package com.bean;

public class Edu_Article_Content {
private int articleId;     //ÎÄÕÂID
private String content;     //ÎÄÕÂÄÚÈİ
public int getArticleId() {
	return articleId;
}
public void setArticleId(int articleId) {
	this.articleId = articleId;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
@Override
public String toString() {
	return "Edu_Article_Content [articleId=" + articleId + ", content=" + content + "]";
}

}
