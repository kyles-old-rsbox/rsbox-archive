import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class class404 {
	class400[] field4514;
	int field4518;
	Comparator field4517;
	HashMap field4512;
	HashMap field4513;
	final int field4515;

	class404(int var1) {
		this.field4518 = 0;
		this.field4517 = null;
		this.field4515 = var1;
		this.field4514 = this.method7306(var1);
		this.field4513 = new HashMap(var1 / 8);
		this.field4512 = new HashMap(var1 / 8);
	}

	public void method7285() {
		this.field4518 = 0;
		Arrays.fill(this.field4514, (Object)null);
		this.field4513.clear();
		this.field4512.clear();
	}

	public int method7339() {
		return this.field4518;
	}

	public boolean method7329() {
		return this.field4518 == this.field4515;
	}

	public boolean method7359(DisplayName var1) {
		if (!var1.method8449()) {
			return false;
		} else {
			return this.field4513.containsKey(var1) ? true : this.field4512.containsKey(var1);
		}
	}

	public class400 method7289(DisplayName var1) {
		class400 var3 = this.method7290(var1);
		return null != var3 ? var3 : this.method7303(var1);
	}

	class400 method7290(DisplayName var1) {
		return !var1.method8449() ? null : (class400)this.field4513.get(var1);
	}

	class400 method7303(DisplayName var1) {
		return !var1.method8449() ? null : (class400)this.field4512.get(var1);
	}

	public final boolean method7292(DisplayName var1) {
		class400 var3 = this.method7290(var1);
		if (null == var3) {
			return false;
		} else {
			this.method7293(var3);
			return true;
		}
	}

	final void method7293(class400 var1) {
		int var3 = this.method7337(var1);
		if (var3 != -1) {
			this.method7360(var3);
			this.method7300(var1);
		}
	}

	class400 method7284(DisplayName var1) {
		return this.method7295(var1, (DisplayName)null);
	}

	class400 method7295(DisplayName var1, DisplayName var2) {
		if (this.method7290(var1) != null) {
			throw new IllegalStateException();
		} else {
			class400 var4 = this.method7304();
			var4.method7235(var1, var2);
			this.method7301(var4);
			this.method7340(var4);
			return var4;
		}
	}

	public final class400 method7296(int var1) {
		if (var1 >= 0 && var1 < this.field4518) {
			return this.field4514[var1];
		} else {
			throw new ArrayIndexOutOfBoundsException(var1);
		}
	}

	public final void method7297() {
		if (this.field4517 == null) {
			Arrays.sort(this.field4514, 0, this.field4518);
		} else {
			Arrays.sort(this.field4514, 0, this.field4518, this.field4517);
		}

	}

	final void method7347(class400 var1, DisplayName var2, DisplayName var3) {
		this.method7300(var1);
		var1.method7235(var2, var3);
		this.method7340(var1);
	}

	final int method7337(class400 var1) {
		for (int var3 = 0; var3 < this.field4518; ++var3) {
			if (var1 == this.field4514[var3]) {
				return var3;
			}
		}

		return -1;
	}

	final void method7300(class400 var1) {
		if (this.field4513.remove(var1.field4503) == null) {
			throw new IllegalStateException();
		} else {
			if (var1.field4504 != null) {
				this.field4512.remove(var1.field4504);
			}

		}
	}

	final void method7301(class400 var1) {
		this.field4514[++this.field4518 - 1] = var1;
	}

	final void method7340(class400 var1) {
		this.field4513.put(var1.field4503, var1);
		if (null != var1.field4504) {
			class400 var3 = (class400)this.field4512.put(var1.field4504, var1);
			if (null != var3 && var3 != var1) {
				var3.field4504 = null;
			}
		}

	}

	final void method7360(int var1) {
		--this.field4518;
		if (var1 < this.field4518) {
			System.arraycopy(this.field4514, var1 + 1, this.field4514, var1, this.field4518 - var1);
		}

	}

	public final void method7342() {
		this.field4517 = null;
	}

	public final void method7307(Comparator var1) {
		if (null == this.field4517) {
			this.field4517 = var1;
		} else if (this.field4517 instanceof class393) {
			((class393)this.field4517).method7159(var1);
		}

	}

	static void method7362(class319 var0, class319 var1, boolean var2, int var3) {
		if (Login.field617) {
			if (var3 == 4) {
				class74.method1490(4);
			}

		} else {
			if (var3 == 0) {
				class337.method6314(var2);
			} else {
				class74.method1490(var3);
			}

			class481.method8656();
			byte[] var5 = var0.method6148("title.jpg", "");
			class323.field3774 = class32.method712(var5);
			class91.field882 = class323.field3774.method8473();
			int var6 = client.field1633;
			if (0 != (var6 & 536870912)) {
				class84.field745 = class393.method7165(var1, "logo_deadman_mode", "");
			} else if ((var6 & 1073741824) != 0) {
				class84.field745 = class393.method7165(var1, "logo_seasonal_mode", "");
			} else if (0 != (var6 & 256)) {
				class84.field745 = class393.method7165(var1, "logo_speedrunning", "");
			} else {
				class84.field745 = class393.method7165(var1, "logo", "");
			}

			class351.field4278 = class393.method7165(var1, "titlebox", "");
			class136.field1272 = class393.method7165(var1, "titlebutton", "");
			class352.field4281 = class393.method7165(var1, "titlebutton_large", "");
			class142.field1319 = class393.method7165(var1, "play_now_text", "");
			class393.method7165(var1, "titlebutton_wide42,1", "");
			class258.field2959 = class475.method7371(var1, "runes", "");
			class26.field133 = class475.method7371(var1, "title_mute", "");
			Login.field629 = class393.method7165(var1, "options_radio_buttons,0", "");
			class84.field749 = class393.method7165(var1, "options_radio_buttons,4", "");
			class166.field1525 = class393.method7165(var1, "options_radio_buttons,2", "");
			class362.field4317 = class393.method7165(var1, "options_radio_buttons,6", "");
			class346.field4251 = Login.field629.field5017;
			Login.field636 = Login.field629.field5019;
			class77.field670 = new class86(class258.field2959);
			if (var2) {
				Login.username = "";
				Login.password = "";
				Login.field635 = new String[8];
				Login.field634 = 0;
			}

			class340.field4220 = 0;
			class349.field4269 = "";
			Login.field621 = true;
			Login.field643 = false;
			if (!class413.clientPreferences.method1708()) {
				class279.method3434(2, class43.field311, "scape main", "", 255, false);
			} else {
				class279.field3202 = 1;
				class7.field29 = null;
				class279.field3203 = -1;
				class279.field3204 = -1;
				MessagesManager.field1092 = 0;
				class337.field3889 = false;
				class13.field67 = 2;
			}

			MouseManager.method799(false);
			Login.field617 = true;
			Login.field618 = (class31.canvasWidth - 765) / 2;
			Login.field627 = Login.field618 + 202;
			class11.field47 = 180 + Login.field627;
			class323.field3774.method8483(Login.field618, 0);
			class91.field882.method8483(382 + Login.field618, 0);
			class84.field745.method8755(382 + Login.field618 - class84.field745.field5017 / 2, 18);
		}
	}

	abstract class400 method7304();

	abstract class400[] method7306(int var1);
}
