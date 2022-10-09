package domain.move

import TestData.B2_SQUARE
import TestData.B3_SQUARE
import TestData.B4_SQUARE
import TestData.C2_SQUARE
import TestData.C3_SQUARE
import TestData.D2_SQUARE
import TestData.D4_SQUARE
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

private class MotionPathTest {

    @Test
    fun `can be created for vertical move`() {
        val result = MotionPath.from(Move(B2_SQUARE, B4_SQUARE))

        assertThat(result).isEqualTo(MotionPath(listOf(B3_SQUARE, B4_SQUARE)))
    }

    @Test
    fun `can be created for horizontal move`() {
        val result = MotionPath.from(Move(B2_SQUARE, D2_SQUARE))

        assertThat(result).isEqualTo(MotionPath(listOf(C2_SQUARE, D2_SQUARE)))
    }

    @Test
    fun `can be created for diagonal move`() {
        val result = MotionPath.from(Move(B2_SQUARE, D4_SQUARE))

        assertThat(result).isEqualTo(MotionPath(listOf(C3_SQUARE, D4_SQUARE)))
    }
}