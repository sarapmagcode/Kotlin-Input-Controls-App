package juancruz.example.androidapptwo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.RatingBar
import android.view.Menu
import android.view.View
import android.widget.RadioButton
import android.widget.CheckBox
import android.widget.ToggleButton
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var context: Context? = null
    var text: CharSequence? = null
    var duration = 0
    var toast: Toast? = null

    var check_box = ""
    var radio_button = "One"
    var toggle_button = "Off"
    var rating_bar = "0.0"
    var edit_text = ""

    var fruit = false
    var meat = false

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivity.appContext = applicationContext
        context = MainActivity.appContext
        duration = Toast.LENGTH_SHORT

        val btn_text = findViewById<Button>(R.id.btn_text)
        btn_text.setOnClickListener {
            val text = "You Clicked Text Button"
            Toast.makeText(context, text, duration).show()
        }

        val ratingBar = findViewById<RatingBar>(R.id.rbar_star)
        ratingBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                rating_bar = rating.toString()
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    fun doButtonTextImage(v: View?) {
        text = "You Clicked Image Text Button"
        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    fun doImageButton(v: View?) {
        text = "You Clicked Image Button"
        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    fun doCheckBox(v: View) {
        val checked = (v as CheckBox).isChecked
        when (v.getId()) {
            R.id.cbx_fruit -> fruit = checked
            R.id.cbx_meat -> meat = checked
        }
        check_box = if (fruit && meat) {
            "Fruit and Meat"
        } else if (fruit) {
            "Fruit"
        } else if (meat) {
            "Meat"
        } else {
            "No Selection"
        }
    }

    fun doRadioButton(v: View) {
        val checked = (v as RadioButton).isChecked
        when (v.getId()) {
            R.id.rbtn_one -> if (checked) radio_button = "One"
            R.id.rbtn_two -> radio_button = "Two"
            R.id.rbtn_three -> radio_button = "Three"
        }
    }

    fun doToggleButton(v: View) {
        val on = (v as ToggleButton).isChecked
        toggle_button = if (on) {
            "On"
        } else {
            "Off"
        }
    }

    fun doButton(v: View?) {
        val etxt_msg = findViewById<EditText>(R.id.etxt_msg)
        edit_text = etxt_msg.text.toString()
        text = "Check Box: $check_box\n"
        text = "${text.toString()}Radio Button: $radio_button".trimIndent() + "\n"
        text = "${text.toString()}Toggle Button: $toggle_button".trimIndent() + "\n"
        text = "${text.toString()}Rating Bar: $rating_bar".trimIndent() + "\n"
        text = text.toString() + "Edit Text: " + edit_text + edit_text
        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }
}