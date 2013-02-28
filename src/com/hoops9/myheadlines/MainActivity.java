package com.hoops9.myheadlines;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] listValues = new String[] {
			    "00h34 Multimilionário procura casal para viajar a Marte em 2018",
			    "21h04 Turista espacial Dennis Tito quer lançar missão humana a...",
			    "12h22 Falta de gravidade debilita o sistema imunológico dos...",
			    "16h46 Cientistas usam vídeos para achar origem do meteorito da...",
			    "11h52 Asteroides são cada vez mais ameaçadores, alerta...",
			    "10h16 Astronauta captura e divulga no Twitter imagens do espaço",
			    "14h22 Astronautas interagem ao vivo com internautas em 1º chat...",
			    "10h28 Nasa promove bate-papo com astronautas hoje; saiba como...",
			    "07h24 Astrônomo: alguns meteoritos são impossíveis de prever",
			    "21h10 Curiosity encontra rocha cinzenta sob superfície de Marte"
		};

		
		ListView headlinesList = (ListView) findViewById(R.id.headlines_list);
		ArrayAdapter<String> resource = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listValues);
		headlinesList.setAdapter(resource);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
