import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;

public final class class464 {
   RandomAccessFile field4901;
   long field4903;
   final long field4902;

   public class464(File var1, String var2, long var3) throws IOException {
      if (-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if (var1.length() > var3) {
         var1.delete();
      }

      this.field4901 = new RandomAccessFile(var1, var2);
      this.field4902 = var3;
      this.field4903 = 0L;
      int var5 = this.field4901.read();
      if (-1 != var5 && !var2.equals("r")) {
         this.field4901.seek(0L);
         this.field4901.write(var5);
      }

      this.field4901.seek(0L);
   }

   final void method8372(long var1) throws IOException {
      this.field4901.seek(var1);
      this.field4903 = var1;
   }

   public final void method8363(byte[] var1, int var2, int var3) throws IOException {
      if ((long)var3 + this.field4903 > this.field4902) {
         this.field4901.seek(this.field4902);
         this.field4901.write(1);
         throw new EOFException();
      } else {
         this.field4901.write(var1, var2, var3);
         this.field4903 += (long)var3;
      }
   }

   public final void method8367() throws IOException {
      this.method8365(false);
   }

   public final void method8365(boolean var1) throws IOException {
      if (this.field4901 != null) {
         if (var1) {
            try {
               this.field4901.getFD().sync();
            } catch (SyncFailedException var4) {
            }
         }

         this.field4901.close();
         this.field4901 = null;
      }

   }

   public final long method8366() throws IOException {
      return this.field4901.length();
   }

   public final int method8362(byte[] var1, int var2, int var3) throws IOException {
      int var5 = this.field4901.read(var1, var2, var3);
      if (var5 > 0) {
         this.field4903 += (long)var5;
      }

      return var5;
   }

   protected void finalize() throws Throwable {
      if (this.field4901 != null) {
         System.out.println("");
         this.method8367();
      }

   }
}
