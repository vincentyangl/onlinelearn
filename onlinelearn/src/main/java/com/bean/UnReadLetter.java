package com.bean;

public class UnReadLetter {

	private int SMNum;//未读系统消息数
	private int mNum;//未读站内信数
	private int unReadNum;//总未读消息数
	public int getSMNum() {
		return SMNum;
	}
	public void setSMNum(int sMNum) {
		SMNum = sMNum;
	}
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public int getUnReadNum() {
		return unReadNum;
	}
	public void setUnReadNum(int unReadNum) {
		this.unReadNum = unReadNum;
	}
	
}
