example java:

public class V0__Example  implements baseJdbcMigration {
	public void migrate(Connection connection) throws Exception {
	
		getProperty("data/???.properties");
		getProperties("fff");//get from properties file
		
		generateUid();//get uid
		
        executeQuery(connection,"insert into PERSON (id, NAME) values (4, 'Axel');");//execute query

    }
}

------------------------------------------------------------------------------------
example sql:
create table PERSON (
    id int not null,
    NAME varchar(100) not null
);

-------------------------------------------------------------------------------------
files name format:

V[version]__[Comment].[extention]

replace space and dot with underline.
