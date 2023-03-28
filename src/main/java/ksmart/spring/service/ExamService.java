package ksmart.spring.service;

import jakarta.annotation.PostConstruct;
import ksmart.spring.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ExamService {
    /**
     * @PostConstruct : 객체가 생성 뒤에 이벤트 처리
     */
    @PostConstruct
    public void examServiceInit() {
      log.info("ExamService 객체(Bean) 생성");
    }

    public List<Member> getMemberList() {
        List<Member> memberList = new ArrayList<Member>();
        Member member = null;
        for (int i=1; i<10; i+=1) {
            member = new Member();
            member.setMemberId("id00" + i);
            member.setMemberPw("pw00" + i);
            String memberLevel = "";
            switch (i%3) {
                case 1: {
                    memberLevel = "관리자";
                    break;
                }
                case 2: {
                    memberLevel = "판매자";
                    break;
                }
                default:
                    memberLevel = "구매자";
            }
            member.setMemberLevel(memberLevel);
            member.setMemberName("홍0" + i);
            member.setMemberMobile("010-000"+i+"-000"+i);
            memberList.add(member);
        }
        return memberList;
    }
    public Member getMemberInfo() {
        Member memberInfo = new Member("id001", "pw001", "관리자", "홍00", "010-1111-1111");
//        memberInfo.setMemberId("id001");
//        memberInfo.setMemberPW("pw001");
//        memberInfo.setMemberLevel("관리자");
//        memberInfo.setMemberName("홍길동");
//        memberInfo.setMemberMobile("010-1111-1234");
        return memberInfo;
    }
}
