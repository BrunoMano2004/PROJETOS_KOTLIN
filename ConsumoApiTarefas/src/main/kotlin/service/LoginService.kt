package service

import com.google.gson.Gson
import model.LoginDto
import model.TokenDto

class LoginService {

    fun realizarLogin(login: LoginDto): String{

        val response = ApiService.enviarRequisicao(
            "POST",
            "http://localhost:8080/login",
            login,
            null,
            null)

        val gson = Gson()
        val token = gson.fromJson(response?.body(), TokenDto::class.java)

        return token.jwtToken
    }
}