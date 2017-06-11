package restbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String startPage(){

        return "startPage";
    }

    @RequestMapping("/voting")
    public String index(){

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
