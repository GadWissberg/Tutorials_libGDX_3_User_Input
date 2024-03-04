package com.gadwissberg.example

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

class LibktxHelloWorld : ApplicationAdapter(), InputProcessor {


    private var batch: SpriteBatch? = null
    private var image: Texture? = null
    private val position: Vector2 = Vector2(140f, 210f)
    private val velocity: Vector2 = Vector2(1F, 0F)
    private val destination: Vector2 = Vector2()

    override fun create() {
        batch = SpriteBatch()
        image = Texture("smiley.png")
        Gdx.input.inputProcessor = this
    }

    override fun render() {
        position.add(velocity)


        velocity.set(destination).sub(position).nor()


        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        batch!!.begin()
        batch!!.draw(image, position.x, position.y)
        batch!!.end()
    }

    override fun dispose() {
        batch!!.dispose()
        image!!.dispose()
    }

    override fun keyDown(keycode: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        destination.set(screenX.toFloat(), Gdx.graphics.height - screenY.toFloat())

        velocity.set(destination).sub(position).nor()// Moved from render()

        return true
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        velocity.setZero()
        return true
    }

    override fun touchCancelled(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return false
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        return false
    }
}
