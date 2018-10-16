package com.bit.tatab.login.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.tatab.login.service.LoginService;
import com.bit.tatab.login.vo.LoginVO;
import com.bit.tatab.main.service.MainService;

@Controller
public class LoginController {

	@Inject
	LoginService loginService;

	// google login
/*	
    @RequestMapping(value="/googleLogin.do", method=RequestMethod.GET)
    public ModelAndView gooleLogin() throws Exception {
      
    	System.out.println("구글 로그인 GET");
	  
     	ModelAndView mav = new ModelAndView("userMain");
      
     	return mav;
    }
*/
	
	// google login
    @RequestMapping(value="/googleLogin.do", method=RequestMethod.POST)
    public ModelAndView gooleLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
    	System.out.println("구글 로그인 POST");
	  
     	String googleId = request.getParameter("googleId");
     	String name = request.getParameter("name");
      
     	LoginVO loginVO = new LoginVO(googleId, name);
     	System.out.println(loginVO.toString());
     	
    	
     	//////
    	List<LoginVO> checkLoginVOList = loginService.memberInfoFind(loginVO);

        // 세션객체 등록
        HttpSession session = request.getSession();
        session.setAttribute("login_email", loginVO.getLoginEmail());
		
        System.out.println("login_email: " + session.getAttribute("login_email"));
		
    	// System.out.println("checkLoginVO : " + checkLoginVOList.get(0).toString());
     	 
    	if(checkLoginVOList.size() == 0) {
    		System.out.println("vo 객체 db에 없음!");
        	// 로그인 정보 db에 추가
         	loginService.memberInfoInsert(loginVO);
         	
         	System.out.println("db에 로그인 정보 등록 완료");
    	} else {
    		System.out.println("vo 객체 db에 있음!");
    	}
     	
     	ModelAndView mav = new ModelAndView("userMain");
      
     	return mav;
    }
    
    
    // google logout
    @RequestMapping("/googleLogout.do")
    public ModelAndView googleLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
       // 세션객체 얻어오기
       HttpSession session = request.getSession();
       session.invalidate();
       
       ModelAndView mav = new ModelAndView("redirect:/");
       System.out.println("viewName 확인: " + mav.getViewName());
       
       System.out.println("구글 로그아웃 성공");
       return mav;
    }
    
    
}
