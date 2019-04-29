// import java.net.DatagramSockect;
import java.net.DatagramSocket;
// import java.net.DatagramPackect;
import java.net.DatagramPacket;
import java.net.InetAddress;

class UDPServer{
    public static void main(String args[]) throws Exception{
        // define porta e buffers para comunicacao com servidor:
        DatagramSocket servidor = new DatagramSocket(9876);
        byte[] bufferRecebimento = new byte[1024];
        byte[] bufferEnvio       = new byte[1024];

        System.out.println("Aguradando mensagens de clientes");
        while(true){
            // prepara a estrutura de recebimetno do cliente:
            DatagramPacket pacoteRecebimento = new DatagramPacket(bufferRecebimento, bufferRecebimento.length);

            // Recebe conteudo do cliente e o processa (converte em maiuscula):
            servidor.receive(pacoteRecebimento);
            String texto = new String(pacoteRecebimento.getData());
            System.out.println("Mensagem recebida: " +texto);

            // Processa (converte p/ maiuscula) e devolve respota para cliente:
            InetAddress enderecoIP = pacoteRecebimento.getAddress();
            int porta = pacoteRecebimento.getPort();
            String textoAlterado = texto.toUpperCase();
            bufferEnvio = textoAlterado.getBytes();
            DatagramPacket pacoteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, enderecoIP, porta);
            servidor.send(pacoteEnvio);
        }
    }
}