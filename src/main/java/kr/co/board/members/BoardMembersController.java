package kr.co.board.members;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*")
public class BoardMembersController {

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		return "members/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BoardMembersDto boardMembersDto) throws Exception {
		BoardMembersDao boardMembersDao = new BoardMembersDao();
		
		int result = boardMembersDao.setJoin(boardMembersDto);
		
		if(result == 1) {
			System.out.println("회원가입 완료");
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "members/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String id, String password, HttpSession session) throws Exception {
		BoardMembersDao boardMembersDao = new BoardMembersDao();
		BoardMembersDto boardMembersDto = boardMembersDao.login(id, password);
		
		if(boardMembersDto != null) {
			session.setAttribute("id", boardMembersDto.getId());
			session.setAttribute("name", boardMembersDto.getName());
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("name");
		
		return "redirect:/";
	}
	
}
