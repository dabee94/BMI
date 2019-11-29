package com.example.bmi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calBtn.setOnClickListener() {
            try {
                val height: Double = heightEdit.text.toString().toDouble()
                val weight: Double = weightEdit.text.toString().toDouble()


                val bmi: Double = weight / Math.pow(height, 2.0)



                if (bmi < 18.5) {
                    avatar.setImageResource(R.drawable.under)
                } else if (bmi <= 24.9) {
                    avatar.setImageResource(R.drawable.normal)
                } else {
                    avatar.setImageResource(R.drawable.over)
                }
                bmiEdit.text = "%.2f".format(bmi)
            } catch (ex: Exception) {
                val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER, 0, 0)

                val v: TextView = toast.view.findViewById<TextView>(android.R.id.message)

                v.setTextColor(Color.RED)

                toast.show()
            }


        }

        resetBtn.setOnClickListener() {

            bmiEdit.text="0"
            avatar.setImageResource(R.drawable.empty)
            heightEdit.setText("")
            weightEdit.setText("")
        }
    }

}
