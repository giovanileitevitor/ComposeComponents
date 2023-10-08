package br.applabbs.composecomponents.simpleBoxInsTest

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.applabbs.composecomponents.ui.theme.unitTestDemo.SimpleButtonDemo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import br.applabbs.composecomponents.R


@RunWith(AndroidJUnit4::class)
class SimpleButtonInstTest {

    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup(){
        rule.setContent {
            SimpleButtonDemo()
        }
        rule.onNode(hasTestTag("BOXTAG"), useUnmergedTree = true).assertExists()
        rule.onNode(hasTestTag("TEXTTAG"), useUnmergedTree = true).assertExists()
    }

    @Test
    fun TestIfBoxExists(){
        rule.onNode(hasTestTag("BOXTAG"), useUnmergedTree = true)
            .assertExists()
    }

    @Test
    fun TextIfTextonButtonExists(){
        rule.onNode(hasTestTag("TEXTTAG"), useUnmergedTree = true)
            .assertExists()
    }

}