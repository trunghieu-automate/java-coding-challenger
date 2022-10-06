package hieu;

public final class RangeHieu {
    private final int upperbound;
    private final int lowerbound;

    public static class RangeType{
        static String type;
    }


    private RangeHieu(int lowerbound, int upperbound){
        if(lowerbound>upperbound){
            throw new IllegalArgumentException("Lowerbound should be less than upperbound");
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    private RangeHieu(int lowerbound, int upperbound, String type){
        if(lowerbound>upperbound){
            throw new IllegalArgumentException("Lowerbound should be less than upperbound");
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        RangeType.type = type;
    }

    public static RangeHieu of(int lowerbound, int upperbound){
        return new RangeHieu(lowerbound, upperbound, "closed");
    }

    public static RangeHieu open(int lowerbound, int upperbound){
        return new RangeHieu(lowerbound, upperbound, "open");
    }
    public static RangeHieu closed(int lowerbound, int upperbound){
        return new RangeHieu(lowerbound, upperbound, "closed");
    }
    public static RangeHieu openClosed(int lowerbound, int upperbound){
        return new RangeHieu(lowerbound, upperbound, "openClosed");
    }
    public static RangeHieu closedOpen(int lowerbound, int upperbound){
        return new RangeHieu(lowerbound, upperbound, "closedOpen");
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
