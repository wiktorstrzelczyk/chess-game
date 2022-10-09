import domain.board.File
import domain.board.Rank
import domain.board.Square
import domain.move.Move
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.util.stream.Stream

@Target(ElementType.ANNOTATION_TYPE, ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(
    VerticalMovesProvider::class
)
annotation class VerticalMovesSource

private class VerticalMovesProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
        Stream.of(
            Arguments.of(Move(from = Square(rank = Rank.TWO, file = File.B), to = Square(rank = Rank.THREE, file = File.B))),
            Arguments.of(Move(from = Square(rank = Rank.TWO, file = File.B), to = Square(rank = Rank.ONE, file = File.B)))
        )
}
