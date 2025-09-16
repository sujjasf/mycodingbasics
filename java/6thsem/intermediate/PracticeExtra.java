import java.util.*;

class QueDeque {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= 5; i++){
            queue.add(i);
            System.out.println("Person " + i + " joined queue.");
        }

        while(!queue.isEmpty()){
            System.out.println("Serving Person is : " + queue.poll());
        }

    }
}























// class Maps {
//     public static void main(String[] args) {
//         String text = "Sujjal bro sushant bro sujal khadka bro nepal sujal manxe";
//         String[] words = text.split(" ");

//         Map<String, Integer> frequency = new HashMap<>();

//         for (String word : words ){
//             frequency.put(word, frequency.getOrDefault(word, 0) + 1);
//         }
        
//         System.out.println("Frequency is : " + frequency);
//     }
// }


// class Sets {
//     public static void main(String[] args) {
//         List<Integer> nums = Arrays.asList(10, 20, 30, 20, 50, 40, 50);
//         Set<Integer> unique = new HashSet<>(nums);

//         System.out.println("Original List : " + nums);
        
//         System.out.println("Removing duplicates is : " + unique);
//     }
// }


// class ArrayLists {
//     public static void main(String[] args) {
//         ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

//         int sum = 0;
//         for (int num : numbers) {
//             sum += num;
//         }
//         double average = (double) sum / numbers.size();
//         System.out.println("Sum is : " + sum);
//         System.out.println("Average is : " + average);

//     }
// }