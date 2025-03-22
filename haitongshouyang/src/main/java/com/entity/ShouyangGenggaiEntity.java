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
 * 收养信息更改记录
 *
 * @author 
 * @email
 */
@TableName("shouyang_genggai")
public class ShouyangGenggaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShouyangGenggaiEntity() {

	}

	public ShouyangGenggaiEntity(T t) {
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
     * 修改前
     */
    @TableField(value = "xiugaiqian_text")

    private String xiugaiqianText;


    /**
     * 修改后
     */
    @TableField(value = "xiugaihou_text")

    private String xiugaihouText;


    /**
     * 修改时间
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
	 * 设置：修改前
	 */
    public String getXiugaiqianText() {
        return xiugaiqianText;
    }
    /**
	 * 获取：修改前
	 */

    public void setXiugaiqianText(String xiugaiqianText) {
        this.xiugaiqianText = xiugaiqianText;
    }
    /**
	 * 设置：修改后
	 */
    public String getXiugaihouText() {
        return xiugaihouText;
    }
    /**
	 * 获取：修改后
	 */

    public void setXiugaihouText(String xiugaihouText) {
        this.xiugaihouText = xiugaihouText;
    }
    /**
	 * 设置：修改时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：修改时间
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
        return "ShouyangGenggai{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", shouyangId=" + shouyangId +
            ", xiugaiqianText=" + xiugaiqianText +
            ", xiugaihouText=" + xiugaihouText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
