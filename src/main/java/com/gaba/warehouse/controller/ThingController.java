package com.gaba.warehouse.controller;

import com.gaba.warehouse.model.Thing;
import com.gaba.warehouse.repository.ThingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/thing")
public class ThingController {
    
    @Autowired 
    private final ThingRepository thingRepository;
    
    public ThingController(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Thing> things = thingRepository.findAll();
        model.addAttribute("things", things);
        return "list";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        return "create"; 
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("thing") Thing thing) {
        thingRepository.save(thing);
        return "redirect:/thing/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Thing thing = thingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid thing ID"));
        model.addAttribute("thing", thing);
        return "edit"; 
    }

    
    @PostMapping("/update")
    public String update(@ModelAttribute("thing") Thing updatedThing) {
        Thing thing = thingRepository.findById(updatedThing.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid thing ID"));
        
        thing.setName(updatedThing.getName());
        thing.setAmount(updatedThing.getAmount());

        thingRepository.save(thing);
        return "redirect:/thing/list"; 
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        thingRepository.deleteById(id);
        return "redirect:/thing/list";
    }

}
