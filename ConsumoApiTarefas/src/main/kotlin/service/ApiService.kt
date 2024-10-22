package service

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object ApiService {

    private val client = HttpClient.newHttpClient()
    private val gson = Gson()

    fun <T> enviarRequisicao(
        metodo: String,
        endpoint: String,
        body: T? = null,
        cabecalhos: Map<String, String>? = emptyMap(),
        jwtToken: String? = null
    ): HttpResponse<String>? {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .header("Content-type", "application/json")

        if (jwtToken != null){
            request.header("Authorization", jwtToken)
        }

        when(metodo.uppercase()){
            "GET" -> request.GET()
            "POST" -> request.POST(HttpRequest.BodyPublishers.ofString(body?.let { gson.toJson(body) }))
            "PUT" -> request.PUT(HttpRequest.BodyPublishers.ofString(body?.let { gson.toJson(body) }))
            "DELETE" -> request.DELETE()
        }

        if (cabecalhos != null) {
            for ((key, value) in cabecalhos){
                request.header(key, value)
            }
        }

        val response = client.send(request.build(), HttpResponse.BodyHandlers.ofString())
        return response
    }
}