package com.kjj.commserver.entity.goods;

public class OrgProductImg {
    /**  */
    private Integer imgId;

    /** spuId */
    private Integer goodsId;

    /** 图片Url */
    private String imgUrl;

    /** 图片描述（暂未使用） */
    private String imgDesc;

    /** 缩略图Url（暂未使用） */
    private String thumbUrl;

    /** 原图（暂未使用） */
    private String imgOriginal;

    /** skuId（新增） */
    private Integer itemGoodsId;

    /** 商品分类id （新增）*/
    private Integer productClassId;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc == null ? null : imgDesc.trim();
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl == null ? null : thumbUrl.trim();
    }

    public String getImgOriginal() {
        return imgOriginal;
    }

    public void setImgOriginal(String imgOriginal) {
        this.imgOriginal = imgOriginal == null ? null : imgOriginal.trim();
    }

    public Integer getItemGoodsId() {
        return itemGoodsId;
    }

    public void setItemGoodsId(Integer itemGoodsId) {
        this.itemGoodsId = itemGoodsId;
    }

    public Integer getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(Integer productClassId) {
        this.productClassId = productClassId;
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
        OrgProductImg other = (OrgProductImg) that;
        return (this.getImgId() == null ? other.getImgId() == null : this.getImgId().equals(other.getImgId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getImgDesc() == null ? other.getImgDesc() == null : this.getImgDesc().equals(other.getImgDesc()))
            && (this.getThumbUrl() == null ? other.getThumbUrl() == null : this.getThumbUrl().equals(other.getThumbUrl()))
            && (this.getImgOriginal() == null ? other.getImgOriginal() == null : this.getImgOriginal().equals(other.getImgOriginal()))
            && (this.getItemGoodsId() == null ? other.getItemGoodsId() == null : this.getItemGoodsId().equals(other.getItemGoodsId()))
            && (this.getProductClassId() == null ? other.getProductClassId() == null : this.getProductClassId().equals(other.getProductClassId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImgId() == null) ? 0 : getImgId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getImgDesc() == null) ? 0 : getImgDesc().hashCode());
        result = prime * result + ((getThumbUrl() == null) ? 0 : getThumbUrl().hashCode());
        result = prime * result + ((getImgOriginal() == null) ? 0 : getImgOriginal().hashCode());
        result = prime * result + ((getItemGoodsId() == null) ? 0 : getItemGoodsId().hashCode());
        result = prime * result + ((getProductClassId() == null) ? 0 : getProductClassId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imgId=").append(imgId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", imgDesc=").append(imgDesc);
        sb.append(", thumbUrl=").append(thumbUrl);
        sb.append(", imgOriginal=").append(imgOriginal);
        sb.append(", itemGoodsId=").append(itemGoodsId);
        sb.append(", productClassId=").append(productClassId);
        sb.append("]");
        return sb.toString();
    }
}