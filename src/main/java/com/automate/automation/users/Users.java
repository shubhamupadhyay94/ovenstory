package com.automate.automation.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.automate.automation.bo.User;
import com.automate.framework.excelutilities.ExcelUtility;

public class Users {
	
	static List<User> userList = null;

	

	public static List<User> returnUserList(){
		try {
			userList= new ArrayList<User>();
			userList=ExcelUtility.readExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
		
	}
	

	public static User getUser() {
		User user = userList.get(0);
		return user;

	}
	
	public static void main(String args[]) {
		returnUserList();
		getUser();
	}
}
