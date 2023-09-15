package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;
import com.care.root.member.session_name.MemberSessionName;
@Controller
@RequestMapping("member")
public class MemberController {
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@Autowired
	private MemberService ms;
	@PostMapping("user_check")
	public String user_check(@RequestParam String id ,
			@RequestParam String pw,
			RedirectAttributes rs) {
		int result = ms.user_check(id, pw);
		if(result == 0) {
			rs.addAttribute( "id", id );
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	@RequestMapping("successLogin")
	public String successLogin(@RequestParam("id") String id,HttpSession session) {
		session.setAttribute( MemberSessionName.LOGIN, id );
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
		return "redirect:/index";
	}
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		model.addAttribute("memberList" , ms.memberInfo());
		return "member/memberInfo";
	}
	@RequestMapping("/info")
	public String info(Model model, @RequestParam("id") String userId) {
		model.addAttribute("info", ms.info(userId));
		return "member/info";
	}
	@RequestMapping("/register_form")
	public String register_form() {
		return "member/register";
	}
	@RequestMapping("/register")
	public String register(MemberDTO member) {
		int result = ms.register(member);
		if(result == 1)   
			return "redirect:login";   
		return "redirect:register_form";
	}

}
