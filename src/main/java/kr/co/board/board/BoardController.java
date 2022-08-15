package kr.co.board.board;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "start", required = false, defaultValue = "0") int start, 
			@CookieValue(value = "visited", required = false, defaultValue = "0") String visited,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDao boardDao = new BoardDao();
		
		int visitCount = Integer.parseInt(visited);
		visited = String.valueOf(visitCount + 1);
		
		Cookie cookie = new Cookie("visited", visited);
		cookie.setPath("/board/");
		cookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(cookie);
		mv.addObject("visitedCookie", visited);
		
		ArrayList<BoardDto> ar = boardDao.getList(start);
		int boardCount = boardDao.getLength();
		int pageCount = boardCount / BoardInterface.PAGELIMIT;
		
		if(boardCount % BoardInterface.PAGELIMIT > 0) {
			pageCount++;
		}
		
		mv.addObject("boardCount", boardCount);
		mv.addObject("pageCount", pageCount);
		mv.addObject("list", ar);
		
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(Integer boardNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.getDetail(boardNum);
		
		mv.addObject("detail", boardDto);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "board/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(BoardDto boardDto) throws Exception {
		BoardDao boardDao = new BoardDao();
		int result = boardDao.addBoard(boardDto);
		
		if(result == 1) {
			System.out.println("게시글 작성 성공");
		} else {
			System.out.println("게시글 작성 실패");
		}
		
		return "redirect:/list";
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(Integer boardNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDao boardDao = new BoardDao();
		
		mv.addObject("boardDto", boardDao.getDetail(boardNum));
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardDto boardDto) throws Exception {
		BoardDao boardDao = new BoardDao();
		int result = boardDao.updateBoard(boardDto);
		
		if(result == 1) {
			System.out.println("게시글 수정 성공");
		} else {
			System.out.println("게시글 수정 실패");
		}
		
		return "redirect:/list";
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Integer boardNum) throws Exception {
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(boardNum);
		
		if(result == 1) {
			System.out.println("게시글 삭제 성공");
		} else {
			System.out.println("게시글 삭제 실패");
		}
		
		return "redirect:/list";
	}
	
}
