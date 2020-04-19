import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        BigDecimal money = BigDecimal.valueOf(10000);

        BigDecimal rate = BigDecimal.valueOf(0.0008D);

        int day = 240;

        for (int i = 0; i < day; i++) {
            money = money.add(money.multiply(rate));
        }
        System.out.println(money);

    }

}
