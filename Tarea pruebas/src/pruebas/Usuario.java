package pruebas;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	int saldo_clp;
	int saldo_usd;
	int sesion_us;
	ArrayList<String> movimientos= new ArrayList<String>();
	int mov;

	
	public Usuario() {
		this.saldo_clp = 1000000;
		this.saldo_usd = 1000;
		this.movimientos.add(this.saldo_clp+", CLP, "+this.saldo_usd+", USD");
		this.sesion_us=1;
		this.mov=1;
	}
	
	
	
	public static void deposito (Usuario unico,String curr, int plata) {
		if (curr.compareTo("CLP")==0) {
			unico.saldo_clp+=plata;
			unico.movimientos.add(unico.saldo_clp+", CLP, "+unico.saldo_usd+", USD");
			unico.mov+=1;
			System.out.println("Depósito exitoso");
		}
		if (curr.compareTo("USD")==0) {
			unico.saldo_usd+=plata;
			unico.movimientos.add(unico.saldo_clp+", CLP, "+unico.saldo_usd+", USD");
			unico.mov+=1;
			System.out.println("Depósito exitoso");
		}
	}
	public static void retiro (Usuario unico,String curr, int plata) {
		if (curr.compareTo("CLP")==0) {
			unico.saldo_clp-=plata;
			unico.movimientos.add(unico.saldo_clp+", CLP, "+unico.saldo_usd+", USD");
			unico.mov+=1;
			System.out.println("Retiro exitoso");
		}
		if (curr.compareTo("USD")==0) {
			unico.saldo_usd-=plata;
			unico.movimientos.add(unico.saldo_clp+", CLP, "+unico.saldo_usd+", USD");
			unico.mov+=1;
			System.out.println("Retiro exitoso");
		}
	}
	
	public static void main(String[] args)
	{
		Usuario usuario = new Usuario();
		Scanner user_input = new Scanner(System.in);
		System.out.println("Bienvenido a Banco Azul, selecciona operación a realizar:");
		System.out.println("'1' Depósito");
		System.out.println("'2' Retiro");
		System.out.println("'3' Ver transacciones");
		System.out.println("'4' Cerrar sesión");
		
		
		
		
		
		int option =Integer.parseInt(user_input.next());
		while (usuario.sesion_us<4 ) {
			if (option==1 && usuario.sesion_us<4) {
				System.out.println("Ingrese Monto a depositar y moneda, formato (Currency, Amount)");
				String plata_dep =user_input.next();
				int plata=user_input.nextInt();
				String curr=plata_dep.substring(0,3);
				System.out.println(curr);
				
				System.out.println(plata);
				deposito(usuario,curr,plata);
;
				
			}
			else if (option==2 && usuario.sesion_us<4) {
				System.out.println("Ingrese monto a retirar y moneda, formato (Currency, Amount)");
				String plata_dep =user_input.next();
				int plata=user_input.nextInt();
				if ((plata_dep.compareTo("CLP")==0 && (plata>200000 || plata<0)) || (plata_dep.compareTo("USD")==0 && (plata>100 || plata<0)))
				{
					System.out.println("Monto excede limites (max =CLP 200000, USD 100. min =0) ");
				}
				else 
				{
					retiro(usuario,plata_dep,plata);
				}
				
			}
			else if (option==3 && usuario.sesion_us<4) {
				int i;
				for (i = 0; i < usuario.movimientos.size(); i++) { 
					  
		            // accessing each element of array 
		            String x = usuario.movimientos.get(i); 
		            System.out.print(x + "\n"); 
		            
		        } 
				usuario.mov+=1;
			}
			
			if ((option!=4 && usuario.mov<4) && usuario.sesion_us<4) {
				System.out.println("Bienvenido a Banco Azul, selecciona operación a realizar:");
				System.out.println("'1' Depósito");
				System.out.println("'2' Retiro");
				System.out.println("'3' Ver transacciones");
				System.out.println("'4' Cerrar sesión");
				option =Integer.parseInt(user_input.next());
			}
			if ((option==4 || usuario.mov>3))
			{
				System.out.println("Se ha cerrado la sesión, para volver a iniciar sesión presione '1'");
				option =Integer.parseInt(user_input.next());
				while (option!=1) {
					System.out.println("Se ha cerrado la sesión, para volver a iniciar sesión presione '1'");
					option =Integer.parseInt(user_input.next());
				}
				usuario.sesion_us+=1;
				usuario.movimientos=new ArrayList<String>();
				usuario.mov=1;
				if(usuario.sesion_us<4 ) {
				System.out.println("Bienvenido a Banco Azul, selecciona operación a realizar:");
				System.out.println("'1' Depósito");
				System.out.println("'2' Retiro");
				System.out.println("'3' Ver transacciones");
				System.out.println("'4' Cerrar sesión");
				option =Integer.parseInt(user_input.next());
				}
				else {
					System.out.println("Limite de sesiones alcanzado.");
				}
			}
			
			
		}
		
		
	
		
		user_input.close();
	}
	public int getSaldo_clp() {
		return this.saldo_clp;
	}

	public void setSaldo_clp(int saldo_clp) {
		this.saldo_clp = saldo_clp;
	}

	public int getSaldo_usd() {
		return saldo_usd;
	}

	public void setSaldo_usd(int saldo_usd) {
		this.saldo_usd = saldo_usd;
	}

	public int getSesion_us() {
		return sesion_us;
	}

	public void setSesion_us(int sesion_us) {
		this.sesion_us = sesion_us;
	}

	public ArrayList<String> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<String> movimientos) {
		this.movimientos = movimientos;
	}

	public int getMov() {
		return mov;
	}

	public void setMov(int mov) {
		this.mov = mov;
	}
	
	
	
}