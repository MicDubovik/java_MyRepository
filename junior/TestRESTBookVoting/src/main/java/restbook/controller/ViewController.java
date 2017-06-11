package restbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {
    private String appMode;

    @Autowired
    public ViewController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String startPage(){

        return "startPage";
    }

    @RequestMapping("/voting")
    public String index(Model model){

        model.addAttribute("mode", appMode);

        return "index1";
    }
    @RequestMapping("/result")
    public String result(){

        return "result";
    }

    @RequestMapping("/view")
    public String view(){

        return "votingResult";
    }
}
