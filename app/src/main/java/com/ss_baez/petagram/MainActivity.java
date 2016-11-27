package com.ss_baez.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> pets;
    private RecyclerView listaPets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.huellita48);

        listaPets = (RecyclerView) findViewById(R.id.rvPets);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflar los items del menu para ser usados en el actionbar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.showLikes) {

            Intent intent = new Intent(MainActivity.this, LikesMascotas.class);
            startActivity(intent);
            return true;

        }

        if (id == R.id.showInfo){

            Intent intent = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public PetAdaptador objAdaptador;
    public void inicializarAdaptador(){
        objAdaptador = new PetAdaptador(pets, this);
        listaPets.setAdapter(objAdaptador);
    }


    public void inicializarListaPets(){
        pets = new ArrayList<Pet>();

        pets.add(new Pet(R.drawable.pet1, "Toby"));
        pets.add(new Pet(R.drawable.pet2, "Chaks"));
        pets.add(new Pet(R.drawable.pet3, "Vektor"));
        pets.add(new Pet(R.drawable.pet4, "René"));
        pets.add(new Pet(R.drawable.pet5, "Paco"));
    }
}
