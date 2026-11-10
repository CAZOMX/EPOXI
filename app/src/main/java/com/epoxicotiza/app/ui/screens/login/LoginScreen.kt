
package com.epoxicotiza.app.ui.screens.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.epoxicotiza.app.ui.theme.EpoxiCotizaTheme

// PALETA DE COLORES EPOXICOTIZA

private val Navy = Color(0xFF071321)
private val CardDark = Color(0xFF172534)
private val Orange = Color(0xFFFF7417)
private val White = Color(0xFFFFFFFF)
private val Gray = Color(0xFFAAB5C0)
private val Border = Color(0xFF344353)

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onGoogleClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 27.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(35.dp))

            // LOGOTIPO

            EpoxiLogo()

            Spacer(Modifier.height(13.dp))

            Text(
                text = "EpoxiCotiza",
                color = White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(5.dp))

            Text(
                text = "Cotizaciones de\nSuelos Epóxicos",
                color = Gray,
                fontSize = 13.sp,
                lineHeight = 19.sp,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(25.dp))

            // INICIO CON GOOGLE

            Button(
                onClick = onGoogleClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                shape = RoundedCornerShape(9.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Color(0xFF202124)
                ),
                contentPadding = PaddingValues(horizontal = 15.dp)
            ) {

                Text(
                    text = "G",
                    color = Color(0xFF4285F4),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.width(10.dp))

                Text(
                    text = "Sign in with Google",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(20.dp))

            // SEPARADOR

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Border
                )

                Text(
                    text = "   OR   ",
                    color = Gray,
                    fontSize = 11.sp
                )

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Border
                )
            }

            Spacer(Modifier.height(18.dp))

            // CORREO ELECTRÓNICO

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        "Email address",
                        color = Gray,
                        fontSize = 13.sp
                    )
                },
                leadingIcon = {
                    Text("✉", color = Gray)
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                shape = RoundedCornerShape(10.dp),
                colors = loginFieldColors()
            )

            Spacer(Modifier.height(10.dp))

            // CONTRASEÑA

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        "Password",
                        color = Gray,
                        fontSize = 13.sp
                    )
                },
                leadingIcon = {
                    Text("♙", color = Gray)
                },
                trailingIcon = {
                    TextButton(
                        onClick = {
                            showPassword = !showPassword
                        }
                    ) {
                        Text(
                            if (showPassword) "◉" else "◌",
                            color = Gray
                        )
                    }
                },
                singleLine = true,
                visualTransformation = if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                shape = RoundedCornerShape(10.dp),
                colors = loginFieldColors()
            )

            // RECUPERAR CONTRASEÑA

            TextButton(
                onClick = onForgotPasswordClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    "Forgot your password?",
                    color = Gray,
                    fontSize = 11.sp
                )
            }

            Spacer(Modifier.height(5.dp))

            // INICIAR SESIÓN

            Button(
                onClick = {
                    onLoginClick(email.trim(), password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(9.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = White
                )
            ) {
                Text(
                    "Sign In",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(Modifier.height(16.dp))

            // REGISTRO

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Don't have an account? ",
                    color = Gray,
                    fontSize = 11.sp
                )

                TextButton(
                    onClick = onSignUpClick,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        "Sign up",
                        color = Orange,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(20.dp))
        }
    }
}

// LOGOTIPO

@Composable
private fun EpoxiLogo() {

    Canvas(
        modifier = Modifier.size(58.dp)
    ) {

        val stroke = 7.dp.toPx()

        drawLine(
            color = Orange,
            start = Offset(size.width * .25f, size.height * .35f),
            end = Offset(size.width * .48f, size.height * .12f),
            strokeWidth = stroke,
            cap = StrokeCap.Round
        )

        drawLine(
            color = Orange,
            start = Offset(size.width * .18f, size.height * .65f),
            end = Offset(size.width * .78f, size.height * .05f),
            strokeWidth = stroke,
            cap = StrokeCap.Round
        )

        drawLine(
            color = Orange,
            start = Offset(size.width * .48f, size.height * .85f),
            end = Offset(size.width * .82f, size.height * .51f),
            strokeWidth = stroke,
            cap = StrokeCap.Round
        )
    }
}

// ESTILO DE CAMPOS

@Composable
private fun loginFieldColors() =
    OutlinedTextFieldDefaults.colors(
        focusedTextColor = White,
        unfocusedTextColor = White,
        focusedContainerColor = CardDark,
        unfocusedContainerColor = CardDark,
        focusedBorderColor = Orange,
        unfocusedBorderColor = Border,
        cursorColor = Orange
    )

// PREVISUALIZACIÓN

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "EpoxiCotiza - Login"
)
@Composable
private fun LoginScreenPreview() {
    EpoxiCotizaTheme {
        LoginScreen()
    }
}
