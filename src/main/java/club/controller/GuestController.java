package club.controller;

public class GuestController implements InterfaceController{

	public GuestController(){
		
	}

	@Override
	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = menu();
		}	
	}

	private boolean menu() {
		try {
			System.out.print("MENU \n 1. Hacer consumo \2. Convertirse en socio");
			String option = Utils.getReader().nextLine();
			return options(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private boolean options(String option) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void bePartner() {
		
	}
	
}
