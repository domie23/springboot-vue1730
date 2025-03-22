package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 收养
 *
 * @author 
 * @email
 */
@TableName("shouyang")
public class ShouyangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShouyangEntity() {

	}

	public ShouyangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 员工
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 收养编号
     */
    @TableField(value = "shouyang_uuid_number")

    private String shouyangUuidNumber;


    /**
     * 收养人姓名
     */
    @TableField(value = "shouyangren_name")

    private String shouyangrenName;


    /**
     * 收养人手机号
     */
    @TableField(value = "shouyangren_phone")

    private String shouyangrenPhone;


    /**
     * 收养人国籍
     */
    @TableField(value = "shouyangren_guoji")

    private String shouyangrenGuoji;


    /**
     * 送养者性别
     */
    @TableField(value = "shouyang_sex_types")

    private Integer shouyangSexTypes;


    /**
     * 收养人出生年月
     */
    @TableField(value = "shouyangren_chushengnianyue")

    private String shouyangrenChushengnianyue;


    /**
     * 收养人身份证号
     */
    @TableField(value = "shouyangren_id_number")

    private String shouyangrenIdNumber;


    /**
     * 现住址
     */
    @TableField(value = "shouyangren_xianzhuzhi")

    private String shouyangrenXianzhuzhi;


    /**
     * 收养人能力情况证明文件
     */
    @TableField(value = "shouyangren_nengliqingkuang_file")

    private String shouyangrenNengliqingkuangFile;


    /**
     * 收养人身份证照片
     */
    @TableField(value = "shouyangren_shenfenzheng_photo")

    private String shouyangrenShenfenzhengPhoto;


    /**
     * 健康检查证明文件
     */
    @TableField(value = "shouyangren_jiankangjianchazhengming_file")

    private String shouyangrenJiankangjianchazhengmingFile;


    /**
     * 居民户口簿文件
     */
    @TableField(value = "shouyangren_hukoubu_file")

    private String shouyangrenHukoubuFile;


    /**
     * 收养类型
     */
    @TableField(value = "shouyang_types")

    private Integer shouyangTypes;


    /**
     * 被收养者姓名
     */
    @TableField(value = "beishouyang_name")

    private String beishouyangName;


    /**
     * 被收养者照片
     */
    @TableField(value = "beishouyang_photo")

    private String beishouyangPhoto;


    /**
     * 被收养者性别
     */
    @TableField(value = "beishouyang_sex_types")

    private Integer beishouyangSexTypes;


    /**
     * 被收养者年龄
     */
    @TableField(value = "beishouyang_age")

    private String beishouyangAge;


    /**
     * 被收养人身份证号
     */
    @TableField(value = "beishouyang_id_number")

    private String beishouyangIdNumber;


    /**
     * 收养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "beishouyang_time")

    private Date beishouyangTime;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：收养编号
	 */
    public String getShouyangUuidNumber() {
        return shouyangUuidNumber;
    }
    /**
	 * 获取：收养编号
	 */

    public void setShouyangUuidNumber(String shouyangUuidNumber) {
        this.shouyangUuidNumber = shouyangUuidNumber;
    }
    /**
	 * 设置：收养人姓名
	 */
    public String getShouyangrenName() {
        return shouyangrenName;
    }
    /**
	 * 获取：收养人姓名
	 */

    public void setShouyangrenName(String shouyangrenName) {
        this.shouyangrenName = shouyangrenName;
    }
    /**
	 * 设置：收养人手机号
	 */
    public String getShouyangrenPhone() {
        return shouyangrenPhone;
    }
    /**
	 * 获取：收养人手机号
	 */

    public void setShouyangrenPhone(String shouyangrenPhone) {
        this.shouyangrenPhone = shouyangrenPhone;
    }
    /**
	 * 设置：收养人国籍
	 */
    public String getShouyangrenGuoji() {
        return shouyangrenGuoji;
    }
    /**
	 * 获取：收养人国籍
	 */

    public void setShouyangrenGuoji(String shouyangrenGuoji) {
        this.shouyangrenGuoji = shouyangrenGuoji;
    }
    /**
	 * 设置：送养者性别
	 */
    public Integer getShouyangSexTypes() {
        return shouyangSexTypes;
    }
    /**
	 * 获取：送养者性别
	 */

    public void setShouyangSexTypes(Integer shouyangSexTypes) {
        this.shouyangSexTypes = shouyangSexTypes;
    }
    /**
	 * 设置：收养人出生年月
	 */
    public String getShouyangrenChushengnianyue() {
        return shouyangrenChushengnianyue;
    }
    /**
	 * 获取：收养人出生年月
	 */

    public void setShouyangrenChushengnianyue(String shouyangrenChushengnianyue) {
        this.shouyangrenChushengnianyue = shouyangrenChushengnianyue;
    }
    /**
	 * 设置：收养人身份证号
	 */
    public String getShouyangrenIdNumber() {
        return shouyangrenIdNumber;
    }
    /**
	 * 获取：收养人身份证号
	 */

    public void setShouyangrenIdNumber(String shouyangrenIdNumber) {
        this.shouyangrenIdNumber = shouyangrenIdNumber;
    }
    /**
	 * 设置：现住址
	 */
    public String getShouyangrenXianzhuzhi() {
        return shouyangrenXianzhuzhi;
    }
    /**
	 * 获取：现住址
	 */

    public void setShouyangrenXianzhuzhi(String shouyangrenXianzhuzhi) {
        this.shouyangrenXianzhuzhi = shouyangrenXianzhuzhi;
    }
    /**
	 * 设置：收养人能力情况证明文件
	 */
    public String getShouyangrenNengliqingkuangFile() {
        return shouyangrenNengliqingkuangFile;
    }
    /**
	 * 获取：收养人能力情况证明文件
	 */

    public void setShouyangrenNengliqingkuangFile(String shouyangrenNengliqingkuangFile) {
        this.shouyangrenNengliqingkuangFile = shouyangrenNengliqingkuangFile;
    }
    /**
	 * 设置：收养人身份证照片
	 */
    public String getShouyangrenShenfenzhengPhoto() {
        return shouyangrenShenfenzhengPhoto;
    }
    /**
	 * 获取：收养人身份证照片
	 */

    public void setShouyangrenShenfenzhengPhoto(String shouyangrenShenfenzhengPhoto) {
        this.shouyangrenShenfenzhengPhoto = shouyangrenShenfenzhengPhoto;
    }
    /**
	 * 设置：健康检查证明文件
	 */
    public String getShouyangrenJiankangjianchazhengmingFile() {
        return shouyangrenJiankangjianchazhengmingFile;
    }
    /**
	 * 获取：健康检查证明文件
	 */

    public void setShouyangrenJiankangjianchazhengmingFile(String shouyangrenJiankangjianchazhengmingFile) {
        this.shouyangrenJiankangjianchazhengmingFile = shouyangrenJiankangjianchazhengmingFile;
    }
    /**
	 * 设置：居民户口簿文件
	 */
    public String getShouyangrenHukoubuFile() {
        return shouyangrenHukoubuFile;
    }
    /**
	 * 获取：居民户口簿文件
	 */

    public void setShouyangrenHukoubuFile(String shouyangrenHukoubuFile) {
        this.shouyangrenHukoubuFile = shouyangrenHukoubuFile;
    }
    /**
	 * 设置：收养类型
	 */
    public Integer getShouyangTypes() {
        return shouyangTypes;
    }
    /**
	 * 获取：收养类型
	 */

    public void setShouyangTypes(Integer shouyangTypes) {
        this.shouyangTypes = shouyangTypes;
    }
    /**
	 * 设置：被收养者姓名
	 */
    public String getBeishouyangName() {
        return beishouyangName;
    }
    /**
	 * 获取：被收养者姓名
	 */

    public void setBeishouyangName(String beishouyangName) {
        this.beishouyangName = beishouyangName;
    }
    /**
	 * 设置：被收养者照片
	 */
    public String getBeishouyangPhoto() {
        return beishouyangPhoto;
    }
    /**
	 * 获取：被收养者照片
	 */

    public void setBeishouyangPhoto(String beishouyangPhoto) {
        this.beishouyangPhoto = beishouyangPhoto;
    }
    /**
	 * 设置：被收养者性别
	 */
    public Integer getBeishouyangSexTypes() {
        return beishouyangSexTypes;
    }
    /**
	 * 获取：被收养者性别
	 */

    public void setBeishouyangSexTypes(Integer beishouyangSexTypes) {
        this.beishouyangSexTypes = beishouyangSexTypes;
    }
    /**
	 * 设置：被收养者年龄
	 */
    public String getBeishouyangAge() {
        return beishouyangAge;
    }
    /**
	 * 获取：被收养者年龄
	 */

    public void setBeishouyangAge(String beishouyangAge) {
        this.beishouyangAge = beishouyangAge;
    }
    /**
	 * 设置：被收养人身份证号
	 */
    public String getBeishouyangIdNumber() {
        return beishouyangIdNumber;
    }
    /**
	 * 获取：被收养人身份证号
	 */

    public void setBeishouyangIdNumber(String beishouyangIdNumber) {
        this.beishouyangIdNumber = beishouyangIdNumber;
    }
    /**
	 * 设置：收养时间
	 */
    public Date getBeishouyangTime() {
        return beishouyangTime;
    }
    /**
	 * 获取：收养时间
	 */

    public void setBeishouyangTime(Date beishouyangTime) {
        this.beishouyangTime = beishouyangTime;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shouyang{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", shouyangUuidNumber=" + shouyangUuidNumber +
            ", shouyangrenName=" + shouyangrenName +
            ", shouyangrenPhone=" + shouyangrenPhone +
            ", shouyangrenGuoji=" + shouyangrenGuoji +
            ", shouyangSexTypes=" + shouyangSexTypes +
            ", shouyangrenChushengnianyue=" + shouyangrenChushengnianyue +
            ", shouyangrenIdNumber=" + shouyangrenIdNumber +
            ", shouyangrenXianzhuzhi=" + shouyangrenXianzhuzhi +
            ", shouyangrenNengliqingkuangFile=" + shouyangrenNengliqingkuangFile +
            ", shouyangrenShenfenzhengPhoto=" + shouyangrenShenfenzhengPhoto +
            ", shouyangrenJiankangjianchazhengmingFile=" + shouyangrenJiankangjianchazhengmingFile +
            ", shouyangrenHukoubuFile=" + shouyangrenHukoubuFile +
            ", shouyangTypes=" + shouyangTypes +
            ", beishouyangName=" + beishouyangName +
            ", beishouyangPhoto=" + beishouyangPhoto +
            ", beishouyangSexTypes=" + beishouyangSexTypes +
            ", beishouyangAge=" + beishouyangAge +
            ", beishouyangIdNumber=" + beishouyangIdNumber +
            ", beishouyangTime=" + beishouyangTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
