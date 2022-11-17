package io.github.brunoyillli.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.brunoyillli.recyclerview.R;
import io.github.brunoyillli.recyclerview.activity.ClickListener;
import io.github.brunoyillli.recyclerview.activity.adapter.Adapter;
import io.github.brunoyillli.recyclerview.activity.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        this.criarFilmes();
        Adapter adapter = new Adapter(listaFilmes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
            new ClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new ClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item pressionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Click longo: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );
    }

    public void criarFilmes() {
        Filme filme = new Filme("Alesi aventuras", "cómedia", "2002");
        this.listaFilmes.add(filme);
        filme = new Filme("Bruno o caçador de monstros", "Ação", "2022");
        this.listaFilmes.add(filme);
        filme = new Filme("Gordo o cara mais pesado", "Suspense", "2005");
        this.listaFilmes.add(filme);
        filme = new Filme("Free fire, a origem do mundo", "Documentario", "2020");
        this.listaFilmes.add(filme);
        filme = new Filme("Kakashi da mamae", "Artes marciais", "2022");
        this.listaFilmes.add(filme);
        filme = new Filme("Jogador mais forte de roblox", "Ação", "2018");
        this.listaFilmes.add(filme);
        filme = new Filme("Ditadura do careca", "Documentario", "2023");
        this.listaFilmes.add(filme);
        filme = new Filme("Gantz 1 temporada", "Anime", "2007");
        this.listaFilmes.add(filme);
        filme = new Filme("Gantz 2 temporada", "Anime", "2008");
        this.listaFilmes.add(filme);
        filme = new Filme("Kakashi da mamãe a origem", "Educacional", "2016");
        this.listaFilmes.add(filme);
        filme = new Filme("Adão Negro", "Super Heroi", "2020");
        this.listaFilmes.add(filme);

    }
}