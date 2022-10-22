import java.awt.Image;

public class class80 implements class360 {
   protected static String field706;
   static Image field707;
   static final class80 field697 = new class80(2);
   static final class80 field698 = new class80(1);
   static final class80 field701 = new class80(4);
   static final class80 field703 = new class80(3);
   static final class80 field705 = new class80(0);
   final int field702;

   public static int method1613(int var0, int var1, int var2, int var3, int var4, int var5) {
      if (1 == (var5 & 1)) {
         int var7 = var3;
         var3 = var4;
         var4 = var7;
      }

      var2 &= 3;
      if (0 == var2) {
         return var0;
      } else if (var2 == 1) {
         return var1;
      } else {
         return 2 == var2 ? 7 - var0 - (var3 - 1) : 7 - var1 - (var4 - 1);
      }
   }

   static class80[] method1045() {
      return new class80[]{field697, field701, field705, field698, field703};
   }

   class80(int var1) {
      this.field702 = var1;
   }

   public int method6656() {
      return this.field702;
   }
}
