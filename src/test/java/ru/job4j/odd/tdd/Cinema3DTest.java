package ru.job4j.odd.tdd;

import org.junit.jupiter.api.Disabled;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class Cinema3DTest {

    /* 1. Проверяем, что при покупке билета метод buy возвращает корректный Ticket. */
    @Disabled
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    /* 2. Проверяем, что при добавлении новой сессии (add) она появляется в списке (find). */
    @Disabled
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    /* 3. Если передать некорректный ряд (row = -1), должен вылететь IllegalArgumentException. */
    @Disabled
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* 4. Проверяем, что нельзя купить билет на несуществующий (не добавленный) сеанс.  */
    @Disabled
    public void whenBuyTicketForNonExistentSessionThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        /* Не добавляем никакие сеансы */
        Calendar date = Calendar.getInstance();
        date.set(2025, Calendar.MARCH, 25);
        assertThatThrownBy(() -> cinema.buy(account, 10, 10, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* 5. Проверяем, что нельзя купить билет на дату, которая уже прошла. */
    @Disabled
    public void whenBuyTicketOnPastDateThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        /* Добавим хотя бы один сеанс */
        Session session = new Session3D();
        cinema.add(session);
        /* Укажем дату в прошлом */
        Calendar pastDate = Calendar.getInstance();
        pastDate.set(2020, Calendar.JANUARY, 1);

        assertThatThrownBy(() -> cinema.buy(account, 1, 1, pastDate))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* 6. Проверяем, что нельзя купить билет на уже занятое место. */
    @Disabled
    public void whenBuyTicketOnOccupiedSeatThenException() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2025, Calendar.MARCH, 25);
        /* Первый пользователь покупает место (1,1) */
        Ticket ticket1 = cinema.buy(account1, 1, 1, date);
        assertThat(ticket1).isNotNull();
        /* Второй пользователь пытается купить то же самое место */
        assertThatThrownBy(() -> cinema.buy(account2, 1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* 7. Проверяем покупку нескольких мест подряд (1,1), (1,2), (1,3). */
    @Disabled
    public void whenBuyMultipleTicketsThenSuccessForAll() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2025, Calendar.MARCH, 25);
        int[][] seats = {
                {1, 1},
                {1, 2},
                {1, 3}
        };
        for (int[] seat : seats) {
            Ticket ticket = cinema.buy(account, seat[0], seat[1], date);
            assertThat(ticket).isNotNull();
        }
    }

    /*8. Проверяем, что нельзя купить билет, передав null вместо аккаунта. */
    @Disabled
    public void whenBuyWithNullAccountThenException() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2025, Calendar.MARCH, 25);
        assertThatThrownBy(() -> cinema.buy(null, 1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

}