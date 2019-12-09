package pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import util.ElementUtils;

import java.util.HashMap;
import java.util.Map;

public class UserAccountPage extends PageObject {
    @FindBy(xpath="//div[@class='page-segment page-segment-detail-data']/div[1]//strong[@class='semibold']")
    private WebElementFacade lblUsrName;
    @FindBy(xpath="//div[@class='page-segment page-segment-detail-data']/div[2]//strong[@class='semibold']")
    private WebElementFacade lblUsrEmail;

    public Map<String,String> getUserInfo() throws Exception{
        final Map<String,String> userInforMap = new HashMap<String, String>();
        String usrName = ElementUtils.tryGetText(lblUsrName);
        String usrEmail = ElementUtils.tryGetText(lblUsrEmail);
        userInforMap.put("userName",usrName);
        userInforMap.put("userEmail",usrEmail);
        return userInforMap;
    }

    public void verifyUserAccountPageLoad() throws Exception{
        ElementUtils.waitElementPresent(lblUsrName);
    }
}
