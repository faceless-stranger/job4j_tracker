package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        /* Создаем PreparedStatement и отправляем sql запрос. Statement.RETURN_GENERATED_KEYS - это константа, которая указывает JDBC-драйверу возвращать сгенерированные ключи  после выполнения операции вставки данных в базу данных. */
        try (PreparedStatement pStatement =
                     connection.prepareStatement("INSERT INTO items (name, created) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
            pStatement.setString(1, item.getName());  /* Устанавливаем имя из объекта Item */
            pStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));  /* Устанавливаем дату создания из объекта Item используя Timestamp и нужно помнить о переводе из LocalDateTime в Timestamp */
            pStatement.executeUpdate(); /* Производим вставку и записываем число */
            ResultSet generatedKeys = pStatement.getGeneratedKeys(); /*  ResultSet это интерфейс для представления результата запроса к базе данных. Он представляет собой таблицу данных, возвращенную из базы данных после выполнения SQL-запроса */
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1); /* Получаем значение столбца т.е 1 это id, если указать 2 то это будет name */
                item.setId(id); /* устанавливаем сгенерированный id */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int result = 0;
        try (PreparedStatement pStatement =
                     connection.prepareStatement("UPDATE items SET name = ?, created = ? WHERE ID = ?")) {
            pStatement.setString(1, item.getName());
            pStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            pStatement.setInt(3, id);
            result = pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement pStatement =
                     connection.prepareStatement("DELETE FROM items WHERE ID = ?")) {
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM items")) {
            pStatement.execute();
            ResultSet resultSet = pStatement.getResultSet();
            while (resultSet.next()) {
                result.add(new Item(resultSet.getString("name"), resultSet.getInt("id")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Item(resultSet.getString("name"), resultSet.getInt("id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                item = createItem(resultSet);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item createItem(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setName(resultSet.getString("name"));
        item.setId(resultSet.getInt("id"));
        item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        return item;
    }
}