package SimplifyPath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathTest {
    @Test
    void testAssertTrue() {
        assertTrue(true);
    }

    @Test
    void personalTestCaseOne() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/simple");
        assertEquals("/simple", result);
    }

    @Test
    void personalTestCaseTwo() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/more/advanced");
        assertEquals("/more/advanced", result);
    }

    @Test
    void personalTestCaseThree() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/even/./more/advanced");
        assertEquals("/even/more/advanced", result);
    }

    @Test
    void personalTestCaseFour() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/way/even/../more/advanced");
        assertEquals("/way/more/advanced", result);
    }

    @Test
    void personalTestCaseFive() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/../");
        assertEquals("/", result);
    }

    @Test
    void personalTestCaseSix() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/aa/bb/cc/../../dd/../../ee/ff/");
        assertEquals("/ee/ff", result);
    }

    @Test
    void leetcodeTestCaseOne() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/home/");
        assertEquals("/home", result);
    }

    @Test
    void leetcodeTestCaseTwo() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/a/./b/../../c/");
        assertEquals("/c", result);
    }

    @Test
    void leetcodeTestCaseThree() {
        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath("/a//b////c/d//././/..");
        assertEquals("/a/b/c", result);
    }
}