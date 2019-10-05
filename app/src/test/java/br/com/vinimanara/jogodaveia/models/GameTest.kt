package br.com.vinimanara.jogodaveia.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Exception

class GameTest{

    @Rule
    var instantTaskRule=InstantTaskExecutorRule()

    private lateinit var  game:Game
    private lateinit var player: Player
    private lateinit var anotherPlayer: Player

    @Before
    @Throws(Exception::class)
    fun setUp(){
    game = Game("Vini","João")
        player= game.player1
        anotherPlayer = game.player2
    }

    @Test
    fun returnTrueIfHasThreeSameDiagonalCellFromLeft(){
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell

        val hasThreeSameDiagonalsCell =  game.hasThreeSameDiagonalCells()
        Assert.assertTrue(hasThreeSameDiagonalsCell)
    }

    @Test
    fun returnTrueIfHasThreeSameDiagonalCellFromRight(){
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell

        val hasThreeSameDiagonalsCell =  game.hasThreeSameDiagonalCells()
        Assert.assertTrue(hasThreeSameDiagonalsCell)
    }


    @Test
    fun `return True If Has Three Same Horizontal Cells At Row 1`(){
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell

        val  hasThreeSameHorizontalCells =  game.hasThreeSameHorizontalCells()
        Assert.assertTrue(hasThreeSameHorizontalCells)
    }
    @Test
    fun `return True If Has Three Same Horizontal Cells At Row 2`(){
        val cell = Cell(player)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell

        val  hasThreeSameHorizontalCells =  game.hasThreeSameHorizontalCells()
        Assert.assertTrue(hasThreeSameHorizontalCells)
    }


    @Test
    fun `return True If Has Three Same Horizontal Cells At Row 3`(){
        val cell = Cell(player)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell

        val  hasThreeSameHorizontalCells =  game.hasThreeSameHorizontalCells()
        Assert.assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `return False If Does Not Have Three Same Diagonals Cells`(){
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = anotherCell

        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        Assert.assertFalse(hasThreeSameDiagonalCells)
    }
    @Test
    fun `end game if has three same horizontal cell`() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell

        val hasGameEnded = game.hasGameEnded()
        Assert.assertTrue(
            hasGameEnded
        )
    }
}