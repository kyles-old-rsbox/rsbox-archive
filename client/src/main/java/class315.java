public class class315 {
   static int[] field3720;

   class315() throws Throwable {
      throw new Error();
   }

   static final void method6063(boolean var0) {
      for(int var2 = 0; var2 < client.field1691; ++var2) {
         class81 var3 = client.field1902[client.field1692[var2]];
         if (null != var3 && var3.method1869() && var3.field709.field2289 == var0 && var3.field709.method3870()) {
            int var4 = var3.field827 >> 7;
            int var5 = var3.field802 >> 7;
            if (var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if (1 == var3.field866 && 64 == (var3.field827 & 127) && 64 == (var3.field802 & 127)) {
                  if (client.field1745 == client.field1855[var4][var5]) {
                     continue;
                  }

                  client.field1855[var4][var5] = client.field1745;
               }

               long var6 = class207.method3982(0, 0, 1, !var3.field709.field2282, client.field1692[var2]);
               var3.field872 = client.field1645;
               class145.field1333.method4133(class55.field396, var3.field827, var3.field802, class144.method2498(var3.field827 + (var3.field866 * 64 - 64), var3.field866 * 64 - 64 + var3.field802, class55.field396), 60 + (var3.field866 * 64 - 64), var3, var3.field826, var6, var3.field805);
            }
         }
      }

   }
}
