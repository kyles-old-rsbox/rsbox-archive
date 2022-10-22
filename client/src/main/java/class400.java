public class class400 implements Comparable {
   class472 field4503;
   class472 field4504;

   class400() {
   }

   public class472 method7225() {
      return this.field4503;
   }

   public String method7242() {
      return null == this.field4503 ? "" : this.field4503.method8444();
   }

   public String method7227() {
      return null == this.field4504 ? "" : this.field4504.method8444();
   }

   void method7228(class472 var1, class472 var2) {
      if (null == var1) {
         throw new NullPointerException();
      } else {
         this.field4503 = var1;
         this.field4504 = var2;
      }
   }

   public int method7229(class400 var1) {
      return this.field4503.method8450(var1.field4503);
   }

   public int compareTo(Object var1) {
      return this.method7229((class400)var1);
   }
}
