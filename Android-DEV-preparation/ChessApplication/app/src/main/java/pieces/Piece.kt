package pieces

import androidx.compose.ui.unit.IntOffset

interface Piece {

    val color: Color

    enum class Color {
        White,
        Black;

        val isWhite: Boolean
            get() = this == White

        val isBlack: Boolean
            get() = this == Black
    }

    val drawable: Int

    var position: IntOffset

    fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset>

}