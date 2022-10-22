import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class class88 implements class360 {
   static class28 field794;
   static final class88 field785 = new class88(1, 1);
   static final class88 field786 = new class88(0, -1);
   static final class88 field787 = new class88(3, 8);
   static final class88 field788 = new class88(4, 9);
   static final class88 field793 = new class88(2, 7);
   final int field789;
   final int field792;

   static class88[] method1283() {
      return new class88[]{field786, field793, field785, field788, field787};
   }

   static void method1863(int var0, byte[] var1, class392 var2) {
      class334 var4 = new class334();
      var4.field3860 = 0;
      var4.field4681 = (long)var0;
      var4.field3861 = var1;
      var4.field3862 = var2;
      synchronized(class322.field3759) {
         class322.field3759.method6347(var4);
      }

      synchronized(class322.field3762) {
         if (class322.field3761 == 0) {
            class322.field3763 = new Thread(new class322());
            class322.field3763.setDaemon(true);
            class322.field3763.start();
            class322.field3763.setPriority(5);
         }

         class322.field3761 = 600;
      }
   }

   class88(int var1, int var2) {
      this.field789 = var1;
      this.field792 = var2;
   }

   public int method6656() {
      return this.field792;
   }

   public static void method1865(class453 var0) {
      class43 var2 = (class43)class45.field329.method6457();
      if (var2 != null) {
         int var3 = var0.field4878;
         var0.method8234(var2.field307);

         for(int var4 = 0; var4 < var2.field309; ++var4) {
            if (var2.field300[var4] != 0) {
               var0.method8097(var2.field300[var4]);
            } else {
               try {
                  int var5 = var2.field301[var4];
                  Field var6;
                  int var7;
                  if (var5 == 0) {
                     var6 = var2.field303[var4];
                     var7 = var6.getInt((Object)null);
                     var0.method8097(0);
                     var0.method8234(var7);
                  } else if (1 == var5) {
                     var6 = var2.field303[var4];
                     var6.setInt((Object)null, var2.field304[var4]);
                     var0.method8097(0);
                  } else if (2 == var5) {
                     var6 = var2.field303[var4];
                     var7 = var6.getModifiers();
                     var0.method8097(0);
                     var0.method8234(var7);
                  }

                  Method var23;
                  if (var5 != 3) {
                     if (var5 == 4) {
                        var23 = var2.field305[var4];
                        var7 = var23.getModifiers();
                        var0.method8097(0);
                        var0.method8234(var7);
                     }
                  } else {
                     var23 = var2.field305[var4];
                     byte[][] var24 = var2.field306[var4];
                     Object[] var8 = new Object[var24.length];

                     for(int var9 = 0; var9 < var24.length; ++var9) {
                        ObjectInputStream var10 = new ObjectInputStream(new ByteArrayInputStream(var24[var9]));
                        var8[var9] = var10.readObject();
                     }

                     Object var25 = var23.invoke((Object)null, var8);
                     if (null == var25) {
                        var0.method8097(0);
                     } else if (var25 instanceof Number) {
                        var0.method8097(1);
                        var0.method8102(((Number)var25).longValue());
                     } else if (var25 instanceof String) {
                        var0.method8097(2);
                        var0.method8104((String)var25);
                     } else {
                        var0.method8097(4);
                     }
                  }
               } catch (ClassNotFoundException var11) {
                  var0.method8097(-10);
               } catch (InvalidClassException var12) {
                  var0.method8097(-11);
               } catch (StreamCorruptedException var13) {
                  var0.method8097(-12);
               } catch (OptionalDataException var14) {
                  var0.method8097(-13);
               } catch (IllegalAccessException var15) {
                  var0.method8097(-14);
               } catch (IllegalArgumentException var16) {
                  var0.method8097(-15);
               } catch (InvocationTargetException var17) {
                  var0.method8097(-16);
               } catch (SecurityException var18) {
                  var0.method8097(-17);
               } catch (IOException var19) {
                  var0.method8097(-18);
               } catch (NullPointerException var20) {
                  var0.method8097(-19);
               } catch (Exception var21) {
                  var0.method8097(-20);
               } catch (Throwable var22) {
                  var0.method8097(-21);
               }
            }
         }

         var0.method8226(var3);
         var2.remove();
      }
   }

   static int method1864(int var0, class78 var1, boolean var2) {
      if (6500 == var0) {
         class57.field404[++class387.field4452 - 1] = class328.method6239() ? 1 : 0;
         return 1;
      } else {
         class72 var9;
         if (var0 == 6501) {
            var9 = class72.method524();
            if (var9 != null) {
               class57.field404[++class387.field4452 - 1] = var9.field590;
               class57.field404[++class387.field4452 - 1] = var9.field587;
               class57.field405[++class126.field1220 - 1] = var9.field588;
               class57.field404[++class387.field4452 - 1] = var9.field580;
               class57.field404[++class387.field4452 - 1] = var9.field593;
               class57.field405[++class126.field1220 - 1] = var9.field589;
            } else {
               class57.field404[++class387.field4452 - 1] = -1;
               class57.field404[++class387.field4452 - 1] = 0;
               class57.field405[++class126.field1220 - 1] = "";
               class57.field404[++class387.field4452 - 1] = 0;
               class57.field404[++class387.field4452 - 1] = 0;
               class57.field405[++class126.field1220 - 1] = "";
            }

            return 1;
         } else if (6502 == var0) {
            var9 = class215.method4335();
            if (null != var9) {
               class57.field404[++class387.field4452 - 1] = var9.field590;
               class57.field404[++class387.field4452 - 1] = var9.field587;
               class57.field405[++class126.field1220 - 1] = var9.field588;
               class57.field404[++class387.field4452 - 1] = var9.field580;
               class57.field404[++class387.field4452 - 1] = var9.field593;
               class57.field405[++class126.field1220 - 1] = var9.field589;
            } else {
               class57.field404[++class387.field4452 - 1] = -1;
               class57.field404[++class387.field4452 - 1] = 0;
               class57.field405[++class126.field1220 - 1] = "";
               class57.field404[++class387.field4452 - 1] = 0;
               class57.field404[++class387.field4452 - 1] = 0;
               class57.field405[++class126.field1220 - 1] = "";
            }

            return 1;
         } else {
            int var4;
            class72 var5;
            int var11;
            if (var0 == 6506) {
               var4 = class57.field404[--class387.field4452];
               var5 = null;

               for(var11 = 0; var11 < class72.field582; ++var11) {
                  if (var4 == class399.field4502[var11].field590) {
                     var5 = class399.field4502[var11];
                     break;
                  }
               }

               if (var5 != null) {
                  class57.field404[++class387.field4452 - 1] = var5.field590;
                  class57.field404[++class387.field4452 - 1] = var5.field587;
                  class57.field405[++class126.field1220 - 1] = var5.field588;
                  class57.field404[++class387.field4452 - 1] = var5.field580;
                  class57.field404[++class387.field4452 - 1] = var5.field593;
                  class57.field405[++class126.field1220 - 1] = var5.field589;
               } else {
                  class57.field404[++class387.field4452 - 1] = -1;
                  class57.field404[++class387.field4452 - 1] = 0;
                  class57.field405[++class126.field1220 - 1] = "";
                  class57.field404[++class387.field4452 - 1] = 0;
                  class57.field404[++class387.field4452 - 1] = 0;
                  class57.field405[++class126.field1220 - 1] = "";
               }

               return 1;
            } else if (var0 == 6507) {
               class387.field4452 -= 4;
               var4 = class57.field404[class387.field4452];
               boolean var10 = class57.field404[1 + class387.field4452] == 1;
               var11 = class57.field404[2 + class387.field4452];
               boolean var7 = 1 == class57.field404[class387.field4452 + 3];
               class166.method2701(var4, var10, var11, var7);
               return 1;
            } else if (var0 != 6511) {
               if (6512 == var0) {
                  client.field1794 = class57.field404[--class387.field4452] == 1;
                  return 1;
               } else {
                  class193 var6;
                  int var8;
                  if (6513 == var0) {
                     class387.field4452 -= 2;
                     var4 = class57.field404[class387.field4452];
                     var8 = class57.field404[class387.field4452 + 1];
                     var6 = class213.method4120(var8);
                     if (var6.method3567()) {
                        class57.field405[++class126.field1220 - 1] = class158.method2632(var4).method3860(var8, var6.field2041);
                     } else {
                        class57.field404[++class387.field4452 - 1] = class158.method2632(var4).method3859(var8, var6.field2043);
                     }

                     return 1;
                  } else if (6514 == var0) {
                     class387.field4452 -= 2;
                     var4 = class57.field404[class387.field4452];
                     var8 = class57.field404[class387.field4452 + 1];
                     var6 = class213.method4120(var8);
                     if (var6.method3567()) {
                        class57.field405[++class126.field1220 - 1] = class89.method1866(var4).method3590(var8, var6.field2041);
                     } else {
                        class57.field404[++class387.field4452 - 1] = class89.method1866(var4).method3614(var8, var6.field2043);
                     }

                     return 1;
                  } else if (var0 == 6515) {
                     class387.field4452 -= 2;
                     var4 = class57.field404[class387.field4452];
                     var8 = class57.field404[class387.field4452 + 1];
                     var6 = class213.method4120(var8);
                     if (var6.method3567()) {
                        class57.field405[++class126.field1220 - 1] = class278.method5388(var4).method3657(var8, var6.field2041);
                     } else {
                        class57.field404[++class387.field4452 - 1] = class278.method5388(var4).method3656(var8, var6.field2043);
                     }

                     return 1;
                  } else if (6516 == var0) {
                     class387.field4452 -= 2;
                     var4 = class57.field404[class387.field4452];
                     var8 = class57.field404[class387.field4452 + 1];
                     var6 = class213.method4120(var8);
                     if (var6.method3567()) {
                        class57.field405[++class126.field1220 - 1] = class191.method3536(var4).method3450(var8, var6.field2041);
                     } else {
                        class57.field404[++class387.field4452 - 1] = class191.method3536(var4).method3451(var8, var6.field2043);
                     }

                     return 1;
                  } else if (var0 == 6518) {
                     class57.field404[++class387.field4452 - 1] = client.field1640 ? 1 : 0;
                     return 1;
                  } else if (var0 == 6519) {
                     class57.field404[++class387.field4452 - 1] = client.field1704;
                     return 1;
                  } else if (6520 == var0) {
                     return 1;
                  } else if (var0 == 6521) {
                     return 1;
                  } else if (var0 == 6522) {
                     --class126.field1220;
                     --class387.field4452;
                     return 1;
                  } else if (6523 == var0) {
                     --class126.field1220;
                     --class387.field4452;
                     return 1;
                  } else if (6524 == var0) {
                     class57.field404[++class387.field4452 - 1] = -1;
                     return 1;
                  } else if (6525 == var0) {
                     class57.field404[++class387.field4452 - 1] = 1;
                     return 1;
                  } else if (var0 == 6526) {
                     class57.field404[++class387.field4452 - 1] = 1;
                     return 1;
                  } else if (var0 == 6527) {
                     class57.field404[++class387.field4452 - 1] = client.field1716;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var4 = class57.field404[--class387.field4452];
               if (var4 >= 0 && var4 < class72.field582) {
                  var5 = class399.field4502[var4];
                  class57.field404[++class387.field4452 - 1] = var5.field590;
                  class57.field404[++class387.field4452 - 1] = var5.field587;
                  class57.field405[++class126.field1220 - 1] = var5.field588;
                  class57.field404[++class387.field4452 - 1] = var5.field580;
                  class57.field404[++class387.field4452 - 1] = var5.field593;
                  class57.field405[++class126.field1220 - 1] = var5.field589;
               } else {
                  class57.field404[++class387.field4452 - 1] = -1;
                  class57.field404[++class387.field4452 - 1] = 0;
                  class57.field405[++class126.field1220 - 1] = "";
                  class57.field404[++class387.field4452 - 1] = 0;
                  class57.field404[++class387.field4452 - 1] = 0;
                  class57.field405[++class126.field1220 - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
