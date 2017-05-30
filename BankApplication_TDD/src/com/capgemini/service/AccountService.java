package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientInitialAmountException;

	

	Account depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException;



	Account withdrawAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InsufficientInitialAmountException, InsufficientBalanceException;

}