package domain.board

import domain.piece.*

class BoardFactory {

    fun createInitialBoard(): Board =
        Board(layout =  createBoardLayout())

    private fun createBoardLayout(): BoardLayout {
        val rawLayout: MutableMap<Square, Piece?> = mutableMapOf()
        val squares = createSquares()
        squares.forEach { square ->
            rawLayout[square] = square.initialPiece()
        }
        return BoardLayout(rawLayout)
    }

    private fun createSquares(): Set<Square> =
        File.values().flatMap { file ->
            Rank.values().map { rank ->
                Square(
                    file = file,
                    rank = rank
                )
            }
        }.toMutableSet()

    private fun Square.initialPiece(): Piece? = when {
        rank == Rank.TWO -> Pawn(color = PieceColor.WHITE)
        rank == Rank.SEVEN -> Pawn(color = PieceColor.BLACK)
        rank == Rank.ONE && (file == File.A || file == File.H) -> Rook(color = PieceColor.WHITE)
        rank == Rank.EIGHT && (file == File.A || file == File.H) -> Rook(color = PieceColor.BLACK)
        rank == Rank.ONE && (file == File.B || file == File.G) -> Knight(color = PieceColor.WHITE)
        rank == Rank.EIGHT && (file == File.B || file == File.G) -> Knight(color = PieceColor.BLACK)
        rank == Rank.ONE && (file == File.C || file == File.F) -> Bishop(color = PieceColor.WHITE)
        rank == Rank.EIGHT && (file == File.C || file == File.F) -> Bishop(color = PieceColor.BLACK)
        rank == Rank.ONE && file == File.D -> Queen(color = PieceColor.WHITE)
        rank == Rank.EIGHT && file == File.D -> Queen(color = PieceColor.BLACK)
        rank == Rank.ONE && file == File.E -> King(color = PieceColor.WHITE)
        rank == Rank.EIGHT && file == File.E -> King(color = PieceColor.BLACK)
        else -> null
    }
}