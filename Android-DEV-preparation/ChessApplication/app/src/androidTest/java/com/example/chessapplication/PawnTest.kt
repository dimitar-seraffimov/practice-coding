package com.example.chessapplication

import androidx.compose.ui.unit.IntOffset
import board.BoardXCoordinates
import board.BoardYCoordinates
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue

import org.junit.Test

import pieces.Pawn
import pieces.Piece


/**
 * 1. if is first move be can have 2 movements forward
 * 2. if is not first move be can have 1 movement forward
 * 3. We can capture enemies in diagonal forward
 */
class PawnTest {

    private val demoWhitePiece: Piece =
        Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = BoardXCoordinates.first(),
                y = BoardYCoordinates.first(),
            )
        )

    private val demoBlackPiece: Piece =
        Pawn(
            color = Piece.Color.Black,
            position = IntOffset(
                x = BoardXCoordinates.first(),
                y = BoardYCoordinates.first(),
            )
        )

    // Forward moves

    @Test
    fun testFirstMoveForward() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 2
            )
        )

        val moves = pawn.getAvailableMoves(listOf(pawn))

        assertTrue(moves.isNotEmpty())
        assertEquals(
            IntOffset(
                x = 'A'.code,
                y = 3,
            ),
            moves.first()
        )
    }

    @Test
    fun testSecondMoveForwardTrue() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 2
            )
        )

        val moves = pawn.getAvailableMoves(listOf(pawn))

        assertEquals(2, moves.size)
        assertTrue(
            IntOffset(
                x = 'A'.code,
                y = 3,
            ) in moves
        )
        assertTrue(
            IntOffset(
                x = 'A'.code,
                y = 4,
            ) in moves
        )
    }

    @Test
    fun testSecondMoveForwardFalse() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 3
            )
        )

        val moves = pawn.getAvailableMoves(listOf(pawn))

        assertEquals(1, moves.size)
        assertEquals(
            IntOffset(
                x = 'A'.code,
                y = 4,
            ),
            moves.first()
        )
    }

    // Diagonal moves
    @Test
    fun testCaptureEnemy() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 3
            )
        )
        demoBlackPiece.position =
            IntOffset(
                x = 'B'.code,
                y = 4
            )

        val pieces = listOf(
            pawn,
            demoBlackPiece
        )

        val moves = pawn.getAvailableMoves(pieces)
        println("Calculated moves: $moves")
        assertTrue(
            moves.contains(demoBlackPiece.position)
        )
    }

    @Test
    fun testBlockedForwardMove() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 3 // Pawn at A3
            )
        )
        val demoBlackPiece = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 4 // Blocking piece at A4
            )
        )

        val pieces = listOf(pawn, demoBlackPiece)
        val moves = pawn.getAvailableMoves(pieces)

        assertTrue(
            moves.isEmpty()
        )
    }

    @Test
    fun testDiagonalCapture() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'C'.code,
                y = 3 // Pawn at C3
            )
        )
        val enemyPiece = Pawn(
            color = Piece.Color.Black,
            position = IntOffset(
                x = 'D'.code,
                y = 4 // Enemy piece at D4
            )
        )

        val pieces = listOf(pawn, enemyPiece)
        val moves = pawn.getAvailableMoves(pieces)

        assertTrue(
            moves.contains(enemyPiece.position)
        )
    }

    @Test
    fun testNoCaptureAllyDiagonally() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'C'.code,
                y = 3 // Pawn at C3
            )
        )
        val allyPiece = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'D'.code,
                y = 4 // Ally piece at D4
            )
        )

        val pieces = listOf(pawn, allyPiece)
        val moves = pawn.getAvailableMoves(pieces)

        assertTrue(
            !moves.contains(allyPiece.position)
        )
    }

    @Test
    fun testEdgeOfBoard() {
        val pawn = Pawn(
            color = Piece.Color.White,
            position = IntOffset(
                x = 'A'.code,
                y = 3 // Pawn at A3 (left edge of board)
            )
        )

        val enemyPiece = Pawn(
            color = Piece.Color.Black,
            position = IntOffset(
                x = 'B'.code,
                y = 4 // Enemy piece at B4
            )
        )

        val pieces = listOf(pawn, enemyPiece)

        val moves = pawn.getAvailableMoves(pieces)

        assertTrue(
            moves.contains(IntOffset('B'.code, 4))
        )
        assertTrue(
            !moves.contains(IntOffset('Z'.code, 4)) // Invalid position
        )
    }


}