package domain.move

interface MoveRepository {
    fun save(move: Move)
    fun getAll(): List<Move>
}