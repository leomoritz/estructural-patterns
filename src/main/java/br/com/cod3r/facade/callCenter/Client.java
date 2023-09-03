package br.com.cod3r.facade.callCenter;

import java.util.List;

import br.com.cod3r.facade.callCenter.model.Card;
import br.com.cod3r.facade.callCenter.model.Register;
import br.com.cod3r.facade.callCenter.services.*;

public class Client {

	private static void withoutFacade() {
		CardService cardService = new CardService();
		RegisterService registerService = new RegisterService();
		ReportService reportService = new ReportService(registerService);
		PaymentService paymentService = new PaymentService(registerService);
		SecurityService securityService = new SecurityService(cardService, registerService);

		Card card = cardService.getCardByUser(123456L);
		System.out.println(card);

		reportService.getSumary(card);

		paymentService.getPaymentInfoByCard(card);

		//Remove last register, block the card e order a new one
		List<Register> registers = registerService.getRegistersByCard(card);
		registerService.removeByIndex(card, registers.size() - 1);
		List<Register> pendingRegisters = securityService.blockCard(card);
		Card newCard = cardService.createNewCard(123456L, 33445566L);
		registerService.addCardRegisters(newCard, pendingRegisters);
		reportService.getSumary(newCard);
	}

	private static void withFacade() {
		CallCenterFacade facade = new CallCenterFacade();
		Card card = facade.getCardByUser(123456L);
		System.out.println(card);

		facade.printSummaryByCard(card);
		facade.printPaymentInfoByCard(card);

		List<Register> pendingRegisters = facade.blockCard(card);

		Card newCard = facade.orderNewCard(1234L, 33445566L);
		facade.addCardRegisters(newCard, pendingRegisters);
		facade.printSummaryByUser(1234L);
		facade.printPaymentInfoByUser(1234L);
		facade.cancelCard(newCard);
		facade.getCardByUser(1234L); // deverá lançar uma exceção, porque o cartão foi cancelado na linha anterior.
	}

	public static void main(String[] args) {
		System.out.println("\n-------------------------- WITHOUT FACADE ----------------------------\n");
		withoutFacade();
		System.out.println("\n-------------------------- WITH FACADE ----------------------------\n");
		withFacade();
	}
}
