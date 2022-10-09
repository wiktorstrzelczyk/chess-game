package domain.board

import domain.piece.Piece

data class BoardLayout(
    private val rawLayout: MutableMap<Square, Piece?>
) {
    fun getSquaresWith(piece: Piece): List<Square> =
        rawLayout.filter { it.value == piece }.map { it.key }

    fun getPieceAt(square: Square): Piece? =
        rawLayout[square]

    fun removePieceAt(square: Square) {
        rawLayout[square] = null
    }

    fun addPieceAt(square: Square, piece: Piece) {
        rawLayout[square] = piece
    }

    fun getSquares(): Set<Square> =
        rawLayout.keys.toSet()
}