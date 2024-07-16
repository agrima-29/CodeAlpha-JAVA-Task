import java.util.ArrayList;
import java.util.Scanner;

public class SGrades {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> g = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        System.out.println("Enter grades (type -1 to stop):");

        while (true) {
            System.out.print("Enter student name: ");
            String name = s.next();
            
            System.out.print("Enter grade for " + name + ": ");
            int gr = s.nextInt();

            if (gr == -1) {
                break;
            } else if (gr < 0 || gr > 100) {
                System.out.println("Invalid grade. Try again.");
            } else {
                names.add(name);
                g.add(gr);
            }
        }

        if (g.size() == 0) {
            System.out.println("No grades were entered.");
        } else {
            int sG = 0;
            int hG = g.get(0);
            int lG = g.get(0);

            for (int i = 0; i < g.size(); i++) {
                int cg = g.get(i);
                sG += cg;
                if (cg > hG) {
                    hG = cg;
                }
                if (cg < lG) {
                    lG = cg;
                }
            }

            double aG = (double) sG / g.size();

            System.out.println("Average grade: " + aG);
            System.out.println("Highest grade: " + hG);
            System.out.println("Lowest grade: " + lG);
        }

        s.close();
    }
}