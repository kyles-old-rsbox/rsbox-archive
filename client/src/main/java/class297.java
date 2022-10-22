import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class class297 {
   static class486 field3431;
   boolean field3403 = false;
   boolean field3411 = false;
   boolean field3412 = true;
   class301 field3429;
   class301 field3430;
   class390 field3409 = new class390();
   class390 field3423 = new class390();
   int field3402 = Integer.MAX_VALUE;
   int field3413 = 0;
   int field3414 = 0;
   int field3415 = 0;
   int field3416 = Integer.MAX_VALUE;
   int field3417 = 0;
   int field3418 = 0;
   int field3419 = 0;
   int field3420 = 0;
   int field3421 = 0;
   int field3422 = Integer.MAX_VALUE;
   int field3425 = 0;
   int field3426 = 0;
   int field3427 = 0;
   int field3428 = 0;

   class297() {
      this.field3409.method7046(1);
      this.field3423.method7046(1);
   }

   void method5730() {
      this.field3413 = (1 + this.field3413) % 60;
      if (this.field3426 > 0) {
         --this.field3426;
      }

   }

   public boolean method5552(boolean var1) {
      var1 = var1 && this.field3412;
      boolean var3 = this.field3411 != var1;
      this.field3411 = var1;
      if (!this.field3411) {
         this.method5576(this.field3418, this.field3418);
      }

      return var3;
   }

   public void method5628(boolean var1) {
      this.field3412 = var1;
      this.field3411 = var1 && this.field3411;
   }

   boolean method5554(String var1) {
      String var3 = this.field3409.method7021();
      if (!var3.equals(var1)) {
         var1 = this.method5662(var1);
         this.field3409.method7036(var1);
         this.method5731(this.field3427, this.field3428);
         this.method5624();
         this.method5629();
         return true;
      } else {
         return false;
      }
   }

   boolean method5575(String var1) {
      this.field3423.method7036(var1);
      return true;
   }

   boolean method5556(class384 var1) {
      boolean var3 = !this.field3403;
      this.field3409.method7029(var1);
      this.field3423.method7029(var1);
      this.field3403 = true;
      var3 |= this.method5731(this.field3427, this.field3428);
      var3 |= this.method5576(this.field3419, this.field3418);
      if (this.method5624()) {
         this.method5629();
         var3 = true;
      }

      return var3;
   }

   public boolean method5557(int var1, int var2) {
      boolean var4 = this.field3425 != var1 || var2 != this.field3415;
      this.field3425 = var1;
      this.field3415 = var2;
      var4 |= this.method5731(this.field3427, this.field3428);
      return var4;
   }

   public boolean method5558(int var1) {
      if (var1 < 0) {
         var1 = Integer.MAX_VALUE;
      }

      boolean var3 = var1 == this.field3409.method7047();
      this.field3409.method7027(var1, true);
      this.field3423.method7027(var1, true);
      if (this.method5624()) {
         this.method5629();
         var3 = true;
      }

      return var3;
   }

   public boolean method5559(int var1) {
      if (var1 < 0) {
         this.field3422 = Integer.MAX_VALUE;
      } else {
         this.field3422 = var1;
      }

      if (this.method5624()) {
         this.method5629();
         return true;
      } else {
         return false;
      }
   }

   public boolean method5560(int var1) {
      this.field3416 = var1;
      if (this.method5624()) {
         this.method5629();
         return true;
      } else {
         return false;
      }
   }

   public boolean method5731(int var1, int var2) {
      if (!this.method5691()) {
         this.field3427 = var1;
         this.field3428 = var2;
         return false;
      } else {
         int var4 = this.field3427;
         int var5 = this.field3428;
         int var6 = Math.max(0, this.field3409.method7042() - this.field3425 + 2);
         int var7 = Math.max(0, this.field3409.method7110() - this.field3415 + 1);
         this.field3427 = Math.max(0, Math.min(var6, var1));
         this.field3428 = Math.max(0, Math.min(var7, var2));
         return this.field3427 != var4 || this.field3428 != var5;
      }
   }

   public boolean method5562(int var1, int var2) {
      return true;
   }

   public void method5563(int var1) {
      this.field3409.method7031(var1);
   }

   public void method5564(int var1) {
      this.field3414 = var1;
   }

   public void method5565(int var1) {
      this.field3409.method7046(var1);
   }

   public void method5566(int var1) {
      this.field3409.method7028(var1);
   }

   public boolean method5721(int var1) {
      this.field3417 = var1;
      String var3 = this.field3409.method7021();
      int var4 = var3.length();
      var3 = this.method5662(var3);
      if (var3.length() != var4) {
         this.field3409.method7036(var3);
         this.method5731(this.field3427, this.field3428);
         this.method5624();
         this.method5629();
         return true;
      } else {
         return false;
      }
   }

   public void method5568() {
      this.field3403 = false;
   }

   public boolean method5569(int var1) {
      if (this.method5630(var1)) {
         this.method5574();
         class385 var3 = this.field3409.method7026((char)var1, this.field3418, this.field3402, this.field3422);
         this.method5576(var3.method6951(), var3.method6951());
         this.method5624();
         this.method5629();
      }

      return true;
   }

   public void method5608() {
      if (!this.method5574() && this.field3418 > 0) {
         int var2 = this.field3409.method7038(this.field3418 - 1);
         this.method5629();
         this.method5576(var2, var2);
      }

   }

   public void method5657() {
      if (!this.method5574() && this.field3418 < this.field3409.method7084()) {
         int var2 = this.field3409.method7038(this.field3418);
         this.method5629();
         this.method5576(var2, var2);
      }

   }

   public void method5572() {
      if (!this.method5574() && this.field3418 > 0) {
         class438 var2 = this.method5622(this.field3418 - 1);
         int var3 = this.field3409.method7039((Integer)var2.field4727, this.field3418);
         this.method5629();
         this.method5576(var3, var3);
      }

   }

   public void method5738() {
      if (!this.method5574() && this.field3418 < this.field3409.method7084()) {
         class438 var2 = this.method5622(this.field3418);
         int var3 = this.field3409.method7039(this.field3418, (Integer)var2.field4728);
         this.method5629();
         this.method5576(var3, var3);
      }

   }

   boolean method5574() {
      if (!this.method5619()) {
         return false;
      } else {
         int var2 = this.field3409.method7039(this.field3419, this.field3418);
         this.method5629();
         this.method5576(var2, var2);
         return true;
      }
   }

   public void method5555() {
      this.method5576(0, this.field3409.method7084());
   }

   public boolean method5576(int var1, int var2) {
      if (!this.method5691()) {
         this.field3419 = var1;
         this.field3418 = var2;
         return false;
      } else {
         if (var1 > this.field3409.method7084()) {
            var1 = this.field3409.method7084();
         }

         if (var2 > this.field3409.method7084()) {
            var2 = this.field3409.method7084();
         }

         boolean var4 = var1 != this.field3419 || this.field3418 != var2;
         this.field3419 = var1;
         if (this.field3418 != var2) {
            this.field3418 = var2;
            this.field3413 = 0;
            this.method5579();
         }

         if (var4 && this.field3430 != null) {
            this.field3430.method5979();
         }

         return var4;
      }
   }

   public void method5577(boolean var1) {
      class438 var3 = this.method5623(this.field3418);
      this.method5689((Integer)var3.field4727, var1);
   }

   public void method5638(boolean var1) {
      class438 var3 = this.method5623(this.field3418);
      this.method5689((Integer)var3.field4728, var1);
   }

   public void method5652(boolean var1) {
      this.method5689(0, var1);
   }

   public void method5610(boolean var1) {
      this.method5689(this.field3409.method7084(), var1);
   }

   public void method5813(boolean var1) {
      if (this.method5619() && !var1) {
         this.method5689(Math.min(this.field3419, this.field3418), var1);
      } else if (this.field3418 > 0) {
         this.method5689(this.field3418 - 1, var1);
      }

   }

   public void method5571(boolean var1) {
      if (this.method5619() && !var1) {
         this.method5689(Math.max(this.field3419, this.field3418), var1);
      } else if (this.field3418 < this.field3409.method7084()) {
         this.method5689(1 + this.field3418, var1);
      }

   }

   public void method5583(boolean var1) {
      if (this.field3418 > 0) {
         class438 var3 = this.method5622(this.field3418 - 1);
         this.method5689((Integer)var3.field4727, var1);
      }

   }

   public void method5584(boolean var1) {
      if (this.field3418 < this.field3409.method7084()) {
         class438 var3 = this.method5622(1 + this.field3418);
         this.method5689((Integer)var3.field4728, var1);
      }

   }

   public void method5671(boolean var1) {
      if (this.field3418 > 0) {
         this.method5689(this.field3409.method7041(this.field3418, -1), var1);
      }

   }

   public void method5795(boolean var1) {
      if (this.field3418 < this.field3409.method7084()) {
         this.method5689(this.field3409.method7041(this.field3418, 1), var1);
      }

   }

   public void method5553(boolean var1) {
      if (this.field3418 > 0) {
         int var3 = this.method5626();
         this.method5689(this.field3409.method7041(this.field3418, -var3), var1);
      }

   }

   public void method5588(boolean var1) {
      if (this.field3418 < this.field3409.method7084()) {
         int var3 = this.method5626();
         this.method5689(this.field3409.method7041(this.field3418, var3), var1);
      }

   }

   public void method5722(boolean var1) {
      class388 var3 = this.field3409.method7032(0, this.field3418);
      class438 var4 = var3.method6990();
      this.method5689(this.field3409.method7071((Integer)var4.field4727, this.field3428), var1);
   }

   public void method5590(boolean var1) {
      class388 var3 = this.field3409.method7032(0, this.field3418);
      class438 var4 = var3.method6990();
      this.method5689(this.field3409.method7071((Integer)var4.field4727, this.field3415 + this.field3428), var1);
   }

   public void method5591(int var1, int var2, boolean var3, boolean var4) {
      boolean var6 = false;
      int var9;
      if (!this.field3403) {
         var9 = 0;
      } else {
         var1 += this.field3427;
         var2 += this.field3428;
         var9 = this.field3409.method7071(var1, var2);
      }

      class438 var7;
      if (var3 && var4) {
         this.field3421 = 1;
         var7 = this.method5622(var9);
         class438 var8 = this.method5622(this.field3420);
         this.method5621(var8, var7);
      } else if (var3) {
         this.field3421 = 1;
         var7 = this.method5622(var9);
         this.method5576((Integer)var7.field4727, (Integer)var7.field4728);
         this.field3420 = (Integer)var7.field4727;
      } else if (var4) {
         this.method5576(this.field3420, var9);
      } else {
         if (this.field3426 > 0 && this.field3420 == var9) {
            if (this.field3418 == this.field3419) {
               this.field3421 = 1;
               var7 = this.method5622(var9);
               this.method5576((Integer)var7.field4727, (Integer)var7.field4728);
            } else {
               this.field3421 = 2;
               var7 = this.method5623(var9);
               this.method5576((Integer)var7.field4727, (Integer)var7.field4728);
            }
         } else {
            this.field3421 = 0;
            this.method5576(var9, var9);
            this.field3420 = var9;
         }

         this.field3426 = 25;
      }

   }

   public void method5592(int var1, int var2) {
      if (this.field3403 && this.method5585()) {
         var1 += this.field3427;
         var2 += this.field3428;
         int var4 = this.field3409.method7071(var1, var2);
         class438 var5;
         class438 var6;
         switch(this.field3421) {
         case 0:
            this.method5576(this.field3419, var4);
            break;
         case 1:
            var5 = this.method5622(this.field3420);
            var6 = this.method5622(var4);
            this.method5621(var5, var6);
            break;
         case 2:
            var5 = this.method5623(this.field3420);
            var6 = this.method5623(var4);
            this.method5621(var5, var6);
         }
      }

   }

   public void method5625(Clipboard var1) {
      class388 var3 = this.field3409.method7032(this.field3419, this.field3418);
      if (!var3.method6986()) {
         String var4 = var3.method7005();
         if (!var4.isEmpty()) {
            var1.setContents(new StringSelection(var4), (ClipboardOwner)null);
         }
      }

   }

   public void method5594(Clipboard var1) {
      if (this.method5619()) {
         this.method5625(var1);
         this.method5574();
      }

   }

   public void method5639(Clipboard var1) {
      Transferable var3 = var1.getContents((Object)null);
      if (var3 != null && var3.isDataFlavorSupported(DataFlavor.stringFlavor)) {
         try {
            String var4 = this.method5662((String)var3.getTransferData(DataFlavor.stringFlavor));
            this.method5574();
            class385 var5 = this.field3409.method7076(var4, this.field3418, this.field3402, this.field3422);
            this.method5576(var5.method6951(), var5.method6951());
            this.method5624();
            this.method5629();
         } catch (Exception var6) {
            System.out.println("Error pasting clipboard to InputField.");
         }
      }

   }

   public void method5702() {
      this.field3428 = Math.max(0, this.field3428 - this.field3409.method7044());
   }

   public void method5589() {
      int var2 = Math.max(0, this.field3409.method7110() - this.field3415);
      this.field3428 = Math.min(var2, this.field3428 + this.field3409.method7044());
   }

   public void method5598(class301 var1) {
      this.field3429 = var1;
   }

   public void method5599(class301 var1) {
      this.field3430 = var1;
   }

   public class390 method5747() {
      return this.field3409;
   }

   public class390 method5601() {
      return this.field3423;
   }

   public class388 method5602() {
      return this.field3409.method7032(this.field3419, this.field3418);
   }

   public boolean method5585() {
      return this.field3411;
   }

   public boolean method5604() {
      return this.field3412;
   }

   public boolean method5605() {
      return this.method5585() && this.field3413 % 60 < 30;
   }

   public int method5606() {
      return this.field3418;
   }

   public int method5683() {
      return this.field3419;
   }

   public boolean method5691() {
      return this.field3403;
   }

   public int method5609() {
      return this.field3427;
   }

   public int method5677() {
      return this.field3428;
   }

   public int method5611() {
      return this.field3409.method7047();
   }

   public int method5612() {
      return this.field3422;
   }

   public int method5613() {
      return this.field3416;
   }

   public int method5614() {
      return this.field3414;
   }

   public int method5815() {
      return this.field3409.method7034();
   }

   public int method5739() {
      return this.field3417;
   }

   public int method5617() {
      return this.field3409.method7049();
   }

   public boolean method5618() {
      return this.field3422 > 1;
   }

   boolean method5619() {
      return this.field3418 != this.field3419;
   }

   String method5662(String var1) {
      StringBuilder var3 = new StringBuilder(var1.length());

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         char var5 = var1.charAt(var4);
         if (this.method5630(var5)) {
            var3.append(var5);
         }
      }

      return var3.toString();
   }

   void method5621(class438 var1, class438 var2) {
      if ((Integer)var2.field4727 < (Integer)var1.field4727) {
         this.method5576((Integer)var1.field4728, (Integer)var2.field4727);
      } else {
         this.method5576((Integer)var1.field4727, (Integer)var2.field4728);
      }

   }

   class438 method5622(int var1) {
      int var3 = this.field3409.method7084();
      int var4 = 0;
      int var5 = var3;

      int var6;
      for(var6 = var1; var6 > 0; --var6) {
         if (this.method5760(this.field3409.method7022(var6 - 1).field4428)) {
            var4 = var6;
            break;
         }
      }

      for(var6 = var1; var6 < var3; ++var6) {
         if (this.method5760(this.field3409.method7022(var6).field4428)) {
            var5 = var6;
            break;
         }
      }

      return new class438(var4, var5);
   }

   class438 method5623(int var1) {
      int var3 = this.field3409.method7084();
      int var4 = 0;
      int var5 = var3;

      int var6;
      for(var6 = var1; var6 > 0; --var6) {
         if (this.field3409.method7022(var6 - 1).field4428 == '\n') {
            var4 = var6;
            break;
         }
      }

      for(var6 = var1; var6 < var3; ++var6) {
         if (this.field3409.method7022(var6).field4428 == '\n') {
            var5 = var6;
            break;
         }
      }

      return new class438(var4, var5);
   }

   boolean method5624() {
      if (!this.method5691()) {
         return false;
      } else {
         boolean var2 = false;
         if (this.field3409.method7084() > this.field3416) {
            this.field3409.method7039(this.field3416, this.field3409.method7084());
            var2 = true;
         }

         int var3;
         if (this.field3409.method7045() > this.field3422) {
            var3 = this.field3409.method7041(0, this.field3422) - 1;
            this.field3409.method7039(var3, this.field3409.method7084());
            var2 = true;
         }

         if (var2) {
            var3 = this.field3418;
            int var4 = this.field3419;
            int var5 = this.field3409.method7084();
            if (this.field3418 > var5) {
               var3 = var5;
            }

            if (this.field3419 > var5) {
               var4 = var5;
            }

            this.method5576(var4, var3);
         }

         return var2;
      }
   }

   void method5689(int var1, boolean var2) {
      if (var2) {
         this.method5576(this.field3419, var1);
      } else {
         this.method5576(var1, var1);
      }

   }

   int method5626() {
      return this.field3415 / this.field3409.method7044();
   }

   void method5579() {
      class388 var2 = this.field3409.method7032(0, this.field3418);
      class438 var3 = var2.method6990();
      int var4 = this.field3409.method7044();
      int var5 = (Integer)var3.field4727 - 10;
      int var6 = var5 + 20;
      int var7 = (Integer)var3.field4728 - 3;
      int var8 = 6 + var7 + var4;
      int var9 = this.field3427;
      int var10 = this.field3425 + var9;
      int var11 = this.field3428;
      int var12 = var11 + this.field3415;
      int var13 = this.field3427;
      int var14 = this.field3428;
      if (var5 < var9) {
         var13 = var5;
      } else if (var6 > var10) {
         var13 = var6 - this.field3425;
      }

      if (var7 < var11) {
         var14 = var7;
      } else if (var8 > var12) {
         var14 = var8 - this.field3415;
      }

      this.method5731(var13, var14);
   }

   boolean method5760(int var1) {
      return 32 == var1 || var1 == 10 || 9 == var1;
   }

   void method5629() {
      if (this.field3429 != null) {
         this.field3429.method5979();
      }

   }

   boolean method5630(int var1) {
      switch(this.field3417) {
      case 1:
         return class148.method2543((char)var1);
      case 2:
         return class122.method2302((char)var1);
      case 3:
         return class347.method6414((char)var1);
      case 4:
         char var3 = (char)var1;
         if (class347.method6414(var3)) {
            return true;
         } else {
            if ('k' != var3 && var3 != 'K' && var3 != 'm' && var3 != 'M' && var3 != 'b' && var3 != 'B') {
               return false;
            }

            return true;
         }
      default:
         return true;
      }
   }
}
