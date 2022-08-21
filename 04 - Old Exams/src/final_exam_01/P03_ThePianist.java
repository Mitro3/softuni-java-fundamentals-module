package final_exam_01;
import java.util.*;

public class P03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPieces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int piece = 1; piece <= countPieces ; piece++) {
            String pieceData = scanner.nextLine();
            String[] piecePart = pieceData.split("\\|");
            String pieceName = piecePart[0];
            String composer = piecePart[1];
            String tone = piecePart[2];

            List<String> pieceInfo = new ArrayList<>();
            pieceInfo.add(composer);
            pieceInfo.add(tone);
            piecesMap.put(pieceName, pieceInfo);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String currPiece = command.split("\\|")[1];
            if (command.contains("Add")) {
                if (isPieceInserted(piecesMap, currPiece)) {
                    System.out.println(currPiece + " is already in the collection!");
                } else {
                    String currComposer = command.split("\\|")[2];
                    String currTone = command.split("\\|")[3];

                    List<String> currPieceInfo = new ArrayList<>();
                    currPieceInfo.add(currComposer);
                    currPieceInfo.add(currTone);

                    piecesMap.put(currPiece, currPieceInfo);
                    System.out.printf("%1$s by %2$s in %3$s added to the collection!%n",
                            currPiece, currComposer, currTone);
                }

            } else if (command.contains("Remove")) {
                if (isPieceInserted(piecesMap, currPiece)) {
                    piecesMap.remove(currPiece);
                    System.out.printf("Successfully removed %s!%n", currPiece);
                } else {
                    System.out.printf("Invalid operation! %s " +
                            "does not exist in the collection.%n", currPiece);
                }

            } else if (command.contains("ChangeKey")) {
                if (isPieceInserted(piecesMap, currPiece)) {
                    String newKey = command.split("\\|")[2];
                    List<String> currPieceInfo = piecesMap.get(currPiece);
                    currPieceInfo.add(1, newKey);
                    piecesMap.put(currPiece, currPieceInfo);

                    System.out.printf("Changed the key of %s to %s!%n",
                            currPiece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s " +
                            "does not exist in the collection.%n", currPiece);
                }
            }

            command = scanner.nextLine();
        }

        //"{Piece} -> Composer: {composer}, Key: {key}"
        piecesMap.entrySet()
                .forEach(entry -> System.out.printf("%s -> Composer: %s, " +
                                "Key: %s%n", entry.getKey(),
                        entry.getValue().get(0),
                        entry.getValue().get(1)));
    }

    private static boolean isPieceInserted(Map<String, List<String>> piecesMap, String currPiece) {
        return (piecesMap.containsKey(currPiece));
    }
}
