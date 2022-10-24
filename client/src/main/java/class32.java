import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.imageio.ImageIO;

public class class32 {
	static int field203;
	static int field204;
	static int field206;

	static {
		ImageIO.setUseCache(false);
	}

	class32() throws Throwable {
		throw new Error();
	}

	public static final class473 method712(byte[] var0) {
		BufferedImage var2 = null;

		try {
			Class var3 = ImageIO.class;
			synchronized(ImageIO.class) {
				var2 = ImageIO.read(new ByteArrayInputStream(var0));
			}

			int var7 = var2.getWidth();
			int var8 = var2.getHeight();
			int[] var5 = new int[var8 * var7];
			PixelGrabber var6 = new PixelGrabber(var2, 0, 0, var7, var8, var5, 0, var7);
			var6.grabPixels();
			class473 var10000 = new class473(var5, var7, var8);
			return var10000;
		} catch (IOException var10) {
		} catch (InterruptedException var11) {
		}

		return new class473(0, 0);
	}

	public static boolean method601(File var0, boolean var1) {
		boolean var10000;
		try {
			RandomAccessFile var3 = new RandomAccessFile(var0, "rw");
			int var4 = var3.read();
			var3.seek(0L);
			var3.write(var4);
			var3.seek(0L);
			var3.close();
			if (var1) {
				var0.delete();
			}

			var10000 = true;
		} catch (Exception var5) {
			return false;
		}

		return var10000;
	}
}
