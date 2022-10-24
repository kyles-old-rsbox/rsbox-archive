package com.jagex.oldscape.pub;

public interface RefreshAccessTokenResponse {
	String getAccessToken();

	boolean isSuccess();

	String getRefreshToken();
}
