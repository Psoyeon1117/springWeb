package springPractice1.hello_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springPractice1.hello_spring.service.MemberService;

@Controller //스프링 빈으로 자동포함해주는 @Component를 갖고있다. => 컴포넌트 스캔
public class memberController {
    private final MemberService memberService;

    @Autowired  //스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
    //컨테이너에 포함되기 위해선 스프링 빈으로 등록되어야한다.
    public memberController(MemberService memberService){
        this.memberService = memberService; //하나의 객체(memberservice)를 여러 곳에서 사용할 수 있다.
    }

}
