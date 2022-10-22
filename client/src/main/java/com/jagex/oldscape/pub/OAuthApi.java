package com.jagex.oldscape.pub;

public interface OAuthApi {
   void ns(OtlTokenRequester var1);

   void setRefreshTokenRequester(RefreshAccessTokenRequester var1);

   boolean isOnLoginScreen();

   long nn();

   long getAccountHash();

   long nr();

   void nx(OtlTokenRequester var1);

   void nv(RefreshAccessTokenRequester var1);

   void nf(RefreshAccessTokenRequester var1);

   void setOtlTokenRequester(OtlTokenRequester var1);

   long nm();

   void nt(OtlTokenRequester var1);
}
