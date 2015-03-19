package pw.brudin.scooby.mod

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP
import pw.brudin.scooby.Scooby

/**
 * @since 2:15 PM on 3/19/2015
 */
abstract class Mod(val scooby: Scooby.type, val keyCode: Int) {

  var enabled = false

  def setEnabled(enabled: Boolean): Unit = this.enabled = enabled

  /**
   * Called with the LivingEvent.LivingUpdateEvent event.
   * @param   player	The player, aka you
   * @see     net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent#LivingUpdateEvent
   */
  def onLivingUpdate(mc: Minecraft, player: EntityClientPlayerMP)
}
