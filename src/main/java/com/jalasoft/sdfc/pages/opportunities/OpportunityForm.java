package com.jalasoft.sdfc.pages.opportunities;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.opportunities.view.OpportunityView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OpportunityForm extends BasicForm {
    @Override
    public void setFormFields(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("amount",() -> fillTextArea("Amount", data.get("amount")));
        strategyMap.put("private",() -> setPrivate(data.get("private")));
        strategyMap.put("close_date",() -> fillTextArea("Close Date", data.get("close_date")));
        strategyMap.put("name",() -> fillTextArea("Opportunity Name", data.get("name")));
        strategyMap.put("next_step",() -> fillTextArea("Next Step", data.get("next_step")));
        strategyMap.put("account_name",() -> selectOptionInTextField("Account Name", data.get("account_name")));
        strategyMap.put("stage",() -> selectOptionInSelectField("Stage", data.get("stage")));
        strategyMap.put("type",() -> selectOptionInSelectField("Type", data.get("type")));
        strategyMap.put("probability",() -> fillTextArea("Probability", data.get("probability")));
        strategyMap.put("lead_source",() -> selectOptionInSelectField("Lead Source", data.get("lead_source")));
        strategyMap.put("primary_Campaign",() -> selectOptionInTextField("Primary Campaign Source", data.get("primary_Campaign")));
        strategyMap.put("order_number",() -> fillTextArea("Order Number", data.get("order_number")));
        strategyMap.put("main_competitor",() -> fillTextArea("Main Competitor", data.get("main_competitor")));
        strategyMap.put("current_generator",() -> fillTextArea("Current Generator", data.get("current_generator")));
        strategyMap.put("delivery_status",() -> selectOptionInSelectField("Delivery/Installation Status", data.get("delivery_status")));
        strategyMap.put("tracking_number",() -> selectOptionInSelectField("Tracking Number", data.get("tracking_number")));
        strategyMap.put("description",() -> fillTextArea("Description", data.get("description")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

    private void setPrivate(String isPrivate) {
        if (isPrivate.equals("true")){
            selectCheckBox("Private");
        }
    }

    public OpportunityView createOpportunity(Map<String, String> data) {
        setFormFields(data);
        clickFooterButton("Save");
        return new OpportunityView();
    }
}
