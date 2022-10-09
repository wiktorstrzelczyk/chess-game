package domain.piece

import domain.move.Move

sealed interface Piece {
    val color: PieceColor

    fun canMake(move: Move): Boolean
    fun canCaptureByMaking(move: Move): Boolean
    fun canJumpOverPieces(): Boolean
}
