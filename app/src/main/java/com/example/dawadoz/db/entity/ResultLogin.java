
package com.example.dawadoz.db.entity;

import com.google.gson.annotations.SerializedName;

public class ResultLogin {

    @SerializedName("DisplayName")
    private Object mDisplayName;
    @SerializedName("PharmacyId")
    private Object mPharmacyId;
    @SerializedName("PharmacyLogo")
    private Object mPharmacyLogo;
    @SerializedName("PharmacyName")
    private Object mPharmacyName;
    @SerializedName("UserId")
    private String mUserId;
    @SerializedName("UserName")
    private String mUserName;
    @SerializedName("UserType")
    private Long mUserType;

    public Object getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(Object displayName) {
        mDisplayName = displayName;
    }

    public Object getPharmacyId() {
        return mPharmacyId;
    }

    public void setPharmacyId(Object pharmacyId) {
        mPharmacyId = pharmacyId;
    }

    public Object getPharmacyLogo() {
        return mPharmacyLogo;
    }

    public void setPharmacyLogo(Object pharmacyLogo) {
        mPharmacyLogo = pharmacyLogo;
    }

    public Object getPharmacyName() {
        return mPharmacyName;
    }

    public void setPharmacyName(Object pharmacyName) {
        mPharmacyName = pharmacyName;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public Long getUserType() {
        return mUserType;
    }

    public void setUserType(Long userType) {
        mUserType = userType;
    }

}
