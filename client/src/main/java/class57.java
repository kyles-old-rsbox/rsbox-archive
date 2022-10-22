import java.util.ArrayList;
import java.util.Calendar;

public class class57 {
   static boolean field410 = false;
   static boolean field411 = false;
   static class69[] field399 = new class69[50];
   static int field400 = 0;
   static int field406 = 0;
   static int[] field401;
   static int[] field402 = new int[5];
   static int[] field404 = new int[1000];
   static int[][] field407 = new int[5][5000];
   static String[] field405 = new String[1000];
   static ArrayList field412 = new ArrayList();
   static Calendar field416 = Calendar.getInstance();
   static final double field414 = Math.log(2.0D);
   static final String[] field409 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

   public static int method1274(CharSequence var0, CharSequence var1, class353 var2) {
      int var4 = var0.length();
      int var5 = var1.length();
      int var6 = 0;
      int var7 = 0;
      byte var8 = 0;
      byte var9 = 0;

      while(var6 - var8 < var4 || var7 - var9 < var5) {
         if (var6 - var8 >= var4) {
            return -1;
         }

         if (var7 - var9 >= var5) {
            return 1;
         }

         char var10;
         if (var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var0.charAt(var6++);
         }

         char var11;
         if (0 != var9) {
            var11 = (char)var9;
            boolean var16 = false;
         } else {
            var11 = var1.charAt(var7++);
         }

         byte var12;
         if (198 == var10) {
            var12 = 69;
         } else if (230 == var10) {
            var12 = 101;
         } else if (223 == var10) {
            var12 = 115;
         } else if (var10 == 338) {
            var12 = 69;
         } else if (339 == var10) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         byte var13;
         if (var11 == 198) {
            var13 = 69;
         } else if (230 == var11) {
            var13 = 101;
         } else if (var11 == 223) {
            var13 = 115;
         } else if (338 == var11) {
            var13 = 69;
         } else if (var11 == 339) {
            var13 = 101;
         } else {
            var13 = 0;
         }

         var9 = var13;
         var10 = class216.method4360(var10, var2);
         var11 = class216.method4360(var11, var2);
         if (var10 != var11 && Character.toUpperCase(var10) != Character.toUpperCase(var11)) {
            var10 = Character.toLowerCase(var10);
            var11 = Character.toLowerCase(var11);
            if (var11 != var10) {
               return class199.method3733(var10, var2) - class199.method3733(var11, var2);
            }
         }
      }

      int var17 = Math.min(var4, var5);

      int var18;
      char var21;
      for(var18 = 0; var18 < var17; ++var18) {
         if (var2 == class353.field4294) {
            var6 = var4 - 1 - var18;
            var7 = var5 - 1 - var18;
         } else {
            var7 = var18;
            var6 = var18;
         }

         char var19 = var0.charAt(var6);
         var21 = var1.charAt(var7);
         if (var19 != var21 && Character.toUpperCase(var19) != Character.toUpperCase(var21)) {
            var19 = Character.toLowerCase(var19);
            var21 = Character.toLowerCase(var21);
            if (var19 != var21) {
               return class199.method3733(var19, var2) - class199.method3733(var21, var2);
            }
         }
      }

      var18 = var4 - var5;
      if (var18 != 0) {
         return var18;
      } else {
         for(int var20 = 0; var20 < var17; ++var20) {
            var21 = var0.charAt(var20);
            char var14 = var1.charAt(var20);
            if (var21 != var14) {
               return class199.method3733(var21, var2) - class199.method3733(var14, var2);
            }
         }

         return 0;
      }
   }

   class57() throws Throwable {
      throw new Error();
   }

   public static void method5433(class79 var0) {
      method1954(var0, 500000, 475000);
   }

   static void method1954(class79 var0, int var1, int var2) {
      Object[] var4 = var0.field686;
      class78 var5;
      int var26;
      if (class430.method7838(var0.field696)) {
         class64.field504 = (class245)var4[0];
         class160 var6 = class90.method1885(class64.field504.field2860);
         var5 = class75.method1502(var0.field696, var6.field1481, var6.field1487);
      } else {
         var26 = (Integer)var4[0];
         var5 = class180.method2844(var26);
      }

      if (var5 != null) {
         class387.field4452 = 0;
         class126.field1220 = 0;
         var26 = -1;
         int[] var7 = var5.field674;
         int[] var8 = var5.field680;
         byte var9 = -1;
         field406 = 0;
         field410 = false;
         boolean var10 = false;
         int var11 = 0;
         boolean var23 = false;

         label949: {
            label950: {
               try {
                  int var14;
                  try {
                     var23 = true;
                     field401 = new int[var5.field677];
                     int var12 = 0;
                     class468.field4925 = new String[var5.field678];
                     int var29 = 0;

                     int var15;
                     String var39;
                     for(var14 = 1; var14 < var4.length; ++var14) {
                        if (var4[var14] instanceof Integer) {
                           var15 = (Integer)var4[var14];
                           if (var15 == -2147483647) {
                              var15 = var0.field693;
                           }

                           if (var15 == -2147483646) {
                              var15 = var0.field688;
                           }

                           if (-2147483645 == var15) {
                              var15 = null != var0.field694 ? var0.field694.field3517 * 633110391 * -1917711801 : -1;
                           }

                           if (-2147483644 == var15) {
                              var15 = var0.field690;
                           }

                           if (-2147483643 == var15) {
                              var15 = var0.field694 != null ? 469376671 * var0.field694.field3484 * 1206222175 : -1;
                           }

                           if (var15 == -2147483642) {
                              var15 = var0.field691 != null ? var0.field691.field3517 * 633110391 * -1917711801 : -1;
                           }

                           if (-2147483641 == var15) {
                              var15 = null != var0.field691 ? 469376671 * var0.field691.field3484 * 1206222175 : -1;
                           }

                           if (-2147483640 == var15) {
                              var15 = var0.field689;
                           }

                           if (var15 == -2147483639) {
                              var15 = var0.field687;
                           }

                           field401[var12++] = var15;
                        } else if (var4[var14] instanceof String) {
                           var39 = (String)var4[var14];
                           if (var39.equals("event_opbase")) {
                              var39 = var0.field685;
                           }

                           class468.field4925[var29++] = var39;
                        }
                     }

                     field400 = var0.field695;

                     while(true) {
                        ++var11;
                        if (var11 > var1) {
                           throw new RuntimeException();
                        }

                        ++var26;
                        int var27 = var7[var26];
                        if (var27 >= 100) {
                           boolean var38;
                           if (1 == var5.field680[var26]) {
                              var38 = true;
                           } else {
                              var38 = false;
                           }

                           var15 = class393.method7154(var27, var5, var38);
                           switch(var15) {
                           case 0:
                              var23 = false;
                              break label950;
                           case 1:
                           default:
                              break;
                           case 2:
                              throw new IllegalStateException();
                           }
                        } else if (0 == var27) {
                           field404[++class387.field4452 - 1] = var8[var26];
                        } else if (1 == var27) {
                           var14 = var8[var26];
                           field404[++class387.field4452 - 1] = class293.field3370[var14];
                        } else if (2 == var27) {
                           var14 = var8[var26];
                           class293.field3370[var14] = field404[--class387.field4452];
                           class147.method2521(var14);
                        } else if (var27 == 3) {
                           field405[++class126.field1220 - 1] = var5.field676[var26];
                        } else if (var27 == 6) {
                           var26 += var8[var26];
                        } else if (7 == var27) {
                           class387.field4452 -= 2;
                           if (field404[class387.field4452] != field404[class387.field4452 + 1]) {
                              var26 += var8[var26];
                           }
                        } else if (8 == var27) {
                           class387.field4452 -= 2;
                           if (field404[class387.field4452] == field404[class387.field4452 + 1]) {
                              var26 += var8[var26];
                           }
                        } else if (var27 == 9) {
                           class387.field4452 -= 2;
                           if (field404[class387.field4452] < field404[1 + class387.field4452]) {
                              var26 += var8[var26];
                           }
                        } else if (var27 == 10) {
                           class387.field4452 -= 2;
                           if (field404[class387.field4452] > field404[class387.field4452 + 1]) {
                              var26 += var8[var26];
                           }
                        } else if (var27 == 21) {
                           if (field406 == 0) {
                              var23 = false;
                              break label949;
                           }

                           class69 var37 = field399[--field406];
                           var5 = var37.field552;
                           var7 = var5.field674;
                           var8 = var5.field680;
                           var26 = var37.field554;
                           field401 = var37.field553;
                           class468.field4925 = var37.field555;
                        } else if (25 == var27) {
                           var14 = var8[var26];
                           field404[++class387.field4452 - 1] = class293.method1557(var14);
                        } else if (var27 == 27) {
                           var14 = var8[var26];
                           class410.method7403(var14, field404[--class387.field4452]);
                        } else if (31 == var27) {
                           class387.field4452 -= 2;
                           if (field404[class387.field4452] <= field404[class387.field4452 + 1]) {
                              var26 += var8[var26];
                           }
                        } else if (var27 == 32) {
                           class387.field4452 -= 2;
                           if (field404[class387.field4452] >= field404[class387.field4452 + 1]) {
                              var26 += var8[var26];
                           }
                        } else if (33 == var27) {
                           field404[++class387.field4452 - 1] = field401[var8[var26]];
                        } else if (34 == var27) {
                           field401[var8[var26]] = field404[--class387.field4452];
                        } else if (35 == var27) {
                           field405[++class126.field1220 - 1] = class468.field4925[var8[var26]];
                        } else if (var27 == 36) {
                           class468.field4925[var8[var26]] = field405[--class126.field1220];
                        } else if (37 == var27) {
                           var14 = var8[var26];
                           class126.field1220 -= var14;
                           var39 = class295.method5540(field405, class126.field1220, var14);
                           field405[++class126.field1220 - 1] = var39;
                        } else if (38 == var27) {
                           --class387.field4452;
                        } else if (var27 == 39) {
                           --class126.field1220;
                        } else {
                           int var18;
                           if (40 != var27) {
                              if (var27 == 42) {
                                 field404[++class387.field4452 - 1] = class66.field538.method2305(var8[var26]);
                              } else if (43 == var27) {
                                 class66.field538.method2343(var8[var26], field404[--class387.field4452]);
                              } else if (var27 == 44) {
                                 var14 = var8[var26] >> 16;
                                 var15 = var8[var26] & '\uffff';
                                 int var30 = field404[--class387.field4452];
                                 if (var30 < 0 || var30 > 5000) {
                                    throw new RuntimeException();
                                 }

                                 field402[var14] = var30;
                                 byte var33 = -1;
                                 if (var15 == 105) {
                                    var33 = 0;
                                 }

                                 for(var18 = 0; var18 < var30; ++var18) {
                                    field407[var14][var18] = var33;
                                 }
                              } else if (var27 == 45) {
                                 var14 = var8[var26];
                                 var15 = field404[--class387.field4452];
                                 if (var15 < 0 || var15 >= field402[var14]) {
                                    throw new RuntimeException();
                                 }

                                 field404[++class387.field4452 - 1] = field407[var14][var15];
                              } else if (var27 == 46) {
                                 var14 = var8[var26];
                                 class387.field4452 -= 2;
                                 var15 = field404[class387.field4452];
                                 if (var15 < 0 || var15 >= field402[var14]) {
                                    throw new RuntimeException();
                                 }

                                 field407[var14][var15] = field404[class387.field4452 + 1];
                              } else {
                                 String var31;
                                 if (47 == var27) {
                                    var31 = class66.field538.method2304(var8[var26]);
                                    if (var31 == null) {
                                       var31 = class338.field3899;
                                    }

                                    field405[++class126.field1220 - 1] = var31;
                                 } else if (48 == var27) {
                                    class66.field538.method2308(var8[var26], field405[--class126.field1220]);
                                 } else if (var27 == 49) {
                                    var31 = class66.field538.method2307(var8[var26]);
                                    field405[++class126.field1220 - 1] = var31;
                                 } else if (var27 == 50) {
                                    class66.field538.method2306(var8[var26], field405[--class126.field1220]);
                                 } else if (var27 == 60) {
                                    class421 var34 = var5.field681[var8[var26]];
                                    class426 var42 = (class426)var34.method7781((long)field404[--class387.field4452]);
                                    if (null != var42) {
                                       var26 += var42.field4680;
                                    }
                                 } else {
                                    Integer var35;
                                    if (74 == var27) {
                                       var35 = class12.field55.method2569(var8[var26]);
                                       if (var35 == null) {
                                          field404[++class387.field4452 - 1] = -1;
                                       } else {
                                          field404[++class387.field4452 - 1] = var35;
                                       }
                                    } else {
                                       if (76 != var27) {
                                          throw new IllegalStateException();
                                       }

                                       var35 = class174.field1567.method7405(var8[var26]);
                                       if (null == var35) {
                                          field404[++class387.field4452 - 1] = -1;
                                       } else {
                                          field404[++class387.field4452 - 1] = var35;
                                       }
                                    }
                                 }
                              }
                           } else {
                              var14 = var8[var26];
                              class78 var41 = class180.method2844(var14);
                              int[] var16 = new int[var41.field677];
                              String[] var17 = new String[var41.field678];

                              for(var18 = 0; var18 < var41.field679; ++var18) {
                                 var16[var18] = field404[class387.field4452 - var41.field679 + var18];
                              }

                              for(var18 = 0; var18 < var41.field672; ++var18) {
                                 var17[var18] = field405[class126.field1220 - var41.field672 + var18];
                              }

                              class387.field4452 -= var41.field679;
                              class126.field1220 -= var41.field672;
                              class69 var36 = new class69();
                              var36.field552 = var5;
                              var36.field554 = var26;
                              var36.field553 = field401;
                              var36.field555 = class468.field4925;
                              field399[++field406 - 1] = var36;
                              var5 = var41;
                              var7 = var41.field674;
                              var8 = var41.field680;
                              var26 = -1;
                              field401 = var16;
                              class468.field4925 = var17;
                           }
                        }
                     }
                  } catch (Exception var24) {
                     var10 = true;
                     StringBuilder var13 = new StringBuilder(30);
                     var13.append("").append(var5.field4681).append(" ");
                     var14 = field406 - 1;

                     while(true) {
                        if (var14 < 0) {
                           var13.append("").append(var9);
                           class422.method7800(var13.toString(), var24);
                           var23 = false;
                           break;
                        }

                        var13.append("").append(field399[var14].field552.field4681).append(" ");
                        --var14;
                     }
                  }
               } finally {
                  if (var23) {
                     while(field412.size() > 0) {
                        class98 var20 = (class98)field412.remove(0);
                        class272.method5220(var20.method1965(), var20.method1966(), var20.method1968(), var20.method1969(), "");
                     }

                     if (field410) {
                        field410 = false;
                        class339.method6308();
                     }

                     if (!var10 && var2 > 0 && var11 >= var2) {
                        class422.method7800("Warning: Script " + var5.field673 + " finished at op count " + var11 + " of max " + var1, (Throwable)null);
                     }

                  }
               }

               while(field412.size() > 0) {
                  class98 var28 = (class98)field412.remove(0);
                  class272.method5220(var28.method1965(), var28.method1966(), var28.method1968(), var28.method1969(), "");
               }

               if (field410) {
                  field410 = false;
                  class339.method6308();
               }

               if (!var10 && var2 > 0 && var11 >= var2) {
                  class422.method7800("Warning: Script " + var5.field673 + " finished at op count " + var11 + " of max " + var1, (Throwable)null);
               }

               return;
            }

            while(field412.size() > 0) {
               class98 var32 = (class98)field412.remove(0);
               class272.method5220(var32.method1965(), var32.method1966(), var32.method1968(), var32.method1969(), "");
            }

            if (field410) {
               field410 = false;
               class339.method6308();
            }

            if (!var10 && var2 > 0 && var11 >= var2) {
               class422.method7800("Warning: Script " + var5.field673 + " finished at op count " + var11 + " of max " + var1, (Throwable)null);
            }

            return;
         }

         while(field412.size() > 0) {
            class98 var40 = (class98)field412.remove(0);
            class272.method5220(var40.method1965(), var40.method1966(), var40.method1968(), var40.method1969(), "");
         }

         if (field410) {
            field410 = false;
            class339.method6308();
         }

         if (!var10 && var2 > 0 && var11 >= var2) {
            class422.method7800("Warning: Script " + var5.field673 + " finished at op count " + var11 + " of max " + var1, (Throwable)null);
         }

      }
   }

   static float method1159(class106 var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var3;
         if (var0.field1053 == var1) {
            var3 = 0.0F;
         } else if (var0.field1054 == var1) {
            var3 = 1.0F;
         } else {
            var3 = (var1 - var0.field1053) / (var0.field1054 - var0.field1053);
         }

         float var4;
         if (var0.field1052) {
            var4 = var3;
         } else {
            float[] var5 = new float[]{var0.field1055[0] - var3, var0.field1055[1], var0.field1055[2], var0.field1055[3]};
            float[] var6 = new float[5];
            int var7 = class368.method6726(var5, 3, 0.0F, true, 1.0F, true, var6);
            if (1 == var7) {
               var4 = var6[0];
            } else {
               var4 = 0.0F;
            }
         }

         return var4 * (var0.field1056[1] + var4 * (var0.field1056[2] + var4 * var0.field1056[3])) + var0.field1056[0];
      }
   }

   static int method1273(class453 var0) {
      int var2 = var0.method8007(2);
      int var3;
      if (var2 == 0) {
         var3 = 0;
      } else if (1 == var2) {
         var3 = var0.method8007(5);
      } else if (var2 == 2) {
         var3 = var0.method8007(8);
      } else {
         var3 = var0.method8007(11);
      }

      return var3;
   }

   static final void method2259(class300 var0, int var1, int var2, int var3) {
      if (null == var0.field3590) {
         throw new RuntimeException();
      } else {
         var0.field3590[var1] = var2;
         var0.field3544[var1] = var3;
      }
   }

   static final void method6451(class300 var0, int var1) {
      if (var0.field3541 == null) {
         throw new RuntimeException();
      } else {
         if (null == var0.field3543) {
            var0.field3543 = new int[var0.field3541.length];
         }

         var0.field3543[var1] = Integer.MAX_VALUE;
      }
   }

   static int method33(int var0, class78 var1, boolean var2) {
      return 2;
   }

   static int method6042(int var0) {
      return (int)Math.pow(2.0D, (double)((float)var0 / 256.0F + 7.0F));
   }

   static int method2667(int var0) {
      return (int)((Math.log((double)var0) / field414 - 7.0D) * 256.0D);
   }

   static int method2918(int var0, class78 var1, boolean var2) {
      return 2;
   }

   static int method211(int var0, class78 var1, boolean var2) {
      return 2;
   }

   static int method4885(int var0, class78 var1, boolean var2) {
      return 2;
   }

   static int method4728(int var0, class78 var1, boolean var2) {
      return 2;
   }

   static void method6317(int var0, class295 var1, boolean var2) {
      class254 var4 = client.method6316().method7596(var0);
      int var5 = class291.field3364.field914;
      int var6 = (class291.field3364.field827 >> 7) + class36.field241;
      int var7 = class169.field1536 + (class291.field3364.field802 >> 7);
      class295 var8 = new class295(var5, var6, var7);
      client.method6316().method7584(var4, var8, var1, var2);
   }

   static Object method1287(int var0) {
      return class191.method3533((class451)class217.method4362(class451.method7977(), var0));
   }
}
