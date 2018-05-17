package com.bean;

import java.sql.Timestamp;
import java.util.Date;



public class Edu_Article {
	
private int articleId;    //文章ID
private String title;     //文章标题
private String summary;    //文章摘要
private String keyWord;     //文章关键字
private String imageUrl;    //文章图片URL
private String source;      //文章来源
private String author;     //文章作者
private Date createTime;       //文章创建时间
private Date publishTime;     //文章发布时间
private String link;       //文章访问链接
private int articleType;   //文章类型 2文章
private int clickNum;      //文章点击量
private int praiseCount;     //点赞数量
private int commentNum;     //评论数
private int sort;       //排序值
private Edu_Article_Content edu_Article_Content;//文章内容
public int getArticleId() {
	return articleId;
}
public void setArticleId(int articleId) {
	this.articleId = articleId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public String getKeyWord() {
	return keyWord;
}
public void setKeyWord(String keyWord) {
	this.keyWord = keyWord;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public Date getPublishTime() {
	return publishTime;
}
public void setPublishTime(Date publishTime) {
	this.publishTime = publishTime;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public int getArticleType() {
	return articleType;
}
public void setArticleType(int articleType) {
	this.articleType = articleType;
}
public int getClickNum() {
	return clickNum;
}
public void setClickNum(int clickNum) {
	this.clickNum = clickNum;
}
public int getPraiseCount() {
	return praiseCount;
}
public void setPraiseCount(int praiseCount) {
	this.praiseCount = praiseCount;
}
public int getCommentNum() {
	return commentNum;
}
public void setCommentNum(int commentNum) {
	this.commentNum = commentNum;
}
public int getSort() {
	return sort;
}
public void setSort(int sort) {
	this.sort = sort;
}
public Edu_Article_Content getEdu_Article_Content() {
	return edu_Article_Content;
}
public void setEdu_Article_Content(Edu_Article_Content edu_Article_Content) {
	this.edu_Article_Content = edu_Article_Content;
}
@Override
public String toString() {
	return "Edu_Article [articleId=" + articleId + ", title=" + title + ", summary=" + summary + ", keyWord=" + keyWord
			+ ", imageUrl=" + imageUrl + ", source=" + source + ", author=" + author + ", createTime=" + createTime
			+ ", publishTime=" + publishTime + ", link=" + link + ", articleType=" + articleType + ", clickNum="
			+ clickNum + ", praiseCount=" + praiseCount + ", commentNum=" + commentNum + ", sort=" + sort
			+ ", edu_Article_Content=" + edu_Article_Content + "]";
}

}
