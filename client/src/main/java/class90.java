import java.util.Date;

public abstract class class90 extends class212 {
	boolean field805;
	boolean field820;
	boolean field836;
	boolean field838;
	boolean field842;
	byte field828;
	byte field850;
	byte field864;
	byte field865;
	byte field867;
	class197[] field803;
	class350 field834;
	int field801;
	int field802;
	int field804;
	int field806;
	int field807;
	int field808;
	int field809;
	int field810;
	int field811;
	int field812;
	int field813;
	int field814;
	int field815;
	int field816;
	int field817;
	int field818;
	int field819;
	int field821;
	int field823;
	int field824;
	int field825;
	int field826;
	int field827;
	int field835;
	int field837;
	int field839;
	int field840;
	int field841;
	int field843;
	int field844;
	int field845;
	int field846;
	int field847;
	int field848;
	int field849;
	int field851;
	int field852;
	int field853;
	int field854;
	int field855;
	int field856;
	int field857;
	int field858;
	int field859;
	int field860;
	int field862;
	int field863;
	int field866;
	int field868;
	int field869;
	int field870;
	int field871;
	int field872;
	int field874;
	int field875;
	int field876;
	int field877;
	int[] field829;
	int[] field830;
	int[] field831;
	int[] field832;
	int[] field833;
	int[] field861;
	int[] field873;
	String field822;

	public static class160 method1885(int var0) {
		return var0 >= 0 && var0 < class160.field1464.length && null != class160.field1464[var0] ? class160.field1464[var0] : new class160(var0);
	}

	class90() {
		this.field805 = false;
		this.field866 = 1;
		this.field823 = -1;
		this.field808 = -1;
		this.field806 = -1;
		this.field810 = -1;
		this.field811 = -1;
		this.field812 = -1;
		this.field813 = -1;
		this.field814 = -1;
		this.field846 = -1;
		this.field816 = -1;
		this.field817 = -1;
		this.field818 = -1;
		this.field874 = -1;
		this.field849 = -1;
		this.field821 = -1;
		this.field822 = null;
		this.field820 = false;
		this.field843 = 100;
		this.field801 = 0;
		this.field819 = 0;
		this.field828 = 0;
		this.field829 = new int[4];
		this.field830 = new int[4];
		this.field831 = new int[4];
		this.field832 = new int[4];
		this.field833 = new int[4];
		this.field834 = new class350();
		this.field835 = -1;
		this.field836 = false;
		this.field868 = -1;
		this.field839 = -1;
		this.field840 = 0;
		this.field841 = 0;
		this.field825 = 0;
		this.field852 = -1;
		this.field844 = 0;
		this.field845 = 0;
		this.field804 = 0;
		this.field875 = 0;
		this.field848 = -1;
		this.field856 = 0;
		this.field807 = 0;
		this.field847 = 0;
		this.field809 = 200;
		this.field862 = -1;
		this.field863 = -1;
		this.field869 = 0;
		this.field870 = 32;
		this.field871 = 0;
		this.field861 = new int[10];
		this.field873 = new int[10];
		this.field803 = new class197[10];
		this.field837 = 0;
		this.field876 = 0;
		this.field877 = -1;
	}

	final void method1868() {
		this.field871 = 0;
		this.field876 = 0;
	}

	boolean method1869() {
		return false;
	}

	final void method1877(int var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var8 = true;
		boolean var9 = true;

		int var10;
		for (var10 = 0; var10 < 4; ++var10) {
			if (this.field831[var10] > var5) {
				var8 = false;
			} else {
				var9 = false;
			}
		}

		var10 = -1;
		int var11 = -1;
		int var12 = 0;
		if (var1 >= 0) {
			class206 var13 = class169.method2715(var1);
			var11 = var13.field2338;
			var12 = var13.field2327;
		}

		int var15;
		if (var9) {
			if (-1 == var11) {
				return;
			}

			var10 = 0;
			var15 = 0;
			if (var11 == 0) {
				var15 = this.field831[0];
			} else if (var11 == 1) {
				var15 = this.field830[0];
			}

			for (int var14 = 1; var14 < 4; ++var14) {
				if (var11 == 0) {
					if (this.field831[var14] < var15) {
						var10 = var14;
						var15 = this.field831[var14];
					}
				} else if (var11 == 1 && this.field830[var14] < var15) {
					var10 = var14;
					var15 = this.field830[var14];
				}
			}

			if (var11 == 1 && var15 >= var2) {
				return;
			}
		} else {
			if (var8) {
				this.field828 = 0;
			}

			for (var15 = 0; var15 < 4; ++var15) {
				byte var16 = this.field828;
				this.field828 = (byte)((1 + this.field828) % 4);
				if (this.field831[var16] <= var5) {
					var10 = var16;
					break;
				}
			}
		}

		if (var10 >= 0) {
			this.field829[var10] = var1;
			this.field830[var10] = var2;
			this.field832[var10] = var3;
			this.field833[var10] = var4;
			this.field831[var10] = var6 + var12 + var5;
		}
	}

	final void method1867(int var1, int var2, int var3, int var4, int var5, int var6) {
		class158 var8 = class346.method6404(var1);
		class91 var9 = null;
		class91 var10 = null;
		int var11 = var8.field1447;
		int var12 = 0;

		class91 var13;
		for (var13 = (class91)this.field834.method6465(); var13 != null; var13 = (class91)this.field834.method6467()) {
			++var12;
			if (var13.field880.field1457 == var8.field1457) {
				var13.method1889(var4 + var2, var5, var6, var3);
				return;
			}

			if (var13.field880.field1446 <= var8.field1446) {
				var9 = var13;
			}

			if (var13.field880.field1447 > var11) {
				var10 = var13;
				var11 = var13.field880.field1447;
			}
		}

		if (var10 != null || var12 < 4) {
			var13 = new class91(var8);
			if (null == var9) {
				this.field834.method6463(var13);
			} else {
				class350.method6476(var13, var9);
			}

			var13.method1889(var2 + var4, var5, var6, var3);
			if (var12 >= 4) {
				var10.method7825();
			}

		}
	}

	final void method1872(int var1) {
		class158 var3 = class346.method6404(var1);

		for (class91 var4 = (class91)this.field834.method6465(); null != var4; var4 = (class91)this.field834.method6467()) {
			if (var4.field880 == var3) {
				var4.method7825();
				return;
			}
		}

	}

	static int method1884(int var0, class78 var1, boolean var2) {
		int var4;
		int var5;
		if (4000 == var0) {
			class387.field4452 -= 2;
			var4 = class57.field404[class387.field4452];
			var5 = class57.field404[class387.field4452 + 1];
			class57.field404[++class387.field4452 - 1] = var4 + var5;
			return 1;
		} else if (4001 == var0) {
			class387.field4452 -= 2;
			var4 = class57.field404[class387.field4452];
			var5 = class57.field404[class387.field4452 + 1];
			class57.field404[++class387.field4452 - 1] = var4 - var5;
			return 1;
		} else if (4002 == var0) {
			class387.field4452 -= 2;
			var4 = class57.field404[class387.field4452];
			var5 = class57.field404[class387.field4452 + 1];
			class57.field404[++class387.field4452 - 1] = var5 * var4;
			return 1;
		} else if (var0 == 4003) {
			class387.field4452 -= 2;
			var4 = class57.field404[class387.field4452];
			var5 = class57.field404[class387.field4452 + 1];
			class57.field404[++class387.field4452 - 1] = var4 / var5;
			return 1;
		} else if (4004 == var0) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = (int)(Math.random() * (double)var4);
			return 1;
		} else if (var0 == 4005) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = (int)(Math.random() * (double)(var4 + 1));
			return 1;
		} else {
			int var6;
			int var7;
			int var8;
			if (var0 == 4006) {
				class387.field4452 -= 5;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				var6 = class57.field404[class387.field4452 + 2];
				var7 = class57.field404[3 + class387.field4452];
				var8 = class57.field404[class387.field4452 + 4];
				class57.field404[++class387.field4452 - 1] = var4 + (var5 - var4) * (var8 - var6) / (var7 - var6);
				return 1;
			} else if (var0 == 4007) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				class57.field404[++class387.field4452 - 1] = var4 * var5 / 100 + var4;
				return 1;
			} else if (4008 == var0) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				class57.field404[++class387.field4452 - 1] = var4 | 1 << var5;
				return 1;
			} else if (var0 == 4009) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				class57.field404[++class387.field4452 - 1] = var4 & -1 - (1 << var5);
				return 1;
			} else if (4010 == var0) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				class57.field404[++class387.field4452 - 1] = (var4 & 1 << var5) != 0 ? 1 : 0;
				return 1;
			} else if (var0 == 4011) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				class57.field404[++class387.field4452 - 1] = var4 % var5;
				return 1;
			} else if (4012 == var0) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				if (0 == var4) {
					class57.field404[++class387.field4452 - 1] = 0;
				} else {
					class57.field404[++class387.field4452 - 1] = (int)Math.pow((double)var4, (double)var5);
				}

				return 1;
			} else if (4013 == var0) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				if (var4 == 0) {
					class57.field404[++class387.field4452 - 1] = 0;
					return 1;
				} else {
					switch(var5) {
					case 0:
						class57.field404[++class387.field4452 - 1] = Integer.MAX_VALUE;
						break;
					case 1:
						class57.field404[++class387.field4452 - 1] = var4;
						break;
					case 2:
						class57.field404[++class387.field4452 - 1] = (int)Math.sqrt((double)var4);
						break;
					case 3:
						class57.field404[++class387.field4452 - 1] = (int)Math.cbrt((double)var4);
						break;
					case 4:
						class57.field404[++class387.field4452 - 1] = (int)Math.sqrt(Math.sqrt((double)var4));
						break;
					default:
						class57.field404[++class387.field4452 - 1] = (int)Math.pow((double)var4, 1.0D / (double)var5);
					}

					return 1;
				}
			} else if (4014 == var0) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				class57.field404[++class387.field4452 - 1] = var4 & var5;
				return 1;
			} else if (4015 == var0) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				class57.field404[++class387.field4452 - 1] = var4 | var5;
				return 1;
			} else if (4018 == var0) {
				class387.field4452 -= 3;
				long var10 = (long)class57.field404[class387.field4452];
				long var12 = (long)class57.field404[1 + class387.field4452];
				long var14 = (long)class57.field404[2 + class387.field4452];
				class57.field404[++class387.field4452 - 1] = (int)(var14 * var10 / var12);
				return 1;
			} else if (var0 == 4025) {
				var4 = class282.method4111(class57.field404[--class387.field4452]);
				class57.field404[++class387.field4452 - 1] = var4;
				return 1;
			} else if (var0 == 4026) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				class57.field404[++class387.field4452 - 1] = var4 ^ 1 << var5;
				return 1;
			} else if (4027 == var0) {
				class387.field4452 -= 3;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				var6 = class57.field404[class387.field4452 + 2];
				class57.field404[++class387.field4452 - 1] = class282.method5041(var4, var5, var6);
				return 1;
			} else if (var0 == 4028) {
				class387.field4452 -= 3;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				var6 = class57.field404[2 + class387.field4452];
				class57.field404[++class387.field4452 - 1] = class282.method651(var4, var5, var6);
				return 1;
			} else if (4029 == var0) {
				class387.field4452 -= 3;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				var6 = class57.field404[class387.field4452 + 2];
				var7 = 31 - var6;
				class57.field404[++class387.field4452 - 1] = var4 << var7 >>> var5 + var7;
				return 1;
			} else if (var0 == 4030) {
				class387.field4452 -= 4;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				var6 = class57.field404[class387.field4452 + 2];
				var7 = class57.field404[class387.field4452 + 3];
				var4 = class282.method651(var4, var6, var7);
				var8 = class282.method6306(1 + (var7 - var6));
				if (var5 > var8) {
					var5 = var8;
				}

				class57.field404[++class387.field4452 - 1] = var4 | var5 << var6;
				return 1;
			} else if (var0 == 4032) {
				class57.field404[class387.field4452 - 1] = class422.method6182(class57.field404[class387.field4452 - 1]);
				return 1;
			} else if (4033 == var0) {
				class57.field404[class387.field4452 - 1] = class422.method2841(class57.field404[class387.field4452 - 1]);
				return 1;
			} else if (var0 == 4034) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				var6 = class422.method4672(var4, var5);
				class57.field404[++class387.field4452 - 1] = var6;
				return 1;
			} else if (4035 == var0) {
				class57.field404[class387.field4452 - 1] = Math.abs(class57.field404[class387.field4452 - 1]);
				return 1;
			} else {
				return 2;
			}
		}
	}

	static int method1886(int var0, class78 var1, boolean var2) {
		String var4;
		int var5;
		if (var0 == 4100) {
			var4 = class57.field405[--class126.field1220];
			var5 = class57.field404[--class387.field4452];
			class57.field405[++class126.field1220 - 1] = var4 + var5;
			return 1;
		} else {
			String var10;
			if (var0 == 4101) {
				class126.field1220 -= 2;
				var4 = class57.field405[class126.field1220];
				var10 = class57.field405[class126.field1220 + 1];
				class57.field405[++class126.field1220 - 1] = var4 + var10;
				return 1;
			} else if (4102 == var0) {
				var4 = class57.field405[--class126.field1220];
				var5 = class57.field404[--class387.field4452];
				class57.field405[++class126.field1220 - 1] = var4 + class11.method86(var5, true);
				return 1;
			} else if (var0 == 4103) {
				var4 = class57.field405[--class126.field1220];
				class57.field405[++class126.field1220 - 1] = var4.toLowerCase();
				return 1;
			} else {
				int var7;
				int var11;
				if (4104 == var0) {
					var11 = class57.field404[--class387.field4452];
					long var12 = ((long)var11 + 11745L) * 86400000L;
					class57.field416.setTime(new Date(var12));
					var7 = class57.field416.get(5);
					int var18 = class57.field416.get(2);
					int var9 = class57.field416.get(1);
					class57.field405[++class126.field1220 - 1] = var7 + "-" + class57.field409[var18] + "-" + var9;
					return 1;
				} else if (4105 != var0) {
					if (4106 == var0) {
						var11 = class57.field404[--class387.field4452];
						class57.field405[++class126.field1220 - 1] = Integer.toString(var11);
						return 1;
					} else if (4107 == var0) {
						class126.field1220 -= 2;
						class57.field404[++class387.field4452 - 1] = class312.method6062(class57.method1274(class57.field405[class126.field1220], class57.field405[1 + class126.field1220], class94.field940));
						return 1;
					} else {
						int var6;
						byte[] var14;
						class376 var15;
						if (var0 == 4108) {
							var4 = class57.field405[--class126.field1220];
							class387.field4452 -= 2;
							var5 = class57.field404[class387.field4452];
							var6 = class57.field404[class387.field4452 + 1];
							var14 = class136.field1275.method6175(var6, 0);
							var15 = new class376(var14);
							class57.field404[++class387.field4452 - 1] = var15.method6869(var4, var5);
							return 1;
						} else if (var0 == 4109) {
							var4 = class57.field405[--class126.field1220];
							class387.field4452 -= 2;
							var5 = class57.field404[class387.field4452];
							var6 = class57.field404[1 + class387.field4452];
							var14 = class136.field1275.method6175(var6, 0);
							var15 = new class376(var14);
							class57.field404[++class387.field4452 - 1] = var15.method6862(var4, var5);
							return 1;
						} else if (var0 == 4110) {
							class126.field1220 -= 2;
							var4 = class57.field405[class126.field1220];
							var10 = class57.field405[class126.field1220 + 1];
							if (class57.field404[--class387.field4452] == 1) {
								class57.field405[++class126.field1220 - 1] = var4;
							} else {
								class57.field405[++class126.field1220 - 1] = var10;
							}

							return 1;
						} else if (var0 == 4111) {
							var4 = class57.field405[--class126.field1220];
							class57.field405[++class126.field1220 - 1] = class384.method6864(var4);
							return 1;
						} else if (var0 == 4112) {
							var4 = class57.field405[--class126.field1220];
							var5 = class57.field404[--class387.field4452];
							class57.field405[++class126.field1220 - 1] = var4 + (char)var5;
							return 1;
						} else if (4113 == var0) {
							var11 = class57.field404[--class387.field4452];
							class57.field404[++class387.field4452 - 1] = class348.method6446((char)var11) ? 1 : 0;
							return 1;
						} else if (4114 == var0) {
							var11 = class57.field404[--class387.field4452];
							class57.field404[++class387.field4452 - 1] = class148.method2543((char)var11) ? 1 : 0;
							return 1;
						} else if (4115 == var0) {
							var11 = class57.field404[--class387.field4452];
							class57.field404[++class387.field4452 - 1] = class122.method2302((char)var11) ? 1 : 0;
							return 1;
						} else if (var0 == 4116) {
							var11 = class57.field404[--class387.field4452];
							class57.field404[++class387.field4452 - 1] = class347.method6422((char)var11) ? 1 : 0;
							return 1;
						} else if (var0 == 4117) {
							var4 = class57.field405[--class126.field1220];
							if (var4 != null) {
								class57.field404[++class387.field4452 - 1] = var4.length();
							} else {
								class57.field404[++class387.field4452 - 1] = 0;
							}

							return 1;
						} else if (4118 == var0) {
							var4 = class57.field405[--class126.field1220];
							class387.field4452 -= 2;
							var5 = class57.field404[class387.field4452];
							var6 = class57.field404[class387.field4452 + 1];
							class57.field405[++class126.field1220 - 1] = var4.substring(var5, var6);
							return 1;
						} else if (4119 == var0) {
							var4 = class57.field405[--class126.field1220];
							StringBuilder var19 = new StringBuilder(var4.length());
							boolean var17 = false;

							for (var7 = 0; var7 < var4.length(); ++var7) {
								char var8 = var4.charAt(var7);
								if (var8 == '<') {
									var17 = true;
								} else if (var8 == '>') {
									var17 = false;
								} else if (!var17) {
									var19.append(var8);
								}
							}

							class57.field405[++class126.field1220 - 1] = var19.toString();
							return 1;
						} else if (var0 == 4120) {
							var4 = class57.field405[--class126.field1220];
							var5 = class57.field404[--class387.field4452];
							class57.field404[++class387.field4452 - 1] = var4.indexOf(var5);
							return 1;
						} else if (4121 == var0) {
							class126.field1220 -= 2;
							var4 = class57.field405[class126.field1220];
							var10 = class57.field405[1 + class126.field1220];
							var6 = class57.field404[--class387.field4452];
							class57.field404[++class387.field4452 - 1] = var4.indexOf(var10, var6);
							return 1;
						} else if (4122 == var0) {
							var4 = class57.field405[--class126.field1220];
							class57.field405[++class126.field1220 - 1] = var4.toUpperCase();
							return 1;
						} else if (var0 == 4123) {
							class126.field1220 -= 3;
							var4 = class57.field405[class126.field1220];
							var10 = class57.field405[1 + class126.field1220];
							String var16 = class57.field405[class126.field1220 + 2];
							if (class291.field3364.field911 == null) {
								class57.field405[++class126.field1220 - 1] = var16;
								return 1;
							} else {
								switch(class291.field3364.field911.field3641) {
								case 0:
									class57.field405[++class126.field1220 - 1] = var4;
									break;
								case 1:
									class57.field405[++class126.field1220 - 1] = var10;
									break;
								case 2:
								default:
									class57.field405[++class126.field1220 - 1] = var16;
								}

								return 1;
							}
						} else {
							return 2;
						}
					}
				} else {
					class126.field1220 -= 2;
					var4 = class57.field405[class126.field1220];
					var10 = class57.field405[class126.field1220 + 1];
					if (null != class291.field3364.field911 && 0 != class291.field3364.field911.field3639) {
						class57.field405[++class126.field1220 - 1] = var10;
					} else {
						class57.field405[++class126.field1220 - 1] = var4;
					}

					return 1;
				}
			}
		}
	}
}
