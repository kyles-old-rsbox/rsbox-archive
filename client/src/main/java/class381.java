public class class381 extends class404 {
	final class463 field4410;

	public class381(class463 var1) {
		super(400);
		this.field4410 = var1;
	}

	class400 method7304() {
		return new class398();
	}

	class400[] method7306(int var1) {
		return new class398[var1];
	}

	public void method6824(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) {
				int var4 = var1.method8141();
				boolean var5 = (var4 & 1) == 1;
				class472 var6 = new class472(var1.readString(), this.field4410);
				class472 var7 = new class472(var1.readString(), this.field4410);
				var1.readString();
				if (null != var6 && var6.method8449()) {
					class398 var8 = (class398)this.method7290(var6);
					if (var5) {
						class398 var9 = (class398)this.method7290(var7);
						if (var9 != null && var8 != var9) {
							if (null != var8) {
								this.method7293(var9);
							} else {
								var8 = var9;
							}
						}
					}

					if (var8 != null) {
						this.method7347(var8, var6, var7);
						continue;
					}

					if (this.method7339() < 400) {
						int var10 = this.method7339();
						var8 = (class398)this.method7295(var6, var7);
						var8.field4501 = var10;
					}
					continue;
				}

				throw new IllegalStateException();
			}

			return;
		}
	}
}
