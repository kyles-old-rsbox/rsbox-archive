public class class474 {
   public Object field4963;
   public final int field4965;

   public class474(int var1) {
      this.field4965 = var1;
   }

   public class474(int var1, Object var2) {
      this.field4965 = var1;
      this.field4963 = var2;
   }

   public int hashCode() {
      return super.hashCode();
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof class474)) {
         return false;
      } else {
         class474 var2 = (class474)var1;
         if (null == var2.field4963 && this.field4963 != null) {
            return false;
         } else if (null == this.field4963 && var2.field4963 != null) {
            return false;
         } else {
            return var2.field4965 == this.field4965 && var2.field4963.equals(this.field4963);
         }
      }
   }
}
