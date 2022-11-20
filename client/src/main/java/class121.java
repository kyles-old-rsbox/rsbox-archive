import java.awt.Font;

public class class121 implements class360 {
	static Font field1167;
	static final class121 field1163;
	static final class121 field1164;
	static final class121 field1165;
	static final class121 field1166;
	static final class121 field1168;
	static final class121 field1169;
	static final class121 field1170;
	static final class121 field1171;
	static final class121 field1173;
	static final class121 field1174;
	static final class121 field1175;
	static final class121 field1176;
	static final class121 field1177;
	static final class121 field1178;
	static final class121 field1179;
	static final class121 field1180;
	static final class121 field1183;
	final int field1172;
	final int field1181;
	final int field1182;

	static {
		field1170 = new class121(0, 0, (String)null, -1);
		field1180 = new class121(1, 1, (String)null, 0);
		field1165 = new class121(2, 2, (String)null, 1);
		field1176 = new class121(3, 3, (String)null, 2);
		field1163 = new class121(4, 4, (String)null, 3);
		field1168 = new class121(5, 5, (String)null, 4);
		field1169 = new class121(6, 6, (String)null, 5);
		field1164 = new class121(7, 7, (String)null, 6);
		field1171 = new class121(8, 8, (String)null, 7);
		field1175 = new class121(9, 9, (String)null, 8);
		field1173 = new class121(10, 10, (String)null, 0);
		field1174 = new class121(11, 11, (String)null, 1);
		field1166 = new class121(12, 12, (String)null, 2);
		field1179 = new class121(13, 13, (String)null, 3);
		field1177 = new class121(14, 14, (String)null, 4);
		field1183 = new class121(15, 15, (String)null, 5);
		field1178 = new class121(16, 16, (String)null, 0);
	}

	static class121[] method135() {
		return new class121[]{field1170, field1180, field1165, field1176, field1163, field1168, field1169, field1164, field1171, field1175, field1173, field1174, field1166, field1179, field1177, field1183, field1178};
	}

	class121(int var1, int var2, String var3, int var4) {
		this.field1172 = var1;
		this.field1181 = var2;
		this.field1182 = var4;
	}

	public int rsOrdinal() {
		return this.field1181;
	}

	int method2281() {
		return this.field1182;
	}

	static void method2285() {
		if (client.field1643 && null != class291.field3364) {
			int var1 = class291.field3364.field861[0];
			int var2 = class291.field3364.field873[0];
			if (var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
				return;
			}

			class32.field203 = class291.field3364.field827;
			int var3 = class144.method2498(class291.field3364.field827, class291.field3364.field802, class55.field396) - client.field1723;
			if (var3 < class178.field1595) {
				class178.field1595 = var3;
			}

			class101.field1004 = class291.field3364.field802;
			client.field1643 = false;
		}

	}
}
