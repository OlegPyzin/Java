/* Принятые допущения:
 * в методах осуществляющих суммирование и умножение с типами int и long
 * отсутствуют проверки на возможное переполнение результата операций
 * в связи с этим возможен вывод не совсем адекватной информации при
 * совершении операций
 */

package itmo.java.basics.Lab02;

public class Operate {

    public int summation(int theFirst, int theSecond) {
        int result;

        result = theFirst + theSecond;
        return result;
    }

    public long summation(long theFirst, long theSecond) {
        long result;

        result = theFirst + theSecond;
        return result;
    }

    public double summation(double theFirst, double theSecond) {
        double result;

        result = theFirst + theSecond;
        return result;
    }

    public int subtraction(int theFirst, int theSecond) {
        int result;

        result = theFirst - theSecond;
        return result;
    }

    public long subtraction(long theFirst, long theSecond) {
        long result;

        result = theFirst - theSecond;
        return result;
    }

    public double subtraction(double theFirst, double theSecond) {
        double result;

        result = theFirst - theSecond;
        return result;
    }

    public int multiplication(int theFirst, int theSecond) {
        int result;

        result = theFirst * theSecond;
        return result;
    }

    public long multiplication(long theFirst, long theSecond) {
        long result;

        result = theFirst * theSecond;
        return result;
    }

    public double multiplication(double theFirst, double theSecond) {
        double result;

        result = theFirst * theSecond;
        return result;
    }

    public double division(int theFirst, int theSecond) {
        double result;

        result = (double) theFirst / theSecond;
        return result;
    }

    public double division(long theFirst, long theSecond) {
        double result;

        result = (double) theFirst / theSecond;
        return result;
    }

    public double division(double theFirst, double theSecond) {
        double result;

        result = theFirst / theSecond;
        return result;
    }
}
