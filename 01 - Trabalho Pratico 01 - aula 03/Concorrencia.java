import java.util.Scanner;
import java.lang.Runnable;
import java.net.Socket;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.io.IOException;

public class Concorrencia extends Thread {
    public Socket cliente;
    public Concorrencia(Socket cliente) {
        this.cliente = cliente;
    }
     public void run() {
         Socket cliente;
         // inicia conexao com servidor:
         Scanner teclado   = new Scanner(System.in);
         PrintStream saida = new PrintStream(cliente.getOutputStream());

         while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
         }

         saida.close();
         teclado.close();
     }
}