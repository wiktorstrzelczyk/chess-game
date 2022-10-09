package infrastructure

import domain.move.Move
import domain.move.MoveRepository
import java.util.*

class InMemoryMoveRepository: MoveRepository {

    private val moves = Collections.synchronizedList(mutableListOf<Move>())

    override fun save(move: Move) {
        moves.add(move)
    }

    override fun getAll() =
        moves.toList()
}