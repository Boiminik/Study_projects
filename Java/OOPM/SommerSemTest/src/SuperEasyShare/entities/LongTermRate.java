package SuperEasyShare.entities;

public class LongTermRate extends Rate {
    private int baseAmount;
    private int baseDuration;
    private int perDay;

    public LongTermRate(int baseAmount, int perDay) {
        this.baseAmount = baseAmount;
        this.perDay = perDay;
    }

    @Override
    public String toString() {
        return "LongTermRate{" +
                "baseAmount=" + baseAmount +
                ", baseDuration=" + baseDuration +
                ", perDay=" + perDay +
                '}';
    }
    public int total(Trip t){
        if (t.duration()/60/60/24 >= baseDuration)
            return baseAmount + (perDay *(t.duration()/60/60/24-baseDuration));
        else
            return baseAmount;
    }
}
