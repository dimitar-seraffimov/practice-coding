package pieces

import androidx.compose.ui.unit.IntOffset
import com.example.chessapplication.R.drawable.bishop_black
import com.example.chessapplication.R.drawable.bishop_white
import pieces.dsl.getPieceMoves


class Bishop (
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {

    override val type: Char = Type

    override val drawable: Int =
        if (color.isWhite)
            bishop_white
        else
            bishop_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> =
        getPieceMoves(pieces){
            diagonalMoves()
        }

    companion object {
        const val Type = 'B'
    }

}