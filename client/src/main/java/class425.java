import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class class425 implements class419 {
	JSONObject field4677;

	public class425(String var1) throws UnsupportedEncodingException {
		this.method7822(var1);
	}

	public class425(byte[] var1) throws UnsupportedEncodingException {
		this.method7815(var1);
	}

	void method7815(byte[] var1) throws UnsupportedEncodingException {
		String var3 = new String(var1, "UTF-8");
		this.method7822(var3);
	}

	void method7822(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') {
				this.field4677 = new JSONObject(var1);
			} else {
				if (var1.charAt(0) != '[') {
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
				}

				JSONArray var3 = new JSONArray(var1);
				this.field4677 = new JSONObject();
				this.field4677.put("arrayValues", (Object)var3);
			}
		} catch (JSONException var4) {
			throw new UnsupportedEncodingException(var4.getMessage());
		}

	}

	public JSONObject method7816() {
		return this.field4677;
	}

	public byte[] method7572() throws UnsupportedEncodingException {
		return null == this.field4677 ? new byte[0] : this.field4677.toString().getBytes("UTF-8");
	}
}
