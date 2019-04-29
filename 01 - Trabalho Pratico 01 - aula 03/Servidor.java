import java.net.ServerSocket;
import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;

public class Servidor{
    public static void main(String[] args) throws IOException{
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta");
        
        Socket cliente = servidor.accept();
        
        System.out.println("Nova conexão com o cliente" + cliente.getInetAddress().getHostAddress());

       // try {
            Scanner entrada = new Scanner(cliente.getInputStream());
            while (entrada.hasNextLine()) {
                System.out.println("Mensagem recebida:" + entrada.nextLine());
            }
        // } catch (Exception e) {
        //     System.out.println("Deu ruim!!!");
        // }

        entrada.close();
        servidor.close();
    }
}