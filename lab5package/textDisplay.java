package lab5package;

public class textDisplay {
    public void printWelcomeBanner() {
        String[] welcomeBanner = {
            "============================",
            "        /\\        /\\",
            "     __/ \\\\______// \\_",
            "    /                 \\",
            "   /    D         D    \\",
            "  |  ```     W     ``` \t|",
            "  |  /// CATTO CAFE \\\\\\ |",
            "  |_____________________|",
            "\t\\__/   \\__/",
            "       == WELCOME ==",
            "============================"
        };

        for (String line : welcomeBanner) {
            System.out.println(line);
        }
    }

    public void printCoinChute(){
        String[] welcomeBanner = {
            "===",
            "| |",
            "| |",
            "| |",
            "==="
        };

        for (String line : welcomeBanner) {
            System.out.println(line);
        }
    }

    public void printCoffeeCup() {
        String[] coffeeCup = {
            "`      `",
            "``\t` `",
            " `_`____`__`_",
            "//__________ \\\\",
            "|             |",
            "|             |",
            "|  CATTO CAFE |",
            "|------W------|",
            "\\             /",
            " \\===========/",
            "  \\_________/"
        };

        for (String line : coffeeCup) {
            System.out.println(line);
        }
    }
}

        