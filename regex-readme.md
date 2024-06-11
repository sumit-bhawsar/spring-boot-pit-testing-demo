Hidden world of Regex
## Introduction

Regular Expressions, commonly known as regexes, are a powerful tool for text processing and pattern matching. Java provides robust support for regex through the `java.util.regex` package, enabling developers to efficiently handle string operations, validate input, and perform complex searches. In this blog, we'll dive into the fundamentals of regex in Java, explore common use cases, and provide practical examples to help you harness the power of regular expressions in your Java applications.

## What are Regular Expressions?

Regular expressions are sequences of characters that define a search pattern. They are used to match strings within text, allowing for advanced searching, editing, and manipulation. Regex patterns can be simple, such as matching a single character, or complex, involving multiple characters, quantifiers, and assertions.

## The Basics of Regex Syntax

Before we get into Java-specific implementations, let's understand some basic regex components:

- **Literals:** Directly match the specified characters. For example, `abc` matches "abc".
- **Character Classes:** Match any one of a set of characters. For example, `[abc]` matches "a", "b", or "c".
- **Predefined Character Classes:** Shorthand notations for common classes. For example, `\d` matches any digit, and `\w` matches any word character.
- **Quantifiers:** Specify the number of occurrences to match. For example, `a*` matches zero or more "a"s, and `a{3}` matches exactly three "a"s.
- **Anchors:** Assert the position in the string. For example, `^` asserts the start of a string, and `$` asserts the end of a string.
- **Groups and Alternations:** Group patterns and allow alternatives. For example, `(abc|def)` matches "abc" or "def".

### Using Regex in Java

Java's `java.util.regex` package provides the `Pattern` and `Matcher` classes to work with regex. Here's a quick overview of how to use these classes:

1. **Creating a Pattern:**
   ```java
   import java.util.regex.Pattern;

   Pattern pattern = Pattern.compile("your-regex-here");
   ```

2. **Creating a Matcher:**
   ```java
   import java.util.regex.Matcher;

   Matcher matcher = pattern.matcher("your-input-string-here");
   ```

3. **Using the Matcher:**
   The `Matcher` class provides various methods to work with the input string:
    - `matches()`: Checks if the entire input string matches the regex.
    - `find()`: Finds the next occurrence of the regex in the input string.

#### Practical Examples

Let's look at some practical examples to see how regex can be used in Java.

1. **Validating an Email Address:**
   ```java
   String email = "example@example.com";
   String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(email);

   if (matcher.matches()) {
       System.out.println("Valid email address.");
   } else {
       System.out.println("Invalid email address.");
   }
   ```

2. **Extracting Phone Numbers:**
   ```java
   String text = "Contact us at 123-456-7890 or 987-654-3210.";
   String regex = "\\d{3}-\\d{3}-\\d{4}";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(text);

   while (matcher.find()) {
       System.out.println("Found phone number: " + matcher.group());
   }
   ```

3. **Replacing Text:**
   ```java
   String input = "The color is blue.";
   String regex = "\\bcolor\\b";
   String replacement = "colour";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   String result = matcher.replaceAll(replacement);
   System.out.println(result);  // Output: The colour is blue.
   ```



## Predefined Character Classes in Java Regex

One of the key features that make regex so versatile is the use of predefined character classes. These classes simplify the task of creating patterns by providing shorthand notations for commonly used sets of characters. They save time and make regex patterns more readable by eliminating the need to manually specify large or complex sets of characters.

Here's a list of the most commonly used predefined character classes in Java:

- `\d`: Represents any digit (equivalent to `[0-9]`).
- `\D`: Represents any non-digit character (equivalent to `[^0-9]`).
- `\w`: Represents any word character, which includes letters, digits, and underscores (equivalent to `[a-zA-Z0-9_]`).
- `\W`: Represents any non-word character (equivalent to `[^a-zA-Z0-9_]`).
- `\s`: Represents any whitespace character, including spaces, tabs, and line breaks (equivalent to `[ \t\n\x0B\f\r]`).
- `\S`: Represents any non-whitespace character (equivalent to `[^ \t\n\x0B\f\r]`).

### Using Predefined Character Classes in Java

Let's see some examples to demonstrate how these predefined character classes can be used in Java regex patterns.

1. **Matching Digits:**
   ```java
   String input = "The price is 123 dollars.";
   String regex = "\\d+"; // One or more digits

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   while (matcher.find()) {
       System.out.println("Found digit sequence: " + matcher.group());
   }
   ```

   Output:
   ```
   Found digit sequence: 123
   ```

2. **Matching Non-Digit Characters:**
   ```java
   String input = "Phone number: 123-456-7890.";
   String regex = "\\D+"; // One or more non-digit characters

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   while (matcher.find()) {
       System.out.println("Found non-digit sequence: " + matcher.group());
   }
   ```

   Output:
   ```
   Found non-digit sequence: Phone number: 
   Found non-digit sequence: -
   Found non-digit sequence: -
   Found non-digit sequence: .
   ```

3. **Matching Word Characters:**
   ```java
   String input = "User123_name";
   String regex = "\\w+"; // One or more word characters

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   while (matcher.find()) {
       System.out.println("Found word sequence: " + matcher.group());
   }
   ```

   Output:
   ```
   Found word sequence: User123_name
   ```

4. **Matching Non-Word Characters:**
   ```java
   String input = "Hello, World!";
   String regex = "\\W+"; // One or more non-word characters

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   while (matcher.find()) {
       System.out.println("Found non-word sequence: " + matcher.group());
   }
   ```

   Output:
   ```
   Found non-word sequence: , 
   Found non-word sequence: ! 
   ```

5. **Matching Whitespace Characters:**
   ```java
   String input = "Line 1\nLine 2\tTabbed";
   String regex = "\\s+"; // One or more whitespace characters

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   while (matcher.find()) {
       System.out.println("Found whitespace sequence: '" + matcher.group() + "'");
   }
   ```

   Output:
   ```
   Found whitespace sequence: ' '
   Found whitespace sequence: '
   '
   Found whitespace sequence: '	'
   ```

6. **Matching Non-Whitespace Characters:**
   ```java
   String input = "Whitespace    and\ttabs";
   String regex = "\\S+"; // One or more non-whitespace characters

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   while (matcher.find()) {
       System.out.println("Found non-whitespace sequence: " + matcher.group());
   }
   ```

   Output:
   ```
   Found non-whitespace sequence: Whitespace
   Found non-whitespace sequence: and
   Found non-whitespace sequence: tabs
   ```

#### Combining Predefined Character Classes

You can combine predefined character classes with other regex constructs to create more complex patterns. For example, to match a sequence that starts with a word character followed by digits, you can use:

```java
String input = "User123 and User456";
String regex = "\\w+\\d+"; // One or more word characters followed by one or more digits

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    System.out.println("Found sequence: " + matcher.group());
}
```

Output:
```
Found sequence: User123
Found sequence: User456
```


## Using the `Matcher` Methods in Java Regex

The `Matcher` class in Java, part of the `java.util.regex` package, is a powerful tool for performing regex operations on strings. Once you have compiled a regex pattern using the `Pattern` class, you can use a `Matcher` object to find, match, and manipulate text based on that pattern. 

#### Creating a Matcher

Before using the `Matcher` methods, you need to create a `Matcher` object. Here's a quick refresher on how to do that:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

String regex = "your-regex-here";
String input = "your-input-string-here";

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);
```

#### Common `Matcher` Methods

Let's go through some of the most commonly used `Matcher` methods and see how they work with practical examples.

1. **`matches()`**: Checks if the entire input string matches the regex pattern.

   ```java
   String input = "hello123";
   String regex = "\\w+\\d+";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   if (matcher.matches()) {
       System.out.println("The entire string matches the pattern.");
   } else {
       System.out.println("The entire string does not match the pattern.");
   }
   ```

   Output:
   ```
   The entire string matches the pattern.
   ```

2. **`find()`**: Finds the next subsequence of the input string that matches the regex pattern.

   ```java
   String input = "Find the numbers 123 and 456 in this text.";
   String regex = "\\d+";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   while (matcher.find()) {
       System.out.println("Found a match: " + matcher.group());
   }
   ```

   Output:
   ```
   Found a match: 123
   Found a match: 456
   ```

3. **`group()`**: Returns the matched subsequence. This method is used after a successful match or find operation.

   ```java
   String input = "Email: example@example.com";
   String regex = "\\w+@\\w+\\.com";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   if (matcher.find()) {
       System.out.println("Found email: " + matcher.group());
   }
   ```

   Output:
   ```
   Found email: example@example.com
   ```

4. **`start()` and `end()`**: Return the start and end indices of the matched subsequence.

   ```java
   String input = "Look for the word 'Java' in this sentence.";
   String regex = "Java";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   if (matcher.find()) {
       System.out.println("Found 'Java' at index: " + matcher.start());
       System.out.println("'Java' ends at index: " + matcher.end());
   }
   ```

   Output:
   ```
   Found 'Java' at index: 18
   'Java' ends at index: 22
   ```

5. **`replaceAll()`**: Replaces every subsequence of the input string that matches the regex pattern with a replacement string.

   ```java
   String input = "This is a test. This is another test.";
   String regex = "test";
   String replacement = "example";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   String result = matcher.replaceAll(replacement);
   System.out.println(result);
   ```

   Output:
   ```
   This is a example. This is another example.
   ```

6. **`replaceFirst()`**: Replaces the first subsequence of the input string that matches the regex pattern with a replacement string.

   ```java
   String input = "This is a test. This is another test.";
   String regex = "test";
   String replacement = "example";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   String result = matcher.replaceFirst(replacement);
   System.out.println(result);
   ```

   Output:
   ```
   This is a example. This is another test.
   ```

7. **`lookingAt()`**: Checks if the beginning of the input string matches the regex pattern.

   ```java
   String input = "Java is fun.";
   String regex = "Java";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   if (matcher.lookingAt()) {
       System.out.println("The beginning of the string matches the pattern.");
   } else {
       System.out.println("The beginning of the string does not match the pattern.");
   }
   ```

   Output:
   ```
   The beginning of the string matches the pattern.
   ```

8. **`groupCount()`**: Returns the number of capturing groups in the pattern.

   ```java
   String input = "John (123) Doe";
   String regex = "(\\w+)\\s\\((\\d+)\\)\\s(\\w+)";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(input);

   if (matcher.find()) {
       System.out.println("Total capturing groups: " + matcher.groupCount());
       for (int i = 0; i <= matcher.groupCount(); i++) {
           System.out.println("Group " + i + ": " + matcher.group(i));
       }
   }
   ```

   Output:
   ```
   Total capturing groups: 3
   Group 0: John (123) Doe
   Group 1: John
   Group 2: 123
   Group 3: Doe
   ```


## Using Group Index for Replacement in Java Regex

In Java regex, capturing groups are an incredibly useful feature that allows you to isolate parts of your matched text for further processing. When you want to replace text based on these groups, you can use the `Matcher` class methods (as shown above) to reference and manipulate these groups.

#### What are Capturing Groups?

Capturing groups are parts of your regex pattern enclosed in parentheses `()`. They allow you to extract specific portions of the matched text. Each capturing group is assigned a unique index, starting from 1 (with the entire match being group 0).

For example, in the pattern `(\w+)@(\w+)\.(\w+)`, there are three capturing groups:
- Group 1: `(\w+)` matches the part before the `@`.
- Group 2: `(\w+)` matches the part between the `@` and `.`.
- Group 3: `(\w+)` matches the part after the `.`.

#### Replacing Using Group Index

To replace text using group indices, you can use the `Matcher` methods such as `replaceAll` or `replaceFirst` in conjunction with references to these groups.

1. **Referencing Groups in Replacement Strings**

In the replacement string, you can reference groups using `$n`, where `n` is the group index. For example, `$1` refers to the first capturing group, `$2` to the second, and so on.

Here's how you can use group indices for replacements:

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupReplacementExample {
    public static void main(String[] args) {
        String input = "John's email is john.doe@example.com and Jane's email is jane.doe@sample.org";
        String regex = "(\\w+)\\.(\\w+)@(\\w+\\.\\w+)";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        // Replacing the email addresses with a new format using groups
        String replacement = "$1_$2@$3";
        
        String result = matcher.replaceAll(replacement);
        System.out.println(result);
    }
}
```
Output:
```
John's email is john_doe@example.com and Jane's email is jane_doe@sample.org
```

In this example, the regex pattern captures different parts of the email address, and the replacement string `$1_$2@$3` rearranges these parts with an underscore `_` between the first and last name.

1. **Switching the Order of Names**

Suppose you have a string with names in the format "Last, First" and you want to switch them to "First Last":

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwitchNames {
    public static void main(String[] args) {
        String input = "Doe, John; Smith, Jane; Brown, Bob";
        String regex = "(\\w+),\\s(\\w+)";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        // Switching "Last, First" to "First Last"
        String replacement = "$2 $1";
        
        String result = matcher.replaceAll(replacement);
        System.out.println(result);
    }
}
```

Output:
```
John Doe; Jane Smith; Bob Brown
```

2. **Formatting Phone Numbers**

Suppose you have phone numbers in different formats and you want to standardize them to `(123) 456-7890`:

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatPhoneNumbers {
    public static void main(String[] args) {
        String input = "Call me at 123-456-7890 or 9876543210.";
        String regex = "(\\d{3})[- ]?(\\d{3})[- ]?(\\d{4})";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        // Formatting phone numbers to (123) 456-7890
        String replacement = "($1) $2-$3";
        
        String result = matcher.replaceAll(replacement);
        System.out.println(result);
    }
}
```

Output:
```
Call me at (123) 456-7890 or (987) 654-3210.
```

3. **Reordering Date Formats**

Suppose you have dates in the format `dd-mm-yyyy` and you want to change them to `yyyy/mm/dd`:

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReorderDates {
    public static void main(String[] args) {
        String input = "Today's date is 05-06-2023. Another date is 12-11-2022.";
        String regex = "(\\d{2})-(\\d{2})-(\\d{4})";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        // Reordering date format to yyyy/mm/dd
        String replacement = "$3/$2/$1";
        
        String result = matcher.replaceAll(replacement);
        System.out.println(result);
    }
}
```

Output:
```
Today's date is 2023/06/05. Another date is 2022/11/12.
```








### Understanding Backtracking in Java Regex

One of the mechanisms that make regex so powerful is backtracking. Backtracking is a feature of regex engines that allows them to explore different ways of matching a pattern against an input string.
When the regex engine faced with a choice point (a part of the regex that can match in multiple ways), tries one possibility. If that fails, it backtracks and tries the next possibility. This continues until a match is found or all possibilities are exhausted.

For example, consider the regex pattern `(a|b)c` applied to the string "ac":
- The engine first tries to match "a" (because it appears first in the alternation `a|b`).
- If "a" matches, it moves on to try to match "c".
- If any step fails, the engine backtracks to the alternation and tries the next possibility, "b".

#### How Backtracking Works in Java Regex

Let's look at an example to see how backtracking operates in a simple pattern.

1. **Example: Simple Alternation**

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BacktrackingExample {
    public static void main(String[] args) {
        String input = "ac";
        String regex = "(a|b)c";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.matches()) {
            System.out.println("Pattern matches the input.");
        } else {
            System.out.println("Pattern does not match the input.");
        }
    }
}
```

In this example, the pattern `(a|b)c` will match the input "ac" because the engine first tries "a", matches "a", then moves on to match "c".

2. **Example: Greedy Quantifiers**

Greedy quantifiers (e.g., `*`, `+`, `?`, `{n,m}`) cause the regex engine to match as much text as possible initially, then backtrack if necessary.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GreedyBacktrackingExample {
    public static void main(String[] args) {
        String input = "aaa";
        String regex = "a+";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        while (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
        }
    }
}
```

In this case, `a+` (one or more "a"s) matches the entire string "aaa" in one go, without needing to backtrack.

#### Avoiding Performance Issues with Backtracking

While backtracking is powerful, it can also lead to performance issues, especially with complex patterns and large input strings. These issues are often referred to as "catastrophic backtracking."

1. **Example: Catastrophic Backtracking**

Consider the pattern `"(a+)+b"` and the input "aaaaaaaaaaaaaaaaaaaaaaaaaaac". This pattern can cause catastrophic backtracking because the regex engine will try many different ways to match the input before finally failing.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CatastrophicBacktrackingExample {
    public static void main(String[] args) {
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaac";
        String regex = "(a+)+b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.matches()) {
            System.out.println("Pattern matches the input.");
        } else {
            System.out.println("Pattern does not match the input.");
        }
    }
}
```

To avoid performance issues, follow these best practices:

1. **Avoid Nested Quantifiers:** Nested quantifiers (e.g., `"(a+)+"`) can lead to excessive backtracking. Rewrite patterns to avoid them.

2. **Use Atomic Groups or Possessive Quantifiers:** These constructs prevent backtracking within a specific part of the pattern.

    - **Atomic Group:** `(?>...)`
    - **Possessive Quantifiers:** `*+`, `++`, `?+`, `{n,m}+`


### Atomic Group

An atomic group is a non-capturing group that once matched, does not backtrack. This can be particularly useful in preventing catastrophic backtracking in cases where the regex engine would otherwise spend excessive time exploring different matching paths.

#### Syntax:

An atomic group is denoted by `(?>...)`.

#### Example:

Consider the following input string:

```java
String input = "aaaaab";
```

And the regex pattern:

```java
String regex = "(?>a+)b";
```

This pattern ensures that once the "a+" sequence is matched, it will not backtrack, leading to better performance, especially with large input strings.

   Example using an atomic group:

   ```java
   String regex = "(?>a+)b";
   ```

   Example using a possessive quantifier:

   ```java
   String regex = "a++b";
   ```


### Non-Greedy Quantifiers (Possessive Quantifiers)

Non-greedy quantifiers, also known as reluctant quantifiers, match as little text as possible while still allowing the overall pattern to match. They are denoted by appending a `?` to the standard quantifiers (`*`, `+`, `?`, `{n}`, `{n,}`, `{n,m}`).

#### Example:

Consider the following input string:

```java
String input = "aaaab";
```

And the regex pattern:

```java
String regex = "a+?";
```

This pattern will match the shortest possible sequence of "a" characters, which is just one "a".


### Combined Example:

Let's illustrate the use of non-greedy quantifiers and atomic groups together:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NonGreedyAndAtomicExample {
    public static void main(String[] args) {
        String input = "aaaaab";
        String regex = "(?>a+?)b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
        }
    }
}
```

In this example, the pattern `(?>a+?)b` matches the shortest sequence of "a" characters followed by "b" in the input string "aaaaab". The atomic group ensures that once the "a+" sequence is matched, it will not backtrack, leading to efficient pattern matching.


#### Practical Example: Improving Performance

Let's rewrite the earlier example to improve performance using possessive quantifiers:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ImprovedPerformanceExample {
    public static void main(String[] args) {
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaac";
        String regex = "a++b"; // Using possessive quantifier
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.matches()) {
            System.out.println("Pattern matches the input.");
        } else {
            System.out.println("Pattern does not match the input.");
        }
    }
}
```

In this improved example, the possessive quantifier `a++` ensures that the regex engine doesn't backtrack once it matches as many "a"s as possible, leading to better performance.

#### 1. Lookahead and Lookbehind Assertions

Lookahead and lookbehind assertions, collectively known as "lookarounds," allow you to assert the presence or absence of text without including it in the match. Lookahead assertions check what follows the current position, while lookbehind assertions check what precedes it.

1. **Lookahead Assertion:**

    - **Positive Lookahead (`?=`):** Asserts that what follows the current position matches the given pattern. 

   Example: Matching a word followed by a digit.

   ```java
   import java.util.regex.Pattern;
   import java.util.regex.Matcher;

   public class LookaheadExample {
       public static void main(String[] args) {
           String input = "foo1 bar2 baz3";
           String regex = "\\w+(?=\\d)";

           Pattern pattern = Pattern.compile(regex);
           Matcher matcher = pattern.matcher(input);

           while (matcher.find()) {
               System.out.println("Found word followed by a digit: " + matcher.group());
           }
       }
   }
   ```

   Output:
   ```
   Found word followed by a digit: foo
   Found word followed by a digit: bar
   Found word followed by a digit: baz
   ```
   - **Negative Lookahead (`?!`):** Asserts that what follows the current position does not match the given pattern.
   Example: Matching "bananas" preceded by "apples, "
   ```java
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
   
   public class NegativeLookbehindExample {
      public static void main(String[] args) {
         String input = "apples, bananas, oranges, bananas";
         String regex = "(?!apples), bananas";
   
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(input);
         
         while (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
         }
      }
   }

   ```
   Output:
   ```
   Found match: , bananas
   ```
   in this example the first occurrence of banana is preceded by apples
2. **Lookbehind Assertion:**

    - **Positive Lookbehind (`?<=`):** Asserts that what precedes the current position matches the given pattern.
    

   Example: Matching a digit preceded by a word.

   ```java
   import java.util.regex.Pattern;
   import java.util.regex.Matcher;

   public class LookbehindExample {
       public static void main(String[] args) {
           String input = "foo1 bar2 baz3";
           String regex = "(?<=\\w)\\d";

           Pattern pattern = Pattern.compile(regex);
           Matcher matcher = pattern.matcher(input);

           while (matcher.find()) {
               System.out.println("Found digit preceded by a word: " + matcher.group());
           }
       }
   }
   ```

   Output:
   ```
   Found digit preceded by a word: 1
   Found digit preceded by a word: 2
   Found digit preceded by a word: 3
   ```
- **Negative Lookbehind (`?<!`):** Asserts that what precedes the current position does not match the given pattern.
  Example: Matching "bananas" not preceded by "apples, "
   ```java
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
   
   public class NegativeLookbehindExample {
      public static void main(String[] args) {
         String input = "apples, bananas, oranges, bananas";
         String regex = "(?<!apples), bananas";
   
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(input);
         
         while (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
         }
      }
   }

   ```
  Output:
   ```
   Found match: , bananas
   ```
  in this example the second occurrence of banana is not preceded by apples
#### 2. Conditional Patterns

Conditional patterns in regex allow you to include conditional logic within your regex. This is useful for more complex pattern matching where certain matches depend on the presence of other patterns.

Example: Matching an HTML tag with or without attributes.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ConditionalPatternExample {
    public static void main(String[] args) {
        String input = "<div>content</div><div id='main'>content</div>";
        String regex = "<(\\w+)(?(?=\\s)\\s[^>]*?)>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Found tag: " + matcher.group());
        }
    }
}
```

Output:
```
Found tag: <div>
Found tag: <div id='main'>
```
`(?(?=\\s)\\s[^>]*?)`: This part is a conditional pattern.

- `(?(?=\\s)`: This starts a conditional expression. It checks if there's whitespace ahead.
- `\\s[^>]*?`: If there's whitespace ahead, this part matches whitespace followed by zero or more characters that are not the closing angle bracket `>`. The `*?` makes the quantifier lazy, matching as few characters as possible.

#### 3. Recursive Patterns

Java's regex engine does not support recursion directly within its regex syntax. However, you can achieve recursive-like behavior using a combination of regex features and additional Java code. Recursive patterns are often used for parsing nested structures, like matching nested parentheses or HTML tags.

Example: Matching nested parentheses.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RecursivePatternExample {
    public static void main(String[] args) {
        String input = "a(b(c)d)e";
        String regex = "\\(([^()]*(?:(?R)[^()]*)*)\\)";

        // Since Java doesn't support (?R) directly, we have to construct the pattern in a different way.
        // Below is a simplified example that only matches simple nested structures without true recursion.

        Pattern pattern = Pattern.compile("\\(([^()]*)\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Found nested parentheses: " + matcher.group());
        }
    }
}
```

Output:
```
Found nested parentheses: (c)
Found nested parentheses: (b(c)d)
```

#### 4. Combining Advanced Techniques

You can combine multiple advanced techniques to solve complex text processing problems. For example, you can use lookarounds and conditional patterns together.

Example: Matching a specific word only if it is not within quotes.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CombinedTechniquesExample {
    public static void main(String[] args) {
        String input = "The word 'example' should not be matched, but example should.";
        String regex = "(?<!')\\bexample\\b(?!')";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
        }
    }
}
```

Output:
```
Found match: example
```

#### 1. Flags (Modifiers)

Flags in regex can alter the way the pattern is interpreted. In Java, you can set flags either in the pattern string itself or when compiling the `Pattern` object.

**Example of Common Flags:**

- **Case Insensitivity (`i`)**: Makes the pattern case-insensitive.

   ```java
   import java.util.regex.Pattern;
   import java.util.regex.Matcher;
   
   public class FlagsExample {
       public static void main(String[] args) {
           String input = "Hello\nWorld";
           String regex = "(?i)hello"; // Case insensitive flag in pattern
   
           Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
           Matcher matcher = pattern.matcher(input);
   
           while (matcher.find()) {
               System.out.println("Found match: " + matcher.group());
           }
       }
   }
   ```

   Output:
   ```
   Found match: Hello
   ```

- **Multiline Mode (`m`)**: `^` and `$` match the start and end of each line, not just the start and end of the input string.
  ```java
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
   
   public class MultilineModeExample { 
     public static void main(String[] args) {
        String input = "Line 1\nLine 2\nLine 3";
        String regex = "^Line"; // Pattern to match lines starting with "Line"

        // Enable multiline mode using the Pattern.MULTILINE flag
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);

        // Iterate over matches
        while (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
        }
     }
   }
   ```

   Output:
   ```
   Found match: Line
   Found match: Line
   Found match: Line
   ```

In this example, each occurrence of "Line" at the beginning of a line within the input string is matched, thanks to the multiline mode enabled by the `Pattern.MULTILINE` flag.
- **Dotall Mode (`s`)**: The `.` matches any character, including a newline.

#### 2. Named Capturing Groups

Named capturing groups can make your regex patterns more readable and manageable, especially when dealing with complex patterns.
To define a named capturing group, use the syntax (?<name>pattern), where name is the name you want to assign to the capturing group, and pattern is the regular expression pattern you want to capture.

**Example:**

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NamedCapturingGroupsExample {
    public static void main(String[] args) {
        String input = "John Doe, email: john.doe@example.com";
        String regex = "(?<name>\\w+ \\w+), email: (?<email>\\S+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Name: " + matcher.group("name"));
            System.out.println("Email: " + matcher.group("email"));
        }
    }
}
```

Output:
```
Name: John Doe
Email: john.doe@example.com
```

#### 3. Unicode Support

Java regex supports Unicode, which is essential for working with international text. Unicode property escapes (`\p{...}`) allow you to match characters based on their Unicode properties.

**Example:**

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UnicodeSupportExample {
    public static void main(String[] args) {
        String input = "The price is €100";
        String regex = "\\p{Sc}"; // Matches any currency symbol

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Found currency symbol: " + matcher.group());
        }
    }
}
```

Output:
```
Found currency symbol: €
```

#### 4. Performance Optimization Techniques

Regex performance can be crucial, especially for large input texts. Here are some tips to optimize regex performance:

1. **Avoid Catastrophic Backtracking**: Simplify patterns to avoid excessive backtracking.
2. **Use Possessive Quantifiers**: `*+`, `++`, `?+`, etc., prevent backtracking.
3. **Precompile Patterns**: If you use a pattern multiple times, precompile it to avoid the overhead of compilation.

**Example:**

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PerformanceOptimizationExample {
    public static void main(String[] args) {
        String input = "aaaaab";
        String regex = "a++b"; // Possessive quantifier to prevent backtracking

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
        }
    }
}
```

Output:
```
Found match: aaaaab
```

#### 5. Common Pitfalls and How to Avoid Them

**1. Greedy vs. Lazy Quantifiers:**

Greedy quantifiers (`*`, `+`, `{n,m}`) match as much as possible, while lazy quantifiers (`*?`, `+?`, `{n,m}?`) match as little as possible.

**Example:**

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GreedyVsLazyExample {
    public static void main(String[] args) {
        String input = "<div>Content</div><div>More content</div>";
        String greedyRegex = "<.*>"; // Greedy
        String lazyRegex = "<.*?>"; // Lazy

        Pattern greedyPattern = Pattern.compile(greedyRegex);
        Matcher greedyMatcher = greedyPattern.matcher(input);

        System.out.println("Greedy match:");
        while (greedyMatcher.find()) {
            System.out.println(greedyMatcher.group());
        }

        Pattern lazyPattern = Pattern.compile(lazyRegex);
        Matcher lazyMatcher = lazyPattern.matcher(input);

        System.out.println("Lazy match:");
        while (lazyMatcher.find()) {
            System.out.println(lazyMatcher.group());
        }
    }
}
```

Output:
```
Greedy match:
<div>Content</div><div>More content</div>
Lazy match:
<div>Content</div>
<div>More content</div>
```

**2. Escaping Special Characters:**

Special characters in regex (`.`, `*`, `?`, `+`, `|`, `()`, `[]`, `{}`, `\`, `^`, `$`) need to be escaped with a backslash (`\`) to match them literally.

**Example:**

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EscapingSpecialCharactersExample {
    public static void main(String[] args) {
        String input = "The price is $100.";
        String regex = "\\$\\d+\\.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
        }
    }
}
```

Output:
```
Found match: $100.
```



#### Tips and Best Practices

- **Escape Special Characters:** In regex, certain characters have special meanings (e.g., `.`, `*`, `+`). Use double backslashes (`\\`) to escape these characters in Java strings.
- **Use Raw Strings:** To avoid excessive escaping, consider using raw strings (Java 13+) or character classes.
- **Test Your Patterns:** Utilize online regex testers and debuggers to fine-tune your patterns before implementing them in code.
- **Performance Considerations:** Regex can be computationally expensive for complex patterns and large inputs. Optimize your patterns and consider alternative approaches when necessary.

#### Conclusion

Regular expressions are a versatile and powerful tool for handling text in Java. By understanding the basic syntax and leveraging the `Pattern` and `Matcher` classes, you can efficiently perform a wide range of text processing tasks. Whether you're validating user input, searching for specific patterns, or transforming text, regex can simplify your code and enhance its functionality. Start experimenting with regex in your Java projects and unlock a new level of text processing capability.

#### Conclusion

Predefined character classes in Java regex provide a convenient and efficient way to work with common sets of characters. By using these shorthand notations, you can create more readable and maintainable regex patterns. Whether you're validating input, searching for patterns, or processing text, predefined character classes can simplify your regex tasks and improve your code's clarity. Start incorporating these powerful tools into your Java applications today!
#### Conclusion

The `Matcher` class in Java provides a wide array of methods that make regex operations flexible and powerful. By understanding and utilizing these methods, you can efficiently perform complex pattern matching and text manipulation tasks in your Java applications. Whether you're validating input, searching for specific patterns, or transforming text, the `Matcher` methods offer the tools you need to handle text with precision and ease. Start experimenting with these methods to unlock the full potential of regex in Java!



#### Conclusion

Using group indices for replacements in Java regex can significantly simplify text manipulation tasks. By capturing specific parts of your match and referencing them in your replacement string, you can easily reformat, reorder, and transform your text. Whether you're dealing with names, phone numbers, dates, or any other structured text, mastering group replacements in regex will enhance your ability to handle complex string operations efficiently. Start experimenting with these techniques in your Java projects to see how powerful and flexible regex can be!



### Conclusion:

Non-greedy quantifiers and atomic groups are advanced features in Java regex that provide finer control over pattern matching and can help improve performance, especially in scenarios where backtracking needs to be minimized. By incorporating these features into your regex patterns, you can make your text processing tasks more efficient and robust. Experiment with these concepts in your Java projects to see how they can enhance your regex skills and improve your code's performance.
Certainly! Building a regex for matching HTTP URLs involves understanding the structure of a URL and translating that structure into a regular expression pattern. Here’s a step-by-step guide from a developer's perspective:

### Step 1: Understand the URL Structure

A typical HTTP URL has the following components:
1. **Scheme:** `http://` or `https://`
2. **Host:** A domain name or IP address
3. **Port:** An optional port number, prefixed by a colon (`:`)
4. **Path:** The path to a resource, which starts with a slash (`/`)
5. **Query:** An optional query string, prefixed by a question mark (`?`)
6. **Fragment:** An optional fragment identifier, prefixed by a hash (`#`)

### Step 2: Start with the Scheme

Begin with matching the scheme (`http` or `https`):

```regex
http[s]?
```

- `http`: Matches the literal string "http".
- `[s]?`: Optionally matches "s", making the pattern match both "http" and "https".

### Step 3: Match the Host

The host can be a domain name or an IP address. For simplicity, let's match typical domain names:

```regex
http[s]?://([a-zA-Z0-9.-]+)
```

- `://`: Matches the literal "://".
- `([a-zA-Z0-9.-]+)`: Matches the domain name part, which can include letters, digits, dots, and hyphens.

### Step 4: Add Optional Port

The port number is optional and is prefixed by a colon:

```regex
http[s]?://([a-zA-Z0-9.-]+)(:[0-9]+)?
```

- `(:[0-9]+)?`: Optionally matches a colon followed by one or more digits.

### Step 5: Match the Path

The path starts with a slash and may include various characters:

```regex
http[s]?://([a-zA-Z0-9.-]+)(:[0-9]+)?(/[^?#]*)?
```

- `(/[^?#]*)?`: Optionally matches a slash followed by any characters except "?" and "#".

### Step 6: Add Optional Query

The query string starts with a question mark and includes key-value pairs:

```regex
http[s]?://([a-zA-Z0-9.-]+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*)?
```

- `(\\?[^#]*)?`: Optionally matches a question mark followed by any characters except "#".

### Step 7: Add Optional Fragment

The fragment starts with a hash and includes various characters:

```regex
http[s]?://([a-zA-Z0-9.-]+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*)?(#.*)?
```

- `(#.*)?`: Optionally matches a hash followed by any characters.

### Final Regex Pattern

Combining all these components, we get the final regex pattern for matching HTTP URLs:

```regex
http[s]?://([a-zA-Z0-9.-]+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*)?(#.*)?
```

### Example in Java

Here’s how you can use this regex pattern in a Java program:

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLRegexExample {
    public static void main(String[] args) {
        String regex = "http[s]?://([a-zA-Z0-9.-]+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*)?(#.*)?";
        String input = "http://example.com:80/path/to/resource?name=value#fragment";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Matched URL:");
            System.out.println("Full URL: " + matcher.group(0));
            System.out.println("Host: " + matcher.group(1));
            System.out.println("Port: " + (matcher.group(2) != null ? matcher.group(2) : "none"));
            System.out.println("Path: " + (matcher.group(3) != null ? matcher.group(3) : "none"));
            System.out.println("Query: " + (matcher.group(4) != null ? matcher.group(4) : "none"));
            System.out.println("Fragment: " + (matcher.group(5) != null ? matcher.group(5) : "none"));
        } else {
            System.out.println("The input does not match the URL pattern.");
        }
    }
}
```

### Explanation of Java Code

1. **Pattern Compilation:**
   - The regex pattern is compiled using `Pattern.compile(regex)`.

2. **Matching:**
   - A `Matcher` object is created to match the input string against the pattern.
   - The `matcher.matches()` method checks if the entire input string matches the pattern.

3. **Extracting Components:**
   - The `matcher.group()` method is used to extract various components of the matched URL.
   - `matcher.group(0)` gives the entire matched URL.
   - `matcher.group(1)` gives the host part.
   - `matcher.group(2)` gives the port part, if present.
   - `matcher.group(3)` gives the path part, if present.
   - `matcher.group(4)` gives the query string, if present.
   - `matcher.group(5)` gives the fragment, if present.

This example demonstrates how to construct a regex pattern for matching HTTP URLs and how to use it in a Java program to extract different components of a URL.

To use the regex for HTTP URL validation in a Spring application with JSR 303 (Bean Validation), you can define a custom validation annotation and validator. Here’s a step-by-step guide:

### Step 1: Create a Custom Annotation

Define a custom annotation that uses the regex for validating HTTP URLs.

```java
package com.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UrlValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUrl {
    String message() default "Invalid URL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
```

### Step 2: Create the Validator

Implement the validator logic using the regex pattern.

```java
package com.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UrlValidator implements ConstraintValidator<ValidUrl, String> {
    private static final String URL_PATTERN = "http[s]?://([a-zA-Z0-9.-]+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*)?(#.*)?";
    private static final Pattern pattern = Pattern.compile(URL_PATTERN);

    @Override
    public void initialize(ValidUrl constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        if (url == null || url.isEmpty()) {
            return true; // Use @NotNull for null checks
        }
        return pattern.matcher(url).matches();
    }
}
```

### Step 3: Use the Annotation in a Model

Apply the custom annotation to a field in your model class.

```java
package com.example.model;

import com.example.validation.ValidUrl;

import javax.validation.constraints.NotNull;

public class Website {
    
    @NotNull
    @ValidUrl
    private String url;

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
```

### Step 4: Create a Controller to Test Validation

Create a Spring controller to handle requests and test the validation.

```java
package com.example.controller;

import com.example.model.Website;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/websites")
@Validated
public class WebsiteController {

    @PostMapping
    public ResponseEntity<String> addWebsite(@RequestBody @Valid Website website) {
        return new ResponseEntity<>("URL is valid!", HttpStatus.OK);
    }
}
```

### Step 5: Test the Validation

To test the validation, you can use a tool like `curl`, Postman, or any HTTP client to send a POST request to your Spring application.

#### Example using `curl`:

```sh
curl -X POST -H "Content-Type: application/json" -d '{"url":"http://example.com"}' http://localhost:8080/api/websites
```

### Summary

Here's a quick recap of the steps:
1. **Create a Custom Annotation** (`@ValidUrl`).
2. **Implement the Validator** (`UrlValidator`).
3. **Use the Annotation** in your model class (`Website`).
4. **Create a Controller** to handle and validate the request.

With this setup, your Spring application can now validate HTTP URLs using JSR 303 validation with a custom annotation and validator.

#### Conclusion

Backtracking is an essential feature of regex engines that enables powerful pattern matching capabilities. However, it can also cause performance issues if not managed correctly. By understanding how backtracking works and following best practices, such as avoiding nested quantifiers and using atomic groups or possessive quantifiers, you can create efficient and reliable regex patterns in Java. Start applying these techniques to optimize your regex usage and avoid the pitfalls of excessive backtracking.
