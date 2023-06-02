package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Obraz> obrazki = new ArrayList<>();
    ArrayList<String> opisy = new ArrayList<>();
    TextView textView;
    ImageView imageView;
Button button1,button2,button,buttonDodaj;
ListView listView;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obrazki.add(new Obraz("plaża",R.drawable.morze));
        obrazki.add(new Obraz("morze",R.drawable.morze2));
        obrazki.add(new Obraz("niebieskie morze",R.drawable.morze3));
        opisy.add("morze");
        opisy.add("góry");
        opisy.add("jezioro");
        opisy.add("miasto");
        opisy.add("wioska");
        opisy.add("rzeka");
        opisy.add("pustynia");
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView2);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button3);
        button = findViewById(R.id.button);
        buttonDodaj =findViewById(R.id.button4);
        listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter =new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                opisy
        );
        listView.setAdapter(adapter);
        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText = findViewById(R.id.editTextTextPersonName);
                        String wartosc = editText.getText().toString();
                        opisy.add(wartosc);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        wyswietlObraz(0);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        obrazki.get(i).polubienia++;
                        textView.setText(obrazki.get(i).opis+
                                " polubiono "+obrazki.get(i).polubienia);
                    }
                }
        );
    button2.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i --;
                    if(i<0){
                        i =0;
                    }
                    wyswietlObraz(i);


            }
            }
    );
    button1.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i ++;
                    if(i==obrazki.size()){
                        i--;
                    }
                    wyswietlObraz(i);

                }
            }
    );
    }


    private void  wyswietlObraz(int i){
        textView.setText(obrazki.get(i).opis);
        imageView.setImageResource(obrazki.get(i).idObrazka);
    }
}