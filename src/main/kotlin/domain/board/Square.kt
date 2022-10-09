package domain.board

import kotlin.math.abs
import kotlin.math.max

data class Square(
    val rank: Rank,
    val file: File
) {
    fun isAdjacentTo(other: Square): Boolean {
        val rankDistance = rank.distanceFrom(other.rank)
        val fileDistance = file.distanceFrom(other.file)
        return when {
            rankDistance == 0 && fileDistance == 0 -> false
            (rankDistance == 0 || rankDistance == 1) && (fileDistance == 0 || fileDistance == 1) -> true
            else -> false
        }
    }

    fun isDiagonalTo(other: Square): Boolean =
        (this != other) &&
        abs(rank.numericalValue - other.rank.numericalValue) == abs(file.numericalValue - other.file.numericalValue)

    fun minimalDistanceTo(other: Square): Int {
        val rankDistance = rank.distanceFrom(other.rank)
        val fileDistance = file.distanceFrom(other.file)
        return when (this.isDiagonalTo(other)) {
            true -> max(fileDistance, rankDistance)
            else -> rankDistance + fileDistance
        }
    }

    fun isInTheSameFileAs(other: Square): Boolean =
        file == other.file

    fun isInTheSameRankAs(other: Square): Boolean =
        rank == other.rank

    fun isIn(rank: Rank): Boolean =
        this.rank == rank

    fun isIn(file: File): Boolean =
        this.file == file
}