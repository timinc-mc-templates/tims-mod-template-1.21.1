package {{modPackage}}.{{lowerCase modName}}

import us.timinc.mc.cobblemon.timcore.AbstractConfig
import us.timinc.mc.cobblemon.timcore.AbstractMod

const val MOD_ID: String = "{{snakeCase modName}}"

object {{upperCase modName}} : AbstractMod<{{upperCase modName}}.{{upperCase modName}}Config>(MOD_ID, {{upperCase modName}}Config::class.java) {

    class {{upperCase modName}}Config : AbstractConfig() {
    }

    init {
    }
}