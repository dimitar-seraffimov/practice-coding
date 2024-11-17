package pieces

import androidx.compose.ui.unit.IntOffset
import com.example.chessapplication.R.drawable.knight_black
import com.example.chessapplication.R.drawable.knight_white
import pieces.dsl.getPieceMoves


class Knight (
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {

    override val type: Char = Type

    override val drawable: Int =
        if (color.isWhite)
            knight_white
        else
            knight_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> =
        getPieceMoves(pieces) {
            getLMoves()
        }

    companion object {
        const val Type = 'N'
    }
}