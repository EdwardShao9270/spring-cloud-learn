package com.sh.model;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 保存身份证图片
 * @author bjshaohang
 */
@Data
public class AccountImg implements Serializable{

	private static final long serialVersionUID = -7677934430295624202L;

	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 交易所的tradeId
	 */
	private String firmId;
	/**
	 * 文件类型 A身份证
	 */
	private String fileType;
	/**
	 * 身份证正面&反面
	 */
	private Object file;
	private Object file2;

	/**
	 * 生成时间
	 */
	private Timestamp insertTime;
	/**
	 * 更新时间
	 */
	private Timestamp updateTime;
	/**
	 * 身份证验证状态：0.初始化； 1.自动识别过（不确定是否通过）；2.手动审核通过；3.等待审核
	 */
	private int status;
	/**
	 * 识别出的姓名
	 */
	private String realName;
	/**
	 * 识别出的身份证号
	 */
	private String certNo;
	private String filename1;
	private String filename2;
	private String hhtFileName1;
	private String hhtFilename2;
	private int hhtStatus;

	/**
	 * 交易所id
	 */
	private String partnerId;


    @Override
    public String toString() {
        return "AccountImg{" +
                "userName='" + userName + '\'' +
                ", firmId='" + firmId + '\'' +
                ", fileType='" + fileType + '\'' +
                ", file=" + file +
                ", file2=" + file2 +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", realName='" + realName + '\'' +
                ", certNo='" + certNo + '\'' +
                ", filename1='" + filename1 + '\'' +
                ", filename2='" + filename2 + '\'' +
                ", partnerId='" + partnerId + '\'' +
                '}';
    }
}
