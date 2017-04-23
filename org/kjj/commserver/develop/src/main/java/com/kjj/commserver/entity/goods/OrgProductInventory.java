package com.kjj.commserver.entity.goods;

import java.math.BigDecimal;
import java.util.Date;

public class OrgProductInventory {
    /** 主键 */
    private Integer id;

    /** 商品编码，对应org_product_item表goods_sn字段 */
    private String goodsSn;

    /** 店铺编号,对应org_shop表shop_code字段 */
    private String shopCode;

    /** 店铺库存量 */
    private Integer shopAmount;

    /** 仓库库存量 */
    private Integer warehouseAmount;

    /** 原价 */
    private BigDecimal sourcePrice;

    /** 售价 */
    private BigDecimal sellPrice;

    /** 条形码 */
    private String barcode;

    /** 更新时间 */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public Integer getShopAmount() {
        return shopAmount;
    }

    public void setShopAmount(Integer shopAmount) {
        this.shopAmount = shopAmount;
    }

    public Integer getWarehouseAmount() {
        return warehouseAmount;
    }

    public void setWarehouseAmount(Integer warehouseAmount) {
        this.warehouseAmount = warehouseAmount;
    }

    public BigDecimal getSourcePrice() {
        return sourcePrice;
    }

    public void setSourcePrice(BigDecimal sourcePrice) {
        this.sourcePrice = sourcePrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        OrgProductInventory other = (OrgProductInventory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getShopCode() == null ? other.getShopCode() == null : this.getShopCode().equals(other.getShopCode()))
            && (this.getShopAmount() == null ? other.getShopAmount() == null : this.getShopAmount().equals(other.getShopAmount()))
            && (this.getWarehouseAmount() == null ? other.getWarehouseAmount() == null : this.getWarehouseAmount().equals(other.getWarehouseAmount()))
            && (this.getSourcePrice() == null ? other.getSourcePrice() == null : this.getSourcePrice().equals(other.getSourcePrice()))
            && (this.getSellPrice() == null ? other.getSellPrice() == null : this.getSellPrice().equals(other.getSellPrice()))
            && (this.getBarcode() == null ? other.getBarcode() == null : this.getBarcode().equals(other.getBarcode()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getShopCode() == null) ? 0 : getShopCode().hashCode());
        result = prime * result + ((getShopAmount() == null) ? 0 : getShopAmount().hashCode());
        result = prime * result + ((getWarehouseAmount() == null) ? 0 : getWarehouseAmount().hashCode());
        result = prime * result + ((getSourcePrice() == null) ? 0 : getSourcePrice().hashCode());
        result = prime * result + ((getSellPrice() == null) ? 0 : getSellPrice().hashCode());
        result = prime * result + ((getBarcode() == null) ? 0 : getBarcode().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", shopCode=").append(shopCode);
        sb.append(", shopAmount=").append(shopAmount);
        sb.append(", warehouseAmount=").append(warehouseAmount);
        sb.append(", sourcePrice=").append(sourcePrice);
        sb.append(", sellPrice=").append(sellPrice);
        sb.append(", barcode=").append(barcode);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}