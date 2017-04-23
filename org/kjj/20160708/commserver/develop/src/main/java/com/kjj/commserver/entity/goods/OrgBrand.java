package com.kjj.commserver.entity.goods;

public class OrgBrand {
    /**  */
    private Integer productBrandId;

    /** 产品 品牌编号 */
    private String productStoreCode;

    /** 产品 品牌名称 */
    private String productBrandName;

    /** 品牌 图片 */
    private String productBrandLogoimage;

    /** 当前状态 */
    private String isActive;

    /**  */
    private Integer brandOrder;

    /** 该品牌下产品数量 */
    private Integer brandProductCount;

    /**暂无数据*/
    private String brandRecommand;

    /** 暂无数据 */
    private Integer brandTypeId;

    /**  */
    private String brand1;

    /**  */
    private String brand2;

    /**  */
    private String brand3;

    /** 品牌介绍 */
    private String productBrandIntro;

    /** 品牌所属分类字符串 */
    private String brandTypeStr;

    public Integer getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(Integer productBrandId) {
        this.productBrandId = productBrandId;
    }

    public String getProductStoreCode() {
        return productStoreCode;
    }

    public void setProductStoreCode(String productStoreCode) {
        this.productStoreCode = productStoreCode == null ? null : productStoreCode.trim();
    }

    public String getProductBrandName() {
        return productBrandName;
    }

    public void setProductBrandName(String productBrandName) {
        this.productBrandName = productBrandName == null ? null : productBrandName.trim();
    }

    public String getProductBrandLogoimage() {
        return productBrandLogoimage;
    }

    public void setProductBrandLogoimage(String productBrandLogoimage) {
        this.productBrandLogoimage = productBrandLogoimage == null ? null : productBrandLogoimage.trim();
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    public Integer getBrandOrder() {
        return brandOrder;
    }

    public void setBrandOrder(Integer brandOrder) {
        this.brandOrder = brandOrder;
    }

    public Integer getBrandProductCount() {
        return brandProductCount;
    }

    public void setBrandProductCount(Integer brandProductCount) {
        this.brandProductCount = brandProductCount;
    }

    public String getBrandRecommand() {
        return brandRecommand;
    }

    public void setBrandRecommand(String brandRecommand) {
        this.brandRecommand = brandRecommand == null ? null : brandRecommand.trim();
    }

    public Integer getBrandTypeId() {
        return brandTypeId;
    }

    public void setBrandTypeId(Integer brandTypeId) {
        this.brandTypeId = brandTypeId;
    }

    public String getBrand1() {
        return brand1;
    }

    public void setBrand1(String brand1) {
        this.brand1 = brand1 == null ? null : brand1.trim();
    }

    public String getBrand2() {
        return brand2;
    }

    public void setBrand2(String brand2) {
        this.brand2 = brand2 == null ? null : brand2.trim();
    }

    public String getBrand3() {
        return brand3;
    }

    public void setBrand3(String brand3) {
        this.brand3 = brand3 == null ? null : brand3.trim();
    }

    public String getProductBrandIntro() {
        return productBrandIntro;
    }

    public void setProductBrandIntro(String productBrandIntro) {
        this.productBrandIntro = productBrandIntro == null ? null : productBrandIntro.trim();
    }

    public String getBrandTypeStr() {
        return brandTypeStr;
    }

    public void setBrandTypeStr(String brandTypeStr) {
        this.brandTypeStr = brandTypeStr == null ? null : brandTypeStr.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrgBrand other = (OrgBrand) that;
        return (this.getProductBrandId() == null ? other.getProductBrandId() == null : this.getProductBrandId().equals(other.getProductBrandId()))
            && (this.getProductStoreCode() == null ? other.getProductStoreCode() == null : this.getProductStoreCode().equals(other.getProductStoreCode()))
            && (this.getProductBrandName() == null ? other.getProductBrandName() == null : this.getProductBrandName().equals(other.getProductBrandName()))
            && (this.getProductBrandLogoimage() == null ? other.getProductBrandLogoimage() == null : this.getProductBrandLogoimage().equals(other.getProductBrandLogoimage()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()))
            && (this.getBrandOrder() == null ? other.getBrandOrder() == null : this.getBrandOrder().equals(other.getBrandOrder()))
            && (this.getBrandProductCount() == null ? other.getBrandProductCount() == null : this.getBrandProductCount().equals(other.getBrandProductCount()))
            && (this.getBrandRecommand() == null ? other.getBrandRecommand() == null : this.getBrandRecommand().equals(other.getBrandRecommand()))
            && (this.getBrandTypeId() == null ? other.getBrandTypeId() == null : this.getBrandTypeId().equals(other.getBrandTypeId()))
            && (this.getBrand1() == null ? other.getBrand1() == null : this.getBrand1().equals(other.getBrand1()))
            && (this.getBrand2() == null ? other.getBrand2() == null : this.getBrand2().equals(other.getBrand2()))
            && (this.getBrand3() == null ? other.getBrand3() == null : this.getBrand3().equals(other.getBrand3()))
            && (this.getProductBrandIntro() == null ? other.getProductBrandIntro() == null : this.getProductBrandIntro().equals(other.getProductBrandIntro()))
            && (this.getBrandTypeStr() == null ? other.getBrandTypeStr() == null : this.getBrandTypeStr().equals(other.getBrandTypeStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductBrandId() == null) ? 0 : getProductBrandId().hashCode());
        result = prime * result + ((getProductStoreCode() == null) ? 0 : getProductStoreCode().hashCode());
        result = prime * result + ((getProductBrandName() == null) ? 0 : getProductBrandName().hashCode());
        result = prime * result + ((getProductBrandLogoimage() == null) ? 0 : getProductBrandLogoimage().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        result = prime * result + ((getBrandOrder() == null) ? 0 : getBrandOrder().hashCode());
        result = prime * result + ((getBrandProductCount() == null) ? 0 : getBrandProductCount().hashCode());
        result = prime * result + ((getBrandRecommand() == null) ? 0 : getBrandRecommand().hashCode());
        result = prime * result + ((getBrandTypeId() == null) ? 0 : getBrandTypeId().hashCode());
        result = prime * result + ((getBrand1() == null) ? 0 : getBrand1().hashCode());
        result = prime * result + ((getBrand2() == null) ? 0 : getBrand2().hashCode());
        result = prime * result + ((getBrand3() == null) ? 0 : getBrand3().hashCode());
        result = prime * result + ((getProductBrandIntro() == null) ? 0 : getProductBrandIntro().hashCode());
        result = prime * result + ((getBrandTypeStr() == null) ? 0 : getBrandTypeStr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productBrandId=").append(productBrandId);
        sb.append(", productStoreCode=").append(productStoreCode);
        sb.append(", productBrandName=").append(productBrandName);
        sb.append(", productBrandLogoimage=").append(productBrandLogoimage);
        sb.append(", isActive=").append(isActive);
        sb.append(", brandOrder=").append(brandOrder);
        sb.append(", brandProductCount=").append(brandProductCount);
        sb.append(", brandRecommand=").append(brandRecommand);
        sb.append(", brandTypeId=").append(brandTypeId);
        sb.append(", brand1=").append(brand1);
        sb.append(", brand2=").append(brand2);
        sb.append(", brand3=").append(brand3);
        sb.append(", productBrandIntro=").append(productBrandIntro);
        sb.append(", brandTypeStr=").append(brandTypeStr);
        sb.append("]");
        return sb.toString();
    }
}