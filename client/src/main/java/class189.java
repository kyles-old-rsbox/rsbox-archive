import java.util.HashMap;
import java.util.Map;

public class class189 extends class437 {
   public static class319 field1989;
   public static class319 field1993;
   static boolean field2011 = false;
   static class284 field1991 = new class284(64);
   static class284 field2001 = new class284(100);
   static class284 field2010 = new class284(100);
   boolean[] field2004;
   int field1988 = 0;
   int field1997 = 0;
   int[] field1999;
   int[] field2003;
   public boolean field2005 = false;
   public boolean field2008 = false;
   public int field1990 = -1;
   public int field1992 = -1;
   public int field1994 = -1;
   public int field1996 = -1;
   public int field2002 = -1;
   public int field2006 = 5;
   public int field2009 = 99;
   public int field2012 = -1;
   public int field2013 = 2;
   public int[] field1998;
   public int[] field2000;
   public int[] field2007;
   public Map field1995;

   public static int method3498(int var0, int var1, int var2) {
      var2 &= 3;
      if (var2 == 0) {
         return var1;
      } else if (1 == var2) {
         return 7 - var0;
      } else {
         return 2 == var2 ? 7 - var1 : var0;
      }
   }

   class189() {
   }

   void method3467(class460 var1) {
      while(true) {
         int var3 = var1.method8134();
         if (0 == var3) {
            return;
         }

         this.method3468(var1, var3);
      }
   }

   void method3468(class460 var1, int var2) {
      int var4;
      int var5;
      if (var2 == 1) {
         var4 = var1.method8115();
         this.field2000 = new int[var4];

         for(var5 = 0; var5 < var4; ++var5) {
            this.field2000[var5] = var1.method8115();
         }

         this.field1998 = new int[var4];

         for(var5 = 0; var5 < var4; ++var5) {
            this.field1998[var5] = var1.method8115();
         }

         for(var5 = 0; var5 < var4; ++var5) {
            this.field1998[var5] += var1.method8115() << 16;
         }
      } else if (2 == var2) {
         this.field2012 = var1.method8115();
      } else if (var2 == 3) {
         var4 = var1.method8134();
         this.field2003 = new int[1 + var4];

         for(var5 = 0; var5 < var4; ++var5) {
            this.field2003[var5] = var1.method8134();
         }

         this.field2003[var4] = 9999999;
      } else if (4 == var2) {
         this.field2005 = true;
      } else if (var2 == 5) {
         this.field2006 = var1.method8134();
      } else if (var2 == 6) {
         this.field1996 = var1.method8115();
      } else if (7 == var2) {
         this.field1990 = var1.method8115();
      } else if (var2 == 8) {
         this.field2009 = var1.method8134();
         this.field2008 = true;
      } else if (9 == var2) {
         this.field2002 = var1.method8134();
      } else if (var2 == 10) {
         this.field1992 = var1.method8134();
      } else if (11 == var2) {
         this.field2013 = var1.method8134();
      } else if (var2 == 12) {
         var4 = var1.method8134();
         this.field1999 = new int[var4];

         for(var5 = 0; var5 < var4; ++var5) {
            this.field1999[var5] = var1.method8115();
         }

         for(var5 = 0; var5 < var4; ++var5) {
            this.field1999[var5] += var1.method8115() << 16;
         }
      } else if (13 == var2) {
         var4 = var1.method8134();
         this.field2007 = new int[var4];

         for(var5 = 0; var5 < var4; ++var5) {
            this.field2007[var5] = var1.method8305();
         }
      } else if (var2 == 14) {
         this.field1994 = var1.method8119();
      } else if (var2 == 15) {
         var4 = var1.method8115();
         this.field1995 = new HashMap();

         for(var5 = 0; var5 < var4; ++var5) {
            int var6 = var1.method8115();
            int var7 = var1.method8305();
            this.field1995.put(var6, var7);
         }
      } else if (16 == var2) {
         this.field1988 = var1.method8115();
         this.field1997 = var1.method8115();
      } else if (17 == var2) {
         this.field2004 = new boolean[256];

         for(var4 = 0; var4 < this.field2004.length; ++var4) {
            this.field2004[var4] = false;
         }

         var4 = var1.method8134();

         for(var5 = 0; var5 < var4; ++var5) {
            this.field2004[var1.method8134()] = true;
         }
      }

   }

   void method3469() {
      if (this.field2002 == -1) {
         if (null == this.field2003 && null == this.field2004) {
            this.field2002 = 0;
         } else {
            this.field2002 = 2;
         }
      }

      if (this.field1992 == -1) {
         if (null == this.field2003 && this.field2004 == null) {
            this.field1992 = 0;
         } else {
            this.field1992 = 2;
         }
      }

   }

   public class209 method3479(class209 var1, int var2) {
      class209 var5;
      if (!this.method3486()) {
         var2 = this.field1998[var2];
         class218 var6 = class86.method1819(var2 >> 16);
         var2 &= 65535;
         if (null == var6) {
            return var1.method3988(true);
         } else {
            var5 = var1.method3988(!var6.method4367(var2));
            var5.method4033(var6, var2);
            return var5;
         }
      } else {
         class112 var4 = class195.method3594(this.field1994);
         if (null == var4) {
            return var1.method3988(true);
         } else {
            var5 = var1.method3988(!var4.method2152());
            var5.method4057(var4, var2);
            return var5;
         }
      }
   }

   class209 method3470(class209 var1, int var2, int var3) {
      class209 var6;
      if (!this.method3486()) {
         var2 = this.field1998[var2];
         class218 var7 = class86.method1819(var2 >> 16);
         var2 &= 65535;
         if (null == var7) {
            return var1.method3988(true);
         } else {
            var6 = var1.method3988(!var7.method4367(var2));
            var3 &= 3;
            if (var3 == 1) {
               var6.method4006();
            } else if (2 == var3) {
               var6.method4005();
            } else if (3 == var3) {
               var6.method4083();
            }

            var6.method4033(var7, var2);
            if (var3 == 1) {
               var6.method4083();
            } else if (var3 == 2) {
               var6.method4005();
            } else if (var3 == 3) {
               var6.method4006();
            }

            return var6;
         }
      } else {
         class112 var5 = class195.method3594(this.field1994);
         if (null == var5) {
            return var1.method3988(true);
         } else {
            var6 = var1.method3988(!var5.method2152());
            var3 &= 3;
            if (var3 == 1) {
               var6.method4006();
            } else if (var3 == 2) {
               var6.method4005();
            } else if (3 == var3) {
               var6.method4083();
            }

            var6.method4057(var5, var2);
            if (1 == var3) {
               var6.method4083();
            } else if (var3 == 2) {
               var6.method4005();
            } else if (var3 == 3) {
               var6.method4006();
            }

            return var6;
         }
      }
   }

   class209 method3471(class209 var1, int var2) {
      class209 var5;
      if (!this.method3486()) {
         var2 = this.field1998[var2];
         class218 var6 = class86.method1819(var2 >> 16);
         var2 &= 65535;
         if (var6 == null) {
            return var1.method3997(true);
         } else {
            var5 = var1.method3997(!var6.method4367(var2));
            var5.method4033(var6, var2);
            return var5;
         }
      } else {
         class112 var4 = class195.method3594(this.field1994);
         if (var4 == null) {
            return var1.method3997(true);
         } else {
            var5 = var1.method3997(!var4.method2152());
            var5.method4057(var4, var2);
            return var5;
         }
      }
   }

   public class209 method3472(class209 var1, int var2, class189 var3, int var4) {
      if (field2011 && !this.method3486() && !var3.method3486()) {
         return this.method3496(var1, var2, var3, var4);
      } else {
         class209 var6 = var1.method3988(false);
         boolean var7 = false;
         class218 var8 = null;
         class230 var9 = null;
         class112 var10;
         if (this.method3486()) {
            var10 = this.method3477();
            if (var10 == null) {
               return var6;
            }

            if (var3.method3486() && this.field2004 == null) {
               var6.method4057(var10, var2);
               return var6;
            }

            var9 = var10.field1104;
            var6.method4055(var9, var10, var2, this.field2004, false, !var3.method3486());
         } else {
            var2 = this.field1998[var2];
            var8 = class86.method1819(var2 >> 16);
            var2 &= 65535;
            if (null == var8) {
               return var3.method3479(var1, var4);
            }

            if (!var3.method3486() && (null == this.field2003 || -1 == var4)) {
               var6.method4033(var8, var2);
               return var6;
            }

            if (null == this.field2003 || var4 == -1) {
               var6.method4033(var8, var2);
               return var6;
            }

            var7 = var3.method3486();
            if (!var7) {
               var6.method4002(var8, var2, this.field2003, false);
            }
         }

         if (var3.method3486()) {
            var10 = var3.method3477();
            if (var10 == null) {
               return var6;
            }

            if (var9 == null) {
               var9 = var10.field1104;
            }

            var6.method4055(var9, var10, var4, this.field2004, true, true);
         } else {
            var4 = var3.field1998[var4];
            class218 var11 = class86.method1819(var4 >> 16);
            var4 &= 65535;
            if (var11 == null) {
               return this.method3479(var1, var2);
            }

            var6.method4002(var11, var4, this.field2003, true);
         }

         if (var7 && null != var8) {
            var6.method4002(var8, var2, this.field2003, false);
         }

         var6.method3995();
         return var6;
      }
   }

   class209 method3496(class209 var1, int var2, class189 var3, int var4) {
      var2 = this.field1998[var2];
      class218 var6 = class86.method1819(var2 >> 16);
      var2 &= 65535;
      if (var6 == null) {
         return var3.method3479(var1, var4);
      } else {
         var4 = var3.field1998[var4];
         class218 var7 = class86.method1819(var4 >> 16);
         var4 &= 65535;
         class209 var8;
         if (null == var7) {
            var8 = var1.method3988(!var6.method4367(var2));
            var8.method4033(var6, var2);
            return var8;
         } else {
            var8 = var1.method3988(!var6.method4367(var2) & !var7.method4367(var4));
            var8.method4088(var6, var2, var7, var4, this.field2003);
            return var8;
         }
      }
   }

   public class209 method3474(class209 var1, int var2) {
      if (!this.method3486()) {
         int var4 = this.field1998[var2];
         class218 var5 = class86.method1819(var4 >> 16);
         var4 &= 65535;
         if (null == var5) {
            return var1.method3988(true);
         } else {
            class218 var6 = null;
            int var7 = 0;
            if (this.field1999 != null && var2 < this.field1999.length) {
               var7 = this.field1999[var2];
               var6 = class86.method1819(var7 >> 16);
               var7 &= 65535;
            }

            class209 var8;
            if (var6 != null && var7 != 65535) {
               var8 = var1.method3988(!var5.method4367(var4) & !var6.method4367(var7));
               var8.method4033(var5, var4);
               var8.method4033(var6, var7);
               return var8;
            } else {
               var8 = var1.method3988(!var5.method4367(var4));
               var8.method4033(var5, var4);
               return var8;
            }
         }
      } else {
         return this.method3479(var1, var2);
      }
   }

   public boolean method3486() {
      return this.field1994 >= 0;
   }

   public int method3476() {
      return this.field1997 - this.field1988;
   }

   class112 method3477() {
      return this.method3486() ? class195.method3594(this.field1994) : null;
   }

   public static void method2113() {
      field1991.method5437();
      field2001.method5437();
      field2010.method5437();
   }

   static int method3490(int var0, class78 var1, boolean var2) {
      if (3200 == var0) {
         class387.field4452 -= 3;
         class271.method5212(class57.field404[class387.field4452], class57.field404[1 + class387.field4452], class57.field404[2 + class387.field4452]);
         return 1;
      } else if (3201 == var0) {
         class45.method943(class57.field404[--class387.field4452]);
         return 1;
      } else if (3202 == var0) {
         class387.field4452 -= 2;
         class196.method3635(class57.field404[class387.field4452], class57.field404[class387.field4452 + 1]);
         return 1;
      } else {
         class103 var4;
         class88 var5;
         int var6;
         int var7;
         String var9;
         if (var0 != 3212 && var0 != 3213 && 3209 != var0 && 3181 != var0 && 3203 != var0 && 3205 != var0 && var0 != 3207) {
            if (var0 != 3214 && 3215 != var0 && var0 != 3210 && 3182 != var0 && 3204 != var0 && var0 != 3206 && 3208 != var0) {
               return 3211 == var0 ? 1 : 2;
            } else {
               var4 = class103.field1032;
               var5 = class88.field786;
               boolean var8 = false;
               if (3214 == var0) {
                  var7 = class57.field404[--class387.field4452];
                  var4 = (class103)class217.method4362(class103.method2745(), var7);
                  if (var4 == null) {
                     throw new RuntimeException(String.format("Unrecognized device option %d", var7));
                  }
               }

               if (var0 == 3215) {
                  var7 = class57.field404[--class387.field4452];
                  var5 = (class88)class217.method4362(class88.method1283(), var7);
                  if (var5 == null) {
                     throw new RuntimeException(String.format("Unrecognized game option %d", var7));
                  }
               }

               if (var0 == 3210) {
                  var7 = class57.field404[--class387.field4452];
                  var4 = (class103)class217.method4362(class103.method2745(), var7);
                  if (var4 == null) {
                     var5 = (class88)class217.method4362(class88.method1283(), var7);
                     if (null == var5) {
                        throw new RuntimeException(String.format("Unrecognized client option %d", var7));
                     }
                  }
               } else if (3182 == var0) {
                  var4 = class103.field1025;
               } else if (var0 == 3204) {
                  var5 = class88.field793;
               } else if (3206 == var0) {
                  var5 = class88.field787;
               } else if (var0 == 3208) {
                  var5 = class88.field788;
               }

               if (class88.field786 == var5) {
                  switch(var4.field1027) {
                  case 1:
                     var6 = class413.field4575.method1706() ? 1 : 0;
                     break;
                  case 2:
                     var6 = class413.field4575.method1708() ? 1 : 0;
                     break;
                  case 3:
                     var6 = class413.field4575.method1711() ? 1 : 0;
                     break;
                  case 4:
                     var6 = class413.field4575.method1766();
                     break;
                  case 5:
                     var6 = client.method6536();
                     break;
                  default:
                     var9 = String.format("Unkown device option: %s.", var4.toString());
                     throw new RuntimeException(var9);
                  }
               } else {
                  switch(var5.field789) {
                  case 1:
                     var6 = class413.field4575.method1777() ? 1 : 0;
                     break;
                  case 2:
                     var7 = class413.field4575.method1716();
                     var6 = Math.round((float)(var7 * 100) / 255.0F);
                     break;
                  case 3:
                     var7 = class413.field4575.method1752();
                     var6 = Math.round((float)(100 * var7) / 127.0F);
                     break;
                  case 4:
                     var7 = class413.field4575.method1736();
                     var6 = Math.round((float)(var7 * 100) / 127.0F);
                     break;
                  default:
                     var9 = String.format("Unkown game option: %s.", var5.toString());
                     throw new RuntimeException(var9);
                  }
               }

               class57.field404[++class387.field4452 - 1] = var6;
               return 1;
            }
         } else {
            var4 = class103.field1032;
            var5 = class88.field786;
            var6 = class57.field404[--class387.field4452];
            if (var0 == 3212) {
               var7 = class57.field404[--class387.field4452];
               var4 = (class103)class217.method4362(class103.method2745(), var7);
               if (null == var4) {
                  throw new RuntimeException(String.format("Unrecognized device option %d", var7));
               }
            }

            if (3213 == var0) {
               var7 = class57.field404[--class387.field4452];
               var5 = (class88)class217.method4362(class88.method1283(), var7);
               if (var5 == null) {
                  throw new RuntimeException(String.format("Unrecognized game option %d", var7));
               }
            }

            if (3209 == var0) {
               var7 = class57.field404[--class387.field4452];
               var4 = (class103)class217.method4362(class103.method2745(), var7);
               if (null == var4) {
                  var5 = (class88)class217.method4362(class88.method1283(), var7);
                  if (null == var5) {
                     throw new RuntimeException(String.format("Unrecognized client option %d", var7));
                  }
               }
            } else if (3181 == var0) {
               var4 = class103.field1025;
            } else if (var0 == 3203) {
               var5 = class88.field793;
            } else if (3205 == var0) {
               var5 = class88.field787;
            } else if (var0 == 3207) {
               var5 = class88.field788;
            }

            if (var5 == class88.field786) {
               switch(var4.field1027) {
               case 1:
                  class413.field4575.method1755(1 == var6);
                  break;
               case 2:
                  class413.field4575.method1707(var6 == 1);
                  break;
               case 3:
                  class413.field4575.method1709(1 == var6);
                  break;
               case 4:
                  if (var6 < 0) {
                     var6 = 0;
                  }

                  class413.field4575.method1712(var6);
                  break;
               case 5:
                  client.method4524(var6);
                  break;
               default:
                  var9 = String.format("Unkown device option: %s.", var4.toString());
                  throw new RuntimeException(var9);
               }
            } else {
               switch(var5.field789) {
               case 1:
                  class413.field4575.method1703(1 == var6);
                  break;
               case 2:
                  var6 = Math.min(Math.max(var6, 0), 100);
                  var7 = Math.round((float)(var6 * 255) / 100.0F);
                  class17.method198(var7);
                  break;
               case 3:
                  var6 = Math.min(Math.max(var6, 0), 100);
                  var7 = Math.round((float)(var6 * 127) / 100.0F);
                  client.method1354(var7);
                  break;
               case 4:
                  var6 = Math.min(Math.max(var6, 0), 100);
                  var7 = Math.round((float)(127 * var6) / 100.0F);
                  client.method6041(var7);
                  break;
               default:
                  var9 = String.format("Unkown game option: %s.", var5.toString());
                  throw new RuntimeException(var9);
               }
            }

            return 1;
         }
      }
   }

   static void method3481() {
      for(class188 var1 = (class188)client.field1856.method6356(); var1 != null; var1 = (class188)client.field1856.method6350()) {
         var1.remove();
      }

   }
}
