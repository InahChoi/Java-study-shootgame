import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 위험요소를 만났을 때의 이벤트 처리

public class MoveAndSituation {
  public static int[] rooms = { 0, 1, 2, 3 };
  public static int[][] links = { { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 }, { 0, 1, 2 } };

  public static String MONSTER = "Monster";
  public static String ARROW = "Arrow";
  public static String CLIFF = "Cliff";
  public static String NOTHING = "Nothing";

  public static String[] hazards = { NOTHING, MONSTER, ARROW, CLIFF };

  public static int currentRoom = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("지금 " + currentRoom + "번 방에 있습니다.");

      int[] nextRooms = links[currentRoom];

      System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요.");
      System.out.println(Arrays.toString(nextRooms));

      int roomNumber = scanner.nextInt();

      move(roomNumber);
    }
  }

  // 플레이어가 이동할 때 이동과 이벤트들을 처리하는 메소드
  private static void move(int room) {
    // 입력한 방으로 이동한다.
    currentRoom = room;

    String hazardInRoom = hazards[currentRoom];

    // 몬스터가 있는 방에 들어간 경우
    if (hazardInRoom.equals(MONSTER)) {
      System.out.println("몬스터에게 잡아 먹혔습니다.");
      System.out.println("게임을 종료합니다.");
      // TO DO. Game over 처리
    }

    // 화살이 날아다니는 방에 들어간 경우
    else if (hazardInRoom.equals(ARROW)) {
      System.out.println("화살에 맞았습니다.");
    }

    // 절벽이 있는 방에 들어간 경우
    else if (hazardInRoom.equals(CLIFF)) {
      System.out.println("절벽에 떨어져 다른 방으로 이동 됩니다.");

      Random random = new Random();

      // 절벽이 없는 방이 나올 때 까지 랜덤하게 방을 선택한다.
      do {
        currentRoom = random.nextInt(rooms.length);
      } while (hazards[currentRoom].equals(CLIFF));

      hazards[room] = NOTHING; // 절벽인 방을 이동시키기 위해 원래 방의 절벽을 제거한다.

      while (true) {
        // 절벽인 방을 이동시킬 정수를 랜덤하게 선택한다.
        int newCliffRoom = random.nextInt(rooms.length);

        // 선택된 방이 플레이어가 있는 방이라면 방을 다시 선택한다.
        if (newCliffRoom == currentRoom) {
          continue;
        }

        // 선택된 방에 플레이어, 위험요소가 없다면 절벽을 배치한다.
        if (hazards[newCliffRoom].equals(NOTHING)) {
          hazards[newCliffRoom] = CLIFF;
          break;
        }
      }
      move(currentRoom); // 플레이어가 절벽에 떨어졌을 때 옮겨질 방 위치로 move한다.
    }
  }
}
