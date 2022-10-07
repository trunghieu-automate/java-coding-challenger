package challenge001;

public final class Range<T extends Comparable<T>>{
    private final T upperbound;
    private final T lowerbound;

    public static class RangeType{
        static String type;
    }

    private Range(T lowerbound, T upperbound){
        if(lowerbound.compareTo(upperbound) > 0){
            throw new IllegalArgumentException("Lowerbound should be less than upperbound");
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    private Range(T lowerbound, T upperbound, String type){
            if(lowerbound.compareTo(upperbound) > 0){
                throw new IllegalArgumentException("Lowerbound should be less than upperbound");
            }
            this.lowerbound = lowerbound;
            this.upperbound = upperbound;
            RangeType.type = type;
        }

        public  static <T extends Comparable<T>> Range of(T lowerbound, T upperbound){
        return new Range(lowerbound, upperbound, "closed");
    }

    public static <T extends Comparable<T>> Range<T> open(T lowerbound, T upperbound) {
        return new Range<>(lowerbound, upperbound, "open");
    }
    public static  <T extends Comparable<T>> Range closed(T lowerbound, T upperbound){
        return new Range(lowerbound, upperbound, "closed");
    }
    public static  <T extends Comparable<T>> Range openClosed(T lowerbound, T upperbound){
        return new Range(lowerbound, upperbound, "openClosed");
    }
    public static  <T extends Comparable<T>> Range closedOpen(int lowerbound, int upperbound){
        return new Range(lowerbound, upperbound, "closedOpen");
    }

    public boolean contains(T number){
        switch (RangeType.type){
            case "open": return number.compareTo(lowerbound) > 0 && number.compareTo(upperbound) < 0;
            case "openClosed": return number.compareTo(lowerbound) > 0 && number.compareTo(upperbound) <= 0;
            case "closedOpen": return number.compareTo(lowerbound) >= 0 && number.compareTo(upperbound) < 0;
            case "closed":
            default: return number.compareTo(lowerbound) >= 0 && number.compareTo(upperbound) <= 0;
        }
    }
}
