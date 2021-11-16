import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 위험요소의 힌트 메시지 출력

public class HazardInRooms {
  public static void main(String[] args) {
    int[] rooms = { 0, 1, 2, 3 };

    String MONSTER = "Monster";
    String ARROW = "Arrow";
    String CLIFF = "Cliff";
    String NOTHING = "Nothing";

    String[] hazards = { NOTHING, MONSTER, ARROW, CLIFF };

    HashMap<String, String> hazardMessages = new HashMap<>(); // map 변수를 선언한다.

    hazardMessages.put(MONSTER, "\"엄청나게 으스스하다.\"");
    hazardMessages.put(ARROW, "\"어디선가 화살이 날아올 것 같다.\"");
    hazardMessages.put(CLIFF, "\"바람 부는 소리가 들리는 것 같다.\"");
    hazardMessages.put(NOTHING, "\"저 방에는 아무것도 없는 것 같다.\"");

    int[][] links = { { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 }, { 0, 1, 2 } };

    int currentRoom = 0;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("지금 " + currentRoom + "번 방에 있습니다."); // 시작 시에 몇 번 방에 위치해 있는지 표시해줍니다.

      // 현재 방에서 갈 수 있는 방들의 목록
      int[] nextRooms = links[currentRoom];

      // 방 번호들에 대해 반복문을 실행하면서
      // hazards 배열에서 방 번호에 해당하는 요소를 출력한다.
      for (int nextRoom : nextRooms) {
        String hazard = hazards[nextRoom]; // 방 번호에 해당하는 위험요소를 가져온다.
        String message = hazardMessages.get(hazard); // 위험요소에 해당하는 메시지를 가져온다.
        System.out.println(message);
      }

      System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요.");
      System.out.println(Arrays.toString(nextRooms)); // 현재 방 번호에서 이동할 수 있는 방의 목록을 표시한다.

      int roomNumber = scanner.nextInt(); // 플레이어로 부터 이동할 방의 정수를 입력 받는다.

      currentRoom = roomNumber; // 0이었던 currentRoom의 정수 값을 플레이어로 부터 받은 정수 값으로 변경한다.
    }
  }
}
