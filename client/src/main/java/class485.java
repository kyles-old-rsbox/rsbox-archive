import java.util.Comparator;

public class class485 implements Comparator {
   final boolean field5004;

   public class485(boolean var1) {
      this.field5004 = var1;
   }

   int method8729(class400 var1, class400 var2) {
      return this.field5004 ? var1.method7225().method8450(var2.method7225()) : var2.method7225().method8450(var1.method7225());
   }

   public int compare(Object var1, Object var2) {
      return this.method8729((class400)var1, (class400)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
