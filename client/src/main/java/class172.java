import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class class172 implements Runnable {
	public static String field1552;
	public static String field1559;
	public static short[] field1551;
	boolean field1557;
	class181 field1554;
	class181 field1556;
	Thread field1555;

	public class172() {
		this.field1556 = null;
		this.field1554 = null;
		this.field1557 = false;
		field1559 = "Unknown";
		field1552 = "1.6";

		try {
			field1559 = System.getProperty("java.vendor");
			field1552 = System.getProperty("java.version");
		} catch (Exception var2) {
		}

		this.field1557 = false;
		this.field1555 = new Thread(this);
		this.field1555.setPriority(10);
		this.field1555.setDaemon(true);
		this.field1555.start();
	}

	public final void method2721() {
		synchronized(this) {
			this.field1557 = true;
			this.notifyAll();
		}

		try {
			this.field1555.join();
		} catch (InterruptedException var4) {
		}

	}

	public final void run() {
		while (true) {
			class181 var1;
			synchronized(this) {
				while (true) {
					if (this.field1557) {
						return;
					}

					if (this.field1556 != null) {
						var1 = this.field1556;
						this.field1556 = this.field1556.field1616;
						if (null == this.field1556) {
							this.field1554 = null;
						}
						break;
					}

					try {
						this.wait();
					} catch (InterruptedException var8) {
					}
				}
			}

			try {
				int var5 = var1.field1618;
				if (var5 == 1) {
					var1.socket = new Socket(InetAddress.getByName((String)var1.field1617), var1.field1611);
				} else if (var5 == 2) {
					Thread var3 = new Thread((Runnable)var1.field1617);
					var3.setDaemon(true);
					var3.start();
					var3.setPriority(var1.field1611);
					var1.socket = var3;
				} else if (var5 == 4) {
					var1.socket = new DataInputStream(((URL)var1.field1617).openStream());
				}

				var1.field1614 = 1;
			} catch (ThreadDeath var6) {
				throw var6;
			} catch (Throwable var7) {
				var1.field1614 = 2;
			}
		}
	}

	static final void updatePlayerInfo(PacketBuffer buf) {
		int skipCount = 0;
		buf.setBitMode();

		byte[] skipFlags;
		int i;
		int playerIndex;
		int var5;
		for (i = 0; i < PlayerManager.localPlayerCount; ++i) {
			playerIndex = PlayerManager.localPlayerIndexes[i];
			if ((PlayerManager.skipFlags[playerIndex] & 1) == 0) {
				if (skipCount > 0) {
					--skipCount;
					skipFlags = PlayerManager.skipFlags;
					skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
				} else {
					var5 = buf.readBits(1);
					if (var5 == 0) {
						skipCount = class57.readSkipCount(buf);
						skipFlags = PlayerManager.skipFlags;
						skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
					} else {
						class62.decodeLocalPlayersGpi(buf, playerIndex);
					}
				}
			}
		}

		buf.setByteMode();
		if (skipCount != 0) {
			throw new RuntimeException();
		} else {
			buf.setBitMode();

			for (i = 0; i < PlayerManager.localPlayerCount; ++i) {
				playerIndex = PlayerManager.localPlayerIndexes[i];
				if ((PlayerManager.skipFlags[playerIndex] & 1) != 0) {
					if (skipCount > 0) {
						--skipCount;
						skipFlags = PlayerManager.skipFlags;
						skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
					} else {
						var5 = buf.readBits(1);
						if (var5 == 0) {
							skipCount = class57.readSkipCount(buf);
							skipFlags = PlayerManager.skipFlags;
							skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
						} else {
							class62.decodeLocalPlayersGpi(buf, playerIndex);
						}
					}
				}
			}

			buf.setByteMode();
			if (skipCount != 0) {
				throw new RuntimeException();
			} else {
				buf.setBitMode();

				for (i = 0; i < PlayerManager.externalPlayerCount; ++i) {
					playerIndex = PlayerManager.externalPlayerIndexes[i];
					if (0 != (PlayerManager.skipFlags[playerIndex] & 1)) {
						if (skipCount > 0) {
							--skipCount;
							skipFlags = PlayerManager.skipFlags;
							skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
						} else {
							var5 = buf.readBits(1);
							if (var5 == 0) {
								skipCount = class57.readSkipCount(buf);
								skipFlags = PlayerManager.skipFlags;
								skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
							} else if (class399.decodeExternalPlayersGpi(buf, playerIndex)) {
								skipFlags = PlayerManager.skipFlags;
								skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
							}
						}
					}
				}

				buf.setByteMode();
				if (skipCount != 0) {
					throw new RuntimeException();
				} else {
					buf.setBitMode();

					for (i = 0; i < PlayerManager.externalPlayerCount; ++i) {
						playerIndex = PlayerManager.externalPlayerIndexes[i];
						if ((PlayerManager.skipFlags[playerIndex] & 1) == 0) {
							if (skipCount > 0) {
								--skipCount;
								skipFlags = PlayerManager.skipFlags;
								skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
							} else {
								var5 = buf.readBits(1);
								if (var5 == 0) {
									skipCount = class57.readSkipCount(buf);
									skipFlags = PlayerManager.skipFlags;
									skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
								} else if (class399.decodeExternalPlayersGpi(buf, playerIndex)) {
									skipFlags = PlayerManager.skipFlags;
									skipFlags[playerIndex] = (byte)(skipFlags[playerIndex] | 2);
								}
							}
						}
					}

					buf.setByteMode();
					if (skipCount != 0) {
						throw new RuntimeException();
					} else {
						PlayerManager.localPlayerCount = 0;
						PlayerManager.externalPlayerCount = 0;

						for (i = 1; i < 2048; ++i) {
							skipFlags = PlayerManager.skipFlags;
							skipFlags[i] = (byte)(skipFlags[i] >> 1);
							PlayerEntity var6 = client.localPlayers[i];
							if (var6 != null) {
								PlayerManager.localPlayerIndexes[++PlayerManager.localPlayerCount - 1] = i;
							} else {
								PlayerManager.externalPlayerIndexes[++PlayerManager.externalPlayerCount - 1] = i;
							}
						}

					}
				}
			}
		}
	}

	final class181 method2722(int var1, int var2, int var3, Object var4) {
		class181 var6 = new class181();
		var6.field1618 = var1;
		var6.field1611 = var2;
		var6.field1617 = var4;
		synchronized(this) {
			if (null != this.field1554) {
				this.field1554.field1616 = var6;
				this.field1554 = var6;
			} else {
				this.field1554 = this.field1556 = var6;
			}

			this.notify();
			return var6;
		}
	}

	public final class181 method2723(String var1, int var2) {
		return this.method2722(1, var2, 0, var1);
	}

	public final class181 method2731(Runnable var1, int var2) {
		return this.method2722(2, var2, 0, var1);
	}
}
