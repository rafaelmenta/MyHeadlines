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
			    "00h34 Multimilion�rio procura casal para viajar a Marte em 2018",
			    "21h04 Turista espacial Dennis Tito quer lan�ar miss�o humana a...",
			    "12h22 Falta de gravidade debilita o sistema imunol�gico dos...",
			    "16h46 Cientistas usam v�deos para achar origem do meteorito da...",
			    "11h52 Asteroides s�o cada vez mais amea�adores, alerta...",
			    "10h16 Astronauta captura e divulga no Twitter imagens do espa�o",
			    "14h22 Astronautas interagem ao vivo com internautas em 1� chat...",
			    "10h28 Nasa promove bate-papo com astronautas hoje; saiba como...",
			    "07h24 Astr�nomo: alguns meteoritos s�o imposs�veis de prever",
			    "21h10 Curiosity encontra rocha cinzenta sob superf�cie de Marte"
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
