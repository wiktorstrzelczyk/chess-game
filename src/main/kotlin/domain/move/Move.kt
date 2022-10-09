package domain.move

import domain.board.Square

data class Move(
    val from: Square,
    val to: Square
) {
    val isVertical = from.isInTheSameFileAs(to)
    val isHorizontal = from.isInTheSameRankAs(to)
    val isDiagonal = from.isDiagonalTo(to)
    val length = from.minimalDistanceTo(to)
}