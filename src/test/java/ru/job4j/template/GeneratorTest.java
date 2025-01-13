package ru.job4j.template;

import org.junit.jupiter.api.Disabled;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeneratorTest {

    @Disabled
    void whenAllKeysPresentAndNoExtraKeysThenSuccess() {
        Generator generator = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );
        String expected = "I am a Petr Arsentev, Who are you?";
        String result = generator.produce(template, args);
        assertEquals(expected, result);
    }

    @Disabled
    void whenKeyMissingInMapThenThrowException() {
        Generator generator = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "", "you"
        );
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> generator.produce(template, args)
        );
        assertEquals("Missing key: subject", exception.getMessage());
    }

    @Disabled
    void whenExtraKeyInMapThenThrowException() {
        Generator generator = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "extra", "value"
        );
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> generator.produce(template, args)
        );
        assertEquals("Extra key found: extra", exception.getMessage());
    }

    @Disabled
    void whenMapIsEmptyThenThrowException() {
        Generator generator = new MyGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of();

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> generator.produce(template, args)
        );

        assertEquals("Missing key: name", exception.getMessage());
    }
}