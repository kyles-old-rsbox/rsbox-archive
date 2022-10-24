import java.util.Comparator;

final class class316 implements Comparator {
	int method6074(class328 var1, class328 var2) {
		return var1.field3806 < var2.field3806 ? -1 : (var1.field3806 == var2.field3806 ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.method6074((class328)var1, (class328)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
