package com.evanandroid.apps.onbidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main__hyuk.*
import kotlinx.android.synthetic.main.custom_view.view.*

class MainActivity_Hyuk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__hyuk)


        val fragmentList = listOf(fragment1(), fragment2())

        val adapter = FragmentAdapter(supportFragmentManager, 1)
        adapter.fragmentList = fragmentList
        viewPager.adapter = adapter //앞에껀 아까 만든 뷰페이져 아이디
        tabLayout.setupWithViewPager(viewPager) //탭레이아웃과 뷰랑도 연결 즉 뷰페이저는 Adapter를 통한 프래그먼트와 이것을통한 탭과 둘다 연동
        //이거 하는순간 내가 첨에 디자인에서 끌어와던 내용 사라진 형시 이제 탭 이미지 만들어 주기
        tabLayout.getTabAt(0)?.setCustomView(createView("공매조회"))
        tabLayout.getTabAt(1)?.setCustomView(createView("지도검색"))
    }

    //여 밑에껀 한개 표본으로 만들어논 뷰를 통체로 탭하나에 넣어주는거
    //내용만 바꿔주고
    fun createView(tabName: String): View {
        val tabView = LayoutInflater.from(this).inflate(R.layout.custom_view, null)
        tabView.text_custom.text = tabName //상황에따라 내용을 바꿔준다는 뜻
        when (tabName) {
            "공매조회" -> {
                tabView.image_custom.setImageResource(R.drawable.gongmae)
            }
            "지도검색" -> {
                tabView.image_custom.setImageResource(R.drawable.map)
            }
            else -> {
                return tabView
            }
        }
        return tabView
    }
}