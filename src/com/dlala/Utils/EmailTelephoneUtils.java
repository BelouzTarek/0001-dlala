package com.dlala.Utils;

import org.apache.commons.validator.routines.EmailValidator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class EmailTelephoneUtils {
	
	public static void checkPhoneNumber(String phoneNumberStr) throws NumberParseException,IllegalArgumentException {
		
		if (phoneNumberStr == null || phoneNumberStr.length() == 0) {
			throw new IllegalArgumentException("Le <strong>numero du téléphone</strong> n'est pas valide");
		}

		if (!phoneNumberStr.contains("+213")) {
			phoneNumberStr = "+213" + phoneNumberStr;
		}

		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(phoneNumberStr, null);
		// throws NumberParseException

		if (!phoneUtil.isValidNumber(phoneNumber)) {
			throw new IllegalArgumentException(phoneNumberStr + " n'est pas un téléphone valide");
		}
	}
	
	public static void checkEmail(String email) throws Exception {
		boolean valid = EmailValidator.getInstance().isValid(email);
		
		if(null == email || email.isEmpty()) {
			throw new Exception("L'<strong>Email</strong> n'est pas valide");
		}
		
		if(!valid) {
			throw new Exception("<strong>"+ email +"</strong> n'est pas un email valide");
		}
	}

}
