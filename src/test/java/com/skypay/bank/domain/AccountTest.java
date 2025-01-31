package com.skypay.bank.domain;


import com.skypay.bank.infrastructure.DateProvider;
import com.skypay.bank.ui.StatementPrinter;
import org.junit.Test;

import static org.mockito.Mockito.*;

class AccountTest {

    @Test
    void testPrintStatement() {
        // Given: Création des mocks pour DateProvider et StatementPrinter
        DateProvider dateProvider = mock(DateProvider.class);
        StatementPrinter statementPrinter = mock(StatementPrinter.class);

        // Simulation des dates
        when(dateProvider.getCurrentDate())
                .thenReturn("10/01/2012")
                .thenReturn("13/01/2012")
                .thenReturn("14/01/2012");

        // Création d'un compte avec les mocks
        Account account = new Account(dateProvider, statementPrinter);

        // When: Effectuer les dépôts et un retrait
        account.deposit(1000);  // Dépôt de 1000
        account.deposit(2000);  // Dépôt de 2000
        account.withdraw(500);  // Retrait de 500

        // Then: Vérification que la méthode print a été appelée avec les bonnes transactions
        account.printStatement();

        // On vérifie si la méthode print() a bien été appelée
        // Le test échouera ici car printStatement() n'est pas encore implémenté
        verify(statementPrinter).print(anyList());
    }
}
