package ir.viratech.pond_ms.core.db.flyway.migrations;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.google_key.GoogleApiKey;
import ir.viratech.pond_ms.model.google_key.logic.GoogleApiKeyMgr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class V27__AddGoogleApiKeys extends BaseJdbcMigration {

    @Override
    public void migrate(Connection conn) throws Exception {
        List<String> keys = getGoogleApiKeys();
        for (String key : keys)
            addGoogleApiKeysToTable(conn, key);
    }

    private void addGoogleApiKeysToTable(Connection conn, String key) throws SQLException {
        long id = getMaxIdByTable(conn, GoogleApiKey.TABLE) + 1;
        Quoter quoter = new Quoter(false, true, true, false, false, false);

        GoogleApiKey googleApiKey = GoogleApiKeyMgr.getInstance().createNew();
        googleApiKey.setKey(key);

        this.executeQuery(conn, SqlUtil.insertIntoTable(GoogleApiKey.TABLE,
                GoogleApiKey.PROPCOLUMN_ID,
                GoogleApiKey.PROPCOLUMN_EXTUID,
                GoogleApiKey.PROPCOLUMN_KEY,
                GoogleApiKey.PROPCOLUMN_LAST_USED_DATE,
                GoogleApiKey.PROPCOLUMN_USED_COUNTER,
                GoogleApiKey.PROPCOLUMN_BUSY)

                + SqlUtil.values(
                quoter.tuple(id, googleApiKey.getExtuid(), googleApiKey.getKey(),
                        null, 0, false)));
    }

    private List<String> getGoogleApiKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("AIzaSyB3BfnvSljMDgu7aP1cLWoqSY0Zywr80-I");
        keys.add("AIzaSyBzQsZqKfbDPov7USO89uU09ZJp2vQouHM");
        keys.add("AIzaSyBv8X9F3O0gNxYUHhQ_a2u9DRS7PLbDUH8");
        keys.add("AIzaSyA05DssyM43X1-_kkMMLbH-7qJNo2q7JXk");
        keys.add("AIzaSyB3aj05lw_XrCOfEbes8qvqRjDGlHNNfME");
        keys.add("AIzaSyB9cfuJyR_unQ_YgtvzZDIIdV7w2G3DRnQ");
        keys.add("AIzaSyD2kYYKgzv0V5NIePaML3-Up_y8Fetmb-I");
        keys.add("AIzaSyCIzpBAUbZgA0ZFd-_7gHC4EKquTqVbWkU");
        keys.add("AIzaSyCABWlRl5G-WlisB1X30COIUM4j8pSkJWs");
        keys.add("AIzaSyAALQWWUg_oA8-U9B2Jc6NIgvI4alZl-g0");
        keys.add("AIzaSyBffwbK3OttY3aOKIOc-Rn-hjwFaOEB0EY");
        keys.add("AIzaSyBWfUqBzgSMSxn4IAatd2PXwPbJwADsliU");
        keys.add("AIzaSyC6agZG3TRdOI-s6ivTWF-xXWAvUCQ22Pg");
        keys.add("AIzaSyAnkrVH6MZplTNtgtTI6I4qChKquk3nFvQ");
        keys.add("AIzaSyBmri-qeZVb0evlozfg7WRj5AaEl277H-g");
        keys.add("AIzaSyCjPKqgM27tW55drRp6yQ10-pPu8RlLpeY");
        keys.add("AIzaSyDgdHPiEjYaqcCsjGNyaLMURt4UG7Jlo2A");
        keys.add("AIzaSyBprR9QLUIxtnmumbs9LQzl8BCEsO11V9Q");
        keys.add("AIzaSyCYlfisVyk7I8BfLz-a7arknPQijssJcC4");
        keys.add("AIzaSyBVBysGiFbrsbYqM-5_wioaS2M33XYWTXw");
        keys.add("AIzaSyACmjB3WfnUgbl0vXnoJ88XyHkSkq1Nnls");
        keys.add("AIzaSyBkCXZAO0bo1KXmt-Ex1YjOEABCbd4GgDE");
        keys.add("AIzaSyDq43T-290NQ4ZVqxyQ77bEdATqbjfCzXI");
        keys.add("AIzaSyCXQ6tSd096hQQq_bj25a3OZEWGkIcM0Jk");
        keys.add("AIzaSyAe2qnKtGP96ACpm3Ou89WgKETvB06e6uw");
        keys.add("AIzaSyASWvHQQCXotSzd5_8hkUoj2FyohMVNO3o");
        keys.add("AIzaSyAIoeF7udHjDDvbY9NJq04BQVCRmHqwJkY");
        keys.add("AIzaSyAN14KF22ZhLoFwWLoM7AEHlDWdUo_1tbw");
        keys.add("AIzaSyA0nNFm4b260uvYkSZTaLz9mn3HX940350");
        keys.add("AIzaSyCuPOQQAU99azd4LHsYc_FgDQ_K-aHev0I");
        keys.add("AIzaSyDNjfS3JKPyT3ptVDmt-i0HrmNCKm7rn5k");
        keys.add("AIzaSyB15KXJ-A_V8zKYuTlo_MiBOuwjd6M_u4U");
        keys.add("AIzaSyA1JvSP-dtfmRxYGkXMg06GXL2IgpPhs9w");
        keys.add("AIzaSyDdWejTX8XHO-9PYWlvYlY36FCJFslAvdg");
        keys.add("AIzaSyCpK_HSKRXC57hx_GJcxGTUvRhcqnI-KyA");
        keys.add("AIzaSyClF-KdNFvjQwZWj5nLyyMHpFQbqojarSY");
        return keys;
    }
}
