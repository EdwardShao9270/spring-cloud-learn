package com.sh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;

/**
 * @author bjzhangjie1
 * @date 2018/7/12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountChgLog {

    public static int INIT_STATUS = 0;
    public static int FAIL_STATUS = 6;
    public static int SUCCESS_STATUS = 7;

    private String id;

    private int logType;

    private String userName;

    private String partnerId;

    private String firmId;

    private String certNo;

    private String oldRegMobile;

    private String newRegMobile;

    private String oldBankMobile;

    private String newBankMobile;

    private String oldBankCardNo;

    private String  newBankCardNo;

    private String oldBankName;

    private String newBankName;

    private String realName;

    private String bankId;

    private int channel;

    private int status;

    private Timestamp createTime;

    private Timestamp updateTime;
}
