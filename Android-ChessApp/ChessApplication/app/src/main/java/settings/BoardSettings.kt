package settings

import android.content.Context
import android.content.SharedPreferences

// initialize SharedPreferences in your Application class or Activity
lateinit var boardSettings: SharedPreferences

fun initializeBoardSettings(context: Context) {
    boardSettings = context.getSharedPreferences("board_settings", Context.MODE_PRIVATE)
}
