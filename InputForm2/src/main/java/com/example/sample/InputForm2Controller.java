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

	List<Food> foodList = new ArrayList<>();

	@RequestMapping(value="/index")
	public String index(Model model) {

		foodList = new ArrayList<>();
		List<FoodClassification> foodClassificationList = new ArrayList<>();

		FoodClassification vegetable = new FoodClassification();
		FoodClassification fruit = new FoodClassification();
		vegetable.setClassificationId(1);
		vegetable.setClassificationName("野菜");
		fruit.setClassificationId(2);
		fruit.setClassificationName("果物");
		foodClassificationList.add(vegetable);
		foodClassificationList.add(fruit);

		Food tomato = new Food();
		Food lettuce = new Food();
		Food strawberry = new Food();
		Food peach = new Food();
		tomato.setFoodId(1);
		tomato.setFoodName("トマト");
		tomato.setClassificationId(1);
		lettuce.setFoodId(2);
		lettuce.setFoodName("レタス");
		lettuce.setClassificationId(1);
		strawberry.setFoodId(3);
		strawberry.setFoodName("苺");
		strawberry.setClassificationId(2);
		peach.setFoodId(4);
		peach.setFoodName("桃");
		peach.setClassificationId(2);
		foodList.add(tomato);
		foodList.add(lettuce);
		foodList.add(strawberry);
		foodList.add(peach);

		List<Food> foodListLinkToClassification = getFoodListLinkToClassification(1);

		model.addAttribute("classificationList", foodClassificationList);
		model.addAttribute("foodListLinkToClassification", foodListLinkToClassification);

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

	@RequestMapping(value="/getFoodListLinkToClassification", method=RequestMethod.GET)
	@ResponseBody
	public List<Food> getFoodListLinkToClassification(@RequestParam("classificationId") int classificationId) {

		List<Food> foodListLinkToClassification = new ArrayList<>();

		for (Food food : foodList) {
			if (food.getClassificationId() == classificationId) {
				foodListLinkToClassification.add(food);
			}
		}

		return foodListLinkToClassification;
	}
}
