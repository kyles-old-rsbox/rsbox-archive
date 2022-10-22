import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

@class308
public final class class264 {
   static class473[] field2999;
   static int field2998;
   static final HashMap field2994 = new HashMap();

   static {
      TimeZone var0;
      synchronized(field2994) {
         TimeZone var2 = (TimeZone)field2994.get("Europe/London");
         if (var2 == null) {
            var2 = TimeZone.getTimeZone("Europe/London");
            field2994.put("Europe/London", var2);
         }

         var0 = var2;
      }

      Calendar.getInstance(var0);
   }

   class264() throws Throwable {
      throw new Error();
   }

   static void method5168(int var0, int var1) {
      int[] var3 = new int[4];
      int[] var4 = new int[4];
      var3[0] = var0;
      var4[0] = var1;
      int var5 = 1;

      for(int var6 = 0; var6 < 4; ++var6) {
         if (class72.field585[var6] != var0) {
            var3[var5] = class72.field585[var6];
            var4[var5] = class72.field584[var6];
            ++var5;
         }
      }

      class72.field585 = var3;
      class72.field584 = var4;
      class12.method91(class399.field4502, 0, class399.field4502.length - 1, class72.field585, class72.field584);
   }

   static final void method5166(class300[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class481.method8646(var2, var3, var4, var5);
      class221.method4389();

      for(int var10 = 0; var10 < var0.length; ++var10) {
         class300 var11 = var0[var10];
         if (var11 != null && (var11.field3596 == var1 || var1 == -1412584499 && var11 == client.field1874)) {
            int var12;
            if (var8 == -1) {
               client.field1863[client.field1858] = var6 + var11.field3473;
               client.field1864[client.field1858] = var7 + var11.field3551;
               client.field1710[client.field1858] = var11.field3448;
               client.field1658[client.field1858] = var11.field3476;
               var12 = ++client.field1858 - 1;
            } else {
               var12 = var8;
            }

            var11.field3609 = var12;
            var11.field3610 = client.field1645;
            if (!var11.field3459 || !client.method343(var11)) {
               if (var11.field3464 > 0) {
                  method5169(var11);
               }

               int var13 = var6 + var11.field3473;
               int var14 = var7 + var11.field3551;
               int var15 = var11.field3612;
               int var16;
               int var17;
               if (var11 == client.field1874) {
                  if (-1412584499 != var1 && !var11.field3550) {
                     class78.field682 = var0;
                     class374.field4385 = var6;
                     class47.field341 = var7;
                     continue;
                  }

                  if (client.field1833 && client.field1827) {
                     var16 = class42.field284;
                     var17 = class42.field285;
                     var16 -= client.field1824;
                     var17 -= client.field1825;
                     if (var16 < client.field1746) {
                        var16 = client.field1746;
                     }

                     if (var16 + var11.field3448 > client.field1823.field3448 + client.field1746) {
                        var16 = client.field1823.field3448 + client.field1746 - var11.field3448;
                     }

                     if (var17 < client.field1829) {
                        var17 = client.field1829;
                     }

                     if (var11.field3476 + var17 > client.field1823.field3476 + client.field1829) {
                        var17 = client.field1823.field3476 + client.field1829 - var11.field3476;
                     }

                     var13 = var16;
                     var14 = var17;
                  }

                  if (!var11.field3550) {
                     var15 = 128;
                  }
               }

               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               int var23;
               if (var11.field3462 == 2) {
                  var16 = var2;
                  var17 = var3;
                  var18 = var4;
                  var19 = var5;
               } else if (var11.field3462 == 9) {
                  var20 = var13;
                  var21 = var14;
                  var22 = var11.field3448 + var13;
                  var23 = var11.field3476 + var14;
                  if (var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  if (var23 < var14) {
                     var21 = var23;
                     var23 = var14;
                  }

                  ++var22;
                  ++var23;
                  var16 = var20 > var2 ? var20 : var2;
                  var17 = var21 > var3 ? var21 : var3;
                  var18 = var22 < var4 ? var22 : var4;
                  var19 = var23 < var5 ? var23 : var5;
               } else {
                  var20 = var13 + var11.field3448;
                  var21 = var11.field3476 + var14;
                  var16 = var13 > var2 ? var13 : var2;
                  var17 = var14 > var3 ? var14 : var3;
                  var18 = var20 < var4 ? var20 : var4;
                  var19 = var21 < var5 ? var21 : var5;
               }

               if (!var11.field3459 || var16 < var18 && var17 < var19) {
                  if (var11.field3464 != 0) {
                     if (var11.field3464 == 1336) {
                        if (class413.field4575.method1711()) {
                           var14 += 15;
                           class353.field4289.method6861("Fps:" + class31.field174, var11.field3448 + var13, var14, 16776960, -1);
                           var14 += 15;
                           Runtime var48 = Runtime.getRuntime();
                           var21 = (int)((var48.totalMemory() - var48.freeMemory()) / 1024L);
                           var22 = 16776960;
                           if (var21 > 327680 && !client.field1636) {
                              var22 = 16711680;
                           }

                           class353.field4289.method6861("Mem:" + var21 + "k", var13 + var11.field3448, var14, var22, -1);
                           var14 += 15;
                        }
                        continue;
                     }

                     if (1337 == var11.field3464) {
                        client.field1798 = var13;
                        client.field1799 = var14;
                        class9.method63(var13, var14, var11.field3448, var11.field3476);
                        client.field1860[var11.field3609] = true;
                        class481.method8646(var2, var3, var4, var5);
                        continue;
                     }

                     if (var11.field3464 == 1338) {
                        class73.method1487(var11, var13, var14, var12);
                        class481.method8646(var2, var3, var4, var5);
                        continue;
                     }

                     if (1339 == var11.field3464) {
                        class125.method2358(var11, var13, var14, var12);
                        class481.method8646(var2, var3, var4, var5);
                        continue;
                     }

                     if (var11.field3464 == 1400) {
                        class4.field10.method7656(var13, var14, var11.field3448, var11.field3476, client.field1645);
                     }

                     if (1401 == var11.field3464) {
                        class4.field10.method7589(var13, var14, var11.field3448, var11.field3476);
                     }

                     if (1402 == var11.field3464) {
                        class77.field670.method1807(var13, client.field1645);
                     }
                  }

                  if (var11.field3462 == 0) {
                     if (!var11.field3459 && client.method343(var11) && var11 != class219.field2616) {
                        continue;
                     }

                     if (!var11.field3459) {
                        if (var11.field3482 > var11.field3492 - var11.field3476) {
                           var11.field3482 = var11.field3492 - var11.field3476;
                        }

                        if (var11.field3482 < 0) {
                           var11.field3482 = 0;
                        }
                     }

                     method5166(var0, var11.field3517, var16, var17, var18, var19, var13 - var11.field3481, var14 - var11.field3482, var12);
                     if (var11.field3602 != null) {
                        method5166(var11.field3602, var11.field3517, var16, var17, var18, var19, var13 - var11.field3481, var14 - var11.field3482, var12);
                     }

                     class89 var31 = (class89)client.field1810.get((long)var11.field3517);
                     if (null != var31) {
                        class41.method763(var31.field796, var16, var17, var18, var19, var13, var14, var12);
                     }

                     class481.method8646(var2, var3, var4, var5);
                     class221.method4389();
                  } else if (var11.field3462 == 11) {
                     if (client.method343(var11) && var11 != class219.field2616) {
                        continue;
                     }

                     if (var11.field3602 != null) {
                        method5166(var11.field3602, var11.field3517, var16, var17, var18, var19, var13 - var11.field3481, var14 - var11.field3482, var12);
                     }

                     class481.method8646(var2, var3, var4, var5);
                     class221.method4389();
                  }

                  if (client.field1869 || client.field1800[var12] || client.field1867 > 1) {
                     if (var11.field3462 == 0 && !var11.field3459 && var11.field3492 > var11.field3476) {
                        client.method1783(var11.field3448 + var13, var14, var11.field3482, var11.field3476, var11.field3492);
                     }

                     if (var11.field3462 != 1) {
                        int var26;
                        int var27;
                        int var41;
                        int var43;
                        if (2 == var11.field3462) {
                           var20 = 0;

                           for(var21 = 0; var21 < var11.field3472; ++var21) {
                              for(var22 = 0; var22 < var11.field3486; ++var22) {
                                 var23 = var22 * (var11.field3528 + 32) + var13;
                                 var43 = var14 + (var11.field3529 + 32) * var21;
                                 if (var20 < 20) {
                                    var23 += var11.field3530[var20];
                                    var43 += var11.field3531[var20];
                                 }

                                 if (var11.field3461[var20] <= 0) {
                                    if (null != var11.field3526 && var20 < 20) {
                                       class473 var49 = var11.method5849(var20);
                                       if (null != var49) {
                                          var49.method8519(var23, var43);
                                       } else if (class300.field3458) {
                                          class136.method2438(var11);
                                       }
                                    }
                                 } else {
                                    boolean var47 = false;
                                    boolean var44 = false;
                                    var27 = var11.field3461[var20] - 1;
                                    if (var23 + 32 > var2 && var23 < var4 && 32 + var43 > var3 && var43 < var5 || var11 == class183.field1943 && var20 == client.field1737) {
                                       class473 var45;
                                       if (client.field1802 == 1 && class6.field23 == var20 && var11.field3517 == class213.field2493) {
                                          var45 = class71.method1436(var27, var11.field3456[var20], 2, 0, 2, false);
                                       } else {
                                          var45 = class71.method1436(var27, var11.field3456[var20], 1, 3153952, 2, false);
                                       }

                                       if (null != var45) {
                                          if (class183.field1943 == var11 && var20 == client.field1737) {
                                             var41 = class42.field284 - client.field1638;
                                             var26 = class42.field285 - client.field1757;
                                             if (var41 < 5 && var41 > -5) {
                                                var41 = 0;
                                             }

                                             if (var26 < 5 && var26 > -5) {
                                                var26 = 0;
                                             }

                                             if (client.field1786 < 5) {
                                                var41 = 0;
                                                var26 = 0;
                                             }

                                             var45.method8484(var23 + var41, var43 + var26, 128);
                                             if (-1 != var1) {
                                                class300 var29 = var0[var1 & '\uffff'];
                                                int var30;
                                                if (var26 + var43 < class481.field4995 && var29.field3482 > 0) {
                                                   var30 = (class481.field4995 - var43 - var26) * client.field1701 / 3;
                                                   if (var30 > client.field1701 * 10) {
                                                      var30 = client.field1701 * 10;
                                                   }

                                                   if (var30 > var29.field3482) {
                                                      var30 = var29.field3482;
                                                   }

                                                   var29.field3482 -= var30;
                                                   client.field1757 += var30;
                                                   class136.method2438(var29);
                                                }

                                                if (var26 + var43 + 32 > class481.field4998 && var29.field3482 < var29.field3492 - var29.field3476) {
                                                   var30 = client.field1701 * (var43 + var26 + 32 - class481.field4998) / 3;
                                                   if (var30 > client.field1701 * 10) {
                                                      var30 = client.field1701 * 10;
                                                   }

                                                   if (var30 > var29.field3492 - var29.field3476 - var29.field3482) {
                                                      var30 = var29.field3492 - var29.field3476 - var29.field3482;
                                                   }

                                                   var29.field3482 += var30;
                                                   client.field1757 -= var30;
                                                   class136.method2438(var29);
                                                }
                                             }
                                          } else if (class132.field1247 == var11 && var20 == client.field1888) {
                                             var45.method8484(var23, var43, 128);
                                          } else {
                                             var45.method8519(var23, var43);
                                          }
                                       } else {
                                          class136.method2438(var11);
                                       }
                                    }
                                 }

                                 ++var20;
                              }
                           }
                        } else if (var11.field3462 == 3) {
                           if (class42.method796(var11)) {
                              var20 = var11.field3495;
                              if (var11 == class219.field2616 && var11.field3567 != 0) {
                                 var20 = var11.field3567;
                              }
                           } else {
                              var20 = var11.field3485;
                              if (class219.field2616 == var11 && var11.field3487 != 0) {
                                 var20 = var11.field3487;
                              }
                           }

                           if (var11.field3489) {
                              switch(var11.field3490.field4930) {
                              case 1:
                                 class481.method8679(var13, var14, var11.field3448, var11.field3476, var11.field3485, var11.field3495);
                                 break;
                              case 2:
                                 class481.method8678(var13, var14, var11.field3448, var11.field3476, var11.field3485, var11.field3495, 255 - (var11.field3612 & 255), 255 - (var11.field3588 & 255));
                                 break;
                              default:
                                 if (0 == var15) {
                                    class481.method8653(var13, var14, var11.field3448, var11.field3476, var20);
                                 } else {
                                    class481.method8652(var13, var14, var11.field3448, var11.field3476, var20, 256 - (var15 & 255));
                                 }
                              }
                           } else if (var15 == 0) {
                              class481.method8657(var13, var14, var11.field3448, var11.field3476, var20);
                           } else {
                              class481.method8661(var13, var14, var11.field3448, var11.field3476, var20, 256 - (var15 & 255));
                           }
                        } else {
                           class376 var32;
                           if (var11.field3462 == 4) {
                              var32 = var11.method5848();
                              if (null == var32) {
                                 if (class300.field3458) {
                                    class136.method2438(var11);
                                 }
                              } else {
                                 String var46 = var11.field3522;
                                 if (class42.method796(var11)) {
                                    var21 = var11.field3495;
                                    if (class219.field2616 == var11 && 0 != var11.field3567) {
                                       var21 = var11.field3567;
                                    }

                                    if (var11.field3523.length() > 0) {
                                       var46 = var11.field3523;
                                    }
                                 } else {
                                    var21 = var11.field3485;
                                    if (var11 == class219.field2616 && 0 != var11.field3487) {
                                       var21 = var11.field3487;
                                    }
                                 }

                                 if (var11.field3459 && -1 != var11.field3445) {
                                    class198 var50 = class278.method5388(var11.field3445);
                                    var46 = var50.field2131;
                                    if (var46 == null) {
                                       var46 = class338.field3899;
                                    }

                                    if ((1 == var50.field2142 || 1 != var11.field3599) && var11.field3599 != -1) {
                                       var46 = class96.method4510(16748608) + var46 + class96.field965 + " " + 'x' + class34.method650(var11.field3599);
                                    }
                                 }

                                 if (client.field1641 == var11) {
                                    var46 = class338.field4062;
                                    var21 = var11.field3485;
                                 }

                                 if (!var11.field3459) {
                                    var46 = class11.method76(var46, var11);
                                 }

                                 var32.method6863(var46, var13, var14, var11.field3448, var11.field3476, var21, var11.field3488 ? 0 : -1, var11.field3525, var11.field3572, var11.field3524);
                              }
                           } else if (var11.field3462 == 5) {
                              class473 var38;
                              if (!var11.field3459) {
                                 var38 = var11.method5844(class42.method796(var11), class28.field155);
                                 if (null != var38) {
                                    var38.method8519(var13, var14);
                                 } else if (class300.field3458) {
                                    class136.method2438(var11);
                                 }
                              } else {
                                 if (-1 != var11.field3445) {
                                    var38 = class71.method1436(var11.field3445, var11.field3599, var11.field3500, var11.field3501, var11.field3520, false);
                                 } else {
                                    var38 = var11.method5844(false, class28.field155);
                                 }

                                 if (var38 == null) {
                                    if (class300.field3458) {
                                       class136.method2438(var11);
                                    }
                                 } else {
                                    var21 = var38.field4956;
                                    var22 = var38.field4957;
                                    if (!var11.field3499) {
                                       var23 = var11.field3448 * 4096 / var21;
                                       if (var11.field3498 != 0) {
                                          var38.method8497(var11.field3448 / 2 + var13, var11.field3476 / 2 + var14, var11.field3498, var23);
                                       } else if (var15 != 0) {
                                          var38.method8486(var13, var14, var11.field3448, var11.field3476, 256 - (var15 & 255));
                                       } else if (var11.field3448 == var21 && var11.field3476 == var22) {
                                          var38.method8519(var13, var14);
                                       } else {
                                          var38.method8480(var13, var14, var11.field3448, var11.field3476);
                                       }
                                    } else {
                                       class481.method8717(var13, var14, var11.field3448 + var13, var14 + var11.field3476);
                                       var23 = (var21 - 1 + var11.field3448) / var21;
                                       var43 = (var22 - 1 + var11.field3476) / var22;

                                       for(var41 = 0; var41 < var23; ++var41) {
                                          for(var26 = 0; var26 < var43; ++var26) {
                                             if (var11.field3498 != 0) {
                                                var38.method8497(var41 * var21 + var13 + var21 / 2, var22 / 2 + var14 + var26 * var22, var11.field3498, 4096);
                                             } else if (0 != var15) {
                                                var38.method8484(var13 + var21 * var41, var22 * var26 + var14, 256 - (var15 & 255));
                                             } else {
                                                var38.method8519(var41 * var21 + var13, var14 + var26 * var22);
                                             }
                                          }
                                       }

                                       class481.method8646(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class198 var24;
                              if (6 == var11.field3462) {
                                 boolean var37 = class42.method796(var11);
                                 if (var37) {
                                    var21 = var11.field3509;
                                 } else {
                                    var21 = var11.field3575;
                                 }

                                 class209 var40 = null;
                                 var23 = 0;
                                 if (-1 != var11.field3445) {
                                    var24 = class278.method5388(var11.field3445);
                                    if (var24 != null) {
                                       var24 = var24.method3651(var11.field3599);
                                       var40 = var24.method3648(1);
                                       if (null != var40) {
                                          var40.method4067();
                                          var23 = var40.field2489 / 2;
                                       } else {
                                          class136.method2438(var11);
                                       }
                                    }
                                 } else if (5 == var11.field3504) {
                                    if (0 == var11.field3505) {
                                       var40 = client.field1920.method5995((class189)null, -1, (class189)null, -1);
                                    } else {
                                       var40 = class291.field3364.method4112();
                                    }
                                 } else if (var21 == -1) {
                                    var40 = var11.method5850((class189)null, -1, var37, class291.field3364.field911);
                                    if (null == var40 && class300.field3458) {
                                       class136.method2438(var11);
                                    }
                                 } else {
                                    class189 var42 = class160.method2660(var21);
                                    var40 = var11.method5850(var42, var11.field3471, var37, class291.field3364.field911);
                                    if (var40 == null && class300.field3458) {
                                       class136.method2438(var11);
                                    }
                                 }

                                 class221.method4432(var13 + var11.field3448 / 2, var11.field3476 / 2 + var14);
                                 var43 = var11.field3562 * class221.field2644[var11.field3601] >> 16;
                                 var41 = var11.field3562 * class221.field2645[var11.field3601] >> 16;
                                 if (null != var40) {
                                    if (!var11.field3459) {
                                       var40.method4074(0, var11.field3513, 0, var11.field3601, 0, var43, var41);
                                    } else {
                                       var40.method4067();
                                       if (var11.field3534) {
                                          var40.method3996(0, var11.field3513, var11.field3514, var11.field3601, var11.field3510, var23 + var43 + var11.field3548, var41 + var11.field3548, var11.field3562);
                                       } else {
                                          var40.method4074(0, var11.field3513, var11.field3514, var11.field3601, var11.field3510, var11.field3548 + var43 + var23, var41 + var11.field3548);
                                       }
                                    }
                                 }

                                 class221.method4391();
                              } else {
                                 if (7 == var11.field3462) {
                                    var32 = var11.method5848();
                                    if (null == var32) {
                                       if (class300.field3458) {
                                          class136.method2438(var11);
                                       }
                                       continue;
                                    }

                                    var21 = 0;

                                    for(var22 = 0; var22 < var11.field3472; ++var22) {
                                       for(var23 = 0; var23 < var11.field3486; ++var23) {
                                          if (var11.field3461[var21] > 0) {
                                             var24 = class278.method5388(var11.field3461[var21] - 1);
                                             String var25;
                                             if (1 != var24.field2142 && var11.field3456[var21] == 1) {
                                                var25 = class96.method4510(16748608) + var24.field2131 + class96.field965;
                                             } else {
                                                var25 = class96.method4510(16748608) + var24.field2131 + class96.field965 + " " + 'x' + class34.method650(var11.field3456[var21]);
                                             }

                                             var26 = var23 * (115 + var11.field3528) + var13;
                                             var27 = var14 + (var11.field3529 + 12) * var22;
                                             if (var11.field3525 == 0) {
                                                var32.method6868(var25, var26, var27, var11.field3485, var11.field3488 ? 0 : -1);
                                             } else if (1 == var11.field3525) {
                                                var32.method6948(var25, var11.field3448 / 2 + var26, var27, var11.field3485, var11.field3488 ? 0 : -1);
                                             } else {
                                                var32.method6861(var25, var11.field3448 + var26 - 1, var27, var11.field3485, var11.field3488 ? 0 : -1);
                                             }
                                          }

                                          ++var21;
                                       }
                                    }
                                 }

                                 class376 var34;
                                 if (8 == var11.field3462 && var11 == class219.field2617 && client.field1929 == client.field1670) {
                                    var20 = 0;
                                    var21 = 0;
                                    var34 = class353.field4289;
                                    String var39 = var11.field3522;

                                    String var36;
                                    for(var39 = class11.method76(var39, var11); var39.length() > 0; var21 += 1 + var34.field4435) {
                                       var41 = var39.indexOf(class96.field966);
                                       if (var41 != -1) {
                                          var36 = var39.substring(0, var41);
                                          var39 = var39.substring(var41 + 4);
                                       } else {
                                          var36 = var39;
                                          var39 = "";
                                       }

                                       var26 = var34.method6887(var36);
                                       if (var26 > var20) {
                                          var20 = var26;
                                       }
                                    }

                                    var20 += 6;
                                    var21 += 7;
                                    var41 = var13 + var11.field3448 - 5 - var20;
                                    var26 = var11.field3476 + var14 + 5;
                                    if (var41 < 5 + var13) {
                                       var41 = 5 + var13;
                                    }

                                    if (var41 + var20 > var4) {
                                       var41 = var4 - var20;
                                    }

                                    if (var21 + var26 > var5) {
                                       var26 = var5 - var21;
                                    }

                                    class481.method8653(var41, var26, var20, var21, 16777120);
                                    class481.method8657(var41, var26, var20, var21, 0);
                                    var39 = var11.field3522;
                                    var27 = 2 + var34.field4435 + var26;

                                    for(var39 = class11.method76(var39, var11); var39.length() > 0; var27 += 1 + var34.field4435) {
                                       int var28 = var39.indexOf(class96.field966);
                                       if (-1 != var28) {
                                          var36 = var39.substring(0, var28);
                                          var39 = var39.substring(4 + var28);
                                       } else {
                                          var36 = var39;
                                          var39 = "";
                                       }

                                       var34.method6868(var36, 3 + var41, var27, 0, -1);
                                    }
                                 }

                                 if (9 == var11.field3462) {
                                    if (var11.field3494) {
                                       var20 = var13;
                                       var21 = var14 + var11.field3476;
                                       var22 = var13 + var11.field3448;
                                       var23 = var14;
                                    } else {
                                       var20 = var13;
                                       var21 = var14;
                                       var22 = var11.field3448 + var13;
                                       var23 = var11.field3476 + var14;
                                    }

                                    if (var11.field3493 == 1) {
                                       class481.method8663(var20, var21, var22, var23, var11.field3485);
                                    } else {
                                       class380.method6799(var20, var21, var22, var23, var11.field3485, var11.field3493);
                                    }
                                 } else if (var11.field3462 == 12) {
                                    class297 var33 = var11.method5869();
                                    class302 var35 = var11.method5946();
                                    if (var33 != null && var35 != null && var33.method5691()) {
                                       var34 = var11.method5848();
                                       if (var34 != null) {
                                          client.field1852.method8420(var13, var14, var11.field3448, var11.field3476, var33.method5609(), var33.method5677(), 0, 0, var33.method5606(), var33.method5683(), var33.method5605());
                                          var23 = var11.field3488 ? var11.field3501 * -1568224905 * 1004200007 : -1;
                                          if (!var33.method5585() && var33.method5747().method7024()) {
                                             client.field1852.method8421(var35.field3618, var23, var35.field3617, var35.field3619);
                                             client.field1852.method8419(var33.method5601(), var34);
                                          } else {
                                             client.field1852.method8421(var11.field3485, var23, var35.field3617, var35.field3619);
                                             client.field1852.method8419(var33.method5747(), var34);
                                          }

                                          class481.method8646(var2, var3, var4, var5);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   static final void method5169(class300 var0) {
      int var2 = var0.field3464;
      if (324 == var2) {
         if (-1 == client.field1682) {
            client.field1682 = var0.field3560;
            client.field1686 = var0.field3496;
         }

         if (client.field1920.field3639 == 1) {
            var0.field3560 = client.field1682;
         } else {
            var0.field3560 = client.field1686;
         }

      } else if (var2 == 325) {
         if (-1 == client.field1682) {
            client.field1682 = var0.field3560;
            client.field1686 = var0.field3496;
         }

         if (1 == client.field1920.field3639) {
            var0.field3560 = client.field1686;
         } else {
            var0.field3560 = client.field1682;
         }

      } else if (327 == var2) {
         var0.field3601 = 150;
         var0.field3513 = (int)(Math.sin((double)client.field1645 / 40.0D) * 256.0D) & 2047;
         var0.field3504 = 5;
         var0.field3505 = 0;
      } else if (var2 == 328) {
         var0.field3601 = 150;
         var0.field3513 = (int)(Math.sin((double)client.field1645 / 40.0D) * 256.0D) & 2047;
         var0.field3504 = 5;
         var0.field3505 = 1;
      }
   }
}
