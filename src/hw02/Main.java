package hw02;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

/**
 * Дз по второму семинару
 */

public class Main {
    private static Scanner in;

    static double readDoubleValue(String msg) {
        Double value = null;
        do {
            System.out.println(msg);
            String input = in.nextLine();
            try {
                value = Double.parseDouble(input);
            } catch (Exception ex) {
                System.out.println("ошибка ввода");
            }
        } while (value == null);

        return value;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        in = new Scanner(System.in);


        {
            double kms = readDoubleValue("введите км: ");
            Optional<Double> milesFromKms = KmsAndMiles.kms2miles(kms);
            if (milesFromKms.isPresent()) {
                System.out.printf("%.3f км = %.3f миль\n",
                        kms, milesFromKms.get());
            } else {
                System.out.println("неверный аргумент");
            }
        }
        {
            double miles = readDoubleValue("введите мили: ");
            Optional<Double> kmsFromMiles = KmsAndMiles.miles2kms(miles);
            if (kmsFromMiles.isPresent()) {
                System.out.printf("%.3f миль = %.3f км\n",
                        miles, kmsFromMiles.get());
            } else {
                System.out.println("неверный аргумент");
            }
        }


        {
            double celsius = readDoubleValue("введите градусы по Цельсию: ");
            Optional<Double> fahrenheitFromCelsius = CelsiusAndFahrenheit.celsius2fahrenheit(celsius);
            if (fahrenheitFromCelsius.isPresent()) {
                System.out.printf("%.3f градусов по Цельсию = %.3f градусов по Фаренгейту\n",
                        celsius, fahrenheitFromCelsius.get());
            } else {
                System.out.println("неверный аргумент");
            }
        }
        {
            double fahrenheit = readDoubleValue("введите градусы по фаренгейту: ");
            Optional<Double> celsiusFromFahrenheit = CelsiusAndFahrenheit.fahrenheit2Celsius(fahrenheit);
            if (celsiusFromFahrenheit.isPresent()) {
                System.out.printf("%.3f градусов по Фаренгейту = %.3f градусов по Цельсию\n",
                        fahrenheit, celsiusFromFahrenheit.get());
            } else {
                System.out.println("неверный аргумент");
            }
        }

    }
}


class KmsAndMiles {
    private static final double KMS_IN_MILE = 1.60934D;

    static Optional<Double> kms2miles(double kms) {
        if (kms < 0) {
            return Optional.empty();
        }
        return Optional.of(kms / KMS_IN_MILE);
    }

    static Optional<Double> miles2kms(double miles) {
        if (miles < 0) {
            return Optional.empty();
        }
        return Optional.of(miles * KMS_IN_MILE);
    }
}


class CelsiusAndFahrenheit {
    static Optional<Double> celsius2fahrenheit(double celsius) {
        return Optional.of(celsius * 9 / 5 + 32);
    }

    static Optional<Double> fahrenheit2Celsius(double fahrenheit) {
        return Optional.of((fahrenheit - 32) * 5 / 9);
    }
}