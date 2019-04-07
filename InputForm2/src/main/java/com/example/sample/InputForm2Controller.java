package com.example.sample;

import java.util.ArrayList;
import java.util.List;

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

		Object object = new Object();
		model.addAttribute("object", object);

		return "index";
	}

	@RequestMapping(value="/getInputMessage", method=RequestMethod.GET)
	@ResponseBody
	public Object getInputMessage(@RequestParam("inputMessage") String inputMessage) {
		Object object = new Object();
		object.setInputMessage(inputMessage);
		return object;
	}

	@RequestMapping(value="/getSelectItem", method=RequestMethod.GET)
	@ResponseBody
	public Object getSelecgItem(@RequestParam("selectItem") int selectItem) {
		Object object = new Object();
		object.setSelectItem(selectItem);
		return object;
	}

	@RequestMapping(value="/getInputValue", method=RequestMethod.GET)
	public String getInputValue(@RequestParam("inputMessage") String inputMessage, @RequestParam("selectItem") int selectItem, Model model) {

		List<Object> objectList = new ArrayList<>();
		Object object = new Object();
		object.setInputMessage(inputMessage);
		object.setSelectItem(selectItem);
		objectList.add(object);
		objectList.add(object);

		model.addAttribute("objectList", objectList);

		return "index :: resultTable";
	}
}
