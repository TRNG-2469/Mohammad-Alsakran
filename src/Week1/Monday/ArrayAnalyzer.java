package Week1.Monday;

public class ArrayAnalyzer {
    public static void main(String[] args){


        int[] nums = {2, 67, 55, 4, 21, 42, 44, 85, 1, 90};
        int sum=0;
        double avr=1;
        int min=nums[0];
        int max=nums[0];
        for (int num :nums){
            sum+=num;

            if (num > max){
                max=num;
            }
            if (num < min){
                min=num;
            }
        }

        avr=(double)sum/nums.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avr);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);



    }
}
