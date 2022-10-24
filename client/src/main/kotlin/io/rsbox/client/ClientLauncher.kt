package io.rsbox.client

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkContrastIJTheme
import org.bouncycastle.crypto.tls.ConnectionEnd.client
import java.applet.Applet
import java.applet.AppletContext
import java.applet.AppletStub
import java.awt.Color
import java.awt.Dimension
import java.awt.GridLayout
import java.net.URL
import javax.swing.ImageIcon
import javax.swing.JDialog
import javax.swing.JFrame

/**
 * Development client launcher.
 * @author Kyle Escobar
 */
/* object ClientLauncher {

    /**
     * === DEVELOPMENT SETTINGS ===
     */
    const val CLIENT_TITLE = "RSBox Dev Client : v209.1"
    const val SERVER_IP = "oldschool1.runescape.com"
    const val DEFAULT_WORLD = "301"
    const val RSA_MODULUS = "a65afc7b11a18da1a1bd0e144ea1883463fa040a57341006cec6556954e275446d8b0a222076a68fb0cb6d1fcaa9e7969affe6d5c42ccdba314e465d6dcf69a2bce2c6c70abc884349a2e31bf334ba712e4f7cda455562a80f3ceb1134e6459974780798ef38221e2fa1b9bd6560e120258f366e732b75bd7a385f07a5f5330d"
    const val CACHE_DIR = "rsbox"

    /**
     * === CLIENT PARAMS ===
     */
    private val params = mapOf(
        "title" to CLIENT_TITLE,
        "codebase" to "http://$SERVER_IP/",
        "cachedir" to CACHE_DIR,
        "storebase" to "0",
        "initial_class" to "client.class",
        "download" to "2232012",
        "window_preferredwidth" to "800",
        "window_preferredheight" to "600",
        "applet_minwidth" to "765",
        "applet_minheight" to "503",
        "applet_maxwidth" to "5760",
        "applet_maxheight" to "2160",
        "1" to "1",
        "2" to "https://payments.jagex.com/",
        "3" to "false",
        "4" to "1", // Client Type (Odd = Desktop, Even = Mobile)
        "5" to "0",
        "6" to "0",
        "7" to "0",
        "8" to "true",
        "9" to "ElZAIrq5NpKN6D3mDdihco3oPeYN2KFy2DCquj7JMmECPmLrDP3Bnw",
        "10" to "5",
        "11" to "https://auth.jagex.com/",
        "12" to DEFAULT_WORLD, // Selected World Number
        "13" to ".runescape.com",
        "14" to "0",
        "15" to "0",
        "16" to "false",
        "17" to "http://${SERVER_IP}/world_list.ws", // World HTTP Server
        "18" to "",
        "19" to "196515767263-1oo20deqm6edn7ujlihl6rpadk9drhva.apps.googleusercontent.com",
        "20" to "https://social.auth.jagex.com/",
        "21" to "0",
        "22" to "1",
        "25" to "209",
        "28" to "https://account.jagex.com/",
    )

    private lateinit var applet: Applet
    private lateinit var frame: JFrame

    private val clientIcon = ClientLauncher::class.java.getResource("/rsbox.png").let { ImageIcon(it).image }

    @JvmStatic
    fun main(args: Array<String>) {
        start()
    }

    private fun start() {
        applet = client()
        applet.background = Color.BLACK
        applet.preferredSize = Dimension(params["applet_minwidth"]!!.toInt(), params["applet_minheight"]!!.toInt())
        applet.size = applet.preferredSize
        applet.layout = null
        applet.setStub(applet.createStub())
        applet.isVisible = true
        applet.init()
        applet.start()

        JFrame.setDefaultLookAndFeelDecorated(true)
        JDialog.setDefaultLookAndFeelDecorated(true)
        FlatGitHubDarkContrastIJTheme.setup()

        frame = JFrame(CLIENT_TITLE)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.iconImage = clientIcon
        frame.layout = GridLayout(1, 0)
        frame.add(applet)
        frame.pack()
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
        frame.minimumSize = Dimension(params["applet_minwidth"]!!.toInt(), params["applet_minheight"]!!.toInt())
        frame.maximumSize = Dimension(params["applet_maxwidth"]!!.toInt(), params["applet_maxheight"]!!.toInt())
    }

    private fun Applet.createStub(): AppletStub = object : AppletStub {
        override fun isActive(): Boolean = true
        override fun getAppletContext(): AppletContext? = null
        override fun getCodeBase(): URL = URL(params["codebase"])
        override fun getDocumentBase(): URL = URL(params["codebase"])
        override fun getParameter(name: String): String? = params[name]
        override fun appletResize(width: Int, height: Int) {
            this@createStub.setSize(width, height)
        }
    }
}*/