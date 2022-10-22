public class class402 {
   float field4506;
   float field4507;
   float field4508;

   static {
      new class402(0.0F, 0.0F, 0.0F);
      new class402(1.0F, 1.0F, 1.0F);
      new class402(1.0F, 0.0F, 0.0F);
      new class402(0.0F, 1.0F, 0.0F);
      new class402(0.0F, 0.0F, 1.0F);
      class107.method2079(100);
   }

   class402(float var1, float var2, float var3) {
      this.field4507 = var1;
      this.field4508 = var2;
      this.field4506 = var3;
   }

   final float method7268() {
      return (float)Math.sqrt((double)(this.field4506 * this.field4506 + this.field4508 * this.field4508 + this.field4507 * this.field4507));
   }

   public String toString() {
      return this.field4507 + ", " + this.field4508 + ", " + this.field4506;
   }
}
