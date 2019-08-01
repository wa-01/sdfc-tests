package com.jalasoft.sdfc.pages.opportunities.view;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

public class OpportunityDetails extends AbstractPage {
    /*Another way to get the same value is:
      //span[contains(text(),'Opportunity')]/ancestor::div[contains(@class,'slds-form-element')]/
      descendant::span[contains(@class,'test-id__field-value')]/span
     */
    private static String SPAN_VALUE = "//span[contains(text(),'%s')]/parent::div/following-sibling::div/" +
            "descendant::span[contains(@class,'test-id__field-value')]/span";

    private static String PRIVATE_CHECKBOX = SPAN_VALUE + "/img";

    public String getFieldValue(String label) {
        if (label.equals("Private"))
            return isPrivateSelected() ? "select" : "unselect";
        return action.getText(By.xpath(String.format(SPAN_VALUE, label)));
    }

    public boolean isPrivateSelected(){
        String attribute = action.getAttribute(By.xpath(String.format(PRIVATE_CHECKBOX, "Private")), "alt");
        return Boolean.valueOf(attribute);
    }

}
