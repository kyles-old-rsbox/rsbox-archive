public class class240 {
   static int field2826;
   byte[][][] field2825;
   int field2827;

   class240(int var1) {
      this.field2827 = var1;
   }

   void method4701(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (var7 != 0 && 0 != this.field2827 && this.field2825 != null) {
         var8 = this.method4684(var8, var7);
         var7 = this.method4696(var7);
         class481.method8654(var1, var2, var5, var6, var3, var4, this.field2825[var7 - 1][var8], this.field2827, true);
      }
   }

   int method4684(int var1, int var2) {
      if (var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if (var2 == 10) {
         var1 = 3 + var1 & 3;
      }

      if (var2 == 11) {
         var1 = 3 + var1 & 3;
      }

      return var1;
   }

   int method4696(int var1) {
      if (var1 != 9 && 10 != var1) {
         return 11 == var1 ? 8 : var1;
      } else {
         return 1;
      }
   }

   void method4686() {
      if (null == this.field2825) {
         this.field2825 = new byte[8][4][];
         this.method4685();
         this.method4687();
         this.method4691();
         this.method4683();
         this.method4690();
         this.method4705();
         this.method4692();
         this.method4682();
      }
   }

   void method4685() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[0][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[0][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= var4) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[0][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= var4) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[0][3] = var2;
   }

   void method4687() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[1][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var3 >= 0 && var3 < var2.length) {
               if (var5 >= var4 << 1) {
                  var2[var3] = -1;
               }

               ++var3;
            } else {
               ++var3;
            }
         }
      }

      this.field2825[1][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[1][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[1][3] = var2;
   }

   void method4691() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[2][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[2][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[2][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[2][3] = var2;
   }

   void method4683() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[3][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[3][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[3][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[3][3] = var2;
   }

   void method4690() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[4][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[4][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[4][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var3 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field2825[4][3] = var2;
   }

   void method4705() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      boolean var3 = false;
      var2 = new byte[this.field2827 * this.field2827];
      int var6 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[5][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var4 <= this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[5][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[5][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var4 >= this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[5][3] = var2;
   }

   void method4692() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      boolean var3 = false;
      var2 = new byte[this.field2827 * this.field2827];
      int var6 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[6][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 <= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[6][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[6][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[6][3] = var2;
   }

   void method4682() {
      byte[] var2 = new byte[this.field2827 * this.field2827];
      boolean var3 = false;
      var2 = new byte[this.field2827 * this.field2827];
      int var6 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[7][0] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field2827; ++var5) {
            if (var5 >= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[7][1] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = this.field2827 - 1; var4 >= 0; --var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[7][2] = var2;
      var2 = new byte[this.field2827 * this.field2827];
      var6 = 0;

      for(var4 = 0; var4 < this.field2827; ++var4) {
         for(var5 = this.field2827 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 - this.field2827 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field2825[7][3] = var2;
   }
}
