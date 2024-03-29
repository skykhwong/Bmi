package com.tom.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_help.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("BMI Help")
                .setMessage("kg/m")
                .setPositiveButton("OK",null)
                .show()
        }
    }

    fun bmi(view: View) {
        val weight = ed_weight.text.toString().toFloat()
        val height = ed_height.text.toString().toFloat()
        val bmi = weight / (height * height)
        Log.d("BMI", bmi.toString())
        /*val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("BMI_EXTRA", bmi)
        startActivity(intent)*/
        Intent(this, ResultActivity::class.java).apply{
            putExtra("BMI_EXTRA", bmi)
            startActivity(this)
        }

        /*Toast.makeText(this,bmi.toString(), Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setMessage(bmi.toString())
            .setPositiveButton("OK", null)
            .setNeutralButton("Cancel", null)
            .show()*/
    }
}