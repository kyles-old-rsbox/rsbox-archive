import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class class176 {
	static class473[] field1585;
	class109 field1577;
	float[] field1582;
	int field1575;
	String field1579;
	String field1583;
	ArrayList field1576;
	ArrayList field1580;
	ArrayList field1581;
	Map field1572;
	Map field1578;

	public class176() {
		this.field1575 = -1;
		this.field1579 = null;
		this.field1582 = new float[4];
		this.field1580 = new ArrayList();
		this.field1581 = new ArrayList();
		this.field1576 = new ArrayList();
		this.field1578 = new HashMap();
		this.field1572 = new HashMap();
	}

	public boolean method2757(String var1, class115 var2) {
		if (null != var1 && !var1.isEmpty()) {
			if (null == var2) {
				return false;
			} else {
				this.method2793();

				boolean var10000;
				try {
					this.field1583 = var1;
					this.field1577 = var2.method2222(new URL(this.field1583));
					this.field1575 = 0;
					var10000 = true;
				} catch (MalformedURLException var5) {
					this.method2793();
					this.field1575 = 100;
					return false;
				}

				return var10000;
			}
		} else {
			return false;
		}
	}

	public void method2758(class115 var1) {
		switch(this.field1575) {
		case 0:
			this.method2756(var1);
			break;
		case 1:
			this.method2767();
			break;
		default:
			return;
		}

	}

	public int method2796() {
		return this.field1575;
	}

	public int method2760(String var1) {
		return this.field1578.containsKey(var1) ? (Integer)this.field1578.get(var1) : -1;
	}

	public String method2761(String var1) {
		return (String)((String)(this.field1572.containsKey(var1) ? this.field1572.get(var1) : null));
	}

	public ArrayList method2762() {
		return this.field1581;
	}

	public ArrayList method2811() {
		return this.field1576;
	}

	public String method2764() {
		return this.field1579;
	}

	public ArrayList method2765() {
		return this.field1580;
	}

	void method2793() {
		this.field1577 = null;
		this.field1579 = null;
		this.field1582[0] = 0.0F;
		this.field1582[1] = 0.0F;
		this.field1582[2] = 1.0F;
		this.field1582[3] = 1.0F;
		this.field1580.clear();
		this.field1581.clear();
		this.field1576.clear();
		this.field1578.clear();
		this.field1572.clear();
	}

	void method2756(class115 var1) {
		if (null != this.field1577 && this.field1577.method2102()) {
			byte[] var3 = this.field1577.method2115();
			if (var3 == null) {
				this.method2793();
				this.field1575 = 100;
			} else {
				JSONObject var4;
				try {
					class425 var5 = new class425(var3);
					var4 = var5.method7816();
					var4 = var4.getJSONObject("message");
				} catch (Exception var10) {
					this.method2793();
					this.field1575 = 102;
					return;
				}

				try {
					this.method2768(var4.getJSONArray("images"), var1);
				} catch (Exception var9) {
					this.field1581.clear();
				}

				try {
					this.method2780(var4.getJSONArray("labels"));
				} catch (Exception var8) {
					this.field1576.clear();
				}

				try {
					this.method2759(var4.getJSONObject("behaviour"));
				} catch (Exception var7) {
					this.field1579 = null;
					this.field1582[0] = 0.0F;
					this.field1582[1] = 0.0F;
					this.field1582[2] = 1.0F;
					this.field1582[3] = 1.0F;
					this.field1580.clear();
				}

				try {
					this.method2766(var4.getJSONObject("meta"));
				} catch (Exception var6) {
					this.field1578.clear();
					this.field1572.clear();
				}

				this.field1575 = this.field1581.size() > 0 ? 1 : 2;
				this.field1577 = null;
			}
		}
	}

	void method2767() {
		Iterator var2 = this.field1581.iterator();

		class164 var3;
		do {
			if (!var2.hasNext()) {
				var2 = this.field1581.iterator();

				while (var2.hasNext()) {
					var3 = (class164)var2.next();
					if (null != var3.field1515) {
						byte[] var4 = var3.field1515.method2115();
						if (var4 != null && var4.length > 0) {
							this.field1575 = 2;
							return;
						}
					}
				}

				this.method2793();
				this.field1575 = 101;
				return;
			}

			var3 = (class164)var2.next();
		} while(null == var3.field1515 || var3.field1515.method2102());

	}

	void method2768(JSONArray var1, class115 var2) throws JSONException {
		if (var1 != null) {
			for (int var4 = 0; var4 < var1.length(); ++var4) {
				try {
					JSONObject var5 = var1.getJSONObject(var4);
					class164 var6 = new class164(this);
					var6.field1515 = var2.method2222(new URL(var5.getString("src")));
					var6.field1514 = method2391(var5, "placement");
					this.field1581.add(var6);
				} catch (MalformedURLException var7) {
				}
			}

		}
	}

	void method2780(JSONArray var1) throws JSONException {
		if (var1 != null) {
			for (int var3 = 0; var3 < var1.length(); ++var3) {
				JSONObject var4 = var1.getJSONObject(var3);
				class165 var5 = new class165(this);
				var5.field1518 = var4.getString("text");
				String var8 = var4.getString("align_x");
				byte var7;
				if (var8.equals("centre")) {
					var7 = 1;
				} else if (!var8.equals("bottom") && !var8.equals("right")) {
					var7 = 0;
				} else {
					var7 = 2;
				}

				var5.field1520 = var7;
				String var11 = var4.getString("align_y");
				byte var10;
				if (var11.equals("centre")) {
					var10 = 1;
				} else if (!var11.equals("bottom") && !var11.equals("right")) {
					var10 = 0;
				} else {
					var10 = 2;
				}

				var5.field1521 = var10;
				var5.field1522 = var4.getInt("font");
				var5.field1516 = method2391(var4, "placement");
				this.field1576.add(var5);
			}

		}
	}

	void method2759(JSONObject var1) throws JSONException {
		if (var1 != null) {
			this.field1582 = method2391(var1, "clickbounds");
			this.field1579 = var1.getString("endpoint");
			String[] var3 = JSONObject.getNames(var1);

			for (int var4 = 0; var4 < var1.length(); ++var4) {
				if (!var3[var4].equals("clickbounds") && !var3[var4].equals("endpoint")) {
					try {
						int var5 = var1.getInt(var3[var4]);
						this.field1580.add(new class171(this, var3[var4], var5));
					} catch (Exception var9) {
						try {
							String var6 = var1.getString(var3[var4]);
							if (var6.equals("true")) {
								this.field1580.add(new class171(this, var3[var4], 1));
							} else if (var6.equals("false")) {
								this.field1580.add(new class171(this, var3[var4], 0));
							} else {
								this.field1580.add(new class159(this, var3[var4], var6));
							}
						} catch (Exception var8) {
						}
					}
				}
			}

		}
	}

	void method2766(JSONObject var1) throws JSONException {
		String[] var3 = JSONObject.getNames(var1);

		for (int var4 = 0; var4 < var1.length(); ++var4) {
			try {
				int var5 = var1.getInt(var3[var4]);
				this.field1578.put(var3[var4], var5);
			} catch (Exception var9) {
				try {
					String var6 = var1.getString(var3[var4]);
					if (var6.equals("true")) {
						this.field1578.put(var3[var4], 1);
					} else if (var6.equals("false")) {
						this.field1578.put(var3[var4], 0);
					} else {
						this.field1572.put(var3[var4], var6);
					}
				} catch (Exception var8) {
				}
			}
		}

	}

	static float[] method2391(JSONObject var0, String var1) throws JSONException {
		float[] var3 = new float[4];

		try {
			JSONArray var4 = var0.getJSONArray(var1);
			var3[0] = (float)var4.optDouble(0, 0.0D);
			var3[1] = (float)var4.optDouble(1, 0.0D);
			var3[2] = (float)var4.optDouble(2, 1.0D);
			var3[3] = (float)var4.optDouble(3, 1.0D);
		} catch (JSONException var5) {
			var3[0] = 0.0F;
			var3[1] = 0.0F;
			var3[2] = 1.0F;
			var3[3] = 1.0F;
		}

		return var3;
	}

	static final void method2802(int var0, int var1) {
		class343 var3 = client.field1865[class55.field396][var0][var1];
		if (var3 == null) {
			class145.field1333.method4143(class55.field396, var0, var1);
		} else {
			long var4 = -99999999L;
			class104 var6 = null;

			class104 var7;
			for (var7 = (class104)var3.method6364(); var7 != null; var7 = (class104)var3.method6358()) {
				class198 var8 = class278.method5388(var7.field1043);
				long var9 = (long)var8.field2143;
				if (1 == var8.field2142) {
					var9 *= (long)(1 + var7.field1038);
				}

				if (var9 > var4) {
					var4 = var9;
					var6 = var7;
				}
			}

			if (null == var6) {
				class145.field1333.method4143(class55.field396, var0, var1);
			} else {
				var3.method6353(var6);
				class104 var13 = null;
				class104 var12 = null;

				for (var7 = (class104)var3.method6364(); null != var7; var7 = (class104)var3.method6358()) {
					if (var6.field1043 != var7.field1043) {
						if (var13 == null) {
							var13 = var7;
						}

						if (var7.field1043 != var13.field1043 && null == var12) {
							var12 = var7;
						}
					}
				}

				long var10 = class207.method3982(var0, var1, 3, false, 0);
				class145.field1333.method4129(class55.field396, var0, var1, class144.method2498(128 * var0 + 64, 128 * var1 + 64, class55.field396), var6, var10, var13, var12);
			}
		}
	}

	static final String method2812(int var0) {
		return var0 < 999999999 ? Integer.toString(var0) : "*";
	}
}
