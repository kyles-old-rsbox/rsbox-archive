public class ClientPacket implements ClientProt {
	public static final ClientPacket field3039;
	public static final ClientPacket field3040;
	public static final ClientPacket field3041;
	public static final ClientPacket field3042;
	public static final ClientPacket field3043;
	public static final ClientPacket field3044;
	public static final ClientPacket field3045;
	public static final ClientPacket field3046;
	public static final ClientPacket field3047;
	public static final ClientPacket field3048;
	public static final ClientPacket field3049;
	public static final ClientPacket field3050;
	public static final ClientPacket field3051;
	public static final ClientPacket field3052;
	public static final ClientPacket field3053;
	public static final ClientPacket field3054;
	public static final ClientPacket field3055;
	public static final ClientPacket field3056;
	public static final ClientPacket field3057;
	public static final ClientPacket field3058;
	public static final ClientPacket field3059;
	public static final ClientPacket field3060;
	public static final ClientPacket field3061;
	public static final ClientPacket field3062;
	public static final ClientPacket field3063;
	public static final ClientPacket field3064;
	public static final ClientPacket field3065;
	public static final ClientPacket field3066;
	public static final ClientPacket field3067;
	public static final ClientPacket field3068;
	public static final ClientPacket field3069;
	public static final ClientPacket field3070;
	public static final ClientPacket field3072;
	public static final ClientPacket field3073;
	public static final ClientPacket field3074;
	public static final ClientPacket field3075;
	public static final ClientPacket field3076;
	public static final ClientPacket field3077;
	public static final ClientPacket field3078;
	public static final ClientPacket field3079;
	public static final ClientPacket field3080;
	public static final ClientPacket field3081;
	public static final ClientPacket field3082;
	public static final ClientPacket NO_TIMEOUT;
	public static final ClientPacket field3084;
	public static final ClientPacket field3085;
	public static final ClientPacket field3086;
	public static final ClientPacket field3087;
	public static final ClientPacket field3089;
	public static final ClientPacket field3090;
	public static final ClientPacket field3091;
	public static final ClientPacket field3092;
	public static final ClientPacket field3093;
	public static final ClientPacket field3094;
	public static final ClientPacket field3095;
	public static final ClientPacket field3096;
	public static final ClientPacket field3097;
	public static final ClientPacket field3098;
	public static final ClientPacket field3100;
	public static final ClientPacket field3101;
	public static final ClientPacket field3102;
	public static final ClientPacket field3103;
	public static final ClientPacket field3104;
	public static final ClientPacket field3105;
	public static final ClientPacket field3106;
	public static final ClientPacket field3107;
	public static final ClientPacket field3108;
	public static final ClientPacket field3109;
	public static final ClientPacket field3110;
	public static final ClientPacket field3111;
	public static final ClientPacket field3112;
	public static final ClientPacket field3113;
	public static final ClientPacket field3114;
	public static final ClientPacket field3115;
	public static final ClientPacket field3116;
	public static final ClientPacket field3117;
	public static final ClientPacket field3118;
	public static final ClientPacket field3119;
	public static final ClientPacket field3120;
	public static final ClientPacket field3121;
	public static final ClientPacket field3122;
	public static final ClientPacket field3123;
	public static final ClientPacket field3124;
	public static final ClientPacket field3125;
	public static final ClientPacket field3126;
	public static final ClientPacket field3127;
	public static final ClientPacket field3128;
	public static final ClientPacket field3129;
	public static final ClientPacket field3130;
	public static final ClientPacket field3131;
	public static final ClientPacket field3132;
	public static final ClientPacket field3133;
	public static final ClientPacket MOVE_GAMECLICK;
	public static final ClientPacket field3136;
	public static final ClientPacket field3137;
	public static final ClientPacket field3138;
	public static final ClientPacket field3139;
	public static final ClientPacket field3140;
	public static final ClientPacket field3141;
	public static final ClientPacket field3142;
	public static final ClientPacket field3143;
	public static final ClientPacket field3145;
	public static final ClientPacket field3146;
	static final ClientPacket field3071;
	static final ClientPacket field3088;
	static final ClientPacket field3099;
	static final ClientPacket field3135;
	static final ClientPacket field3144;
	final int opcode;
	final int length;

	static {
		NO_TIMEOUT = new ClientPacket(0, 0);
		field3040 = new ClientPacket(1, 9);
		field3041 = new ClientPacket(2, 14);
		field3082 = new ClientPacket(3, -1);
		field3129 = new ClientPacket(4, -1);
		field3044 = new ClientPacket(5, 3);
		field3045 = new ClientPacket(6, 8);
		field3140 = new ClientPacket(7, 0);
		field3047 = new ClientPacket(8, -2);
		field3048 = new ClientPacket(9, 3);
		field3049 = new ClientPacket(10, -1);
		field3050 = new ClientPacket(11, 7);
		field3085 = new ClientPacket(12, 8);
		field3052 = new ClientPacket(13, -1);
		field3053 = new ClientPacket(14, 7);
		field3054 = new ClientPacket(15, 7);
		field3055 = new ClientPacket(16, 8);
		field3056 = new ClientPacket(17, 3);
		field3057 = new ClientPacket(18, 15);
		field3058 = new ClientPacket(19, 8);
		field3068 = new ClientPacket(20, 8);
		field3125 = new ClientPacket(21, 8);
		field3061 = new ClientPacket(22, 8);
		field3062 = new ClientPacket(23, 8);
		field3092 = new ClientPacket(24, 7);
		field3064 = new ClientPacket(25, 7);
		field3065 = new ClientPacket(26, 13);
		field3051 = new ClientPacket(27, 4);
		field3067 = new ClientPacket(28, 8);
		field3066 = new ClientPacket(29, -1);
		field3084 = new ClientPacket(30, 7);
		field3142 = new ClientPacket(31, 3);
		field3106 = new ClientPacket(32, 7);
		field3081 = new ClientPacket(33, 4);
		field3043 = new ClientPacket(34, -1);
		field3144 = new ClientPacket(35, -1);
		field3075 = new ClientPacket(36, 4);
		field3076 = new ClientPacket(37, 8);
		field3120 = new ClientPacket(38, -2);
		field3059 = new ClientPacket(39, 1);
		field3074 = new ClientPacket(40, -1);
		field3063 = new ClientPacket(41, -1);
		field3070 = new ClientPacket(42, 3);
		field3126 = new ClientPacket(43, 2);
		field3138 = new ClientPacket(44, 6);
		field3090 = new ClientPacket(45, 3);
		field3079 = new ClientPacket(46, 0);
		field3086 = new ClientPacket(47, 8);
		field3087 = new ClientPacket(48, 15);
		field3088 = new ClientPacket(49, -1);
		field3089 = new ClientPacket(50, 3);
		field3101 = new ClientPacket(51, 5);
		field3046 = new ClientPacket(52, 8);
		field3077 = new ClientPacket(53, 4);
		field3093 = new ClientPacket(54, 15);
		field3094 = new ClientPacket(55, 6);
		field3095 = new ClientPacket(56, 3);
		field3096 = new ClientPacket(57, 16);
		field3131 = new ClientPacket(58, 16);
		field3098 = new ClientPacket(59, 8);
		field3118 = new ClientPacket(60, -1);
		field3069 = new ClientPacket(61, 3);
		field3099 = new ClientPacket(62, 7);
		field3102 = new ClientPacket(63, -1);
		field3103 = new ClientPacket(64, 8);
		field3104 = new ClientPacket(65, 8);
		field3105 = new ClientPacket(66, -1);
		field3078 = new ClientPacket(67, 3);
		field3107 = new ClientPacket(68, 8);
		field3108 = new ClientPacket(69, -2);
		field3109 = new ClientPacket(70, 6);
		field3110 = new ClientPacket(71, 3);
		field3111 = new ClientPacket(72, 11);
		field3112 = new ClientPacket(73, -1);
		field3091 = new ClientPacket(74, 8);
		field3114 = new ClientPacket(75, -1);
		field3115 = new ClientPacket(76, -1);
		field3116 = new ClientPacket(77, 8);
		field3117 = new ClientPacket(78, -1);
		field3073 = new ClientPacket(79, -1);
		field3119 = new ClientPacket(80, 11);
		field3072 = new ClientPacket(81, 8);
		field3121 = new ClientPacket(82, 7);
		field3122 = new ClientPacket(83, 3);
		field3123 = new ClientPacket(84, 15);
		field3124 = new ClientPacket(85, 2);
		field3100 = new ClientPacket(86, 9);
		field3060 = new ClientPacket(87, 2);
		field3127 = new ClientPacket(88, 0);
		field3128 = new ClientPacket(89, -1);
		field3039 = new ClientPacket(90, 4);
		field3130 = new ClientPacket(91, 8);
		field3042 = new ClientPacket(92, 3);
		field3132 = new ClientPacket(93, 7);
		field3133 = new ClientPacket(94, -1);
		MOVE_GAMECLICK = new ClientPacket(95, -1);
		field3135 = new ClientPacket(96, -1);
		field3136 = new ClientPacket(97, 0);
		field3137 = new ClientPacket(98, -1);
		field3071 = new ClientPacket(99, 2);
		field3139 = new ClientPacket(100, 2);
		field3113 = new ClientPacket(101, 10);
		field3141 = new ClientPacket(102, 3);
		field3097 = new ClientPacket(103, 16);
		field3143 = new ClientPacket(104, 11);
		field3080 = new ClientPacket(105, 7);
		field3145 = new ClientPacket(106, 11);
		field3146 = new ClientPacket(107, 22);
	}

	public static class178 method5221(int var0) {
		class178 var2 = (class178)class178.field1590.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			byte[] var3 = class178.field1593.method6175(16, var0);
			var2 = new class178();
			if (var3 != null) {
				var2.method2837(new Buffer(var3));
			}

			class178.field1590.method5434(var2, (long)var0);
			return var2;
		}
	}

	ClientPacket(int var1, int var2) {
		this.opcode = var1;
		this.length = var2;
	}
}
