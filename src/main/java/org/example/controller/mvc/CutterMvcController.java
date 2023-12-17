package org.example.controller.mvc;

import lombok.RequiredArgsConstructor;
import org.example.entity.Cutter;
import org.example.service.mvc.CrudMvcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("cutter")
public class CutterMvcController {

    private final CrudMvcService<Cutter> cutterService;


    @GetMapping()
    public String list(Model model) {
        model.addAttribute("cutterList", cutterService.list());
        return "cutter";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("cutter", cutterService.create());
        return "cutter_edit";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cutter", cutterService.getById(id));
        return "cutter_edit";
    }

    @PostMapping()
    public String save(@RequestParam(name = "id", required = false) Long id,
                       @ModelAttribute("cutter") Cutter item) {
        cutterService.save(id, item);
        return "redirect:/cutter";
    }

    @PostMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        cutterService.delete(id);
        return "redirect:/cutter";
    }
}
