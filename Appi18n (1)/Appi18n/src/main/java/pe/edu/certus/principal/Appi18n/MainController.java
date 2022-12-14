package pe.edu.certus.principal.Appi18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	private MessageSource mensajes;

	@GetMapping("/")
	public String welcome(Model model, HttpServletRequest request) {
		Locale currentLocale = request.getLocale();
		String countryCode = currentLocale.getCountry();
		String countryName = currentLocale.getDisplayCountry();
		
		String langCode = currentLocale.getLanguage();
		String langName = currentLocale.getDisplayLanguage();
		
		System.out.println(countryCode + ": " + countryName);
		System.out.println(langCode + ": " + langName);
		
	//model.addAttribute("nombre",mensajes.getMessage("saludo.pais",null, LocaleContextHolder.getLocale()));
		model.addAttribute("nombre",mensajes.getMessage("saludo.pais",null, currentLocale));
		return "index";
	}
	
}

