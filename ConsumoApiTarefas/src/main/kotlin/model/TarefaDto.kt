package model

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
        return super.toString()
    }
}
