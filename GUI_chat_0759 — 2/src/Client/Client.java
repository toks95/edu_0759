package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 9197); // Создаем сокет для подключения к серверу
            System.out.println("Подключено!");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Thread thread = new Thread(new Runnable() { // Создаем поток для приема сообщений от сервера
                @Override
                public void run() {
                    String response = null;
                    while (true){
                        try {
                            response = in.readUTF(); // Принимаем сообщения от сервера
                            System.out.println(response); // Печатаем на консоль принятое сообщение от сервера
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                            System.out.println("Сервер не работает.");
                            break;
                        }
                    }
                }
            });
            thread.start();
            Scanner scanner = new Scanner(System.in);
            String request = null;
            while (true){
                request = scanner.nextLine(); // Ждём сообщение от поьзователя (из консоли)
                out.writeUTF(request); // Отправляем сообщение из консоли на сервер
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}