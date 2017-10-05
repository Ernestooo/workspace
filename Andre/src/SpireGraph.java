/**
	PG1 - Ano: 16/17
	Ficha 2: Exercício 3!
	Realizado por: André Martins(43562), Bernardo Vale(43608), João Figueiredo(43500)
*/



import java.util.Scanner;

public class SpireGraph{
	public static void main(String[]args){
		Scanner keys = new Scanner(System.in);
		
		int[] ns = new int[10];//array inicial de 10 valores!
		int soma;//soma dos valores do array
		int n=0; //auxiliar para passar o array de strings para array de inteiros
		boolean erro=false;//flag auxiliar
		String[] temp;//array para ler, inicialmente, a sequência
		String t;//auxiliar
	
		
		//Input da sequência-----------------------------------------------------------------------------------
		do{
			//*Limpa a soma e o array, caso seja necessário introduzir uma nova sequência!*
			soma=0;
			for(int i =0 ; i<10; i++){
				ns[i]=0;
			}
			//-----------------------------------------------------------------------------
			
			System.out.println("Qual é a sequência?");
			String str = keys.nextLine();//Introduz a sequência numa variável do tipo String
			str = str.trim();
			temp = str.split(" ");//Guarda os valores num array de strings
			
			//*Passa o array de strings para um array de Inteiros*
			for(int i = 0; i<temp.length; i++){
				t = temp[i];
				n=0;
				for(int w=t.length()-1, p=1 ; w>=0 ; w--, p*=10){
					n+=(t.charAt(w)-'0')*p;
				}
				ns[i]=n;
			}
			//-------------------------------------------------------
			
			//*Verifica se os valores introduzidos são válidos!*
			for(int i = 0; i<10 ; i++){
				if(ns[0]<0){
					erro=true;
					break;
				}
				if(ns[i]>=0 && ns[i]<=15){
					soma+=ns[i];
					erro=false;
				}
				else if(ns[i]>15){
					erro=true;
					break;
				}
				else if(soma>30){
					erro=true;
					break;
				}
				else{
					ns[i]=0;
					erro=false;
					break;
				}
			}
			//---------------------------------------------------
			
		}while(erro);//Caso haja algum valor inválido ele pede para introduzir nova sequência!
		//*----------------------------------------------------------------------------------------------------
		
		
		
		//-------------------- *Test: Print Array ns*-----------------
		System.out.print("[");
		for(int i = 0; i<10 ; i++){
			if(i<9){
				System.out.print(ns[i] + ", ");
			}
			else{
				System.out.print(ns[i] + "]");
			}
		}
		//*-----------------------------------------------------------
		
		
		//*Cálculo da altura máx*---------------------------------
		System.out.println();
		int hMAX = ns[0]; //altura max
		int posM=0;
		for(int i=1; i<10 ; i++){
			if(hMAX < ns[i] && i<10){
				hMAX = ns[i];
				posM=i;
			}
		}
		/*System.out.println(hMAX + " " + posM);//só para testar*/
		//*-------------------------------------------------------
		
		//*Cácula o nº de triangulos pedidos!*
		int nTriangs = 0;
		for(int i = 0; i<10 ; i++){
			if(ns[i]!=0){
				nTriangs++;
			}
			else{
				if(ns[i+1]!=0 || ns[i+2]!=0){
					nTriangs++;
				}
				else{
					break;
				}
				
			}
		}
		//*-----------------------------------
		
		int aux; //variável auxiliar usada em (1)
		for(int i=hMAX+1 ; i>0 ; i--){//*Print das linhas*---------------------------------------------------------------
			System.out.println();
			for(int w = 0 ; w<10 ; w++){
				if(ns[w]==0 && ns[w+1]==0 && ns[w+2]==0){
					break;
				}
				if(ns[w]+1>=i){
					if(ns[w]+1==i){
						for(int outEspacos=ns[w]+1 ; outEspacos>0; outEspacos--){
							System.out.print(" ");
						}
						System.out.print("_");
						for(int outEspacos=ns[w]+1 ; outEspacos>0; outEspacos--){
							System.out.print(" ");
						}
					}
					else if(ns[w]==i){
						for(int outEspacos= ns[w] ; outEspacos>0 ; outEspacos--){
							System.out.print(" ");
						}
						System.out.print("/|\\");
						for(int outEspacos= ns[w] ; outEspacos>0 ; outEspacos--){
							System.out.print(" ");
						}
					}
					else{
						aux = ns[w]-i;//(1)aux = Número de espaços no interior do triângulo
						
						for(int a = aux; a<ns[w];a++){//Dá os espaços antes da primeira parede do triângulo
							System.out.print(" ");
						}
						
						System.out.print("/");//Primeira parede do triângulo
						
						for(int a = aux; a>0 ; a--){//Dá os espaços dentro da primeira parte do triângulo
							System.out.print(" ");
						}
						
						System.out.print("|");//Meio do triângulo
						
						for(int a = aux; a>0 ; a--){//Dá os espaços dentro da segunda parte do triângulo
							System.out.print(" ");
						}
						
						System.out.print("\\");//Segunda parede do triângulo
						
						for(int a = aux; a<ns[w];a++){//Dá os espaços a seguir à segunda parede do triângulo
							System.out.print(" ");
						}
					}
				}
				//Dá os espaços em branco caso a linha ainda não seja onde o triângulo começa*
				else{
					for(int espacosGrandes=(ns[w]*2+3) ; espacosGrandes>0; espacosGrandes--){
						System.out.print(" ");
					}
				}
				//-----------------------------------------------------------------------------
			}
		}
		//*-----------------------------------------------------------------------------------------------------------------
		
		System.out.println();
		
		//*Apresenta a base dos triângulos*------
		for(int i = 0; i<nTriangs ; i++){
			System.out.print("<");
			for(int w=0; w<(2*ns[i]+1) ; w++){
				System.out.print("=");
			}
			System.out.print(">");
		}
		//*--------------------------------------
		
		//*Apresenta a última linha, onde apresenta os traços para definir onde começa/acaba cada triângulo*
		System.out.println();
		for(int i = 0; i<nTriangs ; i++){
			System.out.print(" ");
			for(int w=0; w<(2*ns[i]+1) ; w++){
				if(w==0 || w==(2*ns[i])){
					System.out.print("|");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.print(" ");
		}
		System.out.println();
		//*-------------------------------------------------------------------------------------------------
	}
}