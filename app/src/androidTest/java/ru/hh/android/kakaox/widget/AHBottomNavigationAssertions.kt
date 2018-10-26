package ru.hh.android.kakaox.widget

import com.agoda.kakao.BaseAssertions
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation

/**
 * Provides assertions for RatingBar
 */
interface AHBottomNavigationAssertions : BaseAssertions {
    /**
     *  Checks if tab with number is selected
     *
     *  @param index of selected tab as expected
     */
    fun isTabSelected(index: Int) {
        view.check { view, noViewFoundException ->
            if (view is AHBottomNavigation) {
                if (view.currentItem != index) {
                    throw java.lang.AssertionError(
                        "Expected selected item index is $index, but actual is ${view.currentItem}"
                    )
                }
            } else {
                noViewFoundException?.let { throw AssertionError(it) }
            }
        }
    }
}