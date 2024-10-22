package main

import model.LoginDto
import service.ApiService
import service.LoginService
import view.PrincipalView
import java.util.Scanner

fun main(){
    val scan = Scanner(System.`in`)
    val loginService = LoginService()

    println("Digite seu username: ")
    val username = scan.nextLine()

    println("Digite sua senha: ")
    val senha = scan.nextLine()

    val token = loginService.realizarLogin(LoginDto(username, senha))

    PrincipalView.menu(scan, token)

}