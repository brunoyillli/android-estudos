package io.github.brunoyillli.listadetarefas.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.github.brunoyillli.listadetarefas.R;
import io.github.brunoyillli.listadetarefas.adapter.TarefaAdapter;
import io.github.brunoyillli.listadetarefas.databinding.ActivityMainBinding;
import io.github.brunoyillli.listadetarefas.helper.DbHelper;
import io.github.brunoyillli.listadetarefas.helper.RecyclerItemClickListener;
import io.github.brunoyillli.listadetarefas.model.Tarefa;
import io.github.brunoyillli.listadetarefas.service.TarefaService;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Tarefa tarefaSelecioanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        recyclerView = findViewById(R.id.recyclerListaTarefas);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onItemClick(View view, int position) {
                        Tarefa tarefaSelecionada = listaTarefas.get(position);
                        Intent intent = new Intent(MainActivity.this,
                                AdicionarTarefaActivity.class);
                        intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        tarefaSelecioanda = listaTarefas.get(position);


                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Confirmar exclusão");
                        dialog.setMessage("Deseja excluir a tarefa: " + tarefaSelecioanda.getNomeTarefa() + " ? ");

                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                TarefaService tarefaService = new TarefaService(getApplicationContext());
                                if(tarefaService.deletar(tarefaSelecioanda)){
                                    carregarListaTarefas();
                                    Toast.makeText(getApplicationContext(), "Sucesso ao excluir tarefa!",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Erro ao excluir tarefa!",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                        dialog.setNegativeButton("Não", null);
                        dialog.create();
                        dialog.show();
                    }
                }
                )
        );

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaTarefas() {

        TarefaService tarefaService = new TarefaService(getApplicationContext());
        listaTarefas = tarefaService.listar();

        tarefaAdapter = new TarefaAdapter(listaTarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(tarefaAdapter);

    }

    @Override
    protected void onStart() {
        carregarListaTarefas();
        super.onStart();
    }


}