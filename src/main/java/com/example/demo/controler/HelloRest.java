package com.example.demo.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {
	
	@RequestMapping(value = "/hello",method=RequestMethod.GET)
	public String hello(){
		return "spring hello";
	}

	@RequestMapping(value = "/world",method=RequestMethod.POST)
	public String world(){
		return "spring world";
	}
	
	@RequestMapping(value = "/json",method=RequestMethod.GET)
	public RtnPojo json(){
		RtnPojo rtnPojo = new RtnPojo("success");
		return rtnPojo;
	}

}
