package domain

import domain.piece.PieceColor

data class Player(
    val piecesColor: PieceColor
) {
    fun getOpposite() =
        Player(piecesColor.getOpposite())
}