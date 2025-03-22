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
 * 送养
 *
 * @author 
 * @email
 */
@TableName("songyang")
public class SongyangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SongyangEntity() {

	}

	public SongyangEntity(T t) {
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
     * 送养编号
     */
    @TableField(value = "songyang_uuid_number")

    private String songyangUuidNumber;


    /**
     * 送养人姓名
     */
    @TableField(value = "songyangren_name")

    private String songyangrenName;


    /**
     * 送养人手机号
     */
    @TableField(value = "songyangren_phone")

    private String songyangrenPhone;


    /**
     * 送养人身份证号
     */
    @TableField(value = "songyangren_id_number")

    private String songyangrenIdNumber;


    /**
     * 送养人照片
     */
    @TableField(value = "songyangren_photo")

    private String songyangrenPhoto;


    /**
     * 送养者性别
     */
    @TableField(value = "songyang_sex_types")

    private Integer songyangSexTypes;


    /**
     * 送养人身份证照片
     */
    @TableField(value = "songyangren_shenfenzheng_photo")

    private String songyangrenShenfenzhengPhoto;


    /**
     * 原始记录相关文件
     */
    @TableField(value = "songyangren_yuanshijilu_file")

    private String songyangrenYuanshijiluFile;


    /**
     * 机关相关证明文件
     */
    @TableField(value = "songyangren_jiguanzhengming_file")

    private String songyangrenJiguanzhengmingFile;


    /**
     * 送养类型
     */
    @TableField(value = "songyang_types")

    private Integer songyangTypes;


    /**
     * 被送养者姓名
     */
    @TableField(value = "bei_name")

    private String beiName;


    /**
     * 被送养者照片
     */
    @TableField(value = "bei_photo")

    private String beiPhoto;


    /**
     * 被送养者性别
     */
    @TableField(value = "bei_sex_types")

    private Integer beiSexTypes;


    /**
     * 被送养者年龄
     */
    @TableField(value = "bei_age")

    private String beiAge;


    /**
     * 被送养者身份证号
     */
    @TableField(value = "bei_id_number")

    private String beiIdNumber;


    /**
     * 送养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "bei_time")

    private Date beiTime;


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
	 * 设置：送养编号
	 */
    public String getSongyangUuidNumber() {
        return songyangUuidNumber;
    }
    /**
	 * 获取：送养编号
	 */

    public void setSongyangUuidNumber(String songyangUuidNumber) {
        this.songyangUuidNumber = songyangUuidNumber;
    }
    /**
	 * 设置：送养人姓名
	 */
    public String getSongyangrenName() {
        return songyangrenName;
    }
    /**
	 * 获取：送养人姓名
	 */

    public void setSongyangrenName(String songyangrenName) {
        this.songyangrenName = songyangrenName;
    }
    /**
	 * 设置：送养人手机号
	 */
    public String getSongyangrenPhone() {
        return songyangrenPhone;
    }
    /**
	 * 获取：送养人手机号
	 */

    public void setSongyangrenPhone(String songyangrenPhone) {
        this.songyangrenPhone = songyangrenPhone;
    }
    /**
	 * 设置：送养人身份证号
	 */
    public String getSongyangrenIdNumber() {
        return songyangrenIdNumber;
    }
    /**
	 * 获取：送养人身份证号
	 */

    public void setSongyangrenIdNumber(String songyangrenIdNumber) {
        this.songyangrenIdNumber = songyangrenIdNumber;
    }
    /**
	 * 设置：送养人照片
	 */
    public String getSongyangrenPhoto() {
        return songyangrenPhoto;
    }
    /**
	 * 获取：送养人照片
	 */

    public void setSongyangrenPhoto(String songyangrenPhoto) {
        this.songyangrenPhoto = songyangrenPhoto;
    }
    /**
	 * 设置：送养者性别
	 */
    public Integer getSongyangSexTypes() {
        return songyangSexTypes;
    }
    /**
	 * 获取：送养者性别
	 */

    public void setSongyangSexTypes(Integer songyangSexTypes) {
        this.songyangSexTypes = songyangSexTypes;
    }
    /**
	 * 设置：送养人身份证照片
	 */
    public String getSongyangrenShenfenzhengPhoto() {
        return songyangrenShenfenzhengPhoto;
    }
    /**
	 * 获取：送养人身份证照片
	 */

    public void setSongyangrenShenfenzhengPhoto(String songyangrenShenfenzhengPhoto) {
        this.songyangrenShenfenzhengPhoto = songyangrenShenfenzhengPhoto;
    }
    /**
	 * 设置：原始记录相关文件
	 */
    public String getSongyangrenYuanshijiluFile() {
        return songyangrenYuanshijiluFile;
    }
    /**
	 * 获取：原始记录相关文件
	 */

    public void setSongyangrenYuanshijiluFile(String songyangrenYuanshijiluFile) {
        this.songyangrenYuanshijiluFile = songyangrenYuanshijiluFile;
    }
    /**
	 * 设置：机关相关证明文件
	 */
    public String getSongyangrenJiguanzhengmingFile() {
        return songyangrenJiguanzhengmingFile;
    }
    /**
	 * 获取：机关相关证明文件
	 */

    public void setSongyangrenJiguanzhengmingFile(String songyangrenJiguanzhengmingFile) {
        this.songyangrenJiguanzhengmingFile = songyangrenJiguanzhengmingFile;
    }
    /**
	 * 设置：送养类型
	 */
    public Integer getSongyangTypes() {
        return songyangTypes;
    }
    /**
	 * 获取：送养类型
	 */

    public void setSongyangTypes(Integer songyangTypes) {
        this.songyangTypes = songyangTypes;
    }
    /**
	 * 设置：被送养者姓名
	 */
    public String getBeiName() {
        return beiName;
    }
    /**
	 * 获取：被送养者姓名
	 */

    public void setBeiName(String beiName) {
        this.beiName = beiName;
    }
    /**
	 * 设置：被送养者照片
	 */
    public String getBeiPhoto() {
        return beiPhoto;
    }
    /**
	 * 获取：被送养者照片
	 */

    public void setBeiPhoto(String beiPhoto) {
        this.beiPhoto = beiPhoto;
    }
    /**
	 * 设置：被送养者性别
	 */
    public Integer getBeiSexTypes() {
        return beiSexTypes;
    }
    /**
	 * 获取：被送养者性别
	 */

    public void setBeiSexTypes(Integer beiSexTypes) {
        this.beiSexTypes = beiSexTypes;
    }
    /**
	 * 设置：被送养者年龄
	 */
    public String getBeiAge() {
        return beiAge;
    }
    /**
	 * 获取：被送养者年龄
	 */

    public void setBeiAge(String beiAge) {
        this.beiAge = beiAge;
    }
    /**
	 * 设置：被送养者身份证号
	 */
    public String getBeiIdNumber() {
        return beiIdNumber;
    }
    /**
	 * 获取：被送养者身份证号
	 */

    public void setBeiIdNumber(String beiIdNumber) {
        this.beiIdNumber = beiIdNumber;
    }
    /**
	 * 设置：送养时间
	 */
    public Date getBeiTime() {
        return beiTime;
    }
    /**
	 * 获取：送养时间
	 */

    public void setBeiTime(Date beiTime) {
        this.beiTime = beiTime;
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
        return "Songyang{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", songyangUuidNumber=" + songyangUuidNumber +
            ", songyangrenName=" + songyangrenName +
            ", songyangrenPhone=" + songyangrenPhone +
            ", songyangrenIdNumber=" + songyangrenIdNumber +
            ", songyangrenPhoto=" + songyangrenPhoto +
            ", songyangSexTypes=" + songyangSexTypes +
            ", songyangrenShenfenzhengPhoto=" + songyangrenShenfenzhengPhoto +
            ", songyangrenYuanshijiluFile=" + songyangrenYuanshijiluFile +
            ", songyangrenJiguanzhengmingFile=" + songyangrenJiguanzhengmingFile +
            ", songyangTypes=" + songyangTypes +
            ", beiName=" + beiName +
            ", beiPhoto=" + beiPhoto +
            ", beiSexTypes=" + beiSexTypes +
            ", beiAge=" + beiAge +
            ", beiIdNumber=" + beiIdNumber +
            ", beiTime=" + beiTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
