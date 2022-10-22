import java.util.Iterator;
import java.util.LinkedHashMap;

public class SoundCache {
   public static int field348;
   class319 musicSampleIndex;
   class319 field350;
   class434 musicSamples = new class434(256);
   class434 rawSounds = new class434(256);

   public SoundCache(class319 var1, class319 var2) {
      this.field350 = var1;
      this.musicSampleIndex = var2;
   }

   RawSound method989(int var1, int var2, int[] var3) {
      int var5 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var5 |= var1 << 16;
      long var6 = (long)var5;
      RawSound var8 = (RawSound)this.rawSounds.get(var6);
      if (null != var8) {
         return var8;
      } else if (null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class33 var9 = class33.method610(this.field350, var1, var2);
         if (var9 == null) {
            return null;
         } else {
            var8 = var9.method605();
            this.rawSounds.put(var8, var6);
            if (null != var3) {
               var3[0] -= var8.field258.length;
            }

            return var8;
         }
      }
   }

   RawSound getMusicSample0(int var1, int var2, int[] var3) {
      int var5 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var5 |= var1 << 16;
      long var6 = (long)var5 ^ 4294967296L;
      RawSound rawSound = (RawSound)this.rawSounds.get(var6);
      if (rawSound != null) {
         return rawSound;
      } else if (null != var3 && var3[0] <= 0) {
         return null;
      } else {
         VorbisSample musicSample = (VorbisSample)this.musicSamples.get(var6);
         if (null == musicSample) {
            musicSample = VorbisSample.readMusicSample(this.musicSampleIndex, var1, var2);
            if (musicSample == null) {
               return null;
            }

            this.musicSamples.put(musicSample, var6);
         }

         rawSound = musicSample.toRawSound(var3);
         if (null == rawSound) {
            return null;
         } else {
            musicSample.remove();
            this.rawSounds.put(rawSound, var6);
            return rawSound;
         }
      }
   }

   public RawSound getSoundEffect(int var1, int[] var2) {
      if (this.field350.method6092() == 1) {
         return this.method989(0, var1, var2);
      } else if (this.field350.method6091(var1) == 1) {
         return this.method989(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   static void method1000() {
      Iterator var1 = class110.field1089.iterator();

      while(var1.hasNext()) {
         class63 var2 = (class63)var1.next();
         var2.method1345();
      }

   }

   public RawSound getMusicSample(int var1, int[] var2) {
      if (this.musicSampleIndex.method6092() == 1) {
         return this.getMusicSample0(0, var1, var2);
      } else if (this.musicSampleIndex.method6091(var1) == 1) {
         return this.getMusicSample0(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   static final void method996(boolean var0) {
      if (var0) {
         client.field1671 = class75.field621 ? class141.field1306 : class141.field1303;
      } else {
         LinkedHashMap var2 = class413.field4575.field744;
         String var4 = class75.field633;
         int var5 = var4.length();
         int var6 = 0;

         for(int var7 = 0; var7 < var5; ++var7) {
            var6 = (var6 << 5) - var6 + var4.charAt(var7);
         }

         client.field1671 = var2.containsKey(var6) ? class141.field1302 : class141.field1301;
      }

   }
}
