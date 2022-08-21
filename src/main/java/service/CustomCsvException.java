package service;

public class CustomCsvException extends Exception {

    public enum ExceptionType {
        INCORRECT_FILE, IMPROPER_CSV
    }

    public ExceptionType type;

    public CustomCsvException(String message) {
	public CustomCsvException(String message, ExceptionType type) {
            super(message);
            this.type = type;
        }
    }
}