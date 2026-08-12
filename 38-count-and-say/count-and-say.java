class Solution {
    public String countAndSay(int n) {
        String result = "1";

        // Generate the sequence up to the nth term
        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;

            // Traverse the previous result
            for (int j = 1; j < result.length(); j++) {
                // If current character matches previous, increment count
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    // Append count and character to current result
                    current.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }

            // Append the last group
            current.append(count).append(result.charAt(result.length() - 1));

            // Update result for next iteration
            result = current.toString();
        }

        // Return the final result
        return result;
    }
}