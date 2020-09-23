package board

import pieces.*
import java.lang.IllegalArgumentException

class Board(private var pieces: MutableList<Piece>) {
    val history = mutableListOf<Pair<Position, Position>>()

    init {
        sort()
    }

    override fun toString(): String {
        return if(pieces.count() == 0)
            "Board contains no more piece"
        else{
            var string = "Board contains ${pieces.count()} piece(s): \n"
            for (piece in pieces) {
                string += piece
                string += "\n"
            }
            string
        }
    }

    fun moveTo(piece: Piece, position: Position){
        //require(position in allNextPossiblePositions(piece)){ "Position not possible"}
        val allPossiblePosition = allNextPossiblePositions(piece)
        if (position !in allPossiblePosition) throw  IllegalArgumentException("Position $position is not possible")
        pieces.removeIf { it.currentPosition == position }
        history.add(Pair(piece.currentPosition, position))
        piece.moveTo(position)
        sort()

    }

    private fun sort(){
        pieces.sortBy { it.currentPosition }
    }

    fun thereIsPiece(position : Position) : Boolean = pieces.any{ it.currentPosition == position }
    fun getPiece(position: Position) : Piece? = pieces.find{ it.currentPosition == position }
    fun allCurrentPositions() : List<Position> = pieces.map { it.currentPosition }
    fun allNextPossiblePositions(piece: Piece): List<Position> {
        val positions = mutableListOf<Position>()
        for (possibleMove in piece.possibleMoves) {
            var position = piece.currentPosition + possibleMove
            var length = 0

            position@ while (!position.outOfBounds() && (possibleMove.direction.length == 0 || (possibleMove.direction.length != 0 && length < possibleMove.direction.length))) {
                when( getPiece(position)?.color ?: "" ) {
                    // in this position an opponent piece exists
                    piece.color.opponentColor() ->{
                        if(possibleMove.moveType in listOf<MoveType>( MoveType.CAPTURE_ONLY, MoveType.MOVE_N_CAPTURE))
                            positions.add(position)
                        break@position
                    }

                    // in this position one of our piece exists
                    piece.color -> break@position

                    // no piece in this position
                    else -> {
                        if (possibleMove.moveType in listOf<MoveType>( MoveType.MOVE_ONLY, MoveType.MOVE_N_CAPTURE) ){
                            positions.add(position)
                            position += possibleMove
                        }
                        length += 1

                    }
                }
            }
        }
        // we add specialMoves
        //positions.addAll(specialMoves(piece))
        return positions
    }
    fun getPieces(positions: List<Position>, color: Color) : List<Piece>? = pieces.filter{ it.currentPosition in positions && it.color == color }
    private fun hasPiece(position: Position, color: Color) : Boolean = pieces.any{  it.currentPosition == position && it.color == color }
    fun specialMoves(piece: Piece) : List<Position>?{
        return when(piece){
            is Pawn -> specialMoves(piece)
            is King -> specialMoves(piece)
            else -> null
        }
        //TODO("to be implemented")
        return listOf()
    }

    fun specialMoves(pawn: Pawn) : List<Position>?{
        //TODO("to be implemented")
        return listOf()
    }
    fun specialMoves(king: King) : List<Position>? {
        //TODO("to be implemented")
        return listOf()
    }


    companion object Factory{
        fun setup() : Board{
            val white = Color.WHITE
            val black = Color.BLACK
            var blackPawn = listOf<Piece>()
            var whitePawn = listOf<Piece>()
            for( i in 1..8 ) {
                blackPawn += Pawn(Position(i, 7), black)
                whitePawn += Pawn(Position(i, 2), white)
            }

            return Board( mutableListOf(
                Rook(Position(1,1), white),
                Knight(Position(2,1), white),
                Bishop(Position(3,1), white),
                King(Position(4,1), white),
                Queen(Position(5,1), white),
                Bishop(Position(6,1), white),
                Knight( Position(7,1), white),
                Rook( Position(8,1), white),

                Rook(Position(1,8), black),
                Knight(Position(2,8), black),
                Bishop(Position(3,8), black),
                King(Position(4,8), black),
                Queen(Position(5,8), black),
                Bishop(Position(6,8), black),
                Knight( Position(7,8), black),
                Rook( Position(8,8), black)

            ).apply {
                addAll(blackPawn)
                addAll(whitePawn)
            } )
        }
    }
}

