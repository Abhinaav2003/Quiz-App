import java.util.ArrayList;

public class ResultStore {

    // Stores all student results
    public static ArrayList<Result> results = new ArrayList<>();

    // Add a new result
    public static void addResult(Result result) {
        results.add(result);
    }

    // Get all results
    public static ArrayList<Result> getResults() {
        return results;
    }

    // Get result by index
    public static Result getResult(int index) {

        if (index >= 0 && index < results.size()) {
            return results.get(index);
        }

        return null;
    }

    // Total results
    public static int getResultCount() {
        return results.size();
    }

    // Clear all results
    public static void clearResults() {
        results.clear();
    }
}