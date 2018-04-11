package com.bean;

public class Edu_Questions_Tag_Relation {
private int id;      //ID
private int questionsId;   //ÎÊ´ðid
private int questionsTagId;    //ÎÊ´ð±êÇ©id
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getQuestionsId() {
	return questionsId;
}
public void setQuestionsId(int questionsId) {
	this.questionsId = questionsId;
}
public int getQuestionsTagId() {
	return questionsTagId;
}
public void setQuestionsTagId(int questionsTagId) {
	this.questionsTagId = questionsTagId;
}
@Override
public String toString() {
	return "Edu_Questions_Tag_Relation [id=" + id + ", questionsId=" + questionsId + ", questionsTagId="
			+ questionsTagId + "]";
}


}
