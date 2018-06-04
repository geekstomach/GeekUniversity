package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLClientInfoException;
import java.util.Vector;

public class Server {
    public static final int PORT = 8195; //создаем ServerSocket step 1
    //инициализируетм новый объект класса Vector
    //он будет содержать массив объектов клиентов
    //Методы класса Vector синхронизированы, в то время как ArrayList - нет.
    private Vector<ClientHandler> clients;

//инициализируем сервис авторизации
    AuthService authService;
public AuthService getAuthService(){
    return authService;
}

//Определяем конструктор класса
    public Server() throws Exception {
        //запускаем сервер используя порт
        try(ServerSocket serverSocket = new ServerSocket(PORT)){ //создаем ServerSocket step 2
            //создаем новый объект класса Vector
            clients = new Vector<>();

            authService = new AuthService();
            authService.connect();

            System.out.println("ServerMain started...Waiting fore clients");

            while (true){
                //Специальный тип сокета, слушает определенный порт
                //Подключился ли?
                Socket socket =serverSocket.accept(); //создаем ServerSocket step 3
                //Кто подключился ?
                System.out.println("Client connected "+
                socket.getInetAddress() + " " + socket.getPort() + " " +
                socket.getLocalPort());

 //Создаем новый объект класса ClientHandler того кто подключился
                new ClientHandler(this,socket);
            }
        } catch (IOException e) {   //new ServerSocket(PORT)) требует try/catch ввода вывода
            e.printStackTrace();
        } catch (SQLClientInfoException | ClassNotFoundException e) { //обращение к базе данных требует Exception
            System.err.println("Не удалось запустить сервис авторизации");
            e.printStackTrace();
        } finally {
            authService.disconnect();
        }
    }
    public void subscribe (ClientHandler clientHandler) {
        //в случае успешной авторизации добавляем переданный объект класса ClientHandler в Vector
        clients.add(clientHandler);
    }
    public void unsubscribe (ClientHandler clientHandler){
        clients.remove(clientHandler);
        }

    public void broadcastMsg (String msg){
        for (ClientHandler o: clients){
            o.sendMsg(msg);
        }
    }
}
