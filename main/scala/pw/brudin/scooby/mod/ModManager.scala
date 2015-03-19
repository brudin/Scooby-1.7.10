package pw.brudin.scooby.mod

import pw.brudin.scooby.Scooby
import pw.brudin.scooby.mod.mods.{TriggerBot, Sprint}

import scala.collection.mutable

/**
 * @since 2:42 PM on 3/19/2015
 */
class ModManager(scooby: Scooby.type) {

  val mods = mutable.MutableList[Mod]()

  def load(): Unit = {
    register(new Sprint(scooby))
    register(new TriggerBot(scooby))
  }

  def register(mod: Mod): Unit = mods += mod
}
