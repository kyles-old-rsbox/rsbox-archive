import java.applet.Applet;
import netscape.javascript.JSObject;

public class class40 {
   class40() throws Throwable {
      throw new Error();
   }

   public static Object method756(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   public static Object method760(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
