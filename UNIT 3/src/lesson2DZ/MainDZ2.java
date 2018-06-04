package lesson2DZ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MainDZ2 {
  //  jdbc:sqlite:C:/Users/XE/Google Диск/GeekBrains/geekbrains/UNIT 3/src/lesson2DZ\DZ2table
    private static final String url = "jdbc:sqlite:C:/Users/XE/Google Диск/GeekBrains/geekbrains/UNIT 3/src/lesson2DZ\\DZ2table";
    private static final  String username = "root";
    private static final  String password = "qwe123";

    static Connection connection;
    private static PreparedStatement preparedStatement;

    public static void main(String ...args) {

        //регистрация драйвера

        try {
            //загружаем класс и инициализируем
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url, username, password);//имя и пароль опционально
            //далее следуют отдельные методы взаимодействия с таблицей
            sqlCreateTable();
            sqlInsertData();
            try {
                terminal();
            } catch (IOException e) {

            }
            //после окончания работы с базой соединение необходимо закрыть
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
    public static void sqlCreateTable(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS DZ2table ( " +
                    "'id'INTEGER PRIMARY KEY NOT NULL," +
                    "'prodid' NUMERIC NOT NULL, " +
                    "'title' TEXT NOT NULL," +
                    "'cost' DOUBLE (10000,2) NOT NULL )");
            System.out.println("the table is created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void sqlInsertData(){
        try {
            //connect.setAutoCommit(false)// используем при наличии нескольких ействий над датой базой
            //~~~ Чтение таблицы БД ~~~
            preparedStatement = connection.prepareStatement("DELETE FROM DZ2table");//что-то не срабатывает
            // Выполнение запроса
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("INSERT INTO DZ2table(prodid,title,cost) VALUES (?,?,?)");
            for (int i = 0; i <100 ; i++) {
                preparedStatement.setInt(1, i*10);
                preparedStatement.setString(2, "Goods"+i);
                //ограничить двуся знаками после запятой
                preparedStatement.setDouble(3, Math.random()*100_000);
                preparedStatement.executeUpdate();
//praparesStatment.exxecutBUnsh();  // используем при наличии нескольких ействий над датой базой
            }
            System.out.println("the table is refreshed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public static void sqlFindOutThePrice (String title){
    try {

        preparedStatement = connection.prepareStatement("SELECT title , cost FROM DZ2table WHERE title = ?");
        preparedStatement.setString(1, title);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()==false){
            System.out.println("Такого товара нет: "+title);
        }else {
            do {
                String t = resultSet.getString("title");
                Double c = resultSet.getDouble("cost");
                System.out.println(t+" - "+c);
            }while (resultSet.next());
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public static void sqlChangeThePrice(String title, Double cost){
    try {
        preparedStatement = connection.prepareStatement("UPDATE DZ2table SET cost = ? WHERE title = ?");
        preparedStatement.setDouble(1,cost);
        preparedStatement.setString(2,title );
        preparedStatement.executeUpdate();
        sqlFindOutThePrice(title);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public static void sqlSelectPriceFromTo (Double from, Double to) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("SELECT*FROM DZ2table WHERE cost BETWEEN ? AND ?");
            preparedStatement.setDouble(1,from );
            preparedStatement.setDouble(2,to );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()==false){
                System.out.println("В данном диапазоне нет значений");
            } else {
                do {
                    String id = resultSet.getString("id");
                    String prodid = resultSet.getString("prodid");
                    String title = resultSet.getString("title");
                    String cost = resultSet.getString("cost");
                    System.out.println("[" + id + "|" + prodid + "|" + title + "|" + cost + "]");
                } while (resultSet.next());
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public static void terminal() throws IOException, SQLException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Используйте команду: \n /цена , чтобы узнать цену \n /exit , для выхода из программы \n /сменитьцену , для изменения цены \n /товарыпоцене , для вывода списка товаров в заданном диапазоне");
    while (true){
        System.out.println("Введите команду :");
        String r = reader.readLine();
        if (r.startsWith("/цена")) {
            sqlFindOutThePrice(r.split(" ")[1]);
        }else if (r.startsWith("/сменитьцену")){
            sqlChangeThePrice(r.split(" ")[1],Double.parseDouble(r.split(" ")[2]));
        }else if (r.startsWith("/товарыпоцене")){
            sqlSelectPriceFromTo(Double.parseDouble(r.split(" ")[1]), Double.parseDouble(r.split(" ")[2]));
        }else if (r.startsWith("/exit")){
            System.exit(0);
        }else {
            System.out.println("Комманда некорректна");
        }

    }
}
}
