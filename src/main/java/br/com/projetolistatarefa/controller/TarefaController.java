package br.com.projetolistatarefa.controller;

import br.com.projetolistatarefa.entites.Tarefa;
import br.com.projetolistatarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {


    @Autowired
    TarefaService tarefaService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Tarefa>> listarTodos() {

        List<Tarefa> listagem = tarefaService.listar();
        return ResponseEntity.ok(listagem);
    }

    @PostMapping(value = "/adicionarTarefa")
    public void adicionar(@RequestBody Tarefa tarefa) {
        tarefaService.salvar(tarefa);
    }

    @DeleteMapping(value = "/{id}")
    public void remover(@PathVariable Long id) {
        tarefaService.excluir(id);
    }
}
