//package sudopkill;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import sudopkill.AuthProvider.AuthProvider;
//import sudopkill.page.Page;
//import sudopkill.account.Account;
//
//
//import java.time.Instant;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.HashSet;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PageTest {
//
////    String title = "tester";
////    String content = "tester";
////
////    String email = "harisghauri@gmail.com";
////    String pass = "pass";
////    String role = "USER_ROLE";
////    String localRole = AuthProvider.LOCAL.toString();
//
//
//
////    @Test
////    public void testPageGetters() throws Exception {
////
////        //Make guinea pigs
////        Account author = new Account(email, pass, localRole, localRole);
////
////        Page parentPage = new Page("Parent Tester", "test", author, null);
////        Page childPage = new Page("Parent Tester", "test", author, null);
////
////        Page page = new Page(this.title, this.content, author, parentPage);
////
////        page.addChildNode(childPage);
////
////        assertEquals(page.getTitle(), this.title);
////        assertEquals(page.getContent(), this.content);
////        assertEquals(page.getAuthor(), author);
////        assertEquals(page.getParent(), parentPage);
////
////    }
//
////    @Test
////    public void testPageSetters() throws Exception {
////
////
////
////        //Make guinea pigs
////        Account author = new Account(email, pass, localRole, localRole);
////
////        Page parentPage = new Page("Parent Tester", "test", author, null);
////        Page childPage = new Page("Parent Tester", "test", author, null);
////
////        Page page = new Page(this.title, this.content, null, null);
////
////        Set<Page> childNodes = new HashSet<>();
////        childNodes.add(childPage);
////
////        page.setTitle("Test");
////        page.setContent("Test");
////        page.setAuthor(author);
////        page.setParent(parentPage);
////        page.setChildNodes(childNodes);
////
////        assertEquals(page.getTitle(), "Test");
////        assertEquals(page.getContent(), "Test");
////        assertEquals(page.getAuthor(), author);
////        assertEquals(page.getParent(), parentPage);
////        assertEquals(page.getChildNodes(), childNodes);
////
////    }
//
//}