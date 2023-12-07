package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        // Start the backtracking process
        backtrack(candidates, target, 0, currentList, result);

        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> currentList, List<List<Integer>> result) {
        // Base case: if remaining becomes 0, add the current combination to the result
        if (remaining == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Explore all possible combinations
        for (int i = start; i < candidates.length; i++) {
            // Skip candidates if they are greater than the remaining target
            if (candidates[i] <= remaining) {
                // Choose
                currentList.add(candidates[i]);

                // Explore
                backtrack(candidates, remaining - candidates[i], i, currentList, result);

                // Unchoose (backtrack)
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
