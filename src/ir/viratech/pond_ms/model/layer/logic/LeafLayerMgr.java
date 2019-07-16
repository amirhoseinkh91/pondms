package ir.viratech.pond_ms.model.layer.logic;


import ir.viratech.pond_ms.model.file.DataFile;
import ir.viratech.pond_ms.model.file.logic.DataFileMgr;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.base.BaseLeafLayerMgr;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.layer.LeafLayer".
 */
public class LeafLayerMgr extends BaseLeafLayerMgr {


	public void deleteDatafile (LeafLayer layer, String fileUid) {
		DataFile file = DataFileMgr.getInstance().getByExtuid(fileUid);
		layer.removeFromDataFiles(file);
		DataFileMgr.getInstance().delete(file);
		this.update(layer);
	}


}