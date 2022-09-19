import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.Listeners;

@Listeners(ExtentITestListenerClassAdapter.class)
public class BaseTest {
}
