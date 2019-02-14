package sample;

public class console {
    public static void log(String text) {
        System.out.println(text);
    }
    public static void log(int text) {
        System.out.println(text);
    }
    public static void log(float text) {
        System.out.println(text);
    }
    public static void log(double text) {
        System.out.println(text);
    }
    public static void log(String[] text) {
        for(String t: text) {
            System.out.print(t);
        }
        System.out.println();
    }
    public static void log(int[] text) {
        for(int t: text) {
            System.out.print(t);
        }
        System.out.println();
    }
    public static void log(double[] text) {
        for(double t: text) {
            System.out.print(t);
        }
        System.out.println();
    }

    public static void log (boolean text) {
        System.out.println(text);
    }
}
