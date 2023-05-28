package codeacademy.learnintermediatejava.projecttakeoutsystem;

public interface IntUserInputRetriever<T> {

	  public T produceOutputOnIntUserInput(int selection) throws IllegalArgumentException;

	}