package Week1.Monday;

public class PrimitivePractice {

    public static void main(String[] args){

        byte v1=0;
        short v2=0;
        int v3=0;
        long v4=0;
        float v5=0.0f;
        double v6=0.0d;
        char v7='0';
        boolean v8=false;


        System.out.println( "v1:" +v1+ " is a byte");
        System.out.println( "v2:" +v2+ " is a short");
        System.out.println( "v3:" +v3+ " is an int");
        System.out.println( "v4:" +v4+ " is a long");
        System.out.println( "v5:" +v5+ " is a float");
        System.out.println( "v6:" +v6+ " is a double");
        System.out.println( "v7:" +v7+ " is a short");
        System.out.println( "v8:" +v8+ " is a boolean");


        byte smallVal=50;
        int largeVal= smallVal;
        System.out.println(smallVal + " " + largeVal);

        double decimalVal=99.99;
        int truncatedVal= (int)decimalVal;
        System.out.println(decimalVal + " " + truncatedVal);

        int a=10;
        int b=a;
        b=20;

        System.out.println(a+" "+b);

        int[] firstArray = new int[]{10, 20, 30};

        int[] secondArray = firstArray;

        secondArray[0] = 999;

        System.out.println(firstArray[0]+ " "+ secondArray[0]);

    }
}
