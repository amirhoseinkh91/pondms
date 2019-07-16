package ir.viratech.pond_ms.model.tour_relations.tour;

import java.util.List;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.meal.Meal;
import ir.viratech.pond_ms.model.tour_relations.sight_seeing.SightSeeing;

public class DayTourObject {

	private List<ExtendedPointObject> objects;

	public List<ExtendedPointObject> getObjects() {
		return objects;
	}

	public void setObjects(List<ExtendedPointObject> objects) {
		this.objects = objects;
	}

	public ExtendedPointObject get_nth_Object(int index) {
		return this.objects.get(index);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DayTourObject that = (DayTourObject) o;

		return objects != null ? objects.equals(that.objects) : that.objects == null;
	}

	@Override
	public int hashCode() {
		return objects != null ? objects.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "DayTourObject{" +
				"objects=" + objects +
				'}';
	}
}
