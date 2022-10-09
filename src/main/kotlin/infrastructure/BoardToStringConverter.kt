package infrastructure

import domain.Player
import domain.board.Board
import domain.board.File
import domain.board.Rank
import domain.board.Square
import domain.piece.*

interface BoardToStringConverter {
    fun convert(board: Board, currentPlayer: Player): String
}

class SimpleBoardToStringConverter: BoardToStringConverter {

    override fun convert(board: Board, currentPlayer: Player): String =
        buildString {
            if(board.isPlayerInCheck(currentPlayer)) {
                append(PLAYER_IN_CHECK_MESSAGE)
                appendLine()
            }
            append(board.asString())
        }

    private fun Board.asString(): String =
        buildString {
            getBoardLayout().getSquares().sortedInDisplayOrder().forEach { square ->
                val pieceOnSquare = getBoardLayout().getPieceAt(square)
                append(pieceOnSquare.asString())
                when {
                    square.isIn(File.H) && !square.isIn(Rank.ONE) -> appendLine()
                    !square.isIn(File.H) -> append(SPACE_BETWEEN_PIECES)
                }
            }
        }

    private fun Piece?.asString() = when (this) {
        is Bishop -> if (color == PieceColor.WHITE) "B" else "b"
        is King -> if (color == PieceColor.WHITE) "K" else "k"
        is Knight -> if (color == PieceColor.WHITE) "N" else "n"
        is Pawn -> if (color == PieceColor.WHITE) "P" else "p"
        is Queen -> if (color == PieceColor.WHITE) "Q" else "q"
        is Rook -> if (color == PieceColor.WHITE) "R" else "r"
        else -> NO_PIECE_SIGN
    }

    private fun Set<Square>.sortedInDisplayOrder() =
        this.sortedWith(compareByDescending<Square> { square -> square.rank.numericalValue }
            .thenBy { square -> square.file.numericalValue }
        ).toSet()

    companion object {
        const val NO_PIECE_SIGN = "."
        const val SPACE_BETWEEN_PIECES = " "
        const val PLAYER_IN_CHECK_MESSAGE = "in check"
    }
}
