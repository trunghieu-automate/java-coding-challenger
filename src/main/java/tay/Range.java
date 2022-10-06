package tay;

public class Range {
    private final int lowerBound;
    private final int upperBound;
    private static Range instance = null;

    private ContainRange containRange = ContainRange.closed;

    private Range(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("lowerBound value cannot be greater than upper value");
        }
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    private Range(int lowerBound, int upperBound, ContainRange range) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("lowerBound value cannot be greater than upper value");
        }
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.containRange = range;
    }


    public static Range of(int lowerBound, int upperBound) {
        if (instance == null)
            instance = new Range(lowerBound, upperBound);
        return instance;
    }

    public boolean contains(int number) {
        switch (containRange) {
            case open :return number > lowerBound && number < upperBound;
            case openClosed : return number > lowerBound && number <= upperBound;
            case closedOpen : return number >= lowerBound && number < upperBound;
            case closed :
            default: return number >= lowerBound && number <= upperBound;
        }
    }

    public static Range open(int lowerBound, int upperBound) {
        return new Range(lowerBound, upperBound, ContainRange.open);
    }

    public static Range closed(int lowerBound, int upperBound) {
        return new Range(lowerBound, upperBound, ContainRange.closed);
    }

    public static Range openClosed(int lowerBound, int upperBound) {
        return new Range(lowerBound, upperBound, ContainRange.openClosed);
    }

    public static Range closedOpen(int lowerBound, int upperBound) {
        return new Range(lowerBound, upperBound, ContainRange.closedOpen);
    }
}

enum ContainRange {
    open, closed, openClosed, closedOpen
}
