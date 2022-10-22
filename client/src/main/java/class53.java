import java.util.Iterator;

public class class53 {
   static int[] field381;
   int field377 = 0;
   final class463 field375;
   public final class381 field376;
   public final class389 field380;

   class53(class463 var1) {
      this.field375 = var1;
      this.field380 = new class389(var1);
      this.field376 = new class381(var1);
   }

   public static class415 method1114() {
      synchronized(class415.field4595) {
         if (class415.field4594 == 0) {
            return new class415();
         } else {
            class415.field4595[--class415.field4594].method7538();
            return class415.field4595[class415.field4594];
         }
      }
   }

   boolean method1085() {
      return 2 == this.field377;
   }

   final void method1109() {
      this.field377 = 1;
   }

   final void method1046(class460 var1, int var2) {
      this.field380.method7011(var1, var2);
      this.field377 = 2;

      for(int var4 = 0; var4 < class102.field1012; ++var4) {
         class93 var5 = client.field1763[class102.field1013[var4]];
         var5.method1908();
      }

      Iterator var7 = class110.field1089.iterator();

      while(var7.hasNext()) {
         class63 var6 = (class63)var7.next();
         var6.method1342();
      }

      if (null != class73.field603) {
         class73.field603.method6700();
      }

   }

   final void method1047() {
      for(class369 var2 = (class369)this.field380.field4466.method6376(); var2 != null; var2 = (class369)this.field380.field4466.method6373()) {
         if ((long)var2.field4361 < class272.method2046() / 1000L - 5L) {
            if (var2.field4360 > 0) {
               class42.method773(5, "", var2.field4359 + class338.field3942);
            }

            if (0 == var2.field4360) {
               class42.method773(5, "", var2.field4359 + class338.field4052);
            }

            var2.method7804();
         }
      }

   }

   static void method1092(class336 var0, int var1) {
      if (var0.field3883) {
         if (var1 <= class324.field3786) {
            throw new RuntimeException("");
         }

         if (var1 < class324.field3791) {
            class324.field3791 = var1;
         }
      } else {
         if (var1 >= class324.field3791) {
            throw new RuntimeException("");
         }

         if (var1 > class324.field3786) {
            class324.field3786 = var1;
         }
      }

      if (class110.field1090 != null) {
         class110.field1090.field4878 = var1 * 8 + 5;
         if (class110.field1090.field4878 >= class110.field1090.field4881.length) {
            if (!var0.field3883) {
               throw new RuntimeException("");
            }

            var0.method6273();
         } else {
            int var3 = class110.field1090.method8119();
            int var4 = class110.field1090.method8119();
            var0.method6290(var3, var4);
         }

      } else {
         class169.method2714((class336)null, 255, 255, 0, (byte)0, true);
         class324.field3789[var1] = var0;
      }
   }

   final void method1048() {
      this.field377 = 0;
      this.field380.method7278();
      this.field376.method7278();
   }

   final boolean method1071(class472 var1, boolean var2) {
      if (var1 == null) {
         return false;
      } else if (var1.equals(class291.field3364.field910)) {
         return true;
      } else {
         return this.field380.method7010(var1, var2);
      }
   }

   final boolean method1049(class472 var1) {
      if (null == var1) {
         return false;
      } else {
         return this.field376.method7352(var1);
      }
   }

   final void method1050(String var1) {
      if (var1 != null) {
         class472 var3 = new class472(var1, this.field375);
         if (var3.method8442()) {
            if (this.method1098()) {
               method2348();
            } else if (class291.field3364.field910.equals(var3)) {
               method229(class338.field3924);
            } else if (this.method1071(var3, false)) {
               method2355(var1);
            } else if (this.method1049(var3)) {
               method5451(var1);
            } else {
               method959(var1);
            }
         }
      }
   }

   static final void method229(String var0) {
      class42.method773(30, "", var0);
   }

   static final void method2348() {
      method229(class338.field4035);
   }

   static final void method2355(String var0) {
      method229(var0 + class338.field4071);
   }

   static final void method5451(String var0) {
      method229(class338.field4076 + var0 + class338.field4077);
   }

   static final void method959(String var0) {
      class263 var2 = class185.method3435(class274.field3074, client.field1778.field1071);
      var2.field2984.method8097(class460.method1887(var0));
      var2.field2984.method8104(var0);
      client.field1778.method2078(var2);
   }

   final boolean method1098() {
      return this.field380.method7322() || this.field380.method7332() >= 200 && 1 != client.field1921;
   }

   final void method1052(String var1) {
      if (null != var1) {
         class472 var3 = new class472(var1, this.field375);
         if (var3.method8442()) {
            if (this.method1053()) {
               method229(class338.field4072);
            } else if (class291.field3364.field910.equals(var3)) {
               method229(class338.field4177);
            } else if (this.method1049(var3)) {
               method7276(var1);
            } else if (this.method1071(var3, false)) {
               method1812(var1);
            } else {
               class263 var4 = class185.method3435(class274.field3128, client.field1778.field1071);
               var4.field2984.method8097(class460.method1887(var1));
               var4.field2984.method8104(var1);
               client.field1778.method2078(var4);
            }
         }
      }
   }

   static final void method7276(String var0) {
      method229(var0 + class338.field4080);
   }

   static final void method1812(String var0) {
      method229(class338.field4078 + var0 + class338.field4079);
   }

   final boolean method1053() {
      return this.field376.method7322() || this.field376.method7332() >= 100 && 1 != client.field1921;
   }

   final void method1069(String var1) {
      if (var1 != null) {
         class472 var3 = new class472(var1, this.field375);
         if (var3.method8442()) {
            if (this.field380.method7285(var3)) {
               client.field1844 = client.field1878;
               class263 var4 = class185.method3435(class274.field3129, client.field1778.field1071);
               var4.field2984.method8097(class460.method1887(var1));
               var4.field2984.method8104(var1);
               client.field1778.method2078(var4);
            }

            for(int var6 = 0; var6 < class102.field1012; ++var6) {
               class93 var5 = client.field1763[class102.field1013[var6]];
               var5.method1908();
            }

            Iterator var7 = class110.field1089.iterator();

            while(var7.hasNext()) {
               class63 var8 = (class63)var7.next();
               var8.method1342();
            }

            if (null != class73.field603) {
               class73.field603.method6700();
            }

         }
      }
   }

   public static void method1112() {
      try {
         class163.field1503.method8390();

         for(int var1 = 0; var1 < class163.field1502; ++var1) {
            class163.field1510[var1].method8390();
         }

         class163.field1509.method8390();
         class163.field1498.method8390();
      } catch (Exception var2) {
      }

   }

   final void method1055(String var1) {
      if (var1 != null) {
         class472 var3 = new class472(var1, this.field375);
         if (var3.method8442()) {
            if (this.field376.method7285(var3)) {
               client.field1844 = client.field1878;
               class263 var4 = class185.method3435(class274.field3102, client.field1778.field1071);
               var4.field2984.method8097(class460.method1887(var1));
               var4.field2984.method8104(var1);
               client.field1778.method2078(var4);
            }

            class442.method7913();
         }
      }
   }

   static final void method2855(String var0, int var1) {
      class263 var3 = class185.method3435(class274.field3117, client.field1778.field1071);
      var3.field2984.method8097(class460.method1887(var0) + 1);
      var3.field2984.method8257(var1);
      var3.field2984.method8104(var0);
      client.field1778.method2078(var3);
   }

   final boolean method1056(class472 var1) {
      class380 var3 = (class380)this.field380.method7282(var1);
      return null != var3 && var3.method7167();
   }
}
