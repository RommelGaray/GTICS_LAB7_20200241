package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Technician;
import com.example.lab7gtics.repository.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/tecnicos")
public class TecnicoController {

    final DeviceRepository deviceRepository;

    final SiteRepository siteRepository;

    final LocationRepository locationRepository;

    final TicketRepository ticketRepository;

    final TechnicianRepository technicianRepository;

    public TecnicoController(DeviceRepository deviceRepository, SiteRepository siteRepository, LocationRepository locationRepository, TicketRepository ticketRepository, TechnicianRepository technicianRepository) {
        this.deviceRepository = deviceRepository;
        this.siteRepository = siteRepository;
        this.locationRepository = locationRepository;
        this.ticketRepository = ticketRepository;
        this.technicianRepository = technicianRepository;
    }


    @GetMapping(value = {"/", ""})
    public String listaEquipo(Model model) {
        model.addAttribute("listaTecnicos", technicianRepository.findAll());
        return "Tecnico/listaTecnico";
    }

    @GetMapping("/newForm")
    public String nuevoTecnicoFrm(@ModelAttribute("tecnico") Technician technician) {

        return "Tecnico/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("technician") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal

            if (technician.getId() == 0) {
                attr.addFlashAttribute("msg", "Tecnico creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Tecnico actualizado exitosamente");
            }
            technicianRepository.save(technician);
            return "redirect:/tecnicos";

        } else { //hay al menos 1 error
            return "Tecnico/editFrm";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("technician") Technician technician,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            technician = optionalTechnician.get();
            model.addAttribute("product", technician);
            return "Tecnico/editFrm";
        } else {
            return "redirect:/tecnicos";
        }
    }


}
