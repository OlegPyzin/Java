package itmo.java.basics.Lab09;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        System.out.println("Соберем команду игроков.");
        Map<User, Integer> game = new HashMap<>();

        addPlayers(game);

        System.out.println("Команда игроков:");
        for (Map.Entry<User, Integer> player : game.entrySet()) {
            System.out.println(player.getKey().getName() + " стартует с " + player.getValue() + " очками");
        }
        System.out.println("\n==================================\n");
        System.out.println("Команда создана,");

        System.out.println("\nПроведем сеанс игры.");
        nextGame(game);

        System.out.println("\nСеанс игры проведен.\nМожно посмотреть количество очков у игроков.\n");
        getPlayerInfo(game);
    }

    public static void addPlayers(Map<User,Integer>game) {
        String inputName;
        Integer tmpValue;
        int len;
        Scanner getHuman = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.println("Введите имя игрока, или Enter для завершения ввода");
            inputName = getHuman.nextLine();
            inputName = inputName.trim();
            len = inputName.length();
            if (len > 0) {
                // Сгенерируем начальное число очков
                tmpValue = random.nextInt(50);
                User player = new User(inputName);
                game.put(player, tmpValue);
            }
        } while (len != 0);
    }

    public static void nextGame(Map<User,Integer>game) {
        Integer tmpValue;
        Random random = new Random();

        for (Map.Entry<User, Integer> player : game.entrySet()) {
            tmpValue = random.nextInt(50);
            tmpValue += player.getValue();
            player.setValue(tmpValue);
        }
    }

    public static void getPlayerInfo(Map<User,Integer>game) {
        String inputName;
        int len;
        Integer intScoredPoints;
        Scanner getHuman = new Scanner(System.in);

        do {
            System.out.println("Введите имя игрока для получения количества очков,\nили Enter для завершения ввода");
            inputName = getHuman.nextLine();
            inputName = inputName.trim();
            len = inputName.length();

            if (len > 0) {
                User tmpPlayer = new User(inputName);
                intScoredPoints = game.get(tmpPlayer);
                if (intScoredPoints == null) {
                    System.out.println("Игрока с именем [" + inputName + "] нет в команде, повторите ввод");
                } else {
                    System.out.println("У игрока " + inputName + " " + intScoredPoints + " очков.");
                }
            }
        } while (len != 0);
    }
}
