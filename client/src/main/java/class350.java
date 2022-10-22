import java.util.Collection;
import java.util.Iterator;

public class class350 implements Iterable, Collection {
   class427 field4272 = new class427();
   class427 field4273;

   public class350() {
      this.field4272.field4682 = this.field4272;
      this.field4272.field4683 = this.field4272;
   }

   public void method6465() {
      while(this.field4272.field4682 != this.field4272) {
         this.field4272.field4682.remove();
      }

   }

   public void method6454(class427 var1) {
      if (var1.field4683 != null) {
         var1.remove();
      }

      var1.field4683 = this.field4272.field4683;
      var1.field4682 = this.field4272;
      var1.field4683.field4682 = var1;
      var1.field4682.field4683 = var1;
   }

   public void method6455(class427 var1) {
      if (var1.field4683 != null) {
         var1.remove();
      }

      var1.field4683 = this.field4272;
      var1.field4682 = this.field4272.field4682;
      var1.field4683.field4682 = var1;
      var1.field4682.field4683 = var1;
   }

   public static void method6468(class427 var0, class427 var1) {
      if (var0.field4683 != null) {
         var0.remove();
      }

      var0.field4683 = var1;
      var0.field4682 = var1.field4682;
      var0.field4683.field4682 = var0;
      var0.field4682.field4683 = var0;
   }

   public class427 method6457() {
      return this.method6458((class427)null);
   }

   class427 method6458(class427 var1) {
      class427 var2;
      if (var1 == null) {
         var2 = this.field4272.field4682;
      } else {
         var2 = var1;
      }

      if (var2 == this.field4272) {
         this.field4273 = null;
         return null;
      } else {
         this.field4273 = var2.field4682;
         return var2;
      }
   }

   public class427 method6459() {
      class427 var1 = this.field4273;
      if (var1 == this.field4272) {
         this.field4273 = null;
         return null;
      } else {
         this.field4273 = var1.field4682;
         return var1;
      }
   }

   int method6479() {
      int var1 = 0;

      for(class427 var2 = this.field4272.field4682; var2 != this.field4272; var2 = var2.field4682) {
         ++var1;
      }

      return var1;
   }

   public boolean method6524() {
      return this.field4272.field4682 == this.field4272;
   }

   class427[] method6462() {
      class427[] var1 = new class427[this.method6479()];
      int var2 = 0;

      for(class427 var3 = this.field4272.field4682; var3 != this.field4272; var3 = var3.field4682) {
         var1[var2++] = var3;
      }

      return var1;
   }

   public Iterator iterator() {
      return new class358(this);
   }

   public int size() {
      return this.method6479();
   }

   public boolean isEmpty() {
      return this.method6524();
   }

   public boolean contains(Object var1) {
      throw new RuntimeException();
   }

   public Object[] toArray() {
      return this.method6462();
   }

   @Override
   public boolean add(Object o) {
      return false;
   }

   public Object[] toArray(Object[] var1) {
      int var2 = 0;

      for(class427 var3 = this.field4272.field4682; var3 != this.field4272; var3 = var3.field4682) {
         var1[var2++] = var3;
      }

      return var1;
   }

   boolean method6461(class427 var1) {
      this.method6454(var1);
      return true;
   }

   public boolean remove(Object var1) {
      throw new RuntimeException();
   }

   public boolean containsAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean addAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean removeAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean retainAll(Collection var1) {
      throw new RuntimeException();
   }

   public void clear() {
      this.method6465();
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int hashCode() {
      return super.hashCode();
   }
}
