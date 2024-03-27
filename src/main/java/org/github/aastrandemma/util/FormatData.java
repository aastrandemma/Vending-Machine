package org.github.aastrandemma.util;

import java.text.DecimalFormat;

public class FormatData {
    public static String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }
}