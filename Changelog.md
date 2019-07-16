############### Notes ###############
To see git logs:
	git log --oneline --color
Make sure:
	* the last version here is equal to the framework version in build.xml.properties.
	* the last commit hash here matches the last commit in git.
	* to create a tag for released version by executing:
		git tag v2.1.0
#####################################

##
Updated to ViraCommons 2.2:
	* The class "FlywayMigrator_Reset" is merged with "FlywayMigrator_Update".
	* Method "FlywayMigrator_Reset.getReadyForReset()" moved & renamed to "FlywayAutomaticUpdateMigratorBean.disableAutomaticMigration()".
	* The class "FlywayMigrator_Update" is renamed to "FlywayMigrator".
	  Its bean name is renamed from 'flaywayUpdaterBean' to 'flaywayMigratorBean'.
 


## 2.3.0 (1393//) ()
new Features:
	added password.strong.threshold
	added password.expire.interim.second 
	added user.expire.interim.second
	in config.properties and datamodel
	
	added log filter(log all request and response)
	
	added encript data util
	
	added EntityByDtoFinderOrCreator_ByUid
	
## 2.2.0 (1393/11/04) (08bed1a)
Updated to 'ViraCommons-1.7.jar':
	- Renamed DAO/Mgr.delete(id) to deleteById(id)

## 2.1.1 (1393/10/30) (1c57c85)
new Features:
	- Updated to 'ViraCommons-1.6.jar':
		- added the support of searching fields like 'person.name'

## 2.1.0 (1393/10/20) (4818d64)
new Features:
	- synch-ing base files with the new model-code-generator




## 2.0.1 (1393/10/10) (a26887b)
new Features:
	- Auth-local/Auth-cas ant target removed. using AuthenticationProfiles instead. you can set the authentication type in config.properties now.
	- felan chiz dige poshtibani nemishe
