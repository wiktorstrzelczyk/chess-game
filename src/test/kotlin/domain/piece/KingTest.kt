package domain.piece

import DiagonalMovesSource
import HorizontalMovesSource
import TestData.ANY_KING
import TestData.SAMPLE_MOVE_TO_THE_SAME_SQUARE
import TestData.SAMPLE_TWO_SQUARES_DIAGONALLY_MOVE
import VerticalMovesSource
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import domain.move.Move
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

private class KingTest {

    @ParameterizedTest
    @VerticalMovesSource
    fun `can move vertically`(move: Move) {
        val result = ANY_KING.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @HorizontalMovesSource
    fun `can move horizontally`(move: Move) {
        val result = ANY_KING.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @DiagonalMovesSource
    fun `can move diagonally`(move: Move) {
        val result = ANY_KING.canMake(move)

        assertThat(result).isTrue()
    }

    @Test
    fun `cannot move more than 1 square`() {
        val result = ANY_KING.canMake(SAMPLE_TWO_SQUARES_DIAGONALLY_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot move to the same square`() {
        val result = ANY_KING.canMake(SAMPLE_MOVE_TO_THE_SAME_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot jump over other pieces`() {
        val result = ANY_KING.canJumpOverPieces()

        assertThat(result).isFalse()
    }
}