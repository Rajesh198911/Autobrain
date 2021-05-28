package com.autobrain.pages;

import com.autobrain.base.Base;
import com.autobrain.models.SignupModel;

public class SignupWithBluetoothDevice extends Base {
	com.autobrain.pages.SignupWithBoughtDeviceFromABWebsite signup;
	com.autobrain.pages.SignupWithRetailerDevice retailer_signup;
	com.autobrain.pages.Login login;
	SignupModel obj;
	String lockObject = "lockObject";

	public SignupWithBluetoothDevice(SignupModel object) {
		login = new Login();
		signup = new SignupWithBoughtDeviceFromABWebsite(object);
		retailer_signup = new SignupWithRetailerDevice(object);
		obj = object;
	}

	public void signupWithBluetoothDevice(boolean AddCellularDevicewithoutPricingPlan) throws Exception {

		synchronized (lockObject) {

			retailer_signup.addDevicesInCsvFile();

			retailer_signup.CreateInvoice();

			retailer_signup.SubmitCsvFile();

			retailer_signup.ChooseInvoicePricingPlanAndDistributionChannel();
		}
		signup.signup();

		signup.EsfExemptionsSetup();

		signup.step1Setup(obj.getAll_Devices_No().get(0));

		signup.choosePricingPlanAndAddCardDetails();

		// Add device which having no pricing plan
		if (AddCellularDevicewithoutPricingPlan) {
			obj.setBluetooth_is("Upgraeded");
			login.logout();
			login.login("john@example.com", "welcome");
			signup.createDeviceFromPanel();
			VisibilityOfElementByXpath("//a[contains(text(),'Log Out')]", 15).click();
			getDriver().navigate().to(url);
			login.login(obj.getOwner_email(), "welcome");
			Thread.sleep(500);
			signup.activateNewDevice(obj.getAll_Devices_No().get(1));
		}

		// If more than one device then activate new device
		if (obj.getBluetooth_is().equals("free_plus_paid")) {

			// Logout current user
			login.logout();

			// Change blue-tooth type for upgraded device
			obj.setBluetooth_is("upgraded_device");
			// Order to ship upgraded device
			signup.orderToShip();

			// Set blue-tooth type back to default
			obj.setBluetooth_is("free_plus_paid");
			// Login registered user
			login.login(obj.getOwner_email(), "welcome");

			// Close the blue-tooth instruction popup
			Base b = new Base();
			b.VisibilityOfElementByXpath("//button[contains(text(),'GOT IT')]", 10).click();
			signup.activateNewDevice(obj.getAll_Devices_No().get(1));

		}

	}

}
