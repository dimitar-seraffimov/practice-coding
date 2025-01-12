import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import board.rememberBoard
import ui.game.BoardUi

@Composable
fun App(){
    val board = rememberBoard()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        BoardUi(
            board = board
        )
    }
}