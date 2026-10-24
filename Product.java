package product;

public class Product {
	private String name;
	private String category;
	private double price;
	private int number;
	private double weight;

	//Геттеры
	public String getName() {
		return this.name;
	}

	public String getCategory() {
		return this.category;
	}

	public double getPrice() {
		return this.price;
	}

	public int getNumber() {
		return this.number;
	}

	public double getWeight() {
		return this.weight;
	}

	//Сеттеры
	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	//Всякие методы разные....

	//Скидка на товар рандомная
	public double randomDiscount() {
		double newprice = this.price - (this.price * ((Math.random() * 46) + 5))/100;
		return newprice;
	}

	//продаем товар
	public int selling(int amount) {
		if (this.number > 0 & amount < this.number) {
			this.number -= amount;
		}
		return this.number;
	}

	// ресток товара
	public int restock(int amount) {
		if (amount > 0) {
			this.number += amount;
			return this.number;
		} else {
			this.number += 0;
			return this.number;
		}
	}

	// выручка
	public double revenue(int amount) {
		if (amount != 0) {
			double money = amount * this.price;
			return money;
		} else {
			return 0;
		}
	}

	// кол-во доступного товара
	public String availability() {
		if (this.number == 0) {
			return "not available now";
		} else if (this.number <= 5) {
			return "product is running low";
		} else {
			return "product in stock";
		}
	}

	// вывод информейшн о товаре
	public void printInfo() {
		System.out.println("name: " + this.name);
		System.out.println("category: " + this.category);
		System.out.println("weight: " + this.weight);
		System.out.println("price: " + this.price);
		System.out.println("amount: " + this.number + " (" + availability() + ")");
	}
}
