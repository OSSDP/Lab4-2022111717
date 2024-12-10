package untitled;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试类总体原则：
 * 1. **等价类划分原则**：通过等价类划分，考虑以下场景：
 *    - 版本号完全相等。
 *    - 一个版本号短于另一个，补零后相等。
 *    - 一个版本号的某修订号大于另一个版本号对应的修订号。
 *    - 一个版本号的某修订号小于另一个版本号对应的修订号。
 * 2. **边界值分析**：测试空版本号、单个修订号的版本号、大量修订号的版本号等极端情况。
 * 3. **特殊输入测试**：版本号中包含前导零的情况。
 */
public class L2022111717_15_Test {

    Solution solution = new Solution();

    /**
     * 测试目的：
     * 验证版本号完全相等时，返回值为 0。
     * 测试用例：
     * - "1.0" 与 "1.0"
     * - "1.01" 与 "1.001"
     */
    @Test
    public void testEqualVersions() {
        assertEquals(0, solution.compareVersion("1.0", "1.0"));
        assertEquals(0, solution.compareVersion("1.01", "1.001"));
    }

    /**
     * 测试目的：
     * 验证一个版本号短于另一个版本号，但补零后两者相等时，返回值为 0。
     * 测试用例：
     * - "1.0" 与 "1.0.0"
     * - "1" 与 "1.0.0"
     */
    @Test
    public void testShorterVersionEquals() {
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"));
        assertEquals(0, solution.compareVersion("1", "1.0.0"));
    }

    /**
     * 测试目的：
     * 验证一个版本号的某修订号大于另一个版本号的对应修订号时，返回值为 1。
     * 测试用例：
     * - "1.2" 与 "1.1"
     * - "1.0.2" 与 "1.0.1"
     */
    @Test
    public void testVersion1GreaterThanVersion2() {
        assertEquals(1, solution.compareVersion("1.2", "1.1"));
        assertEquals(1, solution.compareVersion("1.0.2", "1.0.1"));
    }

    /**
     * 测试目的：
     * 验证一个版本号的某修订号小于另一个版本号的对应修订号时，返回值为 -1。
     * 测试用例：
     * - "1.0" 与 "1.1"
     * - "0.9" 与 "1.0"
     */
    @Test
    public void testVersion1LessThanVersion2() {
        assertEquals(-1, solution.compareVersion("1.0", "1.1"));
        assertEquals(-1, solution.compareVersion("0.9", "1.0"));
    }

    /**
     * 测试目的：
     * 验证极端情况：空字符串、前导零、大量修订号等。
     * 测试用例：
     * - "1.0.0.0" 与 "1"
     * - "0.0.0.0" 与 "0"
     * - "1.01.001" 与 "1.1.1"
     */
    @Test
    public void testEdgeCases() {
        assertEquals(0, solution.compareVersion("1.0.0.0", "1"));
        assertEquals(0, solution.compareVersion("0.0.0.0", "0"));
        assertEquals(0, solution.compareVersion("1.01.001", "1.1.1"));
    }
}