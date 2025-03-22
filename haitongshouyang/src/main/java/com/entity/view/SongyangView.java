package com.entity.view;

import com.entity.SongyangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 送养
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("songyang")
public class SongyangView extends SongyangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 送养者性别的值
		*/
		private String songyangSexValue;
		/**
		* 送养类型的值
		*/
		private String songyangValue;
		/**
		* 被送养者性别的值
		*/
		private String beiSexValue;



		//级联表 yuangong
			/**
			* 员工工号
			*/
			private String yuangongUuidNumber;
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工头像
			*/
			private String yuangongPhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 电子邮箱
			*/
			private String yuangongEmail;

	public SongyangView() {

	}

	public SongyangView(SongyangEntity songyangEntity) {
		try {
			BeanUtils.copyProperties(this, songyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 送养者性别的值
			*/
			public String getSongyangSexValue() {
				return songyangSexValue;
			}
			/**
			* 设置： 送养者性别的值
			*/
			public void setSongyangSexValue(String songyangSexValue) {
				this.songyangSexValue = songyangSexValue;
			}
			/**
			* 获取： 送养类型的值
			*/
			public String getSongyangValue() {
				return songyangValue;
			}
			/**
			* 设置： 送养类型的值
			*/
			public void setSongyangValue(String songyangValue) {
				this.songyangValue = songyangValue;
			}
			/**
			* 获取： 被送养者性别的值
			*/
			public String getBeiSexValue() {
				return beiSexValue;
			}
			/**
			* 设置： 被送养者性别的值
			*/
			public void setBeiSexValue(String beiSexValue) {
				this.beiSexValue = beiSexValue;
			}














				//级联表的get和set yuangong

					/**
					* 获取： 员工工号
					*/
					public String getYuangongUuidNumber() {
						return yuangongUuidNumber;
					}
					/**
					* 设置： 员工工号
					*/
					public void setYuangongUuidNumber(String yuangongUuidNumber) {
						this.yuangongUuidNumber = yuangongUuidNumber;
					}

					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}

					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}

					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}

					/**
					* 获取： 员工头像
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工头像
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}

					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getYuangongEmail() {
						return yuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYuangongEmail(String yuangongEmail) {
						this.yuangongEmail = yuangongEmail;
					}


}
