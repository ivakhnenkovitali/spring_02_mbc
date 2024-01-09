package by.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyFirstSpringWebMvcSuperController {
    @RequestMapping(value = "/")
    public String viewIndex(){
        return "index";
    }
    @GetMapping(value = "/oldApproach")
    public String passParamOldApproach(HttpServletRequest req){
        var stringParam = req.getParameter("par1");
        var intParam = Integer.parseInt(req.getParameter("par2"));
        req.setAttribute("strPar", stringParam);
        req.setAttribute("intPar", intParam);
        return "main";

        }

        ////вторая полавина занятие
    @GetMapping(value = "/springApproach")
        public String passParamSpringApproach(
            @RequestParam(name = "par1")String name,
            @RequestParam(name = "par2", required = false) Integer age,
            HttpServletRequest req)  {
          req.setAttribute("strPar", name);
          req.setAttribute("intPar", age);
          return "main";
        }
    }

