import java.io.IOException;

public class class318 implements class360 {
   public static final class318 field3727 = new class318(0);
   public static final class318 field3728 = new class318(2);
   public static final class318 field3729 = new class318(1);
   public static final class318 field3731 = new class318(-1);
   static int field3732;
   final int field3730;

   class318(int var1) {
      this.field3730 = var1;
   }

   public int method6656() {
      return this.field3730;
   }

   static final void method6075(boolean var0) {
      class349.method6449();
      ++client.field1778.field1077;
      if (client.field1778.field1077 >= 50 || var0) {
         client.field1778.field1077 = 0;
         if (!client.field1697 && client.field1778.method2082() != null) {
            class263 var2 = class185.method3435(class274.field3083, client.field1778.field1071);
            client.field1778.method2078(var2);

            try {
               client.field1778.method2081();
            } catch (IOException var4) {
               client.field1697 = true;
            }
         }

      }
   }
}
