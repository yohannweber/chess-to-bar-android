package pieces

import board.Move
import board.Position
import board.Vector
import board.Color

class Knight(initialPosition: Position, color: Color)
    : Piece("Knight", initialPosition, color,
    mutableListOf<Move>(
        Move(Vector(1,2,1)),
        Move(Vector(2,1,1)),
        Move(Vector(2,-1,1)),
        Move(Vector(1,-2,1)),
        Move(Vector(-1,-2,1)),
        Move(Vector(-2,-1,1)),
        Move(Vector(-2,1,1)),
        Move(Vector(-1,2,1))
    )
) {

}