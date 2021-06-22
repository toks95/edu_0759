//package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

//95.24.131.65 - роутера
//192.168.1.19 - мой уникальный для локальной сети
//127.0.0.1 - одинаковый у всех
//localhost - одинаковый у всех

public class Server {
    public static void main(String[] args) {
        HashMap<Socket, String> clientSockets = new HashMap<Socket, String>();
        try {
            ServerSocket serverSocket = new ServerSocket(9198); // Создаёи серверный сокет
            System.out.println("Сервер запущен!");
            while (true){ // бесконечный цикл для ожидания подключения клиентов
                System.out.println("...подключение клиентов...");
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                System.out.println("Клиент подключился.");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
                out.writeUTF("Здравствуйте! Как к Вам можно обращаться?");
                String name = in.readUTF(); // Принимает сообщение от клиента
                clientSockets.put(socket,name);
                out.writeUTF(" Добро пожаловать!"+name.toUpperCase(Locale.ROOT)+ " , обращайтесь, если есть вопросы."); // Рассылает принятое сообщение всем клиентам
                out.writeUTF("Мы ответим в любое время суток.");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        while (true){
                            try{
                                request = in.readUTF(); // Принимает сообщение от клиента
                                System.out.println("Клиент прислал: "+request);
                                for (Socket clientSocket: clientSockets.keySet()
                                    //  String name: clientSockets.values()
                                ) { // Перебираем клиентов которые подключенны в настоящий момент
                                    if (clientSocket != socket) {
                                        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                                        out.writeUTF(
                                                "Сообщение от " +
                                                        clientSockets.get(socket)
                                                        +
                                                        ":"+
                                                        request.toUpperCase(Locale.ROOT)); // Рассылает принятое сообщение всем клиентам
                                    }
                                }
                            }catch (IOException ex){
                                ex.printStackTrace();
                                clientSockets.remove(socket); // Удаление сокета, когда клиент отключился
                                break;
                            }
                        }
                    }
                });
                thread.start();
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}