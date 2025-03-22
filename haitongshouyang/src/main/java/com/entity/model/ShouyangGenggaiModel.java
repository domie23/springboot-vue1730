package com.entity.model;

import com.entity.ShouyangGenggaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收养信息更改记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShouyangGenggaiModel implements Serializable {
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
     * 修改前
     */
    private String xiugaiqianText;


    /**
     * 修改后
     */
    private String xiugaihouText;


    /**
     * 修改时间
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
	 * 获取：修改前
	 */
    public String getXiugaiqianText() {
        return xiugaiqianText;
    }


    /**
	 * 设置：修改前
	 */
    public void setXiugaiqianText(String xiugaiqianText) {
        this.xiugaiqianText = xiugaiqianText;
    }
    /**
	 * 获取：修改后
	 */
    public String getXiugaihouText() {
        return xiugaihouText;
    }


    /**
	 * 设置：修改后
	 */
    public void setXiugaihouText(String xiugaihouText) {
        this.xiugaihouText = xiugaihouText;
    }
    /**
	 * 获取：修改时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：修改时间
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
