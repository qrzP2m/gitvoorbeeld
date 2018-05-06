import java.util.*;

public class Calculation {

	/*Het programma deed het in grote lijnen goed totdat ik de 'arithmetics' methoden (oa welcomeArith())
	toevoegde. Daarna vraagt het programma meerdere keren achter elkaar om input van de gebruiker.
	Ik begrijp niet goed waarom. Daardoor ben ik veel tijd verloren en zijn de methoden vanaf welcomeArith() niet volledig. */

	String type;
	

	Calculation() {
	}

	Calculation(String type) {
		this.type = type;
	}

	public static void main(String[] args) {

			welcome();
	}


	static void welcome() {
		System.out.println("Welcome to the program!");
		System.out.println("Would you like to perform arithmetics or conversion to decimal values?");
		System.out.println("Please type either 1 (arithmetics) or 2 (conversion).");
		
		Scanner arithmOrBase = new Scanner(System.in);
		int arithmBase = arithmOrBase.nextInt();
		//Hierna vraagt het programma een tweede keer om input. Ik begrijp niet waarom.
		if (arithmBase == 1) {
			Calculation calArith = new Calculation("arithmetics");
			calArith.welcomeArith();
		} else if (arithmBase == 2) {
			Calculation calBase = new Calculation("conversion");
			calBase.welcomeBase();
		}
	}

	void welcomeArith() {
	
		System.out.println("What sort of arithmetics would you like to perform?");
		System.out.println("Please type either 1 (subtraction) or 2 (addition).");
		
		Scanner arithmChoice = new Scanner(System.in);
		int arithmChoiceInput = arithmChoice.nextInt();
		if (arithmChoiceInput == 1) {
			Arithmetic arithmetic = new Arithmetic("subtraction");
			arithmetic.subtraction(1, 2); //Deze argumenten had ik via een Scanner ingevuld als ik meer tijd had.
		} else if (arithmChoiceInput == 2) {
			Arithmetic arithmetic = new Arithmetic("addition");
			arithmetic.addition(1, 2); //Deze argumenten had ik via een Scanner ingevuld als ik meer tijd had.
		}
	}

		
		Scanner baseChoice = new Scanner(System.in); 

		int decision = baseChoice.nextInt();
		
		Choice choice = new Choice(decision);
		


	void welcomeBase() {

		
		System.out.println("What sort of value would you like to convert to a decimal value?");
		System.out.println("Choose 1 for binary, 2 for octal or 3 for hexadecimal.");

		
		Scanner baseChoice = new Scanner(System.in); 

		int decision = baseChoice.nextInt();
		
		Choice choice = new Choice(decision);
		
		try {
			choiceOption(choice);
		} catch (InvalidValueException e) {
			System.out.println("That is not a valid value.");
		}
	
	}	
		
		
	void choiceOption(Choice choice) throws InvalidValueException {
		if(choice.baseChoice == 1) {
			System.out.println("You choose binary to decimal.");
			BinaryVal binaryVal = new BinaryVal();
			binaryVal.binaryInput(binaryVal);
		} else if (choice.baseChoice == 2) {
			System.out.println("You choose octal to decimal.");
			OctalVal octalVal = new OctalVal();
			octalVal.octalInput(octalVal);
		} else if (choice.baseChoice == 3) {
			System.out.println("You choose hexadecimal to decimal.");
			HexaDecVal hexaDecVal = new HexaDecVal();
			hexaDecVal.hexaDecInput(hexaDecVal);
		} else {
			throw new InvalidValueException();
		}
	}
					

}

class Arithmetic implements Value {

	int answer;

	String type;

	Arithmetic(int answer) {
		this.answer = answer;
	}
	
	Arithmetic(String type) {
		this.type = type;
	}

	Value addition(int x, int y) {
		int sum = (x + y);
		System.out.println("The sum of " + x + " and " + y + " is " + sum + ".");
		Arithmetic arithmAdd = new Arithmetic(sum);
		return arithmAdd;
	} 

	Value addition(int x, int y, int z) {
		int sum = (x + y);
		System.out.println("The sum of " + x + ", " + z + " and " + y + " is " + sum + ".");
		Arithmetic arithmAdd = new Arithmetic(sum);
		return arithmAdd;
	} 

	Value addition(int x, int y, int z, int w) {
		int sum = (x + y);
		System.out.println("The sum of " + x + ", " + z + ", " + w + " and " + y + " is " + sum + ".");
		Arithmetic arithmAdd = new Arithmetic(sum);
		return arithmAdd;
	} 

	Value subtraction(int x, int y) {
		int minus = (x - y);
		System.out.println("The subtraction of " + x + " and " + y + " is " + minus + ".");
		Arithmetic arithmAdd = new Arithmetic(minus);
		return arithmAdd;
	}	

	Value subtraction(int x, int y, int z) {
		int minus = (x - y);
		System.out.println("The subtraction of " + x + ", " + z + " and " + y + " is " + minus + ".");
		Arithmetic arithmAdd = new Arithmetic(minus);
		return arithmAdd;
	}

	

}

interface Value { 

	int numbers = 0;
	
}

class BinaryVal implements Value {

	int numbers;
	
	int decNumbers;

	int decOutput;

	List<Integer> binaryList;

	Value binaryInput(BinaryVal binaryVal) {

		//System.out.println("Please input the binary number."); 
		Scanner valInput = new Scanner(System.in); 

		List<Integer> binaryList = new ArrayList<Integer>();
		System.out.println("Please input the binary numbers one at a time.");
		
		int input = valInput.nextInt();
		if (input == 0 || input == 1) {
			binaryList.add(input);
		} else {
			System.out.println("Please input either a zero or a one.");
			binaryList.add(input);
		}

		int input2 = valInput.nextInt();	
		binaryList.add(input2);

		int input3 = valInput.nextInt();	
		binaryList.add(input3);

		int input4 = valInput.nextInt();	
		binaryList.add(input4);

		System.out.println("Your chosen binary number is: " + binaryList.get(0) + binaryList.get(1) + binaryList.get(2) + binaryList.get(3));

		binaryVal.numbers = input;
		
		try {
			binaryCalc(binaryList);
		} catch (InvalidValueException e) {
			System.out.println("Decimal values can not be less than zero.");
		}
		
		return binaryVal;	
	}


		Value binaryCalc(List<Integer> binaryList) throws InvalidValueException {

		decNumbers = ((binaryList.get(0) * 1) + (binaryList.get(1) * 2) + (binaryList.get(2) * 4) + (binaryList.get(3) * 8));

		DecVal decVal = new DecVal(decNumbers); 
		System.out.println("This results in a decimal value of " + decVal.decNumbers + ".");
		return decVal;
	}	
}

class DecVal implements Value {

	int decNumbers;
	int decOutput;

	DecVal() {
	}

	DecVal(int decNumbers) throws InvalidValueException {
		this.decNumbers = decNumbers;
		if (decNumbers < 0) {
			throw new InvalidValueException();
		}
	}

		
	
		
}

class OctalVal implements Value {

	int decNumbers;
	
	Value octalInput(OctalVal octalVal) {

		Scanner valInput = new Scanner(System.in); 

		List<Integer> octalList = new ArrayList<Integer>();
		System.out.println("Please input the octal numbers one at a time.");
		
		
		int input = valInput.nextInt();
		if (input > 0 & input <= 7) {
			octalList.add(input);
		} else {
			System.out.println("Please input a number between 0 and 7.");
			octalList.add(input);
		}

		int input2 = valInput.nextInt();	
		octalList.add(input2);

		int input3 = valInput.nextInt();	
		octalList.add(input3);

		int input4 = valInput.nextInt();	
		octalList.add(input4);

		System.out.println("Your chosen octal number is: " + octalList.get(0) + octalList.get(1) + octalList.get(2) + octalList.get(3));

		//octalList.numbers = input;

		try {
			octalCalc(octalList, octalVal);
		} catch (InvalidValueException e) {
			System.out.println("Decimal values can not be less than zero.");
		}

		return octalVal;

	}

	Value octalCalc(List<Integer> octalList, OctalVal octalVal)  throws InvalidValueException {
		
		decNumbers = ((octalList.get(0) * 1) + (octalList.get(1) * 8) + (octalList.get(2) * 64) + (octalList.get(3) * 512));

		DecVal decVal = new DecVal(decNumbers); 
		
		System.out.println("This results in a decimal value of " + decVal.decNumbers);

		return decVal;

	}	

}

class HexaDecVal implements Value {
		
	int decNumbers;
	
	Value hexaDecInput(HexaDecVal hexaDecVal) {

		Scanner valInput = new Scanner(System.in); 

		List<Integer> hexaDecList = new ArrayList<Integer>();
		System.out.println("Please input the hexadecimal numbers and characters one at a time.");
		
		String s = null;

		int input = valInput.nextInt();
		String strInput = valInput.nextLine();
		
		if (strInput.matches("//d+")) {			
				if(input == 0) {
					int number0 = 0;
					hexaDecList.add(number0);
				} else if(input == 1) {
					int number1 = 1;
					hexaDecList.add(number1);
				} else if (input == 2) {
					int number2 = 2;
					hexaDecList.add(number2);
				} else if (input == 3) {
					int number3 = 3;
					hexaDecList.add(number3);
				} else if (input == 4) {
					int number4 = 4;
					hexaDecList.add(number4);
				} else if (input == 5) {
					int number5 = 5;
					hexaDecList.add(number5);
				} else if (input == 6) {
					int number6 = 6;
					hexaDecList.add(number6);
				} else if (input == 7) {
					int number7 = 7;
					hexaDecList.add(number7);
				} else if (input == 8) {
					int number8 = 8;
					hexaDecList.add(number8);
				} else if (input == 9) {
					int number9 = 9;
					hexaDecList.add(number9); }
		
		//Het else if {} gedeelte hieronder werkt niet. Ik begrijp niet goed waarom dit niet werkt.
		//Het invoeren van een getal werkt verder wel goed. 	
		} else if (!strInput.matches("//d+")) { 
			if (strInput == "A") {
				int A = 10;
				hexaDecList.add(A);
			} else if (strInput == "B") {
				int B = 11;
				hexaDecList.add(B);
			} else if (strInput == "C") {
				int C = 12;
				hexaDecList.add(C);
			} else if (strInput == "D") {
				int D = 13;
				hexaDecList.add(D);
			} else if (strInput == "E") {
				int E = 14;
				hexaDecList.add(E);
			} else if (strInput == "F") {
				int F = 15;
				hexaDecList.add(F);
			}
			
		}
						


		System.out.println("Your chosen hexadecimal number is: " + hexaDecList.get(0) + hexaDecList.get(1) + hexaDecList.get(2) + hexaDecList.get(3));

		//octalList.numbers = input;

		try {
			hexaDecCalc(hexaDecList, hexaDecVal);
		} catch (InvalidValueException e) {
			System.out.println("Decimal values can not be less than zero.");
		}

		return hexaDecVal;
	}



	Value hexaDecCalc(List<Integer> hexaDecList, HexaDecVal hexaDecVal) throws InvalidValueException {


		decNumbers = ((hexaDecList.get(0) * 1) + (hexaDecList.get(1) * 16) + (hexaDecList.get(2) * 256) + (hexaDecList.get(3) * 4096));
		DecVal decVal = new DecVal(decNumbers); 
		
		System.out.println("This results in a decimal value of " + decVal.decNumbers);
		
		return decVal;

	}
}	

class Choice {
	
	int baseChoice;

	Choice() {
	}

	Choice(int baseChoice) {
		this.baseChoice = baseChoice;
	}
	

}

class InvalidValueException extends Exception {}
