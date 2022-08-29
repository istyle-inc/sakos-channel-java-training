package book;

import java.util.ArrayList;
import java.util.List;

public class BookApp {
    /**
     *
     * @param books
     * @param toBeAdded
     * @return
     */
    public List<Book> シチュエーション1_本のリストに重複なく本を足したい(List<Book> books, Book... toBeAdded) {
        var result = new ArrayList<>(books);
        var actualAdditions = new ArrayList<Book>();
        for (Book candidate : toBeAdded) {
            var foundDuplicationInList = false;
            var foundDuplicationInAddition = false;
            for (Book alreadyInList : books) {
                if (alreadyInList.sameAs(candidate)) {
                    foundDuplicationInList = true;
                    break;
                }
            }
            if (!foundDuplicationInList) {
                for (Book actualAddition : actualAdditions) {
                    if (actualAddition.sameAs(candidate)) {
                        foundDuplicationInAddition = true;
                        break;
                    }
                }
                if (!foundDuplicationInAddition) {
                    actualAdditions.add(candidate);
                }
            }
            foundDuplicationInList = false;
            foundDuplicationInAddition = false;
        }
        result.addAll(actualAdditions);
        return result;
    }
}
