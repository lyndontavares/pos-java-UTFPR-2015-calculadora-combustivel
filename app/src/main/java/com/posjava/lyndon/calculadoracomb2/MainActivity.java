package com.posjava.lyndon.calculadoracomb2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listAlcoolReal;
    private ListView listAlcoolCentavo;
    private ListView listGasolinaReal;
    private ListView listGasolinaCentavo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAlcoolReal = (ListView) findViewById(R.id.viewAlcoolReal);
        listAlcoolCentavo = (ListView) findViewById(R.id.viewAlcoolCentavo);
        listGasolinaReal = (ListView) findViewById(R.id.viewGasolinaReal);
        listGasolinaCentavo = (ListView) findViewById(R.id.viewGasolinaCentavo);

        popularLista();


    }

    public void popularLista() {

        ArrayList<String> listaAlcoolReal = new ArrayList<String>();

        ArrayList<String> listaGasolinaReal = new ArrayList<String>();
        for (int i=1;i<4;i++){
            listaAlcoolReal.add( String.valueOf(i));
            listaGasolinaReal.add( String.valueOf(i));
        }

        ArrayList<String> listaAlcoolCentavo = new ArrayList<String>();
        ArrayList<String> listaGasolinaCentavo = new ArrayList<String>();
        for (int j=0;j<100;j++){
            listaAlcoolCentavo.add( String.valueOf(j));
            listaGasolinaCentavo.add( String.valueOf(j));
        }

        ArrayAdapter<String> adptAlcoolReal =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaAlcoolReal);
        listAlcoolReal.setAdapter(adptAlcoolReal);

        listAlcoolReal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String op =  ((TextView) view).getText().toString();
                Toast.makeText(MainActivity.this, "Selecionado "+op, Toast.LENGTH_LONG).show();
            }
        });



        ArrayAdapter<String> adptAlcoolCentavo =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaAlcoolCentavo);

        listAlcoolCentavo.setAdapter(adptAlcoolCentavo);

        ArrayAdapter<String> adptGasolinaReal =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaGasolinaReal);
        listGasolinaReal.setAdapter(adptGasolinaReal);

        ArrayAdapter<String> adptGasolinaCentavo =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaGasolinaCentavo);
        listGasolinaCentavo.setAdapter(adptGasolinaCentavo);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }




    public void mostrarItemSelecionado(View v) {

        double alcoolreal =  Double.valueOf(listAlcoolReal.getSelectedItem().toString());
        double alcoolcent = Double.valueOf(listAlcoolCentavo.getSelectedItem().toString());

        double gasolinareal = Double.valueOf(listGasolinaReal.getSelectedItem().toString());
        double gasolinacent = Double.valueOf(listGasolinaCentavo.getSelectedItem().toString());

        double coeficiente = 0.7;
        double alcool = alcoolreal + (alcoolcent/100);
        double gasolina = gasolinareal + (gasolinacent/100);

        if ( (alcool/gasolina) < coeficiente ){

            Toast.makeText(this, "Melhor abastecer com Álcool", Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(this, "Melhor abastecer com Gasolina", Toast.LENGTH_LONG ).show();

        }

    }


}
