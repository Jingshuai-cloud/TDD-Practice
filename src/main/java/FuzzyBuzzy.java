public class FuzzyBuzzy {

    public String playGame(int i) {
        if(i%15 == 0) return "FuzzyBuzzy";
        if(i%3 == 0) return "Buzzy";
        if(i%5 == 0) return "Fuzzy";
       return String.valueOf(i);
    }
}
