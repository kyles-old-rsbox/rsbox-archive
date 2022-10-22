public class class133 {
   static client field1257;
   static int[] field1250;
   public byte field1256;
   public class472 field1254;
   public int field1249;

   class133() {
   }

   static final void method2411() {
      class453 var1 = client.field1778.field1076;
      var1.method8006();
      int var2 = var1.method8007(8);
      int var3;
      if (var2 < client.field1691) {
         for(var3 = var2; var3 < client.field1691; ++var3) {
            client.field1770[++client.field1769 - 1] = client.field1692[var3];
         }
      }

      if (var2 > client.field1691) {
         throw new RuntimeException("");
      } else {
         client.field1691 = 0;

         for(var3 = 0; var3 < var2; ++var3) {
            int var4 = client.field1692[var3];
            class81 var5 = client.field1902[var4];
            int var6 = var1.method8007(1);
            if (0 == var6) {
               client.field1692[++client.field1691 - 1] = var4;
               var5.field847 = client.field1645;
            } else {
               int var7 = var1.method8007(2);
               if (var7 == 0) {
                  client.field1692[++client.field1691 - 1] = var4;
                  var5.field847 = client.field1645;
                  client.field1694[++client.field1693 - 1] = var4;
               } else {
                  int var8;
                  int var9;
                  if (var7 == 1) {
                     client.field1692[++client.field1691 - 1] = var4;
                     var5.field847 = client.field1645;
                     var8 = var1.method8007(3);
                     var5.method1615(var8, class197.field2114);
                     var9 = var1.method8007(1);
                     if (var9 == 1) {
                        client.field1694[++client.field1693 - 1] = var4;
                     }
                  } else if (var7 == 2) {
                     client.field1692[++client.field1691 - 1] = var4;
                     var5.field847 = client.field1645;
                     if (var1.method8007(1) == 1) {
                        var8 = var1.method8007(3);
                        var5.method1615(var8, class197.field2116);
                        var9 = var1.method8007(3);
                        var5.method1615(var9, class197.field2116);
                     } else {
                        var8 = var1.method8007(3);
                        var5.method1615(var8, class197.field2113);
                     }

                     var8 = var1.method8007(1);
                     if (var8 == 1) {
                        client.field1694[++client.field1693 - 1] = var4;
                     }
                  } else if (var7 == 3) {
                     client.field1770[++client.field1769 - 1] = var4;
                  }
               }
            }
         }

      }
   }
}
