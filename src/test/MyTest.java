package test;

import model.dao.StokDAO;

public class MyTest {
	StokDAO instance;
	protected boolean testExist1;
	public void test() throws Exception {
		instance = new StokDAO();
		testExist1 = instance.isExistITEMMSKCD("-30", "G");
		System.out.println(testExist1);
	}
	public static void main(String[] args) throws Exception {
		MyTest mt = new MyTest();
		mt.test();
	}

}
