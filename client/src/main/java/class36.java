import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class class36 implements KeyListener, FocusListener {
   static int field241;
   static int[][] field238;
   boolean[] field237 = new boolean[112];
   class29[] field234 = new class29[3];
   Collection field236 = new ArrayList(100);
   Collection field243 = new ArrayList(100);
   volatile int field239 = 0;

   class36() {
   }

   void method702(class29 var1, int var2) {
      this.field234[var2] = var1;
   }

   public int method671() {
      return this.field239;
   }

   void method672(Component var1) {
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(this);
      var1.addFocusListener(this);
   }

   synchronized void method673(Component var1) {
      var1.removeKeyListener(this);
      var1.removeFocusListener(this);
      synchronized(this) {
         this.field243.add(new class37(4, 0));
      }
   }

   void method674() {
      ++this.field239;
      this.method676();
      Iterator var2 = this.field236.iterator();

      while(var2.hasNext()) {
         class37 var3 = (class37)var2.next();

         for(int var4 = 0; var4 < this.field234.length && !var3.method714(this.field234[var4]); ++var4) {
         }
      }

      this.field236.clear();
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      int var2;
      label23: {
         var2 = var1.getKeyCode();
         if (var2 >= 0) {
            int var4 = class41.field264.length;
            if (var2 < var4) {
               int var5 = class41.field264[var2];
               var2 = var5;
               boolean var6 = (var5 & 128) != 0;
               if (var6) {
                  var2 = -1;
               }
               break label23;
            }
         }

         var2 = -1;
      }

      if (var2 >= 0) {
         this.field237[var2] = true;
         this.field243.add(new class37(1, var2));
         this.field239 = 0;
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      int var2;
      label16: {
         var2 = var1.getKeyCode();
         if (var2 >= 0) {
            int var4 = class41.field264.length;
            if (var2 < var4) {
               int var5 = class41.field264[var2];
               var2 = var5 & -129;
               break label16;
            }
         }

         var2 = -1;
      }

      if (var2 >= 0) {
         this.field237[var2] = false;
         this.field243.add(new class37(2, var2));
      }

      var1.consume();
   }

   public final synchronized void keyTyped(KeyEvent var1) {
      char var2 = var1.getKeyChar();
      if (0 != var2 && '\uffff' != var2) {
         boolean var3;
         if ((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
            label47: {
               if (0 != var2) {
                  char[] var4 = class349.field4270;

                  for(int var5 = 0; var5 < var4.length; ++var5) {
                     char var6 = var4[var5];
                     if (var2 == var6) {
                        var3 = true;
                        break label47;
                     }
                  }
               }

               var3 = false;
            }
         } else {
            var3 = true;
         }

         if (var3) {
            this.field243.add(new class37(3, var2));
         }
      }

      var1.consume();
   }

   synchronized void method676() {
      Collection var2 = this.field236;
      this.field236 = this.field243;
      this.field243 = var2;
   }

   public final synchronized void focusGained(FocusEvent var1) {
      this.field243.add(new class37(4, 1));
   }

   public final synchronized void focusLost(FocusEvent var1) {
      for(int var2 = 0; var2 < 112; ++var2) {
         if (this.field237[var2]) {
            this.field237[var2] = false;
            this.field243.add(new class37(2, var2));
         }
      }

      this.field243.add(new class37(4, 0));
   }

   static int method711(int var0, class78 var1, boolean var2) {
      int var4;
      Object var5;
      int var6;
      class459 var7;
      int var8;
      if (var0 != 7500 && 7508 != var0) {
         if (7501 != var0) {
            int var21;
            int var23;
            if (var0 == 7502) {
               class387.field4452 -= 3;
               var4 = class57.field404[class387.field4452];
               var21 = class57.field404[class387.field4452 + 1];
               var6 = class57.field404[class387.field4452 + 2];
               var23 = class444.method7135(var21);
               var8 = class444.method6191(var21);
               int var25 = class444.method1425(var21);
               class452 var26 = class154.method2596(var4);
               class458 var27 = class28.method412(var23);
               int[] var28 = var27.field4872[var8];
               int var13 = 0;
               int var14 = var28.length;
               if (var25 >= 0) {
                  if (var25 >= var14) {
                     throw new RuntimeException("Tuple index out-of-bounds. Requested: " + var25 + ", Max: " + var14);
                  }

                  var13 = var25;
                  var14 = 1 + var25;
               }

               Object[] var15 = var26.method7982(var8);
               if (null == var15 && var27.field4874 != null) {
                  var15 = var27.field4874[var8];
               }

               int var16;
               int var17;
               if (var15 == null) {
                  for(var16 = var13; var16 < var14; ++var16) {
                     var17 = var28[var16];
                     class451 var29 = class213.method4117(var17);
                     if (class451.field4850 == var29) {
                        class57.field405[++class126.field1220 - 1] = "";
                     } else {
                        class57.field404[++class387.field4452 - 1] = class362.method6664(var17);
                     }
                  }

                  return 1;
               } else {
                  var16 = var15.length / var28.length;
                  if (var6 >= 0 && var6 < var16) {
                     for(var17 = var13; var17 < var14; ++var17) {
                        int var18 = var28.length * var6 + var17;
                        class451 var19 = class213.method4117(var28[var17]);
                        if (class451.field4850 == var19) {
                           class57.field405[++class126.field1220 - 1] = (String)var15[var18];
                        } else {
                           class57.field404[++class387.field4452 - 1] = (Integer)var15[var18];
                        }
                     }

                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               }
            } else if (var0 == 7503) {
               class387.field4452 -= 2;
               var4 = class57.field404[class387.field4452];
               var21 = class57.field404[1 + class387.field4452];
               var6 = 0;
               var23 = class444.method7135(var21);
               var8 = class444.method6191(var21);
               class452 var24 = class154.method2596(var4);
               class458 var10 = class28.method412(var23);
               int[] var11 = var10.field4872[var8];
               Object[] var12 = var24.method7982(var8);
               if (null == var12 && null != var10.field4874) {
                  var12 = var10.field4874[var8];
               }

               if (null != var12) {
                  var6 = var12.length / var11.length;
               }

               class57.field404[++class387.field4452 - 1] = var6;
               return 1;
            } else if (var0 != 7504 && 7510 != var0) {
               if (var0 == 7505) {
                  var4 = class57.field404[--class387.field4452];
                  class452 var22 = class154.method2596(var4);
                  class57.field404[++class387.field4452 - 1] = var22.field4855;
                  return 1;
               } else if (7506 == var0) {
                  var4 = class57.field404[--class387.field4452];
                  var21 = -1;
                  if (null != class73.field605 && var4 >= 0 && var4 < class73.field605.size()) {
                     var21 = (Integer)class73.field605.get(var4);
                  }

                  class57.field404[++class387.field4452 - 1] = var21;
                  return 1;
               } else if (var0 != 7507 && 7509 != var0) {
                  return 2;
               } else {
                  var4 = class57.field404[--class387.field4452];
                  var5 = class57.method1287(var4);
                  var6 = class57.field404[--class387.field4452];
                  var7 = class213.method4118(var6);
                  if (null == var7) {
                     throw new RuntimeException();
                  } else if (class444.method7135(var6) != client.field1928) {
                     throw new RuntimeException();
                  } else if (class73.field605 == null && class73.field605.isEmpty()) {
                     throw new RuntimeException();
                  } else {
                     var8 = class444.method1425(var6);
                     List var9 = var7.method8091(var5, var8);
                     class73.field605 = new LinkedList(class73.field605);
                     if (var9 != null) {
                        class73.field605.retainAll(var9);
                     } else {
                        class73.field605.clear();
                     }

                     class92.field890 = class73.field605.iterator();
                     if (var0 == 7507) {
                        class57.field404[++class387.field4452 - 1] = class73.field605.size();
                     }

                     return 1;
                  }
               }
            } else {
               --class387.field4452;
               var4 = class57.field404[class387.field4452];
               class459 var20 = class175.method2752(var4);
               if (var20 == null) {
                  throw new RuntimeException();
               } else {
                  class73.field605 = var20.method8091(0, 0);
                  var6 = 0;
                  if (null != class73.field605) {
                     client.field1928 = var4;
                     class92.field890 = class73.field605.iterator();
                     var6 = class73.field605.size();
                  }

                  if (var0 == 7504) {
                     class57.field404[++class387.field4452 - 1] = var6;
                  }

                  return 1;
               }
            }
         } else {
            if (null != class92.field890 && class92.field890.hasNext()) {
               class57.field404[++class387.field4452 - 1] = (Integer)class92.field890.next();
            } else {
               class57.field404[++class387.field4452 - 1] = -1;
            }

            return 1;
         }
      } else {
         var4 = class57.field404[--class387.field4452];
         var5 = class57.method1287(var4);
         var6 = class57.field404[--class387.field4452];
         var7 = class213.method4118(var6);
         if (null == var7) {
            throw new RuntimeException();
         } else {
            var8 = class444.method1425(var6);
            class73.field605 = var7.method8091(var5, var8);
            if (class73.field605 != null) {
               client.field1928 = class444.method7135(var6);
               class92.field890 = class73.field605.iterator();
               if (var0 == 7500) {
                  class57.field404[++class387.field4452 - 1] = class73.field605.size();
               }
            } else {
               client.field1928 = -1;
               class92.field890 = null;
               if (var0 == 7500) {
                  class57.field404[++class387.field4452 - 1] = 0;
               }
            }

            return 1;
         }
      }
   }
}
