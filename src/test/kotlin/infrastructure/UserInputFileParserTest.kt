package infrastructure

import assertk.assertThat
import assertk.assertions.isEqualTo
import domain.board.File
import domain.board.Rank
import domain.board.Square
import domain.move.Move
import org.junit.jupiter.api.Test

private class UserInputFileParserTest {

    @Test
    fun `can parse 0's and 1's`() {
        val result = UserInputFileParser().parse(intArrayOf(0, 0, 1, 1))

        assertThat(result).isEqualTo(
            Move(
                from = Square(file = File.A, rank = Rank.EIGHT),
                to = Square(file = File.B, rank = Rank.SEVEN)
            )
        )
    }

    @Test
    fun `can parse 2's and 3's`() {
        val result = UserInputFileParser().parse(intArrayOf(2, 2, 3, 3))

        assertThat(result).isEqualTo(
            Move(
                from = Square(file = File.C, rank = Rank.SIX),
                to = Square(file = File.D, rank = Rank.FIVE)
            )
        )
    }

    @Test
    fun `can parse 4's and 5's`() {
        val result = UserInputFileParser().parse(intArrayOf(4, 4, 5, 5))

        assertThat(result).isEqualTo(
            Move(
                from = Square(file = File.E, rank = Rank.FOUR),
                to = Square(file = File.F, rank = Rank.THREE)
            )
        )
    }

    @Test
    fun `can parse 6's and 7's`() {
        val result = UserInputFileParser().parse(intArrayOf(6, 6, 7, 7))

        assertThat(result).isEqualTo(
            Move(
                from = Square(file = File.G, rank = Rank.TWO),
                to = Square(file = File.H, rank = Rank.ONE)
            )
        )
    }
}