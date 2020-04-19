package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

//Step definitions independent from steps; can be reused by other scenarios as well. Cucumber goes into steps andthen goes to step definitions looks for matching setps.
//Cucumber take step definitions as blocks.
//But for same step 2 different implementation is not possible !!

public class CreateCalendarEventStepDefinitions {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        calendarEventsPage.clickToCreateCalendarEvent();
    }

    @Then("user enters {string} as a title")
    public void user_enters_as_a_title(String string) {
       calendarEventsPage.enterCalendarEventTitle(string);
    }

    @Then("user enters {string} as a description")
    public void user_enters_as_a_description(String string) {
        calendarEventsPage.enterCalendarEventDescription(string);

    }

    @Then("user click on save and close button")
    public void user_click_on_save_and_close_button() {
        calendarEventsPage.clickOnSaveAndClose();
    }

    @Then("user verifies that description of new calendar event is {string}")
    public void user_verifies_that_description_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string,calendarEventsPage.getGeneralInfoDescriptionText());
    }

    @Then("user verifies that title of new calendar event is {string}")
    public void user_verifies_that_title_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string,calendarEventsPage.getGeneralInfoTitleText());
    }

    //    And user enters new calendar event information:
//            | description | On this meeting we discuss what went well, what went wrong and what can be improved |
//            | title       | Sprint Retrospective                                                                |

    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String, String> dataTable) {
        calendarEventsPage.enterCalendarEventDescription(dataTable.get("description"));
        calendarEventsPage.enterCalendarEventTitle(dataTable.get("title"));
    }

    @Then("user verifies new calendar event was created successfully")
    public void user_verifies_new_calendar_event_was_created_successfully(Map<String, String> dataTable) {
        Assert.assertEquals(dataTable.get("description"), calendarEventsPage.getGeneralInfoDescriptionText());
        Assert.assertEquals(dataTable.get("title"), calendarEventsPage.getGeneralInfoTitleText());
    }

}