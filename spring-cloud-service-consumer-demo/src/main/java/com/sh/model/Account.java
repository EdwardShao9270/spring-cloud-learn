
package com.sh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account implements Cloneable, Serializable{

	private static final long serialVersionUID = -2745464744803816553L;

	private Long id;

	private String userId;

	/** 真实姓名 **/
	private String realName;

	/** 邮箱 **/
	private String email;

	/** 手机号 **/
	private String phone;

	/** 姓名 **/
	private String name;

	/** 身份证号 **/
	private String certno;

	/** 证件类别 **/
	private String certType; 
	
	/** 银行编号 **/
	private String bankid;

	private String bankName;

	/** 银行借记卡号 **/
	private String accno;

	/** 微信openid **/
	private String wxid;

	/** 交易商编号 是指用户在交易商的开户名*/
	private String firmid;
	
	/** type=1 南交所; **/
	private Integer type;

	private Long createTime;

	private Boolean sign;
	
	private Timestamp insertTime; // 生成时间

	private Timestamp updateTime; // 更新时间
	
	/** 交易所编号*/
	private String partnerId;
	
	/** 用户名,为后续去除userid依赖做准备*/
	private String username;
	
	/** 用户在该交易所的状态
	 * -1	开户失败
	 * 0	初始化or未获取到开户结果--需要重查
	 * 1	开户成功
	 * 2	签约成功
	 * 3	入金成功
	 * 4	已交易
	 */
	private Integer status;
	
	/**来源 app 手机客户端 ; web 页面 */
	private String source;
	
	/**初始密码*/
	private String password;
	
	/**资金密码*/
	private String passwordFund;
	
	/**用户VIP标识*/
	private Integer vipFlag;

	/**支付渠道*/
	private Integer epayFlag;

	private Integer errorCode;
	private String errorMsg;
	private Integer bankCityId;
	private Integer answer;
	private Integer tradeFlag;
	private String userIp;
	
	/**广贵开户后置需求，文件上传状态*/
	private int pmecStatus;
	
	private boolean fromCron;
	
    /** 银行渠道签约**/
    private String bankChannelInfo;

	/**注册手机号*/
	private String regMobile;

}