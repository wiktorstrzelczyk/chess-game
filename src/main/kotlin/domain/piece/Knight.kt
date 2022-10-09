package domain.piece

import domain.move.Move

data class Knight(override val color: PieceColor) : Piece {

    override fun canMake(move: Move): Boolean =
        move.isValid()

    override fun canCaptureByMaking(move: Move): Boolean =
        move.isValid()

    override fun canJumpOverPieces(): Boolean =
        true

    private fun Move.isValid(): Boolean =
        when {
            length != 3 -> false
            from.rank.distanceFrom(to.rank) == 2 && from.file.distanceFrom(to.file) == 1 -> true
            from.rank.distanceFrom(to.rank) == 1 && from.file.distanceFrom(to.file) == 2 -> true
            else -> false
        }
}