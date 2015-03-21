package pw.brudin.scooby.mod

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP

/**
 * @since 2:15 PM on 3/19/2015
 */
object Mod {
  def unapply(mod: Mod): Option[Int] = Some(mod.keyCode)
}

trait Mod(private[Mod] val keyKode: Int) {

  def setEnabled(enabled: Boolean): Unit

  /**
   * Called with the LivingEvent.LivingUpdateEvent event.
   * @param   player	The player, aka you
   * @see     net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent#LivingUpdateEvent
   */
  def onLivingUpdate(mc: Minecraft, player: EntityClientPlayerMP): Unit

}
