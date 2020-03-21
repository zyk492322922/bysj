package com.ruoyi.web.controller.userMobile.domain;

/**
 * Created by zyk on 2020/3/21.
 */
public class TUserMobileDto extends TUserMobile {

    private String assetCode;

    private String userName;

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
