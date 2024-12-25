package com.example.kotlinintro

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    private var isTimerRunning = false
    private var timeRemaining: Long = 0
    private var tickSound: MediaPlayer? = null
    private var finishSound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisera view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Hantera systemfält och padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialisera ljud
        tickSound = MediaPlayer.create(this, R.raw.tick_tack) // "tick_sound.mp3" i res/raw
        finishSound = MediaPlayer.create(this, R.raw.finish) // "finish_sound.mp3" i res/raw

        // Konfigurera NumberPickers för att välja minuter och sekunder
        binding.apply {
            npMinutes.maxValue = 59
            npMinutes.minValue = 0
            npSeconds.maxValue = 59
            npSeconds.minValue = 0

            // Starta/Pausa knapp
            btnStart.setOnClickListener {
                if (isTimerRunning) {
                    pauseTimer()
                } else {
                    val minutes = npMinutes.value
                    val seconds = npSeconds.value
                    val totalMillis = (minutes * 60 + seconds) * 1000L
                    startTimer(if (timeRemaining == 0L) totalMillis else timeRemaining)
                }
            }

            // Återställ knapp
            btnReset.setOnClickListener {
                resetTimer()
            }
        }
    }

    /**
     * Startar eller fortsätter en nedräkningstimer
     * @param timeMillis Tid kvar att räkna ner
     */
    private fun startTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1000) { // Uppdatera varje sekund
            override fun onTick(timeM: Long) {
                timeRemaining = timeM
                binding.tvTimer.text = formatTime(timeM)

                // Spela "tick-tack"-ljud
                tickSound?.start()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"
                isTimerRunning = false
                timeRemaining = 0
                binding.btnStart.text = "Start"

                // Spela avslutningsljud
                finishSound?.start()
            }
        }.start()

        isTimerRunning = true
        binding.btnStart.text = "Pause"
    }

    /**
     * Pausar den aktuella timern
     */
    private fun pauseTimer() {
        timer?.cancel()
        isTimerRunning = false
        binding.btnStart.text = "Resume"
    }

    /**
     * Återställ timern till startläge
     */
    private fun resetTimer() {
        timer?.cancel()
        timeRemaining = 0
        isTimerRunning = false
        binding.tvTimer.text = "00:00"
        binding.btnStart.text = "Start"
    }

    /**
     * Formatera tiden till MM:SS
     * @param timeMillis Tiden i millisekunder
     * @return Formaterad tid i strängformat
     */
    private fun formatTime(timeMillis: Long): String {
        val seconds = (timeMillis / 1000) % 60
        val minutes = (timeMillis / 1000) / 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onPause() {
        super.onPause()
        timer?.cancel()
        tickSound?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        tickSound?.release()
        finishSound?.release()
    }
}
