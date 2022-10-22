public class class160 extends class437 {
   public static class160[] field1464;
   public static class319 field1467;
   public static int field1469;
   static class284 field1466 = new class284(256);
   byte[] field1486;
   int field1465 = Integer.MIN_VALUE;
   int field1478 = -1;
   int field1479 = Integer.MAX_VALUE;
   int field1480 = Integer.MAX_VALUE;
   int field1482 = Integer.MIN_VALUE;
   int[] field1474;
   int[] field1485;
   public boolean field1463 = false;
   public boolean field1471 = true;
   public class183 field1484;
   public class194 field1483;
   public int field1468 = -1;
   public int field1472 = 0;
   public int field1475;
   public int field1487;
   public String field1470;
   public String field1477;
   public String[] field1476 = new String[5];
   public final int field1481;

   public class160(int var1) {
      this.field1483 = class194.field2050;
      this.field1484 = class183.field1939;
      this.field1487 = -1;
      this.field1481 = var1;
   }

   public static class189 method2660(int var0) {
      class189 var2 = (class189)class189.field1991.method5439((long)var0);
      if (null != var2) {
         return var2;
      } else {
         byte[] var3 = class189.field1989.method6167(12, var0);
         var2 = new class189();
         if (var3 != null) {
            var2.method3467(new class460(var3));
         }

         var2.method3469();
         class189.field1991.method5434(var2, (long)var0);
         return var2;
      }
   }

   public void method2649(class460 var1) {
      while(true) {
         int var3 = var1.method8134();
         if (var3 == 0) {
            return;
         }

         this.method2663(var1, var3);
      }
   }

   void method2663(class460 var1, int var2) {
      if (var2 == 1) {
         this.field1468 = var1.method8133();
      } else if (2 == var2) {
         this.field1478 = var1.method8133();
      } else if (var2 == 3) {
         this.field1470 = var1.method8124();
      } else if (var2 == 4) {
         this.field1475 = var1.method8305();
      } else if (var2 == 5) {
         var1.method8305();
      } else if (var2 == 6) {
         this.field1472 = var1.method8134();
      } else {
         int var4;
         if (7 == var2) {
            var4 = var1.method8134();
            if ((var4 & 1) == 0) {
               this.field1471 = false;
            }

            if ((var4 & 2) == 2) {
               this.field1463 = true;
            }
         } else if (8 == var2) {
            var1.method8134();
         } else if (var2 >= 10 && var2 <= 14) {
            this.field1476[var2 - 10] = var1.method8124();
         } else if (var2 == 15) {
            var4 = var1.method8134();
            this.field1474 = new int[var4 * 2];

            int var5;
            for(var5 = 0; var5 < var4 * 2; ++var5) {
               this.field1474[var5] = var1.method8197();
            }

            var1.method8119();
            var5 = var1.method8134();
            this.field1485 = new int[var5];

            int var6;
            for(var6 = 0; var6 < this.field1485.length; ++var6) {
               this.field1485[var6] = var1.method8119();
            }

            this.field1486 = new byte[var4];

            for(var6 = 0; var6 < var4; ++var6) {
               this.field1486[var6] = var1.method8280();
            }
         } else if (var2 != 16) {
            if (var2 == 17) {
               this.field1477 = var1.method8124();
            } else if (var2 == 18) {
               var1.method8133();
            } else if (var2 == 19) {
               this.field1487 = var1.method8115();
            } else if (var2 == 21) {
               var1.method8119();
            } else if (22 == var2) {
               var1.method8119();
            } else if (23 == var2) {
               var1.method8134();
               var1.method8134();
               var1.method8134();
            } else if (24 == var2) {
               var1.method8197();
               var1.method8197();
            } else if (var2 == 25) {
               var1.method8133();
            } else if (var2 == 28) {
               var1.method8134();
            } else if (29 == var2) {
               this.field1483 = (class194)class217.method4362(class194.method1991(), var1.method8134());
            } else if (var2 == 30) {
               this.field1484 = (class183)class217.method4362(class183.method2270(), var1.method8134());
            }
         }
      }

   }

   public void method2647() {
      if (null != this.field1474) {
         for(int var2 = 0; var2 < this.field1474.length; var2 += 2) {
            if (this.field1474[var2] < this.field1479) {
               this.field1479 = this.field1474[var2];
            } else if (this.field1474[var2] > this.field1465) {
               this.field1465 = this.field1474[var2];
            }

            if (this.field1474[1 + var2] < this.field1480) {
               this.field1480 = this.field1474[1 + var2];
            } else if (this.field1474[1 + var2] > this.field1482) {
               this.field1482 = this.field1474[1 + var2];
            }
         }
      }

   }

   public class473 method2644(boolean var1) {
      int var3 = var1 ? 748178793 * this.field1478 * -1842539815 : -1983314433 * this.field1468 * 840104447;
      return this.method2645(var3);
   }

   class473 method2645(int var1) {
      if (var1 < 0) {
         return null;
      } else {
         class473 var3 = (class473)field1466.method5439((long)var1);
         if (null != var3) {
            return var3;
         } else {
            var3 = class389.method7007(field1467, var1, 0);
            if (var3 != null) {
               field1466.method5434(var3, (long)var1);
            }

            return var3;
         }
      }
   }

   public int method2646() {
      return this.field1481;
   }

   public static void method1424() {
      field1466.method5437();
   }
}
