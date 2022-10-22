public class class305 {
   static class284 field3645 = new class284(260);
   static final int[] field3642 = new int[]{8, 11, 4, 6, 9, 7, 10};
   boolean field3644 = false;
   class179[] field3643;
   int[] field3637;
   int[] field3646;
   long field3636;
   long field3638;
   public int field3639 = 0;
   public int field3640;
   public int field3641 = -1;

   public void method5989(int[] var1, class179[] var2, boolean var3, int[] var4, int var5, int var6, int var7) {
      this.field3643 = var2;
      this.field3644 = var3;
      this.field3641 = var7;
      this.method5990(var1, var4, var5, var6);
   }

   public void method5990(int[] var1, int[] var2, int var3, int var4) {
      if (var1 == null) {
         var1 = new int[12];

         for(int var6 = 0; var6 < 7; ++var6) {
            for(int var7 = 0; var7 < class182.field1626; ++var7) {
               class182 var8 = class78.method1593(var7);
               if (null != var8 && !var8.field1630 && var6 + (var3 == 1 ? 7 : 0) == var8.field1623) {
                  var1[field3642[var6]] = var7 + 256;
                  break;
               }
            }
         }
      }

      this.field3646 = var1;
      this.field3637 = var2;
      this.field3639 = var3;
      this.field3640 = var4;
      this.method5994();
   }

   public void method5992(int var1, boolean var2) {
      if (var1 != 1 || 1 != this.field3639) {
         int var4 = this.field3646[field3642[var1]];
         if (var4 != 0) {
            var4 -= 256;

            class182 var5;
            do {
               if (!var2) {
                  --var4;
                  if (var4 < 0) {
                     var4 = class182.field1626 - 1;
                  }
               } else {
                  ++var4;
                  if (var4 >= class182.field1626) {
                     var4 = 0;
                  }
               }

               var5 = class78.method1593(var4);
            } while(null == var5 || var5.field1630 || var1 + (1 == this.field3639 ? 7 : 0) != var5.field1623);

            this.field3646[field3642[var1]] = var4 + 256;
            this.method5994();
         }
      }
   }

   public void method6004(int var1, boolean var2) {
      int var4 = this.field3637[var1];
      if (!var2) {
         do {
            --var4;
            if (var4 < 0) {
               var4 = class37.field251[var1].length - 1;
            }
         } while(!class141.method2474(var1, var4));
      } else {
         do {
            ++var4;
            if (var4 >= class37.field251[var1].length) {
               var4 = 0;
            }
         } while(!class141.method2474(var1, var4));
      }

      this.field3637[var1] = var4;
      this.method5994();
   }

   public void method5991(int var1) {
      if (var1 != this.field3639) {
         this.method5990((int[])null, this.field3637, var1, -1);
      }
   }

   public void method6008(class460 var1) {
      var1.method8097(this.field3639);

      int var3;
      for(var3 = 0; var3 < 7; ++var3) {
         int var4 = this.field3646[field3642[var3]];
         if (var4 == 0) {
            var1.method8097(-1);
         } else {
            var1.method8097(var4 - 256);
         }
      }

      for(var3 = 0; var3 < 5; ++var3) {
         var1.method8097(this.field3637[var3]);
      }

   }

   void method5994() {
      long var2 = this.field3638;
      int var4 = this.field3646[5];
      int var5 = this.field3646[9];
      this.field3646[5] = var5;
      this.field3646[9] = var4;
      this.field3638 = 0L;

      int var6;
      for(var6 = 0; var6 < 12; ++var6) {
         this.field3638 <<= 4;
         if (this.field3646[var6] >= 256) {
            this.field3638 += (long)(this.field3646[var6] - 256);
         }
      }

      if (this.field3646[0] >= 256) {
         this.field3638 += (long)(this.field3646[0] - 256 >> 4);
      }

      if (this.field3646[1] >= 256) {
         this.field3638 += (long)(this.field3646[1] - 256 >> 8);
      }

      for(var6 = 0; var6 < 5; ++var6) {
         this.field3638 <<= 3;
         this.field3638 += (long)this.field3637[var6];
      }

      this.field3638 <<= 1;
      this.field3638 += (long)this.field3639;
      this.field3646[5] = var4;
      this.field3646[9] = var5;
      if (0L != var2 && var2 != this.field3638 || this.field3644) {
         field3645.method5441(var2);
      }

   }

   public class209 method5995(class189 var1, int var2, class189 var3, int var4) {
      if (this.field3640 != -1) {
         return class158.method2632(this.field3640).method3855(var1, var2, var3, var4);
      } else {
         long var6 = this.field3638;
         int[] var8 = this.field3646;
         if (var1 != null && (var1.field1996 >= 0 || var1.field1990 >= 0)) {
            var8 = new int[12];

            for(int var9 = 0; var9 < 12; ++var9) {
               var8[var9] = this.field3646[var9];
            }

            if (var1.field1996 >= 0) {
               var6 += (long)(var1.field1996 - this.field3646[5] << 40);
               var8[5] = var1.field1996;
            }

            if (var1.field1990 >= 0) {
               var6 += (long)(var1.field1990 - this.field3646[3] << 48);
               var8[3] = var1.field1990;
            }
         }

         class209 var19 = (class209)field3645.method5439(var6);
         if (null == var19) {
            boolean var10 = false;

            int var12;
            for(int var11 = 0; var11 < 12; ++var11) {
               var12 = var8[var11];
               if (var12 >= 256 && var12 < 512 && !class78.method1593(var12 - 256).method2848()) {
                  var10 = true;
               }

               if (var12 >= 512 && !class278.method5388(var12 - 512).method3694(this.field3639)) {
                  var10 = true;
               }
            }

            if (var10) {
               if (-1L != this.field3636) {
                  var19 = (class209)field3645.method5439(this.field3636);
               }

               if (null == var19) {
                  return null;
               }
            }

            if (null == var19) {
               class201[] var21 = new class201[12];
               var12 = 0;

               int var14;
               for(int var13 = 0; var13 < 12; ++var13) {
                  var14 = var8[var13];
                  if (var14 >= 256 && var14 < 512) {
                     class201 var15 = class78.method1593(var14 - 256).method2863();
                     if (var15 != null) {
                        var21[var12++] = var15;
                     }
                  }

                  if (var14 >= 512) {
                     class198 var23 = class278.method5388(var14 - 512);
                     class201 var16 = var23.method3647(this.field3639);
                     if (var16 != null) {
                        if (null != this.field3643) {
                           class179 var17 = this.field3643[var13];
                           if (null != var17) {
                              int var18;
                              if (var17.field1603 != null && var23.field2132 != null && var17.field1603.length == var23.field2133.length) {
                                 for(var18 = 0; var18 < var23.field2132.length; ++var18) {
                                    var16.method3790(var23.field2133[var18], var17.field1603[var18]);
                                 }
                              }

                              if (var17.field1600 != null && null != var23.field2160 && var23.field2135.length == var17.field1600.length) {
                                 for(var18 = 0; var18 < var23.field2160.length; ++var18) {
                                    var16.method3791(var23.field2135[var18], var17.field1600[var18]);
                                 }
                              }
                           }
                        }

                        var21[var12++] = var16;
                     }
                  }
               }

               class201 var22 = new class201(var21, var12);

               for(var14 = 0; var14 < 5; ++var14) {
                  if (this.field3637[var14] < class37.field251[var14].length) {
                     var22.method3790(class172.field1551[var14], class37.field251[var14][this.field3637[var14]]);
                  }

                  if (this.field3637[var14] < class97.field974[var14].length) {
                     var22.method3790(class9.field39[var14], class97.field974[var14][this.field3637[var14]]);
                  }
               }

               var19 = var22.method3796(64, 850, -30, -50, -30);
               field3645.method5434(var19, var6);
               this.field3636 = var6;
            }
         }

         if (var1 == null && null == var3) {
            return var19;
         } else {
            class209 var20;
            if (var1 != null && null != var3) {
               var20 = var1.method3472(var19, var2, var3, var4);
            } else if (null != var1) {
               var20 = var1.method3479(var19, var2);
            } else {
               var20 = var3.method3479(var19, var4);
            }

            return var20;
         }
      }
   }

   class201 method5996() {
      if (-1 != this.field3640) {
         return class158.method2632(this.field3640).method3885();
      } else {
         boolean var2 = false;

         int var4;
         for(int var3 = 0; var3 < 12; ++var3) {
            var4 = this.field3646[var3];
            if (var4 >= 256 && var4 < 512 && !class78.method1593(var4 - 256).method2850()) {
               var2 = true;
            }

            if (var4 >= 512 && !class278.method5388(var4 - 512).method3692(this.field3639)) {
               var2 = true;
            }
         }

         if (var2) {
            return null;
         } else {
            class201[] var8 = new class201[12];
            var4 = 0;

            int var6;
            for(int var5 = 0; var5 < 12; ++var5) {
               var6 = this.field3646[var5];
               class201 var7;
               if (var6 >= 256 && var6 < 512) {
                  var7 = class78.method1593(var6 - 256).method2852();
                  if (var7 != null) {
                     var8[var4++] = var7;
                  }
               }

               if (var6 >= 512) {
                  var7 = class278.method5388(var6 - 512).method3655(this.field3639);
                  if (var7 != null) {
                     var8[var4++] = var7;
                  }
               }
            }

            class201 var9 = new class201(var8, var4);

            for(var6 = 0; var6 < 5; ++var6) {
               if (this.field3637[var6] < class37.field251[var6].length) {
                  var9.method3790(class172.field1551[var6], class37.field251[var6][this.field3637[var6]]);
               }

               if (this.field3637[var6] < class97.field974[var6].length) {
                  var9.method3790(class9.field39[var6], class97.field974[var6][this.field3637[var6]]);
               }
            }

            return var9;
         }
      }
   }

   public int method6021() {
      return this.field3640 == -1 ? this.field3646[1] + (this.field3646[11] << 5) + (this.field3637[0] << 25) + (this.field3637[4] << 20) + (this.field3646[0] << 15) + (this.field3646[8] << 10) : 305419896 + class158.method2632(this.field3640).field2260;
   }

   public static void method3577() {
      field3645.method5437();
   }
}
