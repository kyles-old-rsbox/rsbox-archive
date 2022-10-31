public class TestClass {

    public TestClass() {

    }

    void runTest() {
        Car car = new Car("Mazda");
        for(int i = 0; i < 4; i++) {
            car.addWheel();
        }
    }

    public static void test() {
        TestClass cls = new TestClass();
        cls.runTest();
    }
}
