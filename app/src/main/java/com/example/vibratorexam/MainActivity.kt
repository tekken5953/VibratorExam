package com.example.vibratorexam

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn)
        val layout: ConstraintLayout = findViewById(R.id.layout_main)

        btn.setOnClickListener {
            vibrateArray()
            Snackbar.make(this, layout, "완료 메시지",Snackbar.LENGTH_SHORT).show()
        }
    }

    // 진동을 설정한 배열의 수와 길이만큼 울림
    private fun vibrateArray() {
        CoroutineScope(Dispatchers.Default).launch {

            MakeVibrator().run {
                init(this@MainActivity)

                longArrayOf(100, 100, 100).forEach {
                    make(it)
                    delay(100)
                }
            }
        }
    }

    // 진동을 한번 울림
    private fun vibrateSingle() {
        MakeVibrator().run {
            init(this@MainActivity)
            make(200)
        }
    }
}