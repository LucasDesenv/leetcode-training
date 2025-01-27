package org.leetcode.stack;

import java.util.Map;
import java.util.Stack;

/**
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 *
 * The input string s is valid if and only if:
 *
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 */
public class ValidParentheses {

  private static final Map<Character, Character> PARENTHESES = Map.of(
    '(', ')',
    '{', '}',
    '[', ']'
  );

  public static void main(String[] args) {
    System.out.println("Should be true: " + isValid("[]"));
    System.out.println("Should be true: " + isValid("([{}])"));
    System.out.println("Should be false: " + isValid("[(]]"));
    System.out.println("Should be false: " + isValid("]"));
  }

  public static boolean isValid(String s) {
    char[] charArray = s.toCharArray();
    //When opening, add to the Stack: (, [, {
    //When closing, fetch from the stack if it matches.
    //close: } matches the last in the stack, which is }

    Stack<Character> stack = new Stack<>();


    for (int i = 0; i < charArray.length; i++) {
      //[0] = (
      //[1] = [
      char currentParentheses = charArray[i];
      boolean isOpen = PARENTHESES.get(currentParentheses) != null;
      if (isOpen){
        stack.push(currentParentheses);
        continue;
      }

      if (stack.isEmpty()){
        return false;
      }

      Character previousParentheses = stack.pop();
      if (!PARENTHESES.get(previousParentheses).equals(currentParentheses)){
        return false;
      }
    }

    return stack.isEmpty();

  }
}
