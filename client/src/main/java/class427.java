public class class427 {
   public class427 field4682;
   public class427 field4683;
   public long field4681;

   public void remove() {
      if (this.field4683 != null) {
         this.field4683.field4682 = this.field4682;
         this.field4682.field4683 = this.field4683;
         this.field4682 = null;
         this.field4683 = null;
      }
   }

   public boolean method7819() {
      return this.field4683 != null;
   }
}
