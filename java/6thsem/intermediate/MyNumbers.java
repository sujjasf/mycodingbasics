import java.util.ArrayList;
import java.util.Scanner;

public class MyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c, max, min = 0,imin = 0, imax = 0;
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("How many number do you wnat to enter? ");

        c = sc.nextInt();
        System.out.println("Enter Number");
        for(int i = 1; i <= c; i++) {
            al.add(sc.nextInt());
        }

        System.out.println("Elements in arrayList");
        for(int i : al) {
            System.out.println(i);
        }

        min = al.get(0);
        max = al.get(0);

        for(int i = 0; i <= al.size() -1; i++ ) {
            if(al.get(i) < min) {
                min = al.get(i);
                imin = i;
            }
            if(al.get(i) > max) {
                max = al.get(i);
                imax = i;
            }
        }    System.out.println("largest number is : "+max+" .at index: "+imax);
        System.out.println("Smallest number is : "+min+" .at index: "+imin);

        System.out.println("--------------------after swaping----------------");
        al.set(imax,min);
        al.set(imin,max);
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
            
        }
        // temp=max;
        // max=min;
        // min=temp;
        // System.out.println("largest number is : "+max);
        // System.out.println("Smallest number is : "+min);


    }
   
    
}