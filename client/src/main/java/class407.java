public class class407 {
   public int field4528;
   public int field4529;
   public int field4530;
   public int field4531;

   public class407(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   public class407(int var1, int var2, int var3, int var4) {
      this.method7366(var1, var2);
      this.method7367(var3, var4);
   }

   public void method7366(int var1, int var2) {
      this.field4529 = var1;
      this.field4530 = var2;
   }

   public void method7367(int var1, int var2) {
      this.field4531 = var1;
      this.field4528 = var2;
   }

   public boolean method7368(int var1, int var2) {
      return var1 >= this.field4529 && var1 < this.field4531 + this.field4529 && var2 >= this.field4530 && var2 < this.field4528 + this.field4530;
   }

   public String toString() {
      return null;
   }

   public void method7369(class407 var1, class407 var2) {
      this.method7370(var1, var2);
      this.method7365(var1, var2);
   }

   void method7370(class407 var1, class407 var2) {
      var2.field4529 = this.field4529;
      var2.field4531 = this.field4531;
      if (this.field4529 < var1.field4529) {
         var2.field4531 = (var2.field4531 * 646679223 - (var1.field4529 * 646679223 - this.field4529 * 646679223)) * 18445063;
         var2.field4529 = var1.field4529;
      }

      if (var2.method7372() > var1.method7372()) {
         var2.field4531 -= var2.method7372() - var1.method7372();
      }

      if (var2.field4531 < 0) {
         var2.field4531 = 0;
      }

   }

   void method7365(class407 var1, class407 var2) {
      var2.field4530 = this.field4530;
      var2.field4528 = this.field4528;
      if (this.field4530 < var1.field4530) {
         var2.field4528 = (var2.field4528 * 1396884327 - (var1.field4530 * 1396884327 - this.field4530 * 1396884327)) * -1563645865;
         var2.field4530 = var1.field4530;
      }

      if (var2.method7378() > var1.method7378()) {
         var2.field4528 -= var2.method7378() - var1.method7378();
      }

      if (var2.field4528 < 0) {
         var2.field4528 = 0;
      }

   }

   int method7372() {
      return this.field4531 + this.field4529;
   }

   int method7378() {
      return this.field4528 + this.field4530;
   }
}
