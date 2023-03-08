package banking.obs.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obs.genericutility.BaseClass;

public class Testng extends BaseClass{
@Test
public void test() {
	System.out.println("test");
	Assert.fail();
}

}
