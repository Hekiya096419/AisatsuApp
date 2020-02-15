package jp.techacademy.jouchan.wan.aisatsuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.TimePickerDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{view, hour, minute ->
                when{
                    hour in 2..9 && minute in 0..59 -> textview.text = "おはよう"
                    hour in 10..17 && minute in 0..59 -> textview.text = "こんにちは"
                    else -> textview.text = "こんばんは"
                }
            },
            12, 0, true)
        timePickerDialog.show()
    }
}