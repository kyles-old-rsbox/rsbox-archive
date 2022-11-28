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
	public static class205 keyHandler;
	public static int worldId;
	public static int buildNumber;
	public static int field1936;
	public static final class107 serverConnection;
	static boolean isLowDetail;
	static boolean field1640;
	static boolean field1643;
	static boolean field1648;
	static boolean isFocused;
	static boolean field1660;
	static boolean field1697;
	static boolean dynamicRegion;
	static boolean field1714;
	static boolean field1732;
	static boolean field1739;
	static boolean field1752;
	static boolean field1759;
	static boolean field1762;
	static boolean field1781;
	static boolean field1783;
	static boolean isMenuOpen;
	static boolean field1794;
	static boolean field1796;
	static boolean field1797;
	static boolean isSpellSelected;
	static boolean isPlayerMod;
	static boolean field1827;
	static boolean isLoading;
	static boolean field1833;
	static boolean field1862;
	static boolean isResizable;
	static boolean isUsernameRemembered;
	static boolean field1900;
	static boolean field1901;
	static boolean[] field1699;
	static boolean[] playerOptionsPriorities;
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
	static PlayerModel playerAppearance;
	static class336 field1665;
	static class33[] field1899;
	static NodeDeque field1765;
	static NodeDeque pendingSpawns;
	static NodeDeque graphics;
	static NodeDeque field1813;
	static NodeDeque projectiles;
	static NodeDeque field1854;
	static NodeDeque field1856;
	static NodeDeque[][][] groundItems;
	static class347[] field1924;
	static class382 timer;
	static NodeHashTable field1785;
	static NodeHashTable parentInterfaces;
	static class436 field1807;
	static class445 field1758;
	static class470 field1852;
	static class473[] field1818;
	static class58 field1685;
	static class74 field1925;
	static AttackOption playerAttackOption;
	static AttackOption npcAttackOption;
	static class81[] npcs;
	static PlayerEntity[] localPlayers;
	static int field1631;
	static int field1633;
	static int field1634;
	static int field1637;
	static int field1638;
	static int field1639;
	static int field1642;
	static int field1645;
	static int field1647;
	static int rebootTimer;
	static int hintArrowType;
	static int field1654;
	static int field1655;
	static int field1656;
	static int mouseCrossX;
	static int field1661;
	static int field1662;
	static int js5ConnectionState;
	static int field1664;
	static int field1666;
	static int loginState;
	static int loginTicks;
	static int loginErrorCount;
	static int field1670;
	static int field1672;
	static int field1676;
	static int field1678;
	static int field1682;
	static int field1684;
	static int field1686;
	static int field1690;
	static int npcCount;
	static int field1693;
	static int menuOptionsCount;
	static int logoutTimer;
	static int field1700;
	static int field1701;
	static int field1702;
	static int field1703;
	static int clientType;
	static int minimapState;
	static int field1711;
	static int field1712;
	static int field1713;
	static int field1715;
	static int field1716;
	static int loginWaitSeconds;
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
	static int mouseCrossY;
	static int privilegeLevel;
	static int mouseCrossColor;
	static int field1753;
	static int field1757;
	static int field1761;
	static int localPlayerIndex;
	static int gameState;
	static int field1767;
	static int field1768;
	static int field1769;
	static int field1773;
	static int combatTargetPlayerIndex;
	static int field1786;
	static int field1793;
	static int field1798;
	static int field1799;
	static int isItemSelected;
	static int field1805;
	static int field1806;
	static int field1809;
	static int field1811;
	static int field1814;
	static int field1816;
	static int followerIndex;
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
	static int destinationX;
	static int destinationY;
	static int field1892;
	static int rootInterface;
	static int soundEffectCount;
	static int field1898;
	static int mouseCrossState;
	static int field1910;
	static int gameBuild;
	static int field1913;
	static int field1915;
	static int field1917;
	static int field1919;
	static int isMember;
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
	static int[][][] instanceChunkTemplates;
	static String field1653;
	static String field1754;
	static String field1803;
	static String field1873;
	static String[] field1743;
	static String[] playerMenuActions;
	static String[] field1791;
	static String[] field1923;
	static ArrayList field1930;
	static HashMap field1934;
	static long playerUUID;
	static long field1644;
	static long mouseLastPressedTimeMillis;
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
	ProofOfWorkRequest powRequest;
	Buffer powResponseBuf;
	OtlTokenRequester field1815;
	RefreshAccessTokenRequester field1680;
	String field1673;
	Future field1677;
	Future field1681;
	long seed;

	public client() {
		this.field1835 = false;
		this.seed = -1L;
	}

	static {
		field1660 = true;
		worldId = 1;
		field1633 = 0;
		gameBuild = 0;
		field1635 = false;
		isLowDetail = false;
		field1637 = -1;
		clientType = -1;
		field1716 = -1;
		field1640 = false;
		buildNumber = 209;
		gameState = 0;
		isLoading = true;
		field1645 = 0;
		mouseLastPressedTimeMillis = -1L;
		field1647 = -1;
		field1773 = -1;
		field1644 = -1L;
		isFocused = true;
		rebootTimer = 0;
		hintArrowType = 0;
		field1879 = 0;
		field1654 = 0;
		field1655 = 0;
		field1656 = 0;
		field1913 = 0;
		field1866 = 0;
		field1684 = 0;
		playerAttackOption = AttackOption.HIDDEN;
		npcAttackOption = AttackOption.HIDDEN;
		field1793 = 0;
		js5ConnectionState = 0;
		field1664 = 0;
		field1666 = 0;
		loginState = 0;
		loginTicks = 0;
		loginErrorCount = 0;
		loginWaitSeconds = 0;
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
		isUsernameRemembered = false;
		field1685 = new class58();
		field1689 = null;
		npcs = new class81[65536];
		npcCount = 0;
		field1692 = new int[65536];
		field1693 = 0;
		field1694 = new int[250];
		serverConnection = new class107();
		logoutTimer = 0;
		field1697 = false;
		timer = new class382();
		field1934 = new HashMap();
		field1700 = 0;
		field1631 = 1;
		field1702 = 0;
		field1703 = 1;
		field1725 = 0;
		field1884 = new class200[4];
		dynamicRegion = false;
		instanceChunkTemplates = new int[4][13][13];
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
		mouseCrossX = 0;
		mouseCrossY = 0;
		mouseCrossState = 0;
		mouseCrossColor = 0;
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
		localPlayers = new PlayerEntity[2048];
		localPlayerIndex = -1;
		isMember = 0;
		playerUUID = -1L;
		field1739 = true;
		field1768 = 0;
		field1769 = 0;
		field1770 = new int[1000];
		field1771 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		field1774 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
		combatTargetPlayerIndex = -1;
		groundItems = new NodeDeque[4][104][104];
		pendingSpawns = new NodeDeque();
		projectiles = new NodeDeque();
		graphics = new NodeDeque();
		field1780 = new int[25];
		field1817 = new int[25];
		field1782 = new int[25];
		field1862 = false;
		isMenuOpen = false;
		menuOptionsCount = 0;
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
		isItemSelected = 0;
		field1803 = null;
		isSpellSelected = false;
		field1805 = -1;
		field1806 = -1;
		field1653 = null;
		field1754 = null;
		rootInterface = -1;
		parentInterfaces = new NodeHashTable(8);
		field1811 = 0;
		field1898 = -1;
		field1753 = 0;
		field1814 = 0;
		field1641 = null;
		field1816 = 0;
		field1859 = 0;
		privilegeLevel = 0;
		followerIndex = -1;
		isPlayerMod = false;
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
		field1765 = new NodeDeque();
		field1854 = new NodeDeque();
		field1813 = new NodeDeque();
		field1856 = new NodeDeque();
		field1785 = new NodeHashTable(512);
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
		isResizable = true;
		field1870 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		field1871 = 0;
		field1872 = 0;
		field1873 = "";
		field1918 = new long[100];
		field1875 = 0;
		keyHandler = new class205();
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
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		field1748 = -1;
		field1781 = false;
		soundEffectCount = 0;
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
		playerAppearance = new PlayerModel();
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
		return ProofOfWorkRequest.field10;
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
						if (clientType == -1) {
							clientType = Integer.parseInt(var2);
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
						class368.field4353 = (class329)class217.fromValue(class329.method1596(), Integer.parseInt(var2));
						if (class368.field4353 == class329.field3819) {
							class234.gameEngineMode = class463.field4894;
						} else {
							class234.gameEngineMode = class463.field4896;
						}
						break;
					case 11:
						class106.field1050 = var2;
						break;
					case 12:
						worldId = Integer.parseInt(var2);
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
						gameBuild = Integer.parseInt(var2);
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
							buildNumber = Integer.parseInt(var2);
						} else {
							buildNumber = Integer.parseInt(var2.substring(0, var3));
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
					MouseManager.field296 = System.getProperty("os.name");
				} catch (Exception var16) {
					MouseManager.field296 = "Unknown";
				}

				class20.field100 = MouseManager.field296.toLowerCase();

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
					class290.field3361 = ProofOfWorkRequest.method34(ClientLauncher.CACHE_DIR, var8, var3);
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
			Buffer.field4885 = clientType;
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
		Scene.field2559 = false;
		isLowDetail = false;
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

		class180.worldPort = gameBuild == 0 ? 43594 : 40000 + worldId;
		class141.js5Port = gameBuild == 0 ? 443 : 50000 + worldId;
		class454.currentPort = class180.worldPort;
		class172.field1551 = class303.field3622;
		class37.field251 = class303.field3624;
		class9.field39 = class303.field3621;
		class97.field974 = class303.field3623;
		class28.urlRequester = new class125(this.field1835, 209);
		this.initKeyboard();
		this.method450();
		class18.mouseWheel = this.mouseWheel();
		this.method449(field1877, 0);
		this.method449(keyHandler, 1);
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

			var6 = new class83(new Buffer(var7));
		} catch (Exception var12) {
		}

		try {
			if (null != var5) {
				var5.method8374();
			}
		} catch (Exception var11) {
		}

		class413.clientPreferences = var6;
		this.method444();
		class99.method1985(this, AttackOption.field706);
		class164.method2692(class413.clientPreferences.method1726());
		class217.friends = new class53(class234.gameEngineMode);
		this.field1674 = new class15("tokenRequest", 1, 1);
	}

	protected final void method468() {
		++field1645;
		this.method3087();
		class322.method4893();
		class182.method2856();
		class349.method6457();
		keyHandler.method3893();
		this.method539();
		MouseManager.method4616();
		if (null != class18.mouseWheel) {
			int var2 = class18.mouseWheel.method2702();
			field1639 = var2;
		}

		if (gameState == 0) {
			class34.load();
			class339.method6315();
		} else if (gameState == 5) {
			class442.loginScreen(this, class353.fontPlain12);
			class34.load();
			class339.method6315();
		} else if (10 != gameState && 11 != gameState) {
			if (20 == gameState) {
				class442.loginScreen(this, class353.fontPlain12);
				this.cycleLoggedOut();
			} else if (50 == gameState) {
				class442.loginScreen(this, class353.fontPlain12);
				this.cycleLoggedOut();
			} else if (25 == gameState) {
				class43.method802();
			}
		} else {
			class442.loginScreen(this, class353.fontPlain12);
		}

		if (gameState == 30) {
			this.cycleLoggedIn();
		} else if (40 == gameState || 45 == gameState) {
			this.cycleLoggedOut();
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
						class279.field3201.method5271(MessagesManager.field1092);
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

		if ((10 == gameState || 20 == gameState || gameState == 30) && 0L != field1730 && class272.method2046() > field1730) {
			class164.method2692(class2.method11());
		}

		int var5;
		if (var1) {
			for (var5 = 0; var5 < 100; ++var5) {
				field1860[var5] = true;
			}
		}

		if (gameState == 0) {
			this.method477(Login.field622, Login.field623, var1);
		} else if (5 == gameState) {
			class109.method2105(class114.field1127, class346.field4250, class353.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				class109.method2105(class114.field1127, class346.field4250, class353.fontPlain12);
			} else if (gameState == 50) {
				class109.method2105(class114.field1127, class346.field4250, class353.fontPlain12);
			} else if (gameState == 25) {
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
			} else if (gameState == 30) {
				this.method2885();
			} else if (gameState == 40) {
				class131.method2399(class338.field3903 + class96.field966 + class338.field3950, false);
			} else if (gameState == 45) {
				class131.method2399(class338.field4062, false);
			}
		} else {
			class109.method2105(class114.field1127, class346.field4250, class353.fontPlain12);
		}

		if (30 == gameState && field1867 == 0 && !var1 && !isResizable) {
			for (var5 = 0; var5 < field1858; ++var5) {
				if (field1861[var5]) {
					class6.field18.method8620(field1863[var5], field1864[var5], field1710[var5], field1658[var5]);
					field1861[var5] = false;
				}
			}
		} else if (gameState > 0) {
			class6.field18.method8621(0, 0);

			for (var5 = 0; var5 < field1858; ++var5) {
				field1861[var5] = false;
			}
		}

	}

	protected final void method455() {
		if (class66.varcs.method2316()) {
			class66.varcs.method2312();
		}

		if (null != class74.mouseRecorder) {
			class74.mouseRecorder.field746 = false;
		}

		class74.mouseRecorder = null;
		serverConnection.method2080();
		class73.method1488();
		class18.mouseWheel = null;
		if (class91.field886 != null) {
			class91.field886.method361();
		}

		if (class88.field794 != null) {
			class88.field794.method361();
		}

		class323.method6200();
		class322.method3464();
		if (null != class28.urlRequester) {
			class28.urlRequester.method2236();
			class28.urlRequester = null;
		}

		class53.method1112();
		this.field1674.method130();
	}

	void method3087() {
		if (1000 != gameState) {
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
						Buffer var7;
						while (class324.field3780 < 200 && class324.field3778 > 0) {
							var6 = (class335)class324.field3794.first();
							var7 = new Buffer(4);
							var7.writeByte(1);
							var7.writeMedium((int)var6.field4681);
							class324.field3787.write(var7.data, 0, 4);
							class324.field3779.method7857(var6, var6.field4681);
							--class324.field3778;
							++class324.field3780;
						}

						while (class324.field3777 < 200 && class324.field3788 > 0) {
							var6 = (class335)class324.field3781.method6573();
							var7 = new Buffer(4);
							var7.writeByte(0);
							var7.writeMedium((int)var6.field4681);
							class324.field3787.write(var7.data, 0, 4);
							var6.method7889();
							class324.field3784.method7857(var6, var6.field4681);
							--class324.field3788;
							++class324.field3777;
						}

						for (int var18 = 0; var18 < 100; ++var18) {
							int var19 = class324.field3787.available();
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
							Buffer var26;
							if (var8 > 0) {
								var9 = var8 - class324.field3776.offset;
								if (var9 > var19) {
									var9 = var19;
								}

								class324.field3787.read(class324.field3776.data, class324.field3776.offset, var9);
								if (class324.field3792 != 0) {
									for (var10 = 0; var10 < var9; ++var10) {
										var10000 = class324.field3776.data;
										var10001 = var10 + class324.field3776.offset;
										var10000[var10001] ^= class324.field3792;
									}
								}

								var26 = class324.field3776;
								var26.offset += var9;
								if (class324.field3776.offset < var8) {
									break;
								}

								if (null == class116.field1137) {
									class324.field3776.offset = 0;
									var10 = class324.field3776.readUnsignedByte();
									var11 = class324.field3776.readUnsignedShort();
									int var12 = class324.field3776.readUnsignedByte();
									var13 = class324.field3776.readInt();
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
									class431.field4704 = new Buffer(class116.field1137.field3868 + var13 + var17);
									class431.field4704.writeByte(var12);
									class431.field4704.writeInt(var13);
									class324.field3790 = 8;
									class324.field3776.offset = 0;
								} else if (class324.field3790 == 0) {
									if (-1 == class324.field3776.data[0]) {
										class324.field3790 = 1;
										class324.field3776.offset = 0;
									} else {
										class116.field1137 = null;
									}
								}
							} else {
								var9 = class431.field4704.data.length - class116.field1137.field3868;
								var10 = 512 - class324.field3790;
								if (var10 > var9 - class431.field4704.offset) {
									var10 = var9 - class431.field4704.offset;
								}

								if (var10 > var19) {
									var10 = var19;
								}

								class324.field3787.read(class431.field4704.data, class431.field4704.offset, var10);
								if (class324.field3792 != 0) {
									for (var11 = 0; var11 < var10; ++var11) {
										var10000 = class431.field4704.data;
										var10001 = var11 + class431.field4704.offset;
										var10000[var10001] ^= class324.field3792;
									}
								}

								var26 = class431.field4704;
								var26.offset += var10;
								class324.field3790 += var10;
								if (var9 == class431.field4704.offset) {
									if (16711935L == class116.field1137.field4681) {
										MessagesManager.field1090 = class431.field4704;

										for (var11 = 0; var11 < 256; ++var11) {
											class336 var20 = class324.field3789[var11];
											if (null != var20) {
												MessagesManager.field1090.offset = var11 * 8 + 5;
												if (MessagesManager.field1090.offset >= MessagesManager.field1090.data.length) {
													if (!var20.field3883) {
														throw new RuntimeException("");
													}

													var20.method6281();
												} else {
													var13 = MessagesManager.field1090.readInt();
													int var21 = MessagesManager.field1090.readInt();
													var20.method6298(var13, var21);
												}
											}
										}
									} else {
										class324.field3785.reset();
										class324.field3785.update(class431.field4704.data, 0, var9);
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
										class116.field1137.field3866.method6278((int)(class116.field1137.field4681 & 65535L), class431.field4704.data, 16711680L == (class116.field1137.field4681 & 16711680L), class111.field1097);
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
				if (gameState <= 5) {
					this.method473("js5io");
					class9.method64(1000);
					return;
				}

				field1664 = 3000;
				class324.field3775 = 3;
			}

			if (--field1664 + 1 <= 0) {
				try {
					if (0 == js5ConnectionState) {
						class347.js5Socket = class31.field169.method2723(class271.field3032, class454.currentPort);
						++js5ConnectionState;
					}

					if (js5ConnectionState == 1) {
						if (class347.js5Socket.field1614 == 2) {
							this.method3062(-1);
							return;
						}

						if (class347.js5Socket.field1614 == 1) {
							++js5ConnectionState;
						}
					}

					Buffer buf;
					if (2 == js5ConnectionState) {
						Socket socket = (Socket)class347.js5Socket.socket;
						BufferedNetworkSocket js5Socket = new BufferedNetworkSocket(socket, 40000, 5000);
						class312.js5Socket = js5Socket;
						buf = new Buffer(5);
						buf.writeByte(15);
						buf.writeInt(209);
						class312.js5Socket.write(buf.data, 0, 5);
						++js5ConnectionState;
						class218.field2591 = class272.method2046();
					}

					if (3 == js5ConnectionState) {
						if (class312.js5Socket.available() > 0) {
							int var6 = class312.js5Socket.readUnsignedByte();
							if (var6 != 0) {
								this.method3062(var6);
								return;
							}

							++js5ConnectionState;
						} else if (class272.method2046() - class218.field2591 > 30000L) {
							this.method3062(-2);
							return;
						}
					}

					if (js5ConnectionState == 4) {
						AbstractSocket var12 = class312.js5Socket;
						boolean var7 = gameState > 20;
						if (null != class324.field3787) {
							try {
								class324.field3787.method7259();
							} catch (Exception var10) {
							}

							class324.field3787 = null;
						}

						class324.field3787 = var12;
						MouseManager.method799(var7);
						class324.field3776.offset = 0;
						class116.field1137 = null;
						class431.field4704 = null;
						class324.field3790 = 0;

						while (true) {
							class335 var13 = (class335)class324.field3779.first();
							if (var13 == null) {
								while (true) {
									var13 = (class335)class324.field3784.first();
									if (null == var13) {
										if (class324.field3792 != 0) {
											try {
												buf = new Buffer(4);
												buf.writeByte(4);
												buf.writeByte(class324.field3792);
												buf.writeShort(0);
												class324.field3787.write(buf.data, 0, 4);
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
										class347.js5Socket = null;
										class312.js5Socket = null;
										js5ConnectionState = 0;
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
		class347.js5Socket = null;
		class312.js5Socket = null;
		js5ConnectionState = 0;
		if (class180.worldPort == class454.currentPort) {
			class454.currentPort = class141.js5Port;
		} else {
			class454.currentPort = class180.worldPort;
		}

		++field1666;
		if (field1666 >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.method473("js5connect_full");
				class9.method64(1000);
			} else {
				field1664 = 3000;
			}
		} else if (field1666 >= 2 && var1 == 6) {
			this.method473("js5connect_outofdate");
			class9.method64(1000);
		} else if (field1666 >= 4) {
			if (gameState <= 5) {
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
			var5 = var4.getGroupId("sl_back");
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

		class481.method8660(Login.field618, 23, 765, 480, 0);
		class481.method8686(Login.field618, 0, 125, 23, 12425273, 9135624);
		class481.method8686(125 + Login.field618, 0, 640, 23, 5197647, 2697513);
		var0.method6955(class338.field4054, 62 + Login.field618, 15, 0, -1);
		if (null != class207.field2367) {
			class207.field2367[1].method8755(Login.field618 + 140, 1);
			var1.method6875(class338.field4126, 152 + Login.field618, 10, 16777215, -1);
			class207.field2367[0].method8755(140 + Login.field618, 12);
			var1.method6875(class338.field4059, Login.field618 + 152, 21, 16777215, -1);
		}

		if (class84.field752 != null) {
			int var23 = Login.field618 + 280;
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
			int var24 = 390 + Login.field618;
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
			var5 = Login.field618 + 500;
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
			var6 = 610 + Login.field618;
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

		class481.method8660(708 + Login.field618, 4, 50, 16, 0);
		var1.method6955(class338.field4149, Login.field618 + 708 + 25, 16, 16777215, -1);
		Login.field626 = -1;
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
			Login.field616 = var11 - var5;
			if (null != class227.field2723 && Login.field645 > 0) {
				class227.field2723.method8755(8, class12.canvasHeight / 2 - class227.field2723.field5019 / 2);
			}

			if (null != class7.field24 && Login.field645 < Login.field616) {
				class7.field24.method8755(class31.canvasWidth - class7.field24.field5017 - 8, class12.canvasHeight / 2 - class7.field24.field5019 / 2);
			}

			int var12 = var10 + 23;
			int var13 = var9 + Login.field618;
			int var14 = 0;
			boolean var15 = false;
			int var16 = Login.field645;

			int var17;
			for (var17 = var16 * var6; var17 < class72.field582 && var16 - Login.field645 < var5; ++var17) {
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

				if (MouseManager.field284 >= var13 && MouseManager.field285 >= var12 && MouseManager.field284 < var27 + var13 && MouseManager.field285 < var12 + var28 && var19) {
					Login.field626 = var17;
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
				var17 = var1.method6894(class399.field4502[Login.field626].field588) + 6;
				int var18 = var1.field4435 + 8;
				int var26 = MouseManager.field285 + 25;
				if (var18 + var26 > 480) {
					var26 = MouseManager.field285 - 25 - var18;
				}

				class481.method8660(MouseManager.field284 - var17 / 2, var26, var17, var18, 16777120);
				class481.method8664(MouseManager.field284 - var17 / 2, var26, var17, var18, 0);
				var1.method6955(class399.field4502[Login.field626].field588, MouseManager.field284, var26 + var1.field4435 + 4, 0, -1);
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
		worldId = var0.field590;
		field1633 = var0.field587;
		class180.worldPort = 0 == gameBuild ? 43594 : 40000 + var0.field590;
		class141.js5Port = 0 == gameBuild ? 443 : 50000 + var0.field590;
		class454.currentPort = class180.worldPort;
	}

	static class336 method5506(int var0, boolean var1, boolean var2, boolean var3, boolean var4) {
		class392 var6 = null;
		if (null != class163.field1503) {
			var6 = new class392(var0, class163.field1503, class163.field1510[var0], 1000000);
		}

		return new class336(var6, class227.field2721, var0, var1, var2, var3, var4);
	}

	final void cycleLoggedOut() {
		Object loginSocket = serverConnection.method2082();
		PacketBuffer packetBuf = serverConnection.buffer;

		try {
			if (loginState == 0) {
				if (class147.isaacRandom == null && (field1685.method1278() || loginTicks > 250)) {
					class147.isaacRandom = field1685.method1289();
					field1685.method1277();
					field1685 = null;
				}

				if (class147.isaacRandom != null) {
					if (null != loginSocket) {
						((AbstractSocket)loginSocket).method7259();
						loginSocket = null;
					}

					class231.field2748 = null;
					field1697 = false;
					loginTicks = 0;
					if (field1758.method7938()) {
						try {
							this.method2876(class298.field3437);
							class43.setLoginState(21);
						} catch (Throwable var26) {
							class422.method7807((String)null, var26);
							class112.loginError(65);
							return;
						}
					} else {
						class43.setLoginState(1);
					}
				}
			}

			class9 var28;
			if (21 == loginState) {
				if (this.field1681 != null) {
					if (!this.field1681.isDone()) {
						return;
					}

					if (this.field1681.isCancelled()) {
						class112.loginError(65);
						this.field1681 = null;
						return;
					}

					try {
						RefreshAccessTokenResponse var4 = (RefreshAccessTokenResponse)this.field1681.get();
						if (!var4.isSuccess()) {
							class112.loginError(65);
							this.field1681 = null;
							return;
						}

						class310.field3689 = var4.getAccessToken();
						class298.field3437 = var4.getRefreshToken();
						this.field1681 = null;
					} catch (Exception var25) {
						class422.method7807((String)null, var25);
						class112.loginError(65);
						this.field1681 = null;
						return;
					}
				} else {
					if (null == this.field1679) {
						class112.loginError(65);
						return;
					}

					if (!this.field1679.method107()) {
						return;
					}

					if (this.field1679.method119()) {
						class422.method7807(this.field1679.method111(), (Throwable)null);
						class112.loginError(65);
						this.field1679 = null;
						return;
					}

					var28 = this.field1679.method108();
					if (var28.method54() != 200) {
						class112.loginError(65);
						this.field1679 = null;
						return;
					}

					loginTicks = 0;
					class425 var5 = new class425(var28.method55());

					try {
						class310.field3689 = var5.method7816().getString("access_token");
						class298.field3437 = var5.method7816().getString("refresh_token");
					} catch (Exception var24) {
						class422.method7807("Error parsing tokens", var24);
						class112.loginError(65);
						this.field1679 = null;
						return;
					}
				}

				this.method2877(class310.field3689);
				class43.setLoginState(20);
			}

			if (loginState == 20) {
				if (null != this.field1677) {
					if (!this.field1677.isDone()) {
						return;
					}

					if (this.field1677.isCancelled()) {
						class112.loginError(65);
						this.field1677 = null;
						return;
					}

					try {
						OtlTokenResponse var29 = (OtlTokenResponse)this.field1677.get();
						if (!var29.isSuccess()) {
							class112.loginError(65);
							this.field1677 = null;
							return;
						}

						this.field1673 = var29.getToken();
						this.field1677 = null;
					} catch (Exception var23) {
						class422.method7807((String)null, var23);
						class112.loginError(65);
						this.field1677 = null;
						return;
					}
				} else {
					if (null == this.field1675) {
						class112.loginError(65);
						return;
					}

					if (!this.field1675.method107()) {
						return;
					}

					if (this.field1675.method119()) {
						class422.method7807(this.field1675.method111(), (Throwable)null);
						class112.loginError(65);
						this.field1675 = null;
						return;
					}

					var28 = this.field1675.method108();
					if (var28.method54() != 200) {
						class422.method7807("Response code: " + var28.method54() + "Response body: " + var28.method55(), (Throwable)null);
						class112.loginError(65);
						this.field1675 = null;
						return;
					}

					this.field1673 = var28.method55();
					this.field1675 = null;
				}

				loginTicks = 0;
				class43.setLoginState(1);
			}

			if (loginState == 1) {
				if (null == class231.field2748) {
					class231.field2748 = class31.field169.method2723(class271.field3032, class454.currentPort);
				}

				if (class231.field2748.field1614 == 2) {
					throw new IOException();
				}

				if (class231.field2748.field1614 == 1) {
					Socket var30 = (Socket)class231.field2748.socket;
					BufferedNetworkSocket var31 = new BufferedNetworkSocket(var30, 40000, 5000);
					loginSocket = var31;
					serverConnection.method2097(var31);
					class231.field2748 = null;
					class43.setLoginState(2);
				}
			}

			PacketMessage packetMessage;
			if (2 == loginState) {
				serverConnection.reset();
				packetMessage = PacketMessage.create();
				packetMessage.buffer.writeByte(LoginType.field2976.id);
				serverConnection.add(packetMessage);
				serverConnection.flush();
				packetBuf.offset = 0;
				class43.setLoginState(3);
			}

			int status;
			if (3 == loginState) {
				if (class91.field886 != null) {
					class91.field886.method378();
				}

				if (null != class88.field794) {
					class88.field794.method378();
				}

				if (((AbstractSocket)loginSocket).method7254(1)) {
					status = ((AbstractSocket)loginSocket).readUnsignedByte();
					if (class91.field886 != null) {
						class91.field886.method378();
					}

					if (class88.field794 != null) {
						class88.field794.method378();
					}

					if (status != 0) {
						class112.loginError(status);
						return;
					}

					packetBuf.offset = 0;
					class43.setLoginState(4);
				}
			}

			if (loginState == 4) {
				if (packetBuf.offset < 8) {
					status = ((AbstractSocket)loginSocket).available();
					if (status > 8 - packetBuf.offset) {
						status = 8 - packetBuf.offset;
					}

					if (status > 0) {
						((AbstractSocket)loginSocket).read(packetBuf.data, packetBuf.offset, status);
						packetBuf.offset += status;
					}
				}

				if (8 == packetBuf.offset) {
					packetBuf.offset = 0;
					class170.seed = packetBuf.readLong();
					class43.setLoginState(5);
				}
			}

			int usernameLength;
			int startOffset;
			int xteaBufStartOffset;
			if (5 == loginState) {
				serverConnection.buffer.offset = 0;
				serverConnection.reset();
				PacketBuffer rsaBuf = new PacketBuffer(500);
				int[] xteaKeys = new int[]{class147.isaacRandom.nextInt(), class147.isaacRandom.nextInt(), class147.isaacRandom.nextInt(), class147.isaacRandom.nextInt()};
				rsaBuf.offset = 0;
				rsaBuf.writeByte(1);
				rsaBuf.writeInt(xteaKeys[0]);
				rsaBuf.writeInt(xteaKeys[1]);
				rsaBuf.writeInt(xteaKeys[2]);
				rsaBuf.writeInt(xteaKeys[3]);
				rsaBuf.writeLong(class170.seed);
				int i;
				if (40 == gameState) {
					rsaBuf.writeInt(class119.reconnectXteas[0]);
					rsaBuf.writeInt(class119.reconnectXteas[1]);
					rsaBuf.writeInt(class119.reconnectXteas[2]);
					rsaBuf.writeInt(class119.reconnectXteas[3]);
				} else {
					if (gameState == 50) {
						rsaBuf.writeByte(class141.field1304.rsOrdinal());
						rsaBuf.writeInt(class158.field1451);
					} else {
						rsaBuf.writeByte(field1671.rsOrdinal());
						switch(field1671.field1305) {
						case 0:
							LinkedHashMap params = class413.clientPreferences.parameters;
							String username = Login.username;
							usernameLength = username.length();
							int curCharIndex = 0;

							for (i = 0; i < usernameLength; ++i) {
								curCharIndex = (curCharIndex << 5) - curCharIndex + username.charAt(i);
							}

							rsaBuf.writeInt((Integer)params.get(curCharIndex));
							break;
						case 1:
						case 3:
							rsaBuf.writeMedium(class340.field4220);
							++rsaBuf.offset;
						case 2:
						default:
							break;
						case 4:
							rsaBuf.offset += 4;
						}
					}

					if (field1758.method7938()) {
						rsaBuf.writeByte(class445.field4787.rsOrdinal());
						rsaBuf.writeString(this.field1673);
					} else {
						rsaBuf.writeByte(class445.field4791.rsOrdinal());
						rsaBuf.writeString(Login.password);
					}
				}

				rsaBuf.encryptRSA(class62.exponent, class62.modulus);
				class119.reconnectXteas = xteaKeys;
				PacketMessage buf = PacketMessage.create();
				buf.buffer.offset = 0;
				if (gameState == 40) {
					buf.buffer.writeByte(LoginType.RECONNECT.id);
				} else {
					buf.buffer.writeByte(LoginType.NORMAL.id);
				}

				buf.buffer.writeShort(0);
				startOffset = buf.buffer.offset;
				buf.buffer.writeInt(209);
				buf.buffer.writeInt(1);
				buf.buffer.writeByte(clientType);
				buf.buffer.writeByte(field1716);
				buf.buffer.writeByte((byte) 0);
				buf.buffer.writeBytes(rsaBuf.data, 0, rsaBuf.offset);
				xteaBufStartOffset = buf.buffer.offset;
				buf.buffer.writeString(Login.username);
				buf.buffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				buf.buffer.writeShort(class31.canvasWidth);
				buf.buffer.writeShort(class12.canvasHeight);
				class296.writeRandomBytes(buf.buffer);
				buf.buffer.writeString(class61.field481);
				buf.buffer.writeInt(class11.field45);
				Buffer platformInfoBuf = new Buffer(MoveSpeed.platformInfo.size());
				MoveSpeed.platformInfo.write(platformInfoBuf);
				buf.buffer.writeBytes(platformInfoBuf.data, 0, platformInfoBuf.data.length);
				buf.buffer.writeByte(clientType);
				buf.buffer.writeInt(0);
				buf.buffer.writeIntAlt(class136.field1275.field3746);
				buf.buffer.writeInt(class174.field1564.field3746);
				buf.buffer.writeIntLEAlt(class304.field3634.field3746);
				buf.buffer.writeInt(class155.field1425.field3746);
				buf.buffer.writeIntAlt(class58.cache_regionMaps.field3746);
				buf.buffer.writeIntLEAlt(0);
				buf.buffer.writeIntLE(MouseManager.field295.field3746);
				buf.buffer.writeIntLEAlt(class147.field1352.field3746);
				buf.buffer.writeInt(class243.field2846.field3746);
				buf.buffer.writeIntAlt(class139.field1286.field3746);
				buf.buffer.writeIntLE(class324.field3783.field3746);
				buf.buffer.writeIntAlt(class43.field311.field3746);
				buf.buffer.writeIntLEAlt(class333.field3859.field3746);
				buf.buffer.writeIntLE(ProofOfWorkRequest.field12.field3746);
				buf.buffer.writeIntLEAlt(class252.field2922.field3746);
				buf.buffer.writeInt(field1665.field3746);
				buf.buffer.writeIntLE(class71.field578.field3746);
				buf.buffer.writeIntLE(class371.field4369.field3746);
				buf.buffer.writeIntLEAlt(class145.field1338.field3746);
				buf.buffer.writeInt(class11.field48.field3746);
				buf.buffer.writeIntLE(class202.field2255.field3746);
				buf.buffer.encryptXTEA(xteaKeys, xteaBufStartOffset, buf.buffer.offset);
				buf.buffer.writeLengthShort(buf.buffer.offset - startOffset);
				serverConnection.add(buf);
				serverConnection.flush();
				serverConnection.isaacRandom = new IsaacRandom(xteaKeys);
				int[] readerXteaKeys = new int[4];

				for (i = 0; i < 4; ++i) {
					readerXteaKeys[i] = 50 + xteaKeys[i];
				}

				packetBuf.initIsaacRandom(readerXteaKeys);
				class43.setLoginState(6);
			}

			int remainingBytes;
			if (loginState == 6 && ((AbstractSocket)loginSocket).available() > 0) {
				status = ((AbstractSocket)loginSocket).readUnsignedByte();
				if (status == 61) {
					remainingBytes = ((AbstractSocket)loginSocket).available();
					class87.field781 = remainingBytes == 1 && ((AbstractSocket)loginSocket).readUnsignedByte() == 1;
					class43.setLoginState(5);
				}

				if (status == 21 && gameState == 20) {
					class43.setLoginState(12);
				} else if (status == 2) {
					class43.setLoginState(14);
				} else if (status == 15 && 40 == gameState) {
					serverConnection.serverPacketLength = -1;
					class43.setLoginState(19);
				} else if (status == 64) {
					class43.setLoginState(10);
				} else if (status == 23 && loginErrorCount < 1) {
					++loginErrorCount;
					class43.setLoginState(0);
				} else if (status == 29) {
					class43.setLoginState(17);
				} else {
					if (status != 69) {
						class112.loginError(status);
						return;
					}

					class43.setLoginState(7);
				}
			}

			if (loginState == 7 && ((AbstractSocket)loginSocket).available() >= 2) {
				((AbstractSocket)loginSocket).read(packetBuf.data, 0, 2);
				packetBuf.offset = 0;
				class77.loginProofOfWorkSize = packetBuf.readUnsignedShort();
				class43.setLoginState(8);
			}

			if (loginState == 8 && ((AbstractSocket)loginSocket).available() >= class77.loginProofOfWorkSize) {
				packetBuf.offset = 0;
				((AbstractSocket)loginSocket).read(packetBuf.data, packetBuf.offset, class77.loginProofOfWorkSize);
				class25[] bruteforcerSomethingType = new class25[]{class25.SHA256};
				class25 var35 = bruteforcerSomethingType[packetBuf.readUnsignedByte()];

				try {
					ProofOfWorkMessage var37 = class8.getPowChallengeType(var35);
					this.powRequest = new ProofOfWorkRequest(packetBuf, var37);
					class43.setLoginState(9);
				} catch (Exception var22) {
					class112.loginError(22);
					return;
				}
			}

			if (9 == loginState && this.powRequest.method17()) {
				this.powResponseBuf = this.powRequest.method19();
				this.powRequest.destroy();
				this.powRequest = null;
				if (null == this.powResponseBuf) {
					class112.loginError(22);
					return;
				}

				serverConnection.reset();
				packetMessage = PacketMessage.create();
				packetMessage.buffer.writeByte(LoginType.PROOF_OF_WORK.id);
				packetMessage.buffer.writeShort(this.powResponseBuf.offset);
				packetMessage.buffer.writeBytes(this.powResponseBuf);
				serverConnection.add(packetMessage);
				serverConnection.flush();
				this.powResponseBuf = null;
				class43.setLoginState(6);
			}

			if (loginState == 10 && ((AbstractSocket)loginSocket).available() > 0) {
				class195.loginRetryLength = ((AbstractSocket)loginSocket).readUnsignedByte();
				class43.setLoginState(11);
			}

			if (loginState == 11 && ((AbstractSocket)loginSocket).available() >= class195.loginRetryLength) {
				((AbstractSocket)loginSocket).read(packetBuf.data, 0, class195.loginRetryLength);
				packetBuf.offset = 0;
				class43.setLoginState(6);
			}

			if (loginState == 12 && ((AbstractSocket)loginSocket).available() > 0) {
				loginWaitSeconds = (((AbstractSocket)loginSocket).readUnsignedByte() + 3) * 60;
				class43.setLoginState(13);
			}

			if (loginState == 13) {
				loginTicks = 0;
				Login.setLoginResponseString(class338.Str_YouJustLeftAnotherWorld, class338.Str_YourProfileWillBeTransferedIn, loginWaitSeconds / 60 + class338.Str_Seconds);
				if (--loginWaitSeconds <= 0) {
					class43.setLoginState(0);
				}

			} else {
				if (14 == loginState && ((AbstractSocket)loginSocket).available() >= 1) {
					class77.loginAuthWaitLength = ((AbstractSocket)loginSocket).readUnsignedByte();
					class43.setLoginState(15);
				}

				if (loginState == 15 && ((AbstractSocket)loginSocket).available() >= class77.loginAuthWaitLength) {
					boolean var47 = ((AbstractSocket)loginSocket).readUnsignedByte() == 1;
					((AbstractSocket)loginSocket).read(packetBuf.data, 0, 4);
					packetBuf.offset = 0;
					boolean var48 = false;
					if (var47) {
						int authCode;
						authCode = packetBuf.readByteIsaac() << 24;
						authCode |= packetBuf.readByteIsaac() << 16;
						authCode |= packetBuf.readByteIsaac() << 8;
						authCode |= packetBuf.readByteIsaac();
						String username = Login.username;
						int usernameLength2 = username.length();
						xteaBufStartOffset = 0;
						usernameLength = 0;

						while (true) {
							if (usernameLength >= usernameLength2) {
								if (class413.clientPreferences.parameters.size() >= 10 && !class413.clientPreferences.parameters.containsKey(xteaBufStartOffset)) {
									Iterator itr = class413.clientPreferences.parameters.entrySet().iterator();
									itr.next();
									itr.remove();
								}

								class413.clientPreferences.parameters.put(xteaBufStartOffset, authCode);
								break;
							}

							xteaBufStartOffset = (xteaBufStartOffset << 5) - xteaBufStartOffset + username.charAt(usernameLength);
							++usernameLength;
						}
					}

					if (isUsernameRemembered) {
						class413.clientPreferences.setRememberedUsername(Login.username);
					} else {
						class413.clientPreferences.setRememberedUsername(null);
					}

					ClientPreferences.savePreferences();
					privilegeLevel = ((AbstractSocket)loginSocket).readUnsignedByte();
					isPlayerMod = ((AbstractSocket)loginSocket).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)loginSocket).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)loginSocket).readUnsignedByte();
					isMember = ((AbstractSocket)loginSocket).readUnsignedByte();
					((AbstractSocket)loginSocket).read(packetBuf.data, 0, 8);
					packetBuf.offset = 0;
					this.seed = packetBuf.readLong();
					if (class77.loginAuthWaitLength >= 29) {
						((AbstractSocket)loginSocket).read(packetBuf.data, 0, 8);
						packetBuf.offset = 0;
						playerUUID = packetBuf.readLong();
					}

					((AbstractSocket)loginSocket).read(packetBuf.data, 0, 1);
					packetBuf.offset = 0;
					ServerPacket[] serverPackets = ServerPacket.values();
					int opcode = packetBuf.readPacketOpcode();
					if (opcode < 0 || opcode >= serverPackets.length) {
						throw new IOException(opcode + " " + packetBuf.offset);
					}

					serverConnection.serverPacket = serverPackets[opcode];
					serverConnection.serverPacketLength = serverConnection.serverPacket.length;
					((AbstractSocket)loginSocket).read(packetBuf.data, 0, 2);
					packetBuf.offset = 0;
					serverConnection.serverPacketLength = packetBuf.readUnsignedShort();

					try {
						class40.method756(class133.field1257, "zap");
					} catch (Throwable var21) {
					}

					class43.setLoginState(16);
				}

				if (loginState != 16) {
					if (17 == loginState && ((AbstractSocket)loginSocket).available() >= 2) {
						packetBuf.offset = 0;
						((AbstractSocket)loginSocket).read(packetBuf.data, 0, 2);
						packetBuf.offset = 0;
						class135.field1268 = packetBuf.readUnsignedShort();
						class43.setLoginState(18);
					}

					if (loginState == 18 && ((AbstractSocket)loginSocket).available() >= class135.field1268) {
						packetBuf.offset = 0;
						((AbstractSocket)loginSocket).read(packetBuf.data, 0, class135.field1268);
						packetBuf.offset = 0;
						String msg1 = packetBuf.readString();
						String msg2 = packetBuf.readString();
						String msg3 = packetBuf.readString();
						Login.setLoginResponseString(msg1, msg2, msg3);
						class9.method64(10);
						if (field1758.method7938()) {
							class74.method1490(9);
						}
					}

					if (19 == loginState) {
						if (-1 == serverConnection.serverPacketLength) {
							if (((AbstractSocket)loginSocket).available() < 2) {
								return;
							}

							((AbstractSocket)loginSocket).read(packetBuf.data, 0, 2);
							packetBuf.offset = 0;
							serverConnection.serverPacketLength = packetBuf.readUnsignedShort();
						}

						if (((AbstractSocket)loginSocket).available() >= serverConnection.serverPacketLength) {
							((AbstractSocket)loginSocket).read(packetBuf.data, 0, serverConnection.serverPacketLength);
							packetBuf.offset = 0;
							int length = serverConnection.serverPacketLength;
							timer.start();
							class228.resetWorld();
							PlayerManager.updateGPI(packetBuf);
							if (length != packetBuf.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++loginTicks;
						if (loginTicks > 2000) {
							if (loginErrorCount < 1) {
								if (class180.worldPort == class454.currentPort) {
									class454.currentPort = class141.js5Port;
								} else {
									class454.currentPort = class180.worldPort;
								}

								++loginErrorCount;
								class43.setLoginState(0);
							} else {
								class112.loginError(-3);
							}
						}
					}
				} else {
					if (((AbstractSocket)loginSocket).available() >= serverConnection.serverPacketLength) {
						packetBuf.offset = 0;
						((AbstractSocket)loginSocket).read(packetBuf.data, 0, serverConnection.serverPacketLength);
						timer.pause();
						mouseLastPressedTimeMillis = -1L;
						class74.mouseRecorder.index = 0;
						class71.isFocused = true;
						isFocused = true;
						field1881 = -1L;
						class45.method333();
						serverConnection.reset();
						serverConnection.buffer.offset = 0;
						serverConnection.serverPacket = null;
						serverConnection.field1079 = null;
						serverConnection.field1072 = null;
						serverConnection.field1080 = null;
						serverConnection.serverPacketLength = 0;
						serverConnection.field1070 = 0;
						rebootTimer = 0;
						logoutTimer = 0;
						hintArrowType = 0;
						menuOptionsCount = 0;
						isMenuOpen = false;
						MouseManager.idleTicks = 0;
						MessagesManager.channels.clear();
						MessagesManager.hashTable.clear();
						MessagesManager.queue.clear();
						MessagesManager.count = 0;
						isItemSelected = 0;
						isSpellSelected = false;
						soundEffectCount = 0;
						field1672 = 0;
						field1722 = 0;
						class335.field3867 = null;
						minimapState = 0;
						field1662 = -1;
						destinationX = 0;
						destinationY = 0;
						playerAttackOption = AttackOption.HIDDEN;
						npcAttackOption = AttackOption.HIDDEN;
						npcCount = 0;
						PlayerManager.localPlayerCount = 0;

						for (int i = 0; i < 2048; ++i) {
							PlayerManager.cachedAppearanceData[i] = null;
							PlayerManager.moveSpeeds[i] = MoveSpeed.field2114;
						}

						for (int i = 0; i < 2048; ++i) {
							localPlayers[i] = null;
						}

						for (int i = 0; i < 65536; ++i) {
							npcs[i] = null;
						}

						combatTargetPlayerIndex = -1;
						projectiles.clear();
						graphics.clear();

						for (int level = 0; level < 4; ++level) {
							for (int x = 0; x < 104; ++x) {
								for (int y = 0; y < 104; ++y) {
									groundItems[level][x][y] = null;
								}
							}
						}

						pendingSpawns = new NodeDeque();
						class217.friends.clear();

						for (status = 0; status < class178.field1592; ++status) {
							class178 var38 = ClientPacket.method5221(status);
							if (var38 != null) {
								class293.field3368[status] = 0;
								class293.field3370[status] = 0;
							}
						}

						class66.varcs.clear();
						followerIndex = -1;
						if (rootInterface != -1) {
							class257.method5138(rootInterface);
						}

						for (InterfaceParent interf = (InterfaceParent) parentInterfaces.first(); null != interf; interf = (InterfaceParent) parentInterfaces.next()) {
							ProofOfWorkRequest.closeInterface(interf, true);
						}

						rootInterface = -1;
						parentInterfaces = new NodeHashTable(8);
						field1641 = null;
						menuOptionsCount = 0;
						isMenuOpen = false;
						playerAppearance.method5998((int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

						for (status = 0; status < 8; ++status) {
							playerMenuActions[status] = null;
							playerOptionsPriorities[status] = false;
						}

						class87.method2410();
						isLoading = true;

						for (status = 0; status < 100; ++status) {
							field1860[status] = true;
						}

						method206();
						class73.field603 = null;
						class127.field1224 = null;
						Arrays.fill(field1738, (Object)null);
						class188.field1982 = null;
						Arrays.fill(field1883, (Object)null);

						for (status = 0; status < 8; ++status) {
							field1924[status] = new class347();
						}

						class242.field2835 = null;
						PlayerManager.updateGPI(packetBuf);
						class361.field4314 = -1;
						class25.rebuildRegion(false, packetBuf);
						serverConnection.serverPacket = null;
					}

				}
			}
		} catch (IOException var27) {
			if (loginErrorCount < 1) {
				if (class180.worldPort == class454.currentPort) {
					class454.currentPort = class141.js5Port;
				} else {
					class454.currentPort = class180.worldPort;
				}

				++loginErrorCount;
				class43.setLoginState(0);
			} else {
				class112.loginError(-2);
			}
		}
	}

	static long getPlayerUUID() {
		return playerUUID;
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
		PlayerModel.method3577();
		class300.method5845();
		((class215)class221.field2629).method4312();
		class78.field675.method5437();
		class139.field1286.method6117();
		MouseManager.field295.method6117();
		class333.field3859.method6117();
		class11.field48.method6117();
		class58.cache_regionMaps.method6117();
		class43.field311.method6117();
		class252.field2922.method6117();
		class155.field1425.method6117();
		field1665.method6117();
		class243.field2846.method6117();
		ProofOfWorkRequest.field12.method6117();
		class202.field2255.method6117();
		class255.field2944.method6117();
	}

	static final void method4611() {
		if (logoutTimer > 0) {
			class368.method6731();
		} else {
			timer.method6830();
			class9.method64(40);
			class218.field2589 = serverConnection.method2082();
			serverConnection.method2100();
		}
	}

	final void cycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field1697) {
			field1697 = false;
			method4611();
		} else {
			if (!isMenuOpen) {
				method5557();
			}

			int var2;
			for (var2 = 0; var2 < 100 && this.method2888(serverConnection); ++var2) {
			}

			if (30 == gameState) {
				while (true) {
					class43 var3 = (class43)class45.field329.method6465();
					boolean var30;
					if (var3 == null) {
						var30 = false;
					} else {
						var30 = true;
					}

					int sceneX;
					PacketMessage var31;
					if (!var30) {
						PacketMessage var15;
						int var16;
						if (timer.field4413) {
							var15 = class185.create(ClientPacket.field3066, serverConnection.isaacRandom);
							var15.buffer.writeByte(0);
							var16 = var15.buffer.offset;
							timer.method6834(var15.buffer);
							var15.buffer.method8151(var15.buffer.offset - var16);
							serverConnection.add(var15);
							timer.method6832();
						}

						int sceneY;
						int var6;
						int var7;
						int var8;
						int var9;
						int var10;
						int var11;
						int var12;
						int var13;
						synchronized(class74.mouseRecorder.field755) {
							if (!field1660) {
								class74.mouseRecorder.index = 0;
							} else if (0 != MouseManager.field277 || class74.mouseRecorder.index >= 40) {
								var31 = null;
								sceneX = 0;
								sceneY = 0;
								var6 = 0;
								var7 = 0;

								for (var8 = 0; var8 < class74.mouseRecorder.index && (null == var31 || var31.buffer.offset - sceneX < 246); ++var8) {
									sceneY = var8;
									var9 = class74.mouseRecorder.field750[var8];
									if (var9 < -1) {
										var9 = -1;
									} else if (var9 > 65534) {
										var9 = 65534;
									}

									var10 = class74.mouseRecorder.field748[var8];
									if (var10 < -1) {
										var10 = -1;
									} else if (var10 > 65534) {
										var10 = 65534;
									}

									if (field1647 != var10 || field1773 != var9) {
										if (var31 == null) {
											var31 = class185.create(ClientPacket.field3118, serverConnection.isaacRandom);
											var31.buffer.writeByte(0);
											sceneX = var31.buffer.offset;
											PacketBuffer var10000 = var31.buffer;
											var10000.offset += 2;
											var6 = 0;
											var7 = 0;
										}

										if (-1L != field1644) {
											var11 = var10 - field1647;
											var12 = var9 - field1773;
											var13 = (int)((class74.mouseRecorder.field754[var8] - field1644) / 20L);
											var6 = (int)((long)var6 + (class74.mouseRecorder.field754[var8] - field1644) % 20L);
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
											var31.buffer.writeShort((var11 << 6) + (var13 << 12) + var12);
										} else if (var13 < 32 && var11 >= -128 && var11 <= 127 && var12 >= -128 && var12 <= 127) {
											var11 += 128;
											var12 += 128;
											var31.buffer.writeByte(var13 + 128);
											var31.buffer.writeShort((var11 << 8) + var12);
										} else if (var13 < 32) {
											var31.buffer.writeByte(var13 + 192);
											if (var10 != -1 && var9 != -1) {
												var31.buffer.writeInt(var10 | var9 << 16);
											} else {
												var31.buffer.writeInt(Integer.MIN_VALUE);
											}
										} else {
											var31.buffer.writeShort((var13 & 8191) + 57344);
											if (var10 != -1 && var9 != -1) {
												var31.buffer.writeInt(var10 | var9 << 16);
											} else {
												var31.buffer.writeInt(Integer.MIN_VALUE);
											}
										}

										++var7;
										field1644 = class74.mouseRecorder.field754[var8];
									}
								}

								if (var31 != null) {
									var31.buffer.method8151(var31.buffer.offset - sceneX);
									var8 = var31.buffer.offset;
									var31.buffer.offset = sceneX;
									var31.buffer.writeByte(var6 / var7);
									var31.buffer.writeByte(var6 % var7);
									var31.buffer.offset = var8;
									serverConnection.add(var31);
								}

								if (sceneY >= class74.mouseRecorder.index) {
									class74.mouseRecorder.index = 0;
								} else {
									class84 var56 = class74.mouseRecorder;
									var56.index -= sceneY;
									System.arraycopy(class74.mouseRecorder.field748, sceneY, class74.mouseRecorder.field748, 0, class74.mouseRecorder.index);
									System.arraycopy(class74.mouseRecorder.field750, sceneY, class74.mouseRecorder.field750, 0, class74.mouseRecorder.index);
									System.arraycopy(class74.mouseRecorder.field754, sceneY, class74.mouseRecorder.field754, 0, class74.mouseRecorder.index);
								}
							}
						}

						if (MouseManager.field277 == 1 || !class95.field944 && MouseManager.field277 == 4 || MouseManager.field277 == 2) {
							long var17 = MouseManager.field279 - mouseLastPressedTimeMillis;
							if (var17 > 32767L) {
								var17 = 32767L;
							}

							mouseLastPressedTimeMillis = MouseManager.field279;
							sceneX = MouseManager.lastPressedY;
							if (sceneX < 0) {
								sceneX = 0;
							} else if (sceneX > class12.canvasHeight) {
								sceneX = class12.canvasHeight;
							}

							sceneY = MouseManager.lastPressedX;
							if (sceneY < 0) {
								sceneY = 0;
							} else if (sceneY > class31.canvasWidth) {
								sceneY = class31.canvasWidth;
							}

							var6 = (int)var17;
							PacketMessage var19 = class185.create(ClientPacket.field3094, serverConnection.isaacRandom);
							var19.buffer.writeShort((var6 << 1) + (MouseManager.field277 == 2 ? 1 : 0));
							var19.buffer.writeShort(sceneY);
							var19.buffer.writeShort(sceneX);
							serverConnection.add(var19);
						}

						if (keyHandler.field2312 > 0) {
							var15 = class185.create(ClientPacket.field3047, serverConnection.isaacRandom);
							var15.buffer.writeShort(0);
							var16 = var15.buffer.offset;
							long var20 = class272.method2046();

							for (var6 = 0; var6 < keyHandler.field2312; ++var6) {
								long var22 = var20 - field1881;
								if (var22 > 16777215L) {
									var22 = 16777215L;
								}

								field1881 = var20;
								var15.buffer.method8167((int)var22);
								var15.buffer.writeByteSUB(keyHandler.field2311[var6]);
							}

							var15.buffer.writeLengthShort(var15.buffer.offset - var16);
							serverConnection.add(var15);
						}

						if (field1922 > 0) {
							--field1922;
						}

						if (keyHandler.isKeyDown(96) || keyHandler.isKeyDown(97) || keyHandler.isKeyDown(98) || keyHandler.isKeyDown(99)) {
							field1732 = true;
						}

						if (field1732 && field1922 <= 0) {
							field1922 = 20;
							field1732 = false;
							var15 = class185.create(ClientPacket.field3077, serverConnection.isaacRandom);
							var15.buffer.writeShort(field1761);
							var15.buffer.writeShortLE(field1672);
							serverConnection.add(var15);
						}

						if (class71.isFocused && !isFocused) {
							isFocused = true;
							var15 = class185.create(ClientPacket.field3059, serverConnection.isaacRandom);
							var15.buffer.writeByte(1);
							serverConnection.add(var15);
						}

						if (!class71.isFocused && isFocused) {
							isFocused = false;
							var15 = class185.create(ClientPacket.field3059, serverConnection.isaacRandom);
							var15.buffer.writeByte(0);
							serverConnection.add(var15);
						}

						if (null != ProofOfWorkRequest.field10) {
							ProofOfWorkRequest.field10.method7575();
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

						if (30 != gameState) {
							return;
						}

						for (class101 var39 = (class101) pendingSpawns.method6364(); var39 != null; var39 = (class101) pendingSpawns.method6358()) {
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
						for (var2 = 0; var2 < soundEffectCount; ++var2) {
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
										sceneY = (field1734[var2] & 255) * 128;
										var6 = field1734[var2] >> 16 & 255;
										var7 = var6 * 128 + 64 - class291.localPlayer.field827;
										if (var7 < 0) {
											var7 = -var7;
										}

										var8 = field1734[var2] >> 8 & 255;
										var9 = 64 + var8 * 128 - class291.localPlayer.field802;
										if (var9 < 0) {
											var9 = -var9;
										}

										var10 = var9 + var7 - 128;
										if (var10 > sceneY) {
											field1897[var2] = -100;
											continue;
										}

										if (var10 < 0) {
											var10 = 0;
										}

										sceneX = (sceneY - var10) * class413.clientPreferences.method1736() / sceneY;
									} else {
										sceneX = class413.clientPreferences.method1752();
									}

									if (sceneX > 0) {
										class39 var24 = var32.method605().method752(class233.field2759);
										class44 var25 = class44.method829(var24, 100, sceneX);
										var25.method813(field1896[var2] - 1);
										class451.field4849.method718(var25);
									}

									field1897[var2] = -100;
								}
							} else {
								--soundEffectCount;

								for (var16 = var2; var16 < soundEffectCount; ++var16) {
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
								if (class413.clientPreferences.method1716() != 0 && -1 != field1748) {
									class279.method332(class43.field311, field1748, 0, class413.clientPreferences.method1716(), false);
								}

								field1781 = false;
							}
						}

						++serverConnection.field1070;
						if (serverConnection.field1070 > 750) {
							method4611();
							return;
						}

						var2 = PlayerManager.localPlayerCount;
						int[] var33 = PlayerManager.localPlayerIndexes;

						for (sceneX = 0; sceneX < var2; ++sceneX) {
							PlayerEntity var43 = localPlayers[var33[sceneX]];
							if (var43 != null) {
								class25.method341(var43, 1);
							}
						}

						for (var2 = 0; var2 < npcCount; ++var2) {
							var16 = field1692[var2];
							class81 var26 = npcs[var16];
							if (var26 != null) {
								class25.method341(var26, var26.field709.field2262);
							}
						}

						int[] var40 = PlayerManager.localPlayerIndexes;

						for (var16 = 0; var16 < PlayerManager.localPlayerCount; ++var16) {
							PlayerEntity var49 = localPlayers[var40[var16]];
							if (null != var49 && var49.field843 > 0) {
								--var49.field843;
								if (0 == var49.field843) {
									var49.field822 = null;
								}
							}
						}

						for (var16 = 0; var16 < npcCount; ++var16) {
							sceneX = field1692[var16];
							class81 var44 = npcs[sceneX];
							if (var44 != null && var44.field843 > 0) {
								--var44.field843;
								if (0 == var44.field843) {
									var44.field822 = null;
								}
							}
						}

						++field1701;
						if (mouseCrossColor != 0) {
							mouseCrossState += 20;
							if (mouseCrossState >= 400) {
								mouseCrossColor = 0;
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

						while (keyHandler.method3911() && field1822 < 128) {
							if (privilegeLevel >= 2 && keyHandler.isKeyDown(82) && keyHandler.field2317 == 66) {
								StringBuilder var45 = new StringBuilder();

								class63 var42;
								for (Iterator var46 = MessagesManager.hashTable.iterator(); var46.hasNext(); var45.append(var42.field503).append('\n')) {
									var42 = (class63)var46.next();
									if (var42.field500 != null && !var42.field500.isEmpty()) {
										var45.append(var42.field500).append(':');
									}
								}

								String var50 = var45.toString();
								class133.field1257.method463(var50);
							} else if (1 != field1722 || keyHandler.field2321 <= 0) {
								field1880[field1822] = keyHandler.field2317;
								field1756[field1822] = keyHandler.field2321;
								++field1822;
							}
						}

						if (class114.method2218() && keyHandler.isKeyDown(82) && keyHandler.isKeyDown(81) && field1639 != 0) {
							sceneX = class291.localPlayer.field914 - field1639;
							if (sceneX < 0) {
								sceneX = 0;
							} else if (sceneX > 3) {
								sceneX = 3;
							}

							if (class291.localPlayer.field914 != sceneX) {
								class136.method2439(class291.localPlayer.field861[0] + class36.sceneBaseX, class169.sceneBaseY + class291.localPlayer.field873[0], sceneX, false);
							}

							field1639 = 0;
						}

						if (1 == MouseManager.field277) {
							field1877.method3521();
						}

						if (-1 != rootInterface) {
							method5127(rootInterface, 0, 0, class31.canvasWidth, class12.canvasHeight, 0, 0);
						}

						++field1878;

						while (true) {
							class300 var47;
							class300 var48;
							ClientScript var52;
							do {
								var52 = (ClientScript)field1854.method6375();
								if (null == var52) {
									while (true) {
										do {
											var52 = (ClientScript)field1813.method6375();
											if (null == var52) {
												while (true) {
													do {
														var52 = (ClientScript)field1765.method6375();
														if (null == var52) {
															while (true) {
																class188 var54 = (class188)field1856.method6375();
																if (var54 == null) {
																	this.method2889();
																	class260.method5145();
																	if (field1874 != null) {
																		this.method2894();
																	}

																	PacketMessage var27;
																	if (class183.field1943 != null) {
																		class136.method2438(class183.field1943);
																		++field1786;
																		if (MouseManager.field289 == 0) {
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

																					var27 = class185.create(ClientPacket.field3100, serverConnection.isaacRandom);
																					var27.buffer.writeIntLEAlt(class183.field1943.field3517);
																					var27.buffer.writeByteSUB(var35);
																					var27.buffer.writeShortLEADD(field1737);
																					var27.buffer.writeShort(field1892);
																					serverConnection.add(var27);
																				}
																			} else if (this.method2890()) {
																				this.method3357(field1638, field1757);
																			} else if (menuOptionsCount > 0) {
																				sceneX = field1638;
																				sceneY = field1757;
																				class73 var51 = class101.field1005;
																				if (null != var51) {
																					PacketMessage.method5159(var51.field600, var51.field595, var51.field594, var51.field597, var51.field598, var51.field599, var51.field604, sceneX, sceneY);
																				}

																				class101.field1005 = null;
																			}

																			field1840 = 10;
																			MouseManager.field277 = 0;
																			class183.field1943 = null;
																		} else if (field1786 >= 5 && (MouseManager.field284 > field1638 + 5 || MouseManager.field284 < field1638 - 5 || MouseManager.field285 > field1757 + 5 || MouseManager.field285 < field1757 - 5)) {
																			field1759 = true;
																		}
																	}

																	if (Scene.shouldSendMove()) {
																		sceneX = Scene.selectedSceneX;
																		sceneY = Scene.selectedSceneY;
																		PacketMessage clientPacket = class185.create(ClientPacket.MOVE_GAMECLICK, serverConnection.isaacRandom);
																		clientPacket.buffer.writeByte(5);
																		clientPacket.buffer.writeShortLEADD(class169.sceneBaseY + sceneY);
																		clientPacket.buffer.writeByteNEG(keyHandler.isKeyDown(82) ? (keyHandler.isKeyDown(81) ? 2 : 1) : 0);
																		clientPacket.buffer.writeShortADD(sceneX + class36.sceneBaseX);
																		serverConnection.add(clientPacket);
																		Scene.method4162();
																		mouseCrossX = MouseManager.lastPressedX;
																		mouseCrossY = MouseManager.lastPressedY;
																		mouseCrossColor = 1;
																		mouseCrossState = 0;
																		destinationX = sceneX;
																		destinationY = sceneY;
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
																		sceneX = class291.localPlayer.field827;
																		sceneY = class291.localPlayer.field802;
																		if (class32.field203 - sceneX < -500 || class32.field203 - sceneX > 500 || class101.field1004 - sceneY < -500 || class101.field1004 - sceneY > 500) {
																			class32.field203 = sceneX;
																			class101.field1004 = sceneY;
																		}

																		if (class32.field203 != sceneX) {
																			class32.field203 += (sceneX - class32.field203) / 16;
																		}

																		if (sceneY != class101.field1004) {
																			class101.field1004 += (sceneY - class101.field1004) / 16;
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

																		class178.field1595 = class144.method2498(class291.localPlayer.field827, class291.localPlayer.field802, class55.field396) - field1723;
																	} else if (field1722 == 1) {
																		class121.method2285();
																		short var38 = -1;
																		if (keyHandler.isKeyDown(33)) {
																			var38 = 0;
																		} else if (keyHandler.isKeyDown(49)) {
																			var38 = 1024;
																		}

																		if (keyHandler.isKeyDown(48)) {
																			if (var38 == 0) {
																				var38 = 1792;
																			} else if (var38 == 1024) {
																				var38 = 1280;
																			} else {
																				var38 = 1536;
																			}
																		} else if (keyHandler.isKeyDown(50)) {
																			if (var38 == 0) {
																				var38 = 256;
																			} else if (var38 == 1024) {
																				var38 = 768;
																			} else {
																				var38 = 512;
																			}
																		}

																		byte var37 = 0;
																		if (keyHandler.isKeyDown(35)) {
																			var37 = -1;
																		} else if (keyHandler.isKeyDown(51)) {
																			var37 = 1;
																		}

																		var6 = 0;
																		if (var38 >= 0 || var37 != 0) {
																			var6 = keyHandler.isKeyDown(81) ? field1767 : field1727;
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
																				sceneX = field1676 - class237.field2807 & 2047;
																				var8 = class221.field2644[sceneX];
																				var9 = class221.field2645[sceneX];
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

																		if (keyHandler.isKeyDown(13)) {
																			method202();
																		}
																	}

																	if (4 == MouseManager.field289 && class95.field944) {
																		sceneX = MouseManager.field285 - field1886;
																		field1719 = sceneX * 2;
																		field1886 = sceneX != -1 && sceneX != 1 ? (field1886 + MouseManager.field285) / 2 : MouseManager.field285;
																		sceneY = field1720 - MouseManager.field284;
																		field1718 = sceneY * 2;
																		field1720 = sceneY != -1 && sceneY != 1 ? (field1720 + MouseManager.field284) / 2 : MouseManager.field284;
																	} else {
																		if (keyHandler.isKeyDown(96)) {
																			field1718 += (-24 - field1718) / 2;
																		} else if (keyHandler.isKeyDown(97)) {
																			field1718 += (24 - field1718) / 2;
																		} else {
																			field1718 /= 2;
																		}

																		if (keyHandler.isKeyDown(98)) {
																			field1719 += (12 - field1719) / 2;
																		} else if (keyHandler.isKeyDown(99)) {
																			field1719 += (-12 - field1719) / 2;
																		} else {
																			field1719 /= 2;
																		}

																		field1886 = MouseManager.field285;
																		field1720 = MouseManager.field284;
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
																			MouseManager.field298 = 0;
																			class158.field1440 = 0;
																			class109.field1086 = 0;
																			class318.field3732 = 0;
																			class264.field2998 = 0;
																			class19.field96 = 0;
																			class244.field2859 = 0;
																		}
																	} else if (field1900) {
																		sceneX = class264.field2998 * 128 + 64;
																		sceneY = class19.field96 * 128 + 64;
																		var6 = class144.method2498(sceneX, sceneY, class55.field396) - class244.field2859;
																		class96.method1961(sceneX, var6, sceneY);
																		sceneX = 64 + class8.field34 * 128;
																		sceneY = 64 + class122.field1186 * 128;
																		var6 = class144.method2498(sceneX, sceneY, class55.field396) - class278.field3197;
																		var7 = sceneX - class215.field2568;
																		var8 = var6 - class32.field204;
																		var9 = sceneY - class323.field3766;
																		var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
																		var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.9490051269531D) & 2047;
																		var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.9490051269531D) & 2047;
																		class109.method2104(var11, var12);
																	}

																	for (sceneX = 0; sceneX < 5; ++sceneX) {
																		var10002 = field1906[sceneX]++;
																	}

																	class66.varcs.method2314();
																	sceneX = ++MouseManager.idleTicks - 1;
																	var6 = class31.field198.method671();
																	if (sceneX > 15000 && var6 > 15000) {
																		logoutTimer = 250;
																		MouseManager.idleTicks = 14500;
																		var27 = class185.create(ClientPacket.field3127, serverConnection.isaacRandom);
																		serverConnection.add(var27);
																	}

																	class217.friends.method1047();
																	++serverConnection.field1077;
																	if (serverConnection.field1077 > 50) {
																		var27 = class185.create(ClientPacket.NO_TIMEOUT, serverConnection.isaacRandom);
																		serverConnection.add(var27);
																	}

																	try {
																		serverConnection.flush();
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

													class57.runClientScript(var52);
												}
											}

											var47 = var52.field694;
											if (var47.field3484 < 0) {
												break;
											}

											var48 = class282.method5426(var47.field3596);
										} while(null == var48 || var48.field3602 == null || var47.field3484 >= var48.field3602.length || var47 != var48.field3602[var47.field3484]);

										class57.runClientScript(var52);
									}
								}

								var47 = var52.field694;
								if (var47.field3484 < 0) {
									break;
								}

								var48 = class282.method5426(var47.field3596);
							} while(var48 == null || var48.field3602 == null || var47.field3484 >= var48.field3602.length || var48.field3602[var47.field3484] != var47);

							class57.runClientScript(var52);
						}
					}

					var31 = class185.create(ClientPacket.field3043, serverConnection.isaacRandom);
					var31.buffer.writeByte(0);
					sceneX = var31.buffer.offset;
					class88.method1865(var31.buffer);
					var31.buffer.method8151(var31.buffer.offset - sceneX);
					serverConnection.add(var31);
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
		PacketMessage var1 = class185.create(ClientPacket.field3101, serverConnection.isaacRandom);
		var1.buffer.writeByte(class2.method11());
		var1.buffer.writeShort(class31.canvasWidth);
		var1.buffer.writeShort(class12.canvasHeight);
		serverConnection.add(var1);
	}

	protected final void method599() {
		field1730 = class272.method2046() + 500L;
		this.method3069();
		if (rootInterface != -1) {
			this.method2892(true);
		}

	}

	void method3069() {
		int var2 = class31.canvasWidth;
		int var3 = class12.canvasHeight;
		if (super.field171 < var2) {
			var2 = super.field171;
		}

		if (super.field179 < var3) {
			var3 = super.field179;
		}

		if (class413.clientPreferences != null) {
			try {
				class40.method760(class133.field1257, "resize", new Object[]{class2.method11()});
			} catch (Throwable var5) {
			}
		}

	}

	final void method2885() {
		if (-1 != rootInterface) {
			class378.method6804(rootInterface);
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
		if (rootInterface != -1) {
			field1858 = 0;
			class41.method763(rootInterface, 0, 0, class31.canvasWidth, class12.canvasHeight, 0, 0, -1);
		}

		class481.method8715();
		if (field1752) {
			if (1 == mouseCrossColor) {
				class205.field2326[mouseCrossState / 100].method8526(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				class205.field2326[4 + mouseCrossState / 100].method8526(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		if (!isMenuOpen) {
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
			int var7 = MouseManager.field284;
			int var8 = MouseManager.field285;

			for (int var9 = 0; var9 < menuOptionsCount; ++var9) {
				int var10 = var3 + 31 + 15 * (menuOptionsCount - 1 - var9);
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

		class55.method1117(class55.field396, class291.localPlayer.field827, class291.localPlayer.field802, field1701);
		field1701 = 0;
	}

	public static NodeDeque method7851() {
		return field1765;
	}

	static boolean method6201() {
		return 0 != (field1768 & 4);
	}

	static final void method2451(class90 var0, int var1) {
		class230.method4536(var0.field827, var0.field802, var1);
	}

	boolean method2886(class107 var1, int var2) {
		if (var1.serverPacketLength == 0) {
			class73.field603 = null;
		} else {
			if (null == class73.field603) {
				class73.field603 = new class367(class234.gameEngineMode, class133.field1257);
			}

			class73.field603.method6705(var1.buffer, var2);
		}

		method6423();
		var1.serverPacket = null;
		return true;
	}

	boolean method2900(class107 var1) {
		if (class73.field603 != null) {
			class73.field603.method6706(var1.buffer);
		}

		method6423();
		var1.serverPacket = null;
		return true;
	}

	final boolean method2888(class107 connection) {
		AbstractSocket var3 = connection.method2082();
		PacketBuffer packetBuf = connection.buffer;
		if (null == var3) {
			return false;
		} else {
			String var22;
			int i;
			try {
				int var6;
				if (null == connection.serverPacket) {
					if (connection.field1067) {
						if (!var3.method7254(1)) {
							return false;
						}

						var3.read(connection.buffer.data, 0, 1);
						connection.field1070 = 0;
						connection.field1067 = false;
					}

					packetBuf.offset = 0;
					if (packetBuf.method8007()) {
						if (!var3.method7254(1)) {
							return false;
						}

						var3.read(connection.buffer.data, 1, 1);
						connection.field1070 = 0;
					}

					connection.field1067 = true;
					ServerPacket[] var5 = ServerPacket.values();
					var6 = packetBuf.readPacketOpcode();
					if (var6 < 0 || var6 >= var5.length) {
						throw new IOException(var6 + " " + packetBuf.offset);
					}

					connection.serverPacket = var5[var6];
					connection.serverPacketLength = connection.serverPacket.length;
				}

				if (connection.serverPacketLength == -1) {
					if (!var3.method7254(1)) {
						return false;
					}

					connection.method2082().read(packetBuf.data, 0, 1);
					connection.serverPacketLength = packetBuf.data[0] & 255;
				}

				if (-2 == connection.serverPacketLength) {
					if (!var3.method7254(2)) {
						return false;
					}

					connection.method2082().read(packetBuf.data, 0, 2);
					packetBuf.offset = 0;
					connection.serverPacketLength = packetBuf.readUnsignedShort();
				}

				if (!var3.method7254(connection.serverPacketLength)) {
					return false;
				}

				packetBuf.offset = 0;
				var3.read(packetBuf.data, 0, connection.serverPacketLength);
				connection.field1070 = 0;
				timer.method6829();
				connection.field1080 = connection.field1072;
				connection.field1072 = connection.field1079;
				connection.field1079 = connection.serverPacket;
				if (ServerPacket.field3219 == connection.serverPacket) {
					class342.method6352(class271.field3021);
					connection.serverPacket = null;
					return true;
				}

				class300 var7;
				int someVar;
				if (ServerPacket.field3225 == connection.serverPacket) {
					someVar = packetBuf.readIntIME();
					var6 = packetBuf.readUnsignedShortADD();
					var7 = class282.method5426(someVar);
					if (1 != var7.field3504 || var6 != var7.field3505) {
						var7.field3504 = 1;
						var7.field3505 = var6;
						class136.method2438(var7);
					}

					connection.serverPacket = null;
					return true;
				}

				String var53;
				if (connection.serverPacket == ServerPacket.field3253) {
					someVar = packetBuf.readUnsignedByteNeg();
					var6 = packetBuf.readUnsignedByteNeg();
					var53 = packetBuf.readString();
					if (var6 >= 1 && var6 <= 8) {
						if (var53.equalsIgnoreCase(class338.field3899)) {
							var53 = null;
						}

						playerMenuActions[var6 - 1] = var53;
						playerOptionsPriorities[var6 - 1] = someVar == 0;
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3265) {
					class7.field28 = packetBuf.readUnsignedByteNeg();
					class19.field98 = packetBuf.readUnsignedByteADD();

					for (someVar = class7.field28; someVar < 8 + class7.field28; ++someVar) {
						for (var6 = class19.field98; var6 < 8 + class19.field98; ++var6) {
							if (groundItems[class55.field396][someVar][var6] != null) {
								groundItems[class55.field396][someVar][var6] = null;
								class176.method2802(someVar, var6);
							}
						}
					}

					for (class101 var52 = (class101) pendingSpawns.method6364(); null != var52; var52 = (class101) pendingSpawns.method6358()) {
						if (var52.field999 >= class7.field28 && var52.field999 < 8 + class7.field28 && var52.field994 >= class19.field98 && var52.field994 < class19.field98 + 8 && var52.field993 == class55.field396) {
							var52.field1003 = 0;
						}
					}

					connection.serverPacket = null;
					return true;
				}

				String clientScriptStr;
				if (connection.serverPacket == ServerPacket.RUN_CLIENTSCRIPT) {
					clientScriptStr = packetBuf.readString();
					Object[] scriptArgs = new Object[clientScriptStr.length() + 1];

					for (i = clientScriptStr.length() - 1; i >= 0; --i) {
						if (clientScriptStr.charAt(i) == 's') {
							scriptArgs[i + 1] = packetBuf.readString();
						} else {
							scriptArgs[i + 1] = new Integer(packetBuf.readInt());
						}
					}

					scriptArgs[0] = new Integer(packetBuf.readInt());
					ClientScript script = new ClientScript();
					script.args = scriptArgs;
					class57.runClientScript(script);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3320 == connection.serverPacket) {
					class342.method6352(class271.field3024);
					connection.serverPacket = null;
					return true;
				}

				class227 var15;
				int var16;
				int var17;
				String var26;
				byte var69;
				if (connection.serverPacket == ServerPacket.field3275) {
					var69 = packetBuf.readByte();
					var22 = packetBuf.readString();
					long var24 = (long) packetBuf.readUnsignedShort();
					long var9 = (long) packetBuf.method8312();
					class333 var60 = (class333)class217.fromValue(class333.method5480(), packetBuf.readUnsignedByte());
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
								if (var60.field3858 && class217.friends.method1049(new DisplayName(var22, class234.gameEngineMode))) {
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
						var26 = class384.method6864(class307.method5489(packetBuf));
						var17 = var69 >= 0 ? 41 : 44;
						if (var60.field3856 != -1) {
							MessagesManager.method1858(var17, class96.method5151(var60.field3856) + var22, var26, var68.field1350);
						} else {
							MessagesManager.method1858(var17, var22, var26, var68.field1350);
						}
					}

					connection.serverPacket = null;
					return true;
				}

				class81 var8;
				int var27;
				if (connection.serverPacket == ServerPacket.field3224) {
					i = packetBuf.readUnsignedByte();
					someVar = packetBuf.readUnsignedShortADD();
					var6 = packetBuf.readUnsignedShortLEADD();
					if (var6 == 65535) {
						var6 = -1;
					}

					var8 = npcs[someVar];
					if (var8 != null) {
						if (var6 == var8.field852 && var6 != -1) {
							var27 = class160.method2660(var6).field2013;
							if (var27 == 1) {
								var8.field844 = 0;
								var8.field845 = 0;
								var8.field804 = i;
								var8.field875 = 0;
							} else if (var27 == 2) {
								var8.field875 = 0;
							}
						} else if (var6 == -1 || -1 == var8.field852 || class160.method2660(var6).field2006 >= class160.method2660(var8.field852).field2006) {
							var8.field852 = var6;
							var8.field844 = 0;
							var8.field845 = 0;
							var8.field804 = i;
							var8.field875 = 0;
							var8.field876 = var8.field871;
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3282) {
					class174.field1567 = null;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3230) {
					someVar = packetBuf.readInt();
					InterfaceParent var76 = (InterfaceParent) parentInterfaces.method7855((long)someVar);
					if (null != var76) {
						ProofOfWorkRequest.closeInterface(var76, true);
					}

					if (field1641 != null) {
						class136.method2438(field1641);
						field1641 = null;
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3305 && field1900) {
					field1901 = true;
					class318.field3732 = packetBuf.readUnsignedByte();
					class109.field1086 = packetBuf.readUnsignedByte();
					MouseManager.field298 = packetBuf.readUnsignedByte();
					class158.field1440 = packetBuf.readUnsignedByte();

					for (someVar = 0; someVar < 5; ++someVar) {
						field1699[someVar] = false;
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3303) {
					rebootTimer = packetBuf.readUnsignedShortADD() * 30;
					field1642 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3308) {
					class342.method6352(class271.field3019);
					connection.serverPacket = null;
					return true;
				}

				boolean var78;
				if (ServerPacket.field3273 == connection.serverPacket) {
					var78 = packetBuf.readUnsignedByte() == 1;
					if (var78) {
						class100.field987 = class272.method2046() - packetBuf.readLong();
						class242.field2835 = new class337(packetBuf, true);
					} else {
						class242.field2835 = null;
					}

					field1849 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.REBUILD_REGION) {
					class25.rebuildRegion(true, connection.buffer);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3244) {
					class342.method6352(class271.field3030);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3278 == connection.serverPacket) {
					someVar = packetBuf.readInt();
					var6 = packetBuf.readInt();
					i = class260.method5146();
					PacketMessage var58 = class185.create(ClientPacket.field3113, serverConnection.isaacRandom);
					var58.buffer.writeInt(someVar);
					var58.buffer.writeIntAlt(var6);
					var58.buffer.writeByteNEG(i);
					var58.buffer.writeByteSUB(class31.field174);
					serverConnection.add(var58);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3315) {
					someVar = packetBuf.method8175();
					var6 = packetBuf.readUnsignedShortADD();
					var7 = class282.method5426(someVar);
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

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3251 == connection.serverPacket) {
					class342.method6352(class271.field3023);
					connection.serverPacket = null;
					return true;
				}

				int var28;
				class300 var29;
				if (connection.serverPacket == ServerPacket.field3220) {
					someVar = packetBuf.readUnsignedShortADD();
					var6 = packetBuf.readUnsignedShortLE();
					i = packetBuf.readUnsignedShortLEADD();
					var28 = packetBuf.readInt();
					var29 = class282.method5426(var28);
					if (var29.field3601 != someVar || var6 != var29.field3513 || var29.field3562 != i) {
						var29.field3601 = someVar;
						var29.field3513 = var6;
						var29.field3562 = i;
						class136.method2438(var29);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3272 == connection.serverPacket) {
					for (someVar = 0; someVar < localPlayers.length; ++someVar) {
						if (localPlayers[someVar] != null) {
							localPlayers[someVar].field852 = -1;
						}
					}

					for (someVar = 0; someVar < npcs.length; ++someVar) {
						if (null != npcs[someVar]) {
							npcs[someVar].field852 = -1;
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3283) {
					minimapState = packetBuf.readUnsignedByte();
					connection.serverPacket = null;
					return true;
				}

				class300 var55;
				if (ServerPacket.field3218 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedShortLE();
					var6 = packetBuf.readUnsignedShortLE();
					i = packetBuf.readIntIME();
					var55 = class282.method5426(i);
					var55.field3512 = (someVar << 16) + var6;
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3301 == connection.serverPacket) {
					class342.method6352(class271.field3025);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3311 == connection.serverPacket) {
					clientScriptStr = packetBuf.readString();
					var22 = class384.method6864(class158.method2630(class307.method5489(packetBuf)));
					MouseManager.method773(6, clientScriptStr, var22);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3234) {
					for (someVar = 0; someVar < class293.field3370.length; ++someVar) {
						if (class293.field3368[someVar] != class293.field3370[someVar]) {
							class293.field3370[someVar] = class293.field3368[someVar];
							class147.method2521(someVar);
							field1931[++field1690 - 1 & 31] = someVar;
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3297 == connection.serverPacket) {
					return this.method2886(connection, 1);
				}

				if (ServerPacket.field3249 == connection.serverPacket) {
					method2263();
					var69 = packetBuf.readByte();
					class142 var75 = new class142(packetBuf);
					class148 var61;
					if (var69 >= 0) {
						var61 = field1738[var69];
					} else {
						var61 = class127.field1224;
					}

					var75.method2481(var61);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3228 == connection.serverPacket) {
					class368.method6731();
					connection.serverPacket = null;
					return false;
				}

				if (ServerPacket.field3289 == connection.serverPacket) {
					someVar = packetBuf.readInt();
					var6 = packetBuf.readUnsignedShortLEADD();
					class293.field3368[var6] = someVar;
					if (class293.field3370[var6] != someVar) {
						class293.field3370[var6] = someVar;
					}

					class147.method2521(var6);
					field1931[++field1690 - 1 & 31] = var6;
					connection.serverPacket = null;
					return true;
				}

				long var10;
				if (connection.serverPacket == ServerPacket.field3325) {
					someVar = packetBuf.readUnsignedShortLE();
					if (someVar == 65535) {
						someVar = -1;
					}

					var6 = packetBuf.readUnsignedShortLE();
					if (var6 == 65535) {
						var6 = -1;
					}

					i = packetBuf.readInt();
					var28 = packetBuf.readInt();

					for (var27 = someVar; var27 <= var6; ++var27) {
						var10 = ((long)var28 << 32) + (long)var27;
						class427 var80 = field1785.method7855(var10);
						if (null != var80) {
							var80.method7825();
						}

						field1785.method7857(new class426(i), var10);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3321 == connection.serverPacket) {
					class342.method6352(class271.field3029);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3268 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedByte();
					class368.method6732(someVar);
					connection.serverPacket = null;
					return false;
				}

				if (ServerPacket.field3266 == connection.serverPacket) {
					class342.method6352(class271.field3022);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3245 == connection.serverPacket) {
					packetBuf.offset += 28;
					if (packetBuf.method8246()) {
						method5002(packetBuf, packetBuf.offset - 28);
					}

					connection.serverPacket = null;
					return true;
				}

				int var31;
				if (ServerPacket.field3236 == connection.serverPacket) {
					someVar = packetBuf.readInt();
					var6 = packetBuf.readUnsignedShort();
					if (someVar < -70000) {
						var6 += 32768;
					}

					if (someVar >= 0) {
						var7 = class282.method5426(someVar);
					} else {
						var7 = null;
					}

					for (; packetBuf.offset < connection.serverPacketLength; class233.method4557(var6, var28, var27 - 1, var31)) {
						var28 = packetBuf.method8207();
						var27 = packetBuf.readUnsignedShort();
						var31 = 0;
						if (var27 != 0) {
							var31 = packetBuf.readUnsignedByte();
							if (var31 == 255) {
								var31 = packetBuf.readInt();
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
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3248) {
					field1871 = packetBuf.readUnsignedByteADD();
					field1872 = packetBuf.readUnsignedByte();
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3296 == connection.serverPacket) {
					class342.method6352(class271.field3026);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3323) {
					class342.method6352(class271.field3033);
					connection.serverPacket = null;
					return true;
				}

				boolean var64;
				if (connection.serverPacket == ServerPacket.field3299) {
					someVar = packetBuf.method8207();
					var64 = packetBuf.readUnsignedByte() == 1;
					var53 = "";
					boolean var83 = false;
					if (var64) {
						var53 = packetBuf.readString();
						if (class217.friends.method1049(new DisplayName(var53, class234.gameEngineMode))) {
							var83 = true;
						}
					}

					String var81 = packetBuf.readString();
					if (!var83) {
						MouseManager.method773(someVar, var53, var81);
					}

					connection.serverPacket = null;
					return true;
				}

				class300 var71;
				if (ServerPacket.field3267 == connection.serverPacket) {
					someVar = packetBuf.method8175();
					var71 = class282.method5426(someVar);
					var71.field3504 = 3;
					var71.field3505 = class291.localPlayer.appearance.method6029();
					class136.method2438(var71);
					connection.serverPacket = null;
					return true;
				}

				long var13;
				long var32;
				long var34;
				if (connection.serverPacket == ServerPacket.field3277) {
					clientScriptStr = packetBuf.readString();
					var32 = packetBuf.readLong();
					var34 = (long) packetBuf.readUnsignedShort();
					var10 = (long) packetBuf.method8312();
					class333 var30 = (class333)class217.fromValue(class333.method5480(), packetBuf.readUnsignedByte());
					var13 = var10 + (var34 << 32);
					boolean var85 = false;

					for (var16 = 0; var16 < 100; ++var16) {
						if (var13 == field1918[var16]) {
							var85 = true;
							break;
						}
					}

					if (var30.field3858 && class217.friends.method1049(new DisplayName(clientScriptStr, class234.gameEngineMode))) {
						var85 = true;
					}

					if (!var85 && 0 == field1830) {
						field1918[field1875] = var13;
						field1875 = (1 + field1875) % 100;
						var26 = class384.method6864(class158.method2630(class307.method5489(packetBuf)));
						if (-1 != var30.field3856) {
							MessagesManager.method1858(9, class96.method5151(var30.field3856) + clientScriptStr, var26, class363.method4889(var32));
						} else {
							MessagesManager.method1858(9, clientScriptStr, var26, class363.method4889(var32));
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3319) {
					class227.field2714 = true;
					class236.method4618(true, packetBuf);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3214 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedByte();
					method411(someVar);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3243 == connection.serverPacket) {
					class131.method2400(packetBuf, connection.serverPacketLength);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3227 == connection.serverPacket) {
					class19.field98 = packetBuf.readUnsignedByteSub();
					class7.field28 = packetBuf.readUnsignedByte();

					while (packetBuf.offset < connection.serverPacketLength) {
						someVar = packetBuf.readUnsignedByte();
						class271 var74 = class271.method1667()[someVar];
						class342.method6352(var74);
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3276) {
					field1900 = true;
					field1901 = false;
					class264.field2998 = packetBuf.readUnsignedByte();
					class19.field96 = packetBuf.readUnsignedByte();
					class244.field2859 = packetBuf.readUnsignedShort();
					class318.field3732 = packetBuf.readUnsignedByte();
					class109.field1086 = packetBuf.readUnsignedByte();
					if (class109.field1086 >= 100) {
						class215.field2568 = 64 + class264.field2998 * 128;
						class323.field3766 = 64 + class19.field96 * 128;
						class32.field204 = class144.method2498(class215.field2568, class323.field3766, class55.field396) - class244.field2859;
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3239) {
					class242.updatePlayers(packetBuf, connection.serverPacketLength);
					class372.method6749();
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.PLAYER_INFO == connection.serverPacket) {
					class78.isNewPlayerUpdating = true;
					class242.updatePlayers(packetBuf, connection.serverPacketLength);
					class372.method6749();
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3312 == connection.serverPacket) {
					class330.method6258(packetBuf.readString());
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3226) {
					someVar = packetBuf.readUnsignedShort();
					var6 = packetBuf.readUnsignedByte();
					i = packetBuf.readUnsignedShort();
					class271.method5212(someVar, var6, i);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3294 == connection.serverPacket) {
					someVar = packetBuf.method8175();
					var64 = packetBuf.readUnsignedByteSub() == 1;
					var7 = class282.method5426(someVar);
					if (var7.field3480 != var64) {
						var7.field3480 = var64;
						class136.method2438(var7);
					}

					connection.serverPacket = null;
					return true;
				}

				int var37;
				int var38;
				if (ServerPacket.field3326 == connection.serverPacket) {
					var31 = packetBuf.readUnsignedShort();
					var37 = packetBuf.readUnsignedByte();
					var38 = packetBuf.readUnsignedShortLE();
					i = packetBuf.method8169();
					someVar = i >> 16;
					var6 = i >> 8 & 255;
					var28 = someVar + (i >> 4 & 7);
					var27 = var6 + (i & 7);
					if (var28 >= 0 && var27 >= 0 && var28 < 104 && var27 < 104) {
						var28 = 64 + var28 * 128;
						var27 = var27 * 128 + 64;
						class77 var87 = new class77(var31, class55.field396, var28, var27, class144.method2498(var28, var27, class55.field396) - var37, var38, field1645);
						graphics.method6355(var87);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3290 == connection.serverPacket) {
					field1847 = field1878;
					var69 = packetBuf.readByte();
					class143 var73 = new class143(packetBuf);
					class147 var56;
					if (var69 >= 0) {
						var56 = field1883[var69];
					} else {
						var56 = class188.field1982;
					}

					var73.method2490(var56);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3241 == connection.serverPacket) {
					class217.friends.field376.method6824(packetBuf, connection.serverPacketLength);
					class442.method7920();
					field1844 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3238 == connection.serverPacket) {
					class198.method3654();
					field1859 = packetBuf.method8204();
					field1642 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3280 == connection.serverPacket) {
					someVar = packetBuf.method8175();
					var6 = packetBuf.readUnsignedShort();
					i = var6 >> 10 & 31;
					var28 = var6 >> 5 & 31;
					var27 = var6 & 31;
					var31 = (var28 << 11) + (i << 19) + (var27 << 3);
					class300 var59 = class282.method5426(someVar);
					if (var59.field3485 != var31) {
						var59.field3485 = var31;
						class136.method2438(var59);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3246 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedShortADD();
					if (someVar == 65535) {
						someVar = -1;
					}

					class45.method943(someVar);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3215) {
					someVar = packetBuf.method8148();
					var6 = packetBuf.readUnsignedShortLE();
					if (var6 == 65535) {
						var6 = -1;
					}

					class196.method3635(var6, someVar);
					connection.serverPacket = null;
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
				if (connection.serverPacket == ServerPacket.field3263) {
					var40 = packetBuf.readUnsignedShort();
					var82 = packetBuf.readByteADD();
					var16 = packetBuf.readUnsignedShortADD();
					var17 = packetBuf.readUnsignedShortADD();
					var14 = packetBuf.readUnsignedByte() * 4;
					var88 = packetBuf.readByteADD();
					var19 = packetBuf.readUnsignedByte();
					var38 = packetBuf.readShortLEADD();
					var18 = packetBuf.readUnsignedByteNeg();
					i = packetBuf.method8312();
					someVar = i >> 16;
					var6 = i >> 8 & 255;
					var28 = (i >> 4 & 7) + someVar;
					var27 = (i & 7) + var6;
					var84 = packetBuf.readUnsignedByteADD() * 4;
					var31 = var82 + var28;
					var37 = var88 + var27;
					if (var28 >= 0 && var27 >= 0 && var28 < 104 && var27 < 104 && var31 >= 0 && var37 >= 0 && var31 < 104 && var37 < 104 && var40 != 65535) {
						var28 = 64 + var28 * 128;
						var27 = 64 + var27 * 128;
						var31 = var31 * 128 + 64;
						var37 = 64 + var37 * 128;
						var20 = new class66(var40, class55.field396, var28, var27, class144.method2498(var28, var27, class55.field396) - var14, field1645 + var16, field1645 + var17, var18, var19, var38, var84);
						var20.method1380(var31, var37, class144.method2498(var31, var37, class55.field396) - var84, var16 + field1645);
						projectiles.method6355(var20);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3317 == connection.serverPacket) {
					var17 = packetBuf.readUnsignedShort();
					var16 = packetBuf.readUnsignedShortLEADD();
					var19 = packetBuf.readUnsignedByteNeg();
					i = packetBuf.method8312();
					someVar = i >> 16;
					var6 = i >> 8 & 255;
					var28 = someVar + (i >> 4 & 7);
					var27 = var6 + (i & 7);
					var40 = packetBuf.readUnsignedShort();
					var38 = packetBuf.method8125();
					var14 = packetBuf.readUnsignedByteNeg() * 4;
					var88 = packetBuf.readByte();
					var84 = packetBuf.readUnsignedByteSub() * 4;
					var82 = packetBuf.readByte();
					var18 = packetBuf.readUnsignedByte();
					var31 = var82 + var28;
					var37 = var88 + var27;
					if (var28 >= 0 && var27 >= 0 && var28 < 104 && var27 < 104 && var31 >= 0 && var37 >= 0 && var31 < 104 && var37 < 104 && var40 != 65535) {
						var28 = 64 + var28 * 128;
						var27 = var27 * 128 + 64;
						var31 = 64 + var31 * 128;
						var37 = var37 * 128 + 64;
						var20 = new class66(var40, class55.field396, var28, var27, class144.method2498(var28, var27, class55.field396) - var14, var16 + field1645, var17 + field1645, var18, var19, var38, var84);
						var20.method1380(var31, var37, class144.method2498(var31, var37, class55.field396) - var84, field1645 + var16);
						projectiles.method6355(var20);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3254 == connection.serverPacket) {
					class342.method6352(class271.field3028);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3235) {
					someVar = packetBuf.readInt();
					var6 = packetBuf.method8175();
					i = packetBuf.readUnsignedShort();
					if (i == 65535) {
						i = -1;
					}

					var55 = class282.method5426(var6);
					class198 var79;
					if (!var55.field3459) {
						if (i == -1) {
							var55.field3504 = 0;
							connection.serverPacket = null;
							return true;
						}

						var79 = class278.method5388(i);
						var55.field3504 = 4;
						var55.field3505 = i;
						var55.field3601 = var79.field2137;
						var55.field3513 = var79.field2138;
						var55.field3562 = var79.field2144 * 100 / someVar;
						class136.method2438(var55);
					} else {
						var55.field3445 = i;
						var55.field3599 = someVar;
						var79 = class278.method5388(i);
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

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.IF_OPENTOP) {
					someVar = packetBuf.readUnsignedShortADD();
					rootInterface = someVar;
					this.method2892(false);
					class82.method1699(someVar);
					class134.method2421(rootInterface);

					for (var6 = 0; var6 < 100; ++var6) {
						field1860[var6] = true;
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3222 == connection.serverPacket) {
					if (-1 != rootInterface) {
						class217.method4361(rootInterface, 0);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3262 == connection.serverPacket) {
					class217.friends.method1046(packetBuf, connection.serverPacketLength);
					field1844 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3287) {
					if (class174.field1567 == null) {
						class174.field1567 = new class411(class191.field2026);
					}

					class474 var50 = class191.field2026.method7216(packetBuf);
					class174.field1567.field4557.method7566(var50.field4965, var50.field4963);
					field1841[++field1842 - 1 & 31] = var50.field4965;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3307) {
					class198.method3654();
					someVar = packetBuf.method8175();
					var6 = packetBuf.readUnsignedByteNeg();
					i = packetBuf.readUnsignedByteNeg();
					field1782[i] = someVar;
					field1780[i] = var6;
					field1817[i] = 1;

					for (var28 = 0; var28 < 98; ++var28) {
						if (someVar >= class321.field3756[var28]) {
							field1817[i] = var28 + 2;
						}
					}

					field1839[++field1742 - 1 & 31] = i;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3302) {
					field1847 = field1878;
					var69 = packetBuf.readByte();
					if (connection.serverPacketLength == 1) {
						if (var69 >= 0) {
							field1883[var69] = null;
						} else {
							class188.field1982 = null;
						}

						connection.serverPacket = null;
						return true;
					}

					if (var69 >= 0) {
						field1883[var69] = new class147(packetBuf);
					} else {
						class188.field1982 = new class147(packetBuf);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3310 == connection.serverPacket) {
					var78 = packetBuf.readBoolean();
					if (var78) {
						if (class335.field3867 == null) {
							class335.field3867 = new class348();
						}
					} else {
						class335.field3867 = null;
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3274) {
					someVar = packetBuf.readInt();
					var6 = packetBuf.readUnsignedShortADD();
					var7 = class282.method5426(someVar);
					if (var7.field3504 != 2 || var6 != var7.field3505) {
						var7.field3504 = 2;
						var7.field3505 = var6;
						class136.method2438(var7);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3231 == connection.serverPacket) {
					return this.method2886(connection, 2);
				}

				if (connection.serverPacket == ServerPacket.field3314) {
					someVar = packetBuf.readInt();
					var6 = packetBuf.readUnsignedShort();
					if (someVar < -70000) {
						var6 += 32768;
					}

					if (someVar >= 0) {
						var7 = class282.method5426(someVar);
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
					var28 = packetBuf.readUnsignedShort();

					for (var27 = 0; var27 < var28; ++var27) {
						var31 = packetBuf.readUnsignedShortLE();
						var37 = packetBuf.readUnsignedByteSub();
						if (var37 == 255) {
							var37 = packetBuf.readIntLE();
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
					connection.serverPacket = null;
					return true;
				}

				InterfaceParent var54;
				if (ServerPacket.IF_OPENSUB == connection.serverPacket) {
					someVar = packetBuf.readUnsignedByteSub(); // type
					var6 = packetBuf.readIntLE(); // component
					i = packetBuf.readUnsignedShortADD(); // interfaceId
					var54 = (InterfaceParent) parentInterfaces.method7855((long)var6);

					int parent = var6 >> 16;
					int child = var6 & 0xFFFF;
					int interfaceId = i;
					int type = someVar;
					System.out.println("[ServerPacket] IF_OPENSUB(parent="+parent+", child="+child+", interfaceId="+interfaceId+", type="+type+")");

					if (null != var54) {
						ProofOfWorkRequest.closeInterface(var54, var54.field796 != i);
					}

					class405.method7370(var6, i, someVar);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3271 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedByte();
					if (packetBuf.readUnsignedByte() == 0) {
						field1924[someVar] = new class347();
						packetBuf.offset += 18;
					} else {
						--packetBuf.offset;
						field1924[someVar] = new class347(packetBuf, false);
					}

					field1848 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3318) {
					class227.field2714 = true;
					class236.method4618(false, packetBuf);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3292 == connection.serverPacket) {
					class297.field3431 = class363.method6675(packetBuf.readUnsignedByte());
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3285 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedByte();
					var6 = packetBuf.readUnsignedByte();
					i = packetBuf.readUnsignedByte();
					var28 = packetBuf.readUnsignedByte();
					field1699[someVar] = true;
					field1903[someVar] = var6;
					field1808[someVar] = i;
					field1905[someVar] = var28;
					field1906[someVar] = 0;
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3279 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedShortLEADD();
					PlayerEntity var57;
					if (localPlayerIndex == someVar) {
						var57 = class291.localPlayer;
					} else {
						var57 = localPlayers[someVar];
					}

					i = packetBuf.readIntLE();
					var6 = packetBuf.readUnsignedShortADD();
					if (var57 != null) {
						var57.field848 = var6;
						var57.field824 = i >> 16;
						var57.field851 = (i & 65535) + field1645;
						var57.field856 = 0;
						var57.field807 = 0;
						if (var57.field851 > field1645) {
							var57.field856 = -1;
						}

						if (var57.field848 == 65535) {
							var57.field848 = -1;
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3259) {
					someVar = packetBuf.readUnsignedShortLEADD();
					class408.method7405(someVar);
					field1837[++field1838 - 1 & 31] = someVar & 32767;
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3284 == connection.serverPacket) {
					byte[] var49 = new byte[connection.serverPacketLength];
					packetBuf.method8017(var49, 0, var49.length);
					Buffer var72 = new Buffer(var49);
					var53 = var72.readString();
					class115.method2229(var53, true, false);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3298) {
					class174.field1567 = new class411(class191.field2026);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3291 == connection.serverPacket) {
					return this.method2900(connection);
				}

				if (connection.serverPacket == ServerPacket.field3252) {
					clientScriptStr = packetBuf.readString();
					var6 = packetBuf.readIntIME();
					var7 = class282.method5426(var6);
					if (!clientScriptStr.equals(var7.field3522)) {
						var7.field3522 = clientScriptStr;
						class136.method2438(var7);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3260 == connection.serverPacket) {
					class198.method3654();
					field1816 = packetBuf.readUnsignedByte();
					field1642 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3233 == connection.serverPacket) {
					someVar = packetBuf.readInt();
					if (field1729 != someVar) {
						field1729 = someVar;
						method3391();
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3306) {
					class236.method4618(false, packetBuf);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.IF_MOVESUB == connection.serverPacket) {
					someVar = packetBuf.readIntIME(); // to component
					var6 = packetBuf.readIntLE(); // from component

					int fromParent = var6 >> 16;
					int fromChild = var6 & 0xFFFF;
					int toParent = someVar >> 16;
					int toChild = someVar & 0xFFFF;
					System.out.println("[ServerPacket] IF_MOVESUB(fromParent="+fromParent+", fromChild="+fromChild+", toParent="+toParent+", toChild="+toChild+").");

					InterfaceParent var51 = (InterfaceParent) parentInterfaces.method7855((long)var6);
					var54 = (InterfaceParent) parentInterfaces.method7855((long)someVar);
					if (var54 != null) {
						ProofOfWorkRequest.closeInterface(var54, var51 == null || var51.field796 != var54.field796);
					}

					if (var51 != null) {
						var51.method7825();
						parentInterfaces.method7857(var51, (long)someVar);
					}

					var29 = class282.method5426(var6);
					if (null != var29) {
						class136.method2438(var29);
					}

					var29 = class282.method5426(someVar);
					if (var29 != null) {
						class136.method2438(var29);
						class26.method349(class300.field3593[var29.field3517 >>> 16], var29, true);
					}

					if (-1 != rootInterface) {
						class217.method4361(rootInterface, 1);
					}

					connection.serverPacket = null;
					return true;
				}

				String var41;
				if (connection.serverPacket == ServerPacket.field3300) {
					var69 = packetBuf.readByte();
					var32 = (long) packetBuf.readUnsignedShort();
					var34 = (long) packetBuf.method8312();
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
						var41 = class307.method5489(packetBuf);
						var84 = var69 >= 0 ? 43 : 46;
						MessagesManager.method1858(var84, "", var41, var39.field1350);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3286 == connection.serverPacket) {
					class236.method4618(true, packetBuf);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3221) {
					someVar = packetBuf.readShortLEADD();
					var6 = packetBuf.readIntLE();
					var7 = class282.method5426(var6);
					if (someVar != var7.field3575 || someVar == -1) {
						var7.field3575 = someVar;
						var7.field3471 = 0;
						var7.field3518 = 0;
						class136.method2438(var7);
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3264) {
					class342.method6352(class271.field3020);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3304 == connection.serverPacket) {
					class25.rebuildRegion(false, connection.buffer);
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3270 == connection.serverPacket) {
					someVar = packetBuf.readIntIME();
					var71 = class282.method5426(someVar);

					for (i = 0; i < var71.field3461.length; ++i) {
						var71.field3461[i] = -1;
						var71.field3461[i] = 0;
					}

					class136.method2438(var71);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3242) {
					clientScriptStr = packetBuf.readString();
					var32 = (long) packetBuf.readUnsignedShort();
					var34 = (long) packetBuf.method8312();
					class333 var42 = (class333)class217.fromValue(class333.method5480(), packetBuf.readUnsignedByte());
					long var43 = var34 + (var32 << 32);
					boolean var89 = false;

					for (var14 = 0; var14 < 100; ++var14) {
						if (field1918[var14] == var43) {
							var89 = true;
							break;
						}
					}

					if (class217.friends.method1049(new DisplayName(clientScriptStr, class234.gameEngineMode))) {
						var89 = true;
					}

					if (!var89 && field1830 == 0) {
						field1918[field1875] = var43;
						field1875 = (field1875 + 1) % 100;
						var41 = class384.method6864(class158.method2630(class307.method5489(packetBuf)));
						byte var36;
						if (var42.field3857) {
							var36 = 7;
						} else {
							var36 = 3;
						}

						if (var42.field3856 != -1) {
							MouseManager.method773(var36, class96.method5151(var42.field3856) + clientScriptStr, var41);
						} else {
							MouseManager.method773(var36, clientScriptStr, var41);
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3288) {
					hintArrowType = packetBuf.readUnsignedByte();
					if (1 == hintArrowType) {
						field1879 = packetBuf.readUnsignedShort();
					}

					if (hintArrowType >= 2 && hintArrowType <= 6) {
						if (2 == hintArrowType) {
							field1866 = 64;
							field1684 = 64;
						}

						if (hintArrowType == 3) {
							field1866 = 0;
							field1684 = 64;
						}

						if (hintArrowType == 4) {
							field1866 = 128;
							field1684 = 64;
						}

						if (5 == hintArrowType) {
							field1866 = 64;
							field1684 = 0;
						}

						if (hintArrowType == 6) {
							field1866 = 64;
							field1684 = 128;
						}

						hintArrowType = 2;
						field1655 = packetBuf.readUnsignedShort();
						field1656 = packetBuf.readUnsignedShort();
						field1913 = packetBuf.readUnsignedByte();
					}

					if (hintArrowType == 10) {
						field1654 = packetBuf.readUnsignedShort();
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3322 == connection.serverPacket) {
					someVar = packetBuf.method8204();
					var6 = packetBuf.readIntIME();
					i = packetBuf.readShortLEADD();
					var55 = class282.method5426(var6);
					if (var55.field3469 != i || someVar != var55.field3470 || var55.field3465 != 0 || var55.field3466 != 0) {
						var55.field3469 = i;
						var55.field3470 = someVar;
						var55.field3465 = 0;
						var55.field3466 = 0;
						class136.method2438(var55);
						this.method2893(var55);
						if (0 == var55.field3462) {
							class26.method349(class300.field3593[var6 >> 16], var55, false);
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3295) {
					field1900 = false;

					for (someVar = 0; someVar < 5; ++someVar) {
						field1699[someVar] = false;
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3255) {
					someVar = connection.serverPacketLength + packetBuf.offset;
					var6 = packetBuf.readUnsignedShort();
					i = packetBuf.readUnsignedShort();
					if (var6 != rootInterface) {
						rootInterface = var6;
						this.method2892(false);
						class82.method1699(rootInterface);
						class134.method2421(rootInterface);

						for (var28 = 0; var28 < 100; ++var28) {
							field1860[var28] = true;
						}
					}

					InterfaceParent var11;
					for (; i-- > 0; var11.field795 = true) {
						var28 = packetBuf.readInt();
						var27 = packetBuf.readUnsignedShort();
						var31 = packetBuf.readUnsignedByte();
						var11 = (InterfaceParent) parentInterfaces.method7855((long)var28);
						if (null != var11 && var11.field796 != var27) {
							ProofOfWorkRequest.closeInterface(var11, true);
							var11 = null;
						}

						if (null == var11) {
							var11 = class405.method7370(var28, var27, var31);
						}
					}

					for (var54 = (InterfaceParent) parentInterfaces.first(); var54 != null; var54 = (InterfaceParent) parentInterfaces.next()) {
						if (var54.field795) {
							var54.field795 = false;
						} else {
							ProofOfWorkRequest.closeInterface(var54, true);
						}
					}

					field1785 = new NodeHashTable(512);

					while (packetBuf.offset < someVar) {
						var28 = packetBuf.readInt();
						var27 = packetBuf.readUnsignedShort();
						var31 = packetBuf.readUnsignedShort();
						var37 = packetBuf.readInt();

						for (var38 = var27; var38 <= var31; ++var38) {
							var13 = ((long)var28 << 32) + (long)var38;
							field1785.method7857(new class426(var37), var13);
						}
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3309 == connection.serverPacket) {
					class342.method6352(class271.field3018);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3229) {
					var69 = packetBuf.readByteSUB();
					var6 = packetBuf.readUnsignedShortADD();
					class293.field3368[var6] = var69;
					if (class293.field3370[var6] != var69) {
						class293.field3370[var6] = var69;
					}

					class147.method2521(var6);
					field1931[++field1690 - 1 & 31] = var6;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3217) {
					class19.field98 = packetBuf.readUnsignedByteADD();
					class7.field28 = packetBuf.readUnsignedByteADD();
					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3256 == connection.serverPacket) {
					someVar = packetBuf.readUnsignedShortLE();
					var8 = npcs[someVar];
					i = packetBuf.readUnsignedShortLE();
					var6 = packetBuf.method8175();
					if (var8 != null) {
						var8.field848 = i;
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

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3257 == connection.serverPacket) {
					method2263();
					var69 = packetBuf.readByte();
					if (connection.serverPacketLength == 1) {
						if (var69 >= 0) {
							field1738[var69] = null;
						} else {
							class127.field1224 = null;
						}

						connection.serverPacket = null;
						return true;
					}

					if (var69 >= 0) {
						field1738[var69] = new class148(packetBuf);
					} else {
						class127.field1224 = new class148(packetBuf);
					}

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3281 == connection.serverPacket) {
					for (someVar = 0; someVar < class178.field1592; ++someVar) {
						class178 var70 = ClientPacket.method5221(someVar);
						if (var70 != null) {
							class293.field3368[someVar] = 0;
							class293.field3370[someVar] = 0;
						}
					}

					class198.method3654();
					field1690 += 32;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3232) {
					class342.method6352(class271.field3031);
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3247) {
					field1900 = true;
					field1901 = false;
					class8.field34 = packetBuf.readUnsignedByte();
					class122.field1186 = packetBuf.readUnsignedByte();
					class278.field3197 = packetBuf.readUnsignedShort();
					MouseManager.field298 = packetBuf.readUnsignedByte();
					class158.field1440 = packetBuf.readUnsignedByte();
					if (class158.field1440 >= 100) {
						someVar = class8.field34 * 128 + 64;
						var6 = class122.field1186 * 128 + 64;
						i = class144.method2498(someVar, var6, class55.field396) - class278.field3197;
						var28 = someVar - class215.field2568;
						var27 = i - class32.field204;
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

					connection.serverPacket = null;
					return true;
				}

				if (ServerPacket.field3313 == connection.serverPacket) {
					class72 var47 = new class72();
					var47.field589 = packetBuf.readString();
					var47.field590 = packetBuf.readUnsignedShort();
					var6 = packetBuf.readInt();
					var47.field587 = var6;
					class9.method64(45);
					var3.method7259();
					var3 = null;
					method3066(var47);
					connection.serverPacket = null;
					return false;
				}

				if (ServerPacket.field3237 == connection.serverPacket) {
					destinationX = packetBuf.readUnsignedByte();
					if (255 == destinationX) {
						destinationX = 0;
					}

					destinationY = packetBuf.readUnsignedByte();
					if (255 == destinationY) {
						destinationY = 0;
					}

					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3250) {
					class217.friends.method1109();
					field1844 = field1878;
					connection.serverPacket = null;
					return true;
				}

				if (connection.serverPacket == ServerPacket.field3213) {
					var14 = packetBuf.readUnsignedShortADD();
					var31 = packetBuf.readUnsignedByteADD();
					var37 = var31 >> 2;
					var38 = var31 & 3;
					var40 = field1708[var37];
					i = packetBuf.method8312();
					someVar = i >> 16;
					var6 = i >> 8 & 255;
					var28 = someVar + (i >> 4 & 7);
					var27 = var6 + (i & 7);
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

					connection.serverPacket = null;
					return true;
				}

				class422.method7807("" + (connection.serverPacket != null ? connection.serverPacket.field3324 : -1) + class96.field959 + (connection.field1072 != null ? connection.field1072.field3324 : -1) + class96.field959 + (connection.field1080 != null ? -1220623677 * connection.field1080.field3324 * 1911455211 : -1) + class96.field959 + connection.serverPacketLength, (Throwable)null);
				class368.method6731();
			} catch (IOException var45) {
				method4611();
			} catch (Exception var46) {
				var22 = "" + (connection.serverPacket != null ? connection.serverPacket.field3324 : -1) + class96.field959 + (connection.field1072 != null ? -1220623677 * connection.field1072.field3324 * 1911455211 : -1) + class96.field959 + (null != connection.field1080 ? -1220623677 * connection.field1080.field3324 * 1911455211 : -1) + class96.field959 + connection.serverPacketLength + class96.field959 + (class291.localPlayer.field861[0] + class36.sceneBaseX) + class96.field959 + (class291.localPlayer.field873[0] + class169.sceneBaseY) + class96.field959;

				for (i = 0; i < connection.serverPacketLength && i < 50; ++i) {
					var22 = var22 + packetBuf.data[i] + class96.field959;
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
		menuOptionsCount = 0;
		isMenuOpen = false;
		field1791[0] = class338.field4149;
		field1923[0] = "";
		field1788[0] = 1006;
		field1916[0] = false;
		menuOptionsCount = 1;
	}

	static final boolean method5007() {
		return isMenuOpen;
	}

	final void method2889() {
		boolean var2 = false;

		int var3;
		int var6;
		while (!var2) {
			var2 = true;

			for (var3 = 0; var3 < menuOptionsCount - 1; ++var3) {
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
					int var22 = MouseManager.field277;
					int var9;
					int var16;
					int var23;
					int var24;
					if (isMenuOpen) {
						if (var22 != 1 && (class95.field944 || var22 != 4)) {
							var3 = MouseManager.field284;
							var16 = MouseManager.field285;
							if (var3 < class94.field923 - 10 || var3 > 10 + class94.field923 + class179.field1601 || var16 < class125.field1206 - 10 || var16 > 10 + class240.field2826 + class125.field1206) {
								isMenuOpen = false;
								class319.method6181(class94.field923, class125.field1206, class179.field1601, class240.field2826);
							}
						}

						if (var22 == 1 || !class95.field944 && var22 == 4) {
							var3 = class94.field923;
							var16 = class125.field1206;
							var17 = class179.field1601;
							var6 = MouseManager.lastPressedX;
							var23 = MouseManager.lastPressedY;
							var24 = -1;

							for (var9 = 0; var9 < menuOptionsCount; ++var9) {
								var25 = var16 + 31 + (menuOptionsCount - 1 - var9) * 15;
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
								PacketMessage.method5159(var9, var25, var11, var12, var13, var14, var15, MouseManager.lastPressedX, MouseManager.lastPressedY);
							}

							isMenuOpen = false;
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

						if ((var22 == 1 || !class95.field944 && var22 == 4) && menuOptionsCount > 0 && var3 >= 0) {
							var16 = field1851[var3];
							var17 = field1787[var3];
							var6 = field1788[var3];
							var23 = field1789[var3];
							var24 = field1790[var3];
							String var19 = field1791[var3];
							String var20 = field1923[var3];
							PacketMessage.method5159(var16, var17, var6, var23, var24, var19, var20, MouseManager.lastPressedX, MouseManager.lastPressedY);
						}

						if (var22 == 2 && menuOptionsCount > 0) {
							this.method3357(MouseManager.lastPressedX, MouseManager.lastPressedY);
						}
					}

					return;
				}

				if (null != class183.field1943 && !field1759 && menuOptionsCount > 0 && !this.method2890()) {
					var25 = field1638;
					var11 = field1757;
					class73 var21 = class101.field1005;
					if (null != var21) {
						PacketMessage.method5159(var21.field600, var21.field595, var21.field594, var21.field597, var21.field598, var21.field599, var21.field604, var25, var11);
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
				field1638 = MouseManager.lastPressedX;
				field1757 = MouseManager.lastPressedY;
				if (var3 >= 0) {
					method102(var3);
				}

				class136.method2438(class183.field1943);
			}
		}
	}

	final boolean method2890() {
		int var2 = method5125();
		return (field1862 && menuOptionsCount > 2 || class45.method951(var2)) && !field1916[var2];
	}

	final void method3357(int var1, int var2) {
		int var4 = class114.field1127.method6894(class338.field4057);

		int var5;
		int var6;
		for (var5 = 0; var5 < menuOptionsCount; ++var5) {
			var6 = class114.field1127.method6894(class233.method4558(var5));
			if (var6 > var4) {
				var4 = var6;
			}
		}

		var4 += 8;
		var5 = menuOptionsCount * 15 + 22;
		var6 = var1 - var4 / 2;
		if (var6 + var4 > class31.canvasWidth) {
			var6 = class31.canvasWidth - var4;
		}

		if (var6 < 0) {
			var6 = 0;
		}

		int var7 = var2;
		if (var2 + var5 > class12.canvasHeight) {
			var7 = class12.canvasHeight - var5;
		}

		if (var7 < 0) {
			var7 = 0;
		}

		class94.field923 = var6;
		class125.field1206 = var7;
		class179.field1601 = var4;
		class240.field2826 = menuOptionsCount * 15 + 22;
		var1 -= field1915;
		var2 -= field1634;
		class145.field1333.method4159(class55.field396, var1, var2, false);
		isMenuOpen = true;
	}

	static void method7985(int var0, int var1) {
		PacketMessage var3 = class185.create(ClientPacket.field3109, serverConnection.isaacRandom);
		var3.buffer.writeShortLE(var1);
		var3.buffer.writeInt(var0);
		serverConnection.add(var3);
	}

	public static final void method351(String var0, String var1, int var2, int var3, int var4, int var5) {
		class105.method2042(var0, var1, var2, var3, var4, var5, -1, false);
	}

	static final void method1556(String var0, String var1, int var2, int var3, int var4, int var5, int var6) {
		class105.method2042(var0, var1, var2, var3, var4, var5, var6, false);
	}

	static final int method5125() {
		return menuOptionsCount - 1;
	}

	final void method2892(boolean var1) {
		int var3 = rootInterface;
		int var4 = class31.canvasWidth;
		int var5 = class12.canvasHeight;
		if (class246.method4928(var3)) {
			class256.method5126(class300.field3593[var3], -1, var4, var5, var1);
		}

	}

	void method2893(class300 var1) {
		class300 var3 = var1.field3596 == -1 ? null : class282.method5426(var1.field3596);
		int var4;
		int var5;
		if (null == var3) {
			var4 = class31.canvasWidth;
			var5 = class12.canvasHeight;
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
			var2 = MouseManager.field284;
			var3 = MouseManager.field285;
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
			ClientScript var9;
			if (field1874.field3478 != null && field1833) {
				var9 = new ClientScript();
				var9.field694 = field1874;
				var9.field693 = var7;
				var9.field688 = var8;
				var9.args = field1874.field3478;
				class57.runClientScript(var9);
			}

			if (MouseManager.field289 == 0) {
				if (field1833) {
					if (null != field1874.field3537) {
						var9 = new ClientScript();
						var9.field694 = field1874;
						var9.field693 = var7;
						var9.field688 = var8;
						var9.field691 = field1826;
						var9.args = field1874.field3537;
						class57.runClientScript(var9);
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
							PacketMessage var20 = class185.create(ClientPacket.field3097, serverConnection.isaacRandom);
							var20.buffer.writeInt(field1874.field3517);
							var20.buffer.writeShort(field1874.field3445);
							var20.buffer.writeShort(field1874.field3484);
							var20.buffer.writeShort(field1826.field3484);
							var20.buffer.writeInt(field1826.field3517);
							var20.buffer.writeShortLE(field1826.field3445);
							serverConnection.add(var20);
						}
					}
				} else if (this.method2890()) {
					this.method3357(field1824 + field1831, field1825 + field1832);
				} else if (menuOptionsCount > 0) {
					int var17 = field1824 + field1831;
					int var18 = field1832 + field1825;
					class73 var16 = class101.field1005;
					if (var16 != null) {
						PacketMessage.method5159(var16.field600, var16.field595, var16.field594, var16.field597, var16.field598, var16.field599, var16.field604, var17, var18);
					}

					class101.field1005 = null;
				}

				field1874 = null;
			}

		} else {
			if (class78.field684 > 1) {
				if (!field1833 && menuOptionsCount > 0) {
					var2 = field1831 + field1824;
					var3 = field1825 + field1832;
					class73 var4 = class101.field1005;
					if (var4 != null) {
						PacketMessage.method5159(var4.field600, var4.field595, var4.field594, var4.field597, var4.field598, var4.field599, var4.field604, var2, var3);
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
		float var1 = 200.0F * ((float)class413.clientPreferences.method1717() - 0.5F);
		return 100 - Math.round(var1);
	}

	static final void method3634(double var0) {
		class221.method4394(var0);
		((class215)class221.field2629).method4329(var0);
		class198.method716();
		class413.clientPreferences.method1714(var0);
	}

	static final void method1354(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		class413.clientPreferences.method1704(var0);
	}

	static final void method6049(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		class413.clientPreferences.method1719(var0);
	}

	static final void method602() {
		for (int var1 = 0; var1 < PlayerManager.localPlayerCount; ++var1) {
			PlayerEntity var2 = localPlayers[PlayerManager.localPlayerIndexes[var1]];
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
		PacketMessage var1 = class185.create(ClientPacket.field3049, serverConnection.isaacRandom);
		var1.buffer.writeByte(0);
		serverConnection.add(var1);
	}

	static boolean method343(class300 var0) {
		return var0.field3480;
	}

	static void method5002(Buffer var0, int var1) {
		byte[] var3 = var0.data;
		if (null == field1689) {
			field1689 = new byte[24];
		}

		class386.method6961(var3, var1, field1689, 0, 24);
		class199.method3732(var0, var1);
	}

	public DisplayName method6785() {
		return null != class291.localPlayer ? class291.localPlayer.displayName : null;
	}

	static void method411(int var0) {
		field1722 = var0;
	}

	static void method202() {
		serverConnection.add(class185.create(ClientPacket.field3079, serverConnection.isaacRandom));
		field1722 = 0;
	}

	static void method3391() {
		if (field1722 == 1) {
			field1643 = true;
		}

	}

	static void method3393() {
		class413.clientPreferences.method1723(field1637);
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
