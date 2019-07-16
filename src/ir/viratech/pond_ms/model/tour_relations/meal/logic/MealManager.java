package ir.viratech.pond_ms.model.tour_relations.meal.logic;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.meal.Meal;

public class MealManager extends BaseManager {

	public static Meal getInstance() throws InstantiationException, IllegalAccessException {
		return Meal.class.newInstance();
	}
	
}
