import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class class352 implements Iterator {
	static class175 field4282;
	static class488 field4281;
	class342 field4284;
	int field4279;
	int field4280;

	class352(class342 var1) {
		this.field4279 = 0;
		this.field4280 = this.field4284.field4226;
		this.field4284 = var1;
	}

	public boolean hasNext() {
		return this.field4279 < this.field4284.field4224;
	}

	public Object next() {
		if (this.field4284.field4226 != this.field4280) {
			throw new ConcurrentModificationException();
		} else if (this.field4279 < this.field4284.field4224) {
			Object var1 = this.field4284.field4227[this.field4279].field4307;
			++this.field4279;
			return var1;
		} else {
			throw new NoSuchElementException();
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	static void method6544() {
		class75.field633 = class75.field633.trim();
		if (class75.field633.length() == 0) {
			class75.method5452(class338.field4167, class338.field4010, class338.field4169);
		} else {
			long var2;
			try {
				URL var4 = new URL(class140.method2473("services", false) + "m=accountappeal/login.ws");
				URLConnection var5 = var4.openConnection();
				var5.setRequestProperty("connection", "close");
				var5.setDoInput(true);
				var5.setDoOutput(true);
				var5.setConnectTimeout(5000);
				OutputStreamWriter var6 = new OutputStreamWriter(var5.getOutputStream());
				var6.write("data1=req");
				var6.flush();
				InputStream var7 = var5.getInputStream();
				class460 var8 = new class460(new byte[1000]);

				while (true) {
					int var9 = var7.read(var8.field4881, var8.field4878, 1000 - var8.field4878);
					if (var9 == -1) {
						var8.field4878 = 0;
						long var11 = var8.method8127();
						var2 = var11;
						break;
					}

					var8.field4878 += var9;
					if (var8.field4878 >= 1000) {
						var2 = 0L;
						break;
					}
				}
			} catch (Exception var15) {
				var2 = 0L;
			}

			int var1;
			if (var2 == 0L) {
				var1 = 5;
			} else {
				var1 = class359.method6662(var2, class75.field633);
			}

			switch(var1) {
			case 2:
				class75.method5452(class338.field4050, class338.field4171, class338.field4183);
				class74.method1490(6);
				break;
			case 3:
				class75.method5452(class338.field4173, class338.field4162, class338.field4175);
				break;
			case 4:
				class75.method5452(class338.field4204, class338.field4156, class338.field4123);
				break;
			case 5:
				class75.method5452(class338.field3914, class338.field4180, class338.field4184);
				break;
			case 6:
				class75.method5452(class338.field4178, class338.field3933, class338.field3992);
				break;
			case 7:
				class75.method5452(class338.field4185, class338.field4186, class338.field3912);
			}

		}
	}
}
