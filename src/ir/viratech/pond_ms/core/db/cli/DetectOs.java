package ir.viratech.pond_ms.core.db.cli;

public class DetectOs {
    public static void main(String[] args) {
        String property = System.getProperty("os.name");
        System.out.println(property);
    }
}
