public class class438 {
	public final Object field4727;
	public final Object field4728;

	public class438(Object var1, Object var2) {
		this.field4727 = var1;
		this.field4728 = var2;
	}

	public String toString() {
		return this.field4727 + ", " + this.field4728;
	}

	public boolean equals(Object var1) {
		if (var1 != null && var1 instanceof class438) {
			class438 var2 = (class438)var1;
			if (this.field4727 == null) {
				if (null != var2.field4727) {
					return false;
				}
			} else if (!this.field4727.equals(var2.field4727)) {
				return false;
			}

			if (null == this.field4728) {
				if (null != var2.field4728) {
					return false;
				}
			} else if (!this.field4728.equals(var2.field4728)) {
				return false;
			}

			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		int var1 = 0;
		if (this.field4727 != null) {
			var1 += this.field4727.hashCode();
		}

		if (this.field4728 != null) {
			var1 += 31 * this.field4728.hashCode();
		}

		return var1;
	}
}
