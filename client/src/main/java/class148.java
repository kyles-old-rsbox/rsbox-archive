public class class148 {
   boolean field1358;
   boolean field1359;
   class421 field1382;
   int field1361 = 0;
   int field1363 = 0;
   int[] field1362;
   int[] field1365;
   long field1360;
   long[] field1379;
   long[] field1380;
   public boolean field1364;
   public boolean[] field1375;
   public byte field1357;
   public byte field1367;
   public byte field1368;
   public byte field1377;
   public byte[] field1381;
   public int field1369;
   public int field1370 = -1;
   public int field1376 = -1;
   public int field1378;
   public int[] field1374;
   public String field1372 = null;
   public String[] field1371;
   public String[] field1373;

   public class148(class460 var1) {
      this.method2542(var1);
   }

   void method2523(int var1) {
      if (this.field1358) {
         if (this.field1380 != null) {
            System.arraycopy(this.field1380, 0, this.field1380 = new long[var1], 0, this.field1369);
         } else {
            this.field1380 = new long[var1];
         }
      }

      if (this.field1359) {
         if (this.field1373 != null) {
            System.arraycopy(this.field1373, 0, this.field1373 = new String[var1], 0, this.field1369);
         } else {
            this.field1373 = new String[var1];
         }
      }

      if (null != this.field1381) {
         System.arraycopy(this.field1381, 0, this.field1381 = new byte[var1], 0, this.field1369);
      } else {
         this.field1381 = new byte[var1];
      }

      if (null != this.field1365) {
         System.arraycopy(this.field1365, 0, this.field1365 = new int[var1], 0, this.field1369);
      } else {
         this.field1365 = new int[var1];
      }

      if (this.field1374 != null) {
         System.arraycopy(this.field1374, 0, this.field1374 = new int[var1], 0, this.field1369);
      } else {
         this.field1374 = new int[var1];
      }

      if (null != this.field1375) {
         System.arraycopy(this.field1375, 0, this.field1375 = new boolean[var1], 0, this.field1369);
      } else {
         this.field1375 = new boolean[var1];
      }

   }

   void method2524(int var1) {
      if (this.field1358) {
         if (null != this.field1379) {
            System.arraycopy(this.field1379, 0, this.field1379 = new long[var1], 0, this.field1378);
         } else {
            this.field1379 = new long[var1];
         }
      }

      if (this.field1359) {
         if (null != this.field1371) {
            System.arraycopy(this.field1371, 0, this.field1371 = new String[var1], 0, this.field1378);
         } else {
            this.field1371 = new String[var1];
         }
      }

   }

   public int method2525(String var1) {
      if (null != var1 && var1.length() != 0) {
         for(int var3 = 0; var3 < this.field1369; ++var3) {
            if (this.field1373[var3].equals(var1)) {
               return var3;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   public int method2562(int var1, int var2, int var3) {
      int var5 = var3 == 31 ? -1 : (1 << var3 + 1) - 1;
      return (this.field1365[var1] & var5) >>> var2;
   }

   public Integer method2569(int var1) {
      if (null == this.field1382) {
         return null;
      } else {
         class427 var3 = this.field1382.method7781((long)var1);
         return null != var3 && var3 instanceof class426 ? new Integer(((class426)var3).field4680) : null;
      }
   }

   public int[] method2528() {
      if (this.field1362 == null) {
         String[] var2 = new String[this.field1369];
         this.field1362 = new int[this.field1369];

         for(int var3 = 0; var3 < this.field1369; this.field1362[var3] = var3++) {
            var2[var3] = this.field1373[var3];
            if (var2[var3] != null) {
               var2[var3] = var2[var3].toLowerCase();
            }
         }

         class446.method2038(var2, this.field1362);
      }

      return this.field1362;
   }

   void method2529(long var1, String var3, int var4) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (var1 > 0L != this.field1358) {
         throw new RuntimeException("");
      } else if (this.field1359 != (var3 != null)) {
         throw new RuntimeException("");
      } else {
         if (var1 > 0L && (null == this.field1380 || this.field1369 >= this.field1380.length) || var3 != null && (this.field1373 == null || this.field1369 >= this.field1373.length)) {
            this.method2523(5 + this.field1369);
         }

         if (null != this.field1380) {
            this.field1380[this.field1369] = var1;
         }

         if (this.field1373 != null) {
            this.field1373[this.field1369] = var3;
         }

         if (-1 == this.field1376) {
            this.field1376 = this.field1369;
            this.field1381[this.field1369] = 126;
         } else {
            this.field1381[this.field1369] = 0;
         }

         this.field1365[this.field1369] = 0;
         this.field1374[this.field1369] = var4;
         this.field1375[this.field1369] = false;
         ++this.field1369;
         this.field1362 = null;
      }
   }

   void method2530(int var1) {
      if (var1 >= 0 && var1 < this.field1369) {
         --this.field1369;
         this.field1362 = null;
         if (0 == this.field1369) {
            this.field1380 = null;
            this.field1373 = null;
            this.field1381 = null;
            this.field1365 = null;
            this.field1374 = null;
            this.field1375 = null;
            this.field1376 = -1;
            this.field1370 = -1;
         } else {
            System.arraycopy(this.field1381, var1 + 1, this.field1381, var1, this.field1369 - var1);
            System.arraycopy(this.field1365, 1 + var1, this.field1365, var1, this.field1369 - var1);
            System.arraycopy(this.field1374, 1 + var1, this.field1374, var1, this.field1369 - var1);
            System.arraycopy(this.field1375, var1 + 1, this.field1375, var1, this.field1369 - var1);
            if (null != this.field1380) {
               System.arraycopy(this.field1380, 1 + var1, this.field1380, var1, this.field1369 - var1);
            }

            if (this.field1373 != null) {
               System.arraycopy(this.field1373, var1 + 1, this.field1373, var1, this.field1369 - var1);
            }

            this.method2531();
         }

      } else {
         throw new RuntimeException("");
      }
   }

   public static boolean method2543(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   void method2531() {
      if (0 == this.field1369) {
         this.field1376 = -1;
         this.field1370 = -1;
      } else {
         this.field1376 = -1;
         this.field1370 = -1;
         int var2 = 0;
         byte var3 = this.field1381[0];

         for(int var4 = 1; var4 < this.field1369; ++var4) {
            if (this.field1381[var4] > var3) {
               if (var3 == 125) {
                  this.field1370 = var2;
               }

               var2 = var4;
               var3 = this.field1381[var4];
            } else if (-1 == this.field1370 && this.field1381[var4] == 125) {
               this.field1370 = var4;
            }
         }

         this.field1376 = var2;
         if (this.field1376 != -1) {
            this.field1381[this.field1376] = 126;
         }

      }
   }

   void method2571(long var1, String var3) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (this.field1358 != var1 > 0L) {
         throw new RuntimeException("");
      } else if (this.field1359 != (null != var3)) {
         throw new RuntimeException("");
      } else {
         if (var1 > 0L && (null == this.field1379 || this.field1378 >= this.field1379.length) || var3 != null && (this.field1371 == null || this.field1378 >= this.field1371.length)) {
            this.method2524(5 + this.field1378);
         }

         if (this.field1379 != null) {
            this.field1379[this.field1378] = var1;
         }

         if (null != this.field1371) {
            this.field1371[this.field1378] = var3;
         }

         ++this.field1378;
      }
   }

   void method2533(int var1) {
      --this.field1378;
      if (0 == this.field1378) {
         this.field1379 = null;
         this.field1371 = null;
      } else {
         if (null != this.field1379) {
            System.arraycopy(this.field1379, 1 + var1, this.field1379, var1, this.field1378 - var1);
         }

         if (null != this.field1371) {
            System.arraycopy(this.field1371, 1 + var1, this.field1371, var1, this.field1378 - var1);
         }
      }

   }

   int method2534(int var1, byte var2) {
      if (126 != var2 && 127 != var2) {
         if (this.field1376 == var1 && (-1 == this.field1370 || this.field1381[this.field1370] < 125)) {
            return -1;
         } else if (this.field1381[var1] == var2) {
            return -1;
         } else {
            this.field1381[var1] = var2;
            this.method2531();
            return var1;
         }
      } else {
         return -1;
      }
   }

   boolean method2535(int var1) {
      if (this.field1376 != var1 && this.field1381[var1] != 126) {
         this.field1381[this.field1376] = 125;
         this.field1370 = this.field1376;
         this.field1381[var1] = 126;
         this.field1376 = var1;
         return true;
      } else {
         return false;
      }
   }

   int method2551(int var1, boolean var2) {
      if (this.field1375[var1] == var2) {
         return -1;
      } else {
         this.field1375[var1] = var2;
         return var1;
      }
   }

   int method2537(int var1, int var2, int var3, int var4) {
      int var6 = (1 << var3) - 1;
      int var7 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
      int var8 = var7 ^ var6;
      var2 <<= var3;
      var2 &= var8;
      int var9 = this.field1365[var1];
      if (var2 == (var9 & var8)) {
         return -1;
      } else {
         var9 &= ~var8;
         this.field1365[var1] = var9 | var2;
         return var1;
      }
   }

   boolean method2565(int var1, int var2) {
      if (this.field1382 != null) {
         class427 var4 = this.field1382.method7781((long)var1);
         if (var4 != null) {
            if (var4 instanceof class426) {
               class426 var5 = (class426)var4;
               if (var2 == var5.field4680) {
                  return false;
               }

               var5.field4680 = var2;
               return true;
            }

            var4.remove();
         }
      } else {
         this.field1382 = new class421(4);
      }

      this.field1382.method7774(new class426(var2), (long)var1);
      return true;
   }

   boolean method2539(int var1, int var2, int var3, int var4) {
      int var6 = (1 << var3) - 1;
      int var7 = var4 == 31 ? -1 : (1 << 1 + var4) - 1;
      int var8 = var7 ^ var6;
      var2 <<= var3;
      var2 &= var8;
      if (null != this.field1382) {
         class427 var9 = this.field1382.method7781((long)var1);
         if (var9 != null) {
            if (var9 instanceof class426) {
               class426 var10 = (class426)var9;
               if (var2 == (var10.field4680 & var8)) {
                  return false;
               }

               var10.field4680 &= ~var8;
               var10.field4680 |= var2;
               return true;
            }

            var9.remove();
         }
      } else {
         this.field1382 = new class421(4);
      }

      this.field1382.method7774(new class426(var2), (long)var1);
      return true;
   }

   boolean method2540(int var1, long var2) {
      if (this.field1382 != null) {
         class427 var4 = this.field1382.method7781((long)var1);
         if (null != var4) {
            if (var4 instanceof class424) {
               class424 var5 = (class424)var4;
               if (var2 == var5.field4676) {
                  return false;
               }

               var5.field4676 = var2;
               return true;
            }

            var4.remove();
         }
      } else {
         this.field1382 = new class421(4);
      }

      this.field1382.method7774(new class424(var2), (long)var1);
      return true;
   }

   boolean method2541(int var1, String var2) {
      if (var2 == null) {
         var2 = "";
      } else if (var2.length() > 80) {
         var2 = var2.substring(0, 80);
      }

      if (null != this.field1382) {
         class427 var4 = this.field1382.method7781((long)var1);
         if (null != var4) {
            if (var4 instanceof class418) {
               class418 var5 = (class418)var4;
               if (var5.field4601 instanceof String) {
                  if (var2.equals(var5.field4601)) {
                     return false;
                  }

                  var5.remove();
                  this.field1382.method7774(new class418(var2), var5.field4681);
                  return true;
               }
            }

            var4.remove();
         }
      } else {
         this.field1382 = new class421(4);
      }

      this.field1382.method7774(new class418(var2), (long)var1);
      return true;
   }

   void method2542(class460 var1) {
      int var3 = var1.method8134();
      if (var3 >= 1 && var3 <= 6) {
         int var4 = var1.method8134();
         if (0 != (var4 & 1)) {
            this.field1358 = true;
         }

         if ((var4 & 2) != 0) {
            this.field1359 = true;
         }

         if (!this.field1358) {
            this.field1380 = null;
            this.field1379 = null;
         }

         if (!this.field1359) {
            this.field1373 = null;
            this.field1371 = null;
         }

         this.field1361 = var1.method8119();
         this.field1363 = var1.method8119();
         if (var3 <= 3 && this.field1363 != 0) {
            this.field1363 += 16912800;
         }

         this.field1369 = var1.method8115();
         this.field1378 = var1.method8134();
         this.field1372 = var1.method8124();
         if (var3 >= 4) {
            var1.method8119();
         }

         this.field1364 = var1.method8134() == 1;
         this.field1367 = var1.method8280();
         this.field1357 = var1.method8280();
         this.field1377 = var1.method8280();
         this.field1368 = var1.method8280();
         int var5;
         if (this.field1369 > 0) {
            if (this.field1358 && (null == this.field1380 || this.field1380.length < this.field1369)) {
               this.field1380 = new long[this.field1369];
            }

            if (this.field1359 && (null == this.field1373 || this.field1373.length < this.field1369)) {
               this.field1373 = new String[this.field1369];
            }

            if (null == this.field1381 || this.field1381.length < this.field1369) {
               this.field1381 = new byte[this.field1369];
            }

            if (null == this.field1365 || this.field1365.length < this.field1369) {
               this.field1365 = new int[this.field1369];
            }

            if (null == this.field1374 || this.field1374.length < this.field1369) {
               this.field1374 = new int[this.field1369];
            }

            if (null == this.field1375 || this.field1375.length < this.field1369) {
               this.field1375 = new boolean[this.field1369];
            }

            for(var5 = 0; var5 < this.field1369; ++var5) {
               if (this.field1358) {
                  this.field1380[var5] = var1.method8120();
               }

               if (this.field1359) {
                  this.field1373[var5] = var1.method8298();
               }

               this.field1381[var5] = var1.method8280();
               if (var3 >= 2) {
                  this.field1365[var5] = var1.method8119();
               }

               if (var3 >= 5) {
                  this.field1374[var5] = var1.method8115();
               } else {
                  this.field1374[var5] = 0;
               }

               if (var3 >= 6) {
                  this.field1375[var5] = var1.method8134() == 1;
               } else {
                  this.field1375[var5] = false;
               }
            }

            this.method2531();
         }

         if (this.field1378 > 0) {
            if (this.field1358 && (this.field1379 == null || this.field1379.length < this.field1378)) {
               this.field1379 = new long[this.field1378];
            }

            if (this.field1359 && (null == this.field1371 || this.field1371.length < this.field1378)) {
               this.field1371 = new String[this.field1378];
            }

            for(var5 = 0; var5 < this.field1378; ++var5) {
               if (this.field1358) {
                  this.field1379[var5] = var1.method8120();
               }

               if (this.field1359) {
                  this.field1371[var5] = var1.method8298();
               }
            }
         }

         if (var3 >= 3) {
            var5 = var1.method8115();
            if (var5 > 0) {
               this.field1382 = new class421(var5 < 16 ? class282.method953(var5) : 16);

               while(var5-- > 0) {
                  int var6 = var1.method8119();
                  int var7 = var6 & 1073741823;
                  int var8 = var6 >>> 30;
                  if (var8 == 0) {
                     int var9 = var1.method8119();
                     this.field1382.method7774(new class426(var9), (long)var7);
                  } else if (var8 == 1) {
                     long var11 = var1.method8120();
                     this.field1382.method7774(new class424(var11), (long)var7);
                  } else if (2 == var8) {
                     String var12 = var1.method8124();
                     this.field1382.method7774(new class418(var12), (long)var7);
                  }
               }
            }
         }

      } else {
         throw new RuntimeException("" + var3);
      }
   }

   static int method2527(int var0, class78 var1, boolean var2) {
      class300 var4 = class282.method5426(class57.field404[--class387.field4452]);
      if (var0 == 2800) {
         class57.field404[++class387.field4452 - 1] = class290.method2693(class190.method3528(var4));
         return 1;
      } else if (var0 != 2801) {
         if (2802 == var0) {
            if (null == var4.field3545) {
               class57.field405[++class126.field1220 - 1] = "";
            } else {
               class57.field405[++class126.field1220 - 1] = var4.field3545;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var5 = class57.field404[--class387.field4452];
         --var5;
         if (var4.field3546 != null && var5 < var4.field3546.length && null != var4.field3546[var5]) {
            class57.field405[++class126.field1220 - 1] = var4.field3546[var5];
         } else {
            class57.field405[++class126.field1220 - 1] = "";
         }

         return 1;
      }
   }
}
