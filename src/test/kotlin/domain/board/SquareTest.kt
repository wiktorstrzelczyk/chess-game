package domain.board

import TestData.ANY_SQUARE
import TestData.B2_SQUARE
import TestData.B3_SQUARE
import TestData.C3_SQUARE
import TestData.H5_SQUARE
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

private class SquareTest {

    @Test
    fun `should be adjacent to an other if the distance between them is 1`() {
        val result = B2_SQUARE.isAdjacentTo(B3_SQUARE)

        assertThat(result).isTrue()
    }

    @Test
    fun `should not be adjacent to an other if the distance between them is not 1`() {
        val result = B2_SQUARE.isAdjacentTo(H5_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `should not be adjacent to itself`() {
        val result = ANY_SQUARE.isAdjacentTo(ANY_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `should be diagonal when lies on the hypotenuse`() {
        val result = B2_SQUARE.isDiagonalTo(C3_SQUARE)

        assertThat(result).isTrue()
    }

    @Test
    fun `should not be diagonal when not lies on the hypotenuse`() {
        val result = B2_SQUARE.isDiagonalTo(H5_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `should be in the same rank as an other if their ranks are equal`() {
        val result = B3_SQUARE.isInTheSameRankAs(C3_SQUARE)

        assertThat(result).isTrue()
    }

    @Test
    fun `should not be in the same rank as an other if their ranks are not equal`() {
        val result = B2_SQUARE.isInTheSameRankAs(C3_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `should be in the same file as other if their files are equal`() {
        val result = B2_SQUARE.isInTheSameFileAs(B3_SQUARE)

        assertThat(result).isTrue()
    }

    @Test
    fun `should not be in the same file if files are not equal`() {
        val result = B2_SQUARE.isInTheSameFileAs(H5_SQUARE)

        assertThat(result).isFalse()
    }

    @Test
    fun `should be in the given file if the files are equal`() {
        val result = B2_SQUARE.isIn(File.B)

        assertThat(result).isTrue()
    }

    @Test
    fun `should not be in the given file if the files are not equal`() {
        val result = B2_SQUARE.isIn(File.C)

        assertThat(result).isFalse()
    }

    @Test
    fun `should be in the given rank if the ranks are equal`() {
        val result = B2_SQUARE.isIn(Rank.TWO)

        assertThat(result).isTrue()
    }

    @Test
    fun `should not be in the given rank if the ranks are not equal`() {
        val result = B2_SQUARE.isIn(Rank.THREE)

        assertThat(result).isFalse()
    }
}