package com.autobrain.testcases;

import org.testng.annotations.Test;
import com.autobrain.base.Base;
import com.autobrain.models.SignupModel;
import com.autobrain.pages.DeviceReplacement;
import com.autobrain.pages.MarkReplacedDeviceForReuse;
import com.autobrain.pages.SignupWithBluetoothDevice;
import com.autobrain.pages.SignupWithBoughtDeviceFromABWebsite;
import com.autobrain.pages.SignupWithRetailerDevice;

public class DemoTest extends Base {

//	@Test
	public void verifySignupWithPersonalDeviceBoughtFromAB() throws Exception {
		SignupModel SignupModel = new SignupModel();

		SignupModel.setTotal_bought_devices(2);
		SignupModel.setAccount_type("personal");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_personal_billing_interval("yearly");
		SignupModel.setSet_esf(false);

		SignupWithBoughtDeviceFromABWebsite ss = new SignupWithBoughtDeviceFromABWebsite(SignupModel);
		ss.signupWithBoughtDeviceFromABWebsite();
	}

	@Test
	public void verifySignupWithBusinessDeviceBoughtFromAB() throws Exception {

		SignupModel SignupModel = new SignupModel();

		SignupModel.setTotal_bought_devices(2);
		SignupModel.setAccount_type("business");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_business_billing_interval("yearly");
		SignupModel.setSet_esf(false);

		SignupWithBoughtDeviceFromABWebsite ss = new SignupWithBoughtDeviceFromABWebsite(SignupModel);
		ss.signupWithBoughtDeviceFromABWebsite();
	}

//	@Test
	public void verifySignupWithPersonalDeviceBoughtFromRetailer() throws Exception {
		SignupModel SignupModel = new SignupModel();

		SignupModel.setTotal_bought_devices(2);
		SignupModel.setAccount_type("personal");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_personal_billing_interval("monthly");
		SignupModel.setPricing_plan("90 days personal plan");
		SignupModel.setSet_esf(false);

		SignupWithRetailerDevice ss = new SignupWithRetailerDevice(SignupModel);
		ss.signupWithRetailerDevice();
	}

//	@Test
	public void verifySignupWithBusinessDeviceBoughtFromRetailer() throws Exception {
		SignupModel SignupModel = new SignupModel();

		SignupModel.setTotal_bought_devices(3);
		SignupModel.setAccount_type("business");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_business_billing_interval("monthly");
		SignupModel.setPricing_plan("Plan Type: Business Referral, Cost: $19.99, Monthly: $14.99, Free Days: 14");
		SignupModel.setSet_esf(false);

		SignupWithRetailerDevice ss = new SignupWithRetailerDevice(SignupModel);
		ss.signupWithRetailerDevice();
	}

//	@Test
	public void verifySignupWithFreeBluetoothDevice() throws Exception {
		SignupModel SignupModel = new SignupModel();

		SignupModel.setAccount_type("personal");
		SignupModel.setBluetooth_is("free");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_personal_billing_interval("monthly");
		SignupModel.setPricing_plan("Personal Tier Free, Price: $49.97, Monthly: $0.00, Free Days: 90");
		SignupModel.setSet_esf(false);

		SignupWithBluetoothDevice ss = new SignupWithBluetoothDevice(SignupModel);
		ss.signupWithBluetoothDevice(false);
	}

//	@Test
	public void verifySignpuWithFreePlusPaidBluetoothDevice() throws Exception {
		SignupModel SignupModel = new SignupModel();

		SignupModel.setAccount_type("personal");
		SignupModel.setBluetooth_is("free_plus_paid");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_personal_billing_interval("monthly");
		SignupModel.setPricing_plan("Personal Tier Free, Price: $49.97, Monthly: $0.00, Free Days: 90");
		SignupModel.setSet_esf(false);

		SignupWithBluetoothDevice ss = new SignupWithBluetoothDevice(SignupModel);
		ss.signupWithBluetoothDevice(false);
	}

//	@Test
	public void verifyActivateCellularDeviceWhichContainNoInvoiceUnderFreeBluetoothAccount() throws Exception {
		SignupModel SignupModel = new SignupModel();

		SignupModel.setAccount_type("personal");
		SignupModel.setBluetooth_is("free");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_personal_billing_interval("monthly");
		SignupModel.setPricing_plan("Personal Tier Free, Price: $49.97, Monthly: $0.00, Free Days: 90");
		SignupModel.setSet_esf(false);

		SignupWithBluetoothDevice ss = new SignupWithBluetoothDevice(SignupModel);
		ss.signupWithBluetoothDevice(true);
	}

//	@Test
	public void verifyDeviceReplacement() throws Exception {

		SignupModel SignupModel = new SignupModel();

		SignupModel.setAccount_type("personal");
		SignupModel.setPersonal_plan("vip");
		SignupModel.setChoose_personal_billing_interval("monthly");
		SignupModel.setPricing_plan("90 days personal plan");
		SignupModel.setSet_esf(false);

		DeviceReplacement n = new DeviceReplacement(SignupModel);
		n.deviceReplacement();
	}

//	@Test(priority = 8)
	public void verifyMarkReplacedDeviceForReuse() throws Exception {
		MarkReplacedDeviceForReuse l = new MarkReplacedDeviceForReuse();
		l.markReplacedDeviceForReuse();
	}

}
