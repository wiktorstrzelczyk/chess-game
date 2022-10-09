package domain.board

import assertk.assertThat
import assertk.assertions.isEqualTo
import domain.piece.*
import org.junit.jupiter.api.Test

private class BoardFactoryTest {

    @Test
    fun `can create initial board`() {
        val boardFactory = BoardFactory()
        val rawLayout = mutableMapOf(
            Square(Rank.ONE, File.A) to Rook(PieceColor.WHITE),
            Square(Rank.ONE, File.B) to Knight(PieceColor.WHITE),
            Square(Rank.ONE, File.C) to Bishop(PieceColor.WHITE),
            Square(Rank.ONE, File.D) to Queen(PieceColor.WHITE),
            Square(Rank.ONE, File.E) to King(PieceColor.WHITE),
            Square(Rank.ONE, File.F) to Bishop(PieceColor.WHITE),
            Square(Rank.ONE, File.G) to Knight(PieceColor.WHITE),
            Square(Rank.ONE, File.H) to Rook(PieceColor.WHITE),
            Square(Rank.EIGHT, File.A) to Rook(PieceColor.BLACK),
            Square(Rank.EIGHT, File.B) to Knight(PieceColor.BLACK),
            Square(Rank.EIGHT, File.C) to Bishop(PieceColor.BLACK),
            Square(Rank.EIGHT, File.D) to Queen(PieceColor.BLACK),
            Square(Rank.EIGHT, File.E) to King(PieceColor.BLACK),
            Square(Rank.EIGHT, File.F) to Bishop(PieceColor.BLACK),
            Square(Rank.EIGHT, File.G) to Knight(PieceColor.BLACK),
            Square(Rank.EIGHT, File.H) to Rook(PieceColor.BLACK),
            Square(Rank.TWO, File.A) to Pawn(PieceColor.WHITE),
            Square(Rank.TWO, File.B) to Pawn(PieceColor.WHITE),
            Square(Rank.TWO, File.C) to Pawn(PieceColor.WHITE),
            Square(Rank.TWO, File.D) to Pawn(PieceColor.WHITE),
            Square(Rank.TWO, File.E) to Pawn(PieceColor.WHITE),
            Square(Rank.TWO, File.F) to Pawn(PieceColor.WHITE),
            Square(Rank.TWO, File.G) to Pawn(PieceColor.WHITE),
            Square(Rank.TWO, File.H) to Pawn(PieceColor.WHITE),
            Square(Rank.SEVEN, File.A) to Pawn(PieceColor.BLACK),
            Square(Rank.SEVEN, File.B) to Pawn(PieceColor.BLACK),
            Square(Rank.SEVEN, File.C) to Pawn(PieceColor.BLACK),
            Square(Rank.SEVEN, File.D) to Pawn(PieceColor.BLACK),
            Square(Rank.SEVEN, File.E) to Pawn(PieceColor.BLACK),
            Square(Rank.SEVEN, File.F) to Pawn(PieceColor.BLACK),
            Square(Rank.SEVEN, File.G) to Pawn(PieceColor.BLACK),
            Square(Rank.SEVEN, File.H) to Pawn(PieceColor.BLACK),
            Square(Rank.THREE, File.A) to null,
            Square(Rank.THREE, File.B) to null,
            Square(Rank.THREE, File.C) to null,
            Square(Rank.THREE, File.D) to null,
            Square(Rank.THREE, File.E) to null,
            Square(Rank.THREE, File.F) to null,
            Square(Rank.THREE, File.G) to null,
            Square(Rank.THREE, File.H) to null,
            Square(Rank.FOUR, File.A) to null,
            Square(Rank.FOUR, File.B) to null,
            Square(Rank.FOUR, File.C) to null,
            Square(Rank.FOUR, File.D) to null,
            Square(Rank.FOUR, File.E) to null,
            Square(Rank.FOUR, File.F) to null,
            Square(Rank.FOUR, File.G) to null,
            Square(Rank.FOUR, File.H) to null,
            Square(Rank.FIVE, File.A) to null,
            Square(Rank.FIVE, File.B) to null,
            Square(Rank.FIVE, File.C) to null,
            Square(Rank.FIVE, File.D) to null,
            Square(Rank.FIVE, File.E) to null,
            Square(Rank.FIVE, File.F) to null,
            Square(Rank.FIVE, File.G) to null,
            Square(Rank.FIVE, File.H) to null,
            Square(Rank.SIX, File.A) to null,
            Square(Rank.SIX, File.B) to null,
            Square(Rank.SIX, File.C) to null,
            Square(Rank.SIX, File.D) to null,
            Square(Rank.SIX, File.E) to null,
            Square(Rank.SIX, File.F) to null,
            Square(Rank.SIX, File.G) to null,
            Square(Rank.SIX, File.H) to null
        )

        val result = boardFactory.createInitialBoard()

        assertThat(result).isEqualTo(
            Board(
                BoardLayout(
                    rawLayout
                )
            )
        )
    }
}