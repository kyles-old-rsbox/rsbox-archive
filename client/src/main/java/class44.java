public class class44 extends class51 {
   boolean field325;
   int field312;
   int field313;
   int field314;
   int field315;
   int field316;
   int field317;
   int field318;
   int field319;
   int field320;
   int field321;
   int field322;
   int field323;
   int field324;
   int field326;

   static int method932(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   static int method938(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   int method1002() {
      int var1 = this.field316 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if (this.field312 == 0) {
         var1 -= var1 * this.field324 / (((RawSound)super.field358).field258.length << 8);
      } else if (this.field312 >= 0) {
         var1 -= var1 * this.field320 / ((RawSound)super.field358).field258.length;
      }

      return var1 > 255 ? 255 : var1;
   }

   class44(RawSound var1, int var2, int var3) {
      super.field358 = var1;
      this.field320 = var1.field259;
      this.field321 = var1.field260;
      this.field325 = var1.field261;
      this.field313 = var2;
      this.field314 = var3;
      this.field315 = 8192;
      this.field324 = 0;
      this.method812();
   }

   class44(RawSound var1, int var2, int var3, int var4) {
      super.field358 = var1;
      this.field320 = var1.field259;
      this.field321 = var1.field260;
      this.field325 = var1.field261;
      this.field313 = var2;
      this.field314 = var3;
      this.field315 = var4;
      this.field324 = 0;
      this.method812();
   }

   public static class44 method829(RawSound var0, int var1, int var2) {
      return var0.field258 != null && var0.field258.length != 0 ? new class44(var0, (int)((long)var0.field257 * 256L * (long)var1 / (long)(SoundCache.field348 * 100)), var2 << 6) : null;
   }

   public static class44 method811(RawSound var0, int var1, int var2, int var3) {
      return var0.field258 != null && var0.field258.length != 0 ? new class44(var0, var1, var2, var3) : null;
   }

   void method812() {
      this.field316 = this.field314;
      this.field317 = method932(this.field314, this.field315);
      this.field318 = method938(this.field314, this.field315);
   }

   public synchronized void method813(int var1) {
      this.field312 = var1;
   }

   public synchronized void method814(int var1) {
      this.method841(var1 << 6, this.method818());
   }

   synchronized void method892(int var1) {
      this.method841(var1, this.method818());
   }

   synchronized void method841(int var1, int var2) {
      this.field314 = var1;
      this.field315 = var2;
      this.field323 = 0;
      this.method812();
   }

   public synchronized int method857() {
      return this.field314 == Integer.MIN_VALUE ? 0 : this.field314;
   }

   public synchronized int method818() {
      return this.field315 < 0 ? -1 : this.field315;
   }

   public synchronized void method929(int var1) {
      int var2 = ((RawSound)super.field358).field258.length << 8;
      if (var1 < -1) {
         var1 = -1;
      }

      if (var1 > var2) {
         var1 = var2;
      }

      this.field324 = var1;
   }

   public synchronized void method820(boolean var1) {
      this.field313 = (this.field313 ^ this.field313 >> 31) + (this.field313 >>> 31);
      if (var1) {
         this.field313 = -this.field313;
      }

   }

   void method821() {
      if (this.field323 != 0) {
         if (this.field314 == Integer.MIN_VALUE) {
            this.field314 = 0;
         }

         this.field323 = 0;
         this.method812();
      }

   }

   public synchronized void method822(int var1, int var2) {
      this.method806(var1, var2, this.method818());
   }

   public synchronized void method806(int var1, int var2, int var3) {
      if (var1 == 0) {
         this.method841(var2, var3);
      } else {
         int var4 = method932(var2, var3);
         int var5 = method938(var2, var3);
         if (this.field317 == var4 && this.field318 == var5) {
            this.field323 = 0;
         } else {
            int var6 = var2 - this.field316;
            if (this.field316 - var2 > var6) {
               var6 = this.field316 - var2;
            }

            if (var4 - this.field317 > var6) {
               var6 = var4 - this.field317;
            }

            if (this.field317 - var4 > var6) {
               var6 = this.field317 - var4;
            }

            if (var5 - this.field318 > var6) {
               var6 = var5 - this.field318;
            }

            if (this.field318 - var5 > var6) {
               var6 = this.field318 - var5;
            }

            if (var1 > var6) {
               var1 = var6;
            }

            this.field323 = var1;
            this.field314 = var2;
            this.field315 = var3;
            this.field322 = (var2 - this.field316) / var1;
            this.field319 = (var4 - this.field317) / var1;
            this.field326 = (var5 - this.field318) / var1;
         }
      }
   }

   public synchronized void method815(int var1) {
      if (var1 == 0) {
         this.method892(0);
         this.remove();
      } else if (this.field317 == 0 && this.field318 == 0) {
         this.field323 = 0;
         this.field314 = 0;
         this.field316 = 0;
         this.remove();
      } else {
         int var2 = -this.field316;
         if (this.field316 > var2) {
            var2 = this.field316;
         }

         if (-this.field317 > var2) {
            var2 = -this.field317;
         }

         if (this.field317 > var2) {
            var2 = this.field317;
         }

         if (-this.field318 > var2) {
            var2 = -this.field318;
         }

         if (this.field318 > var2) {
            var2 = this.field318;
         }

         if (var1 > var2) {
            var1 = var2;
         }

         this.field323 = var1;
         this.field314 = Integer.MIN_VALUE;
         this.field322 = -this.field316 / var1;
         this.field319 = -this.field317 / var1;
         this.field326 = -this.field318 / var1;
      }
   }

   public synchronized void method866(int var1) {
      if (this.field313 < 0) {
         this.field313 = -var1;
      } else {
         this.field313 = var1;
      }

   }

   public synchronized int method826() {
      return this.field313 < 0 ? -this.field313 : this.field313;
   }

   public boolean method827() {
      return this.field324 < 0 || this.field324 >= ((RawSound)super.field358).field258.length << 8;
   }

   public boolean method817() {
      return this.field323 != 0;
   }

   protected class51 method1007() {
      return null;
   }

   protected class51 method1004() {
      return null;
   }

   protected int method1003() {
      return this.field314 == 0 && this.field323 == 0 ? 0 : 1;
   }

   public synchronized void method1005(int[] var1, int var2, int var3) {
      if (this.field314 == 0 && this.field323 == 0) {
         this.method1001(var3);
      } else {
         RawSound var4 = (RawSound)super.field358;
         int var5 = this.field320 << 8;
         int var6 = this.field321 << 8;
         int var7 = var4.field258.length << 8;
         int var8 = var6 - var5;
         if (var8 <= 0) {
            this.field312 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if (this.field324 < 0) {
            if (this.field313 <= 0) {
               this.method821();
               this.remove();
               return;
            }

            this.field324 = 0;
         }

         if (this.field324 >= var7) {
            if (this.field313 >= 0) {
               this.method821();
               this.remove();
               return;
            }

            this.field324 = var7 - 1;
         }

         if (this.field312 < 0) {
            if (this.field325) {
               if (this.field313 < 0) {
                  var9 = this.method835(var1, var2, var5, var3, var4.field258[this.field320]);
                  if (this.field324 >= var5) {
                     return;
                  }

                  this.field324 = var5 + var5 - 1 - this.field324;
                  this.field313 = -this.field313;
               }

               while(true) {
                  var9 = this.method834(var1, var9, var6, var3, var4.field258[this.field321 - 1]);
                  if (this.field324 < var6) {
                     return;
                  }

                  this.field324 = var6 + var6 - 1 - this.field324;
                  this.field313 = -this.field313;
                  var9 = this.method835(var1, var9, var5, var3, var4.field258[this.field320]);
                  if (this.field324 >= var5) {
                     return;
                  }

                  this.field324 = var5 + var5 - 1 - this.field324;
                  this.field313 = -this.field313;
               }
            } else if (this.field313 < 0) {
               while(true) {
                  var9 = this.method835(var1, var9, var5, var3, var4.field258[this.field321 - 1]);
                  if (this.field324 >= var5) {
                     return;
                  }

                  this.field324 = var6 - 1 - (var6 - 1 - this.field324) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method834(var1, var9, var6, var3, var4.field258[this.field320]);
                  if (this.field324 < var6) {
                     return;
                  }

                  this.field324 = var5 + (this.field324 - var5) % var8;
               }
            }
         } else {
            if (this.field312 > 0) {
               if (this.field325) {
                  label130: {
                     if (this.field313 < 0) {
                        var9 = this.method835(var1, var2, var5, var3, var4.field258[this.field320]);
                        if (this.field324 >= var5) {
                           return;
                        }

                        this.field324 = var5 + var5 - 1 - this.field324;
                        this.field313 = -this.field313;
                        if (--this.field312 == 0) {
                           break label130;
                        }
                     }

                     do {
                        var9 = this.method834(var1, var9, var6, var3, var4.field258[this.field321 - 1]);
                        if (this.field324 < var6) {
                           return;
                        }

                        this.field324 = var6 + var6 - 1 - this.field324;
                        this.field313 = -this.field313;
                        if (--this.field312 == 0) {
                           break;
                        }

                        var9 = this.method835(var1, var9, var5, var3, var4.field258[this.field320]);
                        if (this.field324 >= var5) {
                           return;
                        }

                        this.field324 = var5 + var5 - 1 - this.field324;
                        this.field313 = -this.field313;
                     } while(--this.field312 != 0);
                  }
               } else {
                  int var10;
                  if (this.field313 < 0) {
                     while(true) {
                        var9 = this.method835(var1, var9, var5, var3, var4.field258[this.field321 - 1]);
                        if (this.field324 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field324) / var8;
                        if (var10 >= this.field312) {
                           this.field324 += var8 * this.field312;
                           this.field312 = 0;
                           break;
                        }

                        this.field324 += var8 * var10;
                        this.field312 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method834(var1, var9, var6, var3, var4.field258[this.field320]);
                        if (this.field324 < var6) {
                           return;
                        }

                        var10 = (this.field324 - var5) / var8;
                        if (var10 >= this.field312) {
                           this.field324 -= var8 * this.field312;
                           this.field312 = 0;
                           break;
                        }

                        this.field324 -= var8 * var10;
                        this.field312 -= var10;
                     }
                  }
               }
            }

            if (this.field313 < 0) {
               this.method835(var1, var9, 0, var3, 0);
               if (this.field324 < 0) {
                  this.field324 = -1;
                  this.method821();
                  this.remove();
               }
            } else {
               this.method834(var1, var9, var7, var3, 0);
               if (this.field324 >= var7) {
                  this.field324 = var7;
                  this.method821();
                  this.remove();
               }
            }

         }
      }
   }

   public synchronized void method1001(int var1) {
      if (this.field323 > 0) {
         if (var1 >= this.field323) {
            if (this.field314 == Integer.MIN_VALUE) {
               this.field314 = 0;
               this.field318 = 0;
               this.field317 = 0;
               this.field316 = 0;
               this.remove();
               var1 = this.field323;
            }

            this.field323 = 0;
            this.method812();
         } else {
            this.field316 += this.field322 * var1;
            this.field317 += this.field319 * var1;
            this.field318 += this.field326 * var1;
            this.field323 -= var1;
         }
      }

      RawSound var2 = (RawSound)super.field358;
      int var3 = this.field320 << 8;
      int var4 = this.field321 << 8;
      int var5 = var2.field258.length << 8;
      int var6 = var4 - var3;
      if (var6 <= 0) {
         this.field312 = 0;
      }

      if (this.field324 < 0) {
         if (this.field313 <= 0) {
            this.method821();
            this.remove();
            return;
         }

         this.field324 = 0;
      }

      if (this.field324 >= var5) {
         if (this.field313 >= 0) {
            this.method821();
            this.remove();
            return;
         }

         this.field324 = var5 - 1;
      }

      this.field324 += this.field313 * var1;
      if (this.field312 < 0) {
         if (!this.field325) {
            if (this.field313 < 0) {
               if (this.field324 >= var3) {
                  return;
               }

               this.field324 = var4 - 1 - (var4 - 1 - this.field324) % var6;
            } else {
               if (this.field324 < var4) {
                  return;
               }

               this.field324 = var3 + (this.field324 - var3) % var6;
            }

         } else {
            if (this.field313 < 0) {
               if (this.field324 >= var3) {
                  return;
               }

               this.field324 = var3 + var3 - 1 - this.field324;
               this.field313 = -this.field313;
            }

            while(this.field324 >= var4) {
               this.field324 = var4 + var4 - 1 - this.field324;
               this.field313 = -this.field313;
               if (this.field324 >= var3) {
                  return;
               }

               this.field324 = var3 + var3 - 1 - this.field324;
               this.field313 = -this.field313;
            }

         }
      } else {
         if (this.field312 > 0) {
            if (this.field325) {
               label122: {
                  if (this.field313 < 0) {
                     if (this.field324 >= var3) {
                        return;
                     }

                     this.field324 = var3 + var3 - 1 - this.field324;
                     this.field313 = -this.field313;
                     if (--this.field312 == 0) {
                        break label122;
                     }
                  }

                  do {
                     if (this.field324 < var4) {
                        return;
                     }

                     this.field324 = var4 + var4 - 1 - this.field324;
                     this.field313 = -this.field313;
                     if (--this.field312 == 0) {
                        break;
                     }

                     if (this.field324 >= var3) {
                        return;
                     }

                     this.field324 = var3 + var3 - 1 - this.field324;
                     this.field313 = -this.field313;
                  } while(--this.field312 != 0);
               }
            } else {
               label154: {
                  int var7;
                  if (this.field313 < 0) {
                     if (this.field324 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field324) / var6;
                     if (var7 >= this.field312) {
                        this.field324 += var6 * this.field312;
                        this.field312 = 0;
                        break label154;
                     }

                     this.field324 += var6 * var7;
                     this.field312 -= var7;
                  } else {
                     if (this.field324 < var4) {
                        return;
                     }

                     var7 = (this.field324 - var3) / var6;
                     if (var7 >= this.field312) {
                        this.field324 -= var6 * this.field312;
                        this.field312 = 0;
                        break label154;
                     }

                     this.field324 -= var6 * var7;
                     this.field312 -= var7;
                  }

                  return;
               }
            }
         }

         if (this.field313 < 0) {
            if (this.field324 < 0) {
               this.field324 = -1;
               this.method821();
               this.remove();
            }
         } else if (this.field324 >= var5) {
            this.field324 = var5;
            this.method821();
            this.remove();
         }

      }
   }

   int method834(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field323 > 0) {
            int var6 = var2 + this.field323;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field323 += var2;
            if (this.field313 == 256 && (this.field324 & 255) == 0) {
               if (class174.field1566) {
                  var2 = method846(0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, this.field319, this.field326, 0, var6, var3, this);
               } else {
                  var2 = method845(((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, this.field322, 0, var6, var3, this);
               }
            } else if (class174.field1566) {
               var2 = method850(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, this.field319, this.field326, 0, var6, var3, this, this.field313, var5);
            } else {
               var2 = method849(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, this.field322, 0, var6, var3, this, this.field313, var5);
            }

            this.field323 -= var2;
            if (this.field323 != 0) {
               return var2;
            }

            if (!this.method836()) {
               continue;
            }

            return var4;
         }

         if (this.field313 == 256 && (this.field324 & 255) == 0) {
            if (class174.field1566) {
               return method885(0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, 0, var4, var3, this);
            }

            return method837(((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, 0, var4, var3, this);
         }

         if (class174.field1566) {
            return method819(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, 0, var4, var3, this, this.field313, var5);
         }

         return method905(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, 0, var4, var3, this, this.field313, var5);
      }
   }

   int method835(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field323 > 0) {
            int var6 = var2 + this.field323;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field323 += var2;
            if (this.field313 == -256 && (this.field324 & 255) == 0) {
               if (class174.field1566) {
                  var2 = method848(0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, this.field319, this.field326, 0, var6, var3, this);
               } else {
                  var2 = method902(((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, this.field322, 0, var6, var3, this);
               }
            } else if (class174.field1566) {
               var2 = method852(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, this.field319, this.field326, 0, var6, var3, this, this.field313, var5);
            } else {
               var2 = method933(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, this.field322, 0, var6, var3, this, this.field313, var5);
            }

            this.field323 -= var2;
            if (this.field323 != 0) {
               return var2;
            }

            if (!this.method836()) {
               continue;
            }

            return var4;
         }

         if (this.field313 == -256 && (this.field324 & 255) == 0) {
            if (class174.field1566) {
               return method840(0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, 0, var4, var3, this);
            }

            return method839(((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, 0, var4, var3, this);
         }

         if (class174.field1566) {
            return method844(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field317, this.field318, 0, var4, var3, this, this.field313, var5);
         }

         return method843(0, 0, ((RawSound)super.field358).field258, var1, this.field324, var2, this.field316, 0, var4, var3, this, this.field313, var5);
      }
   }

   boolean method836() {
      int var1 = this.field314;
      int var2;
      int var3;
      if (var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method932(var1, this.field315);
         var3 = method938(var1, this.field315);
      }

      if (this.field316 == var1 && this.field317 == var2 && this.field318 == var3) {
         if (this.field314 == Integer.MIN_VALUE) {
            this.field314 = 0;
            this.field318 = 0;
            this.field317 = 0;
            this.field316 = 0;
            this.remove();
            return true;
         } else {
            this.method812();
            return false;
         }
      } else {
         if (this.field316 < var1) {
            this.field322 = 1;
            this.field323 = var1 - this.field316;
         } else if (this.field316 > var1) {
            this.field322 = -1;
            this.field323 = this.field316 - var1;
         } else {
            this.field322 = 0;
         }

         if (this.field317 < var2) {
            this.field319 = 1;
            if (this.field323 == 0 || this.field323 > var2 - this.field317) {
               this.field323 = var2 - this.field317;
            }
         } else if (this.field317 > var2) {
            this.field319 = -1;
            if (this.field323 == 0 || this.field323 > this.field317 - var2) {
               this.field323 = this.field317 - var2;
            }
         } else {
            this.field319 = 0;
         }

         if (this.field318 < var3) {
            this.field326 = 1;
            if (this.field323 == 0 || this.field323 > var3 - this.field318) {
               this.field323 = var3 - this.field318;
            }
         } else if (this.field318 > var3) {
            this.field326 = -1;
            if (this.field323 == 0 || this.field323 > this.field318 - var3) {
               this.field323 = this.field318 - var3;
            }
         } else {
            this.field326 = 0;
         }

         return false;
      }
   }

   static int method837(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class44 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if ((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
      }

      var8.field324 = var2 << 8;
      return var3;
   }

   static int method885(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class44 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if ((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field324 = var3 << 8;
      return var4 >> 1;
   }

   static int method839(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class44 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
      }

      var8.field324 = var2 << 8;
      return var3;
   }

   static int method840(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class44 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if ((var7 = var4 + var3 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field324 = var3 << 8;
      return var4 >> 1;
   }

   static int method905(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class44 var10, int var11, int var12) {
      if (var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field324 = var4;
      return var5;
   }

   static int method819(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class44 var11, int var12, int var13) {
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field324 = var4;
      return var5 >> 1;
   }

   static int method843(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class44 var10, int var11, int var12) {
      if (var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var9 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field324 = var4;
      return var5;
   }

   static int method844(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class44 var11, int var12, int var13) {
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var14 << 8) + (var2[var1] - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field324 = var4;
      return var5 >> 1;
   }

   static int method845(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class44 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field317 += var9.field319 * (var6 - var3);
      var9.field318 += var9.field326 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      var9.field316 = var4 >> 2;
      var9.field324 = var2 << 8;
      return var3;
   }

   static int method846(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class44 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field316 += var12.field322 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field317 = var5 >> 2;
      var12.field318 = var6 >> 2;
      var12.field324 = var3 << 8;
      return var4 >> 1;
   }

   static int method902(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class44 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field317 += var9.field319 * (var6 - var3);
      var9.field318 += var9.field326 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      var9.field316 = var4 >> 2;
      var9.field324 = var2 << 8;
      return var3;
   }

   static int method848(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class44 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field316 += var12.field322 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field317 = var5 >> 2;
      var12.field318 = var6 >> 2;
      var12.field324 = var3 << 8;
      return var4 >> 1;
   }

   static int method849(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class44 var11, int var12, int var13) {
      var11.field317 -= var11.field319 * var5;
      var11.field318 -= var11.field326 * var5;
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field317 += var11.field319 * var5;
      var11.field318 += var11.field326 * var5;
      var11.field316 = var6;
      var11.field324 = var4;
      return var5;
   }

   static int method850(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class44 var13, int var14, int var15) {
      var13.field316 -= var13.field322 * var5;
      if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var2[var1 + 1] - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field316 += var13.field322 * var5;
      var13.field317 = var6;
      var13.field318 = var7;
      var13.field324 = var4;
      return var5;
   }

   static int method933(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class44 var11, int var12, int var13) {
      var11.field317 -= var11.field319 * var5;
      var11.field318 -= var11.field326 * var5;
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field317 += var11.field319 * var5;
      var11.field318 += var11.field326 * var5;
      var11.field316 = var6;
      var11.field324 = var4;
      return var5;
   }

   static int method852(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class44 var13, int var14, int var15) {
      var13.field316 -= var13.field322 * var5;
      if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var16 << 8) + (var2[var1] - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field316 += var13.field322 * var5;
      var13.field317 = var6;
      var13.field318 = var7;
      var13.field324 = var4;
      return var5;
   }
}
