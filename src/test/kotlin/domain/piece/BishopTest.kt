package domain.piece

import DiagonalMovesSource
import HorizontalMovesSource
import TestData.ANY_BISHOP
import TestData.SAMPLE_MOVE_TO_THE_SAME_SQUARE
import TestData.SAMPLE_TWO_SQUARES_DIAGONALLY_MOVE
import VerticalMovesSource
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import domain.move.Move
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

private class BishopTest {

    @ParameterizedTest
    @DiagonalMovesSource
    fun `can move diagonally`(move: Move) {
        val result = ANY_BISHOP.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @VerticalMovesSource
    fun `cannot move vertically`(move: Move) {
        val result = ANY_BISHOP.canMake(move)

        assertThat(result).isFalse()
    }

    @ParameterizedTest
    @HorizontalMovesSource
    fun `cannot move horizontally`(move: Move) {
        val result = ANY_BISHOP.canMake(move)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot move more than 1 square`() {
        val result = ANY_BISHOP.canMake(SAMPLE_TWO_SQUARES_DIAGONALLY_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot move to the same square`() {
        val result = ANY_BISHOP.canMake(SAMPLE_MOVE_TO_THE_SAME_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot jump over other pieces`() {
        val result = ANY_BISHOP.canJumpOverPieces()

        assertThat(result).isFalse()
    }
}