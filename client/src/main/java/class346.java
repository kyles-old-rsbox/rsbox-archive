import java.util.HashSet;
import java.util.Set;

public class class346 implements class360 {
   static class376 field4250;
   static int field4251;
   static final class346 field4233;
   static final class346 field4234;
   static final class346 field4235;
   static final class346 field4236;
   static final class346 field4238;
   static final class346 field4239;
   static final class346 field4240;
   static final class346 field4241;
   static final class346 field4242;
   static final class346 field4244;
   static final class346 field4245;
   static final class346 field4247;
   static final class346 field4249;
   final int field4246;
   final Set field4237 = new HashSet();

   static {
      field4242 = new class346("", 0, new class362[]{class362.field4319});
      field4234 = new class346("", 1, new class362[]{class362.field4316, class362.field4319});
      field4235 = new class346("", 2, new class362[]{class362.field4316, class362.field4318, class362.field4319});
      field4236 = new class346("", 3, new class362[]{class362.field4316});
      field4233 = new class346("", 4);
      field4238 = new class346("", 5, new class362[]{class362.field4316, class362.field4319});
      field4239 = new class346("", 6, new class362[]{class362.field4319});
      field4240 = new class346("", 8, new class362[]{class362.field4316, class362.field4319});
      field4247 = new class346("", 9, new class362[]{class362.field4316, class362.field4318});
      field4249 = new class346("", 10, new class362[]{class362.field4316});
      field4244 = new class346("", 11, new class362[]{class362.field4316});
      field4241 = new class346("", 12, new class362[]{class362.field4316, class362.field4319});
      field4245 = new class346("", 13, new class362[]{class362.field4316});
      method6395();
   }

   static class346[] method6395() {
      return new class346[]{field4236, field4238, field4241, field4247, field4242, field4249, field4233, field4244, field4234, field4235, field4240, field4239, field4245};
   }

   public static class158 method6396(int var0) {
      class158 var2 = (class158)class158.field1456.method5439((long)var0);
      if (var2 != null) {
         return var2;
      } else {
         byte[] var3 = class158.field1452.method6167(33, var0);
         var2 = new class158();
         if (null != var3) {
            var2.method2623(new class460(var3));
         }

         class158.field1456.method5434(var2, (long)var0);
         return var2;
      }
   }

   class346(String var1, int var2) {
      this.field4246 = var2;
   }

   class346(String var1, int var2, class362[] var3) {
      this.field4246 = var2;
      class362[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class362 var6 = var4[var5];
         this.field4237.add(var6);
      }

   }

   public int method6656() {
      return this.field4246;
   }

   static int method6397(int var0, class78 var1, boolean var2) {
      int var4;
      if (6600 == var0) {
         var4 = class55.field396;
         int var17 = (class291.field3364.field827 >> 7) + class36.field241;
         int var13 = (class291.field3364.field802 >> 7) + class169.field1536;
         client.method6316().method7590(var4, var17, var13, true);
         return 1;
      } else {
         class254 var8;
         if (var0 == 6601) {
            var4 = class57.field404[--class387.field4452];
            String var16 = "";
            var8 = client.method6316().method7596(var4);
            if (var8 != null) {
               var16 = var8.method5055();
            }

            class57.field405[++class126.field1220 - 1] = var16;
            return 1;
         } else if (6602 == var0) {
            var4 = class57.field404[--class387.field4452];
            client.method6316().method7609(var4);
            return 1;
         } else if (var0 == 6603) {
            class57.field404[++class387.field4452 - 1] = client.method6316().method7593();
            return 1;
         } else if (var0 == 6604) {
            var4 = class57.field404[--class387.field4452];
            client.method6316().method7578(var4);
            return 1;
         } else if (6605 == var0) {
            class57.field404[++class387.field4452 - 1] = client.method6316().method7595() ? 1 : 0;
            return 1;
         } else {
            class295 var15;
            if (6606 == var0) {
               var15 = new class295(class57.field404[--class387.field4452]);
               client.method6316().method7597(var15.field3376, var15.field3375);
               return 1;
            } else if (var0 == 6607) {
               var15 = new class295(class57.field404[--class387.field4452]);
               client.method6316().method7598(var15.field3376, var15.field3375);
               return 1;
            } else if (var0 == 6608) {
               var15 = new class295(class57.field404[--class387.field4452]);
               client.method6316().method7599(var15.field3374, var15.field3376, var15.field3375);
               return 1;
            } else if (6609 == var0) {
               var15 = new class295(class57.field404[--class387.field4452]);
               client.method6316().method7600(var15.field3374, var15.field3376, var15.field3375);
               return 1;
            } else if (var0 == 6610) {
               class57.field404[++class387.field4452 - 1] = client.method6316().method7601();
               class57.field404[++class387.field4452 - 1] = client.method6316().method7602();
               return 1;
            } else {
               class254 var12;
               if (var0 == 6611) {
                  var4 = class57.field404[--class387.field4452];
                  var12 = client.method6316().method7596(var4);
                  if (var12 == null) {
                     class57.field404[++class387.field4452 - 1] = 0;
                  } else {
                     class57.field404[++class387.field4452 - 1] = var12.method5064().method5522();
                  }

                  return 1;
               } else if (6612 == var0) {
                  var4 = class57.field404[--class387.field4452];
                  var12 = client.method6316().method7596(var4);
                  if (null == var12) {
                     class57.field404[++class387.field4452 - 1] = 0;
                     class57.field404[++class387.field4452 - 1] = 0;
                  } else {
                     class57.field404[++class387.field4452 - 1] = (var12.method5059() - var12.method5124() + 1) * 64;
                     class57.field404[++class387.field4452 - 1] = (var12.method5061() - var12.method5079() + 1) * 64;
                  }

                  return 1;
               } else if (var0 == 6613) {
                  var4 = class57.field404[--class387.field4452];
                  var12 = client.method6316().method7596(var4);
                  if (null == var12) {
                     class57.field404[++class387.field4452 - 1] = 0;
                     class57.field404[++class387.field4452 - 1] = 0;
                     class57.field404[++class387.field4452 - 1] = 0;
                     class57.field404[++class387.field4452 - 1] = 0;
                  } else {
                     class57.field404[++class387.field4452 - 1] = var12.method5124() * 64;
                     class57.field404[++class387.field4452 - 1] = var12.method5079() * 64;
                     class57.field404[++class387.field4452 - 1] = var12.method5059() * 64 + 64 - 1;
                     class57.field404[++class387.field4452 - 1] = var12.method5061() * 64 + 64 - 1;
                  }

                  return 1;
               } else if (6614 == var0) {
                  var4 = class57.field404[--class387.field4452];
                  var12 = client.method6316().method7596(var4);
                  if (null == var12) {
                     class57.field404[++class387.field4452 - 1] = -1;
                  } else {
                     class57.field404[++class387.field4452 - 1] = var12.method5057();
                  }

                  return 1;
               } else if (6615 == var0) {
                  var15 = client.method6316().method7603();
                  if (var15 == null) {
                     class57.field404[++class387.field4452 - 1] = -1;
                     class57.field404[++class387.field4452 - 1] = -1;
                  } else {
                     class57.field404[++class387.field4452 - 1] = var15.field3376;
                     class57.field404[++class387.field4452 - 1] = var15.field3375;
                  }

                  return 1;
               } else if (var0 == 6616) {
                  class57.field404[++class387.field4452 - 1] = client.method6316().method7576();
                  return 1;
               } else if (6617 == var0) {
                  var15 = new class295(class57.field404[--class387.field4452]);
                  var12 = client.method6316().method7581();
                  if (var12 == null) {
                     class57.field404[++class387.field4452 - 1] = -1;
                     class57.field404[++class387.field4452 - 1] = -1;
                     return 1;
                  } else {
                     int[] var11 = var12.method5049(var15.field3374, var15.field3376, var15.field3375);
                     if (null == var11) {
                        class57.field404[++class387.field4452 - 1] = -1;
                        class57.field404[++class387.field4452 - 1] = -1;
                     } else {
                        class57.field404[++class387.field4452 - 1] = var11[0];
                        class57.field404[++class387.field4452 - 1] = var11[1];
                     }

                     return 1;
                  }
               } else {
                  class295 var6;
                  if (6618 == var0) {
                     var15 = new class295(class57.field404[--class387.field4452]);
                     var12 = client.method6316().method7581();
                     if (null == var12) {
                        class57.field404[++class387.field4452 - 1] = -1;
                        class57.field404[++class387.field4452 - 1] = -1;
                        return 1;
                     } else {
                        var6 = var12.method5100(var15.field3376, var15.field3375);
                        if (null == var6) {
                           class57.field404[++class387.field4452 - 1] = -1;
                        } else {
                           class57.field404[++class387.field4452 - 1] = var6.method5522();
                        }

                        return 1;
                     }
                  } else {
                     class295 var9;
                     if (var0 == 6619) {
                        class387.field4452 -= 2;
                        var4 = class57.field404[class387.field4452];
                        var9 = new class295(class57.field404[class387.field4452 + 1]);
                        class57.method6317(var4, var9, false);
                        return 1;
                     } else if (6620 == var0) {
                        class387.field4452 -= 2;
                        var4 = class57.field404[class387.field4452];
                        var9 = new class295(class57.field404[1 + class387.field4452]);
                        class57.method6317(var4, var9, true);
                        return 1;
                     } else if (6621 == var0) {
                        class387.field4452 -= 2;
                        var4 = class57.field404[class387.field4452];
                        var9 = new class295(class57.field404[1 + class387.field4452]);
                        var8 = client.method6316().method7596(var4);
                        if (var8 == null) {
                           class57.field404[++class387.field4452 - 1] = 0;
                           return 1;
                        } else {
                           class57.field404[++class387.field4452 - 1] = var8.method5083(var9.field3374, var9.field3376, var9.field3375) ? 1 : 0;
                           return 1;
                        }
                     } else if (var0 == 6622) {
                        class57.field404[++class387.field4452 - 1] = client.method6316().method7604();
                        class57.field404[++class387.field4452 - 1] = client.method6316().method7605();
                        return 1;
                     } else if (6623 == var0) {
                        var15 = new class295(class57.field404[--class387.field4452]);
                        var12 = client.method6316().method7707(var15.field3374, var15.field3376, var15.field3375);
                        if (null == var12) {
                           class57.field404[++class387.field4452 - 1] = -1;
                        } else {
                           class57.field404[++class387.field4452 - 1] = var12.method5063();
                        }

                        return 1;
                     } else if (6624 == var0) {
                        client.method6316().method7606(class57.field404[--class387.field4452]);
                        return 1;
                     } else if (var0 == 6625) {
                        client.method6316().method7591();
                        return 1;
                     } else if (6626 == var0) {
                        client.method6316().method7608(class57.field404[--class387.field4452]);
                        return 1;
                     } else if (var0 == 6627) {
                        client.method6316().method7638();
                        return 1;
                     } else {
                        boolean var14;
                        if (6628 == var0) {
                           var14 = class57.field404[--class387.field4452] == 1;
                           client.method6316().method7700(var14);
                           return 1;
                        } else if (6629 == var0) {
                           var4 = class57.field404[--class387.field4452];
                           client.method6316().method7758(var4);
                           return 1;
                        } else if (6630 == var0) {
                           var4 = class57.field404[--class387.field4452];
                           client.method6316().method7724(var4);
                           return 1;
                        } else if (6631 == var0) {
                           client.method6316().method7613();
                           return 1;
                        } else if (var0 == 6632) {
                           var14 = class57.field404[--class387.field4452] == 1;
                           client.method6316().method7614(var14);
                           return 1;
                        } else {
                           boolean var10;
                           if (6633 == var0) {
                              class387.field4452 -= 2;
                              var4 = class57.field404[class387.field4452];
                              var10 = class57.field404[1 + class387.field4452] == 1;
                              client.method6316().method7615(var4, var10);
                              return 1;
                           } else if (var0 == 6634) {
                              class387.field4452 -= 2;
                              var4 = class57.field404[class387.field4452];
                              var10 = 1 == class57.field404[1 + class387.field4452];
                              client.method6316().method7616(var4, var10);
                              return 1;
                           } else if (6635 == var0) {
                              class57.field404[++class387.field4452 - 1] = client.method6316().method7617() ? 1 : 0;
                              return 1;
                           } else if (6636 == var0) {
                              var4 = class57.field404[--class387.field4452];
                              class57.field404[++class387.field4452 - 1] = client.method6316().method7618(var4) ? 1 : 0;
                              return 1;
                           } else if (6637 == var0) {
                              var4 = class57.field404[--class387.field4452];
                              class57.field404[++class387.field4452 - 1] = client.method6316().method7619(var4) ? 1 : 0;
                              return 1;
                           } else if (6638 == var0) {
                              class387.field4452 -= 2;
                              var4 = class57.field404[class387.field4452];
                              var9 = new class295(class57.field404[1 + class387.field4452]);
                              var6 = client.method6316().method7622(var4, var9);
                              if (var6 == null) {
                                 class57.field404[++class387.field4452 - 1] = -1;
                              } else {
                                 class57.field404[++class387.field4452 - 1] = var6.method5522();
                              }

                              return 1;
                           } else {
                              class251 var7;
                              if (var0 == 6639) {
                                 var7 = client.method6316().method7624();
                                 if (var7 == null) {
                                    class57.field404[++class387.field4452 - 1] = -1;
                                    class57.field404[++class387.field4452 - 1] = -1;
                                 } else {
                                    class57.field404[++class387.field4452 - 1] = var7.method5024();
                                    class57.field404[++class387.field4452 - 1] = var7.field2915.method5522();
                                 }

                                 return 1;
                              } else if (var0 == 6640) {
                                 var7 = client.method6316().method7711();
                                 if (var7 == null) {
                                    class57.field404[++class387.field4452 - 1] = -1;
                                    class57.field404[++class387.field4452 - 1] = -1;
                                 } else {
                                    class57.field404[++class387.field4452 - 1] = var7.method5024();
                                    class57.field404[++class387.field4452 - 1] = var7.field2915.method5522();
                                 }

                                 return 1;
                              } else {
                                 class160 var5;
                                 if (var0 == 6693) {
                                    var4 = class57.field404[--class387.field4452];
                                    var5 = class90.method1885(var4);
                                    if (null == var5.field1470) {
                                       class57.field405[++class126.field1220 - 1] = "";
                                    } else {
                                       class57.field405[++class126.field1220 - 1] = var5.field1470;
                                    }

                                    return 1;
                                 } else if (var0 == 6694) {
                                    var4 = class57.field404[--class387.field4452];
                                    var5 = class90.method1885(var4);
                                    class57.field404[++class387.field4452 - 1] = var5.field1472;
                                    return 1;
                                 } else if (var0 == 6695) {
                                    var4 = class57.field404[--class387.field4452];
                                    var5 = class90.method1885(var4);
                                    if (var5 == null) {
                                       class57.field404[++class387.field4452 - 1] = -1;
                                    } else {
                                       class57.field404[++class387.field4452 - 1] = var5.field1487;
                                    }

                                    return 1;
                                 } else if (var0 == 6696) {
                                    var4 = class57.field404[--class387.field4452];
                                    var5 = class90.method1885(var4);
                                    if (var5 == null) {
                                       class57.field404[++class387.field4452 - 1] = -1;
                                    } else {
                                       class57.field404[++class387.field4452 - 1] = var5.field1468;
                                    }

                                    return 1;
                                 } else if (var0 == 6697) {
                                    class57.field404[++class387.field4452 - 1] = class64.field504.field2860;
                                    return 1;
                                 } else if (var0 == 6698) {
                                    class57.field404[++class387.field4452 - 1] = class64.field504.field2861.method5522();
                                    return 1;
                                 } else if (var0 == 6699) {
                                    class57.field404[++class387.field4452 - 1] = class64.field504.field2862.method5522();
                                    return 1;
                                 } else {
                                    return 2;
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

   static void method6392(class188 var0) {
      if (null != var0 && var0.field1984 != null) {
         if (var0.field1984.field3484 >= 0) {
            class300 var2 = class282.method5426(var0.field1984.field3596);
            if (var2 == null || null == var2.field3602 || 0 == var2.field3602.length || var0.field1984.field3484 >= var2.field3602.length || var2.field3602[var0.field1984.field3484] != var0.field1984) {
               return;
            }
         }

         if (11 == var0.field1984.field3462 && 0 == var0.field1983) {
            switch(var0.field1984.method5862()) {
            case 0:
               class115.method2229(var0.field1984.method5864(), true, false);
               break;
            case 1:
               if (class242.method4733(class190.method3528(var0.field1984))) {
                  int[] var5 = var0.field1984.method5925();
                  if (var5 != null) {
                     class263 var3 = class185.method3435(class274.field3146, client.field1778.field1071);
                     var3.field2984.method8148(var5[2]);
                     var3.field2984.method8234(var0.field1984.field3517);
                     var3.field2984.method8148(var0.field1984.method5863());
                     var3.field2984.method8174(var0.field1984.field3484);
                     var3.field2984.method8164(var5[1]);
                     var3.field2984.method8164(var5[0]);
                     client.field1778.method2078(var3);
                  }
               }
            }
         } else if (12 == var0.field1984.field3462) {
            class297 var4 = var0.field1984.method5869();
            if (null != var4 && var4.method5604()) {
               switch(var0.field1983) {
               case 0:
                  client.field1877.method3515(var0.field1984);
                  var4.method5552(true);
                  var4.method5591(var0.field1987, var0.field1980, client.field1876.method3895(82), client.field1876.method3895(81));
                  break;
               case 1:
                  var4.method5592(var0.field1987, var0.field1980);
               }
            }
         }

      }
   }
}
