package com.jpk.interfaces;

import com.jpk.exceptions.InvalidMessageException;

public interface MessageReceiver
{
    void receive(String message) throws InvalidMessageException;
}
