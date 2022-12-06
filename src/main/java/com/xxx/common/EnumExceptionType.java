package com.xxx.common;

public enum EnumExceptionType {
    SYSTEM_INTERNAL_ANOMALY(1000, "网络不给力，请稍后重试。"),
    VERIFY_FAILED(1001, "验证失败"),//登录验证码
    USER_ALREADY_EXIST(1002,"手机号已注册"),
    INVITER_NOT_EXIST(1003,"邀请人不存在"),
    USER_NOT_EXIST(1004,"用户不存在"),
    AUTH_ALREADY_UPGRADE(1005,"你已经升级过账号"),
    ALIYUN_SMS_FAILURE(1006,"短信发送失败"),
    COLLECTION_GROUP_ALREADY_EXIST(1007,"收藏分组已存在"),
    //    USER_ALREADY_EXIST_BUT_CAN_UPGRADE(1008,"注册失败，已经是个人账户，可以升级"),
    USER_ALREADY_EXIST_BUT_CAN_UPGRADE(1008,"账号已存在，请直接登录"),
    COMPANY_NOT_EXIST(1009,"公司不存在"),
    COMPANY_ALREADY_IN_COLLECTION(1010,"公司已收藏"),
    NO_COLLECTION_AUTHORITY(1011,"无管理该收藏的权限"),
    COLLECTION_GROUP_NOT_EXIST(1012,"收藏分组不存在"),
    COMPANY_BASEINFO_NOT_EXIST(1013,"公司基本信息不存在"),
    POINTS_NOT_ENOUGH(1014,"会员积分不足"),
    ORDER_ID_ALREAEDY_EXISTS(1015,"商户订单号重复"),
    FILE_ILLEGAL(1016,"文件非法"),
    ADMIN_ALREADY_EXISTS(1017,"该管理员已存在"),
    LOGIN_INVALID(1018,"登录状态失效，请重新登录");




    private int errorCode;

    private String codeMessage;

    EnumExceptionType(int errorCode, String codeMessage) {
        this.errorCode = errorCode;
        this.codeMessage = codeMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getCodeMessage() {
        return codeMessage;
    }
}
