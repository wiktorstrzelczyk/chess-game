package domain.board

import common.Either
import domain.*
import domain.move.MotionPath
import domain.move.Move
import domain.piece.King
import domain.piece.Piece

data class Board(
    private val layout: BoardLayout
) {
    fun applyMove(move: Move, player: Player): Either<MoveCannotBeApplied, Unit> {
        val pieceAtSourceSquare = layout.getPieceAt(move.from)
        val pieceAtDestinationSquare = layout.getPieceAt(move.to)
        if (pieceAtSourceSquare == null) {
            return Either.Left(MissingPieceAtSourceSquare)
        }
        if (pieceAtSourceSquare.color.isDifferentThan(player.piecesColor)) {
            return Either.Left(NoPlayersPiece)
        }
        if (pieceAtDestinationSquare != null && pieceAtSourceSquare.color.isSameAs(pieceAtDestinationSquare.color)) {
            return Either.Left(OwnPieceCapture)
        }
        if (!pieceAtSourceSquare.canMake(move) && !pieceAtSourceSquare.canCaptureByMaking(move)) {
            return Either.Left(WrongMovePattern)
        }
        if (MotionPath.from(move).containsPiecesExcludingDestination() && !pieceAtSourceSquare.canJumpOverPieces()) {
            return Either.Left(PiecesAtTheMovingPath)
        }
        mapMoveOnBoardLayout(move, pieceAtSourceSquare)
        if (player.isInCheck()) {
            revertMove(move, pieceAtSourceSquare, pieceAtSourceSquare)
            return Either.Left(InCheckAfterMove)
        }
        return Either.Right(Unit)
    }

    fun getBoardLayout() =
        layout

    fun isPlayerInCheck(player: Player): Boolean =
        player.isInCheck()

    private fun mapMoveOnBoardLayout(move: Move, piece: Piece) {
        layout.addPieceAt(move.to, piece)
        layout.removePieceAt(move.from)
    }

    private fun revertMove(move: Move, pieceAtSourceSquare: Piece, pieceAtDestinationSquare: Piece?) {
        layout.addPieceAt(move.from, pieceAtSourceSquare)
        if (pieceAtDestinationSquare != null) {
            layout.addPieceAt(move.to, pieceAtDestinationSquare)
        }
    }

    private fun MotionPath.containsPiecesExcludingDestination(): Boolean =
        squares
            .filter { square -> layout.getPieceAt(square) != null }
            .filter { square -> square != squares.last() }
            .toSet()
            .isNotEmpty()

    private fun Player.isInCheck(): Boolean {
        val kingPosition = layout.getSquaresWith(King(piecesColor)).first()
        return layout.getSquares()
            .filter { square -> layout.getPieceAt(square)?.color == piecesColor.getOpposite() }
            .any { square -> layout.getPieceAt(square)?.canMake(Move(from = square, to = kingPosition)) == true }
    }
}