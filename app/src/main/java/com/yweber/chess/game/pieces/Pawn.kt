package pieces

import board.Move
import board.Position
import board.MoveType
import board.Vector
import board.Color

class Pawn(initialPosition: Position, color: Color)
    : Piece("Pawn", initialPosition, color,
    mutableListOf<Move>(
        Move(Vector(0,color.way * 2, 1), MoveType.MOVE_ONLY ),
        Move(Vector(0, color.way * 1, 1), MoveType.MOVE_ONLY ),
        Move(Vector(-1,color.way * 1,1), MoveType.CAPTURE_ONLY),
        Move(Vector(1,color.way * 1,1), MoveType.CAPTURE_ONLY))
)
{
    override fun toString(): String = "$color $name in $currentPosition"

    override fun moveTo(position: Position){
        super.moveTo(position)
        if (count == 1)
            possibleMoves.removeAt(0)
    }

}