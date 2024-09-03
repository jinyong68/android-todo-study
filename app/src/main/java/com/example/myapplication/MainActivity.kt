package com.example.myapplication

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.BlogAdapter.BlogViewHolder


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val blogs = listOf(
        Blog("안녕하지 않습니다.",),
        Blog("안녕하세요 ㅉㅉㅉ",),
        Blog("안녕하세요 올리버쌤입니다!",),
        Blog("안녕하세요 김은찬입니다!",),
        Blog("안녕하세요 김현준입니다!",),
        Blog("내 이름 박진용 17세 ㅋㅋㅋ",),
        Blog("안녕하세용!!!",),
        Blog("아잉",),
        Blog("아 배고프다",),
        Blog("선배님들이 나이를 (이하생략)",),
        Blog("민재 엉만튀 장인 박진용 www",),
        Blog("하다인이 한거임 ㅋ")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeViews()

    }


    private fun initializeViews() {
        binding.blogList.layoutManager = LinearLayoutManager(this)
        binding.blogList.adapter = BlogAdapter(blogs){
            val fragment = WriteFragment()

            supportFragmentManager.beginTransaction().add(binding, fragment).commit()
        }
    }
}
