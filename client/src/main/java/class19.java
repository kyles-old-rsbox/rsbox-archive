import org.bouncycastle.crypto.tls.Certificate;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsCredentials;

import java.io.IOException;

class class19 implements TlsAuthentication {
   static class319 field97;
   static int field96;
   static int field98;
   // $FF: synthetic field
   final class2 this$2;

   class19(class2 var1) {
      this.this$2 = var1;
   }

   static final void method228() {
      for(class66 var1 = (class66)client.field1853.method6356(); null != var1; var1 = (class66)client.field1853.method6350()) {
         if (var1.field537 == class55.field396 && client.field1645 <= var1.field520) {
            if (client.field1645 >= var1.field528) {
               if (var1.field523 > 0) {
                  class81 var2 = client.field1902[var1.field523 - 1];
                  if (var2 != null && var2.field827 >= 0 && var2.field827 < 13312 && var2.field802 >= 0 && var2.field802 < 13312) {
                     var1.method1380(var2.field827, var2.field802, class144.method2498(var2.field827, var2.field802, var1.field537) - var1.field521, client.field1645);
                  }
               }

               if (var1.field523 < 0) {
                  int var3 = -var1.field523 - 1;
                  class93 var4;
                  if (client.field1764 == var3) {
                     var4 = class291.field3364;
                  } else {
                     var4 = client.field1763[var3];
                  }

                  if (var4 != null && var4.field827 >= 0 && var4.field827 < 13312 && var4.field802 >= 0 && var4.field802 < 13312) {
                     var1.method1380(var4.field827, var4.field802, class144.method2498(var4.field827, var4.field802, var1.field537) - var1.field521, client.field1645);
                  }
               }

               var1.method1381(client.field1701);
               class145.field1333.method4133(class55.field396, (int)var1.field525, (int)var1.field514, (int)var1.field527, 60, var1, var1.field519, -1L, false);
            }
         } else {
            var1.remove();
         }
      }

   }

   @Override
   public void notifyServerCertificate(Certificate serverCertificate) throws IOException {

   }

   @Override
   public TlsCredentials getClientCredentials(CertificateRequest certificateRequest) throws IOException {
      return null;
   }
}
