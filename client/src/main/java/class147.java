import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class class147 extends class427 {
	static class336 field1352;
	static SecureRandom isaacRandom;
	boolean field1346;
	boolean field1353;
	int[] field1348;
	long field1349;
	public byte field1345;
	public byte field1351;
	public String field1350;
	public List field1347;

	static {
		new BitSet(65536);
	}

	public class147(Buffer var1) {
		this.field1346 = true;
		this.field1350 = null;
		this.method2506(var1);
	}

	public int[] method2502() {
		if (null == this.field1348) {
			String[] var2 = new String[this.field1347.size()];
			this.field1348 = new int[this.field1347.size()];

			for (int var3 = 0; var3 < this.field1347.size(); this.field1348[var3] = var3++) {
				var2[var3] = ((class133)this.field1347.get(var3)).field1254.method8448();
			}

			class446.method2038(var2, this.field1348);
		}

		return this.field1348;
	}

	void method2516(class133 var1) {
		this.field1347.add(var1);
		this.field1348 = null;
	}

	void method2504(int var1) {
		this.field1347.remove(var1);
		this.field1348 = null;
	}

	public int method2512() {
		return this.field1347.size();
	}

	public int method2505(String var1) {
		if (!this.field1346) {
			throw new RuntimeException("Displaynames not available");
		} else {
			for (int var3 = 0; var3 < this.field1347.size(); ++var3) {
				if (((class133)this.field1347.get(var3)).field1254.getName().equalsIgnoreCase(var1)) {
					return var3;
				}
			}

			return -1;
		}
	}

	void method2506(Buffer var1) {
		int var3 = var1.readUnsignedByte();
		if ((var3 & 1) != 0) {
			this.field1353 = true;
		}

		if (0 != (var3 & 2)) {
			this.field1346 = true;
		}

		int var4 = 2;
		if ((var3 & 4) != 0) {
			var4 = var1.readUnsignedByte();
		}

		super.field4681 = var1.readLong();
		this.field1349 = var1.readLong();
		this.field1350 = var1.readString();
		var1.readBoolean();
		this.field1351 = var1.readByte();
		this.field1345 = var1.readByte();
		int var5 = var1.readUnsignedShort();
		if (var5 > 0) {
			this.field1347 = new ArrayList(var5);

			for (int var6 = 0; var6 < var5; ++var6) {
				class133 var7 = new class133();
				if (this.field1353) {
					var1.readLong();
				}

				if (this.field1346) {
					var7.field1254 = new DisplayName(var1.readString());
				}

				var7.field1256 = var1.readByte();
				var7.field1249 = var1.readUnsignedShort();
				if (var4 >= 3) {
					var1.readBoolean();
				}

				this.field1347.add(var6, var7);
			}
		}

	}

	static final void method2521(int var0) {
		class198.method3654();
		class72.method1475();
		int var2 = ClientPacket.method5221(var0).field1591;
		if (var2 != 0) {
			int var3 = class293.field3370[var0];
			if (var2 == 1) {
				if (var3 == 1) {
					client.method3634(0.9D);
				}

				if (var3 == 2) {
					client.method3634(0.8D);
				}

				if (var3 == 3) {
					client.method3634(0.7D);
				}

				if (var3 == 4) {
					client.method3634(0.6D);
				}
			}

			if (var2 == 3) {
				if (var3 == 0) {
					class17.method198(255);
				}

				if (var3 == 1) {
					class17.method198(192);
				}

				if (var3 == 2) {
					class17.method198(128);
				}

				if (var3 == 3) {
					class17.method198(64);
				}

				if (var3 == 4) {
					class17.method198(0);
				}
			}

			if (var2 == 4) {
				if (var3 == 0) {
					client.method1354(127);
				}

				if (var3 == 1) {
					client.method1354(96);
				}

				if (var3 == 2) {
					client.method1354(64);
				}

				if (var3 == 3) {
					client.method1354(32);
				}

				if (var3 == 4) {
					client.method1354(0);
				}
			}

			if (var2 == 5) {
				client.field1862 = var3 == 1;
			}

			if (var2 == 6) {
				client.field1753 = var3;
			}

			if (var2 == 9) {
				client.field1814 = var3;
			}

			if (var2 == 10) {
				if (var3 == 0) {
					client.method6049(127);
				}

				if (var3 == 1) {
					client.method6049(96);
				}

				if (var3 == 2) {
					client.method6049(64);
				}

				if (var3 == 3) {
					client.method6049(32);
				}

				if (var3 == 4) {
					client.method6049(0);
				}
			}

			if (var2 == 17) {
				client.followerIndex = var3 & 65535;
			}

			if (var2 == 18) {
				client.playerAttackOption = (AttackOption)class217.fromValue(AttackOption.method1045(), var3);
				if (client.playerAttackOption == null) {
					client.playerAttackOption = AttackOption.field705;
				}
			}

			if (var2 == 19) {
				if (var3 == -1) {
					client.combatTargetPlayerIndex = -1;
				} else {
					client.combatTargetPlayerIndex = var3 & 2047;
				}
			}

			if (var2 == 22) {
				client.npcAttackOption = (AttackOption)class217.fromValue(AttackOption.method1045(), var3);
				if (client.npcAttackOption == null) {
					client.npcAttackOption = AttackOption.field705;
				}
			}

		}
	}
}
