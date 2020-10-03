import java.util.ArrayList;

public class StringCaculator {

    public int add(String s) throws Exception {
        if(s.isEmpty()) return 0;
        String[] numbers = getNumbers(s);
        ifNegative(numbers);
        return sumNumbers(numbers);
    }

    private String[] getNumbers(String s){
        String[] numbers = s.split(",|\n");
        return numbers;
    }

    private int transferToInt(String number) throws Exception {
        int intNumber = 0;
        try{
           intNumber =  Integer.parseInt(number);

        }catch (NumberFormatException e){
            System.out.println("unvalid number: " + number);
            throw e;
        }

        return ignoredOverThousand(intNumber);
    }

    private int sumNumbers(String numbers[]) throws Exception {
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            int num = transferToInt(numbers[i]);
            sum += num;
        }
        return sum;
    }

    private void ifNegative(String[] numbers) throws Exception{
        ArrayList negativeNumber = new ArrayList();
        for(int i = 0; i < numbers.length; i++){
           int num =  transferToInt(numbers[i]);
           if(num < 0) negativeNumber.add(num);
        }
        if(negativeNumber.size() > 0 ){
          throw new Exception("Negative value " + negativeNumber);
        }
    }

    private int ignoredOverThousand(int num){
        if(num > 1000) return 0;
        return num;
    }

}
