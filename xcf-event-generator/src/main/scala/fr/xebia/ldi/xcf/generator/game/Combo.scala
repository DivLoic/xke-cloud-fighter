package fr.xebia.ldi.xcf.generator.game

/**
  * Created by loicmdivad.
  */
class Combo(id: Int, moves: Seq[Move]) {

}

object Combo {

  def apply(id: Int, moves: Move*) = new Combo(id, moves)
}
