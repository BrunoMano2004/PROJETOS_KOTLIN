package main

import model.LoginDto
import service.ConsumoApiService

fun main(){

    val login = LoginDto("brunomano2004@gmail.com", "Bruno@8401")

    println(ConsumoApiService.autenticar(login))
}