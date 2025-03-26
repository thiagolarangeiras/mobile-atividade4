package com.example.mobile_atividade4_caca_tesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val navCon = rememberNavController()
            NavHost(
                navController = navCon,
                startDestination = "/home"
            ) {
                composable("/home"){
                    TelaHome(
                        "CAÇA AO TESOURO",
                        "Siga as pistas e chegue no significado da vida",
                        { navCon.navigate("/pista1") },
                        "Começar"
                    )
                }

                composable("/pista1"){
                    TelaPista(
                        "PISTA I",
                        "o que é o que é, quanto mais tu bota menos tu tem?",
                        { navCon.navigate("/pista2") },
                        { navCon.popBackStack() },
                    )
                }

                composable("/pista2"){
                    TelaPista(
                        "PISTA II",
                        "o que é o que é, quanto mais tu bota menos tu tem?",
                        { navCon.navigate("/pista3") },
                        { navCon.popBackStack() },
                    )
                }

                composable("/pista3"){
                    TelaPista(
                        "PISTA III",
                        "o que é o que é, quanto mais tu bota menos tu tem?",
                        { navCon.navigate("/tesouro") },
                        { navCon.popBackStack() },
                    )
                }

                composable("/tesouro"){
                    TelaTesouro(
                        "Parabéns! Você encontrou o tesouro!",
                        { navCon.popBackStack("/home", false) },
                    )
                }
            }
        }
    }
}

@Composable
fun TelaHome(
    name: String,
    content: String,
    btFun1: ()-> Unit,
    btText1: String
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Top
    ) {
        Text(name, fontSize = 50.sp)
        Text(content, fontSize = 25.sp)
        Button(
            onClick = btFun1
        ) {
            Text(btText1, fontSize = 50.sp)
        }
    }
}

@Composable
fun TelaPista(name: String, pista: String, btFun1: ()-> Unit, btFun2: ()-> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Top
    ) {
        Text(name, fontSize = 50.sp)
        Text(pista, fontSize = 25.sp)
        Button(
            onClick = btFun1
        ) {
            Text("Próxima pista", fontSize = 50.sp)
        }
        Button(
            onClick = btFun2
        ) {
            Text("Voltar", fontSize = 50.sp)
        }
    }
}

@Composable
fun TelaTesouro(msgFinal: String, btFun: ()-> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Top
    ) {
        Text(msgFinal, fontSize = 50.sp)
        Button(
            onClick = btFun
        ) {
            Text("Voltar", fontSize = 50.sp)
        }
    }
}