package br.com.vinimanara.jogodaveia.views.game

import br.com.vinimanara.jogodaveia.R
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions
import org.junit.Test

class GameBeginDialogTest {


    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {
        BaristaEditTextInteractions.writeTo(R.id.et_player1, "Vinicius")
        BaristaEditTextInteractions.writeTo(R.id.et_player2, "Jose")
        BaristaDialogInteractions.clickDialogPositiveButton()
        BaristaVisibilityAssertions.assertDisplayed(R.string.game_dialog_same_names)
    }
    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        BaristaEditTextInteractions.writeTo(R.id.et_player1, "")
        BaristaEditTextInteractions.writeTo(R.id.et_player2, "William")
        BaristaDialogInteractions.clickDialogPositiveButton()
        BaristaVisibilityAssertions.assertDisplayed(R.string.game_dialog_empty_name)
    }
    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        BaristaEditTextInteractions.writeTo(R.id.et_player1, "Vini")
        BaristaEditTextInteractions.writeTo(R.id.et_player2, "William")
        BaristaDialogInteractions.clickDialogPositiveButton()
        assertNotExist(R.id.player1Layout)
    }
}