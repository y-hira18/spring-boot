package com.example.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InputForm2Controller {

	@RequestMapping(value="/index")
	public String index(Model model) {

		JsonObject jsonObject = new JsonObject();

		model.addAttribute("jsonObject", jsonObject);

		return "index";
	}

	@RequestMapping(value="/getInputMessage", method=RequestMethod.GET)
	@ResponseBody
	public JsonObject getInputMessage(@RequestParam("inputMessage") String inputMessage, Model model) {
		JsonObject object = new JsonObject();
		object.setInputMessage(inputMessage);
		return object;
	}

	@RequestMapping(value="/getSelectItem", method=RequestMethod.GET)
	@ResponseBody
	public JsonObject getSelecgItem(@RequestParam("selectItem") int selectItem, Model model) {
		JsonObject object = new JsonObject();
		object.setSelectItem(selectItem);
		return object;
	}

}
