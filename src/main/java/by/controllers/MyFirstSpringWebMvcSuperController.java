package by.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyFirstSpringWebMvcSuperController {
    @RequestMapping(value = "/")
    public String viewIndex() {
        return "index";
    }

    @GetMapping(value = "/oldApproach")
    public String passParamOldApproach(HttpServletRequest req) {
        var stringParam = req.getParameter("par1");
        var intParam = Integer.parseInt(req.getParameter("par2"));
        req.setAttribute("strPar", stringParam);
        req.setAttribute("intPar", intParam);
        return "main";

    }

    ////вторая полавина занятие
    @GetMapping(value = "/springApproach")
    public String passParamSpringApproach(
            @RequestParam(name = "par1") String name,
            @RequestParam(name = "par2", required = false) Integer age,
            HttpServletRequest req) {
        req.setAttribute("strPar", name);
        req.setAttribute("intPar", age);
        return "main";
    }

    @GetMapping(value = "/storeInSession")
    public String passParamSpringApproach(
            @RequestParam(name = "par1") String name,
            @RequestParam(name = "par2") int age,
            HttpSession session) {
        session.setAttribute("strPar", name);
        session.setAttribute("intPar", age);
        return "main";
    }

    @GetMapping(value = "/urlPart/{par1}{par2}")
    public String passParamAsUrlPart(
            @PathVariable(name = "par1") String name,
            @PathVariable(name = "par2") int age,
            HttpServletRequest req) {
        req.setAttribute("strPar", name);
        req.setAttribute("intPar", age);
        return "main";

    }

    @GetMapping(value = "/useModel")
    public String passParamSprintApproachStoreInModel(
            @RequestParam(name = "par1") String name,
            @RequestParam(name = "par2") int age,
            Model model) {
        model.addAttribute("strPar", name);
        model.addAttribute("intPar", age);
        return "main";
    }

    @GetMapping(value = "/useModelAndView")
    public ModelAndView passParamSprintApproachStoreInModelAndView(
            @RequestParam(name = "par1") String name,
            @RequestParam(name = "par2") int age) {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("strPar", name);
        modelAndView.addObject("intPar", age);
        return modelAndView;
    }
}

