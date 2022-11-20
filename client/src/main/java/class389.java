public class class389 extends class404 {
	int field4462;
	final class463 field4464;
	public class344 field4466;

	public class389(class463 var1) {
		super(400);
		this.field4462 = 1;
		this.field4466 = new class344();
		this.field4464 = var1;
	}

	class400 method7304() {
		return new class380();
	}

	class400[] method7306(int var1) {
		return new class380[var1];
	}

	public boolean method7017(class472 var1, boolean var2) {
		class380 var4 = (class380)this.method7289(var1);
		if (null == var4) {
			return false;
		} else {
			return !var2 || var4.field4491 != 0;
		}
	}

	public void method7018(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) {
				boolean var4 = var1.method8141() == 1;
				class472 var5 = new class472(var1.readString(), this.field4464);
				class472 var6 = new class472(var1.readString(), this.field4464);
				int var7 = var1.readUnsignedShort();
				int var8 = var1.method8141();
				int var9 = var1.method8141();
				boolean var10 = (var9 & 2) != 0;
				boolean var11 = (var9 & 1) != 0;
				if (var7 > 0) {
					var1.readString();
					var1.method8141();
					var1.method8126();
				}

				var1.readString();
				if (var5 != null && var5.method8449()) {
					class380 var12 = (class380)this.method7290(var5);
					if (var4) {
						class380 var13 = (class380)this.method7290(var6);
						if (var13 != null && var13 != var12) {
							if (var12 != null) {
								this.method7293(var13);
							} else {
								var12 = var13;
							}
						}
					}

					if (var12 != null) {
						this.method7347(var12, var5, var6);
						if (var7 != var12.field4491) {
							boolean var15 = true;

							for (class369 var14 = (class369)this.field4466.method6384(); var14 != null; var14 = (class369)this.field4466.method6381()) {
								if (var14.field4359.equals(var5)) {
									if (var7 != 0 && var14.field4360 == 0) {
										var14.method7811();
										var15 = false;
									} else if (var7 == 0 && var14.field4360 != 0) {
										var14.method7811();
										var15 = false;
									}
								}
							}

							if (var15) {
								this.field4466.method6382(new class369(var5, var7));
							}
						}
					} else {
						if (this.method7339() >= 400) {
							continue;
						}

						var12 = (class380)this.method7295(var5, var6);
					}

					if (var7 != var12.field4491) {
						var12.field4490 = ++this.field4462 - 1;
						if (var12.field4491 == -1 && var7 == 0) {
							var12.field4490 = -(var12.field4490 * 765902219) * 1732968995;
						}

						var12.field4491 = var7;
					}

					var12.field4492 = var8;
					var12.field4407 = var10;
					var12.field4408 = var11;
					continue;
				}

				throw new IllegalStateException();
			}

			this.method7297();
			return;
		}
	}

	public static class473 method7014(class319 var0, int var1, int var2) {
		byte[] var5 = var0.method6175(var1, var2);
		boolean var4;
		if (null == var5) {
			var4 = false;
		} else {
			class317.method6080(var5);
			var4 = true;
		}

		return !var4 ? null : class475.method603();
	}
}
