package sudopkill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sudopkill.AuthProvider.AuthProvider;
import sudopkill.account.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialMediaWikiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void addAccountPassingParams() throws Exception {

		Account account = new Account("harisghauri@gmail.com", "pass", "USER_ROLE", AuthProvider.LOCAL.toString());

//		BuddyInfo buddy= new BuddyInfo();
//		buddy.setName("Haris");
//		buddy.setPhone_nummber("613");
//
//		AddressBook buddies = new AddressBook();
//
//		buddies.addBuddy(buddy);
//
//		assertEquals(buddies.getSize(),1);

	}

	@Test
	public void addAccountUsingSetters() throws Exception {
		Account account = new Account();
		account.setEmail("harisghauri@gmail.com");
		account.setAuthProvider(AuthProvider.LOCAL.toString());
		account.setPassword("pass");
		account.setRole("USER_ROLE");


	}
}
