import java.io.IOException;

public class class107 {
	boolean field1067;
	ServerPacket field1072;
	ServerPacket serverPacket;
	ServerPacket field1079;
	ServerPacket field1080;
	class350 field1068;
	AbstractSocket field1074;
	PacketBuffer buffer;
	Buffer field1078;
	int field1069;
	int field1070;
	int serverPacketLength;
	int field1077;
	public IsaacRandom isaacRandom;

	public static byte method2099(char var0) {
		byte var2;
		if (var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
			var2 = (byte)var0;
		} else if (var0 == 8364) {
			var2 = -128;
		} else if (var0 == 8218) {
			var2 = -126;
		} else if (var0 == 402) {
			var2 = -125;
		} else if (var0 == 8222) {
			var2 = -124;
		} else if (var0 == 8230) {
			var2 = -123;
		} else if (var0 == 8224) {
			var2 = -122;
		} else if (var0 == 8225) {
			var2 = -121;
		} else if (var0 == 710) {
			var2 = -120;
		} else if (var0 == 8240) {
			var2 = -119;
		} else if (var0 == 352) {
			var2 = -118;
		} else if (var0 == 8249) {
			var2 = -117;
		} else if (var0 == 338) {
			var2 = -116;
		} else if (var0 == 381) {
			var2 = -114;
		} else if (var0 == 8216) {
			var2 = -111;
		} else if (var0 == 8217) {
			var2 = -110;
		} else if (var0 == 8220) {
			var2 = -109;
		} else if (var0 == 8221) {
			var2 = -108;
		} else if (var0 == 8226) {
			var2 = -107;
		} else if (var0 == 8211) {
			var2 = -106;
		} else if (var0 == 8212) {
			var2 = -105;
		} else if (var0 == 732) {
			var2 = -104;
		} else if (var0 == 8482) {
			var2 = -103;
		} else if (var0 == 353) {
			var2 = -102;
		} else if (var0 == 8250) {
			var2 = -101;
		} else if (var0 == 339) {
			var2 = -100;
		} else if (var0 == 382) {
			var2 = -98;
		} else if (var0 == 376) {
			var2 = -97;
		} else {
			var2 = 63;
		}

		return var2;
	}

	class107() {
		this.field1068 = new class350();
		this.field1069 = 0;
		this.field1078 = new Buffer(5000);
		this.buffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1067 = true;
		this.field1070 = 0;
		this.field1077 = 0;
	}

	final void reset() {
		this.field1068.method6473();
		this.field1069 = 0;
	}

	static void method2079(int var0) {
	}

	final void flush() throws IOException {
		if (null != this.field1074 && this.field1069 > 0) {
			this.field1078.offset = 0;

			while (true) {
				PacketMessage var2 = (PacketMessage)this.field1068.method6465();
				if (null == var2 || var2.field2987 > this.field1078.data.length - this.field1078.offset) {
					this.field1074.write(this.field1078.data, 0, this.field1078.offset);
					this.field1077 = 0;
					break;
				}

				this.field1078.writeBytes(var2.buffer.data, 0, var2.field2987);
				this.field1069 -= var2.field2987;
				var2.method7825();
				var2.buffer.method8103();
				var2.method5153();
			}
		}

	}

	public final void add(PacketMessage var1) {
		this.field1068.method6462(var1);
		var1.field2987 = var1.buffer.offset;
		var1.buffer.offset = 0;
		this.field1069 += var1.field2987;
	}

	void method2097(AbstractSocket var1) {
		this.field1074 = var1;
	}

	void method2080() {
		if (null != this.field1074) {
			this.field1074.method7259();
			this.field1074 = null;
		}

	}

	void method2100() {
		this.field1074 = null;
	}

	AbstractSocket method2082() {
		return this.field1074;
	}
}
