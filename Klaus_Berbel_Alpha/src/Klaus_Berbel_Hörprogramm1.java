import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Klaus_Berbel_Hörprogramm1 {
	
	static String[] wort = new String[9999999];

	public static void main(String[] args) throws IOException {
		
		// Wortschatz wird an internen Vektor übergeben
		int z = 1;
		try {
	        FileReader f0 = new FileReader("Wortschatz.txt");
	        BufferedReader f = new BufferedReader(f0);
	        String line;
	        
	        while ((line = f.readLine()) != null) {
	        		wort[z]=line;
	        		z++;
	        }
	    }
	    catch (FileNotFoundException e2) {
	        e2.printStackTrace();
	    }
	    catch (IOException e1) {
	        e1.printStackTrace();
	    }
		
	    System.out.println("Hallo! Ich bin Klaus Bärbel. Erzähle mir was");
	    
		for(int i=0;i>-1;i++){
			
			boolean hsobjfound = false;
			boolean ns1objfound = false;
			boolean ns2objfound = false;
			int prädikatbekannt = -1;
			int wortbekannt = 0;
			int wortbekannt2 = 0;
			int wortunbekanntpos = 0;
			String unbekannteswort = "";
			
			// Zeile wird ausgelesen gesplitted und einzelne Wörter an Vektor satzwörter übergeben
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String eingabe = br.readLine();
			
			String[] satzwörter = eingabe.split("\\s");

			String[][] satzmatrix = new String[satzwörter.length][12];
			
			for (int a=0; a<satzwörter.length; a++){
				for (int b=1; b<z; b++){
					// Zeilen des Wortschatzes werden gesplitted
					String[] wortwörter = wort[b].split("\\s");
					
					// Suche nach Übereinstimmung im Wortschatz
					if (wortwörter[0].equals(satzwörter[a])) {
						
						wortbekannt++;
						
						// Satzmatrix wird ausgefüllt
						for (int c=0; c<12; c++){
							satzmatrix[a][c]=wortwörter[c];
						}
						
						if(satzmatrix[a][1].equals("Verb")&&satzmatrix[a][8].equals("infinit")){
							// infinite Verben stellen ein Prädikat da
							satzmatrix[a][10]="Prädikat";
							prädikatbekannt = a;}
						if(satzmatrix[a][1].equals("Adverb")&&satzmatrix[a-1][1].equals("verb")&& a>1){
							satzmatrix[a][10]="Prädikat";
							satzmatrix[a-1][10]="Prädikat";
							prädikatbekannt = a;
						}
					}
				}
				
				if(wortbekannt2 == wortbekannt){
					unbekannteswort = satzwörter[a];
					//System.out.println(unbekannteswort);
					wortunbekanntpos = a;
					
				}
				
				wortbekannt2 = wortbekannt;
				
			}
			
			
			String satz = "";
			String satz1="";
			String nullsatz = "";
			if(wortbekannt == satzwörter.length){
			
				//for (int a=0; a<satzwörter.length; a++){System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][1]+" "+satzmatrix[a][2]+" "+satzmatrix[a][3]+" "+satzmatrix[a][4]+" "+satzmatrix[a][5]+" "+satzmatrix[a][6]+" "+satzmatrix[a][7]+" "+satzmatrix[a][8]+" "+satzmatrix[a][9]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);}
				if(satzmatrix[0][10].equals("Prädikat")||satzmatrix[0][1].equals("Fragewort")||(satzmatrix[1][1].equals("Fragewort")&&satzmatrix[0][1].equals("Präposition"))){
					// Hier kommt die Frage hin
					
					// Satz wird aufaddiert zum Abgleich mit den Antworten
					for (int a=0; a<satzwörter.length; a++){
						//System.out.println(satzmatrix[a][0]+","+satzmatrix[a][1]+","+satzmatrix[a][2]);
						nullsatz = satz1;
						satz1 = nullsatz+satzmatrix[a][0]+" ";
						satz = satz1; 
					}	
					
					// Sucht nach Antworten
					int zähler = 1;String[] fragen = new String[9999999];
					boolean antwortgefunden = false;
					
					try {
				        FileReader f1 = new FileReader("Antworten.txt");
				        BufferedReader ff1 = new BufferedReader(f1);
				        String line;
				        
		
				        while ((line = ff1.readLine()) != null) {
		
				        	String frage1 = "";String frage2 = "";
				        	String antwort1 = "";String antwort2 = "";
				        	fragen[zähler]=line;
				        	zähler++;
				        	
				        	int trennpos = 0;
				        	String[] fragewörter = line.split("\\s");
				        	
				        	for(int b =0; b<fragewörter.length;b++){
				        		if(fragewörter[b].equals(":")){trennpos = b;}
				        	}
				        	for(int c =0; c<trennpos;c++){
				        		frage1 = frage2+" "+fragewörter[c];
				        		frage2 = frage1;
				        		//frage1 = frage2;System.out.println(frage1);
				        	}
				        	frage2=frage1+" ";
				        	for(int c =trennpos+1; c<fragewörter.length;c++){
				        		antwort1 = antwort2+fragewörter[c]+" ";
				        		antwort2 = antwort1;
				        	}
				        	
				        	if(frage2.equals(" "+satz)||frage2.equals("  "+satz)){System.out.println(antwort2);antwortgefunden = true;}
				        	
				        	//System.out.println(antwort2);
				        	//System.out.println(satz);
				        	
				        }
				    }
				    catch (FileNotFoundException e2) {
				        e2.printStackTrace();
				    }
				    catch (IOException e1) {
				        e1.printStackTrace();
				    }
					
					// Fragen mit Verneinungen
					if(antwortgefunden == false){
						
						if(satzmatrix[0][10].equals("Prädikat")){
							satz = "";
							satz1="";
							nullsatz = "";
							for (int a=0; a<satzwörter.length; a++){
								//System.out.println(satzmatrix[a][0]+","+satzmatrix[a][1]+","+satzmatrix[a][2]);
								nullsatz = satz1;
								if(satzmatrix[a][0].equals("nicht")){}
								else {satz1 = nullsatz+satzmatrix[a][0]+" ";}
								satz = satz1; 
								//System.out.println(satz);
							}
							
							try {
						        FileReader f1 = new FileReader("Antworten.txt");
						        BufferedReader ff1 = new BufferedReader(f1);
						        String line;
						        
				
						        while ((line = ff1.readLine()) != null) {
				
						        	String frage1 = "";String frage2 = "";
						        	fragen[zähler]=line;
						        	zähler++;
						        	
						        	int trennpos = 0;
						        	String[] fragewörter = line.split("\\s");
						        	
						        	for(int b =0; b<fragewörter.length;b++){
						        		if(fragewörter[b].equals(":")){trennpos = b;}
						        	}
						        	for(int c =0; c<trennpos;c++){
						        		frage1 = frage2+" "+fragewörter[c];
						        		frage2 = frage1;
						        		//frage1 = frage2;System.out.println(frage1);
						        	}
						        	frage2=frage1+" ";
						        	
						        	
						        	if(frage2.equals(" "+satz)||frage2.equals("  "+satz)){System.out.println("Nein");antwortgefunden = true;}
						        	
						        	//System.out.println(antwort2);
						        	//System.out.println(satz);
						        	
						        }
						    }
						    catch (FileNotFoundException e2) {
						        e2.printStackTrace();
						    }
						    catch (IOException e1) {
						        e1.printStackTrace();
						    }
						}
					}
					
					/**
					if(antwortgefunden == false){
						
						if(satzmatrix[0][10].equals("Prädikat")){
							satz = "";
							satz1="";
							nullsatz = "";
							for (int a=0; a<satzwörter.length; a++){
								//System.out.println(satzmatrix[a][0]+","+satzmatrix[a][1]+","+satzmatrix[a][2]);
								nullsatz = satz1;
								if(satzmatrix[a][1].equals("Verb")){satz1 = nullsatz+satzmatrix[a][0]+" nicht ";}
								else {satz1 = nullsatz+satzmatrix[a][0]+" ";}
								satz = satz1; 
								//System.out.println(satz);
							}
							
							try {
						        FileReader f1 = new FileReader("Antworten.txt");
						        BufferedReader ff1 = new BufferedReader(f1);
						        String line;
						        
				
						        while ((line = ff1.readLine()) != null) {
				
						        	String frage1 = "";String frage2 = "";
						        	fragen[zähler]=line;
						        	zähler++;
						        	
						        	int trennpos = 0;
						        	String[] fragewörter = line.split("\\s");
						        	
						        	for(int b =0; b<fragewörter.length;b++){
						        		if(fragewörter[b].equals(":")){trennpos = b;}
						        	}
						        	for(int c =0; c<trennpos;c++){
						        		frage1 = frage2+" "+fragewörter[c];
						        		frage2 = frage1;
						        		//frage1 = frage2;System.out.println(frage1);
						        	}
						        	frage2=frage1+" ";
						        	
						        	
						        	if(frage2.equals(" "+satz)||frage2.equals("  "+satz)){System.out.println("nein");antwortgefunden = true;}
						        	
						        	//System.out.println(antwort2);
						        	//System.out.println(satz);
						        	
						        }
						    }
						    catch (FileNotFoundException e2) {
						        e2.printStackTrace();
						    }
						    catch (IOException e1) {
						        e1.printStackTrace();
						    }
						}
					}
					**/
					
					if(antwortgefunden == false){// Suche nach verneinten Aussagen
						
						if(satzmatrix[0][10].equals("Prädikat")){// nur Booleanfragen
							
							satz = "";
							satz1="";
							nullsatz = "";
							for (int a=0; a<satzwörter.length; a++){
								//System.out.println(satzmatrix[a][0]+","+satzmatrix[a][1]+","+satzmatrix[a][2]);
								nullsatz = satz1;
								if(satzmatrix[a][0].equals("ein")){satz1 = nullsatz+"kein ";}
								else if(satzmatrix[a][0].equals("eine")){satz1 = nullsatz+"keine ";}
								else if(satzmatrix[a][0].equals("einer")){satz1 = nullsatz+"keiner ";}
								else if(satzmatrix[a][0].equals("einen")){satz1 = nullsatz+"keinen ";}
								else if(satzmatrix[a][0].equals("einem")){satz1 = nullsatz+"keinem ";}
								else if(satzmatrix[a][0].equals("eines")){satz1 = nullsatz+"keines ";}
								else {satz1 = nullsatz+satzmatrix[a][0]+" ";}
								satz = satz1; 
							}
							
							try {
						        FileReader f1 = new FileReader("Antworten.txt");
						        BufferedReader ff1 = new BufferedReader(f1);
						        String line;
						        
				
						        while ((line = ff1.readLine()) != null) {
				
						        	String frage1 = "";String frage2 = "";
						        	fragen[zähler]=line;
						        	zähler++;
						        	
						        	int trennpos = 0;
						        	String[] fragewörter = line.split("\\s");
						        	
						        	for(int b =0; b<fragewörter.length;b++){
						        		if(fragewörter[b].equals(":")){trennpos = b;}
						        	}
						        	for(int c =0; c<trennpos;c++){
						        		frage1 = frage2+" "+fragewörter[c];
						        		frage2 = frage1;
						        		//frage1 = frage2;System.out.println(frage1);
						        	}
						        	frage2=frage1+" ";
						        	
						        	
						        	if(frage2.equals(" "+satz)||frage2.equals("  "+satz)){System.out.println("nein");antwortgefunden = true;}
						        	
						        	//System.out.println(antwort2);
						        	//System.out.println(satz);
						        	
						        }
						    }
						    catch (FileNotFoundException e2) {
						        e2.printStackTrace();
						    }
						    catch (IOException e1) {
						        e1.printStackTrace();
						    }
						}	
					}
					
					if(antwortgefunden == false){
						System.out.println("Das kann ich leider nicht beantworten.");
					}
				}
				//else if(satzmatrix[0][1].equals("Fragewort")){
					// So werden weitere Fragen eingeleitet
				//}
				else{
					// Hier beginnt die Aussage Analyse
					// Nächster Schritt ist die Satzteilung
					
					int verbzähler = 0, nebesätze =0, hauptsätze = 1;
					//String hsausgabe = "Hauptsatz"+hauptsätze;
					boolean hauptsatz = true;
					for (int a=0; a<satzwörter.length; a++){
						if(satzmatrix[a][1].equals("Konjunktion")){hauptsatz = false;nebesätze++;}
						if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){
							if(satzmatrix[a][0].equals("der")||satzmatrix[a][0].equals("die")||satzmatrix[a][0].equals("der")){hauptsatz = false;nebesätze++;}
						}
						if (satzmatrix[a][10].equals("Prädikat")&&satzmatrix[a-1][10].equals("Prädikat")&&a>1){hauptsatz = true;}
						
						//int hsverbzähler = 0;
						if(hauptsatz == true){
							satzmatrix[a][11]="Hauptsatz";
						}
						else{satzmatrix[a][11]="Nebensatz"+nebesätze;}
					}
					
					// Nächster Schritt ist die Einteilung der Satzteile in Satzglieder
					
					String ersterSatzteil = satzmatrix[0][11];
					int satzgliedzähler = 1;
					int satzgliedzähler1 = 1;
					int satzgliedzähler2 = 1;
					//String Satzglied = "Satzglied"+satzgliedzähler;
					
					for (int a=0; a<satzwörter.length; a++){
						if(satzmatrix[a][11].equals(ersterSatzteil)){ // Satzgliederteilung im ersten Teilsatz
							if(ersterSatzteil.equals("Hauptsatz")){
								if(satzmatrix[a][10].equals("Prädikat")){satzgliedzähler++;}
								else{satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler;}
							}
							else if(ersterSatzteil.equals("Nebensatz1")){
								//Satzgliedteilung bei Nebensätzen
								if(satzmatrix[a][10].equals("Prädikat")){satzgliedzähler++;}
								else{
									if(satzmatrix[a][1].equals("Konjunktion")){
										satzmatrix[a][10] ="Konjunktion";
									}
									else if(satzmatrix[a][1].equals("Pronomen")){
										satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler;
										satzgliedzähler++;
									}
									else if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){satzgliedzähler++;
										// Nach einem Substantiv folgt kein Wort mehr, dass zu dessen Satzglied dazu gehört
										satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler;
									}
									else{
										satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler;
									}
								}
							}
						}
						else{
							String zweiterSatzteil = satzmatrix[a][11];
							if(satzmatrix[a][11].equals(zweiterSatzteil)){ // Satzgliederteilung im zweiten Teilsatz
								if(zweiterSatzteil.equals("Hauptsatz")){
									if(satzmatrix[a][10].equals("Prädikat")){satzgliedzähler1++;}
									else{satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler1;}
								}
								else{
									//Satzgliedteilung bei Nebensätzen
									// Fall Bestimmung von Einschiebungen ab zweitem Nebensatz      if(satzmatrix[a-1][11].equals("Hauptsatz")&&satzmatrix[a][0].equals("die")){}
									if(satzmatrix[a][10].equals("Prädikat")){if(zweiterSatzteil.equals("Nebensatz1")){satzgliedzähler1++;}
									if(zweiterSatzteil.equals("Nebensatz2")){satzgliedzähler2++;}}
									else{
										if(satzmatrix[a][1].equals("Konjunktion")){
											satzmatrix[a][10] ="Konjunktion";
										}
										else if(satzmatrix[a][1].equals("Pronomen")){
											if(zweiterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler1;}
											if(zweiterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler2;}
											
											if(zweiterSatzteil.equals("Nebensatz1")){satzgliedzähler1++;}
											if(zweiterSatzteil.equals("Nebensatz2")){satzgliedzähler2++;}
										}
										else if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){if(zweiterSatzteil.equals("Nebensatz1")){satzgliedzähler1++;}
										if(zweiterSatzteil.equals("Nebensatz2")){satzgliedzähler2++;}
											// Nach einem Substantiv folgt kein Wort mehr, dass zu dessen Satzglied dazu gehört
										if(zweiterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler1;}
										if(zweiterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler2;}
										}
										else{
											if(zweiterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler1;}
											if(zweiterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler2;}
										}
									}
								}
							}
							else{
								String dritterSatzteil = satzmatrix[a][11];
								if(satzmatrix[a][11].equals(dritterSatzteil)){ // Satzgliederteilung im dritten Teilsatz
									if(dritterSatzteil.equals("Hauptsatz")){
										if(satzmatrix[a][10].equals("Prädikat")){satzgliedzähler2++;}
										else{satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler2;}
									}
									else{
										//Satzgliedteilung bei Nebensätzen
										// Fall Bestimmung von Einschiebungen ab zweitem Nebensatz      if(satzmatrix[a-1][11].equals("Hauptsatz")&&satzmatrix[a][0].equals("die")){}
										if(satzmatrix[a][10].equals("Prädikat")){if(dritterSatzteil.equals("Nebensatz1")){satzgliedzähler1++;}
										if(dritterSatzteil.equals("Nebensatz2")){satzgliedzähler2++;}}
										else{
											if(satzmatrix[a][1].equals("Konjunktion")){
												satzmatrix[a][10] ="Konjunktion";
											}
											else if(satzmatrix[a][1].equals("Pronomen")){
												if(dritterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler1;}
												if(dritterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler2;}
												
												if(dritterSatzteil.equals("Nebensatz1")){satzgliedzähler1++;}
												if(dritterSatzteil.equals("Nebensatz2")){satzgliedzähler2++;}
											}
											else if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){if(dritterSatzteil.equals("Nebensatz1")){satzgliedzähler1++;}
											if(dritterSatzteil.equals("Nebensatz2")){satzgliedzähler2++;}
												// Nach einem Substantiv folgt kein Wort mehr, dass zu dessen Satzglied dazu gehört
											if(dritterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler1;}
											if(dritterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler2;}
											}
											else{
												if(dritterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler1;}
												if(dritterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedzähler2;}
											}
										}
									}
								}
							}
						}
					}
					
					boolean objektgefunden = false;
					String[] präpositionalVektor = new String[3];
					String[] KasusVektor = new String[3];
					for (int a=0; a<satzwörter.length; a++){
						// Nächster Schritte die unbestimmten Satzglieder als Objekte oder Subjekte einzuordnen
						if(a>0&&satzmatrix[a-1][1].equals("Artikel")){}
						else{
							if(satzmatrix[a][1].equals("Adjektiv")){ // alleinstehende Adjektive sind Objekte
								satzmatrix[a][10]="Objekt";objektgefunden = true;
								if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
								if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
								if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								for (int b=0; b<satzwörter.length; b++){ // übrig bleibendes Satzglied wird zum Subjekt
									if(satzmatrix[b][11].equals(satzmatrix[a][11])){
										if(satzmatrix[b][10].equals("Objekt")||satzmatrix[b][10].equals("Prädikat")||satzmatrix[b][10].equals("Konjunktion")){}
										else{satzmatrix[b][10]="Subjekt";}
									}
								}
							}
						}
					}
					
					int präpozähler=0;
					for (int a=0; a<satzwörter.length; a++){
						if(satzmatrix[a][1].equals("Präposition")){ // Verschiedene Präposition ziehen verschiedene Fälle nach sich: siehe Wikipedia
							if(satzmatrix[a][7].equals("akkusativ")){präpositionalVektor[0]=satzmatrix[a][10];präpositionalVektor[1]=satzmatrix[a][11];präpositionalVektor[2]="akkusativ";}
							if(satzmatrix[a][7].equals("dativ")){präpositionalVektor[0]=satzmatrix[a][10];präpositionalVektor[1]=satzmatrix[a][11];präpositionalVektor[2]="dativ";}
							if(satzmatrix[a][7].equals("genetiv")){präpositionalVektor[0]=satzmatrix[a][10];präpositionalVektor[1]=satzmatrix[a][11];präpositionalVektor[2]="genetiv";}
							if(satzmatrix[a][7].equals("datakk")){präpositionalVektor[0]=satzmatrix[a][10];präpositionalVektor[1]=satzmatrix[a][11];präpositionalVektor[2]="datakk";}
							satzmatrix[a][10]="Objekt";objektgefunden = true;
							if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
							if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
							if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
						}
						if(satzmatrix[a][10].equals(präpositionalVektor[0])&&satzmatrix[a][11].equals(präpositionalVektor[1])){
							satzmatrix[a][10]="Objekt";satzmatrix[a][7]=präpositionalVektor[2];objektgefunden = true;
							if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
							if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
							if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
							präpozähler = a;
						}
					}
					
					/**
					int adjektivposition = 0;
					for (int a=0; a<satzwörter.length; a++){// Alles was explizit ein Element mit einem der nicht SubjektFälle enthält wird zum Objekt
						if(satzmatrix[a][1].equals("Substantiv")||satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Adjektiv")){ // Ausschließbarkeit des Nominatives impliziert ein Objekt
							if(satzmatrix[a][7].equals("genetiv")||satzmatrix[a][7].equals("dativ")||satzmatrix[a][7].equals("akkusativ")){
								for (int b=0; b<satzwörter.length; b++){
									if(satzmatrix[b][11].equals(satzmatrix[a][11])&&satzmatrix[b][10].equals(satzmatrix[a][10])){
										satzmatrix[b][10]="Objekt";objektgefunden = true;
										if(satzmatrix[b][11].equals("Hauptsatz")){hsobjfound=true;}
										if(satzmatrix[b][11].equals("Nebensatz1")){ns1objfound=true;}
										if(satzmatrix[b][11].equals("Nebensatz2")){ns2objfound=true;}
										//adjektivposition = b;
									}
								}
							}
						}
					}
					**/
					
					// Artikelkombinationen zur Fallbestimmung
					for (int a=0; a<satzwörter.length; a++){
						if(satzmatrix[a][1].equals("Substantiv")||satzmatrix[a][1].equals("Adjektiv")){
							
							if(a>0){
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("der")){
									if(satzmatrix[a][4].equals("feminim")){
										satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
										
										if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";}
										else{
											
											if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										}
										
									}
									if(satzmatrix[a][3].equals("singular")&&satzmatrix[a][4].equals("maskulim")){
										satzmatrix[a][10]="Subjekt";satzmatrix[a-1][10]="Subjekt";
										
									}
									if(satzmatrix[a][3].equals("plural")&&satzmatrix[a][4].equals("maskulim")){
										satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
										//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
										
									}
									if(satzmatrix[a][4].equals("neutral")){
										satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
										satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
										//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
									}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("des")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";//objektgefunden = true;
									satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
									//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("dem")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
									satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("den")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
									if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";}
									else{satzmatrix[a][7]="akkusativ";satzmatrix[a-1][7]="akkusativ";}
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("eines")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
									satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
									//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("einem")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
									satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("einer")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
							}
							
							// Artikel + Adjektiv + Substantiv als Objekt
							
							if(a>1){
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("der")){
									if(satzmatrix[a][4].equals("feminim")){
										satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
										
										if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";}
										else{
											
											if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										}
										
									}
									if(satzmatrix[a][3].equals("singular")&&satzmatrix[a][4].equals("maskulim")){
										satzmatrix[a][10]="Subjekt";satzmatrix[a-1][10]="Subjekt";satzmatrix[a-2][10]="Subjekt";
										
									}
									if(satzmatrix[a][3].equals("plural")&&satzmatrix[a][4].equals("maskulim")){
										satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
										satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
										//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
									}
									if(satzmatrix[a][4].equals("neutral")){
										satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
										satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
										//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
									}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("des")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
									satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
									//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("dem")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
									satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";satzmatrix[a-2][7]="dativ";
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("den")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
									if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";satzmatrix[a-2][7]="dativ";}
									else{satzmatrix[a][7]="akkusativ";satzmatrix[a-1][7]="akkusativ";satzmatrix[a-2][7]="akkusativ";}
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("eines")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
									satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
									//if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("einem")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
									satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";satzmatrix[a-2][7]="dativ";
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("einer")){
									satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
							}
						}
					}
					
					for (int a=0; a<satzwörter.length; a++){
						if(satzmatrix[a][0].equals("nicht")){
							satzmatrix[a][10]="Objekt";
						}
					}
					
					// Falls Objekte nicht gefunden mache das nach dem Prädikat zum Objekt
					int verbstelle1 = -1;
					
					for (int a=0; a<satzwörter.length; a++){
						if (hsobjfound==false){
							if(satzmatrix[a][10].equals("Prädikat")&&satzmatrix[a][11].equals("Hauptsatz")){verbstelle1 = a;}
							if(verbstelle1 != -1 && a>verbstelle1 && satzmatrix[a][11].equals("Hauptsatz")){
								if(satzmatrix[a][10].equals("Objekt")){}
								else{satzmatrix[a][10]="Objekt";satzmatrix[a][7]="akkusativ";}
			
								
							}
						}
						if (ns1objfound==false){
							if(satzmatrix[a][10].equals("Prädikat")&&satzmatrix[a][11].equals("Nebensatz1")){
								for (int b=0; b<satzwörter.length; b++){
									if(a>0 && satzmatrix[b][11].equals("Nebensatz1")&& satzmatrix[b][10].equals(satzmatrix[a-1][10])){
										satzmatrix[b][10]="Objekt";satzmatrix[b][7]="akkusativ";
									}
								}
							}
						}
						if (ns2objfound==false){
							if(satzmatrix[a][10].equals("Prädikat")&&satzmatrix[a][11].equals("Nebensatz2")){//verbstelle3 = a;
								for (int b=0; b<satzwörter.length; b++){
									if(a>0 && satzmatrix[b][11].equals("Nebensatz2")&& satzmatrix[b][10].equals(satzmatrix[a-1][10])){
										satzmatrix[b][10]="Objekt";satzmatrix[b][7]="akkusativ";
									}
								}
							}
						}
					}	
					
					// Dafür müssen alle Objekte gefunden sein
					for (int b=0; b<satzwörter.length; b++){ // übrig bleibendes Satzglied wird zum Subjekt
						if(satzmatrix[b][10].equals("Objekt")||satzmatrix[b][10].equals("Prädikat")||satzmatrix[b][10].equals("Konjunktion")){}
						else{satzmatrix[b][10]="Subjekt";}
					}
					
					// Gibt die Satzmatrix aus (einmal komplett einmal gekürzt)
					//for (int a=0; a<satzwörter.length; a++){System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][1]+" "+satzmatrix[a][2]+" "+satzmatrix[a][3]+" "+satzmatrix[a][4]+" "+satzmatrix[a][5]+" "+satzmatrix[a][6]+" "+satzmatrix[a][7]+" "+satzmatrix[a][8]+" "+satzmatrix[a][9]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);}
					//for (int a=0; a<satzwörter.length; a++){System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][7]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);}
					
					// Satzanalyse ist fertig. Nun werden zu der Aussage Fragen und Antworten formuliert
					// Später werden diese Fragen und Antworten gespeichert
					// Sollte der Nutzer jemals einer dieser Fragen stellen ist Klaus Bärbel in der Lage diese zu beantworten
					
					String hspräposition = "";
					String hssubjekt = "";String hssubjekt2 = "";
					String hsobjektohneartikel = "";String hsobjekt2ohneartikel = "";
					String hsobjekt = "";String hsobjekt2 = "";
					String nichthsobjekt = "";String nichthsobjekt2 = "";boolean hsnicht = false;
					String hsobjektnom = "";String hsobjekt2nom = "";boolean hsobjektnomf = false;
					String hsobjektgen = "";String hsobjekt2gen = "";boolean hsobjektgenf = false;
					String hsobjektdat = "";String hsobjekt2dat = "";boolean hsobjektdatf = false;
					String hsobjektdatakk = "";String hsobjekt2datakk = "";boolean hsobjektdatakkf = false;
					String khsobjektdatakk = "";String khsobjekt2datakk = "";boolean hskein = false;boolean hsein = false;
					String hsdativpräpo = "";
					String hsobjektakk = "";String hsobjekt2akk = "";boolean hsobjektakkf = false;
					String hssprädikat = "";String hssprädikat2 = "";
					String ns1präposition = "";
					String ns1konjunktion = "";String ns1konjunktion2 = "";
					String ns1objekt = "";String ns1objekt2 = "";
					String ns1objektnom = "";String ns1objekt2nom = "";
					String ns1objektgen = "";String ns1objekt2gen = "";
					String ns1objektdat = "";String ns1objekt2dat = "";boolean ns1objektdatf = false;
					String ns1dativpräpo = "";
					String ns1objektakk = "";String ns1objekt2akk = "";
					String ns1subjekt = "";String ns1subjekt2 = "";
					String ns1prädikat = "";String ns1prädikat2 = "";
					String ns2präposition = "";
					String ns2konjunktion = "";String ns2konjunktion2 = "";
					String ns2objekt = "";String ns2objekt2 = "";
					String ns2objektnom = "";String ns2objekt2nom = "";
					String ns2objektgen = "";String ns2objekt2gen = "";
					String ns2objektdat = "";String ns2objekt2dat = "";
					String ns2dativpräpo = "";
					String ns2objektakk = "";String ns2objekt2akk = "";
					String ns2subjekt = "";String ns2subjekt2 = "";
					String ns2prädikat = "";String ns2prädikat2 = "";
					
					String khssubjekt = "";String khssubjekt2 = "";
					String khsobjekt = "";String khsobjekt2 = "";
					String khsobjektnom = "";String khsobjekt2nom = "";
					String khsobjektgen = "";String khsobjekt2gen = "";
					String khsobjektdat = "";String khsobjekt2dat = "";
					String khsobjektakk = "";String khsobjekt2akk = "";
					
					String khssubjekt3 = "";String khssubjekt23 = "";
					String khsobjekt3 = "";String khsobjekt23 = "";
					String khsobjektnom3 = "";String khsobjekt2nom3 = "";
					String khsobjektgen3 = "";String khsobjekt2gen3 = "";
					String khsobjektdat3 = "";String khsobjekt2dat3 = "";
					String khsobjektakk3 = "";String khsobjekt2akk3 = "";
					String khsobjektdatakk3 = "";String khsobjekt2datakk3 = "";
					
					String kns1objekt = "";String kns1objekt2 = "";
					String kns1objektnom = "";String kns1objekt2nom = "";
					String kns1objektgen = "";String kns1objekt2gen = "";
					String kns1objektdat = "";String kns1objekt2dat = "";
					String kns1objektakk = "";String kns1objekt2akk = "";
					String kns1subjekt = "";String kns1subjekt2 = "";
					String kns2objekt = "";String kns2objekt2 = "";
					String kns2objektnom = "";String kns2objekt2nom = "";
					String kns2objektgen = "";String kns2objekt2gen = "";
					String kns2objektdat = "";String kns2objekt2dat = "";
					String kns2objektakk = "";String kns2objekt2akk = "";
					String kns2subjekt = "";String kns2subjekt2 = "";
					
					boolean kein = false;
					boolean ein = false;
					//int satzgliedzähler = 0;
					
					// Satzglieder werden aufaddiert in jeweils einem String
					for (int a=0; a<satzwörter.length; a++){
						
						if(satzmatrix[a][0].equals("nicht")){hsnicht = true;}
						
						if(satzmatrix[a][10].equals("Subjekt")&&satzmatrix[a][11].equals("Hauptsatz")){
							hssubjekt2 = hssubjekt+" "+satzmatrix[a][0];
							hssubjekt = hssubjekt2;
							
							if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";hskein = true;}
							
							khssubjekt2 = khssubjekt+" "+satzmatrix[a][0];
							khssubjekt = khssubjekt2;
							
							if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
							if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
							if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
							if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
							if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
							if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
							
							khssubjekt23 = khssubjekt3+" "+satzmatrix[a][0];
							khssubjekt3 = khssubjekt23;
							
							
							
						}
						
						
						
						if(satzmatrix[a][10].equals("Objekt")&&satzmatrix[a][11].equals("Hauptsatz")){
							hsobjekt2 = hsobjekt+" "+satzmatrix[a][0];
							hsobjekt = hsobjekt2;
							
							
							
							if(satzmatrix[a][0].equals("nicht")){hsnicht = true;}
							else{
								nichthsobjekt2 = nichthsobjekt+" "+satzmatrix[a][0];
								nichthsobjekt = nichthsobjekt2;
							}
							
							if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";hskein = true;}
							if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";hskein = true;}
							
							khsobjekt23 = khsobjekt3+" "+satzmatrix[a][0];
							khsobjekt3 = khsobjekt23;
							
							if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
							if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
							if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
							if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
							if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
							if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
							khsobjekt2 = khsobjekt+" "+satzmatrix[a][0];
							khsobjekt = khsobjekt2;
							if(satzmatrix[a][7].equals("nominativ")){
								hsobjekt2nom = hsobjektnom+" "+satzmatrix[a][0];
								hsobjektnom = hsobjekt2nom;
								hsobjektnomf = true;
								
								if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Präposition")){}
								else{hsobjekt2ohneartikel = hsobjektohneartikel+" "+satzmatrix[a][0];
								hsobjektohneartikel = hsobjekt2ohneartikel;}
								
								if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";}
								
								khsobjekt2nom3 = khsobjektnom3+" "+satzmatrix[a][0];
								khsobjektnom3 = khsobjekt2nom3;
								
								if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
								if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
								if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
								if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
								if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
								if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
								khsobjekt2nom = khsobjektnom+" "+satzmatrix[a][0];
								khsobjektnom = khsobjekt2nom;
							}
							// Problem 
							if(satzmatrix[a][7].equals("genetiv")){
								if(satzmatrix[a][1].equals("Präposition")){hspräposition = satzmatrix[a][0];}
								hsobjekt2gen = hsobjektgen+" "+satzmatrix[a][0];
								hsobjektgen = hsobjekt2gen;
								hsobjektgenf = true;
								if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";}
								
								khsobjekt2gen3 = khsobjektgen3+" "+satzmatrix[a][0];
								khsobjektgen3 = khsobjekt2gen3;
								
								if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
								if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
								if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
								if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
								if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
								if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
								khsobjekt2gen = khsobjektgen+" "+satzmatrix[a][0];
								khsobjektgen = khsobjekt2gen;
							}
							if(satzmatrix[a][7].equals("dativ")){
								if(satzmatrix[a][1].equals("Präposition")){hsdativpräpo = satzmatrix[a][0];}
								hsobjekt2dat = hsobjektdat+" "+satzmatrix[a][0];
								hsobjektdat = hsobjekt2dat;
								hsobjektdatf = true;
								
								if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Präposition")){}
								else{hsobjekt2ohneartikel = hsobjektohneartikel+" "+satzmatrix[a][0];
								hsobjektohneartikel = hsobjekt2ohneartikel;}
								
								if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";}
								
								khsobjekt2dat3 = khsobjektdat3+" "+satzmatrix[a][0];
								khsobjektdat3 = khsobjekt2dat3;
								
								if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
								if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
								if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
								if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
								if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
								if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
								khsobjekt2dat = khsobjektdat+" "+satzmatrix[a][0];
								khsobjektdat = khsobjekt2dat;
							}
							if(satzmatrix[a][7].equals("datakk")){
								if(satzmatrix[a][1].equals("Präposition")){hspräposition = satzmatrix[a][0];}
								hsobjekt2datakk = hsobjektdatakk+" "+satzmatrix[a][0];
								hsobjektdatakk = hsobjekt2datakk;
								hsobjektdatakkf = true;
								
								if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Präposition")){}
								else{hsobjekt2ohneartikel = hsobjektohneartikel+" "+satzmatrix[a][0];
								hsobjektohneartikel = hsobjekt2ohneartikel;}
								
								if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";}
								
								khsobjekt2datakk3 = khsobjektdatakk3+" "+satzmatrix[a][0];
								khsobjektdatakk3 = khsobjekt2datakk3;
								
								if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
								if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
								if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
								if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
								if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
								if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
								khsobjekt2datakk = khsobjektdatakk+" "+satzmatrix[a][0];
								khsobjektdatakk = khsobjekt2datakk;
							}
							if(satzmatrix[a][7].equals("akkusativ")){
								if(satzmatrix[a][1].equals("Präposition")){hspräposition = satzmatrix[a][0];}
								hsobjekt2akk = hsobjektakk+" "+satzmatrix[a][0];
								hsobjektakk = hsobjekt2akk;
								hsobjektakkf = true;
								
								if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Präposition")){}
								else{hsobjekt2ohneartikel = hsobjektohneartikel+" "+satzmatrix[a][0];
								hsobjektohneartikel = hsobjekt2ohneartikel;}
								
								if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";}
								if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";}
								
								khsobjekt2akk3 = khsobjektakk3+" "+satzmatrix[a][0];
								khsobjektakk3 = khsobjekt2akk3;
								
								if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
								if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
								if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
								if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
								if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
								if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
								khsobjekt2akk = khsobjektakk+" "+satzmatrix[a][0];
								khsobjektakk = khsobjekt2akk;
							}
						}
						if(satzmatrix[a][10].equals("Prädikat")&&satzmatrix[a][11].equals("Hauptsatz")){
							hssprädikat2 = hssprädikat+" "+satzmatrix[a][0];
							hssprädikat = hssprädikat2;
						}
						if(satzmatrix[a][10].equals("Konjunktion")&&satzmatrix[a][11].equals("Nebensatz1")){
							ns1konjunktion2 = ns1konjunktion+" "+satzmatrix[a][0];
							ns1konjunktion = ns1konjunktion2;
						}
						if(satzmatrix[a][10].equals("Objekt")&&satzmatrix[a][11].equals("Nebensatz1")){
							ns1objekt2 = ns1objekt+" "+satzmatrix[a][0];
							ns1objekt = ns1objekt2;
							if(satzmatrix[a][7].equals("nominativ")){
								ns1objekt2nom = ns1objektnom+" "+satzmatrix[a][0];
								ns1objektnom = ns1objekt2nom;
							}
							if(satzmatrix[a][7].equals("genitiv")){
								if(satzmatrix[a][1].equals("Präposition")){ns1präposition = satzmatrix[a][0];}
								ns1objekt2gen = ns1objektgen+" "+satzmatrix[a][0];
								ns1objektgen = ns1objekt2gen;
							}
							if(satzmatrix[a][7].equals("dativ")){
								if(satzmatrix[a][1].equals("Präposition")){ns1dativpräpo = satzmatrix[a][0];}
								ns1objekt2dat = ns1objektdat+" "+satzmatrix[a][0];
								ns1objektdat = ns1objekt2dat;
								ns1objektdatf = true;
							}
							if(satzmatrix[a][7].equals("akkusativ")){
								if(satzmatrix[a][1].equals("Präposition")){ns1präposition = satzmatrix[a][0];}
								ns1objekt2akk = ns1objektakk+" "+satzmatrix[a][0];
								ns1objektakk = ns1objekt2akk;
							}
						}
						if(satzmatrix[a][10].equals("Subjekt")&&satzmatrix[a][11].equals("Nebensatz1")){
							ns1subjekt2 = ns1subjekt+" "+satzmatrix[a][0];
							ns1subjekt = ns1subjekt2;
						}
						if(satzmatrix[a][10].equals("Prädikat")&&satzmatrix[a][11].equals("Nebensatz1")){
							ns1prädikat2 = ns1prädikat+" "+satzmatrix[a][0];
							ns1prädikat = ns1prädikat2;
						}
						if(satzmatrix[a][10].equals("Konjunktion")&&satzmatrix[a][11].equals("Nebensatz2")){
							ns2konjunktion2 = ns2konjunktion+" "+satzmatrix[a][0];
							ns2konjunktion = ns2konjunktion2;
						}
						if(satzmatrix[a][10].equals("Objekt")&&satzmatrix[a][11].equals("Nebensatz2")){
							ns2objekt2 = ns2objekt+" "+satzmatrix[a][0];
							ns2objekt = ns2objekt2;
							if(satzmatrix[a][7].equals("nominativ")){
								ns2objekt2nom = ns2objektnom+" "+satzmatrix[a][0];
								ns2objektnom = ns2objekt2nom;
							}
							if(satzmatrix[a][7].equals("genitiv")){
								if(satzmatrix[a][1].equals("Präposition")){ns2präposition = satzmatrix[a][0];}
								ns2objekt2gen = ns2objektgen+" "+satzmatrix[a][0];
								ns2objektgen = ns2objekt2gen;
							}
							if(satzmatrix[a][7].equals("dativ")){
								if(satzmatrix[a][1].equals("Präposition")){ns2dativpräpo = satzmatrix[a][0];}
								ns2objekt2dat = ns2objektdat+" "+satzmatrix[a][0];
								ns2objektdat = ns2objekt2dat;
							}
							if(satzmatrix[a][7].equals("akkusativ")){
								if(satzmatrix[a][1].equals("Präposition")){ns2präposition = satzmatrix[a][0];}
								ns2objekt2akk = ns2objektakk+" "+satzmatrix[a][0];
								ns2objektakk = ns2objekt2akk;
							}
						}
						if(satzmatrix[a][10].equals("Subjekt")&&satzmatrix[a][11].equals("Nebensatz2")){
							ns2subjekt2 = ns2subjekt+" "+satzmatrix[a][0];
							ns2subjekt = ns2subjekt2;
						}
						if(satzmatrix[a][10].equals("Prädikat")&&satzmatrix[a][11].equals("Nebensatz2")){
							ns2prädikat2 = ns2prädikat+" "+satzmatrix[a][0];
							ns2prädikat = ns2prädikat2;
						}
					}
					
					//System.out.print(hssprädikat+khssubjekt+khsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja");
					// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
					int boleanzähler = 1;String[] bolfragen = new String[9999999];
					try { FileReader f1 = new FileReader("Antworten.txt");
				        BufferedReader ff1 = new BufferedReader(f1);
				        String line;
				        while ((line = ff1.readLine()) != null) {bolfragen[boleanzähler]=line;
				        		boleanzähler++;
				        }
				    }
				    catch (FileNotFoundException e2) { e2.printStackTrace();}
				    catch (IOException e1) { e1.printStackTrace();}
				
					boolean fragegefunden2 = false;
					for(int b=1;b<boleanzähler;b++){
						if(bolfragen[b].equals(hssprädikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja")){
							fragegefunden2 = true;
						}
						
						if(bolfragen[b].equals("wer"+hssprädikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)){
							fragegefunden2 = true;
						}
						if(bolfragen[b].equals("was"+hssprädikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)||bolfragen[b].equals("was"+hssprädikat+khsobjekt+" :"+khssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)){
							fragegefunden2 = true;
						}
						
						kein = false;ein = false;
						String[] keinein = bolfragen[b].split("\\s");
						for(int a=0; a<keinein.length;a++){
							if(keinein[a].equals("kein")){kein = true;}
							if(keinein[a].equals("keine")){kein = true;}
							if(keinein[a].equals("keiner")){kein = true;}
							if(keinein[a].equals("keinen")){kein = true;}
							if(keinein[a].equals("keinem")){kein = true;}
							if(keinein[a].equals("keines")){kein = true;}
							if(keinein[a].equals("ein")){ein = true;}
							if(keinein[a].equals("eine")){ein = true;}
							if(keinein[a].equals("einer")){ein = true;}
							if(keinein[a].equals("einen")){ein = true;}
							if(keinein[a].equals("einem")){ein = true;}
							if(keinein[a].equals("eines")){ein = true;}
						}
						
						if(bolfragen[b].equals(hssprädikat+khssubjekt+khsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja")){
							fragegefunden2 = true;
							
							if(hskein == false && ein == true){System.out.println("Diese Aussage ist falsch");}
						}
						
						if(bolfragen[b].equals(hssprädikat+khssubjekt+khsobjekt3+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja")){
							fragegefunden2 = true;
							
							if(hskein == true && kein == true){System.out.println("Diese Aussage ist falsch");}
						}
						
						if(hsnicht == true){
							
							if(bolfragen[b].equals(hssprädikat+khssubjekt+nichthsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja")){
								fragegefunden2 = true;
								System.out.println("Diese Aussage ist falsch.");
							}
							
						}
						
						if(bolfragen[b].equals(hssprädikat+khssubjekt+" nicht"+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja")){
							fragegefunden2 = true;
							System.out.println("Diese Aussage ist falsch.");
						}
					
					}
					
					if(fragegefunden2==false){
						// Fragen wie Antworten werden gespeichert
						try {
							BufferedWriter in = new BufferedWriter(
							        new OutputStreamWriter(
							        new FileOutputStream( "Antworten.txt", true)));
								
							try {
								in.write(hssprädikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja");
								in.newLine();
								// Versuch
								if(hsnicht==true){
									in.write(hssprädikat+hssubjekt+nichthsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Nein");
									in.newLine();
								}
								
								in.write("wer"+hssprädikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
								in.newLine();
								in.write("was"+hssprädikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
								in.newLine();
								in.close();
								} 
							catch (IOException e) {
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}	
					}
					
					
					//System.out.println(hsobjektgenf);
					
					//System.out.println(hssprädikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat+" : Ja");
					//System.out.println("wer"+hssprädikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
					//System.out.println("was"+hssprädikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
					boolean fragegefundengenitiv = false;
					if(hsobjektgenf == true){
						//System.out.println(hspräposition+"wessen"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
						
						// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
						try { FileReader f1 = new FileReader("Antworten.txt");
					        BufferedReader ff1 = new BufferedReader(f1);
					        String line;
					        while ((line = ff1.readLine()) != null) {bolfragen[boleanzähler]=line;
					        		boleanzähler++;
					        }
					    }
					    catch (FileNotFoundException e2) { e2.printStackTrace();}
					    catch (IOException e1) { e1.printStackTrace();}
					
						for(int b=1;b<boleanzähler;b++){
							if(bolfragen[b].equals(hspräposition+" wessen"+hsobjektohneartikel+hssprädikat+hssubjekt+" :"+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)){
								fragegefundengenitiv = true;
							}
						}
						
						if(fragegefundengenitiv==false){//System.out.println("blablabla");
							// Fragen wie Antworten werden gespeichert
							try {
								BufferedWriter in = new BufferedWriter(
								        new OutputStreamWriter(
								        new FileOutputStream( "Antworten.txt", true)));
									
								try {
									in.write(hspräposition+" wessen"+hsobjektohneartikel+hssprädikat+hssubjekt+" :"+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
									in.newLine();
									in.close();
									} 
								catch (IOException e) {
									e.printStackTrace();
								}
								
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}	
						}
					}
					if(hsobjektdatf == true){
						//System.out.println(hsdativpräpo+" wem"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
					
						// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
						try { FileReader f1 = new FileReader("Antworten.txt");
					        BufferedReader ff1 = new BufferedReader(f1);
					        String line;
					        while ((line = ff1.readLine()) != null) {bolfragen[boleanzähler]=line;
					        		boleanzähler++;
					        }
					    }
					    catch (FileNotFoundException e2) { e2.printStackTrace();}
					    catch (IOException e1) { e1.printStackTrace();}
					
						for(int b=1;b<boleanzähler;b++){
							if(bolfragen[b].equals(hsdativpräpo+" wem"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)||
									bolfragen[b].equals(hsdativpräpo+" wem"+hssprädikat+khssubjekt+khsobjektnom+" :"+khsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)){
								fragegefunden2 = true;
							}
						}
						
						if(fragegefunden2==false){
							// Fragen wie Antworten werden gespeichert
							try {
								BufferedWriter in = new BufferedWriter(
								        new OutputStreamWriter(
								        new FileOutputStream( "Antworten.txt", true)));
									
								try {
									in.write(hsdativpräpo+" wem"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
									in.newLine();
									in.close();
									} 
								catch (IOException e) {
									e.printStackTrace();
								}
								
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}	
						}
					}
					if(ns1objektdatf == true){
						//System.out.println(ns1dativpräpo+" wem"+ns1prädikat+hssubjekt+ns1objektnom+" :"+ns1objektdat);
					
						// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
						try { FileReader f1 = new FileReader("Antworten.txt");
					        BufferedReader ff1 = new BufferedReader(f1);
					        String line;
					        while ((line = ff1.readLine()) != null) {bolfragen[boleanzähler]=line;
					        		boleanzähler++;
					        }
					    }
					    catch (FileNotFoundException e2) { e2.printStackTrace();}
					    catch (IOException e1) { e1.printStackTrace();}
					
						for(int b=1;b<boleanzähler;b++){
							if(bolfragen[b].equals(ns1dativpräpo+" wem"+ns1prädikat+hssubjekt+ns1objektnom+" :"+ns1objektdat+hsobjektgen)||
									bolfragen[b].equals(ns1dativpräpo+" wem"+ns1prädikat+khssubjekt+ns1objektnom+" :"+ns1objektdat+hsobjektgen)){
								fragegefunden2 = true;
							}
						}
						
						if(fragegefunden2==false){
							// Fragen wie Antworten werden gespeichert
							try {
								BufferedWriter in = new BufferedWriter(
								        new OutputStreamWriter(
								        new FileOutputStream( "Antworten.txt", true)));
									
								try {
									in.write(ns1dativpräpo+" wem"+ns1prädikat+hssubjekt+ns1objektnom+" :"+ns1objektdat+hsobjektgen);
									in.newLine();
									in.close();
									} 
								catch (IOException e) {
									e.printStackTrace();
								}
								
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}	
						}
					}
					if(hsobjektdatakkf == true){
						//System.out.println(hsdativpräpo+" wem"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
					
						// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
						try { FileReader f1 = new FileReader("Antworten.txt");
					        BufferedReader ff1 = new BufferedReader(f1);
					        String line;
					        while ((line = ff1.readLine()) != null) {bolfragen[boleanzähler]=line;
					        		boleanzähler++;
					        }
					    }
					    catch (FileNotFoundException e2) { e2.printStackTrace();}
					    catch (IOException e1) { e1.printStackTrace();}
					
						for(int b=1;b<boleanzähler;b++){
							if(bolfragen[b].equals(hspräposition+" wem"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)||
									bolfragen[b].equals(hspräposition+" wem"+hssprädikat+khssubjekt+khsobjektnom+" :"+khsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)){
								fragegefunden2 = true;
							}
						}
						
						if(fragegefunden2==false){
							// Fragen wie Antworten werden gespeichert
							try {
								BufferedWriter in = new BufferedWriter(
								        new OutputStreamWriter(
								        new FileOutputStream( "Antworten.txt", true)));
									
								try {
									
									if(hskein==true){
										
										in.write(hspräposition+" wem"+hssprädikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.write(hspräposition+" wen"+hssprädikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.write(hspräposition+" was"+hssprädikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.close();
										in.close();
										
									}
									else{
										
										in.write(hspräposition+" wem"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.write(hspräposition+" wen"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.write(hspräposition+" was"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.close();
										in.close();
										
									}
									
									} 
								catch (IOException e) {
									e.printStackTrace();
								}
								
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}	
						}
					}
					if(hsobjektakkf == true){
						//System.out.println("wen"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
						//System.out.println("was"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
					
						// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
						try { FileReader f1 = new FileReader("Antworten.txt");
					        BufferedReader ff1 = new BufferedReader(f1);
					        String line;
					        while ((line = ff1.readLine()) != null) {bolfragen[boleanzähler]=line;
					        		boleanzähler++;
					        }
					    }
					    catch (FileNotFoundException e2) { e2.printStackTrace();}
					    catch (IOException e1) { e1.printStackTrace();}
					
						for(int b=1;b<boleanzähler;b++){
							if(bolfragen[b].equals(hspräposition+" wen"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)||
									bolfragen[b].equals(hspräposition+" wen"+hssprädikat+khssubjekt+khsobjektnom+" :"+khsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat)){
								
								fragegefunden2 = true;
							}
						}
						
						if(fragegefunden2==false){
							// Fragen wie Antworten werden gespeichert
							try {
								BufferedWriter in = new BufferedWriter(
								        new OutputStreamWriter(
								        new FileOutputStream( "Antworten.txt", true)));
									
								try {
									if(hskein==false){
										
										in.write(hspräposition+" wen"+hssprädikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.write(hspräposition+" was"+hssprädikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.close();
										
									}
									else{
										
										in.write(hspräposition+" wen"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.write(hspräposition+" was"+hssprädikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1prädikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2prädikat);
										in.newLine();
										in.close();
										
									}
									} 
								catch (IOException e) {
									e.printStackTrace();
								}
								
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}	
						}
					}
				}
			}
			else{// Implementiere hier Wörter-Lern Algorythmus
				
				int zahl = satzwörter.length - wortbekannt;
				if(zahl>1){System.out.println("Ich erkenne zu viele der Wörter in diesem Satz nicht.");}
				else{
					
					System.out.println("Ich kenne das Wort "+unbekannteswort+" nicht.");
					String wortschatzprinter = "";
					boolean printervoll = false;
					//System.out.println(satzmatrix[wortunbekanntpos-1][0]);
					//char[] c = unbekannteswort.toCharArray();
					//String endung = ""+c[c.length-2]+c[c.length-1];
					//System.out.println(endung);
					
					
					if(prädikatbekannt == -1){
						System.out.println("Ist das Wort ein Verb dritter Person Singular Indikativ Präsens?");
						InputStreamReader antwortreader2 = new InputStreamReader(System.in);
						BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
						String antwort2 = antwortbufferedreader2.readLine();
						
						if(antwort2.equals("ja")){
							wortschatzprinter = unbekannteswort+" Verb dritte singular - indikativ präsens - infinit nein kA kA";printervoll = true;
						}
					}
					
					else if(wortunbekanntpos==satzwörter.length-1){
						System.out.println("Ist das Wort ein infinites Adjektiv");
						InputStreamReader antwortreader2 = new InputStreamReader(System.in);
						BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
						String antwort2 = antwortbufferedreader2.readLine();
						
						if(antwort2.equals("ja")){
							wortschatzprinter = unbekannteswort+" Adjektiv - - - - - nominativ infinit nein kA kA";printervoll = true;
						}
					}
					
					if(wortunbekanntpos>1){
						if(satzmatrix[wortunbekanntpos-1][1].equals("Artikel")){
							System.out.println("Ist das Wort ein Substantiv?");
							InputStreamReader antwortreader = new InputStreamReader(System.in);
							BufferedReader antwortbufferedreader = new BufferedReader(antwortreader);
							String antwort = antwortbufferedreader.readLine();
							
							if(antwort.equals("ja")){
								
								if(satzmatrix[wortunbekanntpos-1][0].equals("der")){
									System.out.println("Steht das Wort im Plural?");
									InputStreamReader antwortreader2 = new InputStreamReader(System.in);
									BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
									String antwort2 = antwortbufferedreader2.readLine();
									
									if(antwort2.equals("ja")){
										System.out.println("Ist das Wort feminim, maskulim oder neutral?");
										InputStreamReader antwortreader3 = new InputStreamReader(System.in);
										BufferedReader antwortbufferedreader3 = new BufferedReader(antwortreader3);
										String antwort3 = antwortbufferedreader3.readLine();
										
										if(antwort3.equals("feminim")){wortschatzprinter = unbekannteswort+" Substantiv - plural feminim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("maskulim")){wortschatzprinter = unbekannteswort+" Substantiv - plural maskulim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("neutral")){wortschatzprinter = unbekannteswort+" Substantiv - plural neutral - - - - ja kA kA";printervoll = true;}
									}
									else if(antwort2.equals("nein")){
										System.out.println("Ist das Wort feminim, maskulim oder neutral?");
										InputStreamReader antwortreader3 = new InputStreamReader(System.in);
										BufferedReader antwortbufferedreader3 = new BufferedReader(antwortreader3);
										String antwort3 = antwortbufferedreader3.readLine();
										
										if(antwort3.equals("feminim")){wortschatzprinter = unbekannteswort+" Substantiv - singular feminim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("maskulim")){wortschatzprinter = unbekannteswort+" Substantiv - singular maskulim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("neutral")){wortschatzprinter = unbekannteswort+" Substantiv - singular neutral - - - - ja kA kA";printervoll = true;}
									}
								}
								if(satzmatrix[wortunbekanntpos-1][0].equals("die")){
									System.out.println("Steht das Wort im Plural?");
									InputStreamReader antwortreader2 = new InputStreamReader(System.in);
									BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
									String antwort2 = antwortbufferedreader2.readLine();
									
									if(antwort2.equals("ja")){
										System.out.println("Ist das Wort feminim, maskulim oder neutral?");
										InputStreamReader antwortreader3 = new InputStreamReader(System.in);
										BufferedReader antwortbufferedreader3 = new BufferedReader(antwortreader3);
										String antwort3 = antwortbufferedreader3.readLine();
										
										if(antwort3.equals("feminim")){wortschatzprinter = unbekannteswort+" Substantiv - plural feminim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("maskulim")){wortschatzprinter = unbekannteswort+" Substantiv - plural maskulim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("neutral")){wortschatzprinter = unbekannteswort+" Substantiv - plural neutral - - - - ja kA kA";printervoll = true;}
									}
									else if(antwort2.equals("nein")){wortschatzprinter = unbekannteswort+" Substantiv - singular feminim - - - - ja kA kA";printervoll = true;}
								}
								if(satzmatrix[wortunbekanntpos-1][0].equals("das")){
									wortschatzprinter = unbekannteswort+" Substantiv - singular neutral - - - - ja kA kA";printervoll = true;
								}
								if(satzmatrix[wortunbekanntpos-1][0].equals("des")){
									System.out.println("Ist das Wort maskulim oder neutral?");
									InputStreamReader antwortreader2 = new InputStreamReader(System.in);
									BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
									String antwort2 = antwortbufferedreader2.readLine();
									
									if(antwort2.equals("maskulim")){wortschatzprinter = unbekannteswort+" Substantiv - singular maskulim - - - - ja kA kA";printervoll = true;}
									if(antwort2.equals("neutral")){wortschatzprinter = unbekannteswort+" Substantiv - singular neutral - - - - ja kA kA";printervoll = true;}
								}
								if(satzmatrix[wortunbekanntpos-1][0].equals("dem")){
									System.out.println("Ist das Wort maskulim oder neutral?");
									InputStreamReader antwortreader2 = new InputStreamReader(System.in);
									BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
									String antwort2 = antwortbufferedreader2.readLine();
									
									if(antwort2.equals("maskulim")){wortschatzprinter = unbekannteswort+" Substantiv - singular maskulim - - - - ja kA kA";printervoll = true;}
									if(antwort2.equals("neutral")){wortschatzprinter = unbekannteswort+" Substantiv - singular neutral - - - - ja kA kA";printervoll = true;}
								}
								if(satzmatrix[wortunbekanntpos-1][0].equals("den")){
									System.out.println("Steht das Wort im Plural?");
									InputStreamReader antwortreader2 = new InputStreamReader(System.in);
									BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
									String antwort2 = antwortbufferedreader2.readLine();
									
									if(antwort2.equals("ja")){
										System.out.println("Ist das Wort feminim, maskulim oder neutral?");
										InputStreamReader antwortreader3 = new InputStreamReader(System.in);
										BufferedReader antwortbufferedreader3 = new BufferedReader(antwortreader3);
										String antwort3 = antwortbufferedreader3.readLine();
										
										if(antwort3.equals("feminim")){wortschatzprinter = unbekannteswort+" Substantiv - plural feminim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("maskulim")){wortschatzprinter = unbekannteswort+" Substantiv - plural maskulim - - - - ja kA kA";printervoll = true;}
										if(antwort3.equals("neutral")){wortschatzprinter = unbekannteswort+" Substantiv - plural neutral - - - - ja kA kA";printervoll = true;}
									}
									else if(antwort2.equals("nein")){wortschatzprinter = unbekannteswort+" Substantiv - singular maskulim - - - - ja kA kA";printervoll = true;}
								}
								if(satzmatrix[wortunbekanntpos-1][0].equals("einen")||satzmatrix[wortunbekanntpos-1][0].equals("kinen")){wortschatzprinter = unbekannteswort+" Substantiv - singular maskulim - - - - ja kA kA";printervoll = true;}
								if(satzmatrix[wortunbekanntpos-1][0].equals("eine")||satzmatrix[wortunbekanntpos-1][0].equals("einer")||satzmatrix[wortunbekanntpos-1][0].equals("keine")||satzmatrix[wortunbekanntpos-1][0].equals("keiner")){wortschatzprinter = unbekannteswort+" Substantiv - singular feminim - - - - ja kA kA";printervoll = true;}
								if(satzmatrix[wortunbekanntpos-1][0].equals("ein")||satzmatrix[wortunbekanntpos-1][0].equals("einem")||satzmatrix[wortunbekanntpos-1][0].equals("eines")||satzmatrix[wortunbekanntpos-1][0].equals("kein")||satzmatrix[wortunbekanntpos-1][0].equals("keinem")||satzmatrix[wortunbekanntpos-1][0].equals("keines")){
									
									System.out.println("Ist das Wort maskulim oder neutral?");
									InputStreamReader antwortreader3 = new InputStreamReader(System.in);
									BufferedReader antwortbufferedreader3 = new BufferedReader(antwortreader3);
									String antwort3 = antwortbufferedreader3.readLine();
									
									if(antwort3.equals("neutral")){wortschatzprinter = unbekannteswort+" Substantiv - singular neutral - - - - ja kA kA";printervoll = true;}
									if(antwort3.equals("maskulim")){wortschatzprinter = unbekannteswort+" Substantiv - singular maskulim - - - - ja kA kA";printervoll = true;}
									
								}
							}else if(antwort.equals("nein")){System.out.println("Ist das Wort ein Adjektiv");
							InputStreamReader antwortreader2 = new InputStreamReader(System.in);
							BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
							String antwort2 = antwortbufferedreader2.readLine();
							
								if(antwort2.equals("ja")){
									wortschatzprinter = unbekannteswort+" Adjektiv - - - - - nominativ infinit nein kA kA";printervoll = true;
								}
							}
						}
					}
				
					
				if(printervoll == true){System.out.println("Ich habe ein neues Wort gelernt.");	
					
					try {BufferedWriter in = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( "Wortschatz.txt", true)));
						
					try {in.newLine();
							in.write(wortschatzprinter);
							in.close();} 
					catch (IOException e) {e.printStackTrace();}
					} catch (FileNotFoundException e1) {e1.printStackTrace();}
					
					z = 1;
					try {FileReader f0 = new FileReader("Wortschatz.txt");
				        BufferedReader f = new BufferedReader(f0);
				        String line;
				        
				        while ((line = f.readLine()) != null) {wort[z]=line;z++;}
				    }
				    catch (FileNotFoundException e2) {e2.printStackTrace();}
				    catch (IOException e1) {e1.printStackTrace();}
					}
				}
			}
		}
	}
}
