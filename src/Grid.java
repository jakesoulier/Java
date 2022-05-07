import java.util.*;

import javax.lang.model.element.VariableElement;

class Grid {

    // static void hiddenList(ArrayList hidden_grid) {
    //     for (int i = 0; i < 10; i++ ){
    //         hidden_grid.set(i, "_");
    //     }

    // }

    // static int guess(Integer first_guess) {
    //     Scanner myObj = new Scanner(System.in);
    //     System.out.println("Guess: ");
    //     first_guess = myObj.nextInt();
    //     return first_guess;
    // }

    public static void main(String[] args)
    {
        ArrayList grid = new ArrayList();
        Scanner myObj = new Scanner(System.in);
        for (char c = 'f'; c < 'k'; c++){
            grid.add(c);
            grid.add(c);
        }
        Collections.shuffle(grid);
        ArrayList hidden_grid = new ArrayList();
        for (int i = 0; i < 10; i++ ){
            hidden_grid.add("_");
        }
        boolean playGame = true;
        while(playGame) {

            System.out.println(hidden_grid);
            // System.out.println(grid);
            // String letters = String.join("-", grid);
            // System.out.println(Arrays.toString(hidden_grid.toArray()));
            // hidden_grid.forEach(System.out::println);
            // System.out.println(letters);

            System.out.println("Guess a position(1-10): ");
            int first_guess = myObj.nextInt();
            int first_guess_edi = first_guess - 1;
            Object firstGuess = grid.get(first_guess_edi);
            Object firstGuessHidden = hidden_grid.get(first_guess_edi);
            // firstGuess = grid.get(2);
            // System.out.println(firstGuess);
            Object firstGuessNew = "_";

            while(firstGuessHidden != "_"){
                System.out.println("That was already guess, Guess again: ");
                first_guess = myObj.nextInt();
                first_guess_edi = first_guess - 1;
                firstGuessNew = grid.get(first_guess_edi);
                System.out.println("firstGuessNew in while check loop: " + firstGuessNew);
                firstGuessHidden = hidden_grid.get(first_guess_edi);

            }
//            System.out.println("firstGuessGrid: " + firstGuess);
//            System.out.println("firstGuessHidden: " + firstGuessHidden);
            // Integer first_guess = 1;
            // guess(first_guess);
            // System.out.println(first_guess);

            hidden_grid.set(first_guess_edi, grid.get(first_guess_edi));
            System.out.println(hidden_grid);

            System.out.println("Guess another position: ");
            int second_guess = myObj.nextInt();
            int second_guess_edi = second_guess - 1;
            Object secondGuess = grid.get(second_guess_edi);
            hidden_grid.set(second_guess_edi, secondGuess);

            if (firstGuess != secondGuess){
                System.out.println("wrong guess");
                System.out.println(hidden_grid);
                // firstGuessNew.toString();
                // System.out.println(firstGuessNew);
                String firstGuessNewStr = String.valueOf(firstGuessNew);
                System.out.println("firstGuessNewStr: " + firstGuessNewStr);
                if (firstGuessNewStr == "_") {
                    hidden_grid.replaceAll(s -> (s == secondGuess || s == firstGuess) ? "_" : s);

                } else
                    hidden_grid.replaceAll(s -> (s == secondGuess || s == firstGuessNewStr) ? "_" : s);
                    //hidden_grid.replaceAll(s -> (s == secondGuess) ? "_" : s);
                    System.out.println("secondGuess: " + secondGuess);
                    //hidden_grid.replaceAll(s -> (s == firstGuessNewStr) ? "_" : s);
                    System.out.println("firstGuessNewStr: " + firstGuessNewStr);
                System.out.println(hidden_grid);
                // hidden_grid.replaceAll(s -> s == secondGuess ? "_" : s);

                // hidden_grid.replaceAll(s -> (s == secondGuess || s == firstGuess  || s == firstGuessNew) ? "_" : s);hidden_grid.replaceAll(s -> (s == secondGuess || s == firstGuess  || s == firstGuessNew) ? "_" : s);

                System.out.println("Wanna try again? (y/n): ");
                String anotherGuess = myObj.next();
                if (anotherGuess.equals("n")){
                    System.out.println("Game Over");
                    playGame = !playGame;
                }
            } else{
                System.out.println("you guess correctly");
                System.out.println("You got a match!");
                if (hidden_grid.contains("_")){
                    ;
                } else{
                    playGame = !playGame;
                    System.out.println("You won!");
                }
            }
        }
    }
}
