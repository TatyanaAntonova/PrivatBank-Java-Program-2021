package hw4;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {
    private static ArrayList<String> wordList1 = new ArrayList<>();
    private static ArrayList<String> wordList2 = new ArrayList<>();

    public Anagram(String input1, String input2) {
        Pattern pattern = Pattern.compile("([А-Яа-яЁёA-Za-z]+)");
        Matcher matcher1 = pattern.matcher(input1);
        Matcher matcher2 = pattern.matcher(input2);

        while (matcher1.find()) {
            wordList1.add(matcher1.group().toLowerCase());
        }
        while (matcher2.find()) {
            wordList2.add(matcher2.group().toLowerCase());
        }
    }

    /**
     * @param list1
     * @param list2
     * @return 1, if all lists' objects are equal
     * 0, if all lists' objects aren't equal
     * -1, if some lists' objects are equal or all lists' objects have size = 1
     */
    private static int compareListObj(ArrayList<String> list1, ArrayList<String> list2) {
        List<String> equalObjList = new ArrayList<>();
        int countOneLetterWord = 0;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    equalObjList.add(list2.get(j));
                    if (list2.get(j).length() == 1) countOneLetterWord++;
                    break;
                }
            }
        }

        if (countOneLetterWord == list1.size()) return -1;
        else if (equalObjList.size() - countOneLetterWord == 0) return 0;
        else if (equalObjList.size() == list1.size()) return 1;

        return -1;
    }

    private static void sortLettersInArrayList(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            char[] chars = arrayList.get(i).toCharArray();
            Arrays.sort(chars);
            StringBuilder stringBuilder = new StringBuilder();

            for (char ch : chars) {
                stringBuilder.append(ch);
            }

            arrayList.set(i, stringBuilder.toString());
        }
    }

    private static boolean isAnagram() {
        if (wordList1.size() != wordList1.size()) {
            return false;
        }

        if (compareListObj(wordList1, wordList2) != 0) return false;

        sortLettersInArrayList(wordList1);
        sortLettersInArrayList(wordList2);

        if (compareListObj(wordList1, wordList2) == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        Anagram anagram = new Anagram(input1, input2);
        if (anagram.isAnagram()) {
            System.out.println("It's an anagram");
        } else {
            System.out.println("It's not an anagram");
        }
    }
}
