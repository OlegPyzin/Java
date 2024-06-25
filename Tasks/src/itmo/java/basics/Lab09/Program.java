package itmo.java.basics.Lab09;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        System.out.println("Соберем команду игроков.");
        Map<User,Integer> game = new HashMap<>();

        addPlayers(game);

        System.out.println("Команда игроков:");
        for(Map.Entry<User,Integer> player: game.entrySet() ) {
            System.out.println(player.getKey().getName() + " стартует с " +player.getValue() + " очками.");
        }
        System.out.println("\n==================================\n");
        System.out.println("Команда создана,");
        System.out.println("\nПроведем сеанс игры.");
        nextGame(game);
        getPlayerInfo(game);
    }

    public static void addPlayers(Map<User,Integer>game) {
        String inputName;
        Integer tmpValue;
        Scanner getHuman = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.println("Введите имя игрока, или Enter для завершения ввода");
            inputName = getHuman.nextLine();
            if(inputName.length() != 0) {
                // Сгенерируем начальное число очков
                tmpValue = random.nextInt(50);
                // Добавим игрока
                game.put(new User(inputName), tmpValue);
            }
        } while ( inputName.length() != 0 );
    }

    public static void nextGame(Map<User,Integer>game) {
        Integer tmpValue;
        Random random = new Random();

        for(Map.Entry<User,Integer> player: game.entrySet() ) {
            tmpValue = random.nextInt(50);
            tmpValue += player.getValue();
            player.setValue(tmpValue);
        }
    }

    public static void getPlayerInfo(Map<User,Integer>game) {
        String inputName;
        Integer cntPlayers=0;
        Scanner getHuman = new Scanner(System.in);

        do {
            System.out.println("Введите имя игрока для получения количества очков,\nили Enter для завершения ввода");
            inputName = getHuman.nextLine();
            if (inputName.length() != 0) {
                for (Map.Entry<User, Integer> player : game.entrySet()) {
                    String name = player.getKey().getName();
                    if (name.equalsIgnoreCase(inputName)) {
                        System.out.println(player.getValue());
                        cntPlayers++;
                    }
                }
                if(cntPlayers==0) {
                    System.out.println("Не найдено ни одного игрока с таким ["+inputName+"] именем. Повторите ввод.");
                }
            }
        } while (inputName.length() != 0 && cntPlayers==0);
        if (cntPlayers > 1) {
            System.out.println("У вас в игре несколько игроков с одним и тем же именем.");
        }
    }
}
