package com.fadsan.controller.admin.settings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fadsan.model.LibraraySettings;
import com.fadsan.model.Session;
import com.fadsan.models.dto.LibraraySettingsDTO;
import com.fadsan.service.LibraraySettingsService;
import com.fadsan.service.SessionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin/**")
public class ManageLibrarySettingController {
	@Autowired
	SessionService sessionService;
	@Autowired
	LibraraySettingsService service;

	@RequestMapping(value = "library.html", method = RequestMethod.GET)
	public String librarayHome(Model model) {
		List<Session> sessionList = sessionService
				.findAllByIsDeletedTrue(Session.class);
		model.addAttribute("sesionList", sessionList);
		model.addAttribute("manageLibrary", new LibraraySettingsDTO());
		return "manage-library";
	}

	@RequestMapping(value = "checkData", method = RequestMethod.POST)
	public @ResponseBody String getData(@RequestParam int sessionId)
			throws JsonProcessingException {
		LibraraySettingsDTO list = service.checkData(sessionId);
		ObjectMapper ob = new ObjectMapper();
		//ob.registerModule(new Hibernate4Module());
		return ob.writeValueAsString(list);
	}

	@RequestMapping(value = "add-library", method = RequestMethod.POST)
	public String saveLibraray(
			@ModelAttribute("manageLibrary") LibraraySettingsDTO libraraySettingDTO,
			RedirectAttributes redirect) {
		String message = service.saveLibraray(libraraySettingDTO);
		redirect.addFlashAttribute("message", message);
		return "redirect:library.html";
	}

}
