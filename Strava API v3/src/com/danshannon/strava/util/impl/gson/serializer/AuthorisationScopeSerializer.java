package com.danshannon.strava.util.impl.gson.serializer;

import java.lang.reflect.Type;

import com.danshannon.strava.api.auth.ref.AuthorisationScope;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Dan Shannon
 *
 */
public class AuthorisationScopeSerializer implements JsonSerializer<AuthorisationScope>, JsonDeserializer<AuthorisationScope>{

	public static AuthorisationScope create(String id) {
		for (AuthorisationScope scope : AuthorisationScope.values()) {
			if (scope.getId().equals(id)) {
				return scope;
			}
		}
		return AuthorisationScope.UNKNOWN;
	}

	/**
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public AuthorisationScope deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		return create(json.getAsString());
	}

	/**
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(AuthorisationScope authorisationScope, Type type, JsonSerializationContext context) {
		return context.serialize(authorisationScope.getId());
	}

}