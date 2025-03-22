package com.entity.model;

import com.entity.ShouyangPeiouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收养者配偶
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShouyangPeiouModel implements Serializable {
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
     * 收养
     */
    private Integer shouyangId;


    /**
     * 收养者配偶姓名
     */
    private String shouyangPeiourenName;


    /**
     * 收养者配偶手机号
     */
    private String shouyangPeiourenPhone;


    /**
     * 收养者配偶国籍
     */
    private String shouyangPeiourenGuoji;


    /**
     * 收养者配偶年龄
     */
    private String shouyangPeiourenAge;


    /**
     * 收养者配偶性别
     */
    private Integer shouyangPeiourenSexTypes;


    /**
     * 收养者配偶出生年月
     */
    private String shouyangPeiourenChushengnianyue;


    /**
     * 收养者配偶身份证号
     */
    private String shouyangPeiourenIdNumber;


    /**
     * 现住址
     */
    private String shouyangPeiourenXianzhuzhi;


    /**
     * 收养者配偶身份证照片
     */
    private String shouyangPeiourenShenfenzhengPhoto;


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
	 * 获取：收养
	 */
    public Integer getShouyangId() {
        return shouyangId;
    }


    /**
	 * 设置：收养
	 */
    public void setShouyangId(Integer shouyangId) {
        this.shouyangId = shouyangId;
    }
    /**
	 * 获取：收养者配偶姓名
	 */
    public String getShouyangPeiourenName() {
        return shouyangPeiourenName;
    }


    /**
	 * 设置：收养者配偶姓名
	 */
    public void setShouyangPeiourenName(String shouyangPeiourenName) {
        this.shouyangPeiourenName = shouyangPeiourenName;
    }
    /**
	 * 获取：收养者配偶手机号
	 */
    public String getShouyangPeiourenPhone() {
        return shouyangPeiourenPhone;
    }


    /**
	 * 设置：收养者配偶手机号
	 */
    public void setShouyangPeiourenPhone(String shouyangPeiourenPhone) {
        this.shouyangPeiourenPhone = shouyangPeiourenPhone;
    }
    /**
	 * 获取：收养者配偶国籍
	 */
    public String getShouyangPeiourenGuoji() {
        return shouyangPeiourenGuoji;
    }


    /**
	 * 设置：收养者配偶国籍
	 */
    public void setShouyangPeiourenGuoji(String shouyangPeiourenGuoji) {
        this.shouyangPeiourenGuoji = shouyangPeiourenGuoji;
    }
    /**
	 * 获取：收养者配偶年龄
	 */
    public String getShouyangPeiourenAge() {
        return shouyangPeiourenAge;
    }


    /**
	 * 设置：收养者配偶年龄
	 */
    public void setShouyangPeiourenAge(String shouyangPeiourenAge) {
        this.shouyangPeiourenAge = shouyangPeiourenAge;
    }
    /**
	 * 获取：收养者配偶性别
	 */
    public Integer getShouyangPeiourenSexTypes() {
        return shouyangPeiourenSexTypes;
    }


    /**
	 * 设置：收养者配偶性别
	 */
    public void setShouyangPeiourenSexTypes(Integer shouyangPeiourenSexTypes) {
        this.shouyangPeiourenSexTypes = shouyangPeiourenSexTypes;
    }
    /**
	 * 获取：收养者配偶出生年月
	 */
    public String getShouyangPeiourenChushengnianyue() {
        return shouyangPeiourenChushengnianyue;
    }


    /**
	 * 设置：收养者配偶出生年月
	 */
    public void setShouyangPeiourenChushengnianyue(String shouyangPeiourenChushengnianyue) {
        this.shouyangPeiourenChushengnianyue = shouyangPeiourenChushengnianyue;
    }
    /**
	 * 获取：收养者配偶身份证号
	 */
    public String getShouyangPeiourenIdNumber() {
        return shouyangPeiourenIdNumber;
    }


    /**
	 * 设置：收养者配偶身份证号
	 */
    public void setShouyangPeiourenIdNumber(String shouyangPeiourenIdNumber) {
        this.shouyangPeiourenIdNumber = shouyangPeiourenIdNumber;
    }
    /**
	 * 获取：现住址
	 */
    public String getShouyangPeiourenXianzhuzhi() {
        return shouyangPeiourenXianzhuzhi;
    }


    /**
	 * 设置：现住址
	 */
    public void setShouyangPeiourenXianzhuzhi(String shouyangPeiourenXianzhuzhi) {
        this.shouyangPeiourenXianzhuzhi = shouyangPeiourenXianzhuzhi;
    }
    /**
	 * 获取：收养者配偶身份证照片
	 */
    public String getShouyangPeiourenShenfenzhengPhoto() {
        return shouyangPeiourenShenfenzhengPhoto;
    }


    /**
	 * 设置：收养者配偶身份证照片
	 */
    public void setShouyangPeiourenShenfenzhengPhoto(String shouyangPeiourenShenfenzhengPhoto) {
        this.shouyangPeiourenShenfenzhengPhoto = shouyangPeiourenShenfenzhengPhoto;
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
