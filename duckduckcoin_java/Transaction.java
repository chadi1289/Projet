package Duckchain;
import java.util.ArrayList;
import java.util.Random;


public class Transaction {
			public static ArrayList<Transaction> transaction = new ArrayList<Transaction>();
			private String source;
			private String destination ;
			private int value ; 
			static int random_value = 20 ; 
			public Transaction(String source , String destination, int value) {
				
				transaction.add(new Transaction(source , destination,value));
				
			}
					
			public static ArrayList<Transaction> getTransaction() {
				return transaction;
			}

			public String getSource() {
				return source;
			}

			public String getDestination() {
				return destination;
			}

			public int getValue() {
				return value;
			}

			public static int getRandom_value() {
				return random_value;
			}
