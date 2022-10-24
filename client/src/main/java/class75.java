import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class class75 {
	static boolean field617;
	static boolean field621;
	static boolean field637;
	static boolean field638;
	static boolean field643;
	static class488 field629;
	static int field616;
	static int field618;
	static int field619;
	static int field622;
	static int field626;
	static int field627;
	static int field628;
	static int field634;
	static int field636;
	static int field640;
	static int field645;
	static int field646;
	static String field623;
	static String field624;
	static String field630;
	static String field631;
	static String field633;
	static String field641;
	static String field642;
	static String field648;
	static String field650;
	static String[] field632;
	static String[] field635;
	static String[] field649;
	static long field639;
	static long field647;

	static class78 method1502(int var0, int var1, int var2) {
		int var4 = class325.method3731(var1, var0);
		class78 var5 = class451.method7977(var4, var0);
		if (null != var5) {
			return var5;
		} else {
			var4 = class325.method1275(var2, var0);
			var5 = class451.method7977(var4, var0);
			return var5 != null ? var5 : null;
		}
	}

	static {
		field618 = 0;
		field627 = 202 + field618;
		field622 = 10;
		field623 = "";
		field628 = -1;
		field646 = 1;
		field619 = 0;
		field648 = "";
		field624 = "";
		field630 = "";
		field631 = "";
		field633 = "";
		field650 = "";
		field634 = 0;
		field635 = new String[8];
		field637 = false;
		field638 = false;
		field621 = true;
		field640 = 0;
		field641 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
		field642 = "1234567890";
		field643 = false;
		field626 = -1;
		field645 = 0;
		field616 = 0;
		new DecimalFormat("##0.00");
		new class130();
		field647 = -1L;
		field639 = -1L;
		field649 = new String[]{"title.jpg"};
		field632 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "logo_speedrunning", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
	}

	class75() throws Throwable {
		throw new Error();
	}

	static Date method2497() {
		Calendar var1 = Calendar.getInstance();
		var1.set(2, 0);
		var1.set(5, 1);
		var1.set(1, 1900);
		return var1.getTime();
	}

	static void method201(String var0, String var1, String var2) {
		class74.method1490(7);
		method5452(var0, var1, var2);
	}

	static void method5452(String var0, String var1, String var2) {
		field624 = var0;
		field630 = var1;
		field631 = var2;
	}

	static void method199() {
		field643 = false;
		class323.field3774.method8483(field618, 0);
		class91.field882.method8483(field618 + 382, 0);
		class84.field745.method8755(382 + field618 - class84.field745.field5017 / 2, 18);
	}

	static void method12() {
		class74.method1490(24);
		method5452(class338.field4136, class338.field4154, class338.field4138);
	}

	static void method230() {
		class74.method1490(24);
		method5452(class338.field4139, class338.field4055, class338.field4193);
	}
}
