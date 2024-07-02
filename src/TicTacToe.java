/*
Autor: Patrick Wiedenmann
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    //  Main Variables
    static char symbol;
    static int eingabe;
    static String player1 = "";
    static String player2 = "";
    static char[][] felder = new char[][] { { '-', '-', '-' }, { '-', '-', '-', }, { '-', '-', '-' } };
    static Scanner scanner = new Scanner(System.in);

    static void spielBeenden() {

        System.out.println("GAME OVER" + "");
        System.exit(0);
    }
    // This method checks trough  a loop if a player filled up the fields in order to win
    static void gewonnen(String player) {

        char symbol;
        if (player == player1) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }

        for (int i = 0; i < 3; i++) {
            if (felder[i][0] == symbol && felder[i][1] == symbol && felder[i][2] == symbol) {
                System.out.println("Winner");
                spielBeenden();
            }
            if (felder[0][i] == symbol && felder[1][i] == symbol && felder[2][i] == symbol) {
                System.out.println("Winner");
                spielBeenden();
            }
        }

        if (felder[0][0] == symbol && felder[1][1] == symbol && felder[2][2] == symbol) {
            System.out.println("Winner");
            spielBeenden();
        }
        if (felder[0][2] == symbol && felder[1][1] == symbol && felder[2][0] == symbol) {
            System.out.println("Winner");
            spielBeenden();
        }
    }
    //This  method checks if a field is already occupied using a boolean
    static boolean belegtesFeldPrüfen(int i, int j, String player) {

        if (felder[i][j] == 'X' || felder[i][j] == 'O') {
            System.out.println("Feld schon belegt");
            spielSteineSetzen(player);
            return false;
        }
        return true;
    }
    //Here method is used in loop to assign one of two symbols to be used for each player
    static void spielSteineSetzen(String player) {

        if (player == player1) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }

        {

            while (true) {
                try {               //Try catch loop allows only certain commands to be used
                    while (true) {

                        eingabe = scanner.nextInt();

                        if (eingabe < 1 || eingabe > 9) {
                            System.out.println("Falsche Eingabe");
                        } else {
                            break;
                        }
                    }
                    break;

                } catch (InputMismatchException e) {  //Exception  doesen't allow numbers  as players name
                    System.out.println("Falsche eingabe");
                    scanner.next();
                    continue;
                }

            }

            switch (eingabe) {//switch case sets the right symbol for each player to be used as input for a given field
                case 1:
                    if (belegtesFeldPrüfen(0, 0, player) == false) {   //loop check if field already occupied  is
                        break;
                    }
                    felder[0][0] = symbol;
                    break;
                case 2:
                    if (belegtesFeldPrüfen(0, 1, player) == false) {
                        break;
                    }
                    felder[0][1] = symbol;
                    break;
                case 3:
                    if (belegtesFeldPrüfen(0, 2, player) == false) {
                        break;
                    }
                    felder[0][2] = symbol;
                    break;
                case 4:
                    if (belegtesFeldPrüfen(1, 0, player) == false) {
                        break;
                    }
                    felder[1][0] = symbol;
                    break;
                case 5:
                    if (belegtesFeldPrüfen(1, 1, player) == false) {
                        break;
                    }
                    felder[1][1] = symbol;
                    break;
                case 6:
                    if (belegtesFeldPrüfen(1, 2, player) == false) {
                        break;
                    }
                    felder[1][2] = symbol;
                    break;
                case 7:
                    if (belegtesFeldPrüfen(2, 0, player) == false) {
                        break;
                    }
                    felder[2][0] = symbol;
                    break;
                case 8:
                    if (belegtesFeldPrüfen(2, 1, player) == false) {
                        break;
                    }
                    felder[2][1] = symbol;
                    break;
                case 9:
                    if (belegtesFeldPrüfen(2, 2, player) == false) {
                        break;
                    }
                    felder[2][2] = symbol;
                    break;
            }

        }
    }
    //This method is responsible for printing the game board in console
    static void spielfeldAnzeigen() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(felder[i][j]);
            }
            System.out.println();
        }

    }
//This method is using loops to check if : accurate symbols are used for name,  if name is correct length and to set the players name using Scanner.

    static String name() {

        String spieler = "";

        spieler = scanner.nextLine().toLowerCase();
        while (spieler.length() < 3) {
            System.out.println("Name ist zu kurz, bitte nur 3 Buchstaben verwenden.");
            spieler = scanner.nextLine().toLowerCase();
        }

        while (spieler.matches(".*\\d.*") || spieler.length() < 3) {
            System.out.println("Zahlen gefunden bzw. zu kurz (min. 3 Zeichen), bitte nochmal eingeben.");
            spieler = scanner.nextLine().toLowerCase();
        }

        while (player1.toLowerCase().equals(spieler) == true) {

            System.out.println("Biite andere Name auswächen");
            spieler = scanner.nextLine().toLowerCase();

            while (spieler.length() < 3 || spieler.matches(".*\\d.*")) {
                System.out.println("Name ist zu kurz, bitte nur 3 Buchstaben verwenden.");
                spieler = scanner.nextLine().toLowerCase();
            }

            while (spieler.matches(".*\\d.*") || spieler.length() < 3) {
                System.out.println("Zahlen gefunden bzw. zu kurz (min. 3 Zeichen), bitte nochmal eingeben.");
                spieler = scanner.nextLine().toLowerCase();
            }
        }

        return spieler = spieler.substring(0, 1).toUpperCase() + spieler.substring(1).toLowerCase();
    }

    public static void main(String[] args) {

        System.out.println("Herzlich willkommen zum TICTACTOE spiel");
        System.out.println("Bitte ihre Name eingeben für Spieler 1");

        player1 = name();
        System.out.println("Bitte ihre Name eingeben für Spieler 2");
        player2 = name();
        System.out.println("Spieler 1 heist: " + player1);
        System.out.println("Spieler 2 heist :" + player2);

        System.out.println();
        spielfeldAnzeigen();

        int reinfolge = 2;
        int durchgänge = 0;
        while (durchgänge < 9) {

            if (reinfolge % 2 == 0) {
                System.out.println("Spieler " + player1 + " ist dran!");
                spielSteineSetzen(player1);
                spielfeldAnzeigen();
                gewonnen(player1);
                System.out.println();
                reinfolge++;
                durchgänge++;
            } else {
                System.out.println("Spieler " + player2 + " ist dran!");
                spielSteineSetzen(player2);
                spielfeldAnzeigen();
                gewonnen(player2);
                System.out.println();
                durchgänge++;
                reinfolge++;

            }
        }
        System.out.println(("Unentschieden"));
    }
}