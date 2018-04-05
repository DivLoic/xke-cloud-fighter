package fr.xebia.ldi.xcf.generator.game

/**
  * Created by loicmdivad.
  */
object Move {

  type Key = Symbol

  case class Move(key: Key)

  val Lp: Key = 'lp // - Light Punch
  val Mp: Key = 'mp // - Medium Punch
  val Hp: Key = 'hp // - Heavy Punch
  val Lk: Key = 'lk // - Light Kick
  val Mk: Key = 'mk // - Medium Kick
  val Hk: Key = 'hk // - Heavy Kick
  val J: Key = 'j // - Jump

  //val `V-skill` = Mp + Mk
  //val `V-trigger` = Hp + Hk

}
