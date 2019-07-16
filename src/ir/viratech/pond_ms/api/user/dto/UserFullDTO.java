package ir.viratech.pond_ms.api.user.dto;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import ir.viratech.commons.api.dto.relation_map.DisplableRelationMapDTO;
import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.field.PrimitiveFieldInfo;
import ir.viratech.commons.api.search.field.types.FieldInfo_String;
import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.api.user.base.BaseUserFullDTO;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.role.UserRole;


/**
 * A DTO for class User.
 *
 */
public class UserFullDTO extends BaseUserFullDTO {

	private PasswordEncoder serverPasswordEncoder = (PasswordEncoder) ApplicationContextProvider.getInitializedApplicationContext().getBean("serverPasswordEncoder");
	/**
	 * FieldInfoContext for UserFullDTO
	 */
	public static class FieldInfoContext extends BaseUserFullDTO.BaseFieldInfoContext {

		@Override
		protected PrimitiveFieldInfo<?> createFieldInfo_FirstName(String externalName, String internalName,
				String internalSearchExpression, String typeKey, String bundleKey, boolean searchable,
				Boolean sortable) {
			return new FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}

	}

	/**
	 * convert password of user to string.
	 */
	@Override
	protected String toString_Password(String password) {
		return (password == null) ? null : ("'"+StringUtils.repeat("*", password.length())+"'");
	}

	/**
	 * Saves a {@link DisplableRelationMapDTO} of {@link UserRole}'s for a given {@link User}.
	 */
	@Override
	protected void save_Roles(User user, DisplableRelationMapDTO<UserRole> roles) throws BadDtoEntityModificationException {
		if (roles != null)
			roles.saveTo(user.getRolesRelationMap());
	}

	@Override
	protected void save_Password(User user, String password) throws BadDtoEntityModificationException {
		user.setAndEncodePassword(password, serverPasswordEncoder);
	}

}
