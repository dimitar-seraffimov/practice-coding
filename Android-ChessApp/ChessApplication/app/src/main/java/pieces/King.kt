package pieces

import androidx.compose.ui.unit.IntOffset
import com.example.chessapp.R.drawable.king_black
import com.example.chessapp.R.drawable.king_white
import pieces.dsl.getPieceMoves


class King (
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {

    override val type: Char = Type

    override val drawable: Int =
        if (color.isWhite)
            king_white
        else
            king_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> =
        getPieceMoves(pieces){
            straightMoves(
                maxMovements = 1,
            )
            diagonalMoves(
                maxMovements = 1,
            )
        }

    companion object {
        const val Type = 'K'
    }
}