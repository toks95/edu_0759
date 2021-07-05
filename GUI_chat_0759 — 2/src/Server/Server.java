package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<User> users = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9197); // Создаем серверный сокет
            System.out.println("Сервер запущен!");
            while (true) { // Бесконечный цикл ожидающий подключения клиентов
                System.out.println("Подключение...");
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                User currentUser = new User(socket);
                users.add(currentUser);
                System.out.println("Успешное подключение!");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); // Поток вывода
                currentUser.setOos(oos);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        try {
                            currentUser.getOos().writeObject("Добро пожаловать!");
                            currentUser.getOos().writeObject("Как к Вам можно обращаться?");
                            String userName = in.readUTF();
                            currentUser.setUserName(userName);
                            sendUserList(); // Отправляем обновления списка пользователей
                            currentUser.getOos().writeObject(currentUser.getUserName() + " здравствуйте!");
                            System.out.println(currentUser.getUserName() + " теперь с нами!");
                            while (true) {
                                request = in.readUTF(); // Принимает сообщение от клиента
                                System.out.println(currentUser.getUserName()+" прислал сообщение: "+request);
                                for (User user : users) { // Перебираем клиентов которые подключены в настоящий момент
                                    if (currentUser != user) {
                                        user.getOos().writeObject(currentUser.getUserName() + ": " + request); // Рассылает принятое сообщения всем клиентам
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            users.remove(currentUser); // Удаление юзера, когда клиент отключился
                            sendUserList(); // Отправляем обновления списка пользователей
                            for (User user : users) { // Перебираем клиентов которые подключены в настоящий момент
                                try {
                                    user.getOos().writeObject("Пользователь " + currentUser.getUserName() + " покинул чат"); // Рассылает принятое сообщения всем клиентам
                                    currentUser.getSocket().close(); // Сокет закрывается, когда клиент покидает чат
                                } catch (IOException IOe) {
                                    IOe.printStackTrace();
                                }
                            }
                        }
                    }
                });
                thread.start();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void sendUserList(){
        String usersName = "**userList**";
        for (User user:users) {
            usersName += "//"+user.getUserName(); //**userList**//user1//user2//user3
        }
        for (User user:users) {
            try{
                user.getOos().writeObject(usersName);
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
    }

}
