package br.com.projetolistatarefa.service;

import br.com.projetolistatarefa.entites.Tarefa;
import br.com.projetolistatarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    
    public void salvar(Tarefa tarefa) {

        Tarefa tarefaCriada = new Tarefa();

        tarefaCriada.setDescricao(tarefa.getDescricao());
        tarefaCriada.setStatus(tarefa.isStatus());
        tarefaCriada.setTitulo(tarefa.getTitulo());
        tarefaRepository.save(tarefaCriada);
    }
    
    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }
    
    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }
    
}