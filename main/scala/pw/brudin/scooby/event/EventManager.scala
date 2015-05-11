package pw.brudin.scooby.event

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent
import net.minecraft.client.entity.{EntityPlayerSP, EntityClientPlayerMP}
import net.minecraftforge.event.entity.living.LivingEvent
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent
import org.lwjgl.input.Keyboard
import pw.brudin.scooby.Scooby
import pw.brudin.scooby.mod.mods.TriggerBot

/**
 * @since 3:52 PM on 3/19/2015
 */
final class EventManager(scooby: Scooby.type) {

  import net.minecraft.client.Minecraft.{getMinecraft => minecraft}

  @SubscribeEvent
  def onEntityUpdate(event: LivingEvent.LivingUpdateEvent): Unit = if(event.entity == minecraft.thePlayer) {
    for (mod <- scooby.modManager.mods if mod.enabled) {
      mod.onLivingUpdate(minecraft, minecraft.thePlayer)
    }
  }

  @SubscribeEvent
  def onKeyPressed(event: InputEvent.KeyInputEvent): Unit = if(Keyboard.getEventKeyState) {
    val keyCode = Keyboard.getEventKey
    for (mod <- scooby.modManager.mods if mod.keyCode == keyCode) {
      mod.setEnabled(!mod.enabled)
    }
    if (keyCode == Keyboard.KEY_RIGHT) TriggerBot.onlyPlayers = !TriggerBot.onlyPlayers
  }
}
