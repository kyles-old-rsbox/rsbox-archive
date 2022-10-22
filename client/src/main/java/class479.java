public final class class479 {
   int field4983;
   int field4985;
   int field4989;
   int field4991;
   int[] field4986 = new int[256];
   int[] field4990 = new int[256];

   public class479(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field4986[var2] = var1[var2];
      }

      this.method8624();
   }

   public final int method8632() {
      if (this.field4985 == 0) {
         this.method8626();
         this.field4985 = 256;
      }

      return this.field4986[--this.field4985];
   }

   public final int method8625() {
      if (this.field4985 == 0) {
         this.method8626();
         this.field4985 = 256;
      }

      return this.field4986[this.field4985 - 1];
   }

   final void method8626() {
      this.field4983 += ++this.field4991;

      for(int var2 = 0; var2 < 256; ++var2) {
         int var3 = this.field4990[var2];
         if ((var2 & 2) == 0) {
            if (0 == (var2 & 1)) {
               this.field4989 ^= this.field4989 << 13;
            } else {
               this.field4989 ^= this.field4989 >>> 6;
            }
         } else if ((var2 & 1) == 0) {
            this.field4989 ^= this.field4989 << 2;
         } else {
            this.field4989 ^= this.field4989 >>> 16;
         }

         this.field4989 += this.field4990[var2 + 128 & 255];
         int var4;
         this.field4990[var2] = var4 = this.field4989 + this.field4990[(var3 & 1020) >> 2] + this.field4983;
         this.field4986[var2] = this.field4983 = var3 + this.field4990[(var4 >> 8 & 1020) >> 2];
      }

   }

   final void method8624() {
      int var10 = -1640531527;
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;

      int var2;
      for(var2 = 0; var2 < 4; ++var2) {
         var3 ^= var4 << 11;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 >>> 2;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 << 8;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 >>> 16;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 << 10;
         var10 += var7;
         var8 += var9;
         var8 ^= var9 >>> 4;
         var3 += var8;
         var9 += var10;
         var9 ^= var10 << 8;
         var4 += var9;
         var10 += var3;
         var10 ^= var3 >>> 9;
         var5 += var10;
         var3 += var4;
      }

      for(var2 = 0; var2 < 256; var2 += 8) {
         var3 += this.field4986[var2];
         var4 += this.field4986[1 + var2];
         var5 += this.field4986[var2 + 2];
         var6 += this.field4986[var2 + 3];
         var7 += this.field4986[var2 + 4];
         var8 += this.field4986[var2 + 5];
         var9 += this.field4986[6 + var2];
         var10 += this.field4986[7 + var2];
         var3 ^= var4 << 11;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 >>> 2;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 << 8;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 >>> 16;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 << 10;
         var10 += var7;
         var8 += var9;
         var8 ^= var9 >>> 4;
         var3 += var8;
         var9 += var10;
         var9 ^= var10 << 8;
         var4 += var9;
         var10 += var3;
         var10 ^= var3 >>> 9;
         var5 += var10;
         var3 += var4;
         this.field4990[var2] = var3;
         this.field4990[1 + var2] = var4;
         this.field4990[2 + var2] = var5;
         this.field4990[var2 + 3] = var6;
         this.field4990[var2 + 4] = var7;
         this.field4990[var2 + 5] = var8;
         this.field4990[var2 + 6] = var9;
         this.field4990[7 + var2] = var10;
      }

      for(var2 = 0; var2 < 256; var2 += 8) {
         var3 += this.field4990[var2];
         var4 += this.field4990[1 + var2];
         var5 += this.field4990[var2 + 2];
         var6 += this.field4990[var2 + 3];
         var7 += this.field4990[4 + var2];
         var8 += this.field4990[var2 + 5];
         var9 += this.field4990[var2 + 6];
         var10 += this.field4990[var2 + 7];
         var3 ^= var4 << 11;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 >>> 2;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 << 8;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 >>> 16;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 << 10;
         var10 += var7;
         var8 += var9;
         var8 ^= var9 >>> 4;
         var3 += var8;
         var9 += var10;
         var9 ^= var10 << 8;
         var4 += var9;
         var10 += var3;
         var10 ^= var3 >>> 9;
         var5 += var10;
         var3 += var4;
         this.field4990[var2] = var3;
         this.field4990[var2 + 1] = var4;
         this.field4990[var2 + 2] = var5;
         this.field4990[3 + var2] = var6;
         this.field4990[4 + var2] = var7;
         this.field4990[5 + var2] = var8;
         this.field4990[var2 + 6] = var9;
         this.field4990[7 + var2] = var10;
      }

      this.method8626();
      this.field4985 = 256;
   }
}
