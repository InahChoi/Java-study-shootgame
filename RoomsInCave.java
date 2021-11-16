import java.util.Arrays;
import java.util.Scanner;

public class RoomsInCave {
  public static void main(String[] args) {
    int[] rooms = { 0, 1, 2, 3 };
    int[][] links = { { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 }, { 0, 1, 2 } }; // 플레이어가 들어갈 수 있는 경우의 수의 방 배열을 정의한다.
    int currentRoom = 0; // 처음 플레이어가 있는 방의 번호를 정의한다.

    Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위해 Scanner를 import한다.

    while (true) {
      System.out.println("지금 " + currentRoom + "번 방에 있습니다."); // 시작 시에 몇 번 방에 위치해 있는지 표시한다.
      System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요.");

      System.out.println(Arrays.toString(links[currentRoom])); // 현재 방 번호에서 이동할 수 있는 방의 목록을 표시한다.

      int roomNumber = scanner.nextInt(); // 플레이어로 부터 이동할 방의 정수를 입력 받는다.

      currentRoom = roomNumber; // 0이었던 currentRoom의 정수 값을 플레이어로 부터 받은 정수 값으로 변경한다.
    }
  }
}