import com.whitehatgaming.UserInputFile
import domain.board.BoardFactory
import domain.Game
import infrastructure.*

fun main() {
    val userInput = UserInputFile("src/main/resources/checkmate.txt")
    val game = Game(
        moveProvider = MovesFromFileProvider(userInputFile = userInput, inputParser = UserInputFileParser()),
        moveRepository = InMemoryMoveRepository(),
        boardDisplayer = ConsoleBoardDisplayer(converter = SimpleBoardToStringConverter()),
        board = BoardFactory().createInitialBoard()
    )
    game.start()
}