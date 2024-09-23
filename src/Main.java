import java.util.Scanner;



public class Main {
    private static int[][] arr;
    private static int kolvo;
    public static void coordxy(){
        System.out.println("Введите количество точек (не менее 3) :");
        Scanner scan = new Scanner(System.in);
        kolvo = scan.nextInt();

        if (kolvo < 3) {
            System.out.println("Количество точек должно быть не менее 3.");
            return;
        }
        arr = new int[kolvo][2];
        for (int i = 0; i < kolvo; i++) {
            System.out.println("Введите x" + (i + 1) + ":");
            arr[i][0] = scan.nextInt();
            System.out.println("Введите y" + (i + 1) + ":");
            arr[i][1] = scan.nextInt();
        }

    }
    public static void Gerron(){
        double S=0 ;
        for (int i  =0 ;i<kolvo - 2;i++)
        {
            double a = Math.sqrt(Math.pow(arr[0][0]-arr[i+1][0],2)+Math.pow(arr[0][1]-arr[i+1][1],2));
            double b = Math.sqrt(Math.pow(arr[0][0]-arr[i+2][0],2)+Math.pow(arr[0][1]-arr[i+2][1],2));
            double c = Math.sqrt(Math.pow(arr[i+1][0]-arr[i+2][0],2)+Math.pow(arr[i+1][1]-arr[i+2][1],2));
            double p = (a+b+c)/2;
            S+=Math.sqrt(p*(p-a)*(p-b)*(p-c));

        }
        System.out.println("Площадь по формуле Геррона: " + S+".\n");
    }
    public static void Formyla(){
        //  через формулу
        double S=0;
        for (int i=0;i<kolvo-2;i++) {
            double result = (arr[0][0] * (arr[i + 1][1] - arr[i + 2][1]) + arr[i + 1][0] * (arr[i + 2][1] - arr[0][1]) + arr[i + 2][0] * (arr[0][1] - arr[i + 1][1])) / 2;
            if (result < 0) {
                result = result * (-1);
            }
            S+=result;
        }
        System.out.println("Площадь по формуле Геррона: " + S+".");
    }
    public static void main(String[] args) {
        coordxy();
        Gerron();
        Formyla();
    }
}