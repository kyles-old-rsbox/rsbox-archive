public class class388 {
   class390 field4459;
   int field4460 = 0;
   int field4461 = 0;

   class388(class390 var1, int var2, int var3) {
      this.field4459 = var1;
      this.field4460 = var2;
      this.field4461 = var3;
   }

   public String method7005() {
      if (this.method6986()) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(this.method6987());

         for(int var3 = this.field4460; var3 < this.field4461; ++var3) {
            class383 var4 = this.field4459.method7022(var3);
            var2.append(var4.field4428);
         }

         return var2.toString();
      }
   }

   boolean method6985(int var1) {
      return this.field4459.method7049() == 2 || this.field4459.method7049() == 1 && (!this.field4459.field4472 || var1 != this.field4461 - 1);
   }

   public boolean method6986() {
      return this.field4461 == this.field4460;
   }

   public int method6987() {
      return this.field4461 - this.field4460;
   }

   boolean method6988(class383 var1) {
      if (this.field4459.field4480 == 2) {
         return true;
      } else if (this.field4459.field4480 == 0) {
         return false;
      } else {
         return this.field4459.method7023() != var1;
      }
   }

   int method6998() {
      if (this.method6986()) {
         return 0;
      } else {
         class383 var2 = this.field4459.method7022(this.field4461 - 1);
         if ('\n' == var2.field4428) {
            return 0;
         } else if (this.method6988(var2)) {
            return this.field4459.field4477.field4430[42];
         } else {
            int var3 = this.field4459.field4477.field4430[var2.field4428];
            if (0 == var3) {
               return var2.field4428 == '\t' ? 3 * this.field4459.field4477.field4430[32] : this.field4459.field4477.field4430[32];
            } else {
               return var3;
            }
         }
      }
   }

   public class438 method6990() {
      if (this.method6986()) {
         return new class438(0, 0);
      } else {
         class383 var2 = this.field4459.method7022(this.field4461 - 1);
         return new class438(var2.field4422 + this.method6998(), var2.field4424);
      }
   }

   public class383 method7003(int var1) {
      return var1 >= 0 && var1 < this.method6987() ? this.field4459.method7022(this.field4460 + var1) : null;
   }
}
