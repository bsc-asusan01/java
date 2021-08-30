class Scrabble {
    private char[] letters;

    Scrabble(String word) {
        if (word == null || "".equals(word)) {
            //testAnEmptyInput failed
            //throw new IllegalArgumentException("Empty or null ");
            this.letters = "".toCharArray();
        } else {
            letters = word.toUpperCase().toCharArray();
        }
    }
    private int scoreForLetters(String lookup) {
        int score = 0;
        if ("AEIOULNRST".contains(lookup)) score = 1;
        else if ("DG".contains(lookup)) score = 2;
        else if ("BCMP".contains(lookup)) score = 3;
        else if ("FHVWY".contains(lookup)) score = 4;
        else if ( "K".equalsIgnoreCase(lookup)) score = 5;
        else if ("JX".contains(lookup)) score = 8;
        else if ("QZ".contains(lookup)) score = 10;
        return score;
    }
    int getScore() {
        int score = 0;
        for (char letter : letters) {
            String lookup = "" + letter;
            score += scoreForLetters(lookup);
        }
        return score;
    }
}
