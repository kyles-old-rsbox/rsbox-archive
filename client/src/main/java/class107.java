import java.io.IOException;

public class class107 {
   boolean field1067 = true;
   class283 field1072;
   class283 field1073 = null;
   class283 field1079;
   class283 field1080;
   class350 field1068 = new class350();
   class401 field1074;
   class453 field1076 = new class453(40000);
   class460 field1078 = new class460(5000);
   int field1069 = 0;
   int field1070 = 0;
   int field1075 = 0;
   int field1077 = 0;
   public class479 field1071;

   public static byte method2099(char var0) {
      byte var2;
      if (var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var2 = (byte)var0;
      } else if (var0 == 8364) {
         var2 = -128;
      } else if (8218 == var0) {
         var2 = -126;
      } else if (402 == var0) {
         var2 = -125;
      } else if (8222 == var0) {
         var2 = -124;
      } else if (8230 == var0) {
         var2 = -123;
      } else if (8224 == var0) {
         var2 = -122;
      } else if (var0 == 8225) {
         var2 = -121;
      } else if (var0 == 710) {
         var2 = -120;
      } else if (var0 == 8240) {
         var2 = -119;
      } else if (var0 == 352) {
         var2 = -118;
      } else if (var0 == 8249) {
         var2 = -117;
      } else if (var0 == 338) {
         var2 = -116;
      } else if (381 == var0) {
         var2 = -114;
      } else if (var0 == 8216) {
         var2 = -111;
      } else if (8217 == var0) {
         var2 = -110;
      } else if (8220 == var0) {
         var2 = -109;
      } else if (var0 == 8221) {
         var2 = -108;
      } else if (var0 == 8226) {
         var2 = -107;
      } else if (var0 == 8211) {
         var2 = -106;
      } else if (var0 == 8212) {
         var2 = -105;
      } else if (732 == var0) {
         var2 = -104;
      } else if (var0 == 8482) {
         var2 = -103;
      } else if (var0 == 353) {
         var2 = -102;
      } else if (8250 == var0) {
         var2 = -101;
      } else if (339 == var0) {
         var2 = -100;
      } else if (var0 == 382) {
         var2 = -98;
      } else if (376 == var0) {
         var2 = -97;
      } else {
         var2 = 63;
      }

      return var2;
   }

   class107() {
   }

   final void method2076() {
      this.field1068.method6465();
      this.field1069 = 0;
   }

   static void method2079(int var0) {
   }

   final void method2081() throws IOException {
      if (null != this.field1074 && this.field1069 > 0) {
         this.field1078.field4878 = 0;

         while(true) {
            class263 var2 = (class263)this.field1068.method6457();
            if (null == var2 || var2.field2987 > this.field1078.field4881.length - this.field1078.field4878) {
               this.field1074.method7251(this.field1078.field4881, 0, this.field1078.field4878);
               this.field1077 = 0;
               break;
            }

            this.field1078.method8107(var2.field2984.field4881, 0, var2.field2987);
            this.field1069 -= var2.field2987;
            var2.remove();
            var2.field2984.method8096();
            var2.method5153();
         }
      }

   }

   public final void method2078(class263 var1) {
      this.field1068.method6454(var1);
      var1.field2987 = var1.field2984.field4878;
      var1.field2984.field4878 = 0;
      this.field1069 += var1.field2987;
   }

   void method2097(class401 var1) {
      this.field1074 = var1;
   }

   void method2080() {
      if (null != this.field1074) {
         this.field1074.method7252();
         this.field1074 = null;
      }

   }

   void method2100() {
      this.field1074 = null;
   }

   class401 method2082() {
      return this.field1074;
   }
}
