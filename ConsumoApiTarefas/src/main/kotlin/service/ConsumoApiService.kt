package service

import model.LoginDto
import java.net.URI
import com.google.gson.Gson
import model.TokenDto
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse

object ConsumoApiService {

    fun enviarRequisicao(json: String): String{

        val client = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/login"))
            .POST(BodyPublishers.ofString(json))
            .header("Content-type", "application/json")
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun autenticar(login: LoginDto): String{
        val gson = Gson()
        val json = gson.toJson(login)

        val response = enviarRequisicao(json)
        val tokenDto = gson.fromJson(response, TokenDto::class.java)

        try {
            val token = tokenDto.jwtToken
            return token
        } catch (ex: NullPointerException){
            return ex.message.toString()
        }
    }
}