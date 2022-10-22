public class class190 implements class29 {
   boolean field2015 = false;
   boolean field2016 = false;
   class300 field2014 = null;

   public void method3515(class300 var1) {
      this.method3521();
      if (null != var1) {
         this.field2014 = var1;
         class310 var3 = var1.method5872();
         if (null != var3) {
            var3.field3690.method5552(true);
            if (var3.field3684 != null) {
               class79 var4 = new class79();
               var4.method1599(var1);
               var4.method1602(var3.field3684);
               client.method7844().method6347(var4);
            }
         }
      }

   }

   public class300 method3516() {
      return this.field2014;
   }

   public void method3521() {
      if (this.field2014 != null) {
         class310 var2 = this.field2014.method5872();
         class300 var3 = this.field2014;
         this.field2014 = null;
         if (null != var2) {
            var2.field3690.method5552(false);
            if (null != var2.field3684) {
               class79 var4 = new class79();
               var4.method1599(var3);
               var4.method1602(var2.field3684);
               client.method7844().method6347(var4);
            }

         }
      }
   }

   public boolean method424(int var1) {
      if (null == this.field2014) {
         return false;
      } else {
         class34 var3 = this.field2014.method5871();
         if (var3 == null) {
            return false;
         } else {
            if (var3.method638(var1)) {
               switch(var1) {
               case 81:
                  this.field2016 = true;
                  break;
               case 82:
                  this.field2015 = true;
                  break;
               default:
                  if (this.method3517(var1)) {
                     class136.method2438(this.field2014);
                  }
               }
            }

            return var3.method619(var1);
         }
      }
   }

   public boolean method414(int var1) {
      switch(var1) {
      case 81:
         this.field2016 = false;
         return false;
      case 82:
         this.field2015 = false;
         return false;
      default:
         return false;
      }
   }

   public boolean method415(char var1) {
      if (null == this.field2014) {
         return false;
      } else if (!class279.method5389(var1)) {
         return false;
      } else {
         class297 var3 = this.field2014.method5869();
         if (var3 != null && var3.method5691()) {
            class34 var4 = this.field2014.method5871();
            if (null == var4) {
               return false;
            } else {
               if (var4.method635(var1) && var3.method5569(var1)) {
                  class136.method2438(this.field2014);
               }

               return var4.method620(var1);
            }
         } else {
            return false;
         }
      }
   }

   public boolean method416(boolean var1) {
      return false;
   }

   boolean method3517(int var1) {
      if (null == this.field2014) {
         return false;
      } else {
         class297 var3 = this.field2014.method5869();
         if (null != var3 && var3.method5691()) {
            switch(var1) {
            case 13:
               this.method3521();
               return true;
            case 48:
               if (this.field2015) {
                  var3.method5555();
               }

               return true;
            case 65:
               if (this.field2015) {
                  var3.method5594(client.method778());
               }

               return true;
            case 66:
               if (this.field2015) {
                  var3.method5625(client.method778());
               }

               return true;
            case 67:
               if (this.field2015) {
                  var3.method5639(client.method778());
               }

               return true;
            case 84:
               if (var3.method5614() == 0) {
                  var3.method5569(10);
               } else if (this.field2016 && var3.method5618()) {
                  var3.method5569(10);
               } else {
                  class310 var4 = this.field2014.method5872();
                  class79 var5 = new class79();
                  var5.method1599(this.field2014);
                  var5.method1602(var4.field3687);
                  client.method7844().method6347(var5);
                  this.method3521();
               }

               return true;
            case 85:
               if (this.field2015) {
                  var3.method5572();
               } else {
                  var3.method5608();
               }

               return true;
            case 96:
               if (this.field2015) {
                  var3.method5583(this.field2016);
               } else {
                  var3.method5813(this.field2016);
               }

               return true;
            case 97:
               if (this.field2015) {
                  var3.method5584(this.field2016);
               } else {
                  var3.method5571(this.field2016);
               }

               return true;
            case 98:
               if (this.field2015) {
                  var3.method5702();
               } else {
                  var3.method5671(this.field2016);
               }

               return true;
            case 99:
               if (this.field2015) {
                  var3.method5589();
               } else {
                  var3.method5795(this.field2016);
               }

               return true;
            case 101:
               if (this.field2015) {
                  var3.method5738();
               } else {
                  var3.method5657();
               }

               return true;
            case 102:
               if (this.field2015) {
                  var3.method5652(this.field2016);
               } else {
                  var3.method5577(this.field2016);
               }

               return true;
            case 103:
               if (this.field2015) {
                  var3.method5610(this.field2016);
               } else {
                  var3.method5638(this.field2016);
               }

               return true;
            case 104:
               if (this.field2015) {
                  var3.method5722(this.field2016);
               } else {
                  var3.method5553(this.field2016);
               }

               return true;
            case 105:
               if (this.field2015) {
                  var3.method5590(this.field2016);
               } else {
                  var3.method5588(this.field2016);
               }

               return true;
            default:
               return false;
            }
         } else {
            return false;
         }
      }
   }

   static final void method3532(String var0) {
      if (!var0.equals("")) {
         class263 var2 = class185.method3435(class274.field3049, client.field1778.field1071);
         var2.field2984.method8097(class460.method1887(var0));
         var2.field2984.method8104(var0);
         client.field1778.method2078(var2);
      }
   }

   static final void method3514(int var0, int var1) {
      if (client.field1883[var0] != null) {
         if (var1 >= 0 && var1 < client.field1883[var0].method2512()) {
            class133 var3 = (class133)client.field1883[var0].field1347.get(var1);
            if (var3.field1256 == -1) {
               class263 var4 = class185.method3435(class274.field3114, client.field1778.field1071);
               var4.field2984.method8097(3 + class460.method1887(var3.field1254.method8444()));
               var4.field2984.method8097(var0);
               var4.field2984.method8174(var1);
               var4.field2984.method8104(var3.field1254.method8444());
               client.field1778.method2078(var4);
            }
         }
      }
   }

   static int method3528(class300 var0) {
      class426 var2 = (class426)client.field1785.get((long)var0.field3484 + ((long)var0.field3517 << 32));
      return null != var2 ? var2.field4680 : var0.field3527;
   }
}
