package domain.board

import TestData.A1_SQUARE
import TestData.A2_SQUARE
import TestData.A3_SQUARE
import TestData.C2_SQUARE
import TestData.C3_SQUARE
import TestData.F2_SQUARE
import TestData.F3_SQUARE
import TestData.PLAYER_WHITE
import TestData.SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE
import TestData.SAMPLE_WHITE_PAWN_TWO_SQUARES_FIRST_MOVE
import TestData.SAMPLE_WRONG_MOVE_PATTERN_IN_INITIAL_BOARD_FOR_WHITE_PLAYER
import TestData.initialBoard
import TestData.ownCheckIfWhiteMakesF2F3MoveBoard
import assertk.assertThat
import assertk.assertions.isEqualTo
import common.Either
import domain.*
import domain.move.Move
import org.junit.jupiter.api.Test


private class BoardTest {

    @Test
    fun `cannot move the other player's pieces`() {
        val result = initialBoard().applyMove(SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE, PLAYER_WHITE)

        assertThat(result).isEqualTo(Either.Left(NoPlayersPiece))
    }

    @Test
    fun `cannot move from square when there is no piece on it`() {
        val result = initialBoard().applyMove(Move(C3_SQUARE, C2_SQUARE), PLAYER_WHITE)

        assertThat(result).isEqualTo(Either.Left(MissingPieceAtSourceSquare))
    }

    @Test
    fun `cannot move to squares occupied by own pieces`() {
        val result = initialBoard().applyMove(Move(A1_SQUARE, A2_SQUARE), PLAYER_WHITE)

        assertThat(result).isEqualTo(Either.Left(OwnPieceCapture))
    }

    @Test
    fun `cannot move piece using wrong move pattern`() {
        val result = initialBoard().applyMove(SAMPLE_WRONG_MOVE_PATTERN_IN_INITIAL_BOARD_FOR_WHITE_PLAYER, PLAYER_WHITE)

        assertThat(result).isEqualTo(Either.Left(WrongMovePattern))
    }

    @Test
    fun `cannot move piece which is not able to jump when there are pieces on the way`() {
        val result = initialBoard().applyMove(Move(A1_SQUARE, A3_SQUARE), PLAYER_WHITE)

        assertThat(result).isEqualTo(Either.Left(PiecesAtTheMovingPath))
    }

    @Test
    fun `cannot make move that causes own check`() {
        val board = ownCheckIfWhiteMakesF2F3MoveBoard()
        val result = board.applyMove(Move(F2_SQUARE, F3_SQUARE), PLAYER_WHITE)

        assertThat(result).isEqualTo(Either.Left(InCheckAfterMove))
    }

    @Test
    fun `correct moves don't cause errors`() {
        val result = initialBoard().applyMove(SAMPLE_WHITE_PAWN_TWO_SQUARES_FIRST_MOVE, PLAYER_WHITE)

        assertThat(result).isEqualTo(Either.Right(Unit))
    }
}