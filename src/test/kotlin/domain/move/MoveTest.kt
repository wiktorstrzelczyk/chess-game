package domain.move

import TestData.SAMPLE_EIGHT_SQUARES_DIAGONALLY_MOVE
import TestData.SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE
import TestData.SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

private class MoveTest {

    @Test
    fun `recognizes vertical move`() {
        val move = SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE

        assertThat(move.isVertical).isTrue()
        assertThat(move.isHorizontal).isFalse()
        assertThat(move.isDiagonal).isFalse()
    }

    @Test
    fun `recognizes non vertical move`() {
        val result = SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE.isVertical

        assertThat(result).isFalse()
    }

    @Test
    fun `recognizes horizontal move`() {
        val move = SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE

        assertThat(move.isVertical).isFalse()
        assertThat(move.isHorizontal).isTrue()
        assertThat(move.isDiagonal).isFalse()
    }

    @Test
    fun `recognizes not horizontal move`() {
        val result = SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE.isHorizontal

        assertThat(result).isFalse()
    }

    @Test
    fun `recognizes diagonal move`() {
        val move = SAMPLE_EIGHT_SQUARES_DIAGONALLY_MOVE

        assertThat(move.isVertical).isFalse()
        assertThat(move.isHorizontal).isFalse()
        assertThat(move.isDiagonal).isTrue()
    }

    @Test
    fun `recognizes not diagonal move`() {
        val result = SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE.isDiagonal

        assertThat(result).isFalse()
    }

    @Test
    fun `length for diagonal move`() {
        val result = SAMPLE_EIGHT_SQUARES_DIAGONALLY_MOVE.length

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `length for horizontal move`() {
        val result = SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE.length

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `length for vertical move`() {
        val result = SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE.length

        assertThat(result).isEqualTo(7)
    }
}