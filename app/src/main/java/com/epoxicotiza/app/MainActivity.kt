
package com.epoxicotiza.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.epoxicotiza.app.ui.screens.login.LoginScreen
import com.epoxicotiza.app.ui.theme.EpoxiCotizaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            EpoxiCotizaTheme {
                LoginScreen(
                    onLoginClick = { email, password ->
                        // Próximamente: validar credenciales
                    },
                    onGoogleClick = {
                        // Próximamente: Firebase Google Auth
                    },
                    onSignUpClick = {
                        // Próximamente: abrir registro
                    },
                    onForgotPasswordClick = {
                        // Próximamente: recuperar contraseña
                    }
                )
            }
        }
    }
}
