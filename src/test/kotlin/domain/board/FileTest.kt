package domain.board

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private class FileTest {

    @Test
    fun `can get distance between files`() {
        val result = File.B.distanceFrom(File.E)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `can be created from an integer`() {
        val result = File.fromInt(2)

        assertThat(result).isEqualTo(File.B)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `cannot be created from integers lower than 1`(value: Int) {
        assertThrows(IllegalArgumentException::class.java) {
            File.fromInt(value)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [9, 10])
    fun `cannot be created from integers greater than 8`(value: Int) {
        assertThrows(IllegalArgumentException::class.java) {
            File.fromInt(value)
        }
    }
}