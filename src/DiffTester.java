import java.io.FileNotFoundException;

public class DiffTester
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println(MarkChenDiff.Diff("abcddef", "vdfaddwf"));
        System.out.println(MarkChenDiff.Diff("friends", "afraid"));
        System.out.println(MarkChenDiff.Diff("delicious", "indiginous"));
        System.out.println(MarkChenDiff.Diff("shalom", "saaalaaam"));
        System.out.println(MarkChenDiff.Diff("happy", "shipshape"));
    }
}