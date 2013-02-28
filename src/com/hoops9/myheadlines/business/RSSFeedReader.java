package com.hoops9.myheadlines.business;

import java.util.ArrayList;
import java.util.List;

import com.hoops9.myheadlines.dao.HeadlineItem;

public class RSSFeedReader {
	
	public static List<HeadlineItem> getHeadlines() {
		
		List<HeadlineItem> headlines = new ArrayList<HeadlineItem>();
		HeadlineItem item = new HeadlineItem();
		
		item.setTime("00h34"); item.setHeadline("Multimilionário procura casal para viajar a Marte em 2018");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("21h04"); item.setHeadline("Turista espacial Dennis Tito quer lançar missão humana a...");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("12h22"); item.setHeadline("Falta de gravidade debilita o sistema imunológico dos...");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("16h46"); item.setHeadline("Cientistas usam vídeos para achar origem do meteorito da...");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("11h52"); item.setHeadline("Asteroides são cada vez mais ameaçadores, alerta...");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("10h16"); item.setHeadline("Astronauta captura e divulga no Twitter imagens do espaço");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("14h22"); item.setHeadline("Astronautas interagem ao vivo com internautas em 1º chat...");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("10h28"); item.setHeadline("Nasa promove bate-papo com astronautas hoje; saiba como...");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("07h24"); item.setHeadline("Astrônomo: alguns meteoritos são impossíveis de prever");
		headlines.add(item); item = new HeadlineItem();
		item.setTime("21h10"); item.setHeadline("Curiosity encontra rocha cinzenta sob superfície de Marte");
		headlines.add(item);
		
		return headlines;
	}

}
