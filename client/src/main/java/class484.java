import java.util.zip.Inflater;

public class class484 {
	Inflater field5001;

	public class484() {
		this(-1, 1000000);
	}

	class484(int var1, int var2) {
	}

	public void method8735(Buffer var1, byte[] var2) {
		if (var1.data[var1.offset] == 31 && -117 == var1.data[var1.offset + 1]) {
			if (null == this.field5001) {
				this.field5001 = new Inflater(true);
			}

			try {
				this.field5001.setInput(var1.data, var1.offset + 10, var1.data.length - (var1.offset + 10 + 8));
				this.field5001.inflate(var2);
			} catch (Exception var5) {
				this.field5001.reset();
				throw new RuntimeException("");
			}

			this.field5001.reset();
		} else {
			throw new RuntimeException("");
		}
	}
}
