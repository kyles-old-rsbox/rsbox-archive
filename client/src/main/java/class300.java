import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class class300 extends class427 {
   public static boolean field3458;
   public static class300[][] field3593;
   static class284 field3453 = new class284(50);
   static class284 field3455 = new class284(8);
   static class284 field3538 = new class284(20);
   static class284 field3554 = new class284(200);
   static class366 field3451;
   static class366 field3457;
   static int field3615;
   class176 field3460;
   class310 field3474;
   int field3506;
   int field3507;
   int field3535;
   HashMap field3532;
   HashMap field3608;
   public boolean field3449;
   public boolean field3459 = false;
   public boolean field3467;
   public boolean field3480 = false;
   public boolean field3488;
   public boolean field3489 = false;
   public boolean field3491;
   public boolean field3494;
   public boolean field3499;
   public boolean field3503;
   public boolean field3519;
   public boolean field3534;
   public boolean field3539;
   public boolean field3540;
   public boolean field3550;
   public boolean field3552;
   public boolean field3603;
   public boolean field3614;
   public byte[][] field3541;
   public byte[][] field3542;
   public class300 field3547;
   public class300[] field3602;
   public class469 field3490;
   public int field3445;
   public int field3448 = 0;
   public int field3462;
   public int field3463 = 0;
   public int field3464 = 0;
   public int field3465 = 0;
   public int field3466 = 0;
   public int field3468 = 0;
   public int field3469 = 0;
   public int field3470 = 0;
   public int field3471;
   public int field3472 = 0;
   public int field3473 = 0;
   public int field3476 = 0;
   public int field3477 = 1;
   public int field3481 = 0;
   public int field3482 = 0;
   public int field3483 = 0;
   public int field3484 = -1;
   public int field3485 = 0;
   public int field3486 = 0;
   public int field3487 = 0;
   public int field3492 = 0;
   public int field3493;
   public int field3495 = 0;
   public int field3496;
   public int field3498;
   public int field3500;
   public int field3501;
   public int field3504;
   public int field3505;
   public int field3508 = 0;
   public int field3509;
   public int field3510;
   public int field3511 = 1;
   public int field3512;
   public int field3513;
   public int field3514;
   public int field3516;
   public int field3517 = -1;
   public int field3518;
   public int field3520;
   public int field3521;
   public int field3524;
   public int field3525;
   public int field3527;
   public int field3528;
   public int field3529;
   public int field3536;
   public int field3548;
   public int field3551 = 0;
   public int field3560;
   public int field3562;
   public int field3567 = 0;
   public int field3572;
   public int field3575;
   public int field3588;
   public int field3596 = -1;
   public int field3597;
   public int field3599;
   public int field3600;
   public int field3601;
   public int field3604;
   public int field3605;
   public int field3606;
   public int field3607;
   public int field3609;
   public int field3610;
   public int field3612;
   public int[] field3456;
   public int[] field3461;
   public int[] field3526;
   public int[] field3530;
   public int[] field3531;
   public int[] field3543;
   public int[] field3544;
   public int[] field3566;
   public int[] field3568;
   public int[] field3570;
   public int[] field3590;
   public int[] field3591;
   public int[] field3592;
   public int[][] field3613;
   public Object[] field3452;
   public Object[] field3454;
   public Object[] field3478;
   public Object[] field3479;
   public Object[] field3502;
   public Object[] field3537;
   public Object[] field3549;
   public Object[] field3553;
   public Object[] field3555;
   public Object[] field3556;
   public Object[] field3557;
   public Object[] field3558;
   public Object[] field3559;
   public Object[] field3561;
   public Object[] field3563;
   public Object[] field3565;
   public Object[] field3569;
   public Object[] field3571;
   public Object[] field3573;
   public Object[] field3574;
   public Object[] field3576;
   public Object[] field3577;
   public Object[] field3578;
   public Object[] field3579;
   public Object[] field3580;
   public Object[] field3581;
   public Object[] field3583;
   public Object[] field3584;
   public Object[] field3585;
   public Object[] field3586;
   public Object[] field3587;
   public Object[] field3589;
   public Object[] field3598;
   public Object[] field3611;
   public String field3497;
   public String field3515;
   public String field3522;
   public String field3523;
   public String field3545;
   public String field3594;
   public String field3595;
   public String[] field3533;
   public String[] field3546;

   public class300() {
      this.field3490 = class469.field4929;
      this.field3612 = 0;
      this.field3588 = 0;
      this.field3493 = 1;
      this.field3494 = false;
      this.field3560 = -1;
      this.field3496 = -1;
      this.field3498 = 0;
      this.field3499 = false;
      this.field3500 = 0;
      this.field3501 = 0;
      this.field3504 = 1;
      this.field3505 = -1;
      this.field3506 = 1;
      this.field3507 = -1;
      this.field3575 = -1;
      this.field3509 = -1;
      this.field3510 = 0;
      this.field3548 = 0;
      this.field3601 = 0;
      this.field3513 = 0;
      this.field3514 = 0;
      this.field3562 = 100;
      this.field3516 = 0;
      this.field3512 = 0;
      this.field3534 = false;
      this.field3519 = false;
      this.field3520 = 2;
      this.field3521 = -1;
      this.field3522 = "";
      this.field3523 = "";
      this.field3524 = 0;
      this.field3525 = 0;
      this.field3572 = 0;
      this.field3488 = false;
      this.field3528 = 0;
      this.field3529 = 0;
      this.field3535 = -1;
      this.field3527 = 0;
      this.field3540 = false;
      this.field3545 = "";
      this.field3547 = null;
      this.field3600 = 0;
      this.field3604 = 0;
      this.field3550 = false;
      this.field3515 = "";
      this.field3552 = false;
      this.field3536 = -1;
      this.field3594 = "";
      this.field3595 = class338.field3895;
      this.field3445 = -1;
      this.field3599 = 0;
      this.field3471 = 0;
      this.field3518 = 0;
      this.field3603 = false;
      this.field3491 = false;
      this.field3605 = -1;
      this.field3606 = 0;
      this.field3607 = 0;
      this.field3597 = 0;
      this.field3609 = -1;
      this.field3610 = -1;
      this.field3539 = false;
      this.field3449 = false;
      this.field3614 = false;
   }

   static {
      field3451 = new class366(10, class387.field4457);
      field3457 = new class366(10, class387.field4457);
      field3458 = false;
   }

   void method5839(class460 var1) {
      this.field3459 = false;
      this.field3462 = var1.method8134();
      this.field3463 = var1.method8134();
      this.field3464 = var1.method8115();
      this.field3469 = var1.method8197();
      this.field3470 = var1.method8197();
      this.field3486 = var1.method8115();
      this.field3472 = var1.method8115();
      this.field3612 = var1.method8134();
      this.field3596 = var1.method8115();
      if (65535 == this.field3596) {
         this.field3596 = -1;
      } else {
         this.field3596 += this.field3517 & -65536;
      }

      this.field3536 = var1.method8115();
      if (this.field3536 == 65535) {
         this.field3536 = -1;
      }

      int var3 = var1.method8134();
      int var4;
      if (var3 > 0) {
         this.field3591 = new int[var3];
         this.field3592 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3591[var4] = var1.method8134();
            this.field3592[var4] = var1.method8115();
         }
      }

      var4 = var1.method8134();
      int var5;
      int var6;
      int var7;
      if (var4 > 0) {
         this.field3613 = new int[var4][];

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var1.method8115();
            this.field3613[var5] = new int[var6];

            for(var7 = 0; var7 < var6; ++var7) {
               this.field3613[var5][var7] = var1.method8115();
               if (this.field3613[var5][var7] == 65535) {
                  this.field3613[var5][var7] = -1;
               }
            }
         }
      }

      if (0 == this.field3462) {
         this.field3492 = var1.method8115();
         this.field3480 = var1.method8134() == 1;
      }

      if (this.field3462 == 1) {
         var1.method8115();
         var1.method8134();
      }

      if (this.field3462 == 2) {
         this.field3461 = new int[this.field3486 * this.field3472];
         this.field3456 = new int[this.field3472 * this.field3486];
         var5 = var1.method8134();
         if (1 == var5) {
            this.field3527 |= 268435456;
         }

         var6 = var1.method8134();
         if (1 == var6) {
            this.field3527 |= 1073741824;
         }

         var7 = var1.method8134();
         if (1 == var7) {
            this.field3527 |= Integer.MIN_VALUE;
         }

         int var8 = var1.method8134();
         if (var8 == 1) {
            this.field3527 |= 536870912;
         }

         this.field3528 = var1.method8134();
         this.field3529 = var1.method8134();
         this.field3530 = new int[20];
         this.field3531 = new int[20];
         this.field3526 = new int[20];

         int var9;
         for(var9 = 0; var9 < 20; ++var9) {
            int var10 = var1.method8134();
            if (var10 == 1) {
               this.field3530[var9] = var1.method8197();
               this.field3531[var9] = var1.method8197();
               this.field3526[var9] = var1.method8119();
            } else {
               this.field3526[var9] = -1;
            }
         }

         this.field3533 = new String[5];

         for(var9 = 0; var9 < 5; ++var9) {
            String var12 = var1.method8124();
            if (var12.length() > 0) {
               this.field3533[var9] = var12;
               this.field3527 |= 1 << var9 + 23;
            }
         }
      }

      if (this.field3462 == 3) {
         this.field3489 = var1.method8134() == 1;
      }

      if (4 == this.field3462 || 1 == this.field3462) {
         this.field3525 = var1.method8134();
         this.field3572 = var1.method8134();
         this.field3524 = var1.method8134();
         this.field3521 = var1.method8115();
         if (this.field3521 == 65535) {
            this.field3521 = -1;
         }

         this.field3488 = var1.method8134() == 1;
      }

      if (4 == this.field3462) {
         this.field3522 = var1.method8124();
         this.field3523 = var1.method8124();
      }

      if (this.field3462 == 1 || this.field3462 == 3 || this.field3462 == 4) {
         this.field3485 = var1.method8119();
      }

      if (this.field3462 == 3 || 4 == this.field3462) {
         this.field3495 = var1.method8119();
         this.field3487 = var1.method8119();
         this.field3567 = var1.method8119();
      }

      if (5 == this.field3462) {
         this.field3560 = var1.method8119();
         this.field3496 = var1.method8119();
      }

      if (this.field3462 == 6) {
         this.field3504 = 1;
         this.field3505 = var1.method8115();
         if (this.field3505 == 65535) {
            this.field3505 = -1;
         }

         this.field3506 = 1;
         this.field3507 = var1.method8115();
         if (65535 == this.field3507) {
            this.field3507 = -1;
         }

         this.field3575 = var1.method8115();
         if (65535 == this.field3575) {
            this.field3575 = -1;
         }

         this.field3509 = var1.method8115();
         if (this.field3509 == 65535) {
            this.field3509 = -1;
         }

         this.field3562 = var1.method8115();
         this.field3601 = var1.method8115();
         this.field3513 = var1.method8115();
      }

      if (this.field3462 == 7) {
         this.field3461 = new int[this.field3472 * this.field3486];
         this.field3456 = new int[this.field3472 * this.field3486];
         this.field3525 = var1.method8134();
         this.field3521 = var1.method8115();
         if (this.field3521 == 65535) {
            this.field3521 = -1;
         }

         this.field3488 = var1.method8134() == 1;
         this.field3485 = var1.method8119();
         this.field3528 = var1.method8197();
         this.field3529 = var1.method8197();
         var5 = var1.method8134();
         if (var5 == 1) {
            this.field3527 |= 1073741824;
         }

         this.field3533 = new String[5];

         for(var6 = 0; var6 < 5; ++var6) {
            String var11 = var1.method8124();
            if (var11.length() > 0) {
               this.field3533[var6] = var11;
               this.field3527 |= 1 << 23 + var6;
            }
         }
      }

      if (8 == this.field3462) {
         this.field3522 = var1.method8124();
      }

      if (2 == this.field3463 || this.field3462 == 2) {
         this.field3515 = var1.method8124();
         this.field3594 = var1.method8124();
         var5 = var1.method8115() & 63;
         this.field3527 |= var5 << 11;
      }

      if (1 == this.field3463 || this.field3463 == 4 || 5 == this.field3463 || 6 == this.field3463) {
         this.field3595 = var1.method8124();
         if (this.field3595.length() == 0) {
            if (this.field3463 == 1) {
               this.field3595 = class338.field3895;
            }

            if (this.field3463 == 4) {
               this.field3595 = class338.field3896;
            }

            if (this.field3463 == 5) {
               this.field3595 = class338.field3896;
            }

            if (6 == this.field3463) {
               this.field3595 = class338.field3897;
            }
         }
      }

      if (1 == this.field3463 || 4 == this.field3463 || 5 == this.field3463) {
         this.field3527 |= 4194304;
      }

      if (6 == this.field3463) {
         this.field3527 |= 1;
      }

   }

   void method5840(class460 var1) {
      var1.method8134();
      this.field3459 = true;
      this.field3462 = var1.method8134();
      this.field3464 = var1.method8115();
      this.field3469 = var1.method8197();
      this.field3470 = var1.method8197();
      this.field3486 = var1.method8115();
      if (9 == this.field3462) {
         this.field3472 = var1.method8197();
      } else {
         this.field3472 = var1.method8115();
      }

      this.field3508 = var1.method8280();
      this.field3468 = var1.method8280();
      this.field3465 = var1.method8280();
      this.field3466 = var1.method8280();
      this.field3596 = var1.method8115();
      if (65535 == this.field3596) {
         this.field3596 = -1;
      } else {
         this.field3596 += this.field3517 & -65536;
      }

      this.field3480 = var1.method8134() == 1;
      if (this.field3462 == 0) {
         this.field3483 = var1.method8115();
         this.field3492 = var1.method8115();
         this.field3539 = var1.method8134() == 1;
      }

      if (5 == this.field3462) {
         this.field3560 = var1.method8119();
         this.field3498 = var1.method8115();
         this.field3499 = var1.method8134() == 1;
         this.field3612 = var1.method8134();
         this.field3500 = var1.method8134();
         this.field3501 = var1.method8119();
         this.field3467 = var1.method8134() == 1;
         this.field3503 = var1.method8134() == 1;
      }

      if (6 == this.field3462) {
         this.field3504 = 1;
         this.field3505 = var1.method8115();
         if (65535 == this.field3505) {
            this.field3505 = -1;
         }

         this.field3510 = var1.method8197();
         this.field3548 = var1.method8197();
         this.field3601 = var1.method8115();
         this.field3513 = var1.method8115();
         this.field3514 = var1.method8115();
         this.field3562 = var1.method8115();
         this.field3575 = var1.method8115();
         if (this.field3575 == 65535) {
            this.field3575 = -1;
         }

         this.field3534 = var1.method8134() == 1;
         var1.method8115();
         if (0 != this.field3508) {
            this.field3516 = var1.method8115();
         }

         if (this.field3468 != 0) {
            var1.method8115();
         }
      }

      if (4 == this.field3462) {
         this.field3521 = var1.method8115();
         if (this.field3521 == 65535) {
            this.field3521 = -1;
         }

         this.field3522 = var1.method8124();
         this.field3524 = var1.method8134();
         this.field3525 = var1.method8134();
         this.field3572 = var1.method8134();
         this.field3488 = var1.method8134() == 1;
         this.field3485 = var1.method8119();
      }

      if (3 == this.field3462) {
         this.field3485 = var1.method8119();
         this.field3489 = var1.method8134() == 1;
         this.field3612 = var1.method8134();
      }

      if (this.field3462 == 9) {
         this.field3493 = var1.method8134();
         this.field3485 = var1.method8119();
         this.field3494 = var1.method8134() == 1;
      }

      this.field3527 = var1.method8305();
      this.field3545 = var1.method8124();
      int var3 = var1.method8134();
      if (var3 > 0) {
         this.field3546 = new String[var3];

         for(int var4 = 0; var4 < var3; ++var4) {
            this.field3546[var4] = var1.method8124();
         }
      }

      this.field3600 = var1.method8134();
      this.field3604 = var1.method8134();
      this.field3550 = var1.method8134() == 1;
      this.field3515 = var1.method8124();
      this.field3553 = this.method5937(var1);
      this.field3558 = this.method5937(var1);
      this.field3454 = this.method5937(var1);
      this.field3598 = this.method5937(var1);
      this.field3563 = this.method5937(var1);
      this.field3565 = this.method5937(var1);
      this.field3585 = this.method5937(var1);
      this.field3569 = this.method5937(var1);
      this.field3571 = this.method5937(var1);
      this.field3549 = this.method5937(var1);
      this.field3559 = this.method5937(var1);
      this.field3611 = this.method5937(var1);
      this.field3555 = this.method5937(var1);
      this.field3556 = this.method5937(var1);
      this.field3557 = this.method5937(var1);
      this.field3478 = this.method5937(var1);
      this.field3537 = this.method5937(var1);
      this.field3574 = this.method5937(var1);
      this.field3566 = this.method5842(var1);
      this.field3568 = this.method5842(var1);
      this.field3570 = this.method5842(var1);
   }

   Object[] method5937(class460 var1) {
      int var3 = var1.method8134();
      if (0 == var3) {
         return null;
      } else {
         Object[] var4 = new Object[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            int var6 = var1.method8134();
            if (0 == var6) {
               var4[var5] = new Integer(var1.method8119());
            } else if (var6 == 1) {
               var4[var5] = var1.method8124();
            }
         }

         this.field3552 = true;
         return var4;
      }
   }

   int[] method5842(class460 var1) {
      int var3 = var1.method8134();
      if (0 == var3) {
         return null;
      } else {
         int[] var4 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var4[var5] = var1.method8119();
         }

         return var4;
      }
   }

   public void method5843(int var1, int var2) {
      int var4 = this.field3461[var2];
      this.field3461[var2] = this.field3461[var1];
      this.field3461[var1] = var4;
      var4 = this.field3456[var2];
      this.field3456[var2] = this.field3456[var1];
      this.field3456[var1] = var4;
   }

   public class473 method5844(boolean var1, class115 var2) {
      field3458 = false;
      if (this.field3497 != null) {
         class473 var4 = this.method5859(var2);
         if (var4 != null) {
            return var4;
         }
      }

      int var8;
      if (var1) {
         var8 = this.field3496;
      } else {
         var8 = this.field3560;
      }

      if (-1 == var8) {
         return null;
      } else {
         long var5 = ((this.field3467 ? 1L : 0L) << 38) + ((long)this.field3500 << 36) + (long)var8 + ((this.field3503 ? 1L : 0L) << 39) + ((long)this.field3501 << 40);
         class473 var7 = (class473)field3554.method5439(var5);
         if (var7 != null) {
            return var7;
         } else {
            var7 = class389.method7007(class299.field3439, var8, 0);
            if (var7 == null) {
               field3458 = true;
               return null;
            } else {
               this.method5847(var7);
               field3554.method5434(var7, var5);
               return var7;
            }
         }
      }
   }

   class473 method5859(class115 var1) {
      if (!this.method5846()) {
         return this.method5845(var1);
      } else {
         String var3 = this.field3497 + (this.field3467 ? 1 : 0) + (this.field3503 ? 1 : 0) + this.field3500 + this.field3501;
         class473 var4 = (class473)field3457.method6677(var3);
         if (null == var4) {
            class473 var5 = this.method5845(var1);
            if (var5 != null) {
               var4 = var5.method8467();
               this.method5847(var4);
               field3457.method6678(var3, var4);
            }
         }

         return var4;
      }
   }

   class473 method5845(class115 var1) {
      if (null != this.field3497 && var1 != null) {
         class312 var3 = (class312)field3451.method6677(this.field3497);
         if (var3 == null) {
            var3 = new class312(this.field3497, var1);
            field3451.method6678(this.field3497, var3);
         }

         return var3.method6050();
      } else {
         return null;
      }
   }

   boolean method5846() {
      return this.field3467 || this.field3503 || 0 != this.field3500 || this.field3501 != 0;
   }

   void method5847(class473 var1) {
      if (this.field3467) {
         var1.method8473();
      }

      if (this.field3503) {
         var1.method8576();
      }

      if (this.field3500 > 0) {
         var1.method8471(this.field3500);
      }

      if (this.field3500 >= 1) {
         var1.method8511(1);
      }

      if (this.field3500 >= 2) {
         var1.method8511(16777215);
      }

      if (0 != this.field3501) {
         var1.method8475(this.field3501);
      }

   }

   public class376 method5848() {
      field3458 = false;
      if (this.field3521 == -1) {
         return null;
      } else {
         class376 var2 = (class376)field3538.method5439((long)this.field3521);
         if (var2 != null) {
            return var2;
         } else {
            var2 = class378.method6798(class299.field3439, class246.field2881, this.field3521, 0);
            if (null != var2) {
               field3538.method5434(var2, (long)this.field3521);
            } else {
               field3458 = true;
            }

            return var2;
         }
      }
   }

   public class473 method5849(int var1) {
      field3458 = false;
      if (var1 >= 0 && var1 < this.field3526.length) {
         int var3 = this.field3526[var1];
         if (-1 == var3) {
            return null;
         } else {
            class473 var4 = (class473)field3554.method5439((long)var3);
            if (var4 != null) {
               return var4;
            } else {
               var4 = class389.method7007(class299.field3439, var3, 0);
               if (null != var4) {
                  field3554.method5434(var4, (long)var3);
               } else {
                  field3458 = true;
               }

               return var4;
            }
         }
      } else {
         return null;
      }
   }

   public class209 method5850(class189 var1, int var2, boolean var3, class305 var4) {
      field3458 = false;
      int var6;
      int var7;
      if (var3) {
         var6 = this.field3506;
         var7 = this.field3507;
      } else {
         var6 = this.field3504;
         var7 = this.field3505;
      }

      if (0 == var6) {
         return null;
      } else if (var6 == 1 && -1 == var7) {
         return null;
      } else {
         class209 var8 = (class209)field3453.method5439((long)((var6 << 16) + var7));
         if (var8 == null) {
            class201 var9;
            if (var6 == 1) {
               var9 = class201.method3774(class202.field2254, var7, 0);
               if (null == var9) {
                  field3458 = true;
                  return null;
               }

               var8 = var9.method3796(64, 768, -50, -10, -50);
            }

            if (var6 == 2) {
               var9 = class158.method2632(var7).method3885();
               if (var9 == null) {
                  field3458 = true;
                  return null;
               }

               var8 = var9.method3796(64, 768, -50, -10, -50);
            }

            if (var6 == 3) {
               if (null == var4) {
                  return null;
               }

               var9 = var4.method5996();
               if (null == var9) {
                  field3458 = true;
                  return null;
               }

               var8 = var9.method3796(64, 768, -50, -10, -50);
            }

            if (4 == var6) {
               class198 var10 = class278.method5388(var7);
               var9 = var10.method3665(10);
               if (null == var9) {
                  field3458 = true;
                  return null;
               }

               var8 = var9.method3796(64 + var10.field2159, var10.field2171 + 768, -50, -10, -50);
            }

            field3453.method5434(var8, (long)(var7 + (var6 << 16)));
         }

         if (null != var1) {
            var8 = var1.method3474(var8, var2);
         }

         return var8;
      }
   }

   public class298 method5851(boolean var1) {
      if (this.field3496 == -1) {
         var1 = false;
      }

      int var3 = var1 ? -455779275 * this.field3496 * 1934104093 : this.field3560 * -787225125 * -784888237;
      if (-1 == var3) {
         return null;
      } else {
         long var4 = ((long)this.field3501 << 40) + ((long)this.field3500 << 36) + (long)var3 + ((this.field3467 ? 1L : 0L) << 38) + ((this.field3503 ? 1L : 0L) << 39);
         class298 var6 = (class298)field3455.method5439(var4);
         if (var6 != null) {
            return var6;
         } else {
            class473 var7 = this.method5844(var1, (class115)null);
            if (var7 == null) {
               return null;
            } else {
               class473 var8 = var7.method8468();
               int[] var9 = new int[var8.field4951];
               int[] var10 = new int[var8.field4951];

               for(int var11 = 0; var11 < var8.field4951; ++var11) {
                  int var12 = 0;
                  int var13 = var8.field4959;

                  int var14;
                  for(var14 = 0; var14 < var8.field4959; ++var14) {
                     if (0 == var8.field4952[var14 + var11 * var8.field4959]) {
                        var12 = var14;
                        break;
                     }
                  }

                  for(var14 = var8.field4959 - 1; var14 >= var12; --var14) {
                     if (var8.field4952[var11 * var8.field4959 + var14] == 0) {
                        var13 = 1 + var14;
                        break;
                     }
                  }

                  var9[var11] = var12;
                  var10[var11] = var13 - var12;
               }

               var6 = new class298(var8.field4959, var8.field4951, var10, var9, var3);
               field3455.method5434(var6, var4);
               return var6;
            }
         }
      }
   }

   public static void method5837() {
      field3554.method5437();
      field3453.method5437();
      field3538.method5437();
      field3455.method5437();
   }

   public void method5852(int var1, String var2) {
      if (this.field3546 == null || this.field3546.length <= var1) {
         String[] var4 = new String[var1 + 1];
         if (this.field3546 != null) {
            for(int var5 = 0; var5 < this.field3546.length; ++var5) {
               var4[var5] = this.field3546[var5];
            }
         }

         this.field3546 = var4;
      }

      this.field3546[var1] = var2;
   }

   public boolean method5901() {
      return !this.field3459 || this.field3462 == 0 || this.field3462 == 11 || this.field3552 || this.field3464 == 1338 || this.field3462 == 12;
   }

   public boolean method5854() {
      return this.field3462 == 11 || this.field3462 == 12;
   }

   public void method5855(String var1, class115 var2, long var3) {
      if (11 == this.field3462 && -1L != var3) {
         var1 = var1.replaceAll("%userid%", Long.toString(var3));
         this.field3460 = new class176();
         if (!this.field3460.method2757(var1, var2)) {
            this.field3460 = null;
         } else {
            if (null == this.field3532 || this.field3608 == null) {
               this.method5978();
            }

         }
      }
   }

   void method5978() {
      this.field3532 = new HashMap();
      this.field3608 = new HashMap();
   }

   public void method5867(int var1, int var2) {
      if (this.field3462 == 11) {
         if (null == this.field3532) {
            this.method5978();
         }

         this.field3532.put(var1, var2);
      }
   }

   public void method5858(String var1, int var2) {
      if (11 == this.field3462) {
         if (null == this.field3608) {
            this.method5978();
         }

         this.field3608.put(var1, var2);
      }
   }

   public boolean method5868() {
      return this.field3535 == 2;
   }

   public int method5860(String var1) {
      return 11 == this.field3462 && this.field3460 != null && this.method5868() ? this.field3460.method2760(var1) : -1;
   }

   public String method5929(String var1) {
      return this.field3462 == 11 && this.field3460 != null && this.method5868() ? this.field3460.method2761(var1) : null;
   }

   public int method5862() {
      return this.field3608 != null && this.field3608.size() > 0 ? 1 : 0;
   }

   public int method5863() {
      if (this.field3462 == 11 && this.field3460 != null && null != this.field3608 && !this.field3608.isEmpty()) {
         String var2 = this.field3460.method2764();
         return var2 != null && this.field3608.containsKey(this.field3460.method2764()) ? (Integer)this.field3608.get(var2) : -1;
      } else {
         return -1;
      }
   }

   public String method5864() {
      if (this.field3462 == 11 && null != this.field3460) {
         String var2 = this.field3460.method2764();
         Iterator var3 = this.field3460.method2765().iterator();

         while(var3.hasNext()) {
            class162 var4 = (class162)var3.next();
            String var5 = String.format("%%%S%%", var4.method2677());
            if (var4.method2671() == 0) {
               var2.replaceAll(var5, Integer.toString(var4.method2670()));
            } else {
               var2.replaceAll(var5, var4.method2672());
            }
         }

         return var2;
      } else {
         return null;
      }
   }

   public int[] method5925() {
      if (11 == this.field3462 && null != this.field3460) {
         int[] var2 = new int[3];
         int var3 = 0;
         Iterator var4 = this.field3460.method2765().iterator();

         while(var4.hasNext()) {
            class162 var5 = (class162)var4.next();
            if (!var5.method2677().equals("user_id")) {
               if (var5.method2671() != 0) {
                  return null;
               }

               var2[var3++] = var5.method2670();
               if (var3 > 3) {
                  return null;
               }
            }
         }

         return var2;
      } else {
         return null;
      }
   }

   public boolean method5866(class115 var1) {
      if (11 == this.field3462 && null != this.field3460) {
         this.field3460.method2758(var1);
         if (this.field3460.method2796() != this.field3535) {
            this.field3535 = this.field3460.method2796();
            if (this.field3535 >= 100) {
               return true;
            }

            if (this.field3535 == 2) {
               this.method5923();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   static class300 method3713(int var0, class300 var1, int var2, int var3, int var4, int var5, int var6, float[] var7) {
      class300 var9 = new class300();
      var9.field3462 = var0;
      var9.field3596 = var1.field3517;
      var9.field3484 = var2;
      var9.field3459 = true;
      var9.field3465 = var3;
      var9.field3466 = var4;
      var9.field3508 = var5;
      var9.field3468 = var6;
      var9.field3469 = (int)(var7[0] * (float)var1.field3448);
      var9.field3470 = (int)((float)var1.field3476 * var7[1]);
      var9.field3486 = (int)((float)var1.field3448 * var7[2]);
      var9.field3472 = (int)((float)var1.field3476 * var7[3]);
      return var9;
   }

   void method5923() {
      this.field3539 = true;
      ArrayList var2 = this.field3460.method2762();
      ArrayList var3 = this.field3460.method2811();
      int var4 = var2.size() + var3.size();
      this.field3602 = new class300[var4];
      int var5 = 0;

      Iterator var6;
      class300 var8;
      for(var6 = var2.iterator(); var6.hasNext(); this.field3602[var5++] = var8) {
         class164 var7 = (class164)var6.next();
         var8 = method3713(5, this, var5, 0, 0, 0, 0, var7.field1514);
         var8.field3497 = var7.field1515.method2103();
         class312 var9 = new class312(var7.field1515);
         field3451.method6678(var8.field3497, var9);
      }

      for(var6 = var3.iterator(); var6.hasNext(); this.field3602[var5++] = var8) {
         class165 var10 = (class165)var6.next();
         var8 = method3713(4, this, var5, 0, 0, 0, 0, var10.field1516);
         var8.field3522 = var10.field1518;
         var8.field3521 = (Integer)this.field3532.get(var10.field1522);
         var8.field3525 = var10.field1520;
         var8.field3572 = var10.field1521;
      }

   }

   public void method5913() {
      this.field3474 = new class310();

      for(int var2 = 1; var2 <= 12; ++var2) {
         this.field3474.field3682.method615(var2, 0);
      }

      for(char var3 = 0; var3 < ' '; ++var3) {
         this.field3474.field3682.method616(var3, 0);
      }

      this.field3474.field3682.method616('\u0080', 0);
      this.field3474.field3682.method615(82, 2);
      this.field3474.field3682.method615(81, 2);
      this.field3474.field3682.method615(86, 2);
   }

   public class297 method5869() {
      return this.field3474 != null ? this.field3474.field3690 : null;
   }

   public class302 method5946() {
      return null != this.field3474 ? this.field3474.field3681 : null;
   }

   public class34 method5871() {
      return this.field3474 != null ? this.field3474.field3682 : null;
   }

   public class310 method5872() {
      return this.field3474;
   }

   boolean method5885(class297 var1) {
      boolean var3 = false;
      if (this.field3522 != null && !this.field3522.isEmpty()) {
         var3 |= var1.method5554(class95.method1955(this.field3522));
         this.field3522 = "";
      }

      if (this.field3523 != null && !this.field3523.isEmpty()) {
         var3 |= var1.method5575(class95.method1955(this.field3523));
         this.field3523 = "";
      }

      return var3;
   }

   public boolean method5918() {
      class297 var2 = this.method5869();
      if (var2 == null) {
         return false;
      } else {
         boolean var3 = false;
         if (!var2.method5691() && this.field3521 != -1) {
            int var4 = var2.method5609();
            int var5 = var2.method5677();
            int var6 = var2.method5683();
            int var7 = var2.method5606();
            class376 var8 = this.method5848();
            if (null != var8) {
               var3 |= var2.method5556(var8);
               var3 |= this.method5885(var2);
               var3 |= var2.method5731(var4, var5);
               var3 |= var2.method5576(var6, var7);
            }
         } else if (var2.method5691()) {
            var3 |= this.method5885(var2);
         }

         var2.method5730();
         return var3;
      }
   }
}
