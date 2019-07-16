package ir.viratech.pond_ms.util.fileImport.raster;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import ir.viratech.commons.tilegenerator.PointWebMercatorTilesTransformer;
import ir.viratech.commons.tilegenerator.TiffPixelReader;
import ir.viratech.commons.tilegenerator.Tiler;
import ir.viratech.commons.tilegenerator.Tuple2;
import ir.viratech.pond_ms.model.layer.RasterLayer;
import ir.viratech.pond_ms.util.fileImport.exception.DataImportException;

public class RasterImporter {

	private RasterLayer layer;
	private String fileDir;

	public RasterImporter(String fileDir, RasterLayer layer) {
		this.fileDir = fileDir;
		this.layer = layer;
	}

	public void cleanData() {
		File dir = new File(layer.getCacheTilesPath());
		if (!dir.exists()) {
			dir.mkdirs();
		} else {
			try {
				FileUtils.cleanDirectory(dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void importData() throws DataImportException {
		File dir = new File(fileDir);
		File file = null;
		for (File f : dir.listFiles())
			if (layer.getMainDataFileExtension().contains(FilenameUtils.getExtension(f.getName()))) {
				file = f;
				break;
			}
		
		FileInputStream fis = null;
		TiffPixelReader[] readers = null;
		try {
			fis = new FileInputStream(file);
			readers = TiffPixelReader.getAllReaders(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Tiler tiler = new Tiler();
		tiler.targetPT = new PointWebMercatorTilesTransformer();
		tiler.maxZoom = 20;

		if (readers.length != 1)
			throw new RuntimeException();
		try {
			tiler.reader = readers[0];

			Tuple2<Double, Double> minMax = tiler.findMinMax();
			tiler.gradiant = layer.getGradient().toTileGeneratorGradient().cloneForInterval(minMax.item1, minMax.item2);

			tiler.baseDirectory = Paths.get(layer.getCacheTilesPath());

			File bdFile = tiler.baseDirectory.toFile();
			if (!bdFile.exists()) {
				bdFile.mkdir();
			}
			else {
				FileUtils.cleanDirectory(tiler.baseDirectory.toFile());
			}
			
			tiler.createTiles();
			tiler.reader.dispose();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
