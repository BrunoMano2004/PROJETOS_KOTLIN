package service

import model.LoginDto
import java.net.URI
import com.google.gson.Gson
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse

class ConsumoApiService {

    fun enviarRequisicaoGet(request: HttpRequest.Builder): String{

        val client = HttpClient.newHttpClient()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun autenticar(login: LoginDto): String{
        val gson = Gson()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/login"))
            .POST(BodyPublishers.ofString(json))
    }
}