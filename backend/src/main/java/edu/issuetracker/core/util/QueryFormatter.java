package edu.issuetracker.core.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;

import java.util.stream.Collectors;

@UtilityClass
public class QueryFormatter {

    private static final String COMMA = ",";

    public static String toOrderByString(Sort sort) {
        return sort.get()
                .map(order -> String.format("%s %s", order.getProperty(), order.getDirection()))
                .collect(Collectors.joining(COMMA));
    }
}
