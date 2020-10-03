import java.util.ArrayList;

public class Greeting {
    public String sayHello(String[] name) {
        if(name.length == 1){
            if(name[0].equals("")) return "Hello myfriend";
            if(ifAllUppercase(name[0])) return "HELLO " + name[0];
            return "Hello " + name[0];
        }

        ArrayList<String> uppercaseName = new ArrayList<>();
        ArrayList<String> normalName = new ArrayList<>();
        for(String n: name){
            if(ifAllUppercase(n)) uppercaseName.add(n);
            else normalName.add(n);
        }
        String upperHello = "";
        if(uppercaseName.size() != 0) upperHello = " AND HELLO " + uppercaseName.get(0) + "!";
        String lowerHello = nameLengthOverOne(normalName);
        return lowerHello + upperHello;
    }

    private boolean ifAllUppercase(String name){
        if(name.matches("[A-Z\\s]+")) return true;
        return false;
    }

    private String nameLengthOverOne(ArrayList<String> name){
        String result = "Hello,";
        if(name.size() == 2) return result+ " " + name.get(0)+ " and " + name.get(1) + ".";
        for(int i = 0; i < name.size(); i++){
            result += " " + name.get(i);
            if(i != name.size() -1) result += ",";
            if(i == name.size() -2) result += " and";
            if(i == name.size() -1) result += ".";
        }
        return result;
    }
}
