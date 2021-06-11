package com.cat.cat.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cat.cat.service.CatWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cat.cat.service.CatWorldService;
import com.cat.cat.vo.CatVO;

@Controller
@RequestMapping("/cat/")
public class CatWorldController {
	
	private static final Logger logger = LoggerFactory.getLogger(CatWorldController.class);
	// Service와 연결
	// URL market/...
	@Resource(name="CatWorldService")
	private CatWorldService CatWorldService;
	
	// join 페이지에 입력만 할 수 있게 페이지만 리턴
	@RequestMapping("join")
	public String join() throws Exception {
		return "join";
	}
	
	// join을 입력해서 실제 디비에 저장하고 오는 곳
	@RequestMapping("joinProc")
	public String joinProc(CatVO catVO) throws Exception {
		
		CatWorldService.joinProc(catVO);
		
		return "joinOk";
	}
	
	// 로그인 입력하는 페이지만 리턴
	@RequestMapping("login")
	public String login() throws Exception {
		
		return "login";
	}

	  // 실제 로그인한 정보가 존재하는지 디비에서 select하고 그 로그인한 회원의 세션을 부여하는 곳
	  
		@RequestMapping("loginProc")
		public String loginProc(CatVO catVO, HttpSession session, Model model) throws Exception {

			// 아이디랑 비번 검색해서 가져온거 member에 담기 
			CatVO member = CatWorldService.loginProc(catVO);

			// login에서 입력한애들이 DB에 실제로 있는애들인지 
			String returnUrl = "";

			if (member == null) {
				logger.info("존재하지 않는 회원입니다.");
				returnUrl = "loginError";
			} else { // 성공적으로 로그인이 될때 session을 부여 
				session.setAttribute("id", member);

				// Model에 담아서 반환 
				model.addAttribute("id", member);

				returnUrl = "loginOk";
			}

			return returnUrl;
		}
	
	/*	
		login Map으로
	 * @PostMapping("loginProc") public String loginProc(CatVO catVO,
	 * HttpServletRequest request)throws Exception {
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * Map<String,String> catInform = CatWorldService.loginProc(catVO);
	 * 
	 * if(catInform.get("id").equals(catVO.getId()) &&
	 * catInform.get("password").equals(catVO.getPassword())){
	 * session.setAttribute("id", catInform.get("id"));
	 * 
	 * return "loginOk"; }else{ return "loginError"; } }
	 */
	
	
	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session)  {
		
		session.invalidate();
		logger.info("로그아웃 되었습니다.");
		
		return "redirect:/";
	}
	
	// 게시판화면 게시글을 작성할때 쭉 나열 할 공간. 
	// 작성된글을 model에 담고 배열 Arr 로 담아서 보여줄 필요가 있음
	// List<> 트랜젝션 사용
	@RequestMapping("catListPage")
	public String Catlist(CatVO catVO) throws Exception {
	
		
		return "catListPage";
	}
	
	// 고양이 분양글을 실제로 올리는 페이지만 리턴하는 곳!
	@RequestMapping("catRegistPage")
	public String catRegistPage(HttpServletResponse response, CatVO catVO, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		
		HttpSession session = request.getSession();
		
		Object member = session.getAttribute("id");
		
		if(member == null) {
			return "redirect:/cat/login";
		} else {
			return "catRegistPage";
			
		}
		
	}
	
	// 실제로 고양이 분양글을 저장하는 곳
	@RequestMapping("catSave")
	public CatVO catSave(CatVO catVO) throws Exception {
		
		return CatWorldService.catSave(catVO);
	}
	
	@RequestMapping("catDetail")
	public String catDetail(CatVO catVO) throws Exception {
		
		
		return "catDetail";
	}
}
