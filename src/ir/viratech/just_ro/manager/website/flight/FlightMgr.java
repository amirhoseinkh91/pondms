package ir.viratech.just_ro.manager.website.flight;

import ir.viratech.base.SuppressWarningsOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class FlightMgr {


    public List<String> getAvailableWebsites() {
        List<String> list = new ArrayList<>();
        list.add("Sepehr360");
        list.add("Alibaba");
        list.add("Mrbilit");
        list.add("Ghasedak24");
        list.add("AirplaneTicket");
        return list;
    }

}
