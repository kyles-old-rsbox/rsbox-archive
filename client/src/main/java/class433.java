import java.util.HashMap;

public class class433 {
   class319 field4705;
   class319 field4706;
   HashMap field4707;

   public class433(class319 var1, class319 var2) {
      this.field4706 = var1;
      this.field4705 = var2;
      this.field4707 = new HashMap();
   }

   public HashMap method7846(class442[] var1) {
      HashMap var3 = new HashMap();
      class442[] var4 = var1;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class442 var6 = var4[var5];
         if (this.field4707.containsKey(var6)) {
            var3.put(var6, this.field4707.get(var6));
         } else {
            class376 var7 = class111.method2143(this.field4706, this.field4705, var6.field4774, "");
            if (null != var7) {
               this.field4707.put(var6, var7);
               var3.put(var6, var7);
            }
         }
      }

      return var3;
   }
}
