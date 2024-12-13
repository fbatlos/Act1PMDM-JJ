package com.example.act1pmdm_jj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.text.isDigitsOnly
import com.dam23_24.composecatalogolayout.screens.Actividad1
import com.dam23_24.composecatalogolayout.screens.Actividad3
import com.dam23_24.composecatalogolayout.screens.Actividad4
import com.dam23_24.composecatalogolayout.screens.Actividad5
import com.example.act1pmdm_jj.ui.theme.Act1PMDMJJTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Act1PMDMJJTheme {
                var myVal by rememberSaveable { mutableStateOf("") }
                Actividad5(
                    value = myVal,
                    onCambio = {
                        val processedText = it
                            .replace(',', '.') // Reemplaza comas por puntos
                            .let { text ->
                                if (text.count { char -> char == '.' } > 1 ||
                                    text.any { char -> !char.isDigit() && char != '.' }) {
                                    myVal
                                } else {
                                    text
                                }
                            }
                        myVal = processedText
                    }
                )
            }
        }
    }
}

