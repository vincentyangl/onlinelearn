package com.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Alipay {

	@RequestMapping("/Alipay/toindex")
	public String toindex(Double courseprice,Model model){
		if(courseprice!=null){
			model.addAttribute("courseprice",courseprice);
		}
		return "Alipay/index";
	}
	@RequestMapping("/Alipay/topay")
	public String pagepay(){
		return "Alipay/alipay.trade.page.pay";
	}
	@RequestMapping("/Alipay/query")
	public String query(){
		return "Alipay/alipay.trade.query";
	}
	@RequestMapping("/Alipay/refund")
	public String refund(){
		return "Alipay/alipay.trade.refund";
	}
	@RequestMapping("/Alipay/refundquery")
	public String refundquery(){
		return "Alipay/alipay.trade.fastpay.refund.query";
	}
	@RequestMapping("/Alipay/close")
	public String close(){
		return "Alipay/alipay.trade.close";
	}
	@RequestMapping("Alipay/notify_url")
	public String notify_url(){
		return "Alipay/notify_url";
	}
	@RequestMapping("Alipay/return_url")
	public String return_url(){
		
		return "Alipay/return_url";
	}
}
