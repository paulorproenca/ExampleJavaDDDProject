package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class BusinessValidation {
    private BusinessValidation(){
        // ensure utility
    }

    public static void nonEmpty(final String arg, final String msg) {
        if(arg==null || arg.isEmpty())
            throw new IllegalArgumentException(msg);
    }

    public static void isEmail(final String arg, final String msg) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
                .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(arg);
        if(!matcher.find())
            throw new IllegalArgumentException(msg);
    }
}
