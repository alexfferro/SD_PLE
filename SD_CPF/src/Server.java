import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			final ServerSocket server = new ServerSocket(1010);
			System.out.println("Servidor Iniciado — IP : 1010");
			while(true) {
				final Socket socket = server.accept();
				
				final ObjectOutputStream outputMessage = new ObjectOutputStream(socket.getOutputStream());
				final ObjectInputStream inputMessage = new ObjectInputStream(socket.getInputStream());
				String CPF = inputMessage.readObject().toString();
				if (ValidaCPF.validarCPF(CPF) == true){
					System.out.println("CPF Válido. \n");
					outputMessage.writeObject(new String("CPF Válido. \n"));
					outputMessage.flush();
				} else {
					System.out.println("ERROR, CPF INVALIDO !! ");
					outputMessage.writeObject(new String("ERROR, CPF INVALIDO !! \n"));
					outputMessage.flush();
				}
				socket.close();
				}	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
