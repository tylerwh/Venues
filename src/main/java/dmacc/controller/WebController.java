package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Venue;
import dmacc.repository.VenueRepository;

@Controller
public class WebController {
	
	@Autowired
	VenueRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllVenues(Model model) {
		model.addAttribute("venues", repo.findAll());
		return "results";
	}
	
	@GetMapping("/addVenue")
	public String addNewVenue(Model model) {
		Venue v = new Venue();
		model.addAttribute("newVenue", v);
		return "inputVenue";
	}
	
	@PostMapping("/addVenue")
	public String addNewContact(@ModelAttribute Venue v, Model model) {
		repo.save(v);
		model.addAttribute("venues", repo.findAll());
		return "results";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Venue v = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		model.addAttribute("venue", v);
		return "updateVenue";
	}
	
	@PostMapping("/updateVenue/{id}")
	public String updateVenue(@PathVariable("id") long id, @Valid Venue v, BindingResult result, Model model) {
		if (result.hasErrors()) {
			v.setId(id);
			return "updateVenue";
		}
		
		repo.save(v);
		model.addAttribute("venues", repo.findAll());
		return "results";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteVenue(@PathVariable("id") long id, Model model) {
		Venue v = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid venue Id: " + id));
		repo.delete(v);
		model.addAttribute("venues", repo.findAll());
		return "results";
		
	}

}
