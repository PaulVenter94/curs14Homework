package ro.fasttrack.curs14homework.countries;

public enum Density {
    HIGH,
    AVERAGE,
    LOW;

    public static Density getType(long l) {
        if (l >= 1000) {
            return HIGH;
        } else if (l >= 200){
            return AVERAGE;
        }else {
            return LOW;
        }
    }
}
