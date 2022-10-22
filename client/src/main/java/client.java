import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.OtlTokenResponse;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenResponse;
import java.awt.datatransfer.Clipboard;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Future;

public final class client extends class31 implements class375 {
   public static boolean field1635 = false;
   public static class205 field1876;
   public static int field1868 = 1;
   public static int field1932 = 209;
   public static int field1936;
   public static final class107 field1778;
   static boolean field1636 = false;
   static boolean field1640 = false;
   static boolean field1643;
   static boolean field1648;
   static boolean field1650 = true;
   static boolean field1660 = true;
   static boolean field1697;
   static boolean field1706;
   static boolean field1714;
   static boolean field1732;
   static boolean field1739;
   static boolean field1752;
   static boolean field1759;
   static boolean field1762;
   static boolean field1781;
   static boolean field1783;
   static boolean field1784;
   static boolean field1794;
   static boolean field1796;
   static boolean field1797;
   static boolean field1804;
   static boolean field1820;
   static boolean field1827;
   static boolean field1828 = true;
   static boolean field1833;
   static boolean field1862;
   static boolean field1869;
   static boolean field1891;
   static boolean field1900;
   static boolean field1901;
   static boolean[] field1699;
   static boolean[] field1755;
   static boolean[] field1800;
   static boolean[] field1860;
   static boolean[] field1861;
   static boolean[] field1916;
   static byte[] field1689;
   static class141 field1671;
   static class147[] field1883;
   static class148[] field1738;
   static class190 field1877;
   static class200[] field1884;
   static class284 field1926;
   static class284 field1927;
   static class300 field1641;
   static class300 field1821;
   static class300 field1823;
   static class300 field1826;
   static class300 field1874;
   static class305 field1920;
   static class336 field1665;
   static class33[] field1899;
   static class343 field1765;
   static class343 field1777;
   static class343 field1779;
   static class343 field1813;
   static class343 field1853;
   static class343 field1854;
   static class343 field1856;
   static class343[][][] field1865;
   static class347[] field1924;
   static class382 field1698;
   static class434 field1785;
   static class434 field1810;
   static class436 field1807;
   static class445 field1758;
   static class470 field1852;
   static class473[] field1818;
   static class58 field1685;
   static class74 field1925;
   static class80 field1812;
   static class80 field1850;
   static class81[] field1902;
   static class93[] field1763;
   static int field1631;
   static int field1633 = 0;
   static int field1634;
   static int field1637 = -1;
   static int field1638;
   static int field1639;
   static int field1642;
   static int field1645 = 0;
   static int field1647 = -1;
   static int field1651 = 0;
   static int field1652 = 0;
   static int field1654 = 0;
   static int field1655 = 0;
   static int field1656 = 0;
   static int field1657;
   static int field1661;
   static int field1662;
   static int field1663;
   static int field1664;
   static int field1666;
   static int field1667;
   static int field1668;
   static int field1669;
   static int field1670;
   static int field1672;
   static int field1676;
   static int field1678;
   static int field1682;
   static int field1684 = 0;
   static int field1686;
   static int field1690;
   static int field1691;
   static int field1693;
   static int field1695;
   static int field1696;
   static int field1700;
   static int field1701;
   static int field1702;
   static int field1703;
   static int field1704 = -1;
   static int field1709;
   static int field1711;
   static int field1712;
   static int field1713;
   static int field1715;
   static int field1716 = -1;
   static int field1717;
   static int field1718;
   static int field1719;
   static int field1720;
   static int field1722;
   static int field1723;
   static int field1724;
   static int field1725;
   static int field1726;
   static int field1727;
   static int field1729;
   static int field1731;
   static int field1733;
   static int field1735;
   static int field1737;
   static int field1742;
   static int field1745;
   static int field1746;
   static int field1747;
   static int field1748;
   static int field1749;
   static int field1750;
   static int field1751;
   static int field1753;
   static int field1757;
   static int field1761;
   static int field1764;
   static int field1766 = 0;
   static int field1767;
   static int field1768;
   static int field1769;
   static int field1773 = -1;
   static int field1775;
   static int field1786;
   static int field1793;
   static int field1798;
   static int field1799;
   static int field1802;
   static int field1805;
   static int field1806;
   static int field1809;
   static int field1811;
   static int field1814;
   static int field1816;
   static int field1819;
   static int field1822;
   static int field1824;
   static int field1825;
   static int field1829;
   static int field1830;
   static int field1831;
   static int field1832;
   static int field1838;
   static int field1840;
   static int field1842;
   static int field1843;
   static int field1844;
   static int field1845;
   static int field1846;
   static int field1847;
   static int field1848;
   static int field1849;
   static int field1857;
   static int field1858;
   static int field1859;
   static int field1866 = 0;
   static int field1867;
   static int field1871;
   static int field1872;
   static int field1875;
   static int field1878;
   static int field1879 = 0;
   static int field1882;
   static int field1885;
   static int field1886;
   static int field1888;
   static int field1889;
   static int field1890;
   static int field1892;
   static int field1893;
   static int field1894;
   static int field1898;
   static int field1904;
   static int field1910;
   static int field1911 = 0;
   static int field1913 = 0;
   static int field1915;
   static int field1917;
   static int field1919;
   static int field1921;
   static int field1922;
   static int field1928;
   static int field1929;
   static int[] field1649;
   static int[] field1658;
   static int[] field1659;
   static int[] field1692;
   static int[] field1694;
   static int[] field1710;
   static int[] field1721;
   static int[] field1734;
   static int[] field1736;
   static int[] field1740;
   static int[] field1741;
   static int[] field1756;
   static int[] field1770;
   static int[] field1774;
   static int[] field1780;
   static int[] field1782;
   static int[] field1787;
   static int[] field1788;
   static int[] field1789;
   static int[] field1790;
   static int[] field1808;
   static int[] field1817;
   static int[] field1834;
   static int[] field1836;
   static int[] field1837;
   static int[] field1839;
   static int[] field1841;
   static int[] field1851;
   static int[] field1863;
   static int[] field1864;
   static int[] field1870;
   static int[] field1880;
   static int[] field1887;
   static int[] field1895;
   static int[] field1896;
   static int[] field1897;
   static int[] field1903;
   static int[] field1905;
   static int[] field1906;
   static int[] field1908;
   static int[] field1931;
   static int[] field1935;
   static int[][] field1855;
   static int[][][] field1707;
   static String field1653;
   static String field1754;
   static String field1803;
   static String field1873;
   static String[] field1743;
   static String[] field1772;
   static String[] field1791;
   static String[] field1923;
   static ArrayList field1930;
   static HashMap field1934;
   static long field1632;
   static long field1644 = -1L;
   static long field1646 = -1L;
   static long field1730;
   static long field1881;
   static long[] field1918;
   static short field1705;
   static short field1744;
   static short field1792;
   static short field1801;
   static short field1907;
   static short field1909;
   static short field1912;
   static short field1914;
   static final class55 field1933;
   static final int[] field1708;
   static final int[] field1771;
   static final String field1795;
   boolean field1835 = false;
   class13 field1675;
   class13 field1679;
   class15 field1674;
   class4 field1687;
   class460 field1728;
   OtlTokenRequester field1815;
   RefreshAccessTokenRequester field1680;
   String field1673;
   Future field1677;
   Future field1681;
   long field1688 = -1L;

   static {
      field1812 = class80.field703;
      field1850 = class80.field703;
      field1793 = 0;
      field1663 = 0;
      field1664 = 0;
      field1666 = 0;
      field1667 = 0;
      field1668 = 0;
      field1669 = 0;
      field1717 = 0;
      field1671 = class141.field1301;
      field1758 = class445.field4791;
      int var1 = "com_jagex_auth_desktop_osrs:public".length();
      byte[] var2 = new byte[var1];

      int var3;
      for(var3 = 0; var3 < var1; ++var3) {
         char var4 = "com_jagex_auth_desktop_osrs:public".charAt(var3);
         if (var4 > 127) {
            var2[var3] = 63;
         } else {
            var2[var3] = (byte)var4;
         }
      }

      byte[] var0 = var2;
      var3 = var2.length;
      StringBuilder var10 = new StringBuilder();

      for(int var5 = 0; var5 < 0 + var3; var5 += 3) {
         int var6 = var0[var5] & 255;
         var10.append(class351.field4277[var6 >>> 2]);
         if (var5 < var3 - 1) {
            int var7 = var0[var5 + 1] & 255;
            var10.append(class351.field4277[(var6 & 3) << 4 | var7 >>> 4]);
            if (var5 < var3 - 2) {
               int var8 = var0[2 + var5] & 255;
               var10.append(class351.field4277[(var7 & 15) << 2 | var8 >>> 6]).append(class351.field4277[var8 & 63]);
            } else {
               var10.append(class351.field4277[(var7 & 15) << 2]).append("=");
            }
         } else {
            var10.append(class351.field4277[(var6 & 3) << 4]).append("==");
         }
      }

      String var9 = var10.toString();
      field1795 = var9;
      field1891 = false;
      field1685 = new class58();
      field1689 = null;
      field1902 = new class81[65536];
      field1691 = 0;
      field1692 = new int[65536];
      field1693 = 0;
      field1694 = new int[250];
      field1778 = new class107();
      field1696 = 0;
      field1697 = false;
      field1698 = new class382();
      field1934 = new HashMap();
      field1700 = 0;
      field1631 = 1;
      field1702 = 0;
      field1703 = 1;
      field1725 = 0;
      field1884 = new class200[4];
      field1706 = false;
      field1707 = new int[4][13][13];
      field1708 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1701 = 0;
      field1857 = 2301979;
      field1711 = 5063219;
      field1712 = 3353893;
      field1713 = 7759444;
      field1714 = false;
      field1715 = 0;
      field1761 = 128;
      field1672 = 0;
      field1718 = 0;
      field1719 = 0;
      field1720 = 0;
      field1886 = 0;
      field1722 = 0;
      field1723 = 50;
      field1724 = 0;
      field1676 = 0;
      field1726 = 0;
      field1727 = 12;
      field1767 = 6;
      field1729 = 0;
      field1643 = false;
      field1922 = 0;
      field1732 = false;
      field1733 = 0;
      field1661 = 0;
      field1735 = 50;
      field1736 = new int[field1735];
      field1908 = new int[field1735];
      field1721 = new int[field1735];
      field1659 = new int[field1735];
      field1740 = new int[field1735];
      field1741 = new int[field1735];
      field1649 = new int[field1735];
      field1743 = new String[field1735];
      field1855 = new int[104][104];
      field1745 = 0;
      field1809 = -1;
      field1747 = -1;
      field1657 = 0;
      field1749 = 0;
      field1904 = 0;
      field1751 = 0;
      field1752 = true;
      field1840 = 0;
      field1888 = 0;
      field1737 = 0;
      field1638 = 0;
      field1757 = 0;
      field1892 = 0;
      field1759 = false;
      field1786 = 0;
      field1830 = 0;
      field1762 = true;
      field1763 = new class93[2048];
      field1764 = -1;
      field1921 = 0;
      field1632 = -1L;
      field1739 = true;
      field1768 = 0;
      field1769 = 0;
      field1770 = new int[1000];
      field1771 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field1772 = new String[8];
      field1755 = new boolean[8];
      field1774 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1775 = -1;
      field1865 = new class343[4][104][104];
      field1777 = new class343();
      field1853 = new class343();
      field1779 = new class343();
      field1780 = new int[25];
      field1817 = new int[25];
      field1782 = new int[25];
      field1862 = false;
      field1784 = false;
      field1695 = 0;
      field1851 = new int[500];
      field1787 = new int[500];
      field1788 = new int[500];
      field1789 = new int[500];
      field1790 = new int[500];
      field1791 = new String[500];
      field1923 = new String[500];
      field1916 = new boolean[500];
      field1794 = false;
      field1648 = false;
      field1796 = false;
      field1797 = true;
      field1798 = -1;
      field1799 = -1;
      field1670 = 0;
      field1929 = 50;
      field1802 = 0;
      field1803 = null;
      field1804 = false;
      field1805 = -1;
      field1806 = -1;
      field1653 = null;
      field1754 = null;
      field1893 = -1;
      field1810 = new class434(8);
      field1811 = 0;
      field1898 = -1;
      field1753 = 0;
      field1814 = 0;
      field1641 = null;
      field1816 = 0;
      field1859 = 0;
      field1750 = 0;
      field1819 = -1;
      field1820 = false;
      field1821 = null;
      field1874 = null;
      field1823 = null;
      field1824 = 0;
      field1825 = 0;
      field1826 = null;
      field1827 = false;
      field1746 = -1;
      field1829 = -1;
      field1783 = false;
      field1831 = -1;
      field1832 = -1;
      field1833 = false;
      field1878 = 1;
      field1931 = new int[32];
      field1690 = 0;
      field1837 = new int[32];
      field1838 = 0;
      field1839 = new int[32];
      field1742 = 0;
      field1841 = new int[32];
      field1842 = 0;
      field1843 = 0;
      field1844 = 0;
      field1845 = 0;
      field1846 = 0;
      field1847 = 0;
      field1848 = 0;
      field1849 = 0;
      field1642 = 0;
      field1639 = 0;
      field1852 = new class470();
      field1765 = new class343();
      field1854 = new class343();
      field1813 = new class343();
      field1856 = new class343();
      field1785 = new class434(512);
      field1858 = 0;
      field1882 = -2;
      field1860 = new boolean[100];
      field1861 = new boolean[100];
      field1800 = new boolean[100];
      field1863 = new int[100];
      field1864 = new int[100];
      field1710 = new int[100];
      field1658 = new int[100];
      field1867 = 0;
      field1730 = 0L;
      field1869 = true;
      field1870 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      field1871 = 0;
      field1872 = 0;
      field1873 = "";
      field1918 = new long[100];
      field1875 = 0;
      field1876 = new class205();
      field1877 = new class190();
      field1822 = 0;
      field1756 = new int[128];
      field1880 = new int[128];
      field1881 = -1L;
      field1738 = new class148[4];
      field1883 = new class147[4];
      field1662 = -1;
      field1885 = 0;
      field1834 = new int[1000];
      field1887 = new int[1000];
      field1818 = new class473[1000];
      field1889 = 0;
      field1890 = 0;
      field1709 = 0;
      field1748 = -1;
      field1781 = false;
      field1894 = 0;
      field1895 = new int[50];
      field1896 = new int[50];
      field1897 = new int[50];
      field1734 = new int[50];
      field1899 = new class33[50];
      field1900 = false;
      field1901 = false;
      field1699 = new boolean[5];
      field1903 = new int[5];
      field1808 = new int[5];
      field1905 = new int[5];
      field1906 = new int[5];
      field1907 = 256;
      field1792 = 205;
      field1909 = 256;
      field1801 = 320;
      field1744 = 1;
      field1912 = 32767;
      field1705 = 1;
      field1914 = 32767;
      field1915 = 0;
      field1634 = 0;
      field1917 = 0;
      field1678 = 0;
      field1919 = 0;
      field1920 = new class305();
      field1682 = -1;
      field1686 = -1;
      field1807 = new class428();
      field1924 = new class347[8];
      field1925 = new class74();
      field1926 = new class284(64);
      field1927 = new class284(64);
      field1928 = -1;
      field1936 = -1;
      field1930 = new ArrayList(10);
      field1910 = 0;
      field1731 = 0;
      field1933 = new class55();
      field1836 = new int[50];
      field1935 = new int[50];
   }

   static class420 method6316() {
      return class4.field10;
   }

   protected final void method453() {
   }

   public final void init() {
      if (this.method547()) {
         int var3;
         for(int var1 = 0; var1 <= 28; ++var1) {
            String var2 = this.getParameter(Integer.toString(var1));
            if (null != var2) {
               switch(var1) {
               case 3:
                  if (var2.equalsIgnoreCase(class96.field967)) {
                     field1635 = true;
                  } else {
                     field1635 = false;
                  }
                  break;
               case 4:
                  if (field1704 == -1) {
                     field1704 = Integer.parseInt(var2);
                  }
                  break;
               case 5:
                  field1633 = Integer.parseInt(var2);
                  break;
               case 6:
                  class94.field940 = class353.method6558(Integer.parseInt(var2));
                  break;
               case 7:
                  class259.field2962 = class225.method4507(Integer.parseInt(var2));
                  break;
               case 8:
                  if (var2.equalsIgnoreCase(class96.field967)) {
                  }
                  break;
               case 9:
                  class61.field481 = var2;
                  break;
               case 10:
                  class368.field4353 = (class329)class217.method4362(class329.method1596(), Integer.parseInt(var2));
                  if (class368.field4353 == class329.field3819) {
                     class234.field2779 = class463.field4894;
                  } else {
                     class234.field2779 = class463.field4896;
                  }
                  break;
               case 11:
                  class106.field1050 = var2;
                  break;
               case 12:
                  field1868 = Integer.parseInt(var2);
               case 13:
               case 16:
               case 18:
               case 19:
               case 20:
               case 22:
               case 23:
               case 24:
               default:
                  break;
               case 14:
                  class11.field45 = Integer.parseInt(var2);
                  break;
               case 15:
                  field1911 = Integer.parseInt(var2);
                  break;
               case 17:
                  class130.field1236 = var2;
                  break;
               case 21:
                  field1637 = Integer.parseInt(var2);
                  break;
               case 25:
                  var3 = var2.indexOf(".");
                  if (-1 == var3) {
                     field1932 = Integer.parseInt(var2);
                  } else {
                     field1932 = Integer.parseInt(var2.substring(0, var3));
                     Integer.parseInt(var2.substring(var3 + 1));
                  }
               }
            }
         }

         method7915();
         class271.field3032 = this.getCodeBase().getHost();
         String var13 = class259.field2962.field3836;
         byte var14 = 0;

         try {
            class163.field1502 = 22;
            class163.field1511 = var14;

            try {
               class42.field296 = System.getProperty("os.name");
            } catch (Exception var10) {
               class42.field296 = "Unknown";
            }

            class20.field100 = class42.field296.toLowerCase();

            try {
               class45.field328 = System.getProperty("user.home");
               if (null != class45.field328) {
                  class45.field328 = class45.field328 + "/";
               }
            } catch (Exception var9) {
            }

            try {
               if (class20.field100.startsWith("win")) {
                  if (null == class45.field328) {
                     class45.field328 = System.getenv("USERPROFILE");
                  }
               } else if (null == class45.field328) {
                  class45.field328 = System.getenv("HOME");
               }

               if (class45.field328 != null) {
                  class45.field328 = class45.field328 + "/";
               }
            } catch (Exception var8) {
            }

            if (class45.field328 == null) {
               class45.field328 = "~/";
            }

            class347.field4261 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class45.field328, "/tmp/", ""};
            class251.field2908 = new String[]{".jagex_cache_" + class163.field1511, ".file_store_" + class163.field1511};

            label170:
            for(var3 = 0; var3 < 4; ++var3) {
               class290.field3361 = class4.method34("oldschool", var13, var3);
               if (!class290.field3361.exists()) {
                  class290.field3361.mkdirs();
               }

               File[] var4 = class290.field3361.listFiles();
               if (null == var4) {
                  break;
               }

               File[] var5 = var4;
               int var6 = 0;

               while(true) {
                  if (var6 >= var5.length) {
                     break label170;
                  }

                  File var7 = var5[var6];
                  if (!class32.method601(var7, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            class170.method2291(class290.field3361);

            try {
               File var15 = new File(class45.field328, "random.dat");
               int var18;
               if (var15.exists()) {
                  class163.field1498 = new class466(new class464(var15, "rw", 25L), 24, 0);
               } else {
                  label150:
                  for(int var16 = 0; var16 < class251.field2908.length; ++var16) {
                     for(var18 = 0; var18 < class347.field4261.length; ++var18) {
                        File var19 = new File(class347.field4261[var18] + class251.field2908[var16] + File.separatorChar + "random.dat");
                        if (var19.exists()) {
                           class163.field1498 = new class466(new class464(var19, "rw", 25L), 24, 0);
                           break label150;
                        }
                     }
                  }
               }

               if (class163.field1498 == null) {
                  RandomAccessFile var17 = new RandomAccessFile(var15, "rw");
                  var18 = var17.read();
                  var17.seek(0L);
                  var17.write(var18);
                  var17.seek(0L);
                  var17.close();
                  class163.field1498 = new class466(new class464(var15, "rw", 25L), 24, 0);
               }
            } catch (IOException var11) {
            }

            class163.field1503 = new class466(new class464(class106.method2066("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class163.field1509 = new class466(new class464(class106.method2066("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class163.field1510 = new class466[class163.field1502];

            for(var3 = 0; var3 < class163.field1502; ++var3) {
               class163.field1510[var3] = new class466(new class464(class106.method2066("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var12) {
            class422.method7800((String)null, var12);
         }

         class133.field1257 = this;
         class460.field4885 = field1704;
         if (-1 == field1716) {
            field1716 = 0;
         }

         class310.field3689 = System.getenv("JX_ACCESS_TOKEN");
         class298.field3437 = System.getenv("JX_REFRESH_TOKEN");
         if (Boolean.parseBoolean(System.getProperty("jagex.disableBouncyCastle"))) {
            this.field1835 = true;
         }

         this.method457(765, 503, 209, 1);
      }
   }

   static final void method7915() {
      class214.field2559 = false;
      field1636 = false;
   }

   boolean method2874() {
      return null != class310.field3689 && !class310.field3689.trim().isEmpty() && class298.field3437 != null && !class298.field3437.trim().isEmpty();
   }

   boolean method3038() {
      return this.field1815 != null;
   }

   void method2876(String var1) throws IOException {
      HashMap var3 = new HashMap();
      var3.put("grant_type", "refresh_token");
      var3.put("scope", "gamesso.token.create");
      var3.put("refresh_token", var1);
      URL var4 = new URL(class106.field1050 + "shield/oauth/token" + (new class431(var3)).method7841());
      HashMap var5 = new HashMap();
      var5.put("Authorization", "Basic " + field1795);
      var5.put("Host", (new URL(class106.field1050)).getHost());
      var5.put("Accept", class430.field4700.method7837());
      class18 var6 = class18.field87;
      RefreshAccessTokenRequester var7 = this.field1680;
      if (var7 != null) {
         this.field1681 = var7.request(var6.method215(), var4, var5, "");
      } else {
         class12 var8 = new class12(var4, var6, this.field1835);
         Iterator var9 = var5.entrySet().iterator();

         while(var9.hasNext()) {
            Entry var10 = (Entry)var9.next();
            var8.method88((String)var10.getKey(), (String)var10.getValue());
         }

         this.field1679 = this.field1674.method131(var8);
      }
   }

   void method2877(String var1) throws MalformedURLException, IOException {
      URL var3 = new URL(class106.field1050 + "public/v1/games/YCfdbvr2pM1zUYMxJRexZY/play");
      HashMap var4 = new HashMap();
      var4.put("Authorization", "Bearer " + var1);
      class18 var5 = class18.field84;
      OtlTokenRequester var6 = this.field1815;
      if (var6 != null) {
         this.field1677 = var6.request(var5.method215(), var3, var4, "");
      } else {
         class12 var7 = new class12(var3, var5, this.field1835);
         Iterator var8 = var4.entrySet().iterator();

         while(var8.hasNext()) {
            Entry var9 = (Entry)var8.next();
            var7.method88((String)var9.getKey(), (String)var9.getValue());
         }

         this.field1675 = this.field1674.method131(var7);
      }
   }

   protected final void method467() {
      int[] var2 = new int[]{20, 260, 10000};
      int[] var3 = new int[]{1000, 100, 500};
      if (var2 != null && var3 != null) {
         class229.field2738 = var2;
         class258.field2960 = new int[var2.length];
         class359.field4312 = new byte[var2.length][][];

         for(int var4 = 0; var4 < class229.field2738.length; ++var4) {
            class359.field4312[var4] = new byte[var3[var4]][];
            class378.field4402.add(var2[var4]);
         }

         Collections.sort(class378.field4402);
      } else {
         class229.field2738 = null;
         class258.field2960 = null;
         class359.field4312 = (byte[][][])null;
         class378.method6175();
      }

      class180.field1608 = field1911 == 0 ? '\uaa4a' : '\u9c40' + field1868;
      class141.field1307 = field1911 == 0 ? 443 : '\uc350' + field1868;
      class454.field4859 = class180.field1608;
      class172.field1551 = class303.field3622;
      class37.field251 = class303.field3624;
      class9.field39 = class303.field3621;
      class97.field974 = class303.field3623;
      class28.field155 = new class125(this.field1835, 209);
      this.method573();
      this.method450();
      class18.field94 = this.method443();
      this.method449(field1877, 0);
      this.method449(field1876, 1);
      class227.field2721 = new class392(255, class163.field1503, class163.field1509, 500000);
      class464 var5 = null;
      class83 var6 = new class83();

      try {
         var5 = class161.method2668("", class368.field4353.field3820, false);
         byte[] var7 = new byte[(int)var5.method8366()];

         int var9;
         for(int var8 = 0; var8 < var7.length; var8 += var9) {
            var9 = var5.method8362(var7, var8, var7.length - var8);
            if (-1 == var9) {
               throw new IOException();
            }
         }

         var6 = new class83(new class460(var7));
      } catch (Exception var11) {
      }

      try {
         if (null != var5) {
            var5.method8367();
         }
      } catch (Exception var10) {
      }

      class413.field4575 = var6;
      this.method444();
      class99.method1985(this, class80.field706);
      class164.method2692(class413.field4575.method1726());
      class217.field2588 = new class53(class234.field2779);
      this.field1674 = new class15("tokenRequest", 1, 1);
   }

   protected final void method468() {
      ++field1645;
      this.method3087();
      class322.method4893();
      class182.method2856();
      class349.method6449();
      field1876.method3893();
      this.method539();
      class42.method4616();
      if (null != class18.field94) {
         int var2 = class18.field94.method2702();
         field1639 = var2;
      }

      if (field1766 == 0) {
         class34.method649();
         class339.method6307();
      } else if (field1766 == 5) {
         class442.method7916(this, class353.field4289);
         class34.method649();
         class339.method6307();
      } else if (10 != field1766 && 11 != field1766) {
         if (20 == field1766) {
            class442.method7916(this, class353.field4289);
            this.method2882();
         } else if (50 == field1766) {
            class442.method7916(this, class353.field4289);
            this.method2882();
         } else if (25 == field1766) {
            class43.method802();
         }
      } else {
         class442.method7916(this, class353.field4289);
      }

      if (field1766 == 30) {
         this.method2883();
      } else if (40 == field1766 || 45 == field1766) {
         this.method2882();
      }

   }

   protected final void method466(boolean var1) {
      boolean var3;
      label170: {
         try {
            if (2 == class279.field3202) {
               if (class141.field1300 == null) {
                  class141.field1300 = class292.method5491(class7.field29, class279.field3203, class279.field3204);
                  if (null == class141.field1300) {
                     var3 = false;
                     break label170;
                  }
               }

               if (class370.field4368 == null) {
                  class370.field4368 = new SoundCache(class279.field3200, class279.field3199);
               }

               if (class279.midiPcmStream.loadMusicTrack(class141.field1300, class279.field3206, class370.field4368, 22050)) {
                  class279.midiPcmStream.method5277();
                  class279.midiPcmStream.method5271(class110.field1092);
                  class279.midiPcmStream.method5276(class141.field1300, class337.field3889);
                  class279.field3202 = 0;
                  class141.field1300 = null;
                  class370.field4368 = null;
                  class7.field29 = null;
                  var3 = true;
                  break label170;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class279.midiPcmStream.method5365();
            class279.field3202 = 0;
            class141.field1300 = null;
            class370.field4368 = null;
            class7.field29 = null;
         }

         var3 = false;
      }

      if (var3 && field1781 && null != class91.field886) {
         class91.field886.method360();
      }

      if ((10 == field1766 || 20 == field1766 || field1766 == 30) && 0L != field1730 && class272.method2046() > field1730) {
         class164.method2692(class2.method11());
      }

      int var5;
      if (var1) {
         for(var5 = 0; var5 < 100; ++var5) {
            field1860[var5] = true;
         }
      }

      if (field1766 == 0) {
         this.method477(class75.field622, class75.field623, var1);
      } else if (5 == field1766) {
         class109.method2105(class114.field1127, class346.field4250, class353.field4289);
      } else if (field1766 != 10 && field1766 != 11) {
         if (field1766 == 20) {
            class109.method2105(class114.field1127, class346.field4250, class353.field4289);
         } else if (field1766 == 50) {
            class109.method2105(class114.field1127, class346.field4250, class353.field4289);
         } else if (field1766 == 25) {
            if (field1725 == 1) {
               if (field1700 > field1631) {
                  field1631 = field1700;
               }

               var5 = (field1631 * 50 - field1700 * 50) / field1631;
               class131.method2399(class338.field3902 + class96.field966 + class96.field964 + var5 + "%" + class96.field958, false);
            } else if (field1725 == 2) {
               if (field1702 > field1703) {
                  field1703 = field1702;
               }

               var5 = (field1703 * 50 - field1702 * 50) / field1703 + 50;
               class131.method2399(class338.field3902 + class96.field966 + class96.field964 + var5 + "%" + class96.field958, false);
            } else {
               class131.method2399(class338.field3902, false);
            }
         } else if (field1766 == 30) {
            this.method2885();
         } else if (field1766 == 40) {
            class131.method2399(class338.field3903 + class96.field966 + class338.field3950, false);
         } else if (field1766 == 45) {
            class131.method2399(class338.field4062, false);
         }
      } else {
         class109.method2105(class114.field1127, class346.field4250, class353.field4289);
      }

      if (30 == field1766 && field1867 == 0 && !var1 && !field1869) {
         for(var5 = 0; var5 < field1858; ++var5) {
            if (field1861[var5]) {
               class6.field18.method8613(field1863[var5], field1864[var5], field1710[var5], field1658[var5]);
               field1861[var5] = false;
            }
         }
      } else if (field1766 > 0) {
         class6.field18.method8614(0, 0);

         for(var5 = 0; var5 < field1858; ++var5) {
            field1861[var5] = false;
         }
      }

   }

   protected final void method455() {
      if (class66.field538.method2316()) {
         class66.field538.method2312();
      }

      if (null != class74.field610) {
         class74.field610.field746 = false;
      }

      class74.field610 = null;
      field1778.method2080();
      class73.method1488();
      class18.field94 = null;
      if (class91.field886 != null) {
         class91.field886.method361();
      }

      if (class88.field794 != null) {
         class88.field794.method361();
      }

      class323.method6192();
      class322.method3464();
      if (null != class28.field155) {
         class28.field155.method2236();
         class28.field155 = null;
      }

      class53.method1112();
      this.field1674.method130();
   }

   void method3087() {
      if (1000 != field1766) {
         long var3 = class272.method2046();
         int var5 = (int)(var3 - class289.field3358);
         class289.field3358 = var3;
         if (var5 > 200) {
            var5 = 200;
         }

         class324.field3795 += var5;
         boolean var2;
         if (class324.field3777 == 0 && class324.field3780 == 0 && class324.field3788 == 0 && class324.field3778 == 0) {
            var2 = true;
         } else if (null == class324.field3787) {
            var2 = false;
         } else {
            try {
               label246: {
                  if (class324.field3795 > 30000) {
                     throw new IOException();
                  }

                  class335 var6;
                  class460 var7;
                  while(class324.field3780 < 200 && class324.field3778 > 0) {
                     var6 = (class335)class324.field3794.method7860();
                     var7 = new class460(4);
                     var7.method8097(1);
                     var7.method8099((int)var6.field4681);
                     class324.field3787.method7251(var7.field4881, 0, 4);
                     class324.field3779.put(var6, var6.field4681);
                     --class324.field3778;
                     ++class324.field3780;
                  }

                  while(class324.field3777 < 200 && class324.field3788 > 0) {
                     var6 = (class335)class324.field3781.method6566();
                     var7 = new class460(4);
                     var7.method8097(0);
                     var7.method8099((int)var6.field4681);
                     class324.field3787.method7251(var7.field4881, 0, 4);
                     var6.method7882();
                     class324.field3784.put(var6, var6.field4681);
                     --class324.field3788;
                     ++class324.field3777;
                  }

                  for(int var21 = 0; var21 < 100; ++var21) {
                     int var22 = class324.field3787.method7248();
                     if (var22 < 0) {
                        throw new IOException();
                     }

                     if (0 == var22) {
                        break;
                     }

                     class324.field3795 = 0;
                     byte var8 = 0;
                     if (class116.field1137 == null) {
                        var8 = 8;
                     } else if (0 == class324.field3790) {
                        var8 = 1;
                     }

                     int var9;
                     int var10;
                     int var11;
                     int var13;
                     byte[] var10000;
                     int var10001;
                     class460 var25;
                     if (var8 > 0) {
                        var9 = var8 - class324.field3776.field4878;
                        if (var9 > var22) {
                           var9 = var22;
                        }

                        class324.field3787.method7260(class324.field3776.field4881, class324.field3776.field4878, var9);
                        if (class324.field3792 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              var10000 = class324.field3776.field4881;
                              var10001 = var10 + class324.field3776.field4878;
                              var10000[var10001] ^= class324.field3792;
                           }
                        }

                        var25 = class324.field3776;
                        var25.field4878 += var9;
                        if (class324.field3776.field4878 < var8) {
                           break;
                        }

                        if (null == class116.field1137) {
                           class324.field3776.field4878 = 0;
                           var10 = class324.field3776.method8134();
                           var11 = class324.field3776.method8115();
                           int var12 = class324.field3776.method8134();
                           var13 = class324.field3776.method8119();
                           long var14 = (long)((var10 << 16) + var11);
                           class335 var16 = (class335)class324.field3779.get(var14);
                           class111.field1097 = true;
                           if (null == var16) {
                              var16 = (class335)class324.field3784.get(var14);
                              class111.field1097 = false;
                           }

                           if (var16 == null) {
                              throw new IOException();
                           }

                           int var17 = var12 == 0 ? 5 : 9;
                           class116.field1137 = var16;
                           class431.field4704 = new class460(class116.field1137.field3868 + var13 + var17);
                           class431.field4704.method8097(var12);
                           class431.field4704.method8234(var13);
                           class324.field3790 = 8;
                           class324.field3776.field4878 = 0;
                        } else if (class324.field3790 == 0) {
                           if (-1 == class324.field3776.field4881[0]) {
                              class324.field3790 = 1;
                              class324.field3776.field4878 = 0;
                           } else {
                              class116.field1137 = null;
                           }
                        }
                     } else {
                        var9 = class431.field4704.field4881.length - class116.field1137.field3868;
                        var10 = 512 - class324.field3790;
                        if (var10 > var9 - class431.field4704.field4878) {
                           var10 = var9 - class431.field4704.field4878;
                        }

                        if (var10 > var22) {
                           var10 = var22;
                        }

                        class324.field3787.method7260(class431.field4704.field4881, class431.field4704.field4878, var10);
                        if (0 != class324.field3792) {
                           for(var11 = 0; var11 < var10; ++var11) {
                              var10000 = class431.field4704.field4881;
                              var10001 = var11 + class431.field4704.field4878;
                              var10000[var10001] ^= class324.field3792;
                           }
                        }

                        var25 = class431.field4704;
                        var25.field4878 += var10;
                        class324.field3790 += var10;
                        if (var9 == class431.field4704.field4878) {
                           if (16711935L == class116.field1137.field4681) {
                              class110.field1090 = class431.field4704;

                              for(var11 = 0; var11 < 256; ++var11) {
                                 class336 var23 = class324.field3789[var11];
                                 if (null != var23) {
                                    class110.field1090.field4878 = 8 * var11 + 5;
                                    if (class110.field1090.field4878 >= class110.field1090.field4881.length) {
                                       if (!var23.field3883) {
                                          throw new RuntimeException("");
                                       }

                                       var23.method6273();
                                    } else {
                                       var13 = class110.field1090.method8119();
                                       int var24 = class110.field1090.method8119();
                                       var23.method6290(var13, var24);
                                    }
                                 }
                              }
                           } else {
                              class324.field3785.reset();
                              class324.field3785.update(class431.field4704.field4881, 0, var9);
                              var11 = (int)class324.field3785.getValue();
                              if (var11 != class116.field1137.field3865) {
                                 try {
                                    class324.field3787.method7252();
                                 } catch (Exception var19) {
                                 }

                                 ++class324.field3793;
                                 class324.field3787 = null;
                                 class324.field3792 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var2 = false;
                                 break label246;
                              }

                              class324.field3793 = 0;
                              class324.field3775 = 0;
                              class116.field1137.field3866.method6270((int)(class116.field1137.field4681 & 65535L), class431.field4704.field4881, 16711680L == (class116.field1137.field4681 & 16711680L), class111.field1097);
                           }

                           class116.field1137.remove();
                           if (class111.field1097) {
                              --class324.field3780;
                           } else {
                              --class324.field3777;
                           }

                           class324.field3790 = 0;
                           class116.field1137 = null;
                           class431.field4704 = null;
                        } else {
                           if (class324.field3790 != 512) {
                              break;
                           }

                           class324.field3790 = 0;
                        }
                     }
                  }

                  var2 = true;
               }
            } catch (IOException var20) {
               try {
                  class324.field3787.method7252();
               } catch (Exception var18) {
               }

               ++class324.field3775;
               class324.field3787 = null;
               var2 = false;
            }
         }

         if (!var2) {
            this.method3033();
         }

      }
   }

   void method3033() {
      if (class324.field3793 >= 4) {
         this.method473("js5crc");
         class9.method64(1000);
      } else {
         if (class324.field3775 >= 4) {
            if (field1766 <= 5) {
               this.method473("js5io");
               class9.method64(1000);
               return;
            }

            field1664 = 3000;
            class324.field3775 = 3;
         }

         if (--field1664 + 1 <= 0) {
            try {
               if (0 == field1663) {
                  class347.field4257 = class31.field169.method2723(class271.field3032, class454.field4859);
                  ++field1663;
               }

               if (field1663 == 1) {
                  if (class347.field4257.field1614 == 2) {
                     this.method3062(-1);
                     return;
                  }

                  if (1 == class347.field4257.field1614) {
                     ++field1663;
                  }
               }

               class460 var4;
               if (2 == field1663) {
                  Socket var3 = (Socket)class347.field4257.field1612;
                  class409 var2 = new class409(var3, 40000, 5000);
                  class312.field3697 = var2;
                  var4 = new class460(5);
                  var4.method8097(15);
                  var4.method8234(209);
                  class312.field3697.method7251(var4.field4881, 0, 5);
                  ++field1663;
                  class218.field2591 = class272.method2046();
               }

               if (3 == field1663) {
                  if (class312.field3697.method7248() > 0) {
                     int var10 = class312.field3697.method7249();
                     if (0 != var10) {
                        this.method3062(var10);
                        return;
                     }

                     ++field1663;
                  } else if (class272.method2046() - class218.field2591 > 30000L) {
                     this.method3062(-2);
                     return;
                  }
               }

               if (field1663 == 4) {
                  class401 var11 = class312.field3697;
                  boolean var12 = field1766 > 20;
                  if (null != class324.field3787) {
                     try {
                        class324.field3787.method7252();
                     } catch (Exception var8) {
                     }

                     class324.field3787 = null;
                  }

                  class324.field3787 = var11;
                  class42.method799(var12);
                  class324.field3776.field4878 = 0;
                  class116.field1137 = null;
                  class431.field4704 = null;
                  class324.field3790 = 0;

                  while(true) {
                     class335 var13 = (class335)class324.field3779.method7860();
                     if (var13 == null) {
                        while(true) {
                           var13 = (class335)class324.field3784.method7860();
                           if (null == var13) {
                              if (class324.field3792 != 0) {
                                 try {
                                    var4 = new class460(4);
                                    var4.method8097(4);
                                    var4.method8097(class324.field3792);
                                    var4.method8174(0);
                                    class324.field3787.method7251(var4.field4881, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class324.field3787.method7252();
                                    } catch (Exception var6) {
                                    }

                                    ++class324.field3775;
                                    class324.field3787 = null;
                                 }
                              }

                              class324.field3795 = 0;
                              class289.field3358 = class272.method2046();
                              class347.field4257 = null;
                              class312.field3697 = null;
                              field1663 = 0;
                              field1666 = 0;
                              return;
                           }

                           class324.field3781.method6572(var13);
                           class324.field3782.put(var13, var13.field4681);
                           ++class324.field3788;
                           --class324.field3777;
                        }
                     }

                     class324.field3794.put(var13, var13.field4681);
                     ++class324.field3778;
                     --class324.field3780;
                  }
               }
            } catch (IOException var9) {
               this.method3062(-3);
            }

         }
      }
   }

   void method3062(int var1) {
      class347.field4257 = null;
      class312.field3697 = null;
      field1663 = 0;
      if (class180.field1608 == class454.field4859) {
         class454.field4859 = class141.field1307;
      } else {
         class454.field4859 = class180.field1608;
      }

      ++field1666;
      if (field1666 >= 2 && (7 == var1 || var1 == 9)) {
         if (field1766 <= 5) {
            this.method473("js5connect_full");
            class9.method64(1000);
         } else {
            field1664 = 3000;
         }
      } else if (field1666 >= 2 && 6 == var1) {
         this.method473("js5connect_outofdate");
         class9.method64(1000);
      } else if (field1666 >= 4) {
         if (field1766 <= 5) {
            this.method473("js5connect");
            class9.method64(1000);
         } else {
            field1664 = 3000;
         }
      }

   }

   static void method5128(class336 var0, String var1) {
      class97 var3 = new class97(var0, var1);
      field1930.add(var3);
      field1731 += var3.field971;
   }

   static int method3449(int var0) {
      return var0 * 3 + 600;
   }

   static void method2904(class376 var0, class376 var1) {
      int var5;
      int var6;
      if (null == class289.field3357) {
         class336 var4 = class155.field1425;
         var5 = var4.method6116("sl_back");
         var6 = var4.method6162(var5, "");
         class473[] var3 = class397.method7198(var4, var5, var6);
         class289.field3357 = var3;
      }

      if (null == class200.field2206) {
         class200.field2206 = class475.method7364(class155.field1425, "sl_flags", "");
      }

      if (class84.field752 == null) {
         class84.field752 = class475.method7364(class155.field1425, "sl_arrows", "");
      }

      if (null == class207.field2367) {
         class207.field2367 = class475.method7364(class155.field1425, "sl_stars", "");
      }

      if (null == class227.field2723) {
         class227.field2723 = class393.method7158(class155.field1425, "leftarrow", "");
      }

      if (class7.field24 == null) {
         class7.field24 = class393.method7158(class155.field1425, "rightarrow", "");
      }

      class481.method8653(class75.field618, 23, 765, 480, 0);
      class481.method8679(class75.field618, 0, 125, 23, 12425273, 9135624);
      class481.method8679(125 + class75.field618, 0, 640, 23, 5197647, 2697513);
      var0.method6948(class338.field4054, 62 + class75.field618, 15, 0, -1);
      if (null != class207.field2367) {
         class207.field2367[1].method8748(class75.field618 + 140, 1);
         var1.method6868(class338.field4126, 152 + class75.field618, 10, 16777215, -1);
         class207.field2367[0].method8748(140 + class75.field618, 12);
         var1.method6868(class338.field4059, class75.field618 + 152, 21, 16777215, -1);
      }

      if (class84.field752 != null) {
         int var23 = class75.field618 + 280;
         if (class72.field585[0] == 0 && class72.field584[0] == 0) {
            class84.field752[2].method8748(var23, 4);
         } else {
            class84.field752[0].method8748(var23, 4);
         }

         if (class72.field585[0] == 0 && class72.field584[0] == 1) {
            class84.field752[3].method8748(var23 + 15, 4);
         } else {
            class84.field752[1].method8748(15 + var23, 4);
         }

         var0.method6868(class338.field4206, 32 + var23, 17, 16777215, -1);
         int var25 = 390 + class75.field618;
         if (class72.field585[0] == 1 && 0 == class72.field584[0]) {
            class84.field752[2].method8748(var25, 4);
         } else {
            class84.field752[0].method8748(var25, 4);
         }

         if (1 == class72.field585[0] && 1 == class72.field584[0]) {
            class84.field752[3].method8748(15 + var25, 4);
         } else {
            class84.field752[1].method8748(15 + var25, 4);
         }

         var0.method6868(class338.field4207, 32 + var25, 17, 16777215, -1);
         var5 = class75.field618 + 500;
         if (2 == class72.field585[0] && class72.field584[0] == 0) {
            class84.field752[2].method8748(var5, 4);
         } else {
            class84.field752[0].method8748(var5, 4);
         }

         if (2 == class72.field585[0] && 1 == class72.field584[0]) {
            class84.field752[3].method8748(var5 + 15, 4);
         } else {
            class84.field752[1].method8748(var5 + 15, 4);
         }

         var0.method6868(class338.field3925, var5 + 32, 17, 16777215, -1);
         var6 = 610 + class75.field618;
         if (class72.field585[0] == 3 && 0 == class72.field584[0]) {
            class84.field752[2].method8748(var6, 4);
         } else {
            class84.field752[0].method8748(var6, 4);
         }

         if (3 == class72.field585[0] && class72.field584[0] == 1) {
            class84.field752[3].method8748(var6 + 15, 4);
         } else {
            class84.field752[1].method8748(var6 + 15, 4);
         }

         var0.method6868(class338.field4202, var6 + 32, 17, 16777215, -1);
      }

      class481.method8653(708 + class75.field618, 4, 50, 16, 0);
      var1.method6948(class338.field4149, class75.field618 + 708 + 25, 16, 16777215, -1);
      class75.field626 = -1;
      if (null != class289.field3357) {
         byte var24 = 88;
         byte var26 = 19;
         var5 = 765 / (1 + var24) - 1;
         var6 = 480 / (var26 + 1);

         int var7;
         int var8;
         do {
            var7 = var6;
            var8 = var5;
            if (var6 * (var5 - 1) >= class72.field582) {
               --var5;
            }

            if (var5 * (var6 - 1) >= class72.field582) {
               --var6;
            }

            if ((var6 - 1) * var5 >= class72.field582) {
               --var6;
            }
         } while(var7 != var6 || var5 != var8);

         var7 = (765 - var24 * var5) / (1 + var5);
         if (var7 > 5) {
            var7 = 5;
         }

         var8 = (480 - var6 * var26) / (1 + var6);
         if (var8 > 5) {
            var8 = 5;
         }

         int var9 = (765 - var5 * var24 - var7 * (var5 - 1)) / 2;
         int var10 = (480 - var6 * var26 - var8 * (var6 - 1)) / 2;
         int var11 = (var6 + class72.field582 - 1) / var6;
         class75.field616 = var11 - var5;
         if (null != class227.field2723 && class75.field645 > 0) {
            class227.field2723.method8748(8, class12.field57 / 2 - class227.field2723.field5019 / 2);
         }

         if (null != class7.field24 && class75.field645 < class75.field616) {
            class7.field24.method8748(class31.field193 - class7.field24.field5017 - 8, class12.field57 / 2 - class7.field24.field5019 / 2);
         }

         int var12 = var10 + 23;
         int var13 = var9 + class75.field618;
         int var14 = 0;
         boolean var15 = false;
         int var16 = class75.field645;

         int var17;
         for(var17 = var16 * var6; var17 < class72.field582 && var16 - class75.field645 < var5; ++var17) {
            class72 var18 = class399.field4502[var17];
            boolean var19 = true;
            String var20 = Integer.toString(var18.field593);
            if (var18.field593 == -1) {
               var20 = class338.field4210;
               var19 = false;
            } else if (var18.field593 > 1980) {
               var20 = class338.field3891;
               var19 = false;
            }

            int var22 = 0;
            int var21;
            if (var18.method1454()) {
               if (var18.method1447()) {
                  var21 = class94.field930.field937;
               } else {
                  var21 = class94.field942.field937;
               }
            } else if (var18.method1442()) {
               var22 = 16711680;
               if (var18.method1447()) {
                  var21 = class94.field928.field937;
               } else {
                  var21 = class94.field927.field937;
               }
            } else if (var18.method1480()) {
               if (var18.method1447()) {
                  var21 = class94.field932.field937;
               } else {
                  var21 = class94.field941.field937;
               }
            } else if (var18.method1440()) {
               if (var18.method1447()) {
                  var21 = class94.field926.field937;
               } else {
                  var21 = class94.field925.field937;
               }
            } else if (var18.method1445()) {
               if (var18.method1447()) {
                  var21 = class94.field936.field937;
               } else {
                  var21 = class94.field933.field937;
               }
            } else if (var18.method1469()) {
               if (var18.method1447()) {
                  var21 = class94.field934.field937;
               } else {
                  var21 = class94.field935.field937;
               }
            } else if (var18.method1447()) {
               var21 = class94.field924.field937;
            } else {
               var21 = class94.field931.field937;
            }

            if (class42.field284 >= var13 && class42.field285 >= var12 && class42.field284 < var24 + var13 && class42.field285 < var12 + var26 && var19) {
               class75.field626 = var17;
               class289.field3357[var21].method8482(var13, var12, 128, 16777215);
               var15 = true;
            } else {
               class289.field3357[var21].method8476(var13, var12);
            }

            if (null != class200.field2206) {
               class200.field2206[(var18.method1447() ? 8 : 0) + var18.field580].method8748(var13 + 29, var12);
            }

            var0.method6948(Integer.toString(var18.field590), 15 + var13, var26 / 2 + var12 + 5, var22, -1);
            var1.method6948(var20, var13 + 60, var26 / 2 + var12 + 5, 268435455, -1);
            var12 += var8 + var26;
            ++var14;
            if (var14 >= var6) {
               var12 = var10 + 23;
               var13 += var7 + var24;
               var14 = 0;
               ++var16;
            }
         }

         if (var15) {
            var17 = var1.method6887(class399.field4502[class75.field626].field588) + 6;
            int var27 = 8 + var1.field4435;
            int var28 = class42.field285 + 25;
            if (var27 + var28 > 480) {
               var28 = class42.field285 - 25 - var27;
            }

            class481.method8653(class42.field284 - var17 / 2, var28, var17, var27, 16777120);
            class481.method8657(class42.field284 - var17 / 2, var28, var17, var27, 0);
            var1.method6948(class399.field4502[class75.field626].field588, class42.field284, var28 + var1.field4435 + 4, 0, -1);
         }
      }

      class6.field18.method8614(0, 0);
   }

   static void method3066(class72 var0) {
      if (var0.method1447() != field1635) {
         field1635 = var0.method1447();
         class198.method5207(var0.method1447());
      }

      if (field1633 != var0.field587) {
         class336 var2 = class155.field1425;
         int var3 = var0.field587;
         if ((var3 & 536870912) != 0) {
            class84.field745 = class393.method7158(var2, "logo_deadman_mode", "");
         } else if (0 != (var3 & 1073741824)) {
            class84.field745 = class393.method7158(var2, "logo_seasonal_mode", "");
         } else if (0 != (var3 & 256)) {
            class84.field745 = class393.method7158(var2, "logo_speedrunning", "");
         } else {
            class84.field745 = class393.method7158(var2, "logo", "");
         }
      }

      class271.field3032 = var0.field589;
      field1868 = var0.field590;
      field1633 = var0.field587;
      class180.field1608 = 0 == field1911 ? '\uaa4a' : '\u9c40' + var0.field590;
      class141.field1307 = 0 == field1911 ? 443 : '\uc350' + var0.field590;
      class454.field4859 = class180.field1608;
   }

   static class336 method5506(int var0, boolean var1, boolean var2, boolean var3, boolean var4) {
      class392 var6 = null;
      if (null != class163.field1503) {
         var6 = new class392(var0, class163.field1503, class163.field1510[var0], 1000000);
      }

      return new class336(var6, class227.field2721, var0, var1, var2, var3, var4);
   }

   final void method2882() {
      Object var2 = field1778.method2082();
      class453 var3 = field1778.field1076;

      try {
         if (field1667 == 0) {
            if (class147.field1355 == null && (field1685.method1278() || field1668 > 250)) {
               class147.field1355 = field1685.method1289();
               field1685.method1277();
               field1685 = null;
            }

            if (class147.field1355 != null) {
               if (null != var2) {
                  ((class401)var2).method7252();
                  var2 = null;
               }

               class231.field2748 = null;
               field1697 = false;
               field1668 = 0;
               if (field1758.method7931()) {
                  try {
                     this.method2876(class298.field3437);
                     class43.method801(21);
                  } catch (Throwable var18) {
                     class422.method7800((String)null, var18);
                     class112.method2169(65);
                     return;
                  }
               } else {
                  class43.method801(1);
               }
            }
         }

         class9 var20;
         if (21 == field1667) {
            if (this.field1681 != null) {
               if (!this.field1681.isDone()) {
                  return;
               }

               if (this.field1681.isCancelled()) {
                  class112.method2169(65);
                  this.field1681 = null;
                  return;
               }

               try {
                  RefreshAccessTokenResponse var4 = (RefreshAccessTokenResponse)this.field1681.get();
                  if (!var4.isSuccess()) {
                     class112.method2169(65);
                     this.field1681 = null;
                     return;
                  }

                  class310.field3689 = var4.getAccessToken();
                  class298.field3437 = var4.getRefreshToken();
                  this.field1681 = null;
               } catch (Exception var17) {
                  class422.method7800((String)null, var17);
                  class112.method2169(65);
                  this.field1681 = null;
                  return;
               }
            } else {
               if (null == this.field1679) {
                  class112.method2169(65);
                  return;
               }

               if (!this.field1679.method107()) {
                  return;
               }

               if (this.field1679.method119()) {
                  class422.method7800(this.field1679.method111(), (Throwable)null);
                  class112.method2169(65);
                  this.field1679 = null;
                  return;
               }

               var20 = this.field1679.method108();
               if (var20.method54() != 200) {
                  class112.method2169(65);
                  this.field1679 = null;
                  return;
               }

               field1668 = 0;
               class425 var5 = new class425(var20.method55());

               try {
                  class310.field3689 = var5.method7809().getString("access_token");
                  class298.field3437 = var5.method7809().getString("refresh_token");
               } catch (Exception var16) {
                  class422.method7800("Error parsing tokens", var16);
                  class112.method2169(65);
                  this.field1679 = null;
                  return;
               }
            }

            this.method2877(class310.field3689);
            class43.method801(20);
         }

         if (field1667 == 20) {
            if (null != this.field1677) {
               if (!this.field1677.isDone()) {
                  return;
               }

               if (this.field1677.isCancelled()) {
                  class112.method2169(65);
                  this.field1677 = null;
                  return;
               }

               try {
                  OtlTokenResponse var21 = (OtlTokenResponse)this.field1677.get();
                  if (!var21.isSuccess()) {
                     class112.method2169(65);
                     this.field1677 = null;
                     return;
                  }

                  this.field1673 = var21.getToken();
                  this.field1677 = null;
               } catch (Exception var15) {
                  class422.method7800((String)null, var15);
                  class112.method2169(65);
                  this.field1677 = null;
                  return;
               }
            } else {
               if (null == this.field1675) {
                  class112.method2169(65);
                  return;
               }

               if (!this.field1675.method107()) {
                  return;
               }

               if (this.field1675.method119()) {
                  class422.method7800(this.field1675.method111(), (Throwable)null);
                  class112.method2169(65);
                  this.field1675 = null;
                  return;
               }

               var20 = this.field1675.method108();
               if (var20.method54() != 200) {
                  class422.method7800("Response code: " + var20.method54() + "Response body: " + var20.method55(), (Throwable)null);
                  class112.method2169(65);
                  this.field1675 = null;
                  return;
               }

               this.field1673 = var20.method55();
               this.field1675 = null;
            }

            field1668 = 0;
            class43.method801(1);
         }

         if (field1667 == 1) {
            if (null == class231.field2748) {
               class231.field2748 = class31.field169.method2723(class271.field3032, class454.field4859);
            }

            if (class231.field2748.field1614 == 2) {
               throw new IOException();
            }

            if (class231.field2748.field1614 == 1) {
               Socket var22 = (Socket)class231.field2748.field1612;
               class409 var23 = new class409(var22, 40000, 5000);
               var2 = var23;
               field1778.method2097(var23);
               class231.field2748 = null;
               class43.method801(2);
            }
         }

         class263 var24;
         if (2 == field1667) {
            field1778.method2076();
            var24 = class263.method5167();
            var24.field2984.method8097(class261.field2976.field2979);
            field1778.method2078(var24);
            field1778.method2081();
            var3.field4878 = 0;
            class43.method801(3);
         }

         int var26;
         if (3 == field1667) {
            if (class91.field886 != null) {
               class91.field886.method378();
            }

            if (null != class88.field794) {
               class88.field794.method378();
            }

            if (((class401)var2).method7247(1)) {
               var26 = ((class401)var2).method7249();
               if (class91.field886 != null) {
                  class91.field886.method378();
               }

               if (class88.field794 != null) {
                  class88.field794.method378();
               }

               if (0 != var26) {
                  class112.method2169(var26);
                  return;
               }

               var3.field4878 = 0;
               class43.method801(4);
            }
         }

         if (field1667 == 4) {
            if (var3.field4878 < 8) {
               var26 = ((class401)var2).method7248();
               if (var26 > 8 - var3.field4878) {
                  var26 = 8 - var3.field4878;
               }

               if (var26 > 0) {
                  ((class401)var2).method7260(var3.field4881, var3.field4878, var26);
                  var3.field4878 += var26;
               }
            }

            if (8 == var3.field4878) {
               var3.field4878 = 0;
               class170.field1540 = var3.method8120();
               class43.method801(5);
            }
         }

         int var10;
         int var34;
         if (5 == field1667) {
            field1778.field1076.field4878 = 0;
            field1778.method2076();
            class453 var33 = new class453(500);
            int[] var25 = new int[]{class147.field1355.nextInt(), class147.field1355.nextInt(), class147.field1355.nextInt(), class147.field1355.nextInt()};
            var33.field4878 = 0;
            var33.method8097(1);
            var33.method8234(var25[0]);
            var33.method8234(var25[1]);
            var33.method8234(var25[2]);
            var33.method8234(var25[3]);
            var33.method8102(class170.field1540);
            int var12;
            if (40 == field1766) {
               var33.method8234(class119.field1157[0]);
               var33.method8234(class119.field1157[1]);
               var33.method8234(class119.field1157[2]);
               var33.method8234(class119.field1157[3]);
            } else {
               if (field1766 == 50) {
                  var33.method8097(class141.field1304.method6656());
                  var33.method8234(class158.field1451);
               } else {
                  var33.method8097(field1671.method6656());
                  switch(field1671.field1305) {
                  case 0:
                     LinkedHashMap var7 = class413.field4575.field744;
                     String var9 = class75.field633;
                     var10 = var9.length();
                     int var11 = 0;

                     for(var12 = 0; var12 < var10; ++var12) {
                        var11 = (var11 << 5) - var11 + var9.charAt(var12);
                     }

                     var33.method8234((Integer)var7.get(var11));
                     break;
                  case 1:
                  case 3:
                     var33.method8099(class340.field4220);
                     ++var33.field4878;
                  case 2:
                  default:
                     break;
                  case 4:
                     var33.field4878 += 4;
                  }
               }

               if (field1758.method7931()) {
                  var33.method8097(class445.field4787.method6656());
                  var33.method8104(this.field1673);
               } else {
                  var33.method8097(class445.field4791.method6656());
                  var33.method8104(class75.field650);
               }
            }

            var33.method8140(class62.field493, class62.field494);
            class119.field1157 = var25;
            class263 var6 = class263.method5167();
            var6.field2984.field4878 = 0;
            if (field1766 == 40) {
               var6.field2984.method8097(class261.field2975.field2979);
            } else {
               var6.field2984.method8097(class261.field2980.field2979);
            }

            var6.field2984.method8174(0);
            var34 = var6.field2984.field4878;
            var6.field2984.method8234(209);
            var6.field2984.method8234(1);
            var6.field2984.method8097(field1704);
            var6.field2984.method8097(field1716);
            byte var8 = 0;
            var6.field2984.method8097(var8);
            var6.field2984.method8107(var33.field4881, 0, var33.field4878);
            int var41 = var6.field2984.field4878;
            var6.field2984.method8104(class75.field633);
            var6.field2984.method8097((field1869 ? 1 : 0) << 1 | (field1636 ? 1 : 0));
            var6.field2984.method8174(class31.field193);
            var6.field2984.method8174(class12.field57);
            class296.method5544(var6.field2984);
            var6.field2984.method8104(class61.field481);
            var6.field2984.method8234(class11.field45);
            class460 var44 = new class460(class197.field2120.method7893());
            class197.field2120.method7896(var44);
            var6.field2984.method8107(var44.field4881, 0, var44.field4881.length);
            var6.field2984.method8097(field1704);
            var6.field2984.method8234(0);
            var6.field2984.method8148(class136.field1275.field3746);
            var6.field2984.method8234(class174.field1564.field3746);
            var6.field2984.method8346(class304.field3634.field3746);
            var6.field2984.method8234(class155.field1425.field3746);
            var6.field2984.method8148(class58.field417.field3746);
            var6.field2984.method8346(0);
            var6.field2984.method8164(class42.field295.field3746);
            var6.field2984.method8346(class147.field1352.field3746);
            var6.field2984.method8234(class243.field2846.field3746);
            var6.field2984.method8148(class139.field1286.field3746);
            var6.field2984.method8164(class324.field3783.field3746);
            var6.field2984.method8148(class43.field311.field3746);
            var6.field2984.method8346(class333.field3859.field3746);
            var6.field2984.method8164(class4.field12.field3746);
            var6.field2984.method8346(class252.field2922.field3746);
            var6.field2984.method8234(field1665.field3746);
            var6.field2984.method8164(class71.field578.field3746);
            var6.field2984.method8164(class371.field4369.field3746);
            var6.field2984.method8346(class145.field1338.field3746);
            var6.field2984.method8234(class11.field48.field3746);
            var6.field2984.method8164(class202.field2255.field3746);
            var6.field2984.method8138(var25, var41, var6.field2984.field4878);
            var6.field2984.method8110(var6.field2984.field4878 - var34);
            field1778.method2078(var6);
            field1778.method2081();
            field1778.field1071 = new class479(var25);
            int[] var45 = new int[4];

            for(var12 = 0; var12 < 4; ++var12) {
               var45[var12] = 50 + var25[var12];
            }

            var3.method7999(var45);
            class43.method801(6);
         }

         int var27;
         if (field1667 == 6 && ((class401)var2).method7248() > 0) {
            var26 = ((class401)var2).method7249();
            if (var26 == 61) {
               var27 = ((class401)var2).method7248();
               class87.field781 = 1 == var27 && ((class401)var2).method7249() == 1;
               class43.method801(5);
            }

            if (21 == var26 && field1766 == 20) {
               class43.method801(12);
            } else if (var26 == 2) {
               class43.method801(14);
            } else if (15 == var26 && 40 == field1766) {
               field1778.field1075 = -1;
               class43.method801(19);
            } else if (64 == var26) {
               class43.method801(10);
            } else if (var26 == 23 && field1669 < 1) {
               ++field1669;
               class43.method801(0);
            } else if (var26 == 29) {
               class43.method801(17);
            } else {
               if (var26 != 69) {
                  class112.method2169(var26);
                  return;
               }

               class43.method801(7);
            }
         }

         if (field1667 == 7 && ((class401)var2).method7248() >= 2) {
            ((class401)var2).method7260(var3.field4881, 0, 2);
            var3.field4878 = 0;
            class77.field669 = var3.method8115();
            class43.method801(8);
         }

         if (field1667 == 8 && ((class401)var2).method7248() >= class77.field669) {
            var3.field4878 = 0;
            ((class401)var2).method7260(var3.field4881, var3.field4878, class77.field669);
            class25[] var37 = new class25[]{class25.field122};
            class25 var28 = var37[var3.method8134()];

            try {
               class24 var29 = class8.method3967(var28);
               this.field1687 = new class4(var3, var29);
               class43.method801(9);
            } catch (Exception var14) {
               class112.method2169(22);
               return;
            }
         }

         if (9 == field1667 && this.field1687.method17()) {
            this.field1728 = this.field1687.method19();
            this.field1687.method18();
            this.field1687 = null;
            if (null == this.field1728) {
               class112.method2169(22);
               return;
            }

            field1778.method2076();
            var24 = class263.method5167();
            var24.field2984.method8097(class261.field2977.field2979);
            var24.field2984.method8174(this.field1728.field4878);
            var24.field2984.method8108(this.field1728);
            field1778.method2078(var24);
            field1778.method2081();
            this.field1728 = null;
            class43.method801(6);
         }

         if (field1667 == 10 && ((class401)var2).method7248() > 0) {
            class195.field2104 = ((class401)var2).method7249();
            class43.method801(11);
         }

         if (field1667 == 11 && ((class401)var2).method7248() >= class195.field2104) {
            ((class401)var2).method7260(var3.field4881, 0, class195.field2104);
            var3.field4878 = 0;
            class43.method801(6);
         }

         if (field1667 == 12 && ((class401)var2).method7248() > 0) {
            field1717 = (((class401)var2).method7249() + 3) * 60;
            class43.method801(13);
         }

         if (field1667 == 13) {
            field1668 = 0;
            class75.method5452(class338.field4083, class338.field3943, field1717 / 60 + class338.field3935);
            if (--field1717 <= 0) {
               class43.method801(0);
            }

         } else {
            if (14 == field1667 && ((class401)var2).method7248() >= 1) {
               class77.field662 = ((class401)var2).method7249();
               class43.method801(15);
            }

            if (field1667 == 15 && ((class401)var2).method7248() >= class77.field662) {
               boolean var39 = ((class401)var2).method7249() == 1;
               ((class401)var2).method7260(var3.field4881, 0, 4);
               var3.field4878 = 0;
               boolean var30 = false;
               if (var39) {
                  var27 = var3.method8002() << 24;
                  var27 |= var3.method8002() << 16;
                  var27 |= var3.method8002() << 8;
                  var27 |= var3.method8002();
                  String var35 = class75.field633;
                  int var38 = var35.length();
                  Iterator var43;
                  var10 = 0;

                  while(true) {
                     if (var10 >= var38) {
                        if (class413.field4575.field744.size() >= 10 && !class413.field4575.field744.containsKey(var38)) {
                           var43 = class413.field4575.field744.entrySet().iterator();
                           var43.next();
                           var43.remove();
                        }

                        class413.field4575.field744.put(var38, var27);
                        break;
                     }

                     var38 = (var38 << 5) - var38 + var35.charAt(var10);
                     ++var10;
                  }
               }

               if (field1891) {
                  class413.field4575.method1710(class75.field633);
               } else {
                  class413.field4575.method1710((String)null);
               }

               class151.method2592();
               field1750 = ((class401)var2).method7249();
               field1820 = ((class401)var2).method7249() == 1;
               field1764 = ((class401)var2).method7249();
               field1764 <<= 8;
               field1764 += ((class401)var2).method7249();
               field1921 = ((class401)var2).method7249();
               ((class401)var2).method7260(var3.field4881, 0, 8);
               var3.field4878 = 0;
               this.field1688 = var3.method8120();
               if (class77.field662 >= 29) {
                  ((class401)var2).method7260(var3.field4881, 0, 8);
                  var3.field4878 = 0;
                  field1632 = var3.method8120();
               }

               ((class401)var2).method7260(var3.field4881, 0, 1);
               var3.field4878 = 0;
               class283[] var31 = class283.method2743();
               var34 = var3.method8004();
               if (var34 < 0 || var34 >= var31.length) {
                  throw new IOException(var34 + " " + var3.field4878);
               }

               field1778.field1073 = var31[var34];
               field1778.field1075 = field1778.field1073.field3240;
               ((class401)var2).method7260(var3.field4881, 0, 2);
               var3.field4878 = 0;
               field1778.field1075 = var3.method8115();

               try {
                  class40.method756(class133.field1257, "zap");
               } catch (Throwable var13) {
               }

               class43.method801(16);
            }

            if (field1667 != 16) {
               if (17 == field1667 && ((class401)var2).method7248() >= 2) {
                  var3.field4878 = 0;
                  ((class401)var2).method7260(var3.field4881, 0, 2);
                  var3.field4878 = 0;
                  class135.field1268 = var3.method8115();
                  class43.method801(18);
               }

               if (field1667 == 18 && ((class401)var2).method7248() >= class135.field1268) {
                  var3.field4878 = 0;
                  ((class401)var2).method7260(var3.field4881, 0, class135.field1268);
                  var3.field4878 = 0;
                  String var47 = var3.method8124();
                  String var42 = var3.method8124();
                  String var36 = var3.method8124();
                  class75.method5452(var47, var42, var36);
                  class9.method64(10);
                  if (field1758.method7931()) {
                     class74.method1490(9);
                  }
               }

               if (19 == field1667) {
                  if (-1 == field1778.field1075) {
                     if (((class401)var2).method7248() < 2) {
                        return;
                     }

                     ((class401)var2).method7260(var3.field4881, 0, 2);
                     var3.field4878 = 0;
                     field1778.field1075 = var3.method8115();
                  }

                  if (((class401)var2).method7248() >= field1778.field1075) {
                     ((class401)var2).method7260(var3.field4881, 0, field1778.field1075);
                     var3.field4878 = 0;
                     var26 = field1778.field1075;
                     field1698.method6826();
                     class228.method4526();
                     class102.method4730(var3);
                     if (var26 != var3.field4878) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field1668;
                  if (field1668 > 2000) {
                     if (field1669 < 1) {
                        if (class180.field1608 == class454.field4859) {
                           class454.field4859 = class141.field1307;
                        } else {
                           class454.field4859 = class180.field1608;
                        }

                        ++field1669;
                        class43.method801(0);
                     } else {
                        class112.method2169(-3);
                     }
                  }
               }
            } else {
               if (((class401)var2).method7248() >= field1778.field1075) {
                  var3.field4878 = 0;
                  ((class401)var2).method7260(var3.field4881, 0, field1778.field1075);
                  field1698.method6839();
                  field1646 = -1L;
                  class74.field610.field747 = 0;
                  class71.field574 = true;
                  field1650 = true;
                  field1881 = -1L;
                  class45.method333();
                  field1778.method2076();
                  field1778.field1076.field4878 = 0;
                  field1778.field1073 = null;
                  field1778.field1079 = null;
                  field1778.field1072 = null;
                  field1778.field1080 = null;
                  field1778.field1075 = 0;
                  field1778.field1070 = 0;
                  field1651 = 0;
                  field1696 = 0;
                  field1652 = 0;
                  field1695 = 0;
                  field1784 = false;
                  class42.field278 = 0;
                  class110.field1093.clear();
                  class110.field1089.method7775();
                  class110.field1088.method6590();
                  class110.field1091 = 0;
                  field1802 = 0;
                  field1804 = false;
                  field1894 = 0;
                  field1672 = 0;
                  field1722 = 0;
                  class335.field3867 = null;
                  field1709 = 0;
                  field1662 = -1;
                  field1889 = 0;
                  field1890 = 0;
                  field1812 = class80.field703;
                  field1850 = class80.field703;
                  field1691 = 0;
                  class102.field1012 = 0;

                  for(var26 = 0; var26 < 2048; ++var26) {
                     class102.field1011[var26] = null;
                     class102.field1010[var26] = class197.field2114;
                  }

                  for(var26 = 0; var26 < 2048; ++var26) {
                     field1763[var26] = null;
                  }

                  for(var26 = 0; var26 < 65536; ++var26) {
                     field1902[var26] = null;
                  }

                  field1775 = -1;
                  field1853.method6346();
                  field1779.method6346();

                  for(var26 = 0; var26 < 4; ++var26) {
                     for(var27 = 0; var27 < 104; ++var27) {
                        for(int var32 = 0; var32 < 104; ++var32) {
                           field1865[var26][var27][var32] = null;
                        }
                     }
                  }

                  field1777 = new class343();
                  class217.field2588.method1048();

                  for(var26 = 0; var26 < class178.field1592; ++var26) {
                     class178 var40 = class274.method5221(var26);
                     if (var40 != null) {
                        class293.field3368[var26] = 0;
                        class293.field3370[var26] = 0;
                     }
                  }

                  class66.field538.method2310();
                  field1819 = -1;
                  if (field1893 != -1) {
                     class257.method5138(field1893);
                  }

                  for(class89 var46 = (class89)field1810.method7860(); null != var46; var46 = (class89)field1810.method7851()) {
                     class4.method32(var46, true);
                  }

                  field1893 = -1;
                  field1810 = new class434(8);
                  field1641 = null;
                  field1695 = 0;
                  field1784 = false;
                  field1920.method5990((int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

                  for(var26 = 0; var26 < 8; ++var26) {
                     field1772[var26] = null;
                     field1755[var26] = false;
                  }

                  class87.method2410();
                  field1828 = true;

                  for(var26 = 0; var26 < 100; ++var26) {
                     field1860[var26] = true;
                  }

                  method206();
                  class73.field603 = null;
                  class127.field1224 = null;
                  Arrays.fill(field1738, (Object)null);
                  class188.field1982 = null;
                  Arrays.fill(field1883, (Object)null);

                  for(var26 = 0; var26 < 8; ++var26) {
                     field1924[var26] = new class347();
                  }

                  class242.field2835 = null;
                  class102.method4730(var3);
                  class361.field4314 = -1;
                  class25.method344(false, var3);
                  field1778.field1073 = null;
               }

            }
         }
      } catch (IOException var19) {
         if (field1669 < 1) {
            if (class180.field1608 == class454.field4859) {
               class454.field4859 = class141.field1307;
            } else {
               class454.field4859 = class180.field1608;
            }

            ++field1669;
            class43.method801(0);
         } else {
            class112.method2169(-2);
         }
      }
   }

   static long method2417() {
      return field1632;
   }

   static final void method2354() {
      class199.field2183.method5437();
      class185.method2597();
      class182.method2825();
      class195.method2401();
      class203.method334();
      class198.method4555();
      class189.method2113();
      class207.method1967();
      class184.field1947.method5437();
      class178.method2666();
      class28.field148.method7951();
      class191.field2026.method7951();
      class206.field2330.method5437();
      class206.field2331.method5437();
      class206.field2332.method5437();
      class158.field1456.method5437();
      class158.field1443.method5437();
      class187.field1977.method5437();
      class193.method6189();
      class160.method1424();
      class458.field4871.method5437();
      class452.field4852.method5437();
      field1926.method5437();
      field1927.method5437();
      class305.method3577();
      class300.method5837();
      ((class215)class221.field2629).method4312();
      class78.field675.method5437();
      class139.field1286.method6109();
      class42.field295.method6109();
      class333.field3859.method6109();
      class11.field48.method6109();
      class58.field417.method6109();
      class43.field311.method6109();
      class252.field2922.method6109();
      class155.field1425.method6109();
      field1665.method6109();
      class243.field2846.method6109();
      class4.field12.method6109();
      class202.field2255.method6109();
      class255.field2944.method6109();
   }

   static final void method4611() {
      if (field1696 > 0) {
         class368.method6724();
      } else {
         field1698.method6823();
         class9.method64(40);
         class218.field2589 = field1778.method2082();
         field1778.method2100();
      }
   }

   final void method2883() {
      if (field1651 > 1) {
         --field1651;
      }

      if (field1696 > 0) {
         --field1696;
      }

      if (field1697) {
         field1697 = false;
         method4611();
      } else {
         if (!field1784) {
            method5549();
         }

         int var2;
         for(var2 = 0; var2 < 100 && this.method2888(field1778); ++var2) {
         }

         if (30 == field1766) {
            while(true) {
               class43 var3 = (class43)class45.field329.method6457();
               boolean var17;
               if (var3 == null) {
                  var17 = false;
               } else {
                  var17 = true;
               }

               int var4;
               class263 var18;
               if (!var17) {
                  class263 var19;
                  int var20;
                  if (field1698.field4413) {
                     var19 = class185.method3435(class274.field3066, field1778.field1071);
                     var19.field2984.method8097(0);
                     var20 = var19.field2984.field4878;
                     field1698.method6827(var19.field2984);
                     var19.field2984.method8144(var19.field2984.field4878 - var20);
                     field1778.method2078(var19);
                     field1698.method6825();
                  }

                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  int var13;
                  synchronized(class74.field610.field755) {
                     if (!field1660) {
                        class74.field610.field747 = 0;
                     } else if (0 != class42.field277 || class74.field610.field747 >= 40) {
                        var18 = null;
                        var4 = 0;
                        var5 = 0;
                        var6 = 0;
                        var7 = 0;

                        for(var8 = 0; var8 < class74.field610.field747 && (null == var18 || var18.field2984.field4878 - var4 < 246); ++var8) {
                           var5 = var8;
                           var9 = class74.field610.field750[var8];
                           if (var9 < -1) {
                              var9 = -1;
                           } else if (var9 > 65534) {
                              var9 = 65534;
                           }

                           var10 = class74.field610.field748[var8];
                           if (var10 < -1) {
                              var10 = -1;
                           } else if (var10 > 65534) {
                              var10 = 65534;
                           }

                           if (field1647 != var10 || field1773 != var9) {
                              if (var18 == null) {
                                 var18 = class185.method3435(class274.field3118, field1778.field1071);
                                 var18.field2984.method8097(0);
                                 var4 = var18.field2984.field4878;
                                 class453 var10000 = var18.field2984;
                                 var10000.field4878 += 2;
                                 var6 = 0;
                                 var7 = 0;
                              }

                              if (-1L != field1644) {
                                 var11 = var10 - field1647;
                                 var12 = var9 - field1773;
                                 var13 = (int)((class74.field610.field754[var8] - field1644) / 20L);
                                 var6 = (int)((long)var6 + (class74.field610.field754[var8] - field1644) % 20L);
                              } else {
                                 var11 = var10;
                                 var12 = var9;
                                 var13 = Integer.MAX_VALUE;
                              }

                              field1647 = var10;
                              field1773 = var9;
                              if (var13 < 8 && var11 >= -32 && var11 <= 31 && var12 >= -32 && var12 <= 31) {
                                 var11 += 32;
                                 var12 += 32;
                                 var18.field2984.method8174((var11 << 6) + (var13 << 12) + var12);
                              } else if (var13 < 32 && var11 >= -128 && var11 <= 127 && var12 >= -128 && var12 <= 127) {
                                 var11 += 128;
                                 var12 += 128;
                                 var18.field2984.method8097(128 + var13);
                                 var18.field2984.method8174((var11 << 8) + var12);
                              } else if (var13 < 32) {
                                 var18.field2984.method8097(192 + var13);
                                 if (-1 != var10 && -1 != var9) {
                                    var18.field2984.method8234(var10 | var9 << 16);
                                 } else {
                                    var18.field2984.method8234(Integer.MIN_VALUE);
                                 }
                              } else {
                                 var18.field2984.method8174((var13 & 8191) + '\ue000');
                                 if (var10 != -1 && -1 != var9) {
                                    var18.field2984.method8234(var10 | var9 << 16);
                                 } else {
                                    var18.field2984.method8234(Integer.MIN_VALUE);
                                 }
                              }

                              ++var7;
                              field1644 = class74.field610.field754[var8];
                           }
                        }

                        if (var18 != null) {
                           var18.field2984.method8144(var18.field2984.field4878 - var4);
                           var8 = var18.field2984.field4878;
                           var18.field2984.field4878 = var4;
                           var18.field2984.method8097(var6 / var7);
                           var18.field2984.method8097(var6 % var7);
                           var18.field2984.field4878 = var8;
                           field1778.method2078(var18);
                        }

                        if (var5 >= class74.field610.field747) {
                           class74.field610.field747 = 0;
                        } else {
                           class84 var53 = class74.field610;
                           var53.field747 -= var5;
                           System.arraycopy(class74.field610.field748, var5, class74.field610.field748, 0, class74.field610.field747);
                           System.arraycopy(class74.field610.field750, var5, class74.field610.field750, 0, class74.field610.field747);
                           System.arraycopy(class74.field610.field754, var5, class74.field610.field754, 0, class74.field610.field747);
                        }
                     }
                  }

                  if (class42.field277 == 1 || !class95.field944 && class42.field277 == 4 || class42.field277 == 2) {
                     long var21 = class42.field279 - field1646;
                     if (var21 > 32767L) {
                        var21 = 32767L;
                     }

                     field1646 = class42.field279;
                     var4 = class42.field293;
                     if (var4 < 0) {
                        var4 = 0;
                     } else if (var4 > class12.field57) {
                        var4 = class12.field57;
                     }

                     var5 = class42.field283;
                     if (var5 < 0) {
                        var5 = 0;
                     } else if (var5 > class31.field193) {
                        var5 = class31.field193;
                     }

                     var6 = (int)var21;
                     class263 var29 = class185.method3435(class274.field3094, field1778.field1071);
                     var29.field2984.method8174((var6 << 1) + (class42.field277 == 2 ? 1 : 0));
                     var29.field2984.method8174(var5);
                     var29.field2984.method8174(var4);
                     field1778.method2078(var29);
                  }

                  if (field1876.field2312 > 0) {
                     var19 = class185.method3435(class274.field3047, field1778.field1071);
                     var19.field2984.method8174(0);
                     var20 = var19.field2984.field4878;
                     long var22 = class272.method2046();

                     for(var6 = 0; var6 < field1876.field2312; ++var6) {
                        long var32 = var22 - field1881;
                        if (var32 > 16777215L) {
                           var32 = 16777215L;
                        }

                        field1881 = var22;
                        var19.field2984.method8160((int)var32);
                        var19.field2984.method8145(field1876.field2311[var6]);
                     }

                     var19.field2984.method8110(var19.field2984.field4878 - var20);
                     field1778.method2078(var19);
                  }

                  if (field1922 > 0) {
                     --field1922;
                  }

                  if (field1876.method3895(96) || field1876.method3895(97) || field1876.method3895(98) || field1876.method3895(99)) {
                     field1732 = true;
                  }

                  if (field1732 && field1922 <= 0) {
                     field1922 = 20;
                     field1732 = false;
                     var19 = class185.method3435(class274.field3077, field1778.field1071);
                     var19.field2984.method8174(field1761);
                     var19.field2984.method8152(field1672);
                     field1778.method2078(var19);
                  }

                  if (class71.field574 && !field1650) {
                     field1650 = true;
                     var19 = class185.method3435(class274.field3059, field1778.field1071);
                     var19.field2984.method8097(1);
                     field1778.method2078(var19);
                  }

                  if (!class71.field574 && field1650) {
                     field1650 = false;
                     var19 = class185.method3435(class274.field3059, field1778.field1071);
                     var19.field2984.method8097(0);
                     field1778.method2078(var19);
                  }

                  if (null != class4.field10) {
                     class4.field10.method7568();
                  }

                  class64.method1378();
                  if (class145.field1335) {
                     method602();
                     class145.field1335 = false;
                  }

                  if (field1662 != class55.field396) {
                     field1662 = class55.field396;
                     class262.method5148(class55.field396);
                  }

                  if (30 != field1766) {
                     return;
                  }

                  for(class101 var23 = (class101)field1777.method6356(); var23 != null; var23 = (class101)field1777.method6350()) {
                     if (var23.field1003 > 0) {
                        --var23.field1003;
                     }

                     if (var23.field1003 == 0) {
                        if (var23.field995 < 0 || class47.method962(var23.field995, var23.field997)) {
                           class331.method6252(var23.field993, var23.field992, var23.field999, var23.field994, var23.field995, var23.field996, var23.field997);
                           var23.remove();
                        }
                     } else {
                        if (var23.field1006 > 0) {
                           --var23.field1006;
                        }

                        if (var23.field1006 == 0 && var23.field999 >= 1 && var23.field994 >= 1 && var23.field999 <= 102 && var23.field994 <= 102 && (var23.field998 < 0 || class47.method962(var23.field998, var23.field1000))) {
                           class331.method6252(var23.field993, var23.field992, var23.field999, var23.field994, var23.field998, var23.field991, var23.field1000);
                           var23.field1006 = -1;
                           if (var23.field995 == var23.field998 && -1 == var23.field995) {
                              var23.remove();
                           } else if (var23.field995 == var23.field998 && var23.field996 == var23.field991 && var23.field997 == var23.field1000) {
                              var23.remove();
                           }
                        }
                     }
                  }

                  int var10002;
                  for(var2 = 0; var2 < field1894; ++var2) {
                     var10002 = field1897[var2]--;
                     if (field1897[var2] >= -10) {
                        class33 var24 = field1899[var2];
                        if (var24 == null) {
                           class33 var54 = (class33)null;
                           var24 = class33.method610(class11.field48, field1895[var2], 0);
                           if (var24 == null) {
                              continue;
                           }

                           int[] var55 = field1897;
                           var55[var2] += var24.method606();
                           field1899[var2] = var24;
                        }

                        if (field1897[var2] < 0) {
                           if (field1734[var2] != 0) {
                              var5 = (field1734[var2] & 255) * 128;
                              var6 = field1734[var2] >> 16 & 255;
                              var7 = var6 * 128 + 64 - class291.field3364.field827;
                              if (var7 < 0) {
                                 var7 = -var7;
                              }

                              var8 = field1734[var2] >> 8 & 255;
                              var9 = 64 + 128 * var8 - class291.field3364.field802;
                              if (var9 < 0) {
                                 var9 = -var9;
                              }

                              var10 = var9 + var7 - 128;
                              if (var10 > var5) {
                                 field1897[var2] = -100;
                                 continue;
                              }

                              if (var10 < 0) {
                                 var10 = 0;
                              }

                              var4 = (var5 - var10) * class413.field4575.method1736() / var5;
                           } else {
                              var4 = class413.field4575.method1752();
                           }

                           if (var4 > 0) {
                              RawSound var25 = var24.method605().method752(class233.field2759);
                              class44 var33 = class44.method829(var25, 100, var4);
                              var33.method813(field1896[var2] - 1);
                              class451.field4849.method718(var33);
                           }

                           field1897[var2] = -100;
                        }
                     } else {
                        --field1894;

                        for(var20 = var2; var20 < field1894; ++var20) {
                           field1895[var20] = field1895[var20 + 1];
                           field1899[var20] = field1899[1 + var20];
                           field1896[var20] = field1896[var20 + 1];
                           field1897[var20] = field1897[1 + var20];
                           field1734[var20] = field1734[1 + var20];
                        }

                        --var2;
                     }
                  }

                  if (field1781) {
                     if (0 != class279.field3202) {
                        var17 = true;
                     } else {
                        var17 = class279.midiPcmStream.method5278();
                     }

                     if (!var17) {
                        if (class413.field4575.method1716() != 0 && -1 != field1748) {
                           class279.method332(class43.field311, field1748, 0, class413.field4575.method1716(), false);
                        }

                        field1781 = false;
                     }
                  }

                  ++field1778.field1070;
                  if (field1778.field1070 > 750) {
                     method4611();
                     return;
                  }

                  var2 = class102.field1012;
                  int[] var27 = class102.field1013;

                  for(var4 = 0; var4 < var2; ++var4) {
                     class93 var26 = field1763[var27[var4]];
                     if (var26 != null) {
                        class25.method341(var26, 1);
                     }
                  }

                  for(var2 = 0; var2 < field1691; ++var2) {
                     var20 = field1692[var2];
                     class81 var30 = field1902[var20];
                     if (var30 != null) {
                        class25.method341(var30, var30.field709.field2262);
                     }
                  }

                  int[] var41 = class102.field1013;

                  for(var20 = 0; var20 < class102.field1012; ++var20) {
                     class93 var34 = field1763[var41[var20]];
                     if (null != var34 && var34.field843 > 0) {
                        --var34.field843;
                        if (0 == var34.field843) {
                           var34.field822 = null;
                        }
                     }
                  }

                  for(var20 = 0; var20 < field1691; ++var20) {
                     var4 = field1692[var20];
                     class81 var28 = field1902[var4];
                     if (var28 != null && var28.field843 > 0) {
                        --var28.field843;
                        if (0 == var28.field843) {
                           var28.field822 = null;
                        }
                     }
                  }

                  ++field1701;
                  if (field1751 != 0) {
                     field1904 += 20;
                     if (field1904 >= 400) {
                        field1751 = 0;
                     }
                  }

                  if (null != class132.field1247) {
                     ++field1840;
                     if (field1840 >= 15) {
                        class136.method2438(class132.field1247);
                        class132.field1247 = null;
                     }
                  }

                  class300 var43 = class219.field2616;
                  class300 var39 = class219.field2617;
                  class219.field2616 = null;
                  class219.field2617 = null;
                  field1826 = null;
                  field1783 = false;
                  field1827 = false;
                  field1822 = 0;

                  while(field1876.method3911() && field1822 < 128) {
                     if (field1750 >= 2 && field1876.method3895(82) && field1876.field2317 == 66) {
                        StringBuilder var31 = new StringBuilder();

                        class63 var44;
                        for(Iterator var36 = class110.field1089.iterator(); var36.hasNext(); var31.append(var44.field503).append('\n')) {
                           var44 = (class63)var36.next();
                           if (var44.field500 != null && !var44.field500.isEmpty()) {
                              var31.append(var44.field500).append(':');
                           }
                        }

                        String var37 = var31.toString();
                        class133.field1257.method463(var37);
                     } else if (1 != field1722 || field1876.field2321 <= 0) {
                        field1880[field1822] = field1876.field2317;
                        field1756[field1822] = field1876.field2321;
                        ++field1822;
                     }
                  }

                  if (class114.method2218() && field1876.method3895(82) && field1876.method3895(81) && field1639 != 0) {
                     var4 = class291.field3364.field914 - field1639;
                     if (var4 < 0) {
                        var4 = 0;
                     } else if (var4 > 3) {
                        var4 = 3;
                     }

                     if (class291.field3364.field914 != var4) {
                        class136.method2439(class291.field3364.field861[0] + class36.field241, class169.field1536 + class291.field3364.field873[0], var4, false);
                     }

                     field1639 = 0;
                  }

                  if (1 == class42.field277) {
                     field1877.method3521();
                  }

                  if (-1 != field1893) {
                     method5127(field1893, 0, 0, class31.field193, class12.field57, 0, 0);
                  }

                  ++field1878;

                  while(true) {
                     class300 var35;
                     class300 var38;
                     class79 var47;
                     do {
                        var47 = (class79)field1854.method6367();
                        if (null == var47) {
                           while(true) {
                              do {
                                 var47 = (class79)field1813.method6367();
                                 if (null == var47) {
                                    while(true) {
                                       do {
                                          var47 = (class79)field1765.method6367();
                                          if (null == var47) {
                                             while(true) {
                                                class188 var49 = (class188)field1856.method6367();
                                                if (var49 == null) {
                                                   this.method2889();
                                                   class260.method5145();
                                                   if (field1874 != null) {
                                                      this.method2894();
                                                   }

                                                   class263 var46;
                                                   if (class183.field1943 != null) {
                                                      class136.method2438(class183.field1943);
                                                      ++field1786;
                                                      if (class42.field289 == 0) {
                                                         if (field1759) {
                                                            if (class183.field1943 == class165.field1523 && field1737 != field1892) {
                                                               class300 var51 = class183.field1943;
                                                               byte var40 = 0;
                                                               if (field1814 == 1 && 206 == var51.field3464) {
                                                                  var40 = 1;
                                                               }

                                                               if (var51.field3461[field1892] <= 0) {
                                                                  var40 = 0;
                                                               }

                                                               var7 = class190.method3528(var51);
                                                               boolean var45 = 0 != (var7 >> 29 & 1);
                                                               if (var45) {
                                                                  var8 = field1737;
                                                                  var9 = field1892;
                                                                  var51.field3461[var9] = var51.field3461[var8];
                                                                  var51.field3456[var9] = var51.field3456[var8];
                                                                  var51.field3461[var8] = -1;
                                                                  var51.field3456[var8] = 0;
                                                               } else if (1 == var40) {
                                                                  var8 = field1737;
                                                                  var9 = field1892;

                                                                  while(var8 != var9) {
                                                                     if (var8 > var9) {
                                                                        var51.method5843(var8 - 1, var8);
                                                                        --var8;
                                                                     } else if (var8 < var9) {
                                                                        var51.method5843(1 + var8, var8);
                                                                        ++var8;
                                                                     }
                                                                  }
                                                               } else {
                                                                  var51.method5843(field1892, field1737);
                                                               }

                                                               var46 = class185.method3435(class274.field3100, field1778.field1071);
                                                               var46.field2984.method8346(class183.field1943.field3517);
                                                               var46.field2984.method8145(var40);
                                                               var46.field2984.method8154(field1737);
                                                               var46.field2984.method8174(field1892);
                                                               field1778.method2078(var46);
                                                            }
                                                         } else if (this.method2890()) {
                                                            this.method3357(field1638, field1757);
                                                         } else if (field1695 > 0) {
                                                            var4 = field1638;
                                                            var5 = field1757;
                                                            class73 var42 = class101.field1005;
                                                            if (null != var42) {
                                                               class263.method5159(var42.field600, var42.field595, var42.field594, var42.field597, var42.field598, var42.field599, var42.field604, var4, var5);
                                                            }

                                                            class101.field1005 = null;
                                                         }

                                                         field1840 = 10;
                                                         class42.field277 = 0;
                                                         class183.field1943 = null;
                                                      } else if (field1786 >= 5 && (class42.field284 > field1638 + 5 || class42.field284 < field1638 - 5 || class42.field285 > field1757 + 5 || class42.field285 < field1757 - 5)) {
                                                         field1759 = true;
                                                      }
                                                   }

                                                   if (class214.method4161()) {
                                                      var4 = class214.field2508;
                                                      var5 = class214.field2530;
                                                      class263 var48 = class185.method3435(class274.field3134, field1778.field1071);
                                                      var48.field2984.method8097(5);
                                                      var48.field2984.method8154(class169.field1536 + var5);
                                                      var48.field2984.method8257(field1876.method3895(82) ? (field1876.method3895(81) ? 2 : 1) : 0);
                                                      var48.field2984.method8330(var4 + class36.field241);
                                                      field1778.method2078(var48);
                                                      class214.method4162();
                                                      field1657 = class42.field283;
                                                      field1749 = class42.field293;
                                                      field1751 = 1;
                                                      field1904 = 0;
                                                      field1889 = var4;
                                                      field1890 = var5;
                                                   }

                                                   if (var43 != class219.field2616) {
                                                      if (null != var43) {
                                                         class136.method2438(var43);
                                                      }

                                                      if (class219.field2616 != null) {
                                                         class136.method2438(class219.field2616);
                                                      }
                                                   }

                                                   if (var39 != class219.field2617 && field1670 == field1929) {
                                                      if (var39 != null) {
                                                         class136.method2438(var39);
                                                      }

                                                      if (class219.field2617 != null) {
                                                         class136.method2438(class219.field2617);
                                                      }
                                                   }

                                                   if (null != class219.field2617) {
                                                      if (field1670 < field1929) {
                                                         ++field1670;
                                                         if (field1929 == field1670) {
                                                            class136.method2438(class219.field2617);
                                                         }
                                                      }
                                                   } else if (field1670 > 0) {
                                                      --field1670;
                                                   }

                                                   if (0 == field1722) {
                                                      var4 = class291.field3364.field827;
                                                      var5 = class291.field3364.field802;
                                                      if (class32.field203 - var4 < -500 || class32.field203 - var4 > 500 || class101.field1004 - var5 < -500 || class101.field1004 - var5 > 500) {
                                                         class32.field203 = var4;
                                                         class101.field1004 = var5;
                                                      }

                                                      if (class32.field203 != var4) {
                                                         class32.field203 += (var4 - class32.field203) / 16;
                                                      }

                                                      if (var5 != class101.field1004) {
                                                         class101.field1004 += (var5 - class101.field1004) / 16;
                                                      }

                                                      var6 = class32.field203 >> 7;
                                                      var7 = class101.field1004 >> 7;
                                                      var8 = class144.method2498(class32.field203, class101.field1004, class55.field396);
                                                      var9 = 0;
                                                      if (var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                         for(var10 = var6 - 4; var10 <= 4 + var6; ++var10) {
                                                            for(var11 = var7 - 4; var11 <= 4 + var7; ++var11) {
                                                               var12 = class55.field396;
                                                               if (var12 < 3 && 2 == (class82.field714[1][var10][var11] & 2)) {
                                                                  ++var12;
                                                               }

                                                               var13 = var8 - class82.field719[var12][var10][var11];
                                                               if (var13 > var9) {
                                                                  var9 = var13;
                                                               }
                                                            }
                                                         }
                                                      }

                                                      var10 = 192 * var9;
                                                      if (var10 > 98048) {
                                                         var10 = 98048;
                                                      }

                                                      if (var10 < 32768) {
                                                         var10 = 32768;
                                                      }

                                                      if (var10 > field1733) {
                                                         field1733 += (var10 - field1733) / 24;
                                                      } else if (var10 < field1733) {
                                                         field1733 += (var10 - field1733) / 80;
                                                      }

                                                      class178.field1595 = class144.method2498(class291.field3364.field827, class291.field3364.field802, class55.field396) - field1723;
                                                   } else if (field1722 == 1) {
                                                      class121.method2285();
                                                      short var52 = -1;
                                                      if (field1876.method3895(33)) {
                                                         var52 = 0;
                                                      } else if (field1876.method3895(49)) {
                                                         var52 = 1024;
                                                      }

                                                      if (field1876.method3895(48)) {
                                                         if (0 == var52) {
                                                            var52 = 1792;
                                                         } else if (var52 == 1024) {
                                                            var52 = 1280;
                                                         } else {
                                                            var52 = 1536;
                                                         }
                                                      } else if (field1876.method3895(50)) {
                                                         if (var52 == 0) {
                                                            var52 = 256;
                                                         } else if (var52 == 1024) {
                                                            var52 = 768;
                                                         } else {
                                                            var52 = 512;
                                                         }
                                                      }

                                                      byte var50 = 0;
                                                      if (field1876.method3895(35)) {
                                                         var50 = -1;
                                                      } else if (field1876.method3895(51)) {
                                                         var50 = 1;
                                                      }

                                                      var6 = 0;
                                                      if (var52 >= 0 || var50 != 0) {
                                                         var6 = field1876.method3895(81) ? field1767 * -337602501 * 1073119475 : 1025325869 * field1727 * 27643045;
                                                         var6 *= 16;
                                                         field1676 = var52;
                                                         field1726 = var50;
                                                      }

                                                      if (field1724 < var6) {
                                                         field1724 += var6 / 8;
                                                         if (field1724 > var6) {
                                                            field1724 = var6;
                                                         }
                                                      } else if (field1724 > var6) {
                                                         field1724 = field1724 * 9 / 10;
                                                      }

                                                      if (field1724 > 0) {
                                                         var7 = field1724 / 16;
                                                         if (field1676 >= 0) {
                                                            var4 = field1676 - class237.field2807 & 2047;
                                                            var8 = class221.field2644[var4];
                                                            var9 = class221.field2645[var4];
                                                            class32.field203 += var8 * var7 / 65536;
                                                            class101.field1004 += var9 * var7 / 65536;
                                                         }

                                                         if (field1726 != 0) {
                                                            class178.field1595 += field1726 * var7;
                                                            if (class178.field1595 > 0) {
                                                               class178.field1595 = 0;
                                                            }
                                                         }
                                                      } else {
                                                         field1676 = -1;
                                                         field1726 = -1;
                                                      }

                                                      if (field1876.method3895(13)) {
                                                         method202();
                                                      }
                                                   }

                                                   if (4 == class42.field289 && class95.field944) {
                                                      var4 = class42.field285 - field1886;
                                                      field1719 = 2 * var4;
                                                      field1886 = -1 != var4 && var4 != 1 ? (field1886 + class42.field285) / 2 : class42.field285 * 1713648013 * -1075873467;
                                                      var5 = field1720 - class42.field284;
                                                      field1718 = 2 * var5;
                                                      field1720 = var5 != -1 && var5 != 1 ? (field1720 + class42.field284) / 2 : -625005879 * class42.field284 * 1166741369;
                                                   } else {
                                                      if (field1876.method3895(96)) {
                                                         field1718 += (-24 - field1718) / 2;
                                                      } else if (field1876.method3895(97)) {
                                                         field1718 += (24 - field1718) / 2;
                                                      } else {
                                                         field1718 /= 2;
                                                      }

                                                      if (field1876.method3895(98)) {
                                                         field1719 += (12 - field1719) / 2;
                                                      } else if (field1876.method3895(99)) {
                                                         field1719 += (-12 - field1719) / 2;
                                                      } else {
                                                         field1719 /= 2;
                                                      }

                                                      field1886 = class42.field285;
                                                      field1720 = class42.field284;
                                                   }

                                                   field1672 = field1672 + field1718 / 2 & 2047;
                                                   field1761 += field1719 / 2;
                                                   if (field1761 < 128) {
                                                      field1761 = 128;
                                                   }

                                                   if (field1761 > 383) {
                                                      field1761 = 383;
                                                   }

                                                   if (field1901) {
                                                      class96.method1961(class226.field2706, class94.field938, class302.field3620);
                                                      class109.method2104(class300.field3615, class32.field206);
                                                      if (class226.field2706 == class215.field2568 && class32.field204 == class94.field938 && class302.field3620 == class323.field3766 && class414.field4588 == class300.field3615 && class237.field2807 == class32.field206) {
                                                         field1901 = false;
                                                         field1900 = false;
                                                         class8.field34 = 0;
                                                         class122.field1186 = 0;
                                                         class278.field3197 = 0;
                                                         class42.field298 = 0;
                                                         class158.field1440 = 0;
                                                         class109.field1086 = 0;
                                                         class318.field3732 = 0;
                                                         class264.field2998 = 0;
                                                         class19.field96 = 0;
                                                         class244.field2859 = 0;
                                                      }
                                                   } else if (field1900) {
                                                      var4 = class264.field2998 * 128 + 64;
                                                      var5 = class19.field96 * 128 + 64;
                                                      var6 = class144.method2498(var4, var5, class55.field396) - class244.field2859;
                                                      class96.method1961(var4, var6, var5);
                                                      var4 = 64 + class8.field34 * 128;
                                                      var5 = 64 + class122.field1186 * 128;
                                                      var6 = class144.method2498(var4, var5, class55.field396) - class278.field3197;
                                                      var7 = var4 - class215.field2568;
                                                      var8 = var6 - class32.field204;
                                                      var9 = var5 - class323.field3766;
                                                      var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                                                      var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
                                                      var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
                                                      class109.method2104(var11, var12);
                                                   }

                                                   for(var4 = 0; var4 < 5; ++var4) {
                                                      var10002 = field1906[var4]++;
                                                   }

                                                   class66.field538.method2314();
                                                   var4 = ++class42.field278 - 1;
                                                   var6 = class31.field198.method671();
                                                   if (var4 > 15000 && var6 > 15000) {
                                                      field1696 = 250;
                                                      class42.field278 = 14500;
                                                      var46 = class185.method3435(class274.field3127, field1778.field1071);
                                                      field1778.method2078(var46);
                                                   }

                                                   class217.field2588.method1047();
                                                   ++field1778.field1077;
                                                   if (field1778.field1077 > 50) {
                                                      var46 = class185.method3435(class274.field3083, field1778.field1071);
                                                      field1778.method2078(var46);
                                                   }

                                                   try {
                                                      field1778.method2081();
                                                   } catch (IOException var15) {
                                                      method4611();
                                                   }

                                                   return;
                                                }

                                                class346.method6392(var49);
                                             }
                                          }

                                          var35 = var47.field694;
                                          if (var35.field3484 < 0) {
                                             break;
                                          }

                                          var38 = class282.method5426(var35.field3596);
                                       } while(var38 == null || null == var38.field3602 || var35.field3484 >= var38.field3602.length || var38.field3602[var35.field3484] != var35);

                                       class57.method5433(var47);
                                    }
                                 }

                                 var35 = var47.field694;
                                 if (var35.field3484 < 0) {
                                    break;
                                 }

                                 var38 = class282.method5426(var35.field3596);
                              } while(null == var38 || var38.field3602 == null || var35.field3484 >= var38.field3602.length || var35 != var38.field3602[var35.field3484]);

                              class57.method5433(var47);
                           }
                        }

                        var35 = var47.field694;
                        if (var35.field3484 < 0) {
                           break;
                        }

                        var38 = class282.method5426(var35.field3596);
                     } while(var38 == null || var38.field3602 == null || var35.field3484 >= var38.field3602.length || var38.field3602[var35.field3484] != var35);

                     class57.method5433(var47);
                  }
               }

               var18 = class185.method3435(class274.field3043, field1778.field1071);
               var18.field2984.method8097(0);
               var4 = var18.field2984.field4878;
               class88.method1865(var18.field2984);
               var18.field2984.method8144(var18.field2984.field4878 - var4);
               field1778.method2078(var18);
            }
         }
      }
   }

   static final void method6557(class90 var0) {
      int var2 = Math.max(1, var0.field857 - field1645);
      int var3 = var0.field815 * 128 + var0.field866 * 64;
      int var4 = var0.field855 * 128 + var0.field866 * 64;
      var0.field827 += (var3 - var0.field827) / var2;
      var0.field802 += (var4 - var0.field802) / var2;
      var0.field837 = 0;
      var0.field860 = var0.field859;
   }

   static void method206() {
      class263 var1 = class185.method3435(class274.field3101, field1778.field1071);
      var1.field2984.method8097(class2.method11());
      var1.field2984.method8174(class31.field193);
      var1.field2984.method8174(class12.field57);
      field1778.method2078(var1);
   }

   protected final void method599() {
      field1730 = class272.method2046() + 500L;
      this.method3069();
      if (field1893 != -1) {
         this.method2892(true);
      }

   }

   void method3069() {
      int var2 = class31.field193;
      int var3 = class12.field57;
      if (super.field171 < var2) {
         var2 = super.field171;
      }

      if (super.field179 < var3) {
         var3 = super.field179;
      }

      if (class413.field4575 != null) {
         try {
            class40.method760(class133.field1257, "resize", new Object[]{class2.method11()});
         } catch (Throwable var5) {
         }
      }

   }

   final void method2885() {
      if (-1 != field1893) {
         class378.method6797(field1893);
      }

      int var2;
      for(var2 = 0; var2 < field1858; ++var2) {
         if (field1860[var2]) {
            field1861[var2] = true;
         }

         field1800[var2] = field1860[var2];
         field1860[var2] = false;
      }

      field1882 = field1645;
      field1798 = -1;
      field1799 = -1;
      class165.field1523 = null;
      if (field1893 != -1) {
         field1858 = 0;
         class41.method763(field1893, 0, 0, class31.field193, class12.field57, 0, 0, -1);
      }

      class481.method8708();
      if (field1752) {
         if (1 == field1751) {
            class205.field2326[field1904 / 100].method8519(field1657 - 8, field1749 - 8);
         }

         if (field1751 == 2) {
            class205.field2326[4 + field1904 / 100].method8519(field1657 - 8, field1749 - 8);
         }
      }

      if (!field1784) {
         if (-1 != field1798) {
            class228.method4515(field1798, field1799);
         }
      } else {
         var2 = class94.field923;
         int var3 = class125.field1206;
         int var4 = class179.field1601;
         int var5 = class240.field2826;
         int var6 = 6116423;
         class481.method8653(var2, var3, var4, var5, var6);
         class481.method8653(1 + var2, var3 + 1, var4 - 2, 16, 0);
         class481.method8657(1 + var2, 18 + var3, var4 - 2, var5 - 19, 0);
         class114.field1127.method6868(class338.field4057, 3 + var2, var3 + 14, var6, -1);
         int var7 = class42.field284;
         int var8 = class42.field285;

         for(int var9 = 0; var9 < field1695; ++var9) {
            int var10 = 31 + var3 + 15 * (field1695 - 1 - var9);
            int var11 = 16777215;
            if (var7 > var2 && var7 < var2 + var4 && var8 > var10 - 13 && var8 < var10 + 3) {
               var11 = 16776960;
            }

            class114.field1127.method6868(class233.method4558(var9), 3 + var2, var10, var11, 0);
         }

         class105.method2047(class94.field923, class125.field1206, class179.field1601, class240.field2826);
      }

      if (3 == field1867) {
         for(var2 = 0; var2 < field1858; ++var2) {
            if (field1800[var2]) {
               class481.method8652(field1863[var2], field1864[var2], field1710[var2], field1658[var2], 16711935, 128);
            } else if (field1861[var2]) {
               class481.method8652(field1863[var2], field1864[var2], field1710[var2], field1658[var2], 16711680, 128);
            }
         }
      }

      class55.method1117(class55.field396, class291.field3364.field827, class291.field3364.field802, field1701);
      field1701 = 0;
   }

   public static class343 method7844() {
      return field1765;
   }

   static boolean method6193() {
      return 0 != (field1768 & 4);
   }

   static final void method2451(class90 var0, int var1) {
      class230.method4536(var0.field827, var0.field802, var1);
   }

   boolean method2886(class107 var1, int var2) {
      if (var1.field1075 == 0) {
         class73.field603 = null;
      } else {
         if (null == class73.field603) {
            class73.field603 = new class367(class234.field2779, class133.field1257);
         }

         class73.field603.method6698(var1.field1076, var2);
      }

      method6415();
      var1.field1073 = null;
      return true;
   }

   boolean method2900(class107 var1) {
      if (class73.field603 != null) {
         class73.field603.method6699(var1.field1076);
      }

      method6415();
      var1.field1073 = null;
      return true;
   }

   final boolean method2888(class107 var1) {
      class401 var3 = var1.method2082();
      class453 var4 = var1.field1076;
      if (null == var3) {
         return false;
      } else {
         String var6;
         int var7;
         try {
            int var25;
            if (null == var1.field1073) {
               if (var1.field1067) {
                  if (!var3.method7247(1)) {
                     return false;
                  }

                  var3.method7260(var1.field1076.field4881, 0, 1);
                  var1.field1070 = 0;
                  var1.field1067 = false;
               }

               var4.field4878 = 0;
               if (var4.method8000()) {
                  if (!var3.method7247(1)) {
                     return false;
                  }

                  var3.method7260(var1.field1076.field4881, 1, 1);
                  var1.field1070 = 0;
               }

               var1.field1067 = true;
               class283[] var5 = class283.method2743();
               var25 = var4.method8004();
               if (var25 < 0 || var25 >= var5.length) {
                  throw new IOException(var25 + " " + var4.field4878);
               }

               var1.field1073 = var5[var25];
               var1.field1075 = var1.field1073.field3240;
            }

            if (var1.field1075 == -1) {
               if (!var3.method7247(1)) {
                  return false;
               }

               var1.method2082().method7260(var4.field4881, 0, 1);
               var1.field1075 = var4.field4881[0] & 255;
            }

            if (-2 == var1.field1075) {
               if (!var3.method7247(2)) {
                  return false;
               }

               var1.method2082().method7260(var4.field4881, 0, 2);
               var4.field4878 = 0;
               var1.field1075 = var4.method8115();
            }

            if (!var3.method7247(var1.field1075)) {
               return false;
            }

            var4.field4878 = 0;
            var3.method7260(var4.field4881, 0, var1.field1075);
            var1.field1070 = 0;
            field1698.method6822();
            var1.field1080 = var1.field1072;
            var1.field1072 = var1.field1079;
            var1.field1079 = var1.field1073;
            if (class283.field3219 == var1.field1073) {
               class342.method6344(class271.field3021);
               var1.field1073 = null;
               return true;
            }

            int var23;
            class300 var34;
            if (class283.field3225 == var1.field1073) {
               var23 = var4.method8169();
               var25 = var4.method8195();
               var34 = class282.method5426(var23);
               if (1 != var34.field3504 || var25 != var34.field3505) {
                  var34.field3504 = 1;
                  var34.field3505 = var25;
                  class136.method2438(var34);
               }

               var1.field1073 = null;
               return true;
            }

            String var37;
            if (var1.field1073 == class283.field3253) {
               var23 = var4.method8147();
               var25 = var4.method8147();
               var37 = var4.method8124();
               if (var25 >= 1 && var25 <= 8) {
                  if (var37.equalsIgnoreCase(class338.field3899)) {
                     var37 = null;
                  }

                  field1772[var25 - 1] = var37;
                  field1755[var25 - 1] = var23 == 0;
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3265) {
               class7.field28 = var4.method8147();
               class19.field98 = var4.method8146();

               for(var23 = class7.field28; var23 < 8 + class7.field28; ++var23) {
                  for(var25 = class19.field98; var25 < 8 + class19.field98; ++var25) {
                     if (field1865[class55.field396][var23][var25] != null) {
                        field1865[class55.field396][var23][var25] = null;
                        class176.method2802(var23, var25);
                     }
                  }
               }

               for(class101 var85 = (class101)field1777.method6356(); null != var85; var85 = (class101)field1777.method6350()) {
                  if (var85.field999 >= class7.field28 && var85.field999 < 8 + class7.field28 && var85.field994 >= class19.field98 && var85.field994 < class19.field98 + 8 && var85.field993 == class55.field396) {
                     var85.field1003 = 0;
                  }
               }

               var1.field1073 = null;
               return true;
            }

            String var29;
            if (var1.field1073 == class283.field3293) {
               var29 = var4.method8124();
               Object[] var84 = new Object[var29.length() + 1];

               for(var7 = var29.length() - 1; var7 >= 0; --var7) {
                  if (var29.charAt(var7) == 's') {
                     var84[1 + var7] = var4.method8124();
                  } else {
                     var84[1 + var7] = new Integer(var4.method8119());
                  }
               }

               var84[0] = new Integer(var4.method8119());
               class79 var82 = new class79();
               var82.field686 = var84;
               class57.method5433(var82);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3320 == var1.field1073) {
               class342.method6344(class271.field3024);
               var1.field1073 = null;
               return true;
            }

            class227 var15;
            int var16;
            int var17;
            byte var26;
            String var70;
            if (var1.field1073 == class283.field3275) {
               var26 = var4.method8280();
               var6 = var4.method8124();
               long var81 = (long)var4.method8115();
               long var65 = (long)var4.method8305();
               class333 var73 = (class333)class217.method4362(class333.method5480(), var4.method8134());
               long var60 = var65 + (var81 << 32);
               boolean var67 = false;
               var15 = null;
               class147 var77 = var26 >= 0 ? field1883[var26] : class188.field1982;
               if (null == var77) {
                  var67 = true;
               } else {
                  var16 = 0;

                  while(true) {
                     if (var16 >= 100) {
                        if (var73.field3858 && class217.field2588.method1049(new class472(var6, class234.field2779))) {
                           var67 = true;
                        }
                        break;
                     }

                     if (var60 == field1918[var16]) {
                        var67 = true;
                        break;
                     }

                     ++var16;
                  }
               }

               if (!var67) {
                  field1918[field1875] = var60;
                  field1875 = (field1875 + 1) % 100;
                  var70 = class384.method6857(class307.method5489(var4));
                  var17 = var26 >= 0 ? 41 : 44;
                  if (var73.field3856 != -1) {
                     class110.method1858(var17, class96.method5151(var73.field3856) + var6, var70, var77.field1350);
                  } else {
                     class110.method1858(var17, var6, var70, var77.field1350);
                  }
               }

               var1.field1073 = null;
               return true;
            }

            int var9;
            class81 var28;
            if (var1.field1073 == class283.field3224) {
               var7 = var4.method8134();
               var23 = var4.method8195();
               var25 = var4.method8157();
               if (65535 == var25) {
                  var25 = -1;
               }

               var28 = field1902[var23];
               if (var28 != null) {
                  if (var25 == var28.field852 && -1 != var25) {
                     var9 = class160.method2660(var25).field2013;
                     if (var9 == 1) {
                        var28.field844 = 0;
                        var28.field845 = 0;
                        var28.field804 = var7;
                        var28.field875 = 0;
                     } else if (2 == var9) {
                        var28.field875 = 0;
                     }
                  } else if (var25 == -1 || -1 == var28.field852 || class160.method2660(var25).field2006 >= class160.method2660(var28.field852).field2006) {
                     var28.field852 = var25;
                     var28.field844 = 0;
                     var28.field845 = 0;
                     var28.field804 = var7;
                     var28.field875 = 0;
                     var28.field876 = var28.field871;
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3282) {
               class174.field1567 = null;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3230) {
               var23 = var4.method8119();
               class89 var83 = (class89)field1810.get((long)var23);
               if (null != var83) {
                  class4.method32(var83, true);
               }

               if (field1641 != null) {
                  class136.method2438(field1641);
                  field1641 = null;
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3305 && field1900) {
               field1901 = true;
               class318.field3732 = var4.method8134();
               class109.field1086 = var4.method8134();
               class42.field298 = var4.method8134();
               class158.field1440 = var4.method8134();

               for(var23 = 0; var23 < 5; ++var23) {
                  field1699[var23] = false;
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3303) {
               field1651 = var4.method8195() * 30;
               field1642 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3308) {
               class342.method6344(class271.field3019);
               var1.field1073 = null;
               return true;
            }

            boolean var50;
            if (class283.field3273 == var1.field1073) {
               var50 = var4.method8134() == 1;
               if (var50) {
                  class100.field987 = class272.method2046() - var4.method8120();
                  class242.field2835 = new class337(var4, true);
               } else {
                  class242.field2835 = null;
               }

               field1849 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3269) {
               class25.method344(true, var1.field1076);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3244) {
               class342.method6344(class271.field3030);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3278 == var1.field1073) {
               var23 = var4.method8119();
               var25 = var4.method8119();
               var7 = class260.method5146();
               class263 var78 = class185.method3435(class274.field3113, field1778.field1071);
               var78.field2984.method8234(var23);
               var78.field2984.method8148(var25);
               var78.field2984.method8257(var7);
               var78.field2984.method8145(class31.field174);
               field1778.method2078(var78);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3315) {
               var23 = var4.method8168();
               var25 = var4.method8195();
               var34 = class282.method5426(var23);
               if (var34 != null && var34.field3462 == 0) {
                  if (var25 > var34.field3492 - var34.field3476) {
                     var25 = var34.field3492 - var34.field3476;
                  }

                  if (var25 < 0) {
                     var25 = 0;
                  }

                  if (var25 != var34.field3482) {
                     var34.field3482 = var25;
                     class136.method2438(var34);
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3251 == var1.field1073) {
               class342.method6344(class271.field3023);
               var1.field1073 = null;
               return true;
            }

            int var8;
            class300 var33;
            if (var1.field1073 == class283.field3220) {
               var23 = var4.method8195();
               var25 = var4.method8155();
               var7 = var4.method8157();
               var8 = var4.method8119();
               var33 = class282.method5426(var8);
               if (var33.field3601 != var23 || var25 != var33.field3513 || var33.field3562 != var7) {
                  var33.field3601 = var23;
                  var33.field3513 = var25;
                  var33.field3562 = var7;
                  class136.method2438(var33);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3272 == var1.field1073) {
               for(var23 = 0; var23 < field1763.length; ++var23) {
                  if (field1763[var23] != null) {
                     field1763[var23].field852 = -1;
                  }
               }

               for(var23 = 0; var23 < field1902.length; ++var23) {
                  if (null != field1902[var23]) {
                     field1902[var23].field852 = -1;
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3283) {
               field1709 = var4.method8134();
               var1.field1073 = null;
               return true;
            }

            class300 var36;
            if (class283.field3218 == var1.field1073) {
               var23 = var4.method8155();
               var25 = var4.method8155();
               var7 = var4.method8169();
               var36 = class282.method5426(var7);
               var36.field3512 = (var23 << 16) + var25;
               var1.field1073 = null;
               return true;
            }

            if (class283.field3301 == var1.field1073) {
               class342.method6344(class271.field3025);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3311 == var1.field1073) {
               var29 = var4.method8124();
               var6 = class384.method6857(class158.method2630(class307.method5489(var4)));
               class42.method773(6, var29, var6);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3234) {
               for(var23 = 0; var23 < class293.field3370.length; ++var23) {
                  if (class293.field3368[var23] != class293.field3370[var23]) {
                     class293.field3370[var23] = class293.field3368[var23];
                     class147.method2521(var23);
                     field1931[++field1690 - 1 & 31] = var23;
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3297 == var1.field1073) {
               return this.method2886(var1, 1);
            }

            if (class283.field3249 == var1.field1073) {
               method2263();
               var26 = var4.method8280();
               class142 var80 = new class142(var4);
               class148 var79;
               if (var26 >= 0) {
                  var79 = field1738[var26];
               } else {
                  var79 = class127.field1224;
               }

               var80.method2481(var79);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3228 == var1.field1073) {
               class368.method6724();
               var1.field1073 = null;
               return false;
            }

            if (class283.field3289 == var1.field1073) {
               var23 = var4.method8119();
               var25 = var4.method8157();
               class293.field3368[var25] = var23;
               if (class293.field3370[var25] != var23) {
                  class293.field3370[var25] = var23;
               }

               class147.method2521(var25);
               field1931[++field1690 - 1 & 31] = var25;
               var1.field1073 = null;
               return true;
            }

            long var43;
            if (var1.field1073 == class283.field3325) {
               var23 = var4.method8155();
               if (var23 == 65535) {
                  var23 = -1;
               }

               var25 = var4.method8155();
               if (var25 == 65535) {
                  var25 = -1;
               }

               var7 = var4.method8119();
               var8 = var4.method8119();

               for(var9 = var23; var9 <= var25; ++var9) {
                  var43 = ((long)var8 << 32) + (long)var9;
                  class427 var58 = field1785.get(var43);
                  if (null != var58) {
                     var58.remove();
                  }

                  field1785.put(new class426(var7), var43);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3321 == var1.field1073) {
               class342.method6344(class271.field3029);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3268 == var1.field1073) {
               var23 = var4.method8134();
               class368.method6725(var23);
               var1.field1073 = null;
               return false;
            }

            if (class283.field3266 == var1.field1073) {
               class342.method6344(class271.field3022);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3245 == var1.field1073) {
               var4.field4878 += 28;
               if (var4.method8239()) {
                  method5002(var4, var4.field4878 - 28);
               }

               var1.field1073 = null;
               return true;
            }

            int var10;
            if (class283.field3236 == var1.field1073) {
               var23 = var4.method8119();
               var25 = var4.method8115();
               if (var23 < -70000) {
                  var25 += 32768;
               }

               if (var23 >= 0) {
                  var34 = class282.method5426(var23);
               } else {
                  var34 = null;
               }

               for(; var4.field4878 < var1.field1075; class233.method4557(var25, var8, var9 - 1, var10)) {
                  var8 = var4.method8200();
                  var9 = var4.method8115();
                  var10 = 0;
                  if (var9 != 0) {
                     var10 = var4.method8134();
                     if (255 == var10) {
                        var10 = var4.method8119();
                     }
                  }

                  if (var34 != null && var8 >= 0 && var8 < var34.field3461.length) {
                     var34.field3461[var8] = var9;
                     var34.field3456[var8] = var10;
                  }
               }

               if (var34 != null) {
                  class136.method2438(var34);
               }

               class198.method3654();
               field1837[++field1838 - 1 & 31] = var25 & 32767;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3248) {
               field1871 = var4.method8146();
               field1872 = var4.method8134();
               var1.field1073 = null;
               return true;
            }

            if (class283.field3296 == var1.field1073) {
               class342.method6344(class271.field3026);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3323) {
               class342.method6344(class271.field3033);
               var1.field1073 = null;
               return true;
            }

            boolean var72;
            if (var1.field1073 == class283.field3299) {
               var23 = var4.method8200();
               var72 = var4.method8134() == 1;
               var37 = "";
               boolean var74 = false;
               if (var72) {
                  var37 = var4.method8124();
                  if (class217.field2588.method1049(new class472(var37, class234.field2779))) {
                     var74 = true;
                  }
               }

               String var52 = var4.method8124();
               if (!var74) {
                  class42.method773(var23, var37, var52);
               }

               var1.field1073 = null;
               return true;
            }

            class300 var31;
            if (class283.field3267 == var1.field1073) {
               var23 = var4.method8168();
               var31 = class282.method5426(var23);
               var31.field3504 = 3;
               var31.field3505 = class291.field3364.field911.method6021();
               class136.method2438(var31);
               var1.field1073 = null;
               return true;
            }

            long var30;
            long var38;
            long var48;
            if (var1.field1073 == class283.field3277) {
               var29 = var4.method8124();
               var30 = var4.method8120();
               var38 = (long)var4.method8115();
               var43 = (long)var4.method8305();
               class333 var55 = (class333)class217.method4362(class333.method5480(), var4.method8134());
               var48 = var43 + (var38 << 32);
               boolean var75 = false;

               for(var16 = 0; var16 < 100; ++var16) {
                  if (var48 == field1918[var16]) {
                     var75 = true;
                     break;
                  }
               }

               if (var55.field3858 && class217.field2588.method1049(new class472(var29, class234.field2779))) {
                  var75 = true;
               }

               if (!var75 && 0 == field1830) {
                  field1918[field1875] = var48;
                  field1875 = (1 + field1875) % 100;
                  var70 = class384.method6857(class158.method2630(class307.method5489(var4)));
                  if (-1 != var55.field3856) {
                     class110.method1858(9, class96.method5151(var55.field3856) + var29, var70, class363.method4889(var30));
                  } else {
                     class110.method1858(9, var29, var70, class363.method4889(var30));
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3319) {
               class227.field2714 = true;
               class236.method4618(true, var4);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3214 == var1.field1073) {
               var23 = var4.method8134();
               method411(var23);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3243 == var1.field1073) {
               class131.method2400(var4, var1.field1075);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3227 == var1.field1073) {
               class19.field98 = var4.method8334();
               class7.field28 = var4.method8134();

               while(var4.field4878 < var1.field1075) {
                  var23 = var4.method8134();
                  class271 var76 = class271.method1667()[var23];
                  class342.method6344(var76);
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3276) {
               field1900 = true;
               field1901 = false;
               class264.field2998 = var4.method8134();
               class19.field96 = var4.method8134();
               class244.field2859 = var4.method8115();
               class318.field3732 = var4.method8134();
               class109.field1086 = var4.method8134();
               if (class109.field1086 >= 100) {
                  class215.field2568 = 64 + class264.field2998 * 128;
                  class323.field3766 = 64 + class19.field96 * 128;
                  class32.field204 = class144.method2498(class215.field2568, class323.field3766, class55.field396) - class244.field2859;
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3239) {
               class242.method4731(var4, var1.field1075);
               class372.method6742();
               var1.field1073 = null;
               return true;
            }

            if (class283.field3316 == var1.field1073) {
               class78.field683 = true;
               class242.method4731(var4, var1.field1075);
               class372.method6742();
               var1.field1073 = null;
               return true;
            }

            if (class283.field3312 == var1.field1073) {
               class330.method6250(var4.method8124());
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3226) {
               var23 = var4.method8115();
               var25 = var4.method8134();
               var7 = var4.method8115();
               class271.method5212(var23, var25, var7);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3294 == var1.field1073) {
               var23 = var4.method8168();
               var72 = var4.method8334() == 1;
               var34 = class282.method5426(var23);
               if (var34.field3480 != var72) {
                  var34.field3480 = var72;
                  class136.method2438(var34);
               }

               var1.field1073 = null;
               return true;
            }

            int var11;
            int var12;
            if (class283.field3326 == var1.field1073) {
               var10 = var4.method8115();
               var11 = var4.method8134();
               var12 = var4.method8155();
               var7 = var4.method8162();
               var23 = var7 >> 16;
               var25 = var7 >> 8 & 255;
               var8 = var23 + (var7 >> 4 & 7);
               var9 = var25 + (var7 & 7);
               if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
                  var8 = 64 + var8 * 128;
                  var9 = var9 * 128 + 64;
                  class77 var61 = new class77(var10, class55.field396, var8, var9, class144.method2498(var8, var9, class55.field396) - var11, var12, field1645);
                  field1779.method6347(var61);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3290 == var1.field1073) {
               field1847 = field1878;
               var26 = var4.method8280();
               class143 var68 = new class143(var4);
               class147 var66;
               if (var26 >= 0) {
                  var66 = field1883[var26];
               } else {
                  var66 = class188.field1982;
               }

               var68.method2490(var66);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3241 == var1.field1073) {
               class217.field2588.field376.method6817(var4, var1.field1075);
               class442.method7913();
               field1844 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (class283.field3238 == var1.field1073) {
               class198.method3654();
               field1859 = var4.method8197();
               field1642 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (class283.field3280 == var1.field1073) {
               var23 = var4.method8168();
               var25 = var4.method8115();
               var7 = var25 >> 10 & 31;
               var8 = var25 >> 5 & 31;
               var9 = var25 & 31;
               var10 = (var8 << 11) + (var7 << 19) + (var9 << 3);
               class300 var71 = class282.method5426(var23);
               if (var71.field3485 != var10) {
                  var71.field3485 = var10;
                  class136.method2438(var71);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3246 == var1.field1073) {
               var23 = var4.method8195();
               if (var23 == 65535) {
                  var23 = -1;
               }

               class45.method943(var23);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3215) {
               var23 = var4.method8141();
               var25 = var4.method8155();
               if (var25 == 65535) {
                  var25 = -1;
               }

               class196.method3635(var25, var23);
               var1.field1073 = null;
               return true;
            }

            int var13;
            int var14;
            int var18;
            int var19;
            class66 var20;
            byte var44;
            byte var62;
            int var69;
            if (var1.field1073 == class283.field3263) {
               var13 = var4.method8115();
               var44 = var4.method8328();
               var16 = var4.method8195();
               var17 = var4.method8195();
               var14 = var4.method8134() * 4;
               var62 = var4.method8328();
               var19 = var4.method8134();
               var12 = var4.method8176();
               var18 = var4.method8147();
               var7 = var4.method8305();
               var23 = var7 >> 16;
               var25 = var7 >> 8 & 255;
               var8 = (var7 >> 4 & 7) + var23;
               var9 = (var7 & 7) + var25;
               var69 = var4.method8146() * 4;
               var10 = var44 + var8;
               var11 = var62 + var9;
               if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104 && var10 >= 0 && var11 >= 0 && var10 < 104 && var11 < 104 && var13 != 65535) {
                  var8 = 64 + 128 * var8;
                  var9 = 64 + 128 * var9;
                  var10 = var10 * 128 + 64;
                  var11 = 64 + 128 * var11;
                  var20 = new class66(var13, class55.field396, var8, var9, class144.method2498(var8, var9, class55.field396) - var14, field1645 + var16, field1645 + var17, var18, var19, var12, var69);
                  var20.method1380(var10, var11, class144.method2498(var10, var11, class55.field396) - var69, var16 + field1645);
                  field1853.method6347(var20);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3317 == var1.field1073) {
               var17 = var4.method8115();
               var16 = var4.method8157();
               var19 = var4.method8147();
               var7 = var4.method8305();
               var23 = var7 >> 16;
               var25 = var7 >> 8 & 255;
               var8 = var23 + (var7 >> 4 & 7);
               var9 = var25 + (var7 & 7);
               var13 = var4.method8115();
               var12 = var4.method8118();
               var14 = var4.method8147() * 4;
               var62 = var4.method8280();
               var69 = var4.method8334() * 4;
               var44 = var4.method8280();
               var18 = var4.method8134();
               var10 = var44 + var8;
               var11 = var62 + var9;
               if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104 && var10 >= 0 && var11 >= 0 && var10 < 104 && var11 < 104 && var13 != 65535) {
                  var8 = 64 + var8 * 128;
                  var9 = 128 * var9 + 64;
                  var10 = 64 + 128 * var10;
                  var11 = var11 * 128 + 64;
                  var20 = new class66(var13, class55.field396, var8, var9, class144.method2498(var8, var9, class55.field396) - var14, var16 + field1645, var17 + field1645, var18, var19, var12, var69);
                  var20.method1380(var10, var11, class144.method2498(var10, var11, class55.field396) - var69, field1645 + var16);
                  field1853.method6347(var20);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3254 == var1.field1073) {
               class342.method6344(class271.field3028);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3235) {
               var23 = var4.method8119();
               var25 = var4.method8168();
               var7 = var4.method8115();
               if (65535 == var7) {
                  var7 = -1;
               }

               var36 = class282.method5426(var25);
               class198 var40;
               if (!var36.field3459) {
                  if (var7 == -1) {
                     var36.field3504 = 0;
                     var1.field1073 = null;
                     return true;
                  }

                  var40 = class278.method5388(var7);
                  var36.field3504 = 4;
                  var36.field3505 = var7;
                  var36.field3601 = var40.field2137;
                  var36.field3513 = var40.field2138;
                  var36.field3562 = var40.field2144 * 100 / var23;
                  class136.method2438(var36);
               } else {
                  var36.field3445 = var7;
                  var36.field3599 = var23;
                  var40 = class278.method5388(var7);
                  var36.field3601 = var40.field2137;
                  var36.field3513 = var40.field2138;
                  var36.field3514 = var40.field2139;
                  var36.field3510 = var40.field2140;
                  var36.field3548 = var40.field2128;
                  var36.field3562 = var40.field2144;
                  if (1 == var40.field2142) {
                     var36.field3520 = 1;
                  } else {
                     var36.field3520 = 2;
                  }

                  if (var36.field3516 > 0) {
                     var36.field3562 = var36.field3562 * 32 / var36.field3516;
                  } else if (var36.field3486 > 0) {
                     var36.field3562 = var36.field3562 * 32 / var36.field3486;
                  }

                  class136.method2438(var36);
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3223) {
               var23 = var4.method8195();
               field1893 = var23;
               this.method2892(false);
               class82.method1699(var23);
               class134.method2421(field1893);

               for(var25 = 0; var25 < 100; ++var25) {
                  field1860[var25] = true;
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3222 == var1.field1073) {
               if (-1 != field1893) {
                  class217.method4361(field1893, 0);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3262 == var1.field1073) {
               class217.field2588.method1046(var4, var1.field1075);
               field1844 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3287) {
               if (class174.field1567 == null) {
                  class174.field1567 = new class411(class191.field2026);
               }

               class474 var57 = class191.field2026.method7209(var4);
               class174.field1567.field4557.method7559(var57.field4965, var57.field4963);
               field1841[++field1842 - 1 & 31] = var57.field4965;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3307) {
               class198.method3654();
               var23 = var4.method8168();
               var25 = var4.method8147();
               var7 = var4.method8147();
               field1782[var7] = var23;
               field1780[var7] = var25;
               field1817[var7] = 1;

               for(var8 = 0; var8 < 98; ++var8) {
                  if (var23 >= class321.field3756[var8]) {
                     field1817[var7] = 2 + var8;
                  }
               }

               field1839[++field1742 - 1 & 31] = var7;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3302) {
               field1847 = field1878;
               var26 = var4.method8280();
               if (var1.field1075 == 1) {
                  if (var26 >= 0) {
                     field1883[var26] = null;
                  } else {
                     class188.field1982 = null;
                  }

                  var1.field1073 = null;
                  return true;
               }

               if (var26 >= 0) {
                  field1883[var26] = new class147(var4);
               } else {
                  class188.field1982 = new class147(var4);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3310 == var1.field1073) {
               var50 = var4.method8122();
               if (var50) {
                  if (class335.field3867 == null) {
                     class335.field3867 = new class348();
                  }
               } else {
                  class335.field3867 = null;
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3274) {
               var23 = var4.method8119();
               var25 = var4.method8195();
               var34 = class282.method5426(var23);
               if (var34.field3504 != 2 || var25 != var34.field3505) {
                  var34.field3504 = 2;
                  var34.field3505 = var25;
                  class136.method2438(var34);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3231 == var1.field1073) {
               return this.method2886(var1, 2);
            }

            if (var1.field1073 == class283.field3314) {
               var23 = var4.method8119();
               var25 = var4.method8115();
               if (var23 < -70000) {
                  var25 += 32768;
               }

               if (var23 >= 0) {
                  var34 = class282.method5426(var23);
               } else {
                  var34 = null;
               }

               if (null != var34) {
                  for(var8 = 0; var8 < var34.field3461.length; ++var8) {
                     var34.field3461[var8] = 0;
                     var34.field3456[var8] = 0;
                  }
               }

               class239.method4680(var25);
               var8 = var4.method8115();

               for(var9 = 0; var9 < var8; ++var9) {
                  var10 = var4.method8155();
                  var11 = var4.method8334();
                  if (var11 == 255) {
                     var11 = var4.method8167();
                  }

                  if (var34 != null && var9 < var34.field3461.length) {
                     var34.field3461[var9] = var10;
                     var34.field3456[var9] = var11;
                  }

                  class233.method4557(var25, var9, var10 - 1, var11);
               }

               if (null != var34) {
                  class136.method2438(var34);
               }

               class198.method3654();
               field1837[++field1838 - 1 & 31] = var25 & 32767;
               var1.field1073 = null;
               return true;
            }

            class89 var32;
            if (class283.field3261 == var1.field1073) {
               var23 = var4.method8334();
               var25 = var4.method8167();
               var7 = var4.method8195();
               var32 = (class89)field1810.get((long)var25);
               if (null != var32) {
                  class4.method32(var32, var32.field796 != var7);
               }

               class405.method7363(var25, var7, var23);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3271 == var1.field1073) {
               var23 = var4.method8134();
               if (var4.method8134() == 0) {
                  field1924[var23] = new class347();
                  var4.field4878 += 18;
               } else {
                  --var4.field4878;
                  field1924[var23] = new class347(var4, false);
               }

               field1848 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3318) {
               class227.field2714 = true;
               class236.method4618(false, var4);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3292 == var1.field1073) {
               class297.field3431 = class363.method6668(var4.method8134());
               var1.field1073 = null;
               return true;
            }

            if (class283.field3285 == var1.field1073) {
               var23 = var4.method8134();
               var25 = var4.method8134();
               var7 = var4.method8134();
               var8 = var4.method8134();
               field1699[var23] = true;
               field1903[var23] = var25;
               field1808[var23] = var7;
               field1905[var23] = var8;
               field1906[var23] = 0;
               var1.field1073 = null;
               return true;
            }

            if (class283.field3279 == var1.field1073) {
               var23 = var4.method8157();
               class93 var45;
               if (field1764 == var23) {
                  var45 = class291.field3364;
               } else {
                  var45 = field1763[var23];
               }

               var7 = var4.method8167();
               var25 = var4.method8195();
               if (var45 != null) {
                  var45.field848 = var25;
                  var45.field824 = var7 >> 16;
                  var45.field851 = (var7 & '\uffff') + field1645;
                  var45.field856 = 0;
                  var45.field807 = 0;
                  if (var45.field851 > field1645) {
                     var45.field856 = -1;
                  }

                  if (var45.field848 == 65535) {
                     var45.field848 = -1;
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3259) {
               var23 = var4.method8157();
               class408.method7398(var23);
               field1837[++field1838 - 1 & 31] = var23 & 32767;
               var1.field1073 = null;
               return true;
            }

            if (class283.field3284 == var1.field1073) {
               byte[] var41 = new byte[var1.field1075];
               var4.method8010(var41, 0, var41.length);
               class460 var42 = new class460(var41);
               var37 = var42.method8124();
               class115.method2229(var37, true, false);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3298) {
               class174.field1567 = new class411(class191.field2026);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3291 == var1.field1073) {
               return this.method2900(var1);
            }

            if (var1.field1073 == class283.field3252) {
               var29 = var4.method8124();
               var25 = var4.method8169();
               var34 = class282.method5426(var25);
               if (!var29.equals(var34.field3522)) {
                  var34.field3522 = var29;
                  class136.method2438(var34);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3260 == var1.field1073) {
               class198.method3654();
               field1816 = var4.method8134();
               field1642 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (class283.field3233 == var1.field1073) {
               var23 = var4.method8119();
               if (field1729 != var23) {
                  field1729 = var23;
                  method3391();
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3306) {
               class236.method4618(false, var4);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3258 == var1.field1073) {
               var23 = var4.method8169();
               var25 = var4.method8167();
               class89 var35 = (class89)field1810.get((long)var25);
               var32 = (class89)field1810.get((long)var23);
               if (var32 != null) {
                  class4.method32(var32, var35 == null || var35.field796 != var32.field796);
               }

               if (var35 != null) {
                  var35.remove();
                  field1810.put(var35, (long)var23);
               }

               var33 = class282.method5426(var25);
               if (null != var33) {
                  class136.method2438(var33);
               }

               var33 = class282.method5426(var23);
               if (var33 != null) {
                  class136.method2438(var33);
                  class26.method349(class300.field3593[var33.field3517 >>> 16], var33, true);
               }

               if (-1 != field1893) {
                  class217.method4361(field1893, 1);
               }

               var1.field1073 = null;
               return true;
            }

            String var54;
            if (var1.field1073 == class283.field3300) {
               var26 = var4.method8280();
               var30 = (long)var4.method8115();
               var38 = (long)var4.method8305();
               var43 = var38 + (var30 << 32);
               boolean var47 = false;
               class147 var53 = var26 >= 0 ? field1883[var26] : class188.field1982;
               if (var53 == null) {
                  var47 = true;
               } else {
                  for(var14 = 0; var14 < 100; ++var14) {
                     if (field1918[var14] == var43) {
                        var47 = true;
                        break;
                     }
                  }
               }

               if (!var47) {
                  field1918[field1875] = var43;
                  field1875 = (field1875 + 1) % 100;
                  var54 = class307.method5489(var4);
                  var69 = var26 >= 0 ? 43 : 46;
                  class110.method1858(var69, "", var54, var53.field1350);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3286 == var1.field1073) {
               class236.method4618(true, var4);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3221) {
               var23 = var4.method8176();
               var25 = var4.method8167();
               var34 = class282.method5426(var25);
               if (var23 != var34.field3575 || -1 == var23) {
                  var34.field3575 = var23;
                  var34.field3471 = 0;
                  var34.field3518 = 0;
                  class136.method2438(var34);
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3264) {
               class342.method6344(class271.field3020);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3304 == var1.field1073) {
               class25.method344(false, var1.field1076);
               var1.field1073 = null;
               return true;
            }

            if (class283.field3270 == var1.field1073) {
               var23 = var4.method8169();
               var31 = class282.method5426(var23);

               for(var7 = 0; var7 < var31.field3461.length; ++var7) {
                  var31.field3461[var7] = -1;
                  var31.field3461[var7] = 0;
               }

               class136.method2438(var31);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3242) {
               var29 = var4.method8124();
               var30 = (long)var4.method8115();
               var38 = (long)var4.method8305();
               class333 var39 = (class333)class217.method4362(class333.method5480(), var4.method8134());
               long var51 = var38 + (var30 << 32);
               boolean var49 = false;

               for(var14 = 0; var14 < 100; ++var14) {
                  if (field1918[var14] == var51) {
                     var49 = true;
                     break;
                  }
               }

               if (class217.field2588.method1049(new class472(var29, class234.field2779))) {
                  var49 = true;
               }

               if (!var49 && field1830 == 0) {
                  field1918[field1875] = var51;
                  field1875 = (field1875 + 1) % 100;
                  var54 = class384.method6857(class158.method2630(class307.method5489(var4)));
                  byte var64;
                  if (var39.field3857) {
                     var64 = 7;
                  } else {
                     var64 = 3;
                  }

                  if (var39.field3856 != -1) {
                     class42.method773(var64, class96.method5151(var39.field3856) + var29, var54);
                  } else {
                     class42.method773(var64, var29, var54);
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3288) {
               field1652 = var4.method8134();
               if (1 == field1652) {
                  field1879 = var4.method8115();
               }

               if (field1652 >= 2 && field1652 <= 6) {
                  if (2 == field1652) {
                     field1866 = 64;
                     field1684 = 64;
                  }

                  if (field1652 == 3) {
                     field1866 = 0;
                     field1684 = 64;
                  }

                  if (field1652 == 4) {
                     field1866 = 128;
                     field1684 = 64;
                  }

                  if (5 == field1652) {
                     field1866 = 64;
                     field1684 = 0;
                  }

                  if (field1652 == 6) {
                     field1866 = 64;
                     field1684 = 128;
                  }

                  field1652 = 2;
                  field1655 = var4.method8115();
                  field1656 = var4.method8115();
                  field1913 = var4.method8134();
               }

               if (field1652 == 10) {
                  field1654 = var4.method8115();
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3322 == var1.field1073) {
               var23 = var4.method8197();
               var25 = var4.method8169();
               var7 = var4.method8176();
               var36 = class282.method5426(var25);
               if (var36.field3469 != var7 || var23 != var36.field3470 || var36.field3465 != 0 || var36.field3466 != 0) {
                  var36.field3469 = var7;
                  var36.field3470 = var23;
                  var36.field3465 = 0;
                  var36.field3466 = 0;
                  class136.method2438(var36);
                  this.method2893(var36);
                  if (0 == var36.field3462) {
                     class26.method349(class300.field3593[var25 >> 16], var36, false);
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3295) {
               field1900 = false;

               for(var23 = 0; var23 < 5; ++var23) {
                  field1699[var23] = false;
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3255) {
               var23 = var1.field1075 + var4.field4878;
               var25 = var4.method8115();
               var7 = var4.method8115();
               if (var25 != field1893) {
                  field1893 = var25;
                  this.method2892(false);
                  class82.method1699(field1893);
                  class134.method2421(field1893);

                  for(var8 = 0; var8 < 100; ++var8) {
                     field1860[var8] = true;
                  }
               }

               class89 var46;
               for(; var7-- > 0; var46.field795 = true) {
                  var8 = var4.method8119();
                  var9 = var4.method8115();
                  var10 = var4.method8134();
                  var46 = (class89)field1810.get((long)var8);
                  if (null != var46 && var46.field796 != var9) {
                     class4.method32(var46, true);
                     var46 = null;
                  }

                  if (null == var46) {
                     var46 = class405.method7363(var8, var9, var10);
                  }
               }

               for(var32 = (class89)field1810.method7860(); var32 != null; var32 = (class89)field1810.method7851()) {
                  if (var32.field795) {
                     var32.field795 = false;
                  } else {
                     class4.method32(var32, true);
                  }
               }

               field1785 = new class434(512);

               while(var4.field4878 < var23) {
                  var8 = var4.method8119();
                  var9 = var4.method8115();
                  var10 = var4.method8115();
                  var11 = var4.method8119();

                  for(var12 = var9; var12 <= var10; ++var12) {
                     var48 = ((long)var8 << 32) + (long)var12;
                     field1785.put(new class426(var11), var48);
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3309 == var1.field1073) {
               class342.method6344(class271.field3018);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3229) {
               var26 = var4.method8151();
               var25 = var4.method8195();
               class293.field3368[var25] = var26;
               if (class293.field3370[var25] != var26) {
                  class293.field3370[var25] = var26;
               }

               class147.method2521(var25);
               field1931[++field1690 - 1 & 31] = var25;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3217) {
               class19.field98 = var4.method8146();
               class7.field28 = var4.method8146();
               var1.field1073 = null;
               return true;
            }

            if (class283.field3256 == var1.field1073) {
               var23 = var4.method8155();
               var28 = field1902[var23];
               var7 = var4.method8155();
               var25 = var4.method8168();
               if (var28 != null) {
                  var28.field848 = var7;
                  var28.field824 = var25 >> 16;
                  var28.field851 = (var25 & '\uffff') + field1645;
                  var28.field856 = 0;
                  var28.field807 = 0;
                  if (var28.field851 > field1645) {
                     var28.field856 = -1;
                  }

                  if (65535 == var28.field848) {
                     var28.field848 = -1;
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3257 == var1.field1073) {
               method2263();
               var26 = var4.method8280();
               if (var1.field1075 == 1) {
                  if (var26 >= 0) {
                     field1738[var26] = null;
                  } else {
                     class127.field1224 = null;
                  }

                  var1.field1073 = null;
                  return true;
               }

               if (var26 >= 0) {
                  field1738[var26] = new class148(var4);
               } else {
                  class127.field1224 = new class148(var4);
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3281 == var1.field1073) {
               for(var23 = 0; var23 < class178.field1592; ++var23) {
                  class178 var27 = class274.method5221(var23);
                  if (var27 != null) {
                     class293.field3368[var23] = 0;
                     class293.field3370[var23] = 0;
                  }
               }

               class198.method3654();
               field1690 += 32;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3232) {
               class342.method6344(class271.field3031);
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3247) {
               field1900 = true;
               field1901 = false;
               class8.field34 = var4.method8134();
               class122.field1186 = var4.method8134();
               class278.field3197 = var4.method8115();
               class42.field298 = var4.method8134();
               class158.field1440 = var4.method8134();
               if (class158.field1440 >= 100) {
                  var23 = class8.field34 * 128 + 64;
                  var25 = class122.field1186 * 128 + 64;
                  var7 = class144.method2498(var23, var25, class55.field396) - class278.field3197;
                  var8 = var23 - class215.field2568;
                  var9 = var7 - class32.field204;
                  var10 = var25 - class323.field3766;
                  var11 = (int)Math.sqrt((double)(var8 * var8 + var10 * var10));
                  class414.field4588 = (int)(Math.atan2((double)var9, (double)var11) * 325.9490051269531D) & 2047;
                  class237.field2807 = (int)(Math.atan2((double)var8, (double)var10) * -325.9490051269531D) & 2047;
                  if (class414.field4588 < 128) {
                     class414.field4588 = 128;
                  }

                  if (class414.field4588 > 383) {
                     class414.field4588 = 383;
                  }
               }

               var1.field1073 = null;
               return true;
            }

            if (class283.field3313 == var1.field1073) {
               class72 var24 = new class72();
               var24.field589 = var4.method8124();
               var24.field590 = var4.method8115();
               var25 = var4.method8119();
               var24.field587 = var25;
               class9.method64(45);
               var3.method7252();
               var3 = null;
               method3066(var24);
               var1.field1073 = null;
               return false;
            }

            if (class283.field3237 == var1.field1073) {
               field1889 = var4.method8134();
               if (255 == field1889) {
                  field1889 = 0;
               }

               field1890 = var4.method8134();
               if (255 == field1890) {
                  field1890 = 0;
               }

               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3250) {
               class217.field2588.method1109();
               field1844 = field1878;
               var1.field1073 = null;
               return true;
            }

            if (var1.field1073 == class283.field3213) {
               var14 = var4.method8195();
               var10 = var4.method8146();
               var11 = var10 >> 2;
               var12 = var10 & 3;
               var13 = field1708[var11];
               var7 = var4.method8305();
               var23 = var7 >> 16;
               var25 = var7 >> 8 & 255;
               var8 = var23 + (var7 >> 4 & 7);
               var9 = var25 + (var7 & 7);
               if (var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
                  if (var13 == 0) {
                     class229 var63 = class145.field1333.method4144(class55.field396, var8, var9);
                     if (var63 != null) {
                        var16 = class234.method1610(var63.field2735);
                        if (var11 == 2) {
                           var63.field2728 = new class61(var16, 2, var12 + 4, class55.field396, var8, var9, var14, false, var63.field2728);
                           var63.field2734 = new class61(var16, 2, 1 + var12 & 3, class55.field396, var8, var9, var14, false, var63.field2734);
                        } else {
                           var63.field2728 = new class61(var16, var11, var12, class55.field396, var8, var9, var14, false, var63.field2728);
                        }
                     }
                  } else if (1 == var13) {
                     class217 var59 = class145.field1333.method4145(class55.field396, var8, var9);
                     if (var59 != null) {
                        var16 = class234.method1610(var59.field2584);
                        if (var11 != 4 && var11 != 5) {
                           if (var11 == 6) {
                              var59.field2582 = new class61(var16, 4, 4 + var12, class55.field396, var8, var9, var14, false, var59.field2582);
                           } else if (var11 == 7) {
                              var59.field2582 = new class61(var16, 4, (var12 + 2 & 3) + 4, class55.field396, var8, var9, var14, false, var59.field2582);
                           } else if (var11 == 8) {
                              var59.field2582 = new class61(var16, 4, 4 + var12, class55.field396, var8, var9, var14, false, var59.field2582);
                              var59.field2585 = new class61(var16, 4, 4 + (var12 + 2 & 3), class55.field396, var8, var9, var14, false, var59.field2585);
                           }
                        } else {
                           var59.field2582 = new class61(var16, 4, var12, class55.field396, var8, var9, var14, false, var59.field2582);
                        }
                     }
                  } else if (2 == var13) {
                     var15 = class145.field1333.method4276(class55.field396, var8, var9);
                     if (var11 == 11) {
                        var11 = 10;
                     }

                     if (null != var15) {
                        var15.field2711 = new class61(class234.method1610(var15.field2719), var11, var12, class55.field396, var8, var9, var14, false, var15.field2711);
                     }
                  } else if (var13 == 3) {
                     class196 var56 = class145.field1333.method4147(class55.field396, var8, var9);
                     if (null != var56) {
                        var56.field2108 = new class61(class234.method1610(var56.field2109), 22, var12, class55.field396, var8, var9, var14, false, var56.field2108);
                     }
                  }
               }

               var1.field1073 = null;
               return true;
            }

            class422.method7800("" + (var1.field1073 != null ? var1.field1073.field3324 * 1911455211 * -1220623677 : -1) + class96.field959 + (var1.field1072 != null ? var1.field1072.field3324 * 1911455211 * -1220623677 : -1) + class96.field959 + (var1.field1080 != null ? -1220623677 * var1.field1080.field3324 * 1911455211 : -1) + class96.field959 + var1.field1075, (Throwable)null);
            class368.method6724();
         } catch (IOException var21) {
            method4611();
         } catch (Exception var22) {
            var6 = "" + (var1.field1073 != null ? var1.field1073.field3324 * 1911455211 * -1220623677 : -1) + class96.field959 + (var1.field1072 != null ? -1220623677 * var1.field1072.field3324 * 1911455211 : -1) + class96.field959 + (null != var1.field1080 ? -1220623677 * var1.field1080.field3324 * 1911455211 : -1) + class96.field959 + var1.field1075 + class96.field959 + (class291.field3364.field861[0] + class36.field241) + class96.field959 + (class291.field3364.field873[0] + class169.field1536) + class96.field959;

            for(var7 = 0; var7 < var1.field1075 && var7 < 50; ++var7) {
               var6 = var6 + var4.field4881[var7] + class96.field959;
            }

            class422.method7800(var6, var22);
            class368.method6724();
         }

         return true;
      }
   }

   static final void method3540(class101 var0) {
      long var2 = 0L;
      int var4 = -1;
      int var5 = 0;
      int var6 = 0;
      if (var0.field992 == 0) {
         var2 = class145.field1333.method4185(var0.field993, var0.field999, var0.field994);
      }

      if (1 == var0.field992) {
         var2 = class145.field1333.method4149(var0.field993, var0.field999, var0.field994);
      }

      if (2 == var0.field992) {
         var2 = class145.field1333.method4150(var0.field993, var0.field999, var0.field994);
      }

      if (var0.field992 == 3) {
         var2 = class145.field1333.method4151(var0.field993, var0.field999, var0.field994);
      }

      if (0L != var2) {
         int var7 = class145.field1333.method4156(var0.field993, var0.field999, var0.field994, var2);
         var4 = class234.method1610(var2);
         var5 = var7 & 31;
         var6 = var7 >> 6 & 3;
      }

      var0.field995 = var4;
      var0.field997 = var5;
      var0.field996 = var6;
   }

   static void method5549() {
      field1695 = 0;
      field1784 = false;
      field1791[0] = class338.field4149;
      field1923[0] = "";
      field1788[0] = 1006;
      field1916[0] = false;
      field1695 = 1;
   }

   static final boolean method5007() {
      return field1784;
   }

   final void method2889() {
      boolean var2 = false;

      int var3;
      int var6;
      while(!var2) {
         var2 = true;

         for(var3 = 0; var3 < field1695 - 1; ++var3) {
            if (field1788[var3] < 1000 && field1788[1 + var3] > 1000) {
               String var4 = field1923[var3];
               field1923[var3] = field1923[var3 + 1];
               field1923[1 + var3] = var4;
               String var5 = field1791[var3];
               field1791[var3] = field1791[1 + var3];
               field1791[var3 + 1] = var5;
               var6 = field1788[var3];
               field1788[var3] = field1788[1 + var3];
               field1788[var3 + 1] = var6;
               var6 = field1851[var3];
               field1851[var3] = field1851[1 + var3];
               field1851[var3 + 1] = var6;
               var6 = field1787[var3];
               field1787[var3] = field1787[var3 + 1];
               field1787[1 + var3] = var6;
               var6 = field1789[var3];
               field1789[var3] = field1789[var3 + 1];
               field1789[var3 + 1] = var6;
               var6 = field1790[var3];
               field1790[var3] = field1790[var3 + 1];
               field1790[var3 + 1] = var6;
               boolean var7 = field1916[var3];
               field1916[var3] = field1916[1 + var3];
               field1916[var3 + 1] = var7;
               var2 = false;
            }
         }
      }

      if (null == class183.field1943) {
         if (field1874 == null) {
            int var11;
            int var18;
            int var24;
            label274: {
               int var16 = class42.field277;
               int var9;
               int var17;
               int var20;
               int var21;
               if (field1784) {
                  if (var16 != 1 && (class95.field944 || var16 != 4)) {
                     var3 = class42.field284;
                     var17 = class42.field285;
                     if (var3 < class94.field923 - 10 || var3 > 10 + class94.field923 + class179.field1601 || var17 < class125.field1206 - 10 || var17 > 10 + class240.field2826 + class125.field1206) {
                        field1784 = false;
                        class319.method6173(class94.field923, class125.field1206, class179.field1601, class240.field2826);
                     }
                  }

                  if (var16 == 1 || !class95.field944 && 4 == var16) {
                     var3 = class94.field923;
                     var17 = class125.field1206;
                     var18 = class179.field1601;
                     var6 = class42.field283;
                     var20 = class42.field293;
                     var21 = -1;

                     for(var9 = 0; var9 < field1695; ++var9) {
                        var24 = var17 + 31 + (field1695 - 1 - var9) * 15;
                        if (var6 > var3 && var6 < var3 + var18 && var20 > var24 - 13 && var20 < 3 + var24) {
                           var21 = var9;
                        }
                     }

                     if (var21 != -1 && var21 >= 0) {
                        var9 = field1851[var21];
                        var24 = field1787[var21];
                        var11 = field1788[var21];
                        int var25 = field1789[var21];
                        int var13 = field1790[var21];
                        String var14 = field1791[var21];
                        String var15 = field1923[var21];
                        class263.method5159(var9, var24, var11, var25, var13, var14, var15, class42.field283, class42.field293);
                     }

                     field1784 = false;
                     class319.method6173(class94.field923, class125.field1206, class179.field1601, class240.field2826);
                  }
               } else {
                  var3 = method5125();
                  if ((1 == var16 || !class95.field944 && var16 == 4) && var3 >= 0) {
                     var17 = field1788[var3];
                     if (39 == var17 || 40 == var17 || var17 == 41 || var17 == 42 || 43 == var17 || var17 == 33 || var17 == 34 || 35 == var17 || var17 == 36 || var17 == 37 || 38 == var17 || 1005 == var17) {
                        var18 = field1851[var3];
                        var6 = field1787[var3];
                        class300 var19 = class282.method5426(var6);
                        var9 = class190.method3528(var19);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if (var8) {
                           break label274;
                        }

                        var11 = class190.method3528(var19);
                        boolean var10 = (var11 >> 29 & 1) != 0;
                        if (var10) {
                           break label274;
                        }
                     }
                  }

                  if ((var16 == 1 || !class95.field944 && var16 == 4) && this.method2890()) {
                     var16 = 2;
                  }

                  if ((1 == var16 || !class95.field944 && var16 == 4) && field1695 > 0 && var3 >= 0) {
                     var17 = field1851[var3];
                     var18 = field1787[var3];
                     var6 = field1788[var3];
                     var20 = field1789[var3];
                     var21 = field1790[var3];
                     String var22 = field1791[var3];
                     String var23 = field1923[var3];
                     class263.method5159(var17, var18, var6, var20, var21, var22, var23, class42.field283, class42.field293);
                  }

                  if (var16 == 2 && field1695 > 0) {
                     this.method3357(class42.field283, class42.field293);
                  }
               }

               return;
            }

            if (null != class183.field1943 && !field1759 && field1695 > 0 && !this.method2890()) {
               var24 = field1638;
               var11 = field1757;
               class73 var12 = class101.field1005;
               if (null != var12) {
                  class263.method5159(var12.field600, var12.field595, var12.field594, var12.field597, var12.field598, var12.field599, var12.field604, var24, var11);
               }

               class101.field1005 = null;
            }

            field1759 = false;
            field1786 = 0;
            if (null != class183.field1943) {
               class136.method2438(class183.field1943);
            }

            class183.field1943 = class282.method5426(var6);
            field1737 = var18;
            field1638 = class42.field283;
            field1757 = class42.field293;
            if (var3 >= 0) {
               method102(var3);
            }

            class136.method2438(class183.field1943);
         }
      }
   }

   final boolean method2890() {
      int var2 = method5125();
      return (field1862 && field1695 > 2 || class45.method951(var2)) && !field1916[var2];
   }

   final void method3357(int var1, int var2) {
      int var4 = class114.field1127.method6887(class338.field4057);

      int var5;
      int var6;
      for(var5 = 0; var5 < field1695; ++var5) {
         var6 = class114.field1127.method6887(class233.method4558(var5));
         if (var6 > var4) {
            var4 = var6;
         }
      }

      var4 += 8;
      var5 = field1695 * 15 + 22;
      var6 = var1 - var4 / 2;
      if (var6 + var4 > class31.field193) {
         var6 = class31.field193 - var4;
      }

      if (var6 < 0) {
         var6 = 0;
      }

      int var7 = var2;
      if (var2 + var5 > class12.field57) {
         var7 = class12.field57 - var5;
      }

      if (var7 < 0) {
         var7 = 0;
      }

      class94.field923 = var6;
      class125.field1206 = var7;
      class179.field1601 = var4;
      class240.field2826 = field1695 * 15 + 22;
      var1 -= field1915;
      var2 -= field1634;
      class145.field1333.method4159(class55.field396, var1, var2, false);
      field1784 = true;
   }

   static void method7978(int var0, int var1) {
      class263 var3 = class185.method3435(class274.field3109, field1778.field1071);
      var3.field2984.method8152(var1);
      var3.field2984.method8234(var0);
      field1778.method2078(var3);
   }

   public static final void method351(String var0, String var1, int var2, int var3, int var4, int var5) {
      class105.method2042(var0, var1, var2, var3, var4, var5, -1, false);
   }

   static final void method1556(String var0, String var1, int var2, int var3, int var4, int var5, int var6) {
      class105.method2042(var0, var1, var2, var3, var4, var5, var6, false);
   }

   static final int method5125() {
      return field1695 - 1;
   }

   final void method2892(boolean var1) {
      int var3 = field1893;
      int var4 = class31.field193;
      int var5 = class12.field57;
      if (class246.method4928(var3)) {
         class256.method5126(class300.field3593[var3], -1, var4, var5, var1);
      }

   }

   void method2893(class300 var1) {
      class300 var3 = var1.field3596 == -1 ? null : class282.method5426(var1.field3596);
      int var4;
      int var5;
      if (null == var3) {
         var4 = class31.field193;
         var5 = class12.field57;
      } else {
         var4 = var3.field3448;
         var5 = var3.field3476;
      }

      class235.method4586(var1, var4, var5, false);
      class327.method6234(var1, var4, var5);
   }

   static final void method1783(int var0, int var1, int var2, int var3, int var4) {
      class420.field4661[0].method8748(var0, var1);
      class420.field4661[1].method8748(var0, var1 + var3 - 16);
      class481.method8653(var0, var1 + 16, 16, var3 - 32, field1857);
      int var6 = (var3 - 32) * var3 / var4;
      if (var6 < 8) {
         var6 = 8;
      }

      int var7 = var2 * (var3 - 32 - var6) / (var4 - var3);
      class481.method8653(var0, var7 + var1 + 16, 16, var6, field1711);
      class481.method8660(var0, var7 + 16 + var1, var6, field1713);
      class481.method8660(1 + var0, var7 + var1 + 16, var6, field1713);
      class481.method8659(var0, var7 + var1 + 16, 16, field1713);
      class481.method8659(var0, 17 + var1 + var7, 16, field1713);
      class481.method8660(15 + var0, var7 + 16 + var1, var6, field1712);
      class481.method8660(14 + var0, var7 + var1 + 17, var6 - 1, field1712);
      class481.method8659(var0, var6 + var7 + var1 + 15, 16, field1712);
      class481.method8659(var0 + 1, var1 + 14 + var7 + var6, 15, field1712);
   }

   static void method8640(boolean var0) {
      field1796 = var0;
   }

   static boolean method4477() {
      return field1796;
   }

   static final void method5127(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (class246.method4928(var0)) {
         class128.method2390(class300.field3593[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   static boolean method2448(int var0) {
      for(int var2 = 0; var2 < field1822; ++var2) {
         if (var0 == field1880[var2]) {
            return true;
         }
      }

      return false;
   }

   final void method2894() {
      class136.method2438(field1874);
      ++class78.field684;
      int var2;
      int var3;
      if (field1783 && field1827) {
         var2 = class42.field284;
         var3 = class42.field285;
         var2 -= field1824;
         var3 -= field1825;
         if (var2 < field1746) {
            var2 = field1746;
         }

         if (var2 + field1874.field3448 > field1823.field3448 + field1746) {
            var2 = field1746 + field1823.field3448 - field1874.field3448;
         }

         if (var3 < field1829) {
            var3 = field1829;
         }

         if (var3 + field1874.field3476 > field1823.field3476 + field1829) {
            var3 = field1829 + field1823.field3476 - field1874.field3476;
         }

         int var15 = var2 - field1831;
         int var5 = var3 - field1832;
         int var6 = field1874.field3600;
         if (class78.field684 > field1874.field3604 && (var15 > var6 || var15 < -var6 || var5 > var6 || var5 < -var6)) {
            field1833 = true;
         }

         int var7 = field1823.field3481 + (var2 - field1746);
         int var8 = var3 - field1829 + field1823.field3482;
         class79 var9;
         if (field1874.field3478 != null && field1833) {
            var9 = new class79();
            var9.field694 = field1874;
            var9.field693 = var7;
            var9.field688 = var8;
            var9.field686 = field1874.field3478;
            class57.method5433(var9);
         }

         if (class42.field289 == 0) {
            if (field1833) {
               if (null != field1874.field3537) {
                  var9 = new class79();
                  var9.field694 = field1874;
                  var9.field693 = var7;
                  var9.field688 = var8;
                  var9.field691 = field1826;
                  var9.field686 = field1874.field3537;
                  class57.method5433(var9);
               }

               if (field1826 != null) {
                  class300 var18 = field1874;
                  int var12 = class190.method3528(var18);
                  int var19 = var12 >> 17 & 7;
                  int var13 = var19;
                  class300 var17;
                  if (0 == var19) {
                     var17 = null;
                  } else {
                     int var14 = 0;

                     while(true) {
                        if (var14 >= var13) {
                           var17 = var18;
                           break;
                        }

                        var18 = class282.method5426(var18.field3596);
                        if (var18 == null) {
                           var17 = null;
                           break;
                        }

                        ++var14;
                     }
                  }

                  if (null != var17) {
                     class263 var20 = class185.method3435(class274.field3097, field1778.field1071);
                     var20.field2984.method8234(field1874.field3517);
                     var20.field2984.method8174(field1874.field3445);
                     var20.field2984.method8174(field1874.field3484);
                     var20.field2984.method8174(field1826.field3484);
                     var20.field2984.method8234(field1826.field3517);
                     var20.field2984.method8152(field1826.field3445);
                     field1778.method2078(var20);
                  }
               }
            } else if (this.method2890()) {
               this.method3357(field1824 + field1831, field1825 + field1832);
            } else if (field1695 > 0) {
               int var16 = field1824 + field1831;
               int var10 = field1832 + field1825;
               class73 var11 = class101.field1005;
               if (var11 != null) {
                  class263.method5159(var11.field600, var11.field595, var11.field594, var11.field597, var11.field598, var11.field599, var11.field604, var16, var10);
               }

               class101.field1005 = null;
            }

            field1874 = null;
         }

      } else {
         if (class78.field684 > 1) {
            if (!field1833 && field1695 > 0) {
               var2 = field1831 + field1824;
               var3 = field1825 + field1832;
               class73 var4 = class101.field1005;
               if (var4 != null) {
                  class263.method5159(var4.field600, var4.field595, var4.field594, var4.field597, var4.field598, var4.field599, var4.field604, var2, var3);
               }

               class101.field1005 = null;
            }

            field1874 = null;
         }

      }
   }

   static void method102(int var0) {
      class101.field1005 = new class73();
      class101.field1005.field600 = field1851[var0];
      class101.field1005.field595 = field1787[var0];
      class101.field1005.field594 = field1788[var0];
      class101.field1005.field597 = field1789[var0];
      class101.field1005.field598 = field1790[var0];
      class101.field1005.field599 = field1791[var0];
      class101.field1005.field604 = field1923[var0];
   }

   static final void method4524(int var0) {
      var0 = Math.max(Math.min(var0, 100), 0);
      var0 = 100 - var0;
      float var2 = (float)var0 / 200.0F + 0.5F;
      method3634((double)var2);
   }

   static final int method6536() {
      float var1 = 200.0F * ((float)class413.field4575.method1717() - 0.5F);
      return 100 - Math.round(var1);
   }

   static final void method3634(double var0) {
      class221.method4394(var0);
      ((class215)class221.field2629).method4329(var0);
      class198.method716();
      class413.field4575.method1714(var0);
   }

   static final void method1354(int var0) {
      var0 = Math.min(Math.max(var0, 0), 127);
      class413.field4575.method1704(var0);
   }

   static final void method6041(int var0) {
      var0 = Math.min(Math.max(var0, 0), 127);
      class413.field4575.method1719(var0);
   }

   static final void method602() {
      for(int var1 = 0; var1 < class102.field1012; ++var1) {
         class93 var2 = field1763[class102.field1013[var1]];
         var2.method1911();
      }

   }

   static final void method6415() {
      field1845 = field1878;
      class105.field1046 = true;
   }

   static final void method2263() {
      field1846 = field1878;
      class145.field1335 = true;
   }

   static final void method2589() {
      class263 var1 = class185.method3435(class274.field3049, field1778.field1071);
      var1.field2984.method8097(0);
      field1778.method2078(var1);
   }

   static boolean method343(class300 var0) {
      return var0.field3480;
   }

   static void method5002(class460 var0, int var1) {
      byte[] var3 = var0.field4881;
      if (null == field1689) {
         field1689 = new byte[24];
      }

      class386.method6954(var3, var1, field1689, 0, 24);
      class199.method3732(var0, var1);
   }

   public class472 method6778() {
      return null != class291.field3364 ? class291.field3364.field910 : null;
   }

   static void method411(int var0) {
      field1722 = var0;
   }

   static void method202() {
      field1778.method2078(class185.method3435(class274.field3079, field1778.field1071));
      field1722 = 0;
   }

   static void method3391() {
      if (field1722 == 1) {
         field1643 = true;
      }

   }

   static void method3393() {
      class413.field4575.method1723(field1637);
   }

   public static boolean method5834() {
      return null != field1874;
   }

   static void method197(boolean var0) {
      field1862 = var0;
   }

   public static Clipboard method778() {
      return class133.field1257.method446();
   }
}
