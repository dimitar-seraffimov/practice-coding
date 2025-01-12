package board

import android.util.Log
import pieces.Piece

/**
 * A to H
 */
val BoardXCoordinates = List(8) {
    'A'.code + it
}

/**
 * 8 to 1
 */
val BoardYCoordinates = List(8) {
    8 - it
}

const val InitialEncodedPiecesPosition =
    "PW01PB06PW11PB16PW21PB26PW31PB36PW41PB46PW51PB56PW61PB66PW71PB76RW00RW70RB07RB77BW20BW50BB27BB57NW10NW60NB17NB67QW30QB37KW40KB47"


fun decodePieces(
    encodedPieces: String
): List<Piece> {
    val pieces = mutableListOf<Piece>()

    var index = 0
    while (index + Piece.EncodedPieceLength <= encodedPieces.length) {
        try {
            val encodedPiece = encodedPieces.substring(index, index + Piece.EncodedPieceLength)
            pieces.add(Piece.decode(encodedPiece))
        } catch (e: Exception) {
            Log.e("DecodePieces", "Error decoding piece at index $index", e)
        }
        index += Piece.EncodedPieceLength
    }

    return pieces
}