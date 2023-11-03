package lab5package;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Coins {
    private double coinValue[] = {0.25, 0.10, 0.05, 0.01};
    private String coinName[] = {"Quarters", "Dimes", "Nickels", "Pennies"};


    public double insertCoins() {
        Scanner scanner = new Scanner(System.in);
        double total = 0;

        System.out.println("Please insert coins ^_^");
        double coin;
        
        for (int i = 0; i < 4; i++){
            while(true){
                try{
                System.out.print(coinName[i] + ": ");
                coin = scanner.nextDouble();
                if (coin < 0){
                    throw new InputMismatchException();
                } 
                total += coin * coinValue[i];
                break;
                }catch (InputMismatchException e){
                    System.out.println("Invalid coin.");
                    scanner.nextLine();
                }
            }
        }

        return total;
    }
}
