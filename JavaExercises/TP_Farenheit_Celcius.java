package tpFarenCelcius;

import java.util.Scanner;

public class TP_Farenheit_Celcius {

	public static void main(String[] args) {
		Scanner sc = null;
		double ToConvert = 0.0f, Converted = 0.0f; 
		char Choix = ' ', Reponse = ' ';
		try{
			sc = new Scanner(System.in);		
			System.out.println("CONVERTISSEUR DE DEGRÉS CELSIUS / DEGRÉS FARENHEIT");
			System.out.println("--------------------------------------------------");
			
			do{
				do{
					System.out.println("Choisissez un type de convertion : ");
					System.out.println("1- Convertir Celsius - Farenheit.");
					System.out.println("2- Convertir Farenheit - Celsius.");
					
					Choix = sc.nextLine().charAt(0);
					if(Choix != '1' && Choix != '2')
						System.out.println("Type non reconnu, essayer encore...");
					
				}while(Choix != '1' && Choix != '2');
				
				System.out.println("Quel est la température à convertir ? : ");
				
				ToConvert = sc.nextDouble();
				sc.nextLine();
				
				switch(Choix){
					case '1':
						Converted = Arrondir(CelsiusToFarenheit(ToConvert), 2);
						System.out.println(ToConvert + "\u00b0C correspond à " + Converted + "\u00b0F");
						break;
					case '2':
						Converted = Arrondir(FarenheitToCelsius(ToConvert), 2);
						System.out.println(ToConvert + "\u00b0F correspond à " + Converted + "\u00b0C");
						break;
					default:
						break;
				}
				
				do{
					System.out.println("Souhaitez-vous convertir une autre température ?(O/N)");
					Reponse = sc.nextLine().charAt(0);
		        }while(Reponse != 'O' && Reponse != 'N');
			}while(Reponse == 'O');
			
			System.out.println("Bye. Thanks!");	
		}finally{
			if(sc != null)
				sc.close();
		}
	}
	
	public static double Arrondir(double A, int B) {
		  return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
		}
	
	public static double CelsiusToFarenheit(double ToConvert){
		return (double) (((9.0 / 5.0) * ToConvert) + 32.0);
	}
	
	public static double FarenheitToCelsius(double ToConvert){
		return (double) (((ToConvert - 32.0) * 5.0) / 9.0);
	}

}
