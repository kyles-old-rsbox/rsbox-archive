import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class class459 extends class437 {
	class451[] field4876;
	List field4875;

	static int method8101(int var0, int var1) {
		class87 var3 = (class87)class87.field782.method7855((long)var0);
		if (null == var3) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var3.field779.length ? var3.field779[var1] : -1;
		}
	}

	public class459(class319 var1, int var2, int var3) {
		byte[] var4 = var1.method6175(var2, var3 + 1);
		this.method8092(new Buffer(var4));
	}

	public class459(class319 var1, int var2) {
		byte[] var3 = var1.method6175(var2, 0);
		this.method8092(new Buffer(var3));
	}

	void method8092(Buffer var1) {
		int var3 = var1.method8142();
		this.field4876 = new class451[var3];
		this.field4875 = new ArrayList(var3);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.field4876[var4] = (class451)class217.fromValue(class451.method7984(), var1.readUnsignedByte());
			int var5 = var1.method8142();
			HashMap var6 = new HashMap(var5);

			while (var5-- > 0) {
				Object var7 = this.field4876[var4].method7974(var1);
				int var8 = var1.method8142();
				ArrayList var9 = new ArrayList();

				while (var8-- > 0) {
					int var10 = var1.method8142();
					var9.add(var10);
				}

				var6.put(var7, var9);
			}

			this.field4875.add(var4, var6);
		}

	}

	public List method8098(Object var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		Map var4 = (Map)this.field4875.get(var2);
		return (List)var4.get(var1);
	}
}
