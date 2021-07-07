
package com.example.dawadoz.db.entity.searchproducts;

import com.google.gson.annotations.SerializedName;

public class SearchProductsResponse {

    @SerializedName("Message")
    private String mMessage;
    @SerializedName("Result")
    private Result mResult;
    @SerializedName("Status")
    private String mStatus;
    @SerializedName("Total_Count")
    private Double mTotalCount;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Double getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Double totalCount) {
        mTotalCount = totalCount;
    }

}
