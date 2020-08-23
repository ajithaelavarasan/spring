package com.mission.ajitha;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AjithaController {


    @RequestMapping(value = "/trial")
    public String test() {
        return "Hai Krishna!!!";
    }

    @RequestMapping(value = "/trial-json")
    public Map testJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "RadhaKrishna");
        map.put("channel", "Vijay");
        map.put("session", "AM");
        map.put("timing", 9);
        map.put("duration_in_min", 30);

        return map;
    }

    @RequestMapping(value = "/shows")
    public Shows getShows() {

        Shows s = new Shows();
        s.setName("RadhaKrishna");
        s.setChannel("Vijay");
        ShowTime st = new ShowTime();
        st.setSession("AM");
        st.setStarttime(9);
        st.setEndtime(10);
        s.setSt(st);
        List<String> bl = new ArrayList<>();
        bl.add("Tamil");
        bl.add("Bengali");
        bl.add("Hindi");
        bl.add("Malayalam");
        s.setBroadcastinglangs(bl);

        return s;

    }


}
