package fr.xebia.ldi.xcf.generator.game

/**
  * Created by loicmdivad.
  */
case class Character(name: String, specialty: Combo)


object Character {

  import Move._

  final class Ryu extends Character("Ryu", Combo(101, Lp, Lp, Hp))
  final class Ken extends Character("Ken", Combo(201, Lp, Lp, Hp))
  final class `Chun-Li` extends Character("Chun-Li", Combo(301, Lp, Lp, Hp))


}
