import java.io.IOException;
import java.io.OutputStream;

public class class413 implements Runnable {
	static class83 field4575;
	boolean field4573;
	byte[] field4569;
	int position;
	int field4568;
	int limit;
	IOException exception;
	OutputStream field4567;
	Thread field4574;

	class413(OutputStream var1, int var2) {
		this.position = 0;
		this.limit = 0;
		this.field4567 = var1;
		this.field4568 = var2 + 1;
		this.field4569 = new byte[this.field4568];
		this.field4574 = new Thread(this);
		this.field4574.setDaemon(true);
		this.field4574.start();
	}

	boolean isClosed() {
		if (this.field4573) {
			try {
				this.field4567.close();
				if (null == this.exception) {
					this.exception = new IOException("");
				}
			} catch (IOException var3) {
				if (this.exception == null) {
					this.exception = new IOException(var3);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public void run() {
		do {
			int var1;
			synchronized(this) {
				while (true) {
					if (this.exception != null) {
						return;
					}

					if (this.position <= this.limit) {
						var1 = this.limit - this.position;
					} else {
						var1 = this.limit + (this.field4568 - this.position);
					}

					if (var1 > 0) {
						break;
					}

					try {
						this.field4567.flush();
					} catch (IOException var19) {
						this.exception = var19;
						return;
					}

					if (this.isClosed()) {
						return;
					}

					try {
						this.wait();
					} catch (InterruptedException var18) {
					}
				}
			}

			try {
				if (var1 + this.position <= this.field4568) {
					this.field4567.write(this.field4569, this.position, var1);
				} else {
					int var7 = this.field4568 - this.position;
					this.field4567.write(this.field4569, this.position, var7);
					this.field4567.write(this.field4569, 0, var1 - var7);
				}
			} catch (IOException var17) {
				IOException var2 = var17;
				synchronized(this) {
					this.exception = var2;
				}

				return;
			}

			synchronized(this) {
				this.position = (var1 + this.position) % this.field4568;
			}
		} while(!this.isClosed());
	}

	void method7494(byte[] var1, int var2, int var3) throws IOException {
		if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
			synchronized(this) {
				if (this.exception != null) {
					throw new IOException(this.exception.toString());
				}

				int var6;
				if (this.position <= this.limit) {
					var6 = this.field4568 - this.limit + this.position - 1;
				} else {
					var6 = this.position - this.limit - 1;
				}

				if (var6 < var3) {
					throw new IOException("");
				}

				if (this.limit + var3 <= this.field4568) {
					System.arraycopy(var1, var2, this.field4569, this.limit, var3);
				} else {
					int var7 = this.field4568 - this.limit;
					System.arraycopy(var1, var2, this.field4569, this.limit, var7);
					System.arraycopy(var1, var2 + var7, this.field4569, 0, var3 - var7);
				}

				this.limit = (var3 + this.limit) % this.field4568;
				this.notifyAll();
			}

		} else {
			throw new IOException();
		}
	}

	void method7487() {
		synchronized(this) {
			this.field4573 = true;
			this.notifyAll();
		}

		try {
			this.field4574.join();
		} catch (InterruptedException var4) {
		}

	}
}
