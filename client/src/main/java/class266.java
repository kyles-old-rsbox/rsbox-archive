public class class266 {
   class266() throws Throwable {
      throw new Error();
   }

   public static final void method3531(long var0) {
      if (var0 > 0L) {
         if (var0 % 10L == 0L) {
            method5004(var0 - 1L);
            method5004(1L);
         } else {
            method5004(var0);
         }

      }
   }

   static final void method5004(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
      }

   }
}
