package domain.move

interface MoveProvider {
    fun nextMove(): Move?
}