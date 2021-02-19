package ncs_java_yhs3.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import ncs_java_yhs3.ds.JdbcUtil;

public class JdbcUtilTest {

	@Test
	public void testGetConnection() {
		System.out.println("testGetConnection");
		Connection con = JdbcUtil.getConnection();
		System.out.println(con);
	}

}
