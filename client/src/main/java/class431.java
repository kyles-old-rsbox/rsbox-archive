import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class class431 implements class419 {
   public static class460 field4704;
   final Map field4703;

   public class431(Map var1) {
      this.field4703 = var1;
   }

   public byte[] method7565() throws UnsupportedEncodingException {
      return this.method7841().getBytes("UTF-8");
   }

   public String method7841() throws UnsupportedEncodingException {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = this.field4703.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         String var5 = URLEncoder.encode((String)var4.getKey(), "UTF-8");
         String var6 = URLEncoder.encode((String)var4.getValue(), "UTF-8");
         var2.append(var5).append("=").append(var6).append("&");
      }

      if (var2.length() == 0) {
         return "";
      } else {
         var2.deleteCharAt(var2.length() - 1);
         var2.insert(0, "?");
         return var2.toString();
      }
   }
}
