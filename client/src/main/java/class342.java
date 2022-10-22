import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class class342 extends AbstractQueue {
   class357[] field4227;
   int field4224;
   int field4226;
   Map field4222;
   final Comparator field4225;

   public class342(int var1) {
      this(var1, (Comparator)null);
   }

   public class342(int var1, Comparator var2) {
      this.field4226 = 0;
      this.field4227 = new class357[var1];
      this.field4222 = new HashMap();
      this.field4225 = var2;
   }

   void method6319() {
      int var2 = 1 + (this.field4227.length << 1);
      this.field4227 = (class357[])((class357[])Arrays.copyOf(this.field4227, var2));
   }

   public int size() {
      return this.field4224;
   }

   public boolean offer(Object var1) {
      if (this.field4222.containsKey(var1)) {
         throw new IllegalArgumentException("");
      } else {
         ++this.field4226;
         int var2 = this.field4224;
         if (var2 >= this.field4227.length) {
            this.method6319();
         }

         ++this.field4224;
         if (0 == var2) {
            this.field4227[0] = new class357(var1, 0);
            this.field4222.put(var1, this.field4227[0]);
         } else {
            this.field4227[var2] = new class357(var1, var2);
            this.field4222.put(var1, this.field4227[var2]);
            this.method6325(var2);
         }

         return true;
      }
   }

   public Object peek() {
      return 0 == this.field4224 ? null : this.field4227[0].field4307;
   }

   public Object poll() {
      if (this.field4224 == 0) {
         return null;
      } else {
         ++this.field4226;
         Object var1 = this.field4227[0].field4307;
         this.field4222.remove(var1);
         --this.field4224;
         if (this.field4224 == 0) {
            this.field4227[this.field4224] = null;
         } else {
            this.field4227[0] = this.field4227[this.field4224];
            this.field4227[0].field4308 = 0;
            this.field4227[this.field4224] = null;
            this.method6321(0);
         }

         return var1;
      }
   }

   public boolean remove(Object var1) {
      class357 var2 = (class357)this.field4222.remove(var1);
      if (null == var2) {
         return false;
      } else {
         ++this.field4226;
         --this.field4224;
         if (var2.field4308 == this.field4224) {
            this.field4227[this.field4224] = null;
            return true;
         } else {
            class357 var3 = this.field4227[this.field4224];
            this.field4227[this.field4224] = null;
            this.field4227[var2.field4308] = var3;
            this.field4227[var2.field4308].field4308 = var2.field4308;
            this.method6321(var2.field4308);
            if (var3 == this.field4227[var2.field4308]) {
               this.method6325(var2.field4308);
            }

            return true;
         }
      }
   }

   void method6325(int var1) {
      class357 var3;
      int var4;
      for(var3 = this.field4227[var1]; var1 > 0; var1 = var4) {
         var4 = var1 - 1 >>> 1;
         class357 var5 = this.field4227[var4];
         if (null != this.field4225) {
            if (this.field4225.compare(var3.field4307, var5.field4307) >= 0) {
               break;
            }
         } else if (((Comparable)var3.field4307).compareTo(var5.field4307) >= 0) {
            break;
         }

         this.field4227[var1] = var5;
         this.field4227[var1].field4308 = var1;
      }

      this.field4227[var1] = var3;
      this.field4227[var1].field4308 = var1;
   }

   void method6321(int var1) {
      class357 var3 = this.field4227[var1];

      int var9;
      for(int var4 = this.field4224 >>> 1; var1 < var4; var1 = var9) {
         int var5 = (var1 << 1) + 1;
         class357 var6 = this.field4227[var5];
         int var7 = (var1 << 1) + 2;
         class357 var8 = this.field4227[var7];
         if (this.field4225 != null) {
            if (var7 < this.field4224 && this.field4225.compare(var6.field4307, var8.field4307) > 0) {
               var9 = var7;
            } else {
               var9 = var5;
            }
         } else if (var7 < this.field4224 && ((Comparable)var6.field4307).compareTo(var8.field4307) > 0) {
            var9 = var7;
         } else {
            var9 = var5;
         }

         if (this.field4225 != null) {
            if (this.field4225.compare(var3.field4307, this.field4227[var9].field4307) <= 0) {
               break;
            }
         } else if (((Comparable)var3.field4307).compareTo(this.field4227[var9].field4307) <= 0) {
            break;
         }

         this.field4227[var1] = this.field4227[var9];
         this.field4227[var1].field4308 = var1;
      }

      this.field4227[var1] = var3;
      this.field4227[var1].field4308 = var1;
   }

   public boolean contains(Object var1) {
      return this.field4222.containsKey(var1);
   }

   public Object[] toArray() {
      Object[] var1 = super.toArray();
      if (null != this.field4225) {
         Arrays.sort(var1, this.field4225);
      } else {
         Arrays.sort(var1);
      }

      return var1;
   }

   public Iterator iterator() {
      return new class352(this);
   }

   static final void method6344(class271 var0) {
      class453 var2 = client.field1778.field1076;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      byte var13;
      int var15;
      int var45;
      int var47;
      int var48;
      class66 var49;
      if (var0 == class271.field3024) {
         var3 = var2.method8195();
         var4 = var2.method8146() * 4;
         byte var34 = var2.method8280();
         var6 = var2.method8155();
         var7 = var2.method8147();
         var8 = var2.method8146();
         var9 = var2.method8149();
         var10 = var2.method8134();
         var11 = class7.field28 + (var10 >> 4 & 7);
         var45 = (var10 & 7) + class19.field98;
         var13 = var2.method8180();
         var48 = var2.method8334() * 4;
         var15 = var2.method8155();
         var5 = var34 + var11;
         var47 = var13 + var45;
         if (var11 >= 0 && var45 >= 0 && var11 < 104 && var45 < 104 && var5 >= 0 && var47 >= 0 && var5 < 104 && var47 < 104 && var6 != 65535) {
            var11 = var11 * 128 + 64;
            var45 = 64 + 128 * var45;
            var5 = var5 * 128 + 64;
            var47 = 128 * var47 + 64;
            var49 = new class66(var6, class55.field396, var11, var45, class144.method2498(var11, var45, class55.field396) - var48, client.field1645 + var3, var15 + client.field1645, var7, var8, var9, var4);
            var49.method1380(var5, var47, class144.method2498(var5, var47, class55.field396) - var4, client.field1645 + var3);
            client.field1853.method6347(var49);
         }

      } else {
         if (var0 == class271.field3021) {
            var3 = var2.method8155();
            var4 = var2.method8146();
            var5 = var2.method8146();
            var6 = var5 >> 4 & 15;
            var7 = var5 & 7;
            var8 = var2.method8146();
            var9 = class7.field28 + (var8 >> 4 & 7);
            var10 = (var8 & 7) + class19.field98;
            if (var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104) {
               var11 = var6 + 1;
               if (class291.field3364.field861[0] >= var9 - var11 && class291.field3364.field861[0] <= var11 + var9 && class291.field3364.field873[0] >= var10 - var11 && class291.field3364.field873[0] <= var10 + var11 && class413.field4575.method1736() != 0 && var7 > 0 && client.field1894 < 50) {
                  client.field1895[client.field1894] = var3;
                  client.field1896[client.field1894] = var7;
                  client.field1897[client.field1894] = var4;
                  client.field1899[client.field1894] = null;
                  client.field1734[client.field1894] = var6 + (var10 << 8) + (var9 << 16);
                  ++client.field1894;
               }
            }
         }

         class104 var38;
         if (var0 == class271.field3020) {
            var2.method8157();
            var3 = var2.method8195();
            var4 = var2.method8146();
            var5 = class7.field28 + (var4 >> 4 & 7);
            var6 = class19.field98 + (var4 & 7);
            if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               class343 var37 = client.field1865[class55.field396][var5][var6];
               if (var37 != null) {
                  for(var38 = (class104)var37.method6356(); null != var38; var38 = (class104)var37.method6350()) {
                     if (var38.field1043 == (var3 & 32767)) {
                        var38.remove();
                        break;
                     }
                  }

                  if (var37.method6356() == null) {
                     client.field1865[class55.field396][var5][var6] = null;
                  }

                  class176.method2802(var5, var6);
               }
            }

         } else {
            byte var32;
            if (var0 == class271.field3018) {
               var3 = var2.method8157();
               var32 = var2.method8180();
               var5 = var2.method8134();
               var6 = var5 >> 2;
               var7 = var5 & 3;
               var8 = client.field1708[var6];
               var9 = var2.method8134();
               var10 = class7.field28 + (var9 >> 4 & 7);
               var11 = (var9 & 7) + class19.field98;
               byte var12 = var2.method8280();
               var13 = var2.method8180();
               byte var14 = var2.method8151();
               var15 = var2.method8115();
               int var16 = var2.method8157();
               int var17 = var2.method8195();
               class93 var18;
               if (client.field1764 == var16) {
                  var18 = class291.field3364;
               } else {
                  var18 = client.field1763[var16];
               }

               if (null != var18) {
                  class195 var19 = class89.method1866(var17);
                  int var20;
                  int var21;
                  if (1 != var7 && var7 != 3) {
                     var20 = var19.field2100;
                     var21 = var19.field2069;
                  } else {
                     var20 = var19.field2069;
                     var21 = var19.field2100;
                  }

                  int var22 = (var20 >> 1) + var10;
                  int var23 = var10 + (var20 + 1 >> 1);
                  int var24 = (var21 >> 1) + var11;
                  int var25 = (1 + var21 >> 1) + var11;
                  int[][] var26 = class82.field719[class55.field396];
                  int var27 = var26[var23][var25] + var26[var22][var24] + var26[var23][var24] + var26[var22][var25] >> 2;
                  int var28 = (var20 << 6) + (var10 << 7);
                  int var29 = (var11 << 7) + (var21 << 6);
                  class209 var30 = var19.method3598(var6, var7, var26, var28, var27, var29);
                  if (var30 != null) {
                     class335.method6263(class55.field396, var10, var11, var8, -1, 0, 0, 31, var3 + 1, var15 + 1);
                     var18.field901 = client.field1645 + var3;
                     var18.field902 = var15 + client.field1645;
                     var18.field906 = var30;
                     var18.field898 = var20 * 64 + var10 * 128;
                     var18.field903 = 64 * var21 + 128 * var11;
                     var18.field904 = var27;
                     byte var31;
                     if (var12 > var13) {
                        var31 = var12;
                        var12 = var13;
                        var13 = var31;
                     }

                     if (var32 > var14) {
                        var31 = var32;
                        var32 = var14;
                        var14 = var31;
                     }

                     var18.field907 = var12 + var10;
                     var18.field909 = var13 + var10;
                     var18.field908 = var32 + var11;
                     var18.field899 = var11 + var14;
                  }
               }
            }

            if (class271.field3023 == var0) {
               var3 = var2.method8147() * 4;
               var32 = var2.method8280();
               var5 = var2.method8157();
               var6 = var2.method8155();
               var7 = var2.method8157();
               var8 = var2.method8147();
               var9 = var2.method8147() * 4;
               byte var41 = var2.method8151();
               var11 = var2.method8334();
               var45 = class7.field28 + (var11 >> 4 & 7);
               var47 = (var11 & 7) + class19.field98;
               var48 = var2.method8159();
               var15 = var2.method8134();
               var10 = var41 + var45;
               var4 = var32 + var47;
               if (var45 >= 0 && var47 >= 0 && var45 < 104 && var47 < 104 && var10 >= 0 && var4 >= 0 && var10 < 104 && var4 < 104 && 65535 != var5) {
                  var45 = 64 + 128 * var45;
                  var47 = 64 + var47 * 128;
                  var10 = 64 + 128 * var10;
                  var4 = var4 * 128 + 64;
                  var49 = new class66(var5, class55.field396, var45, var47, class144.method2498(var45, var47, class55.field396) - var3, var7 + client.field1645, client.field1645 + var6, var15, var8, var48, var9);
                  var49.method1380(var10, var4, class144.method2498(var10, var4, class55.field396) - var9, client.field1645 + var7);
                  client.field1853.method6347(var49);
               }

            } else if (var0 == class271.field3026) {
               var3 = var2.method8334();
               var4 = var2.method8115();
               var5 = var2.method8134();
               var6 = (var5 >> 4 & 7) + class7.field28;
               var7 = (var5 & 7) + class19.field98;
               var8 = var2.method8195();
               if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                  var6 = 64 + var6 * 128;
                  var7 = 64 + 128 * var7;
                  class77 var42 = new class77(var8, class55.field396, var6, var7, class144.method2498(var6, var7, class55.field396) - var3, var4, client.field1645);
                  client.field1779.method6347(var42);
               }

            } else if (class271.field3031 == var0) {
               var3 = var2.method8334();
               var4 = var3 >> 2;
               var5 = var3 & 3;
               var6 = client.field1708[var4];
               var7 = var2.method8115();
               var8 = var2.method8134();
               var9 = (var8 >> 4 & 7) + class7.field28;
               var10 = (var8 & 7) + class19.field98;
               if (var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104) {
                  class335.method6263(class55.field396, var9, var10, var6, var7, var4, var5, 31, 0, -1);
               }

            } else if (class271.field3022 == var0) {
               var3 = var2.method8115();
               var4 = var2.method8146();
               var5 = (var4 >> 4 & 7) + class7.field28;
               var6 = (var4 & 7) + class19.field98;
               var7 = var2.method8157();
               if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  var38 = new class104();
                  var38.field1043 = var7;
                  var38.field1038 = var3;
                  if (null == client.field1865[class55.field396][var5][var6]) {
                     client.field1865[class55.field396][var5][var6] = new class343();
                  }

                  client.field1865[class55.field396][var5][var6].method6347(var38);
                  class176.method2802(var5, var6);
               }

            } else if (var0 == class271.field3019) {
               var3 = var2.method8334();
               var4 = class7.field28 + (var3 >> 4 & 7);
               var5 = class19.field98 + (var3 & 7);
               var6 = var2.method8195();
               var7 = var2.method8146();
               var8 = var7 >> 2;
               var9 = var7 & 3;
               var10 = client.field1708[var8];
               if (var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
                  if (var10 == 0) {
                     class229 var40 = class145.field1333.method4144(class55.field396, var4, var5);
                     if (var40 != null) {
                        var45 = class234.method1610(var40.field2735);
                        if (2 == var8) {
                           var40.field2728 = new class61(var45, 2, 4 + var9, class55.field396, var4, var5, var6, false, var40.field2728);
                           var40.field2734 = new class61(var45, 2, 1 + var9 & 3, class55.field396, var4, var5, var6, false, var40.field2734);
                        } else {
                           var40.field2728 = new class61(var45, var8, var9, class55.field396, var4, var5, var6, false, var40.field2728);
                        }
                     }
                  }

                  if (var10 == 1) {
                     class217 var43 = class145.field1333.method4145(class55.field396, var4, var5);
                     if (null != var43) {
                        var45 = class234.method1610(var43.field2584);
                        if (4 != var8 && 5 != var8) {
                           if (6 == var8) {
                              var43.field2582 = new class61(var45, 4, 4 + var9, class55.field396, var4, var5, var6, false, var43.field2582);
                           } else if (var8 == 7) {
                              var43.field2582 = new class61(var45, 4, (var9 + 2 & 3) + 4, class55.field396, var4, var5, var6, false, var43.field2582);
                           } else if (var8 == 8) {
                              var43.field2582 = new class61(var45, 4, var9 + 4, class55.field396, var4, var5, var6, false, var43.field2582);
                              var43.field2585 = new class61(var45, 4, 4 + (var9 + 2 & 3), class55.field396, var4, var5, var6, false, var43.field2585);
                           }
                        } else {
                           var43.field2582 = new class61(var45, 4, var9, class55.field396, var4, var5, var6, false, var43.field2582);
                        }
                     }
                  }

                  if (var10 == 2) {
                     class227 var44 = class145.field1333.method4276(class55.field396, var4, var5);
                     if (var8 == 11) {
                        var8 = 10;
                     }

                     if (var44 != null) {
                        var44.field2711 = new class61(class234.method1610(var44.field2719), var8, var9, class55.field396, var4, var5, var6, false, var44.field2711);
                     }
                  }

                  if (3 == var10) {
                     class196 var46 = class145.field1333.method4147(class55.field396, var4, var5);
                     if (null != var46) {
                        var46.field2108 = new class61(class234.method1610(var46.field2109), 22, var9, class55.field396, var4, var5, var6, false, var46.field2108);
                     }
                  }
               }

            } else if (var0 == class271.field3028) {
               var3 = var2.method8147();
               var4 = (var3 >> 4 & 7) + class7.field28;
               var5 = class19.field98 + (var3 & 7);
               var6 = var2.method8155();
               var7 = var2.method8155();
               var8 = var2.method8115();
               if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                  class343 var39 = client.field1865[class55.field396][var4][var5];
                  if (null != var39) {
                     for(class104 var36 = (class104)var39.method6356(); null != var36; var36 = (class104)var39.method6350()) {
                        if ((var8 & 32767) == var36.field1043 && var36.field1038 == var6) {
                           var36.field1038 = var7;
                           break;
                        }
                     }

                     class176.method2802(var4, var5);
                  }
               }

            } else {
               class104 var35;
               if (var0 != class271.field3029) {
                  if (class271.field3025 == var0) {
                     var3 = var2.method8134();
                     var4 = var3 >> 2;
                     var5 = var3 & 3;
                     var6 = client.field1708[var4];
                     var7 = var2.method8134();
                     var8 = (var7 >> 4 & 7) + class7.field28;
                     var9 = (var7 & 7) + class19.field98;
                     if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
                        class335.method6263(class55.field396, var8, var9, var6, -1, var4, var5, 31, 0, -1);
                     }

                  } else if (class271.field3033 == var0) {
                     var3 = var2.method8134();
                     var4 = var2.method8167();
                     var5 = var2.method8147();
                     var6 = (var5 >> 4 & 7) + class7.field28;
                     var7 = class19.field98 + (var5 & 7);
                     var8 = var2.method8195();
                     if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                        var35 = new class104();
                        var35.field1043 = var8;
                        var35.field1038 = var4;
                        var35.method2029(var3);
                        if (client.field1865[class55.field396][var6][var7] == null) {
                           client.field1865[class55.field396][var6][var7] = new class343();
                        }

                        client.field1865[class55.field396][var6][var7].method6347(var35);
                        class176.method2802(var6, var7);
                     }

                  } else if (class271.field3030 == var0) {
                     var3 = var2.method8195();
                     var4 = var2.method8146();
                     var5 = var2.method8334();
                     var6 = class7.field28 + (var5 >> 4 & 7);
                     var7 = (var5 & 7) + class19.field98;
                     var8 = var2.method8146();
                     var9 = var8 >> 2;
                     var10 = var8 & 3;
                     var11 = client.field1708[var9];
                     if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                        class335.method6263(class55.field396, var6, var7, var11, var3, var9, var10, var4, 0, -1);
                     }

                  }
               } else {
                  var3 = var2.method8147();
                  var4 = class7.field28 + (var3 >> 4 & 7);
                  var5 = class19.field98 + (var3 & 7);
                  var6 = var2.method8146();
                  var7 = var2.method8157();
                  if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                     class343 var33 = client.field1865[class55.field396][var4][var5];
                     if (null != var33) {
                        for(var35 = (class104)var33.method6356(); var35 != null; var35 = (class104)var33.method6350()) {
                           if ((var7 & 32767) == var35.field1043) {
                              var35.method2029(var6);
                              break;
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
