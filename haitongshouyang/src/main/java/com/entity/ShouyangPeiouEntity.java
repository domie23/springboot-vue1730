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
 * 收养者配偶
 *
 * @author 
 * @email
 */
@TableName("shouyang_peiou")
public class ShouyangPeiouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShouyangPeiouEntity() {

	}

	public ShouyangPeiouEntity(T t) {
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
     * 收养
     */
    @TableField(value = "shouyang_id")

    private Integer shouyangId;


    /**
     * 收养者配偶姓名
     */
    @TableField(value = "shouyang_peiouren_name")

    private String shouyangPeiourenName;


    /**
     * 收养者配偶手机号
     */
    @TableField(value = "shouyang_peiouren_phone")

    private String shouyangPeiourenPhone;


    /**
     * 收养者配偶国籍
     */
    @TableField(value = "shouyang_peiouren_guoji")

    private String shouyangPeiourenGuoji;


    /**
     * 收养者配偶年龄
     */
    @TableField(value = "shouyang_peiouren_age")

    private String shouyangPeiourenAge;


    /**
     * 收养者配偶性别
     */
    @TableField(value = "shouyang_peiouren_sex_types")

    private Integer shouyangPeiourenSexTypes;


    /**
     * 收养者配偶出生年月
     */
    @TableField(value = "shouyang_peiouren_chushengnianyue")

    private String shouyangPeiourenChushengnianyue;


    /**
     * 收养者配偶身份证号
     */
    @TableField(value = "shouyang_peiouren_id_number")

    private String shouyangPeiourenIdNumber;


    /**
     * 现住址
     */
    @TableField(value = "shouyang_peiouren_xianzhuzhi")

    private String shouyangPeiourenXianzhuzhi;


    /**
     * 收养者配偶身份证照片
     */
    @TableField(value = "shouyang_peiouren_shenfenzheng_photo")

    private String shouyangPeiourenShenfenzhengPhoto;


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
	 * 设置：收养
	 */
    public Integer getShouyangId() {
        return shouyangId;
    }
    /**
	 * 获取：收养
	 */

    public void setShouyangId(Integer shouyangId) {
        this.shouyangId = shouyangId;
    }
    /**
	 * 设置：收养者配偶姓名
	 */
    public String getShouyangPeiourenName() {
        return shouyangPeiourenName;
    }
    /**
	 * 获取：收养者配偶姓名
	 */

    public void setShouyangPeiourenName(String shouyangPeiourenName) {
        this.shouyangPeiourenName = shouyangPeiourenName;
    }
    /**
	 * 设置：收养者配偶手机号
	 */
    public String getShouyangPeiourenPhone() {
        return shouyangPeiourenPhone;
    }
    /**
	 * 获取：收养者配偶手机号
	 */

    public void setShouyangPeiourenPhone(String shouyangPeiourenPhone) {
        this.shouyangPeiourenPhone = shouyangPeiourenPhone;
    }
    /**
	 * 设置：收养者配偶国籍
	 */
    public String getShouyangPeiourenGuoji() {
        return shouyangPeiourenGuoji;
    }
    /**
	 * 获取：收养者配偶国籍
	 */

    public void setShouyangPeiourenGuoji(String shouyangPeiourenGuoji) {
        this.shouyangPeiourenGuoji = shouyangPeiourenGuoji;
    }
    /**
	 * 设置：收养者配偶年龄
	 */
    public String getShouyangPeiourenAge() {
        return shouyangPeiourenAge;
    }
    /**
	 * 获取：收养者配偶年龄
	 */

    public void setShouyangPeiourenAge(String shouyangPeiourenAge) {
        this.shouyangPeiourenAge = shouyangPeiourenAge;
    }
    /**
	 * 设置：收养者配偶性别
	 */
    public Integer getShouyangPeiourenSexTypes() {
        return shouyangPeiourenSexTypes;
    }
    /**
	 * 获取：收养者配偶性别
	 */

    public void setShouyangPeiourenSexTypes(Integer shouyangPeiourenSexTypes) {
        this.shouyangPeiourenSexTypes = shouyangPeiourenSexTypes;
    }
    /**
	 * 设置：收养者配偶出生年月
	 */
    public String getShouyangPeiourenChushengnianyue() {
        return shouyangPeiourenChushengnianyue;
    }
    /**
	 * 获取：收养者配偶出生年月
	 */

    public void setShouyangPeiourenChushengnianyue(String shouyangPeiourenChushengnianyue) {
        this.shouyangPeiourenChushengnianyue = shouyangPeiourenChushengnianyue;
    }
    /**
	 * 设置：收养者配偶身份证号
	 */
    public String getShouyangPeiourenIdNumber() {
        return shouyangPeiourenIdNumber;
    }
    /**
	 * 获取：收养者配偶身份证号
	 */

    public void setShouyangPeiourenIdNumber(String shouyangPeiourenIdNumber) {
        this.shouyangPeiourenIdNumber = shouyangPeiourenIdNumber;
    }
    /**
	 * 设置：现住址
	 */
    public String getShouyangPeiourenXianzhuzhi() {
        return shouyangPeiourenXianzhuzhi;
    }
    /**
	 * 获取：现住址
	 */

    public void setShouyangPeiourenXianzhuzhi(String shouyangPeiourenXianzhuzhi) {
        this.shouyangPeiourenXianzhuzhi = shouyangPeiourenXianzhuzhi;
    }
    /**
	 * 设置：收养者配偶身份证照片
	 */
    public String getShouyangPeiourenShenfenzhengPhoto() {
        return shouyangPeiourenShenfenzhengPhoto;
    }
    /**
	 * 获取：收养者配偶身份证照片
	 */

    public void setShouyangPeiourenShenfenzhengPhoto(String shouyangPeiourenShenfenzhengPhoto) {
        this.shouyangPeiourenShenfenzhengPhoto = shouyangPeiourenShenfenzhengPhoto;
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
        return "ShouyangPeiou{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", shouyangId=" + shouyangId +
            ", shouyangPeiourenName=" + shouyangPeiourenName +
            ", shouyangPeiourenPhone=" + shouyangPeiourenPhone +
            ", shouyangPeiourenGuoji=" + shouyangPeiourenGuoji +
            ", shouyangPeiourenAge=" + shouyangPeiourenAge +
            ", shouyangPeiourenSexTypes=" + shouyangPeiourenSexTypes +
            ", shouyangPeiourenChushengnianyue=" + shouyangPeiourenChushengnianyue +
            ", shouyangPeiourenIdNumber=" + shouyangPeiourenIdNumber +
            ", shouyangPeiourenXianzhuzhi=" + shouyangPeiourenXianzhuzhi +
            ", shouyangPeiourenShenfenzhengPhoto=" + shouyangPeiourenShenfenzhengPhoto +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
