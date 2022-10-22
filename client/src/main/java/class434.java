public final class class434 {
   class427 field4710;
   class427 field4711;
   class427[] field4712;
   int field4708;
   int field4709 = 0;

   public class434(int var1) {
      this.field4708 = var1;
      this.field4712 = new class427[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class427 var3 = this.field4712[var2] = new class427();
         var3.field4682 = var3;
         var3.field4683 = var3;
      }

   }

   public class427 get(long var1) {
      class427 var3 = this.field4712[(int)(var1 & (long)(this.field4708 - 1))];

      for(this.field4710 = var3.field4682; this.field4710 != var3; this.field4710 = this.field4710.field4682) {
         if (this.field4710.field4681 == var1) {
            class427 var4 = this.field4710;
            this.field4710 = this.field4710.field4682;
            return var4;
         }
      }

      this.field4710 = null;
      return null;
   }

   public void put(class427 var1, long var2) {
      if (var1.field4683 != null) {
         var1.remove();
      }

      class427 var4 = this.field4712[(int)(var2 & (long)(this.field4708 - 1))];
      var1.field4683 = var4.field4683;
      var1.field4682 = var4;
      var1.field4683.field4682 = var1;
      var1.field4682.field4683 = var1;
      var1.field4681 = var2;
   }

   public class427 method7860() {
      this.field4709 = 0;
      return this.method7851();
   }

   public class427 method7851() {
      class427 var1;
      if (this.field4709 > 0 && this.field4711 != this.field4712[this.field4709 - 1]) {
         var1 = this.field4711;
         this.field4711 = var1.field4682;
         return var1;
      } else {
         do {
            if (this.field4709 >= this.field4708) {
               return null;
            }

            var1 = this.field4712[this.field4709++].field4682;
         } while(var1 == this.field4712[this.field4709 - 1]);

         this.field4711 = var1.field4682;
         return var1;
      }
   }
}
