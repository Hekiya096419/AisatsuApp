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
                    "$hour:$minute" > "1:59" && "$hour:$minute" <= "9:59"
                    -> textview.text = "おはよう"
                    "$hour:$minute" > "17:59" || "$hour:$minute" <= "1:59"
                    -> textview.text = "こんばんは"
                    "$hour:$minute" > "9:59" || "$hour:$minute" <= "17:59"
                    -> textview.text = "こんにちは"}
            },
            12, 0, true)
        timePickerDialog.show()
    }
}
