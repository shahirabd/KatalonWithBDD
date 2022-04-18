import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

public class AppointmentSteps {
	
	//Global declaration
	String username, password, facility, checked, hcProgram, visitDate, strComments
	String apptConfirmation = "Appointment Confirmation"
	
	@Given("User is logged with (.*) and (.*)")
	def UserLogin(username, password) {
		CustomKeywords.'commonSteps.Common.NavigateToLogin'()
		CustomKeywords.'commonSteps.Common.EnterLoginCredentials'(username, password)
		WebUI.click(findTestObject('Object Repository/Login_Page_CURA/button_Login'))
		WebUI.waitForPageLoad(5)
	}
	
	@When("User is navigated to Make Appointment page")
	def verifyHomePage() {
		CustomKeywords.'commonSteps.Common.VerifyAppointmentPage'(false)
	}
	
	@And("User selects the (.*)")
	def SelectFacility(facility) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Appointment_Page_CURA/select_HC'), 5)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Appointment_Page_CURA/select_HC'), facility, false)
	}
	
	@And("sets the readmission checkbox to (.*)")
	def SetReadmissionCb (checked) {
		if(checked == "Yes") {
			WebUI.click(findTestObject('Object Repository/Appointment_Page_CURA/input_Apply readmission'))
		}
		//else {
		//	checked = "No"
		//}
	}
	
	@And("selects the Healthcare program (.*)")
	def SelectHCProgram(hcProgram) {
		if(hcProgram == "Medicaid") {
			WebUI.check(findTestObject('Object Repository/Appointment_Page_CURA/input_Medicaid_programs'))
		}
		else if (hcProgram == "Medicare") {
			WebUI.check(findTestObject('Object Repository/Appointment_Page_CURA/input_Medicare_programs'))
		}
		else {
			WebUI.check(findTestObject('Object Repository/Appointment_Page_CURA/input_None_programs'))
		}
	}
	
	@And("enters the visit date (.*)")
	def EnterVisitDate (visitDate) {
		WebUI.setText(findTestObject('Object Repository/Appointment_Page_CURA/input_Visit Date'), visitDate)
	}
	
	@And("enters the comment (.*)")
	def EnterComments(strComments) {
		WebUI.setText(findTestObject('Object Repository/Appointment_Page_CURA/textarea_Comment'), strComments)
	}
	
	@And("click on the Book Appointment button")
	def ClickApptBtn() {
		WebUI.click(findTestObject('Object Repository/Appointment_Page_CURA/button_Book Appointment'))
	}
	
	@And("user is navigated to Appointment Confirmation page")
	def VerifyAppointmentConfirmationPage() {
		WebUI.waitForPageLoad(5)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Appt_Confirmation_Page_CURA/h2_Appointment Confirmation'))
		WebUI.verifyElementText(findTestObject('Object Repository/Appt_Confirmation_Page_CURA/h2_Appointment Confirmation'), apptConfirmation)
		
		WebUI.verifyElementVisible(findTestObject('Object Repository/Appt_Confirmation_Page_CURA/p_Displayed_HC'))	
		WebUI.verifyElementVisible(findTestObject('Object Repository/Appt_Confirmation_Page_CURA/p_Displayed_Program'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Appt_Confirmation_Page_CURA/p_Displayed_Readmission'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Appt_Confirmation_Page_CURA/p_Displayed_Visit_date'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Appt_Confirmation_Page_CURA/p_Displayed_comment'))
		
		CustomKeywords.'commonSteps.Common.Logout'()
		WebUI.closeBrowser()
	}
}

