package ui.view;

import domain.model.Animal;

import java.sql.*;
import java.util.Properties;

public class AnimalView {

    public static void main(String[] args) {

        // constants for your project
        // replace "probeer" by your own database, e.g. '2TX34'
        String url = "jdbc:postgresql://databanken.ucll.be:62122/probeer";
        // replace 'web3' by your own schema name, e.g. groep102
        String schema = "web3";


        // set properties for db connection
        Properties properties = new Properties();

        try {
            Class.forName("ui.view.Secret");
            Secret.setPass(properties);
        } catch (ClassNotFoundException e) {
            System.out.println("Class ui.view.Secret with credentials not found");
        }

        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode", "prefer");

        //open the db connection
        try (Connection connection = DriverManager.getConnection(url, properties)) {

            // add an animal
            String query = String.format("insert into %s.animal (name,type,food) values (?,?,?)", schema);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Max");
            preparedStatement.setString(2, "Hond");
            preparedStatement.setInt(3, 3);
            preparedStatement.execute();

            //get all animals
            query = String.format("SELECT * from %s.animal order by name;", schema);
            PreparedStatement statementInsert = connection.prepareStatement(query);
            ResultSet resultSet = statementInsert.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int food = resultSet.getInt("food");
                Animal animal = new Animal(id, name, type, food);
                System.out.println(animal.toString());
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection no succes");
        }
    }

}
