import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class class83 {
   static int field732 = 10;
   boolean field730;
   boolean field733 = false;
   boolean field735 = false;
   boolean field741;
   double field737 = 0.8D;
   int field731 = 127;
   int field736;
   int field738 = 127;
   int field739 = -1;
   int field740 = 127;
   int field743 = 1;
   String field742 = null;
   LinkedHashMap field744 = new LinkedHashMap();

   class83() {
      this.method1701(true);
   }

   class83(class460 var1) {
      if (var1 != null && var1.field4881 != null) {
         int var2 = var1.method8134();
         if (var2 >= 0 && var2 <= field732) {
            if (var1.method8134() == 1) {
               this.field730 = true;
            }

            if (var2 > 1) {
               this.field741 = var1.method8134() == 1;
            }

            if (var2 > 3) {
               this.field743 = var1.method8134();
            }

            if (var2 > 2) {
               int var3 = var1.method8134();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method8119();
                  int var6 = var1.method8119();
                  this.field744.put(var5, var6);
               }
            }

            if (var2 > 4) {
               this.field742 = var1.method8298();
            }

            if (var2 > 5) {
               this.field733 = var1.method8122();
            }

            if (var2 > 6) {
               this.field737 = (double)var1.method8134() / 100.0D;
               this.field731 = var1.method8134();
               this.field738 = var1.method8134();
               this.field740 = var1.method8134();
            }

            if (var2 > 7) {
               this.field739 = var1.method8134();
            }

            if (var2 > 8) {
               this.field735 = var1.method8134() == 1;
            }

            if (var2 > 9) {
               this.field736 = var1.method8119();
            }
         } else {
            this.method1701(true);
         }
      } else {
         this.method1701(true);
      }

   }

   void method1701(boolean var1) {
   }

   class460 method1702() {
      class460 var2 = new class460(100);
      var2.method8097(field732);
      var2.method8097(this.field730 ? 1 : 0);
      var2.method8097(this.field741 ? 1 : 0);
      var2.method8097(this.field743);
      var2.method8097(this.field744.size());
      Iterator var3 = this.field744.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var2.method8234((Integer)var4.getKey());
         var2.method8234((Integer)var4.getValue());
      }

      var2.method8104(this.field742 != null ? this.field742 : "");
      var2.method8103(this.field733);
      var2.method8097((int)(100.0D * this.field737));
      var2.method8097(this.field731);
      var2.method8097(this.field738);
      var2.method8097(this.field740);
      var2.method8097(this.field739);
      var2.method8097(this.field735 ? 1 : 0);
      var2.method8234(this.field736);
      return var2;
   }

   void method1703(boolean var1) {
      this.field730 = var1;
      class151.method2592();
   }

   boolean method1777() {
      return this.field730;
   }

   void method1755(boolean var1) {
      this.field733 = var1;
      class151.method2592();
   }

   boolean method1706() {
      return this.field733;
   }

   void method1707(boolean var1) {
      this.field741 = var1;
      class151.method2592();
   }

   boolean method1708() {
      return this.field741;
   }

   void method1709(boolean var1) {
      this.field735 = var1;
      class151.method2592();
   }

   void method1759() {
      this.method1709(!this.field735);
   }

   boolean method1711() {
      return this.field735;
   }

   void method1712(int var1) {
      this.field736 = var1;
      class151.method2592();
   }

   int method1766() {
      return this.field736;
   }

   void method1714(double var1) {
      this.field737 = var1;
      class151.method2592();
   }

   double method1717() {
      return this.field737;
   }

   void method1715(int var1) {
      this.field731 = var1;
      class151.method2592();
   }

   int method1716() {
      return this.field731;
   }

   void method1704(int var1) {
      this.field738 = var1;
      class151.method2592();
   }

   int method1752() {
      return this.field738;
   }

   void method1719(int var1) {
      this.field740 = var1;
      class151.method2592();
   }

   int method1736() {
      return this.field740;
   }

   void method1710(String var1) {
      this.field742 = var1;
      class151.method2592();
   }

   String method1722() {
      return this.field742;
   }

   void method1723(int var1) {
      this.field739 = var1;
      class151.method2592();
   }

   int method1797() {
      return this.field739;
   }

   void method1778(int var1) {
      this.field743 = var1;
      class151.method2592();
   }

   int method1726() {
      return this.field743;
   }

   static int method1796(int var0, class78 var1, boolean var2) {
      class300 var4 = class282.method5426(class57.field404[--class387.field4452]);
      if (var0 == 2600) {
         class57.field404[++class387.field4452 - 1] = var4.field3481;
         return 1;
      } else if (2601 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3482;
         return 1;
      } else if (var0 == 2602) {
         class57.field405[++class126.field1220 - 1] = var4.field3522;
         return 1;
      } else if (var0 == 2603) {
         class57.field404[++class387.field4452 - 1] = var4.field3483;
         return 1;
      } else if (var0 == 2604) {
         class57.field404[++class387.field4452 - 1] = var4.field3492;
         return 1;
      } else if (2605 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3562;
         return 1;
      } else if (var0 == 2606) {
         class57.field404[++class387.field4452 - 1] = var4.field3601;
         return 1;
      } else if (2607 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3514;
         return 1;
      } else if (var0 == 2608) {
         class57.field404[++class387.field4452 - 1] = var4.field3513;
         return 1;
      } else if (2609 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3612;
         return 1;
      } else if (2610 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3588;
         return 1;
      } else if (2611 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3485;
         return 1;
      } else if (var0 == 2612) {
         class57.field404[++class387.field4452 - 1] = var4.field3495;
         return 1;
      } else if (2613 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3490.method6656();
         return 1;
      } else if (var0 == 2614) {
         class57.field404[++class387.field4452 - 1] = var4.field3519 ? 1 : 0;
         return 1;
      } else {
         class302 var5;
         if (var0 == 2617) {
            var5 = var4.method5946();
            class57.field404[++class387.field4452 - 1] = null != var5 ? var5.field3617 * -1249433437 * -374813941 : 0;
         }

         if (var0 == 2618) {
            var5 = var4.method5946();
            class57.field404[++class387.field4452 - 1] = null != var5 ? var5.field3619 * 482449691 * 971643155 : 0;
            return 1;
         } else {
            class297 var8;
            if (var0 == 2619) {
               var8 = var4.method5869();
               class57.field405[++class126.field1220 - 1] = var8 != null ? var8.method5601().method7021() : "";
               return 1;
            } else if (var0 == 2620) {
               var5 = var4.method5946();
               class57.field404[++class387.field4452 - 1] = null != var5 ? 942829249 * var5.field3618 * 1084956993 : 0;
               return 1;
            } else if (2621 == var0) {
               var8 = var4.method5869();
               class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5611() : 0;
               return 1;
            } else if (2622 == var0) {
               var8 = var4.method5869();
               class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5612() : 0;
               return 1;
            } else if (var0 == 2623) {
               var8 = var4.method5869();
               class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5613() : 0;
               return 1;
            } else if (var0 == 2624) {
               var8 = var4.method5869();
               class57.field404[++class387.field4452 - 1] = null != var8 && var8.method5585() ? 1 : 0;
               return 1;
            } else if (2625 != var0) {
               if (var0 == 2626) {
                  var8 = var4.method5869();
                  class57.field405[++class126.field1220 - 1] = null != var8 ? var8.method5602().method7005() : "";
                  return 1;
               } else if (2627 == var0) {
                  var8 = var4.method5869();
                  int var6 = var8 != null ? var8.method5683() : 0;
                  int var7 = null != var8 ? var8.method5606() : 0;
                  class57.field404[++class387.field4452 - 1] = Math.min(var6, var7);
                  class57.field404[++class387.field4452 - 1] = Math.max(var6, var7);
                  return 1;
               } else if (var0 == 2628) {
                  var8 = var4.method5869();
                  class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5606() : 0;
                  return 1;
               } else if (2629 == var0) {
                  var8 = var4.method5869();
                  class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5815() : 0;
                  return 1;
               } else if (var0 == 2630) {
                  var8 = var4.method5869();
                  class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5614() : 0;
                  return 1;
               } else if (2631 == var0) {
                  var8 = var4.method5869();
                  class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5739() : 0;
                  return 1;
               } else if (2632 == var0) {
                  var8 = var4.method5869();
                  class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5617() : 0;
                  return 1;
               } else {
                  class34 var9;
                  if (var0 == 2633) {
                     var9 = var4.method5871();
                     class57.field404[class387.field4452 - 1] = null != var9 ? var9.method617(class57.field404[class387.field4452 - 1]) : 0;
                     return 1;
                  } else if (2634 == var0) {
                     var9 = var4.method5871();
                     class57.field404[class387.field4452 - 1] = null != var9 ? var9.method618((char)class57.field404[class387.field4452 - 1]) : 0;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var8 = var4.method5869();
               class57.field404[++class387.field4452 - 1] = null != var8 && var8.method5604() ? 1 : 0;
               return 1;
            }
         }
      }
   }

   static final void method1795(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var9 = var6 - 334;
      if (var9 < 0) {
         var9 = 0;
      } else if (var9 > 100) {
         var9 = 100;
      }

      int var10 = client.field1909 + var9 * (client.field1801 - client.field1909) / 100;
      int var8 = var5 * var10 / 256;
      var9 = 2048 - var3 & 2047;
      var10 = 2048 - var4 & 2047;
      int var11 = 0;
      int var12 = 0;
      int var13 = var8;
      int var14;
      int var15;
      int var16;
      if (0 != var9) {
         var14 = class221.field2644[var9];
         var15 = class221.field2645[var9];
         var16 = var15 * var12 - var14 * var8 >> 16;
         var13 = var14 * var12 + var8 * var15 >> 16;
         var12 = var16;
      }

      if (var10 != 0) {
         var14 = class221.field2644[var10];
         var15 = class221.field2645[var10];
         var16 = var15 * var11 + var14 * var13 >> 16;
         var13 = var13 * var15 - var14 * var11 >> 16;
         var11 = var16;
      }

      if (client.field1900) {
         class226.field2706 = var0 - var11;
         class94.field938 = var1 - var12;
         class302.field3620 = var2 - var13;
         class300.field3615 = var3;
         class32.field206 = var4;
      } else {
         class215.field2568 = var0 - var11;
         class32.field204 = var1 - var12;
         class323.field3766 = var2 - var13;
         class414.field4588 = var3;
         class237.field2807 = var4;
      }

      if (1 == client.field1722 && client.field1750 >= 2 && 0 == client.field1645 % 50 && (class291.field3364.field827 >> 7 != class32.field203 >> 7 || class101.field1004 >> 7 != class291.field3364.field802 >> 7)) {
         var14 = class291.field3364.field914;
         var15 = (class32.field203 >> 7) + class36.field241;
         var16 = class169.field1536 + (class101.field1004 >> 7);
         class136.method2439(var15, var16, var14, true);
      }

   }

   static final void method1761(class300[] var0, int var1) {
      for(int var3 = 0; var3 < var0.length; ++var3) {
         class300 var4 = var0[var3];
         if (null != var4) {
            if (0 == var4.field3462) {
               if (null != var4.field3602) {
                  method1761(var4.field3602, var1);
               }

               class89 var5 = (class89)client.field1810.get((long)var4.field3517);
               if (null != var5) {
                  class217.method4361(var5.field796, var1);
               }
            }

            class79 var6;
            if (0 == var1 && var4.field3584 != null) {
               var6 = new class79();
               var6.field694 = var4;
               var6.field686 = var4.field3584;
               class57.method5433(var6);
            }

            if (var1 == 1 && null != var4.field3479) {
               if (var4.field3484 >= 0) {
                  class300 var7 = class282.method5426(var4.field3517);
                  if (var7 == null || var7.field3602 == null || var4.field3484 >= var7.field3602.length || var7.field3602[var4.field3484] != var4) {
                     continue;
                  }
               }

               var6 = new class79();
               var6.field694 = var4;
               var6.field686 = var4.field3479;
               class57.method5433(var6);
            }
         }
      }

   }
}
