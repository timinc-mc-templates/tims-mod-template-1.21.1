plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
    id("com.gradleup.shadow") version("9.2.2")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    enableTransitiveAccessWideners.set(true)
    silentMojangMappingsLicense()

    mixin {
        defaultRefmapName.set("mixins.${project.name}.refmap.json")
    }
}
val shadowCommon = configurations.create("shadowCommon")

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraftVersion")}")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:${property("fabricLoaderVersion")}")

    modRuntimeOnly("net.fabricmc.fabric-api:fabric-api:${property("fabricApiVersion")}")
    modImplementation(fabricApi.module("fabric-command-api-v2", property("fabricApiVersion").toString()))

    modImplementation("net.fabricmc:fabric-language-kotlin:${property("fabricKotlin")}")

    implementation(project(":common", configuration = "namedElements"))
    "developmentFabric"(project(":common", configuration = "namedElements"))
    shadowCommon(project(":common", configuration = "transformProductionFabric"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:${property("junitVersion")}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${property("junitVersion")}")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand(project.properties)
    }

}

tasks {

    jar {
        archiveBaseName.set("${rootProject.property("archivesBaseName")}-${project.name}")
        archiveClassifier.set("dev-slim")
    }

    shadowJar {
        archiveClassifier.set("dev-shadow")
        archiveBaseName.set("${rootProject.property("archivesBaseName")}-${project.name}")
        configurations = listOf(shadowCommon)
    }

    remapJar {
        dependsOn(shadowJar)
        inputFile.set(shadowJar.flatMap { it.archiveFile })
        archiveBaseName.set("${rootProject.property("archivesBaseName")}-${project.name}")
        archiveVersion.set("${rootProject.version}")
    }
}