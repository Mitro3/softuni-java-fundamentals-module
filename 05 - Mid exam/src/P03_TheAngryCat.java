import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> priceList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int entryIndex = Integer.parseInt(scanner.nextLine());

        String itemsType = scanner.nextLine();
        int entryPointValue = priceList.get(entryIndex);
        int leftSum = 0;
        int rightSum = 0;

        if (itemsType.equals("cheap")) {
            for (int i = 0; i < entryIndex; i++) {
                if (priceList.get(i) < entryPointValue) {
                    leftSum += priceList.get(i);
                }
            }

            for (int i = priceList.size() - 1; i > entryIndex; i--) {
                if (priceList.get(i) < entryPointValue) {
                    rightSum += priceList.get(i);
                }
            }
        } else if (itemsType.equals("expensive")) {
            for (int i = 0; i < entryIndex; i++) {
                if (priceList.get(i) >= entryPointValue) {
                    leftSum += priceList.get(i);
                }
            }

            for (int i = priceList.size() - 1; i > entryIndex; i--) {
                if (priceList.get(i) >= entryPointValue) {
                    rightSum += priceList.get(i);
                }
            }
        }

        if (leftSum >= rightSum) {
            System.out.printf("Left - %d", leftSum);
        } else {
            System.out.printf("Right - %d", rightSum);
        }

    }
}
