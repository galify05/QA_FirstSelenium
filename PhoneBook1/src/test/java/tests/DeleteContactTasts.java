package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.data.ContactData;
import phonebook.data.UserData;
import phonebook.models.Contact;
import phonebook.models.User;

public class DeleteContactTasts extends TestBase {
    @BeforeMethod
    public void precondition() {

        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.email).setPassword(UserData.password));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.name)
                .setLastName(ContactData.lastName)
                .setPhone(ContactData.phone)
                .setEmail(ContactData.email)
                .setAdress(ContactData.address)
                .setDescription(ContactData.description));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }


}
