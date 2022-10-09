package domain

import domain.board.Board
import domain.board.BoardDisplayer
import domain.move.MoveProvider
import domain.move.MoveRepository
import domain.piece.PieceColor

class Game(
    private val moveProvider: MoveProvider,
    private val moveRepository: MoveRepository,
    private val boardDisplayer: BoardDisplayer,
    private val board: Board
) {
    fun start() {
        var player = Player(PieceColor.WHITE)
        boardDisplayer.display(board, player)
        var nextMove = moveProvider.nextMove()
        while (nextMove != null) {
            board.applyMove(nextMove, player)
            moveRepository.save(nextMove)
            player = Player(player.piecesColor.getOpposite())
            boardDisplayer.display(board, player)
            nextMove = moveProvider.nextMove()
        }
    }
}