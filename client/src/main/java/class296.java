import java.io.IOException;

public class class296 extends class427 {
   class286 field3394;
   class288 field3380;
   RawSound field3387;
   class44 field3397;
   int field3379;
   int field3381;
   int field3382;
   int field3383;
   int field3384;
   int field3385;
   int field3386;
   int field3388;
   int field3389;
   int field3390;
   int field3391;
   int field3392;
   int field3393;
   int field3395;
   int field3396;
   int field3398;
   int field3399;

   class296() {
   }

   void method5545() {
      this.field3380 = null;
      this.field3387 = null;
      this.field3394 = null;
      this.field3397 = null;
   }

   static void method5544(class460 var0) {
      if (null != client.field1689) {
         var0.method8107(client.field1689, 0, client.field1689.length);
      } else {
         byte[] var3 = new byte[24];

         try {
            class163.field1498.method8386(0L);
            class163.field1498.method8384(var3);

            int var4;
            for(var4 = 0; var4 < 24 && var3[var4] == 0; ++var4) {
            }

            if (var4 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var5 = 0; var5 < 24; ++var5) {
               var3[var5] = -1;
            }
         }

         var0.method8107(var3, 0, var3.length);
      }
   }
}
