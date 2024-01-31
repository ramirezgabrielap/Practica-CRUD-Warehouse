package com.gaba.warehouse.controller;

import com.gaba.warehouse.model.Thing;
import com.gaba.warehouse.repository.ThingRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/thing")
public class ThingController {
    
    @Autowired 
    private final ThingRepository thingRepository;
    
    public ThingController(ThingRepository planetRepository) {
        this.thingRepository = planetRepository;
    }

    @GetMapping("/home")
    public String Home(Model model) {
            model.addAttribute("name", " dd ");
            return "home";
    }
    
    @GetMapping("/list")
    public String listThings(Model model) {
        List<Thing> things = thingRepository.findAll();
        model.addAttribute("things", things);
        return "listThings";
    }
    
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Thing thing = thingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid thing ID"));
        model.addAttribute("record", thing);
        return "edit"; // Asegúrate de tener una vista llamada "edit"
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("record", new Thing());
        return "create"; // Asegúrate de tener una vista llamada "create"
    }

    @PostMapping("/create")
    public String createRecord(@ModelAttribute("record") Thing newThing) {
        thingRepository.save(newThing);
        return "redirect:/thing/list";
    }


    // Método para procesar la actualización del registro
    @PostMapping("/update")
    public String updateRecord(@ModelAttribute("record") Thing updatedThing) {
        Thing thing = thingRepository.findById(updatedThing.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid thing ID"));
        
        // Actualizar solo los campos permitidos (name y amount)
        thing.setName(updatedThing.getName());
        thing.setAmount(updatedThing.getAmount());

        thingRepository.save(thing);
        return "redirect:/thing/list"; // Redirige a la página de listado después de la actualización
    }
    
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        thingRepository.deleteById(id);
        return "redirect:/thing/list";
    }
    
    
    
    /*
    @GetMapping()
    public Iterable<Thing> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return thingRepository.findAll(Sort.by("id").ascending());
    }
    
    @GetMapping("/{id}")
    public Optional<Thing> get(@PathVariable Integer id) {
        return this.thingRepository.findById(id);
    }
    
    @PostMapping()
    public Thing save(@Valid @RequestBody Thing thing){
        return this.thingRepository.save(thing);
    }
    
    @PutMapping("/{id}")
    public Thing edit(@Valid @RequestBody Thing thing, @PathVariable Integer id){
        thing.setId(id);
        return this.thingRepository.save(thing);
    }
    
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.thingRepository.deleteById(id);
    }
    
    @GetMapping("/count")
    public Long countPlanets(){
        return thingRepository.count();
    }
*/
}
