package itmo.java.basics.Lab05;

public class StudyString {

    public int findLongWord( String str ) {
        int index;
        int newIndex;
        int length;
        int lengthWord;

        str = str.trim(); // убираем все лишние пробелы
        str = str + ' ';  // Добавим в конец строки пробел чтобы работал алгоритм
        length = str.length() - 1;
        lengthWord = 0;
        index = 0;
        while ( index < length ) {
            newIndex = str.indexOf( ' ', index );
            if ( lengthWord <= (newIndex - index) ) {
                lengthWord = newIndex - index;
            }
            index = newIndex + 1; // указатель на следйющий символ после пробела
        }

        return lengthWord;
    }

    public boolean isPolindrom( String str ) {
        int i;
        int j;

        str = str.toLowerCase();
        for( i=0, j=str.length()-1; i<=j; i++, j-- ) {
            if( str.charAt(i) != str.charAt(j) ) {
                return false;
            }
        }
        return true;
    }

    public String replace( String str, String what, String whereWith ) {
        str = str.replaceAll( what, whereWith );
        return str;
    }

    public int howManySubstring( String str, String what ) {
       int count = 0;
       int index = 0;

       while( index >= 0 ) {
           index = str.indexOf( what, index );
           if ( index >= 0) {
               count++;
           } else {
               break;
           }
           index = str.indexOf(' ', index); // перескакиваем найденное слово до следующего пробела
       }

       return count;
    }

    public String reverseWords( String str ) {
        int startWord;
        int endWord;
        int length;
        char ch;
        int i;
        int j;

        str = str.trim(); // убираем все лишние пробелы

        //str = str + ' ';

        StringBuilder tempStr = new StringBuilder( str );

        length = tempStr.length();
        startWord = 0;
        endWord = tempStr.indexOf( " ", startWord );
        if ( endWord < 0) {
            endWord = length;
        }

        // реверсируем первое слово
        for (i = startWord, j = endWord-1; i <= j; i++, j--) {
            ch = tempStr.charAt(i);
            tempStr.setCharAt(i, tempStr.charAt(j));
            tempStr.setCharAt(j, ch);
        }

        while( endWord < length ) {
            // получаем следующее слово
            if( endWord < length ) {
                //tempStr.setCharAt(endWord+1, ' ');
                startWord = endWord + 1; // двигаемся вперед с последнего символа слова + пробел
                endWord = tempStr.indexOf(" ", startWord);
                if (endWord < 0) {
                    endWord = length;
                }
            }
            // реверсируем слово
            for (i = startWord, j = endWord-1; i <= j; i++, j--) {
                ch = tempStr.charAt(i);
                tempStr.setCharAt(i, tempStr.charAt(j));
                tempStr.setCharAt(j, ch);
            }
        }
    str = tempStr.toString();

    return str;
    }
}
