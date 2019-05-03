package notjava;

import java.util.ArrayList;
import java.util.Optional;

public class Contacts {

    public LetterNode root = new LetterNode();

    public int[] contacts(String[][] queries) {
        ArrayList<Integer> counts = new ArrayList<>();
        for (String[] q : queries) {
            if (q[0].equals("add"))
                root.add(q[1]);
            else
                counts.add(root.countOf(q[1]));

        }
        return counts.stream().mapToInt(e -> e).toArray();
    }

}


class LetterNode {
    public int occurrences = 0;
    public char letter;
    public ArrayList<LetterNode> nexts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() && ((LetterNode) o).letter == letter;
    }

    public void add(String s) {
        LetterNode current = this;
        for (char c : s.toCharArray()) {
            Optional<LetterNode> first = current.nexts.stream().filter(e -> e.letter == c).findFirst();
            if (first.isPresent())
                current = first.get();
            else {
                LetterNode thenew = new LetterNode();
                current.nexts.add(thenew);
                current = thenew;
                current.letter = c;

            }
            current.occurrences = current.occurrences + 1;
        }
    }

    public int countOf(String s) {
        LetterNode current = this;
        for (char c : s.toCharArray()) {
            Optional<LetterNode> first = current.nexts.stream().filter(e -> e.letter == c).findFirst();
            if (first.isPresent())
                current = first.get();
            else
                return 0;

        }
        return current.occurrences;
    }
}