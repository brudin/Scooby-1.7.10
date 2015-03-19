package pw.brudin.scooby.event

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent
import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent
import org.lwjgl.input.Keyboard
import pw.brudin.scooby.Scooby

/**
 * @since 3:52 PM on 3/19/2015
 */
class EventManager(scooby: Scooby.type) {

  final val mc = Minecraft.getMinecraft

  @SubscribeEvent
  def onLivingUpdate(event: LivingUpdateEvent): Unit = {
    event.entity match {
      case entity: EntityClientPlayerMP if event.entity == mc.thePlayer =>
        for (mod <- scooby.modManager.mods) {
          if (mod.enabled) {
            mod.onLivingUpdate(Minecraft.getMinecraft, entity)
          }
        }
      case _ =>
    }
  }

  @SubscribeEvent
  def onKeyPress(event: KeyInputEvent): Unit = {
    if (Keyboard.getEventKeyState) {
      for (mod <- scooby.modManager.mods) {
        if (mod.keyCode == Keyboard.getEventKey) {
          mod.setEnabled(!mod.enabled)
        }
      }
    }
  }
}
