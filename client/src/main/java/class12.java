import java.awt.FontMetrics;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

public class class12 {
	public static int field57;
	static class148 field55;
	static FontMetrics field59;
	boolean field49;
	boolean field54;
	class419 field51;
	int field56;
	Map field50;
	HttpsURLConnection field52;
	final class18 field53;
	final Map field58;

	public class12(URL var1, class18 var2, boolean var3) throws IOException {
		this.field54 = false;
		this.field49 = false;
		this.field56 = 300000;
		if (!var2.method218()) {
			throw new UnsupportedEncodingException("Unsupported request method used " + var2.method215());
		} else {
			this.field52 = (HttpsURLConnection)var1.openConnection();
			if (!var3) {
				HttpsURLConnection var4 = this.field52;
				if (class21.field109 == null) {
					class21.field109 = new class21();
				}

				class21 var5 = class21.field109;
				var4.setSSLSocketFactory(var5);
			}

			this.field53 = var2;
			this.field58 = new HashMap();
			this.field50 = new HashMap();
		}
	}

	public void method88(String var1, String var2) {
		if (!this.field54) {
			this.field58.put(var1, var2);
		}
	}

	String method89() {
		ArrayList var2 = new ArrayList(this.field50.entrySet());
		Collections.sort(var2, new class23(this));
		StringBuilder var3 = new StringBuilder();
		Iterator var4 = var2.iterator();

		while (var4.hasNext()) {
			Entry var5 = (Entry)var4.next();
			if (var3.length() > 0) {
				var3.append(",");
			}

			var3.append(((class430)var5.getKey()).method7844());
			float var6 = (Float)var5.getValue();
			if (var6 < 1.0F) {
				String var7 = Float.toString(var6).substring(0, 4);
				var3.append(";q=" + var7);
			}
		}

		return var3.toString();
	}

	void method87() throws ProtocolException {
		if (!this.field54) {
			this.field52.setRequestMethod(this.field53.method215());
			if (!this.field50.isEmpty()) {
				this.field58.put("Accept", this.method89());
			}

			Iterator var2 = this.field58.entrySet().iterator();

			while (var2.hasNext()) {
				Entry var3 = (Entry)var2.next();
				this.field52.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
			}

			if (this.field53.method207() && null != this.field51) {
				this.field52.setDoOutput(true);
				ByteArrayOutputStream var14 = new ByteArrayOutputStream();

				try {
					var14.write(this.field51.method7572());
					var14.writeTo(this.field52.getOutputStream());
				} catch (IOException var12) {
					var12.printStackTrace();
				} finally {
					if (var14 != null) {
						try {
							var14.close();
						} catch (IOException var11) {
							var11.printStackTrace();
						}
					}

				}
			}

			this.field52.setConnectTimeout(this.field56);
			this.field52.setInstanceFollowRedirects(this.field49);
			this.field54 = true;
		}
	}

	static void method91(class72[] var0, int var1, int var2, int[] var3, int[] var4) {
		if (var1 < var2) {
			int var6 = var1 - 1;
			int var7 = var2 + 1;
			int var8 = (var1 + var2) / 2;
			class72 var9 = var0[var8];
			var0[var8] = var0[var1];
			var0[var1] = var9;

			while (var6 < var7) {
				boolean var10 = true;

				int var11;
				int var12;
				int var13;
				do {
					--var7;

					for (var11 = 0; var11 < 4; ++var11) {
						if (var3[var11] == 2) {
							var12 = var0[var7].field592;
							var13 = var9.field592;
						} else if (1 == var3[var11]) {
							var12 = var0[var7].field593;
							var13 = var9.field593;
							if (var12 == -1 && 1 == var4[var11]) {
								var12 = 2001;
							}

							if (var13 == -1 && 1 == var4[var11]) {
								var13 = 2001;
							}
						} else if (3 == var3[var11]) {
							var12 = var0[var7].method1447() ? 1 : 0;
							var13 = var9.method1447() ? 1 : 0;
						} else {
							var12 = var0[var7].field590;
							var13 = var9.field590;
						}

						if (var12 != var13) {
							if ((var4[var11] != 1 || var12 <= var13) && (0 != var4[var11] || var12 >= var13)) {
								var10 = false;
							}
							break;
						}

						if (var11 == 3) {
							var10 = false;
						}
					}
				} while(var10);

				var10 = true;

				do {
					++var6;

					for (var11 = 0; var11 < 4; ++var11) {
						if (var3[var11] == 2) {
							var12 = var0[var6].field592;
							var13 = var9.field592;
						} else if (var3[var11] == 1) {
							var12 = var0[var6].field593;
							var13 = var9.field593;
							if (var12 == -1 && var4[var11] == 1) {
								var12 = 2001;
							}

							if (var13 == -1 && 1 == var4[var11]) {
								var13 = 2001;
							}
						} else if (var3[var11] == 3) {
							var12 = var0[var6].method1447() ? 1 : 0;
							var13 = var9.method1447() ? 1 : 0;
						} else {
							var12 = var0[var6].field590;
							var13 = var9.field590;
						}

						if (var13 != var12) {
							if ((var4[var11] != 1 || var12 >= var13) && (var4[var11] != 0 || var12 <= var13)) {
								var10 = false;
							}
							break;
						}

						if (var11 == 3) {
							var10 = false;
						}
					}
				} while(var10);

				if (var6 < var7) {
					class72 var14 = var0[var6];
					var0[var6] = var0[var7];
					var0[var7] = var14;
				}
			}

			method91(var0, var1, var7, var3, var4);
			method91(var0, var7 + 1, var2, var3, var4);
		}

	}

	boolean method93() throws IOException, SocketTimeoutException {
		if (!this.field54) {
			this.method87();
		}

		this.field52.connect();
		return this.field52.getResponseCode() == -1;
	}

	class9 method92() {
		try {
			if (!this.field54 || this.field52.getResponseCode() == -1) {
				return new class9("No REST response has been received yet.");
			}
		} catch (IOException var11) {
			this.field52.disconnect();
			return new class9("Error decoding REST response code: " + var11.getMessage());
		}

		class9 var2 = null;

		class9 var4;
		try {
			var2 = new class9(this.field52);
			return var2;
		} catch (IOException var9) {
			var4 = new class9("Error decoding REST response: " + var9.getMessage());
		} finally {
			this.field52.disconnect();
		}

		return var4;
	}
}
