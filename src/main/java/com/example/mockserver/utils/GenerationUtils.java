package com.example.mockserver.utils;

public class GenerationUtils {

    /**
     * Генератор случайных чисел от n до m (включая m)
     * @return int
     */
    public static int randomFromTo(int n, int m)
    {
        return n + (int)(Math.random() * (m - n));
    }


    /**
     * Метод генерирует случайнул латинскую букву верхнего регистра
     * @return char
     */
    public static char randomLatinUpperLetter() {
        return (char) randomFromTo(65, 90);
    }


    /**
     * Метод генерирует случайную
     * @param length
     * @return
     */
    public static String randomCharUpperSequence(final int length) {
        final StringBuffer sequence = new StringBuffer();
        for (int i = 0; i < length; i++) sequence.append(randomLatinUpperLetter());
        return sequence.toString();
    }
}
