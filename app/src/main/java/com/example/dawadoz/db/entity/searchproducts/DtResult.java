
package com.example.dawadoz.db.entity.searchproducts;

import com.google.gson.annotations.SerializedName;

public class DtResult {

    @SerializedName("CategoryID")
    private Long mCategoryID;
    @SerializedName("CompanyName")
    private String mCompanyName;
    @SerializedName("FormID")
    private Long mFormID;
    @SerializedName("FormName")
    private String mFormName;
    @SerializedName("FormName_AR")
    private String mFormNameAR;
    @SerializedName("FormNameAll")
    private String mFormNameAll;
    @SerializedName("FormQuantity")
    private Object mFormQuantity;
    @SerializedName("IsDividable")
    private Boolean mIsDividable;
    @SerializedName("IsPremuim")
    private Boolean mIsPremuim;
    @SerializedName("IsRewards")
    private Boolean mIsRewards;
    @SerializedName("ItemType")
    private Long mItemType;
    @SerializedName("PackingName_AR")
    private Object mPackingNameAR;
    @SerializedName("PackingName_EN")
    private Object mPackingNameEN;
    @SerializedName("Parent_CategoryID")
    private Long mParentCategoryID;
    @SerializedName("Premium_MoneyValue")
    private Long mPremiumMoneyValue;
    @SerializedName("Premium_MoneyValue_ExpireAfter")
    private Long mPremiumMoneyValueExpireAfter;
    @SerializedName("ProductID")
    private Long mProductID;
    @SerializedName("ProductImage")
    private String mProductImage;
    @SerializedName("ProductName_AR")
    private String mProductNameAR;
    @SerializedName("ProductName_EN")
    private String mProductNameEN;
    @SerializedName("RateScore")
    private Double mRateScore;
    @SerializedName("SubPrice")
    private Long mSubPrice;
    @SerializedName("TotalPrice")
    private Long mTotalPrice;
    @SerializedName("TotalRatesCount")
    private Long mTotalRatesCount;
    @SerializedName("UsedFor")
    private String mUsedFor;

    public Long getCategoryID() {
        return mCategoryID;
    }

    public void setCategoryID(Long categoryID) {
        mCategoryID = categoryID;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public Long getFormID() {
        return mFormID;
    }

    public void setFormID(Long formID) {
        mFormID = formID;
    }

    public String getFormName() {
        return mFormName;
    }

    public void setFormName(String formName) {
        mFormName = formName;
    }

    public String getFormNameAR() {
        return mFormNameAR;
    }

    public void setFormNameAR(String formNameAR) {
        mFormNameAR = formNameAR;
    }

    public String getFormNameAll() {
        return mFormNameAll;
    }

    public void setFormNameAll(String formNameAll) {
        mFormNameAll = formNameAll;
    }

    public Object getFormQuantity() {
        return mFormQuantity;
    }

    public void setFormQuantity(Object formQuantity) {
        mFormQuantity = formQuantity;
    }

    public Boolean getIsDividable() {
        return mIsDividable;
    }

    public void setIsDividable(Boolean isDividable) {
        mIsDividable = isDividable;
    }

    public Boolean getIsPremuim() {
        return mIsPremuim;
    }

    public void setIsPremuim(Boolean isPremuim) {
        mIsPremuim = isPremuim;
    }

    public Boolean getIsRewards() {
        return mIsRewards;
    }

    public void setIsRewards(Boolean isRewards) {
        mIsRewards = isRewards;
    }

    public Long getItemType() {
        return mItemType;
    }

    public void setItemType(Long itemType) {
        mItemType = itemType;
    }

    public Object getPackingNameAR() {
        return mPackingNameAR;
    }

    public void setPackingNameAR(Object packingNameAR) {
        mPackingNameAR = packingNameAR;
    }

    public Object getPackingNameEN() {
        return mPackingNameEN;
    }

    public void setPackingNameEN(Object packingNameEN) {
        mPackingNameEN = packingNameEN;
    }

    public Long getParentCategoryID() {
        return mParentCategoryID;
    }

    public void setParentCategoryID(Long parentCategoryID) {
        mParentCategoryID = parentCategoryID;
    }

    public Long getPremiumMoneyValue() {
        return mPremiumMoneyValue;
    }

    public void setPremiumMoneyValue(Long premiumMoneyValue) {
        mPremiumMoneyValue = premiumMoneyValue;
    }

    public Long getPremiumMoneyValueExpireAfter() {
        return mPremiumMoneyValueExpireAfter;
    }

    public void setPremiumMoneyValueExpireAfter(Long premiumMoneyValueExpireAfter) {
        mPremiumMoneyValueExpireAfter = premiumMoneyValueExpireAfter;
    }

    public Long getProductID() {
        return mProductID;
    }

    public void setProductID(Long productID) {
        mProductID = productID;
    }

    public String getProductImage() {
        return mProductImage;
    }

    public void setProductImage(String productImage) {
        mProductImage = productImage;
    }

    public String getProductNameAR() {
        return mProductNameAR;
    }

    public void setProductNameAR(String productNameAR) {
        mProductNameAR = productNameAR;
    }

    public String getProductNameEN() {
        return mProductNameEN;
    }

    public void setProductNameEN(String productNameEN) {
        mProductNameEN = productNameEN;
    }

    public Double getRateScore() {
        return mRateScore;
    }

    public void setRateScore(Double rateScore) {
        mRateScore = rateScore;
    }

    public Long getSubPrice() {
        return mSubPrice;
    }

    public void setSubPrice(Long subPrice) {
        mSubPrice = subPrice;
    }

    public Long getTotalPrice() {
        return mTotalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        mTotalPrice = totalPrice;
    }

    public Long getTotalRatesCount() {
        return mTotalRatesCount;
    }

    public void setTotalRatesCount(Long totalRatesCount) {
        mTotalRatesCount = totalRatesCount;
    }

    public String getUsedFor() {
        return mUsedFor;
    }

    public void setUsedFor(String usedFor) {
        mUsedFor = usedFor;
    }

}
