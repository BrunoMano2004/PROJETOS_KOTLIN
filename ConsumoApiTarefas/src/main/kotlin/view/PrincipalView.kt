package view

import com.google.gson.Gson
import service.TarefaService
import java.util.*

object PrincipalView {

    private val gson = Gson()
    private val tarefaService = TarefaService()


    fun menu(scan: Scanner, token: String){
        println("Bem vindo ao TaskFlow!\n")

        do {
            println("Selecione uma das opções!\n\n" +
                    "1 - Tarefas\n" +
                    "2 - Etiquetas\n" +
                    "3 - Seu usuario\n" +
                    "4 - Estatísticas")

            val resp = scan.nextInt()

            when(resp){
                1 -> println(tarefaService.buscarTarefas(token, gson))
                else -> println("Escolha uma alternativa válida!")
            }

            println("Deseja buscar outra coisa?")
            val respCont = scan.nextLine()

        } while (respCont.equals("S", true))
    }
}