import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class class442 {
   public static final class442 field4769 = new class442("p12_full");
   public static final class442 field4770 = new class442("verdana_13pt_regular");
   public static final class442 field4771 = new class442("verdana_11pt_regular");
   public static final class442 field4773 = new class442("verdana_15pt_regular");
   public static final class442 field4779 = new class442("p11_full");
   public static final class442 field4780 = new class442("b12_full");
   static class147 field4776;
   String field4774;

   public static class442[] method7911() {
      return new class442[]{field4779, field4770, field4773, field4780, field4769, field4771};
   }

   class442(String var1) {
      this.field4774 = var1;
   }

   static void method7916(class31 var0, class376 var1) {
      int var5;
      int var26;
      int var27;
      int var28;
      if (class75.field643) {
         class205 var23 = client.field1876;
         class205 var24 = var23;

         while(true) {
            if (!var24.method3911()) {
               if (class42.field277 != 1 && (class95.field944 || class42.field277 != 4)) {
                  break;
               }

               var5 = 280 + class75.field618;
               if (class42.field283 >= var5 && class42.field283 <= 14 + var5 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(0, 0);
                  break;
               }

               if (class42.field283 >= var5 + 15 && class42.field283 <= var5 + 80 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(0, 1);
                  break;
               }

               var26 = class75.field618 + 390;
               if (class42.field283 >= var26 && class42.field283 <= 14 + var26 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(1, 0);
                  break;
               }

               if (class42.field283 >= 15 + var26 && class42.field283 <= 80 + var26 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(1, 1);
                  break;
               }

               var27 = class75.field618 + 500;
               if (class42.field283 >= var27 && class42.field283 <= var27 + 14 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(2, 0);
                  break;
               }

               if (class42.field283 >= 15 + var27 && class42.field283 <= 80 + var27 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(2, 1);
                  break;
               }

               var28 = class75.field618 + 610;
               if (class42.field283 >= var28 && class42.field283 <= 14 + var28 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(3, 0);
                  break;
               }

               if (class42.field283 >= 15 + var28 && class42.field283 <= 80 + var28 && class42.field293 >= 4 && class42.field293 <= 18) {
                  class264.method5168(3, 1);
                  break;
               }

               if (class42.field283 >= class75.field618 + 708 && class42.field293 >= 4 && class42.field283 <= 50 + class75.field618 + 708 && class42.field293 <= 20) {
                  class75.method199();
                  break;
               }

               if (class75.field626 != -1) {
                  class72 var30 = class399.field4502[class75.field626];
                  client.method3066(var30);
                  class75.method199();
               } else {
                  if (class75.field645 > 0 && null != class227.field2723 && class42.field283 >= 0 && class42.field283 <= class227.field2723.field5017 && class42.field293 >= class12.field57 / 2 - 50 && class42.field293 <= class12.field57 / 2 + 50) {
                     --class75.field645;
                  }

                  if (class75.field645 < class75.field616 && class7.field24 != null && class42.field283 >= class31.field193 - class7.field24.field5017 - 5 && class42.field283 <= class31.field193 && class42.field293 >= class12.field57 / 2 - 50 && class42.field293 <= class12.field57 / 2 + 50) {
                     ++class75.field645;
                  }
               }
               break;
            }

            if (var24.field2317 == 13) {
               class75.method199();
               break;
            }

            if (var24.field2317 == 96) {
               if (class75.field645 > 0 && class227.field2723 != null) {
                  --class75.field645;
               }
            } else if (97 == var24.field2317 && class75.field645 < class75.field616 && class7.field24 != null) {
               ++class75.field645;
            }
         }

      } else {
         if ((class42.field277 == 1 || !class95.field944 && 4 == class42.field277) && class42.field283 >= 765 + class75.field618 - 50 && class42.field293 >= 453) {
            class413.field4575.method1707(!class413.field4575.method1708());
            if (!class413.field4575.method1708()) {
               class336 var3 = class43.field311;
               int var4 = var3.method6116("scape main");
               var5 = var3.method6162(var4, "");
               class279.method332(var3, var4, var5, 255, false);
            } else {
               class279.midiPcmStream.method5365();
               class279.field3202 = 1;
               class7.field29 = null;
            }
         }

         if (5 != client.field1766) {
            if (-1L == class75.field647) {
               class75.field647 = class272.method2046() + 1000L;
            }

            long var22 = class272.method2046();
            boolean var25;
            if (client.field1930 != null && client.field1910 < client.field1930.size()) {
               while(true) {
                  if (client.field1910 >= client.field1930.size()) {
                     var25 = true;
                     break;
                  }

                  class97 var6 = (class97)client.field1930.get(client.field1910);
                  if (!var6.method1962()) {
                     var25 = false;
                     break;
                  }

                  ++client.field1910;
               }
            } else {
               var25 = true;
            }

            if (var25 && -1L == class75.field639) {
               class75.field639 = var22;
               if (class75.field639 > class75.field647) {
                  class75.field647 = class75.field639;
               }
            }

            if (10 == client.field1766 || client.field1766 == 11) {
               if (class353.field4303 == class94.field940) {
                  if (1 == class42.field277 || !class95.field944 && class42.field277 == 4) {
                     var26 = 5 + class75.field618;
                     short var7 = 463;
                     byte var8 = 100;
                     byte var9 = 35;
                     if (class42.field283 >= var26 && class42.field283 <= var26 + var8 && class42.field293 >= var7 && class42.field293 <= var9 + var7) {
                        if (class328.method6239()) {
                           class75.field643 = true;
                           class75.field645 = 0;
                           class75.field616 = 0;
                        }

                        return;
                     }
                  }

                  if (null != class96.field962 && class328.method6239()) {
                     class75.field643 = true;
                     class75.field645 = 0;
                     class75.field616 = 0;
                  }
               }

               var26 = class42.field277;
               var27 = class42.field283;
               var28 = class42.field293;
               if (0 == var26) {
                  var27 = class42.field284;
                  var28 = class42.field285;
               }

               if (!class95.field944 && 4 == var26) {
                  var26 = 1;
               }

               class205 var29 = client.field1876;
               class205 var10 = var29;
               int var32;
               short var33;
               if (class75.field619 == 0) {
                  boolean var44 = false;

                  while(var10.method3911()) {
                     if (var10.field2317 == 84) {
                        var44 = true;
                     }
                  }

                  var32 = class11.field47 - 80;
                  var33 = 291;
                  if (var26 == 1 && var27 >= var32 - 75 && var27 <= 75 + var32 && var28 >= var33 - 20 && var28 <= var33 + 20) {
                     class115.method2229(class140.method2473("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var32 = class11.field47 + 80;
                  if (var26 == 1 && var27 >= var32 - 75 && var27 <= var32 + 75 && var28 >= var33 - 20 && var28 <= var33 + 20 || var44) {
                     if (0 != (client.field1633 & 33554432)) {
                        class75.field648 = "";
                        class75.field624 = class338.field4128;
                        class75.field630 = class338.field4129;
                        class75.field631 = class338.field4130;
                        class74.method1490(1);
                        class279.method5396();
                     } else if ((client.field1633 & 4) != 0) {
                        if (0 != (client.field1633 & 1024)) {
                           class75.field624 = class338.field4125;
                           class75.field630 = class338.field4203;
                           class75.field631 = class338.field4033;
                        } else {
                           class75.field624 = class338.field4039;
                           class75.field630 = class338.field4120;
                           class75.field631 = class338.field4121;
                        }

                        class75.field648 = class338.field4118;
                        class74.method1490(1);
                        class279.method5396();
                     } else if (0 != (client.field1633 & 1024)) {
                        class75.field624 = class338.field4107;
                        class75.field630 = class338.field3922;
                        class75.field631 = class338.field4124;
                        class75.field648 = class338.field4118;
                        class74.method1490(1);
                        class279.method5396();
                     } else {
                        class367.method6723(false);
                     }
                  }
               } else {
                  int var11;
                  short var12;
                  if (class75.field619 == 1) {
                     while(true) {
                        if (!var10.method3911()) {
                           var11 = class11.field47 - 80;
                           var12 = 321;
                           if (1 == var26 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                              class367.method6723(false);
                           }

                           var11 = class11.field47 + 80;
                           if (1 == var26 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                              class74.method1490(0);
                           }
                           break;
                        }

                        if (84 == var10.field2317) {
                           class367.method6723(false);
                        } else if (var10.field2317 == 13) {
                           class74.method1490(0);
                        }
                     }
                  } else {
                     short var31;
                     if (2 == class75.field619) {
                        var31 = 201;
                        var11 = var31 + 52;
                        if (1 == var26 && var28 >= var11 - 12 && var28 < 2 + var11) {
                           class75.field640 = 0;
                        }

                        var11 += 15;
                        if (var26 == 1 && var28 >= var11 - 12 && var28 < var11 + 2) {
                           class75.field640 = 1;
                        }

                        var11 += 15;
                        var31 = 361;
                        if (null != class444.field4785) {
                           var32 = class444.field4785.field4531 / 2;
                           if (1 == var26 && var27 >= class444.field4785.field4529 - var32 && var27 <= var32 + class444.field4785.field4529 && var28 >= var31 - 15 && var28 < var31) {
                              switch(class75.field646) {
                              case 1:
                                 class75.method5452(class338.field4167, class338.field4010, class338.field4169);
                                 class74.method1490(5);
                                 return;
                              case 2:
                                 class115.method2229("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var32 = class11.field47 - 80;
                        var33 = 321;
                        if (1 == var26 && var27 >= var32 - 75 && var27 <= var32 + 75 && var28 >= var33 - 20 && var28 <= 20 + var33) {
                           class75.field633 = class75.field633.trim();
                           if (class75.field633.length() == 0) {
                              class75.method5452(class338.field3973, class338.field3965, class338.field3981);
                              return;
                           }

                           if (class75.field650.length() == 0) {
                              class75.method5452(class338.field4014, class338.field4015, class338.field3988);
                              return;
                           }

                           class75.method5452(class338.field4074, class338.field4134, class338.field4135);
                           SoundCache.method996(false);
                           class9.method64(20);
                           return;
                        }

                        var32 = 180 + class75.field627 + 80;
                        if (1 == var26 && var27 >= var32 - 75 && var27 <= 75 + var32 && var28 >= var33 - 20 && var28 <= 20 + var33) {
                           class74.method1490(0);
                           class75.field633 = "";
                           class75.field650 = "";
                           class340.field4220 = 0;
                           class349.field4269 = "";
                           class75.field621 = true;
                        }

                        var32 = class11.field47 + -117;
                        var33 = 277;
                        class75.field637 = var27 >= var32 && var27 < class346.field4251 + var32 && var28 >= var33 && var28 < class75.field636 + var33;
                        if (var26 == 1 && class75.field637) {
                           client.field1891 = !client.field1891;
                           if (!client.field1891 && class413.field4575.method1722() != null) {
                              class413.field4575.method1710((String)null);
                           }
                        }

                        var32 = 24 + class11.field47;
                        var33 = 277;
                        class75.field638 = var27 >= var32 && var27 < class346.field4251 + var32 && var28 >= var33 && var28 < class75.field636 + var33;
                        if (1 == var26 && class75.field638) {
                           class413.field4575.method1755(!class413.field4575.method1706());
                           if (!class413.field4575.method1706()) {
                              class75.field633 = "";
                              class413.field4575.method1710((String)null);
                              class279.method5396();
                           }
                        }

                        while(true) {
                           Transferable var40;
                           int var41;
                           do {
                              while(true) {
                                 label1372:
                                 do {
                                    while(true) {
                                       while(var10.method3911()) {
                                          if (13 != var10.field2317) {
                                             if (0 != class75.field640) {
                                                continue label1372;
                                             }

                                             class178.method2827(var10.field2321);
                                             if (var10.field2317 == 85 && class75.field633.length() > 0) {
                                                class75.field633 = class75.field633.substring(0, class75.field633.length() - 1);
                                             }

                                             if (84 == var10.field2317 || var10.field2317 == 80) {
                                                class75.field640 = 1;
                                             }

                                             if (class205.method3926(var10.field2321) && class75.field633.length() < 320) {
                                                class75.field633 = class75.field633 + var10.field2321;
                                             }
                                          } else {
                                             class74.method1490(0);
                                             class75.field633 = "";
                                             class75.field650 = "";
                                             class340.field4220 = 0;
                                             class349.field4269 = "";
                                             class75.field621 = true;
                                          }
                                       }

                                       return;
                                    }
                                 } while(1 != class75.field640);

                                 if (var10.field2317 == 85 && class75.field650.length() > 0) {
                                    class75.field650 = class75.field650.substring(0, class75.field650.length() - 1);
                                 } else if (84 == var10.field2317 || 80 == var10.field2317) {
                                    class75.field640 = 0;
                                    if (var10.field2317 == 84) {
                                       class75.field633 = class75.field633.trim();
                                       if (class75.field633.length() == 0) {
                                          class75.method5452(class338.field3973, class338.field3965, class338.field3981);
                                          return;
                                       }

                                       if (class75.field650.length() == 0) {
                                          class75.method5452(class338.field4014, class338.field4015, class338.field3988);
                                          return;
                                       }

                                       class75.method5452(class338.field4074, class338.field4134, class338.field4135);
                                       SoundCache.method996(false);
                                       class9.method64(20);
                                       return;
                                    }
                                 }

                                 if ((var10.method3895(82) || var10.method3895(87)) && 67 == var10.field2317) {
                                    Clipboard var39 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    var40 = var39.getContents(class133.field1257);
                                    var41 = 20 - class75.field650.length();
                                    break;
                                 }

                                 if (class279.method5389(var10.field2321) && class205.method3926(var10.field2321) && class75.field650.length() < 20) {
                                    class75.field650 = class75.field650 + var10.field2321;
                                 }
                              }
                           } while(var41 <= 0);

                           try {
                              String var43 = (String)var40.getTransferData(DataFlavor.stringFlavor);
                              int var18 = Math.min(var41, var43.length());

                              for(int var19 = 0; var19 < var18; ++var19) {
                                 if (!class279.method5389(var43.charAt(var19)) || !class205.method3926(var43.charAt(var19))) {
                                    class74.method1490(3);
                                    return;
                                 }
                              }

                              class75.field650 = class75.field650 + var43.substring(0, var18);
                           } catch (UnsupportedFlavorException var20) {
                           } catch (IOException var21) {
                           }
                        }
                     } else if (3 == class75.field619) {
                        var11 = 180 + class75.field627;
                        var12 = 276;
                        if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                           class337.method6306(false);
                        }

                        var11 = class75.field627 + 180;
                        var12 = 326;
                        if (1 == var26 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                           class75.method5452(class338.field4167, class338.field4010, class338.field4169);
                           class74.method1490(5);
                           return;
                        }
                     } else {
                        int var14;
                        if (class75.field619 == 4) {
                           var11 = 180 + class75.field627 - 80;
                           var12 = 321;
                           if (var26 == 1 && var27 >= var11 - 75 && var27 <= 75 + var11 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                              class349.field4269.trim();
                              if (class349.field4269.length() != 6) {
                                 class75.method5452(class338.field3987, class338.field3931, class338.field3939);
                                 return;
                              }

                              class340.field4220 = Integer.parseInt(class349.field4269);
                              class349.field4269 = "";
                              SoundCache.method996(true);
                              class75.method5452(class338.field4074, class338.field4134, class338.field4135);
                              class9.method64(20);
                              return;
                           }

                           if (var26 == 1 && var27 >= 180 + class75.field627 - 9 && var27 <= 130 + 180 + class75.field627 && var28 >= 263 && var28 <= 296) {
                              class75.field621 = !class75.field621;
                           }

                           if (1 == var26 && var27 >= class75.field627 + 180 - 34 && var27 <= 34 + 180 + class75.field627 && var28 >= 351 && var28 <= 363) {
                              class115.method2229(class140.method2473("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var11 = 80 + class75.field627 + 180;
                           if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                              class74.method1490(0);
                              class75.field633 = "";
                              class75.field650 = "";
                              class340.field4220 = 0;
                              class349.field4269 = "";
                           }

                           while(var10.method3911()) {
                              boolean var13 = false;

                              for(var14 = 0; var14 < class75.field642.length(); ++var14) {
                                 if (var10.field2321 == class75.field642.charAt(var14)) {
                                    var13 = true;
                                    break;
                                 }
                              }

                              if (13 == var10.field2317) {
                                 class74.method1490(0);
                                 class75.field633 = "";
                                 class75.field650 = "";
                                 class340.field4220 = 0;
                                 class349.field4269 = "";
                              } else {
                                 if (85 == var10.field2317 && class349.field4269.length() > 0) {
                                    class349.field4269 = class349.field4269.substring(0, class349.field4269.length() - 1);
                                 }

                                 if (var10.field2317 == 84) {
                                    class349.field4269.trim();
                                    if (class349.field4269.length() != 6) {
                                       class75.method5452(class338.field3987, class338.field3931, class338.field3939);
                                       return;
                                    }

                                    class340.field4220 = Integer.parseInt(class349.field4269);
                                    class349.field4269 = "";
                                    SoundCache.method996(true);
                                    class75.method5452(class338.field4074, class338.field4134, class338.field4135);
                                    class9.method64(20);
                                    return;
                                 }

                                 if (var13 && class349.field4269.length() < 6) {
                                    class349.field4269 = class349.field4269 + var10.field2321;
                                 }
                              }
                           }
                        } else {
                           int var15;
                           if (class75.field619 == 5) {
                              var11 = 180 + class75.field627 - 80;
                              var12 = 321;
                              if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                 class352.method6537();
                                 return;
                              }

                              var11 = 180 + class75.field627 + 80;
                              if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                                 class367.method6723(true);
                              }

                              var33 = 361;
                              if (null != class256.field2949) {
                                 var14 = class256.field2949.field4531 / 2;
                                 if (var26 == 1 && var27 >= class256.field2949.field4529 - var14 && var27 <= class256.field2949.field4529 + var14 && var28 >= var33 - 15 && var28 < var33) {
                                    class115.method2229(class140.method2473("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                                 }
                              }

                              while(var10.method3911()) {
                                 boolean var35 = false;

                                 for(var15 = 0; var15 < class75.field641.length(); ++var15) {
                                    if (var10.field2321 == class75.field641.charAt(var15)) {
                                       var35 = true;
                                       break;
                                    }
                                 }

                                 if (var10.field2317 == 13) {
                                    class367.method6723(true);
                                 } else {
                                    if (85 == var10.field2317 && class75.field633.length() > 0) {
                                       class75.field633 = class75.field633.substring(0, class75.field633.length() - 1);
                                    }

                                    if (var10.field2317 == 84) {
                                       class352.method6537();
                                       return;
                                    }

                                    if (var35 && class75.field633.length() < 320) {
                                       class75.field633 = class75.field633 + var10.field2321;
                                    }
                                 }
                              }
                           } else if (class75.field619 != 6) {
                              if (7 == class75.field619) {
                                 if (class87.field781 && !client.field1640) {
                                    var11 = class11.field47 - 150;
                                    var32 = 40 + 25 + var11 + 240;
                                    var33 = 231;
                                    var14 = 40 + var33;
                                    if (var26 == 1 && var27 >= var11 && var27 <= var32 && var28 >= var33 && var28 <= var14) {
                                       class75.field634 = class85.method1803(var11, var27);
                                    }

                                    var15 = class75.field627 + 180 - 80;
                                    short var16 = 321;
                                    boolean var17;
                                    if (var26 == 1 && var27 >= var15 - 75 && var27 <= 75 + var15 && var28 >= var16 - 20 && var28 <= var16 + 20) {
                                       var17 = class185.method3433();
                                       if (var17) {
                                          class9.method64(50);
                                          return;
                                       }
                                    }

                                    var15 = 80 + class75.field627 + 180;
                                    if (1 == var26 && var27 >= var15 - 75 && var27 <= var15 + 75 && var28 >= var16 - 20 && var28 <= var16 + 20) {
                                       class75.field635 = new String[8];
                                       class367.method6723(true);
                                    }

                                    while(var10.method3911()) {
                                       if (101 == var10.field2317) {
                                          class75.field635[class75.field634] = null;
                                       }

                                       if (85 == var10.field2317) {
                                          if (null == class75.field635[class75.field634] && class75.field634 > 0) {
                                             --class75.field634;
                                          }

                                          class75.field635[class75.field634] = null;
                                       }

                                       if (var10.field2321 >= '0' && var10.field2321 <= '9') {
                                          class75.field635[class75.field634] = "" + var10.field2321;
                                          if (class75.field634 < 7) {
                                             ++class75.field634;
                                          }
                                       }

                                       if (84 == var10.field2317) {
                                          var17 = class185.method3433();
                                          if (var17) {
                                             class9.method64(50);
                                          }

                                          return;
                                       }
                                    }
                                 } else {
                                    var11 = 180 + class75.field627 - 80;
                                    var12 = 321;
                                    if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                                       class115.method2229(class140.method2473("secure", true) + "m=dob/set_dob.ws", true, false);
                                       class75.method5452(class338.field4153, class338.field4165, class338.field4166);
                                       class74.method1490(6);
                                       return;
                                    }

                                    var11 = class75.field627 + 180 + 80;
                                    if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                       class367.method6723(true);
                                    }
                                 }
                              } else if (class75.field619 == 8) {
                                 var11 = 180 + class75.field627 - 80;
                                 var12 = 321;
                                 if (1 == var26 && var27 >= var11 - 75 && var27 <= 75 + var11 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                    class115.method2229("https://www.jagex.com/terms/privacy", true, false);
                                    class75.method5452(class338.field4153, class338.field4165, class338.field4166);
                                    class74.method1490(6);
                                    return;
                                 }

                                 var11 = 80 + class75.field627 + 180;
                                 if (var26 == 1 && var27 >= var11 - 75 && var27 <= 75 + var11 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                    class367.method6723(true);
                                 }
                              } else if (class75.field619 == 9) {
                                 var11 = 180 + class75.field627;
                                 var12 = 311;
                                 if (var29.field2317 == 84 || var29.field2317 == 13 || var26 == 1 && var27 >= var11 - 75 && var27 <= 75 + var11 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                                    class337.method6306(false);
                                 }
                              } else if (class75.field619 == 10) {
                                 var11 = class75.field627 + 180;
                                 var12 = 209;
                                 if (84 == var29.field2317 || 1 == var26 && var27 >= var11 - 109 && var27 <= var11 + 109 && var28 >= var12 && var28 <= 68 + var12) {
                                    class75.method5452(class338.field4074, class338.field4134, class338.field4135);
                                    client.field1758 = class445.field4787;
                                    SoundCache.method996(false);
                                    class9.method64(20);
                                 }
                              } else if (class75.field619 == 12) {
                                 var11 = class11.field47;
                                 var12 = 233;
                                 class407 var34 = var1.method6858(0, 30, class338.field4196, var11, var12);
                                 class407 var36 = var1.method6858(32, 32, class338.field4196, var11, var12);
                                 class407 var37 = var1.method6858(70, 34, class338.field4196, var11, var12);
                                 var32 = var12 + 17;
                                 class407 var38 = var1.method6858(0, 34, class338.field4197, var11, var32);
                                 if (var26 == 1) {
                                    if (var34.method7368(var27, var28)) {
                                       class115.method2229("https://www.jagex.com/terms", true, false);
                                    } else if (var36.method7368(var27, var28)) {
                                       class115.method2229("https://www.jagex.com/terms/privacy", true, false);
                                    } else if (var37.method7368(var27, var28) || var38.method7368(var27, var28)) {
                                       class115.method2229("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
                                    }
                                 }

                                 var11 = class11.field47 - 80;
                                 var12 = 311;
                                 if (1 == var26 && var27 >= var11 - 75 && var27 <= 75 + var11 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                    client.method3393();
                                    class337.method6306(true);
                                 }

                                 var11 = class11.field47 + 80;
                                 if (1 == var26 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                                    class75.field619 = 13;
                                 }
                              } else if (13 == class75.field619) {
                                 var11 = class11.field47;
                                 var12 = 321;
                                 if (1 == var26 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                    class337.method6306(true);
                                 }
                              } else if (14 == class75.field619) {
                                 String var42 = "";
                                 switch(class75.field628) {
                                 case 0:
                                    var42 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                                    break;
                                 case 1:
                                    var42 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                                    break;
                                 case 2:
                                    var42 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
                                    break;
                                 default:
                                    class367.method6723(false);
                                 }

                                 var32 = 180 + class75.field627;
                                 var33 = 276;
                                 if (var26 == 1 && var27 >= var32 - 75 && var27 <= 75 + var32 && var28 >= var33 - 20 && var28 <= var33 + 20) {
                                    class115.method2229(var42, true, false);
                                    class75.method5452(class338.field4153, class338.field4165, class338.field4166);
                                    class74.method1490(6);
                                    return;
                                 }

                                 var32 = 180 + class75.field627;
                                 var33 = 326;
                                 if (1 == var26 && var27 >= var32 - 75 && var27 <= var32 + 75 && var28 >= var33 - 20 && var28 <= var33 + 20) {
                                    class367.method6723(false);
                                 }
                              } else if (24 == class75.field619) {
                                 var11 = class75.field627 + 180;
                                 var12 = 301;
                                 if (1 == var26 && var27 >= var11 - 75 && var27 <= 75 + var11 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                    class337.method6306(false);
                                 }
                              } else if (class75.field619 == 26) {
                                 var11 = 180 + class75.field627 - 80;
                                 var12 = 321;
                                 if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= var12 + 20) {
                                    class115.method2229(class140.method2473("secure", true) + "m=dob/set_dob.ws", true, false);
                                    class75.method5452(class338.field4153, class338.field4165, class338.field4166);
                                    class74.method1490(6);
                                    return;
                                 }

                                 var11 = 180 + class75.field627 + 80;
                                 if (var26 == 1 && var27 >= var11 - 75 && var27 <= var11 + 75 && var28 >= var12 - 20 && var28 <= 20 + var12) {
                                    class367.method6723(true);
                                 }
                              }
                           } else {
                              while(true) {
                                 do {
                                    if (!var10.method3911()) {
                                       var31 = 321;
                                       if (var26 == 1 && var28 >= var31 - 20 && var28 <= var31 + 20) {
                                          class367.method6723(true);
                                       }

                                       return;
                                    }
                                 } while(84 != var10.field2317 && var10.field2317 != 13);

                                 class367.method6723(true);
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

   static void method7914(class93 var0, int var1, int var2) {
      if (var1 == var0.field852 && -1 != var1) {
         int var4 = class160.method2660(var1).field2013;
         if (1 == var4) {
            var0.field844 = 0;
            var0.field845 = 0;
            var0.field804 = var2;
            var0.field875 = 0;
         }

         if (2 == var4) {
            var0.field875 = 0;
         }
      } else if (-1 == var1 || var0.field852 == -1 || class160.method2660(var1).field2006 >= class160.method2660(var0.field852).field2006) {
         var0.field852 = var1;
         var0.field844 = 0;
         var0.field845 = 0;
         var0.field804 = var2;
         var0.field875 = 0;
         var0.field876 = var0.field871;
      }

   }

   static final void method7913() {
      SoundCache.method1000();
      if (class73.field603 != null) {
         class73.field603.method6701();
      }

   }
}
