package service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.TarefaDto
import java.lang.reflect.Type

class TarefaService {

    fun buscarTarefas(token: String, gson: Gson): List<TarefaDto>{
        val response = ApiService.enviarRequisicao(
            "GET",
            "http://localhost:8080/tarefa/usuario",
            null,
            null,
            token)

        val tipo = object: TypeToken<List<TarefaDto>>(){}.type
        val tarefasDto: List<TarefaDto> = gson.fromJson(response?.body(), tipo)

        return tarefasDto
    }
}