package br.usjt.paises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] continentes = {"Todos","Africa","América","Ásia","Europa","Oceania"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela1);

        // pegando a instancia do spinner e aplicando no OnItemSelectedListener
        Spinner spinner = (Spinner) findViewById(R.id.continentes);
        spinner.setOnItemSelectedListener(this);

        // criando a intancia do ArrayAdapter com a lista de continentes

        ArrayAdapter ct = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(ct);
    }

    // Performando a ação onItemSelected e onNothingSelecte

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), continentes[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
