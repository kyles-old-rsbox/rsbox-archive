import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class class88 implements class360 {
	static class28 field794;
	static final class88 field785;
	static final class88 field786;
	static final class88 field787;
	static final class88 field788;
	static final class88 field793;
	final int field789;
	final int field792;

	static {
		field786 = new class88(0, -1);
		field785 = new class88(1, 1);
		field793 = new class88(2, 7);
		field787 = new class88(3, 8);
		field788 = new class88(4, 9);
	}

	static class88[] method1283() {
		return new class88[]{field786, field793, field785, field788, field787};
	}

	static void method1863(int var0, byte[] var1, class392 var2) {
		class334 var4 = new class334();
		var4.field3860 = 0;
		var4.field4681 = (long)var0;
		var4.field3861 = var1;
		var4.field3862 = var2;
		synchronized(class322.field3759) {
			class322.field3759.method6355(var4);
		}

		synchronized(class322.field3762) {
			if (class322.field3761 == 0) {
				class322.field3763 = new Thread(new class322());
				class322.field3763.setDaemon(true);
				class322.field3763.start();
				class322.field3763.setPriority(5);
			}

			class322.field3761 = 600;
		}

	}

	class88(int var1, int var2) {
		this.field789 = var1;
		this.field792 = var2;
	}

	public int method6663() {
		return this.field792;
	}

	public static void method1865(class453 var0) {
		class43 var2 = (class43)class45.field329.method6465();
		if (var2 != null) {
			int var3 = var0.field4878;
			var0.method8241(var2.field307);

			for (int var4 = 0; var4 < var2.field309; ++var4) {
				if (var2.field300[var4] != 0) {
					var0.method8104(var2.field300[var4]);
				} else {
					try {
						int var5 = var2.field301[var4];
						Field var6;
						int var7;
						if (var5 == 0) {
							var6 = var2.field303[var4];
							var7 = var6.getInt((Object)null);
							var0.method8104(0);
							var0.method8241(var7);
						} else if (1 == var5) {
							var6 = var2.field303[var4];
							var6.setInt((Object)null, var2.field304[var4]);
							var0.method8104(0);
						} else if (2 == var5) {
							var6 = var2.field303[var4];
							var7 = var6.getModifiers();
							var0.method8104(0);
							var0.method8241(var7);
						}

						Method var26;
						if (var5 != 3) {
							if (var5 == 4) {
								var26 = var2.field305[var4];
								var7 = var26.getModifiers();
								var0.method8104(0);
								var0.method8241(var7);
							}
						} else {
							var26 = var2.field305[var4];
							byte[][] var11 = var2.field306[var4];
							Object[] var8 = new Object[var11.length];

							for (int var9 = 0; var9 < var11.length; ++var9) {
								ObjectInputStream var10 = new ObjectInputStream(new ByteArrayInputStream(var11[var9]));
								var8[var9] = var10.readObject();
							}

							Object var12 = var26.invoke((Object)null, var8);
							if (null == var12) {
								var0.method8104(0);
							} else if (var12 instanceof Number) {
								var0.method8104(1);
								var0.method8109(((Number)var12).longValue());
							} else if (var12 instanceof String) {
								var0.method8104(2);
								var0.method8111((String)var12);
							} else {
								var0.method8104(4);
							}
						}
					} catch (ClassNotFoundException var14) {
						var0.method8104(-10);
					} catch (InvalidClassException var15) {
						var0.method8104(-11);
					} catch (StreamCorruptedException var16) {
						var0.method8104(-12);
					} catch (OptionalDataException var17) {
						var0.method8104(-13);
					} catch (IllegalAccessException var18) {
						var0.method8104(-14);
					} catch (IllegalArgumentException var19) {
						var0.method8104(-15);
					} catch (InvocationTargetException var20) {
						var0.method8104(-16);
					} catch (SecurityException var21) {
						var0.method8104(-17);
					} catch (IOException var22) {
						var0.method8104(-18);
					} catch (NullPointerException var23) {
						var0.method8104(-19);
					} catch (Exception var24) {
						var0.method8104(-20);
					} catch (Throwable var25) {
						var0.method8104(-21);
					}
				}
			}

			var0.method8233(var3);
			var2.method7825();
		}
	}

	static int method1864(int var0, class78 var1, boolean var2) {
		if (6500 == var0) {
			class57.field404[++class387.field4452 - 1] = class328.method6247() ? 1 : 0;
			return 1;
		} else {
			class72 var4;
			if (var0 == 6501) {
				var4 = class72.method524();
				if (var4 != null) {
					class57.field404[++class387.field4452 - 1] = var4.field590;
					class57.field404[++class387.field4452 - 1] = var4.field587;
					class57.field405[++class126.field1220 - 1] = var4.field588;
					class57.field404[++class387.field4452 - 1] = var4.field580;
					class57.field404[++class387.field4452 - 1] = var4.field593;
					class57.field405[++class126.field1220 - 1] = var4.field589;
				} else {
					class57.field404[++class387.field4452 - 1] = -1;
					class57.field404[++class387.field4452 - 1] = 0;
					class57.field405[++class126.field1220 - 1] = "";
					class57.field404[++class387.field4452 - 1] = 0;
					class57.field404[++class387.field4452 - 1] = 0;
					class57.field405[++class126.field1220 - 1] = "";
				}

				return 1;
			} else if (6502 == var0) {
				var4 = class215.method4335();
				if (null != var4) {
					class57.field404[++class387.field4452 - 1] = var4.field590;
					class57.field404[++class387.field4452 - 1] = var4.field587;
					class57.field405[++class126.field1220 - 1] = var4.field588;
					class57.field404[++class387.field4452 - 1] = var4.field580;
					class57.field404[++class387.field4452 - 1] = var4.field593;
					class57.field405[++class126.field1220 - 1] = var4.field589;
				} else {
					class57.field404[++class387.field4452 - 1] = -1;
					class57.field404[++class387.field4452 - 1] = 0;
					class57.field405[++class126.field1220 - 1] = "";
					class57.field404[++class387.field4452 - 1] = 0;
					class57.field404[++class387.field4452 - 1] = 0;
					class57.field405[++class126.field1220 - 1] = "";
				}

				return 1;
			} else {
				class72 var5;
				int var6;
				int var8;
				if (var0 == 6506) {
					var8 = class57.field404[--class387.field4452];
					var5 = null;

					for (var6 = 0; var6 < class72.field582; ++var6) {
						if (var8 == class399.field4502[var6].field590) {
							var5 = class399.field4502[var6];
							break;
						}
					}

					if (var5 != null) {
						class57.field404[++class387.field4452 - 1] = var5.field590;
						class57.field404[++class387.field4452 - 1] = var5.field587;
						class57.field405[++class126.field1220 - 1] = var5.field588;
						class57.field404[++class387.field4452 - 1] = var5.field580;
						class57.field404[++class387.field4452 - 1] = var5.field593;
						class57.field405[++class126.field1220 - 1] = var5.field589;
					} else {
						class57.field404[++class387.field4452 - 1] = -1;
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field405[++class126.field1220 - 1] = "";
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field405[++class126.field1220 - 1] = "";
					}

					return 1;
				} else if (var0 == 6507) {
					class387.field4452 -= 4;
					var8 = class57.field404[class387.field4452];
					boolean var11 = class57.field404[1 + class387.field4452] == 1;
					var6 = class57.field404[2 + class387.field4452];
					boolean var7 = 1 == class57.field404[class387.field4452 + 3];
					class166.method2701(var8, var11, var6, var7);
					return 1;
				} else if (var0 != 6511) {
					if (6512 == var0) {
						client.field1794 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else {
						int var9;
						class193 var10;
						if (6513 == var0) {
							class387.field4452 -= 2;
							var8 = class57.field404[class387.field4452];
							var9 = class57.field404[class387.field4452 + 1];
							var10 = class213.method4120(var9);
							if (var10.method3567()) {
								class57.field405[++class126.field1220 - 1] = class158.method2632(var8).method3860(var9, var10.field2041);
							} else {
								class57.field404[++class387.field4452 - 1] = class158.method2632(var8).method3859(var9, var10.field2043);
							}

							return 1;
						} else if (6514 == var0) {
							class387.field4452 -= 2;
							var8 = class57.field404[class387.field4452];
							var9 = class57.field404[class387.field4452 + 1];
							var10 = class213.method4120(var9);
							if (var10.method3567()) {
								class57.field405[++class126.field1220 - 1] = class89.method1866(var8).method3590(var9, var10.field2041);
							} else {
								class57.field404[++class387.field4452 - 1] = class89.method1866(var8).method3614(var9, var10.field2043);
							}

							return 1;
						} else if (var0 == 6515) {
							class387.field4452 -= 2;
							var8 = class57.field404[class387.field4452];
							var9 = class57.field404[class387.field4452 + 1];
							var10 = class213.method4120(var9);
							if (var10.method3567()) {
								class57.field405[++class126.field1220 - 1] = class278.method5388(var8).method3657(var9, var10.field2041);
							} else {
								class57.field404[++class387.field4452 - 1] = class278.method5388(var8).method3656(var9, var10.field2043);
							}

							return 1;
						} else if (6516 == var0) {
							class387.field4452 -= 2;
							var8 = class57.field404[class387.field4452];
							var9 = class57.field404[class387.field4452 + 1];
							var10 = class213.method4120(var9);
							if (var10.method3567()) {
								class57.field405[++class126.field1220 - 1] = class191.method3536(var8).method3450(var9, var10.field2041);
							} else {
								class57.field404[++class387.field4452 - 1] = class191.method3536(var8).method3451(var9, var10.field2043);
							}

							return 1;
						} else if (var0 == 6518) {
							class57.field404[++class387.field4452 - 1] = client.field1640 ? 1 : 0;
							return 1;
						} else if (var0 == 6519) {
							class57.field404[++class387.field4452 - 1] = client.field1704;
							return 1;
						} else if (6520 == var0) {
							return 1;
						} else if (var0 == 6521) {
							return 1;
						} else if (var0 == 6522) {
							--class126.field1220;
							--class387.field4452;
							return 1;
						} else if (6523 == var0) {
							--class126.field1220;
							--class387.field4452;
							return 1;
						} else if (6524 == var0) {
							class57.field404[++class387.field4452 - 1] = -1;
							return 1;
						} else if (6525 == var0) {
							class57.field404[++class387.field4452 - 1] = 1;
							return 1;
						} else if (var0 == 6526) {
							class57.field404[++class387.field4452 - 1] = 1;
							return 1;
						} else if (var0 == 6527) {
							class57.field404[++class387.field4452 - 1] = client.field1716;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var8 = class57.field404[--class387.field4452];
					if (var8 >= 0 && var8 < class72.field582) {
						var5 = class399.field4502[var8];
						class57.field404[++class387.field4452 - 1] = var5.field590;
						class57.field404[++class387.field4452 - 1] = var5.field587;
						class57.field405[++class126.field1220 - 1] = var5.field588;
						class57.field404[++class387.field4452 - 1] = var5.field580;
						class57.field404[++class387.field4452 - 1] = var5.field593;
						class57.field405[++class126.field1220 - 1] = var5.field589;
					} else {
						class57.field404[++class387.field4452 - 1] = -1;
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field405[++class126.field1220 - 1] = "";
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field405[++class126.field1220 - 1] = "";
					}

					return 1;
				}
			}
		}
	}
}
