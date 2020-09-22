package lt.ivl.webExternalApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {
    @GetMapping(path = "/")
    public String index() {
        return "index";
    }
}
