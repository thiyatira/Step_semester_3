package data_structures.assigment_problems;

// Demo runner for the hackathon banner printer.
public class A2_BannerPrinterDemo {
    public static void main(String[] args) {
        BannerPrinter printer = new BannerPrinter();

        System.out.println(printer.expandBanner("3[ab]2[c]"));
        System.out.println(printer.expandBanner("2[x3[y]]z"));
        System.out.println(printer.expandBanner("10[a]"));
        System.out.println(printer.expandBanner("hack2[a2[b]]"));
    }
}
