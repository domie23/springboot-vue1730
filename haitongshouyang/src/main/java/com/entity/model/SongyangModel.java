package com.entity.model;

import com.entity.SongyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 送养
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SongyangModel implements Serializable {
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
     * 送养编号
     */
    private String songyangUuidNumber;


    /**
     * 送养人姓名
     */
    private String songyangrenName;


    /**
     * 送养人手机号
     */
    private String songyangrenPhone;


    /**
     * 送养人身份证号
     */
    private String songyangrenIdNumber;


    /**
     * 送养人照片
     */
    private String songyangrenPhoto;


    /**
     * 送养者性别
     */
    private Integer songyangSexTypes;


    /**
     * 送养人身份证照片
     */
    private String songyangrenShenfenzhengPhoto;


    /**
     * 原始记录相关文件
     */
    private String songyangrenYuanshijiluFile;


    /**
     * 机关相关证明文件
     */
    private String songyangrenJiguanzhengmingFile;


    /**
     * 送养类型
     */
    private Integer songyangTypes;


    /**
     * 被送养者姓名
     */
    private String beiName;


    /**
     * 被送养者照片
     */
    private String beiPhoto;


    /**
     * 被送养者性别
     */
    private Integer beiSexTypes;


    /**
     * 被送养者年龄
     */
    private String beiAge;


    /**
     * 被送养者身份证号
     */
    private String beiIdNumber;


    /**
     * 送养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date beiTime;


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
	 * 获取：送养编号
	 */
    public String getSongyangUuidNumber() {
        return songyangUuidNumber;
    }


    /**
	 * 设置：送养编号
	 */
    public void setSongyangUuidNumber(String songyangUuidNumber) {
        this.songyangUuidNumber = songyangUuidNumber;
    }
    /**
	 * 获取：送养人姓名
	 */
    public String getSongyangrenName() {
        return songyangrenName;
    }


    /**
	 * 设置：送养人姓名
	 */
    public void setSongyangrenName(String songyangrenName) {
        this.songyangrenName = songyangrenName;
    }
    /**
	 * 获取：送养人手机号
	 */
    public String getSongyangrenPhone() {
        return songyangrenPhone;
    }


    /**
	 * 设置：送养人手机号
	 */
    public void setSongyangrenPhone(String songyangrenPhone) {
        this.songyangrenPhone = songyangrenPhone;
    }
    /**
	 * 获取：送养人身份证号
	 */
    public String getSongyangrenIdNumber() {
        return songyangrenIdNumber;
    }


    /**
	 * 设置：送养人身份证号
	 */
    public void setSongyangrenIdNumber(String songyangrenIdNumber) {
        this.songyangrenIdNumber = songyangrenIdNumber;
    }
    /**
	 * 获取：送养人照片
	 */
    public String getSongyangrenPhoto() {
        return songyangrenPhoto;
    }


    /**
	 * 设置：送养人照片
	 */
    public void setSongyangrenPhoto(String songyangrenPhoto) {
        this.songyangrenPhoto = songyangrenPhoto;
    }
    /**
	 * 获取：送养者性别
	 */
    public Integer getSongyangSexTypes() {
        return songyangSexTypes;
    }


    /**
	 * 设置：送养者性别
	 */
    public void setSongyangSexTypes(Integer songyangSexTypes) {
        this.songyangSexTypes = songyangSexTypes;
    }
    /**
	 * 获取：送养人身份证照片
	 */
    public String getSongyangrenShenfenzhengPhoto() {
        return songyangrenShenfenzhengPhoto;
    }


    /**
	 * 设置：送养人身份证照片
	 */
    public void setSongyangrenShenfenzhengPhoto(String songyangrenShenfenzhengPhoto) {
        this.songyangrenShenfenzhengPhoto = songyangrenShenfenzhengPhoto;
    }
    /**
	 * 获取：原始记录相关文件
	 */
    public String getSongyangrenYuanshijiluFile() {
        return songyangrenYuanshijiluFile;
    }


    /**
	 * 设置：原始记录相关文件
	 */
    public void setSongyangrenYuanshijiluFile(String songyangrenYuanshijiluFile) {
        this.songyangrenYuanshijiluFile = songyangrenYuanshijiluFile;
    }
    /**
	 * 获取：机关相关证明文件
	 */
    public String getSongyangrenJiguanzhengmingFile() {
        return songyangrenJiguanzhengmingFile;
    }


    /**
	 * 设置：机关相关证明文件
	 */
    public void setSongyangrenJiguanzhengmingFile(String songyangrenJiguanzhengmingFile) {
        this.songyangrenJiguanzhengmingFile = songyangrenJiguanzhengmingFile;
    }
    /**
	 * 获取：送养类型
	 */
    public Integer getSongyangTypes() {
        return songyangTypes;
    }


    /**
	 * 设置：送养类型
	 */
    public void setSongyangTypes(Integer songyangTypes) {
        this.songyangTypes = songyangTypes;
    }
    /**
	 * 获取：被送养者姓名
	 */
    public String getBeiName() {
        return beiName;
    }


    /**
	 * 设置：被送养者姓名
	 */
    public void setBeiName(String beiName) {
        this.beiName = beiName;
    }
    /**
	 * 获取：被送养者照片
	 */
    public String getBeiPhoto() {
        return beiPhoto;
    }


    /**
	 * 设置：被送养者照片
	 */
    public void setBeiPhoto(String beiPhoto) {
        this.beiPhoto = beiPhoto;
    }
    /**
	 * 获取：被送养者性别
	 */
    public Integer getBeiSexTypes() {
        return beiSexTypes;
    }


    /**
	 * 设置：被送养者性别
	 */
    public void setBeiSexTypes(Integer beiSexTypes) {
        this.beiSexTypes = beiSexTypes;
    }
    /**
	 * 获取：被送养者年龄
	 */
    public String getBeiAge() {
        return beiAge;
    }


    /**
	 * 设置：被送养者年龄
	 */
    public void setBeiAge(String beiAge) {
        this.beiAge = beiAge;
    }
    /**
	 * 获取：被送养者身份证号
	 */
    public String getBeiIdNumber() {
        return beiIdNumber;
    }


    /**
	 * 设置：被送养者身份证号
	 */
    public void setBeiIdNumber(String beiIdNumber) {
        this.beiIdNumber = beiIdNumber;
    }
    /**
	 * 获取：送养时间
	 */
    public Date getBeiTime() {
        return beiTime;
    }


    /**
	 * 设置：送养时间
	 */
    public void setBeiTime(Date beiTime) {
        this.beiTime = beiTime;
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
