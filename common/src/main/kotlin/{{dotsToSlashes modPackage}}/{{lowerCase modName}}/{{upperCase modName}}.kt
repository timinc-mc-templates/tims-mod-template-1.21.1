package {{modPackage}}.{{lowerCase sideMod}}

import us.timinc.mc.cobblemon.timcore.AbstractConfig
import us.timinc.mc.cobblemon.timcore.AbstractMod

const val MOD_ID: String = "{{snakeCase sideMod}}"

object {{upperCase sideMod}} : AbstractMod<{{upperCase sideMod}}.{{upperCase sideMod}}Config>(MOD_ID, {{upperCase sideMod}}Config::class.java) {

    class {{upperCase sideMod}}Config : AbstractConfig() {
    }

    init {
    }
}