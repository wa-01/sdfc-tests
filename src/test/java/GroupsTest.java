import java.util.HashMap;
import java.util.Map;

import com.jalasoft.sdfc.pages.Header;
import com.jalasoft.sdfc.pages.Signin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroupsTest {

    @Before
    public void setUp() {
        // Given
        String userName = "rpfh1@mailinator.com";
        Signin signin = new Signin();
        signin.loginAs(userName, "654321*Aa");
    }

    @Test
    public void testCreateGroup() {

        Map<String, String> data = new HashMap<>();
        data.put("name", "MyProject22");
        data.put("account", "account1");
        data.put("privacy", "public");

    }
}
