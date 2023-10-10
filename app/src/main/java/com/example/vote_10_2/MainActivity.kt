package com.example.vote_10_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "웹툰 선호도 투표"

        var  voteCount = IntArray(9)
        //int[] voteCount = new int[9];
        for(i in 0..8)
            voteCount[i] = 0

        var imgV = arrayOfNulls<ImageView>(9)

        var imgVId = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3,
                            R.id.iv4, R.id.iv5, R.id.iv6,
                            R.id.iv7, R.id.iv8, R.id.iv9)

        var imgName = arrayOf("전지적 독자 시점","멸망 이후의 세계","화산귀환",
                            "내가 키운 S급들","연우의 순정","우리집 고양이 보고 갈래?",
                            "버려진 나의 최애를 위하여","재혼황후","시한부인줄 알았어요!")

        for(i in imgVId.indices){
            imgV[i] = findViewById(imgVId[i])
            imgV[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i]+": "+voteCount[i]+"표",Toast.LENGTH_SHORT).show()
            }
        }
        var btnResult = findViewById<Button>(R.id.btnResult)
        btnResult.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("voteCount",voteCount)
            intent.putExtra("imgName",imgName)
            startActivity(intent)
        }
    }
}