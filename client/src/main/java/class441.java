import java.util.Iterator;

public class class441 implements Iterator {
   class421 field4764;
   class427 field4765;
   class427 field4767 = null;
   int field4766;

   class441(class421 var1) {
      this.field4764 = var1;
      this.method7899();
   }

   void method7899() {
      this.field4765 = this.field4764.field4667[0].field4682;
      this.field4766 = 1;
      this.field4767 = null;
   }

   public Object next() {
      class427 var1;
      if (this.field4765 != this.field4764.field4667[this.field4766 - 1]) {
         var1 = this.field4765;
         this.field4765 = var1.field4682;
         this.field4767 = var1;
         return var1;
      } else {
         do {
            if (this.field4766 >= this.field4764.field4664) {
               return null;
            }

            var1 = this.field4764.field4667[this.field4766++].field4682;
         } while(var1 == this.field4764.field4667[this.field4766 - 1]);

         this.field4765 = var1.field4682;
         this.field4767 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if (this.field4765 != this.field4764.field4667[this.field4766 - 1]) {
         return true;
      } else {
         while(this.field4766 < this.field4764.field4664) {
            if (this.field4764.field4667[this.field4766++].field4682 != this.field4764.field4667[this.field4766 - 1]) {
               this.field4765 = this.field4764.field4667[this.field4766 - 1].field4682;
               return true;
            }

            this.field4765 = this.field4764.field4667[this.field4766 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if (this.field4767 == null) {
         throw new IllegalStateException();
      } else {
         this.field4767.remove();
         this.field4767 = null;
      }
   }
}
