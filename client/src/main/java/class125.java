import client.Client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class class125 extends class115 {
	static int field1206;
	final boolean field1207;

	public class125(boolean var1, int var2) {
		super(var2);
		this.field1207 = var1;
	}

	void method2238(class109 var1) throws IOException {
		URLConnection var3 = null;

		try {
			String var4 = var1.field1087.getProtocol();
			if (var4.equals("http")) {
				var3 = this.method2360(var1);
			} else {
				if (!var4.equals("https")) {
					var1.field1084 = true;
					return;
				}

				var3 = this.method2357(var1);
			}

			this.method2224(var3, var1);
		} catch (IOException var8) {
		} finally {
			var1.field1084 = true;
			if (null != var3) {
				if (var3 instanceof HttpURLConnection) {
					((HttpURLConnection)var3).disconnect();
				} else if (var3 instanceof HttpsURLConnection) {
					((HttpsURLConnection)var3).disconnect();
				}
			}

		}

	}

	URLConnection method2360(class109 var1) throws IOException {
		URLConnection var3 = var1.field1087.openConnection();
		this.method2223(var3);
		return var3;
	}

	URLConnection method2357(class109 var1) throws IOException {
		HttpsURLConnection var3 = (HttpsURLConnection)var1.field1087.openConnection();
		if (!this.field1207) {
			if (null == class21.field109) {
				class21.field109 = new class21();
			}

			class21 var5 = class21.field109;
			var3.setSSLSocketFactory(var5);
		}

		this.method2223(var3);
		return var3;
	}

	static final void method2358(class300 var0, int var1, int var2, int var3) {
		class298 var5 = var0.method5859(false);
		if (var5 != null) {
			if (Client.field1709 < 3) {
				class122.field1185.method8502(var1, var2, var5.field3435, var5.field3433, 25, 25, Client.field1672, 256, var5.field3432, var5.field3434);
			} else {
				class481.method8713(var1, var2, 0, var5.field3432, var5.field3434);
			}

		}
	}
}
