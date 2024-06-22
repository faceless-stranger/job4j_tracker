package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll /* метод выполняется один раз до начала тестов. на все тесты создаем одно подключение к БД, чтобы ускорить их, поэтому Connection делаем статическим*/
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
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

    @AfterAll /*в методе выполняется закрытие подключения. Данный метод обозначен аннотацией @AfterAll, т.е. метод выполняется один раз после тестов; */
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach /*тут мы чистим таблицу items после внесенных изменений. Делается это, чтобы облегчить тестирование, иначе изменения, внесенные один тестом, будут видны другому.
    Данный метод обозначен аннотацией @AfterEach, т.е. метод выполняется после каждого теста; */
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void searchForAnAlreadyCreatedItemAndReplaceTheName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemFirst = new Item("item");
        Item itemSecond = new Item("item2");
        tracker.add(itemFirst);
        tracker.replace(itemFirst.getId(), itemSecond);
        assertThat(tracker.findById(itemFirst.getId()).getName()).isEqualTo(itemSecond.getName());
    }

    @Test
    public void deleteItemByIdAndVerifyItsAbsence() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void findAllItemsReturnsAllStoredItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("item1");
        Item secondItem = new Item("item2");
        tracker.add(firstItem);
        tracker.add(secondItem);
        List<Item> foundItems = tracker.findAll();
        assertThat(foundItems)
                .hasSize(2)
                .extracting(Item::getName)
                .containsExactlyInAnyOrder("item1", "item2");
    }

    @Test
    public void findItemsByNameReturnsMatchingItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("item");
        Item secondItem = new Item("item");
        Item thirdItem = new Item("anotherItem");

        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);

        List<Item> foundItems = tracker.findByName("item");

        assertThat(foundItems)
                .hasSize(2)
                .extracting(Item::getName)
                .containsExactlyInAnyOrder("item", "item");
    }

    @Test
    public void findByIdReturnsCorrectItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("item1");
        Item secondItem = new Item("item2");
        tracker.add(firstItem);
        tracker.add(secondItem);
        Item foundItem = tracker.findById(firstItem.getId());
        assertThat(foundItem)
                .isNotNull()
                .isEqualTo(firstItem);
    }
}