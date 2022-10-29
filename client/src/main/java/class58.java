import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class class58 {
	static class336 field417;
	ExecutorService field419;
	Future field418;

	class58() {
		this.field419 = Executors.newSingleThreadExecutor();
		this.field418 = this.field419.submit(new class85());
	}

	void method1277() {
		this.field419.shutdown();
		this.field419 = null;
	}

	boolean method1278() {
		return this.field418.isDone();
	}

	SecureRandom method1289() {
		try {
			return (SecureRandom)this.field418.get();
		} catch (Exception var3) {
			return class18.method219();
		}
	}

	static final void method1276(class51 var0) {
		var0.field359 = false;
		if (var0.field358 != null) {
			var0.field358.field398 = 0;
		}

		for (class51 var2 = var0.method1007(); var2 != null; var2 = var0.method1004()) {
			method1276(var2);
		}

	}
}
