package ir.viratech.pond_ms.core.db.flyway.migrations;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import ir.viratech.commons.model.uid.UidGenerator;
import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.commons.util.string.CharSetUtils;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.Feature.EntityAccessKey;
import ir.viratech.pond_ms.model.user.role.Role;

/**
 * The Class BaseJdbcMigration.
 */
public abstract class BaseJdbcMigration implements JdbcMigration {

	private static final transient Logger logger = Logger.getLogger(BaseJdbcMigration.class);

	private static final String FEATUE_TABLE = Feature.TABLE;
	private static final String ROLE_TABLE = Role.TABLE;
	private static final String ROLE_FEATURE_TABLE = Role.PROPTABLE_AVAILABLE_FEATURES;

	/**
	 * This is a field which is used to fill 'id' column in tables.
	 * It has a simple function to increment.
	 */
	private long id = 1;
	protected void setId(long id) {
		this.id = id;
	}
	protected long nextId() {
		long i = this.id;
		this.id++;
		return i;
	}


	/**
	 * Get a resource as an InputStream from ClassLoader.
	 * @param path relative address from BaseJdbcMigration class.
	 * @return The resource
	 */
	protected InputStream getResourceStream(String path) {
		return BaseJdbcMigration.class.getResourceAsStream(path);
	}

	/**
	 * Loads example properties file from given path.
	 * @param path the path relative to BaseJdbcMigration class.
	 */
	public void initProperties(String path) {
		try (InputStreamReader reader = new InputStreamReader(this.getResourceStream(path), CharSetUtils.CHARSET_UTF8)) {
			this.examplePropertyFile = new Properties();
			this.examplePropertyFile.load(reader);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private Properties examplePropertyFile;
	/**
	 * Get a property from example properties.
	 * You should init the properties before calling this function
	 * @param propertyName the property key
	 * @return the value of property key in the properties file.
	 */
	protected final String getProperty(String propertyName) {
		return this.examplePropertyFile.getProperty(propertyName);
	}

	/**
	 * Execute a query in the given connection.
	 * @param connection
	 * @param query the query to be executed
	 * @throws IllegalStateException when a sql exception recieved.
	 */
	protected void executeQuery(Connection connection, String query) {
		logger.info("executeQuery: " + query);
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.execute();
		}catch(SQLException e){
			logger.error("Failed to execute query: "+query, e);
			throw new IllegalStateException(e);
		}
	}

	/**
	 * Generate Uid using global UidGenerator.
	 *
	 * @return generated Uid.
	 */
	public String generateUid() {
		UidGenerator uidGenerator = ApplicationContextUtil.getApplicationContext().getBean("uidGenerator", UidGenerator.class);
		return uidGenerator.generateUid();
	}

	/**
	 * Create pair of inputs concatenated by comma and with parenthesis around.
	 * Useful for adding associations.
	 * @param leftId
	 * @param rightId
	 * @return the pair in string format
	 */
	protected static <L, R> String createSqlPair(L leftId, R rightId) {
		return SqlUtil.tuple(leftId, rightId);
	}

	/**
	 * Create a list of pairs from one leftId and a list of rightIds.
	 * @see #createSqlPair
	 * @param leftId
	 * @param rightIds
	 * @return a list of pair in string format
	 */
	protected static <L, R> String createSqlPairs(L leftId, List<R> rightIds) {
		StringBuilder values = new StringBuilder("");
		for (R rightId : rightIds) {
			values.append(((values.length() == 0) ? "" : ", ") + createSqlPair(leftId, rightId));
		}
		return values.toString();
	}

	/**
	 * Create a list of pairs from a list of leftIds and a one rightId.
	 * @see #createSqlPair
	 * @param leftIds
	 * @param rightId
	 * @return a list of pair in string format
	 */
	protected static <L, R> String createSqlPairs(List<L> leftIds, R rightId) {
		StringBuilder values = new StringBuilder("");
		for (L leftId : leftIds) {
			values.append(((values.length() == 0) ? "" : ", ") + createSqlPair(leftId, rightId));
		}
		return values.toString();
	}


	/**
	 * Create a list of pairs from a list of leftIds and a list rightId.
	 * It's like Cartesian Product.
	 * @see #createSqlPair
	 * @param leftIds
	 * @param rightId
	 * @return a list of pair in string format
	 */
	protected static <L, R> String createSqlPairs(List<L> leftIds, List<R> rightIds) {
		StringBuilder values = new StringBuilder("");
		for (L leftId : leftIds) {
			for (R rightId : rightIds) {
				values.append(((values.length() == 0) ? "" : ", ") + createSqlPair(leftId, rightId));
			}
		}
		return values.toString();
	}

	protected List<Integer> listAll(int a, int b) {
		List<Integer> l = new ArrayList<>();
		for (int i=a; i<=b; i++)
			l.add(i);
		return l;
	}

	@SafeVarargs
	protected static <T> List<T> sumAll(List<T>... lists) {
		List<T> l = new ArrayList<>();
		for (List<T> list : lists)
			l.addAll(list);
		return l;
	}

	protected long getColumnMaxFromTable(Connection conn, String tableName, String columnName, long defaultValue) throws SQLException {
		String query = "select max("+columnName+") as m from "+tableName;
		logger.info("executeQuery: " + query);
		try (
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet res = stmt.executeQuery();
				) {
			if (res.next()) {
				return res.getLong("m");
			}
		}
		return defaultValue;
	}

	/**
	 * get max id from a table
	 * @param connection
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	protected long getMaxIdByTable(Connection conn, String tableName) throws SQLException {
		return getColumnMaxFromTable(conn, tableName, "id", 0L);
	}

	/**
	 * setId by maxId of the table
	 * @param string
	 * @return
	 * @throws SQLException
	 */
	protected void setIdByMaxTableId(Connection connection, String table) throws SQLException {
		this.setId(this.getMaxIdByTable(connection, table)+1);

	}

	/**
	 *	same as {@link #executeQuery(Connection, String)} but also replace every $UID with new generated uid
	 * @param conn
	 * @param string
	 */
	protected void executeQueryAndReplaceUid(Connection conn, String query) {
		String resultQuery = query;
		String temp = resultQuery.replaceFirst("\\$UID", this.generateUid());
		while (!temp.equals(resultQuery)){
			resultQuery = temp;
			temp = resultQuery.replaceFirst("\\$UID", this.generateUid());
		}
		this.executeQuery(conn, resultQuery);
	}

	/**
	 *
	 * @param conn
	 * @param entityNameInFeature
	 * @param entityNameInDescription
	 * @param startId
	 * @return the next free id in table FEATURES
	 * @throws SQLException
	 */
	protected long addEntityFeatures(Connection conn, String entityNameInFeature, String entityNameInDescription, long startId, boolean exposable) throws SQLException {
		long id = startId;
		Quoter quoter = new Quoter(false, true, true, true, false);
		String query = SqlUtil.insertIntoTable(Feature.TABLE, Feature.PROPCOLUMN_ID, Feature.PROPCOLUMN_EXTUID, Feature.PROPCOLUMN_NAME, Feature.PROPCOLUMN_DESCRIPTION, Feature.PROPCOLUMN_EXPOSABLE)
				+ SqlUtil.values(
						quoter.tuple(id++, this.generateUid(), EntityAccessKey.getAccessKeyForManagement(entityNameInFeature), "access.management entity " + entityNameInDescription, exposable),
						quoter.tuple(id++, this.generateUid(), EntityAccessKey.getAccessKeyForAdd(entityNameInFeature), "access.api.add" + " " + "entity." + entityNameInDescription, exposable),
						quoter.tuple(id++, this.generateUid(), EntityAccessKey.getAccessKeyForView(entityNameInFeature), "access.api.view" + " " + "entity." + entityNameInDescription, exposable),
						quoter.tuple(id++, this.generateUid(), EntityAccessKey.getAccessKeyForEdit(entityNameInFeature), "access.api.edit" + " " + "entity." + entityNameInDescription, exposable),
						quoter.tuple(id++, this.generateUid(), EntityAccessKey.getAccessKeyForDelete(entityNameInFeature),"access.api.delete" + " " + "entity." + entityNameInDescription, exposable),
						quoter.tuple(id++, this.generateUid(), EntityAccessKey.getAccessKeyForList(entityNameInFeature), "access.api.list" + " " + "entity." + entityNameInDescription, exposable)
				);
		this.executeQuery(conn, query);
		return id;
	}

	public boolean addFeatureIfNotExists(Connection conn, String name, String description, boolean exposable) throws SQLException{
		boolean successResult = false;
		String query = "SELECT "+Feature.PROP_NAME+" FROM "+FEATUE_TABLE+" WHERE "+Feature.PROP_NAME+" = '"+name+"';";
		PreparedStatement statement = conn.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		if(!result.next()){
			long maxid = this.getMaxIdByTable(conn, FEATUE_TABLE);
			maxid++;
			String queString ="INSERT INTO "+FEATUE_TABLE+"(id, name, description, extuid, exposable)  VALUES("+maxid+", '"+name+"', '"+description+"', '"+this.generateUid()+"' , "+exposable+");";
			PreparedStatement statement2 = conn.prepareStatement(queString);
			statement2.executeUpdate();
			successResult = true;
		}
		return successResult;
	}
	public boolean addRole(Connection conn,String name, String type_, String description) throws SQLException{
        long maxid = this.getMaxIdByTable(conn, ROLE_TABLE);
        return this.addRole(conn, maxid+1, name,type_, description);
	}

    public boolean addRole(Connection conn, long id, String name, String type_, String description) throws SQLException{
        boolean successResult = false;
        String query = "SELECT "+Feature.PROP_NAME+" FROM "+ROLE_TABLE+" WHERE "+Role.PROP_NAME+" = '"+name+"';";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        if(!result.next()){
            String queString ="INSERT INTO "+ROLE_TABLE+"(id, name, type_, description, extuid, userDefined)  VALUES("+id+", '"+name+"', '"+type_+"', '"+description+"', '"+this.generateUid()+"' , "+Boolean.TRUE+");";
            PreparedStatement statement2 = conn.prepareStatement(queString);
            statement2.executeUpdate();
            successResult = true;
        }
        return successResult;
    }
	public boolean addFeaturesToRole(Connection conn,String featureName,String roleName) throws SQLException{
		boolean successResult = false;
		String query = "SELECT "+Feature.PROP_ID+" FROM "+FEATUE_TABLE+" WHERE "+Feature.PROP_NAME+" = '"+featureName+"';";
		PreparedStatement statement = conn.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		result.next();
		long featureId = result.getLong(Feature.PROP_ID);

		String query2 = "SELECT "+Role.PROP_ID+" FROM "+ROLE_TABLE+" WHERE "+Role.PROP_NAME+" = '"+roleName+"';";
		PreparedStatement statement2 = conn.prepareStatement(query2);
		ResultSet result2 = statement2.executeQuery();
		result2.next();
		long roleId = result2.getLong(Role.PROP_ID);

		String query3 = "SELECT * FROM "+ROLE_FEATURE_TABLE+" WHERE featureid = '"+featureId+"' AND roleid = '"+roleId+"';";
		PreparedStatement statement3 = conn.prepareStatement(query3);
		ResultSet result3 = statement3.executeQuery();
		if(!result3.next()){
			String query4 ="INSERT INTO "+ROLE_FEATURE_TABLE+"(featureId, roleId)  VALUES("+featureId+", "+roleId+");";
			PreparedStatement statement4 = conn.prepareStatement(query4);
			statement4.executeUpdate();
			successResult = true;
		}
		return successResult ;
	}
}