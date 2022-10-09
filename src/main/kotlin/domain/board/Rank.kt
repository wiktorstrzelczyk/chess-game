package domain.board

import kotlin.math.E
import kotlin.math.abs

enum class Rank(
    val numericalValue: Int
) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    fun distanceFrom(rank: Rank) = abs(this.numericalValue - rank.numericalValue)

    companion object {
        fun fromInt(value: Int): Rank {
            require(value >= ONE.numericalValue && value <= EIGHT.numericalValue)
            return Rank.values().first { it.numericalValue == value }
        }
    }
}