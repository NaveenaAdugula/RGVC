package com.capgemini.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
public class AccountServiceImplTest {

	@Mock
	AccountRepository accountRepository;
	
	AccountService accountService;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImpl(accountRepository);
		
	}
	
	/*
	 * test cases for create account
	 * 1. when the amount is less than 500 system should generate exception
	 * 2. when the valid(101,5000) info is passed account should be created successfully
	 */
	
	
	@Test(expected=com.capgemini.exceptions.InsufficientInitialAmountException.class)
	public void whenTheAmountIsLessThanFiveHundredSystemShouldThrowException() throws InsufficientInitialAmountException
	{
		accountService.createAccount(101,400);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialAmountException
	{    
		
		Account account = new Account();
		
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(101, 5000));
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenTheDepositAmountIsInvalidSystemShouldThrowException() throws InvalidAccountNumberException{

		/*Account account = new Account();
		account.setAccountNumber(102);
		account.setAmount(5000);
		when(accountRepository.searchAccount(account.getAccountNumber())).thenReturn(account);
		assertEquals(account,a)*/
		accountService.depositAmount(102, 5000);
	}
	@Test
	public void whenDepositAmountISvalidSystemShouldBeDepositedSuccessfully() throws InvalidAccountNumberException{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accountRepository.searchAccount(account.getAccountNumber())).thenReturn(account);
		assertEquals(account,accountService.depositAmount(101,5000));
	}
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenWithdrawAccountNumberIsInvalidSystemShoulThrowException() throws InvalidAccountNumberException, InsufficientInitialAmountException, InsufficientBalanceException{
		accountService.withdrawAmount(103,3000);
	}
	@Test(expected=com.capgemini.exceptions.InsufficientInitialAmountException.class)
	public void whenWithdrawAmountIsLessThanFiveHunderedSystemShoulThrowException() throws InvalidAccountNumberException, InsufficientInitialAmountException, InsufficientBalanceException{
		accountService.withdrawAmount(101,400);
	}
	@Test(expected=com.capgemini.exceptions.InsufficientBalanceException.class)
	public void whenWithdrawAmountIsLessThanZeroSystemShoulThrowException() throws InvalidAccountNumberException, InsufficientInitialAmountException, InsufficientBalanceException{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(500);
		when(accountRepository.searchAccount(account.getAccountNumber())).thenReturn(account);
		assertEquals(account,accountService.withdrawAmount(101, 500));
	}
	
}
