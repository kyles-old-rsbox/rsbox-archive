import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class class5 implements class167, MouseWheelListener {
   int field15 = 0;

   class5() {
   }

   void method39(Component var1) {
      var1.addMouseWheelListener(this);
   }

   void method38(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field15 += var1.getWheelRotation();
   }

   public synchronized int method2702() {
      int var2 = this.field15;
      this.field15 = 0;
      return var2;
   }
}
