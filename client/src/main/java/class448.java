import java.util.Iterator;

public class class448 extends class399 implements class281 {
   final class265 field4799 = new class265(64);
   final class319 field4800;
   final int field4798;

   public class448(class329 var1, int var2, class353 var3, class319 var4) {
      super(var1, var3, null != var4 ? var4.method6091(var2) : 0);
      this.field4800 = var4;
      this.field4798 = var2;
   }

   protected class416 method7217(int var1) {
      synchronized(this.field4799) {
         class391 var3 = (class391)this.field4799.method5177((long)var1);
         if (var3 == null) {
            var3 = this.method7952(var1);
            this.field4799.method5174(var3, (long)var1);
         }

         return var3;
      }
   }

   class391 method7952(int var1) {
      byte[] var3 = this.field4800.method6167(this.field4798, var1);
      class391 var4 = new class391(var1);
      if (null != var3) {
         var4.method7547(new class460(var3));
      }

      return var4;
   }

   public void method7951() {
      synchronized(this.field4799) {
         this.field4799.method5185();
      }
   }

   public Iterator iterator() {
      return new class468(this);
   }
}
