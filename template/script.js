
async function carregarTarefas() {

    const API_URL_LIST = "http://localhost:8080/tarefa/list";


    const response = await fetch(API_URL_LIST);
    const tarefas = await response.json();

    const lista = document.getElementById("listaTarefas");
    lista.innerHTML = "";

    tarefas.forEach(tarefa => {
        const li = document.createElement("li");
        li.classList.add("tarefa-item"); 
        li.innerHTML = `
                <div class="tarefa">
                    <p class="titulo"><span></span> ${tarefa.titulo}</p>
                    <p class="descricao">${tarefa.descricao}</p>
                    <button class="remover" onclick="removerTarefa(${tarefa.id})">Remover</button>
                </div>
        `;
        lista.appendChild(li);
    });
}

async function adicionarTarefa() {

    const API_URL_ADD = "http://localhost:8080/tarefa/adicionarTarefa";

    const titulo = document.getElementById("tituloTarefa").value;
    const descricao = document.getElementById("descricaoTarefa").value;

    if (descricao && titulo) {
        await fetch(API_URL_ADD, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ 
                titulo,
                descricao, 
                concluida: false 
            })
        });

        document.getElementById("tituloTarefa").value = '';
        document.getElementById("descricaoTarefa").value = '';

        carregarTarefas();
    } else {
        alert("Por favor, preencha tanto o título quanto a descrição da tarefa.");
    }
}

async function removerTarefa(id) {
    const API_URL_REMOVE = "http://localhost:8080/tarefa";
    await fetch(`${API_URL_REMOVE}/${id}`, { method: "DELETE" });
    carregarTarefas();
}
carregarTarefas();