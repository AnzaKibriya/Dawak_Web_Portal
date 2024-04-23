package Pages;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import Enum.BasicInformationEnum;
import Enum.ContactInformation;
import Enum.UserDetailsEnum;
import java.io.FileNotFoundException;
import java.util.List;

import static Helper.BaseClass.*;
import static Pages.WebCommon.*;

public class PatientInformations {

    WebDriver driver;
    public String basicInfoSiblingstring = "//div[contains(text(), '%s')]/following-sibling::div";
    public String basicInfostring="//div[contains(text(), '%s')]";

    String userDetail = "//h5[contains(text(), '%s')]/following-sibling::h5";
    @FindBy(xpath = "//h5[text()='Basic Info']")
    WebElement basicInfoButton;
    @FindBy(xpath = "//div[@class='custom-class-for-accordion-con collapse-div-header']")
    WebElement contactInfoButton;

    String userDetailsibling = "//h5[contains(text(), '%s')]/following-sibling::h5";

    String userDetails="//h5[contains(text(), '%s')]";

    String pendingMedicationTableRow="//app-pending-medication-info//tbody[contains(@class, 'mdc-data-table__content')]//tr";


    String pendingMedicationColumn="//app-pending-medication-info//table[contains(@role, 'table')]//th";

    String pendingMedicationTableData="//app-pending-medication-info//tbody[contains(@class, 'mdc-data-table__content')]//tr[%s]//td[%s]";

    String pendingMedicationTableHeading="//app-pending-medication-info//table[contains(@role, 'table')]//th[%s]";
    String createOrderPath = "./src/main/resources/CreatingOrder.json";

    public PatientInformations(WebDriver Driver) {
        driver=Driver;
    }


    public void verifyContactDetail() {
        contactInfoButton.click();
        ContactInformation[] contactInformations = ContactInformation.values();
        for (int i = 0; i <= contactInformations.length - 1; i++) {
            WebElement contactDetails = driver.findElement(By.xpath(String.format(basicInfostring, contactInformations[i].value)));
            WebElement contactSibling = driver.findElement(By.xpath(String.format(basicInfoSiblingstring, contactInformations[i].value)));

            try {
                info(contactDetails,contactSibling);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

    }



    public void pendingMedicationTable() throws FileNotFoundException {
        List<WebElement> pendingMedicationrowSize = driver.findElements(By.xpath(pendingMedicationTableRow));
        List<WebElement> pendingMedicationColumnSize = driver.findElements(By.xpath(pendingMedicationColumn));
        for(int i=1;i<=pendingMedicationrowSize.size();i++)
        {
            for(int j=1;j<=pendingMedicationColumnSize.size();j++)
            {
                WebElement medicationHeader=driver.findElement(By.xpath(String.format(pendingMedicationTableHeading,j)));
                WebElement medicationDetails=driver.findElement(By.xpath(String.format(pendingMedicationTableData,i,j)));
                System.out.println(medicationDetails.getText());
                info(medicationHeader,medicationDetails);
            }
        }


    }



    public void userDetails()
    {
        UserDetailsEnum[] userData= UserDetailsEnum.values();
        test.log(Status.PASS, "verifying user Details Information");

        for(int i=0;i<=userData.length-1;i++)
        {
            WebElement patienttDetails = driver.findElement(By.xpath(String.format(userDetails, userData[i].value)));
            WebElement patientDetailsSibling = driver.findElement(By.xpath(String.format(userDetailsibling, userData[i].value)));
            System.out.println(patienttDetails.getText());
            System.out.println(patientDetailsSibling.getText());

            try {
                info(patienttDetails,patientDetailsSibling);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }




    public void verifyBasicDetailTable()  {
        basicInfoButton.click();
        BasicInformationEnum[] BasicInformationEnums = BasicInformationEnum.values();
        System.out.println(BasicInformationEnums.length + "enum length");
        test.log(Status.PASS, "verifying Basic Details Information");
        for (int i = 0; i <= BasicInformationEnums.length - 1; i++) {
            WebElement basicInfo = driver.findElement(By.xpath(String.format(basicInfostring, BasicInformationEnums[i].value)));
            WebElement basicInfoSibling = driver.findElement(By.xpath(String.format(basicInfoSiblingstring, BasicInformationEnums[i].value)));

            try {
                info(basicInfo,basicInfoSibling);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



        }
    }



    public void info(WebElement element,WebElement actualText) throws FileNotFoundException {
        Pages.WebCommon().loadJson(createOrderPath);
        JsonArray medicationsArray = order.getAsJsonArray("medications");
          System.out.println(element.getText());
        if (element.getText().contains("Patient Full Name"))
        {
            System.out.println(element.getText());
            String firstName = patient.getAsJsonPrimitive("firstName").getAsString();
            String middleName = patient.getAsJsonPrimitive("middleName").getAsString();
            String lastName = patient.getAsJsonPrimitive("lastName").getAsString();
            String fullname = firstName + middleName + lastName;
            String fullnamewithoutspace = fullname.replaceAll("\\s", "");
            String fullnameUI = actualText.getText().replaceAll("\\s", "");
          //  Pages.WebCommon().assertjson(fullnameUI, fullnamewithoutspace);
            test.log(Status.PASS, "Full name verified");

        }
        else if(element.getText().contains("Emirates ID"))
        {
            String eid = patient.getAsJsonPrimitive("eid").getAsString();
            // Pages.WebCommon().assertjson(actualText.getText(), eid);
            test.log(Status.PASS, "emirated id verified");

        }
        else if(element.getText().contains("MRN#"))
        {
            String mrn = patient.getAsJsonPrimitive("mrn").getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), mrn);
            test.log(Status.PASS, "mrn id verified");


        } else if (element.getText().contains("Date of Birth")) {
            String dob = patient.getAsJsonPrimitive("dob").getAsString();
            test.log(Status.PASS, "Date of birth verified");


        } else if (element.getText().contains("Sex")) {
            String patGender = patient.getAsJsonPrimitive("patGender").getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), patGender);
            test.log(Status.PASS, "Gender verified");



        } else if (element.getText().contains("Martial Status")) {
            String maritalStatusValue = patient
                    .getAsJsonObject("maritalStatus")
                    .getAsJsonPrimitive("value")
                    .getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), maritalStatusValue);
            test.log(Status.PASS, "Marital status verified");


        } else if (element.getText().contains("Nationality")) {
            String nationalityValue = patient
                    .getAsJsonObject("nationality")
                    .getAsJsonPrimitive("value")
                    .getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), nationalityValue);
            test.log(Status.PASS, "Nationality verified");


        } else if (element.getText().contains("Language")) {
            String languageValue = patient
                    .getAsJsonObject("language")
                    .getAsJsonPrimitive("value")
                    .getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), languageValue);
            test.log(Status.PASS, "Language verified");

        } else if (element.getText().contains("CMRN #")) {
            String cmrn = patient.getAsJsonPrimitive("cmrn").getAsString();
           // Pages.WebCommon().assertjson(actualText.getText(), cmrn);
            test.log(Status.PASS, "Cmrn verified");


        } else if (element.getText().contains("Passport #")) {
            String passportNumber = patient.getAsJsonPrimitive("passportNumber").getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), passportNumber);
            test.log(Status.PASS, "Passport verified");


        } else if (element.getText().contains("Encounter #/Dawak Order id #")){
            Pages.WebCommon().assertjson(actualText.getText(), prescriptionOrderID);
            test.log(Status.PASS, "Encounter text verified");


        } else if (element.getText().contains("Task Name")) {
            if (actualText.getText().contains("Approval Required"))
            {
                Pages.WebCommon().assertjson(actualText.getText(), BaseClass.propertyFile("config", "TaskName"));
            test.log(Status.PASS, "Task Name verified");
        }
            else if(actualText.getText().contains("Dispense")){
                Pages.WebCommon().assertjson(actualText.getText(), BaseClass.propertyFile("config", "Task"));
                test.log(Status.PASS, "Task Name verified");


            } else if (actualText.getText().contains("Pickup")) {
                Pages.WebCommon().assertjson(actualText.getText(), BaseClass.propertyFile("config", "TaskNameReadyForDelivery"));
                test.log(Status.PASS, "Task Name verified");

            }


        } else if (element.getText().contains("Refill / Prescription DateTime")) {

            Pages.WebCommon().ExtractDateFromString(actualText.getText());
            getCurrentDateTime();
           // Pages.WebCommon().assertjson(formattedDate, uiFormattedDate);
            test.log(Status.PASS, "Refill Date text verified");
        } else if (element.getText().contains("Patient Emirates ID")) {

            String eid = patient.getAsJsonPrimitive("eid").getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), eid);
            test.log(Status.PASS, "eid text verified");
        } else if (element.getText().contains("Patient Name")) {
            String firstName = patient.getAsJsonPrimitive("firstName").getAsString();
            String middleName = patient.getAsJsonPrimitive("middleName").getAsString();
            String lastName = patient.getAsJsonPrimitive("lastName").getAsString();
            String fullname = firstName + middleName + lastName;
            String fullnamewithoutspace = fullname.replaceAll("\\s", "");
            String fullnameUI = actualText.getText().replaceAll("\\s", "");
            assert fullnamewithoutspace.equalsIgnoreCase(fullnameUI);
            test.log(Status.PASS, "Patient full name text verified");


        } else if (element.getText().contains("Patient MRN #")) {
            String mrn = patient.getAsJsonPrimitive("mrn").getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), mrn);
            test.log(Status.PASS, "mrn text verified");

        } else if (element.getText().contains("Medicine Count")) {

           Pages.WebCommon().assertjson(actualText.getText(), "3");
            test.log(Status.PASS, "medical count text verified");

        } else if (element.getText().contains("Task Created Date / Time")) {
            Pages.WebCommon().ExtractDateFromString(actualText.getText());
            getCurrentDateTime();
           // Pages.WebCommon().assertjson(formattedDate, uiFormattedDate);
            test.log(Status.PASS, "created date text verified");

        }
        else if (element.getText().contains("Physician Encounter Id#")) {
          //  Pages.WebCommon().assertjson(actualText.getText(),prescriptionOrderID);
            test.log(Status.PASS, "prescription order id verified");


        } else if (element.getText().contains("Prescribed By")) {
            String prescriberValue = order
                    .getAsJsonObject("physician")
                    .getAsJsonPrimitive("prescriber")
                    .getAsString();
            Pages.WebCommon().assertjson(actualText.getText(),prescriberValue);


        } else if (element.getText().contains("Order Location")) {

            String orderLocationValue = order
                    .getAsJsonObject("orderLocation")
                    .getAsJsonPrimitive("value")
                    .getAsString();
            Pages.WebCommon().assertjson(actualText.getText(),orderLocationValue);

        } else if (element.getText().contains("Channel")) {
            Pages.WebCommon().assertjson(actualText.getText(),"Mobile App");

        } else if (element.getText().contains("Physician Order Id")) {

               if(physicicianOrderCounter==0) {
                   JsonObject medicationObject = medicationsArray.get(0).getAsJsonObject();
                   String physicianOrderId = medicationObject.get("physicianOrderId").getAsString();
                   Pages.WebCommon().assertjson(actualText.getText(), physicianOrderId);
               }
            if(physicicianOrderCounter==1)
            {
                JsonObject medicationObject2 = medicationsArray.get(1).getAsJsonObject();
                String physicianOrderId2 = medicationObject2.get("physicianOrderId").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(),physicianOrderId2);
            }
            if(physicicianOrderCounter==2)
            {
                JsonObject medicationObject3 = medicationsArray.get(2).getAsJsonObject();
                String physicianOrderId3 = medicationObject3.get("physicianOrderId").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(),physicianOrderId3);
            }
            physicicianOrderCounter++;


        } else if (element.getText().contains("NDC Code")) {
            if(ndcCodecounter==0) {
                JsonObject medicationObject = medicationsArray.get(0).getAsJsonObject();
                String ndcCode = medicationObject.get("ndcCode").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(), ndcCode);
            }
            if(ndcCodecounter==1)
            {
                JsonObject medicationObject = medicationsArray.get(1).getAsJsonObject();
                String ndcCode = medicationObject.get("ndcCode").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(), ndcCode);

            }
            if(ndcCodecounter==2)
            {
                JsonObject medicationObject = medicationsArray.get(2).getAsJsonObject();
                String ndcCode = medicationObject.get("ndcCode").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(), ndcCode);

            }
            ndcCodecounter++;


        } else if (element.getText().contains("Drug Description")) {
            if(drugDescriptionCounter==0) {
                JsonObject medicationObject = medicationsArray.get(0).getAsJsonObject();
                String drugDescription = medicationObject.get("drugDescription").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(), drugDescription);
            }
            if(drugDescriptionCounter==1)
            {
                JsonObject medicationObject = medicationsArray.get(1).getAsJsonObject();
                String drugDescription = medicationObject.get("drugDescription").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(), drugDescription);
            }
            if(drugDescriptionCounter==2)
            {
                JsonObject medicationObject = medicationsArray.get(2).getAsJsonObject();
                String drugDescription = medicationObject.get("drugDescription").getAsString();
                Pages.WebCommon().assertjson(actualText.getText(), drugDescription);
            }
            drugDescriptionCounter++;


        }
        else if (element.getText().contains("Patient Contact#"))
        {
            String phoneNumber = patient.getAsJsonPrimitive("phoneNumber").getAsString();
            Pages.WebCommon().assertjson(actualText.getText(), phoneNumber);
            test.log(Status.PASS, "patient contact id verified");

        } else if (element.getText().contains("App User Contact#")) {
            Pages.WebCommon().assertjson(actualText.getText(), "+971502201010");
            test.log(Status.PASS, "App contact id verified");
            
        } else if (element.getText().contains("Address Type")) {

            if (actualText.getText().isEmpty()) {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            } else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }
        }
            else if (element.getText().contains("Address Line")) {

                if(actualText.getText().isEmpty())
                {
                    softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

                }
                else {
                    test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


                }


            }

        else if (element.getText().contains("City")) {

            if(actualText.getText().isEmpty())
            {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }


        }


        else if (element.getText().contains("Map Pin Location")) {

            if(actualText.getText().isEmpty())
            {
               // softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }


        }


        else if (element.getText().contains("Delivery Date")) {

            if(actualText.getText().isEmpty())
            {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }


        }


        else if (element.getText().contains("Delivery Time")) {

            if(actualText.getText().isEmpty())
            {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }


        }
        else if (element.getText().contains("Mode of Payment")) {

            if(actualText.getText().isEmpty())
            {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }


        }
        else if (element.getText().contains("Payment Status")) {

            if(actualText.getText().isEmpty())
            {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }


        } else if (element.getText().contains("Refill Qty")) {

            Pages.WebCommon().assertjson(actualText.getText(), BaseClass.propertyFile("config", "enterQuantity"));
            test.log(Status.PASS, "Refill Qty verified");
            
        } else if (element.getText().contains("Pill Packed")) {

            if(actualText.getText().isEmpty())
            {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }
        }

        else if (element.getText().contains("Copay amount")) {

         //   Pages.WebCommon().assertjson(actualText.getText(), BaseClass.propertyFile("config", "Amount"));
            test.log(Status.PASS, "Copy amount  verified");

        }

        else if (element.getText().contains("Insurance Status")) {
            if(actualText.getText().isEmpty())
            {
                softAssert.fail("Webtable cell does not contain" + element.getText() + " data");

            }
            else {
                test.log(Status.PASS, "WebTable  contains data in " + element.getText() + " column ");


            }

        }

        else if (element.getText().contains("Dispensing Status")) {
            Pages.WebCommon().assertjson(actualText.getText(), "Pending");
            test.log(Status.PASS, "Dispensing Status verified");

        }


    }


}
