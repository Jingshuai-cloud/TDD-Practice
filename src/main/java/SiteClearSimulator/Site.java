package SiteClearSimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Site {
    private String pathName;
    private ArrayList<ArrayList<Character>> site = new ArrayList<>();
    public Site(String pathName){
        this.pathName = pathName;
    }

    public ArrayList<ArrayList<Character>> readSite() throws FileNotFoundException {
        File siteFile = new File(pathName);
        Scanner scanner = new Scanner(siteFile);
        ArrayList<String> siteArray = new ArrayList<>();
        while(scanner.hasNextLine()){
            siteArray.add(scanner.nextLine());
        }

        for(int i = 0; i< siteArray.size(); i++){
            ArrayList<Character> siteItem = new ArrayList<>();
            for(int j = 0; j < siteArray.get(i).length(); j++){
               siteItem.add(siteArray.get(i).charAt(j));
            }
           site.add(siteItem);
        }
        return site;
    }

    public void printSite() {
        for(int i = 0; i < site.size(); i++){
            for(int j = 0; j < site.get(i).size(); j++){
                System.out.print(site.get(i).get(j));
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
