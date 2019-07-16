package ir.viratech.pond_ms.ui.cli.removeExtraAgencyVectorLayer;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.LeafLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;

import java.util.List;

public class RemoveExtraAgencyParentLayer {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();

        AbstractEntityDAO.touchSession();
        List<LeafLayer> leafLayers = LeafLayerMgr.getInstance().list();

        int counter = 1;
        for (LeafLayer leafLayer : leafLayers) {
            ParentLayer pl = leafLayer.getParentLayer();
            if (pl.getSubLayers().size() > 5) {
                pl.getSubLayers().remove(4);
                System.out.println("#" + (counter++) +"\t" +pl.getName() + "\tupdated.");
            }
            ParentLayerMgr.getInstance().update(pl);
        }

        AbstractEntityDAO.closeCurrentThreadSessions();
    }

}
