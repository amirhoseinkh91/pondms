package ir.viratech.pond_ms.test.fileImoprtTest;

import ir.viratech.commons.file.cli.FileCli;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.commons.utils.DatePrettyPrintConverter;
import ir.viratech.commons.utils.MyDateUtils;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gdal2TilesCommandRun {

//    public static void main(String[] args) {
//        ApplicationContextUtil.initializeCliApplicationContext();
//        GISVectorObject byExtuid = GISVectorObjectMgr.getInstance().getByExtuid("b26e807c-c117-4dd3-bc44-3aadf3337e89");
//        byExtuid.setProvider("TEST");
//        GISVectorObjectMgr.getInstance().update(byExtuid);
//    }

//    public static void main(String[] args) {
//        ApplicationContextUtil.initializeCliApplicationContext();
//        AuthUser byExtuid = AuthUserMgr.getInstance().getByExtuid("c3dfded7-6e36-4f9c-9c6a-2395e715db27");
//        User byAuthUser = UserMgr.getInstance().getByAuthUser(byExtuid);
//        PasswordEncoder bean = ApplicationContextUtil.getApplicationContext().getBean(PasswordEncoder.class);
//        UserMgr.getInstance().updatePassword(byAuthUser, "admin", bean);
//    }


//    public static void main(String[] args) {
//        ApplicationContextUtil.initializeCliApplicationContext();
//        AbstractEntityDAO.touchSession();
//        GISVectorObject vectorObject = GISVectorObjectMgr.getInstance().getByExtuid("b26e807c-c117-4dd3-bc44-3aadf3337e89");
//        VectorLayer layer = vectorObject.getLayer();
//        ParentLayer parentLayer = layer.getParentLayer();
//        while (parentLayer.getParentLayer() != null) {
//            System.out.println(parentLayer.getName());
//            parentLayer = parentLayer.getParentLayer();
//        }
//        System.out.println(parentLayer.getName());
//
//    }

//    public static void main(String[] args) {
//        String property = System.getProperty("os.name");
//        System.out.println(property);
//    }

//    public static void main(String[] args) {
//        ApplicationContextUtil.initializeCliApplicationContext();
//        AbstractFile abstractFile = AbstractFileMgr.getInstance().getByHashCodeString("ADI653BNA4PJPYPORE4Q5H3S2HSTMI2WPFLWBE9S");
//        File file = new File("/home/hnik/Desktop/1.jpg");
//        try {
//            FileCli.writeFile(abstractFile, file);
//        } catch (Exception ignored) {
//        }
//    }

    public static void main(String[] args) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String startDate = "2019-03-13";
            Date now = MyDateUtils.now();
            String format = formatter.format(now);
            Date nowParsedDate = formatter.parse(format);
            Date startDate2 = formatter.parse(startDate);
            int i = MyDateUtils.dayDifferenceWithoutAbs(startDate2,nowParsedDate);
            long time = now.getTime();
            System.out.println(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
