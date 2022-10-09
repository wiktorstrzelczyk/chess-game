package domain.board

import kotlin.math.abs

enum class File(
    val numericalValue: Int
) {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    fun distanceFrom(file: File) = abs(this.numericalValue - file.numericalValue)

    companion object {
        fun fromInt(value: Int): File {
            require(value >= A.numericalValue && value <= H.numericalValue)
            return File.values().first { it.numericalValue == value }
        }
    }
}