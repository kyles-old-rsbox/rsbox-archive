import java.util.Comparator;

public class class124 implements Comparator {
   static class488[] field1199;
   final boolean field1200;

   public class124(boolean var1) {
      this.field1200 = var1;
   }

   int method2346(class396 var1, class396 var2) {
      return this.field1200 ? var1.field4490 - var2.field4490 : var2.field4490 - var1.field4490;
   }

   public int compare(Object var1, Object var2) {
      return this.method2346((class396)var1, (class396)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
