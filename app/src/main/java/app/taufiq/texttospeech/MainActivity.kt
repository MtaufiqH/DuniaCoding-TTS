package app.taufiq.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar_pitch.progress = 50
        seekBar_speed.progress = 50


        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = textToSpeech.setLanguage(Locale.ENGLISH)


                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    throw IOException("Language not supported")
                } else {
                    button_speak.isEnabled = true
                }

            } else {
                throw IOException("initialization failed")

            }
        }


        button_speak.setOnClickListener {
            speak()
        }

    }

    private fun speak() {
        val text = et_to_speech.text.toString()
        var pitch = seekBar_pitch.progress / 100f
        var speed = seekBar_speed.progress / 100f
        if (pitch < 0.1) {
            pitch = 0.1f
        }

        if (speed < 0.1) {
            speed = 0.1f
        }


        textToSpeech.setPitch(pitch)
        textToSpeech.setSpeechRate(speed)

        @Suppress("DEPRECATION")
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null)
    }


    override fun onDestroy() {
        textToSpeech.stop()
        textToSpeech.shutdown()
        super.onDestroy()
    }
}