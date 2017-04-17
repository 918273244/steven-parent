package com.steven.gantt.entity;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Roles implements java.io.Serializable {
	//主键
	private int id;
	private int enable;//是否禁用角色　1　表示禁用　2　表示不禁用
	//角色名称
	private String name;
	private String roleKey;
	//角色描述
	private String description;
	private int parentId;
	private Set<Resources> resources = new HashSet<Resources>(0);

	//1：通用需求 2：端到端需求  3：端到端任务  4：路标  5：通用需求报表 6：端到端需求报表 7：端到端任务报表 8：端到端仪表盘
	private String type;
	//流程节点 通用：RFT（初步分析）  RMT（RMT分析）  RAT（RAT分析）,,RCT（竞品分析），RST（立项风险） 端到端：RPT（初步分析）RRT（在线评审）
	private String flowNode;
	// query（查看）、  flow（流程处理） 
	private String authorityType;
	//通用：XXXRMT;XXXRMT; 或者 XXX产品范围;XXX产品范围   若是端到端：XXX二级产品线；XXX二级产品线
	private String belongTo;
	//国内    海外   XXX分公司   XXX分公司
	private String area;
	  private String createdBy;
	    //创建日期
	    private String createdDate;
	    //修改人
	    private String modifiedBy;
	    //修改时间
	    private String modifiedDate;
	
	

	public Roles() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEnable() {
		return enable;
	}


	public void setEnable(int enable) {
		this.enable = enable;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Resources> getResources() {
		return resources;
	}

	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlowNode() {
		return flowNode;
	}

	public void setFlowNode(String flowNode) {
		this.flowNode = flowNode;
	}


	public String getAuthorityType() {
		return authorityType;
	}


	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}


	public String getBelongTo() {
		return belongTo;
	}


	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public String getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}