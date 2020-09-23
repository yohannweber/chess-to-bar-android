package board

data class Move(val direction : Vector, val moveType: MoveType = MoveType.MOVE_N_CAPTURE) {
}

enum class MoveType{
    MOVE_ONLY,
    CAPTURE_ONLY,
    MOVE_N_CAPTURE
}