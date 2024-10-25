package generated;

import com.xmlparsers.candies.comparator.CandiesEnergyComparator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CandiesTest {

    @Test
    void testSortCandiesByEnergy() {
        Candies candies = new Candies();
        candies.setEmptyListOfCandies();

        Candies.Candy candy1 = new Candies.Candy();
        candy1.setName("Lindor Chocolate");
        candy1.setEnergy(47);

        Candies.Candy candy2 = new Candies.Candy();
        candy2.setName("Ferrero Rocher");
        candy2.setEnergy(35);

        Candies.Candy candy3 = new Candies.Candy();
        candy3.setName("Milky Way");
        candy3.setEnergy(42);

        candies.addCandy(candy1);
        candies.addCandy(candy2);
        candies.addCandy(candy3);

        // Act: Sort the candies by Energy value in ascending order
        candies.sortCandies(new CandiesEnergyComparator());

        // Assert: Verify that the candies are sorted by Energy
        List<Candies.Candy> sortedCandies = candies.getCandies();
        assertEquals("Ferrero Rocher", sortedCandies.get(0).getName());
        assertEquals("Milky Way", sortedCandies.get(1).getName());
        assertEquals("Lindor Chocolate", sortedCandies.get(2).getName());
    }
}