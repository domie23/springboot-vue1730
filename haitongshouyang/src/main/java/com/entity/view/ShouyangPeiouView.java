package com.entity.view;

import com.entity.ShouyangPeiouEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 收养者配偶
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shouyang_peiou")
public class ShouyangPeiouView extends ShouyangPeiouEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 收养者配偶性别的值
		*/
		private String shouyangPeiourenSexValue;



		//级联表 shouyang
			/**
			* 收养 的 员工
			*/
			private Integer shouyangYuangongId;
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
				* 送养者性别的值
				*/
				private String shouyangSexValue;
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
				* 收养类型的值
				*/
				private String shouyangValue;
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
				* 被收养者性别的值
				*/
				private String beishouyangSexValue;
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

	public ShouyangPeiouView() {

	}

	public ShouyangPeiouView(ShouyangPeiouEntity shouyangPeiouEntity) {
		try {
			BeanUtils.copyProperties(this, shouyangPeiouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 收养者配偶性别的值
			*/
			public String getShouyangPeiourenSexValue() {
				return shouyangPeiourenSexValue;
			}
			/**
			* 设置： 收养者配偶性别的值
			*/
			public void setShouyangPeiourenSexValue(String shouyangPeiourenSexValue) {
				this.shouyangPeiourenSexValue = shouyangPeiourenSexValue;
			}








				//级联表的get和set shouyang

					/**
					* 获取：收养 的 员工
					*/
					public Integer getShouyangYuangongId() {
						return shouyangYuangongId;
					}
					/**
					* 设置：收养 的 员工
					*/
					public void setShouyangYuangongId(Integer shouyangYuangongId) {
						this.shouyangYuangongId = shouyangYuangongId;
					}


					/**
					* 获取： 收养编号
					*/
					public String getShouyangUuidNumber() {
						return shouyangUuidNumber;
					}
					/**
					* 设置： 收养编号
					*/
					public void setShouyangUuidNumber(String shouyangUuidNumber) {
						this.shouyangUuidNumber = shouyangUuidNumber;
					}

					/**
					* 获取： 收养人姓名
					*/
					public String getShouyangrenName() {
						return shouyangrenName;
					}
					/**
					* 设置： 收养人姓名
					*/
					public void setShouyangrenName(String shouyangrenName) {
						this.shouyangrenName = shouyangrenName;
					}

					/**
					* 获取： 收养人手机号
					*/
					public String getShouyangrenPhone() {
						return shouyangrenPhone;
					}
					/**
					* 设置： 收养人手机号
					*/
					public void setShouyangrenPhone(String shouyangrenPhone) {
						this.shouyangrenPhone = shouyangrenPhone;
					}

					/**
					* 获取： 收养人国籍
					*/
					public String getShouyangrenGuoji() {
						return shouyangrenGuoji;
					}
					/**
					* 设置： 收养人国籍
					*/
					public void setShouyangrenGuoji(String shouyangrenGuoji) {
						this.shouyangrenGuoji = shouyangrenGuoji;
					}

					/**
					* 获取： 送养者性别
					*/
					public Integer getShouyangSexTypes() {
						return shouyangSexTypes;
					}
					/**
					* 设置： 送养者性别
					*/
					public void setShouyangSexTypes(Integer shouyangSexTypes) {
						this.shouyangSexTypes = shouyangSexTypes;
					}


						/**
						* 获取： 送养者性别的值
						*/
						public String getShouyangSexValue() {
							return shouyangSexValue;
						}
						/**
						* 设置： 送养者性别的值
						*/
						public void setShouyangSexValue(String shouyangSexValue) {
							this.shouyangSexValue = shouyangSexValue;
						}

					/**
					* 获取： 收养人出生年月
					*/
					public String getShouyangrenChushengnianyue() {
						return shouyangrenChushengnianyue;
					}
					/**
					* 设置： 收养人出生年月
					*/
					public void setShouyangrenChushengnianyue(String shouyangrenChushengnianyue) {
						this.shouyangrenChushengnianyue = shouyangrenChushengnianyue;
					}

					/**
					* 获取： 收养人身份证号
					*/
					public String getShouyangrenIdNumber() {
						return shouyangrenIdNumber;
					}
					/**
					* 设置： 收养人身份证号
					*/
					public void setShouyangrenIdNumber(String shouyangrenIdNumber) {
						this.shouyangrenIdNumber = shouyangrenIdNumber;
					}

					/**
					* 获取： 现住址
					*/
					public String getShouyangrenXianzhuzhi() {
						return shouyangrenXianzhuzhi;
					}
					/**
					* 设置： 现住址
					*/
					public void setShouyangrenXianzhuzhi(String shouyangrenXianzhuzhi) {
						this.shouyangrenXianzhuzhi = shouyangrenXianzhuzhi;
					}

					/**
					* 获取： 收养人能力情况证明文件
					*/
					public String getShouyangrenNengliqingkuangFile() {
						return shouyangrenNengliqingkuangFile;
					}
					/**
					* 设置： 收养人能力情况证明文件
					*/
					public void setShouyangrenNengliqingkuangFile(String shouyangrenNengliqingkuangFile) {
						this.shouyangrenNengliqingkuangFile = shouyangrenNengliqingkuangFile;
					}

					/**
					* 获取： 收养人身份证照片
					*/
					public String getShouyangrenShenfenzhengPhoto() {
						return shouyangrenShenfenzhengPhoto;
					}
					/**
					* 设置： 收养人身份证照片
					*/
					public void setShouyangrenShenfenzhengPhoto(String shouyangrenShenfenzhengPhoto) {
						this.shouyangrenShenfenzhengPhoto = shouyangrenShenfenzhengPhoto;
					}

					/**
					* 获取： 健康检查证明文件
					*/
					public String getShouyangrenJiankangjianchazhengmingFile() {
						return shouyangrenJiankangjianchazhengmingFile;
					}
					/**
					* 设置： 健康检查证明文件
					*/
					public void setShouyangrenJiankangjianchazhengmingFile(String shouyangrenJiankangjianchazhengmingFile) {
						this.shouyangrenJiankangjianchazhengmingFile = shouyangrenJiankangjianchazhengmingFile;
					}

					/**
					* 获取： 居民户口簿文件
					*/
					public String getShouyangrenHukoubuFile() {
						return shouyangrenHukoubuFile;
					}
					/**
					* 设置： 居民户口簿文件
					*/
					public void setShouyangrenHukoubuFile(String shouyangrenHukoubuFile) {
						this.shouyangrenHukoubuFile = shouyangrenHukoubuFile;
					}

					/**
					* 获取： 收养类型
					*/
					public Integer getShouyangTypes() {
						return shouyangTypes;
					}
					/**
					* 设置： 收养类型
					*/
					public void setShouyangTypes(Integer shouyangTypes) {
						this.shouyangTypes = shouyangTypes;
					}


						/**
						* 获取： 收养类型的值
						*/
						public String getShouyangValue() {
							return shouyangValue;
						}
						/**
						* 设置： 收养类型的值
						*/
						public void setShouyangValue(String shouyangValue) {
							this.shouyangValue = shouyangValue;
						}

					/**
					* 获取： 被收养者姓名
					*/
					public String getBeishouyangName() {
						return beishouyangName;
					}
					/**
					* 设置： 被收养者姓名
					*/
					public void setBeishouyangName(String beishouyangName) {
						this.beishouyangName = beishouyangName;
					}

					/**
					* 获取： 被收养者照片
					*/
					public String getBeishouyangPhoto() {
						return beishouyangPhoto;
					}
					/**
					* 设置： 被收养者照片
					*/
					public void setBeishouyangPhoto(String beishouyangPhoto) {
						this.beishouyangPhoto = beishouyangPhoto;
					}

					/**
					* 获取： 被收养者性别
					*/
					public Integer getBeishouyangSexTypes() {
						return beishouyangSexTypes;
					}
					/**
					* 设置： 被收养者性别
					*/
					public void setBeishouyangSexTypes(Integer beishouyangSexTypes) {
						this.beishouyangSexTypes = beishouyangSexTypes;
					}


						/**
						* 获取： 被收养者性别的值
						*/
						public String getBeishouyangSexValue() {
							return beishouyangSexValue;
						}
						/**
						* 设置： 被收养者性别的值
						*/
						public void setBeishouyangSexValue(String beishouyangSexValue) {
							this.beishouyangSexValue = beishouyangSexValue;
						}

					/**
					* 获取： 被收养者年龄
					*/
					public String getBeishouyangAge() {
						return beishouyangAge;
					}
					/**
					* 设置： 被收养者年龄
					*/
					public void setBeishouyangAge(String beishouyangAge) {
						this.beishouyangAge = beishouyangAge;
					}

					/**
					* 获取： 被收养人身份证号
					*/
					public String getBeishouyangIdNumber() {
						return beishouyangIdNumber;
					}
					/**
					* 设置： 被收养人身份证号
					*/
					public void setBeishouyangIdNumber(String beishouyangIdNumber) {
						this.beishouyangIdNumber = beishouyangIdNumber;
					}

					/**
					* 获取： 收养时间
					*/
					public Date getBeishouyangTime() {
						return beishouyangTime;
					}
					/**
					* 设置： 收养时间
					*/
					public void setBeishouyangTime(Date beishouyangTime) {
						this.beishouyangTime = beishouyangTime;
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
