import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class class456 implements class417 {
   Map field4869;
   final class482 field4870;

   public class456(class482 var1) {
      this.field4870 = var1;
   }

   public int method7562(int var1) {
      if (this.field4869 != null) {
         class474 var3 = (class474)this.field4869.get(var1);
         if (null != var3) {
            return (Integer)var3.field4963;
         }
      }

      return (Integer)this.field4870.method8724(var1);
   }

   public void method7559(int var1, Object var2) {
      if (this.field4869 == null) {
         this.field4869 = new HashMap();
         this.field4869.put(var1, new class474(var1, var2));
      } else {
         class474 var4 = (class474)this.field4869.get(var1);
         if (null == var4) {
            this.field4869.put(var1, new class474(var1, var2));
         } else {
            var4.field4963 = var2;
         }
      }

   }

   public Iterator iterator() {
      return this.field4869 == null ? Collections.emptyList().iterator() : this.field4869.values().iterator();
   }
}
