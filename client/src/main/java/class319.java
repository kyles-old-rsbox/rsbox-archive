public abstract class class319 {
   static class484 field3745 = new class484();
   static int field3744 = 0;
   boolean field3748;
   boolean field3749;
   class476 field3736;
   class476[] field3742;
   int field3739;
   int[] field3733;
   int[] field3734;
   int[] field3735;
   int[] field3737;
   int[] field3738;
   int[][] field3740;
   int[][] field3741;
   Object[] field3743;
   Object[][] field3747;
   public int field3746;

   class319(boolean var1, boolean var2) {
      this.field3748 = var1;
      this.field3749 = var2;
   }

   void method6077(byte[] var1) {
      int var4 = var1.length;
      int var3 = class241.method4729(var1, 0, var4);
      this.field3746 = var3;
      class460 var5 = new class460(class231.method4537(var1));
      int var6 = var5.method8134();
      if (var6 >= 5 && var6 <= 7) {
         if (var6 >= 6) {
            var5.method8119();
         }

         int var7 = var5.method8134();
         if (var6 >= 7) {
            this.field3739 = var5.method8132();
         } else {
            this.field3739 = var5.method8115();
         }

         int var8 = 0;
         int var9 = -1;
         this.field3734 = new int[this.field3739];
         int var10;
         if (var6 >= 7) {
            for(var10 = 0; var10 < this.field3739; ++var10) {
               this.field3734[var10] = var8 += var5.method8132();
               if (this.field3734[var10] > var9) {
                  var9 = this.field3734[var10];
               }
            }
         } else {
            for(var10 = 0; var10 < this.field3739; ++var10) {
               this.field3734[var10] = var8 += var5.method8115();
               if (this.field3734[var10] > var9) {
                  var9 = this.field3734[var10];
               }
            }
         }

         this.field3737 = new int[1 + var9];
         this.field3738 = new int[var9 + 1];
         this.field3733 = new int[1 + var9];
         this.field3740 = new int[var9 + 1][];
         this.field3743 = new Object[var9 + 1];
         this.field3747 = new Object[var9 + 1][];
         if (0 != var7) {
            this.field3735 = new int[1 + var9];

            for(var10 = 0; var10 < this.field3739; ++var10) {
               this.field3735[this.field3734[var10]] = var5.method8119();
            }

            this.field3736 = new class476(this.field3735);
         }

         for(var10 = 0; var10 < this.field3739; ++var10) {
            this.field3737[this.field3734[var10]] = var5.method8119();
         }

         for(var10 = 0; var10 < this.field3739; ++var10) {
            this.field3738[this.field3734[var10]] = var5.method8119();
         }

         for(var10 = 0; var10 < this.field3739; ++var10) {
            this.field3733[this.field3734[var10]] = var5.method8115();
         }

         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         if (var6 >= 7) {
            for(var10 = 0; var10 < this.field3739; ++var10) {
               var11 = this.field3734[var10];
               var12 = this.field3733[var11];
               var8 = 0;
               var13 = -1;
               this.field3740[var11] = new int[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var15 = this.field3740[var11][var14] = var8 += var5.method8132();
                  if (var15 > var13) {
                     var13 = var15;
                  }
               }

               this.field3747[var11] = new Object[1 + var13];
            }
         } else {
            for(var10 = 0; var10 < this.field3739; ++var10) {
               var11 = this.field3734[var10];
               var12 = this.field3733[var11];
               var8 = 0;
               var13 = -1;
               this.field3740[var11] = new int[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var15 = this.field3740[var11][var14] = var8 += var5.method8115();
                  if (var15 > var13) {
                     var13 = var15;
                  }
               }

               this.field3747[var11] = new Object[1 + var13];
            }
         }

         if (var7 != 0) {
            this.field3741 = new int[1 + var9][];
            this.field3742 = new class476[var9 + 1];

            for(var10 = 0; var10 < this.field3739; ++var10) {
               var11 = this.field3734[var10];
               var12 = this.field3733[var11];
               this.field3741[var11] = new int[this.field3747[var11].length];

               for(var13 = 0; var13 < var12; ++var13) {
                  this.field3741[var11][this.field3740[var11][var13]] = var5.method8119();
               }

               this.field3742[var11] = new class476(this.field3741[var11]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   void method6125(int var1) {
   }

   public byte[] method6167(int var1, int var2) {
      return this.method6080(var1, var2, (int[])null);
   }

   public byte[] method6080(int var1, int var2, int[] var3) {
      if (var1 >= 0 && var1 < this.field3747.length && null != this.field3747[var1] && var2 >= 0 && var2 < this.field3747[var1].length) {
         if (null == this.field3747[var1][var2]) {
            boolean var5 = this.method6117(var1, var3);
            if (!var5) {
               this.method6086(var1);
               var5 = this.method6117(var1, var3);
               if (!var5) {
                  return null;
               }
            }
         }

         byte[] var6 = class329.method6249(this.field3747[var1][var2], false);
         if (this.field3749) {
            this.field3747[var1][var2] = null;
         }

         return var6;
      } else {
         return null;
      }
   }

   public boolean method6081(int var1, int var2) {
      if (var1 >= 0 && var1 < this.field3747.length && null != this.field3747[var1] && var2 >= 0 && var2 < this.field3747[var1].length) {
         if (null != this.field3747[var1][var2]) {
            return true;
         } else if (this.field3743[var1] != null) {
            return true;
         } else {
            this.method6086(var1);
            return null != this.field3743[var1];
         }
      } else {
         return false;
      }
   }

   public boolean method6082(int var1) {
      if (1 == this.field3747.length) {
         return this.method6081(0, var1);
      } else if (this.field3747[var1].length == 1) {
         return this.method6081(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   public boolean method6083(int var1) {
      if (null != this.field3743[var1]) {
         return true;
      } else {
         this.method6086(var1);
         return null != this.field3743[var1];
      }
   }

   public boolean method6084() {
      boolean var2 = true;

      for(int var3 = 0; var3 < this.field3734.length; ++var3) {
         int var4 = this.field3734[var3];
         if (null == this.field3743[var4]) {
            this.method6086(var4);
            if (this.field3743[var4] == null) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   int method6151(int var1) {
      return this.field3743[var1] != null ? 100 : 0;
   }

   public byte[] method6095(int var1) {
      if (1 == this.field3747.length) {
         return this.method6167(0, var1);
      } else if (this.field3747[var1].length == 1) {
         return this.method6167(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   public byte[] method6123(int var1, int var2) {
      if (var1 >= 0 && var1 < this.field3747.length && this.field3747[var1] != null && var2 >= 0 && var2 < this.field3747[var1].length) {
         if (this.field3747[var1][var2] == null) {
            boolean var4 = this.method6117(var1, (int[])null);
            if (!var4) {
               this.method6086(var1);
               var4 = this.method6117(var1, (int[])null);
               if (!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class329.method6249(this.field3747[var1][var2], false);
         return var5;
      } else {
         return null;
      }
   }

   public byte[] method6088(int var1) {
      if (this.field3747.length == 1) {
         return this.method6123(0, var1);
      } else if (1 == this.field3747[var1].length) {
         return this.method6123(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   void method6086(int var1) {
   }

   public int[] method6090(int var1) {
      return var1 >= 0 && var1 < this.field3740.length ? this.field3740[var1] : null;
   }

   public int method6091(int var1) {
      return this.field3747[var1].length;
   }

   public int method6092() {
      return this.field3747.length;
   }

   public void method6093() {
      for(int var2 = 0; var2 < this.field3743.length; ++var2) {
         this.field3743[var2] = null;
      }

   }

   public void method6094(int var1) {
      for(int var3 = 0; var3 < this.field3747[var1].length; ++var3) {
         this.field3747[var1][var3] = null;
      }

   }

   public void method6109() {
      for(int var2 = 0; var2 < this.field3747.length; ++var2) {
         if (null != this.field3747[var2]) {
            for(int var3 = 0; var3 < this.field3747[var2].length; ++var3) {
               this.field3747[var2][var3] = null;
            }
         }
      }

   }

   boolean method6117(int var1, int[] var2) {
      if (this.field3743[var1] == null) {
         return false;
      } else {
         int var4 = this.field3733[var1];
         int[] var5 = this.field3740[var1];
         Object[] var6 = this.field3747[var1];
         boolean var7 = true;

         for(int var8 = 0; var8 < var4; ++var8) {
            if (null == var6[var5[var8]]) {
               var7 = false;
               break;
            }
         }

         if (var7) {
            return true;
         } else {
            byte[] var19;
            if (null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var19 = class329.method6249(this.field3743[var1], false);
            } else {
               var19 = class329.method6249(this.field3743[var1], true);
               class460 var9 = new class460(var19);
               var9.method8139(var2, 5, var9.field4881.length);
            }

            byte[] var20 = class231.method4537(var19);
            if (this.field3748) {
               this.field3743[var1] = null;
            }

            if (var4 > 1) {
               int var10 = var20.length;
               --var10;
               int var11 = var20[var10] & 255;
               var10 -= var11 * var4 * 4;
               class460 var12 = new class460(var20);
               int[] var13 = new int[var4];
               var12.field4878 = var10;

               int var15;
               int var16;
               for(int var14 = 0; var14 < var11; ++var14) {
                  var15 = 0;

                  for(var16 = 0; var16 < var4; ++var16) {
                     var15 += var12.method8119();
                     var13[var16] += var15;
                  }
               }

               byte[][] var21 = new byte[var4][];

               for(var15 = 0; var15 < var4; ++var15) {
                  var21[var15] = new byte[var13[var15]];
                  var13[var15] = 0;
               }

               var12.field4878 = var10;
               var15 = 0;

               for(var16 = 0; var16 < var11; ++var16) {
                  int var17 = 0;

                  for(int var18 = 0; var18 < var4; ++var18) {
                     var17 += var12.method8119();
                     System.arraycopy(var20, var15, var21[var18], var13[var18], var17);
                     var13[var18] += var17;
                     var15 += var17;
                  }
               }

               for(var16 = 0; var16 < var4; ++var16) {
                  if (!this.field3749) {
                     var6[var5[var16]] = class142.method2479(var21[var16], false);
                  } else {
                     var6[var5[var16]] = var21[var16];
                  }
               }
            } else if (!this.field3749) {
               var6[var5[0]] = class142.method2479(var20, false);
            } else {
               var6[var5[0]] = var20;
            }

            return true;
         }
      }
   }

   public int method6116(String var1) {
      var1 = var1.toLowerCase();
      return this.field3736.method8610(class359.method6663(var1));
   }

   public int method6162(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field3742[var1].method8610(class359.method6663(var2));
   }

   public boolean method6147(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var4 = this.field3736.method8610(class359.method6663(var1));
      if (var4 < 0) {
         return false;
      } else {
         int var5 = this.field3742[var4].method8610(class359.method6663(var2));
         return var5 >= 0;
      }
   }

   public byte[] method6140(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var4 = this.field3736.method8610(class359.method6663(var1));
      int var5 = this.field3742[var4].method8610(class359.method6663(var2));
      return this.method6167(var4, var5);
   }

   public boolean method6100(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var4 = this.field3736.method8610(class359.method6663(var1));
      int var5 = this.field3742[var4].method8610(class359.method6663(var2));
      return this.method6081(var4, var5);
   }

   public boolean method6102(String var1) {
      var1 = var1.toLowerCase();
      int var3 = this.field3736.method8610(class359.method6663(var1));
      return this.method6083(var3);
   }

   public void method6098(String var1) {
      var1 = var1.toLowerCase();
      int var3 = this.field3736.method8610(class359.method6663(var1));
      if (var3 >= 0) {
         this.method6125(var3);
      }
   }

   public int method6103(String var1) {
      var1 = var1.toLowerCase();
      int var3 = this.field3736.method8610(class359.method6663(var1));
      return this.method6151(var3);
   }

   static final void method6173(int var0, int var1, int var2, int var3) {
      for(int var5 = 0; var5 < client.field1858; ++var5) {
         if (client.field1710[var5] + client.field1863[var5] > var0 && client.field1863[var5] < var2 + var0 && client.field1864[var5] + client.field1658[var5] > var1 && client.field1864[var5] < var3 + var1) {
            client.field1860[var5] = true;
         }
      }

   }
}
