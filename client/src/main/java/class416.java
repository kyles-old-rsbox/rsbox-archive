public abstract class class416 implements class238 {
	class451 field4599;

	class416(int var1) {
	}

	public void method7554(class460 var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			class406[] var4 = new class406[]{class406.field4524, class406.field4523, class406.field4525, class406.field4522};
			class406 var5 = (class406)class217.method4362(var4, var3);
			if (var5 != null) {
				switch(var5.field4521) {
				case 0:
					class318[] var6 = new class318[]{class318.field3728, class318.field3729, class318.field3731, class318.field3727};
					class217.method4362(var6, var1.method8141());
					break;
				case 1:
				default:
					throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var5);
				case 2:
					var1.method8132();
					break;
				case 3:
					int var7 = var1.method8141();
					this.field4599 = class213.method4117(var7);
					if (null == this.field4599) {
						throw new IllegalStateException("Unknown ScriptVarType ID in VarType.decode: " + var7);
					}
				}
			} else {
				this.method7555(var1, var3);
			}
		}
	}

	boolean method7556() {
		return null != this.field4599;
	}

	Object method7557() {
		if (this.field4599 == class451.field4848) {
			return 0;
		} else if (class451.field4842 == this.field4599) {
			return -1L;
		} else {
			return this.field4599 == class451.field4850 ? "" : null;
		}
	}

	abstract void method7555(class460 var1, int var2);
}
