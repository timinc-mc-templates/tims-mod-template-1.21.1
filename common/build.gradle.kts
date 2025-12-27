plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
}

architectury {
    common("neoforge", "fabric")
}

loom {
    silentMojangMappingsLicense()
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraftVersion")}")
    mappings(loom.officialMojangMappings())

    annotationProcessor("net.fabricmc:sponge-mixin:0.15.4+mixin.0.8.7")
    compileOnly("net.fabricmc:sponge-mixin:0.15.4+mixin.0.8.7")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${property("junitVersion")}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${property("junitVersion")}")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}