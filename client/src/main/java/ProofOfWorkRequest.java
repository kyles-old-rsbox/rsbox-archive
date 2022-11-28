import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProofOfWorkRequest {
	static class336 field12;
	static class420 field10;
	ExecutorService field5;
	Future field13;
	final ProofOfWorkMessage field8;
	final Buffer field7;

	public ProofOfWorkRequest(Buffer var1, ProofOfWorkMessage var2) {
		this.field5 = Executors.newSingleThreadExecutor();
		this.field7 = var1;
		this.field8 = var2;
		this.method30();
	}

	public boolean method17() {
		return this.field13.isDone();
	}

	public void destroy() {
		this.field5.shutdown();
		this.field5 = null;
	}

	public Buffer method19() {
		try {
			return (Buffer)this.field13.get();
		} catch (Exception var3) {
			return null;
		}
	}

	void method30() {
		this.field13 = this.field5.submit(new class6(this, this.field7, this.field8));
	}

	public static File method34(String var0, String var1, int var2) {
		String var4 = var2 == 0 ? "" : "" + var2;
		class163.field1501 = new File(class45.field328, "jagex_cl_" + var0 + "_" + var1 + var4 + ".dat");
		String var5 = null;
		String var6 = null;
		boolean var7 = false;
		Buffer var9;
		File var27;
		if (class163.field1501.exists()) {
			try {
				class464 var8 = new class464(class163.field1501, "rw", 10000L);

				int var10;
				for (var9 = new Buffer((int)var8.method8373()); var9.offset < var9.data.length; var9.offset += var10) {
					var10 = var8.method8369(var9.data, var9.offset, var9.data.length - var9.offset);
					if (var10 == -1) {
						throw new IOException();
					}
				}

				var9.offset = 0;
				var10 = var9.readUnsignedByte();
				if (var10 < 1 || var10 > 3) {
					throw new IOException("" + var10);
				}

				int var11 = 0;
				if (var10 > 1) {
					var11 = var9.readUnsignedByte();
				}

				if (var10 <= 2) {
					var5 = var9.readJagexString();
					if (var11 == 1) {
						var6 = var9.readJagexString();
					}
				} else {
					var5 = var9.method8133();
					if (var11 == 1) {
						var6 = var9.method8133();
					}
				}

				var8.method8374();
			} catch (IOException var25) {
				var25.printStackTrace();
			}

			if (var5 != null) {
				var27 = new File(var5);
				if (!var27.exists()) {
					var5 = null;
				}
			}

			if (var5 != null) {
				var27 = new File(var5, "test.dat");
				if (!class32.method601(var27, true)) {
					var5 = null;
				}
			}
		}

		if (var5 == null && var2 == 0) {
			label147:
			for (int var16 = 0; var16 < class251.field2908.length; ++var16) {
				for (int var17 = 0; var17 < class347.field4261.length; ++var17) {
					File var18 = new File(class347.field4261[var17] + class251.field2908[var16] + File.separatorChar + var0 + File.separatorChar);
					if (var18.exists()) {
						File var12 = new File(var18, "test.dat");

						boolean var28;
						try {
							RandomAccessFile var13 = new RandomAccessFile(var12, "rw");
							int var14 = var13.read();
							var13.seek(0L);
							var13.write(var14);
							var13.seek(0L);
							var13.close();
							var12.delete();
							var28 = true;
						} catch (Exception var23) {
							var28 = false;
						}

						if (var28) {
							var5 = var18.toString();
							var7 = true;
							break label147;
						}
					}
				}
			}
		}

		if (var5 == null) {
			var5 = class45.field328 + File.separatorChar + "jagexcache" + var4 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
			var7 = true;
		}

		File var26;
		if (null != var6) {
			var26 = new File(var6);
			var27 = new File(var5);

			try {
				File[] var30 = var26.listFiles();
				File[] var19 = var30;

				for (int var20 = 0; var20 < var19.length; ++var20) {
					File var29 = var19[var20];
					File var21 = new File(var27, var29.getName());
					boolean var15 = var29.renameTo(var21);
					if (!var15) {
						throw new IOException();
					}
				}
			} catch (Exception var24) {
				var24.printStackTrace();
			}

			var7 = true;
		}

		if (var7) {
			var26 = new File(var5);
			var9 = null;

			try {
				class464 var31 = new class464(class163.field1501, "rw", 10000L);
				Buffer var32 = new Buffer(500);
				var32.writeByte(3);
				var32.writeByte(var9 != null ? 1 : 0);
				var32.method8199(var26.getPath());
				if (null != var9) {
					var32.method8199("");
				}

				var31.method8370(var32.data, 0, var32.offset);
				var31.method8374();
			} catch (IOException var22) {
				var22.printStackTrace();
			}
		}

		return new File(var5);
	}

	static final void method16(class300 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (client.field1714) {
			client.field1715 = 32;
		} else {
			client.field1715 = 0;
		}

		client.field1714 = false;
		int var8;
		if (MouseManager.field289 == 1 || !class95.field944 && 4 == MouseManager.field289) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.field3482 -= 4;
				class136.method2438(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 + var3 - 16 && var6 < var2 + var3) {
				var0.field3482 += 4;
				class136.method2438(var0);
			} else if (var5 >= var1 - client.field1715 && var5 < var1 + 16 + client.field1715 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
				var8 = (var3 - 32) * var3 / var4;
				if (var8 < 8) {
					var8 = 8;
				}

				int var9 = var6 - var2 - 16 - var8 / 2;
				int var10 = var3 - 32 - var8;
				var0.field3482 = var9 * (var4 - var3) / var10;
				class136.method2438(var0);
				client.field1714 = true;
			}
		}

		if (client.field1639 != 0) {
			var8 = var0.field3448;
			if (var5 >= var1 - var8 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
				var0.field3482 += client.field1639 * 45;
				class136.method2438(var0);
			}
		}

	}

	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var3 = var0.field796;
		int var4 = (int)var0.field4681;
		var0.method7825();
		if (var1) {
			class257.method5138(var3);
		}

		class152.method2593(var3);
		class300 var5 = class282.method5426(var4);
		if (null != var5) {
			class136.method2438(var5);
		}

		if (-1 != client.rootInterface) {
			class217.method4361(client.rootInterface, 1);
		}

	}
}
