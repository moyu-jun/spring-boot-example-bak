package com.james.example.boot.hello.domain;

/**
 * 通过接口返回的状态码
 * 状态码共 5 位，错误码命名规则：错误产生来源 + 四位数字编号
 *
 * 错误产生来源：
 * A : 错误来源于用户
 * B : 错误来源于当前系统
 * C : 错误来源于第三方，如 CDN、RPC
 *
 * 四位数字编号从 0001 到 9999，大类之间的步长间距预留 100
 *
 * 编号确定之后，永久固定，不得修改。
 *
 * @author James
 * @date 2020/5/16
 */
public enum ResponseCode {

    /**
     * 成功返回，一切 OK
     */
    SUCCESS("00000", "操作成功"),

    /**
     * 一级宏观错误码
     * 用户端错误
     */
    USER("A0001", "用户端错误"),
    /**
     * 二级宏观错误码
     * 用户注册错误
     */
    USER_REG("A0100", "用户注册错误"),
    USER_REG_NO_AGREE_PRIVACY("A0101", "用户未同意隐私协议"),
    USER_REG_AREA_LIMIT("A0102", "注册国家或地区受限"),
    USER_REG_NAME_INVALID("A0110", "用户名校验失败"),
    USER_REG_NAME_EXIST("A0111", "用户名已存在"),
    USER_REG_NAME_SENSITIVE("A0112", "用户名包含敏感词"),
    USER_REG_NAME_SPECIAL("A0113", "用户名包含特殊字符"),
    USER_REG_PASSWORD_INVALID("A0120", "密码校验失败"),
    USER_REG_PASSWORD_SHORT("A0121", "密码长度不够"),
    USER_REG_PASSWORD_WEAK("A0122", "密码强度不够"),
    USER_REG_CODE_INVALID("A0130", "校验码输入错误"),
    USER_REG_SMS_CODE_INVALID("A0131", "短信校验码输入错误"),
    USER_REG_MAIL_CODE_INVALID("A0132", "邮件校验码输入错误"),
    USER_REG_VOICE_CODE_INVALID("A0133", "语音校验码输入错误"),
    USER_REG_CERT_INVALID("A0140", "用户证件异常"),
    USER_REG_CERT_TYPE_NOT_CHOOSE("A0141", "用户证件类型未选择"),
    USER_REG_ID_CARD_INVALID("A0142", "大陆身份证编号校验非法"),
    USER_REG_PASSPORT_INVALID("A0143", "护照编号校验非法"),
    USER_REG_BASE_INFO_INVALID("A0150", "用户基本信息校验失败"),
    USER_REG_MOBILE_INVALID("A0151", "手机格式校验失败"),
    USER_REG_ADDRESS_INVALID("A0152", "地址格式校验失败"),
    USER_REG_EMAIL_INVALID("A0153", "邮箱格式校验失败"),
    /**
     * 二级宏观错误码
     * 用户登陆异常
     */
    USER_LOGIN("A0200", "用户登陆异常"),
    USER_LOGIN_NOT_EXIST("A0201", "用户账户不存在"),
    USER_LOGIN_ACCOUNT_LOCKED("A0202", "用户账户被冻结"),
    USER_LOGIN_ACCOUNT_CANCELED("A0203", "用户账户已作废"),
    USER_LOGIN_PASSWORD_INVALID("A0210", "用户密码错误"),
    USER_LOGIN_PASSWORD_COUNT_EXCEED("A0211", "用户输入密码次数超限"),
    USER_LOGIN_ROLE_INVALID("A0220", "用户身份校验失败"),
    USER_LOGIN_THIRD_AUTH_INVALID("A0223", "用户未获得第三方登陆授权"),
    USER_LOGIN_EXPIRED("A0230", "用户登陆已过期"),
    USER_LOGIN_VERIFY_CODE_INVALID("A0240", "用户验证码错误"),
    USER_LOGIN_VERIFY_CODE_EXCEED("A0241", "用户验证码尝试次数超限"),
    /**
     * 二级宏观错误码
     * 访问权限异常
     */
    USER_AUTH("A0300", "访问权限异常"),
    USER_AUTH_ACCESS_DENIED("A0301", "访问未授权"),
    USER_AUTH_AUTHORIZING("A0302", "正在授权中"),
    USER_AUTH_REJECTED("A0303", "用户授权申请被拒绝"),
    USER_AUTH_INTERCEPTED_FOR_PRIVACY("A0310", "因访问对象隐私设置被拦截"),
    USER_AUTH_EXPIRED("A0311", "授权已过期"),
    USER_AUTH_NO_PERMISSION("A0312", "无权限使用 API"),
    USER_AUTH_REQUEST_INTERCEPTED("A0320", "用户访问被拦截"),
    USER_AUTH_BLACKLIST("A0321", "黑名单用户"),
    USER_AUTH_ACCOUNT_LOCKED("A0322", "账号被冻结"),
    USER_AUTH_IP_INVALID("A0323", "非法 IP 地址"),
    USER_AUTH_GATEWAY_ACCESS_DENIED("A0324", "网关访问受限"),
    USER_AUTH_REGION_BLACKLIST("A0325", "地域黑名单"),
    USER_AUTH_SERVICE_OVERDUE("A0330", "服务已欠费"),
    USER_AUTH_SIGNATURE_INVALID("A0340", "用户签名异常"),
    USER_AUTH_RSA_SIGNATURE_ERROR("A0341", "RSA 签名错误"),
    // TODO 认证中心所需的异常返回码
    USER_AUTH_CLIENT_INVALID("A0342", "无效的客户端"),
    USER_AUTH_CLIENT_UNAUTHORIZED("A0343", "未经授权的客户端"),
    USER_AUTH_GRANT_INVALID("A0344", "认证失败"),
    USER_AUTH_SCOPE_INVALID("A0345", "无效的认证范围"),
    USER_AUTH_TOKEN_INVALID("A0346", "无效的 token"),
    USER_AUTH_REQUEST_INVALID("A0346", "无效的请求"),
    USER_AUTH_REDIRECT_MISMATCH("A0346", "重定向 URL 不匹配"),
    USER_AUTH_GRANT_TYPE_UNSUPPORTED("A0347", "不支持的认证类型"),
    USER_AUTH_RESPONSE_TYPE_UNSUPPORTED("A0348", "不支持的响应类型"),

    /**
     * 二级宏观错误码
     * 用户请求参数错误
     */
    USER_PARAM("A0400", "用户请求参数错误"),
    USER_PARAM_INCLUDE_ILLEGAL_LINKS("A0401", "包含非法恶意跳转链接"),
    USER_PARAM_INPUT_INVALID("A0402", "无效的用户输入"),
    USER_PARAM_REQUIRED_IS_NULL("A0410", "请求必填参数为空"),
    USER_PARAM_ORDER_ID_IS_NULL("A0411", "用户订单号为空"),
    USER_PARAM_ORDER_AMOUNT_IS_NULL("A0412", "订购数量为空"),
    USER_PARAM_NOT_TIMESTAMP("A0413", "缺少时间戳参数"),
    USER_PARAM_TIMESTAMP_INVALID("A0414", "非法的时间戳参数"),
    USER_PARAM_VALUE_OUT_RANGE("A0420", "请求参数值超出允许的范围"),
    USER_PARAM_FORMAT_INVALID("A0421", "参数格式不匹配"),
    USER_PARAM_ADDRESS_OUT_RANGE("A0422", "地址不在服务范围"),
    USER_PARAM_TIME_OUT_RANGE("A0423", "时间不在服务范围"),
    USER_PARAM_MONEY_EXCEED("A0424", "金额超出限制"),
    USER_PARAM_AMOUNT_OUT_RANGE("A0425", "数量超出限制"),
    USER_PARAM_JSON_PARSE_FAILED("A0427", "请求 JSON 解析失败"),
    USER_PARAM_INPUT_CONTENT_INVALID("A0430", "用户输入内容非法"),
    USER_PARAM_INCLUDE_ILLEGAL_WORDS("A0431", "包含违禁敏感词"),
    USER_PARAM_IMAGE_INFO_ILLEGAL("A0432", "图片包含违禁信息"),
    USER_PARAM_FILE_COPYRIGHT_TORT("A0433", "文件侵犯版权"),
    USER_PARAM_OPERATION_ILLEGAL("A0440", "用户操作异常"),
    USER_PARAM_PAY_TIMEOUT("A0441", "用户支付超时"),
    USER_PARAM_ORDER_CONFIRM_TIMEOUT("A0442", "确认订单超时"),
    USER_PARAM_ORDER_CLOSED("A0443", "订单已关闭"),
    /**
     * 二级宏观错误码
     * 用户请求服务异常
     */
    USER_SERVICE("A0500", "用户请求服务异常"),
    USER_SERVICE_REQUEST_COUNT_EXCEED("A0501", "请求次数超出限制"),
    USER_SERVICE_REQUEST_CONCURRENT_EXCEED("A0502", "请求并发数超出限制"),
    USER_SERVICE_OPERATION_WAITING("A0503", "用户操作请等待"),
    USER_SERVICE_WEB_SOCKET_EXCEPTION("A0504", "WebSocket 连接异常"),
    USER_SERVICE_WEB_SOCKET_DISCONNECT("A0505", "WebSocket 连接断开"),
    USER_SERVICE_REQUEST_DUPLICATE("A0506", "用户重复请求"),
    USER_SERVICE_REQUEST_NOT_FOUND("A0507", "用户请求未找到"),
    USER_SERVICE_REQUEST_DATA_DUPLICATE("A0508", "用户请求数据重复"),

    /**
     * 二级宏观错误码
     * 用户资源异常
     */
    USER_RESOURCE("A0600", "用户资源异常"),
    USER_RESOURCE_ACCOUNT_BALANCE_OVER("A0601", "账户余额不足"),
    USER_RESOURCE_DISK_SPACE_OVER("A0602", "用户磁盘空间不足"),
    USER_RESOURCE_MEMORY_SPACE_OVER("A0603", "用户内存空间不足"),
    USER_RESOURCE_OSS_SPACE_OVER("A0604", "用户 OSS 容量不足"),
    // 例如：每天抽奖数
    USER_RESOURCE_USER_QUOTA_OVER("A0605", "用户配额已用光"),
    /**
     * 二级宏观错误码
     * 用户上传文件异常
     */
    USER_UPLOAD("A0700", "用户上传文件异常"),
    USER_UPLOAD_FILE_TYPE_MISMATCH("A0701", "用户上传文件类型不匹配"),
    USER_UPLOAD_FILE_TOO_LARGE("A0702", "用户上传文件太大"),
    USER_UPLOAD_IMAGE_TOO_LARGE("A0703", "用户上传图片太大"),
    USER_UPLOAD_VIDEO_TOO_LAGER("A0704", "用户上传视频太大"),
    USER_UPLOAD_ZIP_FILE_TOO_LARGE("A0705", "用户上传压缩文件太大"),
    /**
     * 二级宏观错误码
     * 用户当前版本异常
     */
    USER_VERSION("A0800", "用户当前版本异常"),
    USER_VERSION_SYSTEM_MISMATCH("A0801", "用户安装版本与系统不匹配"),
    USER_VERSION_TOO_LOW("A0802", "用户安装版本过低"),
    USER_VERSION_TOO_HIGH("A0803", "用户安装版本过高"),
    USER_VERSION_EXPIRED("A0804", "用户安装版本已过期"),
    USER_VERSION_API_MISMATCH("A0805", "用户 API 请求版本不匹配"),
    USER_VERSION_API_TOO_HIGH("A0806", "用户 API 请求版本过高"),
    USER_VERSION_API_TOO_LOW("A0807", "用户 API 请求版本过低"),
    /**
     * 二级宏观错误码
     * 用户隐私未授权
     */
    USER_PERMISSION("A0900", "用户隐私未授权"),
    USER_PERMISSION_NOT_CONFIRM("A0901", "用户隐私未签署"),
    USER_PERMISSION_NO_CAMERA("A0902", "用户摄像头未授权"),
    USER_PERMISSION_NO_CAMERA_SOFT("A0903", "用户相机未授权"),
    USER_PERMISSION_NO_PICTURE_LIB("A0904", "用户图片库未授权"),
    USER_PERMISSION_NO_FILE("A0905", "用户文件未授权"),
    USER_PERMISSION_NO_LOCATION("A0906", "用户位置信息未授权"),
    USER_PERMISSION_NO_MAIL_LIST("A0907", "用户通讯录未授权"),
    /**
     * 二级宏观错误码
     * 用户设备异常
     */
    USER_DEVICE("A1000", "用户设备异常"),
    USER_DEVICE_CAMERA("A1001", "用户相机异常"),
    USER_DEVICE_MICROPHONE("A1002", "用户麦克风异常"),
    USER_DEVICE_RECEIVER("A1003", "用户听筒异常"),
    USER_DEVICE_SPEAKER("A1004", "用户扬声器异常"),
    USER_DEVICE_GPS_LOCATION("A1005", "用户 GPS 定位异常"),

    /**
     * 一级宏观错误码
     * 系统执行出错
     */
    SYSTEM("B0001", "系统执行出错"),
    /**
     * 二级宏观错误码
     * 系统执行超时
     */
    SYSTEM_TIMEOUT_RUNNING("B0100", "系统执行超时"),
    SYSTEM_TIMEOUT_ORDER_PROCESS("B0101", "系统订单处理超时"),
    SYSTEM_DISASTER_RECOVERY_TRIGGER("B0200", "系统容灾功能被触发"),
    SYSTEM_CURRENT_LIMITING("B0210", "系统限流"),
    SYSTEM_DEMOTION("B0220", "系统功能降级"),
    /**
     * 二级宏观错误码
     * 系统资源异常
     */
    SYSTEM_RESOURCE("B0300", "系统资源异常"),
    SYSTEM_RESOURCE_OVER("B0310", "系统资源耗尽"),
    SYSTEM_RESOURCE_DISK_OVER("B0311", "系统磁盘空间耗尽"),
    SYSTEM_RESOURCE_MEMORY_OVER("B0312", "系统内存耗尽"),
    SYSTEM_RESOURCE_FILE_HANDLE_OVER("B0313", "文件句柄耗尽"),
    SYSTEM_RESOURCE_CONNECT_POOL_OVER("B0314", "系统连接池耗尽"),
    SYSTEM_RESOURCE_THREAD_POOL_OVER("B0315", "系统线程池耗尽"),
    SYSTEM_RESOURCE_ACCESS_DENIED("B0320", "系统资源访问异常"),
    SYSTEM_RESOURCE_READ_DISK_FILE_FAILED("B0321", "系统读取磁盘文件失败"),

    /**
     * 一级宏观错误码
     * 调用第三方服务出错
     */
    THIRD("C0001", "调用第三方服务出错"),
    /**
     * 二级宏观错误码
     * 中间件服务出错
     */
    THIRD_MIDDLE("C0100", "中间件服务出错"),
    THIRD_MIDDLE_RPC("C0110", "RPC 服务出错"),
    THIRD_MIDDLE_RPC_NOT_FOUND("C0111", "RPC 服务未找到"),
    THIRD_MIDDLE_RPC_NOT_REGISTER("C0112", "RPC 服务未注册"),
    THIRD_MIDDLE_INTERFACE_NOT_EXIST("C0113", "接口不存在"),
    THIRD_MIDDLE_MESSAGE("C0120", "消息服务出错"),
    THIRD_MIDDLE_MESSAGE_SEND_FAILED("C0121", "消息投递出错"),
    THIRD_MIDDLE_MESSAGE_CONSUME_FAILED("C0122", "消息消费出错"),
    THIRD_MIDDLE_MESSAGE_SUBSCRIBE_FAILED("C0123", "消息订阅出错"),
    THIRD_MIDDLE_MESSAGE_GROUP_NOT_FOUND("C0124", "消息分组未查到"),
    THIRD_MIDDLE_CACHE("C0130", "缓存服务出错"),
    THIRD_MIDDLE_CACHE_KEY_TOO_LONG("C0131", "key 长度超过限制"),
    THIRD_MIDDLE_CACHE_VALUE_TOO_LONG("C0132", "value 长度超过限制"),
    THIRD_MIDDLE_CACHE_STORAGE_OVER("C0133", "存储容量已满"),
    THIRD_MIDDLE_CACHE_DATA_FORMAT_NOT_SUPPORT("C0134", "不支持的数据格式"),
    THIRD_MIDDLE_CONFIG_SERVICE("C0140", "配置服务出错"),
    THIRD_MIDDLE_NET_RESOURCE_ERROR("C0150", "网络资源服务出错"),
    THIRD_MIDDLE_VPN_ERROR("C0151", "VPN 服务出错"),
    THIRD_MIDDLE_CDN_ERROR("C0152", "CDN 服务出错"),
    THIRD_MIDDLE_DNS_ERROR("C0153", "域名解析服务出错"),
    THIRD_MIDDLE_GATEWAY_ERROR("C0154", "网关服务出错"),
    /**
     * 二级宏观错误码
     * 第三方系统执行超时
     */
    THIRD_TIMEOUT("C0200", "第三方系统执行超时"),
    THIRD_TIMEOUT_RPC("C0210", "RPC 执行超时"),
    THIRD_TIMEOUT_MESSAGE_SEND("C0220", "消息投递超时"),
    THIRD_TIMEOUT_CACHE("C0230", "缓存服务超时"),
    THIRD_TIMEOUT_CONFIG("C0240", "配置服务超时"),
    THIRD_TIMEOUT_MYSQL("C0250", "数据库服务超时"),
    /**
     * 二级宏观错误码
     * 数据库服务出错
     */
    THIRD_DATABASE("C0300", "数据库服务出错"),
    THIRD_DATABASE_TABLE_NOT_FOUND("C0311", "表不存在"),
    THIRD_DATABASE_COLUMN_NOT_FOUND("C0312", "列不存在"),
    THIRD_DATABASE_INCLUDE_SAME_COLUMN("C0321", "多表关联中存在多个相同名称的列"),
    THIRD_DATABASE_DEADLOCK("C0331", "数据库死锁"),
    THIRD_DATABASE_PRIMARY_KEY_CONFLICT("C0341", "主键冲突"),
    /**
     * 二级宏观错误码
     * 第三方容灾系统被触发
     */
    THIRD_DISASTER_RECOVERY("C0400", "第三方容灾系统被触发"),
    THIRD__CURRENT_LIMITING("C0401", "第三方系统限流"),
    THIRD_DEMOTION("C0402", "第三方功能降级"),
    /**
     * 二级宏观错误码
     * 通知服务出错
     */
    THIRD_NOTICE("C0500", "通知服务出错"),
    THIRD_NOTICE_SMS_FAILED("C0501", "短信提醒服务失败"),
    THIRD_NOTICE_VOICE_FAILED("C0502", "语音提醒服务失败"),
    THIRD_NOTICE_EMAIL_FAILED("C0503", "邮件提醒服务失败");

    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
