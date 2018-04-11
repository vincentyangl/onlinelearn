package com.bean;

public class Edu_Questions_Tag {
private int questionsTagId;      //主键id
private String questionsTagName;   //标签名
private int status;        //状态0默认1删除
private String createTime;      //创建时间
private String parentId;     //父级id
public int getQuestionsTagId() {
	return questionsTagId;
}
public void setQuestionsTagId(int questionsTagId) {
	this.questionsTagId = questionsTagId;
}
public String getQuestionsTagName() {
	return questionsTagName;
}
public void setQuestionsTagName(String questionsTagName) {
	this.questionsTagName = questionsTagName;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getParentId() {
	return parentId;
}
public void setParentId(String parentId) {
	this.parentId = parentId;
}
@Override
public String toString() {
	return "Edu_Questions_Tag [questionsTagId=" + questionsTagId + ", questionsTagName=" + questionsTagName
			+ ", status=" + status + ", createTime=" + createTime + ", parentId=" + parentId + "]";
}


}
