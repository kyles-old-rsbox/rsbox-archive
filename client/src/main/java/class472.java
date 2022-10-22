public class class472 implements Comparable {
   String field4948;
   String field4949;

   public class472(String var1) {
      this.field4948 = var1;
      class463 var4 = class463.field4894;
      String var3;
      if (var1 == null) {
         var3 = null;
      } else {
         label125: {
            int var5 = 0;

            int var6;
            boolean var7;
            char var8;
            for(var6 = var1.length(); var5 < var6; ++var5) {
               var8 = var1.charAt(var5);
               var7 = var8 == 160 || var8 == ' ' || var8 == '_' || '-' == var8;
               if (!var7) {
                  break;
               }
            }

            while(var6 > var5) {
               var8 = var1.charAt(var6 - 1);
               var7 = var8 == 160 || var8 == ' ' || '_' == var8 || '-' == var8;
               if (!var7) {
                  break;
               }

               --var6;
            }

            int var15 = var6 - var5;
            if (var15 >= 1) {
               byte var9;
               if (null == var4) {
                  var9 = 12;
               } else {
                  switch(var4.field4890) {
                  case 3:
                     var9 = 20;
                     break;
                  default:
                     var9 = 12;
                  }
               }

               if (var15 <= var9) {
                  StringBuilder var16 = new StringBuilder(var15);

                  for(int var17 = var5; var17 < var6; ++var17) {
                     char var10 = var1.charAt(var17);
                     boolean var11;
                     if (Character.isISOControl(var10)) {
                        var11 = false;
                     } else if (class148.method2543(var10)) {
                        var11 = true;
                     } else {
                        char[] var12 = class462.field4888;
                        int var13 = 0;

                        label78:
                        while(true) {
                           char var14;
                           if (var13 >= var12.length) {
                              var12 = class462.field4889;

                              for(var13 = 0; var13 < var12.length; ++var13) {
                                 var14 = var12[var13];
                                 if (var14 == var10) {
                                    var11 = true;
                                    break label78;
                                 }
                              }

                              var11 = false;
                              break;
                           }

                           var14 = var12[var13];
                           if (var10 == var14) {
                              var11 = true;
                              break;
                           }

                           ++var13;
                        }
                     }

                     if (var11) {
                        char var18 = class462.method687(var10);
                        if (var18 != 0) {
                           var16.append(var18);
                        }
                     }
                  }

                  if (var16.length() == 0) {
                     var3 = null;
                  } else {
                     var3 = var16.toString();
                  }
                  break label125;
               }
            }

            var3 = null;
         }
      }

      this.field4949 = var3;
   }

   public class472(String var1, class463 var2) {
      this.field4948 = var1;
      String var4;
      if (null == var1) {
         var4 = null;
      } else {
         label125: {
            int var5 = 0;

            int var6;
            boolean var7;
            char var8;
            for(var6 = var1.length(); var5 < var6; ++var5) {
               var8 = var1.charAt(var5);
               var7 = 160 == var8 || ' ' == var8 || var8 == '_' || '-' == var8;
               if (!var7) {
                  break;
               }
            }

            while(var6 > var5) {
               var8 = var1.charAt(var6 - 1);
               var7 = var8 == 160 || var8 == ' ' || '_' == var8 || var8 == '-';
               if (!var7) {
                  break;
               }

               --var6;
            }

            int var15 = var6 - var5;
            if (var15 >= 1) {
               byte var9;
               if (var2 == null) {
                  var9 = 12;
               } else {
                  switch(var2.field4890) {
                  case 3:
                     var9 = 20;
                     break;
                  default:
                     var9 = 12;
                  }
               }

               if (var15 <= var9) {
                  StringBuilder var16 = new StringBuilder(var15);

                  for(int var17 = var5; var17 < var6; ++var17) {
                     char var10 = var1.charAt(var17);
                     boolean var11;
                     if (Character.isISOControl(var10)) {
                        var11 = false;
                     } else if (class148.method2543(var10)) {
                        var11 = true;
                     } else {
                        char[] var12 = class462.field4888;
                        int var13 = 0;

                        label78:
                        while(true) {
                           char var14;
                           if (var13 >= var12.length) {
                              var12 = class462.field4889;

                              for(var13 = 0; var13 < var12.length; ++var13) {
                                 var14 = var12[var13];
                                 if (var14 == var10) {
                                    var11 = true;
                                    break label78;
                                 }
                              }

                              var11 = false;
                              break;
                           }

                           var14 = var12[var13];
                           if (var14 == var10) {
                              var11 = true;
                              break;
                           }

                           ++var13;
                        }
                     }

                     if (var11) {
                        char var18 = class462.method687(var10);
                        if (0 != var18) {
                           var16.append(var18);
                        }
                     }
                  }

                  if (var16.length() == 0) {
                     var4 = null;
                  } else {
                     var4 = var16.toString();
                  }
                  break label125;
               }
            }

            var4 = null;
         }
      }

      this.field4949 = var4;
   }

   public String method8444() {
      return this.field4948;
   }

   public String method8441() {
      return this.field4949;
   }

   public boolean method8442() {
      return null != this.field4949;
   }

   public boolean equals(Object var1) {
      if (var1 instanceof class472) {
         class472 var2 = (class472)var1;
         if (null == this.field4949) {
            return var2.field4949 == null;
         } else if (null == var2.field4949) {
            return false;
         } else {
            return this.hashCode() != var2.hashCode() ? false : this.field4949.equals(var2.field4949);
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field4949 == null ? 0 : this.field4949.hashCode();
   }

   public String toString() {
      return this.method8444();
   }

   public int method8450(class472 var1) {
      if (this.field4949 == null) {
         return null == var1.field4949 ? 0 : 1;
      } else {
         return null == var1.field4949 ? -1 : this.field4949.compareTo(var1.field4949);
      }
   }

   public int compareTo(Object var1) {
      return this.method8450((class472)var1);
   }
}
