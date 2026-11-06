package product;
import java.util.Objects;



//класс абстрактный потому что для разных наследников метод может изменяться и товар это вещь абстрактная
public abstract class Product {
	private String name;
	private String category;
	private double price;
	private int number;
	private double weight;

	public Product() { }

	public Product(String name, String category, double price, int number, double weight) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.number = number;
		this.weight = weight;
	}


	//Геттеры
	public String getName() { return this.name; }
	public String getCategory() { return this.category; }
	public double getPrice() { return this.price; }
	public int getNumber() { return this.number; }
	public double getWeight() { return this.weight; }

	//Сеттеры
	public void setName(String name) { this.name = name; }
	public void setCategory(String category) { this.category = category; }
	public void setPrice(double price) { this.price = price; }
	public void setNumber(int number) { this.number = number; }
	public void setWeight(double weight) { this.weight = weight; }


	public abstract double deliveryCost();

	//Скидка на товар рандомная
	public double randomDiscount() {
		double newprice = this.price - (this.price * ((Math.random() * 46) + 5)) / 100;
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

	@Override
	public int hashCode(){
		return Objects.hash(name, category, price, number, weight);
	}


	@Override
	public String toString(){
		return this.name + " " + this.category;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return this.name.equals(product.name)
				&& this.category.equals(product.category) && Double.compare(this.price, product.getPrice()) == 0 && Double.compare(this.weight, product.getWeight()) == 0 && this.number == product.getNumber();
	}

}