package phonebook.utils;

import org.testng.annotations.DataProvider;
import phonebook.models.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Stipok", "Kurka", "1234697122", "da3as@gmail.com", "Turkei", "keker"});
        list.add(new Object[]{"Stipok", "Kurka", "12346932221", "dadnh@gmail.com", "Turkei", "keker"});
        list.add(new Object[]{"Stipok", "Kurka", "123469741233", "dafsas@gmail.com", "Turkei", "keker"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAdress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
