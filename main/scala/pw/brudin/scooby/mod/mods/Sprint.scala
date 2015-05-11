package pw.brudin.scooby.mod.mods

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.{EntityPlayerSP, EntityClientPlayerMP}
import pw.brudin.scooby.mod.Mod

/**
 * @since 2:45 PM on 3/19/2015
 */
final class Sprint extends Mod(Minecraft.getMinecraft.gameSettings.keyBindSprint.getKeyCode) {

  /**
   * Called with the LivingEvent.LivingUpdateEvent event.
   * @param   player	The player, aka you
   * @see     net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent#LivingUpdateEvent
   */
  override def onLivingUpdate(mc: Minecraft, player: EntityClientPlayerMP): Unit = {
    player.setSprinting(shouldSprint(player))
  }

  private def shouldSprint(player: EntityPlayerSP): Boolean = {
    player.moveForward > 0 && !player.isSneaking && !player.isUsingItem &&
      player.getFoodStats.getFoodLevel > 6 && !player.isSwingInProgress
  }
}
