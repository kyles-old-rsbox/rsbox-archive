public class class435 {
   public static int field4713;
   static int field4721;
   boolean field4720 = false;
   class319 field4718;
   int field4714 = 0;
   String field4717;

   class435(class319 var1) {
      this.field4718 = var1;
   }

   void method7865(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1 != this.field4717) {
            this.field4717 = var1;
            this.field4714 = 0;
            this.field4720 = false;
            this.method7866();
         }
      }
   }

   int method7866() {
      if (this.field4714 < 33) {
         if (!this.field4718.method6100(class242.field2833.field2837, this.field4717)) {
            return this.field4714;
         }

         this.field4714 = 33;
      }

      if (33 == this.field4714) {
         if (this.field4718.method6147(class242.field2832.field2837, this.field4717) && !this.field4718.method6100(class242.field2832.field2837, this.field4717)) {
            return this.field4714;
         }

         this.field4714 = 66;
      }

      if (66 == this.field4714) {
         if (!this.field4718.method6100(this.field4717, class242.field2836.field2837)) {
            return this.field4714;
         }

         this.field4714 = 100;
         this.field4720 = true;
      }

      return this.field4714;
   }

   boolean method7867() {
      return this.field4720;
   }

   int method7864() {
      return this.field4714;
   }
}
