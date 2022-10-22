public class class50 {
   int field353;
   int field355;
   int[] field352;
   int[] field354;

   class50() {
      VorbisSample.readBits(16);
      this.field353 = VorbisSample.method1299() != 0 ? VorbisSample.readBits(4) + 1 : 1;
      if (VorbisSample.method1299() != 0) {
         VorbisSample.readBits(8);
      }

      VorbisSample.readBits(2);
      if (this.field353 > 1) {
         this.field355 = VorbisSample.readBits(4);
      }

      this.field352 = new int[this.field353];
      this.field354 = new int[this.field353];

      for(int var1 = 0; var1 < this.field353; ++var1) {
         VorbisSample.readBits(8);
         this.field352[var1] = VorbisSample.readBits(8);
         this.field354[var1] = VorbisSample.readBits(8);
      }

   }
}
