package domain.piece

import DiagonalMovesSource
import HorizontalMovesSource
import TestData.ANY_PAWN
import TestData.BLACK_PAWN
import TestData.SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE
import TestData.SAMPLE_BLACK_PAWN_TWO_SQUARES_FIRST_MOVE
import TestData.SAMPLE_LOWER_LEFT_SQUARE_MOVE
import TestData.SAMPLE_LOWER_RIGHT_SQUARE_MOVE
import TestData.SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE
import TestData.SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE
import TestData.SAMPLE_TWO_SQUARES_DIAGONALLY_FORWARD_MOVE
import TestData.SAMPLE_TWO_SQUARES_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE
import TestData.SAMPLE_TWO_SQUARES_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE
import TestData.SAMPLE_UPPER_LEFT_SQUARE_MOVE
import TestData.SAMPLE_UPPER_RIGHT_SQUARE_MOVE
import TestData.SAMPLE_WHITE_PAWN_ONE_SQUARE_FIRST_MOVE
import TestData.SAMPLE_WHITE_PAWN_TWO_SQUARES_FIRST_MOVE
import TestData.WHITE_PAWN
import VerticalMovesSource
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import domain.move.Move
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

private class PawnTest {

    @ParameterizedTest
    @DiagonalMovesSource
    fun `cannot move diagonally`(move: Move) {
        val result = ANY_PAWN.canMake(move)

       assertThat(result).isFalse()
    }

    @ParameterizedTest
    @HorizontalMovesSource
    fun `cannot move horizontally`(move: Move) {
        val result = ANY_PAWN.canMake(move)

        assertThat(result).isFalse()
    }

    @Test
    fun `white pawn cannot move backward`() {
        val result = WHITE_PAWN.canCaptureByMaking(SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `black pawn cannot move backward`() {
        val result = BLACK_PAWN.canCaptureByMaking(SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `white pawn can move one square forward horizontally`() {
        val result = WHITE_PAWN.canMake(SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `black pawn can move one square forward horizontally`() {
        val result = BLACK_PAWN.canMake(SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `white pawn can move two square forward horizontally when it is the first move`() {
        val result = WHITE_PAWN.canMake(SAMPLE_WHITE_PAWN_TWO_SQUARES_FIRST_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `black pawn can move two square forward horizontally when it is the first move`() {
        val result = BLACK_PAWN.canMake(SAMPLE_BLACK_PAWN_TWO_SQUARES_FIRST_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `white pawn can move one square forward horizontally when it is the first move`() {
        val result = WHITE_PAWN.canMake(SAMPLE_WHITE_PAWN_ONE_SQUARE_FIRST_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `black pawn can move one square forward horizontally when it is the first move`() {
        val result = BLACK_PAWN.canMake(SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `white pawn cannot move more that one square when it is not the first move`() {
        val result = WHITE_PAWN.canMake(SAMPLE_TWO_SQUARES_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `black pawn cannot move more that one square when it is not the first move`() {
        val result = BLACK_PAWN.canMake(SAMPLE_TWO_SQUARES_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE)

        assertThat(result).isFalse()
    }

    @ParameterizedTest
    @HorizontalMovesSource
    fun `pawn cannot capture horizontally`(move: Move) {
        val result = ANY_PAWN.canCaptureByMaking(move)

        assertThat(result).isFalse()
    }

    @ParameterizedTest
    @VerticalMovesSource
    fun `pawn cannot capture vertically`(move: Move) {
        val result = ANY_PAWN.canCaptureByMaking(move)

        assertThat(result).isFalse()
    }

    @Test
    fun `white pawn cannot capture backward`() {
        val result = WHITE_PAWN.canCaptureByMaking(SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `white pawn can capture upper right square`() {
        val result = WHITE_PAWN.canCaptureByMaking(SAMPLE_UPPER_RIGHT_SQUARE_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `white pawn can capture upper left square`() {
        val result = WHITE_PAWN.canCaptureByMaking(SAMPLE_UPPER_LEFT_SQUARE_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `black pawn cannot capture backward`() {
        val result = BLACK_PAWN.canCaptureByMaking(SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `black pawn can capture lower right square`() {
        val result = BLACK_PAWN.canCaptureByMaking(SAMPLE_LOWER_RIGHT_SQUARE_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `black pawn can capture lower left square`() {
        val result = BLACK_PAWN.canCaptureByMaking(SAMPLE_LOWER_LEFT_SQUARE_MOVE)

        assertThat(result).isTrue()
    }

    @Test
    fun `cannot capture more than one square away`() {
        val result = WHITE_PAWN.canCaptureByMaking(SAMPLE_TWO_SQUARES_DIAGONALLY_FORWARD_MOVE)

        assertThat(result).isFalse()
    }

    @Test
    fun `cannot jump over other pieces`() {
        val result = ANY_PAWN.canJumpOverPieces()

        assertThat(result).isFalse()
    }
}