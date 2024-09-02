package club.controller.validator;

public abstract class CommonsValidator {
	
	public void isValidString(String element, String value) throws Exception {
		if(value.equals("")) {
			throw new Exception (element + " can not be an empty field");
		}
	}
	
	public int isValidInteger(String element, String value) throws Exception {
		isValidString(element,value);
		try {
			return Integer.parseInt(value); 
		} catch (Exception e) {
			throw new Exception(element + " must be a valid value");
		}
	}
	
	public long isValidLong(String element, String value) throws Exception {
		isValidString(element, value);
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			throw new Exception(element + " must be a valid value");
		}
	}
	
	public double isValidDouble(String element, String value) throws Exception {
		isValidString(element, value);
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			throw new Exception(element + " must be a valid value");
		}
	}
	
	
}

