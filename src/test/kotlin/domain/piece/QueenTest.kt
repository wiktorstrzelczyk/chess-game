package domain.piece

import DiagonalMovesSource
import HorizontalMovesSource
import TestData.ANY_QUEEN
import TestData.SAMPLE_EIGHT_SQUARES_DIAGONALLY_MOVE
import TestData.SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE
import TestData.SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE
import TestData.SAMPLE_MOVE_TO_THE_SAME_SQUARE
import VerticalMovesSource
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import domain.move.Move
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

private class QueenTest {

    @ParameterizedTest
    @VerticalMovesSource
    fun `can move vertically`(move: Move) {
        val result = ANY_QUEEN.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @HorizontalMovesSource
    fun `can move horizontally`(move: Move) {
        val result = ANY_QUEEN.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @DiagonalMovesSource
    fun `can move diagonally`(move: Move) {
        val result = ANY_QUEEN.canMake(move)

        assertThat(result).isTrue()
    }

    @Test
    fun `can move 8 squares horizontally`() {
        val result = ANY_QUEEN.canMake(SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `can move 8 squares vertically`() {
        val result = ANY_QUEEN.canMake(SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `can move 8 squares diagonally`() {
        val result = ANY_QUEEN.canMake(SAMPLE_EIGHT_SQUARES_DIAGONALLY_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `cannot move to the same square`() {
        val result = ANY_QUEEN.canMake(SAMPLE_MOVE_TO_THE_SAME_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot jump over other pieces`() {
        val result = ANY_QUEEN.canJumpOverPieces()

        assertThat(result).isFalse()
    }
}