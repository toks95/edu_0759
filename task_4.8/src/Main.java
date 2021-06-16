import java.util.Scanner;

/*
 *  ***Гостиница***
 *  1) Гостиница
 *  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 *
 *   *Задание для лабораторной работы №4*
 *   Освободить комнату
 *   Вывести свойства комнаты
 *   Показать комнаты с WiFi
 *   Показать комнаты с WC
 *   Показать комнаты с Eat
 *   Показать комнаты по кол-ву спальных мест
 *   Отобразить список команд
 * */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,true,(byte) 11),
                new Room((byte) 2,true,true,false,(byte) 12),
                new Room((byte) 1,false,true,true,(byte) 13),
                new Room((byte) 3,true,false,false,(byte) 21),
                new Room((byte) 2,false,false,false,(byte) 22),
                new Room((byte) 1,true,true,true,(byte) 23),
                new Room((byte) 3,false,true,false,(byte) 31),
                new Room((byte) 3,true,true,false,(byte) 32),
                new Room((byte) 1,false,false,true,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите команду."+"\n"+"Узнать количество свободных номеров: getFreeRooms"+"\n"+"Забронировать номер: reserveRoom"+"\n"+"Разбронировать номер: clearRoom"+"\n"+"Получить информацию о комнате: roomInfo"+"\n"+"Узнать о WiFi в номере: roomWifi"+"\n"+"Узнать о туалетной комнате в номере: roomWC"+"\n"+"Узнать о включенном в стоимость номера питании: roomEat"+"\n"+"Узнать о количестве спальных мест в номере: getQuantityRoom"+"\n"+"Выход: Exit");
            command = scanner.nextLine();
            if(command.equals("getFreeRooms")){
                hotel.getFreeRooms();
            }else if(command.equals("clearRoom")){
                System.out.print("Какой номер освободить? ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.clearRoom(roomNumber);
            }else if(command.equals("reserveRoom")){
                System.out.print("Какой номер забронировать? ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.reserveRoom(roomNumber);
            }else if(command.equals("roomProperty")){
                System.out.print("Введите номер комнаты: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.roomInfo(roomNumber);
            }else if(command.equals("roomWifi")){
                System.out.print("Номера с WiFi: ");
                hotel.roomWifi();
            }else if(command.equals("roomWc")){
                System.out.print("Номера с туалетной комнатой: ");
                hotel.roomWc();
            }else if(command.equals("roomEat")){
                System.out.print("Номера с питанием: ");
                hotel.roomEat();
            }else if(command.equals("getQuantityRoom")){
                hotel.getQuantityRoom();
            }else if (command.equals("exit")){
                break;
            }
        }
    }
}