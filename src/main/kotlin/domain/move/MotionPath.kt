package domain.move

import domain.board.Square

data class MotionPath(
    val squares: List<Square>
) {
    companion object {
        fun from(move: Move): MotionPath {
            val moveSteps: MutableList<Square> = mutableListOf()
            val iterator = (move.from..move.to).iterator()
            while (iterator.hasNext()) {
                moveSteps.add(iterator.next())
            }
            moveSteps.remove(move.from)
            return MotionPath(moveSteps)
        }
    }
}

