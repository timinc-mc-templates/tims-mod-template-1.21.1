package {{modPackage}}.{{lowerCase modName}}.neoforge

import net.neoforged.fml.common.Mod
import {{modPackage}}.{{lowerCase modName}}.{{upperCase modName}}
import {{modPackage}}.{{lowerCase modName}}.MOD_ID
import us.timinc.mc.cobblemon.timcore.neoforge.AbstractNeoForgeMod

@Mod(MOD_ID)
object {{upperCase modName}}NeoForge : AbstractNeoForgeMod({{upperCase modName}})