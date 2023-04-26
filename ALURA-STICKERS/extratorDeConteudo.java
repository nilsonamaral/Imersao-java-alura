import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {

        //extrai só os dados que interessam (título, classificação, imagem...)
        var parser = new jsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse.(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteúdos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
             var conteudo = new conteudo(titulo, urlImagem);
        }

        return conteudos;
    }
}
