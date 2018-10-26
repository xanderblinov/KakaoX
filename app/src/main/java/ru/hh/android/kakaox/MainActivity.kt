package ru.hh.android.kakaox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        val items = ArrayList<AHBottomNavigationItem>()
        for (item in 0..4) {
            items.add(AHBottomNavigationItem("Item #$item", R.drawable.ic_android))
        }
        with(fragment_main_bottom_navigation){
            addItems(items)
            accentColor = ContextCompat.getColor(context, R.color.colorAccent)
        }
    }
}
