package br.com.cod3r.decorator.coffeeShop.model.decorators;

import br.com.cod3r.decorator.coffeeShop.model.Drink;
import br.com.cod3r.decorator.coffeeShop.model.Milk;

public class MilkAccompaniment extends DrinkDecorator {

    private Milk milk;
    public MilkAccompaniment(Drink drink) {
        super(drink);
        this.milk = new Milk();
    }

    @Override
    public void serve() {
        drink.serve();
        milk.serve();
    }

    @Override
    public Double getPrice() {
        return drink.getPrice() + milk.getPrice();
    }
}
