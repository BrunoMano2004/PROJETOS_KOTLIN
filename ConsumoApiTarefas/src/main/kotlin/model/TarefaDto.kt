package model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TarefaDto(
    val id: Long,
    val nome: String,
    val nomeEtiqueta: String,
    val corEtiqueta: String,
    val descricao: String,
    val status: String,
    val dataExpiracao: String,
    val dataFinalizacao: String? = null
){
    override fun toString(): String {
        return "Tarefa:\n\n" +
                "Id: $id\n" +
                "Titulo: $nome\n" +
                "Etiqueta: $nomeEtiqueta\n" +
                "Descrição: $descricao\n" +
                "Status: $status\n" +
                "Data de Expiração: ${formatarDataHoraParaBrasileiro(dataExpiracao)}\n" +
                "Data de Finalização: ${dataFinalizacao?.let { formatarDataHoraParaBrasileiro(it) } ?: "Não finalizado"}"
    }

    fun formatarDataHoraParaBrasileiro(dataHoraIso: String): String {
        val formatterIso = DateTimeFormatter.ISO_DATE_TIME

        val dataHora = LocalDateTime.parse(dataHoraIso, formatterIso)

        val formatterBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

        return dataHora.format(formatterBrasileiro)
    }
}
