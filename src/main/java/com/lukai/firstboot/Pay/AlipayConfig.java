package com.lukai.firstboot.Pay;
import java.io.*;
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000120602046";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCrilpgwhAUb4o/YVlhl3JGDuaw8S6DLdAInDFEnpklCooaNnMun2RCBVpbu0Pln8y49cdRlBGX1UiLRCTNiusANCC+FFpBC34CD40jznF7biJZGWQqxFD2xcTaBhY1YuqWbnxfS9JgeinVBb9lApk4GAMdhwTPupb4IYtd7F7J2WXNAESikPi/fhwnjngEld7QH01BlsumY7tEJm6SA/KDT3GOfcz/YNiLpyT+wn+5RwiclvGDShUPHODQIEnYlzY1dL3vdlPKZBDCQZrprhlTt7qCOxCaqXk/yafgMIgcmNr9D5KHwva/psW0ZihcmacXvgnGwsn/EC9lvotz0UgDAgMBAAECggEAcJ5qa2+8ws3fw3CUD8Av49LQnYYZ9UFUfPKeXeCJxom+1Sq+P/OhDL8a7XJqRwy8iQnDC8ncKwR5lgTs7Iyxb/bJMEGIZ3+2AIBZNxLH6jMKFdjXrEQqq3h3nnO0jOQeAxkSSjYrLe/GGvalCxnDodIR6YbFH+PuTYUoTEdsi7M5kBnk7W+zNGYxi2N56UGsZn3hd1Lo9zawCxtTsi9UTAYripIswX1qkXqycOYF5U0CWryWD5wGxLqMzvFBeg71z9XzvIS1jmDaeRzjkjS7FVXqXY/qI7iBp0zZOUTjGFJAekfF8ZC0NQe4pfihcOsuZ4QcZ68wzARZ/Wby6u7pkQKBgQD2sZn00xSSk/Roqvr8cH+ec+/TkHbFJkgJf90Ep7p7xyPi0FPspvtvbsVd1mOG2rP4hPvrt/Cs4bUsOuT8v8Xc0jXps0fBb9mYxfGAwdNVB5OwyqrIHgYW50u0Pn/2q7c2lVNnGCtcNYGJdnWvbGvihdUx7NyJ46xAsW0jDbRvPQKBgQCyAvj+hu3iLVadngg/X4Qi0uhsCSI2ljI8rJMCVJr8gRvXLy1wOkDCSNH/061vQKKbJIXraU5x6zXubkiE8lrmRr8xzN5j+UgTIpkpqp6U+Lqw42aWjTX1HmTvaxrRsUx/W6e/kX2mz1TJ7C4j/QPTPP1Y0nz+derE0Y/kQ7AIPwKBgE6Dc9Zhn7iO8kilsj/JpjRN/dQ9tC9G4cJ0OWmT4Fwooxk66Jr3AisS/CnDY+W1kXXVDUCWSDkdlMXA8MQoXNbM6G+6qWm9KWngBd7O0W3MfYrU1cnfFF0RvBxfj+Z3/FWY7PRw0swEE3gmhYoRXby4j4PWONKB7X6heXSglf6ZAoGAF6tBhEZYlvxESgzbN+HxZdf5Q3QrcmqiH2Mq4OJzASQBmakSN5vnRG3+Ti/NHb/QXySKEfUckxUdRKixR8wZvgimH28IGu7oYHL3Po0LLO+tkxuJZnc8N21lKlhpZnxWmZCMS3KC7I0gzwByWiKoQYwYe5jxObxgDO94XHeLjm0CgYA8iHI7g0SutyjWupVOvI3UjDEutbs3pOVc4MbsTyGWhaDb07vTKgIfcvcYxQhGH3R5yY/Hh/8xy4sdHVpDtHuZaKz8+3sjYJyWeE9h01nC0pCX3L5MEz9jgnsdymMxOnCGT6qXnxj8Ke3hhX01EchN+4H88NGTnTLeSrQtE7Kdkg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    //同一个应用公钥在正常环境和沙箱下生成的支付宝公钥是不一样的哦！
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwBVoK2BcSUEf6do1lV0utCDZBuWO53a/gETtYIRKRESt1EzRfH1ZWmnljkHyQge9hAI7ghaeftONF65+UFrvTwv0dFedecDTjAkhI3fhrxzN4f8IyNy0sUufZhWN5WhUyuH/fALDhYshTpnt5x1IdG57J8/rXbkqUgBt5WWInBgxNjV8eU5rBowrCqJztZkpW8uqcqhgjIf+Uf6YdniLY9EhOZTexFcKnsFLyXRr6WaFAWbGx5s8W0R75lkDQf4ueEMlNg9TQPYoAzBwhtN19xMcm/dUpuPX4cWblIQXZCJLlFT24hqSEVAGKZxHFrmEGAEkps9+nlsb6vD+fLO2KQIDAQAB";
    //每周维护后沙箱的公钥就不一样了MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0TW4iTFqmmvfEzap96Y3T2c4L8WZnwIJQg/yg5WSCXXnabsqLUgJ8y6sbwgu3UWknqSpa3hmKzsDmg6Zv8xLfk4tmav9ufRxxYwRh732jv2e729Z7818j+BGurkDvfkW/0W5xh1RCUpGMENfQhfMI2aFmn/ORpsoDtD/y4KHgKzTRf5O6TQs8HlwM1UETDdcB2k+nQ9xMYZUWHF/jWxSOf0G1A/sbgcLc8gLqXW39uhOK/KCmpenmtltQT/yFSjm2VepqYtqoKBtIwIqs0JpJ+udJHE8hjec3y0scxDz93wcO7q17ZXit9fIk40zB9LsGe+7ow2jtHgBb60N7fe4hwIDAQAB

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8888/firstboot/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8888/firstboot/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
