import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class class42 implements MouseListener, MouseMotionListener, FocusListener {
   public static int field277 = 0;
   public static int field283 = 0;
   public static int field284 = 0;
   public static int field285 = 0;
   public static int field289 = 0;
   public static int field293 = 0;
   public static String field296;
   public static long field279 = 0L;
   public static long field286 = 0L;
   public static volatile int field278 = 0;
   static class336 field295;
   static class42 field292 = new class42();
   static int field298;
   static volatile int field275 = 0;
   static volatile int field280 = -1;
   static volatile int field281 = -1;
   static volatile int field287 = 0;
   static volatile int field288 = 0;
   static volatile int field291 = 0;
   static volatile long field282 = -1L;
   static volatile long field290 = 0L;

   static void method773(int var0, String var1, String var2) {
      class110.method1858(var0, var1, var2, (String)null);
   }

   class42() {
   }

   public static void method799(boolean var0) {
      if (null != class324.field3787) {
         try {
            class460 var2 = new class460(4);
            var2.method8097(var0 ? 2 : 3);
            var2.method8099(0);
            class324.field3787.method7251(var2.field4881, 0, 4);
         } catch (IOException var5) {
            try {
               class324.field3787.method7252();
            } catch (Exception var4) {
            }

            ++class324.field3775;
            class324.field3787 = null;
         }

      }
   }

   public static void method4616() {
      synchronized(field292) {
         field289 = field291;
         field284 = field280;
         field285 = field281;
         field286 = field282;
         field277 = field287;
         field283 = field275;
         field293 = field288;
         field279 = field290;
         field287 = 0;
      }
   }

   final int method772(MouseEvent var1) {
      int var3 = var1.getButton();
      if (!var1.isAltDown() && 2 != var3) {
         return !var1.isMetaDown() && 3 != var3 ? 1 : 2;
      } else {
         return 4;
      }
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if (null != field292) {
         field278 = 0;
         field275 = var1.getX();
         field288 = var1.getY();
         field290 = class272.method2046();
         field287 = this.method772(var1);
         if (0 != field287) {
            field291 = field287;
         }
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if (null != field292) {
         field278 = 0;
         field291 = 0;
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if (field292 != null) {
         field278 = 0;
         field280 = -1;
         field281 = -1;
         field282 = var1.getWhen();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if (null != field292) {
         field278 = 0;
         field280 = var1.getX();
         field281 = var1.getY();
         field282 = var1.getWhen();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if (field292 != null) {
         field291 = 0;
      }

   }

   static final void method795(int var0, int var1, int var2, int var3, boolean var4) {
      if (var2 < 1) {
         var2 = 1;
      }

      if (var3 < 1) {
         var3 = 1;
      }

      int var6 = var3 - 334;
      int var7;
      if (var6 < 0) {
         var7 = client.field1907;
      } else if (var6 >= 100) {
         var7 = client.field1792;
      } else {
         var7 = client.field1907 + var6 * (client.field1792 - client.field1907) / 100;
      }

      int var8 = 512 * var7 * var3 / (var2 * 334);
      int var9;
      int var10;
      short var11;
      if (var8 < client.field1705) {
         var11 = client.field1705;
         var7 = 334 * var2 * var11 / (var3 * 512);
         if (var7 > client.field1912) {
            var7 = client.field1912;
            var9 = var7 * var3 * 512 / (var11 * 334);
            var10 = (var2 - var9) / 2;
            if (var4) {
               class481.method8708();
               class481.method8653(var0, var1, var10, var3, -16777216);
               class481.method8653(var2 + var0 - var10, var1, var10, var3, -16777216);
            }

            var0 += var10;
            var2 -= 2 * var10;
         }
      } else if (var8 > client.field1914) {
         var11 = client.field1914;
         var7 = 334 * var2 * var11 / (512 * var3);
         if (var7 < client.field1744) {
            var7 = client.field1744;
            var9 = var11 * var2 * 334 / (512 * var7);
            var10 = (var3 - var9) / 2;
            if (var4) {
               class481.method8708();
               class481.method8653(var0, var1, var2, var10, -16777216);
               class481.method8653(var0, var3 + var1 - var10, var2, var10, -16777216);
            }

            var1 += var10;
            var3 -= 2 * var10;
         }
      }

      client.field1919 = var3 * var7 / 334;
      if (client.field1917 != var2 || var3 != client.field1678) {
         class336.method6274(var2, var3);
      }

      client.field1915 = var0;
      client.field1634 = var1;
      client.field1917 = var2;
      client.field1678 = var3;
   }

   static final void method790(int var0, int var1, int var2, int var3) {
      if (0 == client.field1802 && !client.field1804) {
         client.method351(class338.field4029, "", 23, 0, var0 - var2, var1 - var3);
      }

      long var5 = -1L;
      long var7 = -1L;

      int var9;
      for(var9 = 0; var9 < class234.method1116(); ++var9) {
         long var10 = class234.field2766[var9];
         if (var7 != var10) {
            var7 = var10;
            int var14 = class234.method7545(class234.field2766[var9]);
            int var15 = var14;
            int var16 = class234.method134(var9);
            long var19 = class234.field2766[var9];
            int var18 = (int)(var19 >>> 14 & 3L);
            int var28 = class234.method1610(class234.field2766[var9]);
            int var20 = var28;
            int var24;
            if (var18 == 2 && class145.field1333.method4156(class55.field396, var14, var16, var10) >= 0) {
               class195 var21 = class89.method1866(var28);
               if (var21.field2094 != null) {
                  var21 = var21.method3588();
               }

               if (var21 == null) {
                  continue;
               }

               class101 var22 = null;

               for(class101 var23 = (class101)client.field1777.method6356(); null != var23; var23 = (class101)client.field1777.method6350()) {
                  if (var23.field993 == class55.field396 && var15 == var23.field999 && var23.field994 == var16 && var23.field998 == var20) {
                     var22 = var23;
                     break;
                  }
               }

               if (client.field1802 == 1) {
                  client.method351(class338.field3898, client.field1803 + " " + class96.field963 + " " + class96.method4510(65535) + var21.field2063, 1, var20, var15, var16);
               } else if (client.field1804) {
                  if ((class120.field1161 & 4) == 4) {
                     client.method351(client.field1653, client.field1754 + " " + class96.field963 + " " + class96.method4510(65535) + var21.field2063, 2, var20, var15, var16);
                  }
               } else {
                  String[] var33 = var21.field2060;
                  if (var33 != null) {
                     for(var24 = 4; var24 >= 0; --var24) {
                        if ((var22 == null || var22.method1996(var24)) && var33[var24] != null) {
                           short var25 = 0;
                           if (0 == var24) {
                              var25 = 3;
                           }

                           if (var24 == 1) {
                              var25 = 4;
                           }

                           if (var24 == 2) {
                              var25 = 5;
                           }

                           if (var24 == 3) {
                              var25 = 6;
                           }

                           if (var24 == 4) {
                              var25 = 1001;
                           }

                           client.method351(var33[var24], class96.method4510(65535) + var21.field2063, var25, var20, var15, var16);
                        }
                     }
                  }

                  client.method351(class338.field4182, class96.method4510(65535) + var21.field2063, 1002, var21.field2052, var15, var16);
               }
            }

            int var32;
            class81 var34;
            int[] var35;
            class93 var39;
            if (var18 == 1) {
               class81 var29 = client.field1902[var20];
               if (null == var29) {
                  continue;
               }

               if (1 == var29.field709.field2262 && (var29.field827 & 127) == 64 && (var29.field802 & 127) == 64) {
                  for(var32 = 0; var32 < client.field1691; ++var32) {
                     var34 = client.field1902[client.field1692[var32]];
                     if (null != var34 && var34 != var29 && 1 == var34.field709.field2262 && var34.field827 == var29.field827 && var29.field802 == var34.field802) {
                        class295.method5541(var34, client.field1692[var32], var15, var16);
                     }
                  }

                  var32 = class102.field1012;
                  var35 = class102.field1013;

                  for(var24 = 0; var24 < var32; ++var24) {
                     var39 = client.field1763[var35[var24]];
                     if (null != var39 && var39.field827 == var29.field827 && var29.field802 == var39.field802) {
                        class117.method2256(var39, var35[var24], var15, var16);
                     }
                  }
               }

               class295.method5541(var29, var20, var15, var16);
            }

            if (0 == var18) {
               class93 var30 = client.field1763[var20];
               if (null == var30) {
                  continue;
               }

               if ((var30.field827 & 127) == 64 && 64 == (var30.field802 & 127)) {
                  for(var32 = 0; var32 < client.field1691; ++var32) {
                     var34 = client.field1902[client.field1692[var32]];
                     if (var34 != null && var34.field709.field2262 == 1 && var30.field827 == var34.field827 && var34.field802 == var30.field802) {
                        class295.method5541(var34, client.field1692[var32], var15, var16);
                     }
                  }

                  var32 = class102.field1012;
                  var35 = class102.field1013;

                  for(var24 = 0; var24 < var32; ++var24) {
                     var39 = client.field1763[var35[var24]];
                     if (var39 != null && var30 != var39 && var39.field827 == var30.field827 && var30.field802 == var39.field802) {
                        class117.method2256(var39, var35[var24], var15, var16);
                     }
                  }
               }

               if (var20 != client.field1775) {
                  class117.method2256(var30, var20, var15, var16);
               } else {
                  var5 = var10;
               }
            }

            if (3 == var18) {
               class343 var31 = client.field1865[class55.field396][var15][var16];
               if (var31 != null) {
                  for(class104 var36 = (class104)var31.method6355(); var36 != null; var36 = (class104)var31.method6370()) {
                     class198 var37 = class278.method5388(var36.field1043);
                     if (client.field1802 == 1) {
                        client.method351(class338.field3898, client.field1803 + " " + class96.field963 + " " + class96.method4510(16748608) + var37.field2131, 16, var36.field1043, var15, var16);
                     } else if (client.field1804) {
                        if ((class120.field1161 & 1) == 1) {
                           client.method351(client.field1653, client.field1754 + " " + class96.field963 + " " + class96.method4510(16748608) + var37.field2131, 17, var36.field1043, var15, var16);
                        }
                     } else {
                        String[] var38 = var37.field2148;

                        for(int var40 = 4; var40 >= 0; --var40) {
                           if (var36.method2028(var40)) {
                              if (var38 != null && null != var38[var40]) {
                                 byte var26 = 0;
                                 if (var40 == 0) {
                                    var26 = 18;
                                 }

                                 if (var40 == 1) {
                                    var26 = 19;
                                 }

                                 if (var40 == 2) {
                                    var26 = 20;
                                 }

                                 if (var40 == 3) {
                                    var26 = 21;
                                 }

                                 if (4 == var40) {
                                    var26 = 22;
                                 }

                                 client.method351(var38[var40], class96.method4510(16748608) + var37.field2131, var26, var36.field1043, var15, var16);
                              } else if (2 == var40) {
                                 client.method351(class338.field3949, class96.method4510(16748608) + var37.field2131, 20, var36.field1043, var15, var16);
                              }
                           }
                        }

                        client.method351(class338.field4182, class96.method4510(16748608) + var37.field2131, 1004, var36.field1043, var15, var16);
                     }
                  }
               }
            }
         }
      }

      if (var5 != -1L) {
         var9 = class234.method7545(var5);
         int var27 = class234.method3636(var5);
         class93 var11 = client.field1763[client.field1775];
         class117.method2256(var11, client.field1775, var9, var27);
      }

   }

   static final boolean method796(class300 var0) {
      if (null == var0.field3591) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.field3591.length; ++var2) {
            int var3 = class262.method5150(var0, var2);
            int var4 = var0.field3592[var2];
            if (var0.field3591[var2] == 2) {
               if (var3 >= var4) {
                  return false;
               }
            } else if (3 == var0.field3591[var2]) {
               if (var3 <= var4) {
                  return false;
               }
            } else if (var0.field3591[var2] == 4) {
               if (var4 == var3) {
                  return false;
               }
            } else if (var3 != var4) {
               return false;
            }
         }

         return true;
      }
   }
}
