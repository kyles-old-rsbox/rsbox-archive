public class class84 implements Runnable {
   static class488 field745;
   static class488 field749;
   static class488[] field752;
   boolean field746 = true;
   int field747 = 0;
   int[] field748 = new int[500];
   int[] field750 = new int[500];
   Object field755 = new Object();
   long[] field754 = new long[500];

   class84() {
   }

   public void run() {
      for(; this.field746; class266.method3531(50L)) {
         synchronized(this.field755) {
            if (this.field747 < 500) {
               this.field748[this.field747] = class42.field284;
               this.field750[this.field747] = class42.field285;
               this.field754[this.field747] = class42.field286;
               ++this.field747;
            }
         }
      }

   }
}
