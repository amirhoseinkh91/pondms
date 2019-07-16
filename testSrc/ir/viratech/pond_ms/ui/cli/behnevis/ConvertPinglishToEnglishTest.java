package ir.viratech.pond_ms.ui.cli.behnevis;

import ir.viratech.pond_ms.core.behnevis.BehnevisPinglishToEnglishConverter;

public class ConvertPinglishToEnglishTest {

    public static void main(String[] args) {
        BehnevisPinglishToEnglishConverter converter = new BehnevisPinglishToEnglishConverter() ;
        System.out.println(converter.map("Tehran").trim());
        System.out.println("تهران".equals(converter.map("Tehran").trim()));
    }

}
