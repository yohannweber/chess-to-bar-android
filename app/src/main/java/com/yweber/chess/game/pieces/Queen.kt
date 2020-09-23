package pieces

import board.Move
import board.Position
import board.Vector
import board.Color

class Queen(initialPosition: Position, color: Color)
    : Piece("Queen", initialPosition, color,
    mutableListOf<Move>(
    Move(Vector(1, 0)),
    Move(Vector(0, -1)),
    Move(Vector(-1, 0)),
    Move(Vector(0, 1)),
    Move(Vector(1, 1)),
    Move(Vector(1, -1)),
    Move(Vector(-1, -1)),
    Move(Vector(-1, 1))
)
) {
}