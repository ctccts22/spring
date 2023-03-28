package ksmart.spring.controller;

import jakarta.annotation.PostConstruct;
import ksmart.spring.dto.Member;
import ksmart.spring.service.ExamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class ExamController {

    /**
     * @PostConstruct : 객체가 생성 뒤에 이벤트 처리
     */
    @PostConstruct
    public void examControllerInit() {
        log.info("ExamController 객체(Bean) 생성");
    }
    /**
     * DI(Dependency Injection) : 의존성 주입 3가지 방법
     * @Autowired 의존성 주입시키는 어노테이션
     * Field injection is not recommended
     * 1. 필드주입 방식
     *     @Autowired
     *     private ExamService examService;
     * 2. 수정자 메소드 주입방식
     *     private ExamService examService;
     *     @Autowired
     *     public void setExamService(ExamService examService) {
     *         this.examService = examService;
     *     }
     * 3. 생성자 주입 방식 @AllArgsConstructor 로 더 간단하게 가능
     *     private final ExamService examService;
     *     @Autowired -> 4버전에는 붙어야 했어지만 5버전부터는 생략이 가능하다
     *     public ExamController(ExamService examService) {
     *         this.examService = examService;
     *     }
     *
     */
    private final ExamService examService;

    @GetMapping("/exam2")
    public String exam2(Model model) {
        List<Member> memberList = examService.getMemberList();

        model.addAttribute("title", "exam2");
        model.addAttribute("memberList", memberList);
        return "exam/exam2";
    }

    /**
     * @GetMapping("/exam1") -> 클라이언트가 서버 get방식 요청시 주소 매핑해주는 어노테이션
     * @param model -> 화면에전달되는 data 객체
     * @return type : String -> 논리적인 경로(동적 view html)
     */
//    @GetMapping("/exam1")
//    public ModelAndView exam1() {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("title", "exam1");
//        mav.setViewName("exam/exam1");
//        return mav;

    @GetMapping("/exam1")
    public String exam1(Model model) {

        Member memberInfo = examService.getMemberInfo();
        model.addAttribute("memberInfo", memberInfo);
        log.info(String.valueOf(memberInfo));

        return "exam/exam1";
    }
}
