package com.lukai.firstboot.web;
import com.alipay.api.*;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.lukai.firstboot.Pay.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.*;
import com.lukai.firstboot.Pay.AlipayConfig;

import static java.lang.System.out;

@Controller
public class PayController {


    @RequestMapping("/toPay")
    public String toPay(){
        return "Paystart";
    }

    @RequestMapping("/notify_url")
    public String tonotify_url(){
        return "notify_url";
    }

//    @RequestMapping("/return_url")
//    public String toreturn_url(){
//        return "return_url";
//    }
//这里是因为springboot无法直接访问jsp，所以参数如果用上面的方式进jsp那么参数会无法递交给jsp，只能暂时在这里处理参数，如果SDK验证成功可以跳转到自定义页面，下面只是输出部分信息
    @RequestMapping("/return_url")
    public void toreturn_url(HttpServletRequest request,HttpServletResponse response) throws IOException, AlipayApiException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = request.getParameter("out_trade_no");

            //支付宝交易号
            String trade_no =request.getParameter("trade_no");

            //付款金额
            String total_amount =request.getParameter("total_amount");



            response.getWriter().print("trade_no:" + trade_no + "<\\br>out_trade_no:" + out_trade_no + "<\\br>total_amount:" + total_amount);
        } else {
            response.getWriter().println("验签失败!");
        }
    }

    @RequestMapping("/pay")
    public void payController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);


        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");
        //付款金额，必填
        String total_amount = request.getParameter("WIDtotal_amount");
        //订单名称，必填
        String subject = request.getParameter("WIDsubject");
        //商品描述，可空
        String body = request.getParameter("WIDbody");

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"3m\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String form = "";
        try {

             form = new String(alipayClient.pageExecute(alipayRequest).getBody().getBytes(),"utf-8"); //调用SDK生成表单

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
}
