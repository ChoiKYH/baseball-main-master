package com.example.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller

public class baseballController {
    @Autowired
    @Qualifier("baseballServiceImpl")
    private baseballService service;

    public baseballController() {
        this.service = new baseballServiceImpl();
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }
    @RequestMapping("/count")
    @ResponseBody
    public String count(Map<String, String> param, Map<String, Object> model) {
        return  "count=" + service.count();
    }

    @RequestMapping("/read/{idx}/fighting")
    public String fighting(@PathVariable int idx) {
        return "fighting";
    }
    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("base", service.select());
        return "list.html";
    }

    @RequestMapping("/read/{idx}")
    public  String read(@PathVariable int idx, Model model) {
        model.addAttribute("base", service.read(idx));
        return "read.html";
    }

    /*list(Map<String, String> param, Map<String, Object> model) {
        List<baseballDto> db = service.select();
        for(int i = 0; i < db.size(); i++) {
            model.put("idx" + i, db.get(i).getIdx());
            model.put("team" + i, db.get(i).getTeam());
            model.put("image" + i, db.get(i).getImage());
        }
        return  "list";
    }*/

    @RequestMapping("/read")
    public String read(Map<String, String> param, Map<String, Object> model) {
        int idx = Integer.parseInt(param.get("idx"));


        baseballDto base = service.read(idx);

        model.put("idx", base.getIdx());
        model.put("team", base.getTeam());
        model.put("image", base.getImage());
        model.put("slogan", base.getSlogan());
        model.put("member",base.getMember());
        model.put("bottom", base.getBottom());
        return  "read";
    }

    @RequestMapping("/insertForm")
    public  String insertForm() {
        return "insertForm";
    }

    @RequestMapping("/insert")
    public  String insert(baseballDto base) {
        service.insert(base);
        return "redirect:/list";
    }

    @RequestMapping("/updateForm/{idx}")
    public  String updateForm(@PathVariable int idx, Model model) {

        model.addAttribute("base", service.read(idx));
        return "updateForm";
    }

    @RequestMapping("/update")
    public  String update(baseballDto base) {

        service.update(base);
        return "redirect:/list";
    }

    @RequestMapping("/delete/{idx}")
    public  String delete(@PathVariable int idx) {
        service.delete(idx);
        return "redirect:/list";
    }


}
