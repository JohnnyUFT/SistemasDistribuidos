import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.lang.Runnable;

public class Cliente{
    public static void main(String[] args) throws UnknownHostException, IOException{
        int[] clientes = {0,1,2,3,4,5};
        // Vector v = new Vector();

        for(int i = 0; i<5; i++){
            String host = "127.0.0.1";
            Socket cliente = new Socket(host, 12345);
            System.out.println("O cliente se conectou ao servidor");

            new Thread(t0).start();
            new Thread(t1).start();
        }

        
        
    }

    // implementacao das interfaces Runnable:
    private static Runnable t0  = new Runnable(){
    
        @Override
        public void run() {
            // incia conexao com servidor:
            Scanner teclado   = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());

            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }String host = "127.0.0.1";

            saida.close();
            teclado.close();
        }
    };

    private static Runnable t1  = new Runnable(){
    
        @Override
        public void run() {
            // incia conexao com servidor:
            String host = "127.0.0.1";
            Socket cliente = new Socket(host, 12345);
            System.out.println("O cliente se conectou ao servidor");

            Scanner teclado   = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());

            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }

            saida.close();
            teclado.close();
        }
    };
}