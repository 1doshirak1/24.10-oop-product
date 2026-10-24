package product;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// ООП: классы и объекты
		Product product1 = new Product(); // создали объект

		//сначала ПОЛУЧАЕМ значения в ОТДЕЛЬНЫЕ ПЕРЕМЕННЫЕ
		String name = inputName(scanner, "Enter name of the product!");
		String category = inputCategory(scanner, "Enter category of the product!");
		double price = inputPrice(scanner, "Enter the price!");
		int number = inputNumber(scanner, "Enter available quantity of the product!");
		double weight = inputWeight(scanner, "Enter weight of the product!");

		//затем ПЕРЕДАЕМ их в СЕТТЕРЫ
		product1.setName(name);
		product1.setCategory(category);
		product1.setPrice(price);
		product1.setNumber(number);
		product1.setWeight(weight);

		product1.printInfo();

		int newNumber = product1.selling(19);
		System.out.println("After selling amount: " + newNumber);

		double newPrice = product1.randomDiscount();
		System.out.println("Price with random discount: " + newPrice);

		double revenue = product1.revenue(19);
		System.out.println("Revenue: " + revenue);

		int restock = product1.restock(19);
		System.out.println("After restocking amount: " + restock);
	}

	public static double inputPrice(Scanner scanner, String message) {
		while (true) {
			System.out.println(message);
			double price = scanner.nextDouble();
			scanner.nextLine();
			if (price >= 0) {
				return price;
			}
			System.out.println("Enter correctly!");
		}
	}

	public static double inputWeight(Scanner scanner, String message) {
		while (true) {
			System.out.println(message);
			double weight = scanner.nextDouble();
			scanner.nextLine();
			if (weight > 0) {
				return weight;
			}
			System.out.println("Enter correctly!");
		}
	}

	public static String inputName(Scanner scanner, String message) {
		while (true) {
			System.out.println(message);
			String name = scanner.nextLine();
			if (!name.isEmpty()) {
				return name;
			}
			System.out.println("Enter correctly!");
		}
	}

	public static String inputCategory(Scanner scanner, String message) {
		while (true) {
			System.out.println(message);
			String category = scanner.nextLine();
			if (!category.isEmpty()) {
				return category;
			}
			System.out.println("Enter correctly!");
		}
	}

	public static int inputNumber(Scanner scanner, String message) {
		while (true) {
			System.out.println(message);
			int number = scanner.nextInt();
			scanner.nextLine();
			if (number >= 0) {
				return number;
			}
			System.out.println("Enter correctly!");
		}
	}
}
