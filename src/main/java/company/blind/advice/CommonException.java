package company.blind.advice;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.slf4j.internal.LoggerFactory;

// Exception 터지면 여기서 -> 에러 터질 때 소비자들한테 보여주는 페이지 만들기
@ControllerAdvice
public class CommonException {
	/*
	private static final Logger logger = 
			LoggerFactory.getLogger(CommonException.class);	*/
	
	@ExceptionHandler(Exception.class)
	private ModelAndView err(Exception e) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/board/exception");
		mav.addObject("exception", e);
		
		return mav;
	}
	
}
