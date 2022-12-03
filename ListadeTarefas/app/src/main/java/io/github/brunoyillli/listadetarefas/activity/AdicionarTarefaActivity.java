package io.github.brunoyillli.listadetarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import io.github.brunoyillli.listadetarefas.R;
import io.github.brunoyillli.listadetarefas.model.Tarefa;
import io.github.brunoyillli.listadetarefas.service.TarefaService;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        editTarefa = findViewById(R.id.textTarefa);
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");
        if (tarefaAtual != null) {
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Tarefa tarefa = new Tarefa();
        switch (item.getItemId()) {
            case R.id.itemSalvar:
                TarefaService tarefaService = new TarefaService(getApplicationContext());
                boolean isSalvo = false;
                String nomeTarefa = editTarefa.getText().toString();
                if (tarefaAtual != null) {
                    if (!nomeTarefa.isEmpty()) {
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());
                        isSalvo = tarefaService.atualizar(tarefa);
                        finish();
                    }
                } else if (!nomeTarefa.isEmpty()) {
                    tarefa.setNomeTarefa(editTarefa.getText().toString());
                    isSalvo = tarefaService.salvar(tarefa);
                    finish();
                }
                if (isSalvo) {
                    Toast.makeText(getApplicationContext(), "Sucesso ao salvar/atualizar tarefa!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao salvar/atualizar tarefa!",
                            Toast.LENGTH_LONG).show();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}