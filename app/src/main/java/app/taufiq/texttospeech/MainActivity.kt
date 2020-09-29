package app.taufiq.texttospeech

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // TODO 1: declare variable TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 7: Set default value to the seekBars.

        // TODO 2: set InitListener to TextToSpeech initializations.

        // TODO 6: Set listener to the button to start speak function.

    }

    // TODO 3: create function speak() to run TextToSpeech functionality.
    // TODO 4: SetPitch and SetSpeechRate


    override fun onDestroy() {
        // TODO 5: Stop and shutdown TextToSpeech functionality.
        super.onDestroy()
    }
}