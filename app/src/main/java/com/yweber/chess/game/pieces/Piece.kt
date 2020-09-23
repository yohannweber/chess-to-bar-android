package pieces

import board.Move
import board.Position
import board.Color

open abstract class Piece(
    val name: String,
    val initialPosition: Position,
    val color: Color,
    val possibleMoves : MutableList<Move>,
    var count : Int = 0,
) {
    var currentPosition : Position = initialPosition
    override fun toString() : String {
        return when (initialPosition.abscissa){
            in 1..3 ->
                "$color $name Queen"
            in 4..5 ->
                "$color $name"
            in 6..8 ->
                "$color $name King"
            else ->
                ""

        } + " in $currentPosition"
    }

   open fun moveTo(position: Position){
        currentPosition = position
        count += 1
    }
}