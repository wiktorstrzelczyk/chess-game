package infrastructure

import com.whitehatgaming.UserInputFile
import domain.board.File
import domain.board.Rank
import domain.board.Square
import domain.move.Move
import domain.move.MoveProvider

class MovesFromFileProvider(
    private val userInputFile: UserInputFile,
    private val inputParser: UserInputFileParser
) : MoveProvider {

    override fun nextMove(): Move? {
        val moveFromFile = userInputFile.nextMove()
        return when (moveFromFile == null) {
            true -> return null
            else -> inputParser.parse(moveFromFile)
        }
    }
}

class UserInputFileParser {

    fun parse(move: IntArray): Move =
        Move(
            from = Square(
                file = File.fromInt(move[SOURCE_FILE_POSITION_IN_INPUT] + VALUES_SHIFT_FOR_FILES),
                rank = Rank.fromInt(Rank.values().size - move[SOURCE_RANK_POSITION_IN_INPUT])
            ),
            to = Square(
                file = File.fromInt(move[DESTINATION_FILE_POSITION_IN_INPUT] + VALUES_SHIFT_FOR_FILES),
                rank = Rank.fromInt(Rank.values().size - move[DESTINATION_RANK_POSITION_IN_INPUT])
            )
        )

    companion object {
        const val SOURCE_FILE_POSITION_IN_INPUT = 0
        const val SOURCE_RANK_POSITION_IN_INPUT = 1
        const val DESTINATION_FILE_POSITION_IN_INPUT = 2
        const val DESTINATION_RANK_POSITION_IN_INPUT = 3
        const val VALUES_SHIFT_FOR_FILES = 1
    }
}