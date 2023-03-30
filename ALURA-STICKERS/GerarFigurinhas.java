import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GerarFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        //Leitura da Imagem 
        InputStream InputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(InputStream);

        //Criar nova imagem

        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 150;
        BufferedImage novaImagem = new BufferedImage(altura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar imagem original para nova imagem salva na memória

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //Configurando fonte da imagem

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 62);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        //Escrever frasse na imagem
        graphics.drawString("MELHOR FILME", 50, novaAltura - 100);
        //escrever a nova imagem em um arquivo.

        ImageIO.write(novaImagem, "png", new File("nomeArquivo.png"));
    }

}
