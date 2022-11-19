import client.Client;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class class131 extends class140 {
	int field1241;
	String field1240;
	// $FF: synthetic field
	final class142 this$0;

	public static void method2400(class460 var0, int var1) {
		class43 var3 = new class43();
		var3.field309 = var0.method8141();
		var3.field307 = var0.method8126();
		var3.field301 = new int[var3.field309];
		var3.field300 = new int[var3.field309];
		var3.field303 = new Field[var3.field309];
		var3.field304 = new int[var3.field309];
		var3.field305 = new Method[var3.field309];
		var3.field306 = new byte[var3.field309][][];

		for (int var4 = 0; var4 < var3.field309; ++var4) {
			try {
				int var5 = var0.method8141();
				String var6;
				String var7;
				int var8;
				if (var5 != 0 && var5 != 1 && var5 != 2) {
					if (var5 == 3 || var5 == 4) {
						var6 = var0.method8131();
						var7 = var0.method8131();
						var8 = var0.method8141();
						String[] var9 = new String[var8];

						for (int var10 = 0; var10 < var8; ++var10) {
							var9[var10] = var0.method8131();
						}

						String var21 = var0.method8131();
						byte[][] var11 = new byte[var8][];
						int var13;
						if (var5 == 3) {
							for (int var12 = 0; var12 < var8; ++var12) {
								var13 = var0.method8126();
								var11[var12] = new byte[var13];
								var0.method8333(var11[var12], 0, var13);
							}
						}

						var3.field301[var4] = var5;
						Class[] var22 = new Class[var8];

						for (var13 = 0; var13 < var8; ++var13) {
							var22[var13] = class86.method1835(var9[var13]);
						}

						Class var23 = class86.method1835(var21);
						if (class86.method1835(var6).getClassLoader() == null) {
							throw new SecurityException();
						}

						Method[] var14 = class86.method1835(var6).getDeclaredMethods();
						Method[] var15 = var14;

						for (int var16 = 0; var16 < var15.length; ++var16) {
							Method var17 = var15[var16];
							if (var17.getName().equals(var7)) {
								Class[] var18 = var17.getParameterTypes();
								if (var18.length == var22.length) {
									boolean var19 = true;

									for (int var20 = 0; var20 < var22.length; ++var20) {
										if (var18[var20] != var22[var20]) {
											var19 = false;
											break;
										}
									}

									if (var19 && var23 == var17.getReturnType()) {
										var3.field305[var4] = var17;
									}
								}
							}
						}

						var3.field306[var4] = var11;
					}
				} else {
					var6 = var0.method8131();
					var7 = var0.method8131();
					var8 = 0;
					if (var5 == 1) {
						var8 = var0.method8126();
					}

					var3.field301[var4] = var5;
					var3.field304[var4] = var8;
					if (class86.method1835(var6).getClassLoader() == null) {
						throw new SecurityException();
					}

					var3.field303[var4] = class86.method1835(var6).getDeclaredField(var7);
				}
			} catch (ClassNotFoundException var25) {
				var3.field300[var4] = -1;
			} catch (SecurityException var26) {
				var3.field300[var4] = -2;
			} catch (NullPointerException var27) {
				var3.field300[var4] = -3;
			} catch (Exception var28) {
				var3.field300[var4] = -4;
			} catch (Throwable var29) {
				var3.field300[var4] = -5;
			}
		}

		class45.field329.method6462(var3);
	}

	class131(class142 var1) {
		this.this$0 = var1;
	}

	void method2467(class460 var1) {
		this.field1241 = var1.method8126();
		this.field1240 = var1.method8131();
	}

	void method2468(class148 var1) {
		var1.method2541(this.field1241, this.field1240);
	}

	static final void method2399(String var0, boolean var1) {
		if (Client.field1762) {
			byte var3 = 4;
			int var4 = var3 + 6;
			int var5 = var3 + 6;
			int var6 = class353.field4289.method6862(var0, 250);
			int var7 = class353.field4289.method6869(var0, 250) * 13;
			class481.method8660(var4 - var3, var5 - var3, var3 + var3 + var6, var3 + var7 + var3, 0);
			class481.method8664(var4 - var3, var5 - var3, var3 + var3 + var6, var3 + var7 + var3, 16777215);
			class353.field4289.method6870(var0, var4, var5, var6, var7, 16777215, -1, 1, 1, 0);
			class319.method6181(var4 - var3, var5 - var3, var3 + var6 + var3, var3 + var3 + var7);
			if (var1) {
				class6.field18.method8621(0, 0);
			} else {
				class105.method2047(var4, var5, var6, var7);
			}

		}
	}
}
