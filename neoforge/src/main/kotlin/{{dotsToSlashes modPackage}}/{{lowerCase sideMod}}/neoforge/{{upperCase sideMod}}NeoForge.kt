package {{modPackage}}.{{lowerCase sideMod}}.neoforge

import net.neoforged.fml.common.Mod
import {{modPackage}}.{{lowerCase sideMod}}.{{upperCase sideMod}}
import {{modPackage}}.{{lowerCase sideMod}}.MOD_ID
import us.timinc.mc.cobblemon.timcore.neoforge.AbstractNeoForgeMod

@Mod(MOD_ID)
object {{upperCase sideMod}}NeoForge : AbstractNeoForgeMod({{upperCase sideMod}})