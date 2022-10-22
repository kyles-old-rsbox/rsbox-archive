import java.util.Comparator;

public class class471 implements Comparator {
   final boolean field4947;

   public class471(boolean var1) {
      this.field4947 = var1;
   }

   int method8429(class400 var1, class400 var2) {
      return this.field4947 ? var1.method7229(var2) : var2.method7229(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method8429((class400)var1, (class400)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
