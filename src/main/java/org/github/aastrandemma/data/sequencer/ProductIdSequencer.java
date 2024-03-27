package org.github.aastrandemma.data.sequencer;

public class ProductIdSequencer {
    private static int sequencer = 0;

    public static int nextProductId() {
        return ++sequencer;
    }
}