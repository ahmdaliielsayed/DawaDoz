
package com.example.dawadoz.db.entity;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("Message")
    private String mMessage;
    @SerializedName("Result")
    private ResultLogin mResultLogin;
    @SerializedName("Status")
    private String mStatus;
    @SerializedName("Total_Count")
    private Object mTotalCount;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public ResultLogin getResult() {
        return mResultLogin;
    }

    public void setResult(ResultLogin resultLogin) {
        mResultLogin = resultLogin;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Object getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Object totalCount) {
        mTotalCount = totalCount;
    }

}
