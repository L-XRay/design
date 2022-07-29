package cn.ray.design;

import org.junit.Test;

/**
 * @author JOJO
 * @date 2022/7/29 23:47
 */
public class ApiTest {

    @Test
    public void test_QuestionBank() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("Ray", "1000001921032"));
        System.out.println(questionBankController.createPaper("JOJO", "1000001921051"));
        System.out.println(questionBankController.createPaper("Summer", "1000001921987"));
    }
}
