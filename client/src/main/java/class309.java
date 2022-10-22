import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class class309 {
   static class473 field3678;
   static Calendar field3676;
   static final String[] field3679 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   static final String[][] field3677 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "M\u00e4r", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}, {"jan", "f\u00e9v", "mars", "avr", "mai", "juin", "juil", "ao\u00fbt", "sept", "oct", "nov", "d\u00e9c"}, {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"}, {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}, {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"}};

   static {
      Calendar.getInstance();
      field3676 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   class309() throws Throwable {
      throw new Error();
   }

   public static String method5983(long var0) {
      field3676.setTime(new Date(var0));
      int var2 = field3676.get(7);
      int var3 = field3676.get(5);
      int var4 = field3676.get(2);
      int var5 = field3676.get(1);
      int var6 = field3676.get(11);
      int var7 = field3676.get(12);
      int var8 = field3676.get(13);
      return field3679[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + field3677[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
