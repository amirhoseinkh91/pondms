package ir.viratech.just_ro.manager.website.hotel;

import java.net.SocketTimeoutException;

import ir.viratech.just_ro.model.information.Information;


public class EGardesh extends HotelsWebsites {
	public EGardesh() {
	}

	public EGardesh(Information information) {
		super(information);
	}

	@Override
	protected void startScrape() throws SocketTimeoutException {
		super.startScrape();
		
		System.out.println( this.getClass().getSimpleName() + " has been scraped");
	}

}
