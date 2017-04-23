package com.kjj.commserver.entity.goods;

import java.math.BigDecimal;
import java.util.Date;

public class OrgProduct {
    /**  */
    private Integer goodsId;

    /** 商品分类名称字符串 */
    private String catStr;

    /** 商品所属商品分类id，取值ecs_category的cat_id  */
    private Short catId;

    /** 主商品货号  没有最小商品的时候 与 goods_sn 值相同 */
    private String goodsSnTotal;

    /** 商品的唯一货号 */
    private String goodsSn;

    /** 商品的名称  */
    private String goodsName;

    /** 商品名称显示的样式；包括颜色和字体样式；格式如#ff00ff+strong */
    private String goodsNameStyle;

    /** 点击数 */
    private Integer clickCount;

    /** 品牌id */
    private Short brandId;

    /** 供货人的名称 */
    private String providerName;

    /** 商品库存数量 */
    private Short goodsNumber;

    /** 商品的重量，以千克为单位 */
    private BigDecimal goodsWeight;

    /** 市场售价 */
    private BigDecimal marketPrice;

    /** 本店售价 */
    private BigDecimal shopPrice;

    /** 促销价格 */
    private BigDecimal promotePrice;

    /** 促销价格开始日期 */
    private Integer promoteStartDate;

    /** 促销价格结束日期 */
    private Integer promoteEndDate;

    /** 商品报警数量 */
    private Byte warnNumber;

    /** 关键字 */
    private String keywords;

    /** 产品简目前为 副标题 */
    private String goodsBrief;

    /** 商品在前台显示的微缩图片，如在分类筛选时显示的小图片 */
    private String goodsThumb;

    /** 商品的实际大小图片，如进入该商品页时介绍商品属性所显示的大图片 */
    private String goodsImg;

    /** 应该是上传的商品的原始图片 */
    private String originalImg;

    /** 是否是实物，1，是；0，否；比如虚拟卡就为0，不是实物 */
    private Byte isReal;

    /** 是否是实物，1，是；0，否；比如虚拟卡就为0，不是实物 */
    private String extensionCode;

    /** 该商品是否开放销售，1，是；0，否  */
    private Byte isOnSale;

    /** 是否能单独销售，1，是；0，否；如果不能单独销售，则只能作为某商品的配件或者赠品销售 */
    private Byte isAloneSale;

    /** 是否完善，以提示后台管理员是否已对该商品信息维护完整 */
    private Byte isShipping;

    /** 购买该商品可以使用的积分数量，估计应该是用积分代替金额消费；但程序好像还没有实现该功能  */
    private Integer integral;

    /** 商品的添加时间  */
    private Integer addTime;

    /** 应该是商品的显示顺序，不过该版程序中没实现该功能 */
    private Short sortOrder;

    /** 商品是否已经删除，0，否；1，已删除 */
    private Byte isDelete;

    /** 是否是精品；0，否；1，是 */
    private Byte isBest;

    /** 是否是新品  */
    private Byte isNew;

    /** 是否热销，0，否；1，是  */
    private Byte isHot;

    /** 是否特价促销；0，否；1，是 */
    private Byte isPromote;

    /** 购买该商品所能领到的红包类型 */
    private Byte bonusTypeId;

    /** 最近一次更新商品配置的时间 */
    private Integer lastUpdate;

    /** 商品所属类型id，取值表goods_type的cat_id  */
    private Short goodsType;

    /** 商品的商家备注，仅商家可见  */
    private String sellerNote;

    /** 购买该商品时每笔成功交易赠送的积分数量 */
    private Integer giveIntegral;

    /** 给予的级别积分 */
    private Integer rankIntegral;

    /** 供货商id */
    private Short suppliersId;

    /** 是否被审核 */
    private Byte isCheck;

    /** 否是进口 */
    private Integer isimport;

    /** 产地 */
    private String place;

    /** 质期保 */
    private String expiration;

    /** 预留字段 */
    private String spec;

    /** 商品规格Id */
    private Integer specid;

    /** 上架时间（首次上架，下架后再次上架都将更新） */
    private Date onsaletime;

    /** 销量 */
    private Integer saleNum;

    /** 评论数 */
    private Integer commentNum;

    /** 咨询数 */
    private Integer consultNum;

    /** 下架时间 */
    private Date offsaletime;

    /** 成为历史时间 */
    private Date historytime;

    /** 下架类型：1新增2手动下架3系统违规4编辑 */
    private Byte offSaleType;

    /** spu销售规格展现形式：0合并1展开 */
    private Byte showType;

    /** 商品的详细描述 */
    private String goodsDesc;

    /** 移动端商品描述 */
    private String mobileGoodsDesc;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getCatStr() {
        return catStr;
    }

    public void setCatStr(String catStr) {
        this.catStr = catStr == null ? null : catStr.trim();
    }

    public Short getCatId() {
        return catId;
    }

    public void setCatId(Short catId) {
        this.catId = catId;
    }

    public String getGoodsSnTotal() {
        return goodsSnTotal;
    }

    public void setGoodsSnTotal(String goodsSnTotal) {
        this.goodsSnTotal = goodsSnTotal == null ? null : goodsSnTotal.trim();
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

    public String getGoodsNameStyle() {
        return goodsNameStyle;
    }

    public void setGoodsNameStyle(String goodsNameStyle) {
        this.goodsNameStyle = goodsNameStyle == null ? null : goodsNameStyle.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Short getBrandId() {
        return brandId;
    }

    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    public Short getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Short goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public BigDecimal getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(BigDecimal goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public Integer getPromoteStartDate() {
        return promoteStartDate;
    }

    public void setPromoteStartDate(Integer promoteStartDate) {
        this.promoteStartDate = promoteStartDate;
    }

    public Integer getPromoteEndDate() {
        return promoteEndDate;
    }

    public void setPromoteEndDate(Integer promoteEndDate) {
        this.promoteEndDate = promoteEndDate;
    }

    public Byte getWarnNumber() {
        return warnNumber;
    }

    public void setWarnNumber(Byte warnNumber) {
        this.warnNumber = warnNumber;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief == null ? null : goodsBrief.trim();
    }

    public String getGoodsThumb() {
        return goodsThumb;
    }

    public void setGoodsThumb(String goodsThumb) {
        this.goodsThumb = goodsThumb == null ? null : goodsThumb.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public String getOriginalImg() {
        return originalImg;
    }

    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg == null ? null : originalImg.trim();
    }

    public Byte getIsReal() {
        return isReal;
    }

    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode == null ? null : extensionCode.trim();
    }

    public Byte getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Byte isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Byte getIsAloneSale() {
        return isAloneSale;
    }

    public void setIsAloneSale(Byte isAloneSale) {
        this.isAloneSale = isAloneSale;
    }

    public Byte getIsShipping() {
        return isShipping;
    }

    public void setIsShipping(Byte isShipping) {
        this.isShipping = isShipping;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsBest() {
        return isBest;
    }

    public void setIsBest(Byte isBest) {
        this.isBest = isBest;
    }

    public Byte getIsNew() {
        return isNew;
    }

    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Byte getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(Byte isPromote) {
        this.isPromote = isPromote;
    }

    public Byte getBonusTypeId() {
        return bonusTypeId;
    }

    public void setBonusTypeId(Byte bonusTypeId) {
        this.bonusTypeId = bonusTypeId;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Short getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Short goodsType) {
        this.goodsType = goodsType;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public void setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote == null ? null : sellerNote.trim();
    }

    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    public Integer getRankIntegral() {
        return rankIntegral;
    }

    public void setRankIntegral(Integer rankIntegral) {
        this.rankIntegral = rankIntegral;
    }

    public Short getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getIsimport() {
        return isimport;
    }

    public void setIsimport(Integer isimport) {
        this.isimport = isimport;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration == null ? null : expiration.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Integer getSpecid() {
        return specid;
    }

    public void setSpecid(Integer specid) {
        this.specid = specid;
    }

    public Date getOnsaletime() {
        return onsaletime;
    }

    public void setOnsaletime(Date onsaletime) {
        this.onsaletime = onsaletime;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getConsultNum() {
        return consultNum;
    }

    public void setConsultNum(Integer consultNum) {
        this.consultNum = consultNum;
    }

    public Date getOffsaletime() {
        return offsaletime;
    }

    public void setOffsaletime(Date offsaletime) {
        this.offsaletime = offsaletime;
    }

    public Date getHistorytime() {
        return historytime;
    }

    public void setHistorytime(Date historytime) {
        this.historytime = historytime;
    }

    public Byte getOffSaleType() {
        return offSaleType;
    }

    public void setOffSaleType(Byte offSaleType) {
        this.offSaleType = offSaleType;
    }

    public Byte getShowType() {
        return showType;
    }

    public void setShowType(Byte showType) {
        this.showType = showType;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
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
        OrgProduct other = (OrgProduct) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getCatStr() == null ? other.getCatStr() == null : this.getCatStr().equals(other.getCatStr()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getGoodsSnTotal() == null ? other.getGoodsSnTotal() == null : this.getGoodsSnTotal().equals(other.getGoodsSnTotal()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsNameStyle() == null ? other.getGoodsNameStyle() == null : this.getGoodsNameStyle().equals(other.getGoodsNameStyle()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getProviderName() == null ? other.getProviderName() == null : this.getProviderName().equals(other.getProviderName()))
            && (this.getGoodsNumber() == null ? other.getGoodsNumber() == null : this.getGoodsNumber().equals(other.getGoodsNumber()))
            && (this.getGoodsWeight() == null ? other.getGoodsWeight() == null : this.getGoodsWeight().equals(other.getGoodsWeight()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getShopPrice() == null ? other.getShopPrice() == null : this.getShopPrice().equals(other.getShopPrice()))
            && (this.getPromotePrice() == null ? other.getPromotePrice() == null : this.getPromotePrice().equals(other.getPromotePrice()))
            && (this.getPromoteStartDate() == null ? other.getPromoteStartDate() == null : this.getPromoteStartDate().equals(other.getPromoteStartDate()))
            && (this.getPromoteEndDate() == null ? other.getPromoteEndDate() == null : this.getPromoteEndDate().equals(other.getPromoteEndDate()))
            && (this.getWarnNumber() == null ? other.getWarnNumber() == null : this.getWarnNumber().equals(other.getWarnNumber()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getGoodsBrief() == null ? other.getGoodsBrief() == null : this.getGoodsBrief().equals(other.getGoodsBrief()))
            && (this.getGoodsThumb() == null ? other.getGoodsThumb() == null : this.getGoodsThumb().equals(other.getGoodsThumb()))
            && (this.getGoodsImg() == null ? other.getGoodsImg() == null : this.getGoodsImg().equals(other.getGoodsImg()))
            && (this.getOriginalImg() == null ? other.getOriginalImg() == null : this.getOriginalImg().equals(other.getOriginalImg()))
            && (this.getIsReal() == null ? other.getIsReal() == null : this.getIsReal().equals(other.getIsReal()))
            && (this.getExtensionCode() == null ? other.getExtensionCode() == null : this.getExtensionCode().equals(other.getExtensionCode()))
            && (this.getIsOnSale() == null ? other.getIsOnSale() == null : this.getIsOnSale().equals(other.getIsOnSale()))
            && (this.getIsAloneSale() == null ? other.getIsAloneSale() == null : this.getIsAloneSale().equals(other.getIsAloneSale()))
            && (this.getIsShipping() == null ? other.getIsShipping() == null : this.getIsShipping().equals(other.getIsShipping()))
            && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getSortOrder() == null ? other.getSortOrder() == null : this.getSortOrder().equals(other.getSortOrder()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsBest() == null ? other.getIsBest() == null : this.getIsBest().equals(other.getIsBest()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getIsPromote() == null ? other.getIsPromote() == null : this.getIsPromote().equals(other.getIsPromote()))
            && (this.getBonusTypeId() == null ? other.getBonusTypeId() == null : this.getBonusTypeId().equals(other.getBonusTypeId()))
            && (this.getLastUpdate() == null ? other.getLastUpdate() == null : this.getLastUpdate().equals(other.getLastUpdate()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()))
            && (this.getSellerNote() == null ? other.getSellerNote() == null : this.getSellerNote().equals(other.getSellerNote()))
            && (this.getGiveIntegral() == null ? other.getGiveIntegral() == null : this.getGiveIntegral().equals(other.getGiveIntegral()))
            && (this.getRankIntegral() == null ? other.getRankIntegral() == null : this.getRankIntegral().equals(other.getRankIntegral()))
            && (this.getSuppliersId() == null ? other.getSuppliersId() == null : this.getSuppliersId().equals(other.getSuppliersId()))
            && (this.getIsCheck() == null ? other.getIsCheck() == null : this.getIsCheck().equals(other.getIsCheck()))
            && (this.getIsimport() == null ? other.getIsimport() == null : this.getIsimport().equals(other.getIsimport()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getExpiration() == null ? other.getExpiration() == null : this.getExpiration().equals(other.getExpiration()))
            && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
            && (this.getSpecid() == null ? other.getSpecid() == null : this.getSpecid().equals(other.getSpecid()))
            && (this.getOnsaletime() == null ? other.getOnsaletime() == null : this.getOnsaletime().equals(other.getOnsaletime()))
            && (this.getSaleNum() == null ? other.getSaleNum() == null : this.getSaleNum().equals(other.getSaleNum()))
            && (this.getCommentNum() == null ? other.getCommentNum() == null : this.getCommentNum().equals(other.getCommentNum()))
            && (this.getConsultNum() == null ? other.getConsultNum() == null : this.getConsultNum().equals(other.getConsultNum()))
            && (this.getOffsaletime() == null ? other.getOffsaletime() == null : this.getOffsaletime().equals(other.getOffsaletime()))
            && (this.getHistorytime() == null ? other.getHistorytime() == null : this.getHistorytime().equals(other.getHistorytime()))
            && (this.getOffSaleType() == null ? other.getOffSaleType() == null : this.getOffSaleType().equals(other.getOffSaleType()))
            && (this.getShowType() == null ? other.getShowType() == null : this.getShowType().equals(other.getShowType()))
            && (this.getGoodsDesc() == null ? other.getGoodsDesc() == null : this.getGoodsDesc().equals(other.getGoodsDesc()))
            && (this.getMobileGoodsDesc() == null ? other.getMobileGoodsDesc() == null : this.getMobileGoodsDesc().equals(other.getMobileGoodsDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getCatStr() == null) ? 0 : getCatStr().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getGoodsSnTotal() == null) ? 0 : getGoodsSnTotal().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsNameStyle() == null) ? 0 : getGoodsNameStyle().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getProviderName() == null) ? 0 : getProviderName().hashCode());
        result = prime * result + ((getGoodsNumber() == null) ? 0 : getGoodsNumber().hashCode());
        result = prime * result + ((getGoodsWeight() == null) ? 0 : getGoodsWeight().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getShopPrice() == null) ? 0 : getShopPrice().hashCode());
        result = prime * result + ((getPromotePrice() == null) ? 0 : getPromotePrice().hashCode());
        result = prime * result + ((getPromoteStartDate() == null) ? 0 : getPromoteStartDate().hashCode());
        result = prime * result + ((getPromoteEndDate() == null) ? 0 : getPromoteEndDate().hashCode());
        result = prime * result + ((getWarnNumber() == null) ? 0 : getWarnNumber().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getGoodsBrief() == null) ? 0 : getGoodsBrief().hashCode());
        result = prime * result + ((getGoodsThumb() == null) ? 0 : getGoodsThumb().hashCode());
        result = prime * result + ((getGoodsImg() == null) ? 0 : getGoodsImg().hashCode());
        result = prime * result + ((getOriginalImg() == null) ? 0 : getOriginalImg().hashCode());
        result = prime * result + ((getIsReal() == null) ? 0 : getIsReal().hashCode());
        result = prime * result + ((getExtensionCode() == null) ? 0 : getExtensionCode().hashCode());
        result = prime * result + ((getIsOnSale() == null) ? 0 : getIsOnSale().hashCode());
        result = prime * result + ((getIsAloneSale() == null) ? 0 : getIsAloneSale().hashCode());
        result = prime * result + ((getIsShipping() == null) ? 0 : getIsShipping().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getSortOrder() == null) ? 0 : getSortOrder().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsBest() == null) ? 0 : getIsBest().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getIsPromote() == null) ? 0 : getIsPromote().hashCode());
        result = prime * result + ((getBonusTypeId() == null) ? 0 : getBonusTypeId().hashCode());
        result = prime * result + ((getLastUpdate() == null) ? 0 : getLastUpdate().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        result = prime * result + ((getSellerNote() == null) ? 0 : getSellerNote().hashCode());
        result = prime * result + ((getGiveIntegral() == null) ? 0 : getGiveIntegral().hashCode());
        result = prime * result + ((getRankIntegral() == null) ? 0 : getRankIntegral().hashCode());
        result = prime * result + ((getSuppliersId() == null) ? 0 : getSuppliersId().hashCode());
        result = prime * result + ((getIsCheck() == null) ? 0 : getIsCheck().hashCode());
        result = prime * result + ((getIsimport() == null) ? 0 : getIsimport().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getExpiration() == null) ? 0 : getExpiration().hashCode());
        result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
        result = prime * result + ((getSpecid() == null) ? 0 : getSpecid().hashCode());
        result = prime * result + ((getOnsaletime() == null) ? 0 : getOnsaletime().hashCode());
        result = prime * result + ((getSaleNum() == null) ? 0 : getSaleNum().hashCode());
        result = prime * result + ((getCommentNum() == null) ? 0 : getCommentNum().hashCode());
        result = prime * result + ((getConsultNum() == null) ? 0 : getConsultNum().hashCode());
        result = prime * result + ((getOffsaletime() == null) ? 0 : getOffsaletime().hashCode());
        result = prime * result + ((getHistorytime() == null) ? 0 : getHistorytime().hashCode());
        result = prime * result + ((getOffSaleType() == null) ? 0 : getOffSaleType().hashCode());
        result = prime * result + ((getShowType() == null) ? 0 : getShowType().hashCode());
        result = prime * result + ((getGoodsDesc() == null) ? 0 : getGoodsDesc().hashCode());
        result = prime * result + ((getMobileGoodsDesc() == null) ? 0 : getMobileGoodsDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", catStr=").append(catStr);
        sb.append(", catId=").append(catId);
        sb.append(", goodsSnTotal=").append(goodsSnTotal);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsNameStyle=").append(goodsNameStyle);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", brandId=").append(brandId);
        sb.append(", providerName=").append(providerName);
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsWeight=").append(goodsWeight);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", promotePrice=").append(promotePrice);
        sb.append(", promoteStartDate=").append(promoteStartDate);
        sb.append(", promoteEndDate=").append(promoteEndDate);
        sb.append(", warnNumber=").append(warnNumber);
        sb.append(", keywords=").append(keywords);
        sb.append(", goodsBrief=").append(goodsBrief);
        sb.append(", goodsThumb=").append(goodsThumb);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", originalImg=").append(originalImg);
        sb.append(", isReal=").append(isReal);
        sb.append(", extensionCode=").append(extensionCode);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append(", isAloneSale=").append(isAloneSale);
        sb.append(", isShipping=").append(isShipping);
        sb.append(", integral=").append(integral);
        sb.append(", addTime=").append(addTime);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isBest=").append(isBest);
        sb.append(", isNew=").append(isNew);
        sb.append(", isHot=").append(isHot);
        sb.append(", isPromote=").append(isPromote);
        sb.append(", bonusTypeId=").append(bonusTypeId);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", sellerNote=").append(sellerNote);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", rankIntegral=").append(rankIntegral);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", isCheck=").append(isCheck);
        sb.append(", isimport=").append(isimport);
        sb.append(", place=").append(place);
        sb.append(", expiration=").append(expiration);
        sb.append(", spec=").append(spec);
        sb.append(", specid=").append(specid);
        sb.append(", onsaletime=").append(onsaletime);
        sb.append(", saleNum=").append(saleNum);
        sb.append(", commentNum=").append(commentNum);
        sb.append(", consultNum=").append(consultNum);
        sb.append(", offsaletime=").append(offsaletime);
        sb.append(", historytime=").append(historytime);
        sb.append(", offSaleType=").append(offSaleType);
        sb.append(", showType=").append(showType);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", mobileGoodsDesc=").append(mobileGoodsDesc);
        sb.append("]");
        return sb.toString();
    }
}