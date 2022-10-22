import java.util.Iterator;

public class class355 implements Iterable {
   class437 field4306;
   public class437 field4305 = new class437();

   public class355() {
      this.field4305.field4724 = this.field4305;
      this.field4305.field4725 = this.field4305;
   }

   public void method6590() {
      while(this.field4305.field4724 != this.field4305) {
         this.field4305.field4724.method7882();
      }

   }

   public void method6592(class437 var1) {
      if (var1.field4725 != null) {
         var1.method7882();
      }

      var1.field4725 = this.field4305.field4725;
      var1.field4724 = this.field4305;
      var1.field4725.field4724 = var1;
      var1.field4724.field4725 = var1;
   }

   public static void method6580(class437 var0, class437 var1) {
      if (var0.field4725 != null) {
         var0.method7882();
      }

      var0.field4725 = var1;
      var0.field4724 = var1.field4724;
      var0.field4725.field4724 = var0;
      var0.field4724.field4725 = var0;
   }

   public class437 method6581() {
      class437 var1 = this.field4305.field4724;
      if (var1 == this.field4305) {
         return null;
      } else {
         var1.method7882();
         return var1;
      }
   }

   public class437 method6582() {
      return this.method6585((class437)null);
   }

   class437 method6585(class437 var1) {
      class437 var2;
      if (var1 == null) {
         var2 = this.field4305.field4724;
      } else {
         var2 = var1;
      }

      if (var2 == this.field4305) {
         this.field4306 = null;
         return null;
      } else {
         this.field4306 = var2.field4724;
         return var2;
      }
   }

   public class437 method6584() {
      class437 var1 = this.field4306;
      if (var1 == this.field4305) {
         this.field4306 = null;
         return null;
      } else {
         this.field4306 = var1.field4724;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class364(this);
   }
}
