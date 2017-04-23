package com.kjj.commserver.entity.goods;

import java.util.Date;

public class OrgTradeSnapshoot {
    /** 交易快照id */
    private Integer tradeSnapshootId;

    /** skuId */
    private Integer goodsId;

    /** 商品货号 */
    private String goodsSn;

    /** 商品名称 */
    private String goodsName;

    /** 创建时间 */
    private Date createTime;

    /** 交易快照商品主图 */
    private String imgUrl;

    /** pc端详情 */
    private String pcGoodsDesc;

    /** 移动端详情 */
    private String mobileGoodsDesc;

    public Integer getTradeSnapshootId() {
        return tradeSnapshootId;
    }

    public void setTradeSnapshootId(Integer tradeSnapshootId) {
        this.tradeSnapshootId = tradeSnapshootId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getPcGoodsDesc() {
        return pcGoodsDesc;
    }

    public void setPcGoodsDesc(String pcGoodsDesc) {
        this.pcGoodsDesc = pcGoodsDesc == null ? null : pcGoodsDesc.trim();
    }

    public String getMobileGoodsDesc() {
        return mobileGoodsDesc;
    }

    public void setMobileGoodsDesc(String mobileGoodsDesc) {
        this.mobileGoodsDesc = mobileGoodsDesc == null ? null : mobileGoodsDesc.trim();
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
        OrgTradeSnapshoot other = (OrgTradeSnapshoot) that;
        return (this.getTradeSnapshootId() == null ? other.getTradeSnapshootId() == null : this.getTradeSnapshootId().equals(other.getTradeSnapshootId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getPcGoodsDesc() == null ? other.getPcGoodsDesc() == null : this.getPcGoodsDesc().equals(other.getPcGoodsDesc()))
            && (this.getMobileGoodsDesc() == null ? other.getMobileGoodsDesc() == null : this.getMobileGoodsDesc().equals(other.getMobileGoodsDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTradeSnapshootId() == null) ? 0 : getTradeSnapshootId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getPcGoodsDesc() == null) ? 0 : getPcGoodsDesc().hashCode());
        result = prime * result + ((getMobileGoodsDesc() == null) ? 0 : getMobileGoodsDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tradeSnapshootId=").append(tradeSnapshootId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", createTime=").append(createTime);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", pcGoodsDesc=").append(pcGoodsDesc);
        sb.append(", mobileGoodsDesc=").append(mobileGoodsDesc);
        sb.append("]");
        return sb.toString();
    }
}