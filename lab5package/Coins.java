package lab5package;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Coins {
    private String coinName[] = {"Quarters", "Dimes", "Nickels", "Pennies"};    // names of different coins
    private double coinValue[] = {0.25, 0.10, 0.05, 0.01};  // corresponding values of different coins
    
    public double insertCoins() {
        Scanner scanner = new Scanner(System.in);
        double total = 0;

        System.out.println("Please insert coins ^_^");
        double coin;
        
        for (int i = 0; i < 4; i++){
            while(true){
                try{
                System.out.print(coinName[i] + ": ");       // prompt the user to input the quantity of the specific coin
                coin = scanner.nextDouble();
                if (coin < 0){
                    throw new InputMismatchException();     // throw exception if negative value is entered
                } 
                total += coin * coinValue[i];
                break;  // breaks after successful input

                }catch (InputMismatchException e){          // handle the exception when non integer is input
                    System.out.println("Invalid coin.");
                    scanner.nextLine();     // clear input buffer
                }
            }
        }

        return total;
    }
}
