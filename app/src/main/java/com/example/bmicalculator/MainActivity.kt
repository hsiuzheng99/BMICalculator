package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){

            val weight:Double = txtWeight.text.toString().toDouble()
            val height:Double = txtHeight.text.toString().toDouble()

            val bmi = CalculateBMI(weight,height)
            val status:String

           /* val drawDrawable = when{
                bmi < 18.5 ->imageView.setImageResource(R.drawable.under)
                bmi in 18.5..24.9 -> imageView.setImageResource(R.drawable.normal)
                bmi >24.9 -> imageView.setImageResource(R.drawable.over)
                else -> R.drawable.empty
            }*/

            if (bmi<18.5)
            {
                status = "Under"
                imageView.setImageResource(R.drawable.under)
            }
            else if(bmi>18.5 && bmi<24.9){
                status = "Normal"
                imageView.setImageResource(R.drawable.normal)
            }
            else {
                status = "Over"
                imageView.setImageResource(R.drawable.over)
            }

            lblShowIBM.text = "IBM : %.2f (%s)".format(bmi,status)
        }

        btnReset.setOnClickListener(){
            imageView.setImageResource(R.drawable.empty)
            //both setText and null also can
            lblBMI.setText("")
            txtHeight.text = null
            txtWeight.text = null

            txtWeight.requestFocus()
        }

    }
    public fun CalculateBMI(weight: Double, height: Double):Double {

        return weight / (height*height)
    }

}


