package lesson_06.code.springBootApp.firstSpringBootApp.src.main.java.group40.firstspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping(value = "/greeting")
    public String helloWorld(@RequestParam(name = "name",
            required = false,
            defaultValue = "World") String name, Model model){
        model.addAttribute("username", name);
        return "greeting";
    }


}
