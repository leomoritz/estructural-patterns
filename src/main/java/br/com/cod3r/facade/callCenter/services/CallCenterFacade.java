package br.com.cod3r.facade.callCenter.services;

import br.com.cod3r.facade.callCenter.model.Card;
import br.com.cod3r.facade.callCenter.model.Register;

import java.util.List;

public class CallCenterFacade {

    private CardService cardService;
    private PaymentService paymentService;
    private RegisterService registerService;
    private ReportService reportService;
    private SecurityService securityService;

    public CallCenterFacade() {
        this.cardService = new CardService();
        this.registerService = new RegisterService();
        this.paymentService = new PaymentService(registerService);
        this.reportService = new ReportService(registerService);
        this.securityService = new SecurityService(cardService, registerService);
    }

    public Card orderNewCard(Long user, Long cardNumber) {
        return cardService.createNewCard(user, cardNumber);
    }

    public void cancelCard(Card card) {
        cardService.removeCard(card);
    }

    public List<Register> blockCard(Card card) {
        return securityService.blockCard(card);
    }

    public void printSummaryByCard(Card card) {
        reportService.getSumary(card);
    }

    public void printSummaryByUser(Long user) {
        Card card = getCardByUser(user);
        printPaymentInfoByCard(card);
    }

    public void printPaymentInfoByCard(Card card) {
        paymentService.getPaymentInfoByCard(card);
    }

    public void printPaymentInfoByUser(Long user) {
        Card card = getCardByUser(user);
        printPaymentInfoByCard(card);
    }

    public void addCardRegisters(Card card, List<Register> registers) {
        registerService.addCardRegisters(card, registers);
    }

    public Card getCardByUser(Long user) {
        Card card = cardService.getCardByUser(user);
        if (card == null) {
            throw new RuntimeException("This user informed don't have a card!");
        }
        return card;
    }

}
