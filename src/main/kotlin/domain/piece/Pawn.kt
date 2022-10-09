package domain.piece

import domain.board.Rank
import domain.move.Move
import domain.piece.PieceColor.*

data class Pawn(override val color: PieceColor) : Piece {

    override fun canMake(move: Move): Boolean =
        move.isValid()

    override fun canCaptureByMaking(move: Move): Boolean =
        move.isValidCapture()

    override fun canJumpOverPieces(): Boolean =
        false

    private fun Move.isValid(): Boolean =
        when {
            isBackward() -> false
            !isVertical -> false
            isFirst() && (length == 1 || length == 2) -> true
            !isFirst() && length == 1 -> true
            else -> false
        }

    private fun Move.isValidCapture(): Boolean =
        when {
            isBackward() -> false
            !isDiagonal -> false
            length != 1 -> false
            else -> true
        }

    private fun Move.isFirst(): Boolean =
        when {
            color == WHITE && from.rank == WHITE_PAWNS_STARTING_RANK -> true
            color == BLACK && from.rank == BLACK_PAWNS_STARTING_RANK -> true
            else -> false
        }

    private fun Move.isBackward(): Boolean =
        when {
            color == WHITE && from.rank > to.rank -> true
            color == BLACK && from.rank < to.rank -> true
            else -> false
        }

    companion object {
        private val WHITE_PAWNS_STARTING_RANK = Rank.TWO
        private val BLACK_PAWNS_STARTING_RANK = Rank.SEVEN
    }
}
