package br.com.cod3r.decorator.coffeeShop;

import br.com.cod3r.decorator.coffeeShop.model.Drink;
import br.com.cod3r.decorator.coffeeShop.model.Expresso;
import br.com.cod3r.decorator.coffeeShop.model.Tea;
import br.com.cod3r.decorator.coffeeShop.model.decorators.DoubleDrink;
import br.com.cod3r.decorator.coffeeShop.model.decorators.MilkAccompaniment;

public class Client {
	
	public static void order(String name, Drink drink) {
		System.out.println("Ordering a " + name);
		drink.serve();
		System.out.println(drink.getPrice());
		System.out.println("---------------");
	}

	public static void main(String[] args) {
		order("Expresso", new Expresso());
		order("Tea", new Tea());
		order("Expresso with milk", new MilkAccompaniment(new Expresso()));
		order("Double Tea", new DoubleDrink(new Tea()));
		order("Double Expresso with Milk", new DoubleDrink(new MilkAccompaniment(new Expresso())));
		order("Tea with milk", new MilkAccompaniment(new Tea()));
		
	}
}
