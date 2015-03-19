package pw.brudin.scooby.mod.mods

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP
import pw.brudin.scooby.Scooby
import pw.brudin.scooby.mod.Mod

/**
 * @since 2:45 PM on 3/19/2015
 */
class Sprint(scooby: Scooby.type) extends Mod(scooby, Minecraft.getMinecraft.gameSettings.keyBindSprint.getKeyCode) {

  /**
   * Called with the LivingEvent.LivingUpdateEvent event.
   * @param   player	The player, aka you
   * @see     net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent#LivingUpdateEvent
   */
  override def onLivingUpdate(mc: Minecraft, player: EntityClientPlayerMP): Unit = {
    player.setSprinting(canSprint(player))
  }

  /**
   * Checks if the player should sprint.  Basic checks so that you won't be sprinting while standing still,
   * sneaking, using items (eating), etc.
   *
   * @param player	The target player for sprint checking.
   * @return			<code>true</code> if the player can sprint, else <code>false</code>.
   */
  def canSprint(player: EntityClientPlayerMP): Boolean = player.moveForward > 0 && !player.isSneaking &&
    !player.isUsingItem && player.getFoodStats().getFoodLevel >  6

}
