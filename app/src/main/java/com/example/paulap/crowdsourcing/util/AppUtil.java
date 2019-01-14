package com.example.paulap.crowdsourcing.util;

import com.example.paulap.crowdsourcing.Models.Event;
import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppUtil {

    public static List<Event> eventList = new ArrayList<Event>(){
        {
            add(new Event("Strangere fonduri", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Se vor colecta fundri ptr copii nevoiasi", "Fonduri"));
            add(new Event("Donatii oamenii strazi", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Scopul este de a ajuta oamenii strazii cum puteti. Cu haine, mancare, adapost etc. Orice este binevenit ", "Donati"));
            add(new Event("Ajutor oameni cu dizabilitati", new Date().toString(), "Cluj-Napoca Daicoviciu 34", "Vrem sa ajutam oamenii cu dizabilitati de toate felurile. Acest voluntariat se intampla in fiecare zi, puteti participa venind la adresa mentionatat si vom discuta despre cum puteti ajuta si pe cine.", "Voluntariat"));
        }
    };
    public static List<Issue> issueList = new ArrayList<Issue>(){
        {
            add(new Issue("Groapa","Multe gropi pe strazi","Sa se asfalteze","Rutier",0,R.drawable.issue1));
            add(new Issue("Mijloc de transport","Autobuzele intarzie foarte multe","Mai multe autobuze","Transport",0,R.drawable.issue2));
            add(new Issue("Spatii verzi","Prea putine spatii verzi","Sa se faca mai multe parcuri","Agrement",0,R.drawable.mountain));
        }
    };

}
