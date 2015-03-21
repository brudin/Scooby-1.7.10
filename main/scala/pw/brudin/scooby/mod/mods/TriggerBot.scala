package pw.brudin.scooby.mod.mods

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.MovingObjectPosition.MovingObjectType
import org.lwjgl.input.Keyboard
import pw.brudin.scooby.mod.Mod

import scala.util.Random

/**
 * @since 2:48 PM on 3/19/2015
 */
final class TriggerBot extends Mod(Keyboard.KEY_R) {

  /* Instance of Random used to get the amount of time to wait between hits */
  private val random  = new Random
  private val timer   = new Timer

  /**
   * Called with the LivingEvent.LivingUpdateEvent event.
   * @param   player	The player, aka you
   * @see     net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent#LivingUpdateEvent
   */
  override def onLivingUpdate(mc: Minecraft, player: EntityClientPlayerMP): Unit = {
    val delay = random.nextFloat / 2
    if (timer.hasReached(delay)) {
      if (mc.objectMouseOver != null) {
        if (mc.objectMouseOver.typeOfHit == MovingObjectType.ENTITY) {
          mc.objectMouseOver.entityHit match {
            case entity: EntityPlayer if mc.objectMouseOver.entityHit.isEntityAlive =>
              attack(entity)
            case _ =>
          }
        }
      }
      timer.reset()
    }
  }


  /**
   * Attacks the specified entity.
   * Copied directly from the clickMouse() method in Minecraft.java.
   * This is literally what happens when you click your mouse in vanilla. Nothing more.
   *
   * @param target	An instance of <code>net.minecraft.entity.player.EntityPlayer</code> to be attacked.
   */
  def attack(target: EntityLivingBase): Unit = if (canAttack(Minecraft.getMinecraft.thePlayer, target)) {
      Minecraft.getMinecraft.thePlayer.swingItem()
      Minecraft.getMinecraft.playerController.attackEntity(Minecraft.getMinecraft.thePlayer, target)
  }

  /**
   * Checks if the <code>player</code> is able to attack the <code>target</code>.
   * I check if the <code>currentScreen</code> is null since some people pointed out that attacking with
   * your inventory open is obvious.
   * <code>player.isUsingItem()</code> is if the player is doing something like eating, pulling back a bow, blocking,
   * etc.
   *
   * @param player	The player that is going to attack the target.
   * @param target	The target entity that the player will attack.
   * @return
   */
  def canAttack(player: EntityClientPlayerMP, target: EntityLivingBase): Boolean = {
    Minecraft.getMinecraft.currentScreen == null && !target.isInvisible && !player.isUsingItem
  }
}

/**
 * Still incredibly new to scala, if I should use something other than an object for this, let me know!
 */
class Timer {

  /* Time when last reset happened */
  private var last = systemTime

  /**
   * Checks if it has been a specified amount of seconds since the last reset.
   * @param seconds   How many seconds since last reset
   * @return          <code>true</code> if it has been x seconds, else <code>false</code>
   */
  def hasReached(seconds: Float): Boolean = timePassed >= (seconds * 1000)

  /**
   * Updates the time since last reset.
   */
  def reset(): Unit = {
    last = systemTime
  }

  /**
   * @return The amount of time since the <code>lastCheck</code>.
   */
  def timePassed: Long = systemTime - last

  /**
   * @return The current system time.
   */
  def systemTime: Long = System.nanoTime / 1E6.toLong

}
