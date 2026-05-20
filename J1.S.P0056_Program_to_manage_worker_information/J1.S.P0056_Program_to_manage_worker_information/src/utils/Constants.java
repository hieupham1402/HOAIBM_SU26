package utils;

/**
 * Stores common constants used by the Worker Management program.
 */
public final class Constants {

    public static final int MIN_AGE = 18;
    public static final int MAX_AGE = 50;
    public static final double MIN_MONEY = 0.0;
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String TEXT_REGEX = "^[\\p{L}]+(\\s+[\\p{L}]+)*$";
    public static final String WORKER_CODE_REGEX = "[Ww]\\d+";

    /**
     * Prevents creating Constants objects.
     */
    private Constants() {
    }
}
