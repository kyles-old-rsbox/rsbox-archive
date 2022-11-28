public class class112 extends class437 {
	boolean field1106;
	class106[][] field1101;
	int field1103;
	int field1105;
	public class106[][] field1102;
	public class230 field1104;

	class112(class319 var1, class319 var2, int var3, boolean var4) {
		this.field1102 = (class106[][])null;
		this.field1101 = (class106[][])null;
		this.field1105 = 0;
		this.field1103 = var3;
		byte[] var5 = var1.method6175(this.field1103 >> 16 & 65535, this.field1103 & 65535);
		Buffer var6 = new Buffer(var5);
		int var7 = var6.readUnsignedByte();
		int var8 = var6.readUnsignedShort();
		byte[] var9;
		if (var4) {
			var9 = var2.method6131(0, var8);
		} else {
			var9 = var2.method6131(var8, 0);
		}

		this.field1104 = new class230(var8, var9);
		this.method2145(var6, var7);
	}

	void method2145(Buffer var1, int var2) {
		var1.readUnsignedShort();
		var1.readUnsignedShort();
		this.field1105 = var1.readUnsignedByte();
		int var4 = var1.readUnsignedShort();
		this.field1101 = new class106[this.field1104.method4530().method4346()][];
		this.field1102 = new class106[this.field1104.method4529()][];

		for (int var5 = 0; var5 < var4; ++var5) {
			int var7 = var1.readUnsignedByte();
			class126[] var8 = new class126[]{class126.field1219, class126.field1212, class126.field1210, class126.field1211, class126.field1208, class126.field1213};
			class126 var9 = (class126)class217.fromValue(var8, var7);
			if (var9 == null) {
				var9 = class126.field1219;
			}

			int var14 = var1.method8219();
			class121 var10 = class87.method1855(var1.readUnsignedByte());
			class106 var11 = new class106();
			var11.method2049(var1, var2);
			int var12 = var9.method2367();
			class106[][] var13;
			if (class126.field1212 == var9) {
				var13 = this.field1101;
			} else {
				var13 = this.field1102;
			}

			if (var13[var14] == null) {
				var13[var14] = new class106[var12];
			}

			var13[var14][var10.method2281()] = var11;
			if (class126.field1208 == var9) {
				this.field1106 = true;
			}
		}

	}

	public int method2147() {
		return this.field1105;
	}

	public boolean method2152() {
		return this.field1106;
	}

	public void method2164(int var1, class113 var2, int var3, int var4) {
		class412 var6 = class295.method5542();
		this.method2149(var6, var3, var2, var1);
		this.method2144(var6, var3, var2, var1);
		this.method2150(var6, var3, var2, var1);
		var2.method2194(var6);
		var6.method7469();
	}

	void method2149(class412 var1, int var2, class113 var3, int var4) {
		float[] var6 = var3.method2192(this.field1105);
		float var7 = var6[0];
		float var8 = var6[1];
		float var9 = var6[2];
		if (null != this.field1101[var2]) {
			class106 var10 = this.field1101[var2][0];
			class106 var11 = this.field1101[var2][1];
			class106 var12 = this.field1101[var2][2];
			if (var10 != null) {
				var7 = var10.method2060(var4);
			}

			if (var11 != null) {
				var8 = var11.method2060(var4);
			}

			if (var12 != null) {
				var9 = var12.method2060(var4);
			}
		}

		class415 var15 = class53.method1114();
		var15.method7550(1.0F, 0.0F, 0.0F, var7);
		class415 var16 = class53.method1114();
		var16.method7550(0.0F, 1.0F, 0.0F, var8);
		class415 var17 = class53.method1114();
		var17.method7550(0.0F, 0.0F, 1.0F, var9);
		class415 var13 = class53.method1114();
		var13.method7527(var17);
		var13.method7527(var15);
		var13.method7527(var16);
		class412 var14 = class295.method5542();
		var14.method7427(var13);
		var1.method7426(var14);
		var15.method7535();
		var16.method7535();
		var17.method7535();
		var13.method7535();
		var14.method7469();
	}

	void method2150(class412 var1, int var2, class113 var3, int var4) {
		float[] var6 = var3.method2181(this.field1105);
		float var7 = var6[0];
		float var8 = var6[1];
		float var9 = var6[2];
		if (this.field1101[var2] != null) {
			class106 var10 = this.field1101[var2][3];
			class106 var11 = this.field1101[var2][4];
			class106 var12 = this.field1101[var2][5];
			if (var10 != null) {
				var7 = var10.method2060(var4);
			}

			if (null != var11) {
				var8 = var11.method2060(var4);
			}

			if (null != var12) {
				var9 = var12.method2060(var4);
			}
		}

		var1.field4563[12] = var7;
		var1.field4563[13] = var8;
		var1.field4563[14] = var9;
	}

	void method2144(class412 var1, int var2, class113 var3, int var4) {
		float[] var6 = var3.method2182(this.field1105);
		float var7 = var6[0];
		float var8 = var6[1];
		float var9 = var6[2];
		if (this.field1101[var2] != null) {
			class106 var10 = this.field1101[var2][6];
			class106 var11 = this.field1101[var2][7];
			class106 var12 = this.field1101[var2][8];
			if (var10 != null) {
				var7 = var10.method2060(var4);
			}

			if (var11 != null) {
				var8 = var11.method2060(var4);
			}

			if (var12 != null) {
				var9 = var12.method2060(var4);
			}
		}

		class412 var13 = class295.method5542();
		var13.method7424(var7, var8, var9);
		var1.method7426(var13);
		var13.method7469();
	}

	static int method2170(class300 var0) {
		if (11 != var0.field3462) {
			class57.field405[class126.field1220 - 1] = "";
			return 1;
		} else {
			String var2 = class57.field405[--class126.field1220];
			class57.field405[++class126.field1220 - 1] = var0.method5937(var2);
			return 1;
		}
	}

	static void loginError(int var0) {
		int var2 = Login.field619;
		if (var0 == -3) {
			Login.setLoginResponseString(class338.field3936, class338.field3937, class338.field4075);
		} else if (var0 == -2) {
			Login.setLoginResponseString(class338.field4096, class338.field3940, class338.field3968);
		} else if (var0 == -1) {
			Login.setLoginResponseString(class338.field4084, class338.field3919, class338.field3944);
		} else if (var0 == 3) {
			class74.method1490(3);
			Login.field646 = 1;
		} else if (var0 == 4) {
			class74.method1490(14);
			Login.field628 = 0;
		} else if (var0 == 5) {
			Login.field646 = 2;
			Login.setLoginResponseString(class338.field3948, class338.field4194, class338.field4100);
		} else if (var0 != 68 && (client.field1640 || var0 != 6)) {
			if (var0 == 7) {
				Login.setLoginResponseString(class338.field3954, class338.field3955, class338.field3956);
			} else if (var0 == 8) {
				Login.setLoginResponseString(class338.field3957, class338.field3958, class338.field3959);
			} else if (var0 == 9) {
				Login.setLoginResponseString(class338.field4051, class338.field4091, class338.field4170);
			} else if (var0 == 10) {
				Login.setLoginResponseString(class338.field4116, class338.field3964, class338.field4168);
			} else if (var0 == 11) {
				Login.setLoginResponseString(class338.field4212, class338.field3967, class338.field4122);
			} else if (var0 == 12) {
				Login.setLoginResponseString(class338.field3969, class338.field3970, class338.field3971);
			} else if (var0 == 13) {
				Login.setLoginResponseString(class338.field3904, class338.field4002, class338.field3974);
			} else if (var0 == 14) {
				Login.setLoginResponseString(class338.field3975, class338.field3906, class338.field3977);
			} else if (var0 == 16) {
				Login.setLoginResponseString(class338.field3978, class338.field3979, class338.field3980);
			} else if (var0 == 17) {
				Login.setLoginResponseString(class338.field4073, class338.field4018, class338.field3983);
			} else if (var0 == 18) {
				class74.method1490(14);
				Login.field628 = 1;
			} else if (var0 == 19) {
				Login.setLoginResponseString(class338.field4016, class338.field3962, class338.field3989);
			} else if (var0 == 20) {
				Login.setLoginResponseString(class338.field3990, class338.field4179, class338.field3972);
			} else if (var0 == 22) {
				Login.setLoginResponseString(class338.field4145, class338.field3994, class338.field3995);
			} else if (var0 == 23) {
				Login.setLoginResponseString(class338.field3996, class338.field3997, class338.field3998);
			} else if (var0 == 24) {
				Login.setLoginResponseString(class338.field3999, class338.field4000, class338.field4001);
			} else if (var0 == 25) {
				Login.setLoginResponseString(class338.field4023, class338.field4003, class338.field4209);
			} else if (var0 == 26) {
				Login.setLoginResponseString(class338.field4005, class338.field4006, class338.field4007);
			} else if (var0 == 27) {
				Login.setLoginResponseString(class338.field3920, class338.field4009, class338.field4141);
			} else if (var0 == 31) {
				Login.setLoginResponseString(class338.field4017, class338.field3941, class338.field4164);
			} else if (var0 == 32) {
				class74.method1490(14);
				Login.field628 = 2;
			} else if (var0 == 37) {
				Login.setLoginResponseString(class338.field4008, class338.field4024, class338.field4025);
			} else if (var0 == 38) {
				Login.setLoginResponseString(class338.field4026, class338.field4027, class338.field4127);
			} else if (var0 == 55) {
				class74.method1490(8);
			} else {
				if (var0 == 56) {
					Login.setLoginResponseString(class338.field4161, class338.field4034, class338.field3976);
					class9.method64(11);
					return;
				}

				if (var0 == 57) {
					Login.setLoginResponseString(class338.field4085, class338.field4191, class338.field4038);
					class9.method64(11);
					return;
				}

				if (var0 == 61) {
					Login.setLoginResponseString("", "Please enter your date of birth (DD/MM/YYYY)", "");
					class74.method1490(7);
				} else {
					if (var0 == 62) {
						class9.method64(10);
						class74.method1490(9);
						Login.setLoginResponseString(class338.field4086, class338.field4040, class338.field4041);
						return;
					}

					if (var0 == 63) {
						class9.method64(10);
						class74.method1490(9);
						Login.setLoginResponseString(class338.field4042, class338.field4043, class338.field4044);
						return;
					}

					if (var0 == 65 || var0 == 67) {
						class9.method64(10);
						class74.method1490(9);
						Login.setLoginResponseString(class338.field4045, class338.field4046, class338.field4047);
						return;
					}

					if (var0 == 71) {
						class9.method64(10);
						class74.method1490(7);
						Login.setLoginResponseString("There was a problem updating your DOB.", "Please try again later. If the problem ", "persists, please contact Jagex Support.");
					} else if (var0 == 73) {
						class9.method64(10);
						class74.method1490(6);
						Login.setLoginResponseString(class338.field3960, class338.field4028, class338.field3918);
					} else if (var0 == 72) {
						class9.method64(10);
						class74.method1490(26);
					} else {
						Login.setLoginResponseString(class338.field4048, class338.field4049, class338.field4137);
					}
				}
			}
		} else {
			Login.setLoginResponseString(class338.field3963, class338.field3952, class338.field4181);
		}

		class9.method64(10);
		int var5 = Login.field619;
		boolean var6 = var2 != var5;
		if (!var6 && client.field1758.method7938()) {
			class74.method1490(9);
		}

	}
}
