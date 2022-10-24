import java.io.EOFException;
import java.io.IOException;

public class class466 {
	byte[] field4907;
	byte[] field4909;
	class464 field4914;
	int field4911;
	int field4917;
	long field4910;
	long field4912;
	long field4913;
	long field4915;
	long field4916;
	long field4918;

	public class466(class464 var1, int var2, int var3) throws IOException {
		this.field4910 = -1L;
		this.field4913 = -1L;
		this.field4917 = 0;
		this.field4914 = var1;
		this.field4912 = this.field4916 = var1.method8373();
		this.field4909 = new byte[var2];
		this.field4907 = new byte[var3];
		this.field4915 = 0L;
	}

	public void method8397() throws IOException {
		this.method8399();
		this.field4914.method8374();
	}

	public void method8393(long var1) throws IOException {
		if (var1 < 0L) {
			throw new IOException("");
		} else {
			this.field4915 = var1;
		}
	}

	public long method8394() {
		return this.field4912;
	}

	public void method8391(byte[] var1) throws IOException {
		this.method8392(var1, 0, var1.length);
	}

	public void method8392(byte[] var1, int var2, int var3) throws IOException {
		try {
			if (var2 + var3 > var1.length) {
				throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
			}

			if (-1L != this.field4913 && this.field4915 >= this.field4913 && this.field4915 + (long)var3 <= (long)this.field4917 + this.field4913) {
				System.arraycopy(this.field4907, (int)(this.field4915 - this.field4913), var1, var2, var3);
				this.field4915 += (long)var3;
				return;
			}

			long var5 = this.field4915;
			int var8 = var3;
			int var9;
			if (this.field4915 >= this.field4910 && this.field4915 < this.field4910 + (long)this.field4911) {
				var9 = (int)((long)this.field4911 - (this.field4915 - this.field4910));
				if (var9 > var3) {
					var9 = var3;
				}

				System.arraycopy(this.field4909, (int)(this.field4915 - this.field4910), var1, var2, var9);
				this.field4915 += (long)var9;
				var2 += var9;
				var3 -= var9;
			}

			if (var3 > this.field4909.length) {
				this.field4914.method8379(this.field4915);

				for (this.field4918 = this.field4915; var3 > 0; var3 -= var9) {
					var9 = this.field4914.method8369(var1, var2, var3);
					if (var9 == -1) {
						break;
					}

					this.field4918 += (long)var9;
					this.field4915 += (long)var9;
					var2 += var9;
				}
			} else if (var3 > 0) {
				this.method8410();
				var9 = var3;
				if (var3 > this.field4911) {
					var9 = this.field4911;
				}

				System.arraycopy(this.field4909, 0, var1, var2, var9);
				var2 += var9;
				var3 -= var9;
				this.field4915 += (long)var9;
			}

			if (-1L != this.field4913) {
				if (this.field4913 > this.field4915 && var3 > 0) {
					var9 = var2 + (int)(this.field4913 - this.field4915);
					if (var9 > var2 + var3) {
						var9 = var3 + var2;
					}

					while (var2 < var9) {
						var1[var2++] = 0;
						--var3;
						++this.field4915;
					}
				}

				long var14 = -1L;
				long var11 = -1L;
				if (this.field4913 >= var5 && this.field4913 < var5 + (long)var8) {
					var14 = this.field4913;
				} else if (var5 >= this.field4913 && var5 < this.field4913 + (long)this.field4917) {
					var14 = var5;
				}

				if (this.field4913 + (long)this.field4917 > var5 && (long)this.field4917 + this.field4913 <= var5 + (long)var8) {
					var11 = this.field4913 + (long)this.field4917;
				} else if ((long)var8 + var5 > this.field4913 && var5 + (long)var8 <= (long)this.field4917 + this.field4913) {
					var11 = var5 + (long)var8;
				}

				if (var14 > -1L && var11 > var14) {
					int var13 = (int)(var11 - var14);
					System.arraycopy(this.field4907, (int)(var14 - this.field4913), var1, (int)(var14 - var5) + var2, var13);
					if (var11 > this.field4915) {
						var3 = (int)((long)var3 - (var11 - this.field4915));
						this.field4915 = var11;
					}
				}
			}
		} catch (IOException var17) {
			this.field4918 = -1L;
			throw var17;
		}

		if (var3 > 0) {
			throw new EOFException();
		}
	}

	void method8410() throws IOException {
		this.field4911 = 0;
		if (this.field4918 != this.field4915) {
			this.field4914.method8379(this.field4915);
			this.field4918 = this.field4915;
		}

		int var3;
		for (this.field4910 = this.field4915; this.field4911 < this.field4909.length; this.field4911 += var3) {
			int var2 = this.field4909.length - this.field4911;
			if (var2 > 200000000) {
				var2 = 200000000;
			}

			var3 = this.field4914.method8369(this.field4909, this.field4911, var2);
			if (var3 == -1) {
				break;
			}

			this.field4918 += (long)var3;
		}

	}

	public void method8398(byte[] var1, int var2, int var3) throws IOException {
		try {
			if (this.field4915 + (long)var3 > this.field4912) {
				this.field4912 = this.field4915 + (long)var3;
			}

			if (this.field4913 != -1L && (this.field4915 < this.field4913 || this.field4915 > this.field4913 + (long)this.field4917)) {
				this.method8399();
			}

			if (this.field4913 != -1L && this.field4915 + (long)var3 > this.field4913 + (long)this.field4907.length) {
				int var5 = (int)((long)this.field4907.length - (this.field4915 - this.field4913));
				System.arraycopy(var1, var2, this.field4907, (int)(this.field4915 - this.field4913), var5);
				this.field4915 += (long)var5;
				var2 += var5;
				var3 -= var5;
				this.field4917 = this.field4907.length;
				this.method8399();
			}

			if (var3 > this.field4907.length) {
				if (this.field4915 != this.field4918) {
					this.field4914.method8379(this.field4915);
					this.field4918 = this.field4915;
				}

				this.field4914.method8370(var1, var2, var3);
				this.field4918 += (long)var3;
				if (this.field4918 > this.field4916) {
					this.field4916 = this.field4918;
				}

				long var10 = -1L;
				long var7 = -1L;
				if (this.field4915 >= this.field4910 && this.field4915 < this.field4910 + (long)this.field4911) {
					var10 = this.field4915;
				} else if (this.field4910 >= this.field4915 && this.field4910 < (long)var3 + this.field4915) {
					var10 = this.field4910;
				}

				if ((long)var3 + this.field4915 > this.field4910 && this.field4915 + (long)var3 <= (long)this.field4911 + this.field4910) {
					var7 = this.field4915 + (long)var3;
				} else if ((long)this.field4911 + this.field4910 > this.field4915 && (long)this.field4911 + this.field4910 <= this.field4915 + (long)var3) {
					var7 = (long)this.field4911 + this.field4910;
				}

				if (var10 > -1L && var7 > var10) {
					int var9 = (int)(var7 - var10);
					System.arraycopy(var1, (int)(var10 + (long)var2 - this.field4915), this.field4909, (int)(var10 - this.field4910), var9);
				}

				this.field4915 += (long)var3;
				return;
			}

			if (var3 > 0) {
				if (this.field4913 == -1L) {
					this.field4913 = this.field4915;
				}

				System.arraycopy(var1, var2, this.field4907, (int)(this.field4915 - this.field4913), var3);
				this.field4915 += (long)var3;
				if (this.field4915 - this.field4913 > (long)this.field4917) {
					this.field4917 = (int)(this.field4915 - this.field4913);
				}

				return;
			}
		} catch (IOException var13) {
			this.field4918 = -1L;
			throw var13;
		}

	}

	void method8399() throws IOException {
		if (this.field4913 != -1L) {
			if (this.field4918 != this.field4913) {
				this.field4914.method8379(this.field4913);
				this.field4918 = this.field4913;
			}

			this.field4914.method8370(this.field4907, 0, this.field4917);
			this.field4918 += (long)this.field4917;
			if (this.field4918 > this.field4916) {
				this.field4916 = this.field4918;
			}

			long var2 = -1L;
			long var4 = -1L;
			if (this.field4913 >= this.field4910 && this.field4913 < (long)this.field4911 + this.field4910) {
				var2 = this.field4913;
			} else if (this.field4910 >= this.field4913 && this.field4910 < (long)this.field4917 + this.field4913) {
				var2 = this.field4910;
			}

			if ((long)this.field4917 + this.field4913 > this.field4910 && this.field4913 + (long)this.field4917 <= (long)this.field4911 + this.field4910) {
				var4 = (long)this.field4917 + this.field4913;
			} else if ((long)this.field4911 + this.field4910 > this.field4913 && (long)this.field4911 + this.field4910 <= (long)this.field4917 + this.field4913) {
				var4 = this.field4910 + (long)this.field4911;
			}

			if (var2 > -1L && var4 > var2) {
				int var6 = (int)(var4 - var2);
				System.arraycopy(this.field4907, (int)(var2 - this.field4913), this.field4909, (int)(var2 - this.field4910), var6);
			}

			this.field4913 = -1L;
			this.field4917 = 0;
		}

	}
}
