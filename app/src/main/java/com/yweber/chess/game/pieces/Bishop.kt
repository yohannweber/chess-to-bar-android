package pieces

import board.Move
import board.Position
import board.Vector
import board.Color

class Bishop(initialPosition: Position, color: Color)
    : Piece("Bishop", initialPosition, color,
    mutableListOf<Move>(
        Move(Vector(1, 1)),
        Move(Vector(1, -1)),
        Move(Vector(-1, -1)),
        Move(Vector(-1, 1))
    )
) {

}