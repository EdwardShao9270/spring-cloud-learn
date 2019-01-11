package com.sh.model;

/**
 * @author bjzhangjie1
 * @date 2018/7/12
 */
public enum AccountChgTypeEnum {
    /**
     * 错误类型
     */
    /**
     * 错误类型
     */
    NULL(0,"错误类型"),
    /**
     * 更换注册手机号
     */
    REG_MOB_CHG(1, "更换注册手机号"),
    /**
     * 龙商新开户流程快捷签约并入金
     */
    QUICK_SING_AND_IN(2, "龙商新开户流程快捷签约并入金");


    private int value;
    private String desc;

    AccountChgTypeEnum(int v, String d) {
        value = v;
        desc = d;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static AccountChgTypeEnum getBankName(int id){
        for(AccountChgTypeEnum bankChannel : AccountChgTypeEnum.values()){
            if(bankChannel.getValue() == id){
                return bankChannel;
            }
        }
        return NULL;
    }
}
