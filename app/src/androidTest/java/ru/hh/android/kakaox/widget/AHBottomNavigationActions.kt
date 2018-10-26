package ru.hh.android.kakaox.widget

import android.graphics.Color
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.matcher.ViewMatchers
import android.view.View
import com.agoda.kakao.BaseActions
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation


interface AHBottomNavigationActions : BaseActions {
    /**
     * Select tab for AHBottomNavigation
     *
     * @param number position of tab
     */
    fun selectTab(number: Int) {
        view.perform(object : ViewAction {
            override fun getDescription() = "select tab number : $number"

            override fun getConstraints() = ViewMatchers.isAssignableFrom(AHBottomNavigation::class.java)

            override fun perform(uiController: UiController, view: View) {
                if(view is AHBottomNavigation){
                    view.setCurrentItem(number,true)
                }

            }
        })
    }
}