package io.github.brunoyillli.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.github.brunoyillli.cardview.R;
import io.github.brunoyillli.cardview.adapter.PostagemAdapter;
import io.github.brunoyillli.cardview.model.Postagem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager( layoutManager );

        this.prepararPostagens();

        PostagemAdapter postagemAdapter = new PostagemAdapter(postagemList);
        recyclerPostagem.setAdapter(postagemAdapter);
    }

    public void prepararPostagens(){
        Postagem postagem = new Postagem("Alesi Homem", "Indo para a Bahia", R.drawable.imagem1);
        this.postagemList.add(postagem);
        postagem = new Postagem("Bruno Mendes", "Cidade mais pobre da Bahia", R.drawable.imagem2);
        this.postagemList.add(postagem);
        postagem = new Postagem("Perceu", "Fugindo pra França", R.drawable.imagem3);
        this.postagemList.add(postagem);
        postagem = new Postagem("Mayara Cristina", "Passeando em Góias", R.drawable.imagem4);
        this.postagemList.add(postagem);
    }
}