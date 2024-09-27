package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.diceroller.ui.theme.DiceRollerTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting(diceViewModel: MainViewModel = viewModel()) {

    val diceNumber by diceViewModel.diceNumber.collectAsState()
    val diceImage by diceViewModel.diceImage.collectAsState()
//    var diceNumber by rememberSaveable {
//        mutableStateOf(0)
//    }
//    var diceImage by rememberSaveable {
//        mutableStateOf(R.drawable.empty_dice)
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Hello Player!!", color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = diceImage), contentDescription = "dice")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Dice Number: $diceNumber",
            fontSize = 20.sp,
            color = Color.Black
        )
        Button(onClick = {
            diceViewModel.rollDice()
//            diceNumber = Random.nextInt(6)+1
//            diceImage = when(diceNumber){
//                1 -> R.drawable.dice_1
//                2 -> R.drawable.dice_2
//                3 -> R.drawable.dice_3
//                4 -> R.drawable.dice_4
//                5 -> R.drawable.dice_5
//                else -> R.drawable.dice_6
//            }
        })
        {
            Text(text = "Roll Dice")
        }
    }
}
