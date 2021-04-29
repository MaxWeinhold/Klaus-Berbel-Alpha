import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Vorstellung2 {
	
	static String vorname ="";
	static String nachname ="";
	static String geschlecht ="";
	static String herkunftsland ="";
	static String vater ="";
	static String[] namen = new String[99999];
	static String[] wort = new String[9999999];
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Hallo! Ich bin Klaus B�rbel.");
		System.out.println("Wie lautet dein Vorname?");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String eingabe1 = br.readLine();
		vorname = eingabe1;int namensz�hler = 0;
		
		try {FileReader f0 = new FileReader("Namensliste.txt");
	        BufferedReader f = new BufferedReader(f0);
	        String line;
	        int z = 1;
	        
	        while ((line = f.readLine()) != null) {
	        		namen[z]=line;
	        		String[] person = namen[z].split("\\s");
	        		
	        		if(person[0].equals(vorname)){
	    				namensz�hler++;
	    				nachname = person[1];
	    				
	    				if(person[2].equals("ja")||person[2].equals("Ja")){geschlecht = "weiblich";}
	    				if(person[2].equals("nein")||person[2].equals("Nein")){geschlecht = "m�nnlich";}
	    				
	    				herkunftsland = person[3];
	    				vater = person[8];
	    				
	    				if(namensz�hler>1){
	    				
	    					System.out.println("Und wie lautet dein Nachname?");
	    				
		    				InputStreamReader isr2 = new InputStreamReader(System.in);
		    				BufferedReader br2 = new BufferedReader(isr2);
		    				String eingabe2 = br.readLine();
		    				nachname = eingabe2;int namensz�hler2 = 0;
	    					
	    					if(person[0].equals(vorname)&&person[1].equals(nachname)){
	    						namensz�hler++;
	    	    				geschlecht = person[2];
	    	    				herkunftsland = person[3];
	    	    				vater = person[8];
	    	    				
	    	    				if(vater.equals("ja")){System.out.println("Ich freue mich dir zu schreiben Vater.");}
	    	    				else{System.out.println("Ich kenne dich "+vorname+" "+nachname);}
	    	    				Klaus_Berbel();
	    					}
	    					else{namensz�hler=0;}
	    				}
	    			}
	        		
	        		z++;
	        }
	    }
	    catch (FileNotFoundException e2) {e2.printStackTrace();}
	    catch (IOException e1) {e1.printStackTrace();}
		
		if(namensz�hler == 1){
			
			System.out.println("Lautet dein Name "+vorname+" "+nachname+"?");
			InputStreamReader isr2 = new InputStreamReader(System.in);
			BufferedReader br2 = new BufferedReader(isr2);
			String eingabe2 = br.readLine();
			
			if(eingabe2.equals("nein")){namensz�hler = 0;}
			else{
				
				if(vater.equals("ja")){System.out.println("Ich freue mich dir zu schreiben Vater.");}
				else{System.out.println("Ich kenne dich "+vorname+" "+nachname);}
				Klaus_Berbel();
				
			}
		}
		if(namensz�hler == 0){
			System.out.println("Und wie lautet dein Nachname?");
			
			InputStreamReader isr2 = new InputStreamReader(System.in);
			BufferedReader br2 = new BufferedReader(isr2);
			String eingabe2 = br.readLine();
			nachname = eingabe2;int namensz�hler2 = 0;
			
			System.out.println("Bist du weiblich "+vorname+"?");
			
			InputStreamReader isr3 = new InputStreamReader(System.in);
			BufferedReader br3 = new BufferedReader(isr3);
			String eingabe3 = br.readLine();
			geschlecht = eingabe3;int namensz�hler3 = 0;
			
			if(geschlecht.equals("ja")||geschlecht.equals("Ja")){geschlecht = "weiblich";}
			if(geschlecht.equals("nein")||geschlecht.equals("Nein")){geschlecht = "m�nnlich";}
			
			System.out.println("Aus welcher Stadt kommst du?");
			
			InputStreamReader isr4 = new InputStreamReader(System.in);
			BufferedReader br4 = new BufferedReader(isr4);
			String eingabe4 = br.readLine();
			herkunftsland = eingabe4;int namensz�hler4 = 0;
			
			try {BufferedWriter in = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( "Namensliste.txt", true)));
			
			try {in.newLine();
				in.write(vorname+" "+nachname+" "+geschlecht+" "+herkunftsland+" - - - - nein");
				in.close();} 
			catch (IOException e) {e.printStackTrace();}
			} 
			catch (FileNotFoundException e1) {e1.printStackTrace();}
			
			try {BufferedWriter in = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( vorname+"_"+nachname+".txt", true)));
			
			try {in.newLine();
				in.write("was ist mein Vorame : "+vorname);
				in.newLine();
				in.write("ist mein Vorname "+vorname+" : Ja");
				in.newLine();
				in.write("ist mein Vorname nicht "+vorname+" : Nein");
				in.newLine();
				in.write("lautet mein Vorname "+vorname+" : Ja");
				in.newLine();
				in.write("lautet mein Vorname nicht "+vorname+" : Nein");
				in.newLine();
				in.write("was ist mein Nachname : "+nachname);
				in.newLine();
				in.write("ist mein Nachname "+nachname+" : Ja");
				in.newLine();
				in.write("ist mein Nachname nicht "+nachname+" : Nein");
				in.newLine();
				in.write("lautet mein Nachname "+nachname+" : Ja");
				in.newLine();
				in.write("lautet mein Nachname nicht "+nachname+" : Nein");
				in.newLine();
				in.write("was ist mein Name : "+vorname+" "+nachname);
				in.newLine();
				in.write("ist mein Name "+vorname+" "+nachname+" : Ja");
				in.newLine();
				in.write("ist mein Name nicht "+vorname+" "+nachname+" : Nein");
				in.newLine();
				in.write("lautet mein Name "+vorname+" "+nachname+" : Ja");
				in.newLine();
				in.write("lautet mein Name nicht "+vorname+" "+nachname+" : Nein");
				in.newLine();
				in.write("kommt "+vorname+" aus "+herkunftsland+" : Ja");
				in.newLine();
				in.write("kommt "+vorname+" nicht aus "+herkunftsland+" : Nein");
				in.newLine();
				in.write("kommt "+vorname+" "+nachname+" aus "+herkunftsland+" : Ja");
				in.newLine();
				in.write("kommt "+vorname+" "+nachname+" nicht aus "+herkunftsland+" : Nein");
				in.newLine();
				in.write("komme ich aus "+herkunftsland+" : Ja");
				in.newLine();
				in.write("komme ich nicht aus "+herkunftsland+" : Nein");
				in.newLine();
				in.write("bin ich "+geschlecht+" : Ja");
				in.newLine();
				in.write("bin ich nicht "+geschlecht+" : Nein");
				in.newLine();
				in.write("ist "+vorname+" "+geschlecht+" : Ja");
				in.newLine();
				in.write("ist "+vorname+" nicht "+geschlecht+" : Nein");
				in.newLine();
				in.write("ist "+vorname+" "+nachname+" "+geschlecht+" : Ja");
				in.newLine();
				in.write("ist "+vorname+" "+nachname+" nicht "+geschlecht+" : Nein");
				in.newLine();
				String gegengeschlecht="";
				if(geschlecht.equals("weiblich")){gegengeschlecht="m�nnlich";}
				if(geschlecht.equals("m�nnlich")){gegengeschlecht="weiblich";}
				in.write("bin ich "+gegengeschlecht+" : Nein");
				in.newLine();
				in.write("bin ich nicht "+gegengeschlecht+" : Ja");
				in.newLine();
				in.write("ist "+vorname+" "+gegengeschlecht+" : Nein");
				in.newLine();
				in.write("ist "+vorname+" nicht "+gegengeschlecht+" : Ja");
				in.newLine();
				in.write("ist "+vorname+" "+nachname+" "+gegengeschlecht+" : Nein");
				in.newLine();
				in.write("ist "+vorname+" "+nachname+" nicht "+gegengeschlecht+": Ja");
				in.newLine();
				in.write("was bin ich : "+geschlecht);
				in.newLine();
				in.write("was bin ich nicht : "+gegengeschlecht);
				in.newLine();
				in.close();
			} 
			catch (IOException e) {e.printStackTrace();}
			} 
			catch (FileNotFoundException e1) {e1.printStackTrace();}
			Klaus_Berbel();
		}
	}


	private static void Klaus_Berbel() throws IOException {
		// TODO Auto-generated method stub
		
		// Wortschatz wird an internen Vektor �bergeben
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
				
			    System.out.println("Erz�hle mir etwas!");
			    
				for(int i=0;i>-1;i++){
					
					boolean hsobjfound = false;
					boolean ns1objfound = false;
					boolean ns2objfound = false;
					boolean aussageneu = false;
					int pr�dikatbekannt = -1;
					int wortbekannt = 0;
					int wortbekannt2 = 0;
					int wortunbekanntpos = 0;
					String unbekannteswort = "";
					
					// Zeile wird ausgelesen gesplitted und einzelne W�rter an Vektor satzw�rter �bergeben
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader bbr = new BufferedReader(isr);
					String eingabe = bbr.readLine();
					
					String[] satzw�rter = eingabe.split("\\s");

					String[][] satzmatrix = new String[satzw�rter.length][12];
					
					for (int a=0; a<satzw�rter.length; a++){
						for (int b=1; b<z; b++){
							// Zeilen des Wortschatzes werden gesplitted
							String[] wortw�rter = wort[b].split("\\s");
							//System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][1]+" "+satzmatrix[a][2]+" "+satzmatrix[a][3]+" "+satzmatrix[a][4]+" "+satzmatrix[a][5]+" "+satzmatrix[a][6]+" "+satzmatrix[a][7]+" "+satzmatrix[a][8]+" "+satzmatrix[a][9]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);
							
							// Suche nach �bereinstimmung im Wortschatz
							if (wortw�rter[0].equals(satzw�rter[a])) {
								
								wortbekannt++;
								//System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][1]+" "+satzmatrix[a][2]+" "+satzmatrix[a][3]+" "+satzmatrix[a][4]+" "+satzmatrix[a][5]+" "+satzmatrix[a][6]+" "+satzmatrix[a][7]+" "+satzmatrix[a][8]+" "+satzmatrix[a][9]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);
								// Satzmatrix wird ausgef�llt
								for (int c=0; c<12; c++){
									satzmatrix[a][c]=wortw�rter[c];
								}
								
								if(satzmatrix[a][1].equals("Verb")&&satzmatrix[a][8].equals("finit")){
									// infinite Verben stellen ein Pr�dikat da
									satzmatrix[a][10]="Pr�dikat";
									pr�dikatbekannt = a;}
								if(satzmatrix[a][1].equals("Adverb")&&satzmatrix[a-1][1].equals("verb")&& a>1){
									satzmatrix[a][10]="Pr�dikat";
									satzmatrix[a-1][10]="Pr�dikat";
									pr�dikatbekannt = a;
								}
							}
						}
						
						if(wortbekannt2 == wortbekannt){
							unbekannteswort = satzw�rter[a];
							//System.out.println(unbekannteswort);
							wortunbekanntpos = a;
							
						}
						
						wortbekannt2 = wortbekannt;
						
					}
					
					boolean ichpro = false;
					String satz = "";
					String satz1="";
					String nullsatz = "";
					if(wortbekannt == satzw�rter.length){
					
						//for (int a=0; a<satzw�rter.length; a++){System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][1]+" "+satzmatrix[a][2]+" "+satzmatrix[a][3]+" "+satzmatrix[a][4]+" "+satzmatrix[a][5]+" "+satzmatrix[a][6]+" "+satzmatrix[a][7]+" "+satzmatrix[a][8]+" "+satzmatrix[a][9]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);}
						if(satzmatrix[0][10].equals("Pr�dikat")||satzmatrix[0][1].equals("Fragewort")||(satzmatrix[1][1].equals("Fragewort")&&satzmatrix[0][1].equals("Pr�position"))){
							// Hier kommt die Frage hin
							
							// Satz wird aufaddiert zum Abgleich mit den Antworten
							for (int a=0; a<satzw�rter.length; a++){
								//System.out.println(satzmatrix[a][0]+","+satzmatrix[a][1]+","+satzmatrix[a][2]);
								nullsatz = satz1;
								satz1 = nullsatz+satzmatrix[a][0]+" ";
								satz = satz1; 
								
								if(satzmatrix[a][0].equals("ich")){ichpro = true;}
							}	
							
							// Sucht nach Antworten
							int z�hler = 1;String[] fragen = new String[9999999];
							boolean antwortgefunden = false;
							
							try {FileReader f1 = new FileReader("Antworten.txt");
								if(ichpro == true){f1 = new FileReader(vorname+"_"+nachname+".txt");}
								else{f1 = new FileReader("Antworten.txt");}
						        
						        BufferedReader ff1 = new BufferedReader(f1);
						        String line;
						        
				
						        while ((line = ff1.readLine()) != null) {
				
						        	String frage1 = "";String frage2 = "";
						        	String antwort1 = "";String antwort2 = "";
						        	fragen[z�hler]=line;
						        	z�hler++;
						        	
						        	int trennpos = 0;
						        	String[] fragew�rter = line.split("\\s");
						        	
						        	for(int b =0; b<fragew�rter.length;b++){
						        		if(fragew�rter[b].equals(":")){trennpos = b;}
						        	}
						        	for(int c =0; c<trennpos;c++){
						        		frage1 = frage2+" "+fragew�rter[c];
						        		frage2 = frage1;
						        		//frage1 = frage2;System.out.println(frage1);
						        	}
						        	frage2=frage1+" ";
						        	for(int c =trennpos+1; c<fragew�rter.length;c++){
						        		antwort1 = antwort2+fragew�rter[c]+" ";
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
								
								if(satzmatrix[0][10].equals("Pr�dikat")){
									satz = "";
									satz1="";
									nullsatz = "";
									for (int a=0; a<satzw�rter.length; a++){
										//System.out.println(satzmatrix[a][0]+","+satzmatrix[a][1]+","+satzmatrix[a][2]);
										nullsatz = satz1;
										if(satzmatrix[a][0].equals("nicht")){}
										else {satz1 = nullsatz+satzmatrix[a][0]+" ";}
										satz = satz1; 
										//System.out.println(satz);
									}
									
									try {FileReader f1 = new FileReader("Antworten.txt");
									if(ichpro == true){f1 = new FileReader(vorname+"_"+nachname+".txt");}
									else{f1 = new FileReader("Antworten.txt");}
								        BufferedReader ff1 = new BufferedReader(f1);
								        String line;
								        
						
								        while ((line = ff1.readLine()) != null) {
						
								        	String frage1 = "";String frage2 = "";
								        	fragen[z�hler]=line;
								        	z�hler++;
								        	
								        	int trennpos = 0;
								        	String[] fragew�rter = line.split("\\s");
								        	
								        	for(int b =0; b<fragew�rter.length;b++){
								        		if(fragew�rter[b].equals(":")){trennpos = b;}
								        	}
								        	for(int c =0; c<trennpos;c++){
								        		frage1 = frage2+" "+fragew�rter[c];
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
							
							if(antwortgefunden == false){// Suche nach verneinten Aussagen
								
								if(satzmatrix[0][10].equals("Pr�dikat")){// nur Booleanfragen
									
									satz = "";
									satz1="";
									nullsatz = "";
									for (int a=0; a<satzw�rter.length; a++){
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
									
									try {FileReader f1 = new FileReader("Antworten.txt");
									if(ichpro == true){f1 = new FileReader(vorname+"_"+nachname+".txt");}
									else{f1 = new FileReader("Antworten.txt");}
								        BufferedReader ff1 = new BufferedReader(f1);
								        String line;
								        
						
								        while ((line = ff1.readLine()) != null) {
						
								        	String frage1 = "";String frage2 = "";
								        	fragen[z�hler]=line;
								        	z�hler++;
								        	
								        	int trennpos = 0;
								        	String[] fragew�rter = line.split("\\s");
								        	
								        	for(int b =0; b<fragew�rter.length;b++){
								        		if(fragew�rter[b].equals(":")){trennpos = b;}
								        	}
								        	for(int c =0; c<trennpos;c++){
								        		frage1 = frage2+" "+fragew�rter[c];
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
							
							if(antwortgefunden == false){
								//System.out.println("Das kann ich leider nicht beantworten.");
								
								String[] dateiname = new String[999999];
								String[] aktname = new String[999999];
						        int z3 = 1;
						        
								try {FileReader f0 = new FileReader("Namensliste.txt");
						        BufferedReader f = new BufferedReader(f0);
						        String line;
						        
						        while ((line = f.readLine()) != null) {
						        		namen[z3]=line;
						        		String[] person = namen[z3].split("\\s");
						        		
						        		dateiname[z3] = person[0]+"_"+person[1];
						        		aktname[z3] = person[0];
						        		
						        		z3++;
						        	}
								}
								catch (FileNotFoundException e2) {e2.printStackTrace();}
							    catch (IOException e1) {e1.printStackTrace();}
								
								for(int y = 1; y < z3 ;y++){
									
									// Sucht nach Antworten

									z�hler = 1;fragen = new String[999999];
									
									
									try {FileReader f1 = new FileReader(dateiname[y]+".txt");
										if(ichpro == true){f1 = new FileReader(vorname+"_"+nachname+".txt");}
										else{f1 = new FileReader(dateiname[y]+".txt");}
								        
								        BufferedReader ff1 = new BufferedReader(f1);
								        String line;
								        
						
								        while ((line = ff1.readLine()) != null) {
						
								        	String frage1 = "";String frage2 = "";
								        	String antwort1 = "";String antwort2 = "";
								        	fragen[z�hler]=line;
								        	z�hler++;
								        	
								        	int trennpos = 0;
								        	String[] fragew�rter = line.split("\\s");
								        	
								        	for(int b =0; b<fragew�rter.length;b++){
								        		if(fragew�rter[b].equals(":")){trennpos = b;}
								        	}
								        	for(int c =0; c<trennpos;c++){
								        		frage1 = frage2+" "+fragew�rter[c];
								        		frage2 = frage1;
								        		//frage1 = frage2;System.out.println(frage1);
								        	}
								        	frage2=frage1+" ";
								        	for(int c =trennpos+1; c<fragew�rter.length;c++){
								        		antwort1 = antwort2+fragew�rter[c]+" ";
								        		antwort2 = antwort1;
								        		if(antwort1.equals(vorname+" "+nachname+" ")){antwort2 = "Du";}
								        	}
								        	
								        	if(frage2.equals(" "+satz)||frage2.equals("  "+satz)){System.out.println(aktname[y]+" meint "+antwort2);antwortgefunden = true;}
								        	
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
										
										if(satzmatrix[0][10].equals("Pr�dikat")){
											satz = "";
											satz1="";
											nullsatz = "";
											for (int a=0; a<satzw�rter.length; a++){
												//System.out.println(satzmatrix[a][0]+","+satzmatrix[a][1]+","+satzmatrix[a][2]);
												nullsatz = satz1;
												if(satzmatrix[a][0].equals("nicht")){}
												else {satz1 = nullsatz+satzmatrix[a][0]+" ";}
												satz = satz1; 
												//System.out.println(satz);
											}
											
											try {FileReader f1 = new FileReader(dateiname[y]+".txt");
											if(ichpro == true){f1 = new FileReader(vorname+"_"+nachname+".txt");}
											else{f1 = new FileReader(dateiname[y]+".txt");}
										        BufferedReader ff1 = new BufferedReader(f1);
										        String line;
										        
								
										        while ((line = ff1.readLine()) != null) {
								
										        	String frage1 = "";String frage2 = "";
										        	fragen[z�hler]=line;
										        	z�hler++;
										        	
										        	int trennpos = 0;
										        	String[] fragew�rter = line.split("\\s");
										        	
										        	for(int b =0; b<fragew�rter.length;b++){
										        		if(fragew�rter[b].equals(":")){trennpos = b;}
										        	}
										        	for(int c =0; c<trennpos;c++){
										        		frage1 = frage2+" "+fragew�rter[c];
										        		frage2 = frage1;
										        		//frage1 = frage2;System.out.println(frage1);
										        	}
										        	frage2=frage1+" ";
										        	
										        	
										        	if(frage2.equals(" "+satz)||frage2.equals("  "+satz)){System.out.println(aktname[y]+" meint nein");antwortgefunden = true;}
										        	
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
									
									if(antwortgefunden == false){// Suche nach verneinten Aussagen
										
										if(satzmatrix[0][10].equals("Pr�dikat")){// nur Booleanfragen
											
											satz = "";
											satz1="";
											nullsatz = "";
											for (int a=0; a<satzw�rter.length; a++){
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
											
											try {FileReader f1 = new FileReader(dateiname[y]+".txt");
											if(ichpro == true){f1 = new FileReader(vorname+"_"+nachname+".txt");}
											else{f1 = new FileReader(dateiname[y]+".txt");}
										        BufferedReader ff1 = new BufferedReader(f1);
										        String line;
										        
								
										        while ((line = ff1.readLine()) != null) {
								
										        	String frage1 = "";String frage2 = "";
										        	fragen[z�hler]=line;
										        	z�hler++;
										        	
										        	int trennpos = 0;
										        	String[] fragew�rter = line.split("\\s");
										        	
										        	for(int b =0; b<fragew�rter.length;b++){
										        		if(fragew�rter[b].equals(":")){trennpos = b;}
										        	}
										        	for(int c =0; c<trennpos;c++){
										        		frage1 = frage2+" "+fragew�rter[c];
										        		frage2 = frage1;
										        		//frage1 = frage2;System.out.println(frage1);
										        	}
										        	frage2=frage1+" ";
										        	
										        	
										        	if(frage2.equals(" "+satz)||frage2.equals("  "+satz)){System.out.println(aktname[y]+" meint nein");antwortgefunden = true;}
										        	
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
								}
								
								if(antwortgefunden == false){
									System.out.println("Das kann ich leider nicht beantworten.");
								}
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
							}
						}
						//else if(satzmatrix[0][1].equals("Fragewort")){
							// So werden weitere Fragen eingeleitet
						//}
						else{
							// Hier beginnt die Aussage Analyse
							// N�chster Schritt ist die Satzteilung
							
							int verbz�hler = 0, nebes�tze =0, haupts�tze = 1;
							//String hsausgabe = "Hauptsatz"+haupts�tze;
							boolean hauptsatz = true;
							for (int a=0; a<satzw�rter.length; a++){
								if(satzmatrix[a][1].equals("Konjunktion")){hauptsatz = false;nebes�tze++;}
								if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){
									if(satzmatrix[a][0].equals("der")||satzmatrix[a][0].equals("die")||satzmatrix[a][0].equals("der")){hauptsatz = false;nebes�tze++;}
								}
								if (satzmatrix[a][10].equals("Pr�dikat")&&satzmatrix[a-1][10].equals("Pr�dikat")&&a>1){hauptsatz = true;}
								
								//int hsverbz�hler = 0;
								if(hauptsatz == true){
									satzmatrix[a][11]="Hauptsatz";
								}
								else{satzmatrix[a][11]="Nebensatz"+nebes�tze;}
							}
							
							// N�chster Schritt ist die Einteilung der Satzteile in Satzglieder
							
							String ersterSatzteil = satzmatrix[0][11];
							int satzgliedz�hler = 1;
							int satzgliedz�hler1 = 1;
							int satzgliedz�hler2 = 1;
							//String Satzglied = "Satzglied"+satzgliedz�hler;
							
							for (int a=0; a<satzw�rter.length; a++){
								if(satzmatrix[a][11].equals(ersterSatzteil)){ // Satzgliederteilung im ersten Teilsatz
									if(ersterSatzteil.equals("Hauptsatz")){
										if(satzmatrix[a][10].equals("Pr�dikat")){satzgliedz�hler++;}
										else{satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler;}
									}
									else if(ersterSatzteil.equals("Nebensatz1")){
										//Satzgliedteilung bei Nebens�tzen
										if(satzmatrix[a][10].equals("Pr�dikat")){satzgliedz�hler++;}
										else{
											if(satzmatrix[a][1].equals("Konjunktion")){
												satzmatrix[a][10] ="Konjunktion";
											}
											else if(satzmatrix[a][1].equals("Pronomen")){
												satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler;
												satzgliedz�hler++;
											}
											else if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){satzgliedz�hler++;
												// Nach einem Substantiv folgt kein Wort mehr, dass zu dessen Satzglied dazu geh�rt
												satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler;
											}
											else{
												satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler;
											}
										}
									}
								}
								else{
									String zweiterSatzteil = satzmatrix[a][11];
									if(satzmatrix[a][11].equals(zweiterSatzteil)){ // Satzgliederteilung im zweiten Teilsatz
										if(zweiterSatzteil.equals("Hauptsatz")){
											if(satzmatrix[a][10].equals("Pr�dikat")){satzgliedz�hler1++;}
											else{satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler1;}
										}
										else{
											//Satzgliedteilung bei Nebens�tzen
											// Fall Bestimmung von Einschiebungen ab zweitem Nebensatz      if(satzmatrix[a-1][11].equals("Hauptsatz")&&satzmatrix[a][0].equals("die")){}
											if(satzmatrix[a][10].equals("Pr�dikat")){if(zweiterSatzteil.equals("Nebensatz1")){satzgliedz�hler1++;}
											if(zweiterSatzteil.equals("Nebensatz2")){satzgliedz�hler2++;}}
											else{
												if(satzmatrix[a][1].equals("Konjunktion")){
													satzmatrix[a][10] ="Konjunktion";
												}
												else if(satzmatrix[a][1].equals("Pronomen")){
													if(zweiterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler1;}
													if(zweiterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler2;}
													
													if(zweiterSatzteil.equals("Nebensatz1")){satzgliedz�hler1++;}
													if(zweiterSatzteil.equals("Nebensatz2")){satzgliedz�hler2++;}
												}
												else if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){if(zweiterSatzteil.equals("Nebensatz1")){satzgliedz�hler1++;}
												if(zweiterSatzteil.equals("Nebensatz2")){satzgliedz�hler2++;}
													// Nach einem Substantiv folgt kein Wort mehr, dass zu dessen Satzglied dazu geh�rt
												if(zweiterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler1;}
												if(zweiterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler2;}
												}
												else{
													if(zweiterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler1;}
													if(zweiterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler2;}
												}
											}
										}
									}
									else{
										String dritterSatzteil = satzmatrix[a][11];
										if(satzmatrix[a][11].equals(dritterSatzteil)){ // Satzgliederteilung im dritten Teilsatz
											if(dritterSatzteil.equals("Hauptsatz")){
												if(satzmatrix[a][10].equals("Pr�dikat")){satzgliedz�hler2++;}
												else{satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler2;}
											}
											else{
												//Satzgliedteilung bei Nebens�tzen
												// Fall Bestimmung von Einschiebungen ab zweitem Nebensatz      if(satzmatrix[a-1][11].equals("Hauptsatz")&&satzmatrix[a][0].equals("die")){}
												if(satzmatrix[a][10].equals("Pr�dikat")){if(dritterSatzteil.equals("Nebensatz1")){satzgliedz�hler1++;}
												if(dritterSatzteil.equals("Nebensatz2")){satzgliedz�hler2++;}}
												else{
													if(satzmatrix[a][1].equals("Konjunktion")){
														satzmatrix[a][10] ="Konjunktion";
													}
													else if(satzmatrix[a][1].equals("Pronomen")){
														if(dritterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler1;}
														if(dritterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler2;}
														
														if(dritterSatzteil.equals("Nebensatz1")){satzgliedz�hler1++;}
														if(dritterSatzteil.equals("Nebensatz2")){satzgliedz�hler2++;}
													}
													else if(a>1&&satzmatrix[a-1][1].equals("Substantiv")){if(dritterSatzteil.equals("Nebensatz1")){satzgliedz�hler1++;}
													if(dritterSatzteil.equals("Nebensatz2")){satzgliedz�hler2++;}
														// Nach einem Substantiv folgt kein Wort mehr, dass zu dessen Satzglied dazu geh�rt
													if(dritterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler1;}
													if(dritterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler2;}
													}
													else{
														if(dritterSatzteil.equals("Nebensatz1")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler1;}
														if(dritterSatzteil.equals("Nebensatz2")){satzmatrix[a][10] ="Teilsatzglied"+satzgliedz�hler2;}
													}
												}
											}
										}
									}
								}
							}
							
							boolean objektgefunden = false;
							String[] pr�positionalVektor = new String[3];
							String[] KasusVektor = new String[3];
							for (int a=0; a<satzw�rter.length; a++){
								// N�chster Schritte die unbestimmten Satzglieder als Objekte oder Subjekte einzuordnen
								if(a>0&&satzmatrix[a-1][1].equals("Artikel")){}
								else{
									if(satzmatrix[a][1].equals("Adjektiv")){ // alleinstehende Adjektive sind Objekte
										satzmatrix[a][10]="Objekt";objektgefunden = true;
										if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
										if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										for (int b=0; b<satzw�rter.length; b++){ // �brig bleibendes Satzglied wird zum Subjekt
											if(satzmatrix[b][11].equals(satzmatrix[a][11])){
												if(satzmatrix[b][10].equals("Objekt")||satzmatrix[b][10].equals("Pr�dikat")||satzmatrix[b][10].equals("Konjunktion")){}
												else{satzmatrix[b][10]="Subjekt";}
											}
										}
									}
								}
							}
							
							int pr�poz�hler=0;
							for (int a=0; a<satzw�rter.length; a++){
								if(satzmatrix[a][1].equals("Pr�position")){ // Verschiedene Pr�position ziehen verschiedene F�lle nach sich: siehe Wikipedia
									if(satzmatrix[a][7].equals("akkusativ")){pr�positionalVektor[0]=satzmatrix[a][10];pr�positionalVektor[1]=satzmatrix[a][11];pr�positionalVektor[2]="akkusativ";}
									if(satzmatrix[a][7].equals("dativ")){pr�positionalVektor[0]=satzmatrix[a][10];pr�positionalVektor[1]=satzmatrix[a][11];pr�positionalVektor[2]="dativ";}
									if(satzmatrix[a][7].equals("genetiv")){pr�positionalVektor[0]=satzmatrix[a][10];pr�positionalVektor[1]=satzmatrix[a][11];pr�positionalVektor[2]="genetiv";}
									if(satzmatrix[a][7].equals("datakk")){pr�positionalVektor[0]=satzmatrix[a][10];pr�positionalVektor[1]=satzmatrix[a][11];pr�positionalVektor[2]="datakk";}
									satzmatrix[a][10]="Objekt";objektgefunden = true;
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
								}
								if(satzmatrix[a][10].equals(pr�positionalVektor[0])&&satzmatrix[a][11].equals(pr�positionalVektor[1])){
									satzmatrix[a][10]="Objekt";satzmatrix[a][7]=pr�positionalVektor[2];objektgefunden = true;
									if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
									if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
									pr�poz�hler = a;
								}
							}
							
							// Artikelkombinationen zur Fallbestimmung
							for (int a=0; a<satzw�rter.length; a++){
								if(satzmatrix[a][1].equals("Substantiv")||satzmatrix[a][1].equals("Adjektiv")){
									
									if(a>0){
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("der")){
											if(satzmatrix[a][4].equals("feminim")){
												satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
												
												if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
												satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";}
												else{
													satzmatrix[a][7]="gendat";satzmatrix[a-1][7]="gendat";
													satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";
													if(a>2){
														if(satzmatrix[a-2][1].equals("Pr�position")){satzmatrix[a-2][7]="gendat";}
													}
												}
												
											}
											if(satzmatrix[a][3].equals("singular")&&satzmatrix[a][4].equals("maskulim")){
												satzmatrix[a][10]="Subjekt";satzmatrix[a-1][10]="Subjekt";
												
											}
											if(satzmatrix[a][3].equals("plural")&&satzmatrix[a][4].equals("maskulim")){
												satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
												satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
												satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";
												
											}
											if(satzmatrix[a][4].equals("neutral")){
												satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
												satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
												satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";
											}
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("des")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";//objektgefunden = true;
											satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("dem")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
											satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";
											if(a>2){
												if(satzmatrix[a-2][1].equals("Pr�position")){satzmatrix[a-2][7]="dativ";}
											}
											if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("den")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
											if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";
											if(a>2){
												if(satzmatrix[a-2][1].equals("Pr�position")){satzmatrix[a-2][7]="dativ";}
											}}
											else{satzmatrix[a][7]="akkusativ";satzmatrix[a-1][7]="akkusativ";
											if(a>2){
												if(satzmatrix[a-2][1].equals("Pr�position")){satzmatrix[a-2][7]="akkusativ";}
											}}
											if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("eines")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
											satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("einem")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";objektgefunden = true;
											satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";
											if(a>2){
												if(satzmatrix[a-2][1].equals("Pr�position")){satzmatrix[a-2][7]="dativ";}
											}
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
												
												if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
												satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";satzmatrix[a-2][11]="Hauptsatz";}
												else{
													satzmatrix[a][7]="gendat";satzmatrix[a-1][7]="gendat";satzmatrix[a-2][7]="gendat";
													satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";satzmatrix[a-2][11]="Hauptsatz";
													if(a>3){
														if(satzmatrix[a-3][1].equals("Pr�position")){satzmatrix[a-2][7]="gendat";}
													}
												}
												
											}
											if(satzmatrix[a][3].equals("singular")&&satzmatrix[a][4].equals("maskulim")){
												satzmatrix[a][10]="Subjekt";satzmatrix[a-1][10]="Subjekt";satzmatrix[a-2][10]="Subjekt";
												
											}
											if(satzmatrix[a][3].equals("plural")&&satzmatrix[a][4].equals("maskulim")){
												satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
												satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
												satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";satzmatrix[a-2][11]="Hauptsatz";
											}
											if(satzmatrix[a][4].equals("neutral")){
												satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
												satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
												satzmatrix[a][11]="Hauptsatz";satzmatrix[a-1][11]="Hauptsatz";satzmatrix[a-2][11]="Hauptsatz";
											}
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("des")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
											satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("dem")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
											satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";satzmatrix[a-2][7]="dativ";
											if(a>3){
												if(satzmatrix[a-3][1].equals("Pr�position")){satzmatrix[a-2][7]="dativ";}
											}
											if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("den")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
											if(satzmatrix[a][3].equals("plural")){satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";satzmatrix[a-2][7]="dativ";
											if(a>3){
												if(satzmatrix[a-3][1].equals("Pr�position")){satzmatrix[a-2][7]="dativ";}
											}}
											else{satzmatrix[a][7]="akkusativ";satzmatrix[a-1][7]="akkusativ";satzmatrix[a-2][7]="akkusativ";
											if(a>3){
												if(satzmatrix[a-3][1].equals("Pr�position")){satzmatrix[a-2][7]="akkusativ";}
											}}
											if(satzmatrix[a][11].equals("Hauptsatz")){hsobjfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz1")){ns1objfound=true;}
											if(satzmatrix[a][11].equals("Nebensatz2")){ns2objfound=true;}
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("eines")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
											satzmatrix[a][7]="genetiv";satzmatrix[a-1][7]="genetiv";satzmatrix[a-2][7]="genetiv";
										}
										if(satzmatrix[a][1].equals("Substantiv")&&satzmatrix[a-1][0].equals("Adjektiv")&&satzmatrix[a-2][0].equals("einem")){
											satzmatrix[a][10]="Objekt";satzmatrix[a-1][10]="Objekt";satzmatrix[a-2][10]="Objekt";objektgefunden = true;
											satzmatrix[a][7]="dativ";satzmatrix[a-1][7]="dativ";satzmatrix[a-2][7]="dativ";
											if(a>3){
												if(satzmatrix[a-3][1].equals("Pr�position")){satzmatrix[a-2][7]="dativ";}
											}
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
							
							for (int a=0; a<satzw�rter.length; a++){
								if(satzmatrix[a][0].equals("nicht")){
									satzmatrix[a][10]="Objekt";
								}
							}
							
							// Falls Objekte nicht gefunden mache das nach dem Pr�dikat zum Objekt
							int verbstelle1 = -1;
							
							for (int a=0; a<satzw�rter.length; a++){
								if (hsobjfound==false){
									if(satzmatrix[a][10].equals("Pr�dikat")&&satzmatrix[a][11].equals("Hauptsatz")){verbstelle1 = a;}
									if(verbstelle1 != -1 && a>verbstelle1 && satzmatrix[a][11].equals("Hauptsatz")){
										if(satzmatrix[a][10].equals("Objekt")){}
										else{satzmatrix[a][10]="Objekt";satzmatrix[a][7]="akkusativ";}
					
										
									}
								}
								if (ns1objfound==false){
									if(satzmatrix[a][10].equals("Pr�dikat")&&satzmatrix[a][11].equals("Nebensatz1")){
										for (int b=0; b<satzw�rter.length; b++){
											if(a>0 && satzmatrix[b][11].equals("Nebensatz1")&& satzmatrix[b][10].equals(satzmatrix[a-1][10])){
												satzmatrix[b][10]="Objekt";satzmatrix[b][7]="akkusativ";
											}
										}
									}
								}
								if (ns2objfound==false){
									if(satzmatrix[a][10].equals("Pr�dikat")&&satzmatrix[a][11].equals("Nebensatz2")){//verbstelle3 = a;
										for (int b=0; b<satzw�rter.length; b++){
											if(a>0 && satzmatrix[b][11].equals("Nebensatz2")&& satzmatrix[b][10].equals(satzmatrix[a-1][10])){
												satzmatrix[b][10]="Objekt";satzmatrix[b][7]="akkusativ";
											}
										}
									}
								}
							}	
							
							// Daf�r m�ssen alle Objekte gefunden sein
							for (int b=0; b<satzw�rter.length; b++){ // �brig bleibendes Satzglied wird zum Subjekt
								if(satzmatrix[b][10].equals("Objekt")||satzmatrix[b][10].equals("Pr�dikat")||satzmatrix[b][10].equals("Konjunktion")){}
								else{satzmatrix[b][10]="Subjekt";}
							}
							
							// Gibt die Satzmatrix aus (einmal komplett einmal gek�rzt)
							//for (int a=0; a<satzw�rter.length; a++){System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][1]+" "+satzmatrix[a][2]+" "+satzmatrix[a][3]+" "+satzmatrix[a][4]+" "+satzmatrix[a][5]+" "+satzmatrix[a][6]+" "+satzmatrix[a][7]+" "+satzmatrix[a][8]+" "+satzmatrix[a][9]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);}
							//for (int a=0; a<satzw�rter.length; a++){System.out.println(satzmatrix[a][0]+" "+satzmatrix[a][7]+" "+satzmatrix[a][10]+" "+satzmatrix[a][11]);}
							
							// Satzanalyse ist fertig. Nun werden zu der Aussage Fragen und Antworten formuliert
							// Sp�ter werden diese Fragen und Antworten gespeichert
							// Sollte der Nutzer jemals einer dieser Fragen stellen ist Klaus B�rbel in der Lage diese zu beantworten
							
							String hspr�position = "";
							String hssubjekt = "";String hssubjekt2 = "";
							String hsobjektohneartikel = "";String hsobjekt2ohneartikel = "";
							String hsobjekt = "";String hsobjekt2 = "";
							String nichthsobjekt = "";String nichthsobjekt2 = "";boolean hsnicht = false;
							String hsobjektnom = "";String hsobjekt2nom = "";boolean hsobjektnomf = false;
							String hsobjektgen = "";String hsobjekt2gen = "";boolean hsobjektgenf = false;
							String hsobjektdat = "";String hsobjekt2dat = "";boolean hsobjektdatf = false;
							String hsobjektdatakk = "";String hsobjekt2datakk = "";boolean hsobjektdatakkf = false;
							String khsobjektdatakk = "";String khsobjekt2datakk = "";boolean hskein = false;boolean hsein = false;
							String hsobjektgendat = "";String hsobjekt2gendat = "";boolean hsobjektgendatf = false;
							String khsobjektgendat = "";String khsobjekt2gendat = "";
							String hsdativpr�po = "";
							String hsobjektakk = "";String hsobjekt2akk = "";boolean hsobjektakkf = false;
							String hsspr�dikat = "";String hsspr�dikat2 = "";
							String ns1pr�position = "";
							String ns1konjunktion = "";String ns1konjunktion2 = "";
							String ns1objekt = "";String ns1objekt2 = "";
							String ns1objektnom = "";String ns1objekt2nom = "";
							String ns1objektgen = "";String ns1objekt2gen = "";
							String ns1objektdat = "";String ns1objekt2dat = "";boolean ns1objektdatf = false;
							String ns1dativpr�po = "";
							String ns1objektakk = "";String ns1objekt2akk = "";
							String ns1subjekt = "";String ns1subjekt2 = "";
							String ns1pr�dikat = "";String ns1pr�dikat2 = "";
							String ns2pr�position = "";
							String ns2konjunktion = "";String ns2konjunktion2 = "";
							String ns2objekt = "";String ns2objekt2 = "";
							String ns2objektnom = "";String ns2objekt2nom = "";
							String ns2objektgen = "";String ns2objekt2gen = "";
							String ns2objektdat = "";String ns2objekt2dat = "";
							String ns2dativpr�po = "";
							String ns2objektakk = "";String ns2objekt2akk = "";
							String ns2subjekt = "";String ns2subjekt2 = "";
							String ns2pr�dikat = "";String ns2pr�dikat2 = "";
							
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
							String khsobjektgendat3 = "";String khsobjekt2gendat3 = "";
							
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
							String hspr�position2 = "";
							String ns1konjunktio = "";
							boolean hspr�po = false;
							boolean ns1konju = false;
							boolean ichpro2 = false;
							
							boolean kein = false;
							boolean ein = false;
							//int satzgliedz�hler = 0;
							
							for (int a=0; a<satzw�rter.length; a++){
							if(satzmatrix[a][1].equals("Pr�position")&&satzmatrix[a][11].equals("Hauptsatz")){hspr�po = true;hspr�position2=satzmatrix[a][0];}
							if(satzmatrix[a][0].equals("nicht")){hsnicht = true;}
							if(satzmatrix[a][0].equals("ich")&&satzmatrix[a][10].equals("Subjekt")){ichpro2 = true;}
							if(satzmatrix[a][1].equals("Konjunktion")){ns1konju = true;ns1konjunktio=satzmatrix[a][0];}
							}
							
							// Satzglieder werden aufaddiert in jeweils einem String
							for (int a=0; a<satzw�rter.length; a++){
								
								
								
								
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
									
									if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";hsein = true;}
									if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";hsein = true;}
									if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";hsein = true;}
									if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";hsein = true;}
									if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";hsein = true;}
									if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";hsein = true;}
									
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
									
									if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";hsein = true;}
									if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";hsein = true;}
									if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";hsein = true;}
									if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";hsein = true;}
									if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";hsein = true;}
									if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";hsein = true;}
									khsobjekt2 = khsobjekt+" "+satzmatrix[a][0];
									khsobjekt = khsobjekt2;
									if(satzmatrix[a][7].equals("nominativ")){
										hsobjekt2nom = hsobjektnom+" "+satzmatrix[a][0];
										hsobjektnom = hsobjekt2nom;
										hsobjektnomf = true;
										
										if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Pr�position")){}
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
										if(satzmatrix[a][1].equals("Pr�position")){hspr�position = satzmatrix[a][0];}
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
									if(satzmatrix[a][7].equals("gendat")){
										//if(satzmatrix[a][1].equals("Pr�position")){hspr�position = satzmatrix[a][0];}
										hsobjekt2gendat = hsobjektgendat+" "+satzmatrix[a][0];
										hsobjektgendat = hsobjekt2gendat;
										hsobjektgendatf = true;
										
										/**
										if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Pr�position")){}
										else{hsobjekt2ohneartikel = hsobjektohneartikel+" "+satzmatrix[a][0];
										hsobjektohneartikel = hsobjekt2ohneartikel;}
										**/
										
										if(satzmatrix[a][0].equals("ein")){satzmatrix[a][0]="kein";}
										if(satzmatrix[a][0].equals("eine")){satzmatrix[a][0]="kein";}
										if(satzmatrix[a][0].equals("einer")){satzmatrix[a][0]="kein";}
										if(satzmatrix[a][0].equals("einem")){satzmatrix[a][0]="kein";}
										if(satzmatrix[a][0].equals("einen")){satzmatrix[a][0]="kein";}
										if(satzmatrix[a][0].equals("eines")){satzmatrix[a][0]="kein";}
										
										khsobjekt2gendat3 = khsobjektgendat3+" "+satzmatrix[a][0];
										khsobjektgendat3 = khsobjekt2gendat3;
										
										if(satzmatrix[a][0].equals("kein")){satzmatrix[a][0]="ein";}
										if(satzmatrix[a][0].equals("keine")){satzmatrix[a][0]="eine";}
										if(satzmatrix[a][0].equals("keiner")){satzmatrix[a][0]="einer";}
										if(satzmatrix[a][0].equals("keinem")){satzmatrix[a][0]="einem";}
										if(satzmatrix[a][0].equals("keinen")){satzmatrix[a][0]="einen";}
										if(satzmatrix[a][0].equals("keines")){satzmatrix[a][0]="eines";}
										khsobjekt2gendat = khsobjektgendat+" "+satzmatrix[a][0];
										khsobjektgendat = khsobjekt2gendat;
									}
									if(satzmatrix[a][7].equals("dativ")){
										//if(satzmatrix[a][1].equals("Pr�position")){hsdativpr�po = satzmatrix[a][0];}
										hsobjekt2dat = hsobjektdat+" "+satzmatrix[a][0];
										hsobjektdat = hsobjekt2dat;
										hsobjektdatf = true;
										
										if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Pr�position")){}
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
										//if(satzmatrix[a][1].equals("Pr�position")){hspr�position = satzmatrix[a][0];}
										hsobjekt2datakk = hsobjektdatakk+" "+satzmatrix[a][0];
										hsobjektdatakk = hsobjekt2datakk;
										hsobjektdatakkf = true;
										
										if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Pr�position")){}
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
										//if(satzmatrix[a][1].equals("Pr�position")){hspr�position = satzmatrix[a][0];}
										hsobjekt2akk = hsobjektakk+" "+satzmatrix[a][0];
										hsobjektakk = hsobjekt2akk;
										hsobjektakkf = true;
										
										if(satzmatrix[a][1].equals("Artikel")||satzmatrix[a][1].equals("Pr�position")){}
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
								if(satzmatrix[a][10].equals("Pr�dikat")&&satzmatrix[a][11].equals("Hauptsatz")){
									hsspr�dikat2 = hsspr�dikat+" "+satzmatrix[a][0];
									hsspr�dikat = hsspr�dikat2;
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
										if(satzmatrix[a][1].equals("Pr�position")){ns1pr�position = satzmatrix[a][0];}
										ns1objekt2gen = ns1objektgen+" "+satzmatrix[a][0];
										ns1objektgen = ns1objekt2gen;
									}
									if(satzmatrix[a][7].equals("dativ")){
										if(satzmatrix[a][1].equals("Pr�position")){ns1dativpr�po = satzmatrix[a][0];}
										ns1objekt2dat = ns1objektdat+" "+satzmatrix[a][0];
										ns1objektdat = ns1objekt2dat;
										ns1objektdatf = true;
									}
									if(satzmatrix[a][7].equals("akkusativ")){
										if(satzmatrix[a][1].equals("Pr�position")){ns1pr�position = satzmatrix[a][0];}
										ns1objekt2akk = ns1objektakk+" "+satzmatrix[a][0];
										ns1objektakk = ns1objekt2akk;
									}
								}
								if(satzmatrix[a][10].equals("Subjekt")&&satzmatrix[a][11].equals("Nebensatz1")){
									ns1subjekt2 = ns1subjekt+" "+satzmatrix[a][0];
									ns1subjekt = ns1subjekt2;
								}
								if(satzmatrix[a][10].equals("Pr�dikat")&&satzmatrix[a][11].equals("Nebensatz1")){
									ns1pr�dikat2 = ns1pr�dikat+" "+satzmatrix[a][0];
									ns1pr�dikat = ns1pr�dikat2;
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
										if(satzmatrix[a][1].equals("Pr�position")){ns2pr�position = satzmatrix[a][0];}
										ns2objekt2gen = ns2objektgen+" "+satzmatrix[a][0];
										ns2objektgen = ns2objekt2gen;
									}
									if(satzmatrix[a][7].equals("dativ")){
										if(satzmatrix[a][1].equals("Pr�position")){ns2dativpr�po = satzmatrix[a][0];}
										ns2objekt2dat = ns2objektdat+" "+satzmatrix[a][0];
										ns2objektdat = ns2objekt2dat;
									}
									if(satzmatrix[a][7].equals("akkusativ")){
										if(satzmatrix[a][1].equals("Pr�position")){ns2pr�position = satzmatrix[a][0];}
										ns2objekt2akk = ns2objektakk+" "+satzmatrix[a][0];
										ns2objektakk = ns2objekt2akk;
									}
								}
								if(satzmatrix[a][10].equals("Subjekt")&&satzmatrix[a][11].equals("Nebensatz2")){
									ns2subjekt2 = ns2subjekt+" "+satzmatrix[a][0];
									ns2subjekt = ns2subjekt2;
								}
								if(satzmatrix[a][10].equals("Pr�dikat")&&satzmatrix[a][11].equals("Nebensatz2")){
									ns2pr�dikat2 = ns2pr�dikat+" "+satzmatrix[a][0];
									ns2pr�dikat = ns2pr�dikat2;
								}
							}
							

							//System.out.println(hsobjektdat);
							//System.out.println(hsobjektdatakk);
							//System.out.println(hsobjektgendat);
							boolean wahreaussage = false;
							
								boolean antwortgefunden2 = false;
								String[] dateiname = new String[999999];
						        int z3 = 1;
						        double posbinom = 0;
						        double negbinom = 0;
						        
								try {FileReader f0 = new FileReader("Namensliste.txt");
						        BufferedReader f = new BufferedReader(f0);
						        String line;
						        
						        while ((line = f.readLine()) != null) {
						        		namen[z3]=line;
						        		String[] person = namen[z3].split("\\s");
						        		
						        		dateiname[z3] = person[0]+"_"+person[1];
						        		
						        		z3++;
						        	}
								}
								catch (FileNotFoundException e2) {e2.printStackTrace();}
							    catch (IOException e1) {e1.printStackTrace();}
								
								for(int y = 1; y < z3 ;y++){
									
									// Sucht nach Antworten

									int z�hler2 = 1;String[] fragen2 = new String[999999];
									//System.out.println(dateiname[y]);
									
											
											try {FileReader f1 = new FileReader(dateiname[y]+".txt");
										        BufferedReader ff1 = new BufferedReader(f1);
										        String line;
										        
										        while ((line = ff1.readLine()) != null) {
								
										        	if(line.equals(hsspr�dikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja")){posbinom++;}
										        	if(line.equals(hsspr�dikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Nein")){negbinom++;}
										        	
										        }
										    }
										    catch (FileNotFoundException e2) {
										        e2.printStackTrace();
										    }
										    catch (IOException e1) {
										        e1.printStackTrace();
										    }
									
								}
								
								//System.out.println(posbinom);
								//System.out.println(negbinom);
								
								double t, xstrich, toben, tunten, n;
								
								n = posbinom +negbinom;
								xstrich = posbinom/n;
								
								toben = (xstrich-0.75);
								tunten = Math.sqrt(0.1875/n);
								t = toben/tunten;
								//System.out.println(t);
								
								if(t>1.28){
									wahreaussage = true;
									System.out.println("Ich denke diese Aussage k�nnte wahr sein.");
								}
								
							
							
							
							//System.out.print(hsspr�dikat+khssubjekt+khsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja");
							// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
							int boleanz�hler = 1;String[] bolfragen = new String[999999];
							try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
							if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
						        BufferedReader ff1 = new BufferedReader(f1);
						        String line;
						        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
						        		boleanz�hler++;
						        }
						    }
						    catch (FileNotFoundException e2) { e2.printStackTrace();}
						    catch (IOException e1) { e1.printStackTrace();}
						
							boolean fragegefunden2 = false;
							for(int b=1;b<boleanz�hler;b++){
								if(bolfragen[b].equals(hsspr�dikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja")){
									fragegefunden2 = true;
								}
								
								if(bolfragen[b].equals("wer"+hsspr�dikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
									fragegefunden2 = true;
								}
								if(bolfragen[b].equals("was"+hsspr�dikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||bolfragen[b].equals("was"+hsspr�dikat+khsobjekt+" :"+khssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
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
								
								if(bolfragen[b].equals(hsspr�dikat+khssubjekt+khsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja")){
									fragegefunden2 = true;
									
									if(hskein == false && ein == true){System.out.println("Diese Aussage ist falsch");}
								}
								
								if(bolfragen[b].equals(hsspr�dikat+khssubjekt+khsobjekt3+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja")){
									fragegefunden2 = true;
									
									if(hskein == true && kein == true){System.out.println("Diese Aussage ist falsch");}
								}
								
								if(hsnicht == true){
									
									if(bolfragen[b].equals(hsspr�dikat+khssubjekt+nichthsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja")){
										fragegefunden2 = true;
										System.out.println("Diese Aussage ist falsch.");
									}
									
								}
								
								if(bolfragen[b].equals(hsspr�dikat+khssubjekt+" nicht"+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja")){
									fragegefunden2 = true;
									System.out.println("Diese Aussage ist falsch.");
								}
							
							}
							
							String pr�di = hsspr�dikat;
							if(fragegefunden2==false){
								// Fragen wie Antworten werden gespeichert
								try {
									BufferedWriter in = new BufferedWriter(
									        new OutputStreamWriter(
									        	new FileOutputStream( vorname+"_"+nachname+".txt", true)));
									if(wahreaussage==true){in = new BufferedWriter(
									        new OutputStreamWriter(
									        new FileOutputStream( "Antworten.txt", true)));}
										
									try {
										in.write(hsspr�dikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja");aussageneu = true;
										in.newLine();
										// Versuch
										if(hsnicht==true){
											in.write(hsspr�dikat+hssubjekt+nichthsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Nein");aussageneu = true;
											in.newLine();
										}
										int zz = 1;
										if(ichpro2==true){
											
											
											
											try {
										        FileReader f0 = new FileReader("Wortschatz.txt");
										        BufferedReader f = new BufferedReader(f0);
										        String line;
										        
										        while ((line = f.readLine()) != null) {
										        		wort[zz]=line;
										        		
										        		String[] wortw�rter = wort[zz].split("\\s");
										        		
														if (hsspr�dikat.equals(" "+wortw�rter[0])) {
															if (wortw�rter[2].equals("erste")) {
																String[] wortw�rter2 = wort[zz+2].split("\\s");
																pr�di = " "+wortw�rter2[0];
															}
														}
													
														zz++;	
										        }
										    }
										    catch (FileNotFoundException e2) {e2.printStackTrace();}
										    catch (IOException e1) {e1.printStackTrace();}
											
											
											
											
											
											
											
											
											/**
											int z2 = 0;
											for(int a=0; a<wort.length;a++){
												String[] wortw�rter = wort[a].split("\\s");
												if (hsspr�dikat.equals(" "+wortw�rter[0])) {
													if (wortw�rter[2].equals("erste")) {
														String[] wortw�rter2 = wort[a+2].split("\\s");
														hsspr�dikat = " "+wortw�rter2[0];
													}
												}
											}
											**/
											
											in.write(" wer"+pr�di+hsobjekt+" : "+vorname+" "+nachname);
											in.newLine();
											in.write(" was"+pr�di+hsobjekt+" : "+vorname+" "+nachname);
											in.newLine();
										}
										else{
											in.write(" wer"+pr�di+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
											in.newLine();
											in.write(" was"+pr�di+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
											in.newLine();
										}
										
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
							
							//System.out.println(hsspr�dikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja");
							//System.out.println("wer"+hsspr�dikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							//System.out.println("was"+hsspr�dikat+hsobjekt+" :"+hssubjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							boolean fragegefundengenitiv = false;
							if(hsobjektgenf == true){
								//System.out.println(hspr�position+"wessen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
								
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals(hspr�position+" wessen"+hsobjektohneartikel+hsspr�dikat+hssubjekt+" :"+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										fragegefundengenitiv = true;
									}
								}
								
								if(fragegefundengenitiv==false){//System.out.println("blablabla");
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
											
										try {
											in.write(hspr�position+" wessen"+hsobjektohneartikel+hsspr�dikat+hssubjekt+" :"+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
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
							
							
							
							if(hsobjektgendatf == true){
								//System.out.println(hsdativpr�po+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals(hspr�position+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals(hspr�position+" wem"+hsspr�dikat+khssubjekt+khsobjektnom+" :"+khsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals(hspr�position+" wessen"+hsobjektohneartikel+hsspr�dikat+hssubjekt+" :"+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										fragegefunden2 = true;
									}
								}
								
								if(fragegefunden2==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
										   		new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
											
										try {
											
											if(hsein==true){
												
												in.write(hspr�position+" wem"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" wessen"+hsobjektohneartikel+hsspr�dikat+" nicht"+hssubjekt+" :"+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.close();
												in.close();
												
											}
											else{
												
												in.write(hspr�position+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" wessen"+hsobjektohneartikel+hsspr�dikat+hssubjekt+" :"+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
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
							
							
							
							
							if(hsobjektdatf == true){
								//System.out.println(hsdativpr�po+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals(hsdativpr�po+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals(hsdativpr�po+" wem"+hsspr�dikat+khssubjekt+khsobjektnom+" :"+khsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										fragegefunden2 = true;
									}
								}
								
								if(fragegefunden2==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
								        		new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
										
										try {
											in.write(hsdativpr�po+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
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
								//System.out.println(ns1dativpr�po+" wem"+ns1pr�dikat+hssubjekt+ns1objektnom+" :"+ns1objektdat);
							
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals(ns1dativpr�po+" wem"+ns1pr�dikat+hssubjekt+ns1objektnom+" :"+ns1objektdat+hsobjektgen)||
											bolfragen[b].equals(ns1dativpr�po+" wem"+ns1pr�dikat+khssubjekt+ns1objektnom+" :"+ns1objektdat+hsobjektgen)){
										fragegefunden2 = true;
									}
								}
								
								if(fragegefunden2==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
								        		new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
											
										try {
											in.write(ns1dativpr�po+" wem"+ns1pr�dikat+hssubjekt+ns1objektnom+" :"+ns1objektdat+hsobjektgen);
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
								//System.out.println(hsdativpr�po+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals(hspr�position+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals(hspr�position+" wem"+hsspr�dikat+khssubjekt+khsobjektnom+" :"+khsobjektdat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										fragegefunden2 = true;
									}
								}
								
								if(fragegefunden2==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
								        		new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
											
										try {
											
											if(hsein==true){
												
												in.write(hspr�position+" wem"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" wen"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" was"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.close();
												in.close();
												
											}
											else{
												
												in.write(hspr�position+" wem"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" was"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
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
								//System.out.println("wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
								//System.out.println("was"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals(hspr�position+" wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals(hspr�position+" wen"+hsspr�dikat+khssubjekt+khsobjektnom+" :"+khsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										
										fragegefunden2 = true;
									}
								}
								
								if(fragegefunden2==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
											
										try {
											if(hsein==true){
												
												in.write(hspr�position+" wen"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" was"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.close();
												
											}
											else{
												
												in.write(hspr�position+" wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" was"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
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
							
							
							if(hspr�po == true){
								//System.out.println("wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
								//System.out.println("was"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals("woher"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektgendat+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("woher"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wo"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wo"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wo"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wo"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wohin"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wohin"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wohin"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektakk+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("wohin"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektakk+hsobjektdatakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("warum"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("weshalb"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("warum"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("weshalb"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										
										fragegefunden2 = true;
									}
								}
								
								if(fragegefunden2==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
										        		new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
											
										try {
											
											if(hspr�position2.equals("ab")||hspr�position2.equals("aus")||hspr�position2.equals("von")){
												
												if(hsnicht==true){
													in.write("woher"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("woher"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
											}
											
											
											if(hspr�position2.equals("au�er")||hspr�position2.equals("bei")||hspr�position2.equals("gegen�ber")){
												
												if(hsnicht==true){
													in.write("wo"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("wo"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
											}
											
											if(hspr�position2.equals("abseits")||hspr�position2.equals("au�erhalb")||hspr�position2.equals("diesseits")||hspr�position2.equals("entlang")||hspr�position2.equals("inmitten")
													||hspr�position2.equals("innerhalb")||hspr�position2.equals("jenseits")||hspr�position2.equals("l�ngs")||hspr�position2.equals("oberhalb")||hspr�position2.equals("unterhalb")||hspr�position2.equals("unweit")){
												
												if(hsnicht==true){
													in.write("wo"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("wo"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
											}
											
											
											if(hspr�position2.equals("an")||hspr�position2.equals("auf")
													||hspr�position2.equals("hinter")||hspr�position2.equals("in")||hspr�position2.equals("neben")||hspr�position2.equals("�ber")||hspr�position2.equals("unter")||hspr�position2.equals("vor")||hspr�position2.equals("zwischen")){
												
												if(hsnicht==true){
													in.write("wohin"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("wo"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("wohin"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("wo"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
											}
											
											if(hspr�position2.equals("bis")||hspr�position2.equals("durch")
													||hspr�position2.equals("gegen")){
												
												if(hsnicht==true){
													in.write("wohin"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("wohin"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
											}
											
											
											if(hspr�position2.equals("nah")||hspr�position2.equals("zu")){
												
												if(hsnicht==true){
													in.write("wohin"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("wohin"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektdatakk+hsobjektgendat+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
											}
											
											if(hspr�position2.equals("aufgrund")||hspr�position2.equals("wegen")){
												
												if(hsnicht==true){
													in.write("warum"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("weshalb"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("warum"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("weshalb"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektgen+hsobjektgendat+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
											}
											
											if(hspr�position2.equals("um")){
												
												if(hsnicht==true){
													in.write("warum"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektgendat+hsobjektdatakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("weshalb"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektdat+hsobjektgendat+hsobjektdatakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("warum"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektgendat+hsobjektdatakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("weshalb"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektdat+hsobjektgendat+hsobjektdatakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
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
							
							if(ns1konju == true){
								//System.out.println("wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
								//System.out.println("was"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
							
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals(hspr�position+" wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals(hspr�position+" wen"+hsspr�dikat+khssubjekt+khsobjektnom+" :"+khsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										
										fragegefunden2 = true;
									}
								}
								
								if(fragegefunden2==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
										        		new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
										try {
											if(hsein==true){
												
												in.write(hspr�position+" wen"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" was"+hsspr�dikat+hssubjekt+" nicht"+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.close();
												
											}
											else{
												
												in.write(hspr�position+" wen"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
												in.newLine();
												in.write(hspr�position+" was"+hsspr�dikat+hssubjekt+hsobjektnom+" :"+hsobjektakk+hsobjektgen+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
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
							
							
							if(ns1konju == true){boolean fragegefunden3 = false;
								// bestehende Antworten werden verglichen um Doppelungen zu vermeiden
								try { FileReader f1 = new FileReader(vorname+"_"+nachname+".txt");
								if(wahreaussage == true){f1 = new FileReader("Antworten.txt");}
							        BufferedReader ff1 = new BufferedReader(f1);
							        String line;
							        while ((line = ff1.readLine()) != null) {bolfragen[boleanz�hler]=line;
							        		boleanz�hler++;
							        }
							    }
							    catch (FileNotFoundException e2) { e2.printStackTrace();}
							    catch (IOException e1) { e1.printStackTrace();}
							
								for(int b=1;b<boleanz�hler;b++){
									if(bolfragen[b].equals("warum"+hsspr�dikat+hssubjekt+" nicht"+hsobjekt+" :"+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)||
											bolfragen[b].equals("warum"+hsspr�dikat+hssubjekt+hsobjekt+" :"+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat)){
										
										fragegefunden3 = true;
									}
								}
								
								if(fragegefunden3==false){
									// Fragen wie Antworten werden gespeichert
									try {
										BufferedWriter in = new BufferedWriter(
										        new OutputStreamWriter(
										        		new FileOutputStream( vorname+"_"+nachname+".txt", true)));
										if(wahreaussage==true){in = new BufferedWriter(
										        new OutputStreamWriter(
										        new FileOutputStream( "Antworten.txt", true)));}
											
										try {
											
											if(ns1konjunktio.equals("weil")){
												
												if(hsnicht==true){
													in.write("warum"+hsspr�dikat+hssubjekt+" nicht"+hsobjekt+" :"+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("weshalb"+hsspr�dikat+hssubjekt+" nicht"+hsobjekt+" :"+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}
												else{
													
													in.write("warum"+hsspr�dikat+hssubjekt+hsobjekt+" :"+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.write("weshalb"+hsspr�dikat+hssubjekt+hsobjekt+" :"+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat);
													in.newLine();
													in.close();
												}	
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
							
						// Hier stochastisches Wahrheitsempfinden implementieren
						
						/**
						if(aussageneu == true){
							
							boolean antwortgefunden2 = false;
							String[] dateiname = new String[9999999];
					        int z3 = 1;
					        double posbinom = 0;
					        double negbinom = 0;
					        
							try {FileReader f0 = new FileReader("Namensliste.txt");
					        BufferedReader f = new BufferedReader(f0);
					        String line;
					        
					        while ((line = f.readLine()) != null) {
					        		namen[z3]=line;
					        		String[] person = namen[z3].split("\\s");
					        		
					        		dateiname[z3] = person[0]+"_"+person[1];
					        		
					        		z3++;
					        	}
							}
							catch (FileNotFoundException e2) {e2.printStackTrace();}
						    catch (IOException e1) {e1.printStackTrace();}
							
							for(int y = 1; y < z3 ;y++){
								
								// Sucht nach Antworten

								int z�hler2 = 1;String[] fragen2 = new String[9999999];
								//System.out.println(dateiname[y]);
								
										
										try {FileReader f1 = new FileReader(dateiname[y]+".txt");
									        BufferedReader ff1 = new BufferedReader(f1);
									        String line;
									        
									        while ((line = ff1.readLine()) != null) {
							
									        	if(line.equals(hsspr�dikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Ja")){posbinom++;}
									        	if(line.equals(hsspr�dikat+hssubjekt+hsobjekt+ns1konjunktion+ns1subjekt+ns1objekt+ns1pr�dikat+ns2konjunktion+ns2subjekt+ns2objekt+ns2pr�dikat+" : Nein")){negbinom++;}
									        	
									        }
									    }
									    catch (FileNotFoundException e2) {
									        e2.printStackTrace();
									    }
									    catch (IOException e1) {
									        e1.printStackTrace();
									    }
								
							}
							
							//System.out.println(posbinom);
							//System.out.println(negbinom);
							
							double t, xstrich, toben, tunten, n;
							
							n = posbinom +negbinom;
							xstrich = posbinom/n;
							
							toben = (xstrich-0.75);
							tunten = Math.sqrt(0.1875/n);
							t = toben/tunten;
							System.out.println(t);
							
							if(t>1.28){
								
							}
							
						}
							
						**/	
						
						
						
						}
					}
					else{// Implementiere hier W�rter-Lern Algorythmus
						
						int zahl = satzw�rter.length - wortbekannt;
						if(zahl>1){System.out.println("Ich erkenne zu viele der W�rter in diesem Satz nicht.");}
						else{
							
							System.out.println("Ich kenne das Wort "+unbekannteswort+" nicht.");
							String wortschatzprinter = "";
							boolean printervoll = false;
							//System.out.println(satzmatrix[wortunbekanntpos-1][0]);
							//char[] c = unbekannteswort.toCharArray();
							//String endung = ""+c[c.length-2]+c[c.length-1];
							//System.out.println(endung);
							
							
							if(pr�dikatbekannt == -1){
								
								System.out.println("Ist das Wort ein Verb?");
								InputStreamReader antwortreader2 = new InputStreamReader(System.in);
								BufferedReader antwortbufferedreader2 = new BufferedReader(antwortreader2);
								String antwort2 = antwortbufferedreader2.readLine();
								
								if(antwort2.equals("ja")){
									char[] c = unbekannteswort.toCharArray();
									String endung = ""+c[c.length-2]+c[c.length-1];
									String letzter = ""+c[c.length-1];
									String vorletzter = ""+c[c.length-2];
									String vorvorletzter = ""+c[c.length-3];
									String vorvorvorletzter = "";
									String vorvorvorvorletzter = "";
									if (c.length>4){vorvorvorletzter = ""+c[c.length-4];}
									if (c.length>5){vorvorvorletzter = ""+c[c.length-5];}
									//System.out.println(endung);
									String verbstamm = "";
									String verbstamm2 = "";
									int ender = 0;
									
									if(letzter.equals("e")){//System.out.println("Ist das Verb erste Person Singular?");
										for(int a =0; a<c.length-1; a++){
											verbstamm2 = verbstamm+c[a];
											verbstamm = verbstamm2;
											if(vorletzter.equals("s")||vorletzter.equals("�")||vorletzter.equals("z")){
												ender = 1;
											}
											if(vorletzter.equals("d")||vorletzter.equals("t")){
												ender = 2;
											}
											if(vorvorletzter.equals("t")&&vorletzter.equals("m")){
												ender = 2;
											}
											if(vorvorvorletzter.equals("c")&&vorvorletzter.equals("h")&&vorletzter.equals("n")){
												ender = 2;
											}
											if(vorvorvorletzter.equals("f")&&vorvorletzter.equals("f")&&vorletzter.equals("n")){
												ender = 2;
											}
										}
									}
									if(vorletzter.equals("s")&&letzter.equals("t")){//System.out.println("Ist das Verb zweite Person Singular?");
										for(int a =0; a<c.length-2; a++){
											verbstamm2 = verbstamm+c[a];
											verbstamm = verbstamm2;
										}
									}
									if(letzter.equals("t")){//System.out.println("Ist das Verb dritte Person Singular oder zweite Person Plural?");
										for(int a =0; a<c.length-1; a++){
											verbstamm2 = verbstamm+c[a];
											verbstamm = verbstamm2;
											if(vorletzter.equals("�")||vorletzter.equals("z")){
												ender = 1;
											}
										}
									}
									if(vorletzter.equals("e")&&letzter.equals("n")){//System.out.println("Ist das Verb erste oder dritte Person Plural?");
										for(int a =0; a<c.length-2; a++){
											verbstamm2 = verbstamm+c[a];
											verbstamm = verbstamm2;
											if(vorvorletzter.equals("s")||vorvorletzter.equals("�")||vorvorletzter.equals("z")){
												ender = 1;
											}
											if(vorvorletzter.equals("d")||vorvorletzter.equals("t")){
												ender = 2;
											}
											if(vorvorvorletzter.equals("t")&&vorvorletzter.equals("m")){
												ender = 2;
											}
											if(vorvorvorvorletzter.equals("c")&&vorvorvorletzter.equals("h")&&vorvorletzter.equals("n")){
												ender = 2;
											}
											if(vorvorvorvorletzter.equals("f")&&vorvorvorletzter.equals("f")&&vorvorletzter.equals("n")){
												ender = 2;
											}
										}
									}
									
									if(ender == 1){
										System.out.println("ich "+verbstamm+"e");
										System.out.println("du "+verbstamm+"t");
										System.out.println("er "+verbstamm+"t");
										System.out.println("wir "+verbstamm+"en");
										System.out.println("ihr "+verbstamm+"t");
										System.out.println("sie "+verbstamm+"en");
									}
									else if(ender == 2){
										System.out.println("ich "+verbstamm+"e");
										System.out.println("du "+verbstamm+"est");
										System.out.println("er "+verbstamm+"et");
										System.out.println("wir "+verbstamm+"en");
										System.out.println("ihr "+verbstamm+"et");
										System.out.println("sie "+verbstamm+"en");
									}
									else{
										System.out.println("ich "+verbstamm+"e");
										System.out.println("du "+verbstamm+"st");
										System.out.println("er "+verbstamm+"t");
										System.out.println("wir "+verbstamm+"en");
										System.out.println("ihr "+verbstamm+"t");
										System.out.println("sie "+verbstamm+"en");
									}
									
									System.out.println("Habe ich richtig konjugiert?");
									InputStreamReader antwortreader3 = new InputStreamReader(System.in);
									BufferedReader antwortbufferedreader3 = new BufferedReader(antwortreader3);
									String antwort3 = antwortbufferedreader3.readLine();
									
									if(antwort3.equals("ja")){System.out.println("Ich habe ein neues Wort gelernt.");	
										
										try {BufferedWriter in = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( "Wortschatz.txt", true)));
										
										try {in.newLine();
												
												if(ender == 1){
													in.write(verbstamm+"e Verb erste singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													//in.write(verbstamm+"t Verb zweite singular - indikativ pr�sens - finit nein kA kA");
													//in.newLine();
													in.write(verbstamm+"t Verb dritte singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													in.write(verbstamm+"en Verb erste plural - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													//in.write(verbstamm+"t Verb zweite plural - indikativ pr�sens - finit nein kA kA");
													//in.newLine();
													//in.write(verbstamm+"en Verb dritte plural - indikativ pr�sens - finit nein kA kA");
													//in.newLine();
												}
												else if(ender == 2){
													in.write(verbstamm+"e Verb erste singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													in.write(verbstamm+"est Verb zweite singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													in.write(verbstamm+"et Verb dritte singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													in.write(verbstamm+"en Verb erste plural - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													//in.write(verbstamm+"et Verb zweite plural - indikativ pr�sens - finit nein kA kA");
													//in.newLine();
													//in.write(verbstamm+"en Verb dritte plural - indikativ pr�sens - finit nein kA kA");
													//in.newLine();
												}
												else{
													in.write(verbstamm+"e Verb erste singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													in.write(verbstamm+"st Verb zweite singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													in.write(verbstamm+"t Verb dritte singular - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													in.write(verbstamm+"en Verb erste plural - indikativ pr�sens - finit nein kA kA");
													in.newLine();
													//in.write(verbstamm+"t Verb zweite plural - indikativ pr�sens - finit nein kA kA");
													//in.newLine();
													//in.write(verbstamm+"en Verb dritte plural - indikativ pr�sens - finit nein kA kA");
													//in.newLine();
												}
												in.close();
										} 
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
							
							else if(wortunbekanntpos==satzw�rter.length-1){
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
										if(satzmatrix[wortunbekanntpos-1][0].equals("einen")||satzmatrix[wortunbekanntpos-1][0].equals("keinen")){wortschatzprinter = unbekannteswort+" Substantiv - singular maskulim - - - - ja kA kA";printervoll = true;}
										if(satzmatrix[wortunbekanntpos-1][0].equals("eine")||satzmatrix[wortunbekanntpos-1][0].equals("einer")||
												satzmatrix[wortunbekanntpos-1][0].equals("keine")||satzmatrix[wortunbekanntpos-1][0].equals("keiner")){wortschatzprinter = unbekannteswort+" Substantiv - singular feminim - - - - ja kA kA";printervoll = true;}
										if(satzmatrix[wortunbekanntpos-1][0].equals("ein")||satzmatrix[wortunbekanntpos-1][0].equals("einem")||satzmatrix[wortunbekanntpos-1][0].equals("eines")||
												satzmatrix[wortunbekanntpos-1][0].equals("kein")||satzmatrix[wortunbekanntpos-1][0].equals("keinem")||satzmatrix[wortunbekanntpos-1][0].equals("keines")){
											
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
