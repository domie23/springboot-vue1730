package com.entity.model;

import com.entity.ShouyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收养
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShouyangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 收养编号
     */
    private String shouyangUuidNumber;


    /**
     * 收养人姓名
     */
    private String shouyangrenName;


    /**
     * 收养人手机号
     */
    private String shouyangrenPhone;


    /**
     * 收养人国籍
     */
    private String shouyangrenGuoji;


    /**
     * 送养者性别
     */
    private Integer shouyangSexTypes;


    /**
     * 收养人出生年月
     */
    private String shouyangrenChushengnianyue;


    /**
     * 收养人身份证号
     */
    private String shouyangrenIdNumber;


    /**
     * 现住址
     */
    private String shouyangrenXianzhuzhi;


    /**
     * 收养人能力情况证明文件
     */
    private String shouyangrenNengliqingkuangFile;


    /**
     * 收养人身份证照片
     */
    private String shouyangrenShenfenzhengPhoto;


    /**
     * 健康检查证明文件
     */
    private String shouyangrenJiankangjianchazhengmingFile;


    /**
     * 居民户口簿文件
     */
    private String shouyangrenHukoubuFile;


    /**
     * 收养类型
     */
    private Integer shouyangTypes;


    /**
     * 被收养者姓名
     */
    private String beishouyangName;


    /**
     * 被收养者照片
     */
    private String beishouyangPhoto;


    /**
     * 被收养者性别
     */
    private Integer beishouyangSexTypes;


    /**
     * 被收养者年龄
     */
    private String beishouyangAge;


    /**
     * 被收养人身份证号
     */
    private String beishouyangIdNumber;


    /**
     * 收养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date beishouyangTime;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：收养编号
	 */
    public String getShouyangUuidNumber() {
        return shouyangUuidNumber;
    }


    /**
	 * 设置：收养编号
	 */
    public void setShouyangUuidNumber(String shouyangUuidNumber) {
        this.shouyangUuidNumber = shouyangUuidNumber;
    }
    /**
	 * 获取：收养人姓名
	 */
    public String getShouyangrenName() {
        return shouyangrenName;
    }


    /**
	 * 设置：收养人姓名
	 */
    public void setShouyangrenName(String shouyangrenName) {
        this.shouyangrenName = shouyangrenName;
    }
    /**
	 * 获取：收养人手机号
	 */
    public String getShouyangrenPhone() {
        return shouyangrenPhone;
    }


    /**
	 * 设置：收养人手机号
	 */
    public void setShouyangrenPhone(String shouyangrenPhone) {
        this.shouyangrenPhone = shouyangrenPhone;
    }
    /**
	 * 获取：收养人国籍
	 */
    public String getShouyangrenGuoji() {
        return shouyangrenGuoji;
    }


    /**
	 * 设置：收养人国籍
	 */
    public void setShouyangrenGuoji(String shouyangrenGuoji) {
        this.shouyangrenGuoji = shouyangrenGuoji;
    }
    /**
	 * 获取：送养者性别
	 */
    public Integer getShouyangSexTypes() {
        return shouyangSexTypes;
    }


    /**
	 * 设置：送养者性别
	 */
    public void setShouyangSexTypes(Integer shouyangSexTypes) {
        this.shouyangSexTypes = shouyangSexTypes;
    }
    /**
	 * 获取：收养人出生年月
	 */
    public String getShouyangrenChushengnianyue() {
        return shouyangrenChushengnianyue;
    }


    /**
	 * 设置：收养人出生年月
	 */
    public void setShouyangrenChushengnianyue(String shouyangrenChushengnianyue) {
        this.shouyangrenChushengnianyue = shouyangrenChushengnianyue;
    }
    /**
	 * 获取：收养人身份证号
	 */
    public String getShouyangrenIdNumber() {
        return shouyangrenIdNumber;
    }


    /**
	 * 设置：收养人身份证号
	 */
    public void setShouyangrenIdNumber(String shouyangrenIdNumber) {
        this.shouyangrenIdNumber = shouyangrenIdNumber;
    }
    /**
	 * 获取：现住址
	 */
    public String getShouyangrenXianzhuzhi() {
        return shouyangrenXianzhuzhi;
    }


    /**
	 * 设置：现住址
	 */
    public void setShouyangrenXianzhuzhi(String shouyangrenXianzhuzhi) {
        this.shouyangrenXianzhuzhi = shouyangrenXianzhuzhi;
    }
    /**
	 * 获取：收养人能力情况证明文件
	 */
    public String getShouyangrenNengliqingkuangFile() {
        return shouyangrenNengliqingkuangFile;
    }


    /**
	 * 设置：收养人能力情况证明文件
	 */
    public void setShouyangrenNengliqingkuangFile(String shouyangrenNengliqingkuangFile) {
        this.shouyangrenNengliqingkuangFile = shouyangrenNengliqingkuangFile;
    }
    /**
	 * 获取：收养人身份证照片
	 */
    public String getShouyangrenShenfenzhengPhoto() {
        return shouyangrenShenfenzhengPhoto;
    }


    /**
	 * 设置：收养人身份证照片
	 */
    public void setShouyangrenShenfenzhengPhoto(String shouyangrenShenfenzhengPhoto) {
        this.shouyangrenShenfenzhengPhoto = shouyangrenShenfenzhengPhoto;
    }
    /**
	 * 获取：健康检查证明文件
	 */
    public String getShouyangrenJiankangjianchazhengmingFile() {
        return shouyangrenJiankangjianchazhengmingFile;
    }


    /**
	 * 设置：健康检查证明文件
	 */
    public void setShouyangrenJiankangjianchazhengmingFile(String shouyangrenJiankangjianchazhengmingFile) {
        this.shouyangrenJiankangjianchazhengmingFile = shouyangrenJiankangjianchazhengmingFile;
    }
    /**
	 * 获取：居民户口簿文件
	 */
    public String getShouyangrenHukoubuFile() {
        return shouyangrenHukoubuFile;
    }


    /**
	 * 设置：居民户口簿文件
	 */
    public void setShouyangrenHukoubuFile(String shouyangrenHukoubuFile) {
        this.shouyangrenHukoubuFile = shouyangrenHukoubuFile;
    }
    /**
	 * 获取：收养类型
	 */
    public Integer getShouyangTypes() {
        return shouyangTypes;
    }


    /**
	 * 设置：收养类型
	 */
    public void setShouyangTypes(Integer shouyangTypes) {
        this.shouyangTypes = shouyangTypes;
    }
    /**
	 * 获取：被收养者姓名
	 */
    public String getBeishouyangName() {
        return beishouyangName;
    }


    /**
	 * 设置：被收养者姓名
	 */
    public void setBeishouyangName(String beishouyangName) {
        this.beishouyangName = beishouyangName;
    }
    /**
	 * 获取：被收养者照片
	 */
    public String getBeishouyangPhoto() {
        return beishouyangPhoto;
    }


    /**
	 * 设置：被收养者照片
	 */
    public void setBeishouyangPhoto(String beishouyangPhoto) {
        this.beishouyangPhoto = beishouyangPhoto;
    }
    /**
	 * 获取：被收养者性别
	 */
    public Integer getBeishouyangSexTypes() {
        return beishouyangSexTypes;
    }


    /**
	 * 设置：被收养者性别
	 */
    public void setBeishouyangSexTypes(Integer beishouyangSexTypes) {
        this.beishouyangSexTypes = beishouyangSexTypes;
    }
    /**
	 * 获取：被收养者年龄
	 */
    public String getBeishouyangAge() {
        return beishouyangAge;
    }


    /**
	 * 设置：被收养者年龄
	 */
    public void setBeishouyangAge(String beishouyangAge) {
        this.beishouyangAge = beishouyangAge;
    }
    /**
	 * 获取：被收养人身份证号
	 */
    public String getBeishouyangIdNumber() {
        return beishouyangIdNumber;
    }


    /**
	 * 设置：被收养人身份证号
	 */
    public void setBeishouyangIdNumber(String beishouyangIdNumber) {
        this.beishouyangIdNumber = beishouyangIdNumber;
    }
    /**
	 * 获取：收养时间
	 */
    public Date getBeishouyangTime() {
        return beishouyangTime;
    }


    /**
	 * 设置：收养时间
	 */
    public void setBeishouyangTime(Date beishouyangTime) {
        this.beishouyangTime = beishouyangTime;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
