package com.kjj.commserver.entity.shop;

public class OrgTouchPageBanner {
    /**  */
    private Integer id;

    /** 页面ID  对应org_touch_page表id字段 */
    private Integer pageId;

    /** 图片 */
    private String bannerImg;

    /** 跳转链接 */
    private String bannerUrl;

    /** 标题 */
    private String title;

    /**  */
    private Byte imageOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg == null ? null : bannerImg.trim();
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(Byte imageOrder) {
        this.imageOrder = imageOrder;
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
        OrgTouchPageBanner other = (OrgTouchPageBanner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPageId() == null ? other.getPageId() == null : this.getPageId().equals(other.getPageId()))
            && (this.getBannerImg() == null ? other.getBannerImg() == null : this.getBannerImg().equals(other.getBannerImg()))
            && (this.getBannerUrl() == null ? other.getBannerUrl() == null : this.getBannerUrl().equals(other.getBannerUrl()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImageOrder() == null ? other.getImageOrder() == null : this.getImageOrder().equals(other.getImageOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPageId() == null) ? 0 : getPageId().hashCode());
        result = prime * result + ((getBannerImg() == null) ? 0 : getBannerImg().hashCode());
        result = prime * result + ((getBannerUrl() == null) ? 0 : getBannerUrl().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImageOrder() == null) ? 0 : getImageOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pageId=").append(pageId);
        sb.append(", bannerImg=").append(bannerImg);
        sb.append(", bannerUrl=").append(bannerUrl);
        sb.append(", title=").append(title);
        sb.append(", imageOrder=").append(imageOrder);
        sb.append("]");
        return sb.toString();
    }
}