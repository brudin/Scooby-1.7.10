package pw.brudin.scooby.mod

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP

abstract class Mod(val keyCode: Int) {

  var enabled = false

  def setEnabled(enabled: Boolean): Unit = {
    this.enabled = enabled
  }

  /**
   * Called with the LivingEvent.LivingUpdateEvent event.
   * @param   player	The player, aka you
   * @see     net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent#LivingUpdateEvent
   */
  def onLivingUpdate(mc: Minecraft, player: EntityClientPlayerMP): Unit
}