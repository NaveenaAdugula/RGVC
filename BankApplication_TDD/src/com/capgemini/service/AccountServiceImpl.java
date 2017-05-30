package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(int accountNumber,int amount)throws InsufficientInitialAmountException
	{
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
			}
	@Override
	public Account depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException{
		Account account=new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		if(accountNumber!=101){
			throw new InvalidAccountNumberException();
		}
		if(accountRepository.searchAccount(accountNumber) != null){
			return account;
		}
		return null;
	}
	@Override
	public Account withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientInitialAmountException, InsufficientBalanceException{
		if(accountNumber!=101){
			throw new InvalidAccountNumberException();
		}
		Account account=new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		if(accountRepository.searchAccount(accountNumber)!=null){
			return account;
		}
		if(account.getAmount()>=0 &&account.getAmount()<=500 ){
			throw new InsufficientInitialAmountException();
		}
		if(account.getAmount()<=0 && account.getAmount()<=500){
			throw new InsufficientBalanceException();
		}
		return null;
	}

}
