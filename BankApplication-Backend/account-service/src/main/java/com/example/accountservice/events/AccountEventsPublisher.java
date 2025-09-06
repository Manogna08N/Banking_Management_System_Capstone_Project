package com.example.accountservice.events;

import com.example.accountservice.entity.Account;

public interface AccountEventsPublisher {
	 void publishAccountOpened(Account account);

}
