package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main (String[] args){
        //95.24.131.65 - роутера
        //192.168.1.19 - мой уникальный для локальной сети
        //127.0.0.1 - одинаковый у всех
        //localhost - одинаковый у всех
        try{
                    }
        ServerSocket serverSocket = new ServerSocket(9197);
        System.out.println ("Запущен сервер.");
        System.out.println ("Ожидается подключение клиентов.");
        Socket socket = serverSocket.accept()
    } catch (IOException e){
        e.printStackTrace();
    }
}
