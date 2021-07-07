
package com.example.dawadoz.db.entity.searchproducts;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("dtResult")
    private List<DtResult> mDtResult;
    @SerializedName("Product_Images_Path")
    private String mProductImagesPath;

    public List<DtResult> getDtResult() {
        return mDtResult;
    }

    public void setDtResult(List<DtResult> dtResult) {
        mDtResult = dtResult;
    }

    public String getProductImagesPath() {
        return mProductImagesPath;
    }

    public void setProductImagesPath(String productImagesPath) {
        mProductImagesPath = productImagesPath;
    }

}
