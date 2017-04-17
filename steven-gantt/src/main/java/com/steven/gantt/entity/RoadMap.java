package com.steven.gantt.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Steven on 2017/3/29.
 */
@Component
public class RoadMap {

    private long id;//Id
    private String roadNo;//路标编号
    private String createdBy;//创建人name
    private long createdUserId;//创建人Id
    private String createUserNo;//创建者工号
    private Date createdDate;//创建时间
    private String createdDateValue;
    private String departmentName;//部门
    private String mobile;//联系方式
    private String email;//邮箱
    private String roadName;//路标名称
    private int roadType;//路标类型 1-产品开发路标  2-技术平台开发路标  3-技术预研路标   4-解决方案路标
    private String roadTypeValue;
    private int roadLevel;//路标层级  1-产品系列   2-产品子系列  3-产品   4-版本
    private String loadLevelValue;
    private int newLookFlag;//是否全新外观  0-是 1-否  2-不涉及
    private String newLookFlagValue;
    private int roadPriority;  //路标优先级   1-很高   2-高   3-中   4-低
    private String roadPriorityValue;
    private String appearanceForm;//外观形态
    private String hardwarePlatform;//硬件平台
    private Date planStartTime;//计划启动时间
    private String planStartTimeValue;
    private Date planPublishTime;//计划发布时间
    private String planPublishTimeValue;
    private int marketPosition;//市场定位  0-高端   1-中端    2-低端
    private String marketPositionValue;
    private int targetedMarket;//目标市场   0-行业市场   1-项目市场   2-分销市场
    private String targetedMarketValue;
    private String typicalCustomers;//典型客户
    private String expectedLifeCycle;//预计生命周期-年
    private String estimatedSalesVolume;//预计销售数量(台)
    private String estimatedSalesPrice;//预计销售均价
    private String estimatedGrossMargin;//预计毛利率（百分比）
    private String estimatedRDExpenses;//预计投入研发费用
    private String estimatedSalesAmount;//预计销售金额
    private String estimatedGrossAmount;//预计毛利金额
    private String estimatedInOut;//预计投入产出比（毛利/投入）
    private String coreContent;//核心功能描述  clog类型
    private String performance;//性能
    private String competitionContent;//竞争分析  clog类型
    private String customerContent;//客户价值  clog类型
    private long roadInheritId;//路标继承关系 ID
    private String roadInheritName;//路标继承关系
    private long roadQuotesId;//路标引用关系  ID
    private String roadQuotesName;//路标引用关系
    private long roadSupportID;//路标配套ID
    private String roadSupportName;//路标配套
    private long roadPlatformID;//路标平台ID
    private String roadPlatformName;//路标平台依赖
    private String roadImage;//路标图片
    private String field1;//自定义1
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private String uploadFile;
    private int roadMapType;//0-目录  1-版本
    private String roadMapTypeValue;
    private long parentId;//父级Id
    private long rmtId;//rmt  Id
    private Date updateTime;//更新时间
    private String status;//状态
    private boolean typeFlag;//1：true 表示路标  0：false 解决方案 //

    public boolean getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(boolean typeFlag) {
        this.typeFlag = typeFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedDateValue() {
        return createdDateValue;
    }

    public void setCreatedDateValue(String createdDateValue) {
        this.createdDateValue = createdDateValue;
    }

    public String getPlanStartTimeValue() {
        return planStartTimeValue;
    }

    public void setPlanStartTimeValue(String planStartTimeValue) {
        this.planStartTimeValue = planStartTimeValue;
    }

    public String getPlanPublishTimeValue() {
        return planPublishTimeValue;
    }

    public void setPlanPublishTimeValue(String planPublishTimeValue) {
        this.planPublishTimeValue = planPublishTimeValue;
    }

    public String getRoadTypeValue() {
        return roadTypeValue;
    }

    public void setRoadTypeValue(String roadTypeValue) {
        this.roadTypeValue = roadTypeValue;
    }

    public String getLoadLevelValue() {
        return loadLevelValue;
    }

    public void setLoadLevelValue(String loadLevelValue) {
        this.loadLevelValue = loadLevelValue;
    }

    public String getNewLookFlagValue() {
        return newLookFlagValue;
    }

    public void setNewLookFlagValue(String newLookFlagValue) {
        this.newLookFlagValue = newLookFlagValue;
    }

    public String getRoadPriorityValue() {
        return roadPriorityValue;
    }

    public void setRoadPriorityValue(String roadPriorityValue) {
        this.roadPriorityValue = roadPriorityValue;
    }

    public String getMarketPositionValue() {
        return marketPositionValue;
    }

    public void setMarketPositionValue(String marketPositionValue) {
        this.marketPositionValue = marketPositionValue;
    }

    public String getTargetedMarketValue() {
        return targetedMarketValue;
    }

    public void setTargetedMarketValue(String targetedMarketValue) {
        this.targetedMarketValue = targetedMarketValue;
    }

    public String getRoadMapTypeValue() {
        return roadMapTypeValue;
    }

    public void setRoadMapTypeValue(String roadMapTypeValue) {
        this.roadMapTypeValue = roadMapTypeValue;
    }


    public int getRoadMapType() {
        return roadMapType;
    }

    public void setRoadMapType(int roadMapType) {
        this.roadMapType = roadMapType;
    }

    public long getParentId() {
        return parentId;
    }

    public String getCreateUserNo() {
        return createUserNo;
    }

    public void setCreateUserNo(String createUserNo) {
        this.createUserNo = createUserNo;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getRmtId() {
        return rmtId;
    }

    public void setRmtId(long rmtId) {
        this.rmtId = rmtId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public int getRoadType() {
        return roadType;
    }

    public void setRoadType(int roadType) {
        this.roadType = roadType;
    }

    public int getRoadLevel() {
        return roadLevel;
    }

    public void setRoadLevel(int roadLevel) {
        this.roadLevel = roadLevel;
    }

    public int getNewLookFlag() {
        return newLookFlag;
    }

    public void setNewLookFlag(int newLookFlag) {
        this.newLookFlag = newLookFlag;
    }

    public int getRoadPriority() {
        return roadPriority;
    }

    public void setRoadPriority(int roadPriority) {
        this.roadPriority = roadPriority;
    }

    public String getAppearanceForm() {
        return appearanceForm;
    }

    public void setAppearanceForm(String appearanceForm) {
        this.appearanceForm = appearanceForm;
    }

    public String getHardwarePlatform() {
        return hardwarePlatform;
    }

    public void setHardwarePlatform(String hardwarePlatform) {
        this.hardwarePlatform = hardwarePlatform;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanPublishTime() {
        return planPublishTime;
    }

    public void setPlanPublishTime(Date planPublishTime) {
        this.planPublishTime = planPublishTime;
    }

    public int getMarketPosition() {
        return marketPosition;
    }

    public void setMarketPosition(int marketPosition) {
        this.marketPosition = marketPosition;
    }

    public int getTargetedMarket() {
        return targetedMarket;
    }

    public void setTargetedMarket(int targetedMarket) {
        this.targetedMarket = targetedMarket;
    }

    public String getTypicalCustomers() {
        return typicalCustomers;
    }

    public void setTypicalCustomers(String typicalCustomers) {
        this.typicalCustomers = typicalCustomers;
    }

    public String getExpectedLifeCycle() {
        return expectedLifeCycle;
    }

    public void setExpectedLifeCycle(String expectedLifeCycle) {
        this.expectedLifeCycle = expectedLifeCycle;
    }

    public String getEstimatedSalesVolume() {
        return estimatedSalesVolume;
    }

    public void setEstimatedSalesVolume(String estimatedSalesVolume) {
        this.estimatedSalesVolume = estimatedSalesVolume;
    }

    public String getEstimatedSalesPrice() {
        return estimatedSalesPrice;
    }

    public void setEstimatedSalesPrice(String estimatedSalesPrice) {
        this.estimatedSalesPrice = estimatedSalesPrice;
    }

    public String getEstimatedGrossMargin() {
        return estimatedGrossMargin;
    }

    public void setEstimatedGrossMargin(String estimatedGrossMargin) {
        this.estimatedGrossMargin = estimatedGrossMargin;
    }

    public String getEstimatedRDExpenses() {
        return estimatedRDExpenses;
    }

    public void setEstimatedRDExpenses(String estimatedRDExpenses) {
        this.estimatedRDExpenses = estimatedRDExpenses;
    }

    public String getEstimatedSalesAmount() {
        return estimatedSalesAmount;
    }

    public void setEstimatedSalesAmount(String estimatedSalesAmount) {
        this.estimatedSalesAmount = estimatedSalesAmount;
    }

    public String getEstimatedGrossAmount() {
        return estimatedGrossAmount;
    }

    public void setEstimatedGrossAmount(String estimatedGrossAmount) {
        this.estimatedGrossAmount = estimatedGrossAmount;
    }

    public String getEstimatedInOut() {
        return estimatedInOut;
    }

    public void setEstimatedInOut(String estimatedInOut) {
        this.estimatedInOut = estimatedInOut;
    }

    public String getCoreContent() {
        return coreContent;
    }

    public void setCoreContent(String coreContent) {
        this.coreContent = coreContent;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getCompetitionContent() {
        return competitionContent;
    }

    public void setCompetitionContent(String competitionContent) {
        this.competitionContent = competitionContent;
    }

    public String getCustomerContent() {
        return customerContent;
    }

    public void setCustomerContent(String customerContent) {
        this.customerContent = customerContent;
    }

    public long getRoadInheritId() {
        return roadInheritId;
    }

    public void setRoadInheritId(long roadInheritId) {
        this.roadInheritId = roadInheritId;
    }

    public String getRoadInheritName() {
        return roadInheritName;
    }

    public void setRoadInheritName(String roadInheritName) {
        this.roadInheritName = roadInheritName;
    }

    public long getRoadQuotesId() {
        return roadQuotesId;
    }

    public void setRoadQuotesId(long roadQuotesId) {
        this.roadQuotesId = roadQuotesId;
    }

    public String getRoadQuotesName() {
        return roadQuotesName;
    }

    public void setRoadQuotesName(String roadQuotesName) {
        this.roadQuotesName = roadQuotesName;
    }

    public long getRoadSupportID() {
        return roadSupportID;
    }

    public void setRoadSupportID(long roadSupportID) {
        this.roadSupportID = roadSupportID;
    }

    public String getRoadSupportName() {
        return roadSupportName;
    }

    public void setRoadSupportName(String roadSupportName) {
        this.roadSupportName = roadSupportName;
    }

    public long getRoadPlatformID() {
        return roadPlatformID;
    }

    public void setRoadPlatformID(long roadPlatformID) {
        this.roadPlatformID = roadPlatformID;
    }

    public String getRoadPlatformName() {
        return roadPlatformName;
    }

    public void setRoadPlatformName(String roadPlatformName) {
        this.roadPlatformName = roadPlatformName;
    }

    public String getRoadImage() {
        return roadImage;
    }

    public void setRoadImage(String roadImage) {
        this.roadImage = roadImage;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }

}
