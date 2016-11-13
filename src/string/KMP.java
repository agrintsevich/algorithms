package string;

/**
 * Knutt Morris Pratt algorithm to find index of substring in string
 */
public class KMP extends AbstractSearchStringAlgorithm {

    /**
     * @param text text
     * @param word word to be searched
     * @return first index of word in text or -1 if word doesn't occurs it text
     */
    public int search(final String text, final String word) {
        int i = 0;
        int m = 0;
        final int[] table = computeTable(word);

        while (m + i < text.length()) {
            if (word.charAt(i) == text.charAt(m + i)) {
                if (i == word.length() - 1) {
                    return m;
                }
                i += 1;
            } else {
                if (table[i] > -1) {
                    m = m + i - table[i];
                    i = table[i];
                } else {
                    m = m + 1;
                    i = 0;
                }
            }
        }
        return NOT_FOUND;
    }

    private int[] computeTable(final String w) {
        final int[] table = new int[w.length()];
        table[0] = -1;
        table[1] = 0;
        int lastMatch = 0;
        int p = 2;
        while (p < table.length) {
            if (w.charAt(p - 1) == w.charAt(lastMatch)) {
                lastMatch++;
                table[p] = lastMatch;
                p++;
                continue;
            }
            if (lastMatch != 0) {
                lastMatch = table[lastMatch];
                continue;
            }
            table[p] = lastMatch;
            p++;
        }
        return table;
    }
}
