public abstract class class319 {
	static class484 field3745;
	static int field3744;
	boolean field3748;
	boolean field3749;
	class476 field3736;
	class476[] field3742;
	int field3739;
	int[] field3733;
	int[] field3734;
	int[] field3735;
	int[] field3737;
	int[] field3738;
	int[][] field3740;
	int[][] field3741;
	Object[] field3743;
	Object[][] field3747;
	public int field3746;

	static {
		field3745 = new class484();
		field3744 = 0;
	}

	class319(boolean var1, boolean var2) {
		this.field3748 = var1;
		this.field3749 = var2;
	}

	void method6085(byte[] var1) {
		int var4 = var1.length;
		int var3 = class241.method4729(var1, 0, var4);
		this.field3746 = var3;
		class460 var5 = new class460(class231.method4537(var1));
		int var6 = var5.method8141();
		if (var6 >= 5 && var6 <= 7) {
			if (var6 >= 6) {
				var5.method8126();
			}

			int var7 = var5.method8141();
			if (var6 >= 7) {
				this.field3739 = var5.method8139();
			} else {
				this.field3739 = var5.method8122();
			}

			int var8 = 0;
			int var9 = -1;
			this.field3734 = new int[this.field3739];
			int var10;
			if (var6 >= 7) {
				for (var10 = 0; var10 < this.field3739; ++var10) {
					this.field3734[var10] = var8 += var5.method8139();
					if (this.field3734[var10] > var9) {
						var9 = this.field3734[var10];
					}
				}
			} else {
				for (var10 = 0; var10 < this.field3739; ++var10) {
					this.field3734[var10] = var8 += var5.method8122();
					if (this.field3734[var10] > var9) {
						var9 = this.field3734[var10];
					}
				}
			}

			this.field3737 = new int[var9 + 1];
			this.field3738 = new int[var9 + 1];
			this.field3733 = new int[var9 + 1];
			this.field3740 = new int[var9 + 1][];
			this.field3743 = new Object[var9 + 1];
			this.field3747 = new Object[var9 + 1][];
			if (var7 != 0) {
				this.field3735 = new int[var9 + 1];

				for (var10 = 0; var10 < this.field3739; ++var10) {
					this.field3735[this.field3734[var10]] = var5.method8126();
				}

				this.field3736 = new class476(this.field3735);
			}

			for (var10 = 0; var10 < this.field3739; ++var10) {
				this.field3737[this.field3734[var10]] = var5.method8126();
			}

			for (var10 = 0; var10 < this.field3739; ++var10) {
				this.field3738[this.field3734[var10]] = var5.method8126();
			}

			for (var10 = 0; var10 < this.field3739; ++var10) {
				this.field3733[this.field3734[var10]] = var5.method8122();
			}

			int var11;
			int var12;
			int var13;
			int var14;
			int var15;
			if (var6 >= 7) {
				for (var10 = 0; var10 < this.field3739; ++var10) {
					var11 = this.field3734[var10];
					var12 = this.field3733[var11];
					var8 = 0;
					var13 = -1;
					this.field3740[var11] = new int[var12];

					for (var14 = 0; var14 < var12; ++var14) {
						var15 = this.field3740[var11][var14] = var8 += var5.method8139();
						if (var15 > var13) {
							var13 = var15;
						}
					}

					this.field3747[var11] = new Object[var13 + 1];
				}
			} else {
				for (var10 = 0; var10 < this.field3739; ++var10) {
					var11 = this.field3734[var10];
					var12 = this.field3733[var11];
					var8 = 0;
					var13 = -1;
					this.field3740[var11] = new int[var12];

					for (var14 = 0; var14 < var12; ++var14) {
						var15 = this.field3740[var11][var14] = var8 += var5.method8122();
						if (var15 > var13) {
							var13 = var15;
						}
					}

					this.field3747[var11] = new Object[var13 + 1];
				}
			}

			if (var7 != 0) {
				this.field3741 = new int[var9 + 1][];
				this.field3742 = new class476[var9 + 1];

				for (var10 = 0; var10 < this.field3739; ++var10) {
					var11 = this.field3734[var10];
					var12 = this.field3733[var11];
					this.field3741[var11] = new int[this.field3747[var11].length];

					for (var13 = 0; var13 < var12; ++var13) {
						this.field3741[var11][this.field3740[var11][var13]] = var5.method8126();
					}

					this.field3742[var11] = new class476(this.field3741[var11]);
				}
			}

		} else {
			throw new RuntimeException("");
		}
	}

	void method6133(int var1) {
	}

	public byte[] method6175(int var1, int var2) {
		return this.method6088(var1, var2, (int[])null);
	}

	public byte[] method6088(int var1, int var2, int[] var3) {
		if (var1 >= 0 && var1 < this.field3747.length && null != this.field3747[var1] && var2 >= 0 && var2 < this.field3747[var1].length) {
			if (null == this.field3747[var1][var2]) {
				boolean var5 = this.method6125(var1, var3);
				if (!var5) {
					this.method6094(var1);
					var5 = this.method6125(var1, var3);
					if (!var5) {
						return null;
					}
				}
			}

			byte[] var6 = class329.method6257(this.field3747[var1][var2], false);
			if (this.field3749) {
				this.field3747[var1][var2] = null;
			}

			return var6;
		} else {
			return null;
		}
	}

	public boolean method6089(int var1, int var2) {
		if (var1 >= 0 && var1 < this.field3747.length && null != this.field3747[var1] && var2 >= 0 && var2 < this.field3747[var1].length) {
			if (null != this.field3747[var1][var2]) {
				return true;
			} else if (this.field3743[var1] != null) {
				return true;
			} else {
				this.method6094(var1);
				return null != this.field3743[var1];
			}
		} else {
			return false;
		}
	}

	public boolean method6090(int var1) {
		if (1 == this.field3747.length) {
			return this.method6089(0, var1);
		} else if (this.field3747[var1].length == 1) {
			return this.method6089(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	public boolean method6091(int var1) {
		if (null != this.field3743[var1]) {
			return true;
		} else {
			this.method6094(var1);
			return null != this.field3743[var1];
		}
	}

	public boolean method6092() {
		boolean var2 = true;

		for (int var3 = 0; var3 < this.field3734.length; ++var3) {
			int var4 = this.field3734[var3];
			if (null == this.field3743[var4]) {
				this.method6094(var4);
				if (this.field3743[var4] == null) {
					var2 = false;
				}
			}
		}

		return var2;
	}

	int method6159(int var1) {
		return this.field3743[var1] != null ? 100 : 0;
	}

	public byte[] method6103(int var1) {
		if (1 == this.field3747.length) {
			return this.method6175(0, var1);
		} else if (this.field3747[var1].length == 1) {
			return this.method6175(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	public byte[] method6131(int var1, int var2) {
		if (var1 >= 0 && var1 < this.field3747.length && this.field3747[var1] != null && var2 >= 0 && var2 < this.field3747[var1].length) {
			if (this.field3747[var1][var2] == null) {
				boolean var4 = this.method6125(var1, (int[])null);
				if (!var4) {
					this.method6094(var1);
					var4 = this.method6125(var1, (int[])null);
					if (!var4) {
						return null;
					}
				}
			}

			byte[] var5 = class329.method6257(this.field3747[var1][var2], false);
			return var5;
		} else {
			return null;
		}
	}

	public byte[] method6096(int var1) {
		if (this.field3747.length == 1) {
			return this.method6131(0, var1);
		} else if (1 == this.field3747[var1].length) {
			return this.method6131(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	void method6094(int var1) {
	}

	public int[] method6098(int var1) {
		return var1 >= 0 && var1 < this.field3740.length ? this.field3740[var1] : null;
	}

	public int method6099(int var1) {
		return this.field3747[var1].length;
	}

	public int method6100() {
		return this.field3747.length;
	}

	public void method6101() {
		for (int var2 = 0; var2 < this.field3743.length; ++var2) {
			this.field3743[var2] = null;
		}

	}

	public void method6102(int var1) {
		for (int var3 = 0; var3 < this.field3747[var1].length; ++var3) {
			this.field3747[var1][var3] = null;
		}

	}

	public void method6117() {
		for (int var2 = 0; var2 < this.field3747.length; ++var2) {
			if (null != this.field3747[var2]) {
				for (int var3 = 0; var3 < this.field3747[var2].length; ++var3) {
					this.field3747[var2][var3] = null;
				}
			}
		}

	}

	boolean method6125(int var1, int[] var2) {
		if (this.field3743[var1] == null) {
			return false;
		} else {
			int var4 = this.field3733[var1];
			int[] var5 = this.field3740[var1];
			Object[] var6 = this.field3747[var1];
			boolean var7 = true;

			for (int var8 = 0; var8 < var4; ++var8) {
				if (null == var6[var5[var8]]) {
					var7 = false;
					break;
				}
			}

			if (var7) {
				return true;
			} else {
				byte[] var19;
				if (null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
					var19 = class329.method6257(this.field3743[var1], false);
				} else {
					var19 = class329.method6257(this.field3743[var1], true);
					class460 var9 = new class460(var19);
					var9.method8146(var2, 5, var9.field4881.length);
				}

				byte[] var21 = class231.method4537(var19);
				if (this.field3748) {
					this.field3743[var1] = null;
				}

				if (var4 > 1) {
					int var10 = var21.length;
					--var10;
					int var11 = var21[var10] & 255;
					var10 -= var11 * var4 * 4;
					class460 var12 = new class460(var21);
					int[] var13 = new int[var4];
					var12.field4878 = var10;

					int var15;
					int var16;
					for (int var14 = 0; var14 < var11; ++var14) {
						var15 = 0;

						for (var16 = 0; var16 < var4; ++var16) {
							var15 += var12.method8126();
							var13[var16] += var15;
						}
					}

					byte[][] var20 = new byte[var4][];

					for (var15 = 0; var15 < var4; ++var15) {
						var20[var15] = new byte[var13[var15]];
						var13[var15] = 0;
					}

					var12.field4878 = var10;
					var15 = 0;

					for (var16 = 0; var16 < var11; ++var16) {
						int var17 = 0;

						for (int var18 = 0; var18 < var4; ++var18) {
							var17 += var12.method8126();
							System.arraycopy(var21, var15, var20[var18], var13[var18], var17);
							var13[var18] += var17;
							var15 += var17;
						}
					}

					for (var16 = 0; var16 < var4; ++var16) {
						if (!this.field3749) {
							var6[var5[var16]] = class142.method2479(var20[var16], false);
						} else {
							var6[var5[var16]] = var20[var16];
						}
					}
				} else if (!this.field3749) {
					var6[var5[0]] = class142.method2479(var21, false);
				} else {
					var6[var5[0]] = var21;
				}

				return true;
			}
		}
	}

	public int method6124(String var1) {
		var1 = var1.toLowerCase();
		return this.field3736.method8617(class359.method6670(var1));
	}

	public int method6170(int var1, String var2) {
		var2 = var2.toLowerCase();
		return this.field3742[var1].method8617(class359.method6670(var2));
	}

	public boolean method6155(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var4 = this.field3736.method8617(class359.method6670(var1));
		if (var4 < 0) {
			return false;
		} else {
			int var5 = this.field3742[var4].method8617(class359.method6670(var2));
			return var5 >= 0;
		}
	}

	public byte[] method6148(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var4 = this.field3736.method8617(class359.method6670(var1));
		int var5 = this.field3742[var4].method8617(class359.method6670(var2));
		return this.method6175(var4, var5);
	}

	public boolean method6108(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var4 = this.field3736.method8617(class359.method6670(var1));
		int var5 = this.field3742[var4].method8617(class359.method6670(var2));
		return this.method6089(var4, var5);
	}

	public boolean method6110(String var1) {
		var1 = var1.toLowerCase();
		int var3 = this.field3736.method8617(class359.method6670(var1));
		return this.method6091(var3);
	}

	public void method6106(String var1) {
		var1 = var1.toLowerCase();
		int var3 = this.field3736.method8617(class359.method6670(var1));
		if (var3 >= 0) {
			this.method6133(var3);
		}
	}

	public int method6111(String var1) {
		var1 = var1.toLowerCase();
		int var3 = this.field3736.method8617(class359.method6670(var1));
		return this.method6159(var3);
	}

	static final void method6181(int var0, int var1, int var2, int var3) {
		for (int var5 = 0; var5 < client.field1858; ++var5) {
			if (client.field1710[var5] + client.field1863[var5] > var0 && client.field1863[var5] < var2 + var0 && client.field1864[var5] + client.field1658[var5] > var1 && client.field1864[var5] < var3 + var1) {
				client.field1860[var5] = true;
			}
		}

	}
}
