package com.example.diceroller


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRoleDicer.setOnClickListener {

            //TOAST
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            //Roll Angka
            rollDice()

        }
    }

    private fun rollDice() {
        binding.apply {
            val dice = Dice(6)
            val diceRoll1 = dice.roll()
            val diceRoll2 = dice.roll()
            val sumDice = diceRoll1 + diceRoll2
            tvRoleDicer.text = sumDice.toString()

            val drawableResource1 = when (diceRoll1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            val drawableResource2 = when (diceRoll2) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            imgRoleDicer1.setImageResource(drawableResource1)
            imgRoleDicer2.setImageResource(drawableResource2)
        }
    }
}


class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}