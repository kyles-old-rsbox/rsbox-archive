import java.util.concurrent.ScheduledExecutorService;

public final class class339 {
	static ScheduledExecutorService field4217;

	class339() throws Throwable {
		throw new Error();
	}

	protected static final void method6315() {
		class352.field4282.method2748();

		int var1;
		for (var1 = 0; var1 < 32; ++var1) {
			class31.field176[var1] = 0L;
		}

		for (var1 = 0; var1 < 32; ++var1) {
			class31.field167[var1] = 0L;
		}

		class196.field2112 = 0;
	}

	static final void method6316() {
		PacketMessage var1 = class185.method3435(ClientPacket.field3140, client.serverConnection.isaacRandom);
		client.serverConnection.add(var1);
		class57.field411 = true;

		for (InterfaceParent var2 = (InterfaceParent)client.parentInterfaces.first(); var2 != null; var2 = (InterfaceParent)client.parentInterfaces.next()) {
			if (var2.field797 == 0 || 3 == var2.field797) {
				ProofOfWorkRequest.closeInterface(var2, true);
			}
		}

		if (null != client.field1641) {
			class136.method2438(client.field1641);
			client.field1641 = null;
		}

		class57.field411 = false;
	}
}
