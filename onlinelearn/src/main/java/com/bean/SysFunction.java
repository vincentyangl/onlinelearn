package com.bean;

import java.util.Date;
import java.util.List;

public class SysFunction {

	//Ȩ�ޱ��
	private int id;
	//��Id
	private int pId;
	//Ȩ������
	private String name;
	//����
	private String alias;
	// ��ת·��
	private String functionUrl;
	//�Ƿ��ǲ˵� 1 �˵� 2 ��ť
	private int functionType;
	//����ʱ��
	private Date createTime;
	//����
	private int sort;
	//��Ԫ�ؼ���
	private List<SysFunction> sysFunctions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getFunctionUrl() {
		return functionUrl;
	}
	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}
	public int getFunctionType() {
		return functionType;
	}
	public void setFunctionType(int functionType) {
		this.functionType = functionType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public List<SysFunction> getSysFunctions() {
		return sysFunctions;
	}
	public void setSysFunctions(List<SysFunction> sysFunctions) {
		this.sysFunctions = sysFunctions;
	}
	
}
