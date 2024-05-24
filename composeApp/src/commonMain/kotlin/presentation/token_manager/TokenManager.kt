package presentation.token_manager

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class TokenManager {

    val state: MutableState<TokenState> = mutableStateOf(TokenState())
}