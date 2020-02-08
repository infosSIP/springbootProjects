package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Formation;

@Controller

@RequestMapping(value= {"first","f*"})
public class FirstController {
	
	@Value("${mymessage}")
	private String msg;
	
	
	@RequestMapping("/home")
	//@ResponseBody
	public String home(@RequestParam  (required=true,defaultValue = "Spring") String framework,
			@RequestParam  (required=true,defaultValue = "Sesame") String lieu
			, Model model)
	{
		//System.out.println(framework);
		model.addAttribute("frm", framework).addAttribute("lieu", lieu).addAttribute("m", msg);
		
		ArrayList<String> as = new ArrayList<>();
		as.add("OCA");
		as.add("OCP");
		as.add("SPRING");
		as.add("SPRING BOOT");
		model.addAttribute("formations",as);
		///////////
		
		ArrayList <Formation> af = new ArrayList<>();
		af.add(new Formation(1,"oca",30,"java"));
		af.add(new Formation(2,"spring",40,"java 7"));
		af.add(new Formation(3,"spring boot",40,"java 8"));
		model.addAttribute("afs",af);
		return "First/home";
	}
	
	@RequestMapping("/book")
	public String book()
	{
		return "book";
	}

}
