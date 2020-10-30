package webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerIndex 
{
	//gestisce la chiamata a index
	@RequestMapping(value="index")		//mappa la chiamata gestita dal controller
	public String getWelcome(Model m)
	{
		m.addAttribute("head","Welcome");
		m.addAttribute("select","Select the products you want to buy");
		//nome della pagina che deve tornare
		return "index";
	}
	
	@RequestMapping		//mappa la chiamata gestita dal controller
	public String getWelcome2(Model m)
	{
		m.addAttribute("head","Welcome");
		m.addAttribute("select","Select the products you want to buy");
		//nome della pagina che deve tornare
		return "index";
	}
}
