import java.util.Iterator;

class class468 implements Iterator {
   static String[] field4925;
   int field4922;
   // $FF: synthetic field
   final class448 this$0;

   class468(class448 var1) {
      this.this$0 = var1;
   }

   public boolean hasNext() {
      return this.field4922 < this.this$0.method7210();
   }

   public Object next() {
      int var1 = ++this.field4922 - 1;
      class391 var2 = (class391)this.this$0.field4799.method5177((long)var1);
      return null != var2 ? var2 : this.this$0.method7952(var1);
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
