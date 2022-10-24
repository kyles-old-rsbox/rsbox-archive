import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class class48 extends class478 {
	Component field343;
	Image field344;

	class48(int var1, int var2, Component var3) {
		super.field4981 = var1;
		super.field4979 = var2;
		super.field4980 = new int[1 + var1 * var2];
		DataBufferInt var4 = new DataBufferInt(super.field4980, super.field4980.length);
		DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
		WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field4981, super.field4979), var4, (Point)null);
		this.field344 = new BufferedImage(var5, var6, false, new Hashtable());
		this.method972(var3);
		this.method8624();
	}

	final void method972(Component var1) {
		this.field343 = var1;
	}

	public final void method8621(int var1, int var2) {
		this.method967(this.field343.getGraphics(), var1, var2);
	}

	public final void method8620(int var1, int var2, int var3, int var4) {
		this.method968(this.field343.getGraphics(), var1, var2, var3, var4);
	}

	final void method967(Graphics var1, int var2, int var3) {
		try {
			var1.drawImage(this.field344, var2, var3, this.field343);
		} catch (Exception var6) {
			this.field343.repaint();
		}

	}

	final void method968(Graphics var1, int var2, int var3, int var4, int var5) {
		try {
			Shape var7 = var1.getClip();
			var1.clipRect(var2, var3, var4, var5);
			var1.drawImage(this.field344, 0, 0, this.field343);
			var1.setClip(var7);
		} catch (Exception var8) {
			this.field343.repaint();
		}

	}
}
