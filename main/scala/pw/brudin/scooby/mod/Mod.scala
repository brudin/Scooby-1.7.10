package pw.brudin.scooby.mod

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP

/**
 * @since 2:15 PM on 3/19/2015
 */
trait Mod(keyCode: Int) {

  def setEnabled(enabled: Boolean): Unit

  /**
   * Called with the LivingEvent.LivingUpdateEvent event.
   * @param   player	The player, aka you
   * @see     net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent#LivingUpdateEvent
   */
  def onLivingUpdate(mc: Minecraft, player: EntityClientPlayerMP): Unit

}
