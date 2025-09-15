class Swap {
    public static void main(String[] args) {
        int a =  5;
        int b = 10;
        int temp = b;
        b = a;
        a = temp;
        System.out.printf("The swap of a(5) is %d and b(10) is %d\n", a, b);
    }
}