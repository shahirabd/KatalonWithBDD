package commonSteps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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


class Common {

	@Keyword
	def NavigateToLogin() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.URL)
		WebUI.click(findTestObject('Object Repository/Login_Page_CURA/a_CURA Healthcare_menu-toggle'))
		WebUI.click(findTestObject('Object Repository/Login_Page_CURA/a_Login'))
	}

	@Keyword
	def EnterLoginCredentials(String usrName, String pwd) {
		WebUI.setText(findTestObject('Object Repository/Login_Page_CURA/input_Username_username'), usrName)
		WebUI.setText(findTestObject('Object Repository/Login_Page_CURA/input_Password_password'), pwd)
	}

	@Keyword
	def VerifyAppointmentPage(boolean endTest) {
		WebUI.verifyElementPresent(findTestObject('Login_Page_CURA/h2_Make Appointment'), 5)
		if (endTest) {
			Logout()
			WebUI.closeBrowser()
		}
	}

	@Keyword
	def Logout() {
		WebUI.click(findTestObject('Object Repository/Login_Page_CURA/a_CURA Healthcare_menu-toggle'))
		WebUI.click(findTestObject('Object Repository/Login_Page_CURA/a_Logout'))
	}
}