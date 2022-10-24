import java.lang.ref.SoftReference;

public class class268 extends class285 {
	SoftReference field3009;

	class268(Object var1, int var2) {
		super(var2);
		this.field3009 = new SoftReference(var1);
	}

	Object method5448() {
		return this.field3009.get();
	}

	boolean method5447() {
		return true;
	}
}
