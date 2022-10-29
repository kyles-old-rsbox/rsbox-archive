import com.jagex.oldscape.pub.OAuthApi;
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

public final class client extends class31 implements class375, OAuthApi {
	public static boolean field1635;
	public static class205 field1876;
	public static int field1868;
	public static int field1932;
	public static int field1936;
	public static final class107 field1778;
	static boolean field1636;
	static boolean field1640;
	static boolean field1643;
	static boolean field1648;
	static boolean field1650;
	static boolean field1660;
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
	static boolean field1828;
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
	static int field1633;
	static int field1634;
	static int field1637;
	static int field1638;
	static int field1639;
	static int field1642;
	static int field1645;
	static int field1647;
	static int field1651;
	static int field1652;
	static int field1654;
	static int field1655;
	static int field1656;
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
	static int field1684;
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
	static int field1704;
	static int field1709;
	static int field1711;
	static int field1712;
	static int field1713;
	static int field1715;
	static int field1716;
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
	static int field1766;
	static int field1767;
	static int field1768;
	static int field1769;
	static int field1773;
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
	static int field1866;
	static int field1867;
	static int field1871;
	static int field1872;
	static int field1875;
	static int field1878;
	static int field1879;
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
	static int field1911;
	static int field1913;
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
	static long field1644;
	static long field1646;
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
	boolean field1835;
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
	long field1688;

	public client() {
		this.field1835 = false;
		this.field1688 = -1L;
	}

	static {
		field1660 = true;
		field1868 = 1;
		field1633 = 0;
		field1911 = 0;
		field1635 = false;
		field1636 = false;
		field1637 = -1;
		field1704 = -1;
		field1716 = -1;
		field1640 = false;
		field1932 = 209;
		field1766 = 0;
		field1828 = true;
		field1645 = 0;
		field1646 = -1L;
		field1647 = -1;
		field1773 = -1;
		field1644 = -1L;
		field1650 = true;
		field1651 = 0;
		field1652 = 0;
		field1879 = 0;
		field1654 = 0;
		field1655 = 0;
		field1656 = 0;
		field1913 = 0;
		field1866 = 0;
		field1684 = 0;
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
		for (var3 = 0; var3 < var1; ++var3) {
			char var4 = "com_jagex_auth_desktop_osrs:public".charAt(var3);
			if (var4 > 127) {
				var2[var3] = 63;
			} else {
				var2[var3] = (byte)var4;
			}
		}

		byte[] var0 = var2;
		var3 = var2.length;
		StringBuilder var9 = new StringBuilder();

		for (int var5 = 0; var5 < var3 + 0; var5 += 3) {
			int var6 = var0[var5] & 255;
			var9.append(class351.field4277[var6 >>> 2]);
			if (var5 < var3 - 1) {
				int var7 = var0[var5 + 1] & 255;
				var9.append(class351.field4277[(var6 & 3) << 4 | var7 >>> 4]);
				if (var5 < var3 - 2) {
					int var8 = var0[var5 + 2] & 255;
					var9.append(class351.field4277[(var7 & 15) << 2 | var8 >>> 6]).append(class351.field4277[var8 & 63]);
				} else {
					var9.append(class351.field4277[(var7 & 15) << 2]).append("=");
				}
			} else {
				var9.append(class351.field4277[(var6 & 3) << 4]).append("==");
			}
		}

		String var11 = var9.toString();
		field1795 = var11;
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

	static class420 method6324() {
		return class4.field10;
	}

	protected final void method453() {
	}

	public final void init() {
		if (this.method547()) {
			int var3;
			for (int var1 = 0; var1 <= 28; ++var1) {
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
						class94.field940 = class353.method6565(Integer.parseInt(var2));
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
						if (var3 == -1) {
							field1932 = Integer.parseInt(var2);
						} else {
							field1932 = Integer.parseInt(var2.substring(0, var3));
							Integer.parseInt(var2.substring(var3 + 1));
						}
					}
				}
			}

			method7922();
			class271.field3032 = this.getCodeBase().getHost();
			String var8 = class259.field2962.field3836;
			byte var9 = 0;

			try {
				class163.field1502 = 22;
				class163.field1511 = var9;

				try {
					class42.field296 = System.getProperty("os.name");
				} catch (Exception var16) {
					class42.field296 = "Unknown";
				}

				class20.field100 = class42.field296.toLowerCase();

				try {
					class45.field328 = System.getProperty("user.home");
					if (null != class45.field328) {
						class45.field328 = class45.field328 + "/";
					}
				} catch (Exception var15) {
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
				} catch (Exception var14) {
				}

				if (class45.field328 == null) {
					class45.field328 = "~/";
				}

				class347.field4261 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class45.field328, "/tmp/", ""};
				class251.field2908 = new String[]{".jagex_cache_" + class163.field1511, ".file_store_" + class163.field1511};

				label170:
				for (var3 = 0; var3 < 4; ++var3) {
					class290.field3361 = class4.method34("oldschool", var8, var3);
					if (!class290.field3361.exists()) {
						class290.field3361.mkdirs();
					}

					File[] var4 = class290.field3361.listFiles();
					if (null == var4) {
						break;
					}

					File[] var5 = var4;
					int var6 = 0;

					while (true) {
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
					File var10 = new File(class45.field328, "random.dat");
					int var12;
					if (var10.exists()) {
						class163.field1498 = new class466(new class464(var10, "rw", 25L), 24, 0);
					} else {
						label150:
						for (int var11 = 0; var11 < class251.field2908.length; ++var11) {
							for (var12 = 0; var12 < class347.field4261.length; ++var12) {
								File var13 = new File(class347.field4261[var12] + class251.field2908[var11] + File.separatorChar + "random.dat");
								if (var13.exists()) {
									class163.field1498 = new class466(new class464(var13, "rw", 25L), 24, 0);
									break label150;
								}
							}
						}
					}

					if (class163.field1498 == null) {
						RandomAccessFile var19 = new RandomAccessFile(var10, "rw");
						var12 = var19.read();
						var19.seek(0L);
						var19.write(var12);
						var19.seek(0L);
						var19.close();
						class163.field1498 = new class466(new class464(var10, "rw", 25L), 24, 0);
					}
				} catch (IOException var17) {
				}

				class163.field1503 = new class466(new class464(class106.method2066("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
				class163.field1509 = new class466(new class464(class106.method2066("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
				class163.field1510 = new class466[class163.field1502];

				for (var3 = 0; var3 < class163.field1502; ++var3) {
					class163.field1510[var3] = new class466(new class464(class106.method2066("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
				}
			} catch (Exception var18) {
				class422.method7807((String)null, var18);
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

	static final void method7922() {
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
		URL var4 = new URL(class106.field1050 + "shield/oauth/token" + (new class431(var3)).method7848());
		HashMap var5 = new HashMap();
		var5.put("Authorization", "Basic " + field1795);
		var5.put("Host", (new URL(class106.field1050)).getHost());
		var5.put("Accept", class430.field4700.method7844());
		class18 var6 = class18.field87;
		RefreshAccessTokenRequester var7 = this.field1680;
		if (var7 != null) {
			this.field1681 = var7.request(var6.method215(), var4, var5, "");
		} else {
			class12 var8 = new class12(var4, var6, this.field1835);
			Iterator var9 = var5.entrySet().iterator();

			while (var9.hasNext()) {
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

			while (var8.hasNext()) {
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

			for (int var4 = 0; var4 < class229.field2738.length; ++var4) {
				class359.field4312[var4] = new byte[var3[var4]][];
				class378.field4402.add(var2[var4]);
			}

			Collections.sort(class378.field4402);
		} else {
			class229.field2738 = null;
			class258.field2960 = null;
			class359.field4312 = (byte[][][])null;
			class378.method6183();
		}

		class180.field1608 = field1911 == 0 ? 43594 : 40000 + field1868;
		class141.field1307 = field1911 == 0 ? 443 : 50000 + field1868;
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
			byte[] var7 = new byte[(int)var5.method8373()];

			int var9;
			for (int var8 = 0; var8 < var7.length; var8 += var9) {
				var9 = var5.method8369(var7, var8, var7.length - var8);
				if (var9 == -1) {
					throw new IOException();
				}
			}

			var6 = new class83(new class460(var7));
		} catch (Exception var12) {
		}

		try {
			if (null != var5) {
				var5.method8374();
			}
		} catch (Exception var11) {
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
		class349.method6457();
		field1876.method3893();
		this.method539();
		class42.method4616();
		if (null != class18.field94) {
			int var2 = class18.field94.method2702();
			field1639 = var2;
		}

		if (field1766 == 0) {
			class34.method649();
			class339.method6315();
		} else if (field1766 == 5) {
			class442.method7923(this, class353.field4289);
			class34.method649();
			class339.method6315();
		} else if (10 != field1766 && 11 != field1766) {
			if (20 == field1766) {
				class442.method7923(this, class353.field4289);
				this.method2882();
			} else if (50 == field1766) {
				class442.method7923(this, class353.field4289);
				this.method2882();
			} else if (25 == field1766) {
				class43.method802();
			}
		} else {
			class442.method7923(this, class353.field4289);
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
						class370.field4368 = new class49(class279.field3200, class279.field3199);
					}

					if (class279.field3201.method5273(class141.field1300, class279.field3206, class370.field4368, 22050)) {
						class279.field3201.method5277();
						class279.field3201.method5271(class110.field1092);
						class279.field3201.method5276(class141.field1300, class337.field3889);
						class279.field3202 = 0;
						class141.field1300 = null;
						class370.field4368 = null;
						class7.field29 = null;
						var3 = true;
						break label170;
					}
				}
			} catch (Exception var7) {
				var7.printStackTrace();
				class279.field3201.method5365();
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
			for (var5 = 0; var5 < 100; ++var5) {
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
			for (var5 = 0; var5 < field1858; ++var5) {
				if (field1861[var5]) {
					class6.field18.method8620(field1863[var5], field1864[var5], field1710[var5], field1658[var5]);
					field1861[var5] = false;
				}
			}
		} else if (field1766 > 0) {
			class6.field18.method8621(0, 0);

			for (var5 = 0; var5 < field1858; ++var5) {
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

		class323.method6200();
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
						while (class324.field3780 < 200 && class324.field3778 > 0) {
							var6 = (class335)class324.field3794.method7867();
							var7 = new class460(4);
							var7.method8104(1);
							var7.method8106((int)var6.field4681);
							class324.field3787.method7258(var7.field4881, 0, 4);
							class324.field3779.method7857(var6, var6.field4681);
							--class324.field3778;
							++class324.field3780;
						}

						while (class324.field3777 < 200 && class324.field3788 > 0) {
							var6 = (class335)class324.field3781.method6573();
							var7 = new class460(4);
							var7.method8104(0);
							var7.method8106((int)var6.field4681);
							class324.field3787.method7258(var7.field4881, 0, 4);
							var6.method7889();
							class324.field3784.method7857(var6, var6.field4681);
							--class324.field3788;
							++class324.field3777;
						}

						for (int var18 = 0; var18 < 100; ++var18) {
							int var19 = class324.field3787.method7255();
							if (var19 < 0) {
								throw new IOException();
							}

							if (var19 == 0) {
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
							class460 var26;
							if (var8 > 0) {
								var9 = var8 - class324.field3776.field4878;
								if (var9 > var19) {
									var9 = var19;
								}

								class324.field3787.method7267(class324.field3776.field4881, class324.field3776.field4878, var9);
								if (class324.field3792 != 0) {
									for (var10 = 0; var10 < var9; ++var10) {
										var10000 = class324.field3776.field4881;
										var10001 = var10 + class324.field3776.field4878;
										var10000[var10001] ^= class324.field3792;
									}
								}

								var26 = class324.field3776;
								var26.field4878 += var9;
								if (class324.field3776.field4878 < var8) {
									break;
								}

								if (null == class116.field1137) {
									class324.field3776.field4878 = 0;
									var10 = class324.field3776.method8141();
									var11 = class324.field3776.method8122();
									int var12 = class324.field3776.method8141();
									var13 = class324.field3776.method8126();
									long var14 = (long)((var10 << 16) + var11);
									class335 var16 = (class335)class324.field3779.method7855(var14);
									class111.field1097 = true;
									if (null == var16) {
										var16 = (class335)class324.field3784.method7855(var14);
										class111.field1097 = false;
									}

									if (var16 == null) {
										throw new IOException();
									}

									int var17 = var12 == 0 ? 5 : 9;
									class116.field1137 = var16;
									class431.field4704 = new class460(class116.field1137.field3868 + var13 + var17);
									class431.field4704.method8104(var12);
									class431.field4704.method8241(var13);
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

								if (var10 > var19) {
									var10 = var19;
								}

								class324.field3787.method7267(class431.field4704.field4881, class431.field4704.field4878, var10);
								if (class324.field3792 != 0) {
									for (var11 = 0; var11 < var10; ++var11) {
										var10000 = class431.field4704.field4881;
										var10001 = var11 + class431.field4704.field4878;
										var10000[var10001] ^= class324.field3792;
									}
								}

								var26 = class431.field4704;
								var26.field4878 += var10;
								class324.field3790 += var10;
								if (var9 == class431.field4704.field4878) {
									if (16711935L == class116.field1137.field4681) {
										class110.field1090 = class431.field4704;

										for (var11 = 0; var11 < 256; ++var11) {
											class336 var20 = class324.field3789[var11];
											if (null != var20) {
												class110.field1090.field4878 = var11 * 8 + 5;
												if (class110.field1090.field4878 >= class110.field1090.field4881.length) {
													if (!var20.field3883) {
														throw new RuntimeException("");
													}

													var20.method6281();
												} else {
													var13 = class110.field1090.method8126();
													int var21 = class110.field1090.method8126();
													var20.method6298(var13, var21);
												}
											}
										}
									} else {
										class324.field3785.reset();
										class324.field3785.update(class431.field4704.field4881, 0, var9);
										var11 = (int)class324.field3785.getValue();
										if (var11 != class116.field1137.field3865) {
											try {
												class324.field3787.method7259();
											} catch (Exception var24) {
											}

											++class324.field3793;
											class324.field3787 = null;
											class324.field3792 = (byte)((int)(Math.random() * 255.0D + 1.0D));
											var2 = false;
											break label246;
										}

										class324.field3793 = 0;
										class324.field3775 = 0;
										class116.field1137.field3866.method6278((int)(class116.field1137.field4681 & 65535L), class431.field4704.field4881, 16711680L == (class116.field1137.field4681 & 16711680L), class111.field1097);
									}

									class116.field1137.method7825();
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
				} catch (IOException var25) {
					try {
						class324.field3787.method7259();
					} catch (Exception var23) {
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

						if (class347.field4257.field1614 == 1) {
							++field1663;
						}
					}

					class460 var4;
					if (2 == field1663) {
						Socket var3 = (Socket)class347.field4257.field1612;
						class409 var2 = new class409(var3, 40000, 5000);
						class312.field3697 = var2;
						var4 = new class460(5);
						var4.method8104(15);
						var4.method8241(209);
						class312.field3697.method7258(var4.field4881, 0, 5);
						++field1663;
						class218.field2591 = class272.method2046();
					}

					if (3 == field1663) {
						if (class312.field3697.method7255() > 0) {
							int var6 = class312.field3697.method7256();
							if (var6 != 0) {
								this.method3062(var6);
								return;
							}

							++field1663;
						} else if (class272.method2046() - class218.field2591 > 30000L) {
							this.method3062(-2);
							return;
						}
					}

					if (field1663 == 4) {
						class401 var12 = class312.field3697;
						boolean var7 = field1766 > 20;
						if (null != class324.field3787) {
							try {
								class324.field3787.method7259();
							} catch (Exception var10) {
							}

							class324.field3787 = null;
						}

						class324.field3787 = var12;
						class42.method799(var7);
						class324.field3776.field4878 = 0;
						class116.field1137 = null;
						class431.field4704 = null;
						class324.field3790 = 0;

						while (true) {
							class335 var13 = (class335)class324.field3779.method7867();
							if (var13 == null) {
								while (true) {
									var13 = (class335)class324.field3784.method7867();
									if (null == var13) {
										if (class324.field3792 != 0) {
											try {
												var4 = new class460(4);
												var4.method8104(4);
												var4.method8104(class324.field3792);
												var4.method8181(0);
												class324.field3787.method7258(var4.field4881, 0, 4);
											} catch (IOException var9) {
												try {
													class324.field3787.method7259();
												} catch (Exception var8) {
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

									class324.field3781.method6579(var13);
									class324.field3782.method7857(var13, var13.field4681);
									++class324.field3788;
									--class324.field3777;
								}
							}

							class324.field3794.method7857(var13, var13.field4681);
							++class324.field3778;
							--class324.field3780;
						}
					}
				} catch (IOException var11) {
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
		if (field1666 >= 2 && (var1 == 7 || var1 == 9)) {
			if (field1766 <= 5) {
				this.method473("js5connect_full");
				class9.method64(1000);
			} else {
				field1664 = 3000;
			}
		} else if (field1666 >= 2 && var1 == 6) {
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
			var5 = var4.method6124("sl_back");
			var6 = var4.method6170(var5, "");
			class473[] var3 = class397.method7205(var4, var5, var6);
			class289.field3357 = var3;
		}

		if (null == class200.field2206) {
			class200.field2206 = class475.method7371(class155.field1425, "sl_flags", "");
		}

		if (class84.field752 == null) {
			class84.field752 = class475.method7371(class155.field1425, "sl_arrows", "");
		}

		if (null == class207.field2367) {
			class207.field2367 = class475.method7371(class155.field1425, "sl_stars", "");
		}

		if (null == class227.field2723) {
			class227.field2723 = class393.method7165(class155.field1425, "leftarrow", "");
		}

		if (class7.field24 == null) {
			class7.field24 = class393.method7165(class155.field1425, "rightarrow", "");
		}

		class481.method8660(class75.field618, 23, 765, 480, 0);
		class481.method8686(class75.field618, 0, 125, 23, 12425273, 9135624);
		class481.method8686(125 + class75.field618, 0, 640, 23, 5197647, 2697513);
		var0.method6955(class338.field4054, 62 + class75.field618, 15, 0, -1);
		if (null != class207.field2367) {
			class207.field2367[1].method8755(class75.field618 + 140, 1);
			var1.method6875(class338.field4126, 152 + class75.field618, 10, 16777215, -1);
			class207.field2367[0].method8755(140 + class75.field618, 12);
			var1.method6875(class338.field4059, class75.field618 + 152, 21, 16777215, -1);
		}

		if (class84.field752 != null) {
			int var23 = class75.field618 + 280;
			if (class72.field585[0] == 0 && class72.field584[0] == 0) {
				class84.field752[2].method8755(var23, 4);
			} else {
				class84.field752[0].method8755(var23, 4);
			}

			if (class72.field585[0] == 0 && class72.field584[0] == 1) {
				class84.field752[3].method8755(var23 + 15, 4);
			} else {
				class84.field752[1].method8755(var23 + 15, 4);
			}

			var0.method6875(class338.field4206, var23 + 32, 17, 16777215, -1);
			int var24 = 390 + class75.field618;
			if (class72.field585[0] == 1 && 0 == class72.field584[0]) {
				class84.field752[2].method8755(var24, 4);
			} else {
				class84.field752[0].method8755(var24, 4);
			}

			if (1 == class72.field585[0] && 1 == class72.field584[0]) {
				class84.field752[3].method8755(var24 + 15, 4);
			} else {
				class84.field752[1].method8755(var24 + 15, 4);
			}

			var0.method6875(class338.field4207, var24 + 32, 17, 16777215, -1);
			var5 = class75.field618 + 500;
			if (2 == class72.field585[0] && class72.field584[0] == 0) {
				class84.field752[2].method8755(var5, 4);
			} else {
				class84.field752[0].method8755(var5, 4);
			}

			if (2 == class72.field585[0] && 1 == class72.field584[0]) {
				class84.field752[3].method8755(var5 + 15, 4);
			} else {
				class84.field752[1].method8755(var5 + 15, 4);
			}

			var0.method6875(class338.field3925, var5 + 32, 17, 16777215, -1);
			var6 = 610 + class75.field618;
			if (class72.field585[0] == 3 && 0 == class72.field584[0]) {
				class84.field752[2].method8755(var6, 4);
			} else {
				class84.field752[0].method8755(var6, 4);
			}

			if (3 == class72.field585[0] && class72.field584[0] == 1) {
				class84.field752[3].method8755(var6 + 15, 4);
			} else {
				class84.field752[1].method8755(var6 + 15, 4);
			}

			var0.method6875(class338.field4202, var6 + 32, 17, 16777215, -1);
		}

		class481.method8660(708 + class75.field618, 4, 50, 16, 0);
		var1.method6955(class338.field4149, class75.field618 + 708 + 25, 16, 16777215, -1);
		class75.field626 = -1;
		if (null != class289.field3357) {
			byte var27 = 88;
			byte var28 = 19;
			var5 = 765 / (var27 + 1) - 1;
			var6 = 480 / (var28 + 1);

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

			var7 = (765 - var27 * var5) / (var5 + 1);
			if (var7 > 5) {
				var7 = 5;
			}

			var8 = (480 - var6 * var28) / (var6 + 1);
			if (var8 > 5) {
				var8 = 5;
			}

			int var9 = (765 - var5 * var27 - var7 * (var5 - 1)) / 2;
			int var10 = (480 - var6 * var28 - var8 * (var6 - 1)) / 2;
			int var11 = (var6 + class72.field582 - 1) / var6;
			class75.field616 = var11 - var5;
			if (null != class227.field2723 && class75.field645 > 0) {
				class227.field2723.method8755(8, class12.field57 / 2 - class227.field2723.field5019 / 2);
			}

			if (null != class7.field24 && class75.field645 < class75.field616) {
				class7.field24.method8755(class31.field193 - class7.field24.field5017 - 8, class12.field57 / 2 - class7.field24.field5019 / 2);
			}

			int var12 = var10 + 23;
			int var13 = var9 + class75.field618;
			int var14 = 0;
			boolean var15 = false;
			int var16 = class75.field645;

			int var17;
			for (var17 = var16 * var6; var17 < class72.field582 && var16 - class75.field645 < var5; ++var17) {
				class72 var25 = class399.field4502[var17];
				boolean var19 = true;
				String var20 = Integer.toString(var25.field593);
				if (var25.field593 == -1) {
					var20 = class338.field4210;
					var19 = false;
				} else if (var25.field593 > 1980) {
					var20 = class338.field3891;
					var19 = false;
				}

				int var22 = 0;
				int var21;
				if (var25.method1454()) {
					if (var25.method1447()) {
						var21 = class94.field930.field937;
					} else {
						var21 = class94.field942.field937;
					}
				} else if (var25.method1442()) {
					var22 = 16711680;
					if (var25.method1447()) {
						var21 = class94.field928.field937;
					} else {
						var21 = class94.field927.field937;
					}
				} else if (var25.method1480()) {
					if (var25.method1447()) {
						var21 = class94.field932.field937;
					} else {
						var21 = class94.field941.field937;
					}
				} else if (var25.method1440()) {
					if (var25.method1447()) {
						var21 = class94.field926.field937;
					} else {
						var21 = class94.field925.field937;
					}
				} else if (var25.method1445()) {
					if (var25.method1447()) {
						var21 = class94.field936.field937;
					} else {
						var21 = class94.field933.field937;
					}
				} else if (var25.method1469()) {
					if (var25.method1447()) {
						var21 = class94.field934.field937;
					} else {
						var21 = class94.field935.field937;
					}
				} else if (var25.method1447()) {
					var21 = class94.field924.field937;
				} else {
					var21 = class94.field931.field937;
				}

				if (class42.field284 >= var13 && class42.field285 >= var12 && class42.field284 < var27 + var13 && class42.field285 < var12 + var28 && var19) {
					class75.field626 = var17;
					class289.field3357[var21].method8489(var13, var12, 128, 16777215);
					var15 = true;
				} else {
					class289.field3357[var21].method8483(var13, var12);
				}

				if (null != class200.field2206) {
					class200.field2206[(var25.method1447() ? 8 : 0) + var25.field580].method8755(var13 + 29, var12);
				}

				var0.method6955(Integer.toString(var25.field590), var13 + 15, var28 / 2 + var12 + 5, var22, -1);
				var1.method6955(var20, var13 + 60, var28 / 2 + var12 + 5, 268435455, -1);
				var12 += var8 + var28;
				++var14;
				if (var14 >= var6) {
					var12 = var10 + 23;
					var13 += var7 + var27;
					var14 = 0;
					++var16;
				}
			}

			if (var15) {
				var17 = var1.method6894(class399.field4502[class75.field626].field588) + 6;
				int var18 = var1.field4435 + 8;
				int var26 = class42.field285 + 25;
				if (var18 + var26 > 480) {
					var26 = class42.field285 - 25 - var18;
				}

				class481.method8660(class42.field284 - var17 / 2, var26, var17, var18, 16777120);
				class481.method8664(class42.field284 - var17 / 2, var26, var17, var18, 0);
				var1.method6955(class399.field4502[class75.field626].field588, class42.field284, var26 + var1.field4435 + 4, 0, -1);
			}
		}

		class6.field18.method8621(0, 0);
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
				class84.field745 = class393.method7165(var2, "logo_deadman_mode", "");
			} else if (0 != (var3 & 1073741824)) {
				class84.field745 = class393.method7165(var2, "logo_seasonal_mode", "");
			} else if (0 != (var3 & 256)) {
				class84.field745 = class393.method7165(var2, "logo_speedrunning", "");
			} else {
				class84.field745 = class393.method7165(var2, "logo", "");
			}
		}

		class271.field3032 = var0.field589;
		field1868 = var0.field590;
		field1633 = var0.field587;
		class180.field1608 = 0 == field1911 ? 43594 : 40000 + var0.field590;
		class141.field1307 = 0 == field1911 ? 443 : 50000 + var0.field590;
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
						((class401)var2).method7259();
						var2 = null;
					}

					class231.field2748 = null;
					field1697 = false;
					field1668 = 0;
					if (field1758.method7938()) {
						try {
							this.method2876(class298.field3437);
							class43.method801(21);
						} catch (Throwable var26) {
							class422.method7807((String)null, var26);
							class112.method2169(65);
							return;
						}
					} else {
						class43.method801(1);
					}
				}
			}

			class9 var28;
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
					} catch (Exception var25) {
						class422.method7807((String)null, var25);
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
						class422.method7807(this.field1679.method111(), (Throwable)null);
						class112.method2169(65);
						this.field1679 = null;
						return;
					}

					var28 = this.field1679.method108();
					if (var28.method54() != 200) {
						class112.method2169(65);
						this.field1679 = null;
						return;
					}

					field1668 = 0;
					class425 var5 = new class425(var28.method55());

					try {
						class310.field3689 = var5.method7816().getString("access_token");
						class298.field3437 = var5.method7816().getString("refresh_token");
					} catch (Exception var24) {
						class422.method7807("Error parsing tokens", var24);
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
						OtlTokenResponse var29 = (OtlTokenResponse)this.field1677.get();
						if (!var29.isSuccess()) {
							class112.method2169(65);
							this.field1677 = null;
							return;
						}

						this.field1673 = var29.getToken();
						this.field1677 = null;
					} catch (Exception var23) {
						class422.method7807((String)null, var23);
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
						class422.method7807(this.field1675.method111(), (Throwable)null);
						class112.method2169(65);
						this.field1675 = null;
						return;
					}

					var28 = this.field1675.method108();
					if (var28.method54() != 200) {
						class422.method7807("Response code: " + var28.method54() + "Response body: " + var28.method55(), (Throwable)null);
						class112.method2169(65);
						this.field1675 = null;
						return;
					}

					this.field1673 = var28.method55();
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
					Socket var30 = (Socket)class231.field2748.field1612;
					class409 var31 = new class409(var30, 40000, 5000);
					var2 = var31;
					field1778.method2097(var31);
					class231.field2748 = null;
					class43.method801(2);
				}
			}

			class263 var32;
			if (2 == field1667) {
				field1778.method2076();
				var32 = class263.method5167();
				var32.field2984.method8104(class261.field2976.field2979);
				field1778.method2078(var32);
				field1778.method2081();
				var3.field4878 = 0;
				class43.method801(3);
			}

			int var13;
			if (3 == field1667) {
				if (class91.field886 != null) {
					class91.field886.method378();
				}

				if (null != class88.field794) {
					class88.field794.method378();
				}

				if (((class401)var2).method7254(1)) {
					var13 = ((class401)var2).method7256();
					if (class91.field886 != null) {
						class91.field886.method378();
					}

					if (class88.field794 != null) {
						class88.field794.method378();
					}

					if (var13 != 0) {
						class112.method2169(var13);
						return;
					}

					var3.field4878 = 0;
					class43.method801(4);
				}
			}

			if (field1667 == 4) {
				if (var3.field4878 < 8) {
					var13 = ((class401)var2).method7255();
					if (var13 > 8 - var3.field4878) {
						var13 = 8 - var3.field4878;
					}

					if (var13 > 0) {
						((class401)var2).method7267(var3.field4881, var3.field4878, var13);
						var3.field4878 += var13;
					}
				}

				if (8 == var3.field4878) {
					var3.field4878 = 0;
					class170.field1540 = var3.method8127();
					class43.method801(5);
				}
			}

			int var10;
			int var14;
			int var15;
			if (5 == field1667) {
				field1778.field1076.field4878 = 0;
				field1778.method2076();
				class453 var34 = new class453(500);
				int[] var33 = new int[]{class147.field1355.nextInt(), class147.field1355.nextInt(), class147.field1355.nextInt(), class147.field1355.nextInt()};
				var34.field4878 = 0;
				var34.method8104(1);
				var34.method8241(var33[0]);
				var34.method8241(var33[1]);
				var34.method8241(var33[2]);
				var34.method8241(var33[3]);
				var34.method8109(class170.field1540);
				int var12;
				if (40 == field1766) {
					var34.method8241(class119.field1157[0]);
					var34.method8241(class119.field1157[1]);
					var34.method8241(class119.field1157[2]);
					var34.method8241(class119.field1157[3]);
				} else {
					if (field1766 == 50) {
						var34.method8104(class141.field1304.method6663());
						var34.method8241(class158.field1451);
					} else {
						var34.method8104(field1671.method6663());
						switch(field1671.field1305) {
						case 0:
							LinkedHashMap var7 = class413.field4575.field744;
							String var9 = class75.field633;
							var10 = var9.length();
							int var11 = 0;

							for (var12 = 0; var12 < var10; ++var12) {
								var11 = (var11 << 5) - var11 + var9.charAt(var12);
							}

							var34.method8241((Integer)var7.get(var11));
							break;
						case 1:
						case 3:
							var34.method8106(class340.field4220);
							++var34.field4878;
						case 2:
						default:
							break;
						case 4:
							var34.field4878 += 4;
						}
					}

					if (field1758.method7938()) {
						var34.method8104(class445.field4787.method6663());
						var34.method8111(this.field1673);
					} else {
						var34.method8104(class445.field4791.method6663());
						var34.method8111(class75.field650);
					}
				}

				var34.method8147(class62.field493, class62.field494);
				class119.field1157 = var33;
				class263 var6 = class263.method5167();
				var6.field2984.field4878 = 0;
				if (field1766 == 40) {
					var6.field2984.method8104(class261.field2975.field2979);
				} else {
					var6.field2984.method8104(class261.field2980.field2979);
				}

				var6.field2984.method8181(0);
				var14 = var6.field2984.field4878;
				var6.field2984.method8241(209);
				var6.field2984.method8241(1);
				var6.field2984.method8104(field1704);
				var6.field2984.method8104(field1716);
				byte var8 = 0;
				var6.field2984.method8104(var8);
				var6.field2984.method8114(var34.field4881, 0, var34.field4878);
				var15 = var6.field2984.field4878;
				var6.field2984.method8111(class75.field633);
				var6.field2984.method8104((field1869 ? 1 : 0) << 1 | (field1636 ? 1 : 0));
				var6.field2984.method8181(class31.field193);
				var6.field2984.method8181(class12.field57);
				class296.method5552(var6.field2984);
				var6.field2984.method8111(class61.field481);
				var6.field2984.method8241(class11.field45);
				class460 var16 = new class460(class197.field2120.method7900());
				class197.field2120.method7903(var16);
				var6.field2984.method8114(var16.field4881, 0, var16.field4881.length);
				var6.field2984.method8104(field1704);
				var6.field2984.method8241(0);
				var6.field2984.method8155(class136.field1275.field3746);
				var6.field2984.method8241(class174.field1564.field3746);
				var6.field2984.method8353(class304.field3634.field3746);
				var6.field2984.method8241(class155.field1425.field3746);
				var6.field2984.method8155(class58.field417.field3746);
				var6.field2984.method8353(0);
				var6.field2984.method8171(class42.field295.field3746);
				var6.field2984.method8353(class147.field1352.field3746);
				var6.field2984.method8241(class243.field2846.field3746);
				var6.field2984.method8155(class139.field1286.field3746);
				var6.field2984.method8171(class324.field3783.field3746);
				var6.field2984.method8155(class43.field311.field3746);
				var6.field2984.method8353(class333.field3859.field3746);
				var6.field2984.method8171(class4.field12.field3746);
				var6.field2984.method8353(class252.field2922.field3746);
				var6.field2984.method8241(field1665.field3746);
				var6.field2984.method8171(class71.field578.field3746);
				var6.field2984.method8171(class371.field4369.field3746);
				var6.field2984.method8353(class145.field1338.field3746);
				var6.field2984.method8241(class11.field48.field3746);
				var6.field2984.method8171(class202.field2255.field3746);
				var6.field2984.method8145(var33, var15, var6.field2984.field4878);
				var6.field2984.method8117(var6.field2984.field4878 - var14);
				field1778.method2078(var6);
				field1778.method2081();
				field1778.field1071 = new class479(var33);
				int[] var17 = new int[4];

				for (var12 = 0; var12 < 4; ++var12) {
					var17[var12] = 50 + var33[var12];
				}

				var3.method8006(var17);
				class43.method801(6);
			}

			int var18;
			if (field1667 == 6 && ((class401)var2).method7255() > 0) {
				var13 = ((class401)var2).method7256();
				if (var13 == 61) {
					var18 = ((class401)var2).method7255();
					class87.field781 = var18 == 1 && ((class401)var2).method7256() == 1;
					class43.method801(5);
				}

				if (var13 == 21 && field1766 == 20) {
					class43.method801(12);
				} else if (var13 == 2) {
					class43.method801(14);
				} else if (var13 == 15 && 40 == field1766) {
					field1778.field1075 = -1;
					class43.method801(19);
				} else if (var13 == 64) {
					class43.method801(10);
				} else if (var13 == 23 && field1669 < 1) {
					++field1669;
					class43.method801(0);
				} else if (var13 == 29) {
					class43.method801(17);
				} else {
					if (var13 != 69) {
						class112.method2169(var13);
						return;
					}

					class43.method801(7);
				}
			}

			if (field1667 == 7 && ((class401)var2).method7255() >= 2) {
				((class401)var2).method7267(var3.field4881, 0, 2);
				var3.field4878 = 0;
				class77.field669 = var3.method8122();
				class43.method801(8);
			}

			if (field1667 == 8 && ((class401)var2).method7255() >= class77.field669) {
				var3.field4878 = 0;
				((class401)var2).method7267(var3.field4881, var3.field4878, class77.field669);
				class25[] var36 = new class25[]{class25.field122};
				class25 var35 = var36[var3.method8141()];

				try {
					class24 var37 = class8.method3967(var35);
					this.field1687 = new class4(var3, var37);
					class43.method801(9);
				} catch (Exception var22) {
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
				var32 = class263.method5167();
				var32.field2984.method8104(class261.field2977.field2979);
				var32.field2984.method8181(this.field1728.field4878);
				var32.field2984.method8115(this.field1728);
				field1778.method2078(var32);
				field1778.method2081();
				this.field1728 = null;
				class43.method801(6);
			}

			if (field1667 == 10 && ((class401)var2).method7255() > 0) {
				class195.field2104 = ((class401)var2).method7256();
				class43.method801(11);
			}

			if (field1667 == 11 && ((class401)var2).method7255() >= class195.field2104) {
				((class401)var2).method7267(var3.field4881, 0, class195.field2104);
				var3.field4878 = 0;
				class43.method801(6);
			}

			if (field1667 == 12 && ((class401)var2).method7255() > 0) {
				field1717 = (((class401)var2).method7256() + 3) * 60;
				class43.method801(13);
			}

			if (field1667 == 13) {
				field1668 = 0;
				class75.method5452(class338.field4083, class338.field3943, field1717 / 60 + class338.field3935);
				if (--field1717 <= 0) {
					class43.method801(0);
				}

			} else {
				if (14 == field1667 && ((class401)var2).method7255() >= 1) {
					class77.field662 = ((class401)var2).method7256();
					class43.method801(15);
				}

				if (field1667 == 15 && ((class401)var2).method7255() >= class77.field662) {
					boolean var47 = ((class401)var2).method7256() == 1;
					((class401)var2).method7267(var3.field4881, 0, 4);
					var3.field4878 = 0;
					boolean var48 = false;
					if (var47) {
						var18 = var3.method8009() << 24;
						var18 |= var3.method8009() << 16;
						var18 |= var3.method8009() << 8;
						var18 |= var3.method8009();
						String var43 = class75.field633;
						int var45 = var43.length();
						var15 = 0;
						var10 = 0;

						while (true) {
							if (var10 >= var45) {
								if (class413.field4575.field744.size() >= 10 && !class413.field4575.field744.containsKey(var15)) {
									Iterator var46 = class413.field4575.field744.entrySet().iterator();
									var46.next();
									var46.remove();
								}

								class413.field4575.field744.put(var15, var18);
								break;
							}

							var15 = (var15 << 5) - var15 + var43.charAt(var10);
							++var10;
						}
					}

					if (field1891) {
						class413.field4575.method1710(class75.field633);
					} else {
						class413.field4575.method1710((String)null);
					}

					class151.method2592();
					field1750 = ((class401)var2).method7256();
					field1820 = ((class401)var2).method7256() == 1;
					field1764 = ((class401)var2).method7256();
					field1764 <<= 8;
					field1764 += ((class401)var2).method7256();
					field1921 = ((class401)var2).method7256();
					((class401)var2).method7267(var3.field4881, 0, 8);
					var3.field4878 = 0;
					this.field1688 = var3.method8127();
					if (class77.field662 >= 29) {
						((class401)var2).method7267(var3.field4881, 0, 8);
						var3.field4878 = 0;
						field1632 = var3.method8127();
					}

					((class401)var2).method7267(var3.field4881, 0, 1);
					var3.field4878 = 0;
					class283[] var40 = class283.method2743();
					var14 = var3.method8011();
					if (var14 < 0 || var14 >= var40.length) {
						throw new IOException(var14 + " " + var3.field4878);
					}

					field1778.field1073 = var40[var14];
					field1778.field1075 = field1778.field1073.field3240;
					((class401)var2).method7267(var3.field4881, 0, 2);
					var3.field4878 = 0;
					field1778.field1075 = var3.method8122();

					try {
						class40.method756(class133.field1257, "zap");
					} catch (Throwable var21) {
					}

					class43.method801(16);
				}

				if (field1667 != 16) {
					if (17 == field1667 && ((class401)var2).method7255() >= 2) {
						var3.field4878 = 0;
						((class401)var2).method7267(var3.field4881, 0, 2);
						var3.field4878 = 0;
						class135.field1268 = var3.method8122();
						class43.method801(18);
					}

					if (field1667 == 18 && ((class401)var2).method7255() >= class135.field1268) {
						var3.field4878 = 0;
						((class401)var2).method7267(var3.field4881, 0, class135.field1268);
						var3.field4878 = 0;
						String var44 = var3.method8131();
						String var39 = var3.method8131();
						String var41 = var3.method8131();
						class75.method5452(var44, var39, var41);
						class9.method64(10);
						if (field1758.method7938()) {
							class74.method1490(9);
						}
					}

					if (19 == field1667) {
						if (-1 == field1778.field1075) {
							if (((class401)var2).method7255() < 2) {
								return;
							}

							((class401)var2).method7267(var3.field4881, 0, 2);
							var3.field4878 = 0;
							field1778.field1075 = var3.method8122();
						}

						if (((class401)var2).method7255() >= field1778.field1075) {
							((class401)var2).method7267(var3.field4881, 0, field1778.field1075);
							var3.field4878 = 0;
							var13 = field1778.field1075;
							field1698.method6833();
							class228.method4526();
							class102.method4730(var3);
							if (var13 != var3.field4878) {
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
					if (((class401)var2).method7255() >= field1778.field1075) {
						var3.field4878 = 0;
						((class401)var2).method7267(var3.field4881, 0, field1778.field1075);
						field1698.method6846();
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
						class110.field1089.method7782();
						class110.field1088.method6597();
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

						for (var13 = 0; var13 < 2048; ++var13) {
							class102.field1011[var13] = null;
							class102.field1010[var13] = class197.field2114;
						}

						for (var13 = 0; var13 < 2048; ++var13) {
							field1763[var13] = null;
						}

						for (var13 = 0; var13 < 65536; ++var13) {
							field1902[var13] = null;
						}

						field1775 = -1;
						field1853.method6354();
						field1779.method6354();

						for (var13 = 0; var13 < 4; ++var13) {
							for (var18 = 0; var18 < 104; ++var18) {
								for (int var19 = 0; var19 < 104; ++var19) {
									field1865[var13][var18][var19] = null;
								}
							}
						}

						field1777 = new class343();
						class217.field2588.method1048();

						for (var13 = 0; var13 < class178.field1592; ++var13) {
							class178 var38 = class274.method5221(var13);
							if (var38 != null) {
								class293.field3368[var13] = 0;
								class293.field3370[var13] = 0;
							}
						}

						class66.field538.method2310();
						field1819 = -1;
						if (field1893 != -1) {
							class257.method5138(field1893);
						}

						for (class89 var42 = (class89)field1810.method7867(); null != var42; var42 = (class89)field1810.method7858()) {
							class4.method32(var42, true);
						}

						field1893 = -1;
						field1810 = new class434(8);
						field1641 = null;
						field1695 = 0;
						field1784 = false;
						field1920.method5998((int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

						for (var13 = 0; var13 < 8; ++var13) {
							field1772[var13] = null;
							field1755[var13] = false;
						}

						class87.method2410();
						field1828 = true;

						for (var13 = 0; var13 < 100; ++var13) {
							field1860[var13] = true;
						}

						method206();
						class73.field603 = null;
						class127.field1224 = null;
						Arrays.fill(field1738, (Object)null);
						class188.field1982 = null;
						Arrays.fill(field1883, (Object)null);

						for (var13 = 0; var13 < 8; ++var13) {
							field1924[var13] = new class347();
						}

						class242.field2835 = null;
						class102.method4730(var3);
						class361.field4314 = -1;
						class25.method344(false, var3);
						field1778.field1073 = null;
					}

				}
			}
		} catch (IOException var27) {
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
		class28.field148.method7958();
		class191.field2026.method7958();
		class206.field2330.method5437();
		class206.field2331.method5437();
		class206.field2332.method5437();
		class158.field1456.method5437();
		class158.field1443.method5437();
		class187.field1977.method5437();
		class193.method6197();
		class160.method1424();
		class458.field4871.method5437();
		class452.field4852.method5437();
		field1926.method5437();
		field1927.method5437();
		class305.method3577();
		class300.method5845();
		((class215)class221.field2629).method4312();
		class78.field675.method5437();
		class139.field1286.method6117();
		class42.field295.method6117();
		class333.field3859.method6117();
		class11.field48.method6117();
		class58.field417.method6117();
		class43.field311.method6117();
		class252.field2922.method6117();
		class155.field1425.method6117();
		field1665.method6117();
		class243.field2846.method6117();
		class4.field12.method6117();
		class202.field2255.method6117();
		class255.field2944.method6117();
	}

	static final void method4611() {
		if (field1696 > 0) {
			class368.method6731();
		} else {
			field1698.method6830();
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
				method5557();
			}

			int var2;
			for (var2 = 0; var2 < 100 && this.method2888(field1778); ++var2) {
			}

			if (30 == field1766) {
				while (true) {
					class43 var3 = (class43)class45.field329.method6465();
					boolean var30;
					if (var3 == null) {
						var30 = false;
					} else {
						var30 = true;
					}

					int var4;
					class263 var31;
					if (!var30) {
						class263 var15;
						int var16;
						if (field1698.field4413) {
							var15 = class185.method3435(class274.field3066, field1778.field1071);
							var15.field2984.method8104(0);
							var16 = var15.field2984.field4878;
							field1698.method6834(var15.field2984);
							var15.field2984.method8151(var15.field2984.field4878 - var16);
							field1778.method2078(var15);
							field1698.method6832();
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
								var31 = null;
								var4 = 0;
								var5 = 0;
								var6 = 0;
								var7 = 0;

								for (var8 = 0; var8 < class74.field610.field747 && (null == var31 || var31.field2984.field4878 - var4 < 246); ++var8) {
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
										if (var31 == null) {
											var31 = class185.method3435(class274.field3118, field1778.field1071);
											var31.field2984.method8104(0);
											var4 = var31.field2984.field4878;
											class453 var10000 = var31.field2984;
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
											var31.field2984.method8181((var11 << 6) + (var13 << 12) + var12);
										} else if (var13 < 32 && var11 >= -128 && var11 <= 127 && var12 >= -128 && var12 <= 127) {
											var11 += 128;
											var12 += 128;
											var31.field2984.method8104(var13 + 128);
											var31.field2984.method8181((var11 << 8) + var12);
										} else if (var13 < 32) {
											var31.field2984.method8104(var13 + 192);
											if (var10 != -1 && var9 != -1) {
												var31.field2984.method8241(var10 | var9 << 16);
											} else {
												var31.field2984.method8241(Integer.MIN_VALUE);
											}
										} else {
											var31.field2984.method8181((var13 & 8191) + 57344);
											if (var10 != -1 && var9 != -1) {
												var31.field2984.method8241(var10 | var9 << 16);
											} else {
												var31.field2984.method8241(Integer.MIN_VALUE);
											}
										}

										++var7;
										field1644 = class74.field610.field754[var8];
									}
								}

								if (var31 != null) {
									var31.field2984.method8151(var31.field2984.field4878 - var4);
									var8 = var31.field2984.field4878;
									var31.field2984.field4878 = var4;
									var31.field2984.method8104(var6 / var7);
									var31.field2984.method8104(var6 % var7);
									var31.field2984.field4878 = var8;
									field1778.method2078(var31);
								}

								if (var5 >= class74.field610.field747) {
									class74.field610.field747 = 0;
								} else {
									class84 var56 = class74.field610;
									var56.field747 -= var5;
									System.arraycopy(class74.field610.field748, var5, class74.field610.field748, 0, class74.field610.field747);
									System.arraycopy(class74.field610.field750, var5, class74.field610.field750, 0, class74.field610.field747);
									System.arraycopy(class74.field610.field754, var5, class74.field610.field754, 0, class74.field610.field747);
								}
							}
						}

						if (class42.field277 == 1 || !class95.field944 && class42.field277 == 4 || class42.field277 == 2) {
							long var17 = class42.field279 - field1646;
							if (var17 > 32767L) {
								var17 = 32767L;
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

							var6 = (int)var17;
							class263 var19 = class185.method3435(class274.field3094, field1778.field1071);
							var19.field2984.method8181((var6 << 1) + (class42.field277 == 2 ? 1 : 0));
							var19.field2984.method8181(var5);
							var19.field2984.method8181(var4);
							field1778.method2078(var19);
						}

						if (field1876.field2312 > 0) {
							var15 = class185.method3435(class274.field3047, field1778.field1071);
							var15.field2984.method8181(0);
							var16 = var15.field2984.field4878;
							long var20 = class272.method2046();

							for (var6 = 0; var6 < field1876.field2312; ++var6) {
								long var22 = var20 - field1881;
								if (var22 > 16777215L) {
									var22 = 16777215L;
								}

								field1881 = var20;
								var15.field2984.method8167((int)var22);
								var15.field2984.method8152(field1876.field2311[var6]);
							}

							var15.field2984.method8117(var15.field2984.field4878 - var16);
							field1778.method2078(var15);
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
							var15 = class185.method3435(class274.field3077, field1778.field1071);
							var15.field2984.method8181(field1761);
							var15.field2984.method8159(field1672);
							field1778.method2078(var15);
						}

						if (class71.field574 && !field1650) {
							field1650 = true;
							var15 = class185.method3435(class274.field3059, field1778.field1071);
							var15.field2984.method8104(1);
							field1778.method2078(var15);
						}

						if (!class71.field574 && field1650) {
							field1650 = false;
							var15 = class185.method3435(class274.field3059, field1778.field1071);
							var15.field2984.method8104(0);
							field1778.method2078(var15);
						}

						if (null != class4.field10) {
							class4.field10.method7575();
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

						for (class101 var39 = (class101)field1777.method6364(); var39 != null; var39 = (class101)field1777.method6358()) {
							if (var39.field1003 > 0) {
								--var39.field1003;
							}

							if (var39.field1003 == 0) {
								if (var39.field995 < 0 || class47.method962(var39.field995, var39.field997)) {
									class331.method6260(var39.field993, var39.field992, var39.field999, var39.field994, var39.field995, var39.field996, var39.field997);
									var39.method7825();
								}
							} else {
								if (var39.field1006 > 0) {
									--var39.field1006;
								}

								if (var39.field1006 == 0 && var39.field999 >= 1 && var39.field994 >= 1 && var39.field999 <= 102 && var39.field994 <= 102 && (var39.field998 < 0 || class47.method962(var39.field998, var39.field1000))) {
									class331.method6260(var39.field993, var39.field992, var39.field999, var39.field994, var39.field998, var39.field991, var39.field1000);
									var39.field1006 = -1;
									if (var39.field995 == var39.field998 && -1 == var39.field995) {
										var39.method7825();
									} else if (var39.field995 == var39.field998 && var39.field996 == var39.field991 && var39.field997 == var39.field1000) {
										var39.method7825();
									}
								}
							}
						}

						int var10002;
						for (var2 = 0; var2 < field1894; ++var2) {
							var10002 = field1897[var2]--;
							if (field1897[var2] >= -10) {
								class33 var32 = field1899[var2];
								if (var32 == null) {
									class33 var57 = (class33)null;
									var32 = class33.method610(class11.field48, field1895[var2], 0);
									if (var32 == null) {
										continue;
									}

									int[] var58 = field1897;
									var58[var2] += var32.method606();
									field1899[var2] = var32;
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
										var9 = 64 + var8 * 128 - class291.field3364.field802;
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
										class39 var24 = var32.method605().method752(class233.field2759);
										class44 var25 = class44.method829(var24, 100, var4);
										var25.method813(field1896[var2] - 1);
										class451.field4849.method718(var25);
									}

									field1897[var2] = -100;
								}
							} else {
								--field1894;

								for (var16 = var2; var16 < field1894; ++var16) {
									field1895[var16] = field1895[var16 + 1];
									field1899[var16] = field1899[var16 + 1];
									field1896[var16] = field1896[var16 + 1];
									field1897[var16] = field1897[var16 + 1];
									field1734[var16] = field1734[var16 + 1];
								}

								--var2;
							}
						}

						if (field1781) {
							if (0 != class279.field3202) {
								var30 = true;
							} else {
								var30 = class279.field3201.method5278();
							}

							if (!var30) {
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
						int[] var33 = class102.field1013;

						for (var4 = 0; var4 < var2; ++var4) {
							class93 var43 = field1763[var33[var4]];
							if (var43 != null) {
								class25.method341(var43, 1);
							}
						}

						for (var2 = 0; var2 < field1691; ++var2) {
							var16 = field1692[var2];
							class81 var26 = field1902[var16];
							if (var26 != null) {
								class25.method341(var26, var26.field709.field2262);
							}
						}

						int[] var40 = class102.field1013;

						for (var16 = 0; var16 < class102.field1012; ++var16) {
							class93 var49 = field1763[var40[var16]];
							if (null != var49 && var49.field843 > 0) {
								--var49.field843;
								if (0 == var49.field843) {
									var49.field822 = null;
								}
							}
						}

						for (var16 = 0; var16 < field1691; ++var16) {
							var4 = field1692[var16];
							class81 var44 = field1902[var4];
							if (var44 != null && var44.field843 > 0) {
								--var44.field843;
								if (0 == var44.field843) {
									var44.field822 = null;
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

						class300 var41 = class219.field2616;
						class300 var34 = class219.field2617;
						class219.field2616 = null;
						class219.field2617 = null;
						field1826 = null;
						field1783 = false;
						field1827 = false;
						field1822 = 0;

						while (field1876.method3911() && field1822 < 128) {
							if (field1750 >= 2 && field1876.method3895(82) && field1876.field2317 == 66) {
								StringBuilder var45 = new StringBuilder();

								class63 var42;
								for (Iterator var46 = class110.field1089.iterator(); var46.hasNext(); var45.append(var42.field503).append('\n')) {
									var42 = (class63)var46.next();
									if (var42.field500 != null && !var42.field500.isEmpty()) {
										var45.append(var42.field500).append(':');
									}
								}

								String var50 = var45.toString();
								class133.field1257.method463(var50);
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

						while (true) {
							class300 var47;
							class300 var48;
							class79 var52;
							do {
								var52 = (class79)field1854.method6375();
								if (null == var52) {
									while (true) {
										do {
											var52 = (class79)field1813.method6375();
											if (null == var52) {
												while (true) {
													do {
														var52 = (class79)field1765.method6375();
														if (null == var52) {
															while (true) {
																class188 var54 = (class188)field1856.method6375();
																if (var54 == null) {
																	this.method2889();
																	class260.method5145();
																	if (field1874 != null) {
																		this.method2894();
																	}

																	class263 var27;
																	if (class183.field1943 != null) {
																		class136.method2438(class183.field1943);
																		++field1786;
																		if (class42.field289 == 0) {
																			if (field1759) {
																				if (class183.field1943 == class165.field1523 && field1737 != field1892) {
																					class300 var55 = class183.field1943;
																					byte var35 = 0;
																					if (field1814 == 1 && 206 == var55.field3464) {
																						var35 = 1;
																					}

																					if (var55.field3461[field1892] <= 0) {
																						var35 = 0;
																					}

																					var7 = class190.method3528(var55);
																					boolean var36 = 0 != (var7 >> 29 & 1);
																					if (var36) {
																						var8 = field1737;
																						var9 = field1892;
																						var55.field3461[var9] = var55.field3461[var8];
																						var55.field3456[var9] = var55.field3456[var8];
																						var55.field3461[var8] = -1;
																						var55.field3456[var8] = 0;
																					} else if (var35 == 1) {
																						var8 = field1737;
																						var9 = field1892;

																						while (var8 != var9) {
																							if (var8 > var9) {
																								var55.method5851(var8 - 1, var8);
																								--var8;
																							} else if (var8 < var9) {
																								var55.method5851(var8 + 1, var8);
																								++var8;
																							}
																						}
																					} else {
																						var55.method5851(field1892, field1737);
																					}

																					var27 = class185.method3435(class274.field3100, field1778.field1071);
																					var27.field2984.method8353(class183.field1943.field3517);
																					var27.field2984.method8152(var35);
																					var27.field2984.method8161(field1737);
																					var27.field2984.method8181(field1892);
																					field1778.method2078(var27);
																				}
																			} else if (this.method2890()) {
																				this.method3357(field1638, field1757);
																			} else if (field1695 > 0) {
																				var4 = field1638;
																				var5 = field1757;
																				class73 var51 = class101.field1005;
																				if (null != var51) {
																					class263.method5159(var51.field600, var51.field595, var51.field594, var51.field597, var51.field598, var51.field599, var51.field604, var4, var5);
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
																		class263 var53 = class185.method3435(class274.field3134, field1778.field1071);
																		var53.field2984.method8104(5);
																		var53.field2984.method8161(class169.field1536 + var5);
																		var53.field2984.method8264(field1876.method3895(82) ? (field1876.method3895(81) ? 2 : 1) : 0);
																		var53.field2984.method8337(var4 + class36.field241);
																		field1778.method2078(var53);
																		class214.method4162();
																		field1657 = class42.field283;
																		field1749 = class42.field293;
																		field1751 = 1;
																		field1904 = 0;
																		field1889 = var4;
																		field1890 = var5;
																	}

																	if (var41 != class219.field2616) {
																		if (null != var41) {
																			class136.method2438(var41);
																		}

																		if (class219.field2616 != null) {
																			class136.method2438(class219.field2616);
																		}
																	}

																	if (var34 != class219.field2617 && field1670 == field1929) {
																		if (var34 != null) {
																			class136.method2438(var34);
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
																			for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																				for (var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
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

																		var10 = var9 * 192;
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
																		short var38 = -1;
																		if (field1876.method3895(33)) {
																			var38 = 0;
																		} else if (field1876.method3895(49)) {
																			var38 = 1024;
																		}

																		if (field1876.method3895(48)) {
																			if (var38 == 0) {
																				var38 = 1792;
																			} else if (var38 == 1024) {
																				var38 = 1280;
																			} else {
																				var38 = 1536;
																			}
																		} else if (field1876.method3895(50)) {
																			if (var38 == 0) {
																				var38 = 256;
																			} else if (var38 == 1024) {
																				var38 = 768;
																			} else {
																				var38 = 512;
																			}
																		}

																		byte var37 = 0;
																		if (field1876.method3895(35)) {
																			var37 = -1;
																		} else if (field1876.method3895(51)) {
																			var37 = 1;
																		}

																		var6 = 0;
																		if (var38 >= 0 || var37 != 0) {
																			var6 = field1876.method3895(81) ? field1767 : field1727;
																			var6 *= 16;
																			field1676 = var38;
																			field1726 = var37;
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
																		field1719 = var4 * 2;
																		field1886 = var4 != -1 && var4 != 1 ? (field1886 + class42.field285) / 2 : class42.field285;
																		var5 = field1720 - class42.field284;
																		field1718 = var5 * 2;
																		field1720 = var5 != -1 && var5 != 1 ? (field1720 + class42.field284) / 2 : class42.field284;
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

																	for (var4 = 0; var4 < 5; ++var4) {
																		var10002 = field1906[var4]++;
																	}

																	class66.field538.method2314();
																	var4 = ++class42.field278 - 1;
																	var6 = class31.field198.method671();
																	if (var4 > 15000 && var6 > 15000) {
																		field1696 = 250;
																		class42.field278 = 14500;
																		var27 = class185.method3435(class274.field3127, field1778.field1071);
																		field1778.method2078(var27);
																	}

																	class217.field2588.method1047();
																	++field1778.field1077;
																	if (field1778.field1077 > 50) {
																		var27 = class185.method3435(class274.field3083, field1778.field1071);
																		field1778.method2078(var27);
																	}

																	try {
																		field1778.method2081();
																	} catch (IOException var28) {
																		method4611();
																	}

																	return;
																}

																class346.method6400(var54);
															}
														}

														var47 = var52.field694;
														if (var47.field3484 < 0) {
															break;
														}

														var48 = class282.method5426(var47.field3596);
													} while(var48 == null || null == var48.field3602 || var47.field3484 >= var48.field3602.length || var48.field3602[var47.field3484] != var47);

													class57.method5433(var52);
												}
											}

											var47 = var52.field694;
											if (var47.field3484 < 0) {
												break;
											}

											var48 = class282.method5426(var47.field3596);
										} while(null == var48 || var48.field3602 == null || var47.field3484 >= var48.field3602.length || var47 != var48.field3602[var47.field3484]);

										class57.method5433(var52);
									}
								}

								var47 = var52.field694;
								if (var47.field3484 < 0) {
									break;
								}

								var48 = class282.method5426(var47.field3596);
							} while(var48 == null || var48.field3602 == null || var47.field3484 >= var48.field3602.length || var48.field3602[var47.field3484] != var47);

							class57.method5433(var52);
						}
					}

					var31 = class185.method3435(class274.field3043, field1778.field1071);
					var31.field2984.method8104(0);
					var4 = var31.field2984.field4878;
					class88.method1865(var31.field2984);
					var31.field2984.method8151(var31.field2984.field4878 - var4);
					field1778.method2078(var31);
				}
			}
		}
	}

	static final void method6564(class90 var0) {
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
		var1.field2984.method8104(class2.method11());
		var1.field2984.method8181(class31.field193);
		var1.field2984.method8181(class12.field57);
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
			class378.method6804(field1893);
		}

		int var2;
		for (var2 = 0; var2 < field1858; ++var2) {
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

		class481.method8715();
		if (field1752) {
			if (1 == field1751) {
				class205.field2326[field1904 / 100].method8526(field1657 - 8, field1749 - 8);
			}

			if (field1751 == 2) {
				class205.field2326[4 + field1904 / 100].method8526(field1657 - 8, field1749 - 8);
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
			class481.method8660(var2, var3, var4, var5, var6);
			class481.method8660(var2 + 1, var3 + 1, var4 - 2, 16, 0);
			class481.method8664(var2 + 1, var3 + 18, var4 - 2, var5 - 19, 0);
			class114.field1127.method6875(class338.field4057, var2 + 3, var3 + 14, var6, -1);
			int var7 = class42.field284;
			int var8 = class42.field285;

			for (int var9 = 0; var9 < field1695; ++var9) {
				int var10 = var3 + 31 + 15 * (field1695 - 1 - var9);
				int var11 = 16777215;
				if (var7 > var2 && var7 < var2 + var4 && var8 > var10 - 13 && var8 < var10 + 3) {
					var11 = 16776960;
				}

				class114.field1127.method6875(class233.method4558(var9), var2 + 3, var10, var11, 0);
			}

			class105.method2047(class94.field923, class125.field1206, class179.field1601, class240.field2826);
		}

		if (3 == field1867) {
			for (var2 = 0; var2 < field1858; ++var2) {
				if (field1800[var2]) {
					class481.method8659(field1863[var2], field1864[var2], field1710[var2], field1658[var2], 16711935, 128);
				} else if (field1861[var2]) {
					class481.method8659(field1863[var2], field1864[var2], field1710[var2], field1658[var2], 16711680, 128);
				}
			}
		}

		class55.method1117(class55.field396, class291.field3364.field827, class291.field3364.field802, field1701);
		field1701 = 0;
	}

	public static class343 method7851() {
		return field1765;
	}

	static boolean method6201() {
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

			class73.field603.method6705(var1.field1076, var2);
		}

		method6423();
		var1.field1073 = null;
		return true;
	}

	boolean method2900(class107 var1) {
		if (class73.field603 != null) {
			class73.field603.method6706(var1.field1076);
		}

		method6423();
		var1.field1073 = null;
		return true;
	}

	final boolean method2888(class107 var1) {
		class401 var3 = var1.method2082();
		class453 var4 = var1.field1076;
		if (null == var3) {
			return false;
		} else {
			String var22;
			int var23;
			try {
				int var6;
				if (null == var1.field1073) {
					if (var1.field1067) {
						if (!var3.method7254(1)) {
							return false;
						}

						var3.method7267(var1.field1076.field4881, 0, 1);
						var1.field1070 = 0;
						var1.field1067 = false;
					}

					var4.field4878 = 0;
					if (var4.method8007()) {
						if (!var3.method7254(1)) {
							return false;
						}

						var3.method7267(var1.field1076.field4881, 1, 1);
						var1.field1070 = 0;
					}

					var1.field1067 = true;
					class283[] var5 = class283.method2743();
					var6 = var4.method8011();
					if (var6 < 0 || var6 >= var5.length) {
						throw new IOException(var6 + " " + var4.field4878);
					}

					var1.field1073 = var5[var6];
					var1.field1075 = var1.field1073.field3240;
				}

				if (var1.field1075 == -1) {
					if (!var3.method7254(1)) {
						return false;
					}

					var1.method2082().method7267(var4.field4881, 0, 1);
					var1.field1075 = var4.field4881[0] & 255;
				}

				if (-2 == var1.field1075) {
					if (!var3.method7254(2)) {
						return false;
					}

					var1.method2082().method7267(var4.field4881, 0, 2);
					var4.field4878 = 0;
					var1.field1075 = var4.method8122();
				}

				if (!var3.method7254(var1.field1075)) {
					return false;
				}

				var4.field4878 = 0;
				var3.method7267(var4.field4881, 0, var1.field1075);
				var1.field1070 = 0;
				field1698.method6829();
				var1.field1080 = var1.field1072;
				var1.field1072 = var1.field1079;
				var1.field1079 = var1.field1073;
				if (class283.field3219 == var1.field1073) {
					class342.method6352(class271.field3021);
					var1.field1073 = null;
					return true;
				}

				class300 var7;
				int var21;
				if (class283.field3225 == var1.field1073) {
					var21 = var4.method8176();
					var6 = var4.method8202();
					var7 = class282.method5426(var21);
					if (1 != var7.field3504 || var6 != var7.field3505) {
						var7.field3504 = 1;
						var7.field3505 = var6;
						class136.method2438(var7);
					}

					var1.field1073 = null;
					return true;
				}

				String var53;
				if (var1.field1073 == class283.field3253) {
					var21 = var4.method8154();
					var6 = var4.method8154();
					var53 = var4.method8131();
					if (var6 >= 1 && var6 <= 8) {
						if (var53.equalsIgnoreCase(class338.field3899)) {
							var53 = null;
						}

						field1772[var6 - 1] = var53;
						field1755[var6 - 1] = var21 == 0;
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3265) {
					class7.field28 = var4.method8154();
					class19.field98 = var4.method8153();

					for (var21 = class7.field28; var21 < 8 + class7.field28; ++var21) {
						for (var6 = class19.field98; var6 < 8 + class19.field98; ++var6) {
							if (field1865[class55.field396][var21][var6] != null) {
								field1865[class55.field396][var21][var6] = null;
								class176.method2802(var21, var6);
							}
						}
					}

					for (class101 var52 = (class101)field1777.method6364(); null != var52; var52 = (class101)field1777.method6358()) {
						if (var52.field999 >= class7.field28 && var52.field999 < 8 + class7.field28 && var52.field994 >= class19.field98 && var52.field994 < class19.field98 + 8 && var52.field993 == class55.field396) {
							var52.field1003 = 0;
						}
					}

					var1.field1073 = null;
					return true;
				}

				String var48;
				if (var1.field1073 == class283.field3293) {
					var48 = var4.method8131();
					Object[] var77 = new Object[var48.length() + 1];

					for (var23 = var48.length() - 1; var23 >= 0; --var23) {
						if (var48.charAt(var23) == 's') {
							var77[var23 + 1] = var4.method8131();
						} else {
							var77[var23 + 1] = new Integer(var4.method8126());
						}
					}

					var77[0] = new Integer(var4.method8126());
					class79 var62 = new class79();
					var62.field686 = var77;
					class57.method5433(var62);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3320 == var1.field1073) {
					class342.method6352(class271.field3024);
					var1.field1073 = null;
					return true;
				}

				class227 var15;
				int var16;
				int var17;
				String var26;
				byte var69;
				if (var1.field1073 == class283.field3275) {
					var69 = var4.method8287();
					var22 = var4.method8131();
					long var24 = (long)var4.method8122();
					long var9 = (long)var4.method8312();
					class333 var60 = (class333)class217.method4362(class333.method5480(), var4.method8141());
					long var12 = var9 + (var24 << 32);
					boolean var67 = false;
					var15 = null;
					class147 var68 = var69 >= 0 ? field1883[var69] : class188.field1982;
					if (null == var68) {
						var67 = true;
					} else {
						var16 = 0;

						while (true) {
							if (var16 >= 100) {
								if (var60.field3858 && class217.field2588.method1049(new class472(var22, class234.field2779))) {
									var67 = true;
								}
								break;
							}

							if (var12 == field1918[var16]) {
								var67 = true;
								break;
							}

							++var16;
						}
					}

					if (!var67) {
						field1918[field1875] = var12;
						field1875 = (field1875 + 1) % 100;
						var26 = class384.method6864(class307.method5489(var4));
						var17 = var69 >= 0 ? 41 : 44;
						if (var60.field3856 != -1) {
							class110.method1858(var17, class96.method5151(var60.field3856) + var22, var26, var68.field1350);
						} else {
							class110.method1858(var17, var22, var26, var68.field1350);
						}
					}

					var1.field1073 = null;
					return true;
				}

				class81 var8;
				int var27;
				if (var1.field1073 == class283.field3224) {
					var23 = var4.method8141();
					var21 = var4.method8202();
					var6 = var4.method8164();
					if (var6 == 65535) {
						var6 = -1;
					}

					var8 = field1902[var21];
					if (var8 != null) {
						if (var6 == var8.field852 && var6 != -1) {
							var27 = class160.method2660(var6).field2013;
							if (var27 == 1) {
								var8.field844 = 0;
								var8.field845 = 0;
								var8.field804 = var23;
								var8.field875 = 0;
							} else if (var27 == 2) {
								var8.field875 = 0;
							}
						} else if (var6 == -1 || -1 == var8.field852 || class160.method2660(var6).field2006 >= class160.method2660(var8.field852).field2006) {
							var8.field852 = var6;
							var8.field844 = 0;
							var8.field845 = 0;
							var8.field804 = var23;
							var8.field875 = 0;
							var8.field876 = var8.field871;
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
					var21 = var4.method8126();
					class89 var76 = (class89)field1810.method7855((long)var21);
					if (null != var76) {
						class4.method32(var76, true);
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
					class318.field3732 = var4.method8141();
					class109.field1086 = var4.method8141();
					class42.field298 = var4.method8141();
					class158.field1440 = var4.method8141();

					for (var21 = 0; var21 < 5; ++var21) {
						field1699[var21] = false;
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3303) {
					field1651 = var4.method8202() * 30;
					field1642 = field1878;
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3308) {
					class342.method6352(class271.field3019);
					var1.field1073 = null;
					return true;
				}

				boolean var78;
				if (class283.field3273 == var1.field1073) {
					var78 = var4.method8141() == 1;
					if (var78) {
						class100.field987 = class272.method2046() - var4.method8127();
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
					class342.method6352(class271.field3030);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3278 == var1.field1073) {
					var21 = var4.method8126();
					var6 = var4.method8126();
					var23 = class260.method5146();
					class263 var58 = class185.method3435(class274.field3113, field1778.field1071);
					var58.field2984.method8241(var21);
					var58.field2984.method8155(var6);
					var58.field2984.method8264(var23);
					var58.field2984.method8152(class31.field174);
					field1778.method2078(var58);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3315) {
					var21 = var4.method8175();
					var6 = var4.method8202();
					var7 = class282.method5426(var21);
					if (var7 != null && var7.field3462 == 0) {
						if (var6 > var7.field3492 - var7.field3476) {
							var6 = var7.field3492 - var7.field3476;
						}

						if (var6 < 0) {
							var6 = 0;
						}

						if (var6 != var7.field3482) {
							var7.field3482 = var6;
							class136.method2438(var7);
						}
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3251 == var1.field1073) {
					class342.method6352(class271.field3023);
					var1.field1073 = null;
					return true;
				}

				int var28;
				class300 var29;
				if (var1.field1073 == class283.field3220) {
					var21 = var4.method8202();
					var6 = var4.method8162();
					var23 = var4.method8164();
					var28 = var4.method8126();
					var29 = class282.method5426(var28);
					if (var29.field3601 != var21 || var6 != var29.field3513 || var29.field3562 != var23) {
						var29.field3601 = var21;
						var29.field3513 = var6;
						var29.field3562 = var23;
						class136.method2438(var29);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3272 == var1.field1073) {
					for (var21 = 0; var21 < field1763.length; ++var21) {
						if (field1763[var21] != null) {
							field1763[var21].field852 = -1;
						}
					}

					for (var21 = 0; var21 < field1902.length; ++var21) {
						if (null != field1902[var21]) {
							field1902[var21].field852 = -1;
						}
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3283) {
					field1709 = var4.method8141();
					var1.field1073 = null;
					return true;
				}

				class300 var55;
				if (class283.field3218 == var1.field1073) {
					var21 = var4.method8162();
					var6 = var4.method8162();
					var23 = var4.method8176();
					var55 = class282.method5426(var23);
					var55.field3512 = (var21 << 16) + var6;
					var1.field1073 = null;
					return true;
				}

				if (class283.field3301 == var1.field1073) {
					class342.method6352(class271.field3025);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3311 == var1.field1073) {
					var48 = var4.method8131();
					var22 = class384.method6864(class158.method2630(class307.method5489(var4)));
					class42.method773(6, var48, var22);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3234) {
					for (var21 = 0; var21 < class293.field3370.length; ++var21) {
						if (class293.field3368[var21] != class293.field3370[var21]) {
							class293.field3370[var21] = class293.field3368[var21];
							class147.method2521(var21);
							field1931[++field1690 - 1 & 31] = var21;
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
					var69 = var4.method8287();
					class142 var75 = new class142(var4);
					class148 var61;
					if (var69 >= 0) {
						var61 = field1738[var69];
					} else {
						var61 = class127.field1224;
					}

					var75.method2481(var61);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3228 == var1.field1073) {
					class368.method6731();
					var1.field1073 = null;
					return false;
				}

				if (class283.field3289 == var1.field1073) {
					var21 = var4.method8126();
					var6 = var4.method8164();
					class293.field3368[var6] = var21;
					if (class293.field3370[var6] != var21) {
						class293.field3370[var6] = var21;
					}

					class147.method2521(var6);
					field1931[++field1690 - 1 & 31] = var6;
					var1.field1073 = null;
					return true;
				}

				long var10;
				if (var1.field1073 == class283.field3325) {
					var21 = var4.method8162();
					if (var21 == 65535) {
						var21 = -1;
					}

					var6 = var4.method8162();
					if (var6 == 65535) {
						var6 = -1;
					}

					var23 = var4.method8126();
					var28 = var4.method8126();

					for (var27 = var21; var27 <= var6; ++var27) {
						var10 = ((long)var28 << 32) + (long)var27;
						class427 var80 = field1785.method7855(var10);
						if (null != var80) {
							var80.method7825();
						}

						field1785.method7857(new class426(var23), var10);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3321 == var1.field1073) {
					class342.method6352(class271.field3029);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3268 == var1.field1073) {
					var21 = var4.method8141();
					class368.method6732(var21);
					var1.field1073 = null;
					return false;
				}

				if (class283.field3266 == var1.field1073) {
					class342.method6352(class271.field3022);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3245 == var1.field1073) {
					var4.field4878 += 28;
					if (var4.method8246()) {
						method5002(var4, var4.field4878 - 28);
					}

					var1.field1073 = null;
					return true;
				}

				int var31;
				if (class283.field3236 == var1.field1073) {
					var21 = var4.method8126();
					var6 = var4.method8122();
					if (var21 < -70000) {
						var6 += 32768;
					}

					if (var21 >= 0) {
						var7 = class282.method5426(var21);
					} else {
						var7 = null;
					}

					for (; var4.field4878 < var1.field1075; class233.method4557(var6, var28, var27 - 1, var31)) {
						var28 = var4.method8207();
						var27 = var4.method8122();
						var31 = 0;
						if (var27 != 0) {
							var31 = var4.method8141();
							if (var31 == 255) {
								var31 = var4.method8126();
							}
						}

						if (var7 != null && var28 >= 0 && var28 < var7.field3461.length) {
							var7.field3461[var28] = var27;
							var7.field3456[var28] = var31;
						}
					}

					if (var7 != null) {
						class136.method2438(var7);
					}

					class198.method3654();
					field1837[++field1838 - 1 & 31] = var6 & 32767;
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3248) {
					field1871 = var4.method8153();
					field1872 = var4.method8141();
					var1.field1073 = null;
					return true;
				}

				if (class283.field3296 == var1.field1073) {
					class342.method6352(class271.field3026);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3323) {
					class342.method6352(class271.field3033);
					var1.field1073 = null;
					return true;
				}

				boolean var64;
				if (var1.field1073 == class283.field3299) {
					var21 = var4.method8207();
					var64 = var4.method8141() == 1;
					var53 = "";
					boolean var83 = false;
					if (var64) {
						var53 = var4.method8131();
						if (class217.field2588.method1049(new class472(var53, class234.field2779))) {
							var83 = true;
						}
					}

					String var81 = var4.method8131();
					if (!var83) {
						class42.method773(var21, var53, var81);
					}

					var1.field1073 = null;
					return true;
				}

				class300 var71;
				if (class283.field3267 == var1.field1073) {
					var21 = var4.method8175();
					var71 = class282.method5426(var21);
					var71.field3504 = 3;
					var71.field3505 = class291.field3364.field911.method6029();
					class136.method2438(var71);
					var1.field1073 = null;
					return true;
				}

				long var13;
				long var32;
				long var34;
				if (var1.field1073 == class283.field3277) {
					var48 = var4.method8131();
					var32 = var4.method8127();
					var34 = (long)var4.method8122();
					var10 = (long)var4.method8312();
					class333 var30 = (class333)class217.method4362(class333.method5480(), var4.method8141());
					var13 = var10 + (var34 << 32);
					boolean var85 = false;

					for (var16 = 0; var16 < 100; ++var16) {
						if (var13 == field1918[var16]) {
							var85 = true;
							break;
						}
					}

					if (var30.field3858 && class217.field2588.method1049(new class472(var48, class234.field2779))) {
						var85 = true;
					}

					if (!var85 && 0 == field1830) {
						field1918[field1875] = var13;
						field1875 = (1 + field1875) % 100;
						var26 = class384.method6864(class158.method2630(class307.method5489(var4)));
						if (-1 != var30.field3856) {
							class110.method1858(9, class96.method5151(var30.field3856) + var48, var26, class363.method4889(var32));
						} else {
							class110.method1858(9, var48, var26, class363.method4889(var32));
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
					var21 = var4.method8141();
					method411(var21);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3243 == var1.field1073) {
					class131.method2400(var4, var1.field1075);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3227 == var1.field1073) {
					class19.field98 = var4.method8341();
					class7.field28 = var4.method8141();

					while (var4.field4878 < var1.field1075) {
						var21 = var4.method8141();
						class271 var74 = class271.method1667()[var21];
						class342.method6352(var74);
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3276) {
					field1900 = true;
					field1901 = false;
					class264.field2998 = var4.method8141();
					class19.field96 = var4.method8141();
					class244.field2859 = var4.method8122();
					class318.field3732 = var4.method8141();
					class109.field1086 = var4.method8141();
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
					class372.method6749();
					var1.field1073 = null;
					return true;
				}

				if (class283.field3316 == var1.field1073) {
					class78.field683 = true;
					class242.method4731(var4, var1.field1075);
					class372.method6749();
					var1.field1073 = null;
					return true;
				}

				if (class283.field3312 == var1.field1073) {
					class330.method6258(var4.method8131());
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3226) {
					var21 = var4.method8122();
					var6 = var4.method8141();
					var23 = var4.method8122();
					class271.method5212(var21, var6, var23);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3294 == var1.field1073) {
					var21 = var4.method8175();
					var64 = var4.method8341() == 1;
					var7 = class282.method5426(var21);
					if (var7.field3480 != var64) {
						var7.field3480 = var64;
						class136.method2438(var7);
					}

					var1.field1073 = null;
					return true;
				}

				int var37;
				int var38;
				if (class283.field3326 == var1.field1073) {
					var31 = var4.method8122();
					var37 = var4.method8141();
					var38 = var4.method8162();
					var23 = var4.method8169();
					var21 = var23 >> 16;
					var6 = var23 >> 8 & 255;
					var28 = var21 + (var23 >> 4 & 7);
					var27 = var6 + (var23 & 7);
					if (var28 >= 0 && var27 >= 0 && var28 < 104 && var27 < 104) {
						var28 = 64 + var28 * 128;
						var27 = var27 * 128 + 64;
						class77 var87 = new class77(var31, class55.field396, var28, var27, class144.method2498(var28, var27, class55.field396) - var37, var38, field1645);
						field1779.method6355(var87);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3290 == var1.field1073) {
					field1847 = field1878;
					var69 = var4.method8287();
					class143 var73 = new class143(var4);
					class147 var56;
					if (var69 >= 0) {
						var56 = field1883[var69];
					} else {
						var56 = class188.field1982;
					}

					var73.method2490(var56);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3241 == var1.field1073) {
					class217.field2588.field376.method6824(var4, var1.field1075);
					class442.method7920();
					field1844 = field1878;
					var1.field1073 = null;
					return true;
				}

				if (class283.field3238 == var1.field1073) {
					class198.method3654();
					field1859 = var4.method8204();
					field1642 = field1878;
					var1.field1073 = null;
					return true;
				}

				if (class283.field3280 == var1.field1073) {
					var21 = var4.method8175();
					var6 = var4.method8122();
					var23 = var6 >> 10 & 31;
					var28 = var6 >> 5 & 31;
					var27 = var6 & 31;
					var31 = (var28 << 11) + (var23 << 19) + (var27 << 3);
					class300 var59 = class282.method5426(var21);
					if (var59.field3485 != var31) {
						var59.field3485 = var31;
						class136.method2438(var59);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3246 == var1.field1073) {
					var21 = var4.method8202();
					if (var21 == 65535) {
						var21 = -1;
					}

					class45.method943(var21);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3215) {
					var21 = var4.method8148();
					var6 = var4.method8162();
					if (var6 == 65535) {
						var6 = -1;
					}

					class196.method3635(var6, var21);
					var1.field1073 = null;
					return true;
				}

				int var14;
				int var18;
				int var19;
				class66 var20;
				int var40;
				byte var82;
				int var84;
				byte var88;
				if (var1.field1073 == class283.field3263) {
					var40 = var4.method8122();
					var82 = var4.method8335();
					var16 = var4.method8202();
					var17 = var4.method8202();
					var14 = var4.method8141() * 4;
					var88 = var4.method8335();
					var19 = var4.method8141();
					var38 = var4.method8183();
					var18 = var4.method8154();
					var23 = var4.method8312();
					var21 = var23 >> 16;
					var6 = var23 >> 8 & 255;
					var28 = (var23 >> 4 & 7) + var21;
					var27 = (var23 & 7) + var6;
					var84 = var4.method8153() * 4;
					var31 = var82 + var28;
					var37 = var88 + var27;
					if (var28 >= 0 && var27 >= 0 && var28 < 104 && var27 < 104 && var31 >= 0 && var37 >= 0 && var31 < 104 && var37 < 104 && var40 != 65535) {
						var28 = 64 + var28 * 128;
						var27 = 64 + var27 * 128;
						var31 = var31 * 128 + 64;
						var37 = 64 + var37 * 128;
						var20 = new class66(var40, class55.field396, var28, var27, class144.method2498(var28, var27, class55.field396) - var14, field1645 + var16, field1645 + var17, var18, var19, var38, var84);
						var20.method1380(var31, var37, class144.method2498(var31, var37, class55.field396) - var84, var16 + field1645);
						field1853.method6355(var20);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3317 == var1.field1073) {
					var17 = var4.method8122();
					var16 = var4.method8164();
					var19 = var4.method8154();
					var23 = var4.method8312();
					var21 = var23 >> 16;
					var6 = var23 >> 8 & 255;
					var28 = var21 + (var23 >> 4 & 7);
					var27 = var6 + (var23 & 7);
					var40 = var4.method8122();
					var38 = var4.method8125();
					var14 = var4.method8154() * 4;
					var88 = var4.method8287();
					var84 = var4.method8341() * 4;
					var82 = var4.method8287();
					var18 = var4.method8141();
					var31 = var82 + var28;
					var37 = var88 + var27;
					if (var28 >= 0 && var27 >= 0 && var28 < 104 && var27 < 104 && var31 >= 0 && var37 >= 0 && var31 < 104 && var37 < 104 && var40 != 65535) {
						var28 = 64 + var28 * 128;
						var27 = var27 * 128 + 64;
						var31 = 64 + var31 * 128;
						var37 = var37 * 128 + 64;
						var20 = new class66(var40, class55.field396, var28, var27, class144.method2498(var28, var27, class55.field396) - var14, var16 + field1645, var17 + field1645, var18, var19, var38, var84);
						var20.method1380(var31, var37, class144.method2498(var31, var37, class55.field396) - var84, field1645 + var16);
						field1853.method6355(var20);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3254 == var1.field1073) {
					class342.method6352(class271.field3028);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3235) {
					var21 = var4.method8126();
					var6 = var4.method8175();
					var23 = var4.method8122();
					if (var23 == 65535) {
						var23 = -1;
					}

					var55 = class282.method5426(var6);
					class198 var79;
					if (!var55.field3459) {
						if (var23 == -1) {
							var55.field3504 = 0;
							var1.field1073 = null;
							return true;
						}

						var79 = class278.method5388(var23);
						var55.field3504 = 4;
						var55.field3505 = var23;
						var55.field3601 = var79.field2137;
						var55.field3513 = var79.field2138;
						var55.field3562 = var79.field2144 * 100 / var21;
						class136.method2438(var55);
					} else {
						var55.field3445 = var23;
						var55.field3599 = var21;
						var79 = class278.method5388(var23);
						var55.field3601 = var79.field2137;
						var55.field3513 = var79.field2138;
						var55.field3514 = var79.field2139;
						var55.field3510 = var79.field2140;
						var55.field3548 = var79.field2128;
						var55.field3562 = var79.field2144;
						if (1 == var79.field2142) {
							var55.field3520 = 1;
						} else {
							var55.field3520 = 2;
						}

						if (var55.field3516 > 0) {
							var55.field3562 = var55.field3562 * 32 / var55.field3516;
						} else if (var55.field3486 > 0) {
							var55.field3562 = var55.field3562 * 32 / var55.field3486;
						}

						class136.method2438(var55);
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3223) {
					var21 = var4.method8202();
					field1893 = var21;
					this.method2892(false);
					class82.method1699(var21);
					class134.method2421(field1893);

					for (var6 = 0; var6 < 100; ++var6) {
						field1860[var6] = true;
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

					class474 var50 = class191.field2026.method7216(var4);
					class174.field1567.field4557.method7566(var50.field4965, var50.field4963);
					field1841[++field1842 - 1 & 31] = var50.field4965;
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3307) {
					class198.method3654();
					var21 = var4.method8175();
					var6 = var4.method8154();
					var23 = var4.method8154();
					field1782[var23] = var21;
					field1780[var23] = var6;
					field1817[var23] = 1;

					for (var28 = 0; var28 < 98; ++var28) {
						if (var21 >= class321.field3756[var28]) {
							field1817[var23] = var28 + 2;
						}
					}

					field1839[++field1742 - 1 & 31] = var23;
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3302) {
					field1847 = field1878;
					var69 = var4.method8287();
					if (var1.field1075 == 1) {
						if (var69 >= 0) {
							field1883[var69] = null;
						} else {
							class188.field1982 = null;
						}

						var1.field1073 = null;
						return true;
					}

					if (var69 >= 0) {
						field1883[var69] = new class147(var4);
					} else {
						class188.field1982 = new class147(var4);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3310 == var1.field1073) {
					var78 = var4.method8129();
					if (var78) {
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
					var21 = var4.method8126();
					var6 = var4.method8202();
					var7 = class282.method5426(var21);
					if (var7.field3504 != 2 || var6 != var7.field3505) {
						var7.field3504 = 2;
						var7.field3505 = var6;
						class136.method2438(var7);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3231 == var1.field1073) {
					return this.method2886(var1, 2);
				}

				if (var1.field1073 == class283.field3314) {
					var21 = var4.method8126();
					var6 = var4.method8122();
					if (var21 < -70000) {
						var6 += 32768;
					}

					if (var21 >= 0) {
						var7 = class282.method5426(var21);
					} else {
						var7 = null;
					}

					if (null != var7) {
						for (var28 = 0; var28 < var7.field3461.length; ++var28) {
							var7.field3461[var28] = 0;
							var7.field3456[var28] = 0;
						}
					}

					class239.method4680(var6);
					var28 = var4.method8122();

					for (var27 = 0; var27 < var28; ++var27) {
						var31 = var4.method8162();
						var37 = var4.method8341();
						if (var37 == 255) {
							var37 = var4.method8174();
						}

						if (var7 != null && var27 < var7.field3461.length) {
							var7.field3461[var27] = var31;
							var7.field3456[var27] = var37;
						}

						class233.method4557(var6, var27, var31 - 1, var37);
					}

					if (null != var7) {
						class136.method2438(var7);
					}

					class198.method3654();
					field1837[++field1838 - 1 & 31] = var6 & 32767;
					var1.field1073 = null;
					return true;
				}

				class89 var54;
				if (class283.field3261 == var1.field1073) {
					var21 = var4.method8341();
					var6 = var4.method8174();
					var23 = var4.method8202();
					var54 = (class89)field1810.method7855((long)var6);
					if (null != var54) {
						class4.method32(var54, var54.field796 != var23);
					}

					class405.method7370(var6, var23, var21);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3271 == var1.field1073) {
					var21 = var4.method8141();
					if (var4.method8141() == 0) {
						field1924[var21] = new class347();
						var4.field4878 += 18;
					} else {
						--var4.field4878;
						field1924[var21] = new class347(var4, false);
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
					class297.field3431 = class363.method6675(var4.method8141());
					var1.field1073 = null;
					return true;
				}

				if (class283.field3285 == var1.field1073) {
					var21 = var4.method8141();
					var6 = var4.method8141();
					var23 = var4.method8141();
					var28 = var4.method8141();
					field1699[var21] = true;
					field1903[var21] = var6;
					field1808[var21] = var23;
					field1905[var21] = var28;
					field1906[var21] = 0;
					var1.field1073 = null;
					return true;
				}

				if (class283.field3279 == var1.field1073) {
					var21 = var4.method8164();
					class93 var57;
					if (field1764 == var21) {
						var57 = class291.field3364;
					} else {
						var57 = field1763[var21];
					}

					var23 = var4.method8174();
					var6 = var4.method8202();
					if (var57 != null) {
						var57.field848 = var6;
						var57.field824 = var23 >> 16;
						var57.field851 = (var23 & 65535) + field1645;
						var57.field856 = 0;
						var57.field807 = 0;
						if (var57.field851 > field1645) {
							var57.field856 = -1;
						}

						if (var57.field848 == 65535) {
							var57.field848 = -1;
						}
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3259) {
					var21 = var4.method8164();
					class408.method7405(var21);
					field1837[++field1838 - 1 & 31] = var21 & 32767;
					var1.field1073 = null;
					return true;
				}

				if (class283.field3284 == var1.field1073) {
					byte[] var49 = new byte[var1.field1075];
					var4.method8017(var49, 0, var49.length);
					class460 var72 = new class460(var49);
					var53 = var72.method8131();
					class115.method2229(var53, true, false);
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
					var48 = var4.method8131();
					var6 = var4.method8176();
					var7 = class282.method5426(var6);
					if (!var48.equals(var7.field3522)) {
						var7.field3522 = var48;
						class136.method2438(var7);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3260 == var1.field1073) {
					class198.method3654();
					field1816 = var4.method8141();
					field1642 = field1878;
					var1.field1073 = null;
					return true;
				}

				if (class283.field3233 == var1.field1073) {
					var21 = var4.method8126();
					if (field1729 != var21) {
						field1729 = var21;
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
					var21 = var4.method8176();
					var6 = var4.method8174();
					class89 var51 = (class89)field1810.method7855((long)var6);
					var54 = (class89)field1810.method7855((long)var21);
					if (var54 != null) {
						class4.method32(var54, var51 == null || var51.field796 != var54.field796);
					}

					if (var51 != null) {
						var51.method7825();
						field1810.method7857(var51, (long)var21);
					}

					var29 = class282.method5426(var6);
					if (null != var29) {
						class136.method2438(var29);
					}

					var29 = class282.method5426(var21);
					if (var29 != null) {
						class136.method2438(var29);
						class26.method349(class300.field3593[var29.field3517 >>> 16], var29, true);
					}

					if (-1 != field1893) {
						class217.method4361(field1893, 1);
					}

					var1.field1073 = null;
					return true;
				}

				String var41;
				if (var1.field1073 == class283.field3300) {
					var69 = var4.method8287();
					var32 = (long)var4.method8122();
					var34 = (long)var4.method8312();
					var10 = var34 + (var32 << 32);
					boolean var86 = false;
					class147 var39 = var69 >= 0 ? field1883[var69] : class188.field1982;
					if (var39 == null) {
						var86 = true;
					} else {
						for (var14 = 0; var14 < 100; ++var14) {
							if (field1918[var14] == var10) {
								var86 = true;
								break;
							}
						}
					}

					if (!var86) {
						field1918[field1875] = var10;
						field1875 = (field1875 + 1) % 100;
						var41 = class307.method5489(var4);
						var84 = var69 >= 0 ? 43 : 46;
						class110.method1858(var84, "", var41, var39.field1350);
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
					var21 = var4.method8183();
					var6 = var4.method8174();
					var7 = class282.method5426(var6);
					if (var21 != var7.field3575 || var21 == -1) {
						var7.field3575 = var21;
						var7.field3471 = 0;
						var7.field3518 = 0;
						class136.method2438(var7);
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3264) {
					class342.method6352(class271.field3020);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3304 == var1.field1073) {
					class25.method344(false, var1.field1076);
					var1.field1073 = null;
					return true;
				}

				if (class283.field3270 == var1.field1073) {
					var21 = var4.method8176();
					var71 = class282.method5426(var21);

					for (var23 = 0; var23 < var71.field3461.length; ++var23) {
						var71.field3461[var23] = -1;
						var71.field3461[var23] = 0;
					}

					class136.method2438(var71);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3242) {
					var48 = var4.method8131();
					var32 = (long)var4.method8122();
					var34 = (long)var4.method8312();
					class333 var42 = (class333)class217.method4362(class333.method5480(), var4.method8141());
					long var43 = var34 + (var32 << 32);
					boolean var89 = false;

					for (var14 = 0; var14 < 100; ++var14) {
						if (field1918[var14] == var43) {
							var89 = true;
							break;
						}
					}

					if (class217.field2588.method1049(new class472(var48, class234.field2779))) {
						var89 = true;
					}

					if (!var89 && field1830 == 0) {
						field1918[field1875] = var43;
						field1875 = (field1875 + 1) % 100;
						var41 = class384.method6864(class158.method2630(class307.method5489(var4)));
						byte var36;
						if (var42.field3857) {
							var36 = 7;
						} else {
							var36 = 3;
						}

						if (var42.field3856 != -1) {
							class42.method773(var36, class96.method5151(var42.field3856) + var48, var41);
						} else {
							class42.method773(var36, var48, var41);
						}
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3288) {
					field1652 = var4.method8141();
					if (1 == field1652) {
						field1879 = var4.method8122();
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
						field1655 = var4.method8122();
						field1656 = var4.method8122();
						field1913 = var4.method8141();
					}

					if (field1652 == 10) {
						field1654 = var4.method8122();
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3322 == var1.field1073) {
					var21 = var4.method8204();
					var6 = var4.method8176();
					var23 = var4.method8183();
					var55 = class282.method5426(var6);
					if (var55.field3469 != var23 || var21 != var55.field3470 || var55.field3465 != 0 || var55.field3466 != 0) {
						var55.field3469 = var23;
						var55.field3470 = var21;
						var55.field3465 = 0;
						var55.field3466 = 0;
						class136.method2438(var55);
						this.method2893(var55);
						if (0 == var55.field3462) {
							class26.method349(class300.field3593[var6 >> 16], var55, false);
						}
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3295) {
					field1900 = false;

					for (var21 = 0; var21 < 5; ++var21) {
						field1699[var21] = false;
					}

					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3255) {
					var21 = var1.field1075 + var4.field4878;
					var6 = var4.method8122();
					var23 = var4.method8122();
					if (var6 != field1893) {
						field1893 = var6;
						this.method2892(false);
						class82.method1699(field1893);
						class134.method2421(field1893);

						for (var28 = 0; var28 < 100; ++var28) {
							field1860[var28] = true;
						}
					}

					class89 var11;
					for (; var23-- > 0; var11.field795 = true) {
						var28 = var4.method8126();
						var27 = var4.method8122();
						var31 = var4.method8141();
						var11 = (class89)field1810.method7855((long)var28);
						if (null != var11 && var11.field796 != var27) {
							class4.method32(var11, true);
							var11 = null;
						}

						if (null == var11) {
							var11 = class405.method7370(var28, var27, var31);
						}
					}

					for (var54 = (class89)field1810.method7867(); var54 != null; var54 = (class89)field1810.method7858()) {
						if (var54.field795) {
							var54.field795 = false;
						} else {
							class4.method32(var54, true);
						}
					}

					field1785 = new class434(512);

					while (var4.field4878 < var21) {
						var28 = var4.method8126();
						var27 = var4.method8122();
						var31 = var4.method8122();
						var37 = var4.method8126();

						for (var38 = var27; var38 <= var31; ++var38) {
							var13 = ((long)var28 << 32) + (long)var38;
							field1785.method7857(new class426(var37), var13);
						}
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3309 == var1.field1073) {
					class342.method6352(class271.field3018);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3229) {
					var69 = var4.method8158();
					var6 = var4.method8202();
					class293.field3368[var6] = var69;
					if (class293.field3370[var6] != var69) {
						class293.field3370[var6] = var69;
					}

					class147.method2521(var6);
					field1931[++field1690 - 1 & 31] = var6;
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3217) {
					class19.field98 = var4.method8153();
					class7.field28 = var4.method8153();
					var1.field1073 = null;
					return true;
				}

				if (class283.field3256 == var1.field1073) {
					var21 = var4.method8162();
					var8 = field1902[var21];
					var23 = var4.method8162();
					var6 = var4.method8175();
					if (var8 != null) {
						var8.field848 = var23;
						var8.field824 = var6 >> 16;
						var8.field851 = (var6 & 65535) + field1645;
						var8.field856 = 0;
						var8.field807 = 0;
						if (var8.field851 > field1645) {
							var8.field856 = -1;
						}

						if (65535 == var8.field848) {
							var8.field848 = -1;
						}
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3257 == var1.field1073) {
					method2263();
					var69 = var4.method8287();
					if (var1.field1075 == 1) {
						if (var69 >= 0) {
							field1738[var69] = null;
						} else {
							class127.field1224 = null;
						}

						var1.field1073 = null;
						return true;
					}

					if (var69 >= 0) {
						field1738[var69] = new class148(var4);
					} else {
						class127.field1224 = new class148(var4);
					}

					var1.field1073 = null;
					return true;
				}

				if (class283.field3281 == var1.field1073) {
					for (var21 = 0; var21 < class178.field1592; ++var21) {
						class178 var70 = class274.method5221(var21);
						if (var70 != null) {
							class293.field3368[var21] = 0;
							class293.field3370[var21] = 0;
						}
					}

					class198.method3654();
					field1690 += 32;
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3232) {
					class342.method6352(class271.field3031);
					var1.field1073 = null;
					return true;
				}

				if (var1.field1073 == class283.field3247) {
					field1900 = true;
					field1901 = false;
					class8.field34 = var4.method8141();
					class122.field1186 = var4.method8141();
					class278.field3197 = var4.method8122();
					class42.field298 = var4.method8141();
					class158.field1440 = var4.method8141();
					if (class158.field1440 >= 100) {
						var21 = class8.field34 * 128 + 64;
						var6 = class122.field1186 * 128 + 64;
						var23 = class144.method2498(var21, var6, class55.field396) - class278.field3197;
						var28 = var21 - class215.field2568;
						var27 = var23 - class32.field204;
						var31 = var6 - class323.field3766;
						var37 = (int)Math.sqrt((double)(var28 * var28 + var31 * var31));
						class414.field4588 = (int)(Math.atan2((double)var27, (double)var37) * 325.9490051269531D) & 2047;
						class237.field2807 = (int)(Math.atan2((double)var28, (double)var31) * -325.9490051269531D) & 2047;
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
					class72 var47 = new class72();
					var47.field589 = var4.method8131();
					var47.field590 = var4.method8122();
					var6 = var4.method8126();
					var47.field587 = var6;
					class9.method64(45);
					var3.method7259();
					var3 = null;
					method3066(var47);
					var1.field1073 = null;
					return false;
				}

				if (class283.field3237 == var1.field1073) {
					field1889 = var4.method8141();
					if (255 == field1889) {
						field1889 = 0;
					}

					field1890 = var4.method8141();
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
					var14 = var4.method8202();
					var31 = var4.method8153();
					var37 = var31 >> 2;
					var38 = var31 & 3;
					var40 = field1708[var37];
					var23 = var4.method8312();
					var21 = var23 >> 16;
					var6 = var23 >> 8 & 255;
					var28 = var21 + (var23 >> 4 & 7);
					var27 = var6 + (var23 & 7);
					if (var28 >= 0 && var27 >= 0 && var28 < 103 && var27 < 103) {
						if (var40 == 0) {
							class229 var66 = class145.field1333.method4144(class55.field396, var28, var27);
							if (var66 != null) {
								var16 = class234.method1610(var66.field2735);
								if (var37 == 2) {
									var66.field2728 = new class61(var16, 2, var38 + 4, class55.field396, var28, var27, var14, false, var66.field2728);
									var66.field2734 = new class61(var16, 2, var38 + 1 & 3, class55.field396, var28, var27, var14, false, var66.field2734);
								} else {
									var66.field2728 = new class61(var16, var37, var38, class55.field396, var28, var27, var14, false, var66.field2728);
								}
							}
						} else if (var40 == 1) {
							class217 var65 = class145.field1333.method4145(class55.field396, var28, var27);
							if (var65 != null) {
								var16 = class234.method1610(var65.field2584);
								if (var37 != 4 && var37 != 5) {
									if (var37 == 6) {
										var65.field2582 = new class61(var16, 4, var38 + 4, class55.field396, var28, var27, var14, false, var65.field2582);
									} else if (var37 == 7) {
										var65.field2582 = new class61(var16, 4, (var38 + 2 & 3) + 4, class55.field396, var28, var27, var14, false, var65.field2582);
									} else if (var37 == 8) {
										var65.field2582 = new class61(var16, 4, var38 + 4, class55.field396, var28, var27, var14, false, var65.field2582);
										var65.field2585 = new class61(var16, 4, 4 + (var38 + 2 & 3), class55.field396, var28, var27, var14, false, var65.field2585);
									}
								} else {
									var65.field2582 = new class61(var16, 4, var38, class55.field396, var28, var27, var14, false, var65.field2582);
								}
							}
						} else if (var40 == 2) {
							var15 = class145.field1333.method4276(class55.field396, var28, var27);
							if (var37 == 11) {
								var37 = 10;
							}

							if (null != var15) {
								var15.field2711 = new class61(class234.method1610(var15.field2719), var37, var38, class55.field396, var28, var27, var14, false, var15.field2711);
							}
						} else if (var40 == 3) {
							class196 var63 = class145.field1333.method4147(class55.field396, var28, var27);
							if (null != var63) {
								var63.field2108 = new class61(class234.method1610(var63.field2109), 22, var38, class55.field396, var28, var27, var14, false, var63.field2108);
							}
						}
					}

					var1.field1073 = null;
					return true;
				}

				class422.method7807("" + (var1.field1073 != null ? var1.field1073.field3324 : -1) + class96.field959 + (var1.field1072 != null ? var1.field1072.field3324 : -1) + class96.field959 + (var1.field1080 != null ? -1220623677 * var1.field1080.field3324 * 1911455211 : -1) + class96.field959 + var1.field1075, (Throwable)null);
				class368.method6731();
			} catch (IOException var45) {
				method4611();
			} catch (Exception var46) {
				var22 = "" + (var1.field1073 != null ? var1.field1073.field3324 : -1) + class96.field959 + (var1.field1072 != null ? -1220623677 * var1.field1072.field3324 * 1911455211 : -1) + class96.field959 + (null != var1.field1080 ? -1220623677 * var1.field1080.field3324 * 1911455211 : -1) + class96.field959 + var1.field1075 + class96.field959 + (class291.field3364.field861[0] + class36.field241) + class96.field959 + (class291.field3364.field873[0] + class169.field1536) + class96.field959;

				for (var23 = 0; var23 < var1.field1075 && var23 < 50; ++var23) {
					var22 = var22 + var4.field4881[var23] + class96.field959;
				}

				class422.method7807(var22, var46);
				class368.method6731();
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

	static void method5557() {
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
		while (!var2) {
			var2 = true;

			for (var3 = 0; var3 < field1695 - 1; ++var3) {
				if (field1788[var3] < 1000 && field1788[var3 + 1] > 1000) {
					String var4 = field1923[var3];
					field1923[var3] = field1923[var3 + 1];
					field1923[var3 + 1] = var4;
					String var5 = field1791[var3];
					field1791[var3] = field1791[var3 + 1];
					field1791[var3 + 1] = var5;
					var6 = field1788[var3];
					field1788[var3] = field1788[var3 + 1];
					field1788[var3 + 1] = var6;
					var6 = field1851[var3];
					field1851[var3] = field1851[var3 + 1];
					field1851[var3 + 1] = var6;
					var6 = field1787[var3];
					field1787[var3] = field1787[var3 + 1];
					field1787[var3 + 1] = var6;
					var6 = field1789[var3];
					field1789[var3] = field1789[var3 + 1];
					field1789[var3 + 1] = var6;
					var6 = field1790[var3];
					field1790[var3] = field1790[var3 + 1];
					field1790[var3 + 1] = var6;
					boolean var7 = field1916[var3];
					field1916[var3] = field1916[var3 + 1];
					field1916[var3 + 1] = var7;
					var2 = false;
				}
			}
		}

		if (null == class183.field1943) {
			if (field1874 == null) {
				int var11;
				int var17;
				int var25;
				label274: {
					int var22 = class42.field277;
					int var9;
					int var16;
					int var23;
					int var24;
					if (field1784) {
						if (var22 != 1 && (class95.field944 || var22 != 4)) {
							var3 = class42.field284;
							var16 = class42.field285;
							if (var3 < class94.field923 - 10 || var3 > 10 + class94.field923 + class179.field1601 || var16 < class125.field1206 - 10 || var16 > 10 + class240.field2826 + class125.field1206) {
								field1784 = false;
								class319.method6181(class94.field923, class125.field1206, class179.field1601, class240.field2826);
							}
						}

						if (var22 == 1 || !class95.field944 && var22 == 4) {
							var3 = class94.field923;
							var16 = class125.field1206;
							var17 = class179.field1601;
							var6 = class42.field283;
							var23 = class42.field293;
							var24 = -1;

							for (var9 = 0; var9 < field1695; ++var9) {
								var25 = var16 + 31 + (field1695 - 1 - var9) * 15;
								if (var6 > var3 && var6 < var3 + var17 && var23 > var25 - 13 && var23 < var25 + 3) {
									var24 = var9;
								}
							}

							if (var24 != -1 && var24 >= 0) {
								var9 = field1851[var24];
								var25 = field1787[var24];
								var11 = field1788[var24];
								int var12 = field1789[var24];
								int var13 = field1790[var24];
								String var14 = field1791[var24];
								String var15 = field1923[var24];
								class263.method5159(var9, var25, var11, var12, var13, var14, var15, class42.field283, class42.field293);
							}

							field1784 = false;
							class319.method6181(class94.field923, class125.field1206, class179.field1601, class240.field2826);
						}
					} else {
						var3 = method5125();
						if ((var22 == 1 || !class95.field944 && var22 == 4) && var3 >= 0) {
							var16 = field1788[var3];
							if (var16 == 39 || var16 == 40 || var16 == 41 || var16 == 42 || var16 == 43 || var16 == 33 || var16 == 34 || var16 == 35 || var16 == 36 || var16 == 37 || var16 == 38 || var16 == 1005) {
								var17 = field1851[var3];
								var6 = field1787[var3];
								class300 var18 = class282.method5426(var6);
								var9 = class190.method3528(var18);
								boolean var8 = (var9 >> 28 & 1) != 0;
								if (var8) {
									break label274;
								}

								var11 = class190.method3528(var18);
								boolean var10 = (var11 >> 29 & 1) != 0;
								if (var10) {
									break label274;
								}
							}
						}

						if ((var22 == 1 || !class95.field944 && var22 == 4) && this.method2890()) {
							var22 = 2;
						}

						if ((var22 == 1 || !class95.field944 && var22 == 4) && field1695 > 0 && var3 >= 0) {
							var16 = field1851[var3];
							var17 = field1787[var3];
							var6 = field1788[var3];
							var23 = field1789[var3];
							var24 = field1790[var3];
							String var19 = field1791[var3];
							String var20 = field1923[var3];
							class263.method5159(var16, var17, var6, var23, var24, var19, var20, class42.field283, class42.field293);
						}

						if (var22 == 2 && field1695 > 0) {
							this.method3357(class42.field283, class42.field293);
						}
					}

					return;
				}

				if (null != class183.field1943 && !field1759 && field1695 > 0 && !this.method2890()) {
					var25 = field1638;
					var11 = field1757;
					class73 var21 = class101.field1005;
					if (null != var21) {
						class263.method5159(var21.field600, var21.field595, var21.field594, var21.field597, var21.field598, var21.field599, var21.field604, var25, var11);
					}

					class101.field1005 = null;
				}

				field1759 = false;
				field1786 = 0;
				if (null != class183.field1943) {
					class136.method2438(class183.field1943);
				}

				class183.field1943 = class282.method5426(var6);
				field1737 = var17;
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
		int var4 = class114.field1127.method6894(class338.field4057);

		int var5;
		int var6;
		for (var5 = 0; var5 < field1695; ++var5) {
			var6 = class114.field1127.method6894(class233.method4558(var5));
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

	static void method7985(int var0, int var1) {
		class263 var3 = class185.method3435(class274.field3109, field1778.field1071);
		var3.field2984.method8159(var1);
		var3.field2984.method8241(var0);
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
		class327.method6242(var1, var4, var5);
	}

	static final void method1783(int var0, int var1, int var2, int var3, int var4) {
		class420.field4661[0].method8755(var0, var1);
		class420.field4661[1].method8755(var0, var1 + var3 - 16);
		class481.method8660(var0, var1 + 16, 16, var3 - 32, field1857);
		int var6 = (var3 - 32) * var3 / var4;
		if (var6 < 8) {
			var6 = 8;
		}

		int var7 = var2 * (var3 - 32 - var6) / (var4 - var3);
		class481.method8660(var0, var7 + var1 + 16, 16, var6, field1711);
		class481.method8667(var0, var7 + var1 + 16, var6, field1713);
		class481.method8667(var0 + 1, var7 + var1 + 16, var6, field1713);
		class481.method8666(var0, var7 + var1 + 16, 16, field1713);
		class481.method8666(var0, var1 + 17 + var7, 16, field1713);
		class481.method8667(var0 + 15, var7 + var1 + 16, var6, field1712);
		class481.method8667(var0 + 14, var7 + var1 + 17, var6 - 1, field1712);
		class481.method8666(var0, var6 + var7 + var1 + 15, 16, field1712);
		class481.method8666(var0 + 1, var1 + 14 + var7 + var6, 15, field1712);
	}

	static void method8647(boolean var0) {
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
		for (int var2 = 0; var2 < field1822; ++var2) {
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
						class300 var10 = field1874;
						int var12 = class190.method3528(var10);
						int var11 = var12 >> 17 & 7;
						int var13 = var11;
						class300 var19;
						if (var11 == 0) {
							var19 = null;
						} else {
							int var14 = 0;

							while (true) {
								if (var14 >= var13) {
									var19 = var10;
									break;
								}

								var10 = class282.method5426(var10.field3596);
								if (var10 == null) {
									var19 = null;
									break;
								}

								++var14;
							}
						}

						if (null != var19) {
							class263 var20 = class185.method3435(class274.field3097, field1778.field1071);
							var20.field2984.method8241(field1874.field3517);
							var20.field2984.method8181(field1874.field3445);
							var20.field2984.method8181(field1874.field3484);
							var20.field2984.method8181(field1826.field3484);
							var20.field2984.method8241(field1826.field3517);
							var20.field2984.method8159(field1826.field3445);
							field1778.method2078(var20);
						}
					}
				} else if (this.method2890()) {
					this.method3357(field1824 + field1831, field1825 + field1832);
				} else if (field1695 > 0) {
					int var17 = field1824 + field1831;
					int var18 = field1832 + field1825;
					class73 var16 = class101.field1005;
					if (var16 != null) {
						class263.method5159(var16.field600, var16.field595, var16.field594, var16.field597, var16.field598, var16.field599, var16.field604, var17, var18);
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

	static final int method6543() {
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

	static final void method6049(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		class413.field4575.method1719(var0);
	}

	static final void method602() {
		for (int var1 = 0; var1 < class102.field1012; ++var1) {
			class93 var2 = field1763[class102.field1013[var1]];
			var2.method1911();
		}

	}

	static final void method6423() {
		field1845 = field1878;
		class105.field1046 = true;
	}

	static final void method2263() {
		field1846 = field1878;
		class145.field1335 = true;
	}

	static final void method2589() {
		class263 var1 = class185.method3435(class274.field3049, field1778.field1071);
		var1.field2984.method8104(0);
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

		class386.method6961(var3, var1, field1689, 0, 24);
		class199.method3732(var0, var1);
	}

	public class472 method6785() {
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

	public static boolean method5842() {
		return null != field1874;
	}

	static void method197(boolean var0) {
		field1862 = var0;
	}

	public static Clipboard method778() {
		return class133.field1257.method446();
	}
}
