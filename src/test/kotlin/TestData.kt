import domain.Player
import domain.board.*
import domain.move.Move
import domain.piece.*
import domain.piece.PieceColor.BLACK
import domain.piece.PieceColor.WHITE

object TestData {
    val PLAYER_WHITE = Player(WHITE)
    val PLAYER_BLACK = Player(PieceColor.BLACK)
    val ANY_SQUARE = Square(rank = Rank.ONE, file = File.A)
    val ANY_PIECE = Pawn(WHITE)
    val ANY_BISHOP = Bishop(WHITE)
    val ANY_KING = King(WHITE)
    val ANY_KNIGHT = Knight(WHITE)
    val ANY_QUEEN = Queen(WHITE)
    val ANY_ROOK = Rook(WHITE)
    val ANY_PAWN = Pawn(WHITE)
    val WHITE_PAWN = Pawn(WHITE)
    val BLACK_PAWN = Pawn(PieceColor.BLACK)
    val B2_SQUARE = Square(rank = Rank.TWO, file = File.B)
    val B4_SQUARE = Square(rank = Rank.FOUR, file = File.B)
    val B3_SQUARE = Square(rank = Rank.THREE, file = File.B)
    val H5_SQUARE = Square(rank = Rank.FIVE, file = File.H)
    val C3_SQUARE = Square(rank = Rank.THREE, file = File.C)
    val C2_SQUARE = Square(rank = Rank.TWO, file = File.C)
    val D2_SQUARE = Square(rank = Rank.TWO, file = File.D)
    val D4_SQUARE = Square(rank = Rank.FOUR, file = File.D)
    val A1_SQUARE = Square(rank = Rank.ONE, file = File.A)
    val A2_SQUARE = Square(rank = Rank.TWO, file = File.A)
    val A3_SQUARE = Square(rank = Rank.THREE, file = File.A)
    val F2_SQUARE = Square(rank = Rank.TWO, file = File.F)
    val F3_SQUARE = Square(rank = Rank.THREE, file = File.F)
    val SAMPLE_TWO_SQUARES_DIAGONALLY_MOVE = Move(
        from = Square(rank = Rank.ONE, file = File.C),
        to = Square(rank = Rank.THREE, file = File.C)
    )
    val SAMPLE_MOVE_TO_THE_SAME_SQUARE = Move(
        from = Square(rank = Rank.TWO, file = File.D),
        to = Square(rank = Rank.TWO, file = File.D)
    )
    val SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE = Move(
        from = Square(rank = Rank.THREE, file = File.D),
        to = Square(rank = Rank.FOUR, file = File.D)
    )
    val SAMPLE_ONE_SQUARE_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE = Move(
        from = Square(rank = Rank.THREE, file = File.D),
        to = Square(rank = Rank.TWO, file = File.D)
    )
    val SAMPLE_WHITE_PAWN_TWO_SQUARES_FIRST_MOVE = Move(
        from = Square(rank = Rank.TWO, file = File.D),
        to = Square(rank = Rank.FOUR, file = File.D)
    )
    val SAMPLE_BLACK_PAWN_TWO_SQUARES_FIRST_MOVE = Move(
        from = Square(rank = Rank.SEVEN, file = File.D),
        to = Square(rank = Rank.FIVE, file = File.D)
    )
    val SAMPLE_WHITE_PAWN_ONE_SQUARE_FIRST_MOVE = Move(
        from = Square(rank = Rank.TWO, file = File.D),
        to = Square(rank = Rank.THREE, file = File.D)
    )
    val SAMPLE_BLACK_PAWN_ONE_SQUARE_FIRST_MOVE = Move(
        from = Square(rank = Rank.SEVEN, file = File.D),
        to = Square(rank = Rank.SIX, file = File.D)
    )
    val SAMPLE_TWO_SQUARES_HORIZONTALLY_FOR_WHITE_PLAYER_MOVE = Move(
        from = Square(rank = Rank.FOUR, file = File.D),
        to = Square(rank = Rank.SIX, file = File.D)
    )
    val SAMPLE_TWO_SQUARES_HORIZONTALLY_FOR_BLACK_PLAYER_MOVE = Move(
        from = Square(rank = Rank.FOUR, file = File.D),
        to = Square(rank = Rank.TWO, file = File.D)
    )
    val SAMPLE_UPPER_RIGHT_SQUARE_MOVE = Move(
        from = Square(rank = Rank.FOUR, file = File.D),
        to = Square(rank = Rank.FIVE, file = File.E)
    )
    val SAMPLE_UPPER_LEFT_SQUARE_MOVE = Move(
        from = Square(rank = Rank.FOUR, file = File.D),
        to = Square(rank = Rank.FIVE, file = File.C)
    )
    val SAMPLE_LOWER_RIGHT_SQUARE_MOVE = Move(
        from = Square(rank = Rank.FOUR, file = File.D),
        to = Square(rank = Rank.THREE, file = File.E)
    )
    val SAMPLE_LOWER_LEFT_SQUARE_MOVE = Move(
        from = Square(rank = Rank.FOUR, file = File.D),
        to = Square(rank = Rank.THREE, file = File.C)
    )
    val SAMPLE_TWO_SQUARES_DIAGONALLY_FORWARD_MOVE = Move(
        from = Square(rank = Rank.FOUR, file = File.D),
        to = Square(rank = Rank.SIX, file = File.F)
    )
    val SAMPLE_EIGHT_SQUARES_DIAGONALLY_MOVE = Move(
        from = Square(rank = Rank.ONE, file = File.A),
        to = Square(rank = Rank.EIGHT, file = File.H)
    )
    val SAMPLE_EIGHT_SQUARES_HORIZONTALLY_MOVE = Move(
        from = Square(rank = Rank.ONE, file = File.A),
        to = Square(rank = Rank.ONE, file = File.H)
    )
    val SAMPLE_EIGHT_SQUARES_VERTICALLY_MOVE = Move(
        from = Square(rank = Rank.ONE, file = File.A),
        to = Square(rank = Rank.EIGHT, file = File.A)
    )
    val SAMPLE_WRONG_MOVE_PATTERN_IN_INITIAL_BOARD_FOR_WHITE_PLAYER = Move(
        from = Square(rank = Rank.TWO, file = File.A),
        to = Square(rank = Rank.FIVE, file = File.A)
    )

    fun initialBoard(): Board =
        BoardFactory().createInitialBoard()

    fun blackPlayerInCheckBoard(): Board {
        val board = initialBoard()
        board.getBoardLayout().removePieceAt(Square(rank = Rank.ONE, File.D))
        board.getBoardLayout().addPieceAt(Square(rank = Rank.SEVEN, File.D), Queen(WHITE))
        return board
    }

    fun ownCheckIfWhiteMakesF2F3MoveBoard(): Board {
        val board = initialBoard()
        board.getBoardLayout().removePieceAt(Square(rank = Rank.EIGHT, File.F))
        board.getBoardLayout().addPieceAt(Square(rank = Rank.THREE, File.G), Bishop(BLACK))
        return board
    }
}
