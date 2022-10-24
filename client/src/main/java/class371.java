public final class class371 implements Comparable {
	static class336 field4369;
	Object field4370;
	Object field4374;
	long field4371;
	long field4373;

	class371(Object var1, Object var2) {
		this.field4374 = var1;
		this.field4370 = var2;
	}

	int method6739(class371 var1) {
		if (this.field4373 < var1.field4373) {
			return -1;
		} else {
			return this.field4373 > var1.field4373 ? 1 : 0;
		}
	}

	public boolean equals(Object var1) {
		if (var1 instanceof class371) {
			return this.field4370.equals(((class371)var1).field4370);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int hashCode() {
		return this.field4370.hashCode();
	}

	public int compareTo(Object var1) {
		return this.method6739((class371)var1);
	}
}
