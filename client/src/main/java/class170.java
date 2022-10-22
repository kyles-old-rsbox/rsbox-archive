import java.io.File;
import java.util.Hashtable;

public class class170 {
   static boolean field1543 = false;
   static File field1539;
   static Hashtable field1538 = new Hashtable(16);
   static long field1540;

   class170() throws Throwable {
      throw new Error();
   }

   public static void method2291(File var0) {
      field1539 = var0;
      if (!field1539.exists()) {
         throw new RuntimeException("");
      } else {
         field1543 = true;
      }
   }
}
