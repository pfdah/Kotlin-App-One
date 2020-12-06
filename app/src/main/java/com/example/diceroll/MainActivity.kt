package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollDice()
        val rollButton: Button =findViewById(R.id.button)
        rollButton.setOnClickListener {rollDice()}
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage : ImageView = findViewById(R.id.imageView) //Creating an image resource variable
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //select correct image
        diceImage.setImageResource(drawableResource)
        //describe image
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}