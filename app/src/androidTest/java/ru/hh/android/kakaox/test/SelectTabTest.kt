package ru.hh.android.kakaox.test

import android.content.Intent
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.hh.android.kakaox.MainActivity
import ru.hh.android.kakaox.page.HomeScreen
import java.util.*

@LargeTest
@RunWith(AndroidJUnit4::class)
class SelectTabTest {

    companion object {
        const val DURATION_IN_MS = 3000L
    }

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)


    protected val homeScreen = HomeScreen()


    open fun beforeTestStart() {
        // do nothing by default
    }

    open fun afterTestFinish() {
        // do nothing by default
    }

    @Before
    fun beforeEachTest() {
        activityRule.launchActivity(Intent(Intent.ACTION_MAIN))

        beforeTestStart()
    }

    @After
    fun afterEachTest() {
        afterTestFinish()
    }

    @Test
    fun selectTabsSequentialy() {
        homeScreen {
            openTab(0)
            checkTabSelected(0)
            idle(DURATION_IN_MS)

            openTab(1)
            checkTabSelected(1)
            idle(DURATION_IN_MS)

            openTab(2)
            checkTabSelected(2)
            idle(DURATION_IN_MS)


        }
    }

    @Test
    fun selectTabsSequentialyWithFlakiness() {
        homeScreen {
            openTab(0)
            checkTabSelected(Random().nextInt(1))
            idle(DURATION_IN_MS)


        }
    }

    @Test
    fun selectTabsSequentialyWithFlakiness2() {
        homeScreen {
            openTab(0)
            checkTabSelected(Random().nextInt(2))
            idle(DURATION_IN_MS)


        }
    }

    @Test
    fun selectTabsSequentialyWithFlakiness3() {
        homeScreen {
            openTab(0)
            checkTabSelected(Random().nextInt(3))
            idle(DURATION_IN_MS)


        }
    }

    @Test
    fun selectTabsSequentialyWithFlakiness4() {
        homeScreen {
            openTab(0)
            checkTabSelected(Random().nextInt(4))
            idle(DURATION_IN_MS)


        }
    }


    @Test
    fun selectTabsSequentialyNegative() {
        homeScreen {
            openTab(0)
            checkTabSelected(2)
            idle(DURATION_IN_MS)


        }
    }
}