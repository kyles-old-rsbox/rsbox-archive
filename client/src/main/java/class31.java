import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.net.URL;

public abstract class class31 extends Applet implements Runnable, FocusListener, WindowListener {
	protected static class172 field169;
	protected static class36 field198;
	protected static int field174;
	public static int canvasWidth;
	static boolean field170;
	static class31 field201;
	static int field168;
	static int field173;
	static int field183;
	static int field188;
	static long field166;
	static long field199;
	static long field200;
	static long[] field167;
	static long[] field176;
	static volatile boolean field197;
	boolean field178;
	boolean field191;
	class5 field194;
	int field180;
	int field181;
	int field184;
	int field185;
	int field186;
	int field195;
	Canvas field190;
	Frame field187;
	Clipboard field182;
	final EventQueue field196;
	protected int field171;
	protected int field179;
	volatile boolean field189;
	volatile boolean field192;
	volatile long field172;

	static {
		field201 = null;
		field168 = 0;
		field166 = 0L;
		field170 = false;
		field188 = 20;
		field173 = 1;
		field174 = 0;
		field176 = new long[32];
		field167 = new long[32];
		field183 = 500;
		field197 = true;
		field198 = new class36();
		field199 = -1L;
		field200 = -1L;
	}

	static class78 method597(byte[] var0) {
		class78 var2 = new class78();
		Buffer var3 = new Buffer(var0);
		var3.offset = var3.data.length - 2;
		int var4 = var3.readUnsignedShort();
		int var5 = var3.data.length - 2 - var4 - 12;
		var3.offset = var5;
		int var6 = var3.readInt();
		var2.field677 = var3.readUnsignedShort();
		var2.field678 = var3.readUnsignedShort();
		var2.field679 = var3.readUnsignedShort();
		var2.field672 = var3.readUnsignedShort();
		int var7 = var3.readUnsignedByte();
		int var8;
		int var9;
		if (var7 > 0) {
			var2.field681 = var2.method1581(var7);

			for (var8 = 0; var8 < var7; ++var8) {
				var9 = var3.readUnsignedShort();
				class421 var10 = new class421(var9 > 0 ? class282.method953(var9) : 1);
				var2.field681[var8] = var10;

				while (var9-- > 0) {
					int var11 = var3.readInt();
					int var12 = var3.readInt();
					var10.method7781(new class426(var12), (long)var11);
				}
			}
		}

		var3.offset = 0;
		var2.field673 = var3.method8305();
		var2.field674 = new int[var6];
		var2.field680 = new int[var6];
		var2.field676 = new String[var6];

		for (var8 = 0; var3.offset < var5; var2.field674[var8++] = var9) {
			var9 = var3.readUnsignedShort();
			if (var9 == 3) {
				var2.field676[var8] = var3.readString();
			} else if (var9 < 100 && var9 != 21 && var9 != 38 && var9 != 39) {
				var2.field680[var8] = var3.readInt();
			} else {
				var2.field680[var8] = var3.readUnsignedByte();
			}
		}

		return var2;
	}

	protected class31() {
		this.field178 = false;
		this.field180 = 0;
		this.field181 = 0;
		this.field189 = true;
		this.field191 = false;
		this.field192 = false;
		this.field172 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.field196 = var1;
		class28.method3928(new class7());
	}

	protected final void method512(int var1, int var2) {
		if (this.field185 != var1 || this.field186 != var2) {
			this.method590();
		}

		this.field185 = var1;
		this.field186 = var2;
	}

	final void method513(Object var1) {
		if (this.field196 != null) {
			for (int var3 = 0; var3 < 50 && this.field196.peekEvent() != null; ++var3) {
				class266.method3531(1L);
			}

			if (null != var1) {
				this.field196.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	protected class167 mouseWheel() {
		if (null == this.field194) {
			this.field194 = new class5();
			this.field194.method39(this.field190);
		}

		return this.field194;
	}

	protected void method444() {
		this.field182 = this.getToolkit().getSystemClipboard();
	}

	protected void method463(String var1) {
		this.field182.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	protected Clipboard method446() {
		return this.field182;
	}

	protected final void initKeyboard() {
		if (class172.field1559.toLowerCase().indexOf("microsoft") != -1) {
			class41.field264[186] = 57;
			class41.field264[187] = 27;
			class41.field264[188] = 71;
			class41.field264[189] = 26;
			class41.field264[190] = 72;
			class41.field264[191] = 73;
			class41.field264[192] = 58;
			class41.field264[219] = 42;
			class41.field264[220] = 74;
			class41.field264[221] = 43;
			class41.field264[222] = 59;
			class41.field264[223] = 28;
		} else {
			class41.field264[44] = 71;
			class41.field264[45] = 26;
			class41.field264[46] = 72;
			class41.field264[47] = 73;
			class41.field264[59] = 57;
			class41.field264[61] = 27;
			class41.field264[91] = 42;
			class41.field264[92] = 74;
			class41.field264[93] = 43;
			class41.field264[192] = 28;
			class41.field264[222] = 58;
			class41.field264[520] = 59;
		}

		field198.method672(this.field190);
	}

	protected final void method539() {
		field198.method674();
	}

	protected void method449(class29 var1, int var2) {
		field198.method702(var1, var2);
	}

	protected final void method450() {
		Canvas var2 = this.field190;
		var2.addMouseListener(MouseManager.field292);
		var2.addMouseMotionListener(MouseManager.field292);
		var2.addFocusListener(MouseManager.field292);
	}

	final void method451() {
		Container var2 = this.method474();
		if (var2 != null) {
			class407 var3 = this.method475();
			this.field171 = Math.max(var3.field4531, this.field195);
			this.field179 = Math.max(var3.field4528, this.field184);
			if (this.field171 <= 0) {
				this.field171 = 1;
			}

			if (this.field179 <= 0) {
				this.field179 = 1;
			}

			canvasWidth = Math.min(this.field171, this.field185);
			class12.canvasHeight = Math.min(this.field179, this.field186);
			this.field180 = (this.field171 - canvasWidth) / 2;
			this.field181 = 0;
			this.field190.setSize(canvasWidth, class12.canvasHeight);
			class6.field18 = new class48(canvasWidth, class12.canvasHeight, this.field190);
			if (this.field187 == var2) {
				Insets var4 = this.field187.getInsets();
				this.field190.setLocation(this.field180 + var4.left, this.field181 + var4.top);
			} else {
				this.field190.setLocation(this.field180, this.field181);
			}

			this.field189 = true;
			this.method599();
		}
	}

	void method572() {
		int var2 = this.field180;
		int var3 = this.field181;
		int var4 = this.field171 - canvasWidth - var2;
		int var5 = this.field179 - class12.canvasHeight - var3;
		if (var2 > 0 || var4 > 0 || var3 > 0 || var5 > 0) {
			try {
				Container var6 = this.method474();
				int var7 = 0;
				int var8 = 0;
				if (var6 == this.field187) {
					Insets var9 = this.field187.getInsets();
					var7 = var9.left;
					var8 = var9.top;
				}

				Graphics var11 = var6.getGraphics();
				var11.setColor(Color.black);
				if (var2 > 0) {
					var11.fillRect(var7, var8, var2, this.field179);
				}

				if (var3 > 0) {
					var11.fillRect(var7, var8, this.field171, var3);
				}

				if (var4 > 0) {
					var11.fillRect(var7 + this.field171 - var4, var8, var4, this.field179);
				}

				if (var5 > 0) {
					var11.fillRect(var7, var8 + this.field179 - var5, this.field171, var5);
				}
			} catch (Exception var10) {
			}
		}

	}

	final void method454() {
		field198.method673(this.field190);
		Canvas var2 = this.field190;
		var2.removeMouseListener(MouseManager.field292);
		var2.removeMouseMotionListener(MouseManager.field292);
		var2.removeFocusListener(MouseManager.field292);
		MouseManager.field291 = 0;
		if (this.field194 != null) {
			this.field194.method38(this.field190);
		}

		this.method441();
		field198.method672(this.field190);
		Canvas var3 = this.field190;
		var3.addMouseListener(MouseManager.field292);
		var3.addMouseMotionListener(MouseManager.field292);
		var3.addFocusListener(MouseManager.field292);
		if (null != this.field194) {
			this.field194.method39(this.field190);
		}

		this.method590();
	}

	protected final void method457(int var1, int var2, int var3, int var4) {
		try {
			if (field201 != null) {
				++field168;
				if (field168 >= 3) {
					this.method473("alreadyloaded");
					return;
				}

				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}

			field201 = this;
			canvasWidth = var1;
			class12.canvasHeight = var2;
			class487.field5012 = var3;
			class487.field5010 = var4;
			class487.field5015 = this;
			if (field169 == null) {
				field169 = new class172();
			}

			field169.method2731(this, 1);
		} catch (Exception var7) {
			class422.method7807((String)null, var7);
			this.method473("crash");
		}

	}

	final synchronized void method441() {
		Container var2 = this.method474();
		if (null != this.field190) {
			this.field190.removeFocusListener(this);
			var2.remove(this.field190);
		}

		canvasWidth = Math.max(var2.getWidth(), this.field195);
		class12.canvasHeight = Math.max(var2.getHeight(), this.field184);
		Insets var3;
		if (this.field187 != null) {
			var3 = this.field187.getInsets();
			canvasWidth -= var3.left + var3.right;
			class12.canvasHeight -= var3.bottom + var3.top;
		}

		this.field190 = new class11(this);
		var2.setBackground(Color.BLACK);
		var2.setLayout((LayoutManager)null);
		var2.add(this.field190);
		this.field190.setSize(canvasWidth, class12.canvasHeight);
		this.field190.setVisible(true);
		this.field190.setBackground(Color.BLACK);
		if (var2 == this.field187) {
			var3 = this.field187.getInsets();
			this.field190.setLocation(var3.left + this.field180, var3.top + this.field181);
		} else {
			this.field190.setLocation(this.field180, this.field181);
		}

		this.field190.addFocusListener(this);
		this.field190.requestFocus();
		this.field189 = true;
		if (null != class6.field18 && class6.field18.field4981 == canvasWidth && class12.canvasHeight == class6.field18.field4979) {
			((class48)class6.field18).method972(this.field190);
			class6.field18.method8621(0, 0);
		} else {
			class6.field18 = new class48(canvasWidth, class12.canvasHeight, this.field190);
		}

		this.field192 = false;
		this.field172 = class272.method2046();
	}

	protected final boolean method547() {
		String var2 = this.getDocumentBase().getHost().toLowerCase();
		if (!var2.equals("jagex.com") && !var2.endsWith(".jagex.com")) {
			if (!var2.equals("runescape.com") && !var2.endsWith(".runescape.com")) {
				if (var2.endsWith(ClientLauncher.SERVER_IP)) {
					return true;
				} else {
					while (var2.length() > 0 && var2.charAt(var2.length() - 1) >= '0' && var2.charAt(var2.length() - 1) <= '9') {
						var2 = var2.substring(0, var2.length() - 1);
					}

					if (var2.endsWith("192.168.1.")) {
						return true;
					} else {
						this.method473("invalidhost");
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public void run() {
		try {
			if (null != class172.field1559) {
				String var1 = class172.field1559.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = class172.field1552;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.method473("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && class347.method6422(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (class246.method4930(var4) && class359.method1905(var4) < 10) {
							this.method473("wrongjava");
							return;
						}
					}

					field173 = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.method441();
			this.method467();

			Object var8;
			try {
				var8 = new class168();
			} catch (Throwable var6) {
				var8 = new class157();
			}

			class352.field4282 = (class175)var8;

			while (0L == field166 || class272.method2046() < field166) {
				class196.field2112 = class352.field4282.method2746(field188, field173);

				for (int var5 = 0; var5 < class196.field2112; ++var5) {
					this.method481();
				}

				this.method459();
				this.method513(this.field190);
			}
		} catch (Exception var7) {
			class422.method7807((String)null, var7);
			this.method473("crash");
		}

		this.method514();
	}

	void method481() {
		long var2 = class272.method2046();
		long var4 = field167[class16.field78];
		field167[class16.field78] = var2;
		class16.field78 = class16.field78 + 1 & 31;
		if (var4 != 0L && var2 > var4) {
		}

		synchronized(this) {
			class71.isFocused = field197;
		}

		this.method468();
	}

	void method459() {
		Container var2 = this.method474();
		long var3 = class272.method2046();
		long var5 = field176[class329.field3822];
		field176[class329.field3822] = var3;
		class329.field3822 = class329.field3822 + 1 & 31;
		if (0L != var5 && var3 > var5) {
			int var7 = (int)(var3 - var5);
			field174 = (32000 + (var7 >> 1)) / var7;
		}

		if (++field183 - 1 > 50) {
			field183 -= 50;
			this.field189 = true;
			this.field190.setSize(canvasWidth, class12.canvasHeight);
			this.field190.setVisible(true);
			if (var2 == this.field187) {
				Insets var8 = this.field187.getInsets();
				this.field190.setLocation(var8.left + this.field180, this.field181 + var8.top);
			} else {
				this.field190.setLocation(this.field180, this.field181);
			}
		}

		if (this.field192) {
			this.method454();
		}

		this.method460();
		this.method466(this.field189);
		if (this.field189) {
			this.method572();
		}

		this.field189 = false;
	}

	final void method460() {
		class407 var2 = this.method475();
		if (this.field171 != var2.field4531 || var2.field4528 != this.field179 || this.field191) {
			this.method451();
			this.field191 = false;
		}

	}

	final void method590() {
		this.field191 = true;
	}

	final synchronized void method514() {
		if (!field170) {
			field170 = true;

			try {
				this.field190.removeFocusListener(this);
			} catch (Exception var6) {
			}

			try {
				this.method455();
			} catch (Exception var5) {
			}

			if (this.field187 != null) {
				try {
					System.exit(0);
				} catch (Throwable var4) {
				}
			}

			if (null != field169) {
				try {
					field169.method2721();
				} catch (Exception var3) {
				}
			}

			this.method453();
		}
	}

	public final void start() {
		if (this == field201 && !field170) {
			field166 = 0L;
		}
	}

	public final void stop() {
		if (field201 == this && !field170) {
			field166 = class272.method2046() + 4000L;
		}
	}

	public final void destroy() {
		if (this == field201 && !field170) {
			field166 = class272.method2046();
			class266.method3531(5000L);
			this.method514();
		}
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final synchronized void paint(Graphics var1) {
		if (field201 == this && !field170) {
			this.field189 = true;
			if (class272.method2046() - this.field172 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (null == var2 || var2.width >= canvasWidth && var2.height >= class12.canvasHeight) {
					this.field192 = true;
				}
			}

		}
	}

	public final void focusGained(FocusEvent var1) {
		field197 = true;
		this.field189 = true;
	}

	public final void focusLost(FocusEvent var1) {
		field197 = false;
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	protected final void method477(int var1, String var2, boolean var3) {
		try {
			Graphics var5 = this.field190.getGraphics();
			if (class121.field1167 == null) {
				class121.field1167 = new Font("Helvetica", 1, 13);
				class12.field59 = this.field190.getFontMetrics(class121.field1167);
			}

			if (var3) {
				var5.setColor(Color.black);
				var5.fillRect(0, 0, canvasWidth, class12.canvasHeight);
			}

			Color var6 = new Color(140, 17, 17);

			try {
				if (AttackOption.field707 == null) {
					AttackOption.field707 = this.field190.createImage(304, 34);
				}

				Graphics var7 = AttackOption.field707.getGraphics();
				var7.setColor(var6);
				var7.drawRect(0, 0, 303, 33);
				var7.fillRect(2, 2, var1 * 3, 30);
				var7.setColor(Color.black);
				var7.drawRect(1, 1, 301, 31);
				var7.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var7.setFont(class121.field1167);
				var7.setColor(Color.white);
				var7.drawString(var2, (304 - class12.field59.stringWidth(var2)) / 2, 22);
				var5.drawImage(AttackOption.field707, canvasWidth / 2 - 152, class12.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var10) {
				int var8 = canvasWidth / 2 - 152;
				int var9 = class12.canvasHeight / 2 - 18;
				var5.setColor(var6);
				var5.drawRect(var8, var9, 303, 33);
				var5.fillRect(var8 + 2, var9 + 2, var1 * 3, 30);
				var5.setColor(Color.black);
				var5.drawRect(var8 + 1, var9 + 1, 301, 31);
				var5.fillRect(var8 + 2 + var1 * 3, var9 + 2, 300 - var1 * 3, 30);
				var5.setFont(class121.field1167);
				var5.setColor(Color.white);
				var5.drawString(var2, var8 + (304 - class12.field59.stringWidth(var2)) / 2, var9 + 22);
			}
		} catch (Exception var11) {
			this.field190.repaint();
		}

	}

	protected final void method472() {
		AttackOption.field707 = null;
		class121.field1167 = null;
		class12.field59 = null;
	}

	protected void method473(String var1) {
		if (!this.field178) {
			this.field178 = true;
			System.out.println("error_game_" + var1);

			try {
				this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
			} catch (Exception var4) {
			}

		}
	}

	Container method474() {
		return (Container)(this.field187 != null ? this.field187 : this);
	}

	class407 method475() {
		Container var2 = this.method474();
		int var3 = Math.max(var2.getWidth(), this.field195);
		int var4 = Math.max(var2.getHeight(), this.field184);
		if (this.field187 != null) {
			Insets var5 = this.field187.getInsets();
			var3 -= var5.right + var5.left;
			var4 -= var5.top + var5.bottom;
		}

		return new class407(var3, var4);
	}

	protected final boolean method562() {
		return this.field187 != null;
	}

	static final void sendClientCheat(String message) {
		if (message.equalsIgnoreCase("toggleroof")) {
			class413.clientPreferences.method1703(!class413.clientPreferences.method1777());
			if (class413.clientPreferences.method1777()) {
				MouseManager.method773(99, "", "Roofs are now all hidden");
			} else {
				MouseManager.method773(99, "", "Roofs will only be removed selectively");
			}
		}

		if (message.equalsIgnoreCase("displayfps")) {
			class413.clientPreferences.method1759();
		}

		if (message.equalsIgnoreCase("renderself")) {
			client.field1739 = !client.field1739;
		}

		if (message.equalsIgnoreCase("mouseovertext")) {
			client.field1797 = !client.field1797;
		}

		if (client.privilegeLevel >= 2) {
			if (message.equalsIgnoreCase("errortest")) {
				throw new RuntimeException();
			}

			if (message.equalsIgnoreCase("showcoord")) {
				ProofOfWorkRequest.field10.field4655 = !ProofOfWorkRequest.field10.field4655;
			}

			if (message.equalsIgnoreCase("fpson")) {
				class413.clientPreferences.method1709(true);
			}

			if (message.equalsIgnoreCase("fpsoff")) {
				class413.clientPreferences.method1709(false);
			}

			if (message.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (message.equalsIgnoreCase("clientdrop")) {
				client.method4611();
			}
		}

		PacketMessage packet = class185.create(ClientPacket.CLIENT_CHEAT, client.serverConnection.isaacRandom);
		packet.buffer.writeByte(message.length() + 1);
		packet.buffer.writeString(message);
		client.serverConnection.add(packet);
	}

	static final void method598() {
		client.field1830 = 0;
		int var1 = class36.sceneBaseX + (class291.localPlayer.field827 >> 7);
		int var2 = class169.sceneBaseY + (class291.localPlayer.field802 >> 7);
		if (var1 >= 3053 && var1 <= 3156 && var2 >= 3056 && var2 <= 3136) {
			client.field1830 = 1;
		}

		if (var1 >= 3072 && var1 <= 3118 && var2 >= 9492 && var2 <= 9535) {
			client.field1830 = 1;
		}

		if (client.field1830 == 1 && var1 >= 3139 && var1 <= 3199 && var2 >= 3008 && var2 <= 3062) {
			client.field1830 = 0;
		}

	}

	protected abstract void method453();

	protected abstract void method455();

	protected abstract void method466(boolean var1);

	public abstract void init();

	protected abstract void method467();

	protected abstract void method468();

	protected abstract void method599();
}
