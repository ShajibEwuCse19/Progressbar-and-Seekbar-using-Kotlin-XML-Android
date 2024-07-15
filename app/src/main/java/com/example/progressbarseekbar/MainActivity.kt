package com.example.progressbarseekbar

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.progressbarseekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val startProgress = findViewById<Button>(R.id.bt_start_progress)
        val stopProgress = findViewById<Button>(R.id.bt_stop_progress)
        val progressCircular = findViewById<ProgressBar>(R.id.progress_circular)

        startProgress.setOnClickListener {
            progressCircular.visibility = View.VISIBLE
        }
        stopProgress.setOnClickListener {
            progressCircular.visibility = View.INVISIBLE
        }*/

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btStartProgress.setOnClickListener {
            binding.progressCircular.visibility = View.VISIBLE
        }

        binding.btStopProgress.setOnClickListener {
            binding.progressCircular.visibility = View.INVISIBLE
        }

        binding.seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            var seekBarValue = 0
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekBarValue = binding.seekBar.progress
                binding.tvSeekBar.text = "Seekbar progress = " + p1.toString()
                //binding.tvSeekBar.text = "Seekbar progress = $seekBarValue"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                seekBarValue = binding.seekBar.progress
                //Toast.makeText(this@MainActivity, "Start = $seekBarValue", Toast.LENGTH_SHORT).show()
                binding.tvSeekBar.text = "Seekbar progress = $seekBarValue"
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                seekBarValue = binding.seekBar.progress
                //Toast.makeText(this@MainActivity, "End = $seekBarValue", Toast.LENGTH_LONG).show()
                binding.tvSeekBar.text = "Seekbar progress = $seekBarValue"
            }

        })

    }
}