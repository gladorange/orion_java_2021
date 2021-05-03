import com.task1.MagicNumbers;
import com.task2.AttractionOpposites;

public class AppMain {
    public static void main(String[] args) {
        new MagicNumbers().printMagicNumber( MagicNumbers.getArrRandomNumbers(100,-100,100) );
        new AttractionOpposites().adjacentNumbers( AttractionOpposites.getArrRandomNumbers( 10 ) );
    }
}
