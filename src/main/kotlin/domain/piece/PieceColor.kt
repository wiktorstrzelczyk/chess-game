package domain.piece

enum class PieceColor {
    WHITE,
    BLACK;

    fun getOpposite(): PieceColor =
        when (this) {
            WHITE -> BLACK
            BLACK -> WHITE
        }

    fun isDifferentThan(other: PieceColor): Boolean =
        this != other

    fun isSameAs(other: PieceColor): Boolean =
        this == other
}