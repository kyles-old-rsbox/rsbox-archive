import java.util.Comparator;

public class class74 implements Comparator {
	static byte[][] field612;
	static class84 mouseRecorder;
	boolean field614;

	static void method1490(int var0) {
		if (Login.field619 != var0) {
			Login.field619 = var0;
		}
	}

	static final void method1496(class90 var0) {
		var0.field805 = false;
		class189 var2;
		int var6;
		if (-1 != var0.field839) {
			var2 = class160.method2660(var0.field839);
			if (null != var2) {
				if (!var2.method3486() && var2.field1998 != null) {
					++var0.field841;
					if (var0.field840 < var2.field1998.length && var0.field841 > var2.field2000[var0.field840]) {
						var0.field841 = 1;
						++var0.field840;
						class322.method6198(var2, var0.field840, var0.field827, var0.field802);
					}

					if (var0.field840 >= var2.field1998.length) {
						if (var2.field2012 > 0) {
							var0.field840 -= var2.field2012;
							if (var2.field2008) {
								++var0.field825;
							}

							if (var0.field840 < 0 || var0.field840 >= var2.field1998.length || var2.field2008 && var0.field825 >= var2.field2009) {
								var0.field841 = 0;
								var0.field840 = 0;
								var0.field825 = 0;
							}
						} else {
							var0.field841 = 0;
							var0.field840 = 0;
						}

						class322.method6198(var2, var0.field840, var0.field827, var0.field802);
					}
				} else if (var2.method3486()) {
					++var0.field840;
					var6 = var2.method3476();
					if (var0.field840 < var6) {
						AbstractSocket.method7270(var2, var0.field840, var0.field827, var0.field802);
					} else {
						if (var2.field2012 > 0) {
							var0.field840 -= var2.field2012;
							if (var2.field2008) {
								++var0.field825;
							}

							if (var0.field840 < 0 || var0.field840 >= var6 || var2.field2008 && var0.field825 >= var2.field2009) {
								var0.field840 = 0;
								var0.field841 = 0;
								var0.field825 = 0;
							}
						} else {
							var0.field841 = 0;
							var0.field840 = 0;
						}

						AbstractSocket.method7270(var2, var0.field840, var0.field827, var0.field802);
					}
				} else {
					var0.field839 = -1;
				}
			} else {
				var0.field839 = -1;
			}
		}

		if (-1 != var0.field848 && client.field1645 >= var0.field851) {
			if (var0.field856 < 0) {
				var0.field856 = 0;
			}

			int var5 = class207.method803(var0.field848).field2359;
			if (var5 != -1) {
				class189 var3 = class160.method2660(var5);
				if (var3 != null && null != var3.field1998 && !var3.method3486()) {
					++var0.field807;
					if (var0.field856 < var3.field1998.length && var0.field807 > var3.field2000[var0.field856]) {
						var0.field807 = 1;
						++var0.field856;
						class322.method6198(var3, var0.field856, var0.field827, var0.field802);
					}

					if (var0.field856 >= var3.field1998.length && (var0.field856 < 0 || var0.field856 >= var3.field1998.length)) {
						var0.field848 = -1;
					}
				} else if (var3.method3486()) {
					++var0.field856;
					int var4 = var3.method3476();
					if (var0.field856 < var4) {
						AbstractSocket.method7270(var3, var0.field856, var0.field827, var0.field802);
					} else if (var0.field856 < 0 || var0.field856 >= var4) {
						var0.field848 = -1;
					}
				} else {
					var0.field848 = -1;
				}
			} else {
				var0.field848 = -1;
			}
		}

		if (-1 != var0.field852 && var0.field804 <= 1) {
			var2 = class160.method2660(var0.field852);
			if (1 == var2.field2002 && var0.field876 > 0 && var0.field857 <= client.field1645 && var0.field858 < client.field1645) {
				var0.field804 = 1;
				return;
			}
		}

		if (var0.field852 != -1 && var0.field804 == 0) {
			var2 = class160.method2660(var0.field852);
			if (null != var2) {
				if (!var2.method3486() && var2.field1998 != null) {
					++var0.field845;
					if (var0.field844 < var2.field1998.length && var0.field845 > var2.field2000[var0.field844]) {
						var0.field845 = 1;
						++var0.field844;
						class322.method6198(var2, var0.field844, var0.field827, var0.field802);
					}

					if (var0.field844 >= var2.field1998.length) {
						var0.field844 -= var2.field2012;
						++var0.field875;
						if (var0.field875 >= var2.field2009) {
							var0.field852 = -1;
						} else if (var0.field844 >= 0 && var0.field844 < var2.field1998.length) {
							class322.method6198(var2, var0.field844, var0.field827, var0.field802);
						} else {
							var0.field852 = -1;
						}
					}

					var0.field805 = var2.field2005;
				} else if (var2.method3486()) {
					++var0.field844;
					var6 = var2.method3476();
					if (var0.field844 < var6) {
						AbstractSocket.method7270(var2, var0.field844, var0.field827, var0.field802);
					} else {
						var0.field844 -= var2.field2012;
						++var0.field875;
						if (var0.field875 >= var2.field2009) {
							var0.field852 = -1;
						} else if (var0.field844 >= 0 && var0.field844 < var6) {
							AbstractSocket.method7270(var2, var0.field844, var0.field827, var0.field802);
						} else {
							var0.field852 = -1;
						}
					}
				} else {
					var0.field852 = -1;
				}
			} else {
				var0.field852 = -1;
			}
		}

		if (var0.field804 > 0) {
			--var0.field804;
		}

	}

	class74() {
	}

	int method1492(class328 var1, class328 var2) {
		if (var1.field3806 == var2.field3806) {
			return 0;
		} else {
			if (this.field614) {
				if (var1.field3806 == client.worldId) {
					return -1;
				}

				if (client.worldId == var2.field3806) {
					return 1;
				}
			}

			return var1.field3806 < var2.field3806 ? -1 : 1;
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method1492((class328)var1, (class328)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
