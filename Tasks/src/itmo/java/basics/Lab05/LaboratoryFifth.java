package itmo.java.basics.Lab05;

public class LaboratoryFifth {
    public static void main(String[] args) {

        StudyString studyString = new StudyString();

        String str = studyString.findLongWord("Привет дорогой Джон");
        System.out.println( "Самое длинное слово = [" + str + "]" );

        str = studyString.findLongWord("Написать метод для поиска самого дддддлинного слова в тексте.");
        System.out.println( "Самое длинное слово = [" + str + "]" );

        String test = new String("obalabo");
        System.out.println( studyString.isPolindrom( test ) ? "Полиндром" : "Не полиндром" );

        test = "qoleddewoq";
        System.out.println( studyString.isPolindrom( test ) ? "Полиндром" : "Не полиндром" );

        test = "павлилвап";
        System.out.println( studyString.isPolindrom( test ) ? "Полиндром" : "Не полиндром" );


        test = "Напишите метод, заменяющий бяка в тексте все бяка вхождения слова «бяка» на «[вырезано цензурой]»";

        System.out.println( studyString.replace( test, "бяка", "[вырезано цензурой]"));

        System.out.println( studyString.howManySubstring( test, "бяка" ) );

        test = "This is a test string";
        System.out.println( "[" + studyString.reverseWords( test ) +"]" );
        System.out.println( "[" + studyString.reverseWordsSecond( test ) +"]" );


        System.out.println( "[" + studyString.reverseWords("Hello World" ) +"]" );
        System.out.println( "[" + studyString.reverseWordsSecond("Hello World" ) +"]" );
    }
}
