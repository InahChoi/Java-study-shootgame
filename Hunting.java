import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 몬스터를 잡기 위함

public class Hunting {
  public static int[] rooms = { 0, 1, 2, 3 };
  public static int[][] links = { { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 }, { 0, 1, 2 } };

  public static String MONSTER = "Monster";
  public static String ARROW = "Arrow";
  public static String CLIFF = "Cliff";
  public static String NOTHING = "Nothing";

  public static String[] hazards = { NOTHING, MONSTER, ARROW, CLIFF };

  public static int currentRoom = 0;
  public static int monsterRoom = 3; // 몬스터가 있는 현재의 방 정수

  public static int arrowCount = 5; // 쏠 수 있는 화살의 개수

  public static Random random = new Random();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위해 Scanner를 import한다.

    while (true) {
      System.out.println("지금 " + currentRoom + "번 방에 있습니다."); // 시작 시에 몇 번 방에 위치해 있는지 표시한다.

      int[] nextRooms = links[currentRoom];

      System.out.println("어느 방에 화살을 쏘시겠습니까??");
      System.out.println(Arrays.toString(nextRooms)); // 현재 방 번호에서 이동할 수 있는 방의 목록을 표시한다.

      int roomNumber = scanner.nextInt(); // 플레이어로 부터 이동할 방의 정수를 입력 받는다.

      shoot(roomNumber);
    }
  }

  public static void shoot(int room) {
    if (hazards[room].equals(MONSTER)) {
      System.out.println("축하합니다! 당신은 몬스터를 물리쳤습니다!");
    } else {
      arrowCount = arrowCount - 1;

      if (arrowCount == 0) {
        System.out.println("당신은 몬스터 사냥에 실패했습니다.");
      } else if (random.nextInt(4) != 0) {
        System.out.println("몬스터가 깨어났습니다.");

        int[] nextRooms = links[monsterRoom];
        int nextRoom = nextRooms[random.nextInt(3)];

        if (hazards[nextRoom].equals(NOTHING)) {
          hazards[monsterRoom] = NOTHING;
          hazards[nextRoom] = MONSTER;
          monsterRoom = nextRoom;
        }

        if (monsterRoom == currentRoom) {
          System.out.println("몬스터가 당신을 잡아먹었습니다.");
          System.out.print("당신은 몬스터 사냥에 실패했습니다.");
        } else if (monsterRoom == nextRoom) {
          System.out.println("몬스터가 도망갔습니다.");
        }
      }
    }
  }
}