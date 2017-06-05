import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static final String fileName = "hurdat2-nepac-1949-2016-041317.txt";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        List<String> windNames = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        int counter =0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String l : list) {
            if ((l.substring(0,2).contains("EP") && l.substring(4,8).contains("2009")) || (l.substring(0,2).contains("CP") && l.substring(4,8).contains("2009"))) {
                rows.add((Integer.parseInt(l.substring(33,36).trim())));
                windNames.add(l.substring(19,28).trim());
            }
            if(l.substring(0,4).contains("2009")) {
                dates.add(l.substring(0,8) + "\t" + l.substring(39,41));
            }
        }

        for (int i = 0; i < windNames.size() ; i++) {
            System.out.println("Wind name: " + windNames.get(i));
            System.out.println("Maximum speed in knots : ");
            for (int j = 0; j < rows.get(i) ; j++) {
                System.out.println(dates.get(counter));
                counter++;
            }
            System.out.println();
        }
    }
 }

