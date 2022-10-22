import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public final class class366 {
   final class342 field4337;
   final class342 field4339;
   final class387 field4341;
   final int field4343;
   final Comparator field4342;
   final Map field4338;
   final long field4340;

   public class366(int var1, class387 var2) {
      this(-1L, var1, var2);
   }

   class366(long var1, int var3, class387 var4) {
      this.field4342 = new class374(this);
      this.field4340 = var1;
      this.field4343 = var3;
      this.field4341 = var4;
      if (this.field4343 == -1) {
         this.field4338 = new HashMap(64);
         this.field4337 = new class342(64, this.field4342);
         this.field4339 = null;
      } else {
         if (this.field4341 == null) {
            throw new IllegalArgumentException("");
         }

         this.field4338 = new HashMap(this.field4343);
         this.field4337 = new class342(this.field4343, this.field4342);
         this.field4339 = new class342(this.field4343);
      }

   }

   boolean method6683() {
      return this.field4343 != -1;
   }

   public Object method6677(Object var1) {
      synchronized(this) {
         if (this.field4340 != -1L) {
            this.method6680();
         }

         class371 var4 = (class371)this.field4338.get(var1);
         if (var4 == null) {
            return null;
         } else {
            this.method6684(var4, false);
            return var4.field4374;
         }
      }
   }

   public Object method6678(Object var1, Object var2) {
      synchronized(this) {
         if (this.field4340 != -1L) {
            this.method6680();
         }

         class371 var5 = (class371)this.field4338.get(var1);
         if (var5 != null) {
            Object var9 = var5.field4374;
            var5.field4374 = var2;
            this.method6684(var5, false);
            return var9;
         } else {
            class371 var6;
            if (this.method6683() && this.field4338.size() == this.field4343) {
               var6 = (class371)this.field4339.remove();
               this.field4338.remove(var6.field4370);
               this.field4337.remove(var6);
            }

            var6 = new class371(var2, var1);
            this.field4338.put(var1, var6);
            this.method6684(var6, true);
            return null;
         }
      }
   }

   void method6684(class371 var1, boolean var2) {
      if (!var2) {
         this.field4337.remove(var1);
         if (this.method6683() && !this.field4339.remove(var1)) {
            throw new IllegalStateException("");
         }
      }

      var1.field4371 = System.currentTimeMillis();
      if (this.method6683()) {
         switch(this.field4341.field4454) {
         case 0:
            var1.field4373 = var1.field4371;
            break;
         case 1:
            ++var1.field4373;
         }

         this.field4339.add(var1);
      }

      this.field4337.add(var1);
   }

   void method6680() {
      if (this.field4340 == -1L) {
         throw new IllegalStateException("");
      } else {
         long var2 = System.currentTimeMillis() - this.field4340;

         while(!this.field4337.isEmpty()) {
            class371 var4 = (class371)this.field4337.peek();
            if (var4.field4371 >= var2) {
               return;
            }

            this.field4338.remove(var4.field4370);
            this.field4337.remove(var4);
            if (this.method6683()) {
               this.field4339.remove(var4);
            }
         }

      }
   }
}
