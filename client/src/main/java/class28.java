public class class28 {
   static class115 field155;
   static class448 field148;
   static class47 field154;
   boolean field137 = true;
   class51 field147;
   class51[] field150 = new class51[8];
   class51[] field151 = new class51[8];
   int field138 = 32;
   int field140;
   int field141;
   int field142;
   int field144 = 0;
   int field145 = 0;
   int field146 = 0;
   int field149 = 0;
   long field135 = 0L;
   long field139 = class272.method2046();
   long field143 = 0L;
   protected int[] field136;

   public static class458 method412(int var0) {
      class458 var2 = (class458)class458.field4871.method5439((long)var0);
      if (var2 != null) {
         return var2;
      } else {
         byte[] var3 = class458.field4873.method6167(39, var0);
         var2 = new class458();
         if (null != var3) {
            var2.method8072(new class460(var3));
         }

         var2.method8074();
         class458.field4871.method5434(var2, (long)var0);
         return var2;
      }
   }

   protected class28() {
   }

   public static final void method3928(class27 var0) {
      class30.field164 = var0;
   }

   public final synchronized void method398(class51 var1) {
      this.field147 = var1;
   }

   public final synchronized void method405() {
      if (null != this.field136) {
         long var2 = class272.method2046();

         try {
            if (this.field143 != 0L) {
               if (var2 < this.field143) {
                  return;
               }

               this.method366(this.field140);
               this.field143 = 0L;
               this.field137 = true;
            }

            int var4 = this.method367();
            if (this.field146 - var4 > this.field144) {
               this.field144 = this.field146 - var4;
            }

            int var5 = this.field142 + this.field141;
            if (256 + var5 > 16384) {
               var5 = 16128;
            }

            if (var5 + 256 > this.field140) {
               this.field140 += 1024;
               if (this.field140 > 16384) {
                  this.field140 = 16384;
               }

               this.method369();
               this.method366(this.field140);
               var4 = 0;
               this.field137 = true;
               if (var5 + 256 > this.field140) {
                  var5 = this.field140 - 256;
                  this.field142 = var5 - this.field141;
               }
            }

            while(var4 < var5) {
               this.method363(this.field136, 256);
               this.method368();
               var4 += 256;
            }

            if (var2 > this.field135) {
               if (!this.field137) {
                  if (this.field144 == 0 && this.field145 == 0) {
                     this.method369();
                     this.field143 = 2000L + var2;
                     return;
                  }

                  this.field142 = Math.min(this.field145, this.field144);
                  this.field145 = this.field144;
               } else {
                  this.field137 = false;
               }

               this.field144 = 0;
               this.field135 = 2000L + var2;
            }

            this.field146 = var4;
         } catch (Exception var7) {
            this.method369();
            this.field143 = 2000L + var2;
         }

         try {
            if (var2 > 500000L + this.field139) {
               var2 = this.field139;
            }

            while(var2 > this.field139 + 5000L) {
               this.method382(256);
               this.field139 += (long)(256000 / SoundCache.field348);
            }
         } catch (Exception var6) {
            this.field139 = var2;
         }

      }
   }

   public final void method378() {
      this.field137 = true;
   }

   public final synchronized void method360() {
      this.field137 = true;

      try {
         this.method370();
      } catch (Exception var3) {
         this.method369();
         this.field143 = class272.method2046() + 2000L;
      }

   }

   public final synchronized void method361() {
      if (field154 != null) {
         boolean var2 = true;

         for(int var3 = 0; var3 < 2; ++var3) {
            if (field154.field339[var3] == this) {
               field154.field339[var3] = null;
            }

            if (null != field154.field339[var3]) {
               var2 = false;
            }
         }

         if (var2) {
            class339.field4217.shutdownNow();
            class339.field4217 = null;
            field154 = null;
         }
      }

      this.method369();
      this.field136 = null;
   }

   final void method382(int var1) {
      this.field149 -= var1;
      if (this.field149 < 0) {
         this.field149 = 0;
      }

      if (null != this.field147) {
         this.field147.method1001(var1);
      }

   }

   final void method363(int[] var1, int var2) {
      int var3 = var2;
      if (class174.field1566) {
         var3 = var2 << 1;
      }

      class386.method6962(var1, 0, var3);
      this.field149 -= var2;
      if (null != this.field147 && this.field149 <= 0) {
         this.field149 += SoundCache.field348 >> 4;
         class58.method1276(this.field147);
         this.method402(this.field147, this.field147.method1002());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class51 var10;
         label103:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if (var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if (0 != (var9 & 1)) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class51 var11 = this.field150[var7];

                  label97:
                  while(true) {
                     while(true) {
                        if (null == var11) {
                           break label97;
                        }

                        class56 var12 = var11.field358;
                        if (null != var12 && var12.field398 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field356;
                        } else {
                           var11.field359 = true;
                           int var13 = var11.method1003();
                           var4 += var13;
                           if (var12 != null) {
                              var12.field398 += var13;
                           }

                           if (var4 >= this.field138) {
                              break label103;
                           }

                           class51 var14 = var11.method1007();
                           if (null != var14) {
                              for(int var15 = var11.field357; null != var14; var14 = var11.method1004()) {
                                 this.method402(var14, var15 * var14.method1002() >> 8);
                              }
                           }

                           class51 var18 = var11.field356;
                           var11.field356 = null;
                           if (null == var10) {
                              this.field150[var7] = var18;
                           } else {
                              var10.field356 = var18;
                           }

                           if (var18 == null) {
                              this.field151[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class51 var16 = this.field150[var6];
            class51[] var17 = this.field150;
            this.field151[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field356;
               var16.field356 = null;
            }
         }
      }

      if (this.field149 < 0) {
         this.field149 = 0;
      }

      if (this.field147 != null) {
         this.field147.method1005(var1, 0, var2);
      }

      this.field139 = class272.method2046();
   }

   static void method400() {
      if (null == class75.field633 || class75.field633.length() <= 0) {
         if (class413.field4575.method1722() != null) {
            class75.field633 = class413.field4575.method1722();
            client.field1891 = true;
         } else {
            client.field1891 = false;
         }

      }
   }

   final void method402(class51 var1, int var2) {
      int var4 = var2 >> 5;
      class51 var5 = this.field151[var4];
      if (null == var5) {
         this.field150[var4] = var1;
      } else {
         var5.field356 = var1;
      }

      this.field151[var4] = var1;
      var1.field357 = var2;
   }

   protected void method365() throws Exception {
   }

   protected void method366(int var1) throws Exception {
   }

   protected int method367() throws Exception {
      return this.field140;
   }

   protected void method368() throws Exception {
   }

   protected void method369() {
   }

   protected void method370() throws Exception {
   }

   static int method399() {
      if (client.field1930 != null && client.field1910 < client.field1930.size()) {
         int var1 = 0;

         for(int var2 = 0; var2 <= client.field1910; ++var2) {
            var1 += ((class97)client.field1930.get(var2)).field970;
         }

         return 10000 * var1 / client.field1731;
      } else {
         return 10000;
      }
   }
}
