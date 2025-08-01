package series;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Queries {

    public static void main(String[] args) {
        List<Series> list = DB.getInstance().coll;
        Map<Genre, List<Series>> oldiesByGenre = new HashMap<>();
        for (Series series: list) {
            if (series.getYear() <= 2000) {
                Genre genre = series.getGenre();
                List<Series> seriesOfThisGenre = oldiesByGenre.get(genre);
                if (seriesOfThisGenre == null) {
                    seriesOfThisGenre = new ArrayList<>();
                    oldiesByGenre.put(genre, seriesOfThisGenre);
                }
                seriesOfThisGenre.add(series);
            }
        }
        oldiesByGenre = list.stream()
                .filter((Series s) -> s.getYear() <= 2000)
                .collect(groupingBy(Series::getGenre));

        // computing a list of oldies title, sorted by increasing release date (Java 7)
        List<Series> oldies = new ArrayList<>();
        for(Series s: list) {
            if (s.getYear() <= 2000) {
                oldies.add(s);
            }
        }
        Collections.sort(oldies, new Comparator<Series>() {
            public int compare(Series s1, Series s2) {
                return Integer.compare(s1.getYear(), s2.getYear());
            }
        });
        List<String> titles = new ArrayList<>();
        for(Series s: oldies) {
            titles.add(s.getTitle());
        }
        // Java 8 version
        List<String> titles2 = list
                .stream()
                .filter(s -> s.getYear() <= 2000)
                .sorted(comparing(Series::getYear))
                .map(Series::getTitle)
                .collect(toList());
        System.out.println(titles2);
    }
}
