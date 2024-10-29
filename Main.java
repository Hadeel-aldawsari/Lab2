import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //Q1)Write a program to find all of the longest word in a given dictionary
        System.out.println("****Q1)find all of the longest word in a given dictionary****");
        String []words={ "cat", "dog", "red", "is", "am" };
         int longest=0;
         for (String word:words){
             if (word.length()>longest) longest= word.length();
         }
         for (String word:words){
             if(word.length()==longest) System.out.print(" \""+word+ "\" ");
         }
        System.out.println("");

        //Q2)Write a program that displays the number of occurrences of an element in the array.
        System.out.println("****Q2)displays the number of occurrences of an element in the array****");
        int[] numbers = {1, 1, 1, 3, 3, 5};
        System.out.print("Enter number to count the occurrences: ");
        int num=input.nextInt();
        int occurrences = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==num)occurrences++;
            }
        System.out.println(num + " occurs " + occurrences + " times");



        //Q3)Write a program to find the k largest elements in a given array. Elements in the array can be in
        //any order
        System.out.println("****Q3)find the k largest elements in a given array****");
        System.out.print("please enter k to find largest:");
        int k=input.nextInt();
        int[]arr={1, 4, 17, 7, 25, 3, 100};

        arrange(arr,k);

       // Q4)Create a method to reverse an array of integers. Implement the method without creating a new
        //array
        System.out.println("****Q4)reverse an array of integers****");
        int [] original={5,4,3,2,1};
        reverse(original);


        //Q5) Write a menu driven Java program with following option:
        System.out.println("****Q5)menu driven Java program****");
        //1. Accept elements of an array
        //2. Display elements of an array
        //3. Search the element within array
        //4. Sort the array
        // 5. To Stop the size of the array should be entered by the user.
         ArrayList<Integer>array=new ArrayList<>();
        int choies;
         do {
             System.out.println("1)Accept elements of an array");
             System.out.println("2)Display elements of an array");
             System.out.println("3)Search the element within array");
             System.out.println("4)Sort the array");
             System.out.println("5)Stop");
             System.out.print("Enter the number of your choise:");
             choies = input.nextInt();
             switch (choies) {
                 case 1:
                     System.out.print("Enter integer number to add it:");
                     int element = input.nextInt();
                     array.add(element);
                     break;
                 case 2:
                     for (int el : array) {
                         System.out.println(el);
                     }
                     break;
                 case 3:
                     System.out.print("Enter number you want to search:");
                     int n = input.nextInt();
                     search(array, n);
                     break;
                 case 4:
                     if (array.size() != 0) {
                         array.sort(null);
                         System.out.println("array after sorting: " + array.toString());
                     } else System.out.println("The array is empty");
                     break;
             }
         }while (choies!=5);
        System.out.println("Than you !");

     //Q6)Create a method that generates a random number within a given range. Allow the user to
     //specify the range and call the method to display random numbers
        System.out.println("****Q6)specify the range and call the method to display random numbers****");
        System.out.print("Enter number to start range:");
        int start_range=input.nextInt();
        System.out.print("Enter number to end range:");
        int end_range=input.nextInt();
        while(start_range>=end_range){
            System.out.println("please enter correct range");
            System.out.print("Enter number to start range:");
             start_range=input.nextInt();
            System.out.print("Enter number to end range:");
             end_range=input.nextInt();
        }
        System.out.print("Enter the number of random numbers to generate:");
        int random=input.nextInt();
        generatesRandom(start_range,end_range,random);


        //Q7)Write a program that checks the strength of a password. Create a method that evaluates a
        //password based on criteria like length, inclusion of special characters, and
        //uppercase lowercase letters.
input.nextLine();
        System.out.print("Enter a password: ");
        String password=input.nextLine();
        int totalScore=0;
        totalScore=checkLength(password)+checkSpecialCharacters(password)+checkUpperCaseLowerCase(password);
        if (totalScore>=8){
            System.out.println("Password is strong.");
        } else if (totalScore>=5) {
            System.out.println("Password is moderately strong.");
        }else System.out.println("Password is weak.");

        System.out.println("");

        //Q8)Create a method that generates the Fibonacci sequence up to a specified number of terms.
        //Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1,
        //and each subsequent number in the sequence is the sum of the two preceding ones
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int number=input.nextInt();
        fibonacci(number);


    }//end main

    public static void arrange(int[] numbers,int k){
        for (int i = 0; i < numbers.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > numbers[maxIndex]) {
                    maxIndex = j;
                }}
            int temp = numbers[i];
            numbers[i] = numbers[maxIndex];
            numbers[maxIndex] = temp;
        }
        //print the k
        System.out.println(k+" largest elements of the said array are:");
        for (int p = 0; p <k ; p++) {
            System.out.print(numbers[p]+ " ");
        }
        System.out.println("");
    }//end arrange

    public static void reverse(int[]arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int current = arr[start];
            arr[start] = arr[end];
            arr[end] = current;
            start++;
            end--;
        }
        System.out.println("Reversed Array:");
        for (int re:arr){
            System.out.print(re+" ");
        }
        System.out.println("");
    }//end revers

    public static void search(ArrayList<Integer>arr,int num){
        if(arr.size()!=0){
            String found = "Not found";
            for (int current : arr) {
                if (current == num) {
                    found = found;
                    break;
                }
            }System.out.println("number " + num + " " + found);
        }else System.out.println("sorry :( the array is empty");
    }//end search
    public static void generatesRandom(int start,int end,int random){
        System.out.print("The random generated:");
        for (int i = 0; i <random ; i++) {
            System.out.print((int)((Math.random() * (end - start)) + start)+" ");
        }
    }

    public static int checkLength(String pass){
     if(pass.length()<=5){
         return 0;
     } else if (pass.length()>=6 && pass.length()<=7) {
      return 2;
     }else{
         return 3;}
    }

    public static int checkUpperCaseLowerCase(String pass){
        if (pass.matches(".*[A-Z].*") && pass.matches(".*[a-z].*")){
           return 3;
        }else return 0;
    }

    public static int checkSpecialCharacters(String pass){
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        if(special.matcher(pass).find()){
            return 2;
        }return 0;
    }


        public static void fibonacci(int num) {
            int first = 0, second = 1;
            System.out.print(first + " ");
            if (num > 1) {
                System.out.print(second+ " ");
            }

            for (int i = 2; i < num; i++) {
                int fibonacci = first + second;
                System.out.print(fibonacci + " ");
                first = second;
                second = fibonacci;
            }
        }




}