package pw.brudin.scooby.mod

import pw.brudin.scooby.mod.mods.{TriggerBot, Sprint}

/**
 * @since 2:42 PM on 3/19/2015
 */
final class ModManager {
  import scala.collection.mutable.{Set => MutableSet}

  private val modList = MutableSet.empty[Mod]

  def mods: Iterable[Mod] = modList

  def load(): Unit = {
    register(new Sprint)
    register(new TriggerBot)
  }

  def register(mod: Mod): Unit = {
    modList += mod
  }

}
