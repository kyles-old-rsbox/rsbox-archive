import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import client.Client;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;

class class2 extends DefaultTlsClient {
	static int[] field1;
	// $FF: synthetic field
	final class16 this$1;

	class2(class16 var1) {
		this.this$1 = var1;
	}

	public Hashtable getClientExtensions() throws IOException {
		Hashtable var1 = super.getClientExtensions();
		if (null == var1) {
			var1 = new Hashtable();
		}

		byte[] var2 = this.this$1.val$host.getBytes();
		ByteArrayOutputStream var3 = new ByteArrayOutputStream();
		DataOutputStream var4 = new DataOutputStream(var3);
		var4.writeShort(var2.length + 3);
		var4.writeByte(0);
		var4.writeShort(var2.length);
		var4.write(var2);
		var4.close();
		var1.put(0, var3.toByteArray());
		return var1;
	}

	@Override
	public TlsAuthentication getAuthentication() throws IOException {
		return null;
	}

	static int method15(int var0, class78 var1, boolean var2) {
		class300 var4;
		if (var0 == CS2Opcodes.IF_GETINVOBJECT) {
			var4 = class282.method5426(class57.field404[--class387.field4452]);
			class57.field404[++class387.field4452 - 1] = var4.field3445;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETINVCOUNT) {
			var4 = class282.method5426(class57.field404[--class387.field4452]);
			if (var4.field3445 != -1) {
				class57.field404[++class387.field4452 - 1] = var4.field3599;
			} else {
				class57.field404[++class387.field4452 - 1] = 0;
			}

			return 1;
		} else if (var0 == CS2Opcodes.IF_HASSUB) {
			int var6 = class57.field404[--class387.field4452];
			class89 var5 = (class89) Client.field1810.method7855((long)var6);
			if (var5 != null) {
				class57.field404[++class387.field4452 - 1] = 1;
			} else {
				class57.field404[++class387.field4452 - 1] = 0;
			}

			return 1;
		} else if (var0 == CS2Opcodes.IF_GETTOP) {
			class57.field404[++class387.field4452 - 1] = Client.field1893;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETCRM_HASRESPONSE) {
			var4 = class282.method5426(class57.field404[--class387.field4452]);
			class57.field404[++class387.field4452 - 1] = var4.method5876() ? 1 : 0;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETCRM_INT) {
			var4 = class282.method5426(class57.field404[--class387.field4452]);
			return class405.method7368(var4);
		} else if (var0 == CS2Opcodes.IF_GETCRM_STRING) {
			var4 = class282.method5426(class57.field404[--class387.field4452]);
			return class112.method2170(var4);
		} else {
			return 2;
		}
	}

	static int method11() {
		return Client.field1869 ? 2 : 1;
	}
}
