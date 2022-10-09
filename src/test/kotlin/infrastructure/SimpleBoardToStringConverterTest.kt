package infrastructure

import TestData.PLAYER_BLACK
import TestData.PLAYER_WHITE
import TestData.blackPlayerInCheckBoard
import TestData.initialBoard
import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

private class SimpleBoardToStringConverterTest {

    @Test
    fun `initial board is presented correctly`() {
        val result = SimpleBoardToStringConverter().convert(initialBoard(), PLAYER_WHITE)

        assertThat(result).isEqualTo(
            """
                r n b q k b n r
                p p p p p p p p
                . . . . . . . .
                . . . . . . . .
                . . . . . . . .
                . . . . . . . .
                P P P P P P P P
                R N B Q K B N R
            """.trimIndent()
        )
    }

    @Test
    fun `should contain information about being in check when player is in check`() {
        val result = SimpleBoardToStringConverter().convert(blackPlayerInCheckBoard(), PLAYER_BLACK)

        assertThat(result).contains("in check")
    }
}