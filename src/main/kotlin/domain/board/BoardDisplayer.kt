package domain.board

import domain.Player


interface BoardDisplayer {
    fun display(board: Board, currentPlayer: Player)
}