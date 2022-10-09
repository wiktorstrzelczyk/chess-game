package domain.board

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private class RankTest {

    @Test
    fun `can get distance between ranks`() {
        val result = Rank.ONE.distanceFrom(Rank.SEVEN)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `can be created from an integer`() {
        val result = Rank.fromInt(5)

        assertThat(result).isEqualTo(Rank.FIVE)
    }


    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `cannot be created from integers lower than 1`(value: Int) {
        assertThrows(IllegalArgumentException::class.java) {
            Rank.fromInt(value)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [9, 10])
    fun `cannot be created from integers greater than 8`(value: Int) {
        assertThrows(IllegalArgumentException::class.java) {
            Rank.fromInt(value)
        }
    }
}