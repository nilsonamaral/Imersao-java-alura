import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //criar a requisão
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        

        // Extrair dados que serão usados
        var parser = new jsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        // Manipular os dados desejados

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[1mTítulo:\u001b[m " +  filme.get("title"));
            System.out.println("\u001b[1mURL da Imagen:\u001b[m " + filme.get("image"));
            System.out.println("\u001b[3m \u001b[104m imDb Rating: \u001b[m" + filme.get("imDbRating"));
            double classificacao = Double.parseDouble(filme.get("rank"));
            int estrelas = (int) classificacao;

            for (int i = 1; i <= estrelas; i++) {
                System.out.print("⭐");
            }

            System.out.println("\n");

        }
    }
}