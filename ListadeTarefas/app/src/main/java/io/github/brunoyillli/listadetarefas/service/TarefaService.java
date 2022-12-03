package io.github.brunoyillli.listadetarefas.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.github.brunoyillli.listadetarefas.helper.DbHelper;
import io.github.brunoyillli.listadetarefas.model.Tarefa;

public class TarefaService implements ITarefaService {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaService(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        try {
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.i("INFO", "Tarefa salva com sucesso");
        } catch (Exception e) {
            Log.e("ERRO", "Erro ao salvar tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        try {
            String[] args = {String.valueOf(tarefa.getId())};
            escreve.update(DbHelper.TABELA_TAREFAS,cv,"id=?", args);
            Log.i("INFO", "Tarefa editada com sucesso");
        } catch (Exception e) {
            Log.e("ERRO", "Erro ao editar tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        try {
            String[] args = {String.valueOf(tarefa.getId())};
            escreve.delete(DbHelper.TABELA_TAREFAS,"id=?",args);
            Log.i("INFO", "Tarefa excluida com sucesso");
        } catch (Exception e) {
            Log.e("ERRO", "Erro ao excluir tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + ";";
        Cursor c = le.rawQuery(sql, null);
        while (c.moveToNext()) {
            Tarefa tarefa = new Tarefa();
            Long id = c.getLong(c.getColumnIndexOrThrow("id"));
            String nomeTarefa = c.getString(c.getColumnIndexOrThrow("nome"));
            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);
            tarefas.add(tarefa);
        }
        return tarefas;
    }
}
