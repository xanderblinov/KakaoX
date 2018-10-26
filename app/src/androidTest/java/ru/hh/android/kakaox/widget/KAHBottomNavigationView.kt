package ru.hh.android.kakaox.widget

import android.support.test.espresso.DataInteraction
import android.view.View
import com.agoda.kakao.BaseActions
import com.agoda.kakao.KBaseView
import com.agoda.kakao.ViewBuilder
import org.hamcrest.Matcher


/**
 * View with BaseActions and AHBottomNavigationActions
 *
 * @see BaseActions
 * @see AHBottomNavigationActions
 */
class KAHBottomNavigationView : KBaseView<KAHBottomNavigationView>,
    AHBottomNavigationActions,
    AHBottomNavigationAssertions {

    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(parent: Matcher<View>, function: ViewBuilder.() -> Unit) : super(parent, function)
    constructor(parent: DataInteraction, function: ViewBuilder.() -> Unit) : super(parent, function)
}


