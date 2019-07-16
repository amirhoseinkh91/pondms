package ir.viratech.just_ro.manager.website.hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ir.viratech.just_ro.model.Website;
import ir.viratech.just_ro.model.information.Information;


public class HotelsWebsites extends Website {

	protected List<String> hotelsCityNames = new ArrayList<>();
	public HotelsWebsites() {
		
	}
	
	public HotelsWebsites(Information information) {
		super(information);
	}
	
	
	public final List<String> getHotelFeaturesScrapper(String link, String host) throws IOException {
		Document document = super.getConnectedDocument(link, Method.GET);
		return findFeatures(document, host);
	}
	
	private List<String> findFeatures(Document document , String host) {
		if (host.contains("hotelyar"))
			return findHotelFeaturesFromHotelYar(document);
		if (host.contains("pintapin"))
			return findHotelFeaturesFromPintapin(document);
		if (host.contains("ariabooking"))
			return findHotelFeaturesFromAriabooking(document);
		return null;
	}
	
	private List<String> findHotelFeaturesFromHotelYar(Document document) {
		List<String> features = new ArrayList<>();
		String featuresElement = document.select(".dl-horizontal > dd:nth-child(6)").get(0).text();
		String[] parts = featuresElement.split(" ");
		for (String feature : parts) {
			features.add(feature.replaceAll(",", "").trim());
		}
		return features;
	}
	
	private List<String> findHotelFeaturesFromPintapin(Document document) {
		List<String> features = new ArrayList<>();
		Elements featuresElement = document.select("ul.row").get(0).children();
		
		for (Element featureElement : featuresElement) {
			if (featureElement.hasClass("col-md-4 col-sm-4 col-xs-12")) {
				String f = featureElement.select("h4").get(0).text().trim();
				features.add(f);
			}
		}
		return features;
	}
	
	protected final String calculateFinalPrice(double lowestPrice) {
		double finalPrice = lowestPrice * information.getNights();
		int ourRooms;
		if (information.getAdults() % 2 ==0)
			ourRooms = information.getAdults()/2;
		else
			ourRooms = (int) Math.floor(information.getAdults() / 2) + 1;
		if (ourRooms <= information.getRooms())
			finalPrice *= information.getRooms();
		else
			finalPrice *= ourRooms;
		
		return String.valueOf(finalPrice);
	}
	
	private List<String> findHotelFeaturesFromAriabooking(Document document) {
		List<String> features = new ArrayList<>();
		String featuresElement = document.select("div.info-hotel:nth-child(12) > div:nth-child(2)").get(0).text();
		String[] parts = featuresElement.split("،");
		for (String feature : parts) {
			features.add(feature.trim());
		}
		return features;
	}
	protected void fillHotelsCityNames() {
		this.hotelsCityNames.add("مهاباد");
		this.hotelsCityNames.add("رودسر");
		this.hotelsCityNames.add("محمودآباد");
		this.hotelsCityNames.add("علی آبادکتول");
		this.hotelsCityNames.add("ملایر");
		this.hotelsCityNames.add("آباده");
		this.hotelsCityNames.add("قزوین");
		this.hotelsCityNames.add("اردکان");
		this.hotelsCityNames.add("بروجرد");
		this.hotelsCityNames.add("رضوانشهر");
		this.hotelsCityNames.add("شیروان");
		this.hotelsCityNames.add("یزد");
		this.hotelsCityNames.add("خلخال");
		this.hotelsCityNames.add("نایین");
		this.hotelsCityNames.add("بالی");
		this.hotelsCityNames.add("بیابانک");
		this.hotelsCityNames.add("بابلسر");
		this.hotelsCityNames.add("سیرجان");
		this.hotelsCityNames.add("تبریز");
		this.hotelsCityNames.add("بم");
		this.hotelsCityNames.add("سنندج");
		this.hotelsCityNames.add("خوی");
		this.hotelsCityNames.add("بجنورد");
		this.hotelsCityNames.add("بندر عباس");
		this.hotelsCityNames.add("مرودشت");
		this.hotelsCityNames.add("تاکستان");
		this.hotelsCityNames.add("اراک");
		this.hotelsCityNames.add("ماکو");
		this.hotelsCityNames.add("آزادشهر");
		this.hotelsCityNames.add("بندر انزلی");
		this.hotelsCityNames.add("خوانسار");
		this.hotelsCityNames.add("لار");
		this.hotelsCityNames.add("یاسوج");
		this.hotelsCityNames.add("عباس آباد");
		this.hotelsCityNames.add("شوشتر");
		this.hotelsCityNames.add("عسلویه");
		this.hotelsCityNames.add("گلپایگان");
		this.hotelsCityNames.add("خرم آباد");
		this.hotelsCityNames.add("فردوس");
		this.hotelsCityNames.add("قم");
		this.hotelsCityNames.add("کیش");
		this.hotelsCityNames.add("سرخس");
		this.hotelsCityNames.add("فسا");
		this.hotelsCityNames.add("اسکو");
		this.hotelsCityNames.add("قائمشهر");
		this.hotelsCityNames.add("شاهرود");
		this.hotelsCityNames.add("الیگودرز");
		this.hotelsCityNames.add("سبزوار");
		this.hotelsCityNames.add("ماسوله");
		this.hotelsCityNames.add("گرگان");
		this.hotelsCityNames.add("آمل");
		this.hotelsCityNames.add("سراب");
		this.hotelsCityNames.add("شیراز");
		this.hotelsCityNames.add("مبارکه");
		this.hotelsCityNames.add("کوهرنگ");
		this.hotelsCityNames.add("سمنان");
		this.hotelsCityNames.add("استهبان");
		this.hotelsCityNames.add("مشهد");
		this.hotelsCityNames.add("زنجان");
		this.hotelsCityNames.add("رفسنجان");
		this.hotelsCityNames.add("کاشان");
		this.hotelsCityNames.add("گچساران");
		this.hotelsCityNames.add("بوشهر");
		this.hotelsCityNames.add("ارومیه");
		this.hotelsCityNames.add("زاهدان");
		this.hotelsCityNames.add("جلفا");
		this.hotelsCityNames.add("نکا");
		this.hotelsCityNames.add("ایلام");
		this.hotelsCityNames.add("چابهار");
		this.hotelsCityNames.add("رشت");
		this.hotelsCityNames.add("بافق");
		this.hotelsCityNames.add("تالش");
		this.hotelsCityNames.add("آبادان");
		this.hotelsCityNames.add("سرعین");
		this.hotelsCityNames.add("ماسال");
		this.hotelsCityNames.add("دلیجان");
		this.hotelsCityNames.add("اهواز");
		this.hotelsCityNames.add("کردکوی");
		this.hotelsCityNames.add("طبس");
		this.hotelsCityNames.add("بناب");
		this.hotelsCityNames.add("اصفهان");
		this.hotelsCityNames.add("کرج");
		this.hotelsCityNames.add("میبد");
		this.hotelsCityNames.add("کرمان");
		this.hotelsCityNames.add("تفت");
		this.hotelsCityNames.add("نوشهر");
		this.hotelsCityNames.add("میناب");
		this.hotelsCityNames.add("بیرجند");
		this.hotelsCityNames.add("درود");
		this.hotelsCityNames.add("رامسر");
		this.hotelsCityNames.add("گنبدکاووس");
		this.hotelsCityNames.add("نور");
		this.hotelsCityNames.add("همدان");
		this.hotelsCityNames.add("ساوه");
		this.hotelsCityNames.add("سقز");
		this.hotelsCityNames.add("اردبیل");
		this.hotelsCityNames.add("تهران");
		this.hotelsCityNames.add("آستارا");
		this.hotelsCityNames.add("مهریز");
		this.hotelsCityNames.add("مریوان");
		this.hotelsCityNames.add("کرمانشاه");
		this.hotelsCityNames.add("دامغان");
		this.hotelsCityNames.add("بهشهر");
		this.hotelsCityNames.add("تنکابن");
		this.hotelsCityNames.add("محلات");
		this.hotelsCityNames.add("مینودشت");
		this.hotelsCityNames.add("بانه");
		this.hotelsCityNames.add("دماوند");
		this.hotelsCityNames.add("ساری");
		this.hotelsCityNames.add("شهرکرد");
		this.hotelsCityNames.add("مراغه");
		this.hotelsCityNames.add("لنگرود");
		this.hotelsCityNames.add("نیشابور");
		this.hotelsCityNames.add("اندیمشک");
		this.hotelsCityNames.add("قمصر");
		this.hotelsCityNames.add("لاهیجان");
		this.hotelsCityNames.add("فیروزآباد");
		this.hotelsCityNames.add("خمین");
		this.hotelsCityNames.add("کلیبر");
		this.hotelsCityNames.add("فومن");
		this.hotelsCityNames.add("کلاردشت");
		this.hotelsCityNames.add("ماهان");
		this.hotelsCityNames.add("داراب");
		this.hotelsCityNames.add("قلعه گنج");
		this.hotelsCityNames.add("چالوس");
		this.hotelsCityNames.add("کرمان");
		this.hotelsCityNames.add("خمین");

	}
}
