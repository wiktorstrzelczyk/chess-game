package domain.move

import domain.board.File
import domain.board.Rank
import domain.board.Square
import kotlin.math.sign


operator fun Square.rangeTo(other: Square) = SquareProgression(this, other)

class SquareProgression(private val first: Square, private val last: Square): Iterable<Square> {
    override fun iterator(): Iterator<Square> =
        SquareIterator(first = first, last = last)
}

class SquareIterator(private val first: Square, private val last: Square): Iterator<Square> {
    private val rankDirectionSign = (last.rank.numericalValue - first.rank.numericalValue).sign
    private val fileDirectionSign = (last.file.numericalValue - first.file.numericalValue).sign
    private val rankIterator = when (val step = rankDirectionSign) {
        0 -> null
        else -> IntProgression.fromClosedRange(first.rank.numericalValue, last.rank.numericalValue, step).iterator()
    }
    private val fileIterator = when (val step = fileDirectionSign) {
        0 -> null
        else -> IntProgression.fromClosedRange(first.file.numericalValue, last.file.numericalValue, step).iterator()
    }
    private var lastProcessedSquare: Square = first

    override fun hasNext(): Boolean =
        fileIterator?.hasNext() ?: false || rankIterator?.hasNext() ?: false

    override fun next(): Square {
        val nextSquare = when {
            first.isDiagonalTo(last) -> nextDiagonalSquare()
            isHorizontalStepPossible() -> nextHorizontalSquare()
            isVerticalStepPossible() -> nextVerticalSquare()
            else -> throw IllegalStateException("Cannot get next square on the motion path.")
        }
        lastProcessedSquare = nextSquare
        return nextSquare
    }

    private fun nextDiagonalSquare(): Square {
        check(rankIterator != null && fileIterator != null)
        return Square(
            rank = Rank.fromInt(rankIterator.nextInt()),
            file = File.fromInt(fileIterator.nextInt())
        )
    }

    private fun nextHorizontalSquare(): Square {
        check(fileIterator != null)
        return Square(
            rank = lastProcessedSquare.rank,
            file = File.fromInt(fileIterator.nextInt())
        )
    }

    private fun nextVerticalSquare(): Square {
        check(rankIterator != null)
        return Square(
            rank = Rank.fromInt(rankIterator.nextInt()),
            file = lastProcessedSquare.file
        )
    }

    private fun isHorizontalStepPossible(): Boolean =
        fileIterator != null && fileIterator.hasNext()

    private fun isVerticalStepPossible(): Boolean =
        rankIterator != null && rankIterator.hasNext()
}
