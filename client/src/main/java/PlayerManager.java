public class PlayerManager {
	static byte[] skipFlags;
	static MoveSpeed[] moveSpeeds;
	static Buffer field1021;
	static Buffer[] cachedAppearanceData;
	static int extendedInfoCount;
	static int localPlayerCount;
	static int externalPlayerCount;
	static int[] localPlayerIndexes;
	static int[] field1014;
	static int[] externalPlayerIndexes;
	static int[] field1016;
	static int[] field1018;
	static int[] field1020;
	static short[] field1009;

	static {
		skipFlags = new byte[2048];
		moveSpeeds = new MoveSpeed[2048];
		cachedAppearanceData = new Buffer[2048];
		localPlayerCount = 0;
		localPlayerIndexes = new int[2048];
		externalPlayerCount = 0;
		externalPlayerIndexes = new int[2048];
		field1016 = new int[2048];
		field1014 = new int[2048];
		field1018 = new int[2048];
		extendedInfoCount = 0;
		field1020 = new int[2048];
		field1021 = new Buffer(new byte[5000]);
	}

	PlayerManager() throws Throwable {
		throw new Error();
	}

	static final void updateGPI(PacketBuffer var0) {
		var0.setBitMode();
		int var2 = client.localPlayerIndex;
		PlayerEntity var3 = class291.localPlayer = client.localPlayers[var2] = new PlayerEntity();
		var3.field915 = var2;
		int var4 = var0.readBits(30);
		byte var5 = (byte)(var4 >> 28);
		int var6 = var4 >> 14 & 16383;
		int var7 = var4 & 16383;
		var3.field861[0] = var6 - class36.sceneBaseX;
		var3.field827 = (var3.field861[0] << 7) + (var3.method1916() << 6);
		var3.field873[0] = var7 - class169.sceneBaseY;
		var3.field802 = (var3.field873[0] << 7) + (var3.method1916() << 6);
		class55.field396 = var3.field914 = var5;
		if (null != cachedAppearanceData[var2]) {
			var3.decodeAppearance(cachedAppearanceData[var2]);
		}

		localPlayerCount = 0;
		localPlayerIndexes[++localPlayerCount - 1] = var2;
		skipFlags[var2] = 0;
		externalPlayerCount = 0;

		for (int var8 = 1; var8 < 2048; ++var8) {
			if (var2 != var8) {
				int var9 = var0.readBits(18);
				int var10 = var9 >> 16;
				int var11 = var9 >> 8 & 597;
				int var12 = var9 & 597;
				field1016[var8] = (var11 << 14) + (var10 << 28) + var12;
				field1014[var8] = 0;
				field1018[var8] = -1;
				externalPlayerIndexes[++externalPlayerCount - 1] = var8;
				skipFlags[var8] = 0;
			}
		}

		var0.setByteMode();
	}
}
