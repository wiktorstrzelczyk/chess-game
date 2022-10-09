package domain

sealed class MoveCannotBeApplied
object NoPlayersPiece: MoveCannotBeApplied()
object MissingPieceAtSourceSquare: MoveCannotBeApplied()
object OwnPieceCapture: MoveCannotBeApplied()
object PiecesAtTheMovingPath: MoveCannotBeApplied()
object InCheckAfterMove: MoveCannotBeApplied()
object WrongMovePattern: MoveCannotBeApplied()