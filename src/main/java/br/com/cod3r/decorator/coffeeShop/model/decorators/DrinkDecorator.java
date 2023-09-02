package br.com.cod3r.decorator.coffeeShop.model.decorators;

import br.com.cod3r.decorator.coffeeShop.model.Drink;

public abstract class DrinkDecorator implements Drink {

    protected Drink drink;

    protected DrinkDecorator(Drink drink) {
        this.drink = drink;
    }
}