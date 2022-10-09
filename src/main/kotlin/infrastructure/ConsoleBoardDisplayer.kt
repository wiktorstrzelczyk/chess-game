package infrastructure

import domain.Player
import domain.board.Board
import domain.board.BoardDisplayer

class ConsoleBoardDisplayer(private val converter: BoardToStringConverter) : BoardDisplayer {

    override fun display(board: Board, currentPlayer: Player) {
        println()
        println(converter.convert(board, currentPlayer))
    }
}