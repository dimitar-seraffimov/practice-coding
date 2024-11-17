package pieces

import androidx.compose.ui.unit.IntOffset
import com.example.chessapplication.R.drawable.rook_black
import com.example.chessapplication.R.drawable.rook_white
import pieces.dsl.getPieceMoves


class Rook (
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {
    override val drawable: Int =
        if (color.isWhite)
            rook_white
        else
            rook_black

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> =
        getPieceMoves(pieces){
            straightMoves()
        }

}