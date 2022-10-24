import java.io.IOException;
import java.net.Socket;

public class class409 extends class401 {
	class397 field4548;
	class413 field4546;
	Socket field4550;

	public class409(Socket var1, int var2, int var3) throws IOException {
		this.field4550 = var1;
		this.field4550.setSoTimeout(30000);
		this.field4550.setTcpNoDelay(true);
		this.field4550.setReceiveBufferSize(65536);
		this.field4550.setSendBufferSize(65536);
		this.field4548 = new class397(this.field4550.getInputStream(), var2);
		this.field4546 = new class413(this.field4550.getOutputStream(), var3);
	}

	public boolean method7254(int var1) throws IOException {
		return this.field4548.method7186(var1);
	}

	public int method7255() throws IOException {
		return this.field4548.method7187();
	}

	public int method7256() throws IOException {
		return this.field4548.method7203();
	}

	public int method7267(byte[] var1, int var2, int var3) throws IOException {
		return this.field4548.method7189(var1, var2, var3);
	}

	public void method7258(byte[] var1, int var2, int var3) throws IOException {
		this.field4546.method7494(var1, var2, var3);
	}

	public void method7259() {
		this.field4546.method7487();

		try {
			this.field4550.close();
		} catch (IOException var3) {
		}

		this.field4548.method7190();
	}

	protected void finalize() {
		this.method7259();
	}
}
