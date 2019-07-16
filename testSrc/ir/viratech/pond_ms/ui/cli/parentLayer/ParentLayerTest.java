package ir.viratech.pond_ms.ui.cli.parentLayer;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;

import java.util.List;

public class ParentLayerTest {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        ParentLayer parentLayer = ParentLayerMgr.getInstance().getByName("شهر تهران");
        System.out.println(parentLayer.getName());
        System.out.println(parentLayer);
        System.out.println(parentLayer.getExtuid());
        System.out.println(parentLayer.getCreationDate());

    }

}
