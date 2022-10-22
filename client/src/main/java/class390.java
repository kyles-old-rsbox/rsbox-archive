import java.util.ArrayList;

public class class390 {
   boolean field4472 = true;
   boolean field4475 = true;
   class384 field4477;
   int field4471 = Integer.MAX_VALUE;
   int field4474 = 0;
   int field4479 = 0;
   int field4480 = 0;
   ArrayList field4478 = new ArrayList();

   public class383 method7022(int var1) {
      return (class383)this.field4478.get(var1);
   }

   class383 method7023() {
      return this.field4478.size() == 0 ? null : (class383)this.field4478.get(this.field4478.size() - 1);
   }

   public boolean method7024() {
      return this.field4478.size() == 0;
   }

   public int method7084() {
      return this.field4478.size();
   }

   public String method7021() {
      if (this.method7024()) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(this.method7084());

         for(int var3 = 0; var3 < this.method7084(); ++var3) {
            class383 var4 = this.method7022(var3);
            var2.append(var4.field4428);
         }

         return var2.toString();
      }
   }

   public void method7027(int var1, boolean var2) {
      if (this.field4477 != null && var1 < this.field4477.field4435 * 2) {
         var1 = Integer.MAX_VALUE;
      }

      if (var1 != this.field4471 || var2 != this.field4475) {
         this.field4471 = var1;
         this.field4475 = var2;
         this.method7103(0, this.field4478.size(), false);
      }

   }

   public void method7028(int var1) {
      if (var1 != this.field4480) {
         this.field4480 = var1;
         this.method7103(0, this.field4478.size(), false);
      }

   }

   public void method7029(class384 var1) {
      if (var1 != this.field4477) {
         this.field4477 = var1;
         if (null != this.field4477) {
            if (this.field4474 == 0) {
               this.field4474 = this.field4477.field4435;
            }

            if (!this.method7024()) {
               this.method7103(0, this.field4478.size(), false);
            }
         }
      }

   }

   public void method7046(int var1) {
      if (this.field4479 != var1) {
         this.field4479 = var1;
         this.method7103(0, this.field4478.size(), false);
      }

   }

   public void method7031(int var1) {
      if (var1 != this.field4474) {
         this.field4474 = var1;
         this.method7103(0, this.field4478.size(), false);
      }

   }

   public class388 method7032(int var1, int var2) {
      if (var2 == var1) {
         return new class388(this, 0, 0);
      } else if (var1 <= this.field4478.size() && var2 <= this.field4478.size()) {
         return var2 < var1 ? new class388(this, var2, var1) : new class388(this, var1, var2);
      } else {
         return new class388(this, 0, 0);
      }
   }

   public class385 method7026(char var1, int var2, int var3, int var4) {
      return this.method7076(Character.toString(var1), var2, var3, var4);
   }

   public class385 method7076(String var1, int var2, int var3, int var4) {
      if (var3 == 0) {
         var3 = Integer.MAX_VALUE;
      }

      if (this.field4478.size() >= var3) {
         return new class385(var2, true);
      } else {
         this.field4478.ensureCapacity(this.field4478.size() + var1.length());
         int var6 = var2;
         int var7 = 0;
         class383 var8 = this.method7113(var2);
         int var9 = this.method7097(var2);

         int var10;
         int var11;
         for(var10 = -1; var7 < var1.length() && this.field4478.size() < var3; ++var6) {
            class383 var12 = new class383();
            var12.field4428 = var1.charAt(var7++);
            if ('\n' == var12.field4428) {
               var12.field4424 = var8.field4424 + this.method7044();
               var11 = 0;
            } else {
               var12.field4422 = var8.field4422 + var9;
               var12.field4424 = var8.field4424;
               var11 = this.method7054(var12, false);
               if (this.field4475 && var12.field4422 + var11 > this.field4471) {
                  if (0 == this.field4479) {
                     var12.field4422 = 0;
                     var12.field4424 += this.method7044();
                  } else if (var10 == -1) {
                     var10 = var6;
                  }
               }
            }

            var8 = var12;
            var9 = var11;
            this.field4478.add(var6, var12);
         }

         var11 = var10 == -1 ? var6 : var10;
         this.method7103(var11, this.field4478.size(), true);
         if (0 != var4 && this.method7045() > var4) {
            while(var2 != var6) {
               --var6;
               this.method7038(var6);
               if (this.method7045() <= var4) {
                  break;
               }
            }

            return new class385(var6, true);
         } else {
            return new class385(var6, false);
         }
      }
   }

   class385 method7035(String var1, int var2, int var3) {
      return this.method7076(var1, this.field4478.size(), var2, var3);
   }

   public class385 method7036(String var1) {
      this.method7109();
      return this.method7035(var1, 0, 0);
   }

   void method7109() {
      this.field4478.clear();
   }

   public int method7038(int var1) {
      return this.method7039(var1, var1 + 1);
   }

   public int method7039(int var1, int var2) {
      int var4;
      if (var2 < var1) {
         var4 = var2;
         var2 = var1;
         var1 = var4;
      }

      this.field4478.subList(var1, var2).clear();
      var4 = var1;
      if (this.field4475 && this.field4479 == 1) {
         label35: {
            int var5 = var1;

            char var6;
            do {
               if (var5 <= 0) {
                  break label35;
               }

               --var5;
               var6 = ((class383)this.field4478.get(var5)).field4428;
            } while(var6 != ' ' && var6 != '\t');

            var4 = var5;
         }
      }

      this.method7103(var4, this.field4478.size(), true);
      return var1;
   }

   public int method7071(int var1, int var2) {
      if (this.field4477 != null && var1 >= 0 && var2 >= 0) {
         if (this.field4475 && var1 > this.field4471) {
            return this.field4478.size();
         } else {
            if (!this.field4478.isEmpty()) {
               for(int var4 = 0; var4 < this.field4478.size(); ++var4) {
                  class383 var5 = (class383)this.field4478.get(var4);
                  if (var2 <= var5.field4424 + this.method7044()) {
                     if (var2 < var5.field4424) {
                        break;
                     }

                     if (var1 < var5.field4422) {
                        return var4 > 0 ? var4 - 1 : 0;
                     }

                     if (var4 + 1 != this.field4478.size() && ((class383)this.field4478.get(1 + var4)).field4424 != var5.field4424) {
                        int var6 = this.method7054((class383)this.field4478.get(var4), false);
                        if (var1 < var5.field4422 + var6) {
                           return var4;
                        }

                        if (var2 <= var5.field4424 + this.method7044()) {
                           return 1 + var4;
                        }
                     }
                  }
               }

               class383 var7 = (class383)this.field4478.get(this.field4478.size() - 1);
               if (var1 >= var7.field4422 && var1 <= var7.field4422 + this.method7119() && var2 >= var7.field4424 && var2 <= var7.field4424 + this.method7044()) {
                  return this.field4478.size() - 1;
               }
            }

            return this.field4478.size();
         }
      } else {
         return 0;
      }
   }

   public int method7041(int var1, int var2) {
      if (this.field4477 != null && !this.method7024() && var1 <= this.field4478.size()) {
         byte var4;
         if (var2 > 0) {
            var4 = 1;
         } else {
            var4 = -1;
            var2 = -var2;
         }

         int var5 = 0;
         int var6 = 0;
         if (var1 > 0) {
            class383 var7 = (class383)this.field4478.get(var1 - 1);
            var5 = var7.field4422 + this.method7053(var1 - 1);
            var6 = var7.field4424;
         } else if (var4 == -1 && var1 == 0) {
            return 0;
         }

         int var15 = 16777215;
         int var8 = 0;
         int var9 = var1;
         int var10 = 16777215;
         int var11 = var4 == 1 ? this.field4478.size() + 1 : 0;

         for(int var12 = var4 + var1; var11 != var12; var12 += var4) {
            class383 var13 = (class383)this.field4478.get(var12 - 1);
            if (var6 != var13.field4424) {
               ++var8;
               var6 = var13.field4424;
               if (var8 > var2) {
                  return var9;
               }
            }

            if (var8 == var2) {
               int var14 = Math.abs(var13.field4422 + this.method7053(var12 - 1) - var5);
               if (var14 >= var10) {
                  return var9;
               }

               var9 = var12;
               var10 = var14;
            }
         }

         if (var4 == 1) {
            return this.field4478.size();
         } else {
            if (var6 != 0) {
               ++var8;
            }

            return var10 != 16777215 && (var8 != var2 || var5 >= var10) ? var9 : 0;
         }
      } else {
         return 0;
      }
   }

   public int method7042() {
      if (!this.field4478.isEmpty() && this.method7045() == 1) {
         return this.field4478.isEmpty() ? 0 : ((class383)this.field4478.get(this.field4478.size() - 1)).field4422 + this.method7119();
      } else {
         int var2 = -1;
         int var3 = 0;

         for(int var4 = this.field4478.size() - 1; var4 >= 0; --var4) {
            class383 var5 = (class383)this.field4478.get(var4);
            if (var2 != var5.field4424) {
               int var6 = this.method7054(var5, false) + var5.field4422;
               var3 = Math.max(var6, var3);
               var2 = var5.field4424;
            }
         }

         return var3;
      }
   }

   public int method7110() {
      return this.method7024() ? 0 : this.field4477.field4435 + ((class383)this.field4478.get(this.field4478.size() - 1)).field4424;
   }

   public int method7044() {
      return this.field4474;
   }

   public int method7045() {
      return this.method7110() / this.field4477.field4435;
   }

   int method7119() {
      return this.method7024() ? 0 : this.method7054((class383)this.field4478.get(this.field4478.size() - 1), false);
   }

   public int method7047() {
      return this.field4471;
   }

   public int method7034() {
      return this.field4479;
   }

   public int method7049() {
      return this.field4480;
   }

   void method7103(int var1, int var2, boolean var3) {
      if (!this.method7024() && null != this.field4477) {
         class383 var5 = this.method7113(var1);
         int var6 = this.method7097(var1);

         for(int var7 = var1; var7 < var2; ++var7) {
            class383 var8 = (class383)this.field4478.get(var7);
            int var11;
            if (var8.field4428 == '\n') {
               int var10 = var5.field4424 + this.method7044();
               if (var3) {
                  if (var8.field4424 != var10) {
                     var11 = var10 - var8.field4424;

                     for(int var12 = var7; var12 < var2; ++var12) {
                        class383 var10000 = (class383)this.field4478.get(var12);
                        var10000.field4424 += var11;
                     }
                  }
                  break;
               }

               var8.field4424 = var10;
               boolean var9 = false;
            } else {
               var8.field4422 = var5.field4422 + var6;
               var8.field4424 = var5.field4424;
               int var18 = this.method7054(var8, false);
               if (this.field4475 && var18 + var8.field4422 > this.field4471) {
                  boolean var19 = false;
                  if (this.field4479 == 1) {
                     for(var11 = var7; var11 > 0; --var11) {
                        class383 var20 = (class383)this.field4478.get(var11 - 1);
                        if (var8.field4424 != var20.field4424) {
                           break;
                        }

                        if (' ' == var20.field4428 || '\t' == var20.field4428) {
                           class383 var13 = (class383)this.field4478.get(var11);
                           int var14 = var13.field4422;
                           int var15 = var13.field4424 + this.method7044();

                           for(int var16 = var11; var16 <= var7; ++var16) {
                              class383 var17 = (class383)this.field4478.get(var16);
                              var17.field4422 -= var14;
                              var17.field4424 = var15;
                           }

                           var19 = true;
                           break;
                        }
                     }
                  }

                  if (!var19) {
                     var8.field4422 = 0;
                     var8.field4424 += this.method7044();
                  }
               }
            }

            var5 = (class383)this.field4478.get(var7);
            var6 = this.method7054(var5, false);
         }

      }
   }

   class383 method7113(int var1) {
      if (var1 > 0 && !this.field4478.isEmpty()) {
         return var1 >= this.field4478.size() ? (class383)this.field4478.get(this.field4478.size() - 1) : (class383)this.field4478.get(var1 - 1);
      } else {
         return new class383();
      }
   }

   int method7097(int var1) {
      if (var1 > 0 && !this.field4478.isEmpty()) {
         return var1 >= this.field4478.size() ? this.method7053(this.field4478.size() - 1) : this.method7053(var1 - 1);
      } else {
         return 0;
      }
   }

   int method7053(int var1) {
      return var1 < this.field4478.size() ? this.method7054((class383)this.field4478.get(var1), false) : 0;
   }

   int method7054(class383 var1, boolean var2) {
      if (var1.field4428 == '\n') {
         return 0;
      } else if (!var2 && this.field4480 != 0) {
         return this.field4477.field4430[42];
      } else {
         int var4 = this.field4477.field4430[var1.field4428];
         if (0 == var4) {
            return '\t' == var1.field4428 ? 3 * this.field4477.field4430[32] : this.field4477.field4430[32];
         } else {
            return var4;
         }
      }
   }
}
