import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class class22 extends class28 {
	byte[] field111;
	int field113;
	AudioFormat field114;
	SourceDataLine field112;

	class22() {
	}

	protected void method365() {
		this.field114 = new AudioFormat((float)class49.field348, 16, class174.field1566 ? 2 : 1, true, false);
		this.field111 = new byte[256 << (class174.field1566 ? 2 : 1)];
	}

	protected void method366(int var1) throws LineUnavailableException {
		try {
			Info var3 = new Info(SourceDataLine.class, this.field114, var1 << (class174.field1566 ? 2 : 1));
			this.field112 = (SourceDataLine)AudioSystem.getLine(var3);
			this.field112.open();
			this.field112.start();
			this.field113 = var1;
		} catch (LineUnavailableException var4) {
			if (class282.method4111(var1) != 1) {
				this.method366(class282.method953(var1));
			} else {
				this.field112 = null;
				throw var4;
			}
		}
	}

	protected int method367() {
		return this.field113 - (this.field112.available() >> (class174.field1566 ? 2 : 1));
	}

	protected void method368() {
		int var1 = 256;
		if (class174.field1566) {
			var1 <<= 1;
		}

		for (int var2 = 0; var2 < var1; ++var2) {
			int var3 = super.field136[var2];
			if ((var3 + 8388608 & -16777216) != 0) {
				var3 = 8388607 ^ var3 >> 31;
			}

			this.field111[var2 * 2] = (byte)(var3 >> 8);
			this.field111[var2 * 2 + 1] = (byte)(var3 >> 16);
		}

		this.field112.write(this.field111, 0, var1 << 1);
	}

	protected void method369() {
		if (this.field112 != null) {
			this.field112.close();
			this.field112 = null;
		}

	}

	protected void method370() {
		this.field112.flush();
	}
}
