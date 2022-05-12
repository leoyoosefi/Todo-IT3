package se.lexicon.util;

import java.util.function.BiConsumer;

public interface Validation {

    BiConsumer<String , String> checkStringNotNull = (value, paramName) -> {
        if (value == null) throw new IllegalArgumentException(paramName + " is null");
    };

    BiConsumer<String , String> checkNotEmpty = (value, paramName) -> {
        if (value.length() == 0) throw new IllegalArgumentException(paramName + " is empty");
    };

    BiConsumer<String , String> checkMaxLength20 = (value, paramName) -> {
        if (value.length() > 20) throw new IllegalArgumentException(paramName + " max length is not valid");
    };

    BiConsumer<String , String> checkMinLength3 = (value, paramName) -> {
        if (value.length() < 3) throw new IllegalArgumentException(paramName + " min length is not valid");
    };

}