package board


data class Position(var abscissa: Int, var ordinate: Int) : Comparable<Position> {
    constructor(readablePosition : String) : this( ('a'..'h').indexOf(readablePosition[0]), readablePosition[1].toInt())

    override fun toString(): String {
        val abscissa = ('a'..'h').toList()
        return abscissa[this.abscissa - 1] + ordinate.toString()
    }

    fun outOfBounds(): Boolean = abscissa !in 1..8 || ordinate !in 1..8

    private fun relativePosition(abscissa: Int, ordinate: Int ) : Position {
        return Position(this.abscissa + abscissa, this.ordinate + ordinate)
    }
    fun nextPosition(direction: Vector) : Position{
        return relativePosition(direction.abscissa, direction.ordinate)
    }

    override fun compareTo(other: Position): Int {
        return (abscissa + ordinate * 10) - (other.abscissa + other.ordinate * 10)
    }
    operator fun plus(direction: Vector): Position = Position( abscissa + direction.abscissa, ordinate + direction.ordinate)
    operator fun plus(move: Move): Position = this + move.direction

}


