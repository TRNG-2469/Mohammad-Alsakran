```markdown
# Prompt Log

## Week 1 - Monday

### Exercise: Array Analyzer
**Prompt:** 
**Output:** 
**Notes:** 

---

### Exercise: Guessing Game
**Prompt:** 
**Output:** 
**Notes:** 

---

### Exercise: Primitives Practice
**Prompt:** 
**Output:** 
**Notes:** 

---

## Week 1 - Tuesday

### Exercise: Palindrome Checker
**Prompt:** See prompt-log-palindromes.md
**Output:** See prompt-log-palindromes.md
**Notes:** See prompt-log-palindromes.md
```

## Week 1 - Wedensday

### Exercise: String-manipulation-exercise

**Prompt:** IDE Auto suggested the block of code when I typed the signiture for countVowels

**Output:** public static int countVowels(String s){
        if (s == null) {
            return 0;
        }
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

**Notes:** Initially approached this with a HashSet style solution to store vowels for O(1) lookup, similar to a LeetCode optimization pattern. After reviewing the exercise requirements, the spec only asks for a count using primitive loops and charAt() with no mention of data structure requirements. The IDE suggestion used a simple conditional chain which technically satisfies the constraints. Accepted it after verifying it matched the manual approach requirements. The experience highlights a risk: IDE completions can silently bypass the learning objective if not audited before accepting.
```
