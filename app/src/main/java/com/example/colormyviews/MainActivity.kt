package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()

    }

    private fun makeColored(view: View)
    {
        when (view.id)
        {
            R.id.box_one_text -> view.setBackgroundColor(randomColor())
            R.id.box_two_text -> view.setBackgroundColor(randomColor())
            R.id.box_three_text -> view.setBackgroundColor(randomColor())
            R.id.box_four_text -> view.setBackgroundColor(randomColor())
            R.id.box_five_text -> view.setBackgroundColor(randomColor())

            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(randomColor())
        }

    }

    private fun setListener()
    {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        val clickableView: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, rootConstraintLayout, redButton, greenButton, yellowButton)

        for(item in clickableView)
        {
            item.setOnClickListener{makeColored(it)}
        }

    }

    private fun randomColor(): Int {
        val randomInt = (1..6).random()
        val randomColor = return when (randomInt) {
            1 -> (Color.BLACK)
            2 -> (Color.GRAY)
            3 -> (Color.BLUE)
            4 -> (Color.MAGENTA)
            5 -> (Color.CYAN)
            6 -> (Color.RED)
            else -> (Color.WHITE)
        }
    }
}
