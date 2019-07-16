package ir.viratech.just_ro.manager.merge;

import java.util.Comparator;

import ir.viratech.just_ro.model.lowestprice.LowestPrice;



public class CompareFlights implements Comparator<LowestPrice>{

	@Override
	public int compare(LowestPrice flight1, LowestPrice flight2) {

		int price1 = Integer.parseInt(flight1.getPrice());
		int price2 = Integer.parseInt(flight2.getPrice());
		
		if (price1 < price2){
			
			return price1;
			
		}else {
			
			return price2;
		}
		
	}
}