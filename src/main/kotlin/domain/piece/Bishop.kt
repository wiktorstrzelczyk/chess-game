package domain.piece

import domain.move.Move

data class Bishop(override val color: PieceColor) : Piece {

    override fun canMake(move: Move): Boolean =
        move.isValid()

    override fun canCaptureByMaking(move: Move): Boolean =
        move.isValid()

    override fun canJumpOverPieces(): Boolean =
        false

    private fun Move.isValid(): Boolean =
        isDiagonal
}