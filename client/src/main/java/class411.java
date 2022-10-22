import java.net.URL;

public class class411 implements class432 {
   public final class417 field4557;

   public class411(class399 var1) {
      this(new class456(var1));
   }

   class411(class456 var1) {
      this.field4557 = var1;
   }

   public int method7405(int var1) {
      return this.field4557.method7562(var1);
   }

   static boolean method7404(String var0, int var1, String var2) {
      if (var1 == 0) {
         try {
            if (!class30.field157.startsWith("win")) {
               throw new Exception();
            } else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var5 = 0; var5 < var0.length(); ++var5) {
                  if (var11.indexOf(var0.charAt(var5)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var6) {
            return false;
         }
      } else if (var1 == 1) {
         try {
            Object var4 = class40.method760(class30.field156, var2, new Object[]{(new URL(class30.field156.getCodeBase(), var0)).toString()});
            return null != var4;
         } catch (Throwable var7) {
            return false;
         }
      } else if (var1 == 2) {
         try {
            class30.field156.getAppletContext().showDocument(new URL(class30.field156.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else if (3 == var1) {
         try {
            class40.method756(class30.field156, "loggedout");
         } catch (Throwable var10) {
         }

         try {
            class30.field156.getAppletContext().showDocument(new URL(class30.field156.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var9) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
