package club;

import club.config.MYSQLConnection;
import club.controller.AdminController;
import club.controller.InterfaceController;
import club.controller.LoginController;
import club.controller.PartnerController;
import club.dao.GuestDaoImplementation;

@SuppressWarnings("unused")
public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		InterfaceController controller = new LoginController();
		AdminController admin = new AdminController(); 
		try {
			controller.session();
			//MYSQLConnection.getConnection();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	} 

}
