public class class84 implements Runnable {
	static class488 field745;
	static class488 field749;
	static class488[] field752;
	boolean field746;
	int index;
	int[] field748;
	int[] field750;
	Object field755;
	long[] field754;

	class84() {
		this.field746 = true;
		this.field755 = new Object();
		this.index = 0;
		this.field748 = new int[500];
		this.field750 = new int[500];
		this.field754 = new long[500];
	}

	public void run() {
		for (; this.field746; class266.method3531(50L)) {
			synchronized(this.field755) {
				if (this.index < 500) {
					this.field748[this.index] = MouseManager.field284;
					this.field750[this.index] = MouseManager.field285;
					this.field754[this.index] = MouseManager.field286;
					++this.index;
				}
			}
		}

	}
}
