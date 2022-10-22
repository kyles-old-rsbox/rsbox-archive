public abstract class class51 extends class427 {
   class51 field356;
   class56 field358;
   int field357;
   volatile boolean field359 = true;

   protected class51() {
   }

   int method1002() {
      return 255;
   }

   final void method1006(int[] var1, int var2, int var3) {
      if (this.field359) {
         this.method1005(var1, var2, var3);
      } else {
         this.method1001(var3);
      }

   }

   protected abstract void method1001(int var1);

   protected abstract int method1003();

   protected abstract class51 method1004();

   protected abstract void method1005(int[] var1, int var2, int var3);

   protected abstract class51 method1007();
}
