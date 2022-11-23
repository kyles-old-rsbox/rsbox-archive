import java.util.HashSet;
import java.util.Set;

public class class346 implements class360 {
	static class376 field4250;
	static int field4251;
	static final class346 field4233;
	static final class346 field4234;
	static final class346 field4235;
	static final class346 field4236;
	static final class346 field4238;
	static final class346 field4239;
	static final class346 field4240;
	static final class346 field4241;
	static final class346 field4242;
	static final class346 field4244;
	static final class346 field4245;
	static final class346 field4247;
	static final class346 field4249;
	final int field4246;
	final Set field4237;

	static {
		field4242 = new class346("", 0, new class362[]{class362.field4319});
		field4234 = new class346("", 1, new class362[]{class362.field4316, class362.field4319});
		field4235 = new class346("", 2, new class362[]{class362.field4316, class362.field4318, class362.field4319});
		field4236 = new class346("", 3, new class362[]{class362.field4316});
		field4233 = new class346("", 4);
		field4238 = new class346("", 5, new class362[]{class362.field4316, class362.field4319});
		field4239 = new class346("", 6, new class362[]{class362.field4319});
		field4240 = new class346("", 8, new class362[]{class362.field4316, class362.field4319});
		field4247 = new class346("", 9, new class362[]{class362.field4316, class362.field4318});
		field4249 = new class346("", 10, new class362[]{class362.field4316});
		field4244 = new class346("", 11, new class362[]{class362.field4316});
		field4241 = new class346("", 12, new class362[]{class362.field4316, class362.field4319});
		field4245 = new class346("", 13, new class362[]{class362.field4316});
		method6403();
	}

	static class346[] method6403() {
		return new class346[]{field4236, field4238, field4241, field4247, field4242, field4249, field4233, field4244, field4234, field4235, field4240, field4239, field4245};
	}

	public static class158 method6404(int var0) {
		class158 var2 = (class158)class158.field1456.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = class158.field1452.method6175(33, var0);
			var2 = new class158();
			if (null != var3) {
				var2.method2623(new Buffer(var3));
			}

			class158.field1456.method5434(var2, (long)var0);
			return var2;
		}
	}

	class346(String var1, int var2) {
		this.field4237 = new HashSet();
		this.field4246 = var2;
	}

	class346(String var1, int var2, class362[] var3) {
		this.field4237 = new HashSet();
		this.field4246 = var2;
		class362[] var4 = var3;

		for (int var5 = 0; var5 < var4.length; ++var5) {
			class362 var6 = var4[var5];
			this.field4237.add(var6);
		}

	}

	public int rsOrdinal() {
		return this.field4246;
	}

	static int method6405(int var0, class78 var1, boolean var2) {
		int var4;
		if (var0 == CS2Opcodes._6600) {
			var4 = class55.field396;
			int var10 = (class291.localPlayer.field827 >> 7) + class36.field241;
			int var6 = (class291.localPlayer.field802 >> 7) + class169.field1536;
			client.method6324().method7597(var4, var10, var6, true);
			return 1;
		} else {
			class254 var12;
			if (var0 == CS2Opcodes.WORLDMAP_GETMAPNAME) {
				var4 = class57.field404[--class387.field4452];
				String var17 = "";
				var12 = client.method6324().method7603(var4);
				if (var12 != null) {
					var17 = var12.method5055();
				}

				class57.field405[++class126.field1220 - 1] = var17;
				return 1;
			} else if (var0 == CS2Opcodes.WORLDMAP_SETMAP) {
				var4 = class57.field404[--class387.field4452];
				client.method6324().method7616(var4);
				return 1;
			} else if (var0 == CS2Opcodes.WORLDMAP_GETZOOM) {
				class57.field404[++class387.field4452 - 1] = client.method6324().method7600();
				return 1;
			} else if (var0 == CS2Opcodes.WORLDMAP_SETZOOM) {
				var4 = class57.field404[--class387.field4452];
				client.method6324().method7585(var4);
				return 1;
			} else if (var0 == CS2Opcodes.WORLDMAP_ISLOADED) {
				class57.field404[++class387.field4452 - 1] = client.method6324().method7602() ? 1 : 0;
				return 1;
			} else {
				class295 var16;
				if (var0 == CS2Opcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
					var16 = new class295(class57.field404[--class387.field4452]);
					client.method6324().method7604(var16.field3376, var16.field3375);
					return 1;
				} else if (var0 == CS2Opcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
					var16 = new class295(class57.field404[--class387.field4452]);
					client.method6324().method7605(var16.field3376, var16.field3375);
					return 1;
				} else if (var0 == CS2Opcodes.WORLDMAP_JUMPTOSOURCECOORD) {
					var16 = new class295(class57.field404[--class387.field4452]);
					client.method6324().method7606(var16.field3374, var16.field3376, var16.field3375);
					return 1;
				} else if (var0 == CS2Opcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
					var16 = new class295(class57.field404[--class387.field4452]);
					client.method6324().method7607(var16.field3374, var16.field3376, var16.field3375);
					return 1;
				} else if (var0 == CS2Opcodes.WORLDMAP_GETDISPLAYPOSITION) {
					class57.field404[++class387.field4452 - 1] = client.method6324().method7608();
					class57.field404[++class387.field4452 - 1] = client.method6324().method7609();
					return 1;
				} else {
					class254 var14;
					if (var0 == CS2Opcodes.WORLDMAP_GETCONFIGORIGIN) {
						var4 = class57.field404[--class387.field4452];
						var14 = client.method6324().method7603(var4);
						if (var14 == null) {
							class57.field404[++class387.field4452 - 1] = 0;
						} else {
							class57.field404[++class387.field4452 - 1] = var14.method5064().method5522();
						}

						return 1;
					} else if (var0 == CS2Opcodes.WORLDMAP_GETCONFIGSIZE) {
						var4 = class57.field404[--class387.field4452];
						var14 = client.method6324().method7603(var4);
						if (null == var14) {
							class57.field404[++class387.field4452 - 1] = 0;
							class57.field404[++class387.field4452 - 1] = 0;
						} else {
							class57.field404[++class387.field4452 - 1] = (var14.method5059() - var14.method5124() + 1) * 64;
							class57.field404[++class387.field4452 - 1] = (var14.method5061() - var14.method5079() + 1) * 64;
						}

						return 1;
					} else if (var0 == CS2Opcodes.WORLDMAP_GETCONFIGBOUNDS) {
						var4 = class57.field404[--class387.field4452];
						var14 = client.method6324().method7603(var4);
						if (null == var14) {
							class57.field404[++class387.field4452 - 1] = 0;
							class57.field404[++class387.field4452 - 1] = 0;
							class57.field404[++class387.field4452 - 1] = 0;
							class57.field404[++class387.field4452 - 1] = 0;
						} else {
							class57.field404[++class387.field4452 - 1] = var14.method5124() * 64;
							class57.field404[++class387.field4452 - 1] = var14.method5079() * 64;
							class57.field404[++class387.field4452 - 1] = var14.method5059() * 64 + 64 - 1;
							class57.field404[++class387.field4452 - 1] = var14.method5061() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == CS2Opcodes.WORLDMAP_GETCONFIGZOOM) {
						var4 = class57.field404[--class387.field4452];
						var14 = client.method6324().method7603(var4);
						if (null == var14) {
							class57.field404[++class387.field4452 - 1] = -1;
						} else {
							class57.field404[++class387.field4452 - 1] = var14.method5057();
						}

						return 1;
					} else if (var0 == CS2Opcodes._6615) {
						var16 = client.method6324().method7610();
						if (var16 == null) {
							class57.field404[++class387.field4452 - 1] = -1;
							class57.field404[++class387.field4452 - 1] = -1;
						} else {
							class57.field404[++class387.field4452 - 1] = var16.field3376;
							class57.field404[++class387.field4452 - 1] = var16.field3375;
						}

						return 1;
					} else if (var0 == CS2Opcodes.WORLDMAP_GETCURRENTMAP) {
						class57.field404[++class387.field4452 - 1] = client.method6324().method7583();
						return 1;
					} else if (var0 == CS2Opcodes.WORLDMAP_GETDISPLAYCOORD) {
						var16 = new class295(class57.field404[--class387.field4452]);
						var14 = client.method6324().method7588();
						if (var14 == null) {
							class57.field404[++class387.field4452 - 1] = -1;
							class57.field404[++class387.field4452 - 1] = -1;
							return 1;
						} else {
							int[] var15 = var14.method5049(var16.field3374, var16.field3376, var16.field3375);
							if (null == var15) {
								class57.field404[++class387.field4452 - 1] = -1;
								class57.field404[++class387.field4452 - 1] = -1;
							} else {
								class57.field404[++class387.field4452 - 1] = var15[0];
								class57.field404[++class387.field4452 - 1] = var15[1];
							}

							return 1;
						}
					} else {
						class295 var8;
						if (var0 == CS2Opcodes._6618) {
							var16 = new class295(class57.field404[--class387.field4452]);
							var14 = client.method6324().method7588();
							if (null == var14) {
								class57.field404[++class387.field4452 - 1] = -1;
								class57.field404[++class387.field4452 - 1] = -1;
								return 1;
							} else {
								var8 = var14.method5100(var16.field3376, var16.field3375);
								if (null == var8) {
									class57.field404[++class387.field4452 - 1] = -1;
								} else {
									class57.field404[++class387.field4452 - 1] = var8.method5522();
								}

								return 1;
							}
						} else {
							class295 var13;
							if (var0 == CS2Opcodes._6619) {
								class387.field4452 -= 2;
								var4 = class57.field404[class387.field4452];
								var13 = new class295(class57.field404[class387.field4452 + 1]);
								class57.method6325(var4, var13, false);
								return 1;
							} else if (var0 == CS2Opcodes._6620) {
								class387.field4452 -= 2;
								var4 = class57.field404[class387.field4452];
								var13 = new class295(class57.field404[1 + class387.field4452]);
								class57.method6325(var4, var13, true);
								return 1;
							} else if (var0 == CS2Opcodes.WORLDMAP_COORDINMAP) {
								class387.field4452 -= 2;
								var4 = class57.field404[class387.field4452];
								var13 = new class295(class57.field404[1 + class387.field4452]);
								var12 = client.method6324().method7603(var4);
								if (var12 == null) {
									class57.field404[++class387.field4452 - 1] = 0;
									return 1;
								} else {
									class57.field404[++class387.field4452 - 1] = var12.method5083(var13.field3374, var13.field3376, var13.field3375) ? 1 : 0;
									return 1;
								}
							} else if (var0 == CS2Opcodes.WORLDMAP_GETSIZE) {
								class57.field404[++class387.field4452 - 1] = client.method6324().method7611();
								class57.field404[++class387.field4452 - 1] = client.method6324().method7612();
								return 1;
							} else if (var0 == CS2Opcodes._6623) {
								var16 = new class295(class57.field404[--class387.field4452]);
								var14 = client.method6324().method7714(var16.field3374, var16.field3376, var16.field3375);
								if (null == var14) {
									class57.field404[++class387.field4452 - 1] = -1;
								} else {
									class57.field404[++class387.field4452 - 1] = var14.method5063();
								}

								return 1;
							} else if (var0 == CS2Opcodes._6624) {
								client.method6324().method7613(class57.field404[--class387.field4452]);
								return 1;
							} else if (var0 == CS2Opcodes._6625) {
								client.method6324().method7598();
								return 1;
							} else if (var0 == CS2Opcodes._6626) {
								client.method6324().method7615(class57.field404[--class387.field4452]);
								return 1;
							} else if (var0 == CS2Opcodes._6627) {
								client.method6324().method7645();
								return 1;
							} else {
								boolean var11;
								if (var0 == CS2Opcodes.WORLDMAP_PERPETUALFLASH) {
									var11 = class57.field404[--class387.field4452] == 1;
									client.method6324().method7707(var11);
									return 1;
								} else if (var0 == CS2Opcodes.WORLDMAP_FLASHELEMENT) {
									var4 = class57.field404[--class387.field4452];
									client.method6324().method7765(var4);
									return 1;
								} else if (var0 == CS2Opcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
									var4 = class57.field404[--class387.field4452];
									client.method6324().method7731(var4);
									return 1;
								} else if (var0 == CS2Opcodes.WORLDMAP_STOPCURRENTFLASHES) {
									client.method6324().method7620();
									return 1;
								} else if (var0 == CS2Opcodes.WORLDMAP_DISABLEELEMENTS) {
									var11 = class57.field404[--class387.field4452] == 1;
									client.method6324().method7621(var11);
									return 1;
								} else {
									boolean var5;
									if (var0 == CS2Opcodes.WORLDMAP_DISABLEELEMENT) {
										class387.field4452 -= 2;
										var4 = class57.field404[class387.field4452];
										var5 = class57.field404[1 + class387.field4452] == 1;
										client.method6324().method7622(var4, var5);
										return 1;
									} else if (var0 == CS2Opcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
										class387.field4452 -= 2;
										var4 = class57.field404[class387.field4452];
										var5 = 1 == class57.field404[1 + class387.field4452];
										client.method6324().method7623(var4, var5);
										return 1;
									} else if (var0 == CS2Opcodes.WORLDMAP_GETDISABLEELEMENTS) {
										class57.field404[++class387.field4452 - 1] = client.method6324().method7624() ? 1 : 0;
										return 1;
									} else if (var0 == CS2Opcodes.WORLDMAP_GETDISABLEELEMENT) {
										var4 = class57.field404[--class387.field4452];
										class57.field404[++class387.field4452 - 1] = client.method6324().method7625(var4) ? 1 : 0;
										return 1;
									} else if (var0 == CS2Opcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
										var4 = class57.field404[--class387.field4452];
										class57.field404[++class387.field4452 - 1] = client.method6324().method7626(var4) ? 1 : 0;
										return 1;
									} else if (var0 == CS2Opcodes._6638) {
										class387.field4452 -= 2;
										var4 = class57.field404[class387.field4452];
										var13 = new class295(class57.field404[1 + class387.field4452]);
										var8 = client.method6324().method7629(var4, var13);
										if (var8 == null) {
											class57.field404[++class387.field4452 - 1] = -1;
										} else {
											class57.field404[++class387.field4452 - 1] = var8.method5522();
										}

										return 1;
									} else {
										class251 var9;
										if (var0 == CS2Opcodes.WORLDMAP_LISTELEMENT_START) {
											var9 = client.method6324().method7631();
											if (var9 == null) {
												class57.field404[++class387.field4452 - 1] = -1;
												class57.field404[++class387.field4452 - 1] = -1;
											} else {
												class57.field404[++class387.field4452 - 1] = var9.method5024();
												class57.field404[++class387.field4452 - 1] = var9.field2915.method5522();
											}

											return 1;
										} else if (var0 == CS2Opcodes.WORLDMAP_LISTELEMENT_NEXT) {
											var9 = client.method6324().method7718();
											if (var9 == null) {
												class57.field404[++class387.field4452 - 1] = -1;
												class57.field404[++class387.field4452 - 1] = -1;
											} else {
												class57.field404[++class387.field4452 - 1] = var9.method5024();
												class57.field404[++class387.field4452 - 1] = var9.field2915.method5522();
											}

											return 1;
										} else {
											class160 var7;
											if (var0 == CS2Opcodes.MEC_TEXT) {
												var4 = class57.field404[--class387.field4452];
												var7 = class90.method1885(var4);
												if (null == var7.field1470) {
													class57.field405[++class126.field1220 - 1] = "";
												} else {
													class57.field405[++class126.field1220 - 1] = var7.field1470;
												}

												return 1;
											} else if (var0 == CS2Opcodes.MEC_TEXTSIZE) {
												var4 = class57.field404[--class387.field4452];
												var7 = class90.method1885(var4);
												class57.field404[++class387.field4452 - 1] = var7.field1472;
												return 1;
											} else if (var0 == CS2Opcodes.MEC_CATEGORY) {
												var4 = class57.field404[--class387.field4452];
												var7 = class90.method1885(var4);
												if (var7 == null) {
													class57.field404[++class387.field4452 - 1] = -1;
												} else {
													class57.field404[++class387.field4452 - 1] = var7.field1487;
												}

												return 1;
											} else if (var0 == CS2Opcodes.MEC_SPRITE) {
												var4 = class57.field404[--class387.field4452];
												var7 = class90.method1885(var4);
												if (var7 == null) {
													class57.field404[++class387.field4452 - 1] = -1;
												} else {
													class57.field404[++class387.field4452 - 1] = var7.field1468;
												}

												return 1;
											} else if (var0 == CS2Opcodes.WORLDMAP_ELEMENT) {
												class57.field404[++class387.field4452 - 1] = class64.field504.field2860;
												return 1;
											} else if (var0 == CS2Opcodes._6698) {
												class57.field404[++class387.field4452 - 1] = class64.field504.field2861.method5522();
												return 1;
											} else if (var0 == CS2Opcodes.WORLDMAP_ELEMENTCOORD) {
												class57.field404[++class387.field4452 - 1] = class64.field504.field2862.method5522();
												return 1;
											} else {
												return 2;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	static void method6400(class188 var0) {
		if (null != var0 && var0.field1984 != null) {
			if (var0.field1984.field3484 >= 0) {
				class300 var2 = class282.method5426(var0.field1984.field3596);
				if (var2 == null || null == var2.field3602 || 0 == var2.field3602.length || var0.field1984.field3484 >= var2.field3602.length || var2.field3602[var0.field1984.field3484] != var0.field1984) {
					return;
				}
			}

			if (11 == var0.field1984.field3462 && 0 == var0.field1983) {
				switch(var0.field1984.method5870()) {
				case 0:
					class115.method2229(var0.field1984.method5872(), true, false);
					break;
				case 1:
					if (class242.method4733(class190.method3528(var0.field1984))) {
						int[] var5 = var0.field1984.method5933();
						if (var5 != null) {
							PacketBufferNode var3 = class185.method3435(class274.field3146, client.packetWriter.isaacRandom);
							var3.buffer.writeIntAlt(var5[2]);
							var3.buffer.writeInt(var0.field1984.field3517);
							var3.buffer.writeIntAlt(var0.field1984.method5871());
							var3.buffer.writeShort(var0.field1984.field3484);
							var3.buffer.writeIntLE(var5[1]);
							var3.buffer.writeIntLE(var5[0]);
							client.packetWriter.add(var3);
						}
					}
				}
			} else if (12 == var0.field1984.field3462) {
				class297 var4 = var0.field1984.method5877();
				if (null != var4 && var4.method5612()) {
					switch(var0.field1983) {
					case 0:
						client.field1877.method3515(var0.field1984);
						var4.method5560(true);
						var4.method5599(var0.field1987, var0.field1980, client.field1876.method3895(82), client.field1876.method3895(81));
						break;
					case 1:
						var4.method5600(var0.field1987, var0.field1980);
					}
				}
			}

		}
	}
}
