package pw.brudin.scooby.mod

import pw.brudin.scooby.mod.mods.{TriggerBot, Sprint}

/**
 * @since 2:42 PM on 3/19/2015
 */
final class ModManager {
  import scala.collection.mutable.{List => MutableList}

  private val mods = MutableList.empty[Mod]

  def load(): Unit = {
    register(new Sprint)
    register(new TriggerBot)
  }

  def register(mod: Mod): Unit = {
    mods += mod
  }

}
