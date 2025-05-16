package springPractice1.hello_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springPractice1.hello_spring.domain.Member;
import springPractice1.hello_spring.service.MemberService;

import java.util.List;

@Controller //스프링 빈으로 자동포함해주는 @Component를 갖고있다. => 컴포넌트 스캔
public class memberController {
    private final MemberService memberService;

    @Autowired  //스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
    //컨테이너에 포함되기 위해선 스프링 빈으로 등록되어야한다.
    public memberController(MemberService memberService){
        this.memberService = memberService; //하나의 객체(memberservice)를 여러 곳에서 사용할 수 있다.
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(memberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
        //viewresolver를 통해 html에 연결되고 html내부에서는
        //타임리프 템플릿 엔진에서 전달받은 model안의 데이터를 사용해 화면을 재구성하고 이를 웹에 반환한다.

    }
}
