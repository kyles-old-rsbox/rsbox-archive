import java.util.Comparator;

final class class341 implements Comparator {
   int method6310(class328 var1, class328 var2) {
      return var1.field3807.field4253 < var2.field3807.field4253 ? -1 : (var2.field3807.field4253 == var1.field3807.field4253 ? 0 : 1);
   }

   public int compare(Object var1, Object var2) {
      return this.method6310((class328)var1, (class328)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
