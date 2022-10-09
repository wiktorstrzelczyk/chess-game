package domain.piece

import domain.move.Move

data class King(override val color: PieceColor) : Piece {

    override fun canMake(move: Move): Boolean =
        move.isValid()

    override fun canCaptureByMaking(move: Move): Boolean =
        move.isValid()

    override fun canJumpOverPieces(): Boolean =
        false

    private fun Move.isValid(): Boolean =
        from.isAdjacentTo(to)
}