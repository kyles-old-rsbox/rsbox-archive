package io.rsbox.toolbox.deobfuscator

import org.tinylog.kotlin.Logger
import java.applet.Applet
import java.applet.AppletContext
import java.applet.AppletStub
import java.awt.Color
import java.awt.Dimension
import java.awt.GridLayout
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import javax.swing.JFrame

class TestClient(private val file: File) {

    private val params = hashMapOf<String, String>()

    fun start() {
        Logger.info("Starting test client.")

        /*
         * Parse the Jagex JAV_CONFIG.
         */
        val lines = URL("http://oldschool1.runescape.com/jav_config.ws").readText().split("\n")
        lines.forEach {
            var line = it
            if(line.startsWith("param=")) {
                line = line.substring(6)
            }
            val idx = line.indexOf("=")
            if(idx >= 0) {
                params[line.substring(0, idx)] = line.substring(idx + 1)
            }
        }

        val classloader = URLClassLoader(arrayOf(file.toURI().toURL()))
        val main = params["initial_class"]!!.replace(".class", "")
        val applet = classloader.loadClass(main).newInstance() as Applet

        applet.background = Color.BLACK
        applet.size = Dimension(params["applet_minwidth"]!!.toInt(), params["applet_minheight"]!!.toInt())
        applet.preferredSize = applet.size
        applet.layout = null
        applet.createStub()
        applet.isVisible = true
        applet.init()

        val frame = JFrame("Test Client - ${file.name}")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.layout = GridLayout(1, 0)
        frame.add(applet)
        frame.pack()
        frame.setLocationRelativeTo(null)
        frame.isVisible = true

        Logger.info("Test client is now running.")
    }

    private fun Applet.createStub() {
        val stub = object : AppletStub {
            override fun isActive(): Boolean = true
            override fun getParameter(name: String): String? = params[name]
            override fun getDocumentBase(): URL = URL(params["codebase"]!!)
            override fun getCodeBase(): URL = URL(params["codebase"]!!)
            override fun getAppletContext(): AppletContext? = null
            override fun appletResize(width: Int, height: Int) {
                this@createStub.size = Dimension(width, height)
            }
        }
        this.setStub(stub)
    }
}