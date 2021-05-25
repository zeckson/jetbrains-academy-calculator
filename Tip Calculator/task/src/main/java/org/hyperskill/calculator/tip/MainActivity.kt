package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private val editText: EditText
        get() = findViewById(R.id.edit_text)
    private val slider: Slider
        get() = findViewById(R.id.slider)
    private val textView: TextView
        get() = findViewById(R.id.text_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                updateTextView()
            }
        })
        slider.addOnChangeListener { _, _, _ ->
            updateTextView()
        }
    }

    private fun updateTextView() {
        val billValue = editText.text.toString()
        textView.text = if (billValue.isNotEmpty()) {
            val percentage = slider.value
            val value = billValue.toFloat()
            "Tip amount: %.2f".format((value * percentage / 100))
        } else "";
    }
}