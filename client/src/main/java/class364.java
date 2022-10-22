import java.util.Iterator;

public class class364 implements Iterator {
   class355 field4326;
   class437 field4325 = null;
   class437 field4327;

   class364(class355 var1) {
      this.field4326 = var1;
      this.field4327 = this.field4326.field4305.field4724;
      this.field4325 = null;
   }

   public Object next() {
      class437 var1 = this.field4327;
      if (var1 == this.field4326.field4305) {
         var1 = null;
         this.field4327 = null;
      } else {
         this.field4327 = var1.field4724;
      }

      this.field4325 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field4327 != this.field4326.field4305;
   }

   public void remove() {
      if (this.field4325 == null) {
         throw new IllegalStateException();
      } else {
         this.field4325.method7882();
         this.field4325 = null;
      }
   }
}
