/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.CheckDbConnection;
import model.bean.Stok;
import model.dao.StokDAO;

/**
 * @author TinLQ
 *
 */
public class StokDAOTest {
	StokDAO instance;
	protected Stok stokminus30ITEMMMKCD;
	protected Stok stok0ITEMMMKCD;
	protected Stok stok1ITEMMMKCD;
	protected Stok stok2ITEMMMKCD;
	protected Stok stok3ITEMMMKCD;
	protected Stok stok4ITEMMMKCD;
	protected Stok stok30ITEMMMKCD;
	protected Stok stokminus30ITEMMSYCD;
	protected Stok stok0ITEMMSYCD;
	protected Stok stok1ITEMMSYCD;
	protected Stok stok2ITEMMSYCD;
	protected Stok stok3ITEMMSYCD;
	protected Stok stok4ITEMMSYCD;
	protected Stok stok30ITEMMSYCD;
	protected ArrayList<Stok> list11;
	protected ArrayList<Stok> list12;
	protected ArrayList<Stok> list13;
	protected ArrayList<Stok> list14;
	protected ArrayList<Stok> list10;
	protected ArrayList<Stok> list130;
	protected ArrayList<Stok> list1minus30;
	protected ArrayList<Stok> list2minus30;
	protected ArrayList<Stok> list20;
	protected ArrayList<Stok> list21;
	protected ArrayList<Stok> list22;
	protected ArrayList<Stok> list23;
	protected ArrayList<Stok> list23A;
	protected boolean checkConnection;
	protected String testminus30ITEMMMKCDExpected;
	protected String test0ITEMMMKCDExpected;
	protected String test1ITEMMMKCDExpected;
	protected String test2ITEMMMKCDExpected;
	protected String test3ITEMMMKCDExpected;
	protected String test4ITEMMMKCDExpected;
	protected String test30ITEMMMKCDExpected;
	protected String testNULLITEMMMKCDExpected;
	protected String testminus30ITEMMSYCDExpected;
	protected String test0ITEMMSYCDExpected;
	protected String test1ITEMMSYCDExpected;
	protected String test2ITEMMSYCDExpected;
	protected String test3ITEMMSYCDExpected;
	protected String test4ITEMMSYCDExpected;
	protected String test30ITEMMSYCDExpected;
	protected String testNULLITEMMSYCDExpected;
	protected String test1Actual;
	protected String test2Actual;
	protected String test3Actual;
	protected String testActual;
	protected ArrayList<Stok> list11Actual;
	protected ArrayList<Stok> list12Actual;
	protected ArrayList<Stok> list13Actual;
	protected ArrayList<Stok> list14Actual;
	protected ArrayList<Stok> list10Actual;
	protected ArrayList<Stok> list130Actual;
	protected ArrayList<Stok> list1minus30Actual;
	protected ArrayList<Stok> list2minus30Actual;
	protected ArrayList<Stok> list20Actual;
	protected ArrayList<Stok> list21Actual;
	protected ArrayList<Stok> list22Actual;
	protected ArrayList<Stok> list23Actual;
	protected ArrayList<Stok> list23AActual;
	protected boolean testUpdate1;
	protected boolean testUpdate2;
	protected boolean testUpdate3;
	protected boolean testUpdate4;
	protected boolean testUpdate5;
	protected boolean testUpdate6;
	protected boolean testUpdate7;
	protected boolean testUpdate8;
	protected boolean testExist1;
	protected boolean testExist2;
	protected boolean testExist3;
	protected boolean testExist4;
	protected boolean testExist5;
	protected boolean testExist6;
	protected boolean testExist7;
	protected boolean testExist8;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		instance = new StokDAO();
		// get checkITEMMKCD with iTEMMSTOK = "-30"
		stokminus30ITEMMMKCD = instance.checkITEMMMKCD("-30");
		testminus30ITEMMMKCDExpected = stokminus30ITEMMMKCD.getmAKERDATA();
		// get checkITEMMKCD with iTEMMSTOK = "0"
		stok0ITEMMMKCD = instance.checkITEMMMKCD("0");
		test0ITEMMMKCDExpected = stok0ITEMMMKCD.getmAKERDATA();
		// get checkITEMMKCD with iTEMMSTOK = "1"
		stok1ITEMMMKCD = instance.checkITEMMMKCD("1");
		test1ITEMMMKCDExpected = stok1ITEMMMKCD.getmAKERDATA();
		test1ITEMMMKCDExpected = test1ITEMMMKCDExpected.trim();
		// get checkITEMMKCD with iTEMMSTOK = "2"
		stok2ITEMMMKCD = instance.checkITEMMMKCD("2");
		test2ITEMMMKCDExpected = stok2ITEMMMKCD.getmAKERDATA();
		test2ITEMMMKCDExpected = test2ITEMMMKCDExpected.trim();
		// get checkITEMMKCD with iTEMMSTOK = "3"
		stok3ITEMMMKCD = instance.checkITEMMMKCD("3");
		test3ITEMMMKCDExpected = stok3ITEMMMKCD.getmAKERDATA();
		test3ITEMMMKCDExpected = test3ITEMMMKCDExpected.trim();
		// get checkITEMMKCD with iTEMMSTOK = "4"
		stok4ITEMMMKCD = instance.checkITEMMMKCD("4");
		test4ITEMMMKCDExpected = stok4ITEMMMKCD.getmAKERDATA();
		// get checkITEMMKCD with iTEMMSTOK = "30"
		stok30ITEMMMKCD = instance.checkITEMMMKCD("30");
		test30ITEMMMKCDExpected = stok30ITEMMMKCD.getmAKERDATA();
		// suppose nothing in database, get not thing and return 指定無し
		testNULLITEMMMKCDExpected = "指定無し";

		// get checkITEMMSYCD with iTEMMSTOK = "-30"
		stokminus30ITEMMSYCD = instance.checkITEMMSYCD("-30");
		testminus30ITEMMSYCDExpected = stokminus30ITEMMSYCD.getcARNMNAME();
		// get checkITEMMSYCD with iTEMMSTOK = "0"
		stok0ITEMMSYCD = instance.checkITEMMSYCD("0");
		test0ITEMMSYCDExpected = stok0ITEMMSYCD.getcARNMNAME();
		// get checkITEMMSYCD with iTEMMSTOK = "1"
		stok1ITEMMSYCD = instance.checkITEMMSYCD("1");
		test1ITEMMSYCDExpected = stok1ITEMMSYCD.getcARNMNAME();
		test1ITEMMSYCDExpected = test1ITEMMSYCDExpected.trim();
		// get checkITEMMSYCD with iTEMMSTOK = "2"
		stok2ITEMMSYCD = instance.checkITEMMSYCD("2");
		test2ITEMMSYCDExpected = stok2ITEMMSYCD.getcARNMNAME();
		test2ITEMMSYCDExpected = test2ITEMMSYCDExpected.trim();
		// get checkITEMMSYCD with iTEMMSTOK = "3"
		stok3ITEMMSYCD = instance.checkITEMMSYCD("3");
		test3ITEMMSYCDExpected = stok3ITEMMSYCD.getcARNMNAME();
		test3ITEMMSYCDExpected = test3ITEMMSYCDExpected.trim();
		// get checkITEMMSYCD with iTEMMSTOK = "4"
		stok4ITEMMSYCD = instance.checkITEMMSYCD("4");
		test4ITEMMSYCDExpected = stok4ITEMMSYCD.getcARNMNAME();
		// get checkITEMMSYCD with iTEMMSTOK = "30"
		stok30ITEMMSYCD = instance.checkITEMMSYCD("30");
		test30ITEMMSYCDExpected = stok30ITEMMSYCD.getcARNMNAME();
		// suppose nothing in database, get not thing and return 指定無し
		testNULLITEMMSYCDExpected = "指定無し";

		// get database Connection
		checkConnection = CheckDbConnection.checkConnect();

		// get data to test method getInfoStok(int pagenum)
		list11 = instance.getInfoStok(1);
		list12 = instance.getInfoStok(2);
		list13 = instance.getInfoStok(3);
		list14 = instance.getInfoStok(4);
		list10 = instance.getInfoStok(0);
		list130 = instance.getInfoStok(30);
		list1minus30 = instance.getInfoStok(-30);

		// get data to test method getInfoStok(String iTEMMSTOK, int pagenum)
		list2minus30 = instance.getInfoStok("-30", 1);
		list20 = instance.getInfoStok("0", 1);
		list21 = instance.getInfoStok("1", 1);
		list22 = instance.getInfoStok("2", 1);
		list23 = instance.getInfoStok("3", 1);
		list23A = instance.getInfoStok("3A", 1);

		// get data and return to test method updateInfoStok(String iTEMMSTOK,
		// String iTEMMSKCD)
		testUpdate1 = instance.updateInfoStok("-30", "G");
		testUpdate2 = instance.updateInfoStok("0", "G");
		testUpdate3 = instance.updateInfoStok("1", "G");
		testUpdate4 = instance.updateInfoStok("2", "G");
		testUpdate5 = instance.updateInfoStok("3", "G");
		testUpdate6 = instance.updateInfoStok("3A", "G");
		testUpdate7 = instance.updateInfoStok("30", "G");
		// suppose nothing in database and return false
		testUpdate8 = false;

		// get data and return to test method isExistITEMMSKCD(String iTEMMSTOK,
		// String iTEMMSKCD)
		testExist1 = instance.isExistITEMMSKCD("-30", "G");
		testExist2 = instance.isExistITEMMSKCD("0", "G");
		testExist3 = instance.isExistITEMMSKCD("1", "G");
		testExist4 = instance.isExistITEMMSKCD("2", "G");
		testExist5 = instance.isExistITEMMSKCD("3", "G");
		testExist6 = instance.isExistITEMMSKCD("3A", "G");
		testExist7 = instance.isExistITEMMSKCD("30", "G");
		testExist8 = false;

		test1Actual = "A";
		test2Actual = "B";
		test3Actual = "C";
		testActual = "指定無し";
		list11Actual = new ArrayList<>();
		list11Actual.add(new Stok(4, "1", "A", "AA", "A", "A", "A", "1", "1", "A", 1));
		list12Actual = new ArrayList<>();
		list12Actual.add(new Stok(4, "2", "B", "BB", "B", "B", "B", "2", "2", "B", 2));
		list13Actual = new ArrayList<>();
		list13Actual.add(new Stok(4, "3", "C", "CC", "C", "C", "C", "3", "3", "C", 3));
		list14Actual = new ArrayList<>();
		list14Actual.add(new Stok(4, "3A", "C", "CC", "C", "C", "C", "3", "3", "C", 3));
		list10Actual = new ArrayList<>();
		list130Actual = new ArrayList<>();
		list1minus30Actual = new ArrayList<>();
		list2minus30Actual = new ArrayList<>();
		list20Actual = new ArrayList<>();
		list21Actual = new ArrayList<>();
		list21Actual.add(new Stok(1, "1", "A", "AA", "A", "A", "A", "1", "1", "A", 1));
		list22Actual = new ArrayList<>();
		list22Actual.add(new Stok(1, "2", "B", "BB", "B", "B", "B", "2", "2", "B", 2));
		list23Actual = new ArrayList<>();
		list23Actual.add(new Stok(2, "3", "C", "CC", "C", "C", "C", "3", "3", "C", 3));
		list23AActual = new ArrayList<>();
		list23AActual.add(new Stok(1, "3A", "C", "CC", "C", "C", "C", "3", "3", "C", 3));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test JUnit method checkITEMMMKCD(String iTEMMSTOK)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCheckITEMMMKCD() throws Exception {
		// test if database have data
		assertEquals(testActual, testminus30ITEMMMKCDExpected);
		assertEquals(testActual, test0ITEMMMKCDExpected);
		assertEquals(test1Actual, test1ITEMMMKCDExpected);
		assertEquals(test2Actual, test2ITEMMMKCDExpected);
		assertEquals(test3Actual, test3ITEMMMKCDExpected);
		assertEquals(testActual, test4ITEMMMKCDExpected);
		assertEquals(testActual, test30ITEMMMKCDExpected);
		assertEquals(testActual, testNULLITEMMMKCDExpected);
		// test if connection is connected
		assertEquals(true, checkConnection);
	}

	/**
	 * Test JUnit method checkITEMMSYCD(String iTEMMSTOK) d
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCheckITEMMSYCD() throws Exception {
		// test if database have data
		assertEquals(testActual, testminus30ITEMMSYCDExpected);
		assertEquals(testActual, test0ITEMMSYCDExpected);
		assertEquals(test1Actual, test1ITEMMSYCDExpected);
		assertEquals(test2Actual, test2ITEMMSYCDExpected);
		assertEquals(test3Actual, test3ITEMMSYCDExpected);
		assertEquals(testActual, test4ITEMMSYCDExpected);
		assertEquals(testActual, test30ITEMMSYCDExpected);
		assertEquals(testActual, testNULLITEMMSYCDExpected);
		// test if connection is connected
		assertEquals(true, checkConnection);
	}

	/**
	 * Test JUnit method getInfoStok(int pagenum)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetInfoStok() throws Exception {
		// pagenum = 1
		assertEquals(list11Actual.get(0).getAllpage(), list11.get(0).getAllpage());
		assertEquals(list11Actual.get(0).getiTEMMSTOK(), list11.get(0).getiTEMMSTOK());
		assertEquals(list11Actual.get(0).getiTEMMSKCD(), list11.get(0).getiTEMMSKCD());
		assertEquals(list11Actual.get(0).getiTEMMTNTO(), list11.get(0).getiTEMMTNTO());
		assertEquals(list11Actual.get(0).geteMPFLEMPNM(), list11.get(0).geteMPFLEMPNM());
		assertEquals(list11Actual.get(0).getdCCFLNAME(), list11.get(0).getdCCFLNAME());
		assertEquals(list11Actual.get(0).getiTEMMHNME(), list11.get(0).getiTEMMHNME());
		assertEquals(list11Actual.get(0).getiTEMMMKCD(), list11.get(0).getiTEMMMKCD());
		assertEquals(list11Actual.get(0).getiTEMMSYCD(), list11.get(0).getiTEMMSYCD());
		assertEquals(list11Actual.get(0).getiTEMMTNKMK(), list11.get(0).getiTEMMTNKMK());
		assertEquals(list11Actual.get(0).getiTEMMPART(), list11.get(0).getiTEMMPART());
		// pagenum = 2
		assertEquals(list12Actual.get(0).getAllpage(), list12.get(0).getAllpage());
		assertEquals(list12Actual.get(0).getiTEMMSTOK(), list12.get(0).getiTEMMSTOK());
		assertEquals(list12Actual.get(0).getiTEMMSKCD(), list12.get(0).getiTEMMSKCD());
		assertEquals(list12Actual.get(0).getiTEMMTNTO(), list12.get(0).getiTEMMTNTO());
		assertEquals(list12Actual.get(0).geteMPFLEMPNM(), list12.get(0).geteMPFLEMPNM());
		assertEquals(list12Actual.get(0).getdCCFLNAME(), list12.get(0).getdCCFLNAME());
		assertEquals(list12Actual.get(0).getiTEMMHNME(), list12.get(0).getiTEMMHNME());
		assertEquals(list12Actual.get(0).getiTEMMMKCD(), list12.get(0).getiTEMMMKCD());
		assertEquals(list12Actual.get(0).getiTEMMSYCD(), list12.get(0).getiTEMMSYCD());
		assertEquals(list12Actual.get(0).getiTEMMTNKMK(), list12.get(0).getiTEMMTNKMK());
		assertEquals(list12Actual.get(0).getiTEMMPART(), list12.get(0).getiTEMMPART());
		// pagenum = 3
		assertEquals(list13Actual.get(0).getAllpage(), list13.get(0).getAllpage());
		assertEquals(list13Actual.get(0).getiTEMMSTOK(), list13.get(0).getiTEMMSTOK());
		assertEquals(list13Actual.get(0).getiTEMMSKCD(), list13.get(0).getiTEMMSKCD());
		assertEquals(list13Actual.get(0).getiTEMMTNTO(), list13.get(0).getiTEMMTNTO());
		assertEquals(list13Actual.get(0).geteMPFLEMPNM(), list13.get(0).geteMPFLEMPNM());
		assertEquals(list13Actual.get(0).getdCCFLNAME(), list13.get(0).getdCCFLNAME());
		assertEquals(list13Actual.get(0).getiTEMMHNME(), list13.get(0).getiTEMMHNME());
		assertEquals(list13Actual.get(0).getiTEMMMKCD(), list13.get(0).getiTEMMMKCD());
		assertEquals(list13Actual.get(0).getiTEMMSYCD(), list13.get(0).getiTEMMSYCD());
		assertEquals(list13Actual.get(0).getiTEMMTNKMK(), list13.get(0).getiTEMMTNKMK());
		assertEquals(list13Actual.get(0).getiTEMMPART(), list13.get(0).getiTEMMPART());
		// pagenum = 4
		assertEquals(list14Actual.get(0).getAllpage(), list14.get(0).getAllpage());
		assertEquals(list14Actual.get(0).getiTEMMSTOK(), list14.get(0).getiTEMMSTOK());
		assertEquals(list14Actual.get(0).getiTEMMSKCD(), list14.get(0).getiTEMMSKCD());
		assertEquals(list14Actual.get(0).getiTEMMTNTO(), list14.get(0).getiTEMMTNTO());
		assertEquals(list14Actual.get(0).geteMPFLEMPNM(), list14.get(0).geteMPFLEMPNM());
		assertEquals(list14Actual.get(0).getdCCFLNAME(), list14.get(0).getdCCFLNAME());
		assertEquals(list14Actual.get(0).getiTEMMHNME(), list14.get(0).getiTEMMHNME());
		assertEquals(list14Actual.get(0).getiTEMMMKCD(), list14.get(0).getiTEMMMKCD());
		assertEquals(list14Actual.get(0).getiTEMMSYCD(), list14.get(0).getiTEMMSYCD());
		assertEquals(list14Actual.get(0).getiTEMMTNKMK(), list14.get(0).getiTEMMTNKMK());
		assertEquals(list14Actual.get(0).getiTEMMPART(), list14.get(0).getiTEMMPART());
		// pagenum = 0
		assertEquals(list10Actual, list10);
		// pagenum = 30
		assertEquals(list130Actual, list130);
		// pagenum = -30
		assertEquals(list1minus30Actual, list1minus30);
		// test if connection is connected
		assertEquals(true, checkConnection);
	}

	/**
	 * Test JUnit method getInfoStok(String iTEMMSTOK, int pagenum)
	 *
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetInfoStok2() throws Exception {
		// pagenum = 1, iTEMMSTOK = -30
		assertEquals(list2minus30Actual, list2minus30);
		// pagenum = 1, iTEMMSTOK = 0
		assertEquals(list20Actual, list20);
		// pagenum = 1, iTEMMSTOK = 1
		assertEquals(list21Actual.get(0).getAllpage(), list21.get(0).getAllpage());
		assertEquals(list21Actual.get(0).getiTEMMSTOK(), list21.get(0).getiTEMMSTOK());
		assertEquals(list21Actual.get(0).getiTEMMSKCD(), list21.get(0).getiTEMMSKCD());
		assertEquals(list21Actual.get(0).getiTEMMTNTO(), list21.get(0).getiTEMMTNTO());
		assertEquals(list21Actual.get(0).geteMPFLEMPNM(), list21.get(0).geteMPFLEMPNM());
		assertEquals(list21Actual.get(0).getdCCFLNAME(), list21.get(0).getdCCFLNAME());
		assertEquals(list21Actual.get(0).getiTEMMHNME(), list21.get(0).getiTEMMHNME());
		assertEquals(list21Actual.get(0).getiTEMMMKCD(), list21.get(0).getiTEMMMKCD());
		assertEquals(list21Actual.get(0).getiTEMMSYCD(), list21.get(0).getiTEMMSYCD());
		assertEquals(list21Actual.get(0).getiTEMMTNKMK(), list21.get(0).getiTEMMTNKMK());
		assertEquals(list21Actual.get(0).getiTEMMPART(), list21.get(0).getiTEMMPART());
		// pagenum = 1, iTEMMSTOK = 2
		assertEquals(list22Actual.get(0).getAllpage(), list22.get(0).getAllpage());
		assertEquals(list22Actual.get(0).getiTEMMSTOK(), list22.get(0).getiTEMMSTOK());
		assertEquals(list22Actual.get(0).getiTEMMSKCD(), list22.get(0).getiTEMMSKCD());
		assertEquals(list22Actual.get(0).getiTEMMTNTO(), list22.get(0).getiTEMMTNTO());
		assertEquals(list22Actual.get(0).geteMPFLEMPNM(), list22.get(0).geteMPFLEMPNM());
		assertEquals(list22Actual.get(0).getdCCFLNAME(), list22.get(0).getdCCFLNAME());
		assertEquals(list22Actual.get(0).getiTEMMHNME(), list22.get(0).getiTEMMHNME());
		assertEquals(list22Actual.get(0).getiTEMMMKCD(), list22.get(0).getiTEMMMKCD());
		assertEquals(list22Actual.get(0).getiTEMMSYCD(), list22.get(0).getiTEMMSYCD());
		assertEquals(list22Actual.get(0).getiTEMMTNKMK(), list22.get(0).getiTEMMTNKMK());
		assertEquals(list22Actual.get(0).getiTEMMPART(), list22.get(0).getiTEMMPART());
		// pagenum = 1, iTEMMSTOK = 3
		assertEquals(list23Actual.get(0).getAllpage(), list23.get(0).getAllpage());
		assertEquals(list23Actual.get(0).getiTEMMSTOK(), list23.get(0).getiTEMMSTOK());
		assertEquals(list23Actual.get(0).getiTEMMSKCD(), list23.get(0).getiTEMMSKCD());
		assertEquals(list23Actual.get(0).getiTEMMTNTO(), list23.get(0).getiTEMMTNTO());
		assertEquals(list23Actual.get(0).geteMPFLEMPNM(), list23.get(0).geteMPFLEMPNM());
		assertEquals(list23Actual.get(0).getdCCFLNAME(), list23.get(0).getdCCFLNAME());
		assertEquals(list23Actual.get(0).getiTEMMHNME(), list23.get(0).getiTEMMHNME());
		assertEquals(list23Actual.get(0).getiTEMMMKCD(), list23.get(0).getiTEMMMKCD());
		assertEquals(list23Actual.get(0).getiTEMMSYCD(), list23.get(0).getiTEMMSYCD());
		assertEquals(list23Actual.get(0).getiTEMMTNKMK(), list23.get(0).getiTEMMTNKMK());
		assertEquals(list23Actual.get(0).getiTEMMPART(), list23.get(0).getiTEMMPART());
		// pagenum = 1, iTEMMSTOK = 3A
		assertEquals(list23AActual.get(0).getAllpage(), list23A.get(0).getAllpage());
		assertEquals(list23AActual.get(0).getiTEMMSTOK(), list23A.get(0).getiTEMMSTOK());
		assertEquals(list23AActual.get(0).getiTEMMSKCD(), list23A.get(0).getiTEMMSKCD());
		assertEquals(list23AActual.get(0).getiTEMMTNTO(), list23A.get(0).getiTEMMTNTO());
		assertEquals(list23AActual.get(0).geteMPFLEMPNM(), list23A.get(0).geteMPFLEMPNM());
		assertEquals(list23AActual.get(0).getdCCFLNAME(), list23A.get(0).getdCCFLNAME());
		assertEquals(list23AActual.get(0).getiTEMMHNME(), list23A.get(0).getiTEMMHNME());
		assertEquals(list23AActual.get(0).getiTEMMMKCD(), list23A.get(0).getiTEMMMKCD());
		assertEquals(list23AActual.get(0).getiTEMMSYCD(), list23A.get(0).getiTEMMSYCD());
		assertEquals(list23AActual.get(0).getiTEMMTNKMK(), list23A.get(0).getiTEMMTNKMK());
		assertEquals(list23AActual.get(0).getiTEMMPART(), list23A.get(0).getiTEMMPART());
		// test if connection is connected
		assertEquals(true, checkConnection);
	}

	/**
	 * Test JUnit method updateInfoStok(String iTEMMSTOK, String iTEMMSKCD)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateInfoStok() throws Exception {
		assertEquals(false, testUpdate1);
		assertEquals(false, testUpdate2);
		assertEquals(true, testUpdate3);
		assertEquals(true, testUpdate4);
		assertEquals(true, testUpdate5);
		assertEquals(true, testUpdate6);
		assertEquals(false, testUpdate7);
		assertEquals(false, testUpdate8);
		// test if connection is connected
		assertEquals(true, checkConnection);
	}

	/**
	 * Test JUnit method isExistITEMMSKCD(String iTEMMSTOK, String iTEMMSKCD)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIsExistITEMMSKCD() throws Exception {
		assertEquals(false, testExist1);
		assertEquals(false, testExist2);
		assertEquals(true, testExist3);
		assertEquals(true, testExist4);
		assertEquals(true, testExist5);
		assertEquals(true, testExist6);
		assertEquals(false, testExist7);
		assertEquals(false, testExist8);
	}
}
