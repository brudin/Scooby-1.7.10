package pw.brudin.scooby.event

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent
import net.minecraft.client.entity.EntityClientPlayerMP
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent
import org.lwjgl.input.Keyboard

/**
 * @since 3:52 PM on 3/19/2015
 */
final class EventManager {
  import net.minecraft.client.Minecraft.{getMinecraft => minecraft}

  @SubscribeEvent 
  def onLivingUpdate(event: LivingUpdateEvent): Unit = if(event.entity eq minecraft.thePlayer) {
      scooby.modManager.mods.filter(_.enabled).foreach(_.onLivingUpdate(minecraft, entity))
  }

  @SubscribeEvent 
  def onKeyPress(event: KeyInputEvent): Unit = if (Keyboard.getEventKeyState) {
    scooby.modManager.mods.foreach { case(mod) =>
      mod match {
        case Mod(Keyboard.getEventKey) => mod.setEnabled
        case Mod(_) =>
      }
    }
  }

}
