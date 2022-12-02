/**
 * The Wordle class represents a game where the user goes guesses words and is informed of which letters are wrong or right.
 */

public class Wordle {
    /** This is the player's name */
    private String name;
    /** This is the answer players will try to get */
    private String answer;
    /** This is the mode/hardness that the players selected */
    private String level;
    /** This is the amount of guesses players have taken until they get to the answer */
    private int guesses = 0;
    /** This is the amount of points players obtained from playing */
    private int points = 0;

    /** Default constructor that initializes the level to the easiest mode and their name to UNKNOWN */
    public Wordle() {
        level = "EASY";
        name = "UNKNOWN";
    }

    /** Two parameter constructor that initializes their level and name to their preference */
    public Wordle(String name, int mode) {
        this.name = name;
        if (mode == 1) {
            level = "EASY";
        } else if (mode == 2) {
            level = "MEDIUM";
        } else {
            level = "HARD";
        }
    }

    /** Gets the answer through chance (selection depends on level)
     @return String - the answer
     */
    public String wordRandomizer() {
        int num = (int) (Math.random() * 3) + 1;

        if (level.equals("EASY")) { /* 4-letter words */
            if (num == 1) {
                answer = "fast";
            } else if (num == 2) {
                answer = "stat";
            } else {
                answer = "bunt";
            }
        } else if (level.equals("MEDIUM")) { /* 5-letter words */
            if (num == 1) {
                answer = "viper";
            } else if (num == 2) {
                answer = "corny";
            } else {
                answer = "study";
            }
        } else { /* 6-letter words */
            if (num == 1) {
                answer = "throne";
            } else if (num == 2) {
                answer = "online";
            } else {
                answer = "acting";
            }
        }

        return answer;
    }

    /** Single parameter method that decides if the player's guess is correct
     @param guess - user's input/attempt
     @return boolean - true if guess is equal to answer
     */
    public boolean check(String guess) {
        guess = guess.toLowerCase();
        if (guess.equals(answer)) {
            return true;
        } else {
            return false;
        }
    }

    /** Increases the amount of guesses the player has taken */
    public void plusGuess() {
        guesses++;
    }

    /** Double parameter method that will count how many times a given letter appears in a string
     @param letter - letter that is being searched for
     @param str - String that is being searched through
     */
    public int counter(String str, String letter) {
        int count = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            if (str.substring(idx, idx + 1).equals(letter)) {
                count++;
            }
        }
        return count;
    }

    /** Single parameter method that identifies which of the letters that are green, yellow, or gray in a player's guess
     @param guess - user's input/attempt
     */
    public void letterCheck(String guess) {
        guess = guess.toLowerCase();
        String tempA = answer;
        String gray = "";
        String yellow = "";
        String green = "";

        for (int idx = 0; idx < guess.length(); idx++) {
            String letter = guess.substring(idx, idx + 1);
            int guessCount = counter(guess, letter);
            int answerCount = counter(tempA, letter);

            if (tempA.indexOf(letter) == -1) {
                gray += idx + ", ";
            } else {
                if (guessCount == 1) {
                    if (tempA.indexOf(letter) == idx) {
                        green += idx + ", ";
                    } else {
                        yellow += idx + ", ";
                    }
                } else {
                    /* FIGURE THIS OUT?
                    FIND WHERE IN tempA DOES THE LETTER APPEAR --> MATCH IT WITH WHERE IN guess THE LETTER APPEARS
                    MATCH = GREEN / NO MATCH = YELLOW (IF answerCount == guessCount)
                    (IF answerCount < guessCount) EARLIEST = YELLOW & LATEST = GRAY [HOW???]
                    ALSO NEED TO
                    REMOVE PARTS OF tempA WHEN MATCHED? [WILL THAT IMPACT ANYTHING?] MAKE tempA GLOBAL???
                     */
                }
            }

            /*
            if (tempA.indexOf(letter) == -1) {
                gray += idx + ", ";
            } else {
                if (count == 1) {
                    if (tempA.indexOf(letter) == idx) {
                        green += idx + ", ";
                    } else {
                        yellow += idx + ", ";
                    }
                } else {
                    if (tempA.indexOf(letter) == idx) {
                        green += idx + ", ";
                    }
                }
            }
             */
        }
    }
}