import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket conn;
		try {
			conn = new Socket("127.0.0.1", 1010);
			Scanner entrada = new Scanner(System.in);
			ObjectOutputStream outputMessage = new ObjectOutputStream(conn.getOutputStream());
			ObjectInputStream inputMessage = new ObjectInputStream(conn.getInputStream());
			System.out.println("=========================================================");
			System.out.println("================= INICIANDO PROGRAMA ====================");
			System.out.println("=========================================================");
			System.out.println("INSTRUÇÕES — DIGITE APENAS NUMEROS, 99999999999");
			System.out.println("Digite seu CPF: ");
			outputMessage.writeObject(entrada.nextLine());
			outputMessage.flush();
			System.out.println("Receveid message: " + inputMessage.readObject().toString());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}

}
}