package lab1;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.out;

public class CountSorted 
{

	private static Path file_path = Paths.get("text.txt");

    public static void main(String[] args) throws Exception
    {
        try (Stream<String> lines = Files.lines(file_path))
        {
        	 Map<String, Long> wordCount =
                     lines.flatMap(line -> Stream.of(line.split("\\W+")))
                     .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
            wordCount.forEach((word, count) -> {
                out.println(String.format("Слово '%s'; Кількість зустрічань у тексті: %s ", word, count));
            });         
        }       

    }
}
