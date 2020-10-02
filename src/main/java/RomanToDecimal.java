import java.util.HashMap;

public class RomanToDecimal {
    public int transferToNumber(String roman) {
        int result = 0;
        int number = 0;
        int previousNumber = 0;
        for(int i = roman.length() -1; i >= 0; i--){
            char romanLetter = roman.charAt(i);
            number = getDecimalNumber(String.valueOf(romanLetter));
            if(previousNumber > number) number = number * -1;
            result = result + number;
            previousNumber = Math.abs(number);

        }
        return result;
    }

    public int getDecimalNumber(String romanLetter){
        HashMap<String, Integer> decimal = new HashMap<String, Integer>();
        decimal.put("M",1000);
        decimal.put("D",500);
        decimal.put("C",100);
        decimal.put("L",50);
        decimal.put("X",10);
        decimal.put("V",5);
        decimal.put("I",1);
        int number = 0;
        try{
            number = decimal.get(romanLetter);
        }catch (NullPointerException e){
            System.out.println("there is no roman letter " + romanLetter);
        }

//        int number = 0;
//        switch (romanLetter){
//            case 'M' : number = 1000; break;
//            case 'D' : number = 500; break;
//            case 'C' : number = 100; break;
//            case 'L' : number = 50; break;
//            case 'X' : number = 10; break;
//            case 'V' : number = 5; break;
//            case 'I' : number = 1; break;
//            default:
//                System.out.println("Wrong roman number!");
//        }
        return number;
    }
}
