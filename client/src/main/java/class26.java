import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class class26 implements ThreadFactory {
	static class488[] field133;
	// $FF: synthetic field
	final class15 this$0;
	final ThreadGroup field129;
	final AtomicInteger field134;

	class26(class15 var1) {
		this.this$0 = var1;
		this.field134 = new AtomicInteger(1);
		SecurityManager var2 = System.getSecurityManager();
		this.field129 = var2 != null ? var2.getThreadGroup() : Thread.currentThread().getThreadGroup();
	}

	public Thread newThread(Runnable var1) {
		Thread var2 = new Thread(this.field129, var1, this.this$0.field72 + "-rest-request-" + this.field134.getAndIncrement(), 0L);
		var2.setDaemon(true);
		var2.setPriority(5);
		return var2;
	}

	static void method349(class300[] var0, class300 var1, boolean var2) {
		int var4 = 0 != var1.field3483 ? var1.field3483 : var1.field3448;
		int var5 = 0 != var1.field3492 ? var1.field3492 : var1.field3476;
		class256.method5126(var0, var1.field3517, var4, var5, var2);
		if (null != var1.field3602) {
			class256.method5126(var1.field3602, var1.field3517, var4, var5, var2);
		}

		InterfaceParent var6 = (InterfaceParent)client.parentInterfaces.method7855((long)var1.field3517);
		if (null != var6) {
			int var7 = var6.field796;
			if (class246.method4928(var7)) {
				class256.method5126(class300.field3593[var7], -1, var4, var5, var2);
			}
		}

		if (var1.field3464 == 1337) {
		}

	}
}
