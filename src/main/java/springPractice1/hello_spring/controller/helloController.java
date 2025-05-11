package springPractice1.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @GetMapping("hello")    //주소와 함수를 맵핑한다.
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //spring이 model(data:hello!!)를 만들고 템플릿 엔진에 전송한다.
        //템플릿 엔진은 이를 활용해서 view를 구성한다.
        return "hello"; //templates 밑에 있는 hello.html을 찾는다.
   }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false)String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-api")
    @ResponseBody   //함수의 리턴값으로 웹의 response body를 구성한다.
    public Hello helloString(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   //json형식의 텍스트가 web화면을 구성한다.
    }
    public class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
