package ecosystem.alfa;

import ecosystem.alfa.card.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankCard bankCard = null;

        System.out.println("Выберите тип банковской карты:");
        System.out.println("1. Дебетовая карта");
        System.out.println("2. Кредитная карта");
        System.out.println("3. Премиум дебетовая карта");
        System.out.println("4. Премиум кредитная карта");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                bankCard = new DebitCard(10000, 1);
                break;
            case 2:
                bankCard = new CreditCard(0, 10000, 1);
                break;
            case 3:
                bankCard = new PremiumDebitCard(10000, 1, 5, 5000);
                break;
            case 4:
                bankCard = new PremiumCreditCard(0, 10000, 1, 0.005);
                break;
            default:
                System.out.println("Неправильный выбор");
                return;
        }

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Оплатить");
            System.out.println("2. Пополнить");
            System.out.println("3. Получить информацию о балансе");
            System.out.println("4. Выход");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите сумму оплаты: ");
                    double amount = scanner.nextDouble();
                    if (bankCard.pay(amount)) {
                        System.out.println("Оплата успешна");
                    } else {
                        System.out.println("Недостаточно средств");
                    }
                    break;
                case 2:
                    System.out.print("Введите сумму пополнения: ");
                    amount = scanner.nextDouble();
                    bankCard.deposit(amount);
                    System.out.println("Пополнение успешно");
                    break;
                case 3:
                    System.out.println(bankCard.getInformation());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильный выбор");
            }
        }
    }
}