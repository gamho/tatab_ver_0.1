package com.bit.tatab.main.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.tatab.login.service.LoginService;
import com.bit.tatab.login.vo.LoginVO;
import com.bit.tatab.main.service.MainService;
import com.bit.tatab.main.vo.ProjectVO;
import com.bit.tatab.stickynote.vo.StickyNoteVO;


@Controller
public class MainController {

	@Inject
	MainService mainService;
	@Inject
	LoginService loginService;


	// GET 방식으로 호출되는 userMain 페이지
	@RequestMapping(value="/userMain.do", method=RequestMethod.GET)
	public ModelAndView userMain(HttpServletRequest request) {		
		
		System.out.println("!!!!!");
		
        // 세션객체 얻어오기
        HttpSession session = request.getSession();
        String login_email = session.getAttribute("login_email").toString();
        
    	List<StickyNoteVO> stickyNoteVOList = mainService.stickyNoteFindAll(login_email);
    	System.out.println("stickyNoteListSize : " + stickyNoteVOList.size());
    	
    	for(StickyNoteVO stickyNoteVO: stickyNoteVOList) {
    		System.out.println(stickyNoteVO.toString());
    	}
		
		ModelAndView mav = new ModelAndView("userMain");
		return mav;
		
	}
	
	
	// POST 방식으로 호출되는 userMain 페이지
	@RequestMapping(value="/userMain.do", method=RequestMethod.POST)
	public ModelAndView userMain(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginVO loginvo) throws Exception{
	
		System.out.println("@@@@@");

        // 세션객체 얻어오기
        HttpSession session = request.getSession();
    	List<StickyNoteVO> stickyNoteVOList = mainService.stickyNoteFindAll(session.getAttribute("login_email").toString());
    	System.out.println("stickyNoteListSize : " + stickyNoteVOList.size());
    	
    	for(StickyNoteVO stickyNoteVO: stickyNoteVOList) {
    		System.out.println(stickyNoteVO.toString());
    	}
    	
		ModelAndView mav = new ModelAndView("userMain");
		
		return mav;
		
	}

	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String register(@Valid ProjectVO projectVO) {
	       
//	       System.out.println("register.do post방식");
//	      System.out.println(projectVO.getProject_name());
//	      System.out.println(projectVO.getProject_comment());
	      mainService.insert(projectVO);
	      return "redirect:/userMain.do";
	 }
	
	@RequestMapping(value="/addStickyNoteProcess.do", method=RequestMethod.POST) 
	public String addStickyNoteProcess() {
		
		//mainService.insertStickyNote(stickyNoteVO);
		
		return "redirect:/";
	}
}
