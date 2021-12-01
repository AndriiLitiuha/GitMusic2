package com.example.music2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    Spinner spinner;

    ArrayList <String> spinnerAL = new ArrayList();

    ArrayAdapter spinnerAdapter;
    HashMap  spinnerNamePrice;
    String  selectedSpinner;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();
        createMap();

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerAL );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createList(){
        spinnerAL.add("guitar");
        spinnerAL.add("drums");
        spinnerAL.add("piano");
    }

    void createMap(){
        spinnerNamePrice = new HashMap();
        spinnerNamePrice.put("guitar", 1200.0);
        spinnerNamePrice.put("drums", 1400.0);
        spinnerNamePrice.put("piano", 1700.0);
    }

    public void IncreaseQuantity(View view) {
        TextView quantityCurrent = findViewById(R.id.QuantityCurrent);
        quantityCurrent.setText("" + ++quantity);
        TextView PriceCurrent = findViewById(R.id.PriceCurrent);
        PriceCurrent.setText(""+ quantity * price);
    }

    public void decreaseQuamtity(View view) {
        if (quantity>0){
            TextView quantityCurrent = findViewById(R.id.QuantityCurrent);
            quantityCurrent.setText("" + --quantity);
            TextView PriceCurrent = findViewById(R.id.PriceCurrent);
            PriceCurrent.setText(""+ quantity * price);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedSpinner = spinner.getSelectedItem().toString();
        //try {
            price = (double) spinnerNamePrice.get(selectedSpinner);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        TextView PriceCurrent = findViewById(R.id.PriceCurrent);
        PriceCurrent.setText(""+ quantity * price);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}