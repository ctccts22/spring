package ksmart.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 서블릿 파일(KSmartView)

/**
 * @RequestMapping -> 클라이언트 주소 요청시 주소 라우팅
 * @param -> 화면에 전달될 Data 객체
 * @return String -> 동적 view 논리주소 경로
 */
@Controller
public class KSmartController {

    @RequestMapping(value ="/ksmartView", method = RequestMethod.GET)
    public String ksmartView(Model model) {

        model.addAttribute("title", "ksmartView");
        model.addAttribute("content", "한국스마트정보교육원46기");
        return "ksmart/ksmartView";
    }

}
