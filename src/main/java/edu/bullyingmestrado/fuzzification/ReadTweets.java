/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.fuzzification;

/**
 *
 * @author pamela
 */
public class ReadTweets {
        /**
	 * Inicio do Severity Tool
	 * */
	public static void main(String [] args){
			String modeloAUsar = null;
			String line = null;
			String rptaIsBullyingTrace = null;
			String filePath = "C:/Users/pamela/Desktop/archivoOut.txt";		
			String linea1 = "sep=|" + System.getProperty("line.separator");
			boolean primeraLinea = true;
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
									Classification.class.getResourceAsStream("/model/test.txt")));

				while ((line = br.readLine()) != null) {					
					if (!checkInput(line) )continue;					
					/*Paso 1: Ejecutar Bullying Trace Clasificador*/
					modeloAUsar = "trace";
					ArrayList<String> tokens = null;
					Tokenizer tokenizer = new Tokenizer();
						
					Tokens2FeatureVector t2v = new Tokens2FeatureVector();
					t2v.loadVocab("/model/vocab");

					Classification BullyingTrace = new Classification();
					try {
						BullyingTrace.loadModel("/model/"+ modeloAUsar.toLowerCase());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					tokens = tokenizer.tokenize(line);
					t2v.covertFeatureVector(tokens);
					rptaIsBullyingTrace= BullyingTrace.classify(t2v.getIndexSet(), t2v.getValueSet());
					//System.out.println("Respuesta Clasificador Bullying Trace :"  + rptaIsBullyingTrace);
				
					if (primeraLinea ){
						escribirResultadoClasificacion(linea1, filePath);
						primeraLinea=false;
					}
					
					/*Paso 2: Ejecutar los demás clasificadores si se trata de Bullying Trace*/
					if (rptaIsBullyingTrace.equals("yes")){
						String nuevalinea="";
						String content="";
						String rotulos = "";
						HashMap<String, Double> rotulosConValores  = new HashMap<String, Double>();;     
						double resultadoFuzzy=0.0;
						
						for (String cadena : clasificadoresAUsarParaFuzzy){
							
							//System.out.println("El clasificador es:" + cadena);
							String rptaClasificador = "";
							tokens = null;
							tokenizer = new Tokenizer();
							double valorRotulo =0;
							
							t2v = new Tokens2FeatureVector();
							t2v.loadVocab("/model/vocab");

							Classification clasificador = new Classification();
							try {
								clasificador.loadModel("/model/"+ cadena.toLowerCase());
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							tokens = tokenizer.tokenize(line);
							t2v.covertFeatureVector(tokens);
							rptaClasificador= clasificador.classify(t2v.getIndexSet(), t2v.getValueSet());
							rotulos = rotulos + "|" + rptaClasificador;
							valorRotulo = clasificador.getValue();
							
							if (rptaClasificador.equals("yes") || rptaClasificador.equals("no")) rptaClasificador="teasing";
							
							rotulosConValores.put(rptaClasificador, valorRotulo);
							//System.out.println("Respuesta Clasificador " + cadena + " : "+ rptaClasificador);
						}
						/*Paso 3: Imprimir resultados*/
						/*Imprimir resultados por línea*/
						
						nuevalinea = System.getProperty("line.separator");
					    line= completarTweet(line);
					    /*1julio*/
					   // content = line  + rotulos +nuevalinea;
					    		
					    //escribirResultadoClasificacion(content, filePath);
					  
					    
						resultadoFuzzy =iterarRotulosConValores(rotulosConValores);
						System.out.println("entro..." + resultadoFuzzy);
						if (resultadoFuzzy != -9999999)
						{	//Si se va a fuzzificar
							content = line  + rotulos + "|" + resultadoFuzzy + nuevalinea;
							System.out.println("entro...");
							escribirResultadoClasificacion(content, filePath);
						}
					}
				
				
				
				
				
				}
				
				System.out.println("***FIN****");
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		
			
			
		}/*fin main*/

}
