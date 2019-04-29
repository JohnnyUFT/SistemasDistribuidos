import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.lang.Runnable;
import Concorrencia.*;

public class Cliente{
    public static void main(String[] args) throws UnknownHostException, IOException{
        int[] clientes = {0,1,2,3,4,5};
        // Vector v = new Vector();

        for(int i = 0; i<clientes.length; i++){
            String host = "127.0.0.1";
            Socket cliente = new Socket(host, 12345);
            System.out.println("O cliente se conectou ao servidor");

            new Thread(new Concorrencia(cliente)).start();
            new Thread(new Concorrencia(cliente)).start();
        }   
    }
}