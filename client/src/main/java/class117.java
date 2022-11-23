public class class117 extends class393 {
	final boolean field1139;

	public class117(boolean var1) {
		this.field1139 = var1;
	}

	int method2251(class396 var1, class396 var2) {
		if (var1.field4491 == client.worldId && client.worldId == var2.field4491) {
			return this.field1139 ? var1.method7232().method8457(var2.method7232()) : var2.method7232().method8457(var1.method7232());
		} else {
			return this.method7162(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method2251((class396)var1, (class396)var2);
	}

	static final void method2256(PlayerEntity var0, int var1, int var2, int var3) {
		if (class291.localPlayer != var0) {
			if (client.menuOptionsCount < 400) {
				String var5;
				int var8;
				if (0 == var0.totalLevel) {
					String var6 = var0.actions[0] + var0.displayName + var0.actions[1];
					var8 = var0.combatLevel;
					int var9 = class291.localPlayer.combatLevel;
					int var10 = var9 - var8;
					String var7;
					if (var10 < -9) {
						var7 = class96.method4510(16711680);
					} else if (var10 < -6) {
						var7 = class96.method4510(16723968);
					} else if (var10 < -3) {
						var7 = class96.method4510(16740352);
					} else if (var10 < 0) {
						var7 = class96.method4510(16756736);
					} else if (var10 > 9) {
						var7 = class96.method4510(65280);
					} else if (var10 > 6) {
						var7 = class96.method4510(4259584);
					} else if (var10 > 3) {
						var7 = class96.method4510(8453888);
					} else if (var10 > 0) {
						var7 = class96.method4510(12648192);
					} else {
						var7 = class96.method4510(16776960);
					}

					var5 = var6 + var7 + " " + class96.field964 + class338.field4060 + var0.combatLevel + class96.field958 + var0.actions[2];
				} else {
					var5 = var0.actions[0] + var0.displayName + var0.actions[1] + " " + class96.field964 + class338.field4061 + var0.totalLevel + class96.field958 + var0.actions[2];
				}

				int var11;
				if (client.isItemSelected == 1) {
					client.method351(class338.field3898, client.field1803 + " " + class96.field963 + " " + class96.method4510(16777215) + var5, 14, var1, var2, var3);
				} else if (client.isSpellSelected) {
					if ((class120.field1161 & 8) == 8) {
						client.method351(client.field1653, client.field1754 + " " + class96.field963 + " " + class96.method4510(16777215) + var5, 15, var1, var2, var3);
					}
				} else {
					for (var11 = 7; var11 >= 0; --var11) {
						if (null != client.playerMenuActions[var11]) {
							short var12 = 0;
							if (client.playerMenuActions[var11].equalsIgnoreCase(class338.field4056)) {
								if (client.playerAttackOption == AttackOption.HIDDEN) {
									continue;
								}

								if (client.playerAttackOption == AttackOption.field698 || client.playerAttackOption == AttackOption.field705 && var0.combatLevel > class291.localPlayer.combatLevel) {
									var12 = 2000;
								}

								if (0 != class291.localPlayer.team && var0.team != 0) {
									if (var0.team == class291.localPlayer.team) {
										var12 = 2000;
									} else {
										var12 = 0;
									}
								} else if (AttackOption.field701 == client.playerAttackOption && var0.method1951()) {
									var12 = 2000;
								}
							} else if (client.playerOptionsPriorities[var11]) {
								var12 = 2000;
							}

							boolean var13 = false;
							var8 = client.field1771[var11] + var12;
							client.method351(client.playerMenuActions[var11], class96.method4510(16777215) + var5, var8, var1, var2, var3);
						}
					}
				}

				for (var11 = 0; var11 < client.menuOptionsCount; ++var11) {
					if (client.field1788[var11] == 23) {
						client.field1923[var11] = class96.method4510(16777215) + var5;
						break;
					}
				}

			}
		}
	}
}
