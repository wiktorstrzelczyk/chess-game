package domain.piece

import DiagonalMovesSource
import HorizontalMovesSource
import KnightMovesSource
import TestData.ANY_KNIGHT
import TestData.SAMPLE_MOVE_TO_THE_SAME_SQUARE
import VerticalMovesSource
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import domain.move.Move
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

private class KnightTest {

    @ParameterizedTest
    @KnightMovesSource
    fun `can make L-shape moves`(move: Move) {
        val result = ANY_KNIGHT.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @VerticalMovesSource
    fun `cannot move vertically`(move: Move) {
        val result = ANY_KNIGHT.canMake(move)

        assertThat(result).isFalse()
    }

    @ParameterizedTest
    @HorizontalMovesSource
    fun `cannot move horizontally`(move: Move) {
        val result = ANY_KNIGHT.canMake(move)

        assertThat(result).isFalse()
    }

    @ParameterizedTest
    @DiagonalMovesSource
    fun `cannot move diagonally`(move: Move) {
        val result = ANY_KNIGHT.canMake(move)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot move to the same square`() {
        val result = ANY_KNIGHT.canMake(SAMPLE_MOVE_TO_THE_SAME_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `can jump over other pieces`() {
        val result = ANY_KNIGHT.canJumpOverPieces()

        assertThat(result).isTrue()
    }
}