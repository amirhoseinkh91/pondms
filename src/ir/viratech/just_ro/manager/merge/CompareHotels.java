package ir.viratech.just_ro.manager.merge;

import java.util.Comparator;

import ir.viratech.just_ro.model.hotel.Hotel;


public class CompareHotels implements Comparator<Hotel>{

	@Override
	public int compare(Hotel hotel1, Hotel hotel2) {

		int price1 = Integer.parseInt(hotel1.getLowestPrice());
		int price2 = Integer.parseInt(hotel2.getLowestPrice());
		return hotel1.compareTo(hotel2);
	}
	
}
