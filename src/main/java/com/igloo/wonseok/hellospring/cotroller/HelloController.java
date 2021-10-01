package com.igloo.wonseok.hellospring.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //url에서 get방식으로 hello라는 키워드 들어오면 함수 실행
    public String hello(Model model) { //모델 생성
        model.addAttribute("data", "hello!!"); //모델에 변수명은 data이고 값은 hello!!인 어트리뷰트(key:value형태) 추가.
        return "hello"; //viewResolver에 의해 resources/templates 폴더에서 hello.html를 찾아서 리턴
        //템플릿 엔진에 의해서 html이 가공된 후 나타남.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { //web에서 파라미터로 받은 값을 String name에 저장, 그것을 다시 model에 저장.
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") //URL에 hello-string이라는 키워드에 반응함
    @ResponseBody //html의 body에 return값을 그대로 넣어주겠다
    public String helloString(@RequestParam("name") String name) { //Get방식으로 name의 값을 받아와서 String name에 저장
        return "hello " + name;
    } //서버 실행해서 localhost:8080/hello-string?name=spring 으로 접속하면
    //hello spring이 출력되는데, 이때 소스 보기를 하면 아무 html코드 없이 그냥 소스에 hello spring이라고 적혀있다.
    //return값만 그대로 html코드로 들어간 것이다.
    //근데 이걸(문자를 리턴) 쓸 일은 거의 없음 ㅋ

    @GetMapping("helloApi")
    @ResponseBody   //httpMessageConverter가 리턴값을 html로 바로 던져줌
    //없으면 원래는 viewResolver가 template을 찾아서 던져줌.
    //객체형이면 default로 JSON방식으로 리턴해줌.
    //ㄴ>(MappingJackson2HttpMessageConverter가 객체를 JSON형으로 바꿔줌)
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 반환. 이걸 API방식이라 흔히 얘기함.
    }//서버 기동 후 위 함수로 접근시, JSON방식으로 객체가 나타남. { "name" : "spring!!!" }

    //////////////////////////////////////////////////////////////////////////////////

    static class Hello {  //Hello함수에서 객체를 리턴하기 위해 Hello클래스를 만들어줌.
        //클래스 안에 static 클래스를 만들 수 있음.
        //필요시 HelloController.Hello 이렇게 사용할 수 있음.
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
