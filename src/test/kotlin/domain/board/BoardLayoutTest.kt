package domain.board

import TestData.ANY_PIECE
import TestData.ANY_SQUARE
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test

private class BoardLayoutTest {

    @Test
    fun `can get the piece at a square`() {
        val result = boardLayoutWithPiece().getPieceAt(SQUARE)

        assertThat(result).isEqualTo(PIECE)
    }

    @Test
    fun `can remove the piece from a square`() {
        val boardLayout = boardLayoutWithPiece()

        boardLayout.removePieceAt(SQUARE)

        assertThat(boardLayout.getPieceAt(SQUARE)).isNull()
    }

    @Test
    fun `can add a piece at a square`() {
        val boardLayout = boardLayoutWithoutPiece()

        boardLayout.addPieceAt(SQUARE, PIECE)

        assertThat(boardLayout.getPieceAt(SQUARE)).isEqualTo(PIECE)
    }

    @Test
    fun `can get the squares with a piece`() {
        val result = boardLayoutWithPiece().getSquaresWith(PIECE)

        assertThat(result).isEqualTo(listOf(SQUARE))
    }

    @Test
    fun `can get squares`() {
        val result = boardLayoutWithOneSquare().getSquares()

        assertThat(result).isEqualTo(setOf(SQUARE))
    }

    private fun boardLayoutWithPiece(): BoardLayout =
        BoardLayout(mutableMapOf(ANY_SQUARE to ANY_PIECE))

    private fun boardLayoutWithoutPiece(): BoardLayout =
        BoardLayout(mutableMapOf(ANY_SQUARE to null))

    private fun boardLayoutWithOneSquare(): BoardLayout =
        BoardLayout(mutableMapOf(ANY_SQUARE to null))

    companion object {
        val PIECE = ANY_PIECE
        val SQUARE = ANY_SQUARE
    }
}