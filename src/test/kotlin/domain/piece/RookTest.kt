package domain.piece

import DiagonalMovesSource
import HorizontalMovesSource
import TestData.ANY_ROOK
import TestData.SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE
import TestData.SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE
import TestData.SAMPLE_MOVE_TO_THE_SAME_SQUARE
import VerticalMovesSource
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isNotEqualTo
import assertk.assertions.isTrue
import common.Either
import domain.WrongMovePattern
import domain.board.File
import domain.board.Rank
import domain.board.Square
import domain.move.MotionPath
import domain.move.Move
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

private class RookTest {

    @ParameterizedTest
    @VerticalMovesSource
    fun `can move vertically`(move: Move) {
        val result = ANY_ROOK.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @HorizontalMovesSource
    fun `can move horizontally`(move: Move) {
        val result = ANY_ROOK.canMake(move)

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @DiagonalMovesSource
    fun `cannot move diagonally`(move: Move) {
        val result = ANY_ROOK.canMake(move)

        assertThat(result).isFalse()
    }

    @Test
    fun `can move 8 squares horizontally`() {
        val result = ANY_ROOK.canMake(SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `can move 8 squares vertically`() {
        val result = ANY_ROOK.canMake(SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `cannot move to the same square`() {
        val result = ANY_ROOK.canMake(SAMPLE_MOVE_TO_THE_SAME_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot jump over other pieces`() {
        val result = ANY_ROOK.canJumpOverPieces()

        assertThat(result).isFalse()
    }
}