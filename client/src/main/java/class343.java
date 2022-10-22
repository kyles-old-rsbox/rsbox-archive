public class class343 {
   class427 field4229;
   public class427 field4230 = new class427();

   public class343() {
      this.field4230.field4682 = this.field4230;
      this.field4230.field4683 = this.field4230;
   }

   public void method6346() {
      while(true) {
         class427 var1 = this.field4230.field4682;
         if (var1 == this.field4230) {
            this.field4229 = null;
            return;
         }

         var1.remove();
      }
   }

   public void method6347(class427 var1) {
      if (var1.field4683 != null) {
         var1.remove();
      }

      var1.field4683 = this.field4230.field4683;
      var1.field4682 = this.field4230;
      var1.field4683.field4682 = var1;
      var1.field4682.field4683 = var1;
   }

   public void method6345(class427 var1) {
      if (var1.field4683 != null) {
         var1.remove();
      }

      var1.field4683 = this.field4230;
      var1.field4682 = this.field4230.field4682;
      var1.field4683.field4682 = var1;
      var1.field4682.field4683 = var1;
   }

   public static void method6353(class427 var0, class427 var1) {
      if (var0.field4683 != null) {
         var0.remove();
      }

      var0.field4683 = var1.field4683;
      var0.field4682 = var1;
      var0.field4683.field4682 = var0;
      var0.field4682.field4683 = var0;
   }

   public class427 method6367() {
      class427 var1 = this.field4230.field4682;
      if (var1 == this.field4230) {
         return null;
      } else {
         var1.remove();
         return var1;
      }
   }

   public class427 method6351() {
      class427 var1 = this.field4230.field4683;
      if (var1 == this.field4230) {
         return null;
      } else {
         var1.remove();
         return var1;
      }
   }

   public class427 method6356() {
      class427 var1 = this.field4230.field4682;
      if (var1 == this.field4230) {
         this.field4229 = null;
         return null;
      } else {
         this.field4229 = var1.field4682;
         return var1;
      }
   }

   public class427 method6355() {
      class427 var1 = this.field4230.field4683;
      if (var1 == this.field4230) {
         this.field4229 = null;
         return null;
      } else {
         this.field4229 = var1.field4683;
         return var1;
      }
   }

   public class427 method6350() {
      class427 var1 = this.field4229;
      if (var1 == this.field4230) {
         this.field4229 = null;
         return null;
      } else {
         this.field4229 = var1.field4682;
         return var1;
      }
   }

   public class427 method6370() {
      class427 var1 = this.field4229;
      if (var1 == this.field4230) {
         this.field4229 = null;
         return null;
      } else {
         this.field4229 = var1.field4683;
         return var1;
      }
   }
}
