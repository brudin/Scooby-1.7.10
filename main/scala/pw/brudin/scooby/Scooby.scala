package pw.brudin.scooby

import cpw.mods.fml.common.{FMLCommonHandler, Mod}
import cpw.mods.fml.common.event.FMLInitializationEvent
import net.minecraftforge.common.MinecraftForge
import pw.brudin.scooby.event.EventManager
import pw.brudin.scooby.mod.ModManager

@Mod(modid = Scooby.id, modLanguage = "scala")
object Scooby {

  final val id = "OpenComputers"
  final val modManager = new ModManager(this)
  final val eventManager = new EventManager(this)

  @Mod.EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    FMLCommonHandler.instance().bus().register(eventManager)
    MinecraftForge.EVENT_BUS.register(eventManager)
    modManager.load()
  }
}