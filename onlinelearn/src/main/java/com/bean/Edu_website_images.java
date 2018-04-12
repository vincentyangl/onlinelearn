package com.bean;

import javax.lang.model.type.PrimitiveType;

public class Edu_website_images { //轮播图管理
      private int imge_id;
      private String imge_url;//图片地址
      private String link_address;//图片链接地址
	  private String title;//图表题
	  private Edu_website_images_type edu_website_images_type;//图片类型
	  private int  series_number ;//序列号
	  private String preview_url;//略缩图片地址
	  private String color;//背景色
	  private String describe;//图片描述
	  
	  
	public int getImge_id() {
		return imge_id;
	}
	public void setImge_id(int imge_id) {
		this.imge_id = imge_id;
	}
	public String getImge_url() {
		return imge_url;
	}
	public void setImge_url(String imge_url) {
		this.imge_url = imge_url;
	}
	public String getLink_address() {
		return link_address;
	}
	public void setLink_address(String link_address) {
		this.link_address = link_address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Edu_website_images_type getEdu_website_images_type() {
		return edu_website_images_type;
	}
	public void setEdu_website_images_type(Edu_website_images_type edu_website_images_type) {
		this.edu_website_images_type = edu_website_images_type;
	}
	public int getSeries_number() {
		return series_number;
	}
	public void setSeries_number(int series_number) {
		this.series_number = series_number;
	}
	public String getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	  
	
}
