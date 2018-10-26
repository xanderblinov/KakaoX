package ru.hh.android.kakaox.page

import com.agoda.kakao.Screen
import ru.hh.android.kakaox.R
import ru.hh.android.kakaox.widget.KAHBottomNavigationView


class HomeScreen : Screen<HomeScreen>() {
    private val bottomNavigationView = KAHBottomNavigationView {
        withId(R.id.fragment_main_bottom_navigation)
    }

    fun openTab(index : Int) {
        bottomNavigationView.selectTab(index)
    }

    fun checkTabSelected(index : Int){
        bottomNavigationView.isTabSelected(index)
    }

}