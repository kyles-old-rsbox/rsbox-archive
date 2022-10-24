public class class236 implements class248 {
	int field2787;
	int field2788;
	int field2789;
	int field2790;
	int field2791;
	int field2792;
	int field2793;
	int field2794;
	int field2795;
	int field2796;
	int field2797;
	int field2798;
	int field2799;
	int field2800;

	class236() {
	}

	public void method4986(class254 var1) {
		if (var1.field2936 > this.field2798) {
			var1.field2936 = this.field2798;
		}

		if (var1.field2930 < this.field2798) {
			var1.field2930 = this.field2798;
		}

		if (var1.field2937 > this.field2800) {
			var1.field2937 = this.field2800;
		}

		if (var1.field2939 < this.field2800) {
			var1.field2939 = this.field2800;
		}

	}

	public boolean method4976(int var1, int var2, int var3) {
		if (var1 >= this.field2792 && var1 < this.field2792 + this.field2788) {
			return var2 >= (this.field2790 << 3) + (this.field2789 << 6) && var2 <= 7 + (this.field2789 << 6) + (this.field2795 << 3) && var3 >= (this.field2794 << 3) + (this.field2791 << 6) && var3 <= 7 + (this.field2796 << 3) + (this.field2791 << 6);
		} else {
			return false;
		}
	}

	public boolean method4963(int var1, int var2) {
		return var1 >= (this.field2787 << 3) + (this.field2798 << 6) && var1 <= 7 + (this.field2798 << 6) + (this.field2799 << 3) && var2 >= (this.field2800 << 6) + (this.field2793 << 3) && var2 <= 7 + (this.field2800 << 6) + (this.field2797 << 3);
	}

	public int[] method4979(int var1, int var2, int var3) {
		if (!this.method4976(var1, var2, var3)) {
			return null;
		} else {
			int[] var5 = new int[]{this.field2798 * 64 - this.field2789 * 64 + var2 + (this.field2787 * 8 - this.field2790 * 8), var3 + (this.field2800 * 64 - this.field2791 * 64) + (this.field2793 * 8 - this.field2794 * 8)};
			return var5;
		}
	}

	public class295 method4966(int var1, int var2) {
		if (!this.method4963(var1, var2)) {
			return null;
		} else {
			int var4 = this.field2790 * 8 - this.field2787 * 8 + var1 + (this.field2789 * 64 - this.field2798 * 64);
			int var5 = this.field2791 * 64 - this.field2800 * 64 + var2 + (this.field2794 * 8 - this.field2793 * 8);
			return new class295(this.field2792, var4, var5);
		}
	}

	public void method4967(class460 var1) {
		this.field2792 = var1.method8141();
		this.field2788 = var1.method8141();
		this.field2789 = var1.method8122();
		this.field2790 = var1.method8141();
		this.field2795 = var1.method8141();
		this.field2791 = var1.method8122();
		this.field2794 = var1.method8141();
		this.field2796 = var1.method8141();
		this.field2798 = var1.method8122();
		this.field2787 = var1.method8141();
		this.field2799 = var1.method8141();
		this.field2800 = var1.method8122();
		this.field2793 = var1.method8141();
		this.field2797 = var1.method8141();
		this.method4594();
	}

	void method4594() {
	}

	static final void method4618(boolean var0, class453 var1) {
		client.field1769 = 0;
		client.field1693 = 0;
		class133.method2411();

		int var3;
		int var4;
		int var8;
		int var9;
		int var10;
		int var11;
		int var13;
		int var18;
		while (true) {
			var3 = class227.field2714 ? 16 : 15;
			var4 = 1 << var3;
			if (var1.method8044(client.field1778.field1075) < var3 + 12) {
				break;
			}

			int var15 = var1.method8014(var3);
			if (var4 - 1 == var15) {
				break;
			}

			boolean var6 = false;
			if (null == client.field1902[var15]) {
				client.field1902[var15] = new class81();
				var6 = true;
			}

			class81 var16 = client.field1902[var15];
			client.field1692[++client.field1691 - 1] = var15;
			var16.field847 = client.field1645;
			if (class227.field2714) {
				var11 = var1.method8014(1);
				if (var11 == 1) {
					client.field1694[++client.field1693 - 1] = var15;
				}

				boolean var12 = var1.method8014(1) == 1;
				if (var12) {
					var1.method8014(32);
				}

				var8 = var1.method8014(1);
				var16.field709 = class158.method2632(var1.method8014(14));
				if (var0) {
					var9 = var1.method8014(8);
					if (var9 > 127) {
						var9 -= 256;
					}
				} else {
					var9 = var1.method8014(5);
					if (var9 > 15) {
						var9 -= 32;
					}
				}

				var13 = client.field1774[var1.method8014(3)];
				if (var6) {
					var16.field860 = var16.field826 = var13;
				}

				if (var0) {
					var10 = var1.method8014(8);
					if (var10 > 127) {
						var10 -= 256;
					}
				} else {
					var10 = var1.method8014(5);
					if (var10 > 15) {
						var10 -= 32;
					}
				}
			} else {
				var16.field709 = class158.method2632(var1.method8014(14));
				if (var0) {
					var10 = var1.method8014(8);
					if (var10 > 127) {
						var10 -= 256;
					}
				} else {
					var10 = var1.method8014(5);
					if (var10 > 15) {
						var10 -= 32;
					}
				}

				if (var0) {
					var9 = var1.method8014(8);
					if (var9 > 127) {
						var9 -= 256;
					}
				} else {
					var9 = var1.method8014(5);
					if (var9 > 15) {
						var9 -= 32;
					}
				}

				var8 = var1.method8014(1);
				var11 = client.field1774[var1.method8014(3)];
				if (var6) {
					var16.field860 = var16.field826 = var11;
				}

				var18 = var1.method8014(1);
				if (1 == var18) {
					client.field1694[++client.field1693 - 1] = var15;
				}

				boolean var19 = var1.method8014(1) == 1;
				if (var19) {
					var1.method8014(32);
				}
			}

			var16.field866 = var16.field709.field2262;
			var16.field870 = var16.field709.field2299;
			if (var16.field870 == 0) {
				var16.field826 = 0;
			}

			var16.field810 = var16.field709.field2268;
			var16.field811 = var16.field709.field2269;
			var16.field812 = var16.field709.field2270;
			var16.field813 = var16.field709.field2271;
			var16.field823 = var16.field709.field2265;
			var16.field808 = var16.field709.field2266;
			var16.field806 = var16.field709.field2264;
			var16.field814 = var16.field709.field2272;
			var16.field846 = var16.field709.field2286;
			var16.field816 = var16.field709.field2274;
			var16.field817 = var16.field709.field2256;
			var16.field818 = var16.field709.field2273;
			var16.field874 = var16.field709.field2277;
			var16.field849 = var16.field709.field2297;
			var16.field821 = var16.field709.field2294;
			var16.method1625(var9 + class291.field3364.field861[0], var10 + class291.field3364.field873[0], var8 == 1);
		}

		var1.method8010();

		for (var3 = 0; var3 < client.field1693; ++var3) {
			var4 = client.field1694[var3];
			class81 var5 = client.field1902[var4];
			int var17 = var1.method8141();
			int var7;
			if (0 != (var17 & 32)) {
				var7 = var1.method8141();
				var17 += var7 << 8;
			}

			if (0 != (var17 & 2)) {
				var5.field848 = var1.method8162();
				var7 = var1.method8126();
				var5.field824 = var7 >> 16;
				var5.field851 = client.field1645 + (var7 & 65535);
				var5.field856 = 0;
				var5.field807 = 0;
				if (var5.field851 > client.field1645) {
					var5.field856 = -1;
				}

				if (65535 == var5.field848) {
					var5.field848 = -1;
				}
			}

			if ((var17 & 8) != 0) {
				var7 = var1.method8341();
				if (var7 > 0) {
					for (var8 = 0; var8 < var7; ++var8) {
						var10 = -1;
						var11 = -1;
						var18 = -1;
						var9 = var1.method8207();
						if (var9 == 32767) {
							var9 = var1.method8207();
							var11 = var1.method8207();
							var10 = var1.method8207();
							var18 = var1.method8207();
						} else if (32766 != var9) {
							var11 = var1.method8207();
						} else {
							var9 = -1;
						}

						var13 = var1.method8207();
						var5.method1877(var9, var11, var10, var18, client.field1645, var13);
					}
				}

				var8 = var1.method8153();
				if (var8 > 0) {
					for (var9 = 0; var9 < var8; ++var9) {
						var10 = var1.method8207();
						var11 = var1.method8207();
						if (32767 != var11) {
							var18 = var1.method8207();
							var13 = var1.method8341();
							int var14 = var11 > 0 ? var1.method8153() : var13;
							var5.method1867(var10, client.field1645, var11, var18, var13, var14);
						} else {
							var5.method1872(var10);
						}
					}
				}
			}

			if (0 != (var17 & 2048)) {
				var5.method1616(var1.method8131());
			}

			if (0 != (var17 & 512)) {
				var5.field877 = var1.method8174();
			}

			if ((var17 & 4) != 0) {
				var7 = var1.method8162();
				var8 = var1.method8164();
				var5.field838 = var1.method8153() == 1;
				var9 = var5.field827 - (var7 - class36.field241 - class36.field241) * 64;
				var10 = var5.field802 - 64 * (var8 - class169.field1536 - class169.field1536);
				if (0 != var9 || 0 != var10) {
					var5.field868 = (int)(Math.atan2((double)var9, (double)var10) * 325.949D) & 2047;
				}
			}

			if ((var17 & 128) != 0) {
				var7 = var1.method8122();
				if (var7 == 65535) {
					var7 = -1;
				}

				var8 = var1.method8341();
				if (var5.field852 == var7 && -1 != var7) {
					var9 = class160.method2660(var7).field2013;
					if (1 == var9) {
						var5.field844 = 0;
						var5.field845 = 0;
						var5.field804 = var8;
						var5.field875 = 0;
					}

					if (2 == var9) {
						var5.field875 = 0;
					}
				} else if (var7 == -1 || -1 == var5.field852 || class160.method2660(var7).field2006 >= class160.method2660(var5.field852).field2006) {
					var5.field852 = var7;
					var5.field844 = 0;
					var5.field845 = 0;
					var5.field804 = var8;
					var5.field875 = 0;
					var5.field876 = var5.field871;
				}
			}

			if ((var17 & 64) != 0) {
				var5.field822 = var1.method8131();
				var5.field843 = 100;
			}

			if ((var17 & 1024) != 0) {
				var5.field815 = var1.method8335();
				var5.field855 = var1.method8187();
				var5.field854 = var1.method8335();
				var5.field853 = var1.method8287();
				var5.field857 = var1.method8122() + client.field1645;
				var5.field858 = var1.method8122() + client.field1645;
				var5.field859 = var1.method8164();
				var5.field871 = 1;
				var5.field876 = 0;
				var5.field815 += var5.field861[0];
				var5.field855 += var5.field873[0];
				var5.field854 += var5.field861[0];
				var5.field853 += var5.field873[0];
			}

			if (0 != (var17 & 4096)) {
				var5.field862 = client.field1645 + var1.method8164();
				var5.field863 = client.field1645 + var1.method8202();
				var5.field864 = var1.method8287();
				var5.field865 = var1.method8158();
				var5.field850 = var1.method8287();
				var5.field867 = (byte)var1.method8141();
			}

			if ((var17 & 1) != 0) {
				var5.field835 = var1.method8162();
				if (class227.field2714) {
					var5.field835 += var1.method8153() << 16;
					var7 = 16777215;
				} else {
					var7 = 65535;
				}

				if (var7 == var5.field835) {
					var5.field835 = -1;
				}
			}

			if ((var17 & 16) != 0) {
				var5.field709 = class158.method2632(var1.method8162());
				var5.field866 = var5.field709.field2262;
				var5.field870 = var5.field709.field2299;
				var5.field810 = var5.field709.field2268;
				var5.field811 = var5.field709.field2269;
				var5.field812 = var5.field709.field2270;
				var5.field813 = var5.field709.field2271;
				var5.field823 = var5.field709.field2265;
				var5.field808 = var5.field709.field2266;
				var5.field806 = var5.field709.field2264;
			}

			if ((var17 & 256) != 0) {
				var5.method1617(var1.method8153());
			}
		}

		for (var3 = 0; var3 < client.field1769; ++var3) {
			var4 = client.field1770[var3];
			if (client.field1902[var4].field847 != client.field1645) {
				client.field1902[var4].field709 = null;
				client.field1902[var4] = null;
			}
		}

		if (var1.field4878 != client.field1778.field1075) {
			throw new RuntimeException(var1.field4878 + class96.field959 + client.field1778.field1075);
		} else {
			for (var3 = 0; var3 < client.field1691; ++var3) {
				if (client.field1902[client.field1692[var3]] == null) {
					throw new RuntimeException(var3 + class96.field959 + client.field1691);
				}
			}

		}
	}
}
