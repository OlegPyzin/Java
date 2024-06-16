package itmo.java.basics.Lab05;

public class StudyString {

    public String findLongWord(String str) {
        int maxLengthWord = 0;
        int lengthWord;
        int index = 0;

        String[] tmpStr = str.split(" ");

        for (int i = 0; i < tmpStr.length; i++) {
            lengthWord = tmpStr[i].length();
            if (lengthWord > maxLengthWord) {
                maxLengthWord = lengthWord;
                index = i;
            }
        }

        return tmpStr[index];
    }

    public boolean isPolindrom( String str ) {

        StringBuilder tmpStr = new StringBuilder(str);
        StringBuilder tmpStr1 = new StringBuilder(str);

        tmpStr1 = tmpStr1.reverse();

        if (tmpStr.compareTo(tmpStr1) == 0) {
            return true;
        }
        return false;
    }

    public String replace( String str, String what, String whereWith ) {
        str = str.replaceAll( what, whereWith );
        return str;
    }

    public int howManySubstring(String str, String what) {
        int count = 0;
        int index = 0;

        while (index >= 0) {
            index = str.indexOf(what, index);
            if (index >= 0) {
                count++;
            } else {
                break;
            }
            index = str.indexOf(' ', index); // перескакиваем найденное слово до следующего пробела
        }

        return count;
    }

    public String reverseWords(String str) {
        int startWord;
        int endWord;
        int length;
        char ch;
        int i;
        int j;

        str = str.trim(); // убираем все лишние пробелы

        StringBuilder tempStr = new StringBuilder(str);

        length = tempStr.length();
        startWord = 0;
        endWord = tempStr.indexOf(" ", startWord);
        if (endWord < 0) {
            endWord = length;
        }

        // реверсируем первое слово
        for (i = startWord, j = endWord - 1; i <= j; i++, j--) {
            ch = tempStr.charAt(i);
            tempStr.setCharAt(i, tempStr.charAt(j));
            tempStr.setCharAt(j, ch);
        }

        while (endWord < length) {
            // получаем следующее слово
            if (endWord < length) {
                //tempStr.setCharAt(endWord+1, ' ');
                startWord = endWord + 1; // двигаемся вперед с последнего символа слова + пробел
                endWord = tempStr.indexOf(" ", startWord);
                if (endWord < 0) {
                    endWord = length;
                }
            }
            // реверсируем слово
            for (i = startWord, j = endWord - 1; i <= j; i++, j--) {
                ch = tempStr.charAt(i);
                tempStr.setCharAt(i, tempStr.charAt(j));
                tempStr.setCharAt(j, ch);
            }
        }
        str = tempStr.toString();

        return str;
    }

    public String reverseWordsSecond (String str) {
        int len;
        String[] words =  str.split(" ");
        StringBuilder temp = new StringBuilder();
        StringBuilder tempReverse = new StringBuilder();

        len = words.length;

        for (int i=0; i<len; i++) {
            if( tempReverse.length()>0) {
                tempReverse.delete(0,tempReverse.length());
            }
            tempReverse = tempReverse.append( words[i] );
            tempReverse = tempReverse.reverse();
            temp = temp.append( tempReverse );
            if( i<len-1) {
                temp = temp.append(" ");
            }
        }
        return temp.toString();
    }
}
