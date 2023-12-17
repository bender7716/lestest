package org.example.controller.mvc;

import lombok.RequiredArgsConstructor;
import org.example.entity.Baguette;
import org.example.entity.Cutter;
import org.example.entity.Order;
import org.example.service.mvc.CrudMvcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderMvcController {

    private final CrudMvcService<Order> orderService;
    private final CrudMvcService<Cutter> cutterService;
    private final CrudMvcService<Baguette> baguetteService;


    @GetMapping()
    public String list(Model model) {
        model.addAttribute("orderList", orderService.list());
        return "order";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("order", orderService.create());
        model.addAttribute("cutterList", cutterService.list());
        model.addAttribute("baguetteList", baguetteService.list());
        return "order_edit";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("order", orderService.getById(id));
        model.addAttribute("cutterList", cutterService.list());
        model.addAttribute("baguetteList", baguetteService.list());
        return "order_edit";
    }

    @PostMapping()
    public String save(@RequestParam(name = "id", required = false) Long id,
                       @ModelAttribute("order") Order item) {
        orderService.save(id, item);
        return "redirect:/order";
    }

    @PostMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        orderService.delete(id);
        return "redirect:/order";
    }

}
