package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    //создаем экземпляр класса Socket
    //Абстакция соединения(для обмена данными между процессами)
    private Socket clientSocket;
    //с каждым сокетом связаны два канала

    private DataInputStream in;
    private DataOutputStream out;
    private String nick;

/*    in клиента <--- out сервера
      out клиента ---> in сервера*/

public String getNick(){
    return nick;
}

//конструктор класса - настройка ввода вывода
    public ClientHandler(Server server, Socket socket) {
        try {
            this.clientSocket = socket;
            this.server = server;
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
// в поток можно передавать только final константы

            new Thread(() -> {
                try {
                    while (true) {

                        String msg = in.readUTF();
                        if (msg.startsWith("/auth ")) {
                            String[] data = msg.split("\\s");
                            String newNick = server.
                                    getAuthService().getNickByLoginAndPass(data[1], data[2]);

                            if (newNick != null) {
                                nick = newNick;
                                sendMsg("/auth_ok");
                                server.subscribe(this);
                                break;
                            } else {
                                sendMsg("Неверный логин/пароль");
                            }
                        }
                    }
                        while (true){
                          String msg = in.readUTF();
                            System.out.println(nick + ": " + msg);
                        }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
                    try {
                        socket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    public void sendMsg(String msg) {
    try {
        out.writeUTF(msg);
    }catch (IOException e){
        e.printStackTrace();
    }
    }
}

