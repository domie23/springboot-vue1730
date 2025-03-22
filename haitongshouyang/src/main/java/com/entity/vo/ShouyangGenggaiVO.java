package com.entity.vo;

import com.entity.ShouyangGenggaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 收养信息更改记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shouyang_genggai")
public class ShouyangGenggaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
