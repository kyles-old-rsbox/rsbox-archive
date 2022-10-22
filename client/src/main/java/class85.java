import java.util.concurrent.Callable;

public class class85 implements Callable {
   class85() {
   }

   public Object call() {
      return class18.method219();
   }

   static int method1803(int var0, int var1) {
      for(int var3 = 0; var3 < 8; ++var3) {
         if (var1 <= 30 + var0) {
            return var3;
         }

         var0 += 30;
         var0 += var3 != 1 && 3 != var3 ? 5 : 20;
      }

      return 0;
   }
}
