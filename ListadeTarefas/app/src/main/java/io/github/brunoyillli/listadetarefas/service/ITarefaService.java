package io.github.brunoyillli.listadetarefas.service;

import java.util.List;

import io.github.brunoyillli.listadetarefas.model.Tarefa;

public interface ITarefaService {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();
}
