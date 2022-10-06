public final class Range {
    private final int upperbound;
    private final int lowerbound;

    public static class RangeType{
        static String type;
    }


    private Range(int lowerbound, int upperbound){
        if(lowerbound>upperbound){
            throw new IllegalArgumentException("Lowerbound should be less than upperbound");
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    private Range(int lowerbound, int upperbound, String type){
        if(lowerbound>upperbound){
            throw new IllegalArgumentException("Lowerbound should be less than upperbound");
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        RangeType.type = type;
    }

    public static Range of(int lowerbound, int upperbound){
        return new Range(lowerbound, upperbound, "closed");
    }

    public static Range open(int lowerbound, int upperbound){
        return new Range(lowerbound, upperbound, "open");
    }
    public static Range closed(int lowerbound, int upperbound){
        return new Range(lowerbound, upperbound, "closed");
    }
    public static Range openClosed(int lowerbound, int upperbound){
        return new Range(lowerbound, upperbound, "openClosed");
    }
    public static Range closedOpen(int lowerbound, int upperbound){
        return new Range(lowerbound, upperbound, "closedOpen");
    }

    public boolean contains(int number){
        switch (RangeType.type){
            case "open": return number < upperbound && number > lowerbound;
            case "openClosed": return number <= upperbound && number > lowerbound;
            case "closedOpen": return number < upperbound && number >= lowerbound;
            case "closed":
            default: return number <= upperbound && number >= lowerbound;
        }
    }
}
