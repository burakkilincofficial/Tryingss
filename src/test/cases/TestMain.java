package test.cases;

public class TestMain {
    private String email;

    public boolean getStatusByAge(int age) throws Exception {
        if (age < 0) {
            throw new Exception("the age should be ");
        }
        return age > 18;
    }
}
