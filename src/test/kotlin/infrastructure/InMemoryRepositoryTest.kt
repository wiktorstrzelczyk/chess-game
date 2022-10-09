package infrastructure

import TestData.SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE
import TestData.SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE
import TestData.SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

private class InMemoryRepositoryTest {

    @Test
    fun `can save move`() {
        val repository = InMemoryMoveRepository()

        repository.save(SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE)

        assertThat(repository.getAll()).isEqualTo(listOf(SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE))
    }

    @Test
    fun `can get moves`() {
        val repository = InMemoryMoveRepository()
        repository.save(SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE)
        repository.save(SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE)

        val result = repository.getAll()

        assertThat(result).isEqualTo(
            listOf(
                SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE,
                SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE
            )
        )
    }
}