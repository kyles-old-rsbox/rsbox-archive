public class class370 {
	public static class49 field4368;
	int field4363;
	int field4364;
	int field4365;
	int field4366;

	class370() throws Throwable {
		throw new Error();
	}

	public String toString() {
		boolean var1 = true;
		int var2 = 10 - Integer.toString(this.field4366).length();
		int var3 = 10 - Integer.toString(this.field4364).length();
		int var4 = 10 - Integer.toString(this.field4363).length();
		String var5 = "          ".substring(10 - var2);
		String var6 = "          ".substring(10 - var3);
		String var7 = "          ".substring(10 - var4);
		return "    Size: " + this.field4366 + var5 + "Created: " + this.field4363 + var7 + "Total used: " + this.field4364 + var6 + "Max-In-Use: " + this.field4365;
	}
}
