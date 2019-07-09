package com.inputform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputFormController {

	// 一覧画面
	@RequestMapping(value="/index")
	public String index(Model model) {
		User newUser = new User();

		Map<String, String> yearList = new HashMap<>();
		yearList.put("一年生", "一年生");
		yearList.put("二年生", "二年生");
		yearList.put("三年生", "三年生");

		ArrayList<User> userList = new ArrayList<>();
		User user1 = new User();
		User user2 = new User();
		user1.setYear("一年生");
		user1.setGroup("一組");
		user1.setName("山田");
		user2.setYear("二年生");
		user2.setGroup("二組");
		user2.setName("田中");
		userList.add(user1);
		userList.add(user2);

		model.addAttribute("newUser", newUser);
		model.addAttribute("yearList", yearList);
		model.addAttribute("userList", userList);

		return "index";
	}

	// 登録画面、変更画面
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String input(@RequestParam ("detail") String detail, @ModelAttribute User user, Model model) {
		if (user.getYear() == null || user.getYear() == "") {
			model.addAttribute("errorMessage", "選択してください");
			return index(model);
		}

		Map<String, String> groupList = new HashMap<>();
		groupList.put("一組", "一組");
		groupList.put("二組", "二組");
		groupList.put("三組", "三組");

		model.addAttribute("detail", detail);
		model.addAttribute("groupList", groupList);
		model.addAttribute("user", user);

		return "form";
	}

	// 確認画面
	@RequestMapping(value="/detail",method=RequestMethod.POST)
	public String confirm(@RequestParam ("detail") String detail, @Validated @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			if (detail.equals("confirm_registration")) {
				return input("registration", user, model);
			}
			if (detail.equals("confirm_change")) {
				return input("change", user, model);
			}
		}

		Map<String, String> groupList = new HashMap<>();
		groupList.put("一組", "一組");
		groupList.put("二組", "二組");
		groupList.put("三組", "三組");

		model.addAttribute("detail", detail);
		model.addAttribute("groupList", groupList);
		model.addAttribute("user", user);

		return "form";
	}
}
