class Solution {
    private final String[] map;

    // Constructor to initialize the mapping of digits to characters
    public Solution() {
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    
    private void helper(String digits, List<String> ans, int index, String current) {
        
        if (index == digits.length()) {
            
            ans.add(current);
            return;
        }

        
        String s = map[digits.charAt(index) - '0'];

        
        for (int i = 0; i < s.length(); i++) {
            
            helper(digits, ans, index + 1, current + s.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(); // List to store results
        
        // Return empty list if digits string is empty
        if (digits.length() == 0) return ans;
        
        // Initiate recursive function
        helper(digits, ans, 0, "");
        return ans; // Return the result
    }
}