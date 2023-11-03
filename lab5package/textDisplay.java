package lab5package;
public class TextDisplay {
    public void printWelcomeBanner() {
        System.out.printf(
            "=======================\n" + 
            "      /\\        /\\\n" + 
            "   __/ \\\\______// \\\n" + 
            "  /                 \\\n" + 
            " /    D         D    \\\n" + 
            "|  ```     W     ```  |\n" + 
            "|  /// CATTO CAFE \\\\\\ |\n" + 
            "|_____________________|\n" + 
            "       \\__/   \\__/\n" + 
            "     == WELCOME ==\n" + 
            "What would you like?\n" + 
            "======================\n" + 
            "|   Drink   |  Price |\n" + 
            "----------------------\n" + 
            "| Espresso  |  $1.5  |\n" + 
            "|   Latte   |  $3.0  |\n" +
            "|Cappuccino |  $2.5  |\n" + 
            "=======================\n"
        );
    }

    public void printCoinChute(){
        System.out.printf(
            "===\n" + 
            "| |\n" + 
            "| |\n" + 
            "| |\n" + 
            "===\n"
        );
    }

    public void printCoffeeCup() {
        System.out.printf(
            "`      `\n" +
            "``     ` `\n" + 
            " `_`____`__`_\n" + 
            "//__________ \\\\\n" + 
            "|             |\n" + 
            "|             |\n" + 
            "|  CATTO CAFE |\n" +
            "|------W------|\n" +
            "\\             /\n" +
            " \\===========/\n" +
            "  \\_________/\n"
        );
    }
}

        