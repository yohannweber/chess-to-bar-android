package pieces

import board.Move
import board.Position
import board.Vector
import board.Color

class Rook(initialPosition: Position, color: Color)
    : Piece("Rook", initialPosition, color,
    mutableListOf<Move>(
        Move(Vector(1, 0) ),
        Move(Vector(0, -1)),
        Move(Vector(-1, 0)),
        Move(Vector(0, 1))
    )
) {
}