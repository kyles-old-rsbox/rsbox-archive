import java.util.Comparator;
import java.util.Map.Entry;

class class23 implements Comparator {
	// $FF: synthetic field
	final class12 this$0;

	class23(class12 var1) {
		this.this$0 = var1;
	}

	int method327(Entry var1, Entry var2) {
		return ((Float)var2.getValue()).compareTo((Float)var1.getValue());
	}

	public int compare(Object var1, Object var2) {
		return this.method327((Entry)var1, (Entry)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
