package com.kjj.commserver.entity.shop;


public class OrgShopPageFloor {
    /**  */
    private Integer floorid;

    /**  */
    private String floorname;
    
    /**楼层名字链接地址*/
    private String floorNameUrl;

    /** 面页分类id */
    private Integer pageCategory;

    public String getFloorNameUrl() {
		return floorNameUrl;
	}

	public void setFloorNameUrl(String floorNameUrl) {
		this.floorNameUrl = floorNameUrl;
	}

	/** 页面宣传图片 */
    private String pageImg;

    /** 楼层图片 链接地址 */
    private String pageImgUrl;

    /**  */
    private Integer pageid;

    /** 是否启用 0 no 1 yes */
    private Integer isactive;

    /**  */
    private String page1;

    /**  */
    private String page2;

    /**  */
    private String page3;

    /**  */
    private String page4;

    /**  */
    private String page5;

	public Integer getFloorid() {
        return floorid;
    }

	public void setFloorid(Integer floorid) {
        this.floorid = floorid;
    }

    public String getFloorname() {
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname == null ? null : floorname.trim();
    }

    public Integer getPageCategory() {
        return pageCategory;
    }

    public void setPageCategory(Integer pageCategory) {
        this.pageCategory = pageCategory;
    }

    public String getPageImg() {
        return pageImg;
    }

    public void setPageImg(String pageImg) {
        this.pageImg = pageImg == null ? null : pageImg.trim();
    }

    public String getPageImgUrl() {
        return pageImgUrl;
    }

    public void setPageImgUrl(String pageImgUrl) {
        this.pageImgUrl = pageImgUrl == null ? null : pageImgUrl.trim();
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public String getPage1() {
        return page1;
    }

    public void setPage1(String page1) {
        this.page1 = page1 == null ? null : page1.trim();
    }

    public String getPage2() {
        return page2;
    }

    public void setPage2(String page2) {
        this.page2 = page2 == null ? null : page2.trim();
    }

    public String getPage3() {
        return page3;
    }

    public void setPage3(String page3) {
        this.page3 = page3 == null ? null : page3.trim();
    }

    public String getPage4() {
        return page4;
    }

    public void setPage4(String page4) {
        this.page4 = page4 == null ? null : page4.trim();
    }

    public String getPage5() {
        return page5;
    }

    public void setPage5(String page5) {
        this.page5 = page5 == null ? null : page5.trim();
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
        OrgShopPageFloor other = (OrgShopPageFloor) that;
        return (this.getFloorid() == null ? other.getFloorid() == null : this.getFloorid().equals(other.getFloorid()))
            && (this.getFloorname() == null ? other.getFloorname() == null : this.getFloorname().equals(other.getFloorname()))
            && (this.getPageCategory() == null ? other.getPageCategory() == null : this.getPageCategory().equals(other.getPageCategory()))
            && (this.getPageImg() == null ? other.getPageImg() == null : this.getPageImg().equals(other.getPageImg()))
            && (this.getPageImgUrl() == null ? other.getPageImgUrl() == null : this.getPageImgUrl().equals(other.getPageImgUrl()))
            && (this.getPageid() == null ? other.getPageid() == null : this.getPageid().equals(other.getPageid()))
            && (this.getIsactive() == null ? other.getIsactive() == null : this.getIsactive().equals(other.getIsactive()))
            && (this.getPage1() == null ? other.getPage1() == null : this.getPage1().equals(other.getPage1()))
            && (this.getPage2() == null ? other.getPage2() == null : this.getPage2().equals(other.getPage2()))
            && (this.getPage3() == null ? other.getPage3() == null : this.getPage3().equals(other.getPage3()))
            && (this.getPage4() == null ? other.getPage4() == null : this.getPage4().equals(other.getPage4()))
            && (this.getPage5() == null ? other.getPage5() == null : this.getPage5().equals(other.getPage5()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFloorid() == null) ? 0 : getFloorid().hashCode());
        result = prime * result + ((getFloorname() == null) ? 0 : getFloorname().hashCode());
        result = prime * result + ((getPageCategory() == null) ? 0 : getPageCategory().hashCode());
        result = prime * result + ((getPageImg() == null) ? 0 : getPageImg().hashCode());
        result = prime * result + ((getPageImgUrl() == null) ? 0 : getPageImgUrl().hashCode());
        result = prime * result + ((getPageid() == null) ? 0 : getPageid().hashCode());
        result = prime * result + ((getIsactive() == null) ? 0 : getIsactive().hashCode());
        result = prime * result + ((getPage1() == null) ? 0 : getPage1().hashCode());
        result = prime * result + ((getPage2() == null) ? 0 : getPage2().hashCode());
        result = prime * result + ((getPage3() == null) ? 0 : getPage3().hashCode());
        result = prime * result + ((getPage4() == null) ? 0 : getPage4().hashCode());
        result = prime * result + ((getPage5() == null) ? 0 : getPage5().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", floorid=").append(floorid);
        sb.append(", floorname=").append(floorname);
        sb.append(", pageCategory=").append(pageCategory);
        sb.append(", pageImg=").append(pageImg);
        sb.append(", pageImgUrl=").append(pageImgUrl);
        sb.append(", pageid=").append(pageid);
        sb.append(", isactive=").append(isactive);
        sb.append(", page1=").append(page1);
        sb.append(", page2=").append(page2);
        sb.append(", page3=").append(page3);
        sb.append(", page4=").append(page4);
        sb.append(", page5=").append(page5);
        sb.append("]");
        return sb.toString();
    }
}