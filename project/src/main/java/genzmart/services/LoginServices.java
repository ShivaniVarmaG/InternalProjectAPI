package genzmart.services;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.Date;
import java.sql.Timestamp;

import com.google.api.client.util.Base64;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {

	@SuppressWarnings("unchecked")
	public JSONObject login(JSONObject data) {
		String name = (String) data.get("username");
		String password = (String) data.get("password");
		System.out.println(name + "   " + password);
		if (name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			String token = generateToken(data, 100);
			JSONObject toknjson = new JSONObject();
			toknjson.put("token", token);
			return toknjson;
		} else {
			return new JSONObject();
		}
	}

	private String generateToken(JSONObject tokenData, long validity) {
		String sub = "genzmart";
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("genzmart");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		@SuppressWarnings("unchecked")
		JwtBuilder tokenBuilder = Jwts.builder().setIssuer("test").setSubject(sub).setClaims(tokenData)
				.signWith(signatureAlgorithm, signingKey).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + validity * 1000));

		return tokenBuilder.compact();

	}

	@SuppressWarnings("unused")
	private JSONObject tokenDecoder(String token) {
		JSONObject jsonToken = null;
		try {
			String[] tokenPieces = token.split("\\.");
			String payload = tokenPieces[1];
			String tokenJson = new String(Base64.decodeBase64(payload), StandardCharsets.UTF_8);
			JSONParser parser = new JSONParser();
			jsonToken = (JSONObject) parser.parse(tokenJson);
		} catch (Exception e) {
			return null;
		}
		return jsonToken;
	}

	public boolean validateToken(String token) {
		try {
		JSONObject jsonToken = tokenDecoder(token);
		Long exp = (Long) jsonToken.get("exp");
		Timestamp expiredTime = new Timestamp(exp * 1000);
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Boolean isExpired = expiredTime.before(currentTime);
		String username = (String) jsonToken.get("username");
		return !isExpired && username.equals("admin");
	}
		catch(NullPointerException e) {
			return false;
		}
	}
	
}
