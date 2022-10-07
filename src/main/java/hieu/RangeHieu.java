package hieu;

public final class RangeHieu<T extends Comparable<T>>{
    private final T upperbound;
    private final T lowerbound;

    public static class RangeType{
        static String type;
    }

    private RangeHieu(T lowerbound, T upperbound){
        if(lowerbound.compareTo(upperbound) > 0){
            throw new IllegalArgumentException("Lowerbound should be less than upperbound");
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    private RangeHieu(T lowerbound, T upperbound, String type){
            if(lowerbound.compareTo(upperbound) > 0){
                throw new IllegalArgumentException("Lowerbound should be less than upperbound");
            }
            this.lowerbound = lowerbound;
            this.upperbound = upperbound;
            RangeType.type = type;
        }

        public  static <T extends Comparable<T>> RangeHieu of(T lowerbound, T upperbound){
        return new RangeHieu(lowerbound, upperbound, "closed");
    }

    public static <T extends Comparable<T>> RangeHieu<T> open(T lowerbound, T upperbound) {
        return new RangeHieu<>(lowerbound, upperbound, "open");
    }
    public static  <T extends Comparable<T>> RangeHieu closed(T lowerbound, T upperbound){
        return new RangeHieu(lowerbound, upperbound, "closed");
    }
    public static  <T extends Comparable<T>> RangeHieu openClosed(T lowerbound, T upperbound){
        return new RangeHieu(lowerbound, upperbound, "openClosed");
    }
    public static  <T extends Comparable<T>> RangeHieu closedOpen(int lowerbound, int upperbound){
        return new RangeHieu(lowerbound, upperbound, "closedOpen");
    }

    public boolean contains(T number){
        switch (RangeType.type){
            case "open": return upperbound.compareTo(lowerbound) < 0 && lowerbound.compareTo(number) > 0 ;
            case "openClosed": return upperbound.compareTo(number) < 0 && lowerbound.compareTo(number) >= 0;
            case "closedOpen": return upperbound.compareTo(number) <= 0 && lowerbound.compareTo(number) > 0;
            case "closed":
            default: return upperbound.compareTo(number) <= 0 && lowerbound.compareTo(number) >= 0;
        }
    }
}
